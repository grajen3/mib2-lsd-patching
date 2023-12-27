/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.carlife;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.CallState;
import org.dsi.ifc.carlife.DeviceInfo;
import org.dsi.ifc.carlife.PlaybackInfo;
import org.dsi.ifc.carlife.PlaymodeInfo;
import org.dsi.ifc.carlife.Resource;
import org.dsi.ifc.carlife.ServiceConfiguration;
import org.dsi.ifc.carlife.TouchEvent;
import org.dsi.ifc.carlife.TrackData;

public final class DSICarlifeTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_APPSTATE;
    private static final int ID_CALLSTATE;
    private static final int ID_DEVICEINFO;
    private static final int ID_PLAYBACKINFO;
    private static final int ID_PLAYMODEINFO;
    private static final int ID_RESOURCE;
    private static final int ID_SERVICECONFIGURATION;
    private static final int ID_TOUCHEVENT;
    private static final int ID_TRACKDATA;
    static /* synthetic */ Class class$org$dsi$ifc$carlife$AppState;
    static /* synthetic */ Class class$org$dsi$ifc$carlife$CallState;
    static /* synthetic */ Class class$org$dsi$ifc$carlife$DeviceInfo;
    static /* synthetic */ Class class$org$dsi$ifc$carlife$PlaybackInfo;
    static /* synthetic */ Class class$org$dsi$ifc$carlife$PlaymodeInfo;
    static /* synthetic */ Class class$org$dsi$ifc$carlife$Resource;
    static /* synthetic */ Class class$org$dsi$ifc$carlife$ServiceConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$carlife$TouchEvent;
    static /* synthetic */ Class class$org$dsi$ifc$carlife$TrackData;

    public DSICarlifeTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carlife$AppState == null ? (class$org$dsi$ifc$carlife$AppState = DSICarlifeTracer.class$("org.dsi.ifc.carlife.AppState")) : class$org$dsi$ifc$carlife$AppState, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carlife$CallState == null ? (class$org$dsi$ifc$carlife$CallState = DSICarlifeTracer.class$("org.dsi.ifc.carlife.CallState")) : class$org$dsi$ifc$carlife$CallState, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carlife$DeviceInfo == null ? (class$org$dsi$ifc$carlife$DeviceInfo = DSICarlifeTracer.class$("org.dsi.ifc.carlife.DeviceInfo")) : class$org$dsi$ifc$carlife$DeviceInfo, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carlife$PlaybackInfo == null ? (class$org$dsi$ifc$carlife$PlaybackInfo = DSICarlifeTracer.class$("org.dsi.ifc.carlife.PlaybackInfo")) : class$org$dsi$ifc$carlife$PlaybackInfo, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carlife$PlaymodeInfo == null ? (class$org$dsi$ifc$carlife$PlaymodeInfo = DSICarlifeTracer.class$("org.dsi.ifc.carlife.PlaymodeInfo")) : class$org$dsi$ifc$carlife$PlaymodeInfo, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carlife$Resource == null ? (class$org$dsi$ifc$carlife$Resource = DSICarlifeTracer.class$("org.dsi.ifc.carlife.Resource")) : class$org$dsi$ifc$carlife$Resource, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carlife$ServiceConfiguration == null ? (class$org$dsi$ifc$carlife$ServiceConfiguration = DSICarlifeTracer.class$("org.dsi.ifc.carlife.ServiceConfiguration")) : class$org$dsi$ifc$carlife$ServiceConfiguration, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carlife$TouchEvent == null ? (class$org$dsi$ifc$carlife$TouchEvent = DSICarlifeTracer.class$("org.dsi.ifc.carlife.TouchEvent")) : class$org$dsi$ifc$carlife$TouchEvent, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carlife$TrackData == null ? (class$org$dsi$ifc$carlife$TrackData = DSICarlifeTracer.class$("org.dsi.ifc.carlife.TrackData")) : class$org$dsi$ifc$carlife$TrackData, 9);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceAppState(printWriter, (AppState)object);
                break;
            }
            case 2: {
                this.traceCallState(printWriter, (CallState)object);
                break;
            }
            case 3: {
                this.traceDeviceInfo(printWriter, (DeviceInfo)object);
                break;
            }
            case 4: {
                this.tracePlaybackInfo(printWriter, (PlaybackInfo)object);
                break;
            }
            case 5: {
                this.tracePlaymodeInfo(printWriter, (PlaymodeInfo)object);
                break;
            }
            case 6: {
                this.traceResource(printWriter, (Resource)object);
                break;
            }
            case 7: {
                this.traceServiceConfiguration(printWriter, (ServiceConfiguration)object);
                break;
            }
            case 8: {
                this.traceTouchEvent(printWriter, (TouchEvent)object);
                break;
            }
            case 9: {
                this.traceTrackData(printWriter, (TrackData)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceAppState(PrintWriter printWriter, AppState appState) {
        if (appState == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(appState.appStateID);
        printWriter.print(appState.owner);
    }

    private void traceCallState(PrintWriter printWriter, CallState callState) {
        if (callState == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(callState.status);
        printWriter.print(callState.direction);
    }

    private void traceDeviceInfo(PrintWriter printWriter, DeviceInfo deviceInfo) {
        if (deviceInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(deviceInfo.os);
        printWriter.print(deviceInfo.board);
        printWriter.print(deviceInfo.bootloader);
        printWriter.print(deviceInfo.brand);
        printWriter.print(deviceInfo.cpuAbi);
        printWriter.print(deviceInfo.cpuAbi2);
        printWriter.print(deviceInfo.device);
        printWriter.print(deviceInfo.display);
        printWriter.print(deviceInfo.fingerprint);
        printWriter.print(deviceInfo.hardware);
        printWriter.print(deviceInfo.host);
        printWriter.print(deviceInfo.cid);
        printWriter.print(deviceInfo.manufacturer);
        printWriter.print(deviceInfo.model);
        printWriter.print(deviceInfo.product);
        printWriter.print(deviceInfo.serial);
        printWriter.print(deviceInfo.codename);
        printWriter.print(deviceInfo.incremental);
        printWriter.print(deviceInfo.release);
        printWriter.print(deviceInfo.sdk);
        printWriter.print(deviceInfo.sdkInt);
        printWriter.print(deviceInfo.token);
    }

    private void tracePlaybackInfo(PrintWriter printWriter, PlaybackInfo playbackInfo) {
        if (playbackInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(playbackInfo.status);
        printWriter.print(playbackInfo.playbackApp);
    }

    private void tracePlaymodeInfo(PrintWriter printWriter, PlaymodeInfo playmodeInfo) {
        if (playmodeInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(playmodeInfo.shuffleMode);
        printWriter.print(playmodeInfo.repeatMode);
    }

    private void traceResource(PrintWriter printWriter, Resource resource) {
        if (resource == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(resource.resourceID);
        printWriter.print(resource.owner);
    }

    private void traceServiceConfiguration(PrintWriter printWriter, ServiceConfiguration serviceConfiguration) {
        int n;
        int n2;
        if (serviceConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        if (serviceConfiguration.initialAppState == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = serviceConfiguration.initialAppState.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, serviceConfiguration.initialAppState[n]);
            }
        }
        if (serviceConfiguration.initialResources == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = serviceConfiguration.initialResources.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, serviceConfiguration.initialResources[n]);
            }
        }
        printWriter.print(serviceConfiguration.displayResolutionX);
        printWriter.print(serviceConfiguration.displayResolutionY);
        printWriter.print(serviceConfiguration.displayOffsetX);
        printWriter.print(serviceConfiguration.displayOffsetY);
        printWriter.print(serviceConfiguration.displayName);
        printWriter.print(serviceConfiguration.useRightHandDrive);
        printWriter.print(serviceConfiguration.touchscreenAvailable);
        printWriter.print(serviceConfiguration.touchscreenResolutionX);
        printWriter.print(serviceConfiguration.touchscreenResolutionY);
        printWriter.print(serviceConfiguration.touchpadAvailable);
        printWriter.print(serviceConfiguration.touchpadResolutionX);
        printWriter.print(serviceConfiguration.touchpadResolutionY);
        printWriter.print(serviceConfiguration.startInNightMode);
        printWriter.print(serviceConfiguration.physicalDisplayHeight);
        printWriter.print(serviceConfiguration.physicalDisplayWidth);
    }

    private void traceTouchEvent(PrintWriter printWriter, TouchEvent touchEvent) {
        if (touchEvent == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(touchEvent.x);
        printWriter.print(touchEvent.y);
        printWriter.print(touchEvent.action);
    }

    private void traceTrackData(PrintWriter printWriter, TrackData trackData) {
        if (trackData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(trackData.source);
        printWriter.print(trackData.title);
        printWriter.print(trackData.duration);
        printWriter.print(trackData.album);
        printWriter.print(trackData.artist);
        printWriter.print(trackData.playlistNum);
        printWriter.print(trackData.songid);
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

