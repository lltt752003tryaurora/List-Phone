package com.example.advancedlistphone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //  khai báo mảng dữ liệu, adapter, listview;
    int image[] = {R.drawable.samsung, R.drawable.ip, R.drawable.htc, R.drawable.wp, R.drawable.lg, R.drawable.sky};
    String name[] = {"Điện thoại Sam Sung", "Điện thoại Iphone", "Điện thoại HTC", "Điện thoại Windowphone", "Điện thoại LG", "Điện thoại Sky"};
    String price[] = {"140$", "900$", "560$", "320$", "290$", "310$"};

    ArrayList<Phone> mylist; // Khai báo mảng chính, tí nữa thêm 2 mảng image và name vào
    MyArrayAdapter myadapter; //Khai báo Adapter
    ListView lv;//    khai báo listview

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);
        mylist = new ArrayList<>(); // tọa mới mảng rỗng
    //  đưa 3 mảng con image, name,price vào mảng rỗng này
        for (int i = 0; i < name.length; i++) {
            mylist.add(new Phone(image[i], name[i],price[i]));
        }
        myadapter = new MyArrayAdapter(MainActivity.this,R.layout.layout_item,mylist);
        lv.setAdapter(myadapter);
    //  xử lí click
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myintent = new Intent(MainActivity.this,SubActivity.class);
                myintent.putExtra("name",name[position]);
                startActivity(myintent);
            }
        });
    }
}