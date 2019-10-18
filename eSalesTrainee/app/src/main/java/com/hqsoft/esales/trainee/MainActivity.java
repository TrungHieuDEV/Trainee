package com.hqsoft.esales.trainee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hqsoft.esales.trainee.Data.Sqlite;
import com.hqsoft.esales.trainee.Model.Model_Customer;
import com.hqsoft.esales.trainee.Model.Model_Inventory;
import com.hqsoft.esales.trainee.Model.Model_SalesOrd;
import com.hqsoft.esales.trainee.Model.Model_SalesOrdDet;
import com.hqsoft.esales.trainee.Model.Model_Salesperson;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText t1,t2,t3,t4,t5,t6,t7;
    Button btnThem;
    Sqlite sqlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.ido1);
        t2=findViewById(R.id.ido2);
        t3=findViewById(R.id.ido3);
        t4=findViewById(R.id.ido4);
        t5=findViewById(R.id.ido5);
        t6=findViewById(R.id.ido6);
        t7=findViewById(R.id.ido7);
        btnThem=findViewById(R.id.them);
        sqlite=new Sqlite(this);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Model_Salesperson model_salesperson=Salesperson();
                Model_Customer model_customer=DataCustomer();
                Model_Inventory model_inventory=DataInventory();
                Model_SalesOrd model_salesOrd=DataSalesOrd();
                Model_SalesOrdDet model_salesOrdDet=DataSalesOrdDet();

                if(model_salesperson!= null){
                    sqlite.addSalesperson(model_salesperson);
                }
            }
        });
    }

    //tao bang va put data Salesperson
    public Model_Salesperson Salesperson(){
        String id=t1.getText().toString();
        String pass=t2.getText().toString();
        String name=t3.getText().toString();
        String address=t4.getText().toString();

        Model_Salesperson model_salesperson=new Model_Salesperson(id,pass,name,address);
        return model_salesperson;
  }


 //tao bang va put data Customer
    public Model_Customer DataCustomer(){
        String cusid=t1.getText().toString();
        String cusname=t2.getText().toString();
        String cusaddress=t3.getText().toString();
        String cussdt=t4.getText().toString();

        Model_Customer model_customer=new Model_Customer(cusid,cusname,cusaddress,cussdt);
        return model_customer;
    }

    //tao va add Inventory
    public Model_Inventory DataInventory(){
        String id=t1.getText().toString();
        String name=t2.getText().toString();
        String unit=t3.getText().toString();
        String price=t4.getText().toString();

        Model_Inventory model_inventory=new Model_Inventory(id,name,unit,price);
        return model_inventory;
    }


    //tao va add SalesOrd
    public Model_SalesOrd DataSalesOrd() {
        Calendar c = Calendar.getInstance();
        String date = c.get(Calendar.YEAR)+"-" + c.get(Calendar.MONTH)+"-" + c.get(Calendar.DATE);

        String OrderNbr = t1.getText().toString();
        String SlsperID = t2.getText().toString();
        String CustID = t3.getText().toString();
        String OrdAmt = t4.getText().toString();
        String OrdQty = t5.getText().toString();
        String Remark = t7.getText().toString();

        Model_SalesOrd model_salesOrd = new Model_SalesOrd(OrderNbr, SlsperID, CustID, OrdAmt,OrdQty,date,Remark);
        return model_salesOrd;
    }

    //tao va add SalesOrdDet
    public Model_SalesOrdDet DataSalesOrdDet() {
        String OrderNbr = t1.getText().toString();
        String LineRef = t2.getText().toString();
        String InvtID = t3.getText().toString();
        String LineAmt = t4.getText().toString();
        String LineQty = t5.getText().toString();

        Model_SalesOrdDet model_salesOrdDet = new Model_SalesOrdDet(OrderNbr, LineRef, InvtID, LineAmt,LineQty);
        return model_salesOrdDet;
    }

}
