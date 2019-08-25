package com.luteh.favoritemovieapp.ui

import android.os.Bundle
import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.luteh.favoritemovieapp.R
import com.luteh.favoritemovieapp.common.AppConstant.URI_MOVIE
import com.luteh.favoritemovieapp.data.MovieData
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.no_data_item.*

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private val compositeDisposable = CompositeDisposable()

    private val mainAdapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onInit()
    }

    private fun onInit() {
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        rv_main.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 2)
            adapter = mainAdapter
        }
    }

    override fun onResume() {
        super.onResume()

        compositeDisposable.add(
            Single.fromCallable { getMovieData() }
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ movieDatas ->

                    layout_no_data_item_container.visibility =
                        if (movieDatas.isNullOrEmpty()) VISIBLE else INVISIBLE

                    mainAdapter.setDataSources(movieDatas)
                }, { throwable ->
                    Log.e(TAG, "onResume: $throwable")
                })
        )

    }

    private fun getMovieData(): List<MovieData> {
        val cursor = contentResolver.query(URI_MOVIE, null, null, null, null)
        val movieDatas: MutableList<MovieData> = mutableListOf()

        if (cursor != null) {
            while (cursor.moveToNext()) {
                movieDatas.add(MovieData.fromCursor(cursor))
            }

            cursor.close()
        }

        return movieDatas
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}
