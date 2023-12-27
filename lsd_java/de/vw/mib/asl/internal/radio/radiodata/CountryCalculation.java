/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.radiodata;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.util.ProgramIdentification;
import de.vw.mib.asl.internal.radio.radiodata.CountryCount;
import de.vw.mib.asl.internal.radio.radiodata.NeighboringCountryList;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataSessionManager;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.dsi.ifc.radio.Station;
import org.dsi.ifc.radiodata.CountryRegionData;
import org.dsi.ifc.radiodata.RadioStationData;

public final class CountryCalculation {
    public static final int MIN_COUNT_OF_MATCHING_STATIONS;
    final List list = new LinkedList();
    NeighboringCountryList[] neighboringCountryList = null;

    public int getHomeCountry() {
        if (RadioData.getAmfmDatabase().getSettingsPersistable().getHomeCountryAutoSelectionActive() && RadioDataSessionManager.getInstance().countryList.isAutoHomeCountryCalculationFunctionAvailable()) {
            return RadioData.getAmfmDatabase().getSettingsPersistable().getCalculatedHomeCountry();
        }
        return RadioData.getAmfmDatabase().getSettingsPersistable().getUserSelectedHomeCountry();
    }

    public boolean isCalculatedHomeCountryValid() {
        return RadioData.getAmfmDatabase().getSettingsPersistable().getCalculatedHomeCountry() > 1;
    }

    public int getNeighboringCountry(int n, int n2) {
        int n3 = (n2 & 0xF00000) >> 12;
        if (null != this.neighboringCountryList) {
            for (int i2 = 0; i2 < this.neighboringCountryList.length; ++i2) {
                int[] nArray;
                if (null == this.neighboringCountryList[i2] || this.neighboringCountryList[i2].getHomeCountry() != n || null == (nArray = this.neighboringCountryList[i2].getNeighboringCountries()) || n3 < 0 || n3 >= nArray.length) continue;
                return nArray[n3];
            }
        }
        return -1;
    }

    public int[] getAllNeighboringCountries(int n) {
        if (null != this.neighboringCountryList) {
            for (int i2 = 0; i2 < this.neighboringCountryList.length; ++i2) {
                if (null == this.neighboringCountryList[i2] || this.neighboringCountryList[i2].getHomeCountry() != n) continue;
                return this.neighboringCountryList[i2].getNeighboringCountries();
            }
        }
        return null;
    }

    public void calculateHomeCountry(Station[] stationArray) {
        try {
            if (null == stationArray || stationArray.length < 2) {
                return;
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_COUNTRY_CALCULATION).append("CountryCalculation - calculateHomeCountry() - Start - Station[]:").log();
                for (int i2 = 0; i2 < stationArray.length; ++i2) {
                    if (null == stationArray[i2]) continue;
                    ServiceManager.logger.trace(128).append(new StringBuffer().append("stations[").append(i2).append("]:").toString()).log();
                    ServiceManager.logger.trace(128).append(stationArray[i2].toString()).log();
                }
            }
            ArrayList arrayList = new ArrayList(0);
            for (int i3 = 0; i3 < stationArray.length; ++i3) {
                RadioStationData radioStationData;
                if (null == stationArray[i3] || !stationArray[i3].rds || stationArray[i3].waveband != 1 || !ProgramIdentification.isValidPI(stationArray[i3].getPi()) || null == (radioStationData = RadioDataSessionManager.getInstance().stationDataBuffer.getUniqueRadioStationData(stationArray[i3]))) continue;
                arrayList.add(radioStationData);
            }
            RadioStationData[] radioStationDataArray = (RadioStationData[])arrayList.toArray(new RadioStationData[arrayList.size()]);
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_COUNTRY_CALCULATION).append("CountryCalculation - calculateHomeCountry() - RadioStationData[]:").log();
                if (null != radioStationDataArray) {
                    for (int i4 = 0; i4 < radioStationDataArray.length; ++i4) {
                        if (null == radioStationDataArray[i4]) continue;
                        ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_COUNTRY_CALCULATION).append(new StringBuffer().append("radioStationData[").append(i4).append("]:").toString()).log();
                        ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_COUNTRY_CALCULATION).append(radioStationDataArray[i4].toString()).log();
                    }
                }
            }
            if (null != radioStationDataArray && radioStationDataArray.length >= 2) {
                CountryCount[] countryCountArray = new CountryCount[radioStationDataArray.length];
                for (int i5 = 0; i5 < radioStationDataArray.length; ++i5) {
                    int n;
                    if (null == radioStationDataArray[i5] || -1 == (n = radioStationDataArray[i5].getCountry())) continue;
                    this.addCountry(countryCountArray, n);
                }
                this.setCountry(countryCountArray);
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_COUNTRY_CALCULATION).append("CountryCalculation - calculateHomeCountry() - End").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private void setCountry(CountryCount[] countryCountArray) {
        try {
            int n;
            int n2 = -1;
            int n3 = 1;
            if (null != countryCountArray) {
                for (n = 0; n < countryCountArray.length; ++n) {
                    if (null == countryCountArray[n] || countryCountArray[n].getCount() <= n2) continue;
                    n2 = countryCountArray[n].getCount();
                    n3 = countryCountArray[n].getCountry();
                }
                if (n2 >= 2 && n3 > 1) {
                    RadioData.getAmfmDatabase().getSettingsPersistable().setCalculatedHomeCountry(n3);
                    if (RadioData.getAmfmDatabase().getSettingsPersistable().getHomeCountryAutoSelectionActive()) {
                        RadioDataSessionManager.getInstance().countryList.updateHomeCountryNameInSetup(n3);
                    }
                }
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_COUNTRY_CALCULATION).append("CountryCalculation - setCountry() - countriesCount[]:").log();
                if (null != countryCountArray) {
                    for (n = 0; n < countryCountArray.length; ++n) {
                        if (null == countryCountArray[n]) continue;
                        ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_COUNTRY_CALCULATION).append(new StringBuffer().append("countriesCount[").append(n).append("]: ").append("count: ").append(countryCountArray[n].getCount()).append(" ,country: ").append(countryCountArray[n].getCountry()).toString()).log();
                    }
                }
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_COUNTRY_CALCULATION).append(new StringBuffer().append("calculatedHomeCountry: ").append(RadioData.getAmfmDatabase().getSettingsPersistable().getCalculatedHomeCountry()).toString()).log();
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_COUNTRY_CALCULATION).append("").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private void addCountry(CountryCount[] countryCountArray, int n) {
        block5: {
            try {
                if (null == countryCountArray) break block5;
                for (int i2 = 0; i2 < countryCountArray.length; ++i2) {
                    if (null != countryCountArray[i2] && countryCountArray[i2].getCountry() == n) {
                        countryCountArray[i2].incrementCount();
                    } else {
                        if (null != countryCountArray[i2]) continue;
                        countryCountArray[i2] = new CountryCount(n, 1);
                    }
                    break;
                }
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public void setNeighboringCountryList(CountryRegionData[] countryRegionDataArray) {
        if (null != countryRegionDataArray && countryRegionDataArray.length > 0) {
            this.neighboringCountryList = new NeighboringCountryList[countryRegionDataArray.length];
            for (int i2 = 0; i2 < countryRegionDataArray.length; ++i2) {
                if (null == countryRegionDataArray[i2] || null == countryRegionDataArray[i2].countryNeighborPi) continue;
                this.neighboringCountryList[i2] = new NeighboringCountryList(countryRegionDataArray[i2].countryId, countryRegionDataArray[i2].countryNeighborPi);
            }
        } else {
            this.neighboringCountryList = null;
        }
    }
}

