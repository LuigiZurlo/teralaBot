/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "sourceType",
    "sourceCodeName",
    "latitude",
    "longitude",
    "elevation",
    "cityCode",
    "locationName",
    "timestamp"
})
public class RegisterEnvironmentDeviceLocation {
    
    @JsonProperty("sourceType")
    private String sourceType;
    @JsonProperty("sourceCodeName")
    private String sourceCodeName;
    @JsonProperty("originLocationCode")
    private String originLocationCode;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("elevation")
    private BigDecimal elevation;
    @JsonProperty("cityCode")
    private String cityCode;
    @JsonProperty("locationName")
    private String locationName;
    @JsonProperty("relocationTimestamp")
    private Object relocationTimestamp;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public RegisterEnvironmentDeviceLocation(String installationCodeName, Double latitude, Double longitude, BigDecimal elevation, String locationName) {
        this.sourceCodeName = installationCodeName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
        this.locationName = locationName;
        this.cityCode = "PAI";
        this.relocationTimestamp = null;
        this.sourceType = "int";
    }

    
    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }
    
    @JsonProperty("sourceCodeName")
    public String getSourceCodeName() {
        return sourceCodeName;
    }

    @JsonProperty("sourceCodeName")
    public void setSourceCodeName(String sourceCodeName) {
        this.sourceCodeName = sourceCodeName;
    }

    @JsonProperty("latitude")
    public Double getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("longitude")
    public Double getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("elevation")
    public BigDecimal getElevation() {
        return elevation;
    }

    @JsonProperty("elevation")
    public void setElevation(BigDecimal elevation) {
        this.elevation = elevation;
    }

    @JsonProperty("cityCode")
    public String getCityCode() {
        return cityCode;
    }

    @JsonProperty("cityCode")
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    @JsonProperty("locationName")
    public String getLocationName() {
        return locationName;
    }

    @JsonProperty("locationName")
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @JsonProperty("timestamp")
    public Object getRelocationTimestamp() {
        return relocationTimestamp;
    }

    @JsonProperty("timestamp")
    public void setRelocationTimestamp(Object relocationTimestamp) {
        this.relocationTimestamp = relocationTimestamp;
    }

    

    public String getOriginLocationCode() {
        return originLocationCode;
    }

    public void setOriginLocationCode(String originLocationCode) {
        this.originLocationCode = originLocationCode;
    }
    

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
