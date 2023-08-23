package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Notice;
import com.example.demo.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	@GetMapping("/list")
	public String list(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum, Model model) {
		System.out.println(pageNum);
		Page<Notice> list = service.findAll(pageNum);
		long totalRow = service.countAll();
		
		
		long totalPage = ((totalRow - 1) / 5) + 1;
		
		model.addAttribute("list", list);
		model.addAttribute("totalPage", totalPage);

		return "list";
	}
	
	@GetMapping("/insertForm")
	public String insertForm() {
		return "insertForm";
	}
	
	@PostMapping("/insert")
	public String insert(Notice notice) {
		notice.setS_date(LocalDateTime.now());
		service.save(notice);
		
		return "redirect:/list";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam int num, Model model) {
		Notice notice = service.findByNum(num);
		model.addAttribute("notice", notice);
		
		return "detail";
	}
	
	@GetMapping("/hitUpdate")
	public String hitUpdate(@RequestParam int num) {
		Notice notice = service.findByNum(num);
		notice.setHit(notice.getHit() + 1);
		service.update(notice);
		
		return "redirect:/detail?num=" + num;
	}
	
	@GetMapping("/updateForm")
	public String updateForm(@RequestParam int num, Model model) {
		Notice notice = service.findByNum(num);
		model.addAttribute("notice", notice);
		
		return "updateForm";
	}
	
	@PostMapping("/update")
	public String update(Notice notice) {
		notice.setS_date(LocalDateTime.now());
		System.out.print(notice.getNum());
		service.update(notice);
		
		return "redirect:/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam int num) {
		service.delete(num);
		
		return "redirect:/list";
	}
	
	@PostMapping("/search")
	public String search(@RequestParam String keyword, Model model) {
		List<Notice> list = service.search(keyword);
		model.addAttribute("list", list);
		
		return "list";
	}
}
