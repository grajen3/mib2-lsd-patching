/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.splitscreen.overlays;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconDescriptor;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.asl.internal.navigation.splitscreen.overlays.transformer.OverlaysDataCollector;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.AdditionalTurnListIcon;
import org.dsi.ifc.navigation.TurnListElement;

public class OverlaysTurnListHandler
implements CacheClient {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[OverlaysTargetHSM - OverlaysTurnListHandler]");
    private static final int ICON_CACHE_ID_OVERLAYS_ICON_TYPE_UNDEFINED;
    private static final int ICON_CACHE_ID_OVERLAYS_ICON_TYPE_MANEUVERMARKER_ICON;
    private static final int ICON_CACHE_ID_OVERLAYS_ICON_TYPE_TRAFFICLIGHT_ICON;
    private static final int ICON_CACHE_ID_OVERLAYS_ICON_TYPE_EXIT_ICON;
    private OverlaysDataCollector overlaysDataCollector;
    private boolean uTurnEnabled = OverlaysTurnListHandler.getSystemConstantB("NAV_UTURN_MAPPING", true);
    private final int uTurnLeftValue = OverlaysTurnListHandler.getSystemConstant("NAV_UTURN_LEFT_DIRECTION", 114);
    private final int uTurnRightValue = OverlaysTurnListHandler.getSystemConstant("NAV_UTURN_RIGHT_DIRECTION", 146);
    private int currentOverlay = 0;
    static /* synthetic */ Class array$Ljava$lang$Object;

    public OverlaysTurnListHandler() {
        this.overlaysDataCollector = OverlaysDataCollector.getInstance();
        this.overlaysDataCollector.resetOverlaysDataCollector();
    }

    public void updateRgTurnList(TurnListElement[] turnListElementArray) {
        this.logger.trace("updateRgTurnList");
        boolean bl = false;
        this.overlaysDataCollector.resetOverlaysDataCollector();
        if (turnListElementArray != null) {
            for (int i2 = 0; i2 < turnListElementArray.length; ++i2) {
                if (bl) continue;
                bl = this.extractTurnListElementSwitch(turnListElementArray[i2], bl);
            }
        }
    }

    private boolean extractTurnListElementSwitch(TurnListElement turnListElement, boolean bl) {
        this.logger.trace("extractTurnListElementSwitch");
        int n = turnListElement.getType();
        switch (n) {
            case 1: {
                this.logger.trace("TURNLISTELEMENTTYPE_MANEUVER_NON_CONTROLLED_ACCESS");
                if (bl) break;
                bl = true;
                this.logger.trace(turnListElement.toString());
                this.createManeuverElement(turnListElement);
                this.createManeuverListElementNonControlledAccess(turnListElement);
                break;
            }
            case 2: {
                this.logger.trace("TURNLISTELEMENTTYPE_MANEUVER_CONTROLLED_ACCESS");
                if (bl) break;
                bl = true;
                this.logger.trace(turnListElement.toString());
                this.createManeuverElement(turnListElement);
                this.createManeuverListElementControlledAccess(turnListElement);
                break;
            }
            default: {
                this.logger.trace("None Found");
            }
        }
        return bl;
    }

    private void createManeuverElement(TurnListElement turnListElement) {
        this.logger.trace("createManeuverElement");
        this.overlaysDataCollector.distanceToNextDestination = turnListElement.getDistance();
        this.overlaysDataCollector.dtm = (int)ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteElement(turnListElement);
        this.overlaysDataCollector.name = turnListElement.getTurnToStreet();
        this.overlaysDataCollector.signPost = turnListElement.getSignPostInfo();
        int[] nArray = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getRttHMToRouteElement(turnListElement);
        this.overlaysDataCollector.rtt = turnListElement.getEta();
        this.overlaysDataCollector.rtth = nArray[0];
        this.overlaysDataCollector.rttm = nArray[1];
    }

    private void createManeuverListElementControlledAccess(TurnListElement turnListElement) {
        this.logger.trace("createManeuverListElementControlledAccess");
        this.handleExitIcon(turnListElement);
        this.overlaysDataCollector.exitNumber = turnListElement.getExitNumber();
        int n = 2;
        int n2 = 3;
        this.createManeuverListElementCommon(turnListElement, n, n2);
    }

    private void handleExitIcon(TurnListElement turnListElement) {
        this.logger.trace("handleExitIcon");
        IconDescriptor iconDescriptor = turnListElement.exitIconId == -1 ? null : this.getResourceExitIcon(turnListElement);
        this.overlaysDataCollector.headlineIcon = iconDescriptor == null ? null : iconDescriptor.getResourceLocator();
        this.overlaysDataCollector.trafficLightIconVisibility = this.overlaysDataCollector.headlineIcon != null;
        this.logger.trace(new StringBuffer("handleExitIcon -- exitIconHandling result: ").append(turnListElement.exitIconId).append(", ").append("headlineIcon status: ").append(this.overlaysDataCollector.trafficLightIconVisibility).append(", ").append(" headlineIcon content: ").append(this.overlaysDataCollector.headlineIcon).toString());
    }

    private IconDescriptor getResourceExitIcon(TurnListElement turnListElement) {
        String string = turnListElement.getExitNumber();
        if (string == null) {
            string = "";
        }
        return ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForExitIcon(turnListElement.exitIconId, string.length(), 0, this, new Object[]{new Integer(3), this.overlaysDataCollector});
    }

    private void createManeuverListElementNonControlledAccess(TurnListElement turnListElement) {
        this.logger.trace("createManeuverListElementNonControlledAccess");
        this.overlaysDataCollector.signPost = turnListElement.getSignPostInfo();
        int n = 0;
        int n2 = 1;
        this.createManeuverListElementCommon(turnListElement, n, n2);
    }

    private void createManeuverListElementCommon(TurnListElement turnListElement, int n, int n2) {
        this.extractAdditionalIcons(turnListElement);
        if (turnListElement.laneGuidance != null && turnListElement.laneGuidance.length > 0) {
            this.extractLaneGuidance(turnListElement, turnListElement.laneGuidance.length);
            this.overlaysDataCollector.type = n;
        } else {
            if (turnListElement.maneuver != null && turnListElement.maneuver.length > 0) {
                this.overlaysDataCollector.direction = turnListElement.maneuver[0].getDirection();
                this.overlaysDataCollector.mainElement = turnListElement.maneuver[0].getElement();
            }
            this.overlaysDataCollector.type = n2;
        }
    }

    private void extractLaneGuidance(TurnListElement turnListElement, int n) {
        this.logger.trace("extractLaneGuidance");
        this.overlaysDataCollector.laneDirections = new int[n];
        this.overlaysDataCollector.laneInfos = new int[n];
        this.overlaysDataCollector.laneMarkingsLeft = new int[n];
        this.overlaysDataCollector.laneMarkingsRight = new int[n];
        this.overlaysDataCollector.numberOfLanes = n;
        for (int i2 = 0; i2 < n; ++i2) {
            this.overlaysDataCollector.laneDirections[i2] = this.uTurnEnabled && turnListElement.laneGuidance[i2].laneDirection == this.uTurnLeftValue ? 180 : (this.uTurnEnabled && turnListElement.laneGuidance[i2].laneDirection == this.uTurnRightValue ? 181 : (8 - (turnListElement.laneGuidance[i2].laneDirection >> 5)) % 8 * 45);
            this.overlaysDataCollector.laneInfos[i2] = turnListElement.laneGuidance[i2].getGuidanceInfo();
            this.overlaysDataCollector.laneMarkingsLeft[i2] = turnListElement.laneGuidance[i2].getLaneMarkingLeft();
            this.overlaysDataCollector.laneMarkingsRight[i2] = turnListElement.laneGuidance[i2].getLaneMarkingRight();
        }
        this.overlaysDataCollector.laneGuidanceAvailableOverlays = n > 0;
    }

    private void extractAdditionalIcons(TurnListElement turnListElement) {
        this.logger.trace("extractAdditionalIcons");
        this.overlaysDataCollector.trafficLightIconVisibility = this.currentOverlay == 3;
        AdditionalTurnListIcon[] additionalTurnListIconArray = turnListElement.getAdditionalIcons();
        if (additionalTurnListIconArray != null && additionalTurnListIconArray.length > 0) {
            for (int i2 = 0; i2 < additionalTurnListIconArray.length; ++i2) {
                if (additionalTurnListIconArray[i2] == null) continue;
                int n = additionalTurnListIconArray[i2].getType();
                int n2 = additionalTurnListIconArray[i2].getIconId();
                this.extractAdditionalIconsSwitch(n, n2);
            }
        } else {
            this.logger.trace("-- ZERO ADDITIONAL ICONS!!");
        }
    }

    private void extractAdditionalIconsSwitch(int n, int n2) {
        this.logger.trace("extractAdditionalIconsSwitch");
        switch (n) {
            case 0: {
                this.logger.trace("Additional Icon: Undefined");
                break;
            }
            case 1: {
                this.overlaysDataCollector.colorIndicatorIcon = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForAdditionalTurnlistIcon(n2, n, -1, 0, this, new Object[]{new Integer(1), this.overlaysDataCollector});
                break;
            }
            case 2: {
                this.overlaysDataCollector.headlineIcon = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForAdditionalTurnlistIcon(n2, n, -1, 0, this, new Object[]{new Integer(2), this.overlaysDataCollector});
                this.overlaysDataCollector.trafficLightIconVisibility = this.currentOverlay == 3;
                this.logger.trace(new StringBuffer("extractAdditionalIconsSwitch -- trafficLightIconHandling result: ").append("headlineIcon: ").append(this.overlaysDataCollector.trafficLightIconVisibility).toString());
                break;
            }
            default: {
                this.logger.trace("Nothing found");
            }
        }
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        return null;
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        this.logger.trace("OverlaysTurnListHandler: handleIconCacheUpdate");
        if (object.getClass() == (array$Ljava$lang$Object == null ? (array$Ljava$lang$Object = OverlaysTurnListHandler.class$("[Ljava.lang.Object;")) : array$Ljava$lang$Object)) {
            Object[] objectArray = (Object[])object;
            int n = (Integer)objectArray[0];
            switch (n) {
                case 0: {
                    OverlaysDataCollector overlaysDataCollector = (OverlaysDataCollector)objectArray[1];
                    overlaysDataCollector.headlineIcon = resourceLocator;
                    break;
                }
                case 1: {
                    OverlaysDataCollector overlaysDataCollector = (OverlaysDataCollector)objectArray[1];
                    overlaysDataCollector.colorIndicatorIcon = resourceLocator;
                    break;
                }
                case 2: {
                    OverlaysDataCollector overlaysDataCollector = (OverlaysDataCollector)objectArray[1];
                    overlaysDataCollector.headlineIcon = resourceLocator;
                    break;
                }
                case 3: {
                    OverlaysDataCollector overlaysDataCollector = (OverlaysDataCollector)objectArray[1];
                    overlaysDataCollector.headlineIcon = resourceLocator;
                    break;
                }
            }
        }
    }

    private static int getSystemConstant(String string, int n) {
        String string2 = System.getProperty(string);
        if (string2 != null) {
            int n2 = Integer.parseInt(string2);
            return n2;
        }
        return n;
    }

    private static boolean getSystemConstantB(String string, boolean bl) {
        String string2 = System.getProperty(string);
        if (string2 != null) {
            boolean bl2 = Boolean.getBoolean(string2);
            return bl2;
        }
        return bl;
    }

    public void notifyOverlayDisplayed(int n) {
        this.currentOverlay = n;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

