package com.hqsoft.esales.trainee.Data;

public class String_Query {
    public static final String DATABASE_ESALES ="eSales1.db3";
    //AR_Salesperson------------------------------------------------------------
    public static final String TABLE_AR_SALESPERSON ="AR_Salesperson";
    public static final String SLSPERID ="SLsperID";
    public static final String PASSWORD ="password";
    public static final String FULLNAME ="FullName";
    public static final String ADDRESS ="Address";

    //create
    public static final String SQLQueryAR_Salesperson="CREATE TABLE "+TABLE_AR_SALESPERSON +" (" +
            SLSPERID +" TEXT PRIMARY KEY NOT NULL, "+
            PASSWORD + " TEXT NOT NULL, "+
            FULLNAME +" TEXT NOT NULL, "+
            ADDRESS+" TEXT NOT NULL)";

    //select
    public static String Select_Salesperson(String name, String pass){
        String Select_Salesperson="SELECT * FROM `"+TABLE_AR_SALESPERSON+"` WHERE `"+FULLNAME+"`='"+name+"' AND `"+PASSWORD+"`='"+pass+"'";
        return Select_Salesperson;
    }

    //AR_Customer----------------------------------------------------------------
    public static final String TABLE_AR_CUSTOMER ="AR_Customer";
    public static final String CUSTID ="CustID";
    public static final String NAME ="Name";
    public static final String ADDRESS_CUSTTOMER ="Address";
    public static final String PHONE ="Phone";

    //create
    public static final String SQLQueryAR_Customer="CREATE TABLE "+TABLE_AR_CUSTOMER +" (" +
            CUSTID +" TEXT PRIMARY KEY NOT NULL, "+
            NAME + " TEXT NOT NULL, "+
            ADDRESS_CUSTTOMER +" TEXT NOT NULL, "+
            PHONE+" TEXT NOT NULL)";

    //select
    public static String Select_Customer(){
        String Select_Customer="SELECT * FROM `"+TABLE_AR_CUSTOMER+"`";
        return Select_Customer;
    }

    //select seach
    public static String Select_Seach_Customer(String seach){
        String Select_Seach_Customer="SELECT * FROM `"+TABLE_AR_CUSTOMER+"` WHERE " +
                "`"+CUSTID+"` lIKE '%"+seach+"%' OR `"+NAME+"` LIKE '%"+seach+"%' OR `"+ADDRESS_CUSTTOMER+"` LIKE '%"+seach+"%' " +
                "OR `"+PHONE+"` LIKE '%"+seach+"%'";
        return Select_Seach_Customer;
    }

    //IN_Inventory------------------------------------------------------------------
    public static final String TABLE_IN_INVENTORY ="IN_Inventory";
    public static final String INVTID ="InvtID";
    public static final String NAME_INVT ="Name";
    public static final String UNIT ="Unit";
    public static final String PRICE ="Price";

    public static final String SQLQueryIN_Inventory="CREATE TABLE "+TABLE_IN_INVENTORY +" (" +
            INVTID +" TEXT PRIMARY KEY NOT NULL, "+
            NAME_INVT + " TEXT NOT NULL, "+
            UNIT +" TEXT NOT NULL, "+
            PRICE+" TEXT NOT NULL)";

    //select
    public static String Select_Inventory(){
        String Select_Inventory="SELECT * FROM `"+TABLE_IN_INVENTORY+"`";
        return Select_Inventory;
    }

    //select seach
    public static String Select_Seach_Inventory(String seach){
        String Select_Seach_Inventory="SELECT * FROM `"+TABLE_IN_INVENTORY+"`" +
                "WHERE `"+INVTID+"` like'%"+seach+"%' OR `"+NAME_INVT+"`like'%"+seach+"%' OR `"+PRICE+"`='"+seach+"'";
        return Select_Seach_Inventory;
    }

    //OM_Salesord----------------------------------------------------------------------------------
    public static final String TABLE_OM_SALESORD ="OM_SalesOrd";
    public static final String ORDERNBR="OrderNbr";
    public static final String SLSPER_ID ="SLsperID";
    public static final String CUST_ID ="CustID";
    public static final String ORDAMT ="OrdAmt";
    public static final String ORDQTY ="OrdQty";
    public static final String ORDERDATE ="OrderDate";
    public static final String REMARK ="Remark";

    public static final String SQLQueryOM_SalesOrd="CREATE TABLE "+TABLE_OM_SALESORD +" (" +
            ORDERNBR +" TEXT PRIMARY KEY NOT NULL, "+
            SLSPER_ID + " TEXT NOT NULL, "+
            CUST_ID +" TEXT NOT NULL, "+
            ORDAMT +" REAL NOT NULL, "+
            ORDQTY +" REAL NOT NULL, "+
            ORDERDATE +" DATE NOT NULL, "+
            REMARK +" TEXT NOT NULL, " +
            "FOREIGN KEY (`"+SLSPER_ID+"`) REFERENCES `"+TABLE_AR_SALESPERSON+"`(`"+SLSPERID+"`)," +
            "FOREIGN KEY (`"+CUST_ID+"`) REFERENCES `"+TABLE_AR_CUSTOMER+"` (`"+CUSTID+"`))";

    //select
    public static String Select_SalesOrd(String CustID){
        String Select_SalesOrd="SELECT * FROM `"+TABLE_OM_SALESORD+"` WHERE `"+CUST_ID+"`='"+CustID+"'";
        return Select_SalesOrd;
    }

    //select sum
    public static String Select_Sum_SalesOrd(String CustID){
        String Select_SalesOrd="SELECT SUM(`"+ORDAMT+"`) FROM `"+TABLE_OM_SALESORD+"` WHERE `"+CUST_ID+"`='"+CustID+"'";
        return Select_SalesOrd;
    }

    //OM_SalesOrdDet----------------------------------------------------------------------------------
    public static final String TABLE_OM_SALESORDDET ="OM_SalesOrdDet";
    public static final String ORDER_NBR="OrderNbr";
    public static final String LINEREF ="LineRef";
    public static final String INVT_ID ="InvtID";
    public static final String LINEAMT ="LineAmt";
    public static final String LINEQTY ="LineQty";

    public static final String SQLQueryOM_SalesOrdDet="CREATE TABLE "+TABLE_OM_SALESORDDET +" (" +
            LINEREF + " TEXT PRIMARY KEY NOT NULL, "+
            ORDER_NBR +" TEXT NOT NULL, "+
            INVT_ID +" TEXT NOT NULL, "+
            LINEAMT +" REAL NOT NULL, "+
            LINEQTY +" REAL NOT NULL, " +
            "FOREIGN KEY (`"+ORDER_NBR+"`) REFERENCES `"+TABLE_OM_SALESORD+"` (`"+ORDERNBR+"`)," +
            "FOREIGN KEY (`"+INVT_ID+"`) REFERENCES `"+TABLE_IN_INVENTORY+"` (`"+INVTID+"`))";
}
