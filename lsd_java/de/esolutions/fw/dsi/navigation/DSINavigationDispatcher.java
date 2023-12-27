/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.navigation;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.navigation.DSINavigationReply;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.BapManeuverDescriptor;
import org.dsi.ifc.navigation.BapTurnToInfo;
import org.dsi.ifc.navigation.Brand;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.Category;
import org.dsi.ifc.navigation.CountryInfo;
import org.dsi.ifc.navigation.DSINavigationListener;
import org.dsi.ifc.navigation.DirectionToWaypoint;
import org.dsi.ifc.navigation.DistanceToNextManeuver;
import org.dsi.ifc.navigation.LDListElement;
import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIStateHistoryEntry;
import org.dsi.ifc.navigation.LIStreetHistoryEntry;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.NavDataBase;
import org.dsi.ifc.navigation.NavLaneGuidanceData;
import org.dsi.ifc.navigation.NavNextWayPointInfo;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.NavRmRouteListArrayData;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.NavTraceListData;
import org.dsi.ifc.navigation.NavTraceMemoryUtilization;
import org.dsi.ifc.navigation.NavVersionInfo;
import org.dsi.ifc.navigation.PoiExtendedInfo;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.PosTimeInfo;
import org.dsi.ifc.navigation.RRListElement;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.RgRouteCostChangeInformation;
import org.dsi.ifc.navigation.RgTurnToInfo;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.navigation.RouteProperties;
import org.dsi.ifc.navigation.RrdCalculationInfo;
import org.dsi.ifc.navigation.ThesaurusHistoryEntry;
import org.dsi.ifc.navigation.TourImportStatus;
import org.dsi.ifc.navigation.TryBestMatchResultData;
import org.dsi.ifc.navigation.TryMatchLocationResultData;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.navigation.ValueListStatus;
import org.dsi.ifc.navigation.ViaPointListElement;

