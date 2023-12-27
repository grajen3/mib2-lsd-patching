/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.waypointmode;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.waypointmode.SDCardMountPoint;
import de.vw.mib.asl.internal.navigation.waypointmode.WpmPersistence;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.navigation.NavNextWayPointInfo;
import org.dsi.ifc.navigation.NavTraceListData;

public class WpmDataPool {
    private int recordMode;
    private String storeTourName;
    private WpmPersistence persistence;
    private int numberOfWaypointsInTour;
    private NavNextWayPointInfo nextWpInfo;
    private NavTraceListData selectedtTour;
    private final GenericASLList trackList = ListManager.getGenericASLList(4087);
    private boolean oldBelowThreshold;
    private SDCardMountPoint sdCardMountPoint0;
    private SDCardMountPoint sdCardMountPoint1;

    public boolean isOldBelowThreshold() {
        return this.oldBelowThreshold;
    }

    public void setOldBelowThreshold(boolean bl) {
        this.oldBelowThreshold = bl;
    }

    public GenericASLList getTrackList() {
        return this.trackList;
    }

    public NavTraceListData getSelectedtTour() {
        return this.selectedtTour;
    }

    public void setSelectedtTour(NavTraceListData navTraceListData) {
        this.selectedtTour = navTraceListData;
    }

    public WpmDataPool() {
        this.persistence = WpmPersistence.getInstance();
        this.sdCardMountPoint0 = new SDCardMountPoint();
        this.sdCardMountPoint1 = new SDCardMountPoint();
    }

    void setRecordMode(int n) {
        this.recordMode = n;
    }

    public int getRecordMode() {
        return this.recordMode;
    }

    public String getStoreTourName() {
        return this.storeTourName;
    }

    public void setStoreTourName(String string) {
        this.storeTourName = string;
    }

    void setSplitScreenActive(boolean bl) {
        this.persistence.setSplitScreenActive(bl);
    }

    boolean getSplitScreenActive() {
        return this.persistence.isSplitActive();
    }

    void setSplitScreenCurrentContentDefault(int n) {
        this.persistence.setSplitScreenContentDefaultMode(n);
    }

    int getSplitScreenCurrentContentDefault() {
        return this.persistence.getSplitScreenContentDefaultMode();
    }

    void setSplitScreenCurrentContentDriveRecord(int n) {
        this.persistence.setSplitScreenContentDriveRecordMode(n);
    }

    int getSplitScreenCurrentContentDriveRecord() {
        return this.persistence.getSplitScreenContentDriveRecordMode();
    }

    public void setNumberOfWaypointsInTour(int n) {
        this.numberOfWaypointsInTour = n;
    }

    public int getNumberOfWaypointsInTour() {
        return this.numberOfWaypointsInTour;
    }

    public void setInfoForNextWP(NavNextWayPointInfo navNextWayPointInfo) {
        this.nextWpInfo = navNextWayPointInfo;
    }

    public NavNextWayPointInfo getInfoForNextWP() {
        return this.nextWpInfo;
    }

    public void setExecutionMode(int n) {
        this.persistence.setExecutionMode(n);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setWpmActive(n == 1);
    }

    public int getExecutionMode() {
        return this.persistence.getExecutionMode();
    }

    public void resetDefaults() {
        this.recordMode = 0;
        this.storeTourName = null;
        this.numberOfWaypointsInTour = 0;
        this.nextWpInfo = null;
        this.selectedtTour = null;
        this.trackList.clear();
        this.persistence.clear();
    }

    public SDCardMountPoint getSdCardMountPoint0() {
        return this.sdCardMountPoint0;
    }

    public SDCardMountPoint getSdCardMountPoint1() {
        return this.sdCardMountPoint1;
    }
}

