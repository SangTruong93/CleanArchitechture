/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package namtran.cleanarchitechturesample.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import namtran.cleanarchitechturesample.model.SoccerSeasonModel;
import namtran.cleanarchitechturesample.model.TeamModel;
import namtran.flatform.remote.response.session.SoccerSeason;
import namtran.flatform.remote.response.team.Team;

/**
 * Mapper class used to transform {@link Team} (in the domain layer)
 * to {@link TeamModel} in the
 * presentation layer.
 */
public class TeamModelDataMapper {

  @Inject
  public TeamModelDataMapper() {}

  /**
   * Transform a {@link Team} into an {@link SoccerSeasonModel}.
   *
   * @param team Object to be transformed.
   * @return {@link TeamModel}.
   */
  public TeamModel transform(Team team) {
    if (team == null) {
      throw new IllegalArgumentException("Cannot transform a null value");
    }
    final TeamModel teamModel = new TeamModel();
    teamModel.idSeason = team.idSeason;
    teamModel.name = team.name;
    teamModel.code = team.code;
    teamModel.shortName = team.shortName;
    teamModel.crestUrl = team.crestUrl;

    return teamModel;
  }

  /**
   * Transform a Collection of {@link Team} into a Collection of {@link TeamModel}.
   *
   * @param teams Objects to be transformed.
   * @return List of {@link TeamModel}.
   */
  public List<TeamModel> transform(List<Team> teams) {
    List<TeamModel> teamModels;

    if (teams != null && !teams.isEmpty()) {
      teamModels = new ArrayList<>();
      for (Team team : teams) {
        teamModels.add(transform(team));
      }
    } else {
      teamModels = new ArrayList<>();
    }

    return teamModels;
  }
}
