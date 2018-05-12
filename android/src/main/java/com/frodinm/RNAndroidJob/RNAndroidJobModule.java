package com.frodinm.rnandroidjob;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.util.Log;

import com.evernote.android.job.JobManager;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.util.support.PersistableBundleCompat;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

class RNAndroidJobModule extends ReactContextBaseJavaModule implements LifecycleEventListener {

    private boolean isForeground = false;

    public RNAndroidJobModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "RNAndroidJob";
    }

    @ReactMethod
    public void registerNewTask(String taskId) {
        Log.d(RNAndroidJob.TAG,"TaskId received :"+ taskId);
        Task taskToAdd = null;
        switch (taskId){
            case "up":
                taskToAdd = Task.up;
                break;
            case "down":
                taskToAdd = Task.down;
                break;
            default:
                Log.d(RNAndroidJob.TAG,"None of the tags matched");

        }

        RNAndroidJobCreator.addTask(taskToAdd);
    }

    @ReactMethod
    public void scheduleExactJob() {
        int jobId = new JobRequest.Builder(RNAndroidJob.TAG).setExact(20_000L).build().schedule();
    }

    @Override
    public void initialize() {
        Log.d(RNAndroidJob.TAG, "Initializing RNAndroidJob");
        super.initialize();

        Set<JobRequest> jobRequests = JobManager.instance().getAllJobRequests();
        if (jobRequests.size() > 1) {
            Log.w(RNAndroidJob.TAG, "Found " + jobRequests.size() + " scheduled jobs");
        }

        // Hook into lifecycle events so we can tell when the application is foregrounded
        ReactApplicationContext context = getReactApplicationContext();
        context.addLifecycleEventListener(this);
    }

    @ReactMethod
    public void schedulePeriodicJob() {
        new JobRequest.Builder(RNAndroidJob.TAG).setExecutionWindow(30_000L, 40_000L).build().schedule();
    }

    @ReactMethod
    public void scheduleAdvancedJob() {
        PersistableBundleCompat extras = new PersistableBundleCompat();
        extras.putString("key", "Hello world");

        int jobId = new JobRequest.Builder(RNAndroidJob.TAG).setExecutionWindow(30_000L, 40_000L)
                .setBackoffCriteria(5_000L, JobRequest.BackoffPolicy.EXPONENTIAL).setRequiresCharging(true)
                .setRequiresDeviceIdle(false).setRequiredNetworkType(JobRequest.NetworkType.CONNECTED).setExtras(extras)
                .setRequirementsEnforced(true).setUpdateCurrent(true).build().schedule();
    }

    @ReactMethod
    public void runJobImmediately() {
        int jobId = new JobRequest.Builder(RNAndroidJob.TAG).startNow().build().schedule();
    }

    @ReactMethod
    public void cancelJob(int jobId) {
        JobManager.instance().cancel(jobId);
    }

    @Override
    public void onHostResume() {
        setForeground(true);
        JobManager.instance().cancelAll();
    }

    @Override
    public void onHostPause() {
        setForeground(false);
    }

    @Override
    public void onHostDestroy() {

    }

    private void setForeground(boolean status){
        Log.d(RNAndroidJob.TAG, "Setting foreground "+ status);
        this.isForeground = status;
    }
}
