package com.razorpay_api.ifsc.ifsc_details;

import java.util.ArrayList;
import java.util.List;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.razorpay_api.ifsc.taskmanager.RazorPayIFSCTaskManager;

public class RazorPayIFSCRequest extends RazorPayIFSCTaskManager implements RazorPayIFSCConstants {

	public void razorPayIFSCJsonPayRequest() throws NullPointerException {
		ArrayList<String> listOfBanks;
		try {
			listOfBanks = new ArrayList<String>();
			listOfBanks.add("HDFC0CANSCB");
			listOfBanks.add("KARB0000001");
			listOfBanks.add("BOFA0CN6215");
			listOfBanks.add("CITI0000003");
			listOfBanks.add("ICIC0006609");
			setBanks(listOfBanks);
			List<Response> responseList = getRazorPayResponse();
			for (int responseListCounter = 0; responseListCounter < listOfBanks.size(); responseListCounter++) {

				String EndPoint = getRazorPayIP() + listOfBanks.get(responseListCounter);
				System.out.println("API END POINT ----> " + EndPoint);
				Response razorPayIFSCDetailsResponse = RestAssured.given().contentType("application/json")
						.get(EndPoint);
				responseList.add(razorPayIFSCDetailsResponse);
				if (razorPayIFSCDetailsResponse.statusCode() == 200) {
					System.out.println("Razor Pay API PASS for the IFSC: " + listOfBanks.get(responseListCounter));
				}
			}
		} catch (NullPointerException razorPayIFSCNullPointerException) {
			System.err.println("There exists a Null Pointer Exception in Razory Pay IFSC Details - "
					+ razorPayIFSCNullPointerException.getMessage());
		} catch (Exception razorPayIFSCException) {
			System.err.println(
					"There exists an exception in Razory Pay IFSC Details - " + razorPayIFSCException.getMessage());
		}
	}
}