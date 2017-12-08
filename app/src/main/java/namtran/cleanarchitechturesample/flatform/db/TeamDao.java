package namtran.cleanarchitechturesample.flatform.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Flowable;
import namtran.cleanarchitechturesample.flatform.remote.response.session.SoccerSeason;
import namtran.cleanarchitechturesample.flatform.remote.response.team.Team;

/**
 * Interface for database access for User related operations.
 */
@Dao
public interface TeamDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Team> teams);

    @Query("SELECT * FROM team WHERE idSeason = :idSeason")
    Flowable<List<Team>> fetchTeams(int idSeason);
}
