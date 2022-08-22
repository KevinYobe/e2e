package com.ownai.e2e.config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReportConfig {
    @Value("${report.name}")
    private String reportname;


    @Bean
    public ExtentReports extentSparkReporter(){
        ExtentReports reports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("Ownai Regression Reports.html");
        sparkReporter.config().setDocumentTitle(reportname);
        sparkReporter.config().setTheme(Theme.STANDARD);
        reports.attachReporter(sparkReporter);
        return reports ;
    }

}
