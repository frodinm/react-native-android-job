package com.frodinm.rnandroidjob;

import android.support.annotation.NonNull;
import android.util.Log;

import com.evernote.android.job.Job;

public class UpJob extends RNAndroidJob{

    public static final String TAG = "RNAndroidJobUpJob";

    public UpJob(){
        return;
    }

    @NonNull
    @Override
    protected Result onRunJob(@NonNull Params params) {
        Log.d(TAG, "Job " +this.toString()+" is running");

        return Result.SUCCESS;
    }
}
