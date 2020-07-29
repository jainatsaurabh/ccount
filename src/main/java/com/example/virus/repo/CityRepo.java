package com.example.virus.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.virus.entity.Cities;

@Repository
public interface CityRepo extends JpaRepository<Cities, String> {

	@Query(value = "select * from cities where ccode=?1", nativeQuery = true)
	public Cities findCity(String name);

	@Query(value = "select state_id from cities where ccode=?1", nativeQuery = true)
	public String findScode(String name);

	@Query(value = "update LastUp set dt=?1 ")
	public void setLast(String date);

	@Modifying
	@Transactional
	@Query(value = "UPDATE cities  set active=?1, decease=?2, recover=?3, total=?4,date=?5 WHERE ccode =?6", nativeQuery = true)
	public void upCityData(int a, int d, int r, int t, String dt, String cd);

	@Query(value = "select * from cities where state_id=?1 ORDER BY total DESC", nativeQuery = true)
	public List<Cities> getCitieList(String s_id);

//-----------------------------------------------------------------
	@Query(value = "select sum(total) from cities", nativeQuery = true)
	public Integer getSumTotal();

	@Query(value = "select sum(active) from cities", nativeQuery = true)
	public Integer getSumActive();

	@Query(value = "select sum(decease) from cities", nativeQuery = true)
	public Integer getSumDecease();

	@Query(value = "select sum(Recover) from cities", nativeQuery = true)
	public Integer getSumReccover();

	// --------------------------------------------------------------

	@Query(value = "select sum(total) from cities where state_id=?1", nativeQuery = true)
	public Integer getSumTotalC(String sid);

	@Query(value = "select sum(active) from cities where state_id=?1", nativeQuery = true)
	public Integer getSumActiveC(String sid);

	@Query(value = "select sum(decease) from cities where state_id=?1", nativeQuery = true)
	public Integer getSumDeceaseC(String sid);

	@Query(value = "select sum(Recover) from cities where state_id=?1", nativeQuery = true)
	public Integer getSumReccoverC(String sid);

	//----------------------------------------------------------------
	@Query(value = "select * from cities where ccode=?1 and date=?2", nativeQuery = true)
	public Cities cityByNameDate(String name,String date);

}
