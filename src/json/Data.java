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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "variableName",
    "measuredUnit",
    "values"
})
public class Data {

    @JsonProperty("variableName")
    private String variableName;
    @JsonProperty("measuredUnit")
    private String measuredUnit;
    @JsonProperty("values")
    private List<Value> values = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Data() {
    }

    public Data(String variableName, String measuredUnit) {
        this.variableName = variableName;
        this.measuredUnit = measuredUnit;
//        this.values = new ArrayList<>();
    }

    @JsonProperty("variableName")
    public String getVariableName() {
        return variableName;
    }

    @JsonProperty("variableName")
    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    @JsonProperty("measuredUnit")
    public String getMeasuredUnit() {
        return measuredUnit;
    }

    @JsonProperty("measuredUnit")
    public void setMeasuredUnit(String measuredUnit) {
        this.measuredUnit = measuredUnit;
    }

    @JsonProperty("values")
    public List<Value> getValues() {
        return values;
    }

    @JsonProperty("values")
    public void setValues(List<Value> values) {
        this.values = values;
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
