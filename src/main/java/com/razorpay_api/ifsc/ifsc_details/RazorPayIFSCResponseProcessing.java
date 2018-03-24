package com.razorpay_api.ifsc.ifsc_details;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.jayway.restassured.response.Response;
import com.razorpay_api.ifsc.taskmanager.RazorPayIFSCTaskManager;

public class RazorPayIFSCResponseProcessing extends RazorPayIFSCTaskManager implements RazorPayIFSCConstants {

	private static String razorPayIFSCResponse;

	// Since the response list is used only in this class it is made as final.
	private final List<Response> responseList;

	// Constructor to instantiate the class
	public RazorPayIFSCResponseProcessing(List<Response> razoryPayIFSCDetailsResponseList) {
		this.responseList = razoryPayIFSCDetailsResponseList;
	}

	public void razorPayIFSCResponseProcessing() {
		JSONParser parseRazorPayIFSCResponse;
		int inputSize = getBanks().size();
		System.out.println("\n\n---------------> There are " + inputSize
				+ " banks involved in this Automation <---------------\n\n");
		try {
			parseRazorPayIFSCResponse = new JSONParser();
			for (int responseCounter = 0; responseCounter < responseList.size(); responseCounter++) {
				razorPayIFSCResponse = responseList.get(responseCounter).asString();
				JSONObject parseRazorPayIFSCDetails = (JSONObject) parseRazorPayIFSCResponse
						.parse(razorPayIFSCResponse);
				System.out.println("\n\n---------------> The Bank Details for the IFSC Code - "
						+ parseRazorPayIFSCDetails.get("IFSC").toString() + " <---------------\n\n");
				System.out.println("Address - " + parseRazorPayIFSCDetails.get("ADDRESS").toString());
				System.out.println("State - " + parseRazorPayIFSCDetails.get("STATE").toString());
				System.out.println("Branch - " + parseRazorPayIFSCDetails.get("BRANCH").toString());
				System.out.println("District - " + parseRazorPayIFSCDetails.get("DISTRICT").toString());
				System.out.println("Contact - " + parseRazorPayIFSCDetails.get("CONTACT").toString());
				System.out.println("City - " + parseRazorPayIFSCDetails.get("CITY").toString());
				System.out.println("Bank - " + parseRazorPayIFSCDetails.get("BANK").toString());
				System.out.println("Bank Code - " + parseRazorPayIFSCDetails.get("BANKCODE").toString());
				System.out.println("---------------> End Of Bank Details <---------------\n\n");
			}
		} catch (Exception razorPayIFSCResponseException) {
			System.err.println("Exception in Response -  " + razorPayIFSCResponseException.getMessage());
		}
	}
}