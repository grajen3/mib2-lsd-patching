/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.proximity.component;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.proximity.ProximityServiceImpl;
import de.vw.mib.asl.internal.system.proximity.component.AbstractProximityComponent;
import de.vw.mib.asl.internal.system.proximity.component.TouchComponent$1;
import de.vw.mib.configuration.ConfigurationManager;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.keypanel.DSIKeyPanel;
import org.dsi.ifc.keypanel.DSIKeyPanelListener;

public class TouchComponent
extends AbstractProximityComponent {
    static /* synthetic */ Class class$org$dsi$ifc$keypanel$DSIKeyPanel;
    static /* synthetic */ Class class$org$dsi$ifc$keypanel$DSIKeyPanelListener;

    public TouchComponent(SystemServices systemServices, ProximityServiceImpl proximityServiceImpl) {
        super(systemServices, proximityServiceImpl, PROXIMITY_COMPONENT_TYPE_USER_INTERACTION);
        this.connectToDsi(systemServices.getDsiProxy(), systemServices.getConfigManagerDiag());
    }

    private void connectToDsi(DSIProxy dSIProxy, ConfigurationManager configurationManager) {
        DSIKeyPanel dSIKeyPanel = (DSIKeyPanel)dSIProxy.getService(null, class$org$dsi$ifc$keypanel$DSIKeyPanel == null ? (class$org$dsi$ifc$keypanel$DSIKeyPanel = TouchComponent.class$("org.dsi.ifc.keypanel.DSIKeyPanel")) : class$org$dsi$ifc$keypanel$DSIKeyPanel, configurationManager.getSystemKeyPanelInstance());
        DSIKeyPanelListener dSIKeyPanelListener = this.createDsiKeyPanelListener();
        dSIProxy.addResponseListener(null, class$org$dsi$ifc$keypanel$DSIKeyPanelListener == null ? (class$org$dsi$ifc$keypanel$DSIKeyPanelListener = TouchComponent.class$("org.dsi.ifc.keypanel.DSIKeyPanelListener")) : class$org$dsi$ifc$keypanel$DSIKeyPanelListener, configurationManager.getSystemKeyPanelInstance(), dSIKeyPanelListener);
        dSIKeyPanel.setNotification(20, (DSIListener)dSIKeyPanelListener);
    }

    private DSIKeyPanelListener createDsiKeyPanelListener() {
        return new TouchComponent$1(this);
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

