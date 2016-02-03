package info.nukoneko.kidspos4j.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by atsumi on 2016/02/03.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
final public class ModelStore implements BaseModelAbstract {
    private Integer id;
    private String name;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
