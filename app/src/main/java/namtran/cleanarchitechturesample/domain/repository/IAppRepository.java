package namtran.cleanarchitechturesample.domain.repository;


import java.util.List;

import io.reactivex.Flowable;
import namtran.cleanarchitechturesample.flatform.remote.response.session.SoccerSeason;

public interface IAppRepository {

    Flowable<List<SoccerSeason>> getData();
}
