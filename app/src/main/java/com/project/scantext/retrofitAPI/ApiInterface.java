package com.project.scantext.retrofitAPI;



import com.google.gson.JsonObject;
import com.project.scantext.BcodeResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;


/**
 * @author Junaid Ahmad@Nextgen
 * @since 16/11/2022   Created
 */

public interface ApiInterface {

    @Headers("Content-Type: application/json")
    @POST(EndApi.DECODE_BCODE)
    Call<BcodeResponse> walletBalance(@Body JsonObject jsonBody);

  /*  @Headers("Content-Type: application/json")
    @POST(EndApi.REPORT_LOG)
    Call<ReportResponse> logReport(@Body JsonObject jsonBody);*/

   /*
    @Headers("Content-Type: application/json")
    @GET(EndApi.COMPLAINT_LIST)
    Call<ComplaintListResponse> complaintList(
            @Query("backendKeyUser") String backendKeyUse
    );

    //http://localhost:8080/TafaniMerchant/commuter/ServiceRequestList?
    // backendKeyUser=07563-wa$h-0265adf4-5c27-4858-89bc-20496b2e42b9-XEQYX-Xiti&ServiceRequestId=1
    @Headers("Content-Type: application/json")
    @GET(EndApi.SERVICE_REQUEST_LIST)
    Call<ServiceRequestListResponse> serviceRequestList(
            @Query("backendKeyUser") String backendKeyUser,
            @Query("ServiceRequestId") String ServiceRequestId
    );
    */



}