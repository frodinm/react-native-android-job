package com.frodinm.rnandroidjob;

import android.support.annotation.NonNull;
import android.util.Log;

import com.evernote.android.job.Job;

public class DownJob extends RNAndroidJob {

    public static final String TAG = "RNAndroidJobDownJob";

    @NonNull
    @Override
    protected Result onRunJob(@NonNull Params params) {
        Log.d(TAG, "Job " +this.toString()+" ran");
        return Result.SUCCESS;
    }
}
