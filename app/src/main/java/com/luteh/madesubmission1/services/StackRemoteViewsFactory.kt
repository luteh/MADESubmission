package com.luteh.madesubmission1.services

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.ui.widget.FavoriteMovieWidget
import java.util.*

class StackRemoteViewsFactory(private val mContext: Context) :
    RemoteViewsService.RemoteViewsFactory {

    private val mWidgetItems = ArrayList<Bitmap>()

    override fun onCreate() {
    }

    override fun getLoadingView(): RemoteViews? = null

    override fun getItemId(p0: Int): Long = 0

    override fun onDataSetChanged() {

        mWidgetItems.add(
            BitmapFactory.decodeResource(
                mContext.resources,
                R.drawable.poster_aquaman
            )
        )
        mWidgetItems.add(
            BitmapFactory.decodeResource(
                mContext.resources,
                R.drawable.poster_aquaman
            )
        )

    }

    override fun hasStableIds(): Boolean = false

    override fun getViewAt(position: Int): RemoteViews {

        val rv = RemoteViews(mContext.packageName, R.layout.favorite_movie_widget_item)
        rv.setImageViewBitmap(R.id.iv_widget_item, mWidgetItems[position])
        /*Glide.with(mContext!!)
            .load(mWidgetItems[position])
            .into(object : SimpleTarget<Drawable>() {
                override fun onResourceReady(
                    resource: Drawable,
                    transition: Transition<in Drawable>?
                ) {
                    rv.setImageViewBitmap(R.id.iv_widget_item, resource)
                }

            })*/

        val extras = Bundle()
        extras.putInt(FavoriteMovieWidget.EXTRA_ITEM, position)
        val fillInIntent = Intent()
        fillInIntent.putExtras(extras)

        rv.setOnClickFillInIntent(R.id.iv_widget_item, fillInIntent)
        return rv
    }

    override fun getCount(): Int = mWidgetItems.size

    override fun getViewTypeCount(): Int = 1

    override fun onDestroy() {
    }

}
