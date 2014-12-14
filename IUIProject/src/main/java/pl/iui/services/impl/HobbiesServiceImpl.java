package pl.iui.services.impl;

import java.util.ArrayList;
import java.util.List;

import pl.iui.dao.user.HobbiesDao;
import pl.iui.domain.user.HobbiesEntity;
import pl.iui.services.HobbiesService;

public class HobbiesServiceImpl implements HobbiesService {
	
	private HobbiesDao hobbiesDao;

	@Override
	public List<HobbiesEntity> getAllHobbies() {
		// TODO Auto-generated method stub
		return hobbiesDao.findAll();
	
	}

	public HobbiesDao getHobbiesDao() {
		return hobbiesDao;
	}

	public void setHobbiesDao(HobbiesDao hobbiesDao) {
		this.hobbiesDao = hobbiesDao;
	}
	
	

}
