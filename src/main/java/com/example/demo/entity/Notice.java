package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int num;
	private String title;
	private String info;
	private LocalDateTime s_date;
	private int hit;
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public LocalDateTime getS_date() {
		return s_date;
	}
	public void setS_date(LocalDateTime localDateTime) {
		this.s_date = localDateTime;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}

}
