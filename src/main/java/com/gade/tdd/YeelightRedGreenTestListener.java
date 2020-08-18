package com.gade.tdd;

import com.gade.tdd.notifications.Notifier;
import com.gade.tdd.settings.SettingsState;
import com.intellij.execution.testframework.sm.runner.SMTRunnerEventsListener;
import com.intellij.execution.testframework.sm.runner.SMTestProxy;
import com.mollin.yapi.YeelightDevice;
import com.mollin.yapi.enumeration.YeelightEffect;
import com.mollin.yapi.exception.YeelightResultErrorException;
import com.mollin.yapi.exception.YeelightSocketException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class YeelightRedGreenTestListener implements SMTRunnerEventsListener {

    private YeelightDevice yeelightDevice;
    private final Notifier notifier;

    public YeelightRedGreenTestListener() {
        notifier = new Notifier();
    }

    @Override
    public void onTestingStarted(@NotNull SMTestProxy.SMRootTestProxy testsRoot) {
        final SettingsState settingsState = SettingsState.getInstance();
        try {
            yeelightDevice = new YeelightDevice(settingsState.yeelightDeviceIp, 55443, YeelightEffect.SMOOTH, 500);
            yeelightDevice.setPower(true);
            yeelightDevice.setRGB(255, 255, 255);
            yeelightDevice.setColorTemperature(6500);
        } catch (YeelightSocketException e) {
            notifier.notifyError("Error connecting to Yeelight device (" + settingsState.yeelightDeviceIp +"): " + e.getMessage());
        } catch (YeelightResultErrorException e) {
            notifier.notifyError("Error setting up Yeelight device (" + settingsState.yeelightDeviceIp +"): " + e.getMessage());
        }
    }

    @Override
    public void onTestingFinished(@NotNull SMTestProxy.SMRootTestProxy testsRoot) {
        final SettingsState settingsState = SettingsState.getInstance();
        if (yeelightDevice != null) {
            try {
                if (testsRoot.hasPassedTests()) {
                    yeelightDevice.setRGB(0, 255, 0);
                } else {
                    yeelightDevice.setRGB(255, 0, 0);
                }
                yeelightDevice = null;
            } catch (YeelightSocketException e) {
                notifier.notifyError("Error connecting to Yeelight device (" + settingsState.yeelightDeviceIp + "): " + e.getMessage());
            } catch (YeelightResultErrorException e) {
                notifier.notifyError("Error setting up Yeelight device (" + settingsState.yeelightDeviceIp + "): " + e.getMessage());
            }
        }
    }

    @Override public void onTestsCountInSuite(int count) { }

    @Override public void onTestStarted(@NotNull SMTestProxy test) { }

    @Override public void onTestFinished(@NotNull SMTestProxy test) { }

    @Override public void onTestFailed(@NotNull SMTestProxy test) { }

    @Override public void onTestIgnored(@NotNull SMTestProxy test) { }

    @Override public void onSuiteFinished(@NotNull SMTestProxy suite) { }

    @Override public void onSuiteStarted(@NotNull SMTestProxy suite) { }

    @Override public void onCustomProgressTestsCategory(@Nullable String categoryName, int testCount) { }

    @Override public void onCustomProgressTestStarted() { }

    @Override public void onCustomProgressTestFailed() { }

    @Override public void onCustomProgressTestFinished() { }

    @Override public void onSuiteTreeNodeAdded(SMTestProxy testProxy) { }

    @Override public void onSuiteTreeStarted(SMTestProxy suite) { }
}
