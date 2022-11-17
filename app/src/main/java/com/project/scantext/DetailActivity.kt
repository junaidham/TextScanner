package com.project.scantext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

       // val myModel = intent.getSerializableExtra("model") as? BcodeResponse.DataPayload
        val myModel = intent.extras!!.get("model") as BcodeResponse.DataPayload
        val rupee = myModel.currency
        tvWalletBalance.text = "Wallet Balance  :  $rupee ${myModel.walletBalance}"
        tvExpiryDate.text = "Expiry Date  : ${myModel.expiryDate}"
        tvWalletType.text = "Wallet Type  : ${ myModel.walletType}"
        tvCashAllowed.text = "Cash Allowed  :  $rupee ${myModel.cashAllowed}"
    }
}