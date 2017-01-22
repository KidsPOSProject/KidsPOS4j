package info.nukoneko.cuc.kidspos4j.api;

import info.nukoneko.cuc.kidspos4j.model.ModelItemGenre;
import retrofit2.http.GET;
import rx.Observable;

import java.util.List;

public interface ItemGenre {
    @GET("item_genre/list")
    Observable<List<ModelItemGenre>> getList();
}
