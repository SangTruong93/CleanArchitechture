package namtran.domain.repository;


import java.util.List;

import io.reactivex.Flowable;
import namtran.flatform.remote.response.session.SoccerSeason;
import namtran.flatform.remote.response.team.Team;

public interface IAppRepository {

    Flowable<List<SoccerSeason>> getListSeason();

    Flowable<List<Team>> getListTeam(int idSeason);
}
