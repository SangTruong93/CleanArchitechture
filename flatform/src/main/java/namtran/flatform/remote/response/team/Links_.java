
package namtran.flatform.remote.response.team;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links_ {

    @SerializedName("self")
    @Expose
    private Self_ self;
    @SerializedName("fixtures")
    @Expose
    private Fixtures fixtures;
    @SerializedName("players")
    @Expose
    private Players players;

    public Self_ getSelf() {
        return self;
    }

    public void setSelf(Self_ self) {
        this.self = self;
    }

    public Fixtures getFixtures() {
        return fixtures;
    }

    public void setFixtures(Fixtures fixtures) {
        this.fixtures = fixtures;
    }

    public Players getPlayers() {
        return players;
    }

    public void setPlayers(Players players) {
        this.players = players;
    }

}
