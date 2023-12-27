/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.weather;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.DataProcessor;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import org.dsi.ifc.travellink.GenericPropertyContainer;
import org.dsi.ifc.travellink.TravelLinkDate;

public final class Weather
implements DataProcessor {
    public static final int SETUP_WEATHER_ENTERED;
    public static final int SETUP_SKI_ENTERED;
    public static final int SETUP_ENTRY_UNKNOWN;
    private int setupEntry = 0;
    public static final int WEATHER_STATION_INVALID_ID;
    public static final boolean WEATHER_STATION_NEARBY;
    public static final boolean WEATHER_STATION_NOT_NEARBY;
    private long weatherStationId = -1L;
    public static final int LENGTH_OF_DATA_FOR_WEATHER_FORECAST;
    public static final int WEATHER_STATION_REQUESTED_UNKNOWN;
    public static final int WEATHER_STATION_REQUESTED_NEARBY;
    public static final int WEATHER_STATION_REQUESTED_WEATHERSTATIONID;
    private int weatherStationRequested = 0;
    public static final boolean SHOW_NEARESTWEATHERSTATIONPOPUP_TRUE;
    public static final boolean SHOW_NEARESTWEATHERSTATIONPOPUP_FALSE;
    private boolean showNearestWeatherStationPopup = false;
    public static final int NEARBYAVAILABLE_UNKNOWN;
    public static final int NEARBYAVAILABLE_TRUE;
    public static final int NEARBYAVAILABLE_FALSE;
    private int nearByAvailable = 0;
    private int responseStatusNearBy = 3;
    private long nearByWeatherStationId = -1L;
    private long selectedWeatherStationIdToDelete = -1L;
    private TravelLinkDate todayDate = new TravelLinkDate();
    private int sessionIdForRequestWeatherForecast = -1;

    @Override
    public void processAndUpdate(int n, GenericPropertyContainer[] genericPropertyContainerArray, int n2, int n3) {
        switch (n) {
            case 43: {
                this.setResponseStatusNearBy(n2);
                TLinkServiceManager.getServiceManager().getGuiControllerWeather().updateWeatherForecastStatus(n2);
                if (n2 == 3) {
                    this.setNearByAvailable(2);
                    break;
                }
                this.setNearByAvailable(1);
                TLinkServiceManager.getServiceManager().getDatapool().put(43, genericPropertyContainerArray);
                if (1 != this.getWeatherStationRequested()) break;
                this.setNearByWeatherStationId(genericPropertyContainerArray, n3);
                TLinkServiceManager.getServiceManager().getGuiControllerWeather().updateWeatherForecast(genericPropertyContainerArray);
                break;
            }
            case 44: {
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.trace(64).append("<-- Received - REQUESTTYPE_TL_WEATHER_FORECAST - ").log();
                }
                TLinkServiceManager.getServiceManager().getDatapool().put(44, genericPropertyContainerArray);
                if (2 != this.getWeatherStationRequested()) break;
                TLinkServiceManager.getServiceManager().getGuiControllerWeather().updateWeatherForecast(genericPropertyContainerArray);
                break;
            }
            case 18: {
                TLinkServiceManager.getServiceManager().getGuiControllerWeather().updateWeatherFavoriteCityList(genericPropertyContainerArray);
                break;
            }
            case 22: {
                TLinkServiceManager.getServiceManager().getGuiControllerWeather().updateAddFavoriteWeatherStationStatus(genericPropertyContainerArray, n2);
                break;
            }
            case 21: {
                TLinkServiceManager.getServiceManager().getDsiTravelLinkWeatherAdapter().requestFavoriteCityList();
                TLinkServiceManager.getServiceManager().getGuiControllerWeather().updateDeleteFavoriteWeatherStationStatus(genericPropertyContainerArray, n2);
                break;
            }
            case 19: {
                TLinkServiceManager.getServiceManager().getGuiControllerWeather().updateStateListForWeather(genericPropertyContainerArray);
                break;
            }
            case 20: {
                TLinkServiceManager.getServiceManager().getGuiControllerWeather().updateWeatherStationList(genericPropertyContainerArray);
                TLinkServiceManager.getServiceManager().getGuiControllerWeather().updateWeatherSetupStationList(genericPropertyContainerArray);
                break;
            }
            default: {
                if (!ServiceManager.logger2.isTraceEnabled(64)) break;
                ServiceManager.logger2.error(64).append("Weather : processAndUpdate : RequestType is not handled. RequestTypeID --> ").append(n).log();
            }
        }
    }

    public int getSetupEntry() {
        return this.setupEntry;
    }

    public void setSetupEntry(int n) {
        this.setupEntry = n;
    }

    public long getSelectedWeatherStationId() {
        return this.weatherStationId;
    }

    public void setSelectedWeatherStationId(long l) {
        this.weatherStationId = l;
    }

    public int getWeatherStationRequested() {
        return this.weatherStationRequested;
    }

    public void setWeatherStationRequested(int n) {
        this.weatherStationRequested = n;
    }

    public boolean getNearestWeatherStationPopupShown() {
        return this.showNearestWeatherStationPopup;
    }

    public void setNearestWeatherStationPopupShown(boolean bl) {
        this.showNearestWeatherStationPopup = bl;
    }

    public int getNearByAvailable() {
        return this.nearByAvailable;
    }

    public void setNearByAvailable(int n) {
        this.nearByAvailable = n;
    }

    public void checkAndUpdateNearAvailableStationToGui() {
        if (1 == this.getNearByAvailable()) {
            TLinkServiceManager.getServiceManager().getGuiControllerWeather().updateWeatherForecastStatus(this.getResponseStatusNearBy());
            GenericPropertyContainer[] genericPropertyContainerArray = TLinkServiceManager.getServiceManager().getDatapool().get(43);
            if (genericPropertyContainerArray != null && genericPropertyContainerArray.length > 0 && genericPropertyContainerArray[0] != null) {
                if (1 == this.getWeatherStationRequested()) {
                    TLinkServiceManager.getServiceManager().getGuiControllerWeather().updateWeatherForecast(genericPropertyContainerArray);
                }
            } else if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.error(64).append("Weather : checkAndUpdateNearAvailable : NearByAvailable flag is true. But not data is available ! ").log();
            }
        } else if (2 == this.getNearByAvailable()) {
            TLinkServiceManager.getServiceManager().getGuiControllerWeather().updateWeatherForecastStatus(this.getResponseStatusNearBy());
        } else if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.trace(64).append("Weather : checkAndUpdateNearAvailable : HMI waiting to receive the nearby weather station data  !").log();
        }
    }

    public int getResponseStatusNearBy() {
        return this.responseStatusNearBy;
    }

    public void setResponseStatusNearBy(int n) {
        this.responseStatusNearBy = n;
    }

    public void setNearByWeatherStationId(GenericPropertyContainer[] genericPropertyContainerArray, int n) {
        try {
            if (null != genericPropertyContainerArray && genericPropertyContainerArray.length > 0 && null != genericPropertyContainerArray[0]) {
                this.nearByWeatherStationId = GenericPropertyUtility.getLong(-1776679424, 0, genericPropertyContainerArray[0]);
                if (n == this.getSessionIdForRequestWeatherForecast()) {
                    if (this.nearByWeatherStationId > -1L) {
                        this.setSelectedWeatherStationId(this.nearByWeatherStationId);
                    }
                    this.setSessionIdForRequestWeatherForecast(-1);
                }
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.trace(64).append("Weather : setNearByWeatherStationId( final GenericPropertyContainer[] containerArray ) : ").append(this.nearByWeatherStationId).log();
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public long getNearByWeatherStationId() {
        if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.trace(64).append("Weather : getNearByWeatherStationId() : ").append(this.nearByWeatherStationId).log();
        }
        return this.nearByWeatherStationId;
    }

    public long getSelectedWeatherStationIdToDelete() {
        return this.selectedWeatherStationIdToDelete;
    }

    public void setSelectedWeatherStationIdToDelete(long l) {
        this.selectedWeatherStationIdToDelete = l;
    }

    public void upateWeatherForecast() {
        if (1 == this.getWeatherStationRequested()) {
            GenericPropertyContainer[] genericPropertyContainerArray = TLinkServiceManager.getServiceManager().getDatapool().get(43);
            TLinkServiceManager.getServiceManager().getGuiControllerWeather().updateWeatherForecast(genericPropertyContainerArray);
        } else {
            GenericPropertyContainer[] genericPropertyContainerArray = TLinkServiceManager.getServiceManager().getDatapool().get(44);
            TLinkServiceManager.getServiceManager().getGuiControllerWeather().updateWeatherForecast(genericPropertyContainerArray);
        }
    }

    public TravelLinkDate getTodayDate() {
        return this.todayDate;
    }

    public void setTodayDate(TravelLinkDate travelLinkDate) {
        this.todayDate = travelLinkDate;
    }

    public int getSessionIdForRequestWeatherForecast() {
        return this.sessionIdForRequestWeatherForecast;
    }

    public void setSessionIdForRequestWeatherForecast(int n) {
        this.sessionIdForRequestWeatherForecast = n;
    }
}

