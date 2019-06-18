package teia.corporation.com;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private static RetrofitInterface retrofit;
    private static String BASE_URL = "http://api.languagelayer.com/";

    public static RetrofitInterface getInstance() {
        if(retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(RetrofitInterface.class);
        }
        return retrofit;
    }
}
