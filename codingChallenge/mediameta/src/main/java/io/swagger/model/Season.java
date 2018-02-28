package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Bonus;
import io.swagger.model.Episode;
import io.swagger.model.Title;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Season
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-02-28T19:53:18.269Z")

public class Season extends Title  {
  @JsonProperty("releaseDate")
  private String releaseDate = null;

  @JsonProperty("parentTitle")
  private String parentTitle = null;

  @JsonProperty("episodes")
  @Valid
  private List<Episode> episodes = null;

  public Season releaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
    return this;
  }

   /**
   * Get releaseDate
   * @return releaseDate
  **/
  @ApiModelProperty(example = "09/22/2004", value = "")


  public String getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }

  public Season parentTitle(String parentTitle) {
    this.parentTitle = parentTitle;
    return this;
  }

   /**
   * Get parentTitle
   * @return parentTitle
  **/
  @ApiModelProperty(example = "Adventures in Wonderland", value = "")


  public String getParentTitle() {
    return parentTitle;
  }

  public void setParentTitle(String parentTitle) {
    this.parentTitle = parentTitle;
  }

  public Season episodes(List<Episode> episodes) {
    this.episodes = episodes;
    return this;
  }

  public Season addEpisodesItem(Episode episodesItem) {
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
    Season season = (Season) o;
    return Objects.equals(this.releaseDate, season.releaseDate) &&
        Objects.equals(this.parentTitle, season.parentTitle) &&
        Objects.equals(this.episodes, season.episodes) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(releaseDate, parentTitle, episodes, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Season {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    releaseDate: ").append(toIndentedString(releaseDate)).append("\n");
    sb.append("    parentTitle: ").append(toIndentedString(parentTitle)).append("\n");
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

