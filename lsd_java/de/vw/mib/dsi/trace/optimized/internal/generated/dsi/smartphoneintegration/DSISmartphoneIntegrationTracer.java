/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.smartphoneintegration;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.smartphoneintegration.Device;

public final class DSISmartphoneIntegrationTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_DEVICE;
    static /* synthetic */ Class class$org$dsi$ifc$smartphoneintegration$Device;

    public DSISmartphoneIntegrationTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$smartphoneintegration$Device == null ? (class$org$dsi$ifc$smartphoneintegration$Device = DSISmartphoneIntegrationTracer.class$("org.dsi.ifc.smartphoneintegration.Device")) : class$org$dsi$ifc$smartphoneintegration$Device, 1);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceDevice(printWriter, (Device)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceDevice(PrintWriter printWriter, Device device) {
        if (device == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(device.deviceID);
        printWriter.print(device.deviceName);
        printWriter.print(device.connectionType);
        printWriter.print(device.deviceAddress);
        printWriter.print(device.connectionMethod);
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

