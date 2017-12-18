package namtran.domain.repository;


import java.util.List;

import io.reactivex.Flowable;
import namtran.domain.entity.SoccerSeasonEntity;
import namtran.domain.entity.TeamEntity;
import namtran.flatform.remote.response.session.SoccerSeason;
import namtran.flatform.remote.response.team.Team;

public interface IAppRepository {

    Flowable<List<SoccerSeasonEntity>> getListSeason();

    Flowable<List<TeamEntity>> getListTeam(int idSeason);
}
