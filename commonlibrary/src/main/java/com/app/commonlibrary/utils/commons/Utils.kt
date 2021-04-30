package com.app.commonlibrary.utils.commons

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.app.commonlibrary.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import java.text.SimpleDateFormat
import java.util.*

class Utils {

    fun getCurrentDate(dtFormat: String): String {

        val dateFormat = SimpleDateFormat(dtFormat, Locale.getDefault())
        val today = Calendar.getInstance().time

        return dateFormat.format(today)
    }

    fun convertPassword(email: String, pass: String): String {
        val preHash = UtilsSha256.getSha256(pass)

        return UtilsSha256.getSha256(email + preHash)
    }

    fun hasPermission(permissions: String, context: Context): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ContextCompat.checkSelfPermission(context, permissions) == PackageManager.PERMISSION_GRANTED
        } else true
    }

    fun getDeviceModel(): String {
        val model = Build.MODEL
        val manufacture = Build.MANUFACTURER
        val device = Build.VERSION.RELEASE
        val os = Build.VERSION.SDK_INT
        return "${manufacture.toUpperCase(Locale.getDefault())} $model - $os ($device)"
    }

    fun accessTime(): String {
        val tsLong = System.currentTimeMillis() / 1000
        return tsLong.toString()
    }

    fun imageRound(imageView: ImageView, url: String?, context: Context, scaleType: ImageView.ScaleType? = null) {
        url?.let {
            val radius = context.resources.getDimensionPixelSize(R.dimen.radius)
            var requestOptions = RequestOptions()

            requestOptions = requestOptions.transform(CenterCrop(), RoundedCorners(radius))
            requestOptions = requestOptions.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)

            if(scaleType == ImageView.ScaleType.CENTER_INSIDE) {
                requestOptions = requestOptions.centerInside()
            }

            Glide.with(context)
                .load(it)
                .apply(requestOptions)
                .into(imageView)
        }
    }

    fun imageCircle(imageView: ImageView, url: String?, context: Context, scaleType: ImageView.ScaleType? = null) {
        url?.let {
            val radius = context.resources.getDimensionPixelSize(R.dimen.radius_circle)
            var requestOptions = RequestOptions()

            requestOptions = requestOptions.transform(CenterCrop(), RoundedCorners(radius))
            requestOptions = requestOptions.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)

            if(scaleType == ImageView.ScaleType.CENTER_INSIDE) {
                requestOptions = requestOptions.centerInside()
            }

            Glide.with(context)
                .load(it)
                .apply(requestOptions)
                .into(imageView)
        }
    }

    fun dayTimeGreeting(context: Context) : String {
        val cal = Calendar.getInstance()

        cal.time = Date()

        return when (cal.get(Calendar.HOUR_OF_DAY)) {
            in 12..16 -> context.getString(R.string.text_good_afternoon)
            in 17..20 -> context.getString(R.string.text_good_evening)
            in 21..23 -> context.getString(R.string.text_good_night)
            else -> context.getString(R.string.text_good_morning)
        }

    }

}