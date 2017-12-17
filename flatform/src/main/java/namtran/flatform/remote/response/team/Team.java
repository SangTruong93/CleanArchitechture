
package namtran.flatform.remote.response.team;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import namtran.flatform.remote.response.session.SoccerSeason;

@Entity(tableName = "Team",primaryKeys = {"idSeason", "name"},
        foreignKeys = @ForeignKey(entity = SoccerSeason.class,
        parentColumns = {"id"},
        childColumns = {"idSeason"},
        onUpdate = ForeignKey.CASCADE,
        deferred = true))
public class Team {

    public int idSeason;

    @SerializedName("name")
    @Expose
    @NonNull
    public String name;
    @SerializedName("code")
    @Expose
    public String code = "";
    @SerializedName("shortName")
    @Expose
    public String shortName;
    @SerializedName("crestUrl")
    @Expose
    public String crestUrl;

    public int getIdSeason() {
        return idSeason;
    }

    public void setIdSeason(int idSeason) {
        this.idSeason = idSeason;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getCrestUrl() {
        return crestUrl;
    }

    public void setCrestUrl(String crestUrl) {
        this.crestUrl = crestUrl;
    }
}
