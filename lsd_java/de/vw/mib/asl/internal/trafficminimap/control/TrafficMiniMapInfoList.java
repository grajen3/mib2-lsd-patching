/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.trafficminimap.control;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.trafficminimap.common.TrafficMiniMapInfo;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.trafficminimap.transformer.TrafficMiniMapHotSpotMapCollector;
import org.dsi.ifc.asiatrafficinfomenu.Interrupt;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformationDetails;
import org.dsi.ifc.asiatrafficinfomenu.TrafficMessage;

public class TrafficMiniMapInfoList {
    private final String _classname;
    private final int AREA_LIST_MAX_SIZE;
    private TrafficMiniMapInfo[] _areaList;
    private TrafficMiniMapHotSpotMapCollector _hotSpot;
    private TrafficMiniMapHotSpotMapCollector[] _hotSpotList;

    public TrafficMiniMapInfoList() {
        this._classname = "TrafficMiniMapInfoList";
        this.AREA_LIST_MAX_SIZE = 6;
    }

    void updateMessageList(TrafficMessage[] trafficMessageArray) {
        if (ServiceManager.logger2.isTraceEnabled(128)) {
            LogMessage logMessage = ServiceManager.logger2.trace(128);
            logMessage.append("TrafficMiniMapInfoList").append(new StringBuffer().append(".updateMessageList(").append(!Util.isNullOrEmpty(trafficMessageArray) ? String.valueOf(trafficMessageArray.length) : "NULL").append(")").toString()).log();
        }
        this._areaList = new TrafficMiniMapInfo[0];
        if (!Util.isNullOrEmpty(trafficMessageArray)) {
            int n = trafficMessageArray.length;
            this._areaList = new TrafficMiniMapInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                TrafficMiniMapInfo trafficMiniMapInfo = new TrafficMiniMapInfo(trafficMessageArray[i2]);
                this._areaList[i2] = new TrafficMiniMapInfo(trafficMiniMapInfo);
            }
        }
    }

    void updateRefillMessageList(TrafficMessage[] trafficMessageArray) {
        if (ServiceManager.logger2.isTraceEnabled(128)) {
            LogMessage logMessage = ServiceManager.logger2.trace(128);
            logMessage.append("TrafficMiniMapInfoList").append(new StringBuffer().append(".updateRefillMessageList(").append(!Util.isNullOrEmpty(trafficMessageArray) ? String.valueOf(trafficMessageArray.length) : "NULL").append(")").toString()).log();
        }
        this.resetAreaListInfo();
        if (!Util.isNullOrEmpty(trafficMessageArray)) {
            int n = trafficMessageArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                TrafficMiniMapInfo trafficMiniMapInfo = this.getTrafficInfoFromAreaListWithContentID(trafficMessageArray[i2].getContentID());
                if (trafficMiniMapInfo != null) {
                    trafficMiniMapInfo.setTrafficMessage(trafficMessageArray[i2]);
                    continue;
                }
                if (this._areaList.length >= 6) continue;
                TrafficMiniMapInfo[] trafficMiniMapInfoArray = new TrafficMiniMapInfo[this._areaList.length];
                System.arraycopy((Object)this._areaList, 0, (Object)trafficMiniMapInfoArray, 0, this._areaList.length);
                this._areaList = new TrafficMiniMapInfo[trafficMiniMapInfoArray.length + 1];
                System.arraycopy((Object)trafficMiniMapInfoArray, 0, (Object)this._areaList, 0, trafficMiniMapInfoArray.length);
                this._areaList[trafficMiniMapInfoArray.length] = new TrafficMiniMapInfo(trafficMessageArray[i2]);
                trafficMiniMapInfoArray = null;
            }
        }
    }

    void resetAreaListInfo() {
        if (!Util.isNullOrEmpty(this._areaList)) {
            int n = this._areaList.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (this._areaList[i2].getTrafficMessage() == null) continue;
                this._areaList[i2].getTrafficMessage().isValid = false;
                this._areaList[i2].setResourceInfomation(null);
            }
        }
    }

    void updateValidMessageList(TrafficMessage[] trafficMessageArray) {
        if (ServiceManager.logger2.isTraceEnabled(128)) {
            LogMessage logMessage = ServiceManager.logger2.trace(128);
            logMessage.append("TrafficMiniMapInfoList").append(new StringBuffer().append(".updateValidMessageList(").append(!Util.isNullOrEmpty(trafficMessageArray) ? String.valueOf(trafficMessageArray.length) : "NULL").append(")").toString()).log();
        }
        this._areaList = new TrafficMiniMapInfo[0];
        if (!Util.isNullOrEmpty(trafficMessageArray)) {
            int n = this.getValidMessageListCount(trafficMessageArray);
            this._areaList = new TrafficMiniMapInfo[n];
            int n2 = 0;
            for (int i2 = 0; i2 < trafficMessageArray.length; ++i2) {
                if (!trafficMessageArray[i2].isIsValid() || n2 >= n) continue;
                TrafficMiniMapInfo trafficMiniMapInfo = new TrafficMiniMapInfo(trafficMessageArray[i2]);
                this._areaList[n2] = new TrafficMiniMapInfo(trafficMiniMapInfo);
                ++n2;
            }
        }
    }

    private int getValidMessageListCount(TrafficMessage[] trafficMessageArray) {
        int n = 0;
        if (!Util.isNullOrEmpty(trafficMessageArray)) {
            for (int i2 = 0; i2 < trafficMessageArray.length; ++i2) {
                if (!trafficMessageArray[i2].isIsValid()) continue;
                ++n;
            }
        }
        return n;
    }

    public TrafficMiniMapHotSpotMapCollector getHotSpot() {
        return this._hotSpot;
    }

    public void setHotSpot(TrafficMiniMapHotSpotMapCollector trafficMiniMapHotSpotMapCollector) {
        if (trafficMiniMapHotSpotMapCollector != null) {
            this._hotSpot = trafficMiniMapHotSpotMapCollector;
        }
    }

    public boolean isHotSpotValid() {
        return this._hotSpot.trafficminimap_hot_spot_map_content_id > 0L;
    }

    public TrafficMiniMapInfo[] getCompleteAreaList() {
        return this._areaList;
    }

    public void setCompleteAreaList(TrafficMiniMapInfo[] trafficMiniMapInfoArray) {
        this._areaList = trafficMiniMapInfoArray;
    }

    public boolean isAreaListValid() {
        if (!Util.isNullOrEmpty(this._areaList)) {
            int n = this._areaList.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (!this._areaList[i2].getTrafficMessage().isIsValid()) continue;
                return true;
            }
        }
        return false;
    }

    public boolean isContentIDValidForAreaList(int n) {
        if (!Util.isNullOrEmpty(this._areaList)) {
            int n2 = this._areaList.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (this._areaList[i2].getTrafficMessage().getContentID() != n) continue;
                return true;
            }
        }
        return false;
    }

    public TrafficMiniMapInfo getTrafficInfoFromAreaListWithIndex(int n) {
        if (!Util.isNullOrEmpty(this._areaList)) {
            int n2 = this._areaList.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (i2 != n) continue;
                return this._areaList[i2];
            }
        }
        return null;
    }

    public TrafficMiniMapInfo getTrafficInfoFromAreaListWithMessageID(int n) {
        if (!Util.isNullOrEmpty(this._areaList)) {
            int n2 = this._areaList.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (this._areaList[i2].getTrafficMessage().getTrafficMessageID() != n) continue;
                return this._areaList[i2];
            }
        }
        return null;
    }

    public TrafficMiniMapInfo getTrafficInfoFromAreaListWithContentID(long l) {
        if (!Util.isNullOrEmpty(this._areaList)) {
            int n = this._areaList.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if ((long)this._areaList[i2].getTrafficMessage().getContentID() != l) continue;
                return this._areaList[i2];
            }
        }
        return null;
    }

    public TrafficMiniMapHotSpotMapCollector[] getHotSpotList() {
        return this._hotSpotList;
    }

    public void initialize() {
        this._hotSpot = new TrafficMiniMapHotSpotMapCollector();
        this._areaList = new TrafficMiniMapInfo[0];
        this._hotSpotList = new TrafficMiniMapHotSpotMapCollector[0];
    }

    public void updateTrafficInfoList(TrafficInformation[] trafficInformationArray) {
        LogMessage logMessage;
        if (ServiceManager.logger2.isTraceEnabled(128)) {
            logMessage = ServiceManager.logger2.trace(128);
            logMessage.append("TrafficMiniMapInfoList").append(new StringBuffer().append(".updateTrafficInfoList(").append(!Util.isNullOrEmpty(trafficInformationArray) ? String.valueOf(trafficInformationArray.length) : "NULL").append(")").toString()).log();
        }
        if (!Util.isNullOrEmpty(trafficInformationArray)) {
            int n = trafficInformationArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                if (trafficInformationArray[i2] == null || trafficInformationArray[i2].trafficType != 6) continue;
                this.updateValidMessageList(trafficInformationArray[i2].getTrafficMessages());
            }
        } else {
            this._areaList = new TrafficMiniMapInfo[0];
            if (ServiceManager.logger2.isTraceEnabled(128)) {
                logMessage = ServiceManager.logger2.trace(128);
                logMessage.append("TrafficMiniMapInfoList").append(".handleMessageList()-> LIST IS NULL").log();
            }
        }
    }

    public void updateResourceInformationForAreaList(int n, ResourceInformation resourceInformation) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(128)) {
            object = ServiceManager.logger2.trace(128);
            object.append("TrafficMiniMapInfoList").append(new StringBuffer().append(".updateResourceInformationForAreaList(").append(n).append(", ").append(resourceInformation != null ? resourceInformation.toString() : "NULL").append(")").toString()).log();
        }
        if (n > 0) {
            object = this.getTrafficInfoFromAreaListWithContentID(n);
            if (object != null) {
                ResourceInformation resourceInformation2 = null;
                if (resourceInformation != null) {
                    resourceInformation2 = new ResourceInformation(resourceInformation.getResourceLocator(), resourceInformation.getPhoneticString());
                }
                ((TrafficMiniMapInfo)object).setResourceInfomation(resourceInformation2);
            } else if (ServiceManager.logger2.isTraceEnabled(128)) {
                LogMessage logMessage = ServiceManager.logger2.trace(128);
                logMessage.append("TrafficMiniMapInfoList").append(".updateResourceInformation()-> There is no available Traffic Info or resource Info is invalid").log();
            }
        } else if (ServiceManager.logger2.isTraceEnabled(128)) {
            object = ServiceManager.logger2.trace(128);
            object.append("TrafficMiniMapInfoList").append(new StringBuffer().append(".updateResourceInformation()-> ContentID : ").append(n).append(" is not valid").toString()).log();
        }
    }

    public void updateActiveInterrupts(Interrupt[] interruptArray) {
        if (ServiceManager.logger2.isTraceEnabled(128)) {
            LogMessage logMessage = ServiceManager.logger2.trace(128);
            logMessage.append("TrafficMiniMapInfoList").append(new StringBuffer().append(".updateActiveInterrupts(").append(!Util.isNullOrEmpty(interruptArray) ? String.valueOf(interruptArray.length) : "NULL").append(")").toString()).log();
        }
        if (!Util.isNullOrEmpty(interruptArray)) {
            int n = interruptArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                int[] nArray;
                int n2;
                if (interruptArray[i2].getInterruptType() != 21 || Util.isNullOrEmpty(interruptArray[i2].getContentID()) || (n2 = (nArray = interruptArray[i2].getContentID()).length) <= 0) continue;
                this._hotSpotList = new TrafficMiniMapHotSpotMapCollector[n2];
                for (int i3 = 0; i3 < n2; ++i3) {
                    this._hotSpotList[i3] = new TrafficMiniMapHotSpotMapCollector();
                    this._hotSpotList[i3].trafficminimap_hot_spot_map_content_id = nArray[i3];
                }
            }
            if (!Util.isNullOrEmpty(this._hotSpotList)) {
                this._hotSpot = this._hotSpotList[0];
            }
        } else {
            this._hotSpotList = new TrafficMiniMapHotSpotMapCollector[0];
            this._hotSpot = new TrafficMiniMapHotSpotMapCollector();
        }
    }

    public void updateResourceInformationForActiveInterrupts(int n, ResourceInformation resourceInformation) {
        LogMessage logMessage;
        if (ServiceManager.logger2.isTraceEnabled(128)) {
            logMessage = ServiceManager.logger2.trace(128);
            logMessage.append("TrafficMiniMapInfoList").append(new StringBuffer().append(".updateResourceInformationForActiveInterrupts(").append(n).append(", ").append(resourceInformation != null ? resourceInformation.toString() : "NULL").append(")").toString()).log();
        }
        if (n > 0) {
            if (!Util.isNullOrEmpty(this._hotSpotList)) {
                int n2 = this._hotSpotList.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    if (this._hotSpotList[i2].trafficminimap_hot_spot_map_content_id != (long)n) continue;
                    this._hotSpotList[i2].trafficminimap_hot_spot_map_graphic = resourceInformation != null ? resourceInformation.getResourceLocator() : null;
                    this._hotSpotList[i2].trafficminimap_hot_spot_map_validity = resourceInformation != null;
                }
            }
        } else if (ServiceManager.logger2.isTraceEnabled(128)) {
            logMessage = ServiceManager.logger2.trace(128);
            logMessage.append("TrafficMiniMapInfoList").append(".updateResourceInformationForActiveInterrupts()-> ContentID is Invalid").log();
        }
    }

    public void updateTrafficDetailInfo(int n, TrafficInformationDetails trafficInformationDetails) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(128)) {
            object = ServiceManager.logger2.trace(128);
            object.append("TrafficMiniMapInfoList").append(new StringBuffer().append(".updateTrafficDetailInfo(").append(n).append(", ").append(trafficInformationDetails != null ? trafficInformationDetails.toString() : "NULL").append(")").toString()).log();
        }
        if (n > 0) {
            object = this.getTrafficInfoFromAreaListWithMessageID(n);
            if (object != null) {
                TrafficInformationDetails[] trafficInformationDetailsArray = null;
                if (trafficInformationDetails != null) {
                    trafficInformationDetailsArray = new TrafficInformationDetails[]{new TrafficInformationDetails(trafficInformationDetails.getTrafficType(), trafficInformationDetails.getContentID())};
                }
                ((TrafficMiniMapInfo)object).setTrafficInformationDetail(trafficInformationDetailsArray);
            } else if (ServiceManager.logger2.isTraceEnabled(128)) {
                LogMessage logMessage = ServiceManager.logger2.trace(128);
                logMessage.append("TrafficMiniMapInfoList").append(".updateTrafficDetailInfo()-> There is no available Traffic Info").log();
            }
        } else if (ServiceManager.logger2.isTraceEnabled(128)) {
            object = ServiceManager.logger2.trace(128);
            object.append("TrafficMiniMapInfoList").append(new StringBuffer().append(".updateTrafficDetatilInfo()-> TrafficMessageID : ").append(n).append(" is not valid").toString()).log();
        }
    }

    public void updateTrafficDetailInfoList(int n, TrafficInformationDetails[] trafficInformationDetailsArray) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(128)) {
            object = ServiceManager.logger2.trace(128);
            object.append("TrafficMiniMapInfoList").append(new StringBuffer().append(".updateTrafficDetailInfoList(").append(n).append(", ").append(!Util.isNullOrEmpty(trafficInformationDetailsArray) ? String.valueOf(trafficInformationDetailsArray.length) : "NULL").append(")").toString()).log();
        }
        if (n > 0 && !Util.isNullOrEmpty(trafficInformationDetailsArray)) {
            object = this.getTrafficInfoFromAreaListWithMessageID(n);
            if (object != null) {
                int n2 = trafficInformationDetailsArray.length;
                int n3 = 0;
                for (int i2 = 0; i2 < n2; ++i2) {
                    if (trafficInformationDetailsArray[i2].getTrafficType() != 6) continue;
                    ++n3;
                }
                TrafficInformationDetails[] trafficInformationDetailsArray2 = new TrafficInformationDetails[n3];
                int n4 = 0;
                for (int i3 = 0; i3 < n2; ++i3) {
                    if (trafficInformationDetailsArray[i3].getTrafficType() != 6 || n4 >= n3) continue;
                    trafficInformationDetailsArray2[n4] = new TrafficInformationDetails(trafficInformationDetailsArray[i3].getTrafficType(), trafficInformationDetailsArray[i3].getContentID());
                    ++n4;
                }
                ((TrafficMiniMapInfo)object).setTrafficInformationDetail(trafficInformationDetailsArray2);
            } else if (ServiceManager.logger2.isTraceEnabled(128)) {
                LogMessage logMessage = ServiceManager.logger2.trace(128);
                logMessage.append("TrafficMiniMapInfoList").append(".updateTrafficDetailInfoList()-> There is no available Traffic Info").log();
            }
        } else if (ServiceManager.logger2.isTraceEnabled(128)) {
            object = ServiceManager.logger2.trace(128);
            object.append("TrafficMiniMapInfoList").append(new StringBuffer().append(".updateTrafficDetailInfoList()-> TrafficMessageID : ").append(n).append(" is not valid").toString()).log();
        }
    }
}

