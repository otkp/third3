package org.epragati.pss.service;

import org.epragati.pss.aadharhousehold.model.PssAadharResponseModel;

import com.codetree.bean.HouseHoldDetails;
import com.codetree.bean.MultiSchemeBenifitsByAadhaar;
import com.codetree.bean.SPSVerificationbean;

public interface PssService {
	

	PssAadharResponseModel<SPSVerificationbean> getSPSVerificationDetails(String aadharNo);
	PssAadharResponseModel<MultiSchemeBenifitsByAadhaar> getAadharDetailsByHouseHold_Id(String houseHoldId);
	PssAadharResponseModel<HouseHoldDetails> getHouseHoldDetails(String aadhaarInput);

}
