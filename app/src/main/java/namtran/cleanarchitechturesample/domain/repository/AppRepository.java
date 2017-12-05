package namtran.cleanarchitechturesample.domain.repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;
import namtran.cleanarchitechturesample.flatform.IApi;
import namtran.cleanarchitechturesample.flatform.model.Test;

@Singleton
public class AppRepository implements IAppRepository {

    private final IApi mApi;

    @Inject
    public AppRepository(IApi mApi) {
        this.mApi = mApi;
    }

    @Override
    public Flowable<List<Test>> getData() {
        return mApi.getData();
    }
}
