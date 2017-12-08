package namtran.cleanarchitechturesample.flatform;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import namtran.cleanarchitechturesample.flatform.remote.response.session.SoccerSeason;
import namtran.cleanarchitechturesample.flatform.remote.response.team.ListTeamResponse;
import namtran.cleanarchitechturesample.flatform.remote.response.team.Team;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IApi {

    @GET("/v1/soccerseasons")
    Flowable<List<SoccerSeason>> getListSeason();

    @GET("v1/soccerseasons/{id}/teams")
    Flowable<ListTeamResponse> getListTeam(@Path("id") int id);
}
