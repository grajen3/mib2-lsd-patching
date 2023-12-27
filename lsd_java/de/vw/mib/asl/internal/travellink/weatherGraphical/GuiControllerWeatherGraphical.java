/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.weatherGraphical;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapConfiguration;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.GuiControllerCommon;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkWeatherIsobarMapClickResultDetailsCollector;
import org.dsi.ifc.travellink.GenericPropertyContainer;
import org.dsi.ifc.travellink.TravelLinkDate;

public final class GuiControllerWeatherGraphical
implements GuiControllerCommon {
    @Override
    public void setSubscriptionState(int n) {
        if (ServiceManager.logger2.isTraceEnabled(128)) {
            ServiceManager.logger2.trace(64).append("TL <WEATHER_GRAPHICAL> ").append("GuiControllerWeatherGraphical - setSubscriptionState(").append(n).append(")").log();
        }
        if (n == 2) {
            ServiceManager.aslPropertyManager.valueChangedInteger(4153, 1);
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(4153, 0);
        }
    }

    public void setSelectedWeatherMap(int n) {
        if (n >= 0 && n <= 2) {
            ServiceManager.aslPropertyManager.valueChangedInteger(4175, n);
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(4175, 0);
        }
    }

    public void prepareAndUpdateDataForStorm(GenericPropertyContainer[] genericPropertyContainerArray) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.trace(64).append("GuiControllerWeatherGraphical - prepareAndUpdateDataForStorm()").log();
            }
            Object[] objectArray = new TravelLinkWeatherIsobarMapClickResultDetailsCollector[]{new TravelLinkWeatherIsobarMapClickResultDetailsCollector()};
            if (genericPropertyContainerArray != null && genericPropertyContainerArray.length > 0 && genericPropertyContainerArray[0] != null) {
                int n;
                int n2 = GenericPropertyUtility.getInt(-635697664, 0, genericPropertyContainerArray[0]);
                if (n2 >= 0 && n2 <= 11) {
                    objectArray[0].travellink_weather_isobar_map_click_result_details__storm_type = n2;
                } else {
                    objectArray[0].travellink_weather_isobar_map_click_result_details__storm_type = 0;
                    if (ServiceManager.logger2.isTraceEnabled(64)) {
                        ServiceManager.logger2.error(64).append("Storm Type not in range. Expected values are from 0 to 11. But the received value is ").append(n2).log();
                    }
                }
                String string = GenericPropertyUtility.getString(-652474880, 0, genericPropertyContainerArray[0]);
                objectArray[0].travellink_weather_isobar_map_click_result_details__name = string.equals("") ? "--" : string;
                double d2 = GenericPropertyUtility.getDouble(-518257152, 0, genericPropertyContainerArray[0]);
                double d3 = GenericPropertyUtility.getDouble(-501479936, 0, genericPropertyContainerArray[0]);
                objectArray[0].travellink_weather_isobar_map_click_result_details__location_as_string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedLocation(d2, d3, true);
                objectArray[0].travellink_weather_isobar_map_click_result_details__moving_direction = GenericPropertyUtility.getInt(-602143232, 0, genericPropertyContainerArray[0]);
                float f2 = GenericPropertyUtility.getFloat(-618920448, 0, genericPropertyContainerArray[0]);
                objectArray[0].travellink_weather_isobar_map_click_result_details__speed = (int)Math.ceil(f2);
                objectArray[0].travellink_weather_isobar_map_click_result_details__speed_string = new StringBuffer().append(TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedStromSpeed(f2, true)).append(TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedSpeedUnit()).toString();
                ((TravelLinkWeatherIsobarMapClickResultDetailsCollector)objectArray[0]).travellink_weather_isobar_map_click_result_details__min_pressure = n = GenericPropertyUtility.getInt(-585366016, 0, genericPropertyContainerArray[0]);
                ((TravelLinkWeatherIsobarMapClickResultDetailsCollector)objectArray[0]).travellink_weather_isobar_map_click_result_details__min_pressure_string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedPressure(n, true);
                float f3 = GenericPropertyUtility.getFloat(-568588800, 0, genericPropertyContainerArray[0]);
                ((TravelLinkWeatherIsobarMapClickResultDetailsCollector)objectArray[0]).travellink_weather_isobar_map_click_result_details__max_sustained = (int)Math.ceil(f3);
                ((TravelLinkWeatherIsobarMapClickResultDetailsCollector)objectArray[0]).travellink_weather_isobar_map_click_result_details__max_sustained_string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedMaximumSustainedWind(f3, true);
                TravelLinkDate travelLinkDate = GenericPropertyUtility.getDate(-551811584, 0, genericPropertyContainerArray[0]);
                ((TravelLinkWeatherIsobarMapClickResultDetailsCollector)objectArray[0]).travellink_weather_isobar_map_click_result_details__last_tracked_date = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedDate(travelLinkDate.getDay(), travelLinkDate.getMonth(), travelLinkDate.getYear());
                ((TravelLinkWeatherIsobarMapClickResultDetailsCollector)objectArray[0]).travellink_weather_isobar_map_click_result_details__last_tracked_time = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedTime(travelLinkDate.getHour(), travelLinkDate.getMinute());
                ((TravelLinkWeatherIsobarMapClickResultDetailsCollector)objectArray[0]).travellink_weather_isobar_map_click_result_details__last_tracked_time_zone = GenericPropertyUtility.getString(-535034368, 0, genericPropertyContainerArray[0]);
            } else {
                objectArray[0].travellink_weather_isobar_map_click_result_details__location_as_string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedLocation(-9999.0, -9999.0, false);
                objectArray[0].travellink_weather_isobar_map_click_result_details__storm_type = 0;
                objectArray[0].travellink_weather_isobar_map_click_result_details__name = "--";
                objectArray[0].travellink_weather_isobar_map_click_result_details__location_invalid = true;
                objectArray[0].travellink_weather_isobar_map_click_result_details__location_latitude_degree = 0;
                objectArray[0].travellink_weather_isobar_map_click_result_details__location_latitude_second = 0;
                objectArray[0].travellink_weather_isobar_map_click_result_details__location_latitude_minute = 0;
                objectArray[0].travellink_weather_isobar_map_click_result_details__moving_direction = 0;
                objectArray[0].travellink_weather_isobar_map_click_result_details__speed = -9999;
                objectArray[0].travellink_weather_isobar_map_click_result_details__speed_string = new StringBuffer().append(TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedStromSpeed(3939526, false)).append(TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedSpeedUnit()).toString();
                objectArray[0].travellink_weather_isobar_map_click_result_details__min_pressure = 0;
                objectArray[0].travellink_weather_isobar_map_click_result_details__min_pressure_string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedPressure(-9999, false);
                objectArray[0].travellink_weather_isobar_map_click_result_details__max_sustained = 0;
                objectArray[0].travellink_weather_isobar_map_click_result_details__max_sustained_string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedMaximumSustainedWind(3939526, false);
                objectArray[0].travellink_weather_isobar_map_click_result_details__last_tracked_date = "--";
                objectArray[0].travellink_weather_isobar_map_click_result_details__last_tracked_time = "--";
                objectArray[0].travellink_weather_isobar_map_click_result_details__last_tracked_time_zone = "--";
            }
            ListManager.getGenericASLList(-1942019328).updateList(objectArray);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateNavigationLoadingStatus(boolean bl, boolean bl2) {
        if (!bl || bl2) {
            // empty if block
        }
        if (!bl && ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.warn(64).append("Navigation service is not ready !").log();
        }
        if (bl2 && ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.warn(64).append("Navigation is in error state !").log();
        }
    }

    public void updateNavigationLoadingStatus(boolean bl) {
        if (bl) {
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.trace(64).append(" Navigation is loading !").log();
            }
        } else if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.trace(64).append(" Finished loading Navigation ! So, Map can be shown").log();
        }
    }

    public void showMap() {
        if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.trace(64).append("GuiControllerWeatherGraphical - Finished loading Navigation ! So, Map can be shown").log();
        }
    }

    public void updateZoomLevel(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            int n2 = TLinkServiceManager.getServiceManager().getCurrentViewId();
            int n3 = TLinkServiceManager.getServiceManager().getWeatherGraphical().getSelectedWeatherMap();
            if (n2 == 17 || n2 == 18 || n2 == 21) {
                if (n3 == 0) {
                    if (n > 15000) {
                        TLinkServiceManager.getServiceManager().getWeatherGraphical().setWeatherIconMapZoomInBlocked(false);
                        if (ServiceManager.logger2.isTraceEnabled(64)) {
                            ServiceManager.logger2.trace(64).append("GuiControllerWeatherGraphical : updateZoomLevel :  Icon map zoom is NOT blocked ").log();
                        }
                    } else if (n < 15000) {
                        if (n2 == 17) {
                            boolean bl = TLinkServiceManager.getServiceManager().getWeatherGraphical().isUnblockZoomInForRouteOverview();
                            if (bl) {
                                if (ServiceManager.logger2.isTraceEnabled(64)) {
                                    ServiceManager.logger2.trace(64).append("GuiControllerWeatherGraphical : updateZoomLevel :  Icon map zoom is not blocked due to Route overview active ").log();
                                }
                            } else {
                                ASLNavigationMapConfiguration aSLNavigationMapConfiguration = TLinkServiceManager.getServiceManager().getAslNavigationMapConfigurationFullView();
                                aSLNavigationMapConfiguration.setZoomLevel(15000);
                                TLinkServiceManager.getServiceManager().getWeatherGraphical().setWeatherIconMapZoomInBlocked(true);
                                TLinkServiceManager.getServiceManager().getApiNavigation().setMapConfiguration(aSLNavigationMapConfiguration);
                                if (ServiceManager.logger2.isTraceEnabled(64)) {
                                    ServiceManager.logger2.trace(64).append("GuiControllerWeatherGraphical : updateZoomLevel :  Icon map zoom is blocked ").log();
                                    ServiceManager.logger2.trace(64).append("GuiControllerWeatherGraphical : updateZoomLevel :  Zoom level is below the minimum zoom level.  So, Minimum zoom level will be set explicitly.  ").log();
                                }
                            }
                        } else if (n2 == 18) {
                            ASLNavigationMapConfiguration aSLNavigationMapConfiguration = TLinkServiceManager.getServiceManager().getAslNavigationMapConfigurationWeatherMapSplitView();
                            aSLNavigationMapConfiguration.setZoomLevel(15000);
                            TLinkServiceManager.getServiceManager().getWeatherGraphical().setWeatherIconMapZoomInBlocked(true);
                            TLinkServiceManager.getServiceManager().getApiNavigation().setMapConfiguration(aSLNavigationMapConfiguration);
                            if (ServiceManager.logger2.isTraceEnabled(64)) {
                                ServiceManager.logger2.trace(64).append("GuiControllerWeatherGraphical : updateZoomLevel :  Icon map details zoom is blocked ").log();
                                ServiceManager.logger2.trace(64).append("GuiControllerWeatherGraphical : updateZoomLevel :  Zoom level is below the minimum zoom level.  So, Minimum zoom level will be set explicitly.  ").log();
                            }
                        } else if (n2 == 21) {
                            ASLNavigationMapConfiguration aSLNavigationMapConfiguration = TLinkServiceManager.getServiceManager().getAslNavigationMapConfigurationWeatherMapSplitView();
                            aSLNavigationMapConfiguration.setZoomLevel(-1601830656);
                            TLinkServiceManager.getServiceManager().getWeatherGraphical().setWeatherIconMapZoomInBlocked(true);
                            TLinkServiceManager.getServiceManager().getApiNavigation().setMapConfiguration(aSLNavigationMapConfiguration);
                            if (ServiceManager.logger2.isTraceEnabled(64)) {
                                ServiceManager.logger2.trace(64).append("GuiControllerWeatherGraphical : updateZoomLevel :  Isobar map details zoom is blocked ").log();
                                ServiceManager.logger2.trace(64).append("GuiControllerWeatherGraphical : updateZoomLevel :  Zoom level is below the minimum zoom level.  So, Minimum zoom level will be set explicitly.  ").log();
                            }
                        }
                    } else {
                        TLinkServiceManager.getServiceManager().getWeatherGraphical().setWeatherIconMapZoomInBlocked(true);
                        if (ServiceManager.logger2.isTraceEnabled(64)) {
                            ServiceManager.logger2.trace(64).append("GuiControllerWeatherGraphical : updateZoomLevel :  Icon map zoom is blocked ").log();
                        }
                    }
                } else if (n3 == 1) {
                    if (n > -1601830656) {
                        TLinkServiceManager.getServiceManager().getWeatherGraphical().setWeatherRadarMapZoomInBlocked(false);
                        if (ServiceManager.logger2.isTraceEnabled(64)) {
                            ServiceManager.logger2.trace(64).append("GuiControllerWeatherGraphical : updateZoomLevel :  Radar map zoom is NOT blocked ").log();
                        }
                    } else if (n < -1601830656) {
                        boolean bl = TLinkServiceManager.getServiceManager().getWeatherGraphical().isUnblockZoomInForRouteOverview();
                        if (bl) {
                            if (ServiceManager.logger2.isTraceEnabled(64)) {
                                ServiceManager.logger2.trace(64).append("GuiControllerWeatherGraphical : updateZoomLevel :  Radar map zoom is not blocked due to Route overview active ").log();
                            }
                        } else {
                            ASLNavigationMapConfiguration aSLNavigationMapConfiguration = TLinkServiceManager.getServiceManager().getAslNavigationMapConfigurationFullView();
                            aSLNavigationMapConfiguration.setZoomLevel(-1601830656);
                            TLinkServiceManager.getServiceManager().getWeatherGraphical().setWeatherRadarMapZoomInBlocked(true);
                            TLinkServiceManager.getServiceManager().getApiNavigation().setMapConfiguration(aSLNavigationMapConfiguration);
                            if (ServiceManager.logger2.isTraceEnabled(64)) {
                                ServiceManager.logger2.trace(64).append("GuiControllerWeatherGraphical : updateZoomLevel :  Zoom level is below the minimum zoom level.  So, Minimum zoom level will be set explicitly.  ").log();
                                ServiceManager.logger2.trace(64).append("GuiControllerWeatherGraphical : updateZoomLevel :  Radar map zoom is blocked ").log();
                            }
                        }
                    } else {
                        TLinkServiceManager.getServiceManager().getWeatherGraphical().setWeatherRadarMapZoomInBlocked(true);
                        if (ServiceManager.logger2.isTraceEnabled(64)) {
                            ServiceManager.logger2.trace(64).append("GuiControllerWeatherGraphical : updateZoomLevel :  Radar map zoom is blocked ").log();
                        }
                    }
                } else if (n3 == 2) {
                    if (n > -1601830656) {
                        TLinkServiceManager.getServiceManager().getWeatherGraphical().setWeatherIsobarMapZoomInBlocked(false);
                        if (ServiceManager.logger2.isTraceEnabled(64)) {
                            ServiceManager.logger2.trace(64).append("GuiControllerWeatherGraphical : updateZoomLevel :  Isobar map zoom is NOT blocked ").log();
                        }
                    } else if (n < -1601830656) {
                        boolean bl = TLinkServiceManager.getServiceManager().getWeatherGraphical().isUnblockZoomInForRouteOverview();
                        if (bl) {
                            if (ServiceManager.logger2.isTraceEnabled(64)) {
                                ServiceManager.logger2.trace(64).append("GuiControllerWeatherGraphical : updateZoomLevel :  Isobar map zoom is not blocked due to Route overview active ").log();
                            }
                        } else {
                            ASLNavigationMapConfiguration aSLNavigationMapConfiguration = null;
                            aSLNavigationMapConfiguration = n2 == 21 ? TLinkServiceManager.getServiceManager().getAslNavigationMapConfigurationWeatherMapSplitView() : TLinkServiceManager.getServiceManager().getAslNavigationMapConfigurationFullView();
                            aSLNavigationMapConfiguration.setZoomLevel(-1601830656);
                            TLinkServiceManager.getServiceManager().getWeatherGraphical().setWeatherIsobarMapZoomInBlocked(true);
                            TLinkServiceManager.getServiceManager().getApiNavigation().setMapConfiguration(aSLNavigationMapConfiguration);
                            if (ServiceManager.logger2.isTraceEnabled(64)) {
                                ServiceManager.logger2.trace(64).append("GuiControllerWeatherGraphical : updateZoomLevel :  Zoom level is below the minimum zoom level.  So, Minimum zoom level will be set explicitly.  ").log();
                                ServiceManager.logger2.trace(64).append("GuiControllerWeatherGraphical : updateZoomLevel :  Isobar map zoom is blocked ").log();
                            }
                        }
                    } else {
                        TLinkServiceManager.getServiceManager().getWeatherGraphical().setWeatherIsobarMapZoomInBlocked(true);
                        if (ServiceManager.logger2.isTraceEnabled(64)) {
                            ServiceManager.logger2.trace(64).append("GuiControllerWeatherGraphical : updateZoomLevel :  Isobar map zoom is blocked ").log();
                        }
                    }
                }
                TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setZoomLevel(n);
                ServiceManager.aslPropertyManager.valueChangedInteger(4177, n);
            }
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.trace(64).append(" Zoom level is updated to ... ").append(n).log();
            }
        }
        catch (GenericEventException genericEventException) {
            ServiceManager.errorHandler.handleError(genericEventException);
        }
    }

    public void updateRouteGuidance() {
        try {
            boolean bl = TLinkServiceManager.getServiceManager().getApiNavigation().isRouteGuidanceActive();
            ServiceManager.aslPropertyManager.valueChangedBoolean(-1807801600, bl);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void enableCcpButton(boolean bl) {
        try {
            ServiceManager.aslPropertyManager.valueChangedBoolean(71312128, bl);
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.trace(64).append("GuiControllerWeatherGraphical : enableCcpButton : CCP button enabled -  ").append(bl).log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}

