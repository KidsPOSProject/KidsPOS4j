package info.nukoneko.kidspos4j.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by atsumi on 2016/02/03.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
final public class ModelItemGenre implements BaseModelAbstract {
    private Integer id;
    private String name;
    private String store;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStore() {
        return store;
    }
}
