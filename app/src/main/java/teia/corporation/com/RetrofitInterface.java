package teia.corporation.com;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {

    @GET("detect")
    Call<ResponseModel> detectLanguage(
            @Query("access_key") String key,
            @Query("query") String query
    );
}
