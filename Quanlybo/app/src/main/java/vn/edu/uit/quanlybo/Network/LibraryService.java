package vn.edu.uit.quanlybo.Network;

import android.app.Activity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.uit.quanlybo.Model.Cow;
import vn.edu.uit.quanlybo.Model.ListLibrary.LibraryResponse;
import vn.edu.uit.quanlybo.Model.ListLibrary.LibraryType;

/**
 * Created by PhucHuynh on 11/29/16.
 */

public class LibraryService extends BaseService {

    private static LibraryService libraryService = null;

    private QuanLyBoAPI quanLyBoAPI = getQuanLyBoAPI();

    public static LibraryService getInstance(){
        activity = null;
        if( libraryService == null){
            libraryService = new LibraryService();
        }
        return libraryService;
    }

    public static LibraryService getInstance(Activity atv){
        if ( activity == null){
            activity = atv;
        }

        if (libraryService == null){
            libraryService = new LibraryService();
        }

        return libraryService;
    }

    // ------------------------ GET LIBRARY LIST SERVICE----------------------------------

    public void getListLibrary(final GetListLibrary getListLibrary){
        showProgressDialog();
        Call<List<LibraryResponse>> call = quanLyBoAPI.getLibraryList();
        call.enqueue(new Callback<List<LibraryResponse>>() {
            @Override
            public void onResponse(Call<List<LibraryResponse>> call, Response<List<LibraryResponse>> response) {
                if ( response.isSuccessful() ) {
                    List<LibraryResponse> libraryResponseList = response.body();
                    getListLibrary.onSuccess(libraryResponseList);
                }
                else {
                    getListLibrary.onFailure("Failure");
                }
            }

            @Override
            public void onFailure(Call<List<LibraryResponse>> call, Throwable t) {
                getListLibrary.onFailure("Failure");
            }
        });
    }

    public interface GetListLibrary {
        void onSuccess(List<LibraryResponse> libraryResponseList);
        void onFailure(String errorCode);

    }

    // ------------------------ GET LIBRARY BY TYPE SERVICE----------------------------------

    public void getLibraryByType(String typeId, final GetLibraryByType getLibraryByType){
        showProgressDialog();
        Call<List<LibraryResponse>> call = quanLyBoAPI.getLibraryByType(typeId);
        call.enqueue(new Callback<List<LibraryResponse>>() {
            @Override
            public void onResponse(Call<List<LibraryResponse>> call, Response<List<LibraryResponse>> response) {
                if ( response.isSuccessful() ) {
                    List<LibraryResponse> libraryResponseList = response.body();
                    getLibraryByType.onSuccess(libraryResponseList);
                }
                else {
                    getLibraryByType.onFailure("Failure");
                }
            }

            @Override
            public void onFailure(Call<List<LibraryResponse>> call, Throwable t) {
                getLibraryByType.onFailure("Failure");
            }
        });
    }

    public interface GetLibraryByType {
        void onSuccess(List<LibraryResponse> libraryResponseList);
        void onFailure(String errorCode);

    }

    // ------------------------ GET LIST TYPE LIBRARY SERVICE----------------------------------

    public void getListTypeLibrary(final GetListTypeLibrary getListTypeLibrary){
        showProgressDialog();
        Call<List<LibraryType>> call = quanLyBoAPI.getTypeLibrary();
        call.enqueue(new Callback<List<LibraryType>>() {
            @Override
            public void onResponse(Call<List<LibraryType>> call, Response<List<LibraryType>> response) {
                if ( response.isSuccessful() ) {
                    List<LibraryType> libraryTypes = response.body();
                    getListTypeLibrary.onSuccess(libraryTypes);
                } else {
                    getListTypeLibrary.onFailure("Failure");
                }
            }

            @Override
            public void onFailure(Call<List<LibraryType>> call, Throwable t) {
                getListTypeLibrary.onFailure("Failure");
            }
        });
    }

    public interface GetListTypeLibrary {
        void onSuccess(List<LibraryType> libraryTypeList);
        void onFailure(String errorCode);

    }

}
