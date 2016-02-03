package info.nukoneko.kidspos4j.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by atsumi on 2016/02/03.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
final public class ModelSale implements BaseModelAbstract {
    private Integer id;
    private String barcode;
    private String createdAt;
    private Integer points;
    private Integer price;
    private String items;
    private Integer store;
    private Integer staff;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }

    public Integer getStaff() {
        return staff;
    }

    public void setStaff(Integer staff) {
        this.staff = staff;
    }
}
