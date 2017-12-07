package namtran.cleanarchitechturesample.flatform.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import namtran.cleanarchitechturesample.flatform.remote.response.session.SoccerSeason;

/**
 * Main database description.
 */
@Database(entities = {SoccerSeason.class}, version = 1 ,exportSchema = false)
public abstract class DbProvider extends RoomDatabase {
    public abstract SoccerSeasonDao soccerSeasonDao();
}
