package com.frodinm.RNAndroidJob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobManager;
import com.evernote.android.job.JobRequest;
import com.facebook.react.bridge.LifecycleEventListener;

public abstract class RNAndroidJob extends Job implements LifecycleEventListener {

    public static final String TAG = "RNAndroidJob";
    public static boolean isForeground = false;

    public static UpJob getUpJob(){
        return new UpJob();
    }

    public static DownJob getDownJob(){
        return new DownJob();
    }


    public static void initializeJobManager(Context context) {
        Log.d(TAG, context.toString() + " has initialized");
        JobManager.create(context).addJobCreator(new RNAndroidJobCreator());
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