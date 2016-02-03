package info.nukoneko.kidspos4j;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by TEJNEK on 2016/02/04.
 */
final public class KidsPos4jConfig {
    private static boolean debug = false;
    private static String baseUrl = "http://127.0.0.1:8080/api/";
    private static volatile Retrofit retrofit;

    public static void setDebug(boolean _debug) {
       debug = _debug;
    }

    public static boolean isDebug() {
        return debug;
    }

    public static void setBaseUrl(String _baseUrl) {
        baseUrl = _baseUrl;
        initRetrofit();
    }

    private static void initRetrofit(){
        ObjectMapper mapper = new ObjectMapper();
        JacksonConverterFactory factory =
                JacksonConverterFactory.create(mapper);
        OkHttpClient client = new OkHttpClient();
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(factory)
                .client(client)
                .build();
    }

    public static Retrofit getRetrofit(){
        if (retrofit == null) initRetrofit();
        return retrofit;
    }
}
