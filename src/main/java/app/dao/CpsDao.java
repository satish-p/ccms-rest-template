package app.dao;

import app.model.CpsProfile;

public interface CpsDao {
	CpsProfile getCpsData(String screenName, String accessToken);
}
