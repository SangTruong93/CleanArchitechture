
package namtran.flatform.remote.response.session;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fixtures {

    @SerializedName("href")
    @Expose
    public String href;

    public Fixtures withHref(String href) {
        this.href = href;
        return this;
    }

}
