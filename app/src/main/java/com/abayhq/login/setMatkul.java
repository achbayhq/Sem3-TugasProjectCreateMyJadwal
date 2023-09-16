package com.abayhq.login;

public class setMatkul {
    private String idMatkul;
    private String Matkul;

    public setMatkul(String idMatkul, String Matkul){
        this.idMatkul = idMatkul;
        this.Matkul = Matkul;
    }

    public String getterIdMatkul() {
        return idMatkul;
    }

    public void setterIdMatkul(String idMatkul) {
        this.idMatkul = idMatkul;
    }

    public String getterMatkul() {
        return Matkul;
    }

    public void setterMatkul(String matkul) {
        this.Matkul = matkul;
    }
}
