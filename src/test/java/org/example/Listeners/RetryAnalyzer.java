package org.example.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    int count = 1;
    int maxcount = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (count < maxcount) {
            count++;
            return true;
        } else {
            return false;
        }
    }
}
