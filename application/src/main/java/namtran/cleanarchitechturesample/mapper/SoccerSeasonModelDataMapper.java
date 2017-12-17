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
import namtran.flatform.remote.response.session.SoccerSeason;

/**
 * Mapper class used to transform {@link SoccerSeason} (in the domain layer)
 * to {@link SoccerSeasonModel} in the
 * presentation layer.
 */
public class SoccerSeasonModelDataMapper {

  @Inject
  public SoccerSeasonModelDataMapper() {}

  /**
   * Transform a {@link SoccerSeason} into an {@link SoccerSeasonModel}.
   *
   * @param season Object to be transformed.
   * @return {@link SoccerSeasonModel}.
   */
  public SoccerSeasonModel transform(SoccerSeason season) {
    if (season == null) {
      throw new IllegalArgumentException("Cannot transform a null value");
    }
    final SoccerSeasonModel seasonModel = new SoccerSeasonModel();
    seasonModel.id = season.id;
    seasonModel.caption = season.caption;
    seasonModel.league = season.league;
    seasonModel.year = season.year;
    seasonModel.currentMatchday = season.currentMatchday;
    seasonModel.numberOfMatchdays = season.numberOfMatchdays;
    seasonModel.numberOfTeams = season.numberOfTeams;
    seasonModel.numberOfGames = season.numberOfGames;
    seasonModel.lastUpdated = season.lastUpdated;

    return seasonModel;
  }

  /**
   * Transform a Collection of {@link SoccerSeason} into a Collection of {@link SoccerSeasonModel}.
   *
   * @param seasonCollection Objects to be transformed.
   * @return List of {@link SoccerSeasonModel}.
   */
  public List<SoccerSeasonModel> transform(List<SoccerSeason> seasonCollection) {
    List<SoccerSeasonModel> seasonModelCollection;

    if (seasonCollection != null && !seasonCollection.isEmpty()) {
      seasonModelCollection = new ArrayList<>();
      for (SoccerSeason user : seasonCollection) {
        seasonModelCollection.add(transform(user));
      }
    } else {
      seasonModelCollection = new ArrayList<>();
    }

    return seasonModelCollection;
  }
}
