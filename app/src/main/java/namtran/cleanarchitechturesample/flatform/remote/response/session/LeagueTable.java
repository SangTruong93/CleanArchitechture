
package namtran.cleanarchitechturesample.flatform.remote.response.session;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeagueTable {

    @SerializedName("href")
    @Expose
    public String href;

    public LeagueTable withHref(String href) {
        this.href = href;
        return this;
    }

}
