package com.lixd.gank.app.base

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.lixd.gank.app.inject.component.AppComponent

abstract class BaseActivity : AppCompatActivity() {
    protected var mLoadingView: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layoutRootView = getLayout()
        if (layoutRootView is Int) {
            setContentView(layoutRootView)
        } else if (layoutRootView is View) {
            setContentView(layoutRootView)
        } else {
            throw RuntimeException("布局只接收Int|View类型参数")
        }
        init(savedInstanceState)
    }

    abstract fun getLayout(): Any

    abstract fun init(savedInstanceState: Bundle?)

    protected open fun showLoading() {
        if (mLoadingView == null) {
            mLoadingView = ProgressDialog.show(this, "", "加载中.......")
        } else {
            mLoadingView?.show()
        }
    }

    protected open fun stopLoading() {
        if (mLoadingView != null && mLoadingView!!.isShowing) {
            mLoadingView?.dismiss()
        }
    }

    protected open fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT)
    }

    protected open fun setUpComponent(appComponent: AppComponent) {

    }

    override fun onDestroy() {
        super.onDestroy()
        stopLoading()
    }
}