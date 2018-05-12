import { NativeModules } from 'react-native';

let RNAndroidJob = NativeModules.RNAndroidJob

module.exports = {

    registerNewTask: function (taskId) {
        if (typeof taskId === '') {
            RNAndroidJob.registerNewTask(taskId)
        } else {
            console.log('TaskId needs to be a string')
        }
    }


}