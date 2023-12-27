/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation;

import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;

public interface IManeuverViewElement {
    default public int getType() {
    }

    default public String getName() {
    }

    default public int getDtm() {
    }

    default public int getRtth() {
    }

    default public int getRttm() {
    }

    default public int getSymbolId() {
    }

    default public int getNumberOfPoiIcons() {
    }

    default public ResourceLocator[] getPoiIcons() {
    }

    default public String getTmcRoadName() {
    }

    default public String getTmcStartLocation() {
    }

    default public String getTmcEndLocation() {
    }

    default public String getTmcMessageText() {
    }

    default public ResourceLocator getTmcListIcon() {
    }

    default public long getDistanceToNextDestination() {
    }

    default public long getRtt() {
    }

    default public int getMainElement() {
    }

    default public int getDirection() {
    }

    default public String getSignPost() {
    }

    default public int getDestinationIndex() {
    }

    default public long getTmcMessageID() {
    }

    default public NavLocation getPoiNavLocation() {
    }

    default public String getTmcRoadNumber() {
    }

    default public String getExitNumber() {
    }

    default public String getAddress() {
    }

    default public int getTmcDelay() {
    }

    default public int[] getTollGateDirections() {
    }

    default public int[] getTollGateInfos() {
    }

    default public int[] getTollGateMarkingsLeft() {
    }

    default public int[] getTollGateMarkingsRight() {
    }

    default public ResourceLocator getColorIndicatorIcon() {
    }

    default public ResourceLocator getTrafficLightIcon() {
    }

    default public boolean getTrafficLightIconVisibility() {
    }

    default public int[] getLaneDirections() {
    }

    default public int[] getLaneInfos() {
    }

    default public int[] getLaneMarkingsLeft() {
    }

    default public int[] getLaneMarkingsRight() {
    }

    default public LabeledIconValue getRoadSignLabeledIcon() {
    }

    default public int getTollGateCost() {
    }

    default public int getTollGateCostCurrency() {
    }

    default public int getLength() {
    }

    default public ResourceLocator getStopoverFlagIcon() {
    }

    default public FixFormatterFieldData getFixFormatterFieldForAddressData() {
    }
}

