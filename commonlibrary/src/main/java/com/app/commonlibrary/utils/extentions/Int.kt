package com.app.commonlibrary.utils.extentions

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import java.text.NumberFormat
import java.util.*

fun Int.pxToDp(): Int {
    val metrics = Resources.getSystem().displayMetrics
    val dp = this / (metrics.densityDpi / 160f)
    return Math.round(dp)
}

fun Int.dpToPx(): Int {
    val metrics = Resources.getSystem().displayMetrics
    val px = this * (metrics.densityDpi / 160f)
    return Math.round(px)
}

fun Int.numberFormat(): String {
    val format = NumberFormat.getNumberInstance(Locale("id", "ID"))

    return format.format(this)
}

fun Number.spToPx(context: Context) = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_SP, this.toFloat(), context.resources.displayMetrics).toFloat()