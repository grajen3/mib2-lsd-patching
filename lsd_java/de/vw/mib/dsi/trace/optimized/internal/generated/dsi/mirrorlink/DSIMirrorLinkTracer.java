/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.mirrorlink;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.mirrorlink.Action;
import org.dsi.ifc.mirrorlink.Application;
import org.dsi.ifc.mirrorlink.ClientCapabilities;
import org.dsi.ifc.mirrorlink.Device;
import org.dsi.ifc.mirrorlink.DisplayCapabilities;
import org.dsi.ifc.mirrorlink.Event;
import org.dsi.ifc.mirrorlink.IconCapabilities;
import org.dsi.ifc.mirrorlink.Notification;

public final class DSIMirrorLinkTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_ACTION;
    private static final int ID_APPLICATION;
    private static final int ID_CLIENTCAPABILITIES;
    private static final int ID_DEVICE;
    private static final int ID_DISPLAYCAPABILITIES;
    private static final int ID_EVENT;
    private static final int ID_ICONCAPABILITIES;
    private static final int ID_NOTIFICATION;
    static /* synthetic */ Class class$org$dsi$ifc$mirrorlink$Action;
    static /* synthetic */ Class class$org$dsi$ifc$mirrorlink$Application;
    static /* synthetic */ Class class$org$dsi$ifc$mirrorlink$ClientCapabilities;
    static /* synthetic */ Class class$org$dsi$ifc$mirrorlink$Device;
    static /* synthetic */ Class class$org$dsi$ifc$mirrorlink$DisplayCapabilities;
    static /* synthetic */ Class class$org$dsi$ifc$mirrorlink$Event;
    static /* synthetic */ Class class$org$dsi$ifc$mirrorlink$IconCapabilities;
    static /* synthetic */ Class class$org$dsi$ifc$mirrorlink$Notification;

    public DSIMirrorLinkTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$mirrorlink$Action == null ? (class$org$dsi$ifc$mirrorlink$Action = DSIMirrorLinkTracer.class$("org.dsi.ifc.mirrorlink.Action")) : class$org$dsi$ifc$mirrorlink$Action, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$mirrorlink$Application == null ? (class$org$dsi$ifc$mirrorlink$Application = DSIMirrorLinkTracer.class$("org.dsi.ifc.mirrorlink.Application")) : class$org$dsi$ifc$mirrorlink$Application, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$mirrorlink$ClientCapabilities == null ? (class$org$dsi$ifc$mirrorlink$ClientCapabilities = DSIMirrorLinkTracer.class$("org.dsi.ifc.mirrorlink.ClientCapabilities")) : class$org$dsi$ifc$mirrorlink$ClientCapabilities, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$mirrorlink$Device == null ? (class$org$dsi$ifc$mirrorlink$Device = DSIMirrorLinkTracer.class$("org.dsi.ifc.mirrorlink.Device")) : class$org$dsi$ifc$mirrorlink$Device, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$mirrorlink$DisplayCapabilities == null ? (class$org$dsi$ifc$mirrorlink$DisplayCapabilities = DSIMirrorLinkTracer.class$("org.dsi.ifc.mirrorlink.DisplayCapabilities")) : class$org$dsi$ifc$mirrorlink$DisplayCapabilities, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$mirrorlink$Event == null ? (class$org$dsi$ifc$mirrorlink$Event = DSIMirrorLinkTracer.class$("org.dsi.ifc.mirrorlink.Event")) : class$org$dsi$ifc$mirrorlink$Event, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$mirrorlink$IconCapabilities == null ? (class$org$dsi$ifc$mirrorlink$IconCapabilities = DSIMirrorLinkTracer.class$("org.dsi.ifc.mirrorlink.IconCapabilities")) : class$org$dsi$ifc$mirrorlink$IconCapabilities, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$mirrorlink$Notification == null ? (class$org$dsi$ifc$mirrorlink$Notification = DSIMirrorLinkTracer.class$("org.dsi.ifc.mirrorlink.Notification")) : class$org$dsi$ifc$mirrorlink$Notification, 8);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceAction(printWriter, (Action)object);
                break;
            }
            case 2: {
                this.traceApplication(printWriter, (Application)object);
                break;
            }
            case 3: {
                this.traceClientCapabilities(printWriter, (ClientCapabilities)object);
                break;
            }
            case 4: {
                this.traceDevice(printWriter, (Device)object);
                break;
            }
            case 5: {
                this.traceDisplayCapabilities(printWriter, (DisplayCapabilities)object);
                break;
            }
            case 6: {
                this.traceEvent(printWriter, (Event)object);
                break;
            }
            case 7: {
                this.traceIconCapabilities(printWriter, (IconCapabilities)object);
                break;
            }
            case 8: {
                this.traceNotification(printWriter, (Notification)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceAction(PrintWriter printWriter, Action action) {
        if (action == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(action.actionId);
        printWriter.print(action.actionName);
        printWriter.print(action.launchApp);
    }

    private void traceApplication(PrintWriter printWriter, Application application) {
        if (application == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(application.appID);
        printWriter.print(application.appName);
        printWriter.print(application.appCategory);
        this.trace(printWriter, application.appIcon);
        printWriter.print(application.certType);
        printWriter.print(application.notLaunchableReason);
    }

    private void traceClientCapabilities(PrintWriter printWriter, ClientCapabilities clientCapabilities) {
        if (clientCapabilities == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, clientCapabilities.displayCapabilities);
        this.trace(printWriter, clientCapabilities.iconCapabilities);
        printWriter.print(clientCapabilities.numberOfSimultaneousEvents);
    }

    private void traceDevice(PrintWriter printWriter, Device device) {
        if (device == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(device.deviceID);
        printWriter.print(device.deviceName);
        printWriter.print(device.connectionMedium);
        printWriter.print(device.deviceAddress);
    }

    private void traceDisplayCapabilities(PrintWriter printWriter, DisplayCapabilities displayCapabilities) {
        if (displayCapabilities == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(displayCapabilities.screenWidthInPx);
        printWriter.print(displayCapabilities.screenHeightInPx);
        printWriter.print(displayCapabilities.screenWidthInMm);
        printWriter.print(displayCapabilities.screenHeightInMm);
        printWriter.print(displayCapabilities.screenPositionX);
        printWriter.print(displayCapabilities.screenPositionY);
        printWriter.print(displayCapabilities.displayDistanceToUser);
    }

    private void traceEvent(PrintWriter printWriter, Event event) {
        if (event == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(event.xPosition);
        printWriter.print(event.yPosition);
        printWriter.print(event.eventID);
        printWriter.print(event.pressureValue);
    }

    private void traceIconCapabilities(PrintWriter printWriter, IconCapabilities iconCapabilities) {
        if (iconCapabilities == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(iconCapabilities.iconWidth);
        printWriter.print(iconCapabilities.iconHeight);
        printWriter.print(iconCapabilities.colourDepth);
    }

    private void traceNotification(PrintWriter printWriter, Notification notification) {
        if (notification == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(notification.notiID);
        printWriter.print(notification.title);
        printWriter.print(notification.notiBody);
        printWriter.print(notification.appId);
        if (notification.actionList == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = notification.actionList.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, notification.actionList[i2]);
            }
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

