package com.project.asset.model;
import com.project.asset.shared.AssignStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Assets {
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int asset_id;

    @Column
    private String asset_name;

    @Column
    private Date purchase_date;

    @Column
    private AssignStatus assignStatus;

    @ManyToOne
    @JoinColumn(name = "emp_id", nullable = true)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public int getAsset_id() {
        return asset_id;
    }

    public void setAsset_id(int asset_id) {
        this.asset_id = asset_id;
    }

    public String getAsset_name() {
        return asset_name;
    }

    public void setAsset_name(String asset_name) {
        this.asset_name = asset_name;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public AssignStatus getAssignStatus() {
        return assignStatus;
    }

    public void setAssignStatus(AssignStatus assignStatus) {
        this.assignStatus = assignStatus;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setEmployee(Employee employee){
        this.employee = employee;
    }

    public Employee getEmployee() {
        return this.employee;
    }
}
