package com.example.recipes.helper

import android.os.Build
import android.text.Html
import android.text.Spanned

object HtmlParser {
    fun parseHtml(html: String): Spanned {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(html, Html.FROM_HTML_MODE_COMPACT)
        } else {
            Html.fromHtml(html)
        }
    }
}