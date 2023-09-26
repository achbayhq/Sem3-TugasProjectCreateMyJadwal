package com.abayhq.login;

public class setIPK {

    private String matkul;
    private String predikat;
    private String nilai;

    public setIPK(String matkul, String predikat, String nilai){
        this.matkul = matkul;
        this.predikat = predikat;
        this.nilai = nilai;
    }

    public String getterMatkulIPK() {
        return matkul;
    }

    public void setterMatkulIPK(String matkul) {
        this.matkul = matkul;
    }

    public String getterPredikat() {
        return predikat;
    }

    public void setterPredikat(String predikat) {
        this.predikat = predikat;
    }
    public String getterNilai() {
        return nilai;
    }

    public void setterNilai(String nilai) {
        this.nilai = nilai;
    }
}
