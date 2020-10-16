package org.epragati.pss.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import testing.Services;
import testing.ServicesPortType;

public class PssClientImpl implements PssClient {

//	private static final Logger logger = Logger.getLogger(PssServiceImpl.class);
	private static final Logger logger = LoggerFactory.getLogger(PssClientImpl.class);

	Services services;
	
	public PssClientImpl(){
		this.services =  new Services();
	}
	
	@Override
	public String spsVerification(String aadhaarNo){
	
	//Consume SOAP WebSerivce to get HouseHold id
	ServicesPortType servicesPortType = services.getServicesSOAP11PortHttp();
	String responseString = servicesPortType.spsVerification(aadhaarNo);
	logger.debug("PssExternalServiceImpl:getSPSVerificationDetails:responseString " + responseString);
	return responseString;
}

	@Override

	public String getMultiSchemeBenifitsByHousehold(String houseHoldId){
		ServicesPortType servicesPortType = services.getServicesSOAP11PortHttp();
		String responseString = "ERROR Response";
			
		responseString = servicesPortType.getMultiSchemeBenifitsByHousehold(houseHoldId);
		logger.debug("PssExternalServiceImpl:getAadharDetailsByHouseHold_Id:responseString " + responseString);
		return responseString;
	}

}
