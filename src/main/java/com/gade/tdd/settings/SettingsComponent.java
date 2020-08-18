package com.gade.tdd.settings;

import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.JPanel;
import javax.swing.JComponent;

public class SettingsComponent {

    private final JPanel jPanel;
    private final JBTextField yeelightDeviceIpJBTextField = new JBTextField();

    public SettingsComponent() {
        this.jPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("Enter Yeelight device IP: "), yeelightDeviceIpJBTextField, 1, false)
                .addComponent(yeelightDeviceIpJBTextField, 1)
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
    }

    public JPanel getPanel() {
        return jPanel;
    }

    public JComponent getPreferredFocusedComponent() {
        return yeelightDeviceIpJBTextField;
    }

    @NotNull
    public String getYeelightDeviceIpText() {
        return yeelightDeviceIpJBTextField.getText();
    }

    public void setYeelightDeviceIpText(@NotNull String newIp) {
        yeelightDeviceIpJBTextField.setText(newIp);
    }
}