package com.lixd.gank.app.ui.fragment.about

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.lixd.gank.app.R
import com.lixd.gank.app.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_about.*

class AboutFragment : BaseFragment() {

    override fun getLayout(): Any = R.layout.fragment_about

    override fun init(rootView: View, savedInstanceState: Bundle?) {


    }

    companion object {
        val TAG: String = AboutFragment::class.java.simpleName
        fun newInstance(): Fragment = AboutFragment()
    }
}