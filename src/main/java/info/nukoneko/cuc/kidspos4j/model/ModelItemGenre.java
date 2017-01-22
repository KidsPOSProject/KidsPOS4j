package info.nukoneko.cuc.kidspos4j.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
final public class ModelItemGenre implements BaseModel {
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
