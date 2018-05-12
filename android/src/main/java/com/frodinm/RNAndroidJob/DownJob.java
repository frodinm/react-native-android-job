package com.frodinm.RNAndroidJob;

import android.support.annotation.NonNull;

import com.evernote.android.job.Job;

public class DownJob extends RNAndroidJob {

    public static final String TAG = "RNAndroidJobDownJob";

    @NonNull
    @Override
    protected Result onRunJob(@NonNull Params params) {
        return null;
    }
}
