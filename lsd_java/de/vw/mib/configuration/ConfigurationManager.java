/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.configuration;

import de.vw.mib.configuration.FeatureFlagValueChangeReceiver;
import de.vw.mib.configuration.NvListener;
import de.vw.mib.configuration.RtMethodListener;
import de.vw.mib.configuration.internal.generated.ConfigurationManagerGenerated;
import de.vw.mib.dynamicresourcedata.DynamicResourceDataDescription;

public interface ConfigurationManager
extends ConfigurationManagerGenerated {
    public static final String COUNTRYCODE_CHINA;
    public static final String COUNTRYCODE_JAPAN;
    public static final String COUNTRYCODE_KOREA;
    public static final String COUNTRYCODE_TAIWAN;
    public static final String COUNTRYCODE_USA;
    public static final int ENGINETYPE_COMBUSTION;
    public static final int ENGINETYPE_BEV;
    public static final int ENGINETYPE_PHEV;
    public static final int FUELTYPE_GASOLINE;
    public static final int FUELTYPE_DIESEL;
    public static final int FUELTYPE_CNG;
    public static final int FUELTYPE_LPG;
    public static final int FUELTYPE_ELECTRIC;
    public static final int FUELTYPE_NONE;
    public static final int LSCS_UNINITIALIZED;
    public static final int LSCS_CHANGING;
    public static final int LSCS_FINISHED;
    public static final int SKINID_1;
    public static final int SKINID_2;
    public static final int SKINID_3;
    public static final int SKINMODE_DAY;
    public static final int SKINMODE_NIGHT;
    public static final int DISPLAYCONTEXTGROUP_HMI;
    public static final int DISPLAYCONTEXTGROUP_MAP;
    public static final int DISPLAYCONTEXTGROUP_RVC;
    public static final int DISPLAYCONTEXTGROUP_VIDEO;
    public static final int DISPLAYCONTEXTGROUP_INTERNETBROWSER;
    public static final int DRIVERSIDE_UNDEFINED;
    public static final int DRIVERSIDE_LEFT;
    public static final int DRIVERSIDE_RIGHT;
    public static final int INSTRUMENTCLUSTER_SIZE_SMALL;
    public static final int INSTRUMENTCLUSTER_SIZE_LARGE;
    public static final int MENUMODE_FLOWLIST;
    public static final int MENUMODE_GRID;

    default public boolean isDevelopmentBuild() {
    }

    default public boolean isTestModeAvailable() {
    }

    default public String[] getAvailableLanguages() {
    }

    default public boolean isArabicAvailable() {
    }

    default public boolean isArabicReplacementActive() {
    }

    default public String getDefaultLanguage() {
    }

    default public String getPersistedLanguage() {
    }

    default public int getLscState() {
    }

    default public int[] getAvailableSkins() {
    }

    default public int[] getAvailableSkins4CurrentGuiLanguage() {
    }

    default public int getDefaultSkinId() {
    }

    default public String getSkinName(int n) {
    }

    default public String getSkinModName(int n) {
    }

    default public String getCurrentGuiLanguage() {
    }

    default public int getCurrentSkinId() {
    }

    default public int getCurrentSkinMode() {
    }

    default public String getSkinPath(int n) {
    }

    default public String getCommonDataPath() {
    }

    default public String getCurrentFontPath() {
    }

    default public String getCurrentAlphabetPath() {
    }

    default public String getRelativeFontPath() {
    }

    default public String getRelativeImagePath() {
    }

    default public String getRelativeLanguagePath() {
    }

    default public String getRelativeI18nPath() {
    }

    default public String getCurrentI18nPath() {
    }

    default public String getConfigurationPath() {
    }

    default public String getConfigurationFilePath(String string) {
    }

    default public String getConfigurationResourceFilePath(String string) {
    }

    @Override
    default public boolean getGpsAvailable() {
    }

    default public String getSkinEditorVersion() {
    }

    default public String getSkinFileVersion() {
    }

    default public String getSkinModelVersion() {
    }

    default public String getSkinBuildHmiSoftwareVersion() {
    }

    default public String getSkinShortVersion() {
    }

    default public String getSkinSdsLanguageHash() {
    }

    default public String getSpfName() {
    }

    default public int getSkinBrand(int n) {
    }

    default public String getTranslationDate() {
    }

    default public boolean isLanguageSupportedBySkin(String string, int n) {
    }

    default public String getFallbackLanguage(String string) {
    }

    default public boolean isSdsAvailable() {
    }

    default public String getEncodedVehicleType() {
    }

    default public String getEncodedVehicleTypeForSkin0() {
    }

    default public int getWaitStateTimeout() {
    }

    default public int getViewManagerWaitStateTimeout2() {
    }

    default public int getDynamicTmDebugProbesCfg() {
    }

    default public int[] getDynamicTmTraceCfg() {
    }

    default public int getOffClockLayout() {
    }

    default public int[] getNaviRouteOptionDefaultVignettCountryList() {
    }

    default public int[] getNaviRouteOptionDefaultCityMautList() {
    }

    default public int[] getNaviCommonOptionDefaultVisiblePoiCategories() {
    }

    default public void addNvListener(NvListener nvListener, int n) {
    }

    default public void removeNvListener(NvListener nvListener, int n) {
    }

    default public void addRtMethodListener(RtMethodListener rtMethodListener) {
    }

    default public void removeRtMethodListener(RtMethodListener rtMethodListener) {
    }

    default public void addFeatureFlagValueChangeReceiver(FeatureFlagValueChangeReceiver featureFlagValueChangeReceiver, int n) {
    }

    default public void removeFeatureFlagValueChangeReceiver(FeatureFlagValueChangeReceiver featureFlagValueChangeReceiver, int n) {
    }

    default public String getSdMountName(int n) {
    }

    default public int getEngineType() {
    }

    default public int getPrimaryFuelType() {
    }

    default public int getSecondaryFuelType() {
    }

    default public int getDriverSide() {
    }

    default public int getContextGroupForContext(int n) {
    }

    default public boolean isVehicleStatusWarningIdAvailable(int n) {
    }

    default public String getSoftwareMuPartNumber() {
    }

    default public String getPartNumber() {
    }

    default public DynamicResourceDataDescription getVzaMappingDescription() {
    }

    default public DynamicResourceDataDescription getVzeMappingDescription() {
    }

    default public DynamicResourceDataDescription getCountryCodeMappingDescription() {
    }

    default public DynamicResourceDataDescription getVehicleWarningsMappingDescription() {
    }

    default public DynamicResourceDataDescription getVehicleWarningsNarMappingDescription() {
    }

    default public boolean isStateGroupBlockable(int n) {
    }

    default public int[] getAllInstrumentClusterSizes() {
    }

    default public int getInstrumentClusterSize() {
    }

    default public String getInstrumentClusterSizeRepresentation(int n) {
    }

    default public boolean isSpaceGestureAvailable() {
    }

    default public boolean isMenuModeUserSwitchable() {
    }

    default public int getDefaultMenuMode() {
    }

    default public int getLayoutAndroidAutoCanvasDimensionHeight() {
    }

    default public int getLayoutAndroidAutoCanvasDimensionWidth() {
    }

    default public int getLayoutCarplayCanvasDimensionHeight() {
    }

    default public int getLayoutCarplayCanvasDimensionWidth() {
    }

    default public int getLayoutCarLifeCanvasDimensionHeight() {
    }

    default public int getLayoutCarLifeCanvasDimensionWidth() {
    }

    default public int getCarplayCanvasOffsetX() {
    }

    default public int getLayoutMirrorlinkCanvasDimensionHeight() {
    }

    default public int getLayoutMirrorlinkCanvasDimensionWidth() {
    }
}

