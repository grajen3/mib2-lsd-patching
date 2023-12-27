/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.androidauto;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.androidauto.AppState;
import org.dsi.ifc.androidauto.AppStateRequest;
import org.dsi.ifc.androidauto.CallState;
import org.dsi.ifc.androidauto.PlaybackInfo;
import org.dsi.ifc.androidauto.Resource;
import org.dsi.ifc.androidauto.ResourceRequest;
import org.dsi.ifc.androidauto.ServiceConfiguration;
import org.dsi.ifc.androidauto.TelephonyState;
import org.dsi.ifc.androidauto.TouchEvent;
import org.dsi.ifc.androidauto.TrackData;

public final class DSIAndroidAutoTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_APPSTATE;
    private static final int ID_APPSTATEREQUEST;
    private static final int ID_CALLSTATE;
    private static final int ID_PLAYBACKINFO;
    private static final int ID_RESOURCE;
    private static final int ID_RESOURCEREQUEST;
    private static final int ID_SERVICECONFIGURATION;
    private static final int ID_TELEPHONYSTATE;
    private static final int ID_TOUCHEVENT;
    private static final int ID_TRACKDATA;
    static /* synthetic */ Class class$org$dsi$ifc$androidauto$AppState;
    static /* synthetic */ Class class$org$dsi$ifc$androidauto$AppStateRequest;
    static /* synthetic */ Class class$org$dsi$ifc$androidauto$CallState;
    static /* synthetic */ Class class$org$dsi$ifc$androidauto$PlaybackInfo;
    static /* synthetic */ Class class$org$dsi$ifc$androidauto$Resource;
    static /* synthetic */ Class class$org$dsi$ifc$androidauto$ResourceRequest;
    static /* synthetic */ Class class$org$dsi$ifc$androidauto$ServiceConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$androidauto$TelephonyState;
    static /* synthetic */ Class class$org$dsi$ifc$androidauto$TouchEvent;
    static /* synthetic */ Class class$org$dsi$ifc$androidauto$TrackData;

    public DSIAndroidAutoTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$androidauto$AppState == null ? (class$org$dsi$ifc$androidauto$AppState = DSIAndroidAutoTracer.class$("org.dsi.ifc.androidauto.AppState")) : class$org$dsi$ifc$androidauto$AppState, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$androidauto$AppStateRequest == null ? (class$org$dsi$ifc$androidauto$AppStateRequest = DSIAndroidAutoTracer.class$("org.dsi.ifc.androidauto.AppStateRequest")) : class$org$dsi$ifc$androidauto$AppStateRequest, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$androidauto$CallState == null ? (class$org$dsi$ifc$androidauto$CallState = DSIAndroidAutoTracer.class$("org.dsi.ifc.androidauto.CallState")) : class$org$dsi$ifc$androidauto$CallState, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$androidauto$PlaybackInfo == null ? (class$org$dsi$ifc$androidauto$PlaybackInfo = DSIAndroidAutoTracer.class$("org.dsi.ifc.androidauto.PlaybackInfo")) : class$org$dsi$ifc$androidauto$PlaybackInfo, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$androidauto$Resource == null ? (class$org$dsi$ifc$androidauto$Resource = DSIAndroidAutoTracer.class$("org.dsi.ifc.androidauto.Resource")) : class$org$dsi$ifc$androidauto$Resource, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$androidauto$ResourceRequest == null ? (class$org$dsi$ifc$androidauto$ResourceRequest = DSIAndroidAutoTracer.class$("org.dsi.ifc.androidauto.ResourceRequest")) : class$org$dsi$ifc$androidauto$ResourceRequest, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$androidauto$ServiceConfiguration == null ? (class$org$dsi$ifc$androidauto$ServiceConfiguration = DSIAndroidAutoTracer.class$("org.dsi.ifc.androidauto.ServiceConfiguration")) : class$org$dsi$ifc$androidauto$ServiceConfiguration, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$androidauto$TelephonyState == null ? (class$org$dsi$ifc$androidauto$TelephonyState = DSIAndroidAutoTracer.class$("org.dsi.ifc.androidauto.TelephonyState")) : class$org$dsi$ifc$androidauto$TelephonyState, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$androidauto$TouchEvent == null ? (class$org$dsi$ifc$androidauto$TouchEvent = DSIAndroidAutoTracer.class$("org.dsi.ifc.androidauto.TouchEvent")) : class$org$dsi$ifc$androidauto$TouchEvent, 9);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$androidauto$TrackData == null ? (class$org$dsi$ifc$androidauto$TrackData = DSIAndroidAutoTracer.class$("org.dsi.ifc.androidauto.TrackData")) : class$org$dsi$ifc$androidauto$TrackData, 10);
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
                this.tracePlaybackInfo(printWriter, (PlaybackInfo)object);
                break;
            }
            case 5: {
                this.traceResource(printWriter, (Resource)object);
                break;
            }
            case 6: {
                this.traceResourceRequest(printWriter, (ResourceRequest)object);
                break;
            }
            case 7: {
                this.traceServiceConfiguration(printWriter, (ServiceConfiguration)object);
                break;
            }
            case 8: {
                this.traceTelephonyState(printWriter, (TelephonyState)object);
                break;
            }
            case 9: {
                this.traceTouchEvent(printWriter, (TouchEvent)object);
                break;
            }
            case 10: {
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

    private void traceAppStateRequest(PrintWriter printWriter, AppStateRequest appStateRequest) {
        if (appStateRequest == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(appStateRequest.appStateID);
        printWriter.print(appStateRequest.state);
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
        this.trace(printWriter, callState.callerThumbnail);
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
        printWriter.print(serviceConfiguration.touchpadAvailable);
        printWriter.print(serviceConfiguration.touchpadResolutionX);
        printWriter.print(serviceConfiguration.touchpadResolutionY);
        printWriter.print(serviceConfiguration.touchscreenAvailable);
        printWriter.print(serviceConfiguration.touchscreenResolutionX);
        printWriter.print(serviceConfiguration.touchscreenResolutionY);
        printWriter.print(serviceConfiguration.startInNightMode);
        printWriter.print(serviceConfiguration.physicalDisplayHeight);
        printWriter.print(serviceConfiguration.physicalDisplayWidth);
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
        printWriter.print(touchEvent.pointerID);
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

