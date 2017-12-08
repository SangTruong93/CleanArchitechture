package namtran.cleanarchitechturesample.domain.repository;


import java.util.List;

import io.reactivex.Flowable;
import namtran.cleanarchitechturesample.flatform.remote.response.session.SoccerSeason;
import namtran.cleanarchitechturesample.flatform.remote.response.team.Team;

public interface IAppRepository {

    Flowable<List<SoccerSeason>> getListSeason();

    Flowable<List<Team>> getListTeam(int idSeason);
}
