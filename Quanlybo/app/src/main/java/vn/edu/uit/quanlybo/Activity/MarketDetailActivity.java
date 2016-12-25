package vn.edu.uit.quanlybo.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import vn.edu.uit.quanlybo.Adapter.ListDetailsHistoryBuyMarket;
import vn.edu.uit.quanlybo.AlertDialog.AlertDialogInfo;
import vn.edu.uit.quanlybo.Fragment.FragmentListBuyCows;
import vn.edu.uit.quanlybo.Model.Market.CodeOTP;
import vn.edu.uit.quanlybo.Model.Market.DetailsBuyCows;
import vn.edu.uit.quanlybo.Model.Market.History_Cow;
import vn.edu.uit.quanlybo.Model.Market.RequestCodeOTP;
import vn.edu.uit.quanlybo.Model.User;
import vn.edu.uit.quanlybo.Network.MartketService;
import vn.edu.uit.quanlybo.R;

public class MarketDetailActivity extends AppCompatActivity {
    ListDetailsHistoryBuyMarket adapter = null;
    ListView listViewHistoryDetailsBuyCows;
    private DetailsBuyCows buyCows;
    String marketId = null;
    TextView title;
    TextView name;
    TextView phone;
    TextView location;
    TextView content;
    TextView price;
    TextView isSold;
    TextView dateCreated;
    TextView dateUpdated;
    TextView cow_type_name;
    TextView cow_target_name;
    TextView cow_gender_name;
    TextView cow_birthday;
    TextView cow_day_on;
    Button btnHistory;
    Button btnBuy;
    Button btnOtp;
    TableLayout tb_history;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_market_list_buy_cow_details);
        listViewHistoryDetailsBuyCows = (ListView)findViewById(R.id.details_buy_cow_list);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if( bundle != null) {
            marketId = (String) bundle.get("marketId");
        }
        MartketService.getInstance().getDetailBuyCow(marketId , new MartketService.GetDetailBuyCow() {
            @Override
            public void onSuccess(DetailsBuyCows detailsBuyCows) {
                buyCows = detailsBuyCows;
                addDetailsBuyCow(detailsBuyCows);
            }
            @Override
            public void onFailure(String errorCode) {

            }
        }) ;

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
        final EditText edittext = new EditText(MarketDetailActivity.this);
        edittext.setInputType(InputType.TYPE_CLASS_NUMBER);
        final AlertDialog.Builder alert = new AlertDialog.Builder(MarketDetailActivity.this);
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
                        Fragment fragment = new FragmentListBuyCows();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragmentContainer, fragment)
                                .commit();
                    }

                    @Override
                    public void onFailure(String errorCode) {
                        AlertDialogInfo alertDialogInfo = new AlertDialogInfo();
                        alertDialogInfo.alertDialog(errorCode,MarketDetailActivity.this).show();
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


        tb_history = (TableLayout) findViewById(R.id.tb_history);
        title = (TextView) findViewById(R.id.details_buy_cow_title);
        name = (TextView) findViewById(R.id.details_buy_cow_name);
        phone = (TextView) findViewById(R.id.details_buy_cow_phone);
        location = (TextView)findViewById(R.id.details_buy_cow_location);
        content = (TextView)findViewById(R.id.details_buy_cow_content);
        price = (TextView)findViewById(R.id.details_buy_cow_price);
        isSold = (TextView)findViewById(R.id.details_buy_cow_is_sold);
        dateCreated = (TextView)findViewById(R.id.details_buy_cow_date_created);
        dateUpdated = (TextView)findViewById(R.id.details_buy_cow_date_updated);
        cow_type_name = (TextView)findViewById(R.id.details_buy_cow_type_name);
        cow_gender_name = (TextView)findViewById(R.id.details_buy_cow_gender_name);
        cow_target_name = (TextView)findViewById(R.id.details_buy_cow_target_name);
        cow_birthday = (TextView)findViewById(R.id.details_buy_cow_birthday);
        cow_day_on = (TextView)findViewById(R.id.details_buy_cow_day_on);
        btnHistory = (Button)findViewById(R.id.btn_details_buy_cow_history);
        btnBuy = (Button)findViewById(R.id.btn_details_buy_cow);
        btnOtp = (Button)findViewById(R.id.btn_details_buy_cow_get_otp) ;

        title.setText(detailsBuyCows.getTitle());
        name.setText(detailsBuyCows.getName());
        phone.setText(detailsBuyCows.getPhone());
        location.setText("D/c: " + detailsBuyCows.getLocation());
        content.setText("Nội dung: " + detailsBuyCows.getContent());
        price.setText("$: " + detailsBuyCows.getPrice());
        isSold.setText("Is Sold: "+ detailsBuyCows.getIs_sold());
        dateCreated.setText("Date Created: "+ detailsBuyCows.getDateCreated());
        dateUpdated.setText("Date Updated: " + detailsBuyCows.getDateUpdated());
        cow_type_name.setText("Cow Type: " + detailsBuyCows.getCow_type_name());
        cow_gender_name.setText("Cow Gender: " + detailsBuyCows.getCow_gender_name());
        cow_target_name.setText("Cow Target: " + detailsBuyCows.getCow_target_name());
        cow_birthday.setText("Cow Birthday: " + detailsBuyCows.getCow_birthday());
        cow_day_on.setText("Cow day on: " + detailsBuyCows.getCow_day_old());
        if(isUserOwnedCow()){
            btnBuy.setEnabled(false);
            btnOtp.setEnabled(true);
        }
        else {
            btnBuy.setEnabled(true);
            btnOtp.setEnabled(false);
        }
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tb_history.getChildCount()==0){
                    TableRow.LayoutParams layoutParams = new TableRow.LayoutParams();
                    layoutParams.setMargins(20,20,20,20);
                    TextView name_id = new TextView(MarketDetailActivity.this);
                    TextView name_title = new TextView(MarketDetailActivity.this);
                    name_id.setText("ID");
                    name_title.setText("Title");
                    name_id.setLayoutParams(layoutParams);
                    name_title.setLayoutParams(layoutParams);
                    TableRow name_tbr = new TableRow(MarketDetailActivity.this);
                    name_tbr.addView(name_id);
                    name_tbr.addView(name_title);
                    tb_history.addView(name_tbr);

                    for (History_Cow history_cow : detailsBuyCows.getListHistoryCow()){
                        TextView txt_id= new TextView(MarketDetailActivity.this);
                        TextView txt_title = new TextView(MarketDetailActivity.this);
                        txt_id.setLayoutParams(layoutParams);
                        txt_title.setLayoutParams(layoutParams);
                        TableRow tbr_history = new TableRow(MarketDetailActivity.this);
                        txt_id.setText(history_cow.getId());
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
                        alertDialogInfo.alertDialog(String.valueOf(codeOTP.getOtp()),MarketDetailActivity.this).show();
                    }

                    @Override
                    public void onFailure(String errorCode) {
                        AlertDialogInfo alertDialogInfo = new AlertDialogInfo();
                        alertDialogInfo.alertDialog("Lỗi: "+errorCode,MarketDetailActivity.this).show();
                    }
                });
            }
        });
    }
}
