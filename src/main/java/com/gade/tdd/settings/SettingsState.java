package com.gade.tdd.settings;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(
        name = "com.gade.tdd.settings.SettingsState",
        storages = {@Storage("YeelightRedGreenSettingsPlugin.xml")}
)
public class SettingsState implements PersistentStateComponent<SettingsState> {

    public String yeelightDeviceIp = ""; // default value

    public static SettingsState getInstance() {
        return ServiceManager.getService(SettingsState.class);
    }

    @Nullable
    @Override
    public SettingsState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull SettingsState state) {
        XmlSerializerUtil.copyBean(state, this);
    }
}
