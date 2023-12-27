/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.radiodata;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioAdaptationAdapter;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.radiodata.ComparatorCountryList;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataSessionInfo;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataSessionManager;
import de.vw.mib.asl.internal.radio.transformer.RadioCountryListCollector;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.ArrayList;
import java.util.Arrays;
import org.dsi.ifc.radiodata.CountryRegionData;
import org.dsi.ifc.radiodata.CountryRegionTranslationData;

public final class CountryList {
    CountryRegionData[] countryRegionDataList = null;
    CountryRegionTranslationData[] countryRegionTranslationDataNative = null;
    CountryRegionTranslationData[] countryRegionTranslationDataEnglish = null;
    private static final int INVALID_MAKRO_REGION_ID;
    private static boolean requestedCountryRegionTranslationDataEnglish;
    private int rootNodeMacroRegionId = -1;
    public static final int COUNTRY_LIST_LEVEL_1;
    public static final int COUNTRY_LIST_LEVEL_2;
    private int currentListLevel = 1;
    private Integer[] nextLevelList = null;
    private Integer[] list1Level = null;
    private static final int MODE_DISABLED;
    private static final int MODE_ENABLED;
    private static final int MODE_UNDEFINED;
    private int piAutomaticMode = 2;
    private int gpsAutomaticMode = 2;
    public static int PI_AUTO_MODE;
    public static int GPS_AUTO_MODE;
    private int databaseNameShallBeUsedInStationList = 2;
    private int databaseNameShallBeUsedInMainView = 2;
    private int databaseNameShallBeUsedOnPresets = 2;
    private int databaseNameShallBeUsedInCombiInstrument = 2;

