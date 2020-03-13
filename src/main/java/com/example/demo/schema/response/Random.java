
package com.example.demo.schema.response;

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
    "data",
    "completionTime"
})
public class Random {

    @JsonProperty("data")
    private List<Integer> data = null;
    @JsonProperty("completionTime")
    private String completionTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("data")
    public List<Integer> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Integer> data) {
        this.data = data;
    }

    @JsonProperty("completionTime")
    public String getCompletionTime() {
        return completionTime;
    }

    @JsonProperty("completionTime")
    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
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
