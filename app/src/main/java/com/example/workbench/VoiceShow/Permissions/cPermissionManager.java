package com.example.workbench.VoiceShow.Permissions;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

public class cPermissionManager
{
    private static cPermissionManager mInstance;

    private Activity mActivity;

    //private static final int    MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;
    private String[]        mPermissions = {Manifest.permission.CALL_PHONE,
                            Manifest.permission.INTERNET,
                            Manifest.permission.RECORD_AUDIO,
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.READ_CONTACTS};

    public static cPermissionManager GetInst()
    {
        if (mInstance == null)
            mInstance = new cPermissionManager();

        return mInstance;
    }

    public void Initialize(Activity _act)
    {
        // 퍼미션 획득에 관련된 데이터 할당 작업 및 퍼미션 획득 여부 확인
        SetActivity(_act);
        CheckPermissionDenied();
    }

    public void SetActivity(Activity _act)
    {
        mActivity = _act;
    }

    public void CheckPermissionDenied()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            GetPermissions();
        }
    }

    public void GetPermissions()
    {
        mActivity.requestPermissions(mPermissions, 1000);
    }
}
