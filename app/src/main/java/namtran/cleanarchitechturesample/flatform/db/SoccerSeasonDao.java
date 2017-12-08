package namtran.cleanarchitechturesample.flatform.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import namtran.cleanarchitechturesample.flatform.remote.response.session.SoccerSeason;

/**
 * Interface for database access for User related operations.
 */
@Dao
public interface SoccerSeasonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<SoccerSeason> season);

    @Query("SELECT * FROM soccerseason")
    Flowable<List<SoccerSeason>> fetchSoccerSeason();
}
