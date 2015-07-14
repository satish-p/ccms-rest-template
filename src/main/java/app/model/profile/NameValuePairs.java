package app.model.profile;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(Include.NON_NULL)  
public class NameValuePairs {
	private String sn;
	private List<String> snList;
	private String masterSN;
	private Long masterAccountNumber;
	private Integer bid;
	private Integer sid;
	private Date tenure;
	private Integer pi;
	private Integer categoryId;
	private Boolean isFreePI;
	private Integer monthlyFee;
	private Integer pendingPI;
	private Integer pmi;
	private String zip;
	private Integer careStatus;
	private Boolean isPendingCancel;
	private Integer freeMonths;
	private String snType;
	private String email;
	private String onsBid;
	private String onsType;
	private String guid;
	private Boolean isMFAccount;
	private Integer osb;
	private Map<String, List<CpsSubscription>> subs;
	private Map<String, List<CpsBenefit>> snToBenefitsMap;
	
	private Map<String, Boolean> mfFlags;
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public List<String> getSnList() {
		return snList;
	}
	public void setSnList(List<String> snList) {
		this.snList = snList;
	}
	public String getMasterSN() {
		return masterSN;
	}
	public void setMasterSN(String masterSN) {
		this.masterSN = masterSN;
	}
	public Long getMasterAccountNumber() {
		return masterAccountNumber;
	}
	public void setMasterAccountNumber(Long masterAccountNumber) {
		this.masterAccountNumber = masterAccountNumber;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Date getTenure() {
		return CpsCommon.createDate(tenure);
	}
	public void setTenure(Date tenure) {
		this.tenure = CpsCommon.createDate(tenure);
	}
	public Integer getPi() {
		return pi;
	}
	public void setPi(Integer pi) {
		this.pi = pi;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Boolean getIsFreePI() {
		return isFreePI;
	}
	public void setIsFreePI(Boolean isFreePI) {
		this.isFreePI = isFreePI;
	}
	public Integer getMonthlyFee() {
		return monthlyFee;
	}
	public void setMonthlyFee(Integer monthlyFee) {
		this.monthlyFee = monthlyFee;
	}
	public Integer getPendingPI() {
		return pendingPI;
	}
	public void setPendingPI(Integer pendingPI) {
		this.pendingPI = pendingPI;
	}
	public Integer getPmi() {
		return pmi;
	}
	public void setPmi(Integer pmi) {
		this.pmi = pmi;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public Integer getCareStatus() {
		return careStatus;
	}
	public void setCareStatus(Integer careStatus) {
		this.careStatus = careStatus;
	}
	public Boolean getIsPendingCancel() {
		return isPendingCancel;
	}
	public void setIsPendingCancel(Boolean isPendingCancel) {
		this.isPendingCancel = isPendingCancel;
	}
	public Integer getFreeMonths() {
		return freeMonths;
	}
	public void setFreeMonths(Integer freeMonths) {
		this.freeMonths = freeMonths;
	}
	public String getSnType() {
		return snType;
	}
	public void setSnType(String snType) {
		this.snType = snType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOnsBid() {
		return onsBid;
	}
	public void setOnsBid(String onsBid) {
		this.onsBid = onsBid;
	}
	public String getOnsType() {
		return onsType;
	}
	public void setOnsType(String onsType) {
		this.onsType = onsType;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public Boolean getIsMFAccount() {
		return isMFAccount;
	}
	public void setIsMFAccount(Boolean isMFAccount) {
		this.isMFAccount = isMFAccount;
	}
	public Integer getOsb() {
		return osb;
	}
	public void setOsb(Integer osb) {
		this.osb = osb;
	}
	public Map<String, List<CpsSubscription>> getSubs() {
		return subs;
	}
	public void setSubs(Map<String, List<CpsSubscription>> subs) {
		this.subs = subs;
	}
	public Map<String, List<CpsBenefit>> getBenefitsList() {
		return snToBenefitsMap;
	}
	public Map<String, Boolean> getMfFlags() {
		return mfFlags;
	}
	public void setMfFlags(Map<String, Boolean> mfFlags) {
		this.mfFlags = mfFlags;
	}
	public void setBenefitsList(Map<String, List<CpsBenefit>> snToBenefitsMap) {
		this.snToBenefitsMap = snToBenefitsMap;
	}
	
}
