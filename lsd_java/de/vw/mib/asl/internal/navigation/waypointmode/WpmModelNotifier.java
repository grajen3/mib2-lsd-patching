/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.waypointmode;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.properties.values.SpellerData;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.navigation.NavTraceListData;

public class WpmModelNotifier {
    void setRecordWithDestination(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(4091, bl);
    }

    void setCurrentWPMModeDefault() {
        ServiceManager.aslPropertyManager.valueChangedInteger(4080, 0);
    }

    void setCurrentWPMModeDrive() {
        ServiceManager.aslPropertyManager.valueChangedInteger(4080, 1);
    }

    void setCurrentWPMModeRecord() {
        ServiceManager.aslPropertyManager.valueChangedInteger(4080, 2);
    }

    void setNumberOfWaypointsInTour(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(4085, n);
    }

    void setNumberOfFreeWaypointsInMemory(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(4082, n);
    }

    void setNumberOfMaxWaypointsinMemory(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(4083, n);
    }

    void setIndexOfNextWaypoint(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(4084, n);
    }

    void setNumberOfWaypointsCurrentRecord(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(4086, n);
    }

    void setNumberOfTracksInMemory(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(4081, n);
    }

    void setFreeWaypointMemoryBelowThreshold(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(4117, bl);
    }

    void setSplitScreenActive(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(4173, bl);
    }

    void setSplitScreenContentDefaultMode(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(4103, n);
    }

    void setSplitScreenContentDriveRecordMode(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(4104, n);
    }

    void setDeletionStateIdle() {
        ServiceManager.aslPropertyManager.valueChangedInteger(4119, 0);
    }

    void setDeletionStateDeleting() {
        ServiceManager.aslPropertyManager.valueChangedInteger(4119, 1);
    }

    void setSelectedTrackReadyForGuidanceStart(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(4121, bl);
    }

    void setActionResultOk() {
        ServiceManager.aslPropertyManager.valueChangedInteger(4118, 0);
    }

    void setDistanceToWP(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(4134, n);
    }

    void setDirectionToWP(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(4135, n);
    }

    void setTrackList(NavTraceListData[] navTraceListDataArray) {
        ListManager.getGenericASLList(4087).updateList(navTraceListDataArray);
    }

    void setImportStateIdle() {
        ServiceManager.aslPropertyManager.valueChangedInteger(4136, 0);
    }

    void setImportStateImporting() {
        ServiceManager.aslPropertyManager.valueChangedInteger(4136, 1);
    }

    void setImportResultSuccess() {
        ServiceManager.aslPropertyManager.valueChangedInteger(4137, 0);
    }

    void setImportResultError() {
        ServiceManager.aslPropertyManager.valueChangedInteger(4137, 1);
    }

    void setImportResultMemFull() {
        ServiceManager.aslPropertyManager.valueChangedInteger(4137, 2);
    }

    void setSpellerCharEntered(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(4142, bl);
    }

    void setTourNameExists(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(4143, bl);
    }

    void setSpellerData(SpellerData spellerData) {
        ServiceManager.aslPropertyManager.valueChangedSpellerData(4141, spellerData);
    }

    void setExportResultSuccess() {
        ServiceManager.aslPropertyManager.valueChangedInteger(4158, 0);
    }

    void setExportResultError() {
        ServiceManager.aslPropertyManager.valueChangedInteger(4158, 1);
    }

    void setTrackListRenameString(String string) {
        ServiceManager.aslPropertyManager.valueChangedString(4157, string);
    }

    void setExecutionMode(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(4079, n2);
    }
}

