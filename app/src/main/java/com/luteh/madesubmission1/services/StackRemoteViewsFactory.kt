package com.luteh.madesubmission1.services

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import com.bumptech.glide.Glide
import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.common.constant.AppConstant
import com.luteh.madesubmission1.data.local.db.MyDatabase
import com.luteh.madesubmission1.widget.FavoriteMovieWidget
import java.util.*

class StackRemoteViewsFactory(
    private val mContext: Context
) : RemoteViewsService.RemoteViewsFactory {

    private lateinit var myDatabase: MyDatabase

    private val mWidgetItems = ArrayList<Bitmap>()

    override fun onCreate() {
        if (!::myDatabase.isInitialized) {
            myDatabase = MyDatabase(mContext)
        }
    }

    override fun getLoadingView(): RemoteViews? = null

    override fun getItemId(p0: Int): Long = 0

    override fun onDataSetChanged() {

        val datas = myDatabase.movieDao().loadAllMoviesSync()
        datas.forEach {
            val imageBitmap = Glide.with(mContext)
                .asBitmap()
                .load(AppConstant.BASE_URL_IMAGE + it.posterPath)
                .submit()
                .get()

            mWidgetItems.add(imageBitmap)
        }
    }

    override fun hasStableIds(): Boolean = false

    override fun getViewAt(position: Int): RemoteViews {

        val rv = RemoteViews(mContext.packageName, R.layout.favorite_movie_widget_item)
        rv.setImageViewBitmap(R.id.iv_widget_item, mWidgetItems[position])

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
