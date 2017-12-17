package namtran.flatform;

import java.util.List;

import io.reactivex.Flowable;
import namtran.flatform.remote.response.session.SoccerSeason;
import namtran.flatform.remote.response.team.ListTeamResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IApi {

    @GET("/v1/soccerseasons")
    Flowable<List<SoccerSeason>> getListSeason();

    @GET("v1/soccerseasons/{id}/teams")
    Flowable<ListTeamResponse> getListTeam(@Path("id") int id);
}
