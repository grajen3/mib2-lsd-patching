/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer;

import de.vw.mib.asl.internal.navigation.map.dsi.datapool.MapDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.getinfoforscreenposition.DSIMapViewerGetInfoForScreenPositionTargetHSM;
import edu.emory.mathcs.backport.java.util.LinkedList;
import java.util.List;

public class DSIMapViewerManagerDataPool {
    private boolean createMapViewerKombiEnabled;
    private boolean createMapViewerMainEnabled;
    private boolean createMapViewerSplitScreenEnabled;
    private final MapDataPool datapoolKombiMap;
    private final MapDataPool datapoolMainMap;
    private final MapDataPool datapoolSplitScreenMap;
    private boolean googleEarthMainMapAvailable;
    private boolean googleEarthRegistered;
    private List mapTargetsKombi;
    private List mapTargetsMain;
    private List mapTargetsSplitscreen;
    private boolean mapViewerInstance0Available;
    private DSIMapViewerGetInfoForScreenPositionTargetHSM mapViewerInstance0GetInfoForScreenPositionTargetHSM;
    private boolean mapViewerInstance1Available;
    private DSIMapViewerGetInfoForScreenPositionTargetHSM mapViewerInstance1GetInfoForScreenPositionTargetHSM;
    private boolean mapViewerInstance2Available;
    private DSIMapViewerGetInfoForScreenPositionTargetHSM mapViewerInstance2GetInfoForScreenPositionTargetHSM;
    private boolean mapViewerInstance3Available;
    private DSIMapViewerGetInfoForScreenPositionTargetHSM mapViewerInstance3GetInfoForScreenPositionTargetHSM;

    public DSIMapViewerManagerDataPool() {
        this.setMapTargetsMain(new LinkedList());
        this.setMapTargetsSplitscreen(new LinkedList());
        this.setMapTargetsKombi(new LinkedList());
        this.setCreateMapViewerMainEnabled(true);
        this.setCreateMapViewerKombiEnabled(true);
        this.datapoolMainMap = new MapDataPool(0);
        this.datapoolSplitScreenMap = new MapDataPool(2);
        this.datapoolKombiMap = new MapDataPool(3);
    }

    public MapDataPool getDatapoolKombiMap() {
        return this.datapoolKombiMap;
    }

    public MapDataPool getDatapoolMainMap() {
        return this.datapoolMainMap;
    }

    public MapDataPool getDatapoolSplitScreenMap() {
        return this.datapoolSplitScreenMap;
    }

    public List getMapTargetsKombi() {
        return this.mapTargetsKombi;
    }

    public List getMapTargetsMain() {
        return this.mapTargetsMain;
    }

    public List getMapTargetsSplitscreen() {
        return this.mapTargetsSplitscreen;
    }

    public DSIMapViewerGetInfoForScreenPositionTargetHSM getMapViewerInstance0GetInfoForScreenPositionTargetHSM() {
        return this.mapViewerInstance0GetInfoForScreenPositionTargetHSM;
    }

    public DSIMapViewerGetInfoForScreenPositionTargetHSM getMapViewerInstance1GetInfoForScreenPositionTargetHSM() {
        return this.mapViewerInstance1GetInfoForScreenPositionTargetHSM;
    }

    public DSIMapViewerGetInfoForScreenPositionTargetHSM getMapViewerInstance2GetInfoForScreenPositionTargetHSM() {
        return this.mapViewerInstance2GetInfoForScreenPositionTargetHSM;
    }

    public DSIMapViewerGetInfoForScreenPositionTargetHSM getMapViewerInstance3GetInfoForScreenPositionTargetHSM() {
        return this.mapViewerInstance3GetInfoForScreenPositionTargetHSM;
    }

    public boolean isCreateMapViewerKombiEnabled() {
        return this.createMapViewerKombiEnabled;
    }

    public boolean isCreateMapViewerMainEnabled() {
        return this.createMapViewerMainEnabled;
    }

