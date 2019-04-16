package com.example.cameratest;


import android.content.Context;

//sử dụng SharedPreferences để lưu trữ một giá trị boolean (true or false) để chỉ ra lần đầu tiên người dụng khởi động app
import android.content.SharedPreferences;

public class PrefManager
{
    SharedPreferences mPref;
    SharedPreferences.Editor mEditor;
    Context mContext;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "androidhive-welcome";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static PrefManager mInstance;

    public static PrefManager getInstance(Context context)
    {
        if (mInstance == null)
        {
            mInstance = new PrefManager(context);
        }
        return mInstance;
    }

    public PrefManager(Context context)
    {
        this.mContext = context;
        mPref = mContext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        mEditor = mPref.edit();
    }

    public void setFirstimeLaunch(boolean isFirstTime)
    {
        mEditor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        mEditor.apply();
    }

//    trả về true nếu app khởi động lần đầu tiên
    public boolean isFirstTimeLaunch()
    {
        return mPref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }
}