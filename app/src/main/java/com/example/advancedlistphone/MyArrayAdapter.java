package com.example.advancedlistphone;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<Phone> {
    //  khai báo 3 biến ứng với 3 thông số để xây dựng adapter
    Activity context;
    int idlayout; // layout nằm trong thư mục res
    ArrayList<Phone> mylist;
    // tạo constructor để MainActivity gọi đến và truyền các tham số vào


    public MyArrayAdapter(Activity context, int idLayout, ArrayList<Phone> mylist) {
        super(context, idLayout, mylist);
        this.context = context;
        this.idlayout = idLayout;
        this.mylist = mylist;
    }

    //  Gọi hàm getView để tiến hành sắp xếp dữ liệu
    //  vai trò adapter lấy dữ liệu trong mảng ra và sắp xếp layout rồi trả về cho list view để hiển thị

    //  Mô tả: các dữ liệu trong mảng được lấy ra (layout) sẽ được đặt vào trong một cái layoutInflater để tạo thành view, rồi mới đưa qua list view để hiển thị cho người dùng thấy


    // gõ getView
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    //  tạo ra layoutInflater để chứa layout
        LayoutInflater myflater = context.getLayoutInflater();
    //  đặt layout vào layoutInflater để tạo thành đối tượng View
        convertView = myflater.inflate(idlayout, null);
    //  lấy 1 phần tử trong mảng đặt vào inflater

        // Đặt màu cho convertView dựa vào vị trí của item
        if (position % 2 == 0) {
            convertView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorItemEven));
        } else {
            convertView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorLightYellow));
        }

        Phone myphone = mylist.get(position); //position vị trí index của mảng đi từ 0-> ptu cuối cùng
    //  khai báo, tham chiếu id và hiển thị ảnh lên ImageView, layout đang nằm trong đối tượng covertView nên ta sẽ tham chiếu tới
        ImageView img_phone = convertView.findViewById(R.id.img_phone);
        img_phone.setImageResource(myphone.getImage());// ảnh sẽ lấy ở trong myphone
    //  khai báo, tham chiếu id và hiển thị tên điện thoại lên TextView
        TextView txt_phone = convertView.findViewById(R.id.txt_phone);
        txt_phone.setText(myphone.getName());
        TextView txt_price = convertView.findViewById(R.id.txt_price);
        txt_price.setText(myphone.getPrice());
        return convertView;
    }
}
