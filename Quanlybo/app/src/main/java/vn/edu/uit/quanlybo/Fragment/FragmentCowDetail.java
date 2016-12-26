package vn.edu.uit.quanlybo.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.ArrayList;
import java.util.List;

import vn.edu.uit.quanlybo.Adapter.CowDetailToDoAdapter;
import vn.edu.uit.quanlybo.Model.Cow;
import vn.edu.uit.quanlybo.Model.CowDetail.CurrentToDo;
import vn.edu.uit.quanlybo.Model.User;
import vn.edu.uit.quanlybo.Network.CowService;
import vn.edu.uit.quanlybo.Network.Model.CowDetailResponse;
import vn.edu.uit.quanlybo.R;

public class FragmentCowDetail extends Fragment {
    private View rootView;
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
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_cow_detail, container, false);
        Bundle bundle = this.getArguments();
        if( bundle != null) {
            cow_id_intent = (String) bundle.get("cow_id");
        }
        initData();
        cow_id = (TextView)rootView.findViewById(R.id.cow_detail_id);
        cow_type = (TextView)rootView.findViewById(R.id.cow_detail_type);
        cow_gender = (TextView)rootView.findViewById(R.id.cow_detail_gender);
        cow_father = (TextView)rootView.findViewById(R.id.cow_detail_father);
        cow_mother = (TextView)rootView.findViewById(R.id.cow_detail_mother);
        cow_target = (TextView)rootView.findViewById(R.id.cow_detail_target);
        cow_born = (TextView)rootView.findViewById(R.id.cow_detail_born);
        cow_source = (TextView)rootView.findViewById(R.id.cow_detail_source);
        initTodoList();
        return rootView;
    }

    public void initTodoList(){
        toDoList = (RecyclerView)rootView.findViewById(R.id.cow_detail_list_to_do);

    }

    public void initData() {
        CowService.getInstance().getCowDetail(User.getInstance().getId(), cow_id_intent, new CowService.GetCowDetailByNfc() {
            @Override
            public void onSuccess(Boolean isCheck, CowDetailResponse cowDetailResponse) {
                cow = cowDetailResponse.getCow();
                String father;
                String mother;
                if (cow.getFather() == null) {
                    father = "";
                } else {
                    father = cow.getFather().toString();
                }

                if (cow.getMother() == null) {
                    mother = "";
                } else {
                    mother = cow.getFather().toString();
                }
                cow_id.setText("Thông tin chi biết bò:  #" + cow.getId());
                cow_type.setText("Giống bò : " + cow.getTypeName());
                cow_gender.setText("Giới tính : " + cow.getGenderName());
                cow_father.setText("ID bò cha : #" + father);
                cow_mother.setText("ID bò mẹ : #" + mother);
                cow_target.setText("Mục đích nuôi : " + cow.getTargetName());
                cow_born.setText("Ngày sinh : " + cow.getBirthday());
                cow_source.setText("Nguồn gốc: " + cow.getSourceName());
                List<CurrentToDo> currentToDoList = cowDetailResponse.getCurrentToDoList();
                if (cowDetailResponse.getCurrentToDoList() != null) {
                    for (CurrentToDo currentToDo : cowDetailResponse.getCurrentToDoList()) {
                        currentToDo.getChildItemList();
                        parentListItems.add(currentToDo);
                    }
                    adapter = new CowDetailToDoAdapter(getActivity(), getContext(), parentListItems);
                    toDoList.setLayoutManager(new LinearLayoutManager(getActivity()));
                    toDoList.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(String errorCode) {

            }
        });
    }

}

