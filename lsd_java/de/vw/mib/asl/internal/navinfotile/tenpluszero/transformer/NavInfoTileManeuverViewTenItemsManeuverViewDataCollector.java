/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile.tenpluszero.transformer;

import de.vw.mib.asl.api.navigation.IManeuverViewElement;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;

public class NavInfoTileManeuverViewTenItemsManeuverViewDataCollector
implements Comparable {
    private final long messageID;
    private IManeuverViewElement mvElement;
    protected boolean isValid;

    public NavInfoTileManeuverViewTenItemsManeuverViewDataCollector(IManeuverViewElement iManeuverViewElement) {
        this.messageID = 0L;
        this.mvElement = iManeuverViewElement;
        this.isValid = true;
    }

    @Override
    public int compareTo(Object object) {
        NavInfoTileManeuverViewTenItemsManeuverViewDataCollector navInfoTileManeuverViewTenItemsManeuverViewDataCollector = (NavInfoTileManeuverViewTenItemsManeuverViewDataCollector)object;
        if (this.mvElement.getDtm() >= navInfoTileManeuverViewTenItemsManeuverViewDataCollector.getDtm()) {
            return -1;
        }
        return 1;
    }

    public void updateContent(IManeuverViewElement iManeuverViewElement) {
        this.mvElement = iManeuverViewElement;
    }

    public ResourceLocator[] getPoiIcons() {
        return this.mvElement.getPoiIcons();
    }

    public int getType() {
        return this.mvElement.getType();
    }

    public String getName() {
        return this.mvElement.getName();
    }

    public int getDtm() {
        return this.mvElement.getDtm();
    }

    public int getRtth() {
        return this.mvElement.getRtth();
    }

    public int getRttm() {
        return this.mvElement.getRttm();
    }

    public int getSymbolId() {
        return this.mvElement.getSymbolId();
    }

    public int getNumberOfPoiIcons() {
        return this.mvElement.getNumberOfPoiIcons();
    }

    public String getTmcRoadName() {
        return this.mvElement.getTmcRoadName();
    }

    public String getTmcStartLocation() {
        return this.mvElement.getTmcStartLocation();
    }

    public String getTmcEndLocation() {
        return this.mvElement.getTmcEndLocation();
    }

    public String getTmcMessageText() {
        return this.mvElement.getTmcMessageText();
    }

    public ResourceLocator getTmcListIcon() {
        return this.mvElement.getTmcListIcon();
    }

    public long getDistanceToNextDestination() {
        return this.mvElement.getDistanceToNextDestination();
    }

    public long getRtt() {
        return this.mvElement.getRtt();
    }

    public int getMainElement() {
        return this.mvElement.getMainElement();
    }

    public int getDirection() {
        return this.mvElement.getDirection();
    }

    public String getSignPost() {
        return this.mvElement.getSignPost();
    }

    public int getDestinationIndex() {
        return this.mvElement.getDestinationIndex();
    }

    public long getTmcMessageID() {
        return this.mvElement.getTmcMessageID();
    }

    public NavLocation getPoiNavLocation() {
        return this.mvElement.getPoiNavLocation();
    }

    public String getTmcRoadNumber() {
        return this.mvElement.getTmcRoadNumber();
    }

    public String getExitNumber() {
        return this.mvElement.getExitNumber();
    }

    public String getAddress() {
        return this.mvElement.getAddress();
    }

    public int getTmcDelay() {
        return this.mvElement.getTmcDelay();
    }

    public int[] getTollGateDirections() {
        return this.mvElement.getTollGateDirections();
    }

    public int[] getTollGateInfos() {
        return this.mvElement.getTollGateInfos();
    }

    public int[] getTollGateMarkingsLeft() {
        return this.mvElement.getTollGateMarkingsLeft();
    }

    public int[] getTollGateMarkingsRight() {
        return this.mvElement.getTollGateMarkingsRight();
    }

    public ResourceLocator getColorIndicatorIcon() {
        return this.mvElement.getColorIndicatorIcon();
    }

    public ResourceLocator getTrafficLightIcon() {
        return this.mvElement.getTrafficLightIcon();
    }

    public boolean getTrafficLightIconVisibility() {
        return this.mvElement.getTrafficLightIconVisibility();
    }

    public int[] getLaneDirections() {
        return this.mvElement.getLaneDirections();
    }

    public int[] getLaneInfos() {
        return this.mvElement.getLaneInfos();
    }

    public int[] getLaneMarkingsLeft() {
        return this.mvElement.getLaneMarkingsLeft();
    }

    public int[] getLaneMarkingsRight() {
        return this.mvElement.getLaneMarkingsRight();
    }

    public LabeledIconValue getRoadSignLabeledIcon() {
        return this.mvElement.getRoadSignLabeledIcon();
    }

    public int getTollGateCost() {
        return this.mvElement.getTollGateCost();
    }

    public int getTollGateCostCurrency() {
        return this.mvElement.getTollGateCostCurrency();
    }

    public int getLength() {
        return this.mvElement.getLength();
    }

    public ResourceLocator getStopoverFlagIcon() {
        return this.mvElement.getStopoverFlagIcon();
    }

    public FixFormatterFieldData getFixFormatterFieldForAddressData() {
        return this.mvElement.getFixFormatterFieldForAddressData();
    }

    public boolean isValid() {
        return this.isValid;
    }

    public String toString() {
        return new StringBuffer().append("NavInfoTileManeuverViewTenItemsManeuverViewDataCollector [messageID=").append(this.messageID).append(", mvElement=").append(this.mvElement).append(", getPoiIcons()=").append(this.getPoiIcons() != null ? this.arrayToString(this.getPoiIcons(), this.getPoiIcons().length) : null).append(", getType()=").append(this.getType()).append(", getName()=").append(this.getName()).append(", getDtm()=").append(this.getDtm()).append(", getRtth()=").append(this.getRtth()).append(", getRttm()=").append(this.getRttm()).append(", getSymbolId()=").append(this.getSymbolId()).append(", getNumberOfPoiIcons()=").append(this.getNumberOfPoiIcons()).append(", getTmcRoadName()=").append(this.getTmcRoadName()).append(", getTmcStartLocation()=").append(this.getTmcStartLocation()).append(", getTmcEndLocation()=").append(this.getTmcEndLocation()).append(", getTmcMessageText()=").append(this.getTmcMessageText()).append(", getTmcListIcon()=").append(this.getTmcListIcon()).append(", getDistanceToNextDestination()=").append(this.getDistanceToNextDestination()).append(", getRtt()=").append(this.getRtt()).append(", getMainElement()=").append(this.getMainElement()).append(", getDirection()=").append(this.getDirection()).append(", getSignPost()=").append(this.getSignPost()).append(", getDestinationIndex()=").append(this.getDestinationIndex()).append(", getTmcMessageID()=").append(this.getTmcMessageID()).append(", getPoiNavLocation()=").append(this.getPoiNavLocation()).append(", getTmcRoadNumber()=").append(this.getTmcRoadNumber()).append(", getExitNumber()=").append(this.getExitNumber()).append(", getAddress()=").append(this.getAddress()).append(", getTmcDelay()=").append(this.getTmcDelay()).append(", getTollGateDirections()=").append(this.getTollGateDirections() != null ? this.arrayToString(this.getTollGateDirections(), this.getTollGateDirections().length) : null).append(", getTollGateInfos()=").append(this.getTollGateInfos() != null ? this.arrayToString(this.getTollGateInfos(), this.getTollGateInfos().length) : null).append(", getTollGateMarkingsLeft()=").append(this.getTollGateMarkingsLeft() != null ? this.arrayToString(this.getTollGateMarkingsLeft(), this.getTollGateMarkingsLeft().length) : null).append(", getTollGateMarkingsRight()=").append(this.getTollGateMarkingsRight() != null ? this.arrayToString(this.getTollGateMarkingsRight(), this.getTollGateMarkingsRight().length) : null).append(", getColorIndicatorIcon()=").append(this.getColorIndicatorIcon()).append(", getTrafficLightIcon()=").append(this.getTrafficLightIcon()).append(", getTrafficLightIconVisibility()=").append(this.getTrafficLightIconVisibility()).append(", getLaneDirections()=").append(this.getLaneDirections() != null ? this.arrayToString(this.getLaneDirections(), this.getLaneDirections().length) : null).append(", getLaneInfos()=").append(this.getLaneInfos() != null ? this.arrayToString(this.getLaneInfos(), this.getLaneInfos().length) : null).append(", getLaneMarkingsLeft()=").append(this.getLaneMarkingsLeft() != null ? this.arrayToString(this.getLaneMarkingsLeft(), this.getLaneMarkingsLeft().length) : null).append(", getLaneMarkingsRight()=").append(this.getLaneMarkingsRight() != null ? this.arrayToString(this.getLaneMarkingsRight(), this.getLaneMarkingsRight().length) : null).append(", getRoadSignLabeledIcon()=").append(this.getRoadSignLabeledIcon()).append(", getTollGateCost()=").append(this.getTollGateCost()).append(", getTollGateCostCurrency()=").append(this.getTollGateCostCurrency()).append(", getLength()=").append(this.getLength()).append(", getStopoverFlagIcon()=").append(this.getStopoverFlagIcon()).append(", getFixFormatterFieldForAddressData()=").append(this.getFixFormatterFieldForAddressData()).append("]").toString();
    }

    private String arrayToString(Object object, int n) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        for (int i2 = 0; i2 < n; ++i2) {
            if (i2 > 0) {
                stringBuffer.append(", ");
            }
            if (object instanceof int[]) {
                stringBuffer.append(((int[])object)[i2]);
            }
            if (!(object instanceof Object[])) continue;
            stringBuffer.append(((Object[])object)[i2]);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

