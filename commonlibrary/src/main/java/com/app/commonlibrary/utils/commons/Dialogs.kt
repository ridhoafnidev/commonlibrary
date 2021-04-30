package com.app.commonlibrary.utils.commons

import android.content.Context
import com.app.commonlibrary.R

class Dialogs {
    fun showDialogCase(
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