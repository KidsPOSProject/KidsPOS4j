package info.nukoneko.cuc.kidspos4j.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by atsumi on 2016/02/03.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
final public class ModelStaff implements BaseModel {
    private String barcode;
    private String name;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
