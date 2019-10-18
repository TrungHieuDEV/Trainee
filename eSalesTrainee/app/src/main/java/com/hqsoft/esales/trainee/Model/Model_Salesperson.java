package com.hqsoft.esales.trainee.Model;

public class Model_Salesperson {
    String id,passWord,fullName,address;

    public Model_Salesperson(String id, String passWord, String fullName, String address) {
        this.id = id;
        this.passWord = passWord;
        this.fullName = fullName;
        this.address = address;
    }

    public Model_Salesperson() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
