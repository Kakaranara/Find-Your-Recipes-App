package com.example.recipes.helper

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showToast(message: String?, isLongToast: Boolean = false) {
    when (isLongToast) {
        true -> Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
        false -> Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }
}