package com.timg.inventorysys;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
public class item {

    @Id
    @SequenceGenerator(
            name = "item_id_sequence",
            sequenceName = "item_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_id_sequence"
    )

    private Integer item_id;
    private String item_name;
    private String item_details;
    private String issued;

    private String issuer;

    public item(Integer item_id,
                String item_name,
                String item_details,
                String issued,
                String issuer) {

        this.item_id = item_id;
        this.item_name = item_name;
        this.item_details = item_details;
        this.issued = issued;
        this.issuer = issuer;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_details() {
        return item_details;
    }

    public void setItem_details(String item_details) {
        this.item_details = item_details;
    }

    public String getIssued() {
        return issued;
    }

    public void setIssued(String issued) {
        this.issued = issued;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public item() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        item item = (item) o;
        return Objects.equals(item_id, item.item_id) && Objects.equals(item_name, item.item_name) && Objects.equals(item_details, item.item_details) && Objects.equals(issued, item.issued) && Objects.equals(issuer, item.issuer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item_id, item_name, item_details, issued, issuer);
    }

    @Override
    public String toString() {
        return "item{" +
                "item_id=" + item_id +
                ", item_name='" + item_name + '\'' +
                ", item_details='" + item_details + '\'' +
                ", issued='" + issued + '\'' +
                ", issuer='" + issuer + '\'' +
                '}';
    }
}

