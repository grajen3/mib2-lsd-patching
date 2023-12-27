/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile.maneuverview;

import de.vw.mib.asl.api.navigation.IManeuverViewElement;
import de.vw.mib.asl.internal.navinfotile.maneuverview.NavInfoTileManeuverViewThreeItemsCollector;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;

public class DefaultNavInfoTileManeuverViewThreeItemsCollector
extends NavInfoTileManeuverViewThreeItemsCollector {
    public DefaultNavInfoTileManeuverViewThreeItemsCollector(IManeuverViewElement iManeuverViewElement) {
        super(iManeuverViewElement);
        this.isValid = false;
    }

    public DefaultNavInfoTileManeuverViewThreeItemsCollector() {
        this(null);
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public int getDtm() {
        return 0;
    }

    @Override
    public int getRtth() {
        return 0;
    }

    @Override
    public int getRttm() {
        return 0;
    }

    @Override
    public int getSymbolId() {
        return 0;
    }

    @Override
    public int getNumberOfPoiIcons() {
        return 0;
    }

    @Override
    public ResourceLocator[] getPoiIcons() {
        return null;
    }

    @Override
    public String getTmcRoadName() {
        return "";
    }

    @Override
    public String getTmcStartLocation() {
        return "";
    }

    @Override
    public String getTmcEndLocation() {
        return "";
    }

    @Override
    public String getTmcMessageText() {
        return "";
    }

    @Override
    public ResourceLocator getTmcListIcon() {
        return null;
    }

    @Override
    public long getDistanceToNextDestination() {
        return 0L;
    }

    @Override
    public long getRtt() {
        return 0L;
    }

    @Override
    public int getMainElement() {
        return 0;
    }

    @Override
    public int getDirection() {
        return 0;
    }

    @Override
    public String getSignPost() {
        return "";
    }

    @Override
    public int getDestinationIndex() {
        return 0;
    }

    @Override
    public long getTmcMessageID() {
        return 0L;
    }

    @Override
    public NavLocation getPoiNavLocation() {
        return null;
    }

    @Override
    public String getTmcRoadNumber() {
        return "";
    }

    @Override
    public String getExitNumber() {
        return "";
    }

    @Override
    public String getAddress() {
        return "";
    }

    @Override
    public int getTmcDelay() {
        return 0;
    }

    @Override
    public int[] getTollGateDirections() {
        return null;
    }

    @Override
    public int[] getTollGateInfos() {
        return null;
    }

    @Override
    public int[] getTollGateMarkingsLeft() {
        return null;
    }

    @Override
    public int[] getTollGateMarkingsRight() {
        return null;
    }

    @Override
    public ResourceLocator getColorIndicatorIcon() {
        return null;
    }

    @Override
    public ResourceLocator getTrafficLightIcon() {
        return null;
    }

    @Override
    public boolean getTrafficLightIconVisibility() {
        return false;
    }

    @Override
    public int[] getLaneDirections() {
        return null;
    }

    @Override
    public int[] getLaneInfos() {
        return null;
    }

    @Override
    public int[] getLaneMarkingsLeft() {
        return null;
    }

    @Override
    public int[] getLaneMarkingsRight() {
        return null;
    }

    @Override
    public LabeledIconValue getRoadSignLabeledIcon() {
        return null;
    }

    @Override
    public int getTollGateCost() {
        return 0;
    }

    @Override
    public int getTollGateCostCurrency() {
        return 0;
    }

    @Override
    public int getLength() {
        return 0;
    }

    @Override
    public ResourceLocator getStopoverFlagIcon() {
        return null;
    }

    @Override
    public FixFormatterFieldData getFixFormatterFieldForAddressData() {
        return null;
    }
}

