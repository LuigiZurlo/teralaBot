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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "sourceCodeName",
    "brand",
    "model",
    "version"
})
public class RegisterEnvironmentDevice {

    @JsonProperty("sourceCodeName")
    private String sourceCodeName;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("model")
    private String model;
    @JsonProperty("version")
    private String version;
    @JsonProperty("nativeDeviceId")
    private String nativeDeviceId;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public RegisterEnvironmentDevice(String installationCodeName) {
        this.sourceCodeName = installationCodeName;
        this.brand = "PurpleAir";
        this.model = "PA-II";
        this.version = null;
    }

    public String getNativeDeviceId() {
        return nativeDeviceId;
    }

    public void setNativeDeviceId(String nativeDeviceId) {
        this.nativeDeviceId = nativeDeviceId;
    }
    
    

    @JsonProperty("sourceCodeName")
    public String getSourceCodeName() {
        return sourceCodeName;
    }

    @JsonProperty("sourceCodeName")
    public void setSourceCodeName(String sourceCodeName) {
        this.sourceCodeName = sourceCodeName;
    }

    @JsonProperty("brand")
    public String getBrand() {
        return brand;
    }

    @JsonProperty("brand")
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    @JsonProperty("model")
    public void setModel(String model) {
        this.model = model;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
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
