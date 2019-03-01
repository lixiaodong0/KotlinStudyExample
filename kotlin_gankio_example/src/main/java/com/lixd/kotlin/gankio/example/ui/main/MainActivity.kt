package com.lixd.kotlin.gankio.example.ui.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import com.lixd.kotlin.gankio.example.AppComponent
import com.lixd.kotlin.gankio.example.R
import com.lixd.kotlin.gankio.example.base.BaseActivity
import com.lixd.kotlin.gankio.example.data.ProjectBean
import com.lixd.kotlin.gankio.example.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import javax.inject.Inject

class MainActivity : BaseActivity(), IMainView {

    @Inject
    lateinit var presenter: MainPresenter

    @Inject
    lateinit var adapter: MainAdapter

    override fun showGankData(datas: List<ProjectBean>) {
        adapter.setNewData(datas)
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun init(savedInstanceState: Bundle?) {
        mainRecyclerView.adapter = adapter
        adapter.onItemClickListener = object : MainAdapter.OnItemClickListener {
            override fun onClick(position: Int, data: ProjectBean) {
                if (!TextUtils.isEmpty(data.url)) {
                    startActivity(intentFor<DetailActivity>("url" to data.url))
                }
            }
        }
        mainRecyclerView.layoutManager = LinearLayoutManager(this)

        presenter.getGankData()
    }

    override fun setUpComponent(appComponent: AppComponent) {
        DaggerMainActivityComponent.builder()
                .appComponent(appComponent)
                .mainActivityModule(MainActivityModule(this))
                .build()
                .inject(this)
    }
}
