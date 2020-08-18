package com.gade.tdd.settings;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.JComponent;

import static org.jetbrains.annotations.Nls.Capitalization.Title;

public class SettingsConfigurable implements Configurable {

    private SettingsComponent settingsComponent;
    private final SettingsState settingsState;

    // Constructor with no arguments because this implementation is registered as an applicationConfigurable EP
    public SettingsConfigurable() {
        this.settingsState = SettingsState.getInstance();
    }

    @Nls(capitalization = Title)
    @Override
    public String getDisplayName() {
        return "Yeelight Red Green Plugin Settings";
    }

    @Override
    public JComponent getPreferredFocusedComponent() {
        return settingsComponent.getPreferredFocusedComponent();
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        settingsComponent = new SettingsComponent();
        return settingsComponent.getPanel();
    }

    @Override
    public boolean isModified() {
        return !settingsComponent.getYeelightDeviceIpText().equals(settingsState.yeelightDeviceIp);
    }

    @Override
    public void apply() {
        settingsState.yeelightDeviceIp = settingsComponent.getYeelightDeviceIpText();
    }

    @Override
    public void reset() {
        settingsComponent.setYeelightDeviceIpText(settingsState.yeelightDeviceIp);
    }

    @Override
    public void disposeUIResources() {
        settingsComponent = null;
    }
}
