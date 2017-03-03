package info.nukoneko.cuc.kidspos4j.api;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.*;
import rx.Observable;

public interface Setting {
    @Headers("Content-Type: application/vnd.android.package-archive")
    @GET("system/apk/download")
    Observable<ResponseBody> downloadLatestApk(@Query("type") String downloadType, @Query("build-number") int buildNumber);

    //application/vnd.openxmlformats-officedocument.spreadsheetml.sheet

    @GET("system/apk/check")
    Observable<Boolean> getLatestApk();

    @FormUrlEncoded
    @Headers("Content-Type: application/vnd.android.package-archive")
    @POST("system/apk/upload")
    @Multipart
    Observable<Boolean> uploadNewApk(@Part RequestBody apkFile, @Field("build-number") int buildNumber);
}
