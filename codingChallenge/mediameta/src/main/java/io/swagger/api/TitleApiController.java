package io.swagger.api;

import io.swagger.model.Mediameta;
import io.swagger.model.Title;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;

import org.frankboller.Impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-02-28T19:53:18.269Z")

@Controller
public class TitleApiController implements TitleApi {

  private static final Logger      log = LoggerFactory.getLogger(TitleApiController.class);

  private final ObjectMapper       objectMapper;

  private final HttpServletRequest request;

  @org.springframework.beans.factory.annotation.Autowired
  public TitleApiController(ObjectMapper objectMapper, HttpServletRequest request) {
    this.objectMapper = objectMapper;
    this.request = request;
  }

    public ResponseEntity<Void> addTitleItem(@ApiParam(value = "feature to add"  )  @Valid @RequestBody Title titleItem) {
    String accept = request.getHeader("Accept");
    return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
  }

    public ResponseEntity<Void> deleteTitleItem(@ApiParam(value = "" ,required=true) @RequestHeader(value="type", required=true) String type,@ApiParam(value = "" ,required=true) @RequestHeader(value="name", required=true) String name) {
    String accept = request.getHeader("Accept");
    return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
  }

    public ResponseEntity<List<Title>> searchTitleItem(@ApiParam(value = "select one of type: bonus, episode, season, tvseries, or feature") @Valid @RequestParam(value = "type", required = false) String type,@ApiParam(value = "pass an optional search string") @Valid @RequestParam(value = "searchString", required = false) String searchString) {
    String accept = request.getHeader("Accept");
    if (accept != null && accept.contains("application/json")) {
      Mediameta mediameta = Impl.searchTitleItem(type, searchString, objectMapper);

      log.warn("type:"+type);
      log.warn("searchString:"+searchString);

      List<Title> titles = new ArrayList<>();
      if (null==type || "feature".equals(type)) {
        titles.addAll(mediameta.getFeatures());
      }
      if (null==type || "tvseries".equals(type)) {
        titles.addAll(mediameta.getTvseries());
      }

      return new ResponseEntity(titles,
          HttpStatus.OK);
//            try {
//                return new ResponseEntity<List<Title>>(objectMapper.readValue("[ {  \"name\" : \"Frozen\",  \"description\" : \"a full description which could be used for searches\",  \"type\" : \"one of: bonus, feature, tvseries, season, or episode\",  \"bonuses\" : [ {    \"duration\" : \"12 min\",    \"name\" : \"dwarf meets mickey\",    \"description\" : \"short clip: dwarf visits the park\",    \"type\" : \"bonus\",    \"parentTitle\" : \"Snow White\"  }, {    \"duration\" : \"12 min\",    \"name\" : \"dwarf meets mickey\",    \"description\" : \"short clip: dwarf visits the park\",    \"type\" : \"bonus\",    \"parentTitle\" : \"Snow White\"  } ]}, {  \"name\" : \"Frozen\",  \"description\" : \"a full description which could be used for searches\",  \"type\" : \"one of: bonus, feature, tvseries, season, or episode\",  \"bonuses\" : [ {    \"duration\" : \"12 min\",    \"name\" : \"dwarf meets mickey\",    \"description\" : \"short clip: dwarf visits the park\",    \"type\" : \"bonus\",    \"parentTitle\" : \"Snow White\"  }, {    \"duration\" : \"12 min\",    \"name\" : \"dwarf meets mickey\",    \"description\" : \"short clip: dwarf visits the park\",    \"type\" : \"bonus\",    \"parentTitle\" : \"Snow White\"  } ]} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type application/json", e);
//                return new ResponseEntity<List<Title>>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
    }

    return new ResponseEntity<List<Title>>(HttpStatus.NOT_IMPLEMENTED);
  }

    public ResponseEntity<Void> updateTitleItem(@ApiParam(value = "the json string used for update", required=true) @RequestPart(value="jsonString", required=true)  String jsonString,@ApiParam(value = "one of: bonus, feature, tvseries, season, or episode" ) @RequestHeader(value="type", required=false) String type,@ApiParam(value = "" ) @RequestHeader(value="parentTitle", required=false) String parentTitle) {
    String accept = request.getHeader("Accept");
    return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
  }

}
