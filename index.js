import { NativeModules } from 'react-native';

let RNAndroidJob = NativeModules.RNAndroidJob

module.exports = {

    registerNewTask: function (taskId) {
        console.log(taskId)
        if (taskId.constructor === String) {
            RNAndroidJob.registerNewTask(taskId)
        } else {
            console.log('TaskId needs to be a string')
        }
    },
    schedulePeriodicJob: function () {
        RNAndroidJob.schedulePeriodicJob()
    }


}