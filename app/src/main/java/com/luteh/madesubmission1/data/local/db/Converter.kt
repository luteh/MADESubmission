package com.luteh.madesubmission1.data.local.db

import androidx.room.TypeConverter

/**
 * Created by Luthfan Maftuh on 7/11/2019.
 * Email luthfanmaftuh@gmail.com
 */
class Converter {
    @TypeConverter
    fun toList(strings: String): List<String> {
        val list = mutableListOf<String>()
        val array = strings.split(",")
        for (s in array) {
            list.add(s)
        }
        return list
    }

    @TypeConverter
    fun toString(strings: List<String>): String {
        var result = ""
        strings.forEachIndexed { index, element ->
            result += element
            if (index != (strings.size - 1)) {
                result += ","
            }
        }
        return result
    }
}