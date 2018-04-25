package com.frodinm.rnandroidjob;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;

public class AndroidJobCreator implements JobCreator {

    @Override
    public Job create(String tag) {
        switch (tag) {
            case AndroidJob.TAG:
                return new AndroidJob();
            default:
                return null;
        }
    }
}