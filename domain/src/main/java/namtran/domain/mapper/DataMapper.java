package namtran.domain.mapper;


import javax.inject.Inject;

public class DataMapper {

    private final SoccerSeasonEntityDataMapper seasonEntityDataMapper;
    private final TeamEntityDataMapper teamEntityDataMapper;

    @Inject
    DataMapper(SoccerSeasonEntityDataMapper seasonEntityDataMapper, TeamEntityDataMapper teamEntityDataMapper){

        this.seasonEntityDataMapper = seasonEntityDataMapper;

        this.teamEntityDataMapper = teamEntityDataMapper;
    }

    public SoccerSeasonEntityDataMapper getSeasonEntityDataMapper() {
        return seasonEntityDataMapper;
    }

    public TeamEntityDataMapper getTeamEntityDataMapper() {
        return teamEntityDataMapper;
    }
}
