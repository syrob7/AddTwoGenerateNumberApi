
package com.example.demo.schema.response;

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
    "random",
    "bitsUsed",
    "bitsLeft",
    "requestsLeft",
    "advisoryDelay"
})
public class Result {

    @JsonProperty("random")
    private Random random;
    @JsonProperty("bitsUsed")
    private Integer bitsUsed;
    @JsonProperty("bitsLeft")
    private Integer bitsLeft;
    @JsonProperty("requestsLeft")
    private Integer requestsLeft;
    @JsonProperty("advisoryDelay")
    private Integer advisoryDelay;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("random")
    public Random getRandom() {
        return random;
    }

    @JsonProperty("random")
    public void setRandom(Random random) {
        this.random = random;
    }

    @JsonProperty("bitsUsed")
    public Integer getBitsUsed() {
        return bitsUsed;
    }

    @JsonProperty("bitsUsed")
    public void setBitsUsed(Integer bitsUsed) {
        this.bitsUsed = bitsUsed;
    }

    @JsonProperty("bitsLeft")
    public Integer getBitsLeft() {
        return bitsLeft;
    }

    @JsonProperty("bitsLeft")
    public void setBitsLeft(Integer bitsLeft) {
        this.bitsLeft = bitsLeft;
    }

    @JsonProperty("requestsLeft")
    public Integer getRequestsLeft() {
        return requestsLeft;
    }

    @JsonProperty("requestsLeft")
    public void setRequestsLeft(Integer requestsLeft) {
        this.requestsLeft = requestsLeft;
    }

    @JsonProperty("advisoryDelay")
    public Integer getAdvisoryDelay() {
        return advisoryDelay;
    }

    @JsonProperty("advisoryDelay")
    public void setAdvisoryDelay(Integer advisoryDelay) {
        this.advisoryDelay = advisoryDelay;
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
