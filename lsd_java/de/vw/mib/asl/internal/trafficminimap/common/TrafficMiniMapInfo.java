/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.trafficminimap.common;

import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformationDetails;
import org.dsi.ifc.asiatrafficinfomenu.TrafficMessage;

public class TrafficMiniMapInfo {
    private TrafficMessage _trafficMessage;
    private TrafficInformationDetails[] _trafficDetailInfoList;
    private ResourceInformation _resourceInfo;

    public TrafficMiniMapInfo() {
    }

    public TrafficMiniMapInfo(TrafficMessage trafficMessage) {
        this._trafficMessage = trafficMessage;
    }

    public TrafficMiniMapInfo(TrafficMiniMapInfo trafficMiniMapInfo) {
        this._resourceInfo = trafficMiniMapInfo._resourceInfo;
        this._trafficDetailInfoList = trafficMiniMapInfo._trafficDetailInfoList;
        this._trafficMessage = trafficMiniMapInfo._trafficMessage;
    }

    public TrafficMessage getTrafficMessage() {
        return this._trafficMessage;
    }

    public void setTrafficMessage(TrafficMessage trafficMessage) {
        this._trafficMessage = trafficMessage;
    }

    public ResourceInformation getResourceInformation() {
        return this._resourceInfo;
    }

    public void setResourceInfomation(ResourceInformation resourceInformation) {
        this._resourceInfo = resourceInformation;
    }

    public TrafficInformationDetails[] getTrafficInformationDetail() {
        return this._trafficDetailInfoList;
    }

    public void setTrafficInformationDetail(TrafficInformationDetails[] trafficInformationDetailsArray) {
        this._trafficDetailInfoList = trafficInformationDetailsArray;
    }

    public boolean isEqualsTo(TrafficMiniMapInfo trafficMiniMapInfo) {
        if (trafficMiniMapInfo == null) {
            return false;
        }
        if (this.getTrafficMessage() == null || trafficMiniMapInfo.getTrafficMessage() == null) {
            return false;
        }
        if (this.getTrafficMessage().contentID != trafficMiniMapInfo.getTrafficMessage().contentID) {
            return false;
        }
        if (this.getTrafficMessage().isValid != trafficMiniMapInfo.getTrafficMessage().isValid) {
            return false;
        }
        if (this.getTrafficMessage().trafficMessageID != trafficMiniMapInfo.getTrafficMessage().trafficMessageID) {
            return false;
        }
        return this.getTrafficMessage().value.equalsIgnoreCase(trafficMiniMapInfo.getTrafficMessage().value);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(3000);
        stringBuffer.append("TrafficMiniMapInfo");
        stringBuffer.append('(');
        stringBuffer.append("TrafficMessage");
        stringBuffer.append('=');
        stringBuffer.append(this._trafficMessage != null ? this._trafficMessage.toString() : "NULL");
        stringBuffer.append(',');
        stringBuffer.append("ResourceInformation");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this._resourceInfo != null ? this._resourceInfo.toString() : "NULL");
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

