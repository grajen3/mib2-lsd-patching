/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.internal.system.TouchScreenFeatureSetter$1;
import de.vw.mib.configuration.ConfigurationManager;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.keypanel.DSIKeyPanel;
import org.dsi.ifc.keypanel.DSIKeyPanelListener;

public class TouchScreenFeatureSetter {
    private static final int ABT_ACTIVATE_RAW2_SETTING;
    private int abtMaskSettings = 69;
    private int abtZoomstateSettings = -1;
    private DSIKeyPanel dsiKeyPanel;
    private boolean isInputPanelReady;
    private boolean rawGesturesActivated;
    static /* synthetic */ Class class$org$dsi$ifc$keypanel$DSIKeyPanel;
    static /* synthetic */ Class class$org$dsi$ifc$keypanel$DSIKeyPanelListener;

    public TouchScreenFeatureSetter(DSIProxy dSIProxy, ConfigurationManager configurationManager) {
        String string;
        String string2 = System.getProperty("de.vw.mib.asl.internal.util.SystemKeyUtil.abtMaskSetting");
        if (null != string2) {
            this.abtMaskSettings = Integer.valueOf(string2);
        }
        if (null != (string = System.getProperty("de.vw.mib.asl.internal.util.SystemKeyUtil.abtZoomStepSetting"))) {
            this.abtZoomstateSettings = Integer.valueOf(string);
        }
        this.connectToDsi(dSIProxy, configurationManager);
    }

    public void activateRawGestures(boolean bl) {
        this.rawGesturesActivated = bl;
        if (this.isInputPanelReady) {
            if (bl) {
                this.dsiKeyPanel.setGenericSetting(13, 109, 1);
            } else {
                this.dsiKeyPanel.setGenericSetting(13, 109, this.abtMaskSettings);
            }
        }
    }

    void onInputPanelReady() {
        this.isInputPanelReady = true;
        this.applyZoomSettings();
        this.activateRawGestures(this.rawGesturesActivated);
    }

    private void connectToDsi(DSIProxy dSIProxy, ConfigurationManager configurationManager) {
        this.dsiKeyPanel = (DSIKeyPanel)dSIProxy.getService(null, class$org$dsi$ifc$keypanel$DSIKeyPanel == null ? (class$org$dsi$ifc$keypanel$DSIKeyPanel = TouchScreenFeatureSetter.class$("org.dsi.ifc.keypanel.DSIKeyPanel")) : class$org$dsi$ifc$keypanel$DSIKeyPanel, configurationManager.getSystemKeyPanelInstance());
        DSIKeyPanelListener dSIKeyPanelListener = this.createDSIAdapter();
        dSIProxy.addResponseListener(null, class$org$dsi$ifc$keypanel$DSIKeyPanelListener == null ? (class$org$dsi$ifc$keypanel$DSIKeyPanelListener = TouchScreenFeatureSetter.class$("org.dsi.ifc.keypanel.DSIKeyPanelListener")) : class$org$dsi$ifc$keypanel$DSIKeyPanelListener, configurationManager.getSystemKeyPanelInstance(), dSIKeyPanelListener);
        this.dsiKeyPanel.setNotification(26, (DSIListener)dSIKeyPanelListener);
    }

    private DSIKeyPanelListener createDSIAdapter() {
        return new TouchScreenFeatureSetter$1(this);
    }

    private void applyZoomSettings() {
        if (this.abtZoomstateSettings != -1) {
            this.dsiKeyPanel.setGenericSetting(13, 108, this.abtZoomstateSettings);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

