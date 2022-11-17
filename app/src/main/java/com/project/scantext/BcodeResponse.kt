package com.project.scantext


import com.google.gson.annotations.SerializedName

data class BcodeResponse(
    @SerializedName("error"        ) var error        : Int?    = null,
    @SerializedName("errorMessage" ) var errorMessage : String? = null,
    @SerializedName("data"         ) var dataPayload  : DataPayload?   = DataPayload()
){
    data class DataPayload (
        @SerializedName("walletBalance" ) var walletBalance : Double? = null,
        @SerializedName("expiryDate"    ) var expiryDate    : String? = null,
        @SerializedName("currency"      ) var currency      : String? = null,
        @SerializedName("walletType"    ) var walletType    : String? = null,
        @SerializedName("cashAllowed"   ) var cashAllowed   : Double? = null,
        @SerializedName("isRecurring"   ) var isRecurring   : Int?    = null,
        @SerializedName("token"         ) var token         : String? = null

    ):java.io.Serializable
}
