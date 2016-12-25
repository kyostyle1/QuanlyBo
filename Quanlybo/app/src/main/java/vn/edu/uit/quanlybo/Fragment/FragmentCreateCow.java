package vn.edu.uit.quanlybo.Fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import vn.edu.uit.quanlybo.Model.User;
import vn.edu.uit.quanlybo.Network.CowService;
import vn.edu.uit.quanlybo.Network.Model.CowTypeResponse;
import vn.edu.uit.quanlybo.Network.Model.CreateCowRequest;
import vn.edu.uit.quanlybo.R;

/**
 * Created by phuc9 on 10/19/2016.
 */
public class FragmentCreateCow extends Fragment {
    List<String> giongbo = new ArrayList<>();

    String cowTarget[]= {
            "Nuôi lấy thịt",
            "Nuôi lấy sữa",
            "Nuôi sinh sản"
    };
    View rootView;

    private EditText CowBirthday;
    private Button btnNfcId;
    private EditText father;
    private EditText mother;
    private EditText qrId;
    private EditText nfcId;
    private Spinner cow_type_spinner;
    private String cow_type;
    private Spinner cow_target;
    private String target = "meat";
    private String gender = "male";
    private String source = "no";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_create_cow, container, false);

        /*Spinner Giong bo*/
        getType();

        /* Date time picker */
        CowBirthday = (EditText)rootView.findViewById(R.id.cow_birthday);
        CowBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar myCalendar = Calendar.getInstance();
                DatePickerDialog mdiDialog =new DatePickerDialog(getContext() ,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        CowBirthday.setText(year + "-" + (monthOfYear+1) + "-" + dayOfMonth);
                    }
                }, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH));
                mdiDialog.show();
            }
        });

        /*Spinner Muc dich nuoi*/
        cow_target = (Spinner)rootView.findViewById(R.id.cow_target_spinner);
        ArrayAdapter<String> adapterCowTarget = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, cowTarget);
        adapterCowTarget.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cow_target.setAdapter(adapterCowTarget);

        /*Bò đưc - bò cái*/
        final RadioButton male = (RadioButton) rootView.findViewById(R.id.cowMale);
        final RadioButton female = (RadioButton)rootView.findViewById(R.id.cowFemale);

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                female.setChecked(false);
                gender = "male";
            }
        });

        female.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                male.setChecked(false);
                gender = "female";
            }
        });

        /* Nguồn gốc */
        final RadioButton cowBorn = (RadioButton) rootView.findViewById(R.id.cowBorn);
        final RadioButton cowBuy = (RadioButton)rootView.findViewById(R.id.cowBuy);

        cowBorn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cowBuy.setChecked(false);
                source = "yes";
            }
        });


        cowBuy.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                cowBorn.setChecked(false);
                source = "no";
            }
        });

        /* Mother , Father */
        father = (EditText)rootView.findViewById(R.id.father_id);
        mother = (EditText)rootView.findViewById(R.id.mother_id);

        /* NFC Id*/
        nfcId = (EditText)rootView.findViewById(R.id.nfcId);
        qrId = (EditText)rootView.findViewById(R.id.qrId);

        btnNfcId = (Button)rootView.findViewById(R.id.btnNfcId);
        btnNfcId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return rootView;
    }

    public void getType() {
        CowService.getInstance().getCowType(new CowService.GetCowTypeCallBack() {
            @Override
            public void onSuccess(List<CowTypeResponse> cowTypeResponseList) {
                for( CowTypeResponse cowType : cowTypeResponseList){
                    giongbo.add(cowType.getName());
                    cow_type_spinner = (Spinner)rootView.findViewById(R.id.cow_type_spinner);
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, giongbo);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    cow_type_spinner.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(String errorCode) {

            }
        });
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button createCow = (Button)rootView.findViewById(R.id.btn_create);
        createCow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fatherId;
                if ( father.getText().toString() != null) {
                    fatherId = father.getText().toString();
                }else fatherId = "";

                String motherId;
                if ( mother.getText().toString() != null) {
                    motherId = mother.getText().toString();
                }else motherId = "";

                String nfc;
                if( nfcId.getText().toString() != null){
                    nfc = nfcId.getText().toString();
                }else nfc = "";

                String qr;
                if ( qrId.getText().toString() != null){
                    qr = qrId.getText().toString();
                }else qr = "";

                long target_id = cow_target.getSelectedItemId();
                switch ( (int)target_id){
                    case 0:
                        target = "meat";
                        break;
                    case 1:
                        target = "milk";
                        break;
                    case 2:
                        target = "born";
                        break;
                    default:
                        target = "meat";
                }
                CreateCowRequest createCowRequest = new CreateCowRequest(
                        Integer.valueOf(User.getInstance().getId()),
                        Integer.valueOf(fatherId),
                        Integer.valueOf(motherId),
                        Integer.valueOf(String.valueOf(cow_type_spinner.getSelectedItemId()+1)),
                        nfc,
                        qr,
                        gender,
                        CowBirthday.getText().toString(),
                        target,
                        source
                );
                CowService.getInstance().createCow(createCowRequest, new CowService.CreateCowCallBack() {
                    @Override
                    public void onSuccess() {

                        FragmentTransaction trans = getFragmentManager()
                                .beginTransaction();
                        trans.replace(R.id.root_frame, new FragmentListCow());
                        trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        trans.addToBackStack(null);
                        trans.commit();
                    }

                    @Override
                    public void onFailure(String errorCode) {
                        Log.d("Error",errorCode);
                        Toast.makeText(getContext(), errorCode, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
