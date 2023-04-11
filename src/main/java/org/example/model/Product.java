package org.example.model;

import java.io.Serializable;


public class Product implements Serializable {

    private int ID;
    private String NAME;
    private Integer COUNT;
    private Integer PRICE;
    private String DESCRIPTION;
    private Integer CATEGORY;
    private Boolean IS_ACTIVE;


    public int getId() {
        return ID;
    }

    public String getNAME() {
        return NAME;
    }

    public Integer getCOUNT() {
        return COUNT;
    }

    public Integer getPRICE() {
        return PRICE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public Integer getCATEGORY() {
        return CATEGORY;
    }

    public Boolean getIS_ACTIVE() {
        return IS_ACTIVE;
    }

    public void setId(int ID) {
        this.ID = ID;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setCOUNT(Integer COUNT) {
        this.COUNT = COUNT;
    }

    public void setPRICE(Integer PRICE) {
        this.PRICE = PRICE;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public void setCATEGORY(Integer CATEGORY) {
        this.CATEGORY = CATEGORY;
    }

    public void setIS_ACTIVE(Boolean IS_ACTIVE) {
        this.IS_ACTIVE = IS_ACTIVE;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID=" + ID +
                ", NAME='" + NAME + '\'' +
                ", COUNT=" + COUNT +
                ", PRICE=" + PRICE +
                ", DESCRIPTION='" + DESCRIPTION + '\'' +
                ", CATEGORY=" + CATEGORY +
                ", IS_ACTIVE=" + IS_ACTIVE +
                '}';
    }
}
