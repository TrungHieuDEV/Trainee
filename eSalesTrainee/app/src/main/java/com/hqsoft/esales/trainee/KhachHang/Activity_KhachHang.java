package com.hqsoft.esales.trainee.KhachHang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.hqsoft.esales.trainee.Data.Sqlite;
import com.hqsoft.esales.trainee.Model.Model_Customer;
import com.hqsoft.esales.trainee.R;

import java.util.ArrayList;

public class Activity_KhachHang extends AppCompatActivity {

    EditText edtseachCustomer;
    Toolbar toolbarKhachHang;
    RecyclerView recyclerViewKhachHang;
    LinearLayoutManager layoutManager;
    ArrayList<Model_Customer> arrayListKH;
    Adapter_KhachHang adapter_khachHang;
    Sqlite sqlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khach_hang);
        Anhxa();
        sqlite=new Sqlite(this);
        arrayListKH=sqlite.getAllCustomer();

        //actionBar
        setSupportActionBar(toolbarKhachHang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle("Danh Sách Khách Hàng");
        getSupportActionBar().setIcon(null);

        //tim khach hang
        edtseachCustomer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String seach=charSequence.toString();
                if(seach.equals("")){
                    arrayListKH.clear();
                    arrayListKH.addAll(sqlite.getAllCustomer());
                    adapter_khachHang.notifyDataSetChanged();
                }else {
                    arrayListKH.clear();
                    arrayListKH.addAll(sqlite.SeachCustomer(seach));
                    adapter_khachHang.notifyDataSetChanged();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        GanData();
    }

    //Gan noi dung vao recyclerView
    public void GanData(){
        recyclerViewKhachHang.setHasFixedSize(true);//toi uu noi dung
        layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewKhachHang.setLayoutManager(layoutManager);

        if(adapter_khachHang==null){
            adapter_khachHang=new Adapter_KhachHang(getApplicationContext(),arrayListKH);
            recyclerViewKhachHang.setAdapter(adapter_khachHang);
        }else {
            adapter_khachHang.notifyDataSetChanged();
        }
    }

    public void Anhxa(){
        toolbarKhachHang=findViewById(R.id.toolBar_khachhang);
        recyclerViewKhachHang=findViewById(R.id.recyclerView_KhachHang);
        edtseachCustomer=findViewById(R.id.edtSeachCustomer);
    }
}
