package org.epragati.pss.service.impl;

import java.beans.XMLDecoder;
import java.io.ByteArrayInputStream;
import java.util.Objects;

import org.epragati.pss.ResponseType;
import org.epragati.pss.aadharhousehold.model.PssAadharResponseModel;
import org.epragati.pss.service.PssClient;
import org.epragati.pss.service.PssClientImpl;
import org.epragati.pss.service.PssService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codetree.bean.HouseHoldDetails;
import com.codetree.bean.MultiSchemeBenifitsByAadhaar;
import com.codetree.bean.SPSVerificationbean;

/**
 * Implementation for PssService interface
 * @author rajesh.vaddi
 *
 */
public class PssServiceImpl implements PssService {
//	private static final Logger logger = Logger.getLogger(PssServiceImpl.class);
	private static final Logger logger = LoggerFactory.getLogger(PssServiceImpl.class);
	PssClient client;
	
	public PssServiceImpl(){
		this.client =  new PssClientImpl();
	}	
	/**
	 *  For the given aadhaarId, it return corresponding house hold details
	 * @author Rajesh.Vaddi
	 * @param aadhaarNo
	 * @return
	 */
	@Override
	public  PssAadharResponseModel<HouseHoldDetails> getHouseHoldDetails(String aadhaarId) {
		logger.debug("PssServiceImpl: getAadharDetails method is started executing... ");

		//Call first SOAP Web Service to get houseHold id by Aadhaar id
		PssAadharResponseModel<SPSVerificationbean> sPSVerificationbeanModel =  getSPSVerificationDetails(aadhaarId);
		String houseHold_Id =  sPSVerificationbeanModel.getResponseModel().getHOUSEHOLD_ID();
	
		logger.debug("PssServiceImpl:getHouseHoldDetails:houseHold_Id:: " + houseHold_Id);

		if(houseHold_Id.equals("101")){
			return new  PssAadharResponseModel<>(ResponseType.NOT_FOUND, houseHold_Id);
			
		}

		//Call second SOAP WebService get full details by HouseHold id.
		PssAadharResponseModel<MultiSchemeBenifitsByAadhaar> msBenefitsModel = getAadharDetailsByHouseHold_Id(houseHold_Id);
		
		if (Objects.isNull(msBenefitsModel)) {
			return new PssAadharResponseModel<>(ResponseType.NOT_FOUND, houseHold_Id);
		}

		// only Map required details from msBenefits to houseHoldDetails
		HouseHoldDetails houseHoldDetails = mapper(msBenefitsModel.getResponseModel());

		logger.debug("PssServiceImpl:getHouseHoldDetails:houseHoldDetails:: " + houseHoldDetails);
		
		if(houseHoldDetails.getCITIZEN_NAME().equals("101")){
			return new  PssAadharResponseModel<>(ResponseType.NOT_FOUND, houseHold_Id);
			
		}

		return new  PssAadharResponseModel<>(ResponseType.SUCCESS, "SUCCESS", houseHoldDetails);

	}
	
	/**
	 * For the given aadhaarId, it return corresponding full details of MultiScheme Benefits 
	 * @param aadhaarNo
	 * @return
	 * @author rajesh.vaddi
	 */
	
	@Override
	public PssAadharResponseModel<MultiSchemeBenifitsByAadhaar> getAadharDetailsByHouseHold_Id(final String houseHoldId){
		logger.debug("PssServiceImpl: getAadharDetailsByHouseHold_Id method is started executing... ");
		
		//Consuming SOAP WebService to get HouseHold id
		String responseString = client.getMultiSchemeBenifitsByHousehold(houseHoldId);
		
		if (Objects.isNull(responseString)) {
			return new PssAadharResponseModel<>(ResponseType.NOT_FOUND, responseString);

		}

		//Converting  xml response to java object
		XMLDecoder xmlDecoder2 = new XMLDecoder(new ByteArrayInputStream(responseString.getBytes()));
		MultiSchemeBenifitsByAadhaar [] multiSchemeBenifitsByAadhaar_array = 
											(MultiSchemeBenifitsByAadhaar []) xmlDecoder2.readObject();
		
		logger.debug("PssServiceImpl:getAadharDetailsByHouseHold_Id:multiSchemeBenifitsByAadhaar_array length " 
											+ multiSchemeBenifitsByAadhaar_array.length);
		logger.debug("PssServiceImpl:getAadharDetailsByHouseHold_Id:multiSchemeBenifitsByAadhaar array last element " 
											+ multiSchemeBenifitsByAadhaar_array [multiSchemeBenifitsByAadhaar_array.length - 1 ]);

		xmlDecoder2.close();
		
		//return last element in the array for latest details
		MultiSchemeBenifitsByAadhaar multiSchemeBenifitsByAadhaar = multiSchemeBenifitsByAadhaar_array [multiSchemeBenifitsByAadhaar_array.length - 1 ];
		
		if(multiSchemeBenifitsByAadhaar.getStatus().equals("101")){
			return new  PssAadharResponseModel<>(ResponseType.NOT_FOUND, responseString);
			
		}

		return new  PssAadharResponseModel<>(ResponseType.SUCCESS, "SUCCESS", multiSchemeBenifitsByAadhaar);

	}
	
