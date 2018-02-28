package org.frankboller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.model.Bonus;
import io.swagger.model.Episode;
import io.swagger.model.Feature;
import io.swagger.model.Mediameta;
import io.swagger.model.Season;
import io.swagger.model.TvSeries;

public class StaticMediameta {
  private static final Logger LOGGER = LoggerFactory.getLogger(StaticMediameta.class);

  private static final ArrayList<Bonus>    BONUSES          = new ArrayList<Bonus>();
  private static final ArrayList<Episode>  EPISODES         = new ArrayList<Episode>();
  private static final ArrayList<Feature>  FEATURES         = new ArrayList<Feature>();
  private static final ArrayList<Season>   SEASONS          = new ArrayList<Season>();
  private static final ArrayList<TvSeries> TV_SERIES        = new ArrayList<TvSeries>();
  private static final StaticMediameta     STATIC_MEDIAMETA = new StaticMediameta();

  private Mediameta                        mediameta;

  private StaticMediameta() {
    init();
  }

  private void init() {
    mediameta = new Mediameta();
    mediameta.setBonuses(BONUSES);
    mediameta.setEpisodes(EPISODES);
    mediameta.setFeatures(FEATURES);
    mediameta.setSeasons(SEASONS);
    mediameta.setTvseries(TV_SERIES);
  }

  public static StaticMediameta getInstance() {
    return STATIC_MEDIAMETA;
  }

}
