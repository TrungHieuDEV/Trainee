package com.hqsoft.esales.trainee.DonHang;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.hqsoft.esales.trainee.Data.Sqlite;
import com.hqsoft.esales.trainee.Model.Model_SalesOrd;
import com.hqsoft.esales.trainee.MuaHang.ActivityMuaHang;
import com.hqsoft.esales.trainee.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class DonHangActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    TextView tvtong,tvgetDate;
    ImageView imggetDate;
    Toolbar toolbarDonHang;
    RecyclerView recyclerViewDonHang;
    LinearLayoutManager layoutManager;
    Adapter_DonHang adapter_donHang;
    ArrayList<Model_SalesOrd> arrayListDH;
    Sqlite sqlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_don_hang);
        Anhxa();

        Intent intent=getIntent();
        String id=intent.getStringExtra("CustID");
        sqlite=new Sqlite(this);
        //gan data vao arr
        arrayListDH=sqlite.getsalesOrd(id);
        //lay tong
        String tong=sqlite.getSumSalesOrd(id);
        tvtong.setText(tong);

        setSupportActionBar(toolbarDonHang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Danh Sách Đơn Hàng");
        toolbarDonHang.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //get date
        imggetDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Fragment_DatePicker fragment_datePicker=new Fragment_DatePicker();
               fragment_datePicker.show(getSupportFragmentManager(),"date picker");
            }
        });

        GanData();
    }

    //gan data
    public void GanData(){
        recyclerViewDonHang.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewDonHang.setLayoutManager(layoutManager);

        if (adapter_donHang==null) {
            adapter_donHang = new Adapter_DonHang(getApplicationContext(), arrayListDH);
            recyclerViewDonHang.setAdapter(adapter_donHang);
        }else {
            adapter_donHang.notifyDataSetChanged();
        }
    }

    //menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.add){
            Intent intent=new Intent(DonHangActivity.this, ActivityMuaHang.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    //data picker
    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);
        calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString=simpleDateFormat.format(calendar.getTime());
        tvgetDate.setText(dateString);
//        Log.d("ABC", "");
    }

    public void Anhxa(){
        toolbarDonHang=findViewById(R.id.toolBar_DonHang);
        recyclerViewDonHang=findViewById(R.id.recyclerView_DonHang);
        tvtong=findViewById(R.id.tvTong);
        tvgetDate=findViewById(R.id.tvGetDate);
        imggetDate=findViewById(R.id.imgGetDate);
    }
}
