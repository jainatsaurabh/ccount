package com.example.virus.serve;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.virus.entity.States;
import com.example.virus.repo.StateRepo;

@Service
public class ServeStates {
	@Autowired
	StateRepo srepo;

	public List<States> kjgf() {
		return srepo.findAll(Sort.by("total").descending());
	}

	public List<Integer> getTotal() {
		List<Integer> ls = new ArrayList<Integer>();
		ls.add(srepo.getTotal());
		ls.add(srepo.getSDecease());
		ls.add(srepo.getSActive());
		ls.add(srepo.getSRecover());
		return ls;
	}

	public States getLast(String id) {

		return srepo.getState(id);
	}
	public String fgh(String id)
	{
		return srepo.getState(id).getScode();
		
	}
}
