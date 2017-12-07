package namtran.cleanarchitechturesample.flatform;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import namtran.cleanarchitechturesample.flatform.remote.response.session.SoccerSeason;
import retrofit2.http.GET;

public interface IApi {

    @GET("/v1/soccerseasons")
    Flowable<List<SoccerSeason>> getData();
}
