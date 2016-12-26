package vn.edu.uit.quanlybo.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.ArrayList;
import java.util.List;

import vn.edu.uit.quanlybo.Adapter.CowDetailToDoAdapter;
import vn.edu.uit.quanlybo.Adapter.ListCowToDoAdapter;
import vn.edu.uit.quanlybo.Model.Cow;
import vn.edu.uit.quanlybo.Model.CowDetail.CurrentToDo;
import vn.edu.uit.quanlybo.Model.ListCowToDo.ToDoHeader;
import vn.edu.uit.quanlybo.Model.ListCowToDo.ToDoItem;
import vn.edu.uit.quanlybo.Model.User;
import vn.edu.uit.quanlybo.Network.CowService;
import vn.edu.uit.quanlybo.Network.Model.CowDetailResponse;
import vn.edu.uit.quanlybo.Network.ToDoService;
import vn.edu.uit.quanlybo.R;

/**
 * Created by phuc9 on 10/29/2016.
 */

public class CowDetailActivity extends Activity {
    Cow cow = new Cow();
    Toolbar toolbar;

    TextView cow_id;
    TextView cow_type;
    TextView cow_gender;
    TextView cow_father;
    TextView cow_mother;
    TextView cow_target;
    TextView cow_born;
    TextView cow_source;
    RecyclerView toDoList;
    String cow_id_intent;
    CowDetailToDoAdapter adapter;
    final List<ParentListItem> parentListItems = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cow_detail);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if( bundle != null) {
            cow_id_intent = (String) bundle.get("cow_id");
        }

        initData();
        cow_id = (TextView)findViewById(R.id.cow_detail_id);
        cow_type = (TextView)findViewById(R.id.cow_detail_type);
        cow_gender = (TextView)findViewById(R.id.cow_detail_gender);
        cow_father = (TextView)findViewById(R.id.cow_detail_father);
        cow_mother = (TextView)findViewById(R.id.cow_detail_mother);
        cow_target = (TextView)findViewById(R.id.cow_detail_target);
        cow_born = (TextView)findViewById(R.id.cow_detail_born);
        cow_source = (TextView)findViewById(R.id.cow_detail_source);
        initTodoList();
        initToolBar();

    }

    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle("Thông tin chi tiết");
        setActionBar(toolbar);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            }
        );
    }


    public void initTodoList(){
        toDoList = (RecyclerView)findViewById(R.id.cow_detail_list_to_do);

    }

    public void initData(){
        CowService.getInstance().getCowDetail(User.getInstance().getId(), cow_id_intent, new CowService.CowDetailCallBack() {
            @Override
            public void onSuccess(CowDetailResponse cowDetailResponse) {
                cow = cowDetailResponse.getCow();
                String father;
                String mother;
                if ( cow.getFather() == null){
                    father = "";
                }else {
                    father = cow.getFather().toString();
                }

                if ( cow.getMother() == null){
                    mother = "";
                }else {
                    mother = cow.getFather().toString();
                }
                cow_id.setText("#" + cow.getId());
                cow_type.setText("Giống bò : " + cow.getTypeName());
                cow_gender.setText("Giới tính : " + cow.getGenderName());
                cow_father.setText("Bò cha : " + father);
                cow_mother.setText("Bò mẹ : " +  mother);
                cow_target.setText("Mục đích nuôi : " + cow.getTargetName());
                cow_born.setText("Ngày sinh : " + cow.getBirthday());
                cow_source.setText("Nguồn gốc: " + cow.getSourceName());
                List<CurrentToDo> currentToDoList = cowDetailResponse.getCurrentToDoList();
                if ( cowDetailResponse.getCurrentToDoList() != null) {
                    for (CurrentToDo currentToDo : cowDetailResponse.getCurrentToDoList()) {
                        currentToDo.getChildItemList();
                        parentListItems.add(currentToDo);
                    }
                    adapter = new CowDetailToDoAdapter(getParent(), getBaseContext(), parentListItems);
                    toDoList.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                    toDoList.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(String errorCode) {
                Toast.makeText(CowDetailActivity.this, errorCode, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
