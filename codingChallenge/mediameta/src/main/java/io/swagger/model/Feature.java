package io.swagger.model;

import java.util.Objects;
import io.swagger.model.Bonus;
import io.swagger.model.Title;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Feature
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-02-28T19:53:18.269Z")

public class Feature extends Title  {
  String theatricalReleaseDate;
  String duration;

  public String getTheatricalReleaseDate() {
    return theatricalReleaseDate;
  }

  public void setTheatricalReleaseDate(String theatricalReleaseDate) {
    this.theatricalReleaseDate = theatricalReleaseDate;
  }

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((duration == null) ? 0 : duration.hashCode());
    result =
        prime * result + ((theatricalReleaseDate == null) ? 0 : theatricalReleaseDate.hashCode());
    result *= prime * Objects.hash(super.hashCode());

    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    Feature other = (Feature) obj;
    if (duration == null) {
      if (other.duration != null)
        return false;
    } else if (!duration.equals(other.duration))
      return false;
    if (theatricalReleaseDate == null) {
      if (other.theatricalReleaseDate != null)
        return false;
    } else if (!theatricalReleaseDate.equals(other.theatricalReleaseDate))
      return false;
    return true;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Feature {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    tytheatricalReleaseDatepe: ").append(toIndentedString(theatricalReleaseDate)).append("\n");
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

