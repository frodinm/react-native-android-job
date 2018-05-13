package com.frodinm.rnandroidjob;

import com.evernote.android.job.Job;


public abstract class Task {
    private TaskDescription taskDesc;

    public abstract Job taskToReturn();


    public TaskDescription getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(TaskDescription taskDesc) {
        this.taskDesc = taskDesc;
    }
}
