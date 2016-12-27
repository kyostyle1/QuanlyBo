package vn.edu.uit.quanlybo.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.print.PrintAttributes;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.uit.quanlybo.Adapter.ListDetailsHistoryBuyMarket;
import vn.edu.uit.quanlybo.AlertDialog.AlertDialogInfo;
import vn.edu.uit.quanlybo.Model.Market.CodeOTP;
import vn.edu.uit.quanlybo.Model.Market.DetailsBuyCows;
import vn.edu.uit.quanlybo.Model.Market.History_Cow;
import vn.edu.uit.quanlybo.Model.Market.RequestCodeOTP;
import vn.edu.uit.quanlybo.Model.User;
import vn.edu.uit.quanlybo.Network.MartketService;
import vn.edu.uit.quanlybo.Network.UserService;
import vn.edu.uit.quanlybo.R;

public class FragmentDetailsBuyCow extends Fragment {
    private View rootView;
    private ViewPager viewPager;
    ListDetailsHistoryBuyMarket adapter = null;
    ListView listViewHistoryDetailsBuyCows;
    private DetailsBuyCows buyCows;
    String marketId = null;
    TextView title,id_cow,title_market;
    TextView name;
    TextView phone;
    TextView location;
    TextView content;
    TextView price;
    TextView cow_type_name;
    TextView cow_target_name;
    TextView cow_gender_name;
    TextView cow_day_on;
    Button btnHistory;
    Button btnBuy;
    Button btnOtp;
    TableLayout tb_history;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_market_list_buy_cow_details, container, false);
        listViewHistoryDetailsBuyCows = (ListView)rootView.findViewById(R.id.details_buy_cow_list);
        Bundle bundle = this.getArguments();
        Log.d("startnew","startnew");
        if (bundle != null) {
            marketId = bundle.getString("marketId", "");
        }
        MartketService.getInstance().getDetailBuyCow(marketId , new MartketService.GetDetailBuyCow() {
            @Override
            public void onSuccess(DetailsBuyCows detailsBuyCows) {
                    buyCows = detailsBuyCows;
                    addDetailsBuyCow(detailsBuyCows);
                Log.d("startnew","startnew");
            }

            @Override
            public void onFailure(String errorCode) {

            }
        }) ;
        return rootView;
    }
    protected boolean isUserOwnedCow(){
        String idUser = User.getInstance().getId();
        String idUserBuyCow = buyCows.getUserId();
        if(idUser.equals(idUserBuyCow)){
            return true;
        }
        return false;
    }
    protected void alertDialogInputEditText(){
        final EditText edittext = new EditText(getActivity());
        edittext.setInputType(InputType.TYPE_CLASS_NUMBER);
        final AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        alert.setTitle("Nhập mã OTP");
        alert.setView(edittext);

        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String YouEditTextValue = edittext.getText().toString();
                String id_user_buy = User.getInstance().getId();
                RequestCodeOTP requestCodeOTP = new RequestCodeOTP(id_user_buy,Integer.valueOf(YouEditTextValue));
                MartketService.getInstance().postBuyCodeOtp(buyCows.getId(),requestCodeOTP, new MartketService.PostCodeOtp() {
                    @Override
                    public void onSuccess(String success) {
                        AlertDialogInfo alertDialogInfo = new AlertDialogInfo();
                        alertDialogInfo.alertDialog(success,getActivity()).show();
                      //  Fragment fragment = new FragmentListBuyCows();
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        fragmentManager.popBackStack();


                        /*FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(getView().getId(), fragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();*/
                    }

                    @Override
                    public void onFailure(String errorCode) {
                        AlertDialogInfo alertDialogInfo = new AlertDialogInfo();
                        alertDialogInfo.alertDialog(errorCode,getActivity()).show();
                    }
                });


            }
        });

        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // what ever you want to do with No option.
            }
        });

        alert.show();
    }
    protected  void addDetailsBuyCow(final DetailsBuyCows detailsBuyCows){


        tb_history = (TableLayout) rootView.findViewById(R.id.tb_history);
        id_cow = (TextView) rootView.findViewById(R.id.details_buy_cow_id_cow) ;
        title_market= (TextView) rootView.findViewById(R.id.details_buy_cow_title_martket) ;
        title = (TextView) rootView.findViewById(R.id.details_buy_cow_title);
        name = (TextView) rootView.findViewById(R.id.details_buy_cow_name);
        phone = (TextView) rootView.findViewById(R.id.details_buy_cow_phone);
        location = (TextView)rootView.findViewById(R.id.details_buy_cow_location);
        content = (TextView)rootView.findViewById(R.id.details_buy_cow_content);
        price = (TextView)rootView.findViewById(R.id.details_buy_cow_price);
        cow_type_name = (TextView)rootView.findViewById(R.id.details_buy_cow_type_name);
        cow_gender_name = (TextView)rootView.findViewById(R.id.details_buy_cow_gender_name);
        cow_day_on = (TextView)rootView.findViewById(R.id.details_buy_cow_day_on);
        btnHistory = (Button)rootView.findViewById(R.id.btn_details_buy_cow_history);
        btnBuy = (Button)rootView.findViewById(R.id.btn_details_buy_cow);
        btnOtp = (Button)rootView.findViewById(R.id.btn_details_buy_cow_get_otp) ;


        title.setText("Thông tin chi tiết bài đăng: "+"#"+detailsBuyCows.getId());
        title_market.setText(detailsBuyCows.getTitle());
        id_cow.setText("ID Bò: #"+detailsBuyCows.getCowId());
        name.setText(detailsBuyCows.getName());
        phone.setText(detailsBuyCows.getPhone());
        location.setText("Địa chỉ: " + detailsBuyCows.getLocation());
        content.setText("Nội dung: " + detailsBuyCows.getContent());
        price.setText("Giá tiền: " + detailsBuyCows.getPrice());

        cow_type_name.setText("Giống bò: " + detailsBuyCows.getCow_type_name());
        cow_gender_name.setText("Giới tính: " + detailsBuyCows.getCow_gender_name());
        cow_day_on.setText("Số ngày tuổi: " + detailsBuyCows.getCow_day_old());
       if(isUserOwnedCow()){
            btnBuy.setVisibility(View.GONE);
           /* btnBuy.setEnabled(false);
            btnOtp.setEnabled(true);*/
        }
        else {
           btnOtp.setVisibility(View.GONE);
          /*  btnBuy.setEnabled(true);
            btnOtp.setEnabled(false);*/
        }
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tb_history.getChildCount()==0){
                    TableRow.LayoutParams layoutParams = new TableRow.LayoutParams();
                    layoutParams.setMargins(20,20,20,20);

                    TextView name_id = new TextView(getActivity());
                    TextView name_title = new TextView(getActivity());
                    name_id.setText("Ngày tuổi");
                    name_title.setText("Công việc");
                    name_id.setLayoutParams(layoutParams);
                    name_title.setLayoutParams(layoutParams);
                    TableRow name_tbr = new TableRow(getActivity());
                    name_tbr.addView(name_id);
                    name_tbr.addView(name_title);
                    tb_history.addView(name_tbr);

                    for (History_Cow history_cow : detailsBuyCows.getListHistoryCow()){
                        TextView txt_id= new TextView(getActivity());
                        TextView txt_title = new TextView(getActivity());
                        txt_id.setLayoutParams(layoutParams);
                        txt_title.setLayoutParams(layoutParams);
                        TableRow tbr_history = new TableRow(getActivity());
                        txt_id.setText(history_cow.getDay_old());
                        txt_title.setText(history_cow.getTitle());
                        tbr_history.addView(txt_id);
                        tbr_history.addView(txt_title);
                        tb_history.addView(tbr_history);
                    }
                }
            }
        });
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    alertDialogInputEditText();

            }
        });
        btnOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MartketService.getInstance().getCodeOtp(buyCows.getId(), new MartketService.GetCodeOtp() {
                    @Override
                    public void onSuccess(CodeOTP codeOTP) {
                        AlertDialogInfo alertDialogInfo = new AlertDialogInfo();
                        alertDialogInfo.title = "Mã OTP";
                        alertDialogInfo.alertDialog(String.valueOf(codeOTP.getOtp()),getActivity()).show();
                    }

                    @Override
                    public void onFailure(String errorCode) {
                        AlertDialogInfo alertDialogInfo = new AlertDialogInfo();
                        alertDialogInfo.alertDialog("Lỗi: "+errorCode,getActivity()).show();
                    }
                });
            }
        });
    }
}