package com.example.virus.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.virus.entity.Cities;
import com.example.virus.entity.States;

@Repository
public interface StateRepo extends JpaRepository<States, String> {

	@Query(value = "select * from states where id=?1", nativeQuery = true)
	public States getState(String id);

	@Query(value = "select * from states where scode=?1", nativeQuery = true)
	public States chk(String state);

	@Query(value = "select sum(total) from states", nativeQuery = true)
	public int getTotal();

	@Query(value = "select sum(active) from states", nativeQuery = true)
	public int getSActive();

	@Query(value = "select sum(decease) from states", nativeQuery = true)
	public int getSDecease();

	@Query(value = "select sum(recover) from states", nativeQuery = true)
	public int getSRecover();
	
	@Modifying
	@Transactional
	@Query(value = "update states set active=?1, decease=?2, recover=?3, total=?4, date=?5, time=?6 where id=?7", nativeQuery = true)
	public int upStateData(int a, int d, int r, int t, String dt,String time, String id);

	@Query(value = "select * from states where id=?1 and date=?2", nativeQuery = true)
	public States stateByNameDate(String id,String date);
	
}
