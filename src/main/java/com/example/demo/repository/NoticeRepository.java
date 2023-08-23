package com.example.demo.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Notice;


@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer>{
	
	public Notice findByNum(Integer num);
	
	public List<Notice> findByTitleLike(String keyword);
	
//	10개씩 잘라서 보여주기
	public List<Notice> findTop10AllByOrderByNumDesc();
	
	public Page<Notice> findAllByOrderByNumDesc(PageRequest pageRequest);
} 