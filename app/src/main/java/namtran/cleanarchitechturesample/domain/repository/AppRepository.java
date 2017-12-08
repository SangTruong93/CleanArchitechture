package namtran.cleanarchitechturesample.domain.repository;


import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import namtran.cleanarchitechturesample.flatform.IApi;
import namtran.cleanarchitechturesample.flatform.db.DbProvider;
import namtran.cleanarchitechturesample.flatform.remote.response.session.SoccerSeason;
import namtran.cleanarchitechturesample.flatform.remote.response.team.ListTeamResponse;
import namtran.cleanarchitechturesample.flatform.remote.response.team.Team;
import namtran.cleanarchitechturesample.util.Checker;
import namtran.cleanarchitechturesample.util.Logger;

@Singleton
public class AppRepository implements IAppRepository {

    private final IApi mApi;
    private final DbProvider mDbProvider;

    @Inject
    AppRepository(IApi mApi, DbProvider mDbProvider) {
        this.mApi = mApi;
        this.mDbProvider = mDbProvider;
    }

    @Override
    public Flowable<List<SoccerSeason>> getListSeason() {
        return mDbProvider.soccerSeasonDao().fetchSoccerSeason().flatMap(new Function<List<SoccerSeason>, Publisher<List<SoccerSeason>>>() {
            @Override
            public Publisher<List<SoccerSeason>> apply(List<SoccerSeason> soccerSeasons) throws Exception {
                if (Checker.isEmpty(soccerSeasons)){
                    return mApi.getListSeason().map(new Function<List<SoccerSeason>, List<SoccerSeason>>() {
                        @Override
                        public List<SoccerSeason> apply(List<SoccerSeason> soccerSeasons) throws Exception {
                            mDbProvider.beginTransaction();
                            try {
                                mDbProvider.soccerSeasonDao().insert(soccerSeasons);
                                mDbProvider.setTransactionSuccessful();
                            } finally {
                                mDbProvider.endTransaction();
                            }
                            return soccerSeasons;
                        }
                    });
                }
                return Flowable.just(soccerSeasons);
            }
        });
    }

    @Override
    public Flowable<List<Team>> getListTeam(final int idSeason) {
        return mDbProvider.teamDao().fetchTeams(idSeason).flatMap(new Function<List<Team>, Publisher<List<Team>>>() {
            @Override
            public Publisher<List<Team>> apply(final List<Team> teams) throws Exception {
                if (Checker.isEmpty(teams)){
                    return mApi.getListTeam(idSeason).map(new Function<ListTeamResponse, List<Team>>() {
                        @Override
                        public List<Team> apply(ListTeamResponse listTeamResponse) throws Exception {
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
                            return listTeam;
                        }
                    });
                }
                return Flowable.just(teams);
            }
        });
    }
}
