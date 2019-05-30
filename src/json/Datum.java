/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "sourceType",
    "sourceCodeName",
    "sourceData"
})
public class Datum {
    
    @JsonProperty("sourceType")
    private String sourceType;
    @JsonProperty("sourceCodeName")
    private String sourceCodeName;
    @JsonProperty("sourceData")
    private List<Data> data = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Datum() {
    }

    public Datum(String installationCodeName) {
        this.sourceCodeName = installationCodeName;
        this.sourceType = "int";
        this.data = new ArrayList<>();
    }
    
    @JsonProperty("sourceCodeName")
    public String getSourceCodeName() {
        return sourceCodeName;
    }

    @JsonProperty("sourceCodeName")
    public void setSourceCodeName(String sourceCodeName) {
        this.sourceCodeName = sourceCodeName;
    }

    @JsonProperty("sourceData")
    public List<Data> getData() {
        return data;
    }

    @JsonProperty("sourceData")
    public void setData(List<Data> data) {
        this.data = data;
    }
    
    public void addData(Data data){
        this.data.add(data);
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
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
