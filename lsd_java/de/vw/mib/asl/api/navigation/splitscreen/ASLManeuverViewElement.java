/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.splitscreen;

import de.vw.mib.asl.api.navigation.IManeuverViewElement;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import java.util.Arrays;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;

public class ASLManeuverViewElement
implements IManeuverViewElement {
    public int type;
    public String name;
    public int dtm;
    public int rtth;
    public int rttm;
    public int symbolId;
    public int numberOfPoiIcons;
    public ResourceLocator[] poiIcons;
    public String tmcRoadName;
    public String tmcStartLocation;
    public String tmcEndLocation;
    public String tmcMessageText;
    public ResourceLocator tmcListIcon;
    public long distanceToNextDestination;
    public long rtt;
    public int mainElement;
    public int direction;
    public String signPost;
    public int destinationIndex;
    public long tmcMessageID;
    public NavLocation poiNavLocation;
    public String tmcRoadNumber;
    public String exitNumber;
    public String address;
    public int tmcDelay;
    public int[] tollGateDirections;
    public int[] tollGateInfos;
    public int[] tollGateMarkingsLeft;
    public int[] tollGateMarkingsRight;
    public ResourceLocator colorIndicatorIcon;
    public ResourceLocator trafficLightIcon;
    public boolean trafficLightIconVisibility;
    public int[] laneDirections;
    public int[] laneInfos;
    public int[] laneMarkingsLeft;
    public int[] laneMarkingsRight;
    public LabeledIconValue roadSignLabeledIcon;
    public int tollGateCost;
    public int tollGateCostCurrency;
    public int length;
    public ResourceLocator stopoverFlagIcon;
    public FixFormatterFieldData fixFormatterFieldForAddressData;

    @Override
    public int getType() {
        return this.type;
    }

    public void setType(int n) {
        this.type = n;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    @Override
    public int getDtm() {
        return this.dtm;
    }

    public void setDtm(int n) {
        this.dtm = n;
    }

    @Override
    public int getRtth() {
        return this.rtth;
    }

    public void setRtth(int n) {
        this.rtth = n;
    }

    @Override
    public int getRttm() {
        return this.rttm;
    }

    public void setRttm(int n) {
        this.rttm = n;
    }

    @Override
    public int getSymbolId() {
        return this.symbolId;
    }

    public void setSymbolId(int n) {
        this.symbolId = n;
    }

    @Override
    public int getNumberOfPoiIcons() {
        return this.numberOfPoiIcons;
    }

    public void setNumberOfPoiIcons(int n) {
        this.numberOfPoiIcons = n;
    }

    @Override
    public ResourceLocator[] getPoiIcons() {
        return this.poiIcons;
    }

    public void setPoiIcons(ResourceLocator[] resourceLocatorArray) {
        this.poiIcons = resourceLocatorArray;
    }

    @Override
    public String getTmcRoadName() {
        return this.tmcRoadName;
    }

    public void setTmcRoadName(String string) {
        this.tmcRoadName = string;
    }

    @Override
    public String getTmcStartLocation() {
        return this.tmcStartLocation;
    }

    public void setTmcStartLocation(String string) {
        this.tmcStartLocation = string;
    }

    @Override
    public String getTmcEndLocation() {
        return this.tmcEndLocation;
    }

    public void setTmcEndLocation(String string) {
        this.tmcEndLocation = string;
    }

    @Override
    public String getTmcMessageText() {
        return this.tmcMessageText;
    }

    public void setTmcMessageText(String string) {
        this.tmcMessageText = string;
    }

    @Override
    public ResourceLocator getTmcListIcon() {
        return this.tmcListIcon;
    }

    public void setTmcListIcon(ResourceLocator resourceLocator) {
        this.tmcListIcon = resourceLocator;
    }

    @Override
    public long getDistanceToNextDestination() {
        return this.distanceToNextDestination;
    }

    public void setDistanceToNextDestination(long l) {
        this.distanceToNextDestination = l;
    }

    @Override
    public long getRtt() {
        return this.rtt;
    }

    public void setRtt(long l) {
        this.rtt = l;
    }

    @Override
    public int getMainElement() {
        return this.mainElement;
    }

    public void setMainElement(int n) {
        this.mainElement = n;
    }

    @Override
    public int getDirection() {
        return this.direction;
    }

    public void setDirection(int n) {
        this.direction = n;
    }

    @Override
    public String getSignPost() {
        return this.signPost;
    }

    public void setSignPost(String string) {
        this.signPost = string;
    }

    @Override
    public int getDestinationIndex() {
        return this.destinationIndex;
    }

    public void setDestinationIndex(int n) {
        this.destinationIndex = n;
    }

    @Override
    public long getTmcMessageID() {
        return this.tmcMessageID;
    }

    public void setTmcMessageID(long l) {
        this.tmcMessageID = l;
    }

    @Override
    public NavLocation getPoiNavLocation() {
        return this.poiNavLocation;
    }

    public void setPoiNavLocation(NavLocation navLocation) {
        this.poiNavLocation = navLocation;
    }

    @Override
    public String getTmcRoadNumber() {
        return this.tmcRoadNumber;
    }

    public void setTmcRoadNumber(String string) {
        this.tmcRoadNumber = string;
    }

    @Override
    public String getExitNumber() {
        return this.exitNumber;
    }

    public void setExitNumber(String string) {
        this.exitNumber = string;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String string) {
        this.address = string;
    }

    @Override
    public int getTmcDelay() {
        return this.tmcDelay;
    }

    public void setTmcDelay(int n) {
        this.tmcDelay = n;
    }

    @Override
    public int[] getTollGateDirections() {
        return this.tollGateDirections;
    }

    public void setTollGateDirections(int[] nArray) {
        this.tollGateDirections = nArray;
    }

    @Override
    public int[] getTollGateInfos() {
        return this.tollGateInfos;
    }

    public void setTollGateInfos(int[] nArray) {
        this.tollGateInfos = nArray;
    }

    @Override
    public int[] getTollGateMarkingsLeft() {
        return this.tollGateMarkingsLeft;
    }

    public void setTollGateMarkingsLeft(int[] nArray) {
        this.tollGateMarkingsLeft = nArray;
    }

    @Override
    public int[] getTollGateMarkingsRight() {
        return this.tollGateMarkingsRight;
    }

    public void setTollGateMarkingsRight(int[] nArray) {
        this.tollGateMarkingsRight = nArray;
    }

    @Override
    public ResourceLocator getColorIndicatorIcon() {
        return this.colorIndicatorIcon;
    }

    public void setColorIndicatorIcon(ResourceLocator resourceLocator) {
        this.colorIndicatorIcon = resourceLocator;
    }

    @Override
    public ResourceLocator getTrafficLightIcon() {
        return this.trafficLightIcon;
    }

    public void setTrafficLightIcon(ResourceLocator resourceLocator) {
        this.trafficLightIcon = resourceLocator;
    }

    @Override
    public boolean getTrafficLightIconVisibility() {
        return this.trafficLightIconVisibility;
    }

    public void setTrafficLightIconVisibility(boolean bl) {
        this.trafficLightIconVisibility = bl;
    }

    @Override
    public int[] getLaneDirections() {
        return this.laneDirections;
    }

    public void setLaneDirections(int[] nArray) {
        this.laneDirections = nArray;
    }

    @Override
    public int[] getLaneInfos() {
        return this.laneInfos;
    }

    public void setLaneInfos(int[] nArray) {
        this.laneInfos = nArray;
    }

    @Override
    public int[] getLaneMarkingsLeft() {
        return this.laneMarkingsLeft;
    }

    public void setLaneMarkingsLeft(int[] nArray) {
        this.laneMarkingsLeft = nArray;
    }

    @Override
    public int[] getLaneMarkingsRight() {
        return this.laneMarkingsRight;
    }

    public void setLaneMarkingsRight(int[] nArray) {
        this.laneMarkingsRight = nArray;
    }

    @Override
    public LabeledIconValue getRoadSignLabeledIcon() {
        return this.roadSignLabeledIcon;
    }

    public void setRoadSignLabeledIcon(LabeledIconValue labeledIconValue) {
        this.roadSignLabeledIcon = labeledIconValue;
    }

    @Override
    public int getTollGateCost() {
        return this.tollGateCost;
    }

    public void setTollGateCost(int n) {
        this.tollGateCost = n;
    }

    @Override
    public int getTollGateCostCurrency() {
        return this.tollGateCostCurrency;
    }

    public void setTollGateCostCurrency(int n) {
        this.tollGateCostCurrency = n;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    public void setLength(int n) {
        this.length = n;
    }

    @Override
    public ResourceLocator getStopoverFlagIcon() {
        return this.stopoverFlagIcon;
    }

    public void setStopoverFlagIcon(ResourceLocator resourceLocator) {
        this.stopoverFlagIcon = resourceLocator;
    }

    @Override
    public FixFormatterFieldData getFixFormatterFieldForAddressData() {
        return this.fixFormatterFieldForAddressData;
    }

    public void setFixFormatterFieldForAddressData(FixFormatterFieldData fixFormatterFieldData) {
        this.fixFormatterFieldForAddressData = fixFormatterFieldData;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ASLManeuverViewElement [distanceToNextDestination=");
        stringBuffer.append(this.distanceToNextDestination);
        stringBuffer.append(", dtm=");
        stringBuffer.append(this.dtm);
        stringBuffer.append(", name=");
        stringBuffer.append(this.name);
        stringBuffer.append(", numberOfPoiIcons=");
        stringBuffer.append(this.numberOfPoiIcons);
        stringBuffer.append(", poiIcons=");
        stringBuffer.append(this.poiIcons != null ? Arrays.asList(this.poiIcons) : null);
        stringBuffer.append(", rtt=");
        stringBuffer.append(this.rtt);
        stringBuffer.append(", rtth=");
        stringBuffer.append(this.rtth);
        stringBuffer.append(", rttm=");
        stringBuffer.append(this.rttm);
        stringBuffer.append(", tmcEndLocation=");
        stringBuffer.append(this.tmcEndLocation);
        stringBuffer.append(", tmcListIcon=");
        stringBuffer.append(this.tmcListIcon);
        stringBuffer.append(", tmcMessageText=");
        stringBuffer.append(this.tmcMessageText);
        stringBuffer.append(", tmcRoadName=");
        stringBuffer.append(this.tmcRoadName);
        stringBuffer.append(", tmcStartLocation=");
        stringBuffer.append(this.tmcStartLocation);
        stringBuffer.append(", type=");
        stringBuffer.append(this.type);
        stringBuffer.append(", messageID=");
        stringBuffer.append(this.tmcMessageID);
        stringBuffer.append(", poiNavLocation=");
        stringBuffer.append(this.poiNavLocation);
        stringBuffer.append(", ***3+1 ONLY: START*** symbolId=");
        stringBuffer.append(this.symbolId);
        stringBuffer.append(", ***3+1 ONLY: END***");
        stringBuffer.append(", ***10+0 ONLY: START*** tmcRoadNumber=");
        stringBuffer.append(this.tmcRoadNumber);
        stringBuffer.append(", exitNumber=");
        stringBuffer.append(this.exitNumber);
        stringBuffer.append(", address=");
        stringBuffer.append(this.address);
        stringBuffer.append(", tmcDelay=");
        stringBuffer.append(this.tmcDelay);
        stringBuffer.append(", tollGateDirections=");
        stringBuffer.append(this.tollGateDirections);
        stringBuffer.append(", tollGateInfos=");
        stringBuffer.append(this.tollGateInfos);
        stringBuffer.append(", tollGateMarkingsLeft=");
        stringBuffer.append(this.tollGateMarkingsLeft);
        stringBuffer.append(", tollGateMarkingsRight=");
        stringBuffer.append(this.tollGateMarkingsRight);
        stringBuffer.append(", colorIndicatorIcon=");
        stringBuffer.append(this.colorIndicatorIcon);
        stringBuffer.append(", trafficLightIcon=");
        stringBuffer.append(this.trafficLightIcon);
        stringBuffer.append(", trafficLightIconVisibility=");
        stringBuffer.append(this.trafficLightIconVisibility);
        stringBuffer.append(", laneDirections=");
        stringBuffer.append(this.laneDirections);
        stringBuffer.append(", laneInfos=");
        stringBuffer.append(this.laneInfos);
        stringBuffer.append(", laneMarkingsLeft=");
        stringBuffer.append(this.laneMarkingsLeft);
        stringBuffer.append(", laneMarkingsRight=");
        stringBuffer.append(this.laneMarkingsRight);
        stringBuffer.append(", roadSignLabeledIcon=");
        stringBuffer.append(this.roadSignLabeledIcon);
        stringBuffer.append(", tollGateCost=");
        stringBuffer.append(this.tollGateCost);
        stringBuffer.append(", tollGateCostCurrency=");
        stringBuffer.append(this.tollGateCostCurrency);
        stringBuffer.append(", length=");
        stringBuffer.append(this.length);
        stringBuffer.append(", stopoverFlagIcon=");
        stringBuffer.append(this.stopoverFlagIcon);
        stringBuffer.append(", fixFormatterFieldForAddressData=");
        stringBuffer.append(this.fixFormatterFieldForAddressData);
        stringBuffer.append(", ***10+0 ONLY: END***");
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