public class DSINavigationDispatcher
extends AbstractDispatcher
implements DSINavigationReply {
    private DSINavigationReplyService service = new DSINavigationReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSINavigationDispatcher(int n) {
        super(n, (class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = DSINavigationDispatcher.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateAfaMode(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(1, dSINavigationListener);
                    dSINavigationListener.updateAfaMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateAfaMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAfaSpeaking(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(2, dSINavigationListener);
                    dSINavigationListener.updateAfaSpeaking(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateAfaSpeaking(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateEtcDemoModeState(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(4, dSINavigationListener);
                    dSINavigationListener.updateEtcDemoModeState(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateEtcDemoModeState(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateEtcLanguageLoadProgress(long l, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(5, dSINavigationListener);
                    dSINavigationListener.updateEtcLanguageLoadProgress(l, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateEtcLanguageLoadProgress(l, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateEtcLanguageLoadStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(6, dSINavigationListener);
                    dSINavigationListener.updateEtcLanguageLoadStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateEtcLanguageLoadStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateEtcMetricSystem(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(7, dSINavigationListener);
                    dSINavigationListener.updateEtcMetricSystem(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateEtcMetricSystem(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDmLastDestinationsList(LDListElement[] lDListElementArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(8, dSINavigationListener);
                    dSINavigationListener.updateDmLastDestinationsList(lDListElementArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateDmLastDestinationsList(lDListElementArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDmRecentRoutesList(RRListElement[] rRListElementArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(9, dSINavigationListener);
                    dSINavigationListener.updateDmRecentRoutesList(rRListElementArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateDmRecentRoutesList(rRListElementArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateLispIsSpellerActive(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(10, dSINavigationListener);
                    dSINavigationListener.updateLispIsSpellerActive(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateLispIsSpellerActive(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRgActive(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(11, dSINavigationListener);
                    dSINavigationListener.updateRgActive(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRgActive(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(75);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(75, dSINavigationListener);
                    dSINavigationListener.updateRgInfoForNextDestination(rgInfoForNextDestination, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(75);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRgInfoForNextDestination(rgInfoForNextDestination, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRgCurrentRoute(Route route, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(13, dSINavigationListener);
                    dSINavigationListener.updateRgCurrentRoute(route, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRgCurrentRoute(route, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRgCurrentRouteOptions(RouteOptions routeOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(14, dSINavigationListener);
                    dSINavigationListener.updateRgCurrentRouteOptions(routeOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRgCurrentRouteOptions(routeOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRgLaneGuidance(NavLaneGuidanceData[] navLaneGuidanceDataArray, boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(64);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(64, dSINavigationListener);
                    dSINavigationListener.updateRgLaneGuidance(navLaneGuidanceDataArray, bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(64);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRgLaneGuidance(navLaneGuidanceDataArray, bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRgTurnToStreet(String string, boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(21, dSINavigationListener);
                    dSINavigationListener.updateRgTurnToStreet(string, bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRgTurnToStreet(string, bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRgUnfulfilledRouteOptions(RouteOptions routeOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(22, dSINavigationListener);
                    dSINavigationListener.updateRgUnfulfilledRouteOptions(routeOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRgUnfulfilledRouteOptions(routeOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(23, dSINavigationListener);
                    dSINavigationListener.updateRgDestinationInfo(navRouteListDataArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRgDestinationInfo(navRouteListDataArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRgStreetList(NavRouteListData[] navRouteListDataArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(24, dSINavigationListener);
                    dSINavigationListener.updateRgStreetList(navRouteListDataArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRgStreetList(navRouteListDataArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRgPoiInfo(NavPoiInfo[] navPoiInfoArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(25, dSINavigationListener);
                    dSINavigationListener.updateRgPoiInfo(navPoiInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRgPoiInfo(navPoiInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void rgException(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.rgException(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRgRouteProperties(RouteProperties routeProperties, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(77);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(77, dSINavigationListener);
                    dSINavigationListener.updateRgRouteProperties(routeProperties, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(77);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRgRouteProperties(routeProperties, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSoPosPosition(PosPosition posPosition, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(28, dSINavigationListener);
                    dSINavigationListener.updateSoPosPosition(posPosition, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateSoPosPosition(posPosition, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSoPosPositionDescription(NavLocation navLocation, boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(29);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(29, dSINavigationListener);
                    dSINavigationListener.updateSoPosPositionDescription(navLocation, bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(29);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateSoPosPositionDescription(navLocation, bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSoPosTimeInformation(PosTimeInfo posTimeInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(97);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(97, dSINavigationListener);
                    dSINavigationListener.updateSoPosTimeInformation(posTimeInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(97);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateSoPosTimeInformation(posTimeInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRrdActive(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(31, dSINavigationListener);
                    dSINavigationListener.updateRrdActive(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRrdActive(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRrdCalculationInfo(RrdCalculationInfo[] rrdCalculationInfoArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(32, dSINavigationListener);
                    dSINavigationListener.updateRrdCalculationInfo(rrdCalculationInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRrdCalculationInfo(rrdCalculationInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateEtcVersionInfo(NavVersionInfo navVersionInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(34);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(34, dSINavigationListener);
                    dSINavigationListener.updateEtcVersionInfo(navVersionInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(34);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateEtcVersionInfo(navVersionInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateEtcAvailableNavDataBases(NavDataBase[] navDataBaseArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(81);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(81, dSINavigationListener);
                    dSINavigationListener.updateEtcAvailableNavDataBases(navDataBaseArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(81);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateEtcAvailableNavDataBases(navDataBaseArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBapManeuverDescriptor(BapManeuverDescriptor[] bapManeuverDescriptorArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(76);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(76, dSINavigationListener);
                    dSINavigationListener.updateBapManeuverDescriptor(bapManeuverDescriptorArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(76);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateBapManeuverDescriptor(bapManeuverDescriptorArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBapTurnToInfo(BapTurnToInfo[] bapTurnToInfoArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(85);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(85, dSINavigationListener);
                    dSINavigationListener.updateBapTurnToInfo(bapTurnToInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(85);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateBapTurnToInfo(bapTurnToInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRgiString(short[] sArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(86);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(86, dSINavigationListener);
                    dSINavigationListener.updateRgiString(sArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(86);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRgiString(sArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRgDetailedStreetList(NavRouteListData[] navRouteListDataArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(37);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(37, dSINavigationListener);
                    dSINavigationListener.updateRgDetailedStreetList(navRouteListDataArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(37);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRgDetailedStreetList(navRouteListDataArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRmPersistentRoute(Route route, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(38);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(38, dSINavigationListener);
                    dSINavigationListener.updateRmPersistentRoute(route, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(38);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRmPersistentRoute(route, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRgTimeAfaToDestination(long l, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(39);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(39, dSINavigationListener);
                    dSINavigationListener.updateRgTimeAfaToDestination(l, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(39);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRgTimeAfaToDestination(l, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void etcSensorDataReplayRoute(Route route) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.etcSensorDataReplayRoute(route);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void etcSensorDataReplayGuidance(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.etcSensorDataReplayGuidance(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(42);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(42, dSINavigationListener);
                    dSINavigationListener.updateRgCalculatedRoutes(calculatedRouteListElementArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(42);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRgCalculatedRoutes(calculatedRouteListElementArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRgRouteCostChangeInformation(RgRouteCostChangeInformation rgRouteCostChangeInformation, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(43);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(43, dSINavigationListener);
                    dSINavigationListener.updateRgRouteCostChangeInformation(rgRouteCostChangeInformation, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(43);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRgRouteCostChangeInformation(rgRouteCostChangeInformation, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTrMemoryUtilization(NavTraceMemoryUtilization navTraceMemoryUtilization, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(45);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(45, dSINavigationListener);
                    dSINavigationListener.updateTrMemoryUtilization(navTraceMemoryUtilization, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(45);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateTrMemoryUtilization(navTraceMemoryUtilization, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTrOperatingMode(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(46);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(46, dSINavigationListener);
                    dSINavigationListener.updateTrOperatingMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(46);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateTrOperatingMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTrTraceList(NavTraceListData[] navTraceListDataArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(47);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(47, dSINavigationListener);
                    dSINavigationListener.updateTrTraceList(navTraceListDataArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(47);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateTrTraceList(navTraceListDataArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRmRouteList(NavRmRouteListArrayData[] navRmRouteListArrayDataArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(48);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(48, dSINavigationListener);
                    dSINavigationListener.updateRmRouteList(navRmRouteListArrayDataArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(48);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRmRouteList(navRmRouteListArrayDataArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRgRouteCalculationState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(49);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(49, dSINavigationListener);
                    dSINavigationListener.updateRgRouteCalculationState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(49);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRgRouteCalculationState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNavstateOfOperation(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(52);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(52, dSINavigationListener);
                    dSINavigationListener.updateNavstateOfOperation(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(52);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateNavstateOfOperation(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNavMedia(String[] stringArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(53);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(53, dSINavigationListener);
                    dSINavigationListener.updateNavMedia(stringArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(53);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateNavMedia(stringArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRgTurnList(TurnListElement[] turnListElementArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(54);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(54, dSINavigationListener);
                    dSINavigationListener.updateRgTurnList(turnListElementArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(54);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRgTurnList(turnListElementArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAvailableLanguages(String[] stringArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(55);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(55, dSINavigationListener);
                    dSINavigationListener.updateAvailableLanguages(stringArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(55);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateAvailableLanguages(stringArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateLanguage(String string, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(56);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(56, dSINavigationListener);
                    dSINavigationListener.updateLanguage(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(56);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateLanguage(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDistanceToNextManeuver(DistanceToNextManeuver distanceToNextManeuver, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(57);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(57, dSINavigationListener);
                    dSINavigationListener.updateDistanceToNextManeuver(distanceToNextManeuver, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(57);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateDistanceToNextManeuver(distanceToNextManeuver, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateEtcCurrentNavDataBase(NavDataBase navDataBase, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(78);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(78, dSINavigationListener);
                    dSINavigationListener.updateEtcCurrentNavDataBase(navDataBase, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(78);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateEtcCurrentNavDataBase(navDataBase, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTrDirectionToWaypoint(DirectionToWaypoint directionToWaypoint, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(61);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(61, dSINavigationListener);
                    dSINavigationListener.updateTrDirectionToWaypoint(directionToWaypoint, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(61);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateTrDirectionToWaypoint(directionToWaypoint, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePoiSubstringSearchStatus(ValueListStatus valueListStatus, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(62);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(62, dSINavigationListener);
                    dSINavigationListener.updatePoiSubstringSearchStatus(valueListStatus, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(62);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updatePoiSubstringSearchStatus(valueListStatus, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTrRecordingState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(63);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(63, dSINavigationListener);
                    dSINavigationListener.updateTrRecordingState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(63);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateTrRecordingState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void rgSetRouteGuidanceModeResult() {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.rgSetRouteGuidanceModeResult();
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void dmLastDestinationsGetResult(long l, NavLocation navLocation) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.dmLastDestinationsGetResult(l, navLocation);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void dmRecentRoutesGetResult(long l, Route route) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.dmRecentRoutesGetResult(l, route);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void dmResult(long l, long l2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.dmResult(l, l2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void liGetStateResult(LISpellerData lISpellerData) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.liGetStateResult(lISpellerData);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void liResult(long l) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.liResult(l);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, int n4, long l) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.lispUpdateSpellerResult(string, n, bl, bl2, string2, n2, n3, bl3, bl4, n4, l);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void liCurrentState(NavLocation navLocation, int[] nArray, int[] nArray2, long l) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.liCurrentState(navLocation, nArray, nArray2, l);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void liValueList(LIValueList lIValueList, long l) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.liValueList(lIValueList, l);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void poiValueList(LIValueList lIValueList, long l) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.poiValueList(lIValueList, l);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void liGetLocationDescriptionTransformResult(NavLocation navLocation) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.liGetLocationDescriptionTransformResult(navLocation);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void rmMakeRoutePersistentResult(long l) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.rmMakeRoutePersistentResult(l);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void liTryBestMatchResult(TryBestMatchResultData[] tryBestMatchResultDataArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.liTryBestMatchResult(tryBestMatchResultDataArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void etcGetCountryAbbreviationResult(String string, long l) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.etcGetCountryAbbreviationResult(string, l);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void trStartTraceRecordingResult(int n, long l, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.trStartTraceRecordingResult(n, l, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void trStopTraceRecordingResult(int n, long l, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.trStopTraceRecordingResult(n, l, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void trStoreTraceResult(int n, NavSegmentID navSegmentID, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.trStoreTraceResult(n, navSegmentID, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void trRenameTraceResult(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.trRenameTraceResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void trDeleteTraceResult(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.trDeleteTraceResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void trDeleteAllTracesResult(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.trDeleteAllTracesResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void rmRouteAddResult(int n, long l) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.rmRouteAddResult(n, l);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void rmRouteDeleteResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.rmRouteDeleteResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void rmRouteDeleteAllResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.rmRouteDeleteAllResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void rmRouteGetResult(int n, Route route) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.rmRouteGetResult(n, route);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void rmRouteRenameResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.rmRouteRenameResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void createExportFileResult(int n, boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.createExportFileResult(n, bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void importFileResult(int n, boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.importFileResult(n, bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void languageSpellableCharactersResult(String string) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.languageSpellableCharactersResult(string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void rgNotPossible(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.rgNotPossible(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void translateRouteResult(Route route) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.translateRouteResult(route);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void locationToStreamResult(boolean bl, byte[] byArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.locationToStreamResult(bl, byArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void streamToLocationResult(boolean bl, NavLocation navLocation) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.streamToLocationResult(bl, navLocation);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void liValueListFileStatus(int n, int n2, String string) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.liValueListFileStatus(n, n2, string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void liValueListOutputMethod(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.liValueListOutputMethod(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDmFlagDestination(NavLocation navLocation, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(65);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(65, dSINavigationListener);
                    dSINavigationListener.updateDmFlagDestination(navLocation, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(65);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateDmFlagDestination(navLocation, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void liGetLastCityHistoryEntryResult(NavLocation navLocation, boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.liGetLastCityHistoryEntryResult(navLocation, bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void liGetLastStreetHistoryEntryResult(NavLocation navLocation, boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.liGetLastStreetHistoryEntryResult(navLocation, bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateLiCityHistory(LICityHistoryEntry[] lICityHistoryEntryArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(66);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(66, dSINavigationListener);
                    dSINavigationListener.updateLiCityHistory(lICityHistoryEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(66);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateLiCityHistory(lICityHistoryEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateLiCountryForCityAndStreetHistory(String string, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(67);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(67, dSINavigationListener);
                    dSINavigationListener.updateLiCountryForCityAndStreetHistory(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(67);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateLiCountryForCityAndStreetHistory(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void liLastCityAndStreetHistoryResult(long l) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.liLastCityAndStreetHistoryResult(l);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateLiStreetHistory(LIStreetHistoryEntry[] lIStreetHistoryEntryArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(68);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(68, dSINavigationListener);
                    dSINavigationListener.updateLiStreetHistory(lIStreetHistoryEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(68);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateLiStreetHistory(lIStreetHistoryEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateLiStateHistory(LIStateHistoryEntry[] lIStateHistoryEntryArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(93);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(93, dSINavigationListener);
                    dSINavigationListener.updateLiStateHistory(lIStateHistoryEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(93);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateLiStateHistory(lIStateHistoryEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void liHistoryResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.liHistoryResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void liGetLastStateHistoryEntryResult(NavLocation navLocation, boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.liGetLastStateHistoryEntryResult(navLocation, bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRgTurnListCalculationHorizon(long l, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(69);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(69, dSINavigationListener);
                    dSINavigationListener.updateRgTurnListCalculationHorizon(l, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(69);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRgTurnListCalculationHorizon(l, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRgPoiInfoCalculationHorizon(long l, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(70);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(70, dSINavigationListener);
                    dSINavigationListener.updateRgPoiInfoCalculationHorizon(l, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(70);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRgPoiInfoCalculationHorizon(l, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void soPosPositionDescriptionVehicleResult(NavLocation navLocation) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.soPosPositionDescriptionVehicleResult(navLocation);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void liStripLocationResult(NavLocation navLocation) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.liStripLocationResult(navLocation);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseAudioTrigger(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.responseAudioTrigger(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAudioRequest(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(82);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(82, dSINavigationListener);
                    dSINavigationListener.updateAudioRequest(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(82);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateAudioRequest(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void liSetCountryForCityAndStreetHistoryResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.liSetCountryForCityAndStreetHistoryResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void rgStartGuidanceCalculatedRouteResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.rgStartGuidanceCalculatedRouteResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void rgSwitchToNextPossibleRoadResult(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.rgSwitchToNextPossibleRoadResult(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void liThesaurusHistoryAddResult(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.liThesaurusHistoryAddResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void liThesaurusHistoryGetEntryResult(ThesaurusHistoryEntry thesaurusHistoryEntry, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.liThesaurusHistoryGetEntryResult(thesaurusHistoryEntry, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void liThesaurusHistoryDeleteResult(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.liThesaurusHistoryDeleteResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void liThesaurusHistoryDeleteAllResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.liThesaurusHistoryDeleteAllResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateLIThesaurusHistory(ThesaurusHistoryEntry[] thesaurusHistoryEntryArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(83);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(83, dSINavigationListener);
                    dSINavigationListener.updateLIThesaurusHistory(thesaurusHistoryEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(83);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateLIThesaurusHistory(thesaurusHistoryEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCountryInfo(CountryInfo[] countryInfoArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(84);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(84, dSINavigationListener);
                    dSINavigationListener.updateCountryInfo(countryInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(84);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateCountryInfo(countryInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void requestCountryInfoResult(CountryInfo countryInfo, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.requestCountryInfoResult(countryInfo, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void ehGetAllCategoriesResult(int n, Category[] categoryArray, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.ehGetAllCategoriesResult(n, categoryArray, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void ehGetAllBrandsOfCategoryResult(int n, int n2, Brand[] brandArray, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.ehGetAllBrandsOfCategoryResult(n, n2, brandArray, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void ehResult(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.ehResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setRemainingRangeOfVehicleResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.setRemainingRangeOfVehicleResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setVehicleConsumptionInfoResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.setVehicleConsumptionInfoResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setUserDefinedPOIsResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.setUserDefinedPOIsResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setTrailerStatusResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.setTrailerStatusResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void liGetViaPointListResult(int n, ViaPointListElement[] viaPointListElementArray, int n2, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.liGetViaPointListResult(n, viaPointListElementArray, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void liSelectViaPointResult(NavLocation navLocation, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.liSelectViaPointResult(navLocation, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateStyleDBPaths(String[] stringArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(87);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(87, dSINavigationListener);
                    dSINavigationListener.updateStyleDBPaths(stringArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(87);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateStyleDBPaths(stringArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRouteResumePossible(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(88);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(88, dSINavigationListener);
                    dSINavigationListener.updateRouteResumePossible(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(88);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRouteResumePossible(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void rgStartGuidanceCalculatedRouteByUIDResult(NavSegmentID navSegmentID, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.rgStartGuidanceCalculatedRouteByUIDResult(navSegmentID, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePOIsEnteringProximityRange(NavLocation[] navLocationArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(89);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(89, dSINavigationListener);
                    dSINavigationListener.updatePOIsEnteringProximityRange(navLocationArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(89);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updatePOIsEnteringProximityRange(navLocationArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void liGetSpellableCharactersResult(NavLocation navLocation, int n, String string, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.liGetSpellableCharactersResult(navLocation, n, string, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateEtcAvailablePersonalPOIDataBases(NavDataBase[] navDataBaseArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(91);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(91, dSINavigationListener);
                    dSINavigationListener.updateEtcAvailablePersonalPOIDataBases(navDataBaseArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(91);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateEtcAvailablePersonalPOIDataBases(navDataBaseArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePersonalPOISearchStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(92);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(92, dSINavigationListener);
                    dSINavigationListener.updatePersonalPOISearchStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(92);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updatePersonalPOISearchStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void deletePersonalPOIDataBasesResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.deletePersonalPOIDataBasesResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setVehicleFuelTypeResult(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.setVehicleFuelTypeResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void createNavLocationOfPOIUIDResult(long l, NavLocation navLocation, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.createNavLocationOfPOIUIDResult(l, navLocation, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void rmRouteReplaceResult(int n, long l, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.rmRouteReplaceResult(n, l, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setNavInternalDataToFactorySettingsResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.setNavInternalDataToFactorySettingsResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void liTryMatchLocationResult(TryMatchLocationResultData[] tryMatchLocationResultDataArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.liTryMatchLocationResult(tryMatchLocationResultDataArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNavDbRegionsState(int n, String[] stringArray, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(94);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(94, dSINavigationListener);
                    dSINavigationListener.updateNavDbRegionsState(n, stringArray, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(94);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateNavDbRegionsState(n, stringArray, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void trImportTrailsResult(NavSegmentID[] navSegmentIDArray, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.trImportTrailsResult(navSegmentIDArray, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void trExportTrailsResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.trExportTrailsResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTrInfoForNextWaypoint(NavNextWayPointInfo navNextWayPointInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(95);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(95, dSINavigationListener);
                    dSINavigationListener.updateTrInfoForNextWaypoint(navNextWayPointInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(95);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateTrInfoForNextWaypoint(navNextWayPointInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void rgStartRubberbandManipulationResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.rgStartRubberbandManipulationResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void rgGetRouteBoundingRectangleResult(NavRectangle navRectangle, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.rgGetRouteBoundingRectangleResult(navRectangle, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void rgGetLocationOnRouteResult(NavLocation navLocation, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.rgGetLocationOnRouteResult(navLocation, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void rgResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.rgResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void rgGetRubberBandPointPositionResult(NavLocationWgs84 navLocationWgs84, boolean bl, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.rgGetRubberBandPointPositionResult(navLocationWgs84, bl, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRgEnhancedSignPostInfoStatus(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(96);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(96, dSINavigationListener);
                    dSINavigationListener.updateRgEnhancedSignPostInfoStatus(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(96);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRgEnhancedSignPostInfoStatus(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void etcSetDemoModeResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.etcSetDemoModeResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void lispGetLocationFromLiValueListResult(int n, NavLocation navLocation) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.lispGetLocationFromLiValueListResult(n, navLocation);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void lispGetMatchingNVCResult(String string) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.lispGetMatchingNVCResult(string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void poiGetXt9LDBsResult(String[] stringArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.poiGetXt9LDBsResult(stringArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRgMotorwayInfo(NavPoiInfo[] navPoiInfoArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(99);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(99, dSINavigationListener);
                    dSINavigationListener.updateRgMotorwayInfo(navPoiInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(99);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRgMotorwayInfo(navPoiInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRgVirtualDestinationInfo(RgInfoForNextDestination rgInfoForNextDestination, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(98);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(98, dSINavigationListener);
                    dSINavigationListener.updateRgVirtualDestinationInfo(rgInfoForNextDestination, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(98);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRgVirtualDestinationInfo(rgInfoForNextDestination, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void rgTriggerRCCIUpdateResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.rgTriggerRCCIUpdateResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void liGetLocationDescriptionTransformNearByResult(NavLocation navLocation) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.liGetLocationDescriptionTransformNearByResult(navLocation);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRgTurnToInfo(RgTurnToInfo rgTurnToInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(100);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(100, dSINavigationListener);
                    dSINavigationListener.updateRgTurnToInfo(rgTurnToInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(100);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRgTurnToInfo(rgTurnToInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void etcGetPositionTimeInfoResult(PosTimeInfo posTimeInfo, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.etcGetPositionTimeInfoResult(posTimeInfo, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void poiGetCategoryTypesFromUIdResult(int[] nArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.poiGetCategoryTypesFromUIdResult(nArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRgPersistedRouteDataAvailable(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(101);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(101, dSINavigationListener);
                    dSINavigationListener.updateRgPersistedRouteDataAvailable(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(101);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRgPersistedRouteDataAvailable(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void liDisambiguateLocationResult(int[] nArray, NavLocation[] navLocationArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.liDisambiguateLocationResult(nArray, navLocationArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void triggerEventAudioMessageResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.triggerEventAudioMessageResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMapIntegrationState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(102);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(102, dSINavigationListener);
                    dSINavigationListener.updateMapIntegrationState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(102);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateMapIntegrationState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMapIntegrationProgress(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(103);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(103, dSINavigationListener);
                    dSINavigationListener.updateMapIntegrationProgress(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(103);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateMapIntegrationProgress(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void etcTriggerNavigationRestartResult(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.etcTriggerNavigationRestartResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void lispRequestNVCListResult(int n, String string, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.lispRequestNVCListResult(n, string, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBapManeuverState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(104);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(104, dSINavigationListener);
                    dSINavigationListener.updateBapManeuverState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(104);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateBapManeuverState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void rmImportToursFromGpxFileResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.rmImportToursFromGpxFileResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRmImportToursFromGpxFileStatus(TourImportStatus tourImportStatus, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(105);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(105, dSINavigationListener);
                    dSINavigationListener.updateRmImportToursFromGpxFileStatus(tourImportStatus, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(105);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateRmImportToursFromGpxFileStatus(tourImportStatus, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void importRouteFromGpxFileResult(NavLocation navLocation) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.importRouteFromGpxFileResult(navLocation);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBapManeuverInformation(BapManeuverDescriptor[] bapManeuverDescriptorArray, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(106);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(106, dSINavigationListener);
                    dSINavigationListener.updateBapManeuverInformation(bapManeuverDescriptorArray, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(106);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateBapManeuverInformation(bapManeuverDescriptorArray, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void poiRequestExtendedInfoResult(PoiExtendedInfo poiExtendedInfo, boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.poiRequestExtendedInfoResult(poiExtendedInfo, bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void trClearRecordedTraceCacheResult() {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.trClearRecordedTraceCacheResult();
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(107);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    this.confirmNotificationListener(107, dSINavigationListener);
                    dSINavigationListener.updateProfileState(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(107);
            while (iterator.hasNext()) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)iterator.next();
                    dSINavigationListener.updateProfileState(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void profileChanged(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.profileChanged(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.profileCopied(n, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void profileReset(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.profileReset(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void profileResetAll(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.profileResetAll(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    dSINavigationListener.asyncException(n, string, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void yyIndication(String string, String string2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINavigationListener dSINavigationListener = (DSINavigationListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSINavigationDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSINavigationDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSINavigationListener, new Object[]{string, string2});
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
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