	/**
	 * For the given aadhaarId, it returns house hold id
	 * @param aadhaarNo
	 * @return
	 * @author rajesh.vaddi
	 */

	@Override
	public  PssAadharResponseModel<SPSVerificationbean> getSPSVerificationDetails(final String aadhaarNo){
		logger.debug("PssServiceImpl: getSPSVerificationDetails method is started executing... ");

		String responseString="";
		SPSVerificationbean sPSVerificationbeanObj = new SPSVerificationbean(); 
		XMLDecoder xmlDecoder;
		responseString = client.spsVerification(aadhaarNo);
		
		if (Objects.isNull(responseString)) {
			return new PssAadharResponseModel<>(ResponseType.NOT_FOUND, responseString);
		}

		xmlDecoder = new XMLDecoder(new ByteArrayInputStream(responseString.getBytes()));
		sPSVerificationbeanObj = (SPSVerificationbean) xmlDecoder.readObject();
		xmlDecoder.close();

		logger.debug("PssServiceImpl:getSPSVerificationDetails:sPSVerificationbeanObj " + sPSVerificationbeanObj);
		if(sPSVerificationbeanObj.getStatus().equals("101")){
			return new  PssAadharResponseModel<>(ResponseType.NOT_FOUND, responseString);
			
		}
		return new  PssAadharResponseModel<>(ResponseType.SUCCESS, "SUCCESS", sPSVerificationbeanObj);
		
	}	

	// It maps required fields from MultiSchemeBenifitsByAadhaar to HouseHoldDetails
	private HouseHoldDetails mapper(MultiSchemeBenifitsByAadhaar msBenifits ){
	logger.debug("PssServiceImpl: mapper method is started executing... ");
	HouseHoldDetails houseHoldDetails = new HouseHoldDetails();

	houseHoldDetails.setADDRESS_TYPE(msBenifits.getADDRESS_TYPE()); 
	houseHoldDetails.setBPCL_ID(msBenifits.getBPCL_ID()); 
	houseHoldDetails.setBUILDING_TSH_NUM(msBenifits.getBUILDING_TSH_NUM()); 
	houseHoldDetails.setBUILDING_NAME(msBenifits.getBUILDING_NAME()); 
	houseHoldDetails.setDATE_OF_DEATH(msBenifits.getDATE_OF_DEATH()); 
	houseHoldDetails.setCITIZEN_NAME(msBenifits.getCITIZEN_NAME()); 
	houseHoldDetails.setDISTRICT_CODE(msBenifits.getDISTRICT_CODE()); 
	houseHoldDetails.setDISTRICT_NAME(msBenifits.getDISTRICT_NAME()); 
	houseHoldDetails.setDOB_DT(msBenifits.getDOB_DT()); 
	houseHoldDetails.setDWELLING_TSH_NUM(msBenifits.getDWELLING_TSH_NUM()); 
	houseHoldDetails.setEKYC_STATUS(msBenifits.getEKYC_STATUS()); 
	houseHoldDetails.setFLAT_NO(msBenifits.getFLAT_NO()); 
	houseHoldDetails.setFLOOR_NO(msBenifits.getFLOOR_NO()); 
	houseHoldDetails.setGEO_LAT(msBenifits.getGEO_LAT()); 
	houseHoldDetails.setGEO_LONG(msBenifits.getGEO_LONG()); 
	houseHoldDetails.setHOUSEHOLD_ID(msBenifits.getHOUSEHOLD_ID()); 
	houseHoldDetails.setHOUSING_ID(msBenifits.getHOUSING_ID()); 
	houseHoldDetails.setMARITAL_STATUS(msBenifits.getMARITAL_STATUS()); 
	houseHoldDetails.setMOBILE_NUMBER(msBenifits.getMOBILE_NUMBER()); 
	houseHoldDetails.setPINCODE(msBenifits.getPINCODE()); 
	houseHoldDetails.setRESIDENT_STATUS(msBenifits.getRESIDENT_STATUS()); 
	houseHoldDetails.setRURAL_URBAN_FLAG(msBenifits.getRURAL_URBAN_FLAG()); 
	houseHoldDetails.setSTREET(msBenifits.getSTREET()); 
	houseHoldDetails.setTEHSIL_CODE(msBenifits.getTEHSIL_CODE()); 
	houseHoldDetails.setTEHSIL_NAME(msBenifits.getTEHSIL_NAME()); 
	houseHoldDetails.setUPDATED_ON(msBenifits.getUPDATED_ON()); 
	houseHoldDetails.setCare_of(msBenifits.getCare_of()); 
	logger.debug("PssServiceImpl: mapper:houseHoldDetails :" + houseHoldDetails);
	
	return houseHoldDetails;
	}
}
