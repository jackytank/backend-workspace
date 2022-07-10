package com.edu.lab5.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "reports")
public class Report implements Serializable {
    @Id
    @Column(name = "category", nullable = false, length = 50)
    private String id;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category", nullable = false)
    private Category categories;

    @Column(name = "\"sum\"", nullable = false)
    private Double sum;

    @Column(name = "\"count\"", nullable = false)
    private Long count;

    public Report() {
    }

    public Report(Category categories, Double sum, Long count) {
        this.categories = categories;
        this.sum = sum;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Category getCategories() {
        return categories;
    }

    public void setCategories(Category categories) {
        this.categories = categories;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

}