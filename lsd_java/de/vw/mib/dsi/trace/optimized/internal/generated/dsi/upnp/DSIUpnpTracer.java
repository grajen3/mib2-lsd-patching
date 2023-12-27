/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.upnp;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.upnp.DeviceInfo;
import org.dsi.ifc.upnp.EntryInfo;
import org.dsi.ifc.upnp.ListEntry;
import org.dsi.ifc.upnp.PlaybackMode;

public final class DSIUpnpTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_DEVICEINFO;
    private static final int ID_ENTRYINFO;
    private static final int ID_LISTENTRY;
    private static final int ID_PLAYBACKMODE;
    static /* synthetic */ Class class$org$dsi$ifc$upnp$DeviceInfo;
    static /* synthetic */ Class class$org$dsi$ifc$upnp$EntryInfo;
    static /* synthetic */ Class class$org$dsi$ifc$upnp$ListEntry;
    static /* synthetic */ Class class$org$dsi$ifc$upnp$PlaybackMode;

    public DSIUpnpTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$upnp$DeviceInfo == null ? (class$org$dsi$ifc$upnp$DeviceInfo = DSIUpnpTracer.class$("org.dsi.ifc.upnp.DeviceInfo")) : class$org$dsi$ifc$upnp$DeviceInfo, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$upnp$EntryInfo == null ? (class$org$dsi$ifc$upnp$EntryInfo = DSIUpnpTracer.class$("org.dsi.ifc.upnp.EntryInfo")) : class$org$dsi$ifc$upnp$EntryInfo, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$upnp$ListEntry == null ? (class$org$dsi$ifc$upnp$ListEntry = DSIUpnpTracer.class$("org.dsi.ifc.upnp.ListEntry")) : class$org$dsi$ifc$upnp$ListEntry, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$upnp$PlaybackMode == null ? (class$org$dsi$ifc$upnp$PlaybackMode = DSIUpnpTracer.class$("org.dsi.ifc.upnp.PlaybackMode")) : class$org$dsi$ifc$upnp$PlaybackMode, 4);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceDeviceInfo(printWriter, (DeviceInfo)object);
                break;
            }
            case 2: {
                this.traceEntryInfo(printWriter, (EntryInfo)object);
                break;
            }
            case 3: {
                this.traceListEntry(printWriter, (ListEntry)object);
                break;
            }
            case 4: {
                this.tracePlaybackMode(printWriter, (PlaybackMode)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceDeviceInfo(PrintWriter printWriter, DeviceInfo deviceInfo) {
        if (deviceInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(deviceInfo.deviceName);
        printWriter.print(deviceInfo.deviceID);
        printWriter.print(deviceInfo.deviceType);
    }

    private void traceEntryInfo(PrintWriter printWriter, EntryInfo entryInfo) {
        if (entryInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(entryInfo.entryID);
        printWriter.print(entryInfo.filename);
        printWriter.print(entryInfo.contentType);
        printWriter.print(entryInfo.title);
        printWriter.print(entryInfo.trackNo);
        printWriter.print(entryInfo.numTracks);
        printWriter.print(entryInfo.album);
        printWriter.print(entryInfo.artist);
        printWriter.print(entryInfo.genre);
        printWriter.print(entryInfo.year);
        printWriter.print(entryInfo.comments);
        printWriter.print(entryInfo.avgBitrate);
        printWriter.print(entryInfo.samplingrate);
        printWriter.print(entryInfo.rating);
        printWriter.print(entryInfo.flags);
    }

    private void traceListEntry(PrintWriter printWriter, ListEntry listEntry) {
        if (listEntry == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(listEntry.entryID);
        printWriter.print(listEntry.filename);
        printWriter.print(listEntry.title);
        printWriter.print(listEntry.contentType);
        printWriter.print(listEntry.secLength);
        printWriter.print(listEntry.flags);
    }

    private void tracePlaybackMode(PrintWriter printWriter, PlaybackMode playbackMode) {
        if (playbackMode == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(playbackMode.modeID);
        printWriter.print(playbackMode.scope);
        printWriter.print(playbackMode.modeFlag);
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

