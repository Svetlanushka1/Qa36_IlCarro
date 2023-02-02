package manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;

public class ListenerTNG implements ITestListener, ISuiteListener {
    Logger logger = LoggerFactory.getLogger(ListenerTNG.class);

    @Override
    public void onStart(ISuite suite) {
        ISuiteListener.super.onStart(suite);
    }

    @Override
    public void onFinish(ISuite suite) {
        ISuiteListener.super.onFinish(suite);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        logger.info("onTestSuccess" + result.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        logger.info("onTestStart ---" +result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        logger.info("onTestFailure ---" +result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        logger.info("onTestSkipped ---" +result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
        logger.info("onTestFailedButWithinSuccessPercentage ---" +result.getName());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
        logger.info("onTestFailedWithTimeout ---" +result.getName());

    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        logger.info("onStart ---" +context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        logger.info("onFinish ---" +context.getName());
    }
}
