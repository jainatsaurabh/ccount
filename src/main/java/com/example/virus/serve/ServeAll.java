package com.example.virus.serve;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.virus.entity.Cities;
import com.example.virus.entity.CityUpdate;
import com.example.virus.entity.StateUpdate;
import com.example.virus.entity.States;
import com.example.virus.repo.CityRepo;
import com.example.virus.repo.CityUpdateRepo;
import com.example.virus.repo.LastRepo;
import com.example.virus.repo.StateRepo;
import com.example.virus.repo.StateUpdateRepo;

@Service
public class ServeAll {
	static String date;
	static String time;
	static String preDate;
	static {
		date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		time = new SimpleDateFormat("HH:mm:ss EE").format(new Date());
		preDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date(new Date().getTime() - 1 * 24 * 3600 * 1000l));
	}

	@Autowired
	StateRepo srepo;
	@Autowired
	CityRepo crepo;
	@Autowired
	CityUpdateRepo drepo;
	@Autowired
	LastRepo lrepo;
	@Autowired
	StateUpdateRepo sdrepo;
	@Autowired
	ServeDaily sdaily;

	public Object loginChk(String state, String password) {
		States st = srepo.chk(state);
		if (st.getPass().equals(password)) {
			List<Cities> ls = crepo.getCitieList(st.getId());
			return ls;
		} else
			return "no";
	}

	public String lastUpdate() {
		return lrepo.getLastUpdate();
	}

	public String update(List<String> c, List<Integer> ls) {
		lrepo.setLast(new Date().toString());
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String time = new SimpleDateFormat("HH:mm:ss EE").format(new Date());
		String preDate = new SimpleDateFormat("yyyy-MM-dd")
				.format(new Date(new Date().getTime() - 1 * 24 * 3600 * 1000l));
		States state = srepo.getState(crepo.findScode(c.get(0)));
		int x = 0;
		for (int i = 0; i < c.size(); i++) {
			String ct = c.get(i);
			int n = ls.get(x);
			int r = ls.get(x + 1);
			int d = ls.get(x + 2);

			Cities cit = crepo.findCity(ct);

			int active = (cit.getActive() + n) - (d + r);

			List<CityUpdate> temp = drepo.chkCityUpdate(date, cit.getCcode());
			if (temp.size() == 0) {
				crepo.upCityData((cit.getActive() + n) - (d + r), cit.getDecease() + d, cit.getRecover() + r,
						cit.getTotal() + n, date, cit.getCcode());
				drepo.save(new CityUpdate(state.getId(), cit.getCcode(), date, cit.getActive() + n - (d + r),
						cit.getTotal() + n, d, r));
			} else {
				int ac = temp.get(0).getActive();
				int dc = temp.get(0).getDecease();
				int rec = temp.get(0).getRecover();
				int ttl = temp.get(0).getTotal();
				if (n == 0) {
					n = ttl;
				}
				if (r == 0) {
					r = rec;
				}
				if (d == 0) {
					d = dc;
				}
				crepo.upCityData((cit.getActive() + (ac - active)), cit.getDecease() + (dc - d),
						cit.getRecover() + (rec - r), cit.getTotal() + ((n - ttl) - ttl), date, cit.getCcode());
				// drepo.updateCityUpdate(cit.getActive() + (ac - active), d, r, cit.getTotal()
				// + (n - ttl), date,
				// cit.getCcode());
			}
			x = x + 3;
		}

		String sid = state.getId();
		List<Integer> list = sdaily.getDailyUpdateForCities(sid);
		List<StateUpdate> tem = sdrepo.chkStateUpdate(date, sid);
		int sac = list.get(1);
		int sd = list.get(2);
		int sr = list.get(3);
		int st = list.get(0);
		if (sdrepo.chkStateUpdate(date, sid).size() == 0) {

			srepo.upStateData(sac, state.getDecease() + sd, state.getRecover() + sr, st, date, time, sid);
			sdrepo.save(new StateUpdate(sid, state.getActive() + sac, sr, sd, st, date));
		} else {// active-1 //recover-3 //decease-2 //total-0

			int ac = tem.get(0).getActive();
			int dc = tem.get(0).getDecease();
			int rec = tem.get(0).getRecover();
			int ttl = tem.get(0).getTotal();
			srepo.upStateData(state.getActive() + (ac - sac), state.getDecease() + (dc - sd),
					state.getRecover() + (sr - rec), state.getTotal() + ttl, date, time, sid);
			sdrepo.updateStateUpdate(state.getActive() + (ac - sac), dc, rec, state.getTotal() + ttl, date, sid);
		}
		return "saved";
	}

	public String updateCityUp(List<String> c, List<Integer> ls) {

		int x = 0;
		String sid = srepo.getState(crepo.findScode(c.get(0))).getId();
		for (int i = 0; i < c.size(); i++) {
			String cname = c.get(i);
			int n = ls.get(x);
			int r = ls.get(x + 1);
			int d = ls.get(x + 2);

			Cities city = crepo.findCity(cname);
			List<CityUpdate> cu = drepo.chkCityUpdate(date, cname);// total-0,recover-3,active-1,decease-2
			System.out.println(cu.size()+" size of cityupdate");
			if (cu.size() == 0) {// City_update
				drepo.save(new CityUpdate(sid, cname, date, city.getActive() + (n - (d + r)), n, d, r));

				{// City-----

					Cities cityn = crepo.findCity(cname);
					List<CityUpdate> cup = drepo.chkCityUpdate(date, cname);

					crepo.upCityData(cup.get(0).getActive(), cityn.getDecease() + cup.get(0).getDecease(),
							cityn.getRecover() + cup.get(0).getRecover(), cityn.getTotal() + cup.get(0).getTotal(),
							date, cname);

				}

			} else {
				if(r==0)
				{
					r=cu.get(0).getRecover();
				}
				if(d==0)
				{
					d=cu.get(0).getDecease();
				}
				if(n==0)
				{
					n=cu.get(0).getTotal();
				}
				int rec = r - cu.get(0).getRecover();
				int dec = d - cu.get(0).getDecease();
				int ttl = n - cu.get(0).getTotal();
				int act=ttl-(rec+dec); 
				drepo.updateCityUpdate(d, r, n, cu.get(0).getActive()+act,date, cname);
//				List<CityUpdate> cun = drepo.chkCityUpdate(sid, cname);
//				int ac = cun.get(0).getTotal() - (cun.get(0).getDecease() + cun.get(0).getRecover());
//				drepo.updateCityUpdateActive(ac, sid, cname);

				{
					Cities cityn = crepo.findCity(cname);

					crepo.upCityData(cityn.getActive()+act, cityn.getDecease() + dec,
							cityn.getRecover() + rec, cityn.getTotal() +ttl,
							date, cname);

				}
			}

			x = x + 3;
		}
		return sid;

	}

	public void updateCity(List<String> c) {

		for (int i = 0; i < c.size(); i++) {
			String name = c.get(i);

		}
	}

	public void updateStateUp(String sid) {
		List<StateUpdate> sup = sdrepo.chkStateUpdate(date, sid);
		List<Integer> cup = sdaily.getDailyUpdateForCities(sid);
		if (sup.size() == 0) {
			sdrepo.save(new StateUpdate(sid, cup.get(1), cup.get(3), cup.get(2), cup.get(0), date));
		} else {
			sdrepo.updateStateUpdate(cup.get(1), cup.get(2), cup.get(3), cup.get(0), date, sid);
		}
	}

	public void updateState(String sid) {
		States state = srepo.getState(sid);
		List<StateUpdate> sup = sdrepo.chkStateUpdate(date, sid);
		srepo.upStateData(crepo.getSumActiveC(sid), crepo.getSumDeceaseC(sid),
				crepo.getSumReccoverC(sid), crepo.getSumTotalC(sid), date, time,
				sid);
	}

}
