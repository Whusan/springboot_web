package com.exemple.demo.entity;

/**
 * @author 94826
 */
public class Mtype {

    private String tam;
    private Integer nums;

    public Mtype(String tam, Integer nums) {
        this.tam = tam;
        this.nums = nums;
    }

    public Mtype() {
    }

    public String getTam() {
        return tam;
    }

    public void setTam(String tam) {
        this.tam = tam;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }
}
