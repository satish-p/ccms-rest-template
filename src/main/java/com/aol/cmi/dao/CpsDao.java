package com.aol.cmi.dao;

import com.aol.cmi.model.CpsProfile;

public interface CpsDao {
	CpsProfile getCpsData(String screenName, String accessToken);
}
