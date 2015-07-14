package service;

import model.CpsProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CpsDao;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private CpsDao cpsDao;

	@Override
	public CpsProfile getProfile(String userId, String accessToken) {
		return cpsDao.getCpsData(userId, accessToken);
	}

}
