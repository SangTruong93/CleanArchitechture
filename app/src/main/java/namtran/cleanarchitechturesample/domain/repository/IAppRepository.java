package namtran.cleanarchitechturesample.domain.repository;


import java.util.List;

import io.reactivex.Observable;
import namtran.cleanarchitechturesample.flatform.remote.response.session.SoccerSeasons;

public interface IAppRepository {

    Observable<List<SoccerSeasons>> getData();
}
