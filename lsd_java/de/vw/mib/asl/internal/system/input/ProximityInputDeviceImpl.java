/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.input;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.internal.system.input.AbstractInputDevice;
import de.vw.mib.asl.internal.system.input.ProximityInputDeviceImpl$1;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.input.devices.ProximityInputDevice;
import de.vw.mib.input.devices.ProximityInputDeviceListener;
import java.util.Iterator;
import org.dsi.ifc.keypanel.DSIKeyPanelListener;

public class ProximityInputDeviceImpl
extends AbstractInputDevice
implements ProximityInputDevice {
    static /* synthetic */ Class class$de$vw$mib$input$devices$ProximityInputDeviceListener;

    public ProximityInputDeviceImpl(DSIProxy dSIProxy, ConfigurationManager configurationManager) {
        super(dSIProxy, configurationManager);
    }

    @Override
    public int getType() {
        return 1;
    }

    @Override
    protected DSIKeyPanelListener createKeyPanelListener() {
        return new ProximityInputDeviceImpl$1(this);
    }

    @Override
    protected int[] getDsiAttributes() {
        return new int[]{27};
    }

    @Override
    protected Class getListenerClass() {
        return class$de$vw$mib$input$devices$ProximityInputDeviceListener == null ? (class$de$vw$mib$input$devices$ProximityInputDeviceListener = ProximityInputDeviceImpl.class$("de.vw.mib.input.devices.ProximityInputDeviceListener")) : class$de$vw$mib$input$devices$ProximityInputDeviceListener;
    }

    void notifiyProximityInputListeners(int n, int n2, float f2, float f3, float f4, float f5, float f6, int n3) {
        Iterator iterator = this.getListeners().iterator();
        while (iterator.hasNext()) {
            ProximityInputDeviceListener proximityInputDeviceListener = (ProximityInputDeviceListener)iterator.next();
            proximityInputDeviceListener.updateProximityInput(n, n2, f2, f3, f4, f5, f6, n3);
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

