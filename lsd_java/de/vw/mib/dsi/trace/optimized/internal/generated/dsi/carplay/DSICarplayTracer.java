/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.carplay;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.AppStateRequest;
import org.dsi.ifc.carplay.CallState;
import org.dsi.ifc.carplay.DeviceInfo;
import org.dsi.ifc.carplay.PlaybackInfo;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.ResourceRequest;
import org.dsi.ifc.carplay.ServiceConfiguration;
import org.dsi.ifc.carplay.TelephonyState;
import org.dsi.ifc.carplay.TouchEvent;
import org.dsi.ifc.carplay.TrackData;

public final class DSICarplayTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_APPSTATE;
    private static final int ID_APPSTATEREQUEST;
    private static final int ID_CALLSTATE;
    private static final int ID_DEVICEINFO;
    private static final int ID_PLAYBACKINFO;
    private static final int ID_RESOURCE;
    private static final int ID_RESOURCEREQUEST;
    private static final int ID_SERVICECONFIGURATION;
    private static final int ID_TELEPHONYSTATE;
    private static final int ID_TOUCHEVENT;
    private static final int ID_TRACKDATA;
    static /* synthetic */ Class class$org$dsi$ifc$carplay$AppState;
    static /* synthetic */ Class class$org$dsi$ifc$carplay$AppStateRequest;
    static /* synthetic */ Class class$org$dsi$ifc$carplay$CallState;
    static /* synthetic */ Class class$org$dsi$ifc$carplay$DeviceInfo;
    static /* synthetic */ Class class$org$dsi$ifc$carplay$PlaybackInfo;
    static /* synthetic */ Class class$org$dsi$ifc$carplay$Resource;
    static /* synthetic */ Class class$org$dsi$ifc$carplay$ResourceRequest;
    static /* synthetic */ Class class$org$dsi$ifc$carplay$ServiceConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$carplay$TelephonyState;
    static /* synthetic */ Class class$org$dsi$ifc$carplay$TouchEvent;
    static /* synthetic */ Class class$org$dsi$ifc$carplay$TrackData;

    public DSICarplayTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carplay$AppState == null ? (class$org$dsi$ifc$carplay$AppState = DSICarplayTracer.class$("org.dsi.ifc.carplay.AppState")) : class$org$dsi$ifc$carplay$AppState, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carplay$AppStateRequest == null ? (class$org$dsi$ifc$carplay$AppStateRequest = DSICarplayTracer.class$("org.dsi.ifc.carplay.AppStateRequest")) : class$org$dsi$ifc$carplay$AppStateRequest, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carplay$CallState == null ? (class$org$dsi$ifc$carplay$CallState = DSICarplayTracer.class$("org.dsi.ifc.carplay.CallState")) : class$org$dsi$ifc$carplay$CallState, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carplay$DeviceInfo == null ? (class$org$dsi$ifc$carplay$DeviceInfo = DSICarplayTracer.class$("org.dsi.ifc.carplay.DeviceInfo")) : class$org$dsi$ifc$carplay$DeviceInfo, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carplay$PlaybackInfo == null ? (class$org$dsi$ifc$carplay$PlaybackInfo = DSICarplayTracer.class$("org.dsi.ifc.carplay.PlaybackInfo")) : class$org$dsi$ifc$carplay$PlaybackInfo, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carplay$Resource == null ? (class$org$dsi$ifc$carplay$Resource = DSICarplayTracer.class$("org.dsi.ifc.carplay.Resource")) : class$org$dsi$ifc$carplay$Resource, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carplay$ResourceRequest == null ? (class$org$dsi$ifc$carplay$ResourceRequest = DSICarplayTracer.class$("org.dsi.ifc.carplay.ResourceRequest")) : class$org$dsi$ifc$carplay$ResourceRequest, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carplay$ServiceConfiguration == null ? (class$org$dsi$ifc$carplay$ServiceConfiguration = DSICarplayTracer.class$("org.dsi.ifc.carplay.ServiceConfiguration")) : class$org$dsi$ifc$carplay$ServiceConfiguration, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carplay$TelephonyState == null ? (class$org$dsi$ifc$carplay$TelephonyState = DSICarplayTracer.class$("org.dsi.ifc.carplay.TelephonyState")) : class$org$dsi$ifc$carplay$TelephonyState, 9);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carplay$TouchEvent == null ? (class$org$dsi$ifc$carplay$TouchEvent = DSICarplayTracer.class$("org.dsi.ifc.carplay.TouchEvent")) : class$org$dsi$ifc$carplay$TouchEvent, 10);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carplay$TrackData == null ? (class$org$dsi$ifc$carplay$TrackData = DSICarplayTracer.class$("org.dsi.ifc.carplay.TrackData")) : class$org$dsi$ifc$carplay$TrackData, 11);
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
                this.traceAppStateRequest(printWriter, (AppStateRequest)object);
                break;
            }
            case 3: {
                this.traceCallState(printWriter, (CallState)object);
                break;
            }
            case 4: {
                this.traceDeviceInfo(printWriter, (DeviceInfo)object);
                break;
            }
            case 5: {
                this.tracePlaybackInfo(printWriter, (PlaybackInfo)object);
                break;
            }
            case 6: {
                this.traceResource(printWriter, (Resource)object);
                break;
            }
            case 7: {
                this.traceResourceRequest(printWriter, (ResourceRequest)object);
                break;
            }
            case 8: {
                this.traceServiceConfiguration(printWriter, (ServiceConfiguration)object);
                break;
            }
            case 9: {
                this.traceTelephonyState(printWriter, (TelephonyState)object);
                break;
            }
            case 10: {
                this.traceTouchEvent(printWriter, (TouchEvent)object);
                break;
            }
            case 11: {
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
        printWriter.print(appState.speechMode);
    }

    private void traceAppStateRequest(PrintWriter printWriter, AppStateRequest appStateRequest) {
        if (appStateRequest == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(appStateRequest.appStateID);
        printWriter.print(appStateRequest.state);
        printWriter.print(appStateRequest.speechMode);
    }

    private void traceCallState(PrintWriter printWriter, CallState callState) {
        if (callState == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(callState.phoneNumber);
        printWriter.print(callState.callerName);
        printWriter.print(callState.status);
        printWriter.print(callState.direction);
        printWriter.print(callState.uniqueCallID);
    }

    private void traceDeviceInfo(PrintWriter printWriter, DeviceInfo deviceInfo) {
        if (deviceInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(deviceInfo.deviceID);
        printWriter.print(deviceInfo.deviceName);
        printWriter.print(deviceInfo.deviceLanguage);
        printWriter.print(deviceInfo.osBuildVersion);
        printWriter.print(deviceInfo.airplayVersion);
        printWriter.print(deviceInfo.sessionID);
    }

    private void tracePlaybackInfo(PrintWriter printWriter, PlaybackInfo playbackInfo) {
        if (playbackInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(playbackInfo.status);
        printWriter.print(playbackInfo.shuffleMode);
        printWriter.print(playbackInfo.repeatMode);
        printWriter.print(playbackInfo.playbackApp);
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

    private void traceResourceRequest(PrintWriter printWriter, ResourceRequest resourceRequest) {
        if (resourceRequest == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(resourceRequest.resourceID);
        printWriter.print(resourceRequest.transferType);
        printWriter.print(resourceRequest.transferPriority);
        printWriter.print(resourceRequest.takeConstraint);
        printWriter.print(resourceRequest.borrowConstraint);
        printWriter.print(resourceRequest.unborrowConstraint);
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
        printWriter.print(serviceConfiguration.screenResolution);
        printWriter.print(serviceConfiguration.xResolution);
        printWriter.print(serviceConfiguration.yResolution);
        printWriter.print(serviceConfiguration.xOffset);
        printWriter.print(serviceConfiguration.yOffset);
        printWriter.print(serviceConfiguration.displayName);
        printWriter.print(serviceConfiguration.useRightHandDrive);
        printWriter.print(serviceConfiguration.touchpadXResolution);
        printWriter.print(serviceConfiguration.touchpadYResolution);
        if (serviceConfiguration.bluetoothIdentities == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = serviceConfiguration.bluetoothIdentities.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(serviceConfiguration.bluetoothIdentities[n]);
            }
        }
        printWriter.print(serviceConfiguration.startInNightMode);
        printWriter.print(serviceConfiguration.physicalDisplayHeight);
        printWriter.print(serviceConfiguration.physicalDisplayWidth);
        printWriter.print(serviceConfiguration.inputFeatures);
    }

    private void traceTelephonyState(PrintWriter printWriter, TelephonyState telephonyState) {
        if (telephonyState == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(telephonyState.signalStrength);
        printWriter.print(telephonyState.registrationStatus);
        printWriter.print(telephonyState.airplaneMode);
        printWriter.print(telephonyState.mobileOperator);
    }

    private void traceTouchEvent(PrintWriter printWriter, TouchEvent touchEvent) {
        if (touchEvent == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(touchEvent.x);
        printWriter.print(touchEvent.y);
    }

    private void traceTrackData(PrintWriter printWriter, TrackData trackData) {
        if (trackData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(trackData.title);
        printWriter.print(trackData.duration);
        printWriter.print(trackData.album);
        printWriter.print(trackData.artist);
        printWriter.print(trackData.genre);
        printWriter.print(trackData.composer);
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

