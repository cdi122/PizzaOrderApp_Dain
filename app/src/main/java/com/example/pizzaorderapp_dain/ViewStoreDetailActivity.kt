package com.example.pizzaorderapp_dain

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.pizzaorderapp_dain.datas.Store
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
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
            val permissionListener = object : PermissionListener {
                override fun onPermissionGranted() {

                    val myUri = Uri.parse("tel:${mStoreData.phoneNum}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext, "전화연결 권한이 없습니다.", Toast.LENGTH_SHORT).show()
                }

            }

            TedPermission.create(mContext)
                .setPermissionListener(permissionListener)
                .setDeniedMessage("[설정]에서 전화 권한을 켜주세요.")
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()

        }

    }

    override fun setValues() {

        mStoreData = intent.getSerializableExtra("storeData") as Store
        Glide.with(mContext).load(mStoreData.logoURL).into(storeLogoImg)
        storePhoneNumText.text = mStoreData.phoneNum
        storeNameTxt.text = mStoreData.name


    }


}