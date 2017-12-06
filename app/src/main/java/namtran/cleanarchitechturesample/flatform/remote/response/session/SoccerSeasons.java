
package namtran.cleanarchitechturesample.flatform.remote.response.session;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SoccerSeasons {

    @SerializedName("_links")
    @Expose
    public Links links;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("caption")
    @Expose
    public String caption;
    @SerializedName("league")
    @Expose
    public String league;
    @SerializedName("year")
    @Expose
    public String year;
    @SerializedName("currentMatchday")
    @Expose
    public Integer currentMatchday;
    @SerializedName("numberOfMatchdays")
    @Expose
    public Integer numberOfMatchdays;
    @SerializedName("numberOfTeams")
    @Expose
    public Integer numberOfTeams;
    @SerializedName("numberOfGames")
    @Expose
    public Integer numberOfGames;
    @SerializedName("lastUpdated")
    @Expose
    public String lastUpdated;

    public SoccerSeasons withLinks(Links links) {
        this.links = links;
        return this;
    }

    public SoccerSeasons withId(Integer id) {
        this.id = id;
        return this;
    }

    public SoccerSeasons withCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public SoccerSeasons withLeague(String league) {
        this.league = league;
        return this;
    }

    public SoccerSeasons withYear(String year) {
        this.year = year;
        return this;
    }

    public SoccerSeasons withCurrentMatchday(Integer currentMatchday) {
        this.currentMatchday = currentMatchday;
        return this;
    }

    public SoccerSeasons withNumberOfMatchdays(Integer numberOfMatchdays) {
        this.numberOfMatchdays = numberOfMatchdays;
        return this;
    }

    public SoccerSeasons withNumberOfTeams(Integer numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
        return this;
    }

    public SoccerSeasons withNumberOfGames(Integer numberOfGames) {
        this.numberOfGames = numberOfGames;
        return this;
    }

    public SoccerSeasons withLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

}
