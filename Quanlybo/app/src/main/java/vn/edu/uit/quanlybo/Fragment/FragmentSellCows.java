package vn.edu.uit.quanlybo.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import vn.edu.uit.quanlybo.Model.Cow;
import vn.edu.uit.quanlybo.Model.Market.SellCow;
import vn.edu.uit.quanlybo.Model.User;
import vn.edu.uit.quanlybo.Network.CowService;
import vn.edu.uit.quanlybo.Network.MartketService;
import vn.edu.uit.quanlybo.R;

/**
 * Created by Jackson Nghi on 12/5/2016.
 */

public class FragmentSellCows extends Fragment {

    private EditText edtTitle, edtContent, edtLocation, edtPrice, edtName, edtPhone;
    private TextView txtCow,txtId;
    private Button btnSell;
    private String title,content,location,price;
    private String phone, name,cowid,userid;
    private Cow sell;
    private ViewGroup viewGroup;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sell_cows, container, false);
        viewGroup = container;
        edtTitle = (EditText)rootView.findViewById(R.id.edtTitle);
        edtContent = (EditText)rootView.findViewById(R.id.edtContent);
        edtLocation = (EditText) rootView.findViewById(R.id.edtLocation);
        edtPrice = (EditText) rootView.findViewById(R.id.edtPrice);
        edtName = (EditText) rootView.findViewById(R.id.edtName);
        edtPhone = (EditText) rootView.findViewById(R.id.edtPhone);
        txtCow = (TextView) rootView.findViewById(R.id.txtCow);
        txtId = (TextView) rootView.findViewById(R.id.txtIdCow);
        btnSell = (Button) rootView.findViewById(R.id.btnSell);
        addCows();
        sellCow();
        return rootView;
    }
    protected void addCows(){
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            final String id = bundle.getString("cow_id");
            CowService.getInstance().getListCow(User.getInstance().getId(), new CowService.GetListCow() {
                @Override
                public void onSuccess(List<Cow> cowList) {

                    for(Cow cow : cowList){

                        if(cow.getId().equals(id) ){

                            sell = cow ;
                            break;
                        }
                    }
                    txtId.setText("ID Bò: #"+ sell.getId());
                    txtCow.setText("Giống Bò: "+ sell.getTypeName());
                    edtLocation.setText(User.getInstance().getAddress());
                    edtPhone.setText(User.getInstance().getPhone());
                    edtName.setText(String.valueOf(User.getInstance().getName()));
                }

                @Override
                public void onFailure(String errorCode) {
                    Toast.makeText(getContext(), errorCode, Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
    protected void sellCow(){
        btnSell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userid = User.getInstance().getId();
                cowid = sell.getId();
                if (edtTitle.getText().toString()!=""){
                    title = edtTitle.getText().toString();
                }
                else {
                    title="";
                }
                if(edtName.getText().toString()!=""){
                    name = edtName.getText().toString();
                }
                else {
                    name = "";
                }
                if(edtPhone.getText().toString()!=""){
                    phone = edtPhone.getText().toString();
                }
                else {
                    phone = "";
                }
                if (edtLocation.getText().toString()!=""){
                    location = edtLocation.getText().toString();
                }
                else {
                    location ="";
                }
                if(edtContent.getText().toString()!=""){
                    content = edtContent.getText().toString();
                }
                else {
                    content = "";
                }
                if(edtPrice.getText().toString()!=""){
                    price = edtPrice.getText().toString();
                }
                else {
                    price = "0";
                }
                SellCow sellCow = new SellCow(userid,cowid,title,name,phone,location,content,Integer.valueOf(price));
                MartketService.getInstance().postCowWannaSell(sellCow, new MartketService.PostWannaSell() {
                    @Override
                    public void onSuccess(SellCow sellCow) {
                        Toast.makeText(getContext(),"Đăng bán thành công",Toast.LENGTH_SHORT).show();
                        FragmentManager fragmentManager =  getFragmentManager();
                        fragmentManager.popBackStack();
                        //fragmentManager.popBackStack();
                    }

                    @Override
                    public void onFailure(String errorCode) {
                        Toast.makeText(getContext(),errorCode,Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

    }
}
