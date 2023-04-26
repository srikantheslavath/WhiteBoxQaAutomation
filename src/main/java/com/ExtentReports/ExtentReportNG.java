package com.ExtentReports;

import com.BasePackage.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG extends BaseClass {

    public static ExtentReports extent;

    public static ExtentReports getReportObject(){

       String path= System.getProperty("C:\\Users\\Sampath Velupula\\IdeaProjects\\WhiteBoxQaAutomation\\Reports\\extent.html");

        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "srikanth");
        return extent;
    }









}
