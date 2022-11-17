package com.project.scantext.utils;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.format.Formatter;
import android.util.Log;
import android.widget.Toast;


import com.project.scantext.R;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Random;

public class CommonMethods {
    private static final String TAG = "CommonMethods";


    public static int getRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }


    public static void onToastNetworkError(Context mContext) {
        Toast.makeText(mContext, mContext.getString(R.string.err_msg_internet), Toast.LENGTH_SHORT).show();
    }


    public static void onToast(Context mContext, String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }






    /**
     * getMacAddress
     */
    public static String getMacAddress(Context context) {
        String macAddress = "";
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo wInfo = wifiManager.getConnectionInfo();
        macAddress = wInfo.getMacAddress();
        Log.i(TAG, "getIpAddress macAddress: " + macAddress);
        return macAddress;
    }


    /**
     * getIMEINumber
     */
    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String getIMEINumber(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getDeviceId();
    }


    // https://stackoverflow.com/questions/55173823/i-am-getting-imei-null-in-android-q

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String getIMEIDeviceId(Context context) {
        String deviceId;
        TelephonyManager mTelephony;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            deviceId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
            Log.i(TAG, "VERSION_CODES.Q getIMEIDeviceId :" + deviceId);
        } else {
            mTelephony = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (context.checkSelfPermission(Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                    return "";
                }
            }
            if (mTelephony.getDeviceId() != null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    deviceId = mTelephony.getImei();
                    Log.e(TAG, "getImei :" + deviceId);
                } else {
                    deviceId = mTelephony.getDeviceId();
                    Log.i(TAG, "getDeviceId :" + deviceId);
                }
            } else {
                deviceId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
                Log.i(TAG, "VERSION_CODES.Q deviceId :" + deviceId);
            }
        }
        Log.i(TAG, "getIMEIDeviceId : " + deviceId);

        return deviceId;
    }


    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String getIMEIDeviceId2(Context context) {

        String deviceId;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            deviceId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        } else {
            final TelephonyManager mTelephony = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (context.checkSelfPermission(Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                    return "";
                }
            }

            if (mTelephony.getDeviceId() != null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    deviceId = mTelephony.getImei();
                    Log.d("getImei", deviceId);
                } else {
                    deviceId = mTelephony.getDeviceId();
                    Log.d("getDeviceId", deviceId);
                }
            } else {
                deviceId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
            }
        }

        return deviceId;
    }


    public static void print(String tag, String value) {
        System.out.println(tag + " : " + value);
    }

    public static void printError(String tag, String value) {
        System.err.println(tag + " : " + value);
    }

    public static void print(String value) {
        System.out.println(value);
    }


    public static String getTimeStamping() {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat s = new SimpleDateFormat("yyyyMMddhhmmss");
        return s.format(new Date());
    }

    //https://stackoverflow.com/questions/18734452/display-current-time-in-12-hour-format-with-am-pm
    public static String getDateTime(long milliSeconds) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }
}