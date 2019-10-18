package com.hqsoft.esales.trainee.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.hqsoft.esales.trainee.Model.Model_Customer;
import com.hqsoft.esales.trainee.Model.Model_Inventory;
import com.hqsoft.esales.trainee.Model.Model_SalesOrd;
import com.hqsoft.esales.trainee.Model.Model_SalesOrdDet;
import com.hqsoft.esales.trainee.Model.Model_Salesperson;

import java.util.ArrayList;

public class Sqlite extends SQLiteOpenHelper {
    private static int VERSION = 1;
    private Context context;

    public Sqlite(Context context) {
        super(context, String_Query.DATABASE_ESALES, null, VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //tao bang
        sqLiteDatabase.execSQL(String_Query.SQLQueryAR_Salesperson);
        sqLiteDatabase.execSQL(String_Query.SQLQueryAR_Customer);
        sqLiteDatabase.execSQL(String_Query.SQLQueryIN_Inventory);
        sqLiteDatabase.execSQL(String_Query.SQLQueryOM_SalesOrd);
        sqLiteDatabase.execSQL(String_Query.SQLQueryOM_SalesOrdDet);

        Log.d("ABC","create");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //Salesperson------------------------------------------------
    //add
    public void addSalesperson(Model_Salesperson model_salesperson){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();//put gia tri
        values.put(String_Query.SLSPERID, model_salesperson.getId());
        values.put(String_Query.PASSWORD, model_salesperson.getPassWord());
        values.put(String_Query.FULLNAME, model_salesperson.getFullName());
        values.put(String_Query.ADDRESS, model_salesperson.getAddress());

        db.insert(String_Query.TABLE_AR_SALESPERSON,null,values);
        db.close();
        Log.d("ABC","salesperson");
    }

    // Select Salesperson
    public Model_Salesperson getSalesperson(String name, String pass) {
        SQLiteDatabase db = this.getReadableDatabase();
        String quenry=String_Query.Select_Salesperson(name,pass);
        Cursor cursor;
        cursor = db.rawQuery(quenry,null);
        Model_Salesperson model_salesperson =new Model_Salesperson();
        try {
            cursor.moveToFirst();
            model_salesperson = new Model_Salesperson(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            cursor.close();
        } catch (Exception e) {

        }
        db.close();
        return model_salesperson;
    }

    //Customer--------------------------------------------------------
    //add Customer
    public void addCustomer(Model_Customer model_customer){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();//put gia tri
        values.put(String_Query.CUSTID, model_customer.getCusId());
        values.put(String_Query.NAME,model_customer.getCusName() );
        values.put(String_Query.ADDRESS_CUSTTOMER, model_customer.getCusAddress());
        values.put(String_Query.PHONE, model_customer.getCusSdt());

        db.insert(String_Query.TABLE_AR_CUSTOMER,null,values);
        db.close();
        Log.d("ABC","customer");
    }

    //select Customer
    public ArrayList<Model_Customer> getAllCustomer() {
        ArrayList<Model_Customer> arrayList = new ArrayList<Model_Customer>();
        String selectQuery = String_Query.Select_Customer();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Model_Customer model_customer=new Model_Customer();
                model_customer.setCusId(cursor.getString(0));
                model_customer.setCusName(cursor.getString(1));
                model_customer.setCusAddress(cursor.getString(2));
                model_customer.setCusSdt(cursor.getString(3));
                arrayList.add(model_customer);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return arrayList;
    }

    //select seach Customer
    public ArrayList<Model_Customer> SeachCustomer(String seach) {
        ArrayList<Model_Customer> arrayList = new ArrayList<Model_Customer>();
        String selectQuery = String_Query.Select_Seach_Customer(seach);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Model_Customer model_customer=new Model_Customer();
                model_customer.setCusId(cursor.getString(0));
                model_customer.setCusName(cursor.getString(1));
                model_customer.setCusAddress(cursor.getString(2));
                model_customer.setCusSdt(cursor.getString(3));
                arrayList.add(model_customer);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return arrayList;
    }

    //Inventory----------------------------------------------------------
    //add Inventory
    public void addInventory(Model_Inventory model_inventory){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();//put gia tri
        values.put(String_Query.INVTID, model_inventory.getInId());
        values.put(String_Query.NAME_INVT,model_inventory.getInName());
        values.put(String_Query.UNIT, model_inventory.getInUnit());
        values.put(String_Query.PRICE, model_inventory.getInPrice());

        db.insert(String_Query.TABLE_IN_INVENTORY,null,values);
        db.close();
        Log.d("ABC","Inventory");
    }

    //select Inventory
    public ArrayList<Model_Inventory> getAllInventory() {
        ArrayList<Model_Inventory> arrayList = new ArrayList<Model_Inventory>();
        String selectQuery = String_Query.Select_Inventory();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Model_Inventory model_inventory=new Model_Inventory();
                model_inventory.setInId(cursor.getString(0));
                model_inventory.setInName(cursor.getString(1));
                model_inventory.setInUnit(cursor.getString(2));
                model_inventory.setInPrice(cursor.getString(3));
                arrayList.add(model_inventory);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return arrayList;
    }

    //select seach Inventory
    public ArrayList<Model_Inventory> SeachInventory(String seach) {
        ArrayList<Model_Inventory> arrayList = new ArrayList<Model_Inventory>();
        String selectQuery = String_Query.Select_Seach_Inventory(seach);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Model_Inventory model_inventory=new Model_Inventory();
                model_inventory.setInId(cursor.getString(0));
                model_inventory.setInName(cursor.getString(1));
                model_inventory.setInUnit(cursor.getString(2));
                model_inventory.setInPrice(cursor.getString(3));
                arrayList.add(model_inventory);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return arrayList;
    }


    //SalesOrd-----------------------------------------------------------
    //add SalesOrd
    public void addSalesOrd(Model_SalesOrd model_salesOrd){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();//put gia tri
        values.put(String_Query.ORDERNBR, model_salesOrd.getOrderNbr());
        values.put(String_Query.SLSPER_ID,model_salesOrd.getSlsperID() );
        values.put(String_Query.CUST_ID, model_salesOrd.getCustID());
        values.put(String_Query.ORDAMT, model_salesOrd.getOrdAmt());
        values.put(String_Query.ORDQTY, model_salesOrd.getOrdQty());
        values.put(String_Query.ORDERDATE, model_salesOrd.getOrderDate());
        values.put(String_Query.REMARK, model_salesOrd.getRemark());

        db.insert(String_Query.TABLE_OM_SALESORD,null,values);
        db.close();
        Log.d("ABC","salesOrd");
    }

    //select salesOrd
    public ArrayList<Model_SalesOrd> getsalesOrd(String CustID) {
        ArrayList<Model_SalesOrd> arrayList = new ArrayList<Model_SalesOrd>();
        String selectQuery = String_Query.Select_SalesOrd(CustID);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Model_SalesOrd model_salesOrd=new Model_SalesOrd();
                model_salesOrd.setOrderNbr(cursor.getString(0));
                model_salesOrd.setSlsperID(cursor.getString(1));
                model_salesOrd.setCustID(cursor.getString(2));
                model_salesOrd.setOrdAmt(cursor.getString(3));
                model_salesOrd.setOrdQty(cursor.getString(4));
                model_salesOrd.setOrderDate(cursor.getString(5));
                model_salesOrd.setRemark(cursor.getString(6));

                arrayList.add(model_salesOrd);
            } while (cursor.moveToNext());
//            Log.d("ABC","");
        }
        cursor.close();
        db.close();
        return arrayList;
    }

    //select sum salesOrd
    public String getSumSalesOrd(String CustID) {
        String selectQuery = String_Query.Select_Sum_SalesOrd(CustID);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        String sum="";
        if (cursor.moveToFirst()) {
            do {
                sum=cursor.getString(0);
//                Log.d("ABC",sum);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return sum;
    }


    //SalesOrdDet--------------------------------------------------------
    //add SalesOrdDet
    public void addSalesOrdDet(Model_SalesOrdDet model_salesOrdDet){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();//put gia tri
        values.put(String_Query.ORDER_NBR, model_salesOrdDet.getOrderNbr());
        values.put(String_Query.LINEREF,model_salesOrdDet.getLineRef());
        values.put(String_Query.INVT_ID,model_salesOrdDet.getInvtID() );
        values.put(String_Query.LINEAMT, model_salesOrdDet.getLineAmt());
        values.put(String_Query.LINEQTY, model_salesOrdDet.getLineQty());

        db.insert(String_Query.TABLE_OM_SALESORDDET,null,values);
        db.close();
        Log.d("ABC","salesOrdDet");
    }

}
