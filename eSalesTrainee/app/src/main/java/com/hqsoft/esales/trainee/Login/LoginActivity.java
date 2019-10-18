package com.hqsoft.esales.trainee.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hqsoft.esales.trainee.Data.Sqlite;
import com.hqsoft.esales.trainee.KhachHang.Activity_KhachHang;
import com.hqsoft.esales.trainee.R;

public class LoginActivity extends AppCompatActivity {
    EditText edtdangnhap,edtmatkhau;
    Button btndangnhap,btnthoat;
    Sqlite sqlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Anhxa();
        sqlite=new Sqlite(this);

        //dang nhap
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String use=edtdangnhap.getText().toString();
                String pass=edtmatkhau.getText().toString();
                String returnPass=sqlite.getSalesperson(use,pass).getPassWord();

                if (kiemtra(use,pass)==true){
                    if(returnPass==null){
                        Toast.makeText(LoginActivity.this, "Chưa đúng vui lòng nhập lại", Toast.LENGTH_SHORT).show();
                    }else {
                        Intent intent=new Intent(LoginActivity.this, Activity_KhachHang.class);
                        startActivity(intent);
                    }
                }
            }
        });

        //thoat
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public boolean kiemtra(String use, String pass){
        boolean kiemtra = true;

        if(use.equals("")){
            Toast.makeText(this, "Chưa nhập tên", Toast.LENGTH_SHORT).show();
            kiemtra=false;
        }else if(pass.equals("")){
            Toast.makeText(this, "Chưa nhập mật khẩu", Toast.LENGTH_SHORT).show();
            kiemtra=false;
        }else {
            kiemtra=true;
        }

        return kiemtra;
    }

    private void Anhxa() {
        edtdangnhap=findViewById(R.id.edtDangNhap);
        edtmatkhau=findViewById(R.id.edtMatKhau);
        btndangnhap=findViewById(R.id.btnDangNhap);
        btnthoat=findViewById(R.id.btnThoat);
    }
}
