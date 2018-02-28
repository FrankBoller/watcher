package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Bonus;
import io.swagger.model.Episode;
import io.swagger.model.Feature;
import io.swagger.model.Season;
import io.swagger.model.TvSeries;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Mediameta
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-02-28T19:53:18.269Z")

public class Mediameta   {
  @JsonProperty("type")
  private String type = null;

  @JsonProperty("bonuses")
  @Valid
  private List<Bonus> bonuses = null;

  @JsonProperty("features")
  @Valid
  private List<Feature> features = null;

  @JsonProperty("tvseries")
  @Valid
  private List<TvSeries> tvseries = null;

  @JsonProperty("seasons")
  @Valid
  private List<Season> seasons = null;

  @JsonProperty("episodes")
  @Valid
  private List<Episode> episodes = null;

  public Mediameta type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(example = "one of: bonus, feature, tvseries, season, or episode", required = true, value = "")
  @NotNull


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Mediameta bonuses(List<Bonus> bonuses) {
    this.bonuses = bonuses;
    return this;
  }

  public Mediameta addBonusesItem(Bonus bonusesItem) {
    if (this.bonuses == null) {
      this.bonuses = new ArrayList<Bonus>();
    }
    this.bonuses.add(bonusesItem);
    return this;
  }

   /**
   * Get bonuses
   * @return bonuses
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Bonus> getBonuses() {
    return bonuses;
  }

  public void setBonuses(List<Bonus> bonuses) {
    this.bonuses = bonuses;
  }

  public Mediameta features(List<Feature> features) {
    this.features = features;
    return this;
  }

  public Mediameta addFeaturesItem(Feature featuresItem) {
    if (this.features == null) {
      this.features = new ArrayList<Feature>();
    }
    this.features.add(featuresItem);
    return this;
  }

   /**
   * Get features
   * @return features
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Feature> getFeatures() {
    return features;
  }

  public void setFeatures(List<Feature> features) {
    this.features = features;
  }

  public Mediameta tvseries(List<TvSeries> tvseries) {
    this.tvseries = tvseries;
    return this;
  }

  public Mediameta addTvseriesItem(TvSeries tvseriesItem) {
    if (this.tvseries == null) {
      this.tvseries = new ArrayList<TvSeries>();
    }
    this.tvseries.add(tvseriesItem);
    return this;
  }

   /**
   * Get tvseries
   * @return tvseries
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<TvSeries> getTvseries() {
    return tvseries;
  }

  public void setTvseries(List<TvSeries> tvseries) {
    this.tvseries = tvseries;
  }

  public Mediameta seasons(List<Season> seasons) {
    this.seasons = seasons;
    return this;
  }

  public Mediameta addSeasonsItem(Season seasonsItem) {
    if (this.seasons == null) {
      this.seasons = new ArrayList<Season>();
    }
    this.seasons.add(seasonsItem);
    return this;
  }

   /**
   * Get seasons
   * @return seasons
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Season> getSeasons() {
    return seasons;
  }

  public void setSeasons(List<Season> seasons) {
    this.seasons = seasons;
  }

  public Mediameta episodes(List<Episode> episodes) {
    this.episodes = episodes;
    return this;
  }

  public Mediameta addEpisodesItem(Episode episodesItem) {
    if (this.episodes == null) {
      this.episodes = new ArrayList<Episode>();
    }
    this.episodes.add(episodesItem);
    return this;
  }

   /**
   * Get episodes
   * @return episodes
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Episode> getEpisodes() {
    return episodes;
  }

  public void setEpisodes(List<Episode> episodes) {
    this.episodes = episodes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Mediameta mediameta = (Mediameta) o;
    return Objects.equals(this.type, mediameta.type) &&
        Objects.equals(this.bonuses, mediameta.bonuses) &&
        Objects.equals(this.features, mediameta.features) &&
        Objects.equals(this.tvseries, mediameta.tvseries) &&
        Objects.equals(this.seasons, mediameta.seasons) &&
        Objects.equals(this.episodes, mediameta.episodes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, bonuses, features, tvseries, seasons, episodes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Mediameta {\n");

    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    bonuses: ").append(toIndentedString(bonuses)).append("\n");
    sb.append("    features: ").append(toIndentedString(features)).append("\n");
    sb.append("    tvseries: ").append(toIndentedString(tvseries)).append("\n");
    sb.append("    seasons: ").append(toIndentedString(seasons)).append("\n");
    sb.append("    episodes: ").append(toIndentedString(episodes)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

