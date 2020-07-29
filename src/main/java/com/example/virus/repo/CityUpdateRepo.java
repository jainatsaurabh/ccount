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
public interface CityUpdateRepo extends JpaRepository<CityUpdate, Integer> {

	@Query(value = "select sum(total) from city_update where date=?1", nativeQuery = true)
	public Integer sumByDateTotal(String date);

	@Query(value = "select sum(active) from city_update where date=?1", nativeQuery = true)
	public Integer sumByDateActive(String date);

	@Query(value = "select sum(recover) from city_update where date=?1", nativeQuery = true)
	public Integer sumByDateRecover(String date);

	@Query(value = "select sum(decease) from city_update where date=?1", nativeQuery = true)
	public Integer sumByDateDecease(String date);

//------------------------------------------------------------
	@Query(value = "select sum(total) from city_update where date=?1 and sid=?2", nativeQuery = true)
	public Integer sumByCityUpNameTotal(String date, String name);

	@Query(value = "select sum(active) from city_update where date=?1 and sid=?2", nativeQuery = true)
	public Integer sumByCityUpNameActive(String date, String name);

	@Query(value = "select sum(recover) from city_update where date=?1 and sid=?2", nativeQuery = true)
	public Integer sumByCityUpNameRecover(String date, String name);

	@Query(value = "select  sum(decease) from city_update where date=?1 and sid=?2", nativeQuery = true)
	public Integer sumByCityUpNameDecease(String date, String name);

	// ----------------------------------------------------
	@Query(value = "select sum(total)  from city_update where name=?1", nativeQuery = true)
	public Integer sumByNameTotal(String name);

	@Query(value = "select sum(active) from city_update where name=?1", nativeQuery = true)
	public Integer sumByNameActive(String name);

	@Query(value = "select sum(recover) from city_update where name=?1", nativeQuery = true)
	public Integer sumByNameRecover(String name);

	@Query(value = "select  sum(decease) from city_update where name=?1", nativeQuery = true)
	public Integer sumByNameDecease(String name);

//-------------------------------------------------------------
	@Query(value = "select * from city_update where date=?1", nativeQuery = true)
	public List<CityUpdate> getCityDaily(String date);

	@Query(value = "select * from city_update where date=?1 and name=?2", nativeQuery = true)
	public List<CityUpdate> chkCityUpdate(String date, String name);

	@Modifying
	@Transactional
	@Query(value = "update city_update set  decease=?1, recover=?2, total=?3, active=?4 where date=?5 and name=?6", nativeQuery = true)
	public int updateCityUpdate( int d, int r,int t, int a,String date, String name);

	@Modifying
	@Transactional
	@Query(value = "update city_update set  active=?1, where date=?4 and name=?5", nativeQuery = true)
	public int updateCityUpdateActive( int a, String date, String name);

}
