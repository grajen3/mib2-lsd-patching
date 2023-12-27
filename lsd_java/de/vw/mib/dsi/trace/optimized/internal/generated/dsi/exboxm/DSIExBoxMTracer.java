/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.exboxm;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.exboxm.AudioRequest;
import org.dsi.ifc.exboxm.ConnectionControl;
import org.dsi.ifc.exboxm.ExBoxState;
import org.dsi.ifc.exboxm.MobileDeviceLinkStatus;
import org.dsi.ifc.exboxm.PublicDeviceAddress;

public final class DSIExBoxMTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_AUDIOREQUEST;
    private static final int ID_CONNECTIONCONTROL;
    private static final int ID_EXBOXSTATE;
    private static final int ID_MOBILEDEVICELINKSTATUS;
    private static final int ID_PUBLICDEVICEADDRESS;
    static /* synthetic */ Class class$org$dsi$ifc$exboxm$AudioRequest;
    static /* synthetic */ Class class$org$dsi$ifc$exboxm$ConnectionControl;
    static /* synthetic */ Class class$org$dsi$ifc$exboxm$ExBoxState;
    static /* synthetic */ Class class$org$dsi$ifc$exboxm$MobileDeviceLinkStatus;
    static /* synthetic */ Class class$org$dsi$ifc$exboxm$PublicDeviceAddress;

    public DSIExBoxMTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$exboxm$AudioRequest == null ? (class$org$dsi$ifc$exboxm$AudioRequest = DSIExBoxMTracer.class$("org.dsi.ifc.exboxm.AudioRequest")) : class$org$dsi$ifc$exboxm$AudioRequest, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$exboxm$ConnectionControl == null ? (class$org$dsi$ifc$exboxm$ConnectionControl = DSIExBoxMTracer.class$("org.dsi.ifc.exboxm.ConnectionControl")) : class$org$dsi$ifc$exboxm$ConnectionControl, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$exboxm$ExBoxState == null ? (class$org$dsi$ifc$exboxm$ExBoxState = DSIExBoxMTracer.class$("org.dsi.ifc.exboxm.ExBoxState")) : class$org$dsi$ifc$exboxm$ExBoxState, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$exboxm$MobileDeviceLinkStatus == null ? (class$org$dsi$ifc$exboxm$MobileDeviceLinkStatus = DSIExBoxMTracer.class$("org.dsi.ifc.exboxm.MobileDeviceLinkStatus")) : class$org$dsi$ifc$exboxm$MobileDeviceLinkStatus, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$exboxm$PublicDeviceAddress == null ? (class$org$dsi$ifc$exboxm$PublicDeviceAddress = DSIExBoxMTracer.class$("org.dsi.ifc.exboxm.PublicDeviceAddress")) : class$org$dsi$ifc$exboxm$PublicDeviceAddress, 5);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceAudioRequest(printWriter, (AudioRequest)object);
                break;
            }
            case 2: {
                this.traceConnectionControl(printWriter, (ConnectionControl)object);
                break;
            }
            case 3: {
                this.traceExBoxState(printWriter, (ExBoxState)object);
                break;
            }
            case 4: {
                this.traceMobileDeviceLinkStatus(printWriter, (MobileDeviceLinkStatus)object);
                break;
            }
            case 5: {
                this.tracePublicDeviceAddress(printWriter, (PublicDeviceAddress)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceAudioRequest(PrintWriter printWriter, AudioRequest audioRequest) {
        if (audioRequest == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(audioRequest.auxAudioSource);
        printWriter.print(audioRequest.vdaAudioSource);
    }

    private void traceConnectionControl(PrintWriter printWriter, ConnectionControl connectionControl) {
        if (connectionControl == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(connectionControl.connectionRequestType);
        printWriter.print(connectionControl.connectionRequestResult);
        printWriter.print(connectionControl.pIN);
    }

    private void traceExBoxState(PrintWriter printWriter, ExBoxState exBoxState) {
        if (exBoxState == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(exBoxState.exBoxNavigationActive);
        printWriter.print(exBoxState.exBoxPhoneCallActive);
        printWriter.print(exBoxState.exBoxSpeechActive);
    }

    private void traceMobileDeviceLinkStatus(PrintWriter printWriter, MobileDeviceLinkStatus mobileDeviceLinkStatus) {
        if (mobileDeviceLinkStatus == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(mobileDeviceLinkStatus.linkType);
        printWriter.print(mobileDeviceLinkStatus.navigationActive);
        printWriter.print(mobileDeviceLinkStatus.telephoneActive);
    }

    private void tracePublicDeviceAddress(PrintWriter printWriter, PublicDeviceAddress publicDeviceAddress) {
        if (publicDeviceAddress == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(publicDeviceAddress.publicDeviceAddress);
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

