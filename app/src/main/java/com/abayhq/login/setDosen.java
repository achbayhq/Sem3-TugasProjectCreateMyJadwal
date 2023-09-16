package com.abayhq.login;

public class setDosen {
    private int imgDosen;
    private String nmDosen;

    public setDosen(int imgDosen, String nmDosen){
        this.imgDosen = imgDosen;
        this.nmDosen = nmDosen;
    }

    public int getterimgDosen() {
        return imgDosen;
    }

    public void setterimgDosen(int imgDosen) {
        this.imgDosen = imgDosen;
    }

    public String getterDosen() {
        return nmDosen;
    }

    public void setterDosen(String nmDosen) {
        this.nmDosen = nmDosen;
    }
}
