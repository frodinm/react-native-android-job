package com.frodinm.rnandroidjob;

import android.support.annotation.NonNull;
import android.util.Log;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;



public class RNAndroidJobCreator implements JobCreator {
    public static HashMap<Task, Task> jobMap = new HashMap<>();

    public static void addTask(Task taskId) {

        if(taskId != null){
            switch (taskId.getTaskDesc()){
                case up:
                    jobMap.put(taskId, new Task(){
                        @Override
                        public Job taskToReturn() {
                            return new UpJob();
                        }
                    } );
                    Log.d(RNAndroidJob.TAG, "Job with taskID " + taskId + " has been registered");
                    break;
                case down:
                    jobMap.put(taskId, new Task(){
                        @Override
                        public Job taskToReturn() {
                            return new DownJob();
                        }
                    } );
                    Log.d(RNAndroidJob.TAG, "Job with taskID " + taskId + " has been registered");
                    break;
                case left:
                    break;
                case right:
                    break;
            }
        }else{
            Log.d(RNAndroidJob.TAG, "TaskId did not match any of the defined jobs");
        }
    }

    @Override
    public Job create(@NonNull String taskId) {

        Job task =  jobMap.get(taskId).taskToReturn();

        return task;
    }
}