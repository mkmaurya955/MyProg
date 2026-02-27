package com.example.jaspersubreport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jaspersubreport.entity.OrderAndOrderItemDTO;
import com.example.jaspersubreport.service.JasperReportService;

@RestController
@RequestMapping("/report")
public class Controller {

	@Autowired
	private JasperReportService jasperReportService;

	@GetMapping("/getData")
	    public List<OrderAndOrderItemDTO> getAll(){
		return jasperReportService.getAllData();
	}

}
