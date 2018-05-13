package com.frodinm.rnandroidjob;

public enum TaskDescription {
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
