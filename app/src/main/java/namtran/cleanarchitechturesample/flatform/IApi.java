package namtran.cleanarchitechturesample.flatform;


import java.util.List;

import io.reactivex.Flowable;
import namtran.cleanarchitechturesample.flatform.model.Test;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IApi {

    @GET("/test.json?key=bbbccaa0")
    Flowable<List<Test>> getData();
}
