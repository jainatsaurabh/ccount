package com.example.virus.serve;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.virus.entity.Cities;
import com.example.virus.repo.CityRepo;

@Service
public class ServeCities {
@Autowired
private CityRepo crepo;

public List<Cities> getCities(String st) {
	return crepo.getCitieList(st);
}

public List<Integer> getTotal() {
	List<Integer> ls=new ArrayList<Integer>();
	ls.add(crepo.getSumTotal());
	ls.add(crepo.getSumDecease());
	ls.add(crepo.getSumActive());
	ls.add(crepo.getSumReccover());
	return ls;
}

}
