package com.app.commonlibrary.utils.commons

import android.util.Log
import com.app.commonlibrary.BuildConfig

object Logs {
    fun e(msg: String) {
        if (BuildConfig.DEBUG) {
            Log.e("Error", "Msg: $msg")
        }
    }

    fun d(msg: String) {
        if (BuildConfig.DEBUG) {
            Log.d("Debug", "Msg: $msg")
        }
    }

    fun v(msg: String) {
        if (BuildConfig.DEBUG) {
            Log.v("Verbose","Msg: $msg")
        }
    }

    fun i(msg: String) {
        if (BuildConfig.DEBUG) {
            Log.i("Info","Msg: $msg")
        }
    }

    fun w(msg: String) {
        if (BuildConfig.DEBUG) {
            Log.w("Warn","Msg: $msg")
        }
    }

    fun log(msg: String) {
        if (BuildConfig.DEBUG) {
            Log.e("Msg","$msg")
        }
    }
}