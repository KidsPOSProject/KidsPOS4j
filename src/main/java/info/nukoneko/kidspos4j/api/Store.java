package info.nukoneko.kidspos4j.api;

import info.nukoneko.kidspos4j.model.ModelItem;
import info.nukoneko.kidspos4j.model.ModelStore;
import retrofit.http.GET;
import rx.Observable;

import java.util.List;

/**
 * Created by TEJNEK on 2016/02/04.
 */
public interface Store {
    @GET("store/list")
    Observable<List<ModelStore>> getList();
}
