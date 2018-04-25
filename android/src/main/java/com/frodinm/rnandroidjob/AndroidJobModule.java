package com.frodinm.rnandroidjob;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.util.Log;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

class AndroidJobModule extends ReactContextBaseJavaModule {


    public AndroidJobModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override public String getName() {
        return "AndroidJob";
    }

}
