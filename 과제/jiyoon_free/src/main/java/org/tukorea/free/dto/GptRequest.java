package org.tukorea.free.dto;

import java.util.List;

import org.tukorea.free.domain.GptMessageVO;

public class GptRequest {
    private String model;
    private Integer max_tokens;
    private Double temperature;
    private Boolean stream;
    private List<GptMessageVO> messages;
    
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getMax_tokens() {
		return max_tokens;
	}
	public void setMax_tokens(Integer max_tokens) {
		this.max_tokens = max_tokens;
	}
	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	public Boolean getStream() {
		return stream;
	}
	public void setStream(Boolean stream) {
		this.stream = stream;
	}
	public List<GptMessageVO> getMessages() {
		return messages;
	}
	public void setMessages(List<GptMessageVO> messages) {
		this.messages = messages;
	}
	public GptRequest(String model, Integer max_tokens, Double temperature, Boolean stream, List<GptMessageVO> messages) {
		super();
		this.model = model;
		this.max_tokens = max_tokens;
		this.temperature = temperature;
		this.stream = stream;
		this.messages = messages;
	}
	
	
    
    
}
