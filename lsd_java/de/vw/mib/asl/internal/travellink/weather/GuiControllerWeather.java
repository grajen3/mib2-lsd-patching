/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.weather;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.GuiControllerCommon;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkCurrentWeatherReportCollector;
import java.util.Arrays;
import java.util.Calendar;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.travellink.GenericPropertyContainer;
import org.dsi.ifc.travellink.TravelLinkDate;
import org.dsi.ifc.travellink.Values;

public final class GuiControllerWeather
implements GuiControllerCommon {
    public void updateSelectedWeatherTab(int n) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.trace(64).append("Updating Selected Weather Tab: ").append(n).log();
            }
            if (n >= 0 && n <= 2) {
                ServiceManager.aslPropertyManager.valueChangedInteger(2034180864, n);
            } else {
                ServiceManager.aslPropertyManager.valueChangedInteger(2034180864, 0);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public void setSubscriptionState(int n) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.trace(64).append("TL <WEATHER_TABULAR> ").append("GuiControllerWeather - setSubscriptionState(").append(n).append(")").log();
            }
            if (n == 2) {
                ServiceManager.aslPropertyManager.valueChangedInteger(4156, 1);
            } else if (n == 0) {
                ServiceManager.aslPropertyManager.valueChangedInteger(4156, 2);
            } else {
                ServiceManager.aslPropertyManager.valueChangedInteger(4156, 0);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateWeatherForecast(GenericPropertyContainer[] genericPropertyContainerArray) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.trace(64).append("GuiControllerWeather : updateWeatherForecast()").log();
            }
            if (genericPropertyContainerArray == null || genericPropertyContainerArray.length < 1) {
                GenericPropertyContainer[] genericPropertyContainerArray2 = new GenericPropertyContainer[10];
                for (int i2 = 0; i2 < genericPropertyContainerArray2.length; ++i2) {
                    genericPropertyContainerArray2[i2] = new GenericPropertyContainer();
                }
                ServiceManager.aslPropertyManager.valueChangedString(2118066944, "--");
                this.prepareAndUpdateDataForCurrentWeatherList(new GenericPropertyContainer[0]);
                this.prepareAndUpdateDataForDailyWeatherList(genericPropertyContainerArray2);
                this.prepareAndUpdateDataForHourlyWeatherList(genericPropertyContainerArray2);
            } else if (genericPropertyContainerArray != null && genericPropertyContainerArray.length == 10) {
                if (genericPropertyContainerArray[0] != null) {
                    String string = GenericPropertyUtility.getString(-1759902208, 0, genericPropertyContainerArray[0]);
                    String string2 = GenericPropertyUtility.getString(-1743124992, 0, genericPropertyContainerArray[0]);
                    String string3 = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedNamingRuleE(string, string2);
                    ServiceManager.aslPropertyManager.valueChangedString(2118066944, string3);
                }
                this.prepareAndUpdateDataForCurrentWeatherList(genericPropertyContainerArray);
                this.prepareAndUpdateDataForDailyWeatherList(genericPropertyContainerArray);
                this.prepareAndUpdateDataForHourlyWeatherList(genericPropertyContainerArray);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateWeatherForecastStatus(int n) {
        try {
            if (n == 3) {
                this.updateWeatherLoadingState(0);
                boolean bl = TLinkServiceManager.getServiceManager().getWeather().getNearestWeatherStationPopupShown();
                if (bl) {
                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1950294784);
                    TLinkServiceManager.getServiceManager().getWeather().setNearestWeatherStationPopupShown(false);
                }
            } else {
                this.updateWeatherLoadingState(2);
                boolean bl = TLinkServiceManager.getServiceManager().getWeather().getNearestWeatherStationPopupShown();
                if (bl) {
                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1933517568);
                    TLinkServiceManager.getServiceManager().getWeather().setNearestWeatherStationPopupShown(false);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateWeatherStationNameToPopup(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            Object[] objectArray = ListManager.getGenericASLList(4109).getDSIObjects();
            if (null == objectArray || objectArray.length < 1) {
                return;
            }
            GenericPropertyContainer[] genericPropertyContainerArray = (GenericPropertyContainer[])objectArray;
            if (null != genericPropertyContainerArray && n > -1 && n < genericPropertyContainerArray.length && null != genericPropertyContainerArray[n]) {
                String string = GenericPropertyUtility.getString(-1390737920, 0, genericPropertyContainerArray[n]);
                String string2 = GenericPropertyUtility.getString(-1373960704, 0, genericPropertyContainerArray[n]);
                String string3 = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedNamingRuleE(string, string2);
                long l = GenericPropertyUtility.getLong(-1407515136, 0, genericPropertyContainerArray[n]);
                TLinkServiceManager.getServiceManager().getWeather().setSelectedWeatherStationIdToDelete(l);
                ServiceManager.aslPropertyManager.valueChangedString(-297852160, string3);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private void prepareAndUpdateDataForCurrentWeatherList(GenericPropertyContainer[] genericPropertyContainerArray) {
        Object[] objectArray = new TravelLinkCurrentWeatherReportCollector[]{new TravelLinkCurrentWeatherReportCollector()};
        if (genericPropertyContainerArray != null && genericPropertyContainerArray.length > 0 && genericPropertyContainerArray[0] != null) {
            int n;
            TravelLinkDate travelLinkDate = GenericPropertyUtility.getDate(-1877342720, 0, genericPropertyContainerArray[0]);
            TravelLinkDate travelLinkDate2 = new TravelLinkDate(travelLinkDate.getYear(), travelLinkDate.getDay(), travelLinkDate.getMonth(), travelLinkDate.getHour(), travelLinkDate.getMinute(), travelLinkDate.getSecond());
            TLinkServiceManager.getServiceManager().getWeather().setTodayDate(travelLinkDate2);
            int n2 = GenericPropertyUtility.getInt(-2129000960, 0, genericPropertyContainerArray[0]);
            if (n2 >= 0 && n2 <= 6) {
                objectArray[0].travellink_current_weather_report__air_quality = n2;
            } else {
                objectArray[0].travellink_current_weather_report__air_quality = 6;
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.error(64).append("Air quality not in range. Expected values are from 0 to 6. But the received value is ").append(n2).log();
                }
            }
            int n3 = GenericPropertyUtility.getInt(-2112223744, 0, genericPropertyContainerArray[0]);
            if (n3 >= 0 && n3 <= 5) {
                objectArray[0].travellink_current_weather_report__cloud_cover = n3;
            } else {
                objectArray[0].travellink_current_weather_report__cloud_cover = 5;
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.error(64).append("Cloud cover not in range. Expected values are from 0 to 5. But the received value is ").append(n3).log();
                }
            }
            int n4 = GenericPropertyUtility.getInt(-2095446528, 0, genericPropertyContainerArray[0]);
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.trace(64).append("The value of the weather condition is ").append(n4).log();
            }
            if (n4 >= 0 && n4 <= 59) {
                objectArray[0].travellink_current_weather_report__condition = n4;
            } else {
                objectArray[0].travellink_current_weather_report__condition = 0;
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.error(64).append("Weather condition not in range. Expected values are from 0 to 59. But the received value is ").append(n4).log();
                }
            }
            int n5 = GenericPropertyUtility.getInt(-2078669312, 0, genericPropertyContainerArray[0]);
            int n6 = GenericPropertyUtility.getInt(-2061892096, 0, genericPropertyContainerArray[0]);
            objectArray[0].travellink_current_weather_report__humidity_as_string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedHumidity(n5, n6, true);
            int n7 = GenericPropertyUtility.getInt(-2011560448, 0, genericPropertyContainerArray[0]);
            ((TravelLinkCurrentWeatherReportCollector)objectArray[0]).travellink_current_weather_report__current_temp_as_string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedTemperature(n7, true);
            int n8 = GenericPropertyUtility.getInt(-1994783232, 0, genericPropertyContainerArray[0]);
            if (n8 >= 0 && n8 <= 3) {
                ((TravelLinkCurrentWeatherReportCollector)objectArray[0]).travellink_current_weather_report__pollen_count = n8;
            } else {
                ((TravelLinkCurrentWeatherReportCollector)objectArray[0]).travellink_current_weather_report__pollen_count = 3;
                ServiceManager.logger2.error(64).append("Pollen count enum not in range. Expected values are from 0 to 3. But the received value is ").append(n8).log();
            }
            int n9 = GenericPropertyUtility.getInt(-1810233856, 0, genericPropertyContainerArray[0]);
            ((TravelLinkCurrentWeatherReportCollector)objectArray[0]).travellink_current_weather_report__pollen_count_number = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedPollenCountLevel(n9, true);
            int n10 = GenericPropertyUtility.getInt(-1860565504, 0, genericPropertyContainerArray[0]);
            if (n10 >= 0 && n10 <= 3) {
                ((TravelLinkCurrentWeatherReportCollector)objectArray[0]).travellink_current_weather_report__precipitation_type = n10;
            } else {
                ((TravelLinkCurrentWeatherReportCollector)objectArray[0]).travellink_current_weather_report__precipitation_type = 3;
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.error(64).append("Precipitation not in range. Expected values are from 0 to 3. But the received value is ").append(n10).log();
                }
            }
            int n11 = GenericPropertyUtility.getInt(-1978006016, 0, genericPropertyContainerArray[0]);
            ((TravelLinkCurrentWeatherReportCollector)objectArray[0]).travellink_current_weather_report__precipitation_probability_as_string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedPrecipitationProbability(n11, true);
            float f2 = GenericPropertyUtility.getFloat(-1726347776, 0, genericPropertyContainerArray[0]);
            float f3 = GenericPropertyUtility.getFloat(-1709570560, 0, genericPropertyContainerArray[0]);
            ((TravelLinkCurrentWeatherReportCollector)objectArray[0]).travellink_current_weather_report__precipitation_range_as_string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedPrecipitationRange(f2, f3, true);
            int n12 = GenericPropertyUtility.getInt(-1927674368, 0, genericPropertyContainerArray[0]);
            if (n12 >= 0 && n12 <= 5) {
                ((TravelLinkCurrentWeatherReportCollector)objectArray[0]).travellink_current_weather_report__uv_risk = n12;
            } else {
                ((TravelLinkCurrentWeatherReportCollector)objectArray[0]).travellink_current_weather_report__uv_risk = 5;
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.error(64).append("UV risk not in range. Expected values are from 0 to 5. But the received value is ").append(n12).log();
                }
            }
            int n13 = GenericPropertyUtility.getInt(-1827011072, 0, genericPropertyContainerArray[0]);
            int n14 = GenericPropertyUtility.getInt(-1843788288, 0, genericPropertyContainerArray[0]);
            ((TravelLinkCurrentWeatherReportCollector)objectArray[0]).travellink_current_weather_report__uv_risk__min_max = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedUvIndex(n13, n14, true);
            int n15 = GenericPropertyUtility.getInt(-1910897152, 0, genericPropertyContainerArray[0]);
            if (n15 >= 0 && n15 <= 359) {
                n = TLinkServiceManager.getServiceManager().getCurrentViewId();
                if (18 == n || 17 == n) {
                    ServiceManager.aslPropertyManager.valueChangedBoolean(222307072, true);
                } else {
                    ServiceManager.aslPropertyManager.valueChangedBoolean(205529856, true);
                }
                ((TravelLinkCurrentWeatherReportCollector)objectArray[0]).travellink_current_weather_report__wind_direction = n15;
            } else {
                n = TLinkServiceManager.getServiceManager().getCurrentViewId();
                if (18 == n || 17 == n) {
                    ServiceManager.aslPropertyManager.valueChangedBoolean(222307072, false);
                } else {
                    ServiceManager.aslPropertyManager.valueChangedBoolean(205529856, false);
                }
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.trace(64).append("Wind direction not in range. Expected values are from 0 to 359. But the received value is ").append(n15).log();
                }
            }
            n = GenericPropertyUtility.getInt(-1894119936, 0, genericPropertyContainerArray[0]);
            ((TravelLinkCurrentWeatherReportCollector)objectArray[0]).travellink_current_weather_report__wind_speed_as_string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedSpeed(n, true);
            ((TravelLinkCurrentWeatherReportCollector)objectArray[0]).travellink_current_weather_report__wind_speed_unit_as_string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedSpeedUnit();
        } else {
            objectArray[0].travellink_current_weather_report__air_quality = 6;
            objectArray[0].travellink_current_weather_report__cloud_cover = 5;
            objectArray[0].travellink_current_weather_report__condition = 0;
            objectArray[0].travellink_current_weather_report__humidity_as_string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedHumidity(-9999, -9999, false);
            objectArray[0].travellink_current_weather_report__current_temp_as_string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedTemperature(-9999, false);
            objectArray[0].travellink_current_weather_report__pollen_count = 3;
            objectArray[0].travellink_current_weather_report__pollen_count_number = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedPollenCountLevel(-9999, false);
            objectArray[0].travellink_current_weather_report__precipitation_probability_as_string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedPrecipitationProbability(-9999, false);
            objectArray[0].travellink_current_weather_report__precipitation_range_as_string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedPrecipitationRange(3939526, 3939526, false);
            objectArray[0].travellink_current_weather_report__uv_risk = 5;
            objectArray[0].travellink_current_weather_report__uv_risk__min_max = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedUvIndex(-9999, -9999, false);
            objectArray[0].travellink_current_weather_report__wind_direction = 0;
            objectArray[0].travellink_current_weather_report__wind_speed_as_string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedSpeed(-9999, false);
            objectArray[0].travellink_current_weather_report__wind_speed_unit_as_string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedSpeedUnit();
            objectArray[0].travellink_current_weather_report__precipitation_type = 3;
        }
        ListManager.getGenericASLList(2134844160).updateList(objectArray);
    }

    private void prepareAndUpdateDataForHourlyWeatherList(GenericPropertyContainer[] genericPropertyContainerArray) {
        if (genericPropertyContainerArray != null && genericPropertyContainerArray[0] != null && genericPropertyContainerArray[1] != null && genericPropertyContainerArray[2] != null) {
            Object[] objectArray = new GenericPropertyContainer[]{GenericPropertyUtility.getCopy(genericPropertyContainerArray[0]), GenericPropertyUtility.getCopy(genericPropertyContainerArray[1]), GenericPropertyUtility.getCopy(genericPropertyContainerArray[2])};
            ListManager.getGenericASLList(-2143345920).updateList(objectArray);
            TLinkServiceManager.getServiceManager().getGuiControllerMain().updateMainViewWeatherWidget((GenericPropertyContainer)objectArray[1], (GenericPropertyContainer)objectArray[2]);
        } else if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.trace(64).append("TL <WEATHER_TABULAR> ").append("GuiController : prepareAndUpdateDataForHourlyWeatherList : containerArray element is  null  ").log();
        }
    }

    private void prepareAndUpdateDataForDailyWeatherList(GenericPropertyContainer[] genericPropertyContainerArray) {
        if (genericPropertyContainerArray != null && genericPropertyContainerArray[3] != null && genericPropertyContainerArray[4] != null && genericPropertyContainerArray[5] != null && genericPropertyContainerArray[6] != null && genericPropertyContainerArray[7] != null && genericPropertyContainerArray[8] != null && genericPropertyContainerArray[9] != null) {
            int n = 7;
            Object[] objectArray = new GenericPropertyContainer[7];
            TravelLinkDate travelLinkDate = TLinkServiceManager.getServiceManager().getWeather().getTodayDate();
            int n2 = travelLinkDate.getDay();
            int n3 = travelLinkDate.getMonth();
            short s = travelLinkDate.getYear();
            int n4 = 0;
            int n5 = 0;
            int n6 = 0;
            Calendar calendar = ASLSystemFactory.getSystemApi().getCurrentCalendar(0);
            calendar.set(s, n3 - 1, n2);
            for (int i2 = 0; i2 < 7; ++i2) {
                n3 = calendar.get(2) + 1;
                n2 = calendar.get(5);
                n4 = calendar.get(7);
                n5 = this.getGuiDayOfWeek(n4);
                n6 = this.getContainerArrayIndex(n4);
                if (genericPropertyContainerArray.length > n6) {
                    objectArray[i2] = GenericPropertyUtility.getCopy(genericPropertyContainerArray[n6]);
                    this.addDayMonthInfo((GenericPropertyContainer)objectArray[i2], n2, n3, n5);
                }
                calendar.add(6, 1);
            }
            this.updateToday((GenericPropertyContainer[])objectArray);
            ListManager.getGenericASLList(-2126568704).updateList(objectArray);
        } else if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.trace(64).append("TL <WEATHER_TABULAR> ").append("GuiController : prepareAndUpdateDataForDailyWeatherList : containerArray element is  null  ").log();
        }
    }

    public void updateToday(GenericPropertyContainer[] genericPropertyContainerArray) {
        try {
            boolean bl = false;
            if (genericPropertyContainerArray[0] != null) {
                GenericPropertyUtility.updateGPCWithValue(-2137614336, 7, genericPropertyContainerArray[0]);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public int getGuiDayOfWeek(int n) {
        switch (n) {
            case 1: {
                return 6;
            }
            case 2: {
                return 0;
            }
            case 3: {
                return 1;
            }
            case 4: {
                return 2;
            }
            case 5: {
                return 3;
            }
            case 6: {
                return 4;
            }
            case 7: {
                return 5;
            }
        }
        if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.error(64).append("Weather : getGuiDayOfWeek : returned default value 0 - Monday ").log();
        }
        return 0;
    }

    public int getContainerArrayIndex(int n) {
        switch (n) {
            case 1: {
                return 3;
            }
            case 2: {
                return 4;
            }
            case 3: {
                return 5;
            }
            case 4: {
                return 6;
            }
            case 5: {
                return 7;
            }
            case 6: {
                return 8;
            }
            case 7: {
                return 9;
            }
        }
        ServiceManager.logger2.error(64).append("Weather : getContainerArrayIndex : returned default value Constants.WEATHERFORECASTTIMEFRAME_MONDAY ").log();
        return 4;
    }

    public void addDayMonthInfo(GenericPropertyContainer genericPropertyContainer, int n, int n2, int n3) {
        int n4 = 3;
        int n5 = genericPropertyContainer.keys.length + n4;
        int[] nArray = new int[n5];
        nArray[n5 - 1] = -2104059904;
        nArray[n5 - 2] = -2120837120;
        nArray[n5 - 3] = -2137614336;
        Values[] valuesArray = new Values[n5];
        valuesArray[n5 - 1] = new Values();
        valuesArray[n5 - 1].valuesInt = new int[]{n2};
        valuesArray[n5 - 2] = new Values();
        valuesArray[n5 - 2].valuesInt = new int[]{n};
        valuesArray[n5 - 3] = new Values();
        valuesArray[n5 - 3].valuesInt = new int[]{n3};
        for (int i2 = 0; i2 < genericPropertyContainer.keys.length; ++i2) {
            nArray[i2] = genericPropertyContainer.keys[i2];
            valuesArray[i2] = new Values();
            if (genericPropertyContainer.values[i2] != null && genericPropertyContainer.values[i2].valuesInt != null && genericPropertyContainer.values[i2].valuesInt.length > 0) {
                valuesArray[i2].valuesInt = new int[]{genericPropertyContainer.values[i2].valuesInt[0]};
                continue;
            }
            if (genericPropertyContainer.values[i2] != null && genericPropertyContainer.values[i2].valuesString != null && genericPropertyContainer.values[i2].valuesString.length > 0) {
                valuesArray[i2].valuesString = new String[]{genericPropertyContainer.values[i2].valuesString[0]};
                continue;
            }
            if (genericPropertyContainer.values[i2] != null && genericPropertyContainer.values[i2].valuesBoolean != null && genericPropertyContainer.values[i2].valuesBoolean.length > 0) {
                valuesArray[i2].valuesBoolean = new boolean[]{genericPropertyContainer.values[i2].valuesBoolean[0]};
                continue;
            }
            if (genericPropertyContainer.values[i2] != null && genericPropertyContainer.values[i2].valuesDate != null && genericPropertyContainer.values[i2].valuesDate.length > 0) {
                valuesArray[i2].valuesDate = new TravelLinkDate[]{genericPropertyContainer.values[i2].valuesDate[0]};
                continue;
            }
            if (genericPropertyContainer.values[i2] != null && genericPropertyContainer.values[i2].valuesDouble != null && genericPropertyContainer.values[i2].valuesDouble.length > 0) {
                valuesArray[i2].valuesDouble = new double[]{genericPropertyContainer.values[i2].valuesDouble[0]};
                continue;
            }
            if (genericPropertyContainer.values[i2] != null && genericPropertyContainer.values[i2].valuesFloat != null && genericPropertyContainer.values[i2].valuesFloat.length > 0) {
                valuesArray[i2].valuesFloat = new float[]{genericPropertyContainer.values[i2].valuesFloat[0]};
                continue;
            }
            if (genericPropertyContainer.values[i2] != null && genericPropertyContainer.values[i2].valuesLong != null && genericPropertyContainer.values[i2].valuesLong.length > 0) {
                valuesArray[i2].valuesLong = new long[]{genericPropertyContainer.values[i2].valuesLong[0]};
                continue;
            }
            if (genericPropertyContainer.values[i2] == null || genericPropertyContainer.values[i2].valuesResourceLocator == null || genericPropertyContainer.values[i2].valuesResourceLocator.length <= 0) continue;
            valuesArray[i2].valuesResourceLocator = new ResourceLocator[]{genericPropertyContainer.values[i2].valuesResourceLocator[0]};
        }
        genericPropertyContainer.keys = nArray;
        genericPropertyContainer.values = valuesArray;
    }

    public void updateWeatherFavoriteCityList(GenericPropertyContainer[] genericPropertyContainerArray) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.trace(64).append("GuiControllerWeather : updateWeatherForecast()").log();
            }
            if (genericPropertyContainerArray == null || genericPropertyContainerArray.length < 1) {
                ListManager.getGenericASLList(4109).updateList(new GenericPropertyContainer[0]);
            } else {
                this.prepareAndUpdateWeatherFavoriteCityList(genericPropertyContainerArray);
                int n = genericPropertyContainerArray.length;
                if (n >= 20) {
                    ServiceManager.aslPropertyManager.valueChangedBoolean(-935386368, false);
                } else {
                    ServiceManager.aslPropertyManager.valueChangedBoolean(-935386368, true);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateAddFavoriteWeatherStationStatus(GenericPropertyContainer[] genericPropertyContainerArray, int n) {
        try {
            if (n == 14) {
                this.updateSetupAddFavoriteWeatherStationStatus(n);
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.trace(64).append("TL <WEATHER_TABULAR> ").append("GuiController : updateAddFavoriteWeatherStationStatus : Seleceted station is successfully added in to favorite ").log();
                }
            } else if (n == 15) {
                this.updateSetupAddFavoriteWeatherStationStatus(n);
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.trace(64).append("TL <WEATHER_TABULAR> ").append("GuiController : updateAddFavoriteWeatherStationStatus : Seleceted station is already exists in favorite ").log();
                }
            } else if (n == 12) {
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.error(64).append("TL <WEATHER_TABULAR> ").append("GuiController : updateAddFavoriteWeatherStationStatus : RESPONSESTATUS_ADD_REPOSITORY_IS_FULL").log();
                }
            } else if (n == 13) {
                this.updateSetupAddFavoriteWeatherStationStatus(n);
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.error(64).append("TL <WEATHER_TABULAR> ").append("GuiController : updateAddFavoriteWeatherStationStatus : Adding favorite weather station is unsuccessful ").log();
                }
            } else if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.error(64).append("TL <WEATHER_TABULAR> ").append("GuiController : updateAddFavoriteWeatherStationStatus : Adding favorite weather station is unknown ").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateDeleteFavoriteWeatherStationStatus(GenericPropertyContainer[] genericPropertyContainerArray, int n) {
        try {
            if (n == 11) {
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.info(64).append("TL <WEATHER_TABULAR> ").append("GuiController : updateDeleteFavoriteWeatherStationStatus : Seleceted station is successfully deleted from the favorite ").log();
                }
            } else if (n == 10) {
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.error(64).append("TL <WEATHER_TABULAR> ").append("GuiController : updateDeleteFavoriteWeatherStationStatus : Seleceted station is not deleted from the favorite ").log();
                }
            } else if (n == 9) {
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.error(64).append("TL <WEATHER_TABULAR> ").append("GuiController : updateDeleteFavoriteWeatherStationStatus : Seleceted station does not exists in the favorite ").log();
                }
            } else if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.error(64).append("TL <WEATHER_TABULAR> ").append("GuiController : updateDeleteFavoriteWeatherStationStatus : Deleting favorite weather station is unknown ").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateStateListForWeather(GenericPropertyContainer[] genericPropertyContainerArray) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.trace(64).append("GuiControllerWeather : updateStateListForWeather()  ").log();
            }
            if (genericPropertyContainerArray == null || genericPropertyContainerArray.length < 1) {
                ListManager.getGenericASLList(-1891687680).updateList(new GenericPropertyContainer[0]);
            } else {
                this.prepareAndUpdateWeatherStateList(genericPropertyContainerArray);
                this.prepareAndUpdateWeatherSelectableStateList(genericPropertyContainerArray);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateWeatherStationList(GenericPropertyContainer[] genericPropertyContainerArray) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.trace(64).append("GuiControllerWeather : updateWeatherStationList()").log();
            }
            if (genericPropertyContainerArray == null || genericPropertyContainerArray.length < 1) {
                ListManager.getGenericASLList(-952163584).updateList(new GenericPropertyContainer[0]);
            } else {
                this.prepareAndUpdateWeatherStationList(genericPropertyContainerArray);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateWeatherSetupStationList(GenericPropertyContainer[] genericPropertyContainerArray) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.trace(64).append("GuiControllerWeather : updateWeatherSetupStationList()").log();
            }
            if (genericPropertyContainerArray == null || genericPropertyContainerArray.length < 1) {
                ListManager.getGenericASLList(-1874910464).updateList(new GenericPropertyContainer[0]);
            } else {
                this.prepareAndUpdateWeatherSetupStationList(genericPropertyContainerArray);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private void prepareAndUpdateWeatherStationList(GenericPropertyContainer[] genericPropertyContainerArray) {
        Object[] objectArray = new GenericPropertyContainer[genericPropertyContainerArray.length];
        for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
            objectArray[i2] = GenericPropertyUtility.getCopy(genericPropertyContainerArray[i2]);
        }
        Arrays.sort(objectArray, TLinkServiceManager.getServiceManager().getComparatorString(1226507776));
        ListManager.getGenericASLList(-952163584).updateList(objectArray);
    }

    private void prepareAndUpdateWeatherSetupStationList(GenericPropertyContainer[] genericPropertyContainerArray) {
        Object[] objectArray = new GenericPropertyContainer[genericPropertyContainerArray.length];
        for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
            objectArray[i2] = GenericPropertyUtility.getCopy(genericPropertyContainerArray[i2]);
        }
        Arrays.sort(objectArray, TLinkServiceManager.getServiceManager().getComparatorString(1226507776));
        ListManager.getGenericASLList(-1874910464).updateList(objectArray);
    }

    private void prepareAndUpdateWeatherFavoriteCityList(GenericPropertyContainer[] genericPropertyContainerArray) {
        Object[] objectArray = new GenericPropertyContainer[genericPropertyContainerArray.length];
        for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
            objectArray[i2] = GenericPropertyUtility.getCopy(genericPropertyContainerArray[i2]);
        }
        Arrays.sort(objectArray, TLinkServiceManager.getServiceManager().getComparatorString(-1390737920));
        ListManager.getGenericASLList(4109).updateList(objectArray);
    }

    private void prepareAndUpdateWeatherSelectableStateList(GenericPropertyContainer[] genericPropertyContainerArray) {
        Object[] objectArray = new GenericPropertyContainer[genericPropertyContainerArray.length];
        for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
            objectArray[i2] = GenericPropertyUtility.getCopy(genericPropertyContainerArray[i2]);
        }
        Arrays.sort(objectArray, TLinkServiceManager.getServiceManager().getComparatorString(-451279360));
        ListManager.getGenericASLList(-968940800).updateList(objectArray);
    }

    private void prepareAndUpdateWeatherStateList(GenericPropertyContainer[] genericPropertyContainerArray) {
        Object[] objectArray = new GenericPropertyContainer[genericPropertyContainerArray.length];
        for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
            objectArray[i2] = GenericPropertyUtility.getCopy(genericPropertyContainerArray[i2]);
        }
        Arrays.sort(objectArray, TLinkServiceManager.getServiceManager().getComparatorString(-451279360));
        ListManager.getGenericASLList(-1891687680).updateList(objectArray);
    }

    public void updateWeatherLoadingState(int n) {
        if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.trace(64).append("GuiControllerWeather : updateWeatherLoadingState(), weatherLoadingState = ").append(n).log();
        }
        if (n >= 0 && n <= 2) {
            ServiceManager.aslPropertyManager.valueChangedInteger(-1455480064, n);
        } else if (ServiceManager.logger2.isTraceEnabled(64)) {
            ServiceManager.logger2.error(64).append("GuiControllerWeather : updateWeatherLoadingState(), Loading state not in range. ").log();
        }
    }

    public void updateSetupAddFavoriteWeatherStationStatus(int n) {
        try {
            if (n == 15) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-2042682624);
            } else if (n == 14) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-2009128192);
            } else if (n == 13) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-2025905408);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}

