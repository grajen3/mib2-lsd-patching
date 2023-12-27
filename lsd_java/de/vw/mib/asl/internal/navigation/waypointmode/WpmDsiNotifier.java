/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.waypointmode;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.waypointmode.HsmTargetWayPointMode;
import de.vw.mib.asl.internal.navigation.waypointmode.SDCardMountPoint;
import java.io.File;
import java.util.Arrays;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.DSINavigation;

public class WpmDsiNotifier
implements DSIServiceStateListener {
    private static final int[] DSI_UPDATES = new int[]{95, 45, 46, 63, 47, 11, 75, 28};
    static final int[] DSI_REQUEST_TYPES = new int[]{1068, 1069, 1070, 1071, 1072, 1073, 1178, 1179};
    private HsmTargetWayPointMode target;
    private DSINavigation dsiNavigation;
    private DSIListener dsiNavigationListener;
    private DSIProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;

    public WpmDsiNotifier(HsmTargetWayPointMode hsmTargetWayPointMode) {
        Arrays.sort(DSI_REQUEST_TYPES);
        this.target = hsmTargetWayPointMode;
        this.proxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
    }

    void startRecord(int n) {
        int n2 = n == 0 ? 0 : 1;
        this.dsiNavigation.trStartTraceRecording(n2);
    }

    void storeTour(String string) {
        this.dsiNavigation.trStoreTrace(string == null ? "" : string);
    }

    void deleteTour(NavSegmentID navSegmentID) {
        this.dsiNavigation.trDeleteTrace(navSegmentID);
    }

    void deleteAllTraces() {
        this.dsiNavigation.trDeleteAllTraces();
    }

    void renameTour(NavSegmentID navSegmentID, String string) {
        this.dsiNavigation.trRenameTrace(navSegmentID, string);
    }

    void stopRecord() {
        this.dsiNavigation.trStopTraceRecording();
    }

    void setManualWaypoint() {
        this.dsiNavigation.trCreateWaypoint();
    }

    void skipWayPoints(int n) {
        this.dsiNavigation.rgSkipNextWayPoints(n);
    }

    void importTour(ResourceLocator resourceLocator) {
        this.dsiNavigation.trImportTrails(resourceLocator.getUrl());
    }

    void exportTour(NavSegmentID navSegmentID, String string) {
        SDCardMountPoint sDCardMountPoint = this.target.getDataPool().getSdCardMountPoint0();
        SDCardMountPoint sDCardMountPoint2 = this.target.getDataPool().getSdCardMountPoint1();
        String string2 = sDCardMountPoint2.getPath();
        if (string2 == null || string2.length() <= 0) {
            string2 = sDCardMountPoint.getPath();
        }
        if (string2 != null && string2.length() > 0) {
            String string3 = new File(string2, string).getAbsolutePath();
            this.dsiNavigation.trExportTrails(new NavSegmentID[]{navSegmentID}, string3);
        } else {
            this.target.error("HSMTargetWaypointMode: WpmDsiNotifier.exportTour: Unable to resolve SD2 root path. GPX file is not exported.");
        }
    }

    @Override
    public void registered(String string, int n) {
        if (!string.equals((class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = WpmDsiNotifier.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName())) {
            return;
        }
        if (this.target.isFirstStartupDone) {
            return;
        }
        this.initDSI();
        this.target.isFirstStartupDone = true;
    }

    @Override
    public void unregistered(String string, int n) {
        if (string.equals((class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = WpmDsiNotifier.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName())) {
            this.unregisterDSINavigation();
        }
    }

    void initDSI() {
        this.dsiNavigation = (DSINavigation)this.proxy.getService(this.target, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = WpmDsiNotifier.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.dsiNavigationListener = this.proxy.getAdapterFactory().createDSIListenerMethodAdapter(this.target.getHsm(), class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = WpmDsiNotifier.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        this.proxy.addResponseListener(this.target, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = WpmDsiNotifier.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
        this.dsiNavigation.setNotification(DSI_UPDATES, this.dsiNavigationListener);
    }

    private void unregisterDSINavigation() {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("WpmDsiNotifier tries to unregister from ").append((class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = WpmDsiNotifier.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName()).append("...").log();
        }
        try {
            if (this.dsiNavigationListener != null) {
                if (this.proxy == null) {
                    this.target.trace().append("proxy was null!");
                    return;
                }
                this.proxy.removeResponseListener(this.target, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = WpmDsiNotifier.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
                this.dsiNavigationListener = null;
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
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

