package com.frodinm.rnandroidjob;

import android.support.annotation.NonNull;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;

public class AndroidJob extends Job {

    public static final String TAG = "job_demo_tag";

    @Override
    @NonNull
    protected Result onRunJob(Params params) {
        // run your job
        return Result.SUCCESS;
    }


    private void scheduleJob() {
        new JobRequest.Builder(AndroidJob.TAG)
                .setExecutionWindow(30_000L, 40_000L)
                .build()
                .schedule();
    }
}