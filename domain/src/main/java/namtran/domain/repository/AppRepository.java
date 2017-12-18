package namtran.domain.repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import namtran.domain.entity.SoccerSeasonEntity;
import namtran.domain.entity.TeamEntity;
import namtran.domain.mapper.DataMapper;
import namtran.flatform.IApi;
import namtran.flatform.db.DbProvider;
import namtran.flatform.remote.response.session.SoccerSeason;
import namtran.flatform.remote.response.team.ListTeamResponse;
import namtran.flatform.remote.response.team.Team;
import namtran.util.Checker;

@Singleton
public class AppRepository implements IAppRepository {

    private final IApi mApi;
    private final DbProvider mDbProvider;
    private final DataMapper mDataMapper;

    @Inject
    AppRepository(IApi mApi, DbProvider mDbProvider, DataMapper mDataMapper) {
        this.mApi = mApi;
        this.mDbProvider = mDbProvider;
        this.mDataMapper = mDataMapper;
    }

    @Override
    public Flowable<List<SoccerSeasonEntity>> getListSeason() {
        return mDbProvider.soccerSeasonDao().fetchSoccerSeason().flatMap(new Function<List<SoccerSeason>, Flowable<List<SoccerSeasonEntity>>>() {
            @Override
            public Flowable<List<SoccerSeasonEntity>> apply(List<SoccerSeason> soccerSeasons) throws Exception {
                if (Checker.isEmpty(soccerSeasons)){
                    return mApi.getListSeason().map(new Function<List<SoccerSeason>, List<SoccerSeasonEntity>>() {
                        @Override
                        public List<SoccerSeasonEntity> apply(List<SoccerSeason> soccerSeasons) throws Exception {
                            mDbProvider.beginTransaction();
                            try {
                                mDbProvider.soccerSeasonDao().insert(soccerSeasons);
                                mDbProvider.setTransactionSuccessful();
                            } finally {
                                mDbProvider.endTransaction();
                            }
                            return mDataMapper.getSeasonEntityDataMapper().transform(soccerSeasons);
                        }
                    });
                }
                return Flowable.just(mDataMapper.getSeasonEntityDataMapper().transform(soccerSeasons));
            }
        });
    }

    @Override
    public Flowable<List<TeamEntity>> getListTeam(final int idSeason) {
        return mDbProvider.teamDao().fetchTeams(idSeason).flatMap(new Function<List<Team>, Flowable<List<TeamEntity>>>() {
            @Override
            public Flowable<List<TeamEntity>> apply(final List<Team> teams) throws Exception {
                if (Checker.isEmpty(teams)){
                    return mApi.getListTeam(idSeason).map(new Function<ListTeamResponse, List<TeamEntity>>() {
                        @Override
                        public List<TeamEntity> apply(ListTeamResponse listTeamResponse) throws Exception {
                            List<Team> listTeam = listTeamResponse.getTeams();
                            if (Checker.isEmpty(listTeam))
                                return null;

                            for (Team team : listTeam){
                                team.idSeason = idSeason;
                            }

                            mDbProvider.beginTransaction();
                            try {
                                mDbProvider.teamDao().insert(listTeam);
                                mDbProvider.setTransactionSuccessful();
                            } finally {
                                mDbProvider.endTransaction();
                            }
                            return mDataMapper.getTeamEntityDataMapper().transform(listTeam);
                        }
                    });
                }
                return Flowable.just(mDataMapper.getTeamEntityDataMapper().transform(teams));
            }
        });
    }
}
