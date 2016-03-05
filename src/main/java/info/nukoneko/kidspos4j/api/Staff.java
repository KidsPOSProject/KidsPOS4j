package info.nukoneko.kidspos4j.api;

import info.nukoneko.kidspos4j.model.ModelStaff;
import retrofit2.http.*;
import rx.Observable;

import java.util.List;

/**
 * Created by TEJNEK on 2016/02/04.
 */
public interface Staff {
    /***
     * スタッフの一覧を取得する
     * @return
     */
    @GET("staff/list")
    Observable<List<ModelStaff>> getList();

    /***
     * 重要 新しいスタッフを登録する。既にいたらエラーを返す
     * サーバーではバーコード印刷もするよ(予定)
     * @param staffJson
     * @return
     */
    @POST("staff")
    Observable<ModelStaff> createStaff(@Field("new_staff") String staffJson);

    /***
     * スタッフの情報を取得する。いなかったらnullを返す
     * @param barcode
     * @return
     */
    @GET("staff")
    Observable<ModelStaff> getStaff(@Query("barcode") String barcode);
}
