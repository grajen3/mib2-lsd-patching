/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile.tenpluszero.transformer;

import de.vw.mib.asl.api.navigation.IManeuverViewElement;
import de.vw.mib.asl.internal.navinfotile.tenpluszero.transformer.NavInfoTileManeuverViewTenItemsManeuverViewDataCollector;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.navinfotile.maneuverviewtenitems.ASLNavInfoTileManeuverViewTenItemsPropertyManager;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;

public final class DefaultNavInfoTileManeuverViewTenItemsManeuverViewDataCollector
extends NavInfoTileManeuverViewTenItemsManeuverViewDataCollector {
    public DefaultNavInfoTileManeuverViewTenItemsManeuverViewDataCollector(IManeuverViewElement iManeuverViewElement) {
        super(iManeuverViewElement);
        this.isValid = false;
    }

    public DefaultNavInfoTileManeuverViewTenItemsManeuverViewDataCollector() {
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
        boolean bl = false;
        return new ResourceLocator[0];
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
        return ASLNavInfoTileManeuverViewTenItemsPropertyManager.MANEUVER_VIEW_DATA__MANEUVER_VIEW_DATA_TMC_LIST_ICON__DEFAULT_VALUE;
    }

    @Override
    public long getDistanceToNextDestination() {
        return 0L;
    }

    @Override
    public long getRtt() {
        return this.getRtth() + this.getRttm();
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
        return new NavLocation();
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
        return ASLNavInfoTileManeuverViewTenItemsPropertyManager.MANEUVER_VIEW_DATA__MANEUVER_VIEW_DATA_TOLL_GATE_DIRECTIONS__DEFAULT_VALUE;
    }

    @Override
    public int[] getTollGateInfos() {
        return ASLNavInfoTileManeuverViewTenItemsPropertyManager.MANEUVER_VIEW_DATA__MANEUVER_VIEW_DATA_TOLL_GATE_INFOS__DEFAULT_VALUE;
    }

    @Override
    public int[] getTollGateMarkingsLeft() {
        return ASLNavInfoTileManeuverViewTenItemsPropertyManager.MANEUVER_VIEW_DATA__MANEUVER_VIEW_DATA_TOLL_GATE_MARKINGS_LEFT__DEFAULT_VALUE;
    }

    @Override
    public int[] getTollGateMarkingsRight() {
        return ASLNavInfoTileManeuverViewTenItemsPropertyManager.MANEUVER_VIEW_DATA__MANEUVER_VIEW_DATA_TOLL_GATE_MARKINGS_RIGHT__DEFAULT_VALUE;
    }

    @Override
    public ResourceLocator getColorIndicatorIcon() {
        return ASLNavInfoTileManeuverViewTenItemsPropertyManager.MANEUVER_VIEW_DATA__MANEUVER_VIEW_DATA_COLOR_INDICATOR_ICON__DEFAULT_VALUE;
    }

    @Override
    public ResourceLocator getTrafficLightIcon() {
        return ASLNavInfoTileManeuverViewTenItemsPropertyManager.MANEUVER_VIEW_DATA__MANEUVER_VIEW_DATA_TRAFFIC_LIGHT_ICON__DEFAULT_VALUE;
    }

    @Override
    public boolean getTrafficLightIconVisibility() {
        return false;
    }

    @Override
    public int[] getLaneDirections() {
        return ASLNavInfoTileManeuverViewTenItemsPropertyManager.MANEUVER_VIEW_DATA__MANEUVER_VIEW_DATA_LANE_DIRECTIONS__DEFAULT_VALUE;
    }

    @Override
    public int[] getLaneInfos() {
        return ASLNavInfoTileManeuverViewTenItemsPropertyManager.MANEUVER_VIEW_DATA__MANEUVER_VIEW_DATA_LANE_INFOS__DEFAULT_VALUE;
    }

    @Override
    public int[] getLaneMarkingsLeft() {
        return ASLNavInfoTileManeuverViewTenItemsPropertyManager.MANEUVER_VIEW_DATA__MANEUVER_VIEW_DATA_LANE_MARKINGS_LEFT__DEFAULT_VALUE;
    }

    @Override
    public int[] getLaneMarkingsRight() {
        return ASLNavInfoTileManeuverViewTenItemsPropertyManager.MANEUVER_VIEW_DATA__MANEUVER_VIEW_DATA_LANE_MARKINGS_RIGHT__DEFAULT_VALUE;
    }

    @Override
    public LabeledIconValue getRoadSignLabeledIcon() {
        return ASLNavInfoTileManeuverViewTenItemsPropertyManager.MANEUVER_VIEW_DATA__MANEUVER_VIEW_DATA_ROAD_SIGN_LABELED_ICON__DEFAULT_VALUE;
    }

    @Override
    public int getTollGateCost() {
        return -1;
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
        return ASLNavInfoTileManeuverViewTenItemsPropertyManager.MANEUVER_VIEW_DATA__MANEUVER_VIEW_DATA_STOPOVER_FLAG_ICON__DEFAULT_VALUE;
    }

    @Override
    public FixFormatterFieldData getFixFormatterFieldForAddressData() {
        return ASLNavInfoTileManeuverViewTenItemsPropertyManager.MANEUVER_VIEW_DATA__MANEUVER_VIEW_DATA_ADDRESS_INFO_FOR_FIX_FORMATTER__DEFAULT_VALUE;
    }
}

