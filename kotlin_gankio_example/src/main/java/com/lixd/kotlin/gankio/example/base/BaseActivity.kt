package com.lixd.kotlin.gankio.example.base

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lixd.kotlin.gankio.example.App
import com.lixd.kotlin.gankio.example.AppComponent
import org.jetbrains.anko.progressDialog

abstract class BaseActivity : AppCompatActivity() {

    protected var dialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpComponent(App.getInstance().getAppComponent())
        setContentView(getLayoutId())
        init(savedInstanceState)
    }

    abstract fun getLayoutId(): Int
    abstract fun init(savedInstanceState: Bundle?)

    open fun stopLoading() {
        if (dialog != null && dialog?.isShowing == true) {
            dialog?.dismiss()
        }
    }

    open fun showLoading() {
        if (dialog === null) {
            dialog = progressDialog("请稍后.....")
        }
        dialog?.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        stopLoading()
    }

    abstract fun setUpComponent(appComponent: AppComponent)
}