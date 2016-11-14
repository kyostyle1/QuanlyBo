package vn.edu.uit.quanlybo.Network;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Handler;

/**
 * Created by phuc9 on 11/14/2016.
 */

public class BaseService {
    private Handler handler = new Handler();

    private static BaseService baseService = null;
    private QuanLyBoAPI quanLyBoAPI = null;
    private ProgressDialog progressDialog;
    protected static Activity activity = null;

    public static BaseService getInstance(){
        if (baseService == null){
            baseService = new BaseService();
        }

        return baseService;
    }

    public QuanLyBoAPI getQuanLyBoAPI(){
        if ( quanLyBoAPI == null){
            quanLyBoAPI = QuanLyBoService.getService();
        }
        return quanLyBoAPI;
    }

    public void showProgressDialog(){
        if ( activity != null){
            progressDialog = ProgressDialog.show(activity, "" , "Please wait");
        }
    }

    public void hideProgressDialog(){
        if ( activity != null){
            if( progressDialog != null){
                progressDialog.dismiss();
            }
        }
    }
}
