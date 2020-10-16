/**
 * 
 */
package org.epragati.pss.service;

/**
 * @author rajesh.vaddi
 *
 */
public interface PssClient  {

	String spsVerification(String aadhaarNo);

	String getMultiSchemeBenifitsByHousehold(String houseHoldId);
}
