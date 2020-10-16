package com.codetree.bean;

public class SPSVerificationbean {
	
	private String HOUSEHOLD_ID;
	private String SNO;
	private String ekyc_status;
	private String status;
	
	
	
	public String getHOUSEHOLD_ID() {
		return HOUSEHOLD_ID;
	}
	public void setHOUSEHOLD_ID(String hOUSEHOLD_ID) {
		HOUSEHOLD_ID = hOUSEHOLD_ID;
	}
	public String getSNO() {
		return SNO;
	}

	public void setSNO(String sNO) {
		SNO = sNO;
	}
	public String getEkyc_status() {
		return ekyc_status;
	}
	public void setEkyc_status(String ekyc_status) {
		this.ekyc_status = ekyc_status;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "SPSVerificationbean [HOUSEHOLD_ID=" + HOUSEHOLD_ID + ", SNO=" + SNO + ", ekyc_status=" + ekyc_status  + ", status=" + status + "]";
	}

}
