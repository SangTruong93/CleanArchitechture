
package namtran.flatform.remote.response.session;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName("self")
    @Expose
    public Self self;
    @SerializedName("teams")
    @Expose
    public Teams teams;
    @SerializedName("fixtures")
    @Expose
    public Fixtures fixtures;
    @SerializedName("leagueTable")
    @Expose
    public LeagueTable leagueTable;

    public Links withSelf(Self self) {
        this.self = self;
        return this;
    }

    public Links withTeams(Teams teams) {
        this.teams = teams;
        return this;
    }

    public Links withFixtures(Fixtures fixtures) {
        this.fixtures = fixtures;
        return this;
    }

    public Links withLeagueTable(LeagueTable leagueTable) {
        this.leagueTable = leagueTable;
        return this;
    }

}
