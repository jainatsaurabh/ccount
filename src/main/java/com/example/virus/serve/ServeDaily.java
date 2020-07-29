package com.example.virus.serve;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.virus.entity.CityUpdate;
import com.example.virus.entity.StateUpdate;
import com.example.virus.repo.CityRepo;
import com.example.virus.repo.CityUpdateRepo;
import com.example.virus.repo.StateUpdateRepo;

@Service
public class ServeDaily {

	@Autowired
	private CityUpdateRepo drepo;
	@Autowired
	private StateUpdateRepo sdrepo;

	public List<Integer> getDailyUpdateForStates() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		List<Integer> ls = new ArrayList<Integer>();
		if (drepo.sumByDateTotal(date) >0) {
			ls.add(drepo.sumByDateTotal(date));
			ls.add(drepo.sumByDateActive(date));
			ls.add(drepo.sumByDateDecease(date));
			ls.add(drepo.sumByDateRecover(date));
			return ls;
		} else {
			ls.add(0);
			ls.add(0);
			ls.add(0);
			ls.add(0);
			return ls;
		}
	}

	public List<Integer> getDailyUpdateForCities(String id) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());int x=9;
		List<Integer> ls = new ArrayList<Integer>();
		if (drepo.sumByCityUpNameTotal(date, id) >0) {
			ls.add(drepo.sumByCityUpNameTotal(date, id));
			ls.add(drepo.sumByCityUpNameActive(date, id));
			ls.add(drepo.sumByCityUpNameDecease(date, id));
			ls.add(drepo.sumByCityUpNameRecover(date, id));
			return ls;
		} else {
			ls.add(0);
			ls.add(0);
			ls.add(0);
			ls.add(0);
			return ls;
		}
	}

	public List<StateUpdate> stateListUpdate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		if (sdrepo.getStateDaily(sdf.format(new Date())).size() > 0) {
			return sdrepo.getStateDaily(sdf.format(new Date()));
		} else {
			String ndate = sdf.format(new Date(new Date().getTime() - 1 * 24 * 3600 * 1000l));
			return sdrepo.getStateDaily(ndate);
		}
	}

	public List<CityUpdate> cityListUpdate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		if (drepo.getCityDaily(sdf.format(new Date())).size() > 0) {
			return drepo.getCityDaily(sdf.format(new Date()));
		} else {
			String ndate = sdf.format(new Date(new Date().getTime() - 1 * 24 * 3600 * 1000l));
			return drepo.getCityDaily(ndate);
		}
	}

}
