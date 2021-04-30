package com.ridhoafni.commons

import android.content.Context
import com.ridhoafni.commons.others.GeneralCallBack

open class Dialogs {
    open fun showDialogCase(
        mContext: Context?,
        title: String?,
        description: String?,
        callBack: GeneralCallBack
    ) {
        val alertDialogBuilder: android.app.AlertDialog.Builder =
            android.app.AlertDialog.Builder(mContext)
        alertDialogBuilder.setTitle(title)
        alertDialogBuilder
            .setMessage(description)
            .setCancelable(false)
            .setNegativeButton(
                mContext?.resources?.getString(R.string.ok)
            ) { dialog, _ ->
                callBack.onError(dialog)
            }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}