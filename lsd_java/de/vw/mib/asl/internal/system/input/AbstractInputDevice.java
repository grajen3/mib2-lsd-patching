/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.input;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.input.devices.InputDevice;
import de.vw.mib.input.devices.InputDeviceListener;
import java.util.HashSet;
import java.util.Set;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.keypanel.DSIKeyPanel;
import org.dsi.ifc.keypanel.DSIKeyPanelListener;

public abstract class AbstractInputDevice
implements InputDevice {
    private final Set listeners = new HashSet();
    protected DSIKeyPanel dsiKeyPanel;
    static /* synthetic */ Class class$org$dsi$ifc$keypanel$DSIKeyPanel;
    static /* synthetic */ Class class$org$dsi$ifc$keypanel$DSIKeyPanelListener;

    public AbstractInputDevice(DSIProxy dSIProxy, ConfigurationManager configurationManager) {
        this.connectToDsi(dSIProxy, configurationManager);
    }

    @Override
    public final void addInputDeviceListener(InputDeviceListener inputDeviceListener) {
        Preconditions.checkArgumentNotNull(inputDeviceListener);
        Preconditions.checkArgument(this.getListenerClass().isAssignableFrom(super.getClass()), "Listener must be an instance of ProximityInputDeviceListener");
        this.listeners.add(inputDeviceListener);
    }

    @Override
    public final void removeInputDeviceListener(InputDeviceListener inputDeviceListener) {
        this.listeners.remove(inputDeviceListener);
    }

    protected abstract DSIKeyPanelListener createKeyPanelListener() {
    }

    protected abstract int[] getDsiAttributes() {
    }

    protected abstract Class getListenerClass() {
    }

    protected final Set getListeners() {
        return this.listeners;
    }

    private void connectToDsi(DSIProxy dSIProxy, ConfigurationManager configurationManager) {
        this.dsiKeyPanel = (DSIKeyPanel)dSIProxy.getService(null, class$org$dsi$ifc$keypanel$DSIKeyPanel == null ? (class$org$dsi$ifc$keypanel$DSIKeyPanel = AbstractInputDevice.class$("org.dsi.ifc.keypanel.DSIKeyPanel")) : class$org$dsi$ifc$keypanel$DSIKeyPanel, configurationManager.getSystemKeyPanelInstance());
        DSIKeyPanelListener dSIKeyPanelListener = this.createKeyPanelListener();
        dSIProxy.addResponseListener(null, class$org$dsi$ifc$keypanel$DSIKeyPanelListener == null ? (class$org$dsi$ifc$keypanel$DSIKeyPanelListener = AbstractInputDevice.class$("org.dsi.ifc.keypanel.DSIKeyPanelListener")) : class$org$dsi$ifc$keypanel$DSIKeyPanelListener, configurationManager.getSystemKeyPanelInstance(), dSIKeyPanelListener);
        this.dsiKeyPanel.setNotification(this.getDsiAttributes(), (DSIListener)dSIKeyPanelListener);
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

