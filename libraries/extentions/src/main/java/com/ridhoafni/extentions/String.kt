package com.app.commonlibrary.utils.extentions

import java.text.SimpleDateFormat
import java.util.*

fun String.toDate(): Date {
    return SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(this)
}

fun Date.toFormat(): String {
    return SimpleDateFormat("d MMM yyyy", Locale.getDefault()).format(this)
}

fun Date.toInputFormat(): String {
    return SimpleDateFormat("d/M/yyyy", Locale.getDefault()).format(this)
}

fun Date.toTime(): String {
    return SimpleDateFormat("HH:mm", Locale.getDefault()).format(this)
}