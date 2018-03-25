package com.razorpay_api.ifsc.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.razorpay_api.ifsc.taskmanager.RazorPayIFSCTaskManager;

public class RazorPayIFSCTest {

	@Test
	public void razorPayIFSCDetailsTesting() throws FileNotFoundException, IOException {
		Properties razorPayServerProperties = new Properties();
		razorPayServerProperties.load(new FileInputStream("API_Config.properties"));
		String razorPayServer = razorPayServerProperties.getProperty("API_SERVER_QA");
		SoftAssert razorPayIFSCSoftAssert = new SoftAssert();
		if (razorPayServer != null) {
			RazorPayIFSCTaskManager razorPayIFSCTaskManager = new RazorPayIFSCTaskManager();
			RazorPayIFSCTaskManager.setRazorPayIP(razorPayServer);
			razorPayIFSCTaskManager.razporPayTasks();
		}
		razorPayIFSCSoftAssert.assertAll();
	}
}