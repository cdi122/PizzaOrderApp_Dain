package com.example.pizzaorderapp_dain.adapters

import android.content.Context
import android.renderscript.Script
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.pizzaorderapp_dain.R
import com.example.pizzaorderapp_dain.datas.Store

class PizzaStoreAdapter(
    val mContext : Context,
    val resID: Int,
    val mList : List<Store>) : ArrayAdapter<Store>(mContext, resID, mList) {

        val inflater = LayoutInflater.from(mContext)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
       var tempRow = convertView
        if (tempRow == null){
            tempRow = inflater.inflate(R.layout.pizza_store_list_item, null)
        }
        val row = tempRow!!

        return row
    }

}