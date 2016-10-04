package info.nukoneko.kidspos4j;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by TEJNEK on 2016/02/04.
 */
final public class KidsPos4jConfig {
    private static boolean debug = false;

    private static boolean useSSL = false;
    private static String defaultPath = "api/";
    private static String defaultDomainPort = "127.0.0.1:8080";
    private static volatile Retrofit retrofit;

    public static void setDebug(boolean _debug) {
        debug = _debug;
    }

    public static boolean isDebug() {
        return debug;
    }

    public static void setDefaultUrl(boolean _useSSL, String _domainPort) {
        useSSL = _useSSL;
        defaultDomainPort = _domainPort;
        initRetrofit();
    }

    private static void initRetrofit() {
        ObjectMapper mapper = new ObjectMapper();
        JacksonConverterFactory factory =
                JacksonConverterFactory.create(mapper);

        OkHttpClient.Builder builder = new OkHttpClient.Builder().followRedirects(false);
        if (debug) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }

        retrofit = new Retrofit.Builder()
                .baseUrl(buildUrl())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(factory)
                .client(builder.build())
                .build();
    }

    private static String buildUrl() {
        return String.format("http%s://%s/%s", useSSL ? "s" : "", defaultDomainPort, defaultPath);
    }

    public static Retrofit getRetrofit() {
        if (retrofit == null) initRetrofit();
        return retrofit;
    }
}
