/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.kombisync;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.kombisync.KombiDisplayRequest;
import org.dsi.ifc.kombisync.KombiDisplayStatus;
import org.dsi.ifc.kombisync.KombiPopupStatus;
import org.dsi.ifc.kombisync.MMIDisplayRequest;
import org.dsi.ifc.kombisync.MMIDisplayStatus;
import org.dsi.ifc.kombisync.MMIPopupRequest;
import org.dsi.ifc.kombisync.MenuContext;
import org.dsi.ifc.kombisync.MenuState;

public final class DSIKombiSyncTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_KOMBIDISPLAYREQUEST;
    private static final int ID_KOMBIDISPLAYSTATUS;
    private static final int ID_KOMBIPOPUPSTATUS;
    private static final int ID_MMIDISPLAYREQUEST;
    private static final int ID_MMIDISPLAYSTATUS;
    private static final int ID_MMIPOPUPREQUEST;
    private static final int ID_MENUCONTEXT;
    private static final int ID_MENUSTATE;
    static /* synthetic */ Class class$org$dsi$ifc$kombisync$KombiDisplayRequest;
    static /* synthetic */ Class class$org$dsi$ifc$kombisync$KombiDisplayStatus;
    static /* synthetic */ Class class$org$dsi$ifc$kombisync$KombiPopupStatus;
    static /* synthetic */ Class class$org$dsi$ifc$kombisync$MMIDisplayRequest;
    static /* synthetic */ Class class$org$dsi$ifc$kombisync$MMIDisplayStatus;
    static /* synthetic */ Class class$org$dsi$ifc$kombisync$MMIPopupRequest;
    static /* synthetic */ Class class$org$dsi$ifc$kombisync$MenuContext;
    static /* synthetic */ Class class$org$dsi$ifc$kombisync$MenuState;

    public DSIKombiSyncTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$kombisync$KombiDisplayRequest == null ? (class$org$dsi$ifc$kombisync$KombiDisplayRequest = DSIKombiSyncTracer.class$("org.dsi.ifc.kombisync.KombiDisplayRequest")) : class$org$dsi$ifc$kombisync$KombiDisplayRequest, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$kombisync$KombiDisplayStatus == null ? (class$org$dsi$ifc$kombisync$KombiDisplayStatus = DSIKombiSyncTracer.class$("org.dsi.ifc.kombisync.KombiDisplayStatus")) : class$org$dsi$ifc$kombisync$KombiDisplayStatus, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$kombisync$KombiPopupStatus == null ? (class$org$dsi$ifc$kombisync$KombiPopupStatus = DSIKombiSyncTracer.class$("org.dsi.ifc.kombisync.KombiPopupStatus")) : class$org$dsi$ifc$kombisync$KombiPopupStatus, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$kombisync$MMIDisplayRequest == null ? (class$org$dsi$ifc$kombisync$MMIDisplayRequest = DSIKombiSyncTracer.class$("org.dsi.ifc.kombisync.MMIDisplayRequest")) : class$org$dsi$ifc$kombisync$MMIDisplayRequest, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$kombisync$MMIDisplayStatus == null ? (class$org$dsi$ifc$kombisync$MMIDisplayStatus = DSIKombiSyncTracer.class$("org.dsi.ifc.kombisync.MMIDisplayStatus")) : class$org$dsi$ifc$kombisync$MMIDisplayStatus, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$kombisync$MMIPopupRequest == null ? (class$org$dsi$ifc$kombisync$MMIPopupRequest = DSIKombiSyncTracer.class$("org.dsi.ifc.kombisync.MMIPopupRequest")) : class$org$dsi$ifc$kombisync$MMIPopupRequest, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$kombisync$MenuContext == null ? (class$org$dsi$ifc$kombisync$MenuContext = DSIKombiSyncTracer.class$("org.dsi.ifc.kombisync.MenuContext")) : class$org$dsi$ifc$kombisync$MenuContext, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$kombisync$MenuState == null ? (class$org$dsi$ifc$kombisync$MenuState = DSIKombiSyncTracer.class$("org.dsi.ifc.kombisync.MenuState")) : class$org$dsi$ifc$kombisync$MenuState, 8);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceKombiDisplayRequest(printWriter, (KombiDisplayRequest)object);
                break;
            }
            case 2: {
                this.traceKombiDisplayStatus(printWriter, (KombiDisplayStatus)object);
                break;
            }
            case 3: {
                this.traceKombiPopupStatus(printWriter, (KombiPopupStatus)object);
                break;
            }
            case 4: {
                this.traceMMIDisplayRequest(printWriter, (MMIDisplayRequest)object);
                break;
            }
            case 5: {
                this.traceMMIDisplayStatus(printWriter, (MMIDisplayStatus)object);
                break;
            }
            case 6: {
                this.traceMMIPopupRequest(printWriter, (MMIPopupRequest)object);
                break;
            }
            case 7: {
                this.traceMenuContext(printWriter, (MenuContext)object);
                break;
            }
            case 8: {
                this.traceMenuState(printWriter, (MenuState)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceKombiDisplayRequest(PrintWriter printWriter, KombiDisplayRequest kombiDisplayRequest) {
        if (kombiDisplayRequest == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(kombiDisplayRequest.tid);
        printWriter.print(kombiDisplayRequest.focus);
        printWriter.print(kombiDisplayRequest.screenFormat);
        printWriter.print(kombiDisplayRequest.mainContext);
        this.trace(printWriter, kombiDisplayRequest.menuContext);
        printWriter.print(kombiDisplayRequest.popupContext);
        printWriter.print(kombiDisplayRequest.animationScreenType);
        printWriter.print(kombiDisplayRequest.animationScreenSubType);
        printWriter.print(kombiDisplayRequest.animationLeadTime);
        printWriter.print(kombiDisplayRequest.animationAddInfo);
        printWriter.print(kombiDisplayRequest.lastmoderequest);
        printWriter.print(kombiDisplayRequest.lvdslock);
    }

    private void traceKombiDisplayStatus(PrintWriter printWriter, KombiDisplayStatus kombiDisplayStatus) {
        if (kombiDisplayStatus == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(kombiDisplayStatus.tid);
        printWriter.print(kombiDisplayStatus.focus);
        printWriter.print(kombiDisplayStatus.screenFormat);
        printWriter.print(kombiDisplayStatus.mainContext);
        this.trace(printWriter, kombiDisplayStatus.menuContext);
        printWriter.print(kombiDisplayStatus.popupContext);
        printWriter.print(kombiDisplayStatus.animationScreenType);
        printWriter.print(kombiDisplayStatus.animationScreenSubType);
        printWriter.print(kombiDisplayStatus.animationLeadTime);
        printWriter.print(kombiDisplayStatus.animationAddInfo);
        printWriter.print(kombiDisplayStatus.animationSpeed);
    }

    private void traceKombiPopupStatus(PrintWriter printWriter, KombiPopupStatus kombiPopupStatus) {
        if (kombiPopupStatus == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(kombiPopupStatus.tid);
        printWriter.print(kombiPopupStatus.mmiPopupID);
        printWriter.print(kombiPopupStatus.mmiPopupState);
        printWriter.print(kombiPopupStatus.zpmPrioritySlotID);
        printWriter.print(kombiPopupStatus.mmiPopupPriority);
        printWriter.print(kombiPopupStatus.screenFormat);
        printWriter.print(kombiPopupStatus.focus);
    }

    private void traceMMIDisplayRequest(PrintWriter printWriter, MMIDisplayRequest mMIDisplayRequest) {
        if (mMIDisplayRequest == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(mMIDisplayRequest.tid);
        printWriter.print(mMIDisplayRequest.focus);
        printWriter.print(mMIDisplayRequest.screenFormat);
        printWriter.print(mMIDisplayRequest.mainContext);
        this.trace(printWriter, mMIDisplayRequest.menuContext);
        printWriter.print(mMIDisplayRequest.popupContext);
        printWriter.print(mMIDisplayRequest.quitInfo);
    }

    private void traceMMIDisplayStatus(PrintWriter printWriter, MMIDisplayStatus mMIDisplayStatus) {
        if (mMIDisplayStatus == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(mMIDisplayStatus.tid);
        printWriter.print(mMIDisplayStatus.focus);
        printWriter.print(mMIDisplayStatus.screenFormat);
        printWriter.print(mMIDisplayStatus.mainContext);
        this.trace(printWriter, mMIDisplayStatus.menuContext);
        printWriter.print(mMIDisplayStatus.popupContext);
        printWriter.print(mMIDisplayStatus.animationSpeed);
        printWriter.print(mMIDisplayStatus.animationInfo);
        printWriter.print(mMIDisplayStatus.kdkOpacity);
        printWriter.print(mMIDisplayStatus.kdkVisible);
        printWriter.print(mMIDisplayStatus.bargraphVisible);
        printWriter.print(mMIDisplayStatus.kdkPositionInfo);
    }

    private void traceMMIPopupRequest(PrintWriter printWriter, MMIPopupRequest mMIPopupRequest) {
        if (mMIPopupRequest == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(mMIPopupRequest.tid);
        printWriter.print(mMIPopupRequest.mmiPopupID);
        printWriter.print(mMIPopupRequest.mmiPriority);
        printWriter.print(mMIPopupRequest.zpmPrioritySlotID);
        printWriter.print(mMIPopupRequest.show);
        printWriter.print(mMIPopupRequest.screenFormat);
        printWriter.print(mMIPopupRequest.focus);
    }

    private void traceMenuContext(PrintWriter printWriter, MenuContext menuContext) {
        if (menuContext == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(menuContext.leftSideMenuOpen);
        printWriter.print(menuContext.rightSideMenuOpen);
        printWriter.print(menuContext.partialPopupOpen);
        printWriter.print(menuContext.secondStatusLine);
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
        printWriter.print(menuState.reserve2);
        printWriter.print(menuState.reserve3);
        printWriter.print(menuState.bCall);
        printWriter.print(menuState.cCall);
        printWriter.print(menuState.vics);
        printWriter.print(menuState.tpeg);
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

