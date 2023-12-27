/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink;

import de.vw.mib.asl.framework.api.persistence.AbstractSharedPersistable;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.util.BitField;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;

public final class TravelLinkPersistable
extends AbstractSharedPersistable {
    private static final int BYTES_IN_BITFIELD;
    private static final int BIT_FUEL_STATION_LIST_SORT_ORDER;
    private static final int BIT_FUEL_STATION_LIST_SORT_ORDER_LEN;
    private static final int BIT_WEATHER_TABULAR_VIEW_SELECTION;
    private static final int BIT_WEATHER_TABULAR_VIEW_SELECTION_LEN;
    private static final int BIT_WEATHER_MAPS_SELECTED_WEATHER_MAP;
    private static final int BIT_WEATHER_MAPS_SELECTED_WEATHER_MAP_LEN;
    private static final int BIT_LIST_SORT_ORDER_FOR_MOVIES_RESULT;
    private static final int BIT_LIST_SORT_ORDER_FOR_MOVIES_RESULT_LEN;
    private static final int BIT_LIST_SORT_ORDER_FOR_MOVIE_THEATER_RESULT;
    private static final int BIT_LIST_SORT_ORDER_FOR_MOVIE_THEATER_RESULT_LEN;
    private static final int BIT_LIST_SORT_ORDER_FOR_MOVIE_THEATER_SHOWTIMES;
    private static final int BIT_LIST_SORT_ORDER_FOR_MOVIE_THEATER_SHOWTIMES_LEN;
    private static final int BIT_FUEL_STATION_SEARCH_AREA;
    private static final int BIT_FUEL_STATION_SEARCH_AREA_LEN;
    private static final int BIT_SPORTS_SELECTED_CHANGE_LEAGUE_TYPE;
    private static final int BIT_SPORTS_SELECTED_CHANGE_LEAGUE_TYPE_LEN;
    private static final int BIT_FUEL_STATION_PREFERRED_FUEL_TYPE;
    private static final int BIT_FUEL_STATION_PREFERRED_FUEL_TYPE_LEN;
    private static final int BIT_MOVIE_THEATERS_SEARCH_AREA;
    private static final int BIT_MOVIE_THEATERS_SEARCH_AREA_LEN;
    private static final int BIT_MOVIES_SEARCH_AREA;
    private static final int BIT_MOVIES_SEARCH_AREA_LEN;
    private static final int BIT_LIST_TIMEFRAME_FOR_HEADTOHEAD_GAMES;
    private static final int BIT_LIST_TIMEFRAME_FOR_HEADTOHEAD_GAMES_LEN;
    private BitField bitField = new BitField(40);
    public static final int SPORTS_SELECTED_CHANGE_LEAGUE_DEFAULT_VALUE;
    public static final int SPORTS_SELECTED_CHANGE_LEAGUE_SPORTS_ID_DEFAULT_VALUE;
    public static final String SPORTS_SELECTED_CHANGE_LEAGUE_LEAGUE_NAME_DEFAULT_VALUE;
    private int sportsSelectedChangeLeague = -1;
    private int sportsSelectedChangeLeagueSportsId = 0;
    private String sportsSelectedChangeLeagueName = "";
    private int mainViewVisibleWidgetInAreaOne = 0;
    private int mainViewVisibleWidgetInAreaTwo = 0;
    private int preferredFuelTypeId = 0;
    private String preferredFuelTypeName = "Regular";
    private int fuelSubscribtion = 3;
    private int sportsSubscribtion = 3;
    private int cinemaSubscribtion = 3;
    private int weatherTabSubscribtion = 3;
    private int weatherGraphicalSubscribtion = 3;
    private int trafficSubscribtion = 3;
    private int audioSubscribtion = 0;
    public static final int DEFAULT_ZOOM_LEVEL;
    private int zoomLevelIcon = 15000;
    private int zoomLevelRadar = 15000;
    private int zoomLevelIsobar = 15000;

    public TravelLinkPersistable() {
        super(5023, 0);
        this.clear();
    }

    @Override
    public void clearUnknownValues(short s) {
    }

    @Override
    public void fromStreamInternal(PersistenceInputStream persistenceInputStream, short s) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - fromStreamInternal()").log();
            }
            byte[] byArray = new byte[5];
            for (int i2 = 0; i2 < 5; ++i2) {
                byArray[i2] = persistenceInputStream.readByte();
            }
            this.bitField = new BitField(byArray);
            this.sportsSelectedChangeLeague = persistenceInputStream.readInt();
            this.sportsSelectedChangeLeagueSportsId = persistenceInputStream.readInt();
            this.sportsSelectedChangeLeagueName = persistenceInputStream.readString();
            this.mainViewVisibleWidgetInAreaOne = persistenceInputStream.readByte();
            this.mainViewVisibleWidgetInAreaTwo = persistenceInputStream.readByte();
            this.preferredFuelTypeId = persistenceInputStream.readInt();
            this.preferredFuelTypeName = persistenceInputStream.readString();
            this.fuelSubscribtion = persistenceInputStream.readInt();
            this.sportsSubscribtion = persistenceInputStream.readInt();
            this.cinemaSubscribtion = persistenceInputStream.readInt();
            this.weatherTabSubscribtion = persistenceInputStream.readInt();
            this.weatherGraphicalSubscribtion = persistenceInputStream.readInt();
            this.trafficSubscribtion = persistenceInputStream.readInt();
            this.audioSubscribtion = persistenceInputStream.readInt();
            this.zoomLevelIcon = persistenceInputStream.readInt();
            this.zoomLevelRadar = persistenceInputStream.readInt();
            this.zoomLevelIsobar = persistenceInputStream.readInt();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            this.clear();
        }
    }

    @Override
    public void toStreamInternal(PersistenceOutputStream persistenceOutputStream) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - toStreamInternal()").log();
        }
        byte[] byArray = this.bitField.getBytes();
        for (int i2 = 0; i2 < 5; ++i2) {
            persistenceOutputStream.writeByte(byArray[i2]);
        }
        persistenceOutputStream.writeInt(this.sportsSelectedChangeLeague);
        persistenceOutputStream.writeInt(this.sportsSelectedChangeLeagueSportsId);
        persistenceOutputStream.writeString(this.sportsSelectedChangeLeagueName);
        persistenceOutputStream.writeByte(this.mainViewVisibleWidgetInAreaOne);
        persistenceOutputStream.writeByte(this.mainViewVisibleWidgetInAreaTwo);
        persistenceOutputStream.writeInt(this.preferredFuelTypeId);
        persistenceOutputStream.writeString(this.preferredFuelTypeName);
        persistenceOutputStream.writeInt(this.fuelSubscribtion);
        persistenceOutputStream.writeInt(this.sportsSubscribtion);
        persistenceOutputStream.writeInt(this.cinemaSubscribtion);
        persistenceOutputStream.writeInt(this.weatherTabSubscribtion);
        persistenceOutputStream.writeInt(this.weatherGraphicalSubscribtion);
        persistenceOutputStream.writeInt(this.trafficSubscribtion);
        persistenceOutputStream.writeInt(this.audioSubscribtion);
        persistenceOutputStream.writeInt(this.zoomLevelIcon);
        persistenceOutputStream.writeInt(this.zoomLevelRadar);
        persistenceOutputStream.writeInt(this.zoomLevelIsobar);
    }

    @Override
    public short[] getSupportedVersions() {
        return NO_SUPPORTED_VERSION;
    }

    @Override
    public short getVersion() {
        return 14;
    }

    @Override
    public void clear() {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - clear()").log();
        }
        this.bitField.set(0, 2, 2);
        this.bitField.set(2, 2, 0);
        this.bitField.set(4, 2, 0);
        this.bitField.set(6, 2, 2);
        this.bitField.set(8, 2, 1);
        this.bitField.set(10, 2, 1);
        this.bitField.set(12, 2, 0);
        this.bitField.set(14, 2, 3);
        this.bitField.set(16, 3, 0);
        this.bitField.set(19, 2, 0);
        this.bitField.set(21, 2, 0);
        this.bitField.set(23, 2, 1);
        this.sportsSelectedChangeLeague = -1;
        this.sportsSelectedChangeLeagueSportsId = 0;
        this.sportsSelectedChangeLeagueName = "";
        this.mainViewVisibleWidgetInAreaOne = 0;
        this.mainViewVisibleWidgetInAreaTwo = 0;
        this.preferredFuelTypeId = 0;
        this.preferredFuelTypeName = "Regular";
        this.fuelSubscribtion = 3;
        this.sportsSubscribtion = 3;
        this.cinemaSubscribtion = 3;
        this.weatherTabSubscribtion = 3;
        this.weatherGraphicalSubscribtion = 3;
        this.trafficSubscribtion = 3;
        this.audioSubscribtion = 0;
        this.zoomLevelIcon = 15000;
        this.zoomLevelRadar = 15000;
        this.zoomLevelIsobar = 15000;
    }

    public void setFuelStationListSortOrder(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - setFuelStationListSortOrder(").append(n).append(")").log();
        }
        if (n >= 0 && n <= 2) {
            this.bitField.set(0, 2, n);
        } else {
            this.bitField.set(0, 2, 2);
        }
        this.markDirty(true);
    }

    public int getFuelStationListSortOrder() {
        return this.bitField.get(0, 2);
    }

    public void setWeatherTabularViewSelection(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - setWeatherTabularViewSelection(").append(n).append(")").log();
        }
        if (n >= 0 && n <= 2) {
            this.bitField.set(2, 2, n);
        } else {
            this.bitField.set(2, 2, 0);
        }
        this.markDirty(true);
    }

    public int getWeatherTabularViewSelection() {
        return this.bitField.get(2, 2);
    }

    public void setSelectedWeatherMap(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - setSelectedWeatherMap(").append(n).append(")").log();
        }
        if (n >= 0 && n <= 2) {
            this.bitField.set(4, 2, n);
        } else {
            this.bitField.set(4, 2, 0);
        }
        this.markDirty(true);
    }

    public int getSelectedWeatherMap() {
        return this.bitField.get(4, 2);
    }

    public void setListSortOrderForMoviesResult(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - setListSortOrderForMoviesResult(").append(n).append(")").log();
        }
        if (n >= 0 && n <= 2) {
            this.bitField.set(6, 2, n);
        } else {
            this.bitField.set(6, 2, 2);
        }
        this.markDirty(true);
    }

    public int getListSortOrderForMoviesResult() {
        return this.bitField.get(6, 2);
    }

    public void setListSortOrderForMovieTheaterResult(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - setListSortOrderForMovieTheaterResult(").append(n).append(")").log();
        }
        if (n >= 0 && n <= 1) {
            this.bitField.set(8, 2, n);
        } else {
            this.bitField.set(8, 2, 1);
        }
        this.markDirty(true);
    }

    public int getListSortOrderForMovieTheaterResult() {
        return this.bitField.get(8, 2);
    }

    public void setListSortOrderForMovieTheaterShowTimes(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - setListSortOrderForMovieTheaterShowTimes(").append(n).append(")").log();
        }
        if (n >= 0 && n <= 1) {
            this.bitField.set(10, 2, n);
        } else {
            this.bitField.set(10, 2, 1);
        }
        this.markDirty(true);
    }

    public int getListSortOrderForMovieTheaterShowTimes() {
        return this.bitField.get(10, 2);
    }

    public void setFuelStationSearchArea(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - setFuelStationSearchArea(").append(n).append(")").log();
        }
        if (n >= 0 && n <= 2) {
            this.bitField.set(12, 2, n);
        } else {
            this.bitField.set(12, 2, 0);
        }
        this.markDirty(true);
    }

    public int getFuelStationSearchArea() {
        return this.bitField.get(12, 2);
    }

    public void setPreferredFuelTypeId(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - setPreferredFuelType(").append(n).append(")").log();
        }
        this.preferredFuelTypeId = n;
        this.markDirty(true);
    }

    public int getPreferredFuelTypeId() {
        return this.preferredFuelTypeId;
    }

    public void setPreferredFuelTypeName(String string) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - setPreferredFuelTypeName(").append(string).append(")").log();
        }
        this.preferredFuelTypeName = null == string ? "" : string;
        this.markDirty(true);
    }

    public String getPreferredFuelTypeName() {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - getPreferredFuelTypeName() : ").append(this.preferredFuelTypeName).log();
        }
        if (null == this.preferredFuelTypeName) {
            return "";
        }
        return this.preferredFuelTypeName;
    }

    public int getSportsSelectedChangeLeagueType() {
        return this.bitField.get(14, 2);
    }

    public void setSportsSelectedChangeLeagueType(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - setSportsSelectedChangeLeagueType(").append(n).append(")").log();
        }
        if (n >= 0 && n <= 2) {
            this.bitField.set(14, 2, n);
        } else {
            this.bitField.set(14, 2, 3);
        }
        this.markDirty(true);
    }

    public void setMovieTheatersSearchArea(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - setMovieTheatersSearchArea(").append(n).append(")").log();
        }
        if (n >= 0 && n <= 2) {
            this.bitField.set(19, 2, n);
        } else {
            this.bitField.set(19, 2, 0);
        }
        this.markDirty(true);
    }

    public int getMovieTheatersSearchArea() {
        return this.bitField.get(19, 2);
    }

    public void setMoviesSearchArea(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - setMoviesSearchArea(").append(n).append(")").log();
        }
        if (n >= 0 && n <= 2) {
            this.bitField.set(21, 2, n);
        } else {
            this.bitField.set(21, 2, 0);
        }
        this.markDirty(true);
    }

    public int getMoviesSearchArea() {
        return this.bitField.get(21, 2);
    }

    public void setListTimeFrameForHeadToHeadGames(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - setListTimeFrameForHeadToHeadGames(").append(n).append(")").log();
        }
        if (n >= 0 && n <= 2) {
            this.bitField.set(23, 2, n);
        } else {
            this.bitField.set(23, 2, 1);
        }
        this.markDirty(true);
    }

    public int getListTimeframeForHeadToHeadGames() {
        return this.bitField.get(23, 2);
    }

    public int getSportsSelectedChangeLeague() {
        return this.sportsSelectedChangeLeague;
    }

    public void setSportsSelectedChangeLeague(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - setSportsSelectedChangeLeague(").append(n).append(")").log();
        }
        this.sportsSelectedChangeLeague = n;
        this.markDirty(true);
    }

    public int getSportsSelectedChangeLeagueSportsId() {
        return this.sportsSelectedChangeLeagueSportsId;
    }

    public void setSportsSelectedChangeLeagueSportsId(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - setSportsSelectedChangeLeagueSportsId(").append(n).append(")").log();
        }
        this.sportsSelectedChangeLeagueSportsId = n;
        this.markDirty(true);
    }

    public String getSportsSelectedChangeLeagueName() {
        return this.sportsSelectedChangeLeagueName;
    }

    public void setSportsSelectedChangeLeagueName(String string) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - setSportsSelectedChangeLeagueName(").append(string).append(")").log();
        }
        this.sportsSelectedChangeLeagueName = null == string ? "" : string;
        this.markDirty(true);
    }

    public int getMainViewVisibleWidgetInAreaOne() {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - getMainViewVisibleWidgetInAreaOne(").append(this.mainViewVisibleWidgetInAreaOne).append(")").log();
        }
        if (this.mainViewVisibleWidgetInAreaOne >= 0 && this.mainViewVisibleWidgetInAreaOne <= 4) {
            return this.mainViewVisibleWidgetInAreaOne;
        }
        return 0;
    }

    public int getMainViewVisibleWidgetInAreaTwo() {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - getMainViewVisibleWidgetInAreaTwo(").append(this.mainViewVisibleWidgetInAreaTwo).append(")").log();
        }
        if (this.mainViewVisibleWidgetInAreaTwo >= 0 && this.mainViewVisibleWidgetInAreaTwo <= 4) {
            return this.mainViewVisibleWidgetInAreaTwo;
        }
        return 0;
    }

    public void setMainViewVisibleWidgetInAreaOne(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - setMainViewVisibleWidgetInAreaOne(").append(n).append(")").log();
        }
        if (n >= 0 && n <= 4) {
            this.mainViewVisibleWidgetInAreaOne = n;
        } else if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append(" The widget position for widget area 1 is out of range - ").append(n).log();
        }
        this.markDirty(true);
    }

    public void setMainViewVisibleWidgetInAreaTwo(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - setMainViewVisibleWidgetInAreaTwo(").append(n).append(")").log();
        }
        if (n >= 0 && n <= 4) {
            this.mainViewVisibleWidgetInAreaTwo = n;
        } else if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append(" The widget position for widget area 2 is out of range - ").append(n).log();
        }
        this.markDirty(true);
    }

    public int getFuelSubscribtion() {
        return this.fuelSubscribtion;
    }

    public int getSportsSubscribtion() {
        return this.sportsSubscribtion;
    }

    public int getWeatherTabSubscribtion() {
        return this.weatherTabSubscribtion;
    }

    public int getWeatherGraphicalSubscribtion() {
        return this.weatherGraphicalSubscribtion;
    }

    public int getTrafficSubscribtion() {
        return this.trafficSubscribtion;
    }

    public void setFuelSubscribtion(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - setFuelSubscribtion(").append(n).append(")").log();
        }
        if (n >= 0 && n <= 3) {
            this.fuelSubscribtion = n;
        } else {
            ServiceManager.logger2.error(2).append("Fuel susbcription is out of range. So, Fuel subscription is not presisted.  Expected range 0 - 3. Received subscription - ").append(n).log();
        }
        this.markDirty(true);
    }

    public void setSportsSubscribtion(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - setSportsSubscribtion(").append(n).append(")").log();
        }
        if (n >= 0 && n <= 3) {
            this.sportsSubscribtion = n;
        } else {
            ServiceManager.logger2.error(2).append("Sports susbcription is out of range. So, Sports subscription is not presisted.  Expected range 0 - 3. Received subscription - ").append(n).log();
        }
        this.markDirty(true);
    }

    public void setWeatherTabSubscribtion(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - setWeatherTabSubscribtion(").append(n).append(")").log();
        }
        if (n >= 0 && n <= 3) {
            this.weatherTabSubscribtion = n;
        } else {
            ServiceManager.logger2.error(2).append("Tabular weather susbcription is out of range. So, Tabular weather subscription is not presisted.  Expected range 0 - 3. Received subscription - ").append(n).log();
        }
        this.markDirty(true);
    }

    public void setWeatherGraphicalSubscribtion(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - setWeatherGraphicalSubscribtion(").append(n).append(")").log();
        }
        if (n >= 0 && n <= 3) {
            this.weatherGraphicalSubscribtion = n;
        } else {
            ServiceManager.logger2.error(2).append(" Graphical weather susbcription is out of range. So, Graphical weather subscription is not presisted.  Expected range 0 - 3. Received subscription - ").append(n).log();
        }
        this.markDirty(true);
    }

    public void setTrafficSubscribtion(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - setTrafficSubscribtion(").append(n).append(")").log();
        }
        if (n >= 0 && n <= 3) {
            this.trafficSubscribtion = n;
        } else {
            ServiceManager.logger2.error(2).append(" Traffic susbcription is out of range. So, Traffic subscription is not presisted.  Expected range 0 - 3. Received subscription - ").append(n).log();
        }
        this.markDirty(true);
    }

    public int getCinemaSubscribtion() {
        return this.cinemaSubscribtion;
    }

    public void setCinemaSubscribtion(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - setCinemaSubscribtion(").append(n).append(")").log();
        }
        if (n >= 0 && n <= 3) {
            this.cinemaSubscribtion = n;
        } else {
            ServiceManager.logger2.error(2).append(" Cinema susbcription is out of range. So cinema subscription is not presisted. Expected range 0 - 3. Received subscription- ").append(n).log();
        }
        this.markDirty(true);
    }

    public int getAudioSubscribtion() {
        return this.audioSubscribtion;
    }

    public void setAudioSubscribtion(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - setAudioSubscribtion(").append(n).append(")").log();
        }
        if (n >= 0 && n <= 4) {
            this.audioSubscribtion = n;
        } else {
            ServiceManager.logger2.error(2).append(" Audio susbcription is out of range. So audio subscription is not presisted. Expected range 0 - 4. Received subscription- ").append(n).log();
        }
        this.markDirty(true);
    }

    public int getZoomLevel() {
        int n = 15000;
        int n2 = this.getSelectedWeatherMap();
        if (n2 == 0) {
            n = this.zoomLevelIcon;
        } else if (n2 == 1) {
            n = this.zoomLevelRadar;
        } else if (n2 == 2) {
            n = this.zoomLevelIsobar;
        }
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - getZoomLevel() : ").append(n).log();
        }
        return n;
    }

    public void setZoomLevel(int n) {
        int n2;
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("TravelLinkPersistable - setZoomLevel( ").append(n).append(" )").log();
        }
        if (17 == (n2 = TLinkServiceManager.getServiceManager().getCurrentViewId())) {
            int n3 = this.getSelectedWeatherMap();
            if (n3 == 0) {
                this.zoomLevelIcon = n;
            } else if (n3 == 1) {
                this.zoomLevelRadar = n;
            } else if (n3 == 2) {
                this.zoomLevelIsobar = n;
            }
            this.markDirty(true);
        }
    }
}

