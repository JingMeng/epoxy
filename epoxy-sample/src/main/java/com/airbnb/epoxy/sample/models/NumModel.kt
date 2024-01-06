package com.airbnb.epoxy.sample.models

import android.util.Log
import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.sample.R
import com.airbnb.paris.annotations.Styleable

@EpoxyModelClass(layout = R.layout.number_view)
abstract class NumModel : EpoxyModel<View>() {
    @EpoxyAttribute
    var str: String = "123456"

    override fun bind(view: View) {
        super.bind(view)
        Log.i("NumModel", "-----------NumModel---------bind-----------执行了----")
        view.findViewById<TextView>(R.id.test).text = str
    }

    override fun id(id: Long): EpoxyModel<View> {
//        try {
//            throw RuntimeException("-------NumModel---$id------什么时间调用的--------")
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
        return super.id(id)
    }
}
