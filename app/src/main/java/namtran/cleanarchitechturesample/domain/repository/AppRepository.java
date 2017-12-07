package namtran.cleanarchitechturesample.domain.repository;


import org.reactivestreams.Publisher;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import namtran.cleanarchitechturesample.flatform.IApi;
import namtran.cleanarchitechturesample.flatform.db.DbProvider;
import namtran.cleanarchitechturesample.flatform.remote.response.session.SoccerSeason;
import namtran.cleanarchitechturesample.util.Checker;

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
    public Flowable<List<SoccerSeason>> getData() {
        return mDbProvider.soccerSeasonDao().fetchSoccerSeason().flatMap(new Function<List<SoccerSeason>, Publisher<List<SoccerSeason>>>() {
            @Override
            public Publisher<List<SoccerSeason>> apply(List<SoccerSeason> soccerSeasons) throws Exception {
                if (Checker.isEmpty(soccerSeasons)){
                    return mApi.getData().map(new Function<List<SoccerSeason>, List<SoccerSeason>>() {
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
}
