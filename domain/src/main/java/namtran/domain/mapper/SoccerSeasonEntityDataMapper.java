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
package namtran.domain.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import namtran.domain.entity.SoccerSeasonEntity;
import namtran.flatform.remote.response.session.SoccerSeason;

/**
 * Mapper class used to transform {@link SoccerSeason} (in the domain layer)
 * to {@link SoccerSeasonEntity} in the
 * presentation layer.
 */
public class SoccerSeasonEntityDataMapper {

  @Inject
  public SoccerSeasonEntityDataMapper() {}

  /**
   * Transform a {@link SoccerSeason} into an {@link SoccerSeasonEntity}.
   *
   * @param season Object to be transformed.
   * @return {@link SoccerSeasonEntity}.
   */
  public SoccerSeasonEntity transform(SoccerSeason season) {
    if (season == null) {
      throw new IllegalArgumentException("Cannot transform a null value");
    }
    final SoccerSeasonEntity seasonModel = new SoccerSeasonEntity();
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
   * Transform a Collection of {@link SoccerSeason} into a Collection of {@link SoccerSeasonEntity}.
   *
   * @param seasonCollection Objects to be transformed.
   * @return List of {@link SoccerSeasonEntity}.
   */
  public List<SoccerSeasonEntity> transform(List<SoccerSeason> seasonCollection) {
    List<SoccerSeasonEntity> seasonModelCollection;

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
