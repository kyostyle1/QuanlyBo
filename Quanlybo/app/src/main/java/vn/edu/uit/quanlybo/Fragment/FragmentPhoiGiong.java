package vn.edu.uit.quanlybo.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.uit.quanlybo.Adapter.ListCowAdapter;
import vn.edu.uit.quanlybo.Model.Cow;
import vn.edu.uit.quanlybo.Model.User;
import vn.edu.uit.quanlybo.R;

/**
 * Created by phuc9 on 10/19/2016.
 */
public class FragmentPhoiGiong extends Fragment{
    ListCowAdapter adapter = null;
    ListView cow_list = null;
    Button phoigiong;
    List<Cow> cows = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_phoi_giong, container, false);
        cow_list = (ListView)rootView.findViewById(R.id.cow_list);
        phoigiong = (Button)rootView.findViewById(R.id.phoigiong);
        Log.d("Id",String.valueOf( User.getInstance().getId()));
        Log.d("Access-token", String.valueOf(User.getInstance().getAccess_token()));
        phoigiong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Call<ResponseBody> listCowResponseCall = service.getListCow(User.getInstance().getId(), User.getInstance().getAccess_token());
                listCowResponseCall.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Log.d("Code", String.valueOf(response.code()));
                        Log.d("Respone", response.body().toString());
                        try {
                            JSONObject obj = new JSONObject(response.body().string());
                            Log.d("Meta", obj.getString("_meta"));
                            Log.d("Cow", obj.getString("Cow"));

                            JSONArray json_cows = obj.getJSONArray("Cow");

                            for (int i = 0; i < json_cows.length(); i++) {
                                JSONObject c = json_cows.getJSONObject(i);

                                Integer id = c.getInt("id");
                                //String father = c.getString("father").equals(JSONObject.NULL);
                                //Integer mother = c.getString("mother");
                                Integer userId = c.getInt("userId");
                                Integer typeId = c.getInt("typeId");
                                String qrId = c.getString("qrId");
                                String nfcId = c.getString("nfcId");
                                String birthday = c.getString("birthday");
                                String gender = c.getString("gender");
                                String target = c.getString("target");
                                String isBorn = c.getString("isBorn");
                                //Integer price = c.getInt("price");
                                //Integer market_code = c.getInt("market_code");
                                //String dateCreated = c.getString("dateCreated");
                                //String dateUpdated = c.getString("dateUpdated");
                                // tmp hash map for single contact
                                Cow cow_add = new Cow(id,null,null,userId,typeId,qrId,nfcId,birthday,gender,target,isBorn,null,null);
                                Log.d("123123", cow_add.toString());
                                // adding contact to contact list
                                cows.add(cow_add);
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.d("Fail", "FAIL");

                    }
                });*/

                /*Call<ListCowRespone> listCowResponseCall = service.getListCow(User.getInstance().getId(), User.getInstance().getAccess_token());
                Log.d("Id", User.getInstance().getId());
                Log.d("Token", User.getInstance().getAccess_token());
                listCowResponseCall.enqueue(new Callback<ListCowResponse>() {
                    @Override
                    public void onResponse(Call<ListCowResponse> call, Response<ListCowResponse> response) {
                        Log.d("Body", response.body().toString());
                        Log.d("Raw", response.raw().toString());
                        ListCowResponse listCowResponse = response.body();
                        if ( listCowResponse.getCow() == null){
                            return;
                        }else {
                            cows = listCowResponse.getCow();
                            adapter = new ListCowAdapter(getContext(), R.layout.cow_item, cows);
                            adapter.setNotifyOnChange(true);
                            adapter.notifyDataSetChanged();
                            cow_list.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<ListCowResponse> call, Throwable t) {
                        t.printStackTrace();
                        Log.d("trace", t.getMessage());
                    }

                });*/
            }
        });

        return rootView;
    }
}
