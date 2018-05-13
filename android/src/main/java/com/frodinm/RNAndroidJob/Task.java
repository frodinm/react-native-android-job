package com.frodinm.rnandroidjob;

import com.evernote.android.job.Job;

enum TaskDescription {
    up("up"), down("down"), left("left"), right("right");

    final String taskId;

    TaskDescription(final String taskId){
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return taskId;
    }
}

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
