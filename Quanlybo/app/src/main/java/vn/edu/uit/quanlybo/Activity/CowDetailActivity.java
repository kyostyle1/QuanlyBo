package vn.edu.uit.quanlybo.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.ArrayList;
import java.util.List;

import vn.edu.uit.quanlybo.Adapter.ListCowToDoAdapter;
import vn.edu.uit.quanlybo.Model.Cow;
import vn.edu.uit.quanlybo.Model.ListCowToDo.ToDoHeader;
import vn.edu.uit.quanlybo.Model.ListCowToDo.ToDoItem;
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
    RecyclerView toDoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cow_detail);
        cow = (Cow) getIntent().getSerializableExtra("cow_position");

        toDoList = (RecyclerView)findViewById(R.id.cow_detail_list_to_do);

        cow_id = (TextView)findViewById(R.id.cow_detail_id);
        cow_type = (TextView)findViewById(R.id.cow_detail_type);
        cow_gender = (TextView)findViewById(R.id.cow_detail_gender);
        cow_father = (TextView)findViewById(R.id.cow_detail_father);
        cow_mother = (TextView)findViewById(R.id.cow_detail_mother);
        cow_target = (TextView)findViewById(R.id.cow_detail_target);
        cow_born = (TextView)findViewById(R.id.cow_detail_born);
        initTodoList();
        initToolBar();
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
        cow_type.setText("Giống bò : " + cow.getTypeId().toString());
        cow_gender.setText("Giới tính : " + cow.getGender());
        cow_father.setText("Bò cha : " + father);
        cow_mother.setText("Bò mẹ : " +  mother);
        cow_target.setText("Mục đích nuôi : " + cow.getTarget());
        cow_born.setText("Ngày sinh : " + cow.getBirthday());

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


    public void initTodoList(){}


}
