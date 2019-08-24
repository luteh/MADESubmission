package com.luteh.favoritemovieapp

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    /** The authority of this content provider.  */
    val AUTHORITY = "com.luteh.madesubmission1"

    val TABLE = "movie_db"

    /** The URI for the Menu table.  */
    val URI_MOVIE = Uri.parse(
        "content://$AUTHORITY/$TABLE"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        val cursor = contentResolver.query(URI_MOVIE, null, null, null, null)

        if (cursor != null) {
            while (cursor.moveToNext()) {
                val id = cursor.getString(cursor.getColumnIndex("id"))
                val title = cursor.getString(cursor.getColumnIndex("title"))

                Log.d(TAG, "onCreate: $id $title")
            }

            cursor.close()
        }
    }
}
