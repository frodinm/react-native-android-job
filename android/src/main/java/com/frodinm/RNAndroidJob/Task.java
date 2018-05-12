package com.frodinm.RNAndroidJob;

public enum Task {
    up("up"), down("down"), left("left"), right("right");

    final String taskId;

    Task(final String taskId){
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return taskId;
    }
}
