package org.frankboller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.model.Bonus;
import io.swagger.model.Feature;
import io.swagger.model.Mediameta;
import io.swagger.model.TvSeries;

public class Impl {
  private static final Logger LOGGER = LoggerFactory.getLogger(Impl.class);

  public static Mediameta searchTitleItem(String type, String searchString,
      ObjectMapper objectMapper) {
    /*
     * in caller MUST:
     *
     * Mediameta mediameta = Impl.searchTitleItem(type, searchString, objectMapper);
     * mediameta.addTitlesItem(mediameta.getFeatures().get(0));
     *
     * List features = mediameta.getFeatures(); return new ResponseEntity(features,HttpStatus.OK);
     *
     */
    Mediameta mediameta = new Mediameta();
    String json = null;

    StaticMediameta.getInstance();


    objectMapper.setSerializationInclusion(Include.NON_NULL);
    LOGGER.warn("type:" + type);
    LOGGER.warn("searchString:" + searchString);

    try {
      LOGGER.warn("mediameta:" + mediameta);
      json = objectMapper.writeValueAsString(mediameta);
      LOGGER.warn("json:" + json);

      mediameta = getDummyFeature(mediameta);
      LOGGER.warn("mediameta:" + mediameta);

      mediameta = getDummyTvSeries(mediameta);
      LOGGER.warn("mediameta:" + mediameta);
    } catch (Exception e) {
      LOGGER.error("" + e);
    }

    return mediameta;
  }

  private static Mediameta getDummyTvSeries(Mediameta mediameta) {
    TvSeries tvSeries = new TvSeries();

    if (null == mediameta) {
      mediameta = new Mediameta();
    }

    tvSeries.setDescription("shows a pretend tvSeries");
    tvSeries.setName("pretend tvSeries");

    mediameta.addTvseriesItem(tvSeries);

    return mediameta;
  }

  private static Mediameta getDummyFeature(Mediameta mediameta) {
    Bonus bonus = new Bonus();
    Feature feature = new Feature();

    if (null == mediameta) {
      mediameta = new Mediameta();
    }

    feature.setDescription("shows a dummy feature");
    feature.setName("dummy feature");
    feature.setTheatricalReleaseDate("02/11/1950");
    feature.setDuration("200 min");

    bonus.setDescription("shows a dummy bonus 1");
    bonus.setDuration("5 minute");
    bonus.setName("dummy bonus 1");
    bonus.setParentTitle(feature.getName());
    bonus.setType("Bonus");
    feature.addBonusesItem(bonus);

    bonus = new Bonus();
    bonus.setDescription("shows a dummy bonus 2");
    bonus.setDuration("6 minute");
    bonus.setName("dummy bonus 2");
    bonus.setParentTitle(feature.getName());
    bonus.setType("Bonus");
    feature.addBonusesItem(bonus);

    mediameta.addFeaturesItem(feature);

    return mediameta;
  }



}
