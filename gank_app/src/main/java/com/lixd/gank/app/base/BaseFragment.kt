package com.lixd.gank.app.base

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.lixd.gank.app.App
import com.lixd.gank.app.inject.component.AppComponent

abstract class BaseFragment : Fragment() {
    protected var mLoadingView: ProgressDialog? = null
    protected var mActivity: Context? = null
    protected var layoutRootView: View? = null

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        mActivity = activity
    }

    override fun onDetach() {
        super.onDetach()
        mActivity = null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (getLayout() is Int) {
            layoutRootView = inflater.inflate(getLayout() as Int, container, false)
        } else if (getLayout() is View) {
            layoutRootView = getLayout() as View
        } else {
            throw RuntimeException("布局只接收Int|View类型参数")
        }
        return layoutRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpComponent(App.getInstance().getAppComponent())
        init(view, savedInstanceState)
    }

    abstract fun getLayout(): Any
    abstract fun init(rootView: View, savedInstanceState: Bundle?)

    open fun showLoading() {
        if (mLoadingView == null) {
            mLoadingView = ProgressDialog.show(mActivity, "", "加载中.......")
        } else {
            mLoadingView?.show()
        }
    }

    open fun stopLoading() {
        if (mLoadingView != null && mLoadingView!!.isShowing) {
            mLoadingView?.dismiss()
        }
    }

    open fun showToast(msg: String) {
        Toast.makeText(mActivity, msg, Toast.LENGTH_SHORT)
    }

    protected open fun setUpComponent(appComponent: AppComponent) {

    }
}