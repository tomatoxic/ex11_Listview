package com.example.ex11_listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("리스트뷰 테스트");

//        final String[] midList = { "히어로즈","24시","로스트","로스트룸","스몰빌","탐정몽크",
//                "빅뱅이론","프렌즈","덱스터","글리","가쉽걸","테이큰","슈퍼내츄럴","브이"};

        final ArrayList<String> arrayList = new ArrayList<String>();

        ListView list = findViewById(R.id.listView1);

        // 어댑터뷰를 사용할 때 어댑터뷰의 모양을 설정하고 데이터를 채워주는
        // ArrayAdapter<T> 클래스를 함께 사용
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,arrayList);

        list.setAdapter(adapter);

        final EditText edtItem = findViewById(R.id.edtItem);
        Button btnAdd = findViewById(R.id.btnAdd);

        // 버튼 누르면 edtItem에 입력된 문자열을 아이템으로 추가
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add(edtItem.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        // 리스트에 있는 아이템을 길게 누르면 삭제
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrayList.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(),arrayList[i],
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}