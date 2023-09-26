package com.abayhq.login;

public class setJadwal {

    private String ruang;
    private String matkul;
    private String jam;

    public setJadwal(String ruang, String matkul, String jam){
        this.ruang = ruang;
        this.matkul = matkul;
        this.jam = jam;
    }

    public String getterRuang() {
        return ruang;
    }

    public void setterRuang(String ruang) {
        this.ruang = ruang;
    }

    public String getterMatkul() {
        return matkul;
    }

    public void setterMatkul(String matkul) {
        this.matkul = matkul;
    }

    public String getterJam() {
        return jam;
    }

    public void setterJam(String jam) {
        this.jam = jam;
    }


}
