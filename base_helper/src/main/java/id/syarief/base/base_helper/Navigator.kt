package id.syarief.base.base_helper

import android.content.Context
import android.content.Intent

object Navigator {

    fun navigate(context: Context, pageName: String, callback: (() -> Unit)? = null) {
        val intent = Intent()
        intent.setClassName(context.packageName, pageName)
        context.startActivity(intent)
        callback?.invoke()
    }

    fun navigateIntent(pageName: String) {

    }
}