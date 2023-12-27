/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.trafficminimap.persistence;

import de.vw.mib.asl.framework.api.persistence.AbstractSharedPersistable;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceUtil;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.trafficminimap.common.TrafficMiniMapConstants;
import de.vw.mib.asl.internal.trafficminimap.common.TrafficMiniMapInfo;
import de.vw.mib.log4mib.LogMessage;
import generated.de.vw.mib.asl.internal.trafficminimap.transformer.TrafficMiniMapLastRequestedMapDataCollector;

public class TrafficMiniMapPersistence
extends AbstractSharedPersistable {
    private static final short VERSION;
    private final String _classname;
    private boolean _hotSpotSetupActive = true;
    private TrafficMiniMapLastRequestedMapDataCollector _lastRequestedMiniMap;

    public TrafficMiniMapPersistence() {
        super(5027, 0);
        this._classname = "OnlineCoreServicesPersistence";
    }

    public void reset() {
        this.clear();
        this.markDirty(true);
    }

    public void setHotSpotMiniMapSetupStatus(boolean bl) {
        this._hotSpotSetupActive = bl;
        this.markDirty(true);
    }

    public boolean isHotSpotMiniMapSetupStatusActive() {
        return this._hotSpotSetupActive;
    }

    public TrafficMiniMapLastRequestedMapDataCollector getLastRequestedMiniMap() {
        return this._lastRequestedMiniMap;
    }

    public void setLastRequestedMiniMap(TrafficMiniMapInfo trafficMiniMapInfo) {
        this._lastRequestedMiniMap = new TrafficMiniMapLastRequestedMapDataCollector();
        if (trafficMiniMapInfo != null) {
            this._lastRequestedMiniMap.trafficminimap_last_requested_map_content_id = trafficMiniMapInfo.getResourceInformation() != null ? (long)trafficMiniMapInfo.getTrafficMessage().getContentID() : 0L;
            this._lastRequestedMiniMap.trafficminimap_last_requested_map_name = trafficMiniMapInfo.getResourceInformation() != null ? trafficMiniMapInfo.getTrafficMessage().getValue() : "";
            this._lastRequestedMiniMap.trafficminimap_last_requested_map_graphic = trafficMiniMapInfo.getResourceInformation() != null ? trafficMiniMapInfo.getResourceInformation().getResourceLocator() : TrafficMiniMapConstants.EMPTY_RESOURCE_LOCATOR;
        }
        this.markDirty(true);
    }

    @Override
    public void clearUnknownValues(short s) {
    }

    @Override
    public void fromStreamInternal(PersistenceInputStream persistenceInputStream, short s) {
        if (ServiceManager.logger2.isTraceEnabled(128)) {
            LogMessage logMessage = ServiceManager.logger2.trace(128);
            logMessage.append("OnlineCoreServicesPersistence").append(".fromStreamInternal()").log();
        }
        this.clear();
        this._hotSpotSetupActive = persistenceInputStream.readBoolean();
        this._lastRequestedMiniMap.trafficminimap_last_requested_map_content_id = persistenceInputStream.readLong();
        this._lastRequestedMiniMap.trafficminimap_last_requested_map_name = persistenceInputStream.readString();
        this._lastRequestedMiniMap.trafficminimap_last_requested_map_graphic = PersistenceUtil.readResourceLocator(persistenceInputStream);
    }

    @Override
    public short[] getSupportedVersions() {
        return NO_SUPPORTED_VERSION;
    }

    @Override
    public short getVersion() {
        return 3;
    }

    @Override
    public void toStreamInternal(PersistenceOutputStream persistenceOutputStream) {
        if (ServiceManager.logger2.isTraceEnabled(128)) {
            LogMessage logMessage = ServiceManager.logger2.trace(128);
            logMessage.append("OnlineCoreServicesPersistence").append(".toStreamInternal()").log();
        }
        persistenceOutputStream.writeBoolean(this._hotSpotSetupActive);
        if (this._lastRequestedMiniMap == null) {
            this._lastRequestedMiniMap = new TrafficMiniMapLastRequestedMapDataCollector();
        }
        persistenceOutputStream.writeLong(this._lastRequestedMiniMap.trafficminimap_last_requested_map_content_id);
        persistenceOutputStream.writeString(this._lastRequestedMiniMap.trafficminimap_last_requested_map_name);
        PersistenceUtil.writeResourceLocator(this._lastRequestedMiniMap.trafficminimap_last_requested_map_graphic, persistenceOutputStream);
    }

    @Override
    public void clear() {
        this._hotSpotSetupActive = true;
        this._lastRequestedMiniMap = new TrafficMiniMapLastRequestedMapDataCollector();
    }
}

