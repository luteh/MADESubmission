package com.luteh.qasirtest.internal

import android.content.Context
import android.util.DisplayMetrics
import com.bumptech.glide.annotation.GlideExtension
import com.bumptech.glide.annotation.GlideOption
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.BaseRequestOptions
import kotlin.math.roundToInt

/**
 * Created by Luthfan Maftuh on 8/23/2019.
 * Email luthfanmaftuh@gmail.com
 */

@GlideExtension
class MyGlideExtension private constructor() {

    companion object {
        @JvmStatic
        @GlideOption
        fun roundedCorners(
            options: BaseRequestOptions<*>, context: Context,
            cornerRadius: Int
        ): BaseRequestOptions<*> {
            val px =
                (cornerRadius * (context.resources.displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)).roundToInt()
            return options.transforms(RoundedCorners(px))
        }


    }
}