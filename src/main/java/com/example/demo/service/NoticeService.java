package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.entity.Notice;

public interface NoticeService {

	public Page<Notice> findAll(Integer pageNum);
	
	public Notice findByNum(Integer num);
	
	public Notice save(Notice notice);
	
	public Notice update(Notice notice);
	
	public void delete(Integer num);
	
	public List<Notice> search(String keyword);
	
	public long countAll();
}
