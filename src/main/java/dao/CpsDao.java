package dao;

import model.CpsProfile;

public interface CpsDao {
	CpsProfile getCpsData(String screenName, String accessToken);
}
