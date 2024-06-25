package org.tukorea.free.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVO {

	private String id;
	private String password;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	public void password(String password) {
		this.password = password;
	}
}