package com.example.virus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.virus.entity.States;
import com.example.virus.serve.ServeState;

@RestController
public class FirstController {

	@Autowired
	private ServeState serve;

	@RequestMapping("/first")
	public String jhgf() {
		return "first";
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.TEXT_PLAIN_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public String jhg(States s) {
		return serve.saveData(s);
	}

}
