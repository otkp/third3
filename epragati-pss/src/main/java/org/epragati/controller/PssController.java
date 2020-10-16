package org.epragati.controller;

import org.apache.commons.lang3.StringUtils;
import org.epragati.constants.MessageKeys;
import org.epragati.pss.aadharhousehold.model.PssAadharResponseModel;
import org.epragati.pss.service.PssService;
import org.epragati.pss.service.impl.PssServiceImpl;
import org.epragati.util.AppMessages;
import org.epragati.util.GateWayResponse;
import org.epragati.util.RequestMappingUrls;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codetree.bean.HouseHoldDetails;
import com.codetree.bean.MultiSchemeBenifitsByAadhaar;
import com.codetree.bean.SPSVerificationbean;

/**
 * Controller class for PSS service.
 * @author rajesh.vaddi
 *
 */

@CrossOrigin
@RestController
public class PssController {
	
	@Autowired
	private AppMessages appMsg;

	//private static final Logger logger = Logger.getLogger(PssController.class);
	private static final Logger logger = LoggerFactory.getLogger(PssController.class);

	
	/**
	 * For the given aadhaarId, this method returns house hold id
	 * @param aadhaarNo
	 * @return
	 * @author rajesh.vaddi
	 */
	@GetMapping(path = RequestMappingUrls.HOUSEHOLDID_URL,  produces = { MediaType.APPLICATION_JSON_VALUE})
	public GateWayResponse<?> getHouseHoldId(
			@RequestParam(name = "aadhaarNo", required = true) String aadhaarNo	
			){

		logger.debug("PssServiceImpl : getHouseHoldId method is started executing... ");
		PssAadharResponseModel< SPSVerificationbean > houseHoldId;

		try {
			houseHoldId = new PssServiceImpl().getSPSVerificationDetails(aadhaarNo);
			logger.debug("PssServiceImpl: getHouseHoldId: houseHoldId " + houseHoldId);
		}catch( Exception e){
			logger.debug("PssServiceImpl: getHouseHoldId: Exception " + e.getMessage());
			return new GateWayResponse<> (true, HttpStatus.SERVICE_UNAVAILABLE, null);
		}

		return new GateWayResponse<> (true, HttpStatus.OK, houseHoldId);
		
	}

	/**
	 * For the given aadhaarId, it return corresponding full details of MultiScheme Benefits 
	 * @param aadhaarNo
	 * @return
	 * @author rajesh.vaddi
	 */
	@GetMapping(path = RequestMappingUrls.MULTI_SCHEME_URL,  produces = { MediaType.APPLICATION_JSON_VALUE})
	public GateWayResponse<?> getMultiSchemeBenifitsByAadhaar(
			@RequestParam(name="aadhaarNo", required=true) String aadhaarNo			
			){
		logger.debug("PssServiceImpl: getMultiSchemeBenifitsByAadhaar method is started executing... ");

		if(StringUtils.isEmpty(aadhaarNo))
		{
		return new GateWayResponse<>(HttpStatus.BAD_REQUEST, MessageKeys.MESSAGE_REG_MISSING_PARAMETER);	
		}
		try{
			
			
			PssService service = new PssServiceImpl();
			PssAadharResponseModel<SPSVerificationbean> sPSVerificationbean =  service.getSPSVerificationDetails(aadhaarNo);
			logger.debug("PssServiceImpl: getMultiSchemeBenifitsByAadhaar: sPSVerificationbeanObj " + sPSVerificationbean);
		
			String houseHold_Id = sPSVerificationbean.getResponseModel().getHOUSEHOLD_ID();
			logger.debug("PssServiceImpl: getMultiSchemeBenifitsByAadhaar: houseHold_Id " + houseHold_Id);
	
			PssAadharResponseModel<MultiSchemeBenifitsByAadhaar> msBenefitsFullDetails = service.getAadharDetailsByHouseHold_Id(houseHold_Id);	
			logger.debug("PssServiceImpl: getMultiSchemeBenifitsByAadhaar: msBenefitsFullDetails " + msBenefitsFullDetails);
	
			return new GateWayResponse<>(true, HttpStatus.OK, msBenefitsFullDetails);

		}catch( Exception e){
			logger.debug("PssServiceImpl: getMultiSchemeBenifitsByAadhaar: Exception " + e.getMessage());
			return new GateWayResponse<>(true,  HttpStatus.SERVICE_UNAVAILABLE, null);
		}
	}	
	
	/**
	 * For the given aadhaarId, this method fetches and returns corresponding house hold details
	 * @author Rajesh.Vaddi
	 * @param aadhaarNo
	 * @return
	 */
	@GetMapping(path = RequestMappingUrls.HOUSEHOLD_DETAILS_URL,  produces = { MediaType.APPLICATION_JSON_VALUE})
	public GateWayResponse<?> getPssHouseHoldDetails(
			@RequestParam(name = "aadhaarNo", required = true) String aadhaarNo			
			){

		logger.debug("PssServiceImpl: getPssHouseHoldDetails method is started executing... ");
		try{
			
			PssAadharResponseModel<HouseHoldDetails> houseHoldDetails = new PssServiceImpl().getHouseHoldDetails(aadhaarNo);
			logger.debug("PssServiceImpl: getPssHouseHoldDetails: " + houseHoldDetails);
		
			return new GateWayResponse<>(true, HttpStatus.OK, houseHoldDetails);
		
		}catch( Exception e){
			logger.debug("PssServiceImpl: getPssHouseHoldDetails: Exception " + e.getMessage());
			return new GateWayResponse<>(true,  HttpStatus.SERVICE_UNAVAILABLE, null);
		}
	}

}
