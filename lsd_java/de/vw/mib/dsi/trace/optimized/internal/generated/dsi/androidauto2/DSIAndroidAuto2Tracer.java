/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.androidauto2;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.androidauto2.BluetoothServiceAnnouncement;
import org.dsi.ifc.androidauto2.CallState;
import org.dsi.ifc.androidauto2.PlaybackInfo;
import org.dsi.ifc.androidauto2.ServiceConfiguration;
import org.dsi.ifc.androidauto2.TelephonyState;
import org.dsi.ifc.androidauto2.TouchEvent;
import org.dsi.ifc.androidauto2.TrackData;

public final class DSIAndroidAuto2Tracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_BLUETOOTHSERVICEANNOUNCEMENT;
    private static final int ID_CALLSTATE;
    private static final int ID_PLAYBACKINFO;
    private static final int ID_SERVICECONFIGURATION;
    private static final int ID_TELEPHONYSTATE;
    private static final int ID_TOUCHEVENT;
    private static final int ID_TRACKDATA;
    static /* synthetic */ Class class$org$dsi$ifc$androidauto2$BluetoothServiceAnnouncement;
    static /* synthetic */ Class class$org$dsi$ifc$androidauto2$CallState;
    static /* synthetic */ Class class$org$dsi$ifc$androidauto2$PlaybackInfo;
    static /* synthetic */ Class class$org$dsi$ifc$androidauto2$ServiceConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$androidauto2$TelephonyState;
    static /* synthetic */ Class class$org$dsi$ifc$androidauto2$TouchEvent;
    static /* synthetic */ Class class$org$dsi$ifc$androidauto2$TrackData;

    public DSIAndroidAuto2Tracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$androidauto2$BluetoothServiceAnnouncement == null ? (class$org$dsi$ifc$androidauto2$BluetoothServiceAnnouncement = DSIAndroidAuto2Tracer.class$("org.dsi.ifc.androidauto2.BluetoothServiceAnnouncement")) : class$org$dsi$ifc$androidauto2$BluetoothServiceAnnouncement, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$androidauto2$CallState == null ? (class$org$dsi$ifc$androidauto2$CallState = DSIAndroidAuto2Tracer.class$("org.dsi.ifc.androidauto2.CallState")) : class$org$dsi$ifc$androidauto2$CallState, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$androidauto2$PlaybackInfo == null ? (class$org$dsi$ifc$androidauto2$PlaybackInfo = DSIAndroidAuto2Tracer.class$("org.dsi.ifc.androidauto2.PlaybackInfo")) : class$org$dsi$ifc$androidauto2$PlaybackInfo, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$androidauto2$ServiceConfiguration == null ? (class$org$dsi$ifc$androidauto2$ServiceConfiguration = DSIAndroidAuto2Tracer.class$("org.dsi.ifc.androidauto2.ServiceConfiguration")) : class$org$dsi$ifc$androidauto2$ServiceConfiguration, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$androidauto2$TelephonyState == null ? (class$org$dsi$ifc$androidauto2$TelephonyState = DSIAndroidAuto2Tracer.class$("org.dsi.ifc.androidauto2.TelephonyState")) : class$org$dsi$ifc$androidauto2$TelephonyState, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$androidauto2$TouchEvent == null ? (class$org$dsi$ifc$androidauto2$TouchEvent = DSIAndroidAuto2Tracer.class$("org.dsi.ifc.androidauto2.TouchEvent")) : class$org$dsi$ifc$androidauto2$TouchEvent, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$androidauto2$TrackData == null ? (class$org$dsi$ifc$androidauto2$TrackData = DSIAndroidAuto2Tracer.class$("org.dsi.ifc.androidauto2.TrackData")) : class$org$dsi$ifc$androidauto2$TrackData, 7);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceBluetoothServiceAnnouncement(printWriter, (BluetoothServiceAnnouncement)object);
                break;
            }
            case 2: {
                this.traceCallState(printWriter, (CallState)object);
                break;
            }
            case 3: {
                this.tracePlaybackInfo(printWriter, (PlaybackInfo)object);
                break;
            }
            case 4: {
                this.traceServiceConfiguration(printWriter, (ServiceConfiguration)object);
                break;
            }
            case 5: {
                this.traceTelephonyState(printWriter, (TelephonyState)object);
                break;
            }
            case 6: {
                this.traceTouchEvent(printWriter, (TouchEvent)object);
                break;
            }
            case 7: {
                this.traceTrackData(printWriter, (TrackData)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceBluetoothServiceAnnouncement(PrintWriter printWriter, BluetoothServiceAnnouncement bluetoothServiceAnnouncement) {
        if (bluetoothServiceAnnouncement == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bluetoothServiceAnnouncement.macAddressHU);
        printWriter.print(bluetoothServiceAnnouncement.supportedPairingMethods);
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

    private void traceServiceConfiguration(PrintWriter printWriter, ServiceConfiguration serviceConfiguration) {
        if (serviceConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(serviceConfiguration.displayResolutionX);
        printWriter.print(serviceConfiguration.displayResolutionY);
        printWriter.print(serviceConfiguration.driverPosition);
        printWriter.print(serviceConfiguration.touchpadAvailable);
        printWriter.print(serviceConfiguration.touchpadResolutionX);
        printWriter.print(serviceConfiguration.touchpadResolutionY);
        printWriter.print(serviceConfiguration.touchscreenAvailable);
        printWriter.print(serviceConfiguration.touchscreenResolutionX);
        printWriter.print(serviceConfiguration.touchscreenResolutionY);
        printWriter.print(serviceConfiguration.physicalDisplayHeight);
        printWriter.print(serviceConfiguration.physicalDisplayWidth);
        printWriter.print(serviceConfiguration.rotaryControllerAvailable);
        printWriter.print(serviceConfiguration.externalBluetoothPairing);
        this.trace(printWriter, serviceConfiguration.pairingAnnoncement);
        printWriter.print(serviceConfiguration.windowResolutionX);
        printWriter.print(serviceConfiguration.windowResolutionY);
        printWriter.print(serviceConfiguration.windowOffsetX);
        printWriter.print(serviceConfiguration.windowOffsetY);
    }

    private void traceTelephonyState(PrintWriter printWriter, TelephonyState telephonyState) {
        if (telephonyState == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(telephonyState.signalStrength);
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