    public void setUserSelectedHomeCountry(EventGeneric eventGeneric) {
        try {
            boolean bl;
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("CountryList - setUserSelectedHomeCountry()").log();
            }
            int n = 0;
            int n2 = eventGeneric.getInt(0);
            Object[] objectArray = ListManager.getGenericASLList(4115).getDSIObjects();
            if (null == objectArray || objectArray.length < 1) {
                return;
            }
            RadioCountryListCollector[] radioCountryListCollectorArray = (RadioCountryListCollector[])objectArray;
            if (null == radioCountryListCollectorArray || radioCountryListCollectorArray.length <= n2 || null == radioCountryListCollectorArray[n2]) {
                return;
            }
            n = radioCountryListCollectorArray[n2].countryId;
            int n3 = RadioData.getAmfmDatabase().getSettingsPersistable().getCalculatedHomeCountry();
            boolean bl2 = RadioData.getAmfmDatabase().getSettingsPersistable().getHomeCountryAutoSelectionActive();
            boolean bl3 = bl = n == 1;
            if (this.getListLevel() == 1 && bl) {
                RadioData.getAmfmDatabase().getSettingsPersistable().setHomeCountryAutoSelectionActive(!bl2);
            }
            if (this.getListLevel() == 1) {
                this.nextLevelList = this.getCountryList(n);
                if (!bl && null != this.nextLevelList && this.nextLevelList.length > 0) {
                    this.generateCountryList(2, this.nextLevelList);
                } else {
                    if (bl && bl2 && n3 > 1) {
                        RadioData.getAmfmDatabase().getSettingsPersistable().setUserSelectedHomeCountry(n3);
                    } else {
                        RadioData.getAmfmDatabase().getSettingsPersistable().setUserSelectedHomeCountry(n);
                    }
                    this.generateCountryList(1, this.getCountryList1Level());
                }
            } else {
                RadioData.getAmfmDatabase().getSettingsPersistable().setUserSelectedHomeCountry(n);
                this.generateCountryList(2, this.nextLevelList);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void generateCountryList() {
        this.generateCountryList(1, this.getCountryList1Level());
    }

    public void generateCountryList(int n, Integer[] integerArray) {
        try {
            int n2 = RadioDataSessionManager.getInstance().homeCountryCalc.getHomeCountry();
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("CountryList - generateCountryList() - countryId = ").append(n2).log();
            }
            if (null == integerArray) {
                return;
            }
            RadioDataSessionManager.getInstance().countryList.updateHomeCountryNameInSetup(n2);
            Object[] objectArray = null;
            this.setListLevel(n);
            AmFmFactory.getAslAmfmModelController().updateFmSetupHomeCountryListBackButtonVisible(1 != n);
            objectArray = this.isAutoHomeCountryCalculationFunctionAvailable() && 1 == n ? this.generateListWithAutomaticItem(integerArray) : this.generateListWithoutAutomaticItem(integerArray);
            if (null == objectArray) {
                return;
            }
            ListManager.getGenericASLList(4115).updateList(objectArray);
            int n3 = -1;
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                if (null == objectArray[i2] || !((RadioCountryListCollector)objectArray[i2]).itemActivated) continue;
                n3 = i2;
                break;
            }
            ListManager.getGenericASLList(4115).setActiveIndex(n3);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public RadioCountryListCollector[] generateListWithAutomaticItem(Integer[] integerArray) {
        try {
            Object[] objectArray = null;
            int n = RadioData.getAmfmDatabase().getSettingsPersistable().getUserSelectedHomeCountry();
            int n2 = RadioData.getAmfmDatabase().getSettingsPersistable().getCalculatedHomeCountry();
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("CountryList - generateListWithAutomaticItem() - userSelectedHomeCountry = ").append(n).append(", calculatedHomeCountry = ").append(n2).log();
            }
            if (RadioData.getAmfmDatabase().getSettingsPersistable().getHomeCountryAutoSelectionActive()) {
                if (n2 > 1) {
                    objectArray = new RadioCountryListCollector[2];
                    objectArray[1] = new RadioCountryListCollector();
                    objectArray[1].countryId = n2;
                    objectArray[1].itemEnabled = false;
                    objectArray[1].itemActivated = false;
                    objectArray[1].countryRegionName = this.getCountryName(n2);
                    objectArray[1].guiListItemPosition = 1;
                } else {
                    objectArray = new RadioCountryListCollector[]{new RadioCountryListCollector()};
                }
                this.generateAutoCountryCalculationItem(objectArray[0], true);
            } else if (null == integerArray || integerArray.length < 1) {
                objectArray = new RadioCountryListCollector[]{new RadioCountryListCollector()};
                this.generateAutoCountryCalculationItem(objectArray[0], false);
            } else {
                objectArray = new RadioCountryListCollector[integerArray.length + 1];
                objectArray[0] = new RadioCountryListCollector();
                this.generateAutoCountryCalculationItem(objectArray[0], false);
                int n3 = this.getMacroRegion(n);
                String string = this.getCountryName(n);
                for (int i2 = 0; i2 < integerArray.length && i2 < objectArray.length - 1; ++i2) {
                    Integer[] integerArray2;
                    objectArray[i2 + 1] = new RadioCountryListCollector();
                    if (null == integerArray[i2]) continue;
                    ((RadioCountryListCollector)objectArray[i2 + 1]).countryId = integerArray[i2];
                    ((RadioCountryListCollector)objectArray[i2 + 1]).itemEnabled = true;
                    CountryRegionTranslationData countryRegionTranslationData = this.getCountryRegionTranslationData(((RadioCountryListCollector)objectArray[i2 + 1]).countryId);
                    ((RadioCountryListCollector)objectArray[i2 + 1]).countryRegionName = this.getCountryName(countryRegionTranslationData, ((RadioCountryListCollector)objectArray[i2 + 1]).countryId);
                    ((RadioCountryListCollector)objectArray[i2 + 1]).guiListItemPosition = this.getGuiListItemPosition(countryRegionTranslationData, ((RadioCountryListCollector)objectArray[i2 + 1]).countryId);
                    ((RadioCountryListCollector)objectArray[i2 + 1]).itemActivated = false;
                    if (((RadioCountryListCollector)objectArray[i2 + 1]).countryId == n3) {
                        ((RadioCountryListCollector)objectArray[i2 + 1]).countryRegionName = new StringBuffer().append(((RadioCountryListCollector)objectArray[i2 + 1]).countryRegionName).append(" - ").append(string).toString();
                        ((RadioCountryListCollector)objectArray[i2 + 1]).itemActivated = true;
                    }
                    if (n == ((RadioCountryListCollector)objectArray[i2 + 1]).countryId) {
                        ((RadioCountryListCollector)objectArray[i2 + 1]).itemActivated = true;
                    }
                    if (this.getListLevel() != 1 || null == (integerArray2 = this.getCountryList(((RadioCountryListCollector)objectArray[i2 + 1]).countryId)) || integerArray2.length <= 0) continue;
                    ((RadioCountryListCollector)objectArray[i2 + 1]).countryRegionName = new StringBuffer().append(((RadioCountryListCollector)objectArray[i2 + 1]).countryRegionName).append(" ->").toString();
                }
                Arrays.sort(objectArray, ComparatorCountryList.getComparator());
            }
            return objectArray;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    private void generateAutoCountryCalculationItem(RadioCountryListCollector radioCountryListCollector, boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("CountryList - generateAutoCountryCalculationItem() - isItemActivated = ").append(bl).log();
        }
        radioCountryListCollector.countryId = 1;
        radioCountryListCollector.itemEnabled = true;
        radioCountryListCollector.itemActivated = bl;
        radioCountryListCollector.countryRegionName = this.getCountryName(1);
        radioCountryListCollector.guiListItemPosition = 0;
    }

    public RadioCountryListCollector[] generateListWithoutAutomaticItem(Integer[] integerArray) {
        try {
            int n = RadioData.getAmfmDatabase().getSettingsPersistable().getUserSelectedHomeCountry();
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("CountryList - generateListWithoutAutomaticItem() - userSelectedHomeCountry = ").append(n).log();
            }
            if (null != integerArray) {
                Object[] objectArray = new RadioCountryListCollector[integerArray.length];
                int n2 = this.getMacroRegion(n);
                String string = this.getCountryName(n);
                for (int i2 = 0; i2 < integerArray.length; ++i2) {
                    Integer[] integerArray2;
                    objectArray[i2] = new RadioCountryListCollector();
                    if (null == integerArray[i2]) continue;
                    ((RadioCountryListCollector)objectArray[i2]).countryId = integerArray[i2];
                    ((RadioCountryListCollector)objectArray[i2]).itemEnabled = true;
                    CountryRegionTranslationData countryRegionTranslationData = this.getCountryRegionTranslationData(((RadioCountryListCollector)objectArray[i2]).countryId);
                    ((RadioCountryListCollector)objectArray[i2]).countryRegionName = this.getCountryName(countryRegionTranslationData, ((RadioCountryListCollector)objectArray[i2]).countryId);
                    ((RadioCountryListCollector)objectArray[i2]).guiListItemPosition = this.getGuiListItemPosition(countryRegionTranslationData, ((RadioCountryListCollector)objectArray[i2]).countryId);
                    ((RadioCountryListCollector)objectArray[i2]).itemActivated = false;
                    if (((RadioCountryListCollector)objectArray[i2]).countryId == n2) {
                        ((RadioCountryListCollector)objectArray[i2]).countryRegionName = new StringBuffer().append(((RadioCountryListCollector)objectArray[i2]).countryRegionName).append(" - ").append(string).toString();
                        ((RadioCountryListCollector)objectArray[i2]).itemActivated = true;
                    }
                    if (n == ((RadioCountryListCollector)objectArray[i2]).countryId) {
                        ((RadioCountryListCollector)objectArray[i2]).itemActivated = true;
                    }
                    if (this.getListLevel() != 1 || null == (integerArray2 = this.getCountryList(((RadioCountryListCollector)objectArray[i2]).countryId)) || integerArray2.length <= 0) continue;
                    ((RadioCountryListCollector)objectArray[i2]).countryRegionName = new StringBuffer().append(((RadioCountryListCollector)objectArray[i2]).countryRegionName).append(" ->").toString();
                }
                Arrays.sort(objectArray, ComparatorCountryList.getComparator());
                return objectArray;
            }
            return new RadioCountryListCollector[0];
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public String getCountryName(CountryRegionTranslationData countryRegionTranslationData, int n) {
        if (null != countryRegionTranslationData) {
            String string;
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("CountryList - getCountryName() - countryRegionTranslationData = ").append(countryRegionTranslationData.toString()).log();
            }
            if (null != (string = countryRegionTranslationData.getCountryRegionTranslation()) && string.length() > 0) {
                return string;
            }
        } else if (RadioDataApi.isCountryRegionTranslationDataRequested()) {
            ServiceManager.logger.error(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("CountryList - getCountryName() - countryRegionTranslationData = null").log();
        }
        if (n >= 1) {
            return String.valueOf(n);
        }
        return String.valueOf("");
    }

    public int getGuiListItemPosition(CountryRegionTranslationData countryRegionTranslationData, int n) {
        if (null != countryRegionTranslationData) {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("CountryList - getGuiListItemPosition() - countryRegionTranslationData = ").append(countryRegionTranslationData.toString()).log();
            }
            if (null != countryRegionTranslationData) {
                return countryRegionTranslationData.guiListItemPosition;
            }
        } else {
            ServiceManager.logger.error(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("CountryList - getGuiListItemPosition() - countryRegionTranslationData = null").log();
        }
        return -1601830656;
    }

    public String getCountryName(int n) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("CountryList - getCountryName() - countryId = ").append(n).log();
        }
        CountryRegionTranslationData countryRegionTranslationData = this.getCountryRegionTranslationData(n);
        return this.getCountryName(countryRegionTranslationData, n);
    }

    public void processCountryRegionDataResponse(CountryRegionData[] countryRegionDataArray, int n) {
        try {
            int n2;
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("CountryList - processCountryRegionDataResponse() - sessionId = ").append(n).log();
                if (null == countryRegionDataArray || countryRegionDataArray.length < 1) {
                    ServiceManager.logger.trace(128).append("null == countryRegionData || countryRegionData.length < 1").log();
                } else {
                    for (n2 = 0; n2 < countryRegionDataArray.length; ++n2) {
                        if (null == countryRegionDataArray[n2]) continue;
                        ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append(countryRegionDataArray[n2].toString()).log();
                    }
                }
            }
            if (null != countryRegionDataArray && countryRegionDataArray.length > 0) {
                int n3;
                n2 = RadioAdaptationAdapter.getStationLogoDbMode();
                int n4 = -1;
                for (n3 = countryRegionDataArray.length - 1; n3 >= 0; --n3) {
                    if (null == countryRegionDataArray[n3] || countryRegionDataArray[n3].countryId != n2) continue;
                    n4 = countryRegionDataArray[n3].macroRegionId;
                    break;
                }
                if (n4 > -1) {
                    for (n3 = countryRegionDataArray.length - 1; n3 >= 0; --n3) {
                        if (null == countryRegionDataArray[n3] || countryRegionDataArray[n3].macroRegionId != n4 || countryRegionDataArray[n3].macroRegionId != countryRegionDataArray[n3].countryId) continue;
                        this.rootNodeMacroRegionId = countryRegionDataArray[n3].macroRegionId;
                        break;
                    }
                    if (-1 == this.rootNodeMacroRegionId) {
                        for (n3 = countryRegionDataArray.length - 1; n3 >= 0; --n3) {
                            if (null == countryRegionDataArray[n3] || countryRegionDataArray[n3].countryId != n4) continue;
                            this.rootNodeMacroRegionId = countryRegionDataArray[n3].macroRegionId;
                            break;
                        }
                    }
                    this.countryRegionDataList = countryRegionDataArray;
                    this.generateCountryList(1, this.getCountryList1Level());
                    RadioDataSessionManager.getInstance().homeCountryCalc.setNeighboringCountryList(this.countryRegionDataList);
                    this.setHomeCountryAutoSelectionActive();
                    this.setDatabaseNameUsage();
                    this.setSetupAutoStoreStationLogoSwitchOnOrOff();
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void setHomeCountryAutoSelectionActive() {
        if (!RadioData.getAmfmDatabase().getSettingsPersistable().isHomeCountryUserSelected()) {
            if (this.isAutoHomeCountryCalculationFunctionAvailable() && (1 == RadioAdaptationAdapter.getStationLogoDbMode() || this.rootNodeMacroRegionId == RadioAdaptationAdapter.getStationLogoDbMode())) {
                RadioData.getAmfmDatabase().getSettingsPersistable().setHomeCountryAutoSelectionActive(true);
            } else {
                RadioData.getAmfmDatabase().getSettingsPersistable().setHomeCountryAutoSelectionActive(false);
            }
        }
    }

    public Integer[] getCountryList1Level() {
        if (null == this.list1Level) {
            this.list1Level = this.getCountryList(this.rootNodeMacroRegionId);
        }
        return this.list1Level;
    }

    public boolean isAutoHomeCountryCalculationFunctionAvailable() {
        return this.isAutomaticCountryCalculationInDbActivated(PI_AUTO_MODE);
    }

    public int getMacroRegion(int n) {
        if (null != this.countryRegionDataList) {
            for (int i2 = this.countryRegionDataList.length - 1; i2 >= 0; --i2) {
                if (null == this.countryRegionDataList[i2] || this.countryRegionDataList[i2].countryId != n) continue;
                return this.countryRegionDataList[i2].macroRegionId;
            }
        }
        return -1;
    }

    public Integer[] getCountryList(int n) {
        Integer[] integerArray = null;
        if (null != this.countryRegionDataList) {
            ArrayList arrayList = new ArrayList(0);
            for (int i2 = this.countryRegionDataList.length - 1; i2 >= 0; --i2) {
                if (null == this.countryRegionDataList[i2] || this.countryRegionDataList[i2].macroRegionId != n || this.countryRegionDataList[i2].macroRegionId == this.countryRegionDataList[i2].countryId || this.countryRegionDataList[i2].countryId <= 1) continue;
                arrayList.add(new Integer(this.countryRegionDataList[i2].getCountryId()));
            }
            integerArray = (Integer[])arrayList.toArray(new Integer[arrayList.size()]);
        }
        return integerArray;
    }

    public int getRequestStrategy(int n) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("CountryList - getRequestStrategy( ").append(n).append(" )").log();
        }
        if (null != this.countryRegionDataList) {
            for (int i2 = 0; i2 < this.countryRegionDataList.length; ++i2) {
                if (null == this.countryRegionDataList[i2] || this.countryRegionDataList[i2].getCountryId() != n || this.countryRegionDataList[i2].countryId <= 1) continue;
                return this.countryRegionDataList[i2].getRequestStrategy();
            }
        }
        return -1;
    }

    public void processCountryRegionTranslationData(CountryRegionTranslationData[] countryRegionTranslationDataArray, int n) {
        try {
            RadioDataSessionInfo radioDataSessionInfo;
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("CountryList - processCountryRegionTranslationData() - sessionId = ").append(n).log();
                if (null != countryRegionTranslationDataArray) {
                    for (int i2 = 0; i2 < countryRegionTranslationDataArray.length; ++i2) {
                        if (null == countryRegionTranslationDataArray[i2]) continue;
                        ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append(countryRegionTranslationDataArray[i2].toString()).log();
                    }
                } else {
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("null == countryRegionTranslationData").log();
                }
            }
            if (null == (radioDataSessionInfo = RadioDataSessionManager.getInstance().getRadioDataSessionInfo(n))) {
                return;
            }
            if (radioDataSessionInfo.getRequestType() == 17) {
                this.countryRegionTranslationDataNative = countryRegionTranslationDataArray;
                if (!requestedCountryRegionTranslationDataEnglish && (null == countryRegionTranslationDataArray || countryRegionTranslationDataArray.length < 1 || countryRegionTranslationDataArray.length > 0 && null == countryRegionTranslationDataArray[0])) {
                    RadioDataSessionManager.getInstance().adapterDsiRadioData.requestCountryRegionTranslationData("en_GB", 18);
                    requestedCountryRegionTranslationDataEnglish = true;
                }
            } else if (radioDataSessionInfo.getRequestType() == 18) {
                this.countryRegionTranslationDataEnglish = countryRegionTranslationDataArray;
            }
            RadioDataApi.generateCountryList();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public CountryRegionTranslationData getCountryRegionTranslationData(int n) {
        CountryRegionTranslationData countryRegionTranslationData;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("CountryList - getCountryRegionTranslation( ").append(n).append(" )").log();
        }
        if (null != (countryRegionTranslationData = this.getCountryRegionTranslationData(n, this.countryRegionTranslationDataNative))) {
            return countryRegionTranslationData;
        }
        countryRegionTranslationData = this.getCountryRegionTranslationData(n, this.countryRegionTranslationDataEnglish);
        return countryRegionTranslationData;
    }

    public String getCountryRegionTranslation(int n, CountryRegionTranslationData[] countryRegionTranslationDataArray) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("CountryList - getCountryRegionTranslation() - countryId = ").append(n).log();
        }
        CountryRegionTranslationData countryRegionTranslationData = this.getCountryRegionTranslationData(n, countryRegionTranslationDataArray);
        if (null != countryRegionTranslationDataArray) {
            return countryRegionTranslationData.getCountryRegionTranslation();
        }
        return null;
    }

