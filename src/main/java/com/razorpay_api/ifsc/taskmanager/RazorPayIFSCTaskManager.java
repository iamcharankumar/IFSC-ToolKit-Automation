package com.razorpay_api.ifsc.taskmanager;

import java.util.ArrayList;
import java.util.List;

import com.jayway.restassured.response.Response;
import com.razorpay_api.ifsc.ifsc_details.RazorPayIFSCRequest;
import com.razorpay_api.ifsc.ifsc_details.RazorPayIFSCResponseProcessing;

import lombok.Getter;
import lombok.Setter;

public class RazorPayIFSCTaskManager {

	public static @Getter @Setter String razorPayIP;
	private static @Getter @Setter List<Response> razorPayResponse = new ArrayList<Response>();
	private static @Getter @Setter ArrayList<String> banks;
	RazorPayIFSCRequest razorPayIFSCRequest;
	RazorPayIFSCResponseProcessing razorPayIFSCResponseProcessing;
	
	public void razporPayTasks() {
		razorPayIFSCRequest = new RazorPayIFSCRequest();
		razorPayIFSCResponseProcessing = new RazorPayIFSCResponseProcessing(razorPayResponse);
		razorPayIFSCRequest.razorPayIFSCJsonPayRequest();
		razorPayIFSCResponseProcessing.razorPayIFSCResponseProcessing();
	}
}