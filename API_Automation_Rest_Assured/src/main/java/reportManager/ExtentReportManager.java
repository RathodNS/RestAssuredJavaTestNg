package reportManager;

import com.aventstack.extentreports.ExtentTest;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access=AccessLevel.PRIVATE)
public class ExtentReportManager {

	private static final ThreadLocal<ExtentTest> thread_Local_extentreports = new ThreadLocal<>();
	
	public static void setExtetTest(ExtentTest test) {
		thread_Local_extentreports.set(test);
	}
	
	public static ExtentTest getExentTest() {
		return thread_Local_extentreports.get();
	}
	
	public static void removeExtenttest() {
		thread_Local_extentreports.remove();
	}
}
