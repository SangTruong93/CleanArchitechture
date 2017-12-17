
package namtran.flatform.remote.response.team;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName("self")
    @Expose
    private Self self;
    @SerializedName("soccerseason")
    @Expose
    private Soccerseason soccerseason;

    public Self getSelf() {
        return self;
    }

    public void setSelf(Self self) {
        this.self = self;
    }

    public Soccerseason getSoccerseason() {
        return soccerseason;
    }

    public void setSoccerseason(Soccerseason soccerseason) {
        this.soccerseason = soccerseason;
    }

}
