/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.kombisync2;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.kombisync2.DisplayIdentification;
import org.dsi.ifc.kombisync2.DisplayRequestResponse;
import org.dsi.ifc.kombisync2.DisplayStatus;
import org.dsi.ifc.kombisync2.DisplayStatusFlags;
import org.dsi.ifc.kombisync2.MenuContext;
import org.dsi.ifc.kombisync2.MenuState;
import org.dsi.ifc.kombisync2.PopupActionRequestResponse;
import org.dsi.ifc.kombisync2.PopupRegisterRequestResponse;
import org.dsi.ifc.kombisync2.PopupStatus;
import org.dsi.ifc.kombisync2.PopupStatusFlags;

public final class DSIKombisync2Tracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_DISPLAYIDENTIFICATION;
    private static final int ID_DISPLAYREQUESTRESPONSE;
    private static final int ID_DISPLAYSTATUS;
    private static final int ID_DISPLAYSTATUSFLAGS;
    private static final int ID_MENUCONTEXT;
    private static final int ID_MENUSTATE;
    private static final int ID_POPUPACTIONREQUESTRESPONSE;
    private static final int ID_POPUPREGISTERREQUESTRESPONSE;
    private static final int ID_POPUPSTATUS;
    private static final int ID_POPUPSTATUSFLAGS;
    static /* synthetic */ Class class$org$dsi$ifc$kombisync2$DisplayIdentification;
    static /* synthetic */ Class class$org$dsi$ifc$kombisync2$DisplayRequestResponse;
    static /* synthetic */ Class class$org$dsi$ifc$kombisync2$DisplayStatus;
    static /* synthetic */ Class class$org$dsi$ifc$kombisync2$DisplayStatusFlags;
    static /* synthetic */ Class class$org$dsi$ifc$kombisync2$MenuContext;
    static /* synthetic */ Class class$org$dsi$ifc$kombisync2$MenuState;
    static /* synthetic */ Class class$org$dsi$ifc$kombisync2$PopupActionRequestResponse;
    static /* synthetic */ Class class$org$dsi$ifc$kombisync2$PopupRegisterRequestResponse;
    static /* synthetic */ Class class$org$dsi$ifc$kombisync2$PopupStatus;
    static /* synthetic */ Class class$org$dsi$ifc$kombisync2$PopupStatusFlags;

    public DSIKombisync2Tracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$kombisync2$DisplayIdentification == null ? (class$org$dsi$ifc$kombisync2$DisplayIdentification = DSIKombisync2Tracer.class$("org.dsi.ifc.kombisync2.DisplayIdentification")) : class$org$dsi$ifc$kombisync2$DisplayIdentification, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$kombisync2$DisplayRequestResponse == null ? (class$org$dsi$ifc$kombisync2$DisplayRequestResponse = DSIKombisync2Tracer.class$("org.dsi.ifc.kombisync2.DisplayRequestResponse")) : class$org$dsi$ifc$kombisync2$DisplayRequestResponse, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$kombisync2$DisplayStatus == null ? (class$org$dsi$ifc$kombisync2$DisplayStatus = DSIKombisync2Tracer.class$("org.dsi.ifc.kombisync2.DisplayStatus")) : class$org$dsi$ifc$kombisync2$DisplayStatus, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$kombisync2$DisplayStatusFlags == null ? (class$org$dsi$ifc$kombisync2$DisplayStatusFlags = DSIKombisync2Tracer.class$("org.dsi.ifc.kombisync2.DisplayStatusFlags")) : class$org$dsi$ifc$kombisync2$DisplayStatusFlags, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$kombisync2$MenuContext == null ? (class$org$dsi$ifc$kombisync2$MenuContext = DSIKombisync2Tracer.class$("org.dsi.ifc.kombisync2.MenuContext")) : class$org$dsi$ifc$kombisync2$MenuContext, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$kombisync2$MenuState == null ? (class$org$dsi$ifc$kombisync2$MenuState = DSIKombisync2Tracer.class$("org.dsi.ifc.kombisync2.MenuState")) : class$org$dsi$ifc$kombisync2$MenuState, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$kombisync2$PopupActionRequestResponse == null ? (class$org$dsi$ifc$kombisync2$PopupActionRequestResponse = DSIKombisync2Tracer.class$("org.dsi.ifc.kombisync2.PopupActionRequestResponse")) : class$org$dsi$ifc$kombisync2$PopupActionRequestResponse, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$kombisync2$PopupRegisterRequestResponse == null ? (class$org$dsi$ifc$kombisync2$PopupRegisterRequestResponse = DSIKombisync2Tracer.class$("org.dsi.ifc.kombisync2.PopupRegisterRequestResponse")) : class$org$dsi$ifc$kombisync2$PopupRegisterRequestResponse, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$kombisync2$PopupStatus == null ? (class$org$dsi$ifc$kombisync2$PopupStatus = DSIKombisync2Tracer.class$("org.dsi.ifc.kombisync2.PopupStatus")) : class$org$dsi$ifc$kombisync2$PopupStatus, 9);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$kombisync2$PopupStatusFlags == null ? (class$org$dsi$ifc$kombisync2$PopupStatusFlags = DSIKombisync2Tracer.class$("org.dsi.ifc.kombisync2.PopupStatusFlags")) : class$org$dsi$ifc$kombisync2$PopupStatusFlags, 10);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceDisplayIdentification(printWriter, (DisplayIdentification)object);
                break;
            }
            case 2: {
                this.traceDisplayRequestResponse(printWriter, (DisplayRequestResponse)object);
                break;
            }
            case 3: {
                this.traceDisplayStatus(printWriter, (DisplayStatus)object);
                break;
            }
            case 4: {
                this.traceDisplayStatusFlags(printWriter, (DisplayStatusFlags)object);
                break;
            }
            case 5: {
                this.traceMenuContext(printWriter, (MenuContext)object);
                break;
            }
            case 6: {
                this.traceMenuState(printWriter, (MenuState)object);
                break;
            }
            case 7: {
                this.tracePopupActionRequestResponse(printWriter, (PopupActionRequestResponse)object);
                break;
            }
            case 8: {
                this.tracePopupRegisterRequestResponse(printWriter, (PopupRegisterRequestResponse)object);
                break;
            }
            case 9: {
                this.tracePopupStatus(printWriter, (PopupStatus)object);
                break;
            }
            case 10: {
                this.tracePopupStatusFlags(printWriter, (PopupStatusFlags)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceDisplayIdentification(PrintWriter printWriter, DisplayIdentification displayIdentification) {
        if (displayIdentification == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(displayIdentification.day);
        printWriter.print(displayIdentification.month);
        printWriter.print(displayIdentification.year);
        printWriter.print(displayIdentification.hour);
        printWriter.print(displayIdentification.minute);
        printWriter.print(displayIdentification.seconds);
        printWriter.print(displayIdentification.versionMain);
        printWriter.print(displayIdentification.versionSub);
    }

    private void traceDisplayRequestResponse(PrintWriter printWriter, DisplayRequestResponse displayRequestResponse) {
        if (displayRequestResponse == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(displayRequestResponse.reqRespInformation);
        printWriter.print(displayRequestResponse.mainContext);
        printWriter.print(displayRequestResponse.screenFormat);
        printWriter.print(displayRequestResponse.focus);
        this.trace(printWriter, displayRequestResponse.menuContext);
        printWriter.print(displayRequestResponse.style);
        printWriter.print(displayRequestResponse.requestTID);
        printWriter.print(displayRequestResponse.responseTID);
    }

    private void traceDisplayStatus(PrintWriter printWriter, DisplayStatus displayStatus) {
        if (displayStatus == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(displayStatus.internalState);
        printWriter.print(displayStatus.mainContext);
        printWriter.print(displayStatus.screenFormat);
        printWriter.print(displayStatus.focus);
        this.trace(printWriter, displayStatus.menuContext);
        printWriter.print(displayStatus.style);
        this.trace(printWriter, displayStatus.statusFlags);
    }

    private void traceDisplayStatusFlags(PrintWriter printWriter, DisplayStatusFlags displayStatusFlags) {
        if (displayStatusFlags == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(displayStatusFlags.statusFlags);
    }

    private void traceMenuContext(PrintWriter printWriter, MenuContext menuContext) {
        if (menuContext == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(menuContext.sdsTabState);
        printWriter.print(menuContext.leftMenuState);
        printWriter.print(menuContext.rightMenuState);
        printWriter.print(menuContext.secondStatusLineState);
    }

    private void traceMenuState(PrintWriter printWriter, MenuState menuState) {
        if (menuState == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(menuState.fas);
        printWriter.print(menuState.loading);
        printWriter.print(menuState.favorite);
        printWriter.print(menuState.carViewer);
        printWriter.print(menuState.service);
        printWriter.print(menuState.auxHeater);
        printWriter.print(menuState.airCondition);
        printWriter.print(menuState.vehicleSettings);
        printWriter.print(menuState.office);
        printWriter.print(menuState.race);
        printWriter.print(menuState.systemsettings);
        printWriter.print(menuState.tone);
        printWriter.print(menuState.connect);
        printWriter.print(menuState.profile);
        printWriter.print(menuState.driveSelect);
        printWriter.print(menuState.bordbook);
        printWriter.print(menuState.connectivityManager);
        printWriter.print(menuState.etc);
        printWriter.print(menuState.smartPhone);
        printWriter.print(menuState.reserve3);
        printWriter.print(menuState.bCall);
        printWriter.print(menuState.cCall);
        printWriter.print(menuState.vics);
        printWriter.print(menuState.tpeg);
    }

    private void tracePopupActionRequestResponse(PrintWriter printWriter, PopupActionRequestResponse popupActionRequestResponse) {
        if (popupActionRequestResponse == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(popupActionRequestResponse.tid);
        printWriter.print(popupActionRequestResponse.popupState);
        printWriter.print(popupActionRequestResponse.popupID);
        printWriter.print(popupActionRequestResponse.screenFormat);
        printWriter.print(popupActionRequestResponse.focus);
        this.trace(printWriter, popupActionRequestResponse.menuContext);
    }

    private void tracePopupRegisterRequestResponse(PrintWriter printWriter, PopupRegisterRequestResponse popupRegisterRequestResponse) {
        if (popupRegisterRequestResponse == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(popupRegisterRequestResponse.tid);
        printWriter.print(popupRegisterRequestResponse.popupState);
        printWriter.print(popupRegisterRequestResponse.popupID);
        printWriter.print(popupRegisterRequestResponse.screenFormat);
        printWriter.print(popupRegisterRequestResponse.focus);
        this.trace(printWriter, popupRegisterRequestResponse.menuContext);
        printWriter.print(popupRegisterRequestResponse.popupContext);
        printWriter.print(popupRegisterRequestResponse.popupType);
        printWriter.print(popupRegisterRequestResponse.popupPriority);
        this.trace(printWriter, popupRegisterRequestResponse.popupStatusFlags);
    }

    private void tracePopupStatus(PrintWriter printWriter, PopupStatus popupStatus) {
        if (popupStatus == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(popupStatus.popupID);
        printWriter.print(popupStatus.popupID2);
        printWriter.print(popupStatus.screenFormat);
        printWriter.print(popupStatus.focus);
        this.trace(printWriter, popupStatus.menuContext);
        printWriter.print(popupStatus.popupFlapLeft);
        printWriter.print(popupStatus.popupFlapRight);
        this.trace(printWriter, popupStatus.popupStatusFlags);
    }

    private void tracePopupStatusFlags(PrintWriter printWriter, PopupStatusFlags popupStatusFlags) {
        if (popupStatusFlags == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(popupStatusFlags.statusFlags);
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

