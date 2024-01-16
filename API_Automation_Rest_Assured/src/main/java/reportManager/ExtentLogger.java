package reportManager;

import java.util.List;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.restassured.http.Header;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExtentLogger {
	 public static void pass(String message) {
	        ExtentReportManager.getExentTest().pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
	    }

	    public static void logFailureDetails(String message) {
	        ExtentReportManager.getExentTest().fail(message);
	    }

	    public static void skip(String message) {
	        ExtentReportManager.getExentTest().skip(message);
	    }

	    public static void logInfo(Markup markup) {
	        ExtentReportManager.getExentTest().log(Status.INFO, markup);
	    }

	    // Overloaded method
	    public static void logInfo(String message) {
	        ExtentReportManager.getExentTest().info(message);
	    }

	    public static void logResponse(String response) {
	        ExtentReportManager.getExentTest().pass(MarkupHelper.createCodeBlock(response, CodeLanguage.JSON));
	    }

	    public static void logRequest(RequestSpecification requestSpecification) {
	        QueryableRequestSpecification query = SpecificationQuerier.query(requestSpecification);
	        String body = null;
	        try {
	            body = String.valueOf(query.getBody());
	        } catch (NullPointerException ne) {
	            body = "{}";
	        }
	        ExtentReportManager.getExentTest().pass(MarkupHelper.createCodeBlock(body, CodeLanguage.JSON));
	        for (Header header : query.getHeaders()) {
	            logInfo(header.getName() + ":" + header.getValue());
	        }
	    }

	    public static void logRequestInReport(String request) {
	        logInfo(MarkupHelper.createLabel("API REQUEST", ExtentColor.ORANGE));
	        logInfo(MarkupHelper.createCodeBlock(request));
	    }

	    public static void logResponseInReport(String label, String response) {
	        logInfo(MarkupHelper.createLabel(label, ExtentColor.ORANGE));
	        logInfo(MarkupHelper.createCodeBlock(response));
	    }

	    public static void logHeaders(List<Header> headerList) {
	        String[][] headers = headerList.stream().map(header -> new String[]{header.getName(), header.getValue()})
	                .toArray(String[][]::new);
	        ExtentReportManager.getExentTest().info(MarkupHelper.createTable(headers));
	    }
}
