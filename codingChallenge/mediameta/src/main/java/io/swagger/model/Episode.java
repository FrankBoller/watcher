package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Bonus;
import io.swagger.model.Title;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Episode
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-02-28T19:53:18.269Z")

public class Episode extends Title  {
  @JsonProperty("releaseDate")
  private String releaseDate = null;

  @JsonProperty("parentTitle")
  private String parentTitle = null;

  @JsonProperty("duration")
  private String duration = null;

  public Episode releaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
    return this;
  }

   /**
   * Get releaseDate
   * @return releaseDate
  **/
  @ApiModelProperty(example = "03/23/1992", value = "")


  public String getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }

  public Episode parentTitle(String parentTitle) {
    this.parentTitle = parentTitle;
    return this;
  }

   /**
   * Get parentTitle
   * @return parentTitle
  **/
  @ApiModelProperty(example = "Herstory in the Making", value = "")


  public String getParentTitle() {
    return parentTitle;
  }

  public void setParentTitle(String parentTitle) {
    this.parentTitle = parentTitle;
  }

  public Episode duration(String duration) {
    this.duration = duration;
    return this;
  }

   /**
   * Get duration
   * @return duration
  **/
  @ApiModelProperty(example = "51 min", value = "")


  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Episode episode = (Episode) o;
    return Objects.equals(this.releaseDate, episode.releaseDate) &&
        Objects.equals(this.parentTitle, episode.parentTitle) &&
        Objects.equals(this.duration, episode.duration) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(releaseDate, parentTitle, duration, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Episode {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    releaseDate: ").append(toIndentedString(releaseDate)).append("\n");
    sb.append("    parentTitle: ").append(toIndentedString(parentTitle)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
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

