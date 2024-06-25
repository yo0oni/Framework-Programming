package org.tukorea.free.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScheduleVO {
	private int id;
	private String date;
	private String detail;
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public ScheduleVO() {
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDetail() {
		return detail;
	}

	public List<String> getDetailList() {
		if (detail != null) {
			return Arrays.asList(detail.split("\n"));
		}
		return new ArrayList<>();
	}

	public ScheduleVO(String date, List<String> detail) {
		this.date = date;
		this.detail = String.join("\n", detail);
	}

	public void setDetailList(List<String> detailList) {
		this.detail = String.join("\n", detailList);

	}

}
