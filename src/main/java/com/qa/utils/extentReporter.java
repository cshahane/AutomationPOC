package com.qa.utils;

import java.io.*;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReporter {
	public static ExtentReports generateExtentReport() {
		ExtentReports extentreport = new ExtentReports();
		File extentReporterFile = new File(
				System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReporterFile);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("POC");
		sparkReporter.config().setDocumentTitle("Automation POC");
		sparkReporter.config().setTimeStampFormat("dd-mm-yyyy hh:mm:ss");
		extentreport.attachReporter(sparkReporter);

		Properties configProp = new Properties();
		File configPropFile = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\config\\Config.properties");
		try {
			FileInputStream fisConfigProp = new FileInputStream(configPropFile);
			configProp.load(fisConfigProp);
		} catch (Throwable e) {
			e.getStackTrace();
		}
		extentreport.setSystemInfo("Application URL",configProp.getProperty("url"));
		extentreport.setSystemInfo("Browser Name",configProp.getProperty("browserName"));
		extentreport.setSystemInfo("Email Address",configProp.getProperty("validEmail"));
		extentreport.setSystemInfo("Password",configProp.getProperty("validPassword"));
		extentreport.setSystemInfo("Operating System",System.getProperty("os.name"));
		extentreport.setSystemInfo("UserName", System.getProperty("user.name"));
		extentreport.setSystemInfo("Java Version", System.getProperty("java.version"));
return extentreport;
	}

}
