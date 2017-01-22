package info.nukoneko.cuc.kidspos4j.api;

import retrofit2.http.GET;
import rx.Observable;

public interface Setting {
    @GET("update/check")
    Observable<Boolean> updateCheck();
}
