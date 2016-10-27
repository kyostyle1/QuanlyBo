package vn.edu.uit.quanlybo.Fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.Calendar;

import vn.edu.uit.quanlybo.R;

/**
 * Created by phuc9 on 10/19/2016.
 */
public class FragmentCreateCow extends Fragment {
    String giongbo[]={
            "Bò sữa",
            "Bò nhà",
            "Bò shin"
    };

    String cowTarget[]= {
            "Nuôi lấy thịt",
            "Nuôi lấy sữa",
            "Nuôi để đẻ"
    };

    private EditText CowBirthday;
    private Button btnNfcId;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_create_cow, container, false);

        /*Spinner Giong bo*/
        Spinner cow_type_spinner = (Spinner)rootView.findViewById(R.id.cow_type_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, giongbo);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cow_type_spinner.setAdapter(adapter);

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
        Spinner cow_target = (Spinner)rootView.findViewById(R.id.cow_target_spinner);
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
            }
        });

        female.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                male.setChecked(false);
            }
        });

        /* Nguồn gốc */
        final RadioButton cowBorn = (RadioButton) rootView.findViewById(R.id.cowBorn);
        final RadioButton cowBuy = (RadioButton)rootView.findViewById(R.id.cowBuy);

        cowBorn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cowBuy.setChecked(false);
            }
        });

        cowBuy.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                cowBorn.setChecked(false);
            }
        });

        /* NFC Id*/
        btnNfcId = (Button)rootView.findViewById(R.id.btnNfcId);
        btnNfcId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return rootView;
    }
}
