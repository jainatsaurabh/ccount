package com.example.virus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.virus.entity.Cities;
import com.example.virus.entity.States;
import com.example.virus.serve.ServeState;

@Controller
public class FirstController {

	@Autowired
	private ServeState serve;

	@RequestMapping("/find")
	public String jhgf() {
		return "first";
	}

	@RequestMapping("saveData")
	@ModelAttribute("cityData")
	public Cities getData() {
		return new Cities();
	}

	@PostMapping("/saveCity")
	public Object sdfgh(@ModelAttribute("cityData") Cities city) {
		//System.out.println("saveCity......................................");
		return serve.saveCityIn(city);
	}

//	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE,
//			MediaType.TEXT_PLAIN_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
//	public String jhg(States s) {
//		return serve.saveData(s);
//	}

}
