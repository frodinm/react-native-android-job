package com.frodinm.RNAndroidJob;

import android.support.annotation.NonNull;
import android.util.Log;

import com.evernote.android.job.Job;

public class UpJob extends RNAndroidJob{

    public static final String TAG = "RNAndroidJobUpJob";


    @NonNull
    @Override
    protected Result onRunJob(@NonNull Params params) {
        Log.d(TAG, "Job ran with params" + params.toString());
        return Result.SUCCESS;
    }
}