    public CountryRegionTranslationData getCountryRegionTranslationData(int n, CountryRegionTranslationData[] countryRegionTranslationDataArray) {
        int n2;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("CountryList - getCountryRegionTranslationData() - countryId = ").append(n).log();
            if (null != countryRegionTranslationDataArray) {
                for (n2 = 0; n2 < countryRegionTranslationDataArray.length; ++n2) {
                    if (null == countryRegionTranslationDataArray[n2]) continue;
                    ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append(countryRegionTranslationDataArray[n2].toString()).log();
                }
            }
        }
        if (null != countryRegionTranslationDataArray) {
            for (n2 = 0; n2 < countryRegionTranslationDataArray.length; ++n2) {
                if (null == countryRegionTranslationDataArray[n2] || countryRegionTranslationDataArray[n2].countryId != n) continue;
                return countryRegionTranslationDataArray[n2];
            }
        }
        return null;
    }

    public boolean isCountryRegionTranslationAvailable(String string) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("CountryList - isCountryRegionTranslationAvailable( ").append(string).append(" )").log();
        }
        if (null != this.countryRegionTranslationDataNative) {
            for (int i2 = 0; i2 < this.countryRegionTranslationDataNative.length; ++i2) {
                String string2;
                if (null == this.countryRegionTranslationDataNative[i2] || null == (string2 = this.countryRegionTranslationDataNative[i2].getGuiLanguage()) || !string2.equals(string)) continue;
                return true;
            }
        }
        return false;
    }

    public int getListLevel() {
        return this.currentListLevel;
    }

    public void setListLevel(int n) {
        if (n >= 1 && n <= 2) {
            this.currentListLevel = n;
        }
    }

    public boolean isAutomaticCountryCalculationInDbActivated(int n) {
        if (PI_AUTO_MODE == n && this.piAutomaticMode != 2) {
            return this.piAutomaticMode == 1;
        }
        if (GPS_AUTO_MODE == n && this.gpsAutomaticMode != 2) {
            return this.gpsAutomaticMode == 1;
        }
        if (null != this.countryRegionDataList) {
            for (int i2 = this.countryRegionDataList.length - 1; i2 >= 0; --i2) {
                if (null == this.countryRegionDataList[i2] || this.countryRegionDataList[i2].macroRegionId != this.rootNodeMacroRegionId || this.countryRegionDataList[i2].macroRegionId != this.countryRegionDataList[i2].countryId || null == this.countryRegionDataList[i2].extraInt || this.countryRegionDataList[i2].extraInt.length <= 0) continue;
                int n2 = this.countryRegionDataList[i2].extraInt[0] & 1;
                int n3 = this.countryRegionDataList[i2].extraInt[0] & 2;
                this.piAutomaticMode = n2 != 0 ? 1 : 0;
                this.gpsAutomaticMode = n3 != 0 ? 1 : 0;
                if (PI_AUTO_MODE == n) {
                    return this.piAutomaticMode == 1;
                }
                if (GPS_AUTO_MODE == n) {
                    return this.gpsAutomaticMode == 1;
                }
                return false;
            }
        }
        return false;
    }

    public void updateHomeCountryNameInSetup(int n) {
        String string = "";
        if (n > 1) {
            string = RadioDataSessionManager.getInstance().countryList.getCountryName(n);
            AmFmFactory.getAslAmfmModelController().updateHomeCountryNameInSetup(string);
        } else {
            AmFmFactory.getAslAmfmModelController().updateHomeCountryNameInSetup(string);
        }
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_RADIODATA).append("CountryList - updateHomeCountryNameInSetup() - ").append("regionId = ").append(n).append(", regionName = ").append(string).log();
        }
    }

    public boolean isDatabaseNameActivatedForStationList() {
        return this.databaseNameShallBeUsedInStationList == 1;
    }

    public boolean isDatabaseNameActivatedForMainView() {
        return this.databaseNameShallBeUsedInMainView == 1;
    }

    public boolean isDatabaseNameActivatedForPresets() {
        return this.databaseNameShallBeUsedOnPresets == 1;
    }

    public boolean isDatabaseNameActivatedForCombiInstrument() {
        return this.databaseNameShallBeUsedInCombiInstrument == 1;
    }

    public void setDatabaseNameUsage() {
        if (null != this.countryRegionDataList) {
            for (int i2 = this.countryRegionDataList.length - 1; i2 >= 0; --i2) {
                if (null == this.countryRegionDataList[i2] || this.countryRegionDataList[i2].macroRegionId != this.rootNodeMacroRegionId || this.countryRegionDataList[i2].macroRegionId != this.countryRegionDataList[i2].countryId) continue;
                int n = this.countryRegionDataList[i2].useDatabaseNameInHmi & 1;
                int n2 = this.countryRegionDataList[i2].useDatabaseNameInHmi & 2;
                int n3 = this.countryRegionDataList[i2].useDatabaseNameInHmi & 4;
                int n4 = this.countryRegionDataList[i2].useDatabaseNameInHmi & 8;
                this.databaseNameShallBeUsedInStationList = n != 0 ? 1 : 0;
                this.databaseNameShallBeUsedInMainView = n2 != 0 ? 1 : 0;
                this.databaseNameShallBeUsedOnPresets = n3 != 0 ? 1 : 0;
                if (n4 != 0) {
                    this.databaseNameShallBeUsedInCombiInstrument = 1;
                    break;
                }
                this.databaseNameShallBeUsedInCombiInstrument = 0;
                break;
            }
        }
    }

    public int getRootNodeMacroRegionId() {
        return this.rootNodeMacroRegionId;
    }

    public void setSetupAutoStoreStationLogoSwitchOnOrOff() {
        if (null != RadioData.getAmfmDatabase() && !RadioData.getAmfmDatabase().getSettingsPersistable().isAutoStoreLogoActiveChangedByUser()) {
            if (this.isAutoHomeCountryCalculationFunctionAvailable()) {
                RadioData.getAmfmDatabase().getSettingsPersistable().setAutoStoreLogoActive(true);
                RadioData.getAmfmDatabase().getSettingsPersistable().setAutoStoreStationLogoOnBeforeRdsOff(true);
                AmFmFactory.getAslAmfmModelController().updateLogoAutoStoreActive(true);
            } else {
                RadioData.getAmfmDatabase().getSettingsPersistable().setAutoStoreLogoActive(false);
                RadioData.getAmfmDatabase().getSettingsPersistable().setAutoStoreStationLogoOnBeforeRdsOff(false);
                AmFmFactory.getAslAmfmModelController().updateLogoAutoStoreActive(false);
            }
        }
    }

    static {
        requestedCountryRegionTranslationDataEnglish = false;
        PI_AUTO_MODE = 0;
        GPS_AUTO_MODE = 1;
    }
}

