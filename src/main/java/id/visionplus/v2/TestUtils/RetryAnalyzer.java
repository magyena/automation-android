package id.visionplus.v2.TestUtils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int count = 0;
    private static final int MAX_RETRY_COUNT = 2;  // Number of times to retry the failed test

    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess()) {  // Check if test failed
            if (count < MAX_RETRY_COUNT) {
                count++;
                return true;  // Retry the test
            }
        }
        return false;  // Do not retry the test
    }
}
