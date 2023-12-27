/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile.maneuverview;

import de.vw.mib.asl.api.navigation.IManeuverViewElement;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;

public class NavInfoTileManeuverViewThreeItemsCollector {
    private final IManeuverViewElement mvElement;
    protected boolean isValid = false;

    public NavInfoTileManeuverViewThreeItemsCollector(IManeuverViewElement iManeuverViewElement) {
        this.mvElement = iManeuverViewElement;
        this.isValid = true;
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

    public ResourceLocator[] getPoiIcons() {
        return this.mvElement.getPoiIcons();
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
}

