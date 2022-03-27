package com.project.asset.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Category {
    @Id
    @Column
    private int cat_id;
    @Column
    private String cat_name;
    @Column
    private String description;

    @OneToMany(mappedBy = "Category")
    private List<Assets> listAssets = new ArrayList<>();

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
