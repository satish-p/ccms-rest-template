package com.aol.cmi.service;

import com.aol.cmi.model.CpsProfile;

public interface ProfileService {
	/**
	 * Get Raw CpsProfile Data
	 * @param authentication
	 * @param userId
	 * @return
	 */
	CpsProfile getProfile(String userId, String accessToken);

}
