package namtran.cleanarchitechturesample.domain.repository;


import java.util.List;

import io.reactivex.Flowable;
import namtran.cleanarchitechturesample.flatform.model.Test;

public interface IAppRepository {

    Flowable<List<Test>> getData();
}
