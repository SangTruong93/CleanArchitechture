package namtran.cleanarchitechturesample.flatform;

import java.util.List;

import io.reactivex.Observable;
import namtran.cleanarchitechturesample.flatform.remote.response.session.SoccerSeasons;
import retrofit2.http.GET;

public interface IApi {

    @GET("/v1/soccerseasons")
    Observable<List<SoccerSeasons>> getData();
}