    public boolean isCreateMapViewerSplitScreenEnabled() {
        return this.createMapViewerSplitScreenEnabled;
    }

    public boolean isGoogleEarthMainMapAvailable() {
        return this.googleEarthMainMapAvailable;
    }

    public boolean isGoogleEarthRegistered() {
        return this.googleEarthRegistered;
    }

    public boolean isMapViewerInstanceAvailable(int n) {
        switch (n) {
            case 0: {
                return this.isMapViewerInstance0Available();
            }
            case 1: {
                return this.isMapViewerInstance1Available();
            }
            case 2: {
                return this.isMapViewerInstance2Available();
            }
            case 3: {
                return this.isMapViewerInstance3Available();
            }
        }
        return false;
    }

    public boolean isMapViewerInstance0Available() {
        return this.mapViewerInstance0Available;
    }

    public boolean isMapViewerInstance1Available() {
        return this.mapViewerInstance1Available;
    }

    public boolean isMapViewerInstance2Available() {
        return this.mapViewerInstance2Available;
    }

    public boolean isMapViewerInstance3Available() {
        return this.mapViewerInstance3Available;
    }

    public void setCreateMapViewerKombiEnabled(boolean bl) {
        this.createMapViewerKombiEnabled = bl;
    }

    public void setCreateMapViewerMainEnabled(boolean bl) {
        this.createMapViewerMainEnabled = bl;
    }

    public void setCreateMapViewerSplitScreenEnabled(boolean bl) {
        this.createMapViewerSplitScreenEnabled = bl;
    }

    public void setGoogleEarthMainMapAvailable(boolean bl) {
        this.googleEarthMainMapAvailable = bl;
    }

    public void setGoogleEarthRegistered(boolean bl) {
        this.googleEarthRegistered = bl;
    }

    public void setMapTargetsKombi(List list) {
        this.mapTargetsKombi = list;
    }

    public void setMapTargetsMain(List list) {
        this.mapTargetsMain = list;
    }

    public void setMapTargetsSplitscreen(List list) {
        this.mapTargetsSplitscreen = list;
    }

    public void setMapViewerInstance0Available(boolean bl) {
        this.mapViewerInstance0Available = bl;
    }

    public void setMapViewerInstance0GetInfoForScreenPositionTargetHSM(DSIMapViewerGetInfoForScreenPositionTargetHSM dSIMapViewerGetInfoForScreenPositionTargetHSM) {
        this.mapViewerInstance0GetInfoForScreenPositionTargetHSM = dSIMapViewerGetInfoForScreenPositionTargetHSM;
    }

    public void setMapViewerInstance1Available(boolean bl) {
        this.mapViewerInstance1Available = bl;
    }

    public void setMapViewerInstance1GetInfoForScreenPositionTargetHSM(DSIMapViewerGetInfoForScreenPositionTargetHSM dSIMapViewerGetInfoForScreenPositionTargetHSM) {
        this.mapViewerInstance1GetInfoForScreenPositionTargetHSM = dSIMapViewerGetInfoForScreenPositionTargetHSM;
    }

    public void setMapViewerInstance2Available(boolean bl) {
        this.mapViewerInstance2Available = bl;
    }

    public void setMapViewerInstance2GetInfoForScreenPositionTargetHSM(DSIMapViewerGetInfoForScreenPositionTargetHSM dSIMapViewerGetInfoForScreenPositionTargetHSM) {
        this.mapViewerInstance2GetInfoForScreenPositionTargetHSM = dSIMapViewerGetInfoForScreenPositionTargetHSM;
    }

    public void setMapViewerInstance3Available(boolean bl) {
        this.mapViewerInstance3Available = bl;
    }

    public void setMapViewerInstance3GetInfoForScreenPositionTargetHSM(DSIMapViewerGetInfoForScreenPositionTargetHSM dSIMapViewerGetInfoForScreenPositionTargetHSM) {
        this.mapViewerInstance3GetInfoForScreenPositionTargetHSM = dSIMapViewerGetInfoForScreenPositionTargetHSM;
    }
}

