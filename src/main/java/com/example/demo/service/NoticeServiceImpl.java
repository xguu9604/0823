package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Notice;
import com.example.demo.repository.NoticeRepository;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private NoticeRepository repository;
	
	@Override
	public Page<Notice> findAll(Integer pageNum) {
		return repository.findAllByOrderByNumDesc(PageRequest.of(pageNum - 1, 5));
	}
	
	@Override
	public Notice findByNum(Integer num) {
		return repository.findByNum(num);
	}
	
	@Override
	public Notice save(Notice notice) {
		return repository.save(notice);
	}
	
	@Override
	public Notice update(Notice notice) {
		return repository.save(notice);
	}
	
	@Override
	public void delete(Integer num) {
		repository.deleteById(num);
	}
	
	@Override
	public List<Notice> search(String keyword) {
		return repository.findByTitleLike("%" + keyword + "%");
	}
	
	@Override
	public long countAll() {
		return repository.count();
	}
}
