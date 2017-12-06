package namtran.cleanarchitechturesample.domain.repository;


import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import namtran.cleanarchitechturesample.flatform.IApi;
import namtran.cleanarchitechturesample.flatform.remote.response.session.SoccerSeasons;

@Singleton
public class AppRepository implements IAppRepository {

    private final IApi mApi;

    @Inject
    AppRepository(IApi mApi) {
        this.mApi = mApi;
    }

    @Override
    public Observable<List<SoccerSeasons>> getData() {
        return mApi.getData();
    }
}
