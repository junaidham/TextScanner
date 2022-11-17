package com.project.scantext.utils

import android.app.Activity
import android.app.ProgressDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.Editable
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.project.scantext.R

class CommonsMethods(var mActivity: Activity) {
    var mProgressDialog: ProgressDialog? = null


    fun showProgressDialog(isStatus: Boolean) {
        if (isStatus) {
            mProgressDialog = ProgressDialog.show(mActivity, null, null)
            mProgressDialog!!.setContentView(R.layout.progress_loader)
            mProgressDialog!!.getWindow()!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            mProgressDialog!!.setCancelable(false)
        }
        if (!isStatus) {
            if (mProgressDialog != null && mProgressDialog!!.isShowing())
                mProgressDialog!!.dismiss()
        }
    }


    /*

    fun isValidateMobileNumber(mobileNumber: String, textMobileNumber: TextInputLayout?): Boolean {
        when {
            mobileNumber.isBlank() -> {
                textMobileNumber!!.isErrorEnabled = true
                textMobileNumber.error = mActivity.getString(R.string.field_not_blank)
                return false
            }
            mobileNumber.length < 9 -> {
                textMobileNumber!!.isErrorEnabled = true
                textMobileNumber.error = mActivity.getString(R.string.enter_valid_mobile_number)
                return false
            }
            else -> {
                textMobileNumber!!.isErrorEnabled = false
                return true
            }
        }
    }

    fun isValidateMobileNumber(editText: TextInputEditText, textMobileNumber: TextInputLayout?): Boolean {
        when {
            editText.text.toString().isBlank() -> {
                textMobileNumber!!.isErrorEnabled = true
                textMobileNumber.error = mActivity.getString(R.string.field_not_blank)
                return false
            }
            editText.text.toString().length < 10 -> {
                textMobileNumber!!.isErrorEnabled = true
                textMobileNumber.error = mActivity.getString(R.string.enter_valid_mobile_number)
                return false
            }
            else -> {
                textMobileNumber!!.isErrorEnabled = false
                return true
            }
        }
    }

    fun isValidateFieldEmail(editText: TextInputEditText, textInputLayout: TextInputLayout?): Boolean {
        val email = FieldValidators.isValidEmail2(editText.text.toString())
        if (editText.text.toString().isBlank()){
            textInputLayout!!.isErrorEnabled = true
            textInputLayout.error = mActivity.getString(R.string.field_not_blank)
            return false
        }else if (!FieldValidators.isValidEmail2(editText.text.toString())){
            println("isValidEmail222: $email")
            textInputLayout!!.isErrorEnabled = true
            textInputLayout.error = mActivity.getString(R.string.enter_valid_email)
            return false
        }else {
            textInputLayout!!.isErrorEnabled = false
            return true
        }

    }

    fun isValidateFieldEmail(emailText: String, textInputLayout: TextInputLayout?): Boolean {
        val email = FieldValidators.isValidEmail2(emailText)
        println("isValidEmail2: $email")
        if (emailText.isBlank()){
            textInputLayout!!.isErrorEnabled = true
            textInputLayout.error = mActivity.getString(R.string.field_not_blank)
            return false
        }else if (!FieldValidators.isValidEmail2(emailText)){
            println("isValidEmail222: $email")
            textInputLayout!!.isErrorEnabled = true
            textInputLayout.error = mActivity.getString(R.string.enter_valid_email)
            return false
        }else {
            textInputLayout!!.isErrorEnabled = false
            return true
        }

    }

    fun isValidateField(stringText: String, textInputLayout: TextInputLayout?): Boolean {
        return when {
            stringText.isBlank() -> {
                textInputLayout!!.isErrorEnabled = true
                textInputLayout.error = mActivity.getString(R.string.field_not_blank)
                false
            }
            else -> {
                textInputLayout!!.isErrorEnabled = false
                true
            }
        }
    }

    fun isValidateField(editText: TextInputEditText, textInputLayout: TextInputLayout?): Boolean {
        return when {
            editText.text.toString().isBlank() -> {
                textInputLayout!!.isErrorEnabled = true
                textInputLayout.error = mActivity.getString(R.string.field_not_blank)
                false
            }
            else -> {
                textInputLayout!!.isErrorEnabled = false
                true
            }
        }
    }

    fun isValidateField(editText: TextInputEditText, errorMsg: String, len: Int, txtCardPin: TextInputLayout): Boolean {
        when {
            editText.text.toString().isBlank() -> {
                txtCardPin.isErrorEnabled = true
                txtCardPin.error = mActivity.getString(R.string.field_not_blank)
                return false
            }
            editText.text.toString().length < len -> {
                txtCardPin.isErrorEnabled = true
                txtCardPin.error = errorMsg
                return false
            }
            else -> {
                txtCardPin.isErrorEnabled = false
                return true
            }
        }
    }

    fun isValidateField(stringText: String, errorMsg: String, textInputLayout: TextInputLayout?): Boolean {
        when {
            stringText.isBlank() -> {
                textInputLayout!!.isErrorEnabled = true
                textInputLayout.error = mActivity.getString(R.string.field_not_blank)
                return false
            }
            stringText.length < 5 -> {
                textInputLayout!!.isErrorEnabled = true
                textInputLayout.error = errorMsg
                return false
            }
            else -> {
                textInputLayout!!.isErrorEnabled = false
                return true
            }
        }
    }


    fun isValidateOTP(otp: String, textOTP: TextInputLayout?): Boolean {
        when {
            otp.isBlank() -> {
                textOTP!!.isErrorEnabled = true
                textOTP.error = mActivity.getString(R.string.field_not_blank)
                return false
            }
            otp.length < 6 -> {
                textOTP!!.isErrorEnabled = true
                textOTP.error = mActivity.getString(R.string.enter_valid_otp)
                return false
            }
            else -> {
                textOTP!!.isErrorEnabled = false
                return true
            }
        }
    }

    fun isValidatePIN(mPIN: String, errorMsg: String, txtCardPin: TextInputLayout): Boolean {
        when {
            mPIN.isBlank() -> {
                txtCardPin.isErrorEnabled = true
                txtCardPin.error = mActivity.getString(R.string.field_not_blank)
                return false
            }
            mPIN.length < 6 -> {
                txtCardPin.isErrorEnabled = true
                txtCardPin.error = errorMsg
                return false
            }
            else -> {
                txtCardPin.isErrorEnabled = false
                return true
            }
        }
    }

    fun isValidatePIN(mPIN: String, textCardPin: TextInputLayout?): Boolean {
        when {
            mPIN.isBlank() -> {
                textCardPin!!.isErrorEnabled = true
                textCardPin.error = mActivity.getString(R.string.field_not_blank)
                return false
            }
            mPIN.length < 6 -> {
                textCardPin!!.isErrorEnabled = true
                textCardPin.error = mActivity.getString(R.string.enter_valid_pin)
                return false
            }
            else -> {
                textCardPin!!.isErrorEnabled = false
                return true
            }
        }
    }


    fun doThingWithText(editText: TextInputEditText, btnAction: AppCompatButton, len: Int, it: Editable?) {
        if (it != null){
            if (editText.text!!.isNotEmpty() && editText.text!!.toString().length > len){
                btnAction.isEnabled = true
                btnAction.setBackgroundResource(R.drawable.button_active)
            }else{
                btnAction.isEnabled = false
                btnAction.setBackgroundResource(R.drawable.button_deactive)
            }
        }
    }


    fun doThingWithText(editText: String, btnAction: AppCompatButton, len: Int, it: Editable?) {
        if (it != null){
            if (editText.isNotEmpty() && editText.length > len){
                btnAction.isEnabled = true
                btnAction.setBackgroundResource(R.drawable.button_active)
            }else{
                btnAction.isEnabled = false
                btnAction.setBackgroundResource(R.drawable.button_deactive)
            }
        }
    }

    fun doThingWithTextOTP(editText: TextInputEditText, btnAction: AppCompatButton, it: Editable?) {
        if (it != null){
            if (editText.text!!.length > 5 ){
                btnAction.isEnabled = true
                btnAction.setBackgroundResource(R.drawable.button_active)
            }else{
                btnAction.isEnabled = false
                btnAction.setBackgroundResource(R.drawable.button_deactive)
            }
        }
    }

*/
}