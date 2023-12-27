/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.configuration.internal.generated;

import de.vw.mib.configuration.internal.ConfigurationManagerImpl;
import de.vw.mib.lsctng.SkinmodeChanger;

public class DefaultConfigurationManager
extends ConfigurationManagerImpl {
    @Override
    public boolean isFeatureFlagSet(int n) {
        return true;
    }

    @Override
    public int getBAPFsgFcVersion() {
        return 3041;
    }

    @Override
    public String getAdaptationMetaDataPath() {
        return "\\MMC\\HMI\\config\\adaptation.swap";
    }

    @Override
    public boolean getAM_SSEonMMX() {
        return false;
    }

    @Override
    public boolean getBAPTUNERDABDoubleTuner() {
        return false;
    }

    @Override
    public boolean getBAPTunerEnablePresetListInIC() {
        return false;
    }

    @Override
    public boolean getCarSportBoolean() {
        return false;
    }

    @Override
    public String getCodingMetaDataPath() {
        return "\\MMC\\HMI\\config\\coding.swap";
    }

    @Override
    public int getCommonSkinId() {
        return 0;
    }

    @Override
    public String getCopyrightFilePath() {
        return "\\MMC\\HMI\\config\\copyright.txt";
    }

    @Override
    public String getCopyrightIndexFilePath() {
        return "\\MMC\\HMI\\config\\copyright.index";
    }

    @Override
    public int getDefaultSkinMode() {
        return 0;
    }

    @Override
    public String getDiagClassName() {
        return "de.vw.mib.asl.framework.internal.diagnosis.variant.std2.ClassWarehouseImpl";
    }

    @Override
    public int getEventQueueSize() {
        return 5000;
    }

    @Override
    public String getFwDefaultVisiblePoiCategories() {
        return "1025;2053;101;2000";
    }

    @Override
    public boolean getGpsAvailable() {
        return true;
    }

    @Override
    public int getGraphicsFontCacheSizeMiB() {
        return 1;
    }

    @Override
    public int getGraphicsImageCacheSizeMiB() {
        return 80;
    }

    @Override
    public int getGraphicsVideoRAMSizeMiB() {
        return 64;
    }

    @Override
    public int getMediaImportNumberOfAvailableSources() {
        return 4;
    }

    @Override
    public int getMediaImportPositionCDDVD() {
        return 0;
    }

    @Override
    public int getMediaImportPositionSDCard1() {
        return 1;
    }

    @Override
    public int getMediaImportPositionSDCard2() {
        return 2;
    }

    @Override
    public int getMediaImportPositionUSB() {
        return 3;
    }

    @Override
    public int getMediaVideoNumberOfAvailableSources() {
        return 1;
    }

    @Override
    public int getMediaVideoPositionCDDVD() {
        return 0;
    }

    @Override
    public int getMediaVideoPositionCDDVDChanger() {
        return -1;
    }

    @Override
    public int getNaviInfotileDefaultContentGuidance() {
        return 3;
    }

    @Override
    public int getNaviInfotileDefaultContentNoGuidance() {
        return 3;
    }

    @Override
    public int getNumberOfSDSlots() {
        return 2;
    }

    @Override
    public int getOffClockMapType() {
        return 0;
    }

    @Override
    public int getPhoneMaxPhoneNumberCharacters() {
        return 40;
    }

    @Override
    public int getPhoneMaxPhoneNumberCharactersSds() {
        return 24;
    }

    @Override
    public int getPhoneNumberOfAddressbookEntries() {
        return 2000;
    }

    @Override
    public int getPhoneDefaultContactNameRepresentation() {
        return 1;
    }

    @Override
    public String getRelativeAlphabetPath() {
        return "Alphabets";
    }

    @Override
    public String getRelativeOpsPath() {
        return "OPS";
    }

    @Override
    public String getScreenshotDirectories() {
        return "{sd0};{sd1}";
    }

    @Override
    public boolean getSDSNavTTSAvailable() {
        return false;
    }

    @Override
    public boolean getSDSisUpdateGrammarStateSupported() {
        return true;
    }

    @Override
    public boolean getSDSMediaCountLimitedGlobally() {
        return false;
    }

    @Override
    public int getSDSMediaMaxItems() {
        return 10000;
    }

    @Override
    public int getSystemDayNightModeDefault() {
        return 2;
    }

    @Override
    public int getSystemDefaultDateFormat() {
        return 0;
    }

    @Override
    public int getSystemDisplayBrightnessDefault() {
        return 2;
    }

    @Override
    public int getSystemKeyPanelInstance() {
        return 0;
    }

    @Override
    public int getSystemPersonalisationProfilesCount() {
        return 7;
    }

    @Override
    public boolean getSystemProximityOnDefaultBoolean() {
        return true;
    }

    @Override
    public boolean getSystemShowOffClockActiveDefaultBoolean() {
        return false;
    }

    @Override
    public boolean getSystemSpecialHandlingPowerstateOFFDuringSWDL() {
        return false;
    }

    @Override
    public int getSystemSpellerLayoutDefault() {
        return 1;
    }

    @Override
    public boolean getSystemSummertimeOnDefaultBoolean() {
        return false;
    }

    @Override
    public int getSystemTimeMasterDefault() {
        return 0;
    }

    @Override
    public int getSystemTranslationHash() {
        return 1606053156;
    }

    @Override
    public int getTimerReadoutListTimeoutPromptFinished() {
        return 5000;
    }

    @Override
    public int getTimerReadoutListTimeoutPromptStarted() {
        return 2000;
    }

    @Override
    public int getTimerReadoutListUserInteraction() {
        return 500;
    }

    @Override
    public boolean getTUNERDABsupportsJumpLmBoolean() {
        return true;
    }

    @Override
    public boolean getTUNERDABsupportsScanBoolean() {
        return true;
    }

    @Override
    public int getTunerDabUserPresetLogoHeight() {
        return 120;
    }

    @Override
    public int getTunerDabUserPresetLogoWidth() {
        return 160;
    }

    @Override
    public int getTUNERFirstItemPresetBank2() {
        return 5;
    }

    @Override
    public int getTUNERFirstItemPresetBank3() {
        return 10;
    }

    @Override
    public int getTUNERNumberOfPresets() {
        return 15;
    }

    @Override
    public String getVehicleProductId() {
        return "5K0";
    }

    @Override
    public int getViewHandlerCacheSize() {
        return 8;
    }

    @Override
    public boolean getClusterInstrumentType(int n) {
        boolean[] blArray = new boolean[]{false, false, true};
        this.checkArrayIndex(n, 2);
        return blArray[n];
    }

    @Override
    public int getDisplayDefault(int n) {
        int[] nArray = new int[]{800, 480};
        this.checkArrayIndex(n, 1);
        return nArray[n];
    }

    @Override
    public int getEventPoolSize(int n) {
        int[] nArray = new int[]{20, 100, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20};
        this.checkArrayIndex(n, 25);
        return nArray[n];
    }

    @Override
    public int getNaviCommonOptionDefault(int n) {
        int[] nArray = new int[]{6, 0, 0, 20};
        this.checkArrayIndex(n, 3);
        return nArray[n];
    }

    @Override
    public boolean getNaviCommonOptionDefaultBoolean(int n) {
        boolean[] blArray = new boolean[]{true, false, false, false, false, false, false, false, false, true, false, false};
        this.checkArrayIndex(n, 11);
        return blArray[n];
    }

    @Override
    public int getNaviCountryOverviewLocationOptionDefault(int n) {
        int[] nArray = new int[]{0, 0, 0, 0, 0, 0};
        this.checkArrayIndex(n, 5);
        return nArray[n];
    }

    @Override
    public int getNaviDestInputDefault(int n) {
        int[] nArray = new int[]{25, 5};
        this.checkArrayIndex(n, 1);
        return nArray[n];
    }

    @Override
    public int getNaviDualScreenOptionDefault(int n) {
        int[] nArray = new int[]{0};
        this.checkArrayIndex(n, 0);
        return nArray[n];
    }

    @Override
    public int getNaviLocationOptionDefault(int n) {
        int[] nArray = new int[]{47, 10, 52, 26, 50, 0};
        this.checkArrayIndex(n, 5);
        return nArray[n];
    }

    @Override
    public boolean getNaviLocationOptionDefaultBoolean(int n) {
        boolean[] blArray = new boolean[]{false, false, true, false, false};
        this.checkArrayIndex(n, 4);
        return blArray[n];
    }

    @Override
    public boolean getNaviPoiSortOrderBoolean(int n) {
        boolean[] blArray = new boolean[]{true, false, false, false};
        this.checkArrayIndex(n, 3);
        return blArray[n];
    }

    @Override
    public boolean getNaviRMLOptionBoolean(int n) {
        boolean[] blArray = new boolean[]{false};
        this.checkArrayIndex(n, 0);
        return blArray[n];
    }

    @Override
    public int getNaviRouteOptionDefault(int n) {
        int[] nArray = new int[]{0, 50, 1, 0, 7, 0, 1, 7, 0, 5, 1, 1, 7, 1, 1, 1, 1, 1, 7, 1, 1, 0, 1, 7, 1, 0, 7, 6, 1, 3, 2, 5};
        this.checkArrayIndex(n, 31);
        return nArray[n];
    }

    @Override
    public boolean getNaviRouteOptionDefaultBoolean(int n) {
        boolean[] blArray = new boolean[]{false};
        this.checkArrayIndex(n, 0);
        return blArray[n];
    }

    @Override
    public boolean getNaviSplitScreenOptionDefaultBoolean(int n) {
        boolean[] blArray = new boolean[]{true, true};
        this.checkArrayIndex(n, 1);
        return blArray[n];
    }

    @Override
    public int getNaviSplitScreenOptionDefaultInteger(int n) {
        int[] nArray = new int[]{1, 5, 65, 24, 71, 30, 71, 30};
        this.checkArrayIndex(n, 7);
        return nArray[n];
    }

    @Override
    public int getWidgetPoolSize(int n) {
        int[] nArray = new int[]{10, 10};
        this.checkArrayIndex(n, 1);
        return nArray[n];
    }

    @Override
    public String getHmiSoftwareCgRunVersion() {
        return "H99.99.9-201307250735_TOOLING_201307250901";
    }

    @Override
    public void onNewSkinmode(SkinmodeChanger skinmodeChanger, int n, int n2) {
        this.executeOnNewSkinmode(n2);
        skinmodeChanger.setChangeResult(n, true, n2);
    }
}

