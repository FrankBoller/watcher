package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Bonus;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Title
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-02-28T19:53:18.269Z")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true )
@JsonSubTypes({
  @JsonSubTypes.Type(value = Episode.class, name = "Episode"),
  @JsonSubTypes.Type(value = TvSeries.class, name = "TvSeries"),
  @JsonSubTypes.Type(value = Season.class, name = "Season"),
  @JsonSubTypes.Type(value = Feature.class, name = "Feature"),
})

public class Title   {
  @JsonProperty("type")
  private String type = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("bonuses")
  @Valid
  private List<Bonus> bonuses = null;

  public Title type(String type) {
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

  public Title name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "Frozen", required = true, value = "")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Title description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(example = "a full description which could be used for searches", value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Title bonuses(List<Bonus> bonuses) {
    this.bonuses = bonuses;
    return this;
  }

  public Title addBonusesItem(Bonus bonusesItem) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Title title = (Title) o;
    return Objects.equals(this.type, title.type) &&
        Objects.equals(this.name, title.name) &&
        Objects.equals(this.description, title.description) &&
        Objects.equals(this.bonuses, title.bonuses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, name, description, bonuses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Title {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    bonuses: ").append(toIndentedString(bonuses)).append("\n");
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

