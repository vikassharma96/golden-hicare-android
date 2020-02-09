package com.teckudos.goldenhicare.utils

import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceUtil {
    private const val NAME = "shared_preference"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    private val IS_REGISTERED = Pair("is_registered", true) // todo to false

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var isRegistered: Boolean
        get() = preferences.getBoolean(IS_REGISTERED.first, IS_REGISTERED.second)
        set(value) = preferences.edit {
            it.putBoolean(IS_REGISTERED.first, value)
        }
}