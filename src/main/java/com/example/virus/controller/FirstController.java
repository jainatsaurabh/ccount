package com.example.virus.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.virus.entity.Cities;
import com.example.virus.entity.CityUpdate;
import com.example.virus.entity.States;
import com.example.virus.repo.CityUpdateRepo;
import com.example.virus.serve.ServeAll;
import com.example.virus.serve.ServeCities;
import com.example.virus.serve.ServeDaily;
import com.example.virus.serve.ServeStates;

@Controller
public class FirstController {

	@Autowired
	private ServeAll serve;

	@Autowired
	private ServeStates servest;
	@Autowired
	private ServeCities servect;

	@Autowired
	private ServeDaily servedl;
	@Autowired
	private CityUpdateRepo cup;

	@RequestMapping("saveData")
	@ModelAttribute("cityData")
	public Cities getData() {

		return new Cities();
	}

	@RequestMapping("/login")
	public String kjhgvv() {
		return "login";
	}

	@PostMapping("/saveCity")
	public String kjhgvf() {

		return "save";
	}

	@RequestMapping("/process")
	public ModelAndView jhgfxcvjh(@SessionAttribute("c") List<String> c, @SessionAttribute("dls") List<Integer> dls) {
		ModelAndView mv = new ModelAndView("login");
		String sid = serve.updateCityUp(c, dls);
		serve.updateCity(c);
		serve.updateStateUp(sid);
		serve.updateState(sid);
		mv.addObject("sucess", "Data Saved Sucessfully");
		return mv;
	}

	@RequestMapping("/homePage")
	public ModelAndView jhgc() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("states", servest.kjgf());
		mv.addObject("stateTotal", servest.getTotal());
		mv.addObject("daily", servedl.getDailyUpdateForStates());
		mv.addObject("last", serve.lastUpdate());
		mv.addObject("dailyState", servedl.stateListUpdate());

		return mv;
	}

	@RequestMapping("/citiess")
	public ModelAndView skdjfhf(@RequestParam("st") String st) {
		ModelAndView mv = new ModelAndView("city");
		List<Cities> ls = servect.getCities(st);
		mv.addObject("sname", servest.fgh(st));
		mv.addObject("city", ls);
		mv.addObject("stat", servest.getLast(st));
		mv.addObject("getdail", servedl.getDailyUpdateForCities(st));
		mv.addObject("dailyCity", servedl.cityListUpdate());
		return mv;
	}

	@PostMapping("/loginchk")
	public ModelAndView loginState(@RequestParam("state") String state, @RequestParam("password") String password) {
		ModelAndView mv;
		if (serve.loginChk(state, password) == "no") {
			mv = new ModelAndView("login");
			mv.addObject("cities", "sorry...You Entered Wrong Password!");
			return mv;
		} else {
			mv = new ModelAndView("welcome");
			List<Cities> ls = (List<Cities>) serve.loginChk(state, password);
			mv.addObject("st", state);
			mv.addObject("cities", ls);
			return mv;
		}
	}
}
