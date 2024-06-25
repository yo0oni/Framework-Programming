package org.tukorea.free.domain;

public class GptMessageVO {
	
    private String role;
    private String content;
    
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public GptMessageVO(String role, String content) {
		this.role = role;
		this.content = content;
	}
    
	public GptMessageVO() {
		
	}
	
}