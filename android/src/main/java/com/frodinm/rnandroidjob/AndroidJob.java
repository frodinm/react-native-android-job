package com.frodinm.rnandroidjob;

import android.support.annotation.NonNull;
import android.util.Log;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobManager;
import com.evernote.android.job.JobRequest;
import com.facebook.react.bridge.ReactApplicationContext;

import javafx.application.Application;

public class AndroidJob extends Job {

    public static final String TAG = "rnAndroidJob";

    @Override
    @NonNull
    protected Result onRunJob(Params params) {
        // run your job
        return Result.SUCCESS;
    }

    public static void initializeJobManager(ReactApplicationContext context){
        Log.d(TAG , context.toString()+ " has initialized");
        JobManager.create(context).addJobCreator(new AndroidJobCreator());
    }


    private void scheduleJob() {
        new JobRequest.Builder(AndroidJob.TAG)
                .setExecutionWindow(30_000L, 40_000L)
                .build()
                .schedule();
    }
}