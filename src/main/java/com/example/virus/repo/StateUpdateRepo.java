package com.example.virus.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.virus.entity.CityUpdate;
import com.example.virus.entity.StateUpdate;

@Repository
public interface StateUpdateRepo extends JpaRepository<StateUpdate, String> {
	@Query(value = "select * from state_update where date=?1 ", nativeQuery = true)
	public List<StateUpdate> getStateDaily(String date);
	
	@Query(value = "select * from state_update where date=?1 and sid=?2", nativeQuery = true)
	public List<StateUpdate> chkStateUpdate(String date, String sid);

	@Modifying
	@Transactional
	@Query(value = "update state_update set active=?1, decease=?2, recover=?3, total=?4 where date=?5 and sid=?6", nativeQuery = true)
	public int updateStateUpdate(int a, int d, int r, int t, String date, String sid);
	
}
