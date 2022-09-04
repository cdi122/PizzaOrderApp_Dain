package com.example.pizzaorderapp_dain

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.pizzaorderapp_dain.datas.Store
import kotlinx.android.synthetic.main.activity_view_store_detail.*

class ViewStoreDetailActivity : BaseActivity() {

    lateinit var mStoreData : Store
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_store_detail)
        setupEvents()
        setValues()

    }
    override fun setupEvents() {

        callPhoneBtn.setOnClickListener {
            val myUri = Uri.parse("tel:${mStoreData.phoneNum}")
            val myIntent = Intent(Intent.ACTION_CALL, myUri)
            startActivity(myIntent)
        }

    }

    override fun setValues() {

        mStoreData = intent.getSerializableExtra("storeData") as Store
        Glide.with(mContext).load(mStoreData.logoURL).into(storeLogoImg)
        storePhoneNumText.text = mStoreData.phoneNum
        storeNameTxt.text = mStoreData.name


    }


}