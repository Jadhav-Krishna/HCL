package com.hcl.training;

public class Student {
    private int eno;
    private String name;
    private String branch;
    private double percentage;
    private int sem;
    
    public Student() {
    }
    
    public Student(int eno, String name, String branch, double percentage, int sem) {
        this.eno = eno;
        this.name = name;
        this.branch = branch;
        this.percentage = percentage;
        this.sem = sem;
    }
    
    public int getEno() {
        return eno;
    }
    
    public void setEno(int eno) {
        this.eno = eno;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getBranch() {
        return branch;
    }
    
    public void setBranch(String branch) {
        this.branch = branch;
    }
    
    public double getPercentage() {
        return percentage;
    }
    
    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
    
    public int getSem() {
        return sem;
    }
    
    public void setSem(int sem) {
        this.sem = sem;
    }
    
    @Override
    public String toString() {
        return eno + "\t" + name + "\t" + branch + "\t" + percentage + "\t" + sem;
    }
}
