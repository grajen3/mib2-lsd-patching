/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.trafficminimap.model;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.trafficminimap.common.TrafficMiniMapInfo;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.trafficminimap.transformer.TrafficMiniMapHotSpotMapCollector;
import generated.de.vw.mib.asl.internal.trafficminimap.transformer.TrafficMiniMapLastRequestedMapDataCollector;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformationDetails;
import org.dsi.ifc.global.ResourceLocator;

public class TrafficMiniMapModelController {
    public void setPropertyBoolean(int n, boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(n, bl);
    }

    public void setPropertyInteger(int n, int n2) {
        ServiceManager.aslPropertyManager.valueChangedInteger(n, n2);
    }

    public void setPropertyLong(int n, long l) {
        ServiceManager.aslPropertyManager.valueChangedLong(n, l);
    }

    public void setPropertyString(int n, String string) {
        ServiceManager.aslPropertyManager.valueChangedString(n, string);
    }

    public void setPropertyResourceLocator(int n, ResourceLocator resourceLocator) {
        ServiceManager.aslPropertyManager.valueChangedResourceLocator(n, resourceLocator);
    }

    public void sendSystemEvent(int n) {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(n);
    }

    public void updateHotSpotInfo(TrafficMiniMapHotSpotMapCollector trafficMiniMapHotSpotMapCollector) {
        if (trafficMiniMapHotSpotMapCollector != null) {
            TrafficMiniMapHotSpotMapCollector trafficMiniMapHotSpotMapCollector2 = new TrafficMiniMapHotSpotMapCollector();
            trafficMiniMapHotSpotMapCollector2.trafficminimap_hot_spot_map_content_id = trafficMiniMapHotSpotMapCollector.trafficminimap_hot_spot_map_content_id;
            trafficMiniMapHotSpotMapCollector2.trafficminimap_hot_spot_map_validity = trafficMiniMapHotSpotMapCollector.trafficminimap_hot_spot_map_validity;
            trafficMiniMapHotSpotMapCollector2.trafficminimap_hot_spot_map_name = trafficMiniMapHotSpotMapCollector.trafficminimap_hot_spot_map_name;
            trafficMiniMapHotSpotMapCollector2.trafficminimap_hot_spot_map_graphic = trafficMiniMapHotSpotMapCollector.trafficminimap_hot_spot_map_graphic;
            TrafficMiniMapHotSpotMapCollector[] trafficMiniMapHotSpotMapCollectorArray = new TrafficMiniMapHotSpotMapCollector[]{trafficMiniMapHotSpotMapCollector2};
            this.updateSpotList(trafficMiniMapHotSpotMapCollectorArray);
        } else {
            ServiceManager.logger2.warn(128).append("TRAFIC MINI MAP SPOT INFO INVALID").log();
        }
    }

    public void updateAreaListElementResourceInformation(ResourceLocator resourceLocator) {
        ResourceLocator resourceLocator2 = resourceLocator;
        if (resourceLocator2 == null) {
            resourceLocator2 = new ResourceLocator();
        }
    }

    public void setAreaListElementContentID(int n) {
    }

    public void updateAreaList(TrafficMiniMapInfo[] trafficMiniMapInfoArray) {
        ListManager.getGenericASLList(-1847580160).updateList(trafficMiniMapInfoArray != null ? trafficMiniMapInfoArray : new TrafficMiniMapInfo[]{});
    }

    public GenericASLList getAreaList() {
        return ListManager.getGenericASLList(-1847580160);
    }

    public void setSpotListElementContentID(int n) {
    }

    public void updateSpotList(TrafficMiniMapHotSpotMapCollector[] trafficMiniMapHotSpotMapCollectorArray) {
        ListManager.getGenericASLList(-1830802944).updateList(trafficMiniMapHotSpotMapCollectorArray);
    }

    public GenericASLList getSpotList() {
        return ListManager.getGenericASLList(-1830802944);
    }

    public void updateLastRequestedMiniMapList(TrafficMiniMapLastRequestedMapDataCollector[] trafficMiniMapLastRequestedMapDataCollectorArray) {
        ListManager.getGenericASLList(-1763694080).updateList(trafficMiniMapLastRequestedMapDataCollectorArray);
    }

    public GenericASLList getLastRequestedMiniMapList() {
        return ListManager.getGenericASLList(-1763694080);
    }

    public void updateLastRequestedMiniMap(TrafficMiniMapLastRequestedMapDataCollector trafficMiniMapLastRequestedMapDataCollector) {
        if (trafficMiniMapLastRequestedMapDataCollector != null) {
            TrafficMiniMapLastRequestedMapDataCollector trafficMiniMapLastRequestedMapDataCollector2 = new TrafficMiniMapLastRequestedMapDataCollector();
            trafficMiniMapLastRequestedMapDataCollector2.trafficminimap_last_requested_map_content_id = trafficMiniMapLastRequestedMapDataCollector.trafficminimap_last_requested_map_content_id;
            trafficMiniMapLastRequestedMapDataCollector2.trafficminimap_last_requested_map_name = trafficMiniMapLastRequestedMapDataCollector.trafficminimap_last_requested_map_name;
            trafficMiniMapLastRequestedMapDataCollector2.trafficminimap_last_requested_map_graphic = trafficMiniMapLastRequestedMapDataCollector.trafficminimap_last_requested_map_graphic;
            TrafficMiniMapLastRequestedMapDataCollector[] trafficMiniMapLastRequestedMapDataCollectorArray = new TrafficMiniMapLastRequestedMapDataCollector[]{trafficMiniMapLastRequestedMapDataCollector2};
            this.updateLastRequestedMiniMapList(trafficMiniMapLastRequestedMapDataCollectorArray);
        } else {
            ServiceManager.logger2.warn(128).append("LAST REQUESTED TRAFFIC MINI MAP INFO INVALID").log();
        }
    }

    public void updateTrafficDetailList(TrafficInformationDetails[] trafficInformationDetailsArray) {
    }

    public void updateHotSpotResourceInformation(ResourceLocator resourceLocator) {
        ResourceLocator resourceLocator2 = null;
        if (resourceLocator != null) {
            resourceLocator2 = resourceLocator;
        } else if (resourceLocator2 == null) {
            resourceLocator2 = new ResourceLocator();
        }
    }

    public void updateHotSpotReceptionStatus(boolean bl) {
        this.setPropertyBoolean(-1814025728, bl);
    }

    public void setMapDataRequestState(int n) {
        this.setPropertyInteger(-1746916864, n);
    }

    public void setLastRequestedMiniMap(int n) {
        this.setPropertyInteger(-1797248512, n);
    }

    public void setRefreshMapDataRequestState(int n) {
        this.setPropertyInteger(-1730139648, n);
    }

    public void setAreaListValid(boolean bl) {
        this.setPropertyBoolean(-1696585216, bl);
    }
}

