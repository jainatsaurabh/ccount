package com.example.virus.serve;

import java.util.Date;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.virus.entity.Cities;
import com.example.virus.entity.States;
import com.example.virus.repo.CityRepo;
import com.example.virus.repo.StateRepo;

@Service
public class ServeState {

	@Autowired
	StateRepo srepo;

	@Autowired
	CityRepo crepo;

	public String saveData(States s) {
		int l = s.getCity().size();
		if(l<0)
			System.out.println("size 0");
		if(l>0)
			System.out.println("size 0+");
		s.setDate(new Date().toString());
		int active = 0, recover = 0, total = 0,decease=0;
		Iterator<Cities> itr = s.getCity().iterator();
		while (itr.hasNext()) {
			itr.next().setDate(new Date().toString());
			active += itr.next().getActive();
			recover += itr.next().getActive();
			decease += itr.next().getActive();
		}
		total=active+recover+decease;
		s.setTotal(s.getTotal()+total);
		s.setActive(s.getActive()+active);
		s.setDecease(s.getDecease()+decease);
		//srepo.findById(s.getScode());
		
		if (srepo.save(s) != null)

			return " saved ";
		else
			return " no ";
	}

}
