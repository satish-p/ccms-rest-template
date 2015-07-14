package app.service;

import app.model.CpsProfile;

public interface ProfileService {
	/**
	 * Get Raw CpsProfile Data
	 * @param authentication
	 * @param userId
	 * @return
	 */
	CpsProfile getProfile(String userId, String accessToken);

}
