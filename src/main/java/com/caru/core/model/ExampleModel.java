package com.caru.core.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "message")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExampleModel {
	@XmlElement
	public Result result;
	
    public static class Result {
    	@XmlElement
    	@JsonProperty
        public String searchTarget;
    	@XmlElement
    	@JsonProperty
    	public String itemComposition;
    	@XmlElement
    	@JsonProperty
    	public String query;
    	@XmlElement
    	@JsonProperty
    	public String highlightQuery;
    	@XmlElement
    	@JsonProperty
    	public String patternQuery;
    	@XmlElement
    	@JsonProperty
    	public String patternType;
    	@XmlElement
    	@JsonProperty
    	public String start;
    	@XmlElement
    	@JsonProperty
    	public String isTruncationQuery;
    	@XmlElement
    	@JsonProperty
    	public String isInvalidTruncationQuery;	
    	@XmlElement
    	@JsonProperty
    	public String detailedSearchType;
    	@XmlElement
    	@JsonProperty
    	public String collectionType;
    	@XmlElement
    	@JsonProperty
    	public String itemCount;
    	@XmlElement
    	@JsonProperty
    	public String total;    	
    	@XmlElement
    	@JsonProperty
    	public String homonymTotal;

    	@XmlElement
    	@JsonProperty
    	public Items items;
    	
    	public static class Items {
    		@XmlElement
    		public List<Item> item;
    	}
    }	    
	
    public static class Item {
        @JsonProperty
        @XmlElement
        public String relevance;
        @JsonProperty
        @XmlElement
        public String rfrank;
        @JsonProperty
        @XmlElement
        public String similarity;
        @JsonProperty
        @XmlElement
        public String quality;
        @JsonProperty
        @XmlElement
        public String rank;
        @JsonProperty
        @XmlElement
        public String gdid;
        @JsonProperty
        @XmlElement
        public String id;
        @JsonProperty
        @XmlElement
        public String exampleId;
        @JsonProperty
        @XmlElement
        public String matchType;
        @JsonProperty
        @XmlElement
        public String destinationLink;
        @JsonProperty
        @XmlElement
        public String entry;
        @JsonProperty
        @XmlElement
        public String superscript;
        @JsonProperty
        @XmlElement
        public String body;
    }
}