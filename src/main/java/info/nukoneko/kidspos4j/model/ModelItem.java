package info.nukoneko.kidspos4j.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by atsumi on 2016/02/03.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
final public class ModelItem implements BaseModelAbstract {
    private Integer id;
    private String barcode;
    private String name;
    private Integer price;
    private Integer shop;
    private String genre;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setShop(Integer shop) {
        this.shop = shop;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getShop() {
        return shop;
    }

    public String getGenre() {
        return genre;
    }
}
