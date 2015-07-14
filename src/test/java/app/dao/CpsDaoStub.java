package app.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.model.CpsProfile;
import app.model.profile.CpsBenefit;
import app.model.profile.CpsSubscription;
import app.model.profile.NameValuePairs;

public class CpsDaoStub {

	public static CpsProfile createCpsData(String screenName) {
		CpsProfile profile = new CpsProfile();
		profile.setErrors(createErrors());
		profile.setNameValuePairs(createNameValuePairs(screenName));
		profile.setErrorCount(0);
		return profile;
	}

	private static Map<String, Object> createErrors() {
		Map<String, Object> errorMap = new HashMap<String, Object>();
		return errorMap;
	}

	public static CpsBenefit createBenefit() {
		CpsBenefit cpsBenefit = new CpsBenefit();
		cpsBenefit.setEffectiveDate(new Date());
		cpsBenefit.setName("Lifelock");
		cpsBenefit.setProductClass("Identity");
		cpsBenefit.setProductFamily("iden");
		cpsBenefit.setStatus("ACTIVE");
		cpsBenefit.setSvuProdId("110789");
		return cpsBenefit;
	}

	public static CpsSubscription createSubscription() {
		CpsSubscription cpsSub = new CpsSubscription();
		cpsSub.setEffectiveDate(new Date());
		cpsSub.setName("Lifelock");
		cpsSub.setProductClass("Identity");
		cpsSub.setProductFamily("iden");
		cpsSub.setStatus("ACTIVE");
		cpsSub.setSvuProdId("110789");
		cpsSub.setId("1");
		cpsSub.setAttributes(new HashMap<String, String>());
		return cpsSub;
	}

	public static NameValuePairs createNameValuePairs(String screenName) {
		NameValuePairs nameValuePairs = new NameValuePairs();
		//nameValuePairs.setBenefits(createBenefitsMap(screenName));
		nameValuePairs.setSubs(createSubsMap(screenName));
		nameValuePairs.setBid(1);
		nameValuePairs.setCareStatus(1);
		nameValuePairs.setCategoryId(1);
		nameValuePairs.setEmail("viktest@aol.com");
		nameValuePairs.setFreeMonths(1);
		nameValuePairs.setGuid(screenName);
		nameValuePairs.setIsFreePI(true);
		nameValuePairs.setIsMFAccount(true);
		nameValuePairs.setIsPendingCancel(false);
		nameValuePairs.setMasterAccountNumber(11223344l);
		nameValuePairs.setMasterSN("viktest3");
		nameValuePairs.setMonthlyFee(0);
		nameValuePairs.setOnsBid("1");
		nameValuePairs.setOnsType("2");
		nameValuePairs.setOsb(0);
		nameValuePairs.setPendingPI(3);
		nameValuePairs.setPi(2);
		nameValuePairs.setSid(2);
		nameValuePairs.setPmi(4);
		nameValuePairs.setSn(screenName);
		nameValuePairs.setSnList(Arrays.asList(screenName));
		nameValuePairs.setSnType("M");
		nameValuePairs.setTenure(new Date());
		nameValuePairs.setZip("20166");
		return nameValuePairs;
	}

	public static Map<String, Map<String, CpsBenefit>> createBenefitsMap(String screenName) {
		Map<String, Map<String, CpsBenefit>> benefitsMap = new HashMap<>();
		Map<String, CpsBenefit> benefitsSubMap = new HashMap<>();
		benefitsSubMap.put("60317", createBenefit());
		benefitsMap.put("viktest3", benefitsSubMap );
		return benefitsMap;
	}

	public static Map<String, List<CpsSubscription>> createSubsMap(String screenName) {
		Map<String, List<CpsSubscription>> subMap = new HashMap<>();
		List<CpsSubscription> subsList = new ArrayList<>();
		subsList.add(createSubscription());
		subMap.put(screenName, subsList );
		return subMap;
	}


}
