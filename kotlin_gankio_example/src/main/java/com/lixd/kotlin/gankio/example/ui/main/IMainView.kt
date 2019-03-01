package com.lixd.kotlin.gankio.example.ui.main

import com.lixd.kotlin.gankio.example.base.IBaseView
import com.lixd.kotlin.gankio.example.data.ProjectBean

interface IMainView : IBaseView{

    fun showGankData(datas:List<ProjectBean>)

}