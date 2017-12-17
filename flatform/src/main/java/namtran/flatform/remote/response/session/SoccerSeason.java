
package namtran.flatform.remote.response.session;

import android.arch.persistence.room.Entity;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "SoccerSeason",primaryKeys = "id")
public class SoccerSeason {

    @SerializedName("id")
    public int id;
    @SerializedName("caption")
    public String caption;
    @SerializedName("league")
    public String league;
    @SerializedName("year")
    public String year;
    @SerializedName("currentMatchday")
    public int currentMatchday;
    @SerializedName("numberOfMatchdays")
    public int numberOfMatchdays;
    @SerializedName("numberOfTeams")
    public int numberOfTeams;
    @SerializedName("numberOfGames")
    public int numberOfGames;
    @SerializedName("lastUpdated")
    public String lastUpdated;

    public SoccerSeason(int id, String caption, String league, String year, int currentMatchday, int numberOfMatchdays
            , int numberOfTeams, int numberOfGames, String lastUpdated) {
        this.id = id;
        this.caption = caption;
        this.league = league;
        this.year = year;
        this.currentMatchday = currentMatchday;
        this.numberOfMatchdays = numberOfMatchdays;
        this.numberOfTeams = numberOfTeams;
        this.numberOfGames = numberOfGames;
        this.lastUpdated = lastUpdated;
    }
}
