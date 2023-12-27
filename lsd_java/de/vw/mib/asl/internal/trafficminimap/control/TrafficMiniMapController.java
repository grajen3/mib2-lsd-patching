/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.trafficminimap.control;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.trafficminimap.common.TrafficMiniMapInfo;
import de.vw.mib.asl.internal.trafficminimap.control.TrafficMiniMapManager;
import de.vw.mib.asl.internal.trafficminimap.states.TrafficMiniMapTarget;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.trafficminimap.transformer.TrafficMiniMapHotSpotMapCollector;
import generated.de.vw.mib.asl.internal.trafficminimap.transformer.TrafficMiniMapLastRequestedMapDataCollector;
import org.dsi.ifc.asiatrafficinfomenu.Interrupt;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformationDetails;
import org.dsi.ifc.asiatrafficinfomenu.TunerData;
import org.dsi.ifc.global.DateTime;

public class TrafficMiniMapController
extends AbstractFactoryResetParticipant {
    private final String _classname;
    private TrafficMiniMapTarget _target;
    private int _currentTrafficMessageID = -1;
    private int _currentContentID = -1;
    private IntIntOptHashMap _pendingContentIDList;
    private int _priority = 0;
    private int _mapDataRequestState = 4;
    private int _refreshDataRequestState = 4;
    private boolean _processHotSpotList = false;
    private long _alreadyRequestedHotSpot = 0L;
    private FactoryResetCallback _resetCallback;

    public TrafficMiniMapController(TrafficMiniMapTarget trafficMiniMapTarget) {
        this._classname = "TrafficMiniMapController";
        this._target = trafficMiniMapTarget;
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace("TrafficMiniMapController()");
        }
        TrafficMiniMapManager.getMessageList().initialize();
    }

    private TrafficMiniMapTarget getTarget() {
        return this._target;
    }

    private IntIntOptHashMap getPendingQueueList() {
        if (this._pendingContentIDList == null) {
            this._pendingContentIDList = new IntIntOptHashMap();
        }
        return this._pendingContentIDList;
    }

    private int getNextPossibleHighPrioElementFromQueue() {
        int n = -1;
        if (!this.getPendingQueueList().isEmpty()) {
            int n2 = 0;
            int n3 = -1;
            IntIterator intIterator = this.getPendingQueueList().keyIterator();
            while (intIterator.hasNext()) {
                int n4 = intIterator.next();
                switch (this.getPendingQueueList().get(n4)) {
                    case 5: {
                        n2 = 5;
                        break;
                    }
                    case 4: {
                        if (n2 >= 4) break;
                        n2 = 4;
                        n3 = n4;
                        break;
                    }
                    case 3: {
                        if (n2 >= 3) break;
                        n2 = 4;
                        n3 = n4;
                        break;
                    }
                    case 2: {
                        if (n2 >= 2) break;
                        n2 = 4;
                        n3 = n4;
                        break;
                    }
                    case 1: {
                        if (n2 >= 1) break;
                        n2 = 4;
                        n3 = n4;
                        break;
                    }
                }
                if (n2 != 5) continue;
                n = n4;
                break;
            }
            if (n == -1) {
                n = n3;
            }
        }
        return n;
    }

    private boolean removeListElement(int n) {
        if (!this.getPendingQueueList().isEmpty() && this.getPendingQueueList().containsKey(n)) {
            this.getPendingQueueList().remove(n);
            return true;
        }
        return false;
    }

    private void processInterruptListForResourceInformation() {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append("TrafficMiniMapController").append(".processInterruptListForResourceInformation()").log();
        }
        if (this._currentContentID == -1) {
            int n;
            Object[] objectArray = TrafficMiniMapManager.getMessageList().getHotSpotList();
            if (!Util.isNullOrEmpty(objectArray)) {
                n = objectArray.length;
                for (int i2 = 0; i2 < n; ++i2) {
                    long l = ((TrafficMiniMapHotSpotMapCollector)objectArray[i2]).trafficminimap_hot_spot_map_content_id;
                    if (this._alreadyRequestedHotSpot == l || ((TrafficMiniMapHotSpotMapCollector)objectArray[i2]).trafficminimap_hot_spot_map_graphic != null) continue;
                    this._alreadyRequestedHotSpot = l;
                    this._currentContentID = (int)l;
                    break;
                }
            }
            if (this._currentContentID != -1) {
                this._priority = 4;
                this.getTarget().getDSI().requestResourceInformation(this._currentContentID);
            } else {
                this._alreadyRequestedHotSpot = 0L;
                this._processHotSpotList = false;
                TrafficMiniMapManager.getModelController().updateHotSpotInfo(TrafficMiniMapManager.getMessageList().getHotSpot());
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace("$$$$$$$$$$$ END OF INTERRUPT UPDATE $$$$$$$$");
                }
                if ((n = this.getNextPossibleHighPrioElementFromQueue()) > -1) {
                    this._priority = this.getPendingQueueList().get(n);
                    this._currentContentID = n;
                    this.getTarget().getDSI().requestResourceInformation(this._currentContentID);
                }
            }
        } else if (TrafficMiniMapManager.getMessageList().isHotSpotValid()) {
            this.getPendingQueueList().put((int)TrafficMiniMapManager.getMessageList().getHotSpot().trafficminimap_hot_spot_map_content_id, 4);
        }
    }

    private void updateStateInfo(int n, ResourceInformation resourceInformation) {
        switch (n) {
            case 4: 
            case 5: {
                if (resourceInformation == null) break;
                TrafficMiniMapManager.getModelController().updateHotSpotResourceInformation(resourceInformation.getResourceLocator());
                TrafficMiniMapManager.getModelController().sendSystemEvent(-1847580160);
                break;
            }
            case 3: {
                int n2 = 3;
                TrafficMiniMapInfo trafficMiniMapInfo = TrafficMiniMapManager.getMessageList().getTrafficInfoFromAreaListWithContentID(this._currentContentID);
                if (resourceInformation != null && trafficMiniMapInfo != null) {
                    TrafficMiniMapManager.getPersistence().setLastRequestedMiniMap(trafficMiniMapInfo);
                    n2 = 2;
                }
                TrafficMiniMapManager.getModelController().setRefreshMapDataRequestState(n2);
                break;
            }
            case 2: {
                int n3 = 3;
                TrafficMiniMapInfo trafficMiniMapInfo = TrafficMiniMapManager.getMessageList().getTrafficInfoFromAreaListWithContentID(this._currentContentID);
                TrafficMiniMapManager.getPersistence().setLastRequestedMiniMap(trafficMiniMapInfo);
                if (resourceInformation != null && trafficMiniMapInfo != null) {
                    n3 = 2;
                }
                TrafficMiniMapManager.getModelController().setMapDataRequestState(n3);
                break;
            }
            case 1: {
                break;
            }
            case 0: {
                break;
            }
        }
    }

    private void checkLastRequestedMapValidityOnListUpdate(TrafficMiniMapInfo[] trafficMiniMapInfoArray) {
        TrafficMiniMapLastRequestedMapDataCollector trafficMiniMapLastRequestedMapDataCollector;
        int n = 0;
        if (!Util.isNullOrEmpty(trafficMiniMapInfoArray) && (trafficMiniMapLastRequestedMapDataCollector = TrafficMiniMapManager.getPersistence().getLastRequestedMiniMap()) != null) {
            int n2 = trafficMiniMapInfoArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (trafficMiniMapInfoArray[i2].getTrafficMessage() == null || trafficMiniMapLastRequestedMapDataCollector.trafficminimap_last_requested_map_content_id != (long)trafficMiniMapInfoArray[i2].getTrafficMessage().getContentID()) continue;
                n = 1;
                break;
            }
        }
        if (n == 0) {
            TrafficMiniMapManager.getPersistence().setLastRequestedMiniMap(null);
        }
        TrafficMiniMapManager.getModelController().setLastRequestedMiniMap(n);
    }

    public void startUp() {
        TrafficMiniMapManager.getModelController().updateHotSpotReceptionStatus(TrafficMiniMapManager.getPersistence().isHotSpotMiniMapSetupStatusActive());
        this.updateLists();
        int n = 0;
        TrafficMiniMapLastRequestedMapDataCollector trafficMiniMapLastRequestedMapDataCollector = TrafficMiniMapManager.getPersistence().getLastRequestedMiniMap();
        if (trafficMiniMapLastRequestedMapDataCollector != null && trafficMiniMapLastRequestedMapDataCollector.trafficminimap_last_requested_map_graphic != null) {
            n = 1;
        }
        TrafficMiniMapManager.getModelController().updateLastRequestedMiniMap(trafficMiniMapLastRequestedMapDataCollector);
        TrafficMiniMapManager.getModelController().setLastRequestedMiniMap(n);
    }

    public void reset() {
        this._currentContentID = -1;
        this._currentTrafficMessageID = -1;
        this._priority = 0;
        this._mapDataRequestState = 4;
        this._refreshDataRequestState = 4;
        this._alreadyRequestedHotSpot = 0L;
        this._processHotSpotList = false;
        this.getPendingQueueList().clear();
    }

    public void updateLists() {
        TrafficMiniMapManager.getModelController().setAreaListValid(TrafficMiniMapManager.getMessageList().isAreaListValid());
        TrafficMiniMapManager.getModelController().updateAreaList(TrafficMiniMapManager.getMessageList().getCompleteAreaList());
        TrafficMiniMapManager.getModelController().updateHotSpotInfo(TrafficMiniMapManager.getMessageList().getHotSpot());
    }

    public void handleServiceFullFactoryReset() {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append("TrafficMiniMapController").append(".handleServiceFullFactoryReset()").log();
        }
        this._currentContentID = -1;
        this._currentTrafficMessageID = -1;
        TrafficMiniMapManager.getPersistence().reset();
        this.notifyResetDone();
    }

    public void handleHotSpotMiniMapSetupStatus() {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append("TrafficMiniMapController").append(".handleMiniMapReceptionStatus()").log();
        }
        TrafficMiniMapManager.getPersistence().setHotSpotMiniMapSetupStatus(!TrafficMiniMapManager.getPersistence().isHotSpotMiniMapSetupStatusActive());
        TrafficMiniMapManager.getModelController().updateHotSpotReceptionStatus(TrafficMiniMapManager.getPersistence().isHotSpotMiniMapSetupStatusActive());
    }

    public void requestResourceInformationForMiniMap(int n) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append("TrafficMiniMapController").append(new StringBuffer().append(".requestResourceInformationForMiniMap(").append(n).append(")").toString()).log();
        }
        this._mapDataRequestState = 0;
        if (n > 0) {
            if (!this.getPendingQueueList().containsKey(n)) {
                if (this._currentContentID == -1) {
                    this._priority = 2;
                    this._currentContentID = n;
                    this.getTarget().getDSI().requestResourceInformation(this._currentContentID);
                } else {
                    this.getPendingQueueList().put(n, 2);
                }
            }
        } else {
            this._mapDataRequestState = 3;
        }
        TrafficMiniMapManager.getModelController().setMapDataRequestState(this._mapDataRequestState);
    }

    public void requestResourceInformationOnRefresh(int n) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append("TrafficMiniMapController").append(new StringBuffer().append(".requestResourceInformationOnRefresh(").append(n).append(")").toString()).log();
        }
        this._refreshDataRequestState = 0;
        if (n > 0) {
            if (!this.getPendingQueueList().containsKey(n)) {
                if (this._currentContentID == -1) {
                    this._priority = 3;
                    this._currentContentID = n;
                    this.getTarget().getDSI().requestResourceInformation(this._currentContentID);
                } else {
                    this.getPendingQueueList().put(n, 3);
                }
            }
        } else {
            this._refreshDataRequestState = 3;
        }
        TrafficMiniMapManager.getModelController().setRefreshMapDataRequestState(this._refreshDataRequestState);
    }

    public void requestTrafficInformationDetails(int n) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append("TrafficMiniMapController").append(new StringBuffer().append(".handleRequestTrafficInformationDetails(").append(n).append(")").toString()).log();
        }
        if (n > 0) {
            TrafficMiniMapInfo trafficMiniMapInfo = TrafficMiniMapManager.getMessageList().getTrafficInfoFromAreaListWithMessageID(n);
            if (trafficMiniMapInfo != null) {
                this._currentTrafficMessageID = n;
                this.getTarget().getDSI().requestTrafficInformationDetails(this._currentTrafficMessageID);
            }
        } else {
            this.getTarget().warn("Invalid message ID  for traffic information details");
        }
    }

    public void handleSettingInfo(int n, String string, boolean bl) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append("TrafficMiniMapController").append(".handleSettingInfo(").append(n).append(", ").append(Util.isNullOrEmpty(string) ? "NULL" : string).append(", ").append(bl).append(" )").log();
        }
        if (this.getTarget().getDSI() != null) {
            switch (n) {
                case 0: {
                    if (Util.isNullOrEmpty(string)) break;
                    this.getTarget().getDSI().setLanguage(string);
                    break;
                }
                case 1: {
                    if (Util.isNullOrEmpty(string)) break;
                    this.getTarget().getDSI().setPrefectureSetting(string, bl);
                    break;
                }
                case 2: {
                    this.getTarget().getDSI().setProbeDataSetting(bl);
                    break;
                }
            }
        }
    }

    public void updateActiveInterrupts(Interrupt[] interruptArray) {
        if (!Util.isNullOrEmpty(interruptArray)) {
            if (this.getTarget().isTraceEnabled()) {
                this.getTarget().trace("$$$$$$$$$$$BEGIN OF INTERRUPT OR HOT SPOT UPDATE$$$$$$$$");
            }
            TrafficMiniMapManager.getMessageList().updateActiveInterrupts(interruptArray);
            this._processHotSpotList = true;
            this.processInterruptListForResourceInformation();
        } else {
            this.getTarget().warn("Either Interrupt List is EMPTY or NULL");
        }
    }

    public void updateTrafficType(TrafficInformation[] trafficInformationArray) {
        if (!Util.isNullOrEmpty(trafficInformationArray)) {
            if (this.getTarget().isTraceEnabled()) {
                this.getTarget().trace("******START OF TRAFFIC INFO PROCESSING********");
            }
            TrafficMiniMapManager.getMessageList().updateTrafficInfoList(trafficInformationArray);
            this.updateLists();
            this.checkLastRequestedMapValidityOnListUpdate(TrafficMiniMapManager.getMessageList().getCompleteAreaList());
            if (this.getTarget().isTraceEnabled()) {
                this.getTarget().trace("******END OF TRAFFIC INFO PROCESS********");
            }
        } else {
            this.getTarget().warn("Either traffic information List is EMPTY or NULL");
        }
    }

    public void updatePrefecture(String string) {
        if (!Util.isNullOrEmpty(string)) {
            // empty if block
        }
    }

    public void updateProbeDataSetting(boolean bl) {
    }

    public void updateFrequency(int n) {
    }

    public void updateReceptionStatus(int n) {
    }

    public void updateReceptionDate(DateTime dateTime) {
        if (dateTime != null) {
            // empty if block
        }
    }

    public void updateReceivableStations(TunerData[] tunerDataArray) {
        if (!Util.isNullOrEmpty(tunerDataArray)) {
            // empty if block
        }
    }

    public void responseResourceInformation(int n, ResourceInformation resourceInformation) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append("TrafficMiniMapController").append(new StringBuffer().append(".responseResourceInformation(").append(n).append(", ").append(resourceInformation != null ? resourceInformation.toString() : "NULL").append(")").toString()).log();
        }
        if (n == this._currentContentID) {
            if (this._priority >= 4) {
                TrafficMiniMapManager.getMessageList().updateResourceInformationForActiveInterrupts(n, resourceInformation);
            } else {
                TrafficMiniMapManager.getMessageList().updateResourceInformationForAreaList(n, resourceInformation);
            }
            this.updateLists();
            this.updateStateInfo(this._priority, resourceInformation);
            this._currentContentID = -1;
            this._priority = 0;
            this.removeListElement(n);
            if (this._processHotSpotList) {
                this.processInterruptListForResourceInformation();
            } else {
                int n2 = this.getNextPossibleHighPrioElementFromQueue();
                if (n2 > -1) {
                    this._priority = this.getPendingQueueList().get(n2);
                    this._currentContentID = n2;
                    this.getTarget().getDSI().requestResourceInformation(this._currentContentID);
                }
            }
        } else {
            this.getTarget().warn("Current Content ID is not valid");
        }
    }

    public void responseTrafficInformationDetails(int n, TrafficInformationDetails[] trafficInformationDetailsArray) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append("TrafficMiniMapController").append(new StringBuffer().append(".responseTrafficInformationDetails(").append(n).append(", ").append(!Util.isNullOrEmpty(trafficInformationDetailsArray) ? trafficInformationDetailsArray.toString() : "NULL").append(")").toString()).log();
        }
        if (!Util.isNullOrEmpty(trafficInformationDetailsArray)) {
            if (this._currentTrafficMessageID == n) {
                TrafficMiniMapManager.getMessageList().updateTrafficDetailInfoList(n, trafficInformationDetailsArray);
                this._currentTrafficMessageID = -1;
                TrafficMiniMapManager.getModelController().updateAreaList(TrafficMiniMapManager.getMessageList().getCompleteAreaList());
            } else if (this._currentTrafficMessageID != -1) {
                this.getTarget().getDSI().requestTrafficInformationDetails(this._currentTrafficMessageID);
            } else {
                this.getTarget().info(new StringBuffer().append("Skipping the traffic inforamtion detail info for this traffic message ID = ").append(n).toString());
            }
        }
    }

    public void responseSetLanguage(boolean bl) {
        this.getTarget().info(new StringBuffer().append(" Set LANGUAGE = ").append(bl ? "SUCCESS" : "FAILURE").toString());
    }

    public void asyncException(int n, int n2) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append("TrafficMiniMapController").append(new StringBuffer().append(".asyncException(").append(n).append(", ").append(n2).append(")").toString()).log();
        }
        if (n == 8304) {
            switch (n2) {
                case 1000: {
                    this.responseResourceInformation(this._currentContentID, null);
                    break;
                }
                case 1001: {
                    this.responseTrafficInformationDetails(this._currentTrafficMessageID, null);
                    break;
                }
                case 1002: {
                    break;
                }
                case 1003: {
                    break;
                }
                case 1004: {
                    break;
                }
            }
        } else {
            switch (n) {
                case 8300: {
                    break;
                }
                case 8301: {
                    break;
                }
                case 8302: {
                    break;
                }
                case 8303: {
                    break;
                }
                case 8305: {
                    break;
                }
                case 10001: {
                    break;
                }
            }
        }
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        if (factoryResetCallback != null) {
            this._resetCallback = factoryResetCallback;
            this.handleServiceFullFactoryReset();
        }
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    public void notifyResetDone() {
        if (this._resetCallback != null) {
            this._resetCallback.notifyResetDone();
        }
    }
}

