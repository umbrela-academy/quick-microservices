package com.example.apiclient.domain;

public class BookVM {

    private Long id;
    private String name;
    private Double cost;
    private String addendum;

    public BookVM(Book book, String addendum) {
        this.id = book.getId();
        this.name = book.getName();
        this.cost = book.getCost();
        this.addendum = addendum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getAddendum() {
        return addendum;
    }

    public void setAddendum(String addendum) {
        this.addendum = addendum;
    }
}
