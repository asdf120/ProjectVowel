package movie.data.vo;

import java.sql.Date;

public class ManagerVO {
	
	private String mgrID; 
	private String mgrPW;
	private String mgrName;
	private String mgrTel;
	private Date mgrBirth;
	private Date mgrHireDate;
	public String getMgrID() {
		return mgrID;
	}
	public void setMgrID(String mgrID) {
		this.mgrID = mgrID;
	}
	public String getMgrPW() {
		return mgrPW;
	}
	public void setMgrPW(String mgrPW) {
		this.mgrPW = mgrPW;
	}
	public String getMgrName() {
		return mgrName;
	}
	public void setMgrName(String mgrName) {
		this.mgrName = mgrName;
	}
	public String getMgrTel() {
		return mgrTel;
	}
	public void setMgrTel(String mgrTel) {
		this.mgrTel = mgrTel;
	}
	public Date getMgrBirth() {
		return mgrBirth;
	}
	public void setMgrBirth(Date mgrBirth) {
		this.mgrBirth = mgrBirth;
	}
	public Date getMgrHireDate() {
		return mgrHireDate;
	}
	public void setMgrHireDate(Date mgrHireDate) {
		this.mgrHireDate = mgrHireDate;
	}
	
	
	
	
	
}
