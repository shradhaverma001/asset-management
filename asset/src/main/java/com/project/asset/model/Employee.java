package com.project.asset.model;
import javax.persistence.*;

@Entity
@Table
public class Employee {
    @Id
    @Column
    private int emp_id;
    @Column
    private String emp_name;
    @Column
    private String designation;


    @ManyToOne
    @JoinColumn(name = "Assets.asset_id")
    private Assets assets;

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

}
