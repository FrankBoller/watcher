package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Bonus;
import io.swagger.model.Season;
import io.swagger.model.Title;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TvSeries
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-02-28T19:53:18.269Z")

public class TvSeries extends Title  {
  @JsonProperty("releaseDate")
  private String releaseDate = null;

  @JsonProperty("seasons")
  @Valid
  private List<Season> seasons = null;

  public TvSeries releaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
    return this;
  }

   /**
   * Get releaseDate
   * @return releaseDate
  **/
  @ApiModelProperty(example = "11/27/2013", value = "")


  public String getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }

  public TvSeries seasons(List<Season> seasons) {
    this.seasons = seasons;
    return this;
  }

  public TvSeries addSeasonsItem(Season seasonsItem) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TvSeries tvSeries = (TvSeries) o;
    return Objects.equals(this.releaseDate, tvSeries.releaseDate) &&
        Objects.equals(this.seasons, tvSeries.seasons) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(releaseDate, seasons, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TvSeries {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    releaseDate: ").append(toIndentedString(releaseDate)).append("\n");
    sb.append("    seasons: ").append(toIndentedString(seasons)).append("\n");
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

