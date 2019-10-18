package com.hqsoft.esales.trainee.MuaHang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hqsoft.esales.trainee.MatHang.Fragment_MatHang;
import com.hqsoft.esales.trainee.Model.Model_MuaHang;
import com.hqsoft.esales.trainee.R;

import java.util.ArrayList;

public class ActivityMuaHang extends AppCompatActivity implements Fragment_MatHang.Listener{

    Button themMH;

    Toolbar toolbarMuaHang;
    RecyclerView recyclerViewMuaHang;
    LinearLayoutManager layoutManager;
    Adapter_MuaHang adapter_muaHang;
    ArrayList<Model_MuaHang> arrayList;

    @Override
    public void sendData(String id, String name) {
        Log.d("ABC",id+":"+name);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mua_hang);
        Anhxa();

        //toolbar
        setSupportActionBar(toolbarMuaHang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Mua Hàng");
        toolbarMuaHang.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //them data
        AddData();

        themMH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_MatHang fragment_matHang=new Fragment_MatHang();
                fragment_matHang.setCancelable(false);
                fragment_matHang.show(getSupportFragmentManager(), "dialog");
            }
        });
    }

    public void AddData(){
        recyclerViewMuaHang.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewMuaHang.setLayoutManager(layoutManager);
        arrayList=new ArrayList<>();

        arrayList.add(new Model_MuaHang("1","cd678","danh rang","2000","4","10000"));
        arrayList.add(new Model_MuaHang("2","cd678","danh rang","2000","5","10000"));
        arrayList.add(new Model_MuaHang("3","cd678","danh rang","2000","5","10000"));
        arrayList.add(new Model_MuaHang("4","cd678","danh rang","2000","5","10000"));
        arrayList.add(new Model_MuaHang("5","cd678","danh rang","2000","5","10000"));

        if(adapter_muaHang==null) {
            adapter_muaHang = new Adapter_MuaHang(getApplicationContext(), arrayList);
            recyclerViewMuaHang.setAdapter(adapter_muaHang);
        }else {
            adapter_muaHang.notifyDataSetChanged();
        }
    }

    public void Anhxa(){
        toolbarMuaHang=findViewById(R.id.toolBar_MuaHang);
        recyclerViewMuaHang=findViewById(R.id.recyclerView_MuaHang);
        themMH=findViewById(R.id.themMatHang);
    }

}
