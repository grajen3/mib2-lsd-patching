/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.configuration.internal;

import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.configuration.ConfigurationManagerAsyncValueSetterService;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.configuration.NvListener;
import de.vw.mib.configuration.internal.ConfigurationManagerImpl$1;
import de.vw.mib.configuration.internal.PropertiesReader;
import de.vw.mib.configuration.internal.ServiceManager;
import de.vw.mib.configuration.internal.generated.ConfigurationManagerImplGenerated;
import de.vw.mib.dynamicresourcedata.DynamicResourceDataDescription;
import de.vw.mib.lsctng.LanguageChanger;
import de.vw.mib.lsctng.SkinChanger;
import de.vw.mib.lsctng.SkinmodeChanger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class ConfigurationManagerImpl
extends ConfigurationManagerImplGenerated
implements ConfigurationManagerDiag,
ConfigurationManagerAsyncValueSetterService {
    private static final String FILENAME_ADAPTATION_METADATA;
    private static final String FILENAME_CODING_METADATA;
    private static final String FILENAME_COPYRIGHTTEXT;
    private static final String FILENAME_COPYRIGHTINDEX;
    private static final String KEY_ENCODEDVEHICLETYPE_OVERRIDE;
    private static final int DEFAULT_SKIN_SLOTS;
    private static final String UNKNOWN_VALUE;
    private static final String KEY_INFOFILE_SKINNAME;
    private static final String KEY_INFOFILE_SKINDISPLAYNAME;
    private static final String KEY_INFOFILE_SKINMODNAME;
    private static final String KEY_INFOFILE_SKINEDITORVERSION;
    private static final String KEY_INFOFILE_SKINFILEVERSION;
    private static final String KEY_INFOFILE_SKINMODELVERSION;
    private static final String KEY_INFOFILE_SKINBUILDHMISOFTWAREVERSION;
    private static final String KEY_INFOFILE_SKINSDSLANGUAGEHASH;
    private static final String KEY_INFOFILE_SPFNAME;
    private static final String KEY_INFOFILE_SKINBRAND;
    private static final String KEY_INFOFILE_TRANSLATIONDATE;
    private static final String KEY_INFOFILE_SUPPORTEDLANGUAGES;
    private static final String KEY_INFOFILE_DEFAULTMENUMODE;
    private static final String DEFAULTMENUMODE_DEFAULT;
    private static final String KEY_INFOFILE_USERSWITCHABLEMENUMODE;
    private static final String USERSWITCHABLEMENUMODE_DEFAULT;
    private static final String KEY_INFOFILE_LAYOUT_ANDROID_AUTO_CANVAS_DIMENSION_HEIGHT;
    private static final String LAYOUT_ANDROID_AUTO_CANVAS_DIMENSION_HEIGHT;
    private static final String KEY_INFOFILE_LAYOUT_ANDROID_AUTO_CANVAS_DIMENSION_WIDTH;
    private static final String LAYOUT_ANDROID_AUTO_CANVAS_DIMENSION_WIDTH;
    private static final String KEY_INFOFILE_LAYOUT_CARPLAY_CANVAS_DIMENSION_HEIGHT;
    private static final String LAYOUT_CARPLAY_CANVAS_DIMENSION_HEIGHT;
    private static final String KEY_INFOFILE_LAYOUT_CARPLAY_CANVAS_DIMENSION_WIDTH;
    private static final String LAYOUT_CARPLAY_CANVAS_DIMENSION_WIDTH;
    private static final String KEY_INFOFILE_LAYOUT_MIRRORLINK_CANVAS_DIMENSION_HEIGHT;
    private static final String LAYOUT_MIRRORLINK_CANVAS_DIMENSION_HEIGHT;
    private static final String KEY_INFOFILE_LAYOUT_MIRRORLINK_CANVAS_DIMENSION_WIDTH;
    private static final String LAYOUT_MIRRORLINK_CANVAS_DIMENSION_WIDTH;
    private static final String ARABIC_REPLACEMENT_LANGUAGE;
    private static final String KEY_CARPLAY_CANVAS_OFFSET_X;
    private static final int CARPLAY_CANVAS_OFFSET_X_DEFAULT;
    private static final String CARLIFE_CANVAS_HEIGHT;
    private static final String CARLIFE_CANVAS_WIDTH;
    private static final int CARLIFE_CANVAS_HEIGHT_DEFAULT;
    private static final int CARLIFE_CANVAS_WIDTH_DEFAULT;
    private boolean developmentBuild = System.getProperty("de.vw.mib.developmentbuild") != null;
    private String skinSlotsAsString = System.getProperty("de.vw.mib.configuration.skinslots");
    private int skinSlots;
    private String alphabetPath = null;
    private String commonDataPath = null;
    private String currentFontPath = null;
    private String[] selectableLanguages = null;
    private boolean arabicAvailable = false;
    private int defaultSkinId = 1;
    private String defaultLanguage = null;
    private String persistedLanguage = null;
    private String[] fallbackLanguages = null;
    private String currentGuiLanguage = "de_DE";
    private int currentSkinId = 1;
    private Properties currentSkinProperties;
    private int currentSkinMode = 0;
    private final String[] skinPaths;
    private String[] sdMountNames = null;
    private String screenshotDirectories = null;
    private boolean sdsAvailable = true;
    private String encodedVehicleProject = System.getProperty("de.vw.mib.configuration.encodedVehicleType", "0203070000");
    private final String SPEECH_INPUT_DIRECTORY;
    private final String SPEECH_SVOXRES_DIRECTORY;
    private int lscState = 0;
    private int dynamicTmDebugProbesCfg = -2;
    private int[] dynamicTmTraceCfg = new int[0];
    private int waitStateTimeoutSwitchToMenu = 0;
    private final IntObjectOptHashMap nvListeners = new IntObjectOptHashMap();
    protected int[] availableSkins4CurrentLanguage;
    protected int enginetype;
    protected int primaryFueltype;
    protected int secondaryFuelType;
    protected String encodedVehicleTypeForSkin0;
    protected int driverSide = 0;
    private int[] vehicleStatusWarningIds = null;
    private String softwareMuPartNumber = "n/a";
    private String partNumber = "n/a";
    private byte[] driverDistractionPreventionConfig = new byte[0];
    private DynamicResourceDataDescription vzaMappingDescription;
    private DynamicResourceDataDescription vzeMappingDescription;
    private DynamicResourceDataDescription countryCodeMappingDescription;
    private DynamicResourceDataDescription vehicleWarningsMappingDescription;
    private DynamicResourceDataDescription vehicleWarningsNarMappingDescription;
    private int currentInstrumentClusterSize;
    private int[] allInstrumentClusterSizes;
    private String[] allInstrumentClusterSizeRepresentations;
    private boolean spaceGesturesAreAvailable = false;
    private int offClockLayout = -1;
    int[] naviCommonOptionDefaultVisiblePoiCategories = null;
    private final PropertiesReader propertiesReader;

    public ConfigurationManagerImpl(PropertiesReader propertiesReader) {
        this.SPEECH_INPUT_DIRECTORY = "/Speech/input/";
        this.SPEECH_SVOXRES_DIRECTORY = "/Speech/svox_res/";
        this.propertiesReader = propertiesReader;
        this.skinSlots = 8;
        if (this.skinSlotsAsString != null) {
            try {
                this.skinSlots = Integer.parseInt(this.skinSlotsAsString);
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
        }
        this.skinPaths = new String[1 + this.skinSlots];
        this.allInstrumentClusterSizes = new int[]{0, 1};
        this.allInstrumentClusterSizeRepresentations = new String[]{"IC_Size_Small", "IC_Size_Large"};
        this.currentInstrumentClusterSize = 0;
        if (ServiceManager.logManager != null) {
            ServiceManager.logManager.addHeartbeatInformation("hmisoftware.version", this.getHmiSoftwareVersion());
            ServiceManager.logManager.addHeartbeatInformation("hmisoftware.base.version", this.getHmiSoftwareBaseVersion());
            ServiceManager.logManager.addHeartbeatInformation("skin.short.version", this.getSkinShortVersion());
            ServiceManager.logManager.addHeartbeatInformation("vehicle.id", this.getEncodedVehicleType());
        }
    }

    public ConfigurationManagerImpl() {
        this(new PropertiesReader());
    }

    @Override
    public boolean isDevelopmentBuild() {
        return this.developmentBuild;
    }

    @Override
    public boolean isTestModeAvailable() {
        return this.isFeatureFlagSet(400);
    }

    @Override
    public String getCurrentGuiLanguage() {
        return this.currentGuiLanguage;
    }

    @Override
    public int getCurrentSkinId() {
        return this.currentSkinId;
    }

    @Override
    public int getCurrentSkinMode() {
        return this.currentSkinMode;
    }

    @Override
    public String getSkinName(int n) {
        String string = this.readFromInfoFile(n, "skin.name", "<not set>");
        return this.readFromInfoFile(n, "skin.displayname", string);
    }

    @Override
    public String getSkinModName(int n) {
        String string = this.readFromInfoFile(n, "skin.name", "<not set>");
        return this.readFromInfoFile(n, "skin.modname", string);
    }

    @Override
    public String getSkinPath(int n) {
        String string = this.skinPaths[n];
        if (string == null) {
            String string2 = this.getResourcesPath();
            String string3 = System.getProperty(new StringBuffer().append("cm.skin").append(n).toString(), new StringBuffer().append("skin").append(n).toString());
            this.skinPaths[n] = string = new StringBuffer().append(string2).append(string3).toString();
        }
        return string;
    }

    @Override
    public String getCurrentAlphabetPath() {
        if (this.alphabetPath != null) {
            return this.alphabetPath;
        }
        return new StringBuffer().append(this.getSkinPath(this.getCurrentSkinId())).append("/").append(this.getRelativeAlphabetPath()).toString();
    }

    @Override
    public String[] getAvailableLanguages() {
        return this.selectableLanguages;
    }

    @Override
    public boolean isArabicAvailable() {
        return this.arabicAvailable;
    }

    @Override
    public boolean isArabicReplacementActive() {
        return this.currentGuiLanguage.equals("en_SA");
    }

    @Override
    public String getDefaultLanguage() {
        if (this.defaultLanguage == null) {
            return "en_GB";
        }
        return this.defaultLanguage;
    }

    @Override
    public void setDefaultLanguage(String string) {
        this.defaultLanguage = string;
    }

    @Override
    public String getPersistedLanguage() {
        if (this.persistedLanguage == null) {
            return "NO_LANGUAGE";
        }
        return this.persistedLanguage;
    }

    @Override
    public void setPersistedLanguage(String string) {
        this.persistedLanguage = string;
    }

    @Override
    public int getLscState() {
        return this.lscState;
    }

    @Override
    public int getDefaultSkinId() {
        return this.defaultSkinId;
    }

    @Override
    public void setDefaultSkinId(int n) {
        if (n < 1 || n > 8) {
            throw new IllegalArgumentException(new StringBuffer().append("newDefaultSkinId must lie in the range from 1 to ").append(String.valueOf(8)).toString());
        }
        this.defaultSkinId = n;
    }

    @Override
    public String getRelativeI18nPath() {
        return "i18n";
    }

    @Override
    public String getCurrentI18nPath() {
        return new StringBuffer().append(this.getSkinPath(this.getCurrentSkinId())).append("/").append(this.getRelativeI18nPath()).toString();
    }

    @Override
    public String getCommonDataPath() {
        if (this.commonDataPath != null) {
            return this.commonDataPath;
        }
        return new StringBuffer().append(this.getSkinPath(this.getCommonSkinId())).append("/").append(this.getRelativeDataPath()).toString();
    }

    @Override
    public String getCurrentFontPath() {
        if (this.currentFontPath != null) {
            return this.currentFontPath;
        }
        return new StringBuffer().append(this.getSkinPath(this.getCurrentSkinId())).append("/").append(this.getRelativeFontPath()).toString();
    }

    @Override
    public String getSkinEditorVersion() {
        return this.readFromInfoFile(this.getCurrentSkinId(), "SkinSEVersion", "<not set>");
    }

    @Override
    public String getSkinFileVersion() {
        return this.readFromInfoFile(this.getCurrentSkinId(), "SkinSkinFileVersion", "<not set>");
    }

    @Override
    public String getSkinModelVersion() {
        return this.readFromInfoFile(this.getCurrentSkinId(), "SkinSkinModelVersion", "<not set>");
    }

    @Override
    public String getSkinBuildHmiSoftwareVersion() {
        return this.readFromInfoFile(this.getCurrentSkinId(), "SkinBuildHmiSoftwareVersion", "<not set>");
    }

    @Override
    public String getSkinShortVersion() {
        return new StringBuffer().append(this.getSkinName(this.getCurrentSkinId())).append("-").append(this.getPureVariant()).append("-").append(this.getSkinBrand(this.getCurrentSkinId())).toString();
    }

    @Override
    public String getSkinSdsLanguageHash() {
        return this.readFromInfoFile(this.getCurrentSkinId(), "SdsLanguageHash", "<not set>");
    }

    @Override
    public String getSpfName() {
        return this.readFromInfoFile(this.getCurrentSkinId(), "SpfName", "<not set>");
    }

    @Override
    public boolean isMenuModeUserSwitchable() {
        return "TRUE".equals(this.readFromInfoFile(this.getCurrentSkinId(), "UserSwitchableMenuMode", "false").toUpperCase());
    }

    @Override
    public int getDefaultMenuMode() {
        String string = this.readFromInfoFile(this.getCurrentSkinId(), "DefaultMenuMode", "FlowList").toUpperCase();
        if ("FLOWLIST".equals(string)) {
            return 0;
        }
        if ("GRID".equals(string)) {
            return 1;
        }
        ServiceManager.loggerFactory.getLogger(4).warn(2).append("The skin info file contains an invalid value for key '").append("DefaultMenuMode").append("': ").append(string).log();
        if ("GRID".equals("FlowList")) {
            return 1;
        }
        return 0;
    }

    @Override
    public int getSkinBrand(int n) {
        int n2 = 2;
        String string = this.readFromInfoFile(n, "SkinBrand", null);
        if (string != null) {
            boolean bl = false;
            try {
                int n3 = Integer.parseInt(string.trim());
                if (n3 >= 1 && n3 <= 6) {
                    n2 = n3;
                } else {
                    bl = true;
                }
            }
            catch (NumberFormatException numberFormatException) {
                bl = true;
            }
            if (bl) {
                ServiceManager.loggerFactory.getLogger(4).warn(2).append("The parameter for the key '").append("SkinBrand").append("' in the skin properties contains an invalid value! Using default '").append(n2).append("' instead.").log();
            }
        } else {
            ServiceManager.loggerFactory.getLogger(4).warn(2).append("The parameter for the key '").append("SkinBrand").append("' is not configured in the skin properties! Using default '").append(n2).append("' instead.").log();
        }
        return n2;
    }

    @Override
    public String getTranslationDate() {
        return this.readFromInfoFile(this.getCurrentSkinId(), "TranslationDate", "<not set>");
    }

    @Override
    public boolean isLanguageSupportedBySkin(String string, int n) {
        this.getAvailableSkins();
        if (this.availableSkins == null) {
            return false;
        }
        for (int i2 = 0; i2 < this.availableSkins.length; ++i2) {
            if (n != this.availableSkins[i2]) continue;
            String string2 = this.readFromInfoFile(n, "SupportedLanguages", "");
            return string2.indexOf(string) >= 0;
        }
        return false;
    }

    @Override
    public String getFallbackLanguage(String string) {
        if (this.selectableLanguages != null && this.fallbackLanguages != null) {
            for (int i2 = 0; i2 < this.selectableLanguages.length; ++i2) {
                if (!this.selectableLanguages[i2].equals(string)) continue;
                if (this.fallbackLanguages.length <= i2) break;
                return this.fallbackLanguages[i2] != null ? this.fallbackLanguages[i2] : string;
            }
        }
        return string;
    }

    @Override
    public int[] getAvailableSkins() {
        if (this.availableSkins == null) {
            int n = 0;
            int[] nArray = new int[this.skinSlots];
            for (int i2 = 1; i2 <= this.skinSlots; ++i2) {
                File file = new File(this.getSkinPath(i2), "info.txt");
                if (!file.exists()) continue;
                nArray[n++] = i2;
            }
            this.availableSkins = new int[n];
            System.arraycopy((Object)nArray, 0, (Object)this.availableSkins, 0, n);
        }
        return this.availableSkins;
    }

    @Override
    public int[] getAvailableSkins4CurrentGuiLanguage() {
        if (this.availableSkins4CurrentLanguage == null) {
            int n = 0;
            int[] nArray = new int[this.skinSlots];
            this.getAvailableSkins();
            if (this.availableSkins != null) {
                for (int i2 = 0; i2 < this.availableSkins.length; ++i2) {
                    int n2 = this.availableSkins[i2];
                    if (!this.isLanguageSupportedBySkin(this.currentGuiLanguage, n2)) continue;
                    nArray[n++] = n2;
                }
            }
            this.availableSkins4CurrentLanguage = new int[n];
            System.arraycopy((Object)nArray, 0, (Object)this.availableSkins4CurrentLanguage, 0, n);
        }
        return this.availableSkins4CurrentLanguage;
    }

    @Override
    public String getEncodedVehicleType() {
        return this.encodedVehicleProject;
    }

    private boolean existsDirectory4EncodedVehicleType(String string) {
        String string2 = new StringBuffer().append(this.getCommonDataPath()).append("/").append(string).toString();
        File file = new File(string2);
        return file.exists() && file.isDirectory();
    }

    @Override
    public String getEncodedVehicleTypeForSkin0() {
        if (this.encodedVehicleTypeForSkin0 == null) {
            String string = this.getEncodedVehicleType();
            this.encodedVehicleTypeForSkin0 = this.existsDirectory4EncodedVehicleType(string) ? string : (this.existsDirectory4EncodedVehicleType(string = new StringBuffer().append(string.substring(0, 8)).append("0").append(string.substring(9)).toString()) ? string : (this.existsDirectory4EncodedVehicleType(string = new StringBuffer().append(string.substring(0, 8)).append("00").toString()) ? string : (this.existsDirectory4EncodedVehicleType(string = new StringBuffer().append(string.substring(0, 2)).append("00000000").toString()) ? string : "0000000000")));
        }
        return this.encodedVehicleTypeForSkin0;
    }

    @Override
    public int getWaitStateTimeout() {
        return 500;
    }

    @Override
    public int getViewManagerWaitStateTimeout2() {
        if (this.waitStateTimeoutSwitchToMenu < 10000) {
            int n;
            String string = System.getProperty("ViewManager.WaitStateTimeoutSwitchToMenu", "20000");
            try {
                n = Integer.parseInt(string);
            }
            catch (NumberFormatException numberFormatException) {
                n = 20000;
            }
            this.waitStateTimeoutSwitchToMenu = n = Math.max(n, 10000);
        }
        return this.waitStateTimeoutSwitchToMenu;
    }

    @Override
    public void setAvailableSkins(int[] nArray) {
        this.availableSkins = nArray;
    }

    @Override
    public String getRelativeImagePath() {
        return "Images";
    }

    public String getRelativeDataPath() {
        return "Data";
    }

    @Override
    public String getRelativeFontPath() {
        return "Fonts";
    }

    @Override
    public String getRelativeLanguagePath() {
        return "Languages";
    }

    @Override
    public int getDynamicTmDebugProbesCfg() {
        return this.dynamicTmDebugProbesCfg;
    }

    @Override
    public int[] getDynamicTmTraceCfg() {
        return this.dynamicTmTraceCfg;
    }

    @Override
    public int[] getNaviRouteOptionDefaultCityMautList() {
        return null;
    }

    @Override
    public int[] getNaviRouteOptionDefaultVignettCountryList() {
        return null;
    }

    @Override
    public int[] getNaviCommonOptionDefaultVisiblePoiCategories() {
        if (this.isFeatureFlagSet(26) && this.isFeatureFlagSet(369)) {
            int[] nArray = new int[]{-202702848, 101, 1575682048};
            return nArray;
        }
        int[] nArray = new int[]{1025, 2053, 101, 2000};
        return nArray;
    }

    @Override
    public String getAdaptationMetaDataPath() {
        if (this.getConfigurationPath() == null) {
            return super.getAdaptationMetaDataPath();
        }
        return new StringBuffer().append(this.getConfigurationPath()).append("adaptation.swap").toString();
    }

    @Override
    public String getCodingMetaDataPath() {
        if (this.getConfigurationPath() == null) {
            return super.getCodingMetaDataPath();
        }
        return new StringBuffer().append(this.getConfigurationPath()).append("coding.swap").toString();
    }

    @Override
    public String getCopyrightFilePath() {
        if (this.getConfigurationPath() == null) {
            return super.getCopyrightFilePath();
        }
        return new StringBuffer().append(this.getConfigurationPath()).append("copyright.txt").toString();
    }

    @Override
    public String getCopyrightIndexFilePath() {
        if (this.getConfigurationPath() == null) {
            return super.getCopyrightIndexFilePath();
        }
        return new StringBuffer().append(this.getConfigurationPath()).append("copyright.index").toString();
    }

    @Override
    public void addNvListener(NvListener nvListener, int n) {
        CowList cowList = (CowList)this.nvListeners.get(n);
        if (cowList == null) {
            cowList = CowList.EMPTY;
        }
        cowList = cowList.add(nvListener);
        this.nvListeners.put(n, cowList);
    }

    @Override
    public void removeNvListener(NvListener nvListener, int n) {
        CowList cowList = (CowList)this.nvListeners.get(n);
        if (cowList != null) {
            cowList = cowList.remove(nvListener);
            this.nvListeners.put(n, cowList);
        }
    }

    private void notifyNvListener(int n) {
        CowList cowList = (CowList)this.nvListeners.get(n);
        if (cowList != null) {
            for (CowList cowList2 = cowList; cowList2 != CowList.EMPTY; cowList2 = cowList2.tail()) {
                ((NvListener)cowList2.head()).notifyNvListener(n);
            }
        }
    }

    @Override
    public String getSdMountName(int n) {
        if (this.sdMountNames == null) {
            int n2 = this.getNumberOfSDSlots();
            this.sdMountNames = new String[n2];
            StringBuffer stringBuffer = new StringBuffer(System.getProperty("ConfigurationManager.SdRoots", ""));
            for (int i2 = stringBuffer.length() - 1; i2 >= 0; --i2) {
                if (stringBuffer.charAt(i2) != ' ') continue;
                stringBuffer.deleteCharAt(i2);
            }
            int n3 = 0;
            for (int i3 = 0; i3 < n2; ++i3) {
                if (n3 >= stringBuffer.length()) {
                    this.sdMountNames[i3] = new StringBuffer().append("\\S").append(i3).toString();
                    continue;
                }
                int n4 = stringBuffer.indexOf(",", n3);
                if (n4 < 0) {
                    this.sdMountNames[i3] = stringBuffer.substring(n3);
                    n3 = stringBuffer.length();
                    continue;
                }
                this.sdMountNames[i3] = stringBuffer.substring(n3, n4);
                n3 = n4 + 1;
            }
        }
        if (n >= 0 && n < this.getNumberOfSDSlots()) {
            return this.sdMountNames[n];
        }
        return null;
    }

    @Override
    public String getScreenshotDirectories() {
        if (this.screenshotDirectories == null) {
            StringBuffer stringBuffer = new StringBuffer(super.getScreenshotDirectories());
            int n = 0;
            while (n < stringBuffer.length()) {
                int n2 = stringBuffer.indexOf("{sd", n);
                if (n2 <= stringBuffer.length() - 5) {
                    int n3;
                    String string = "x";
                    if (stringBuffer.charAt(n2 + 4) == '}' && (n3 = Character.getNumericValue(stringBuffer.charAt(n2 + 3))) >= 0) {
                        string = this.getSdMountName(n3);
                        if (string != null) {
                            stringBuffer.replace(n2, n2 + 5, string);
                        } else {
                            string = "x";
                        }
                    }
                    n += string.length();
                    continue;
                }
                n = stringBuffer.length();
            }
            this.screenshotDirectories = stringBuffer.toString();
        }
        return this.screenshotDirectories;
    }

    @Override
    public boolean isVehicleStatusWarningIdAvailable(int n) {
        if (this.vehicleStatusWarningIds == null) {
            this.initializeVehicleStatusWarningIds();
        }
        return Arrays.binarySearch(this.vehicleStatusWarningIds, n) >= 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void initializeVehicleStatusWarningIds() {
        File file = new File(this.getConfigurationFilePath("vehiclestatuswarningids.txt"));
        BufferedReader bufferedReader = null;
        try {
            if (file != null) {
                FileReader fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);
                int n = Integer.parseInt(bufferedReader.readLine());
                this.vehicleStatusWarningIds = new int[n];
                for (int i2 = 0; i2 < n; ++i2) {
                    this.vehicleStatusWarningIds[i2] = Integer.parseInt(bufferedReader.readLine());
                }
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            ServiceManager.loggerFactory.getLogger(4).error(2).append("Couldn't find the vehicle status warning id file '").append(file).append("'.").log();
            this.vehicleStatusWarningIds = new int[0];
        }
        catch (NumberFormatException numberFormatException) {
            ServiceManager.loggerFactory.getLogger(4).error(2).append("Number format error in vehicle status warning id file '").append(file).append("'.").log();
            this.vehicleStatusWarningIds = new int[0];
        }
        catch (IOException iOException) {
            ServiceManager.loggerFactory.getLogger(4).error(2).append("Couldn't read vehicle status warning id file '").append(file).append("'.").log();
            this.vehicleStatusWarningIds = new int[0];
        }
        finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                }
                catch (IOException iOException) {}
            }
        }
    }

    @Override
    public void setSelectableLanguages(String[] stringArray) {
        this.selectableLanguages = stringArray;
        this.arabicAvailable = false;
        for (int i2 = 0; i2 < this.selectableLanguages.length; ++i2) {
            if (!this.selectableLanguages[i2].startsWith("ar_")) continue;
            this.arabicAvailable = true;
            break;
        }
    }

    @Override
    public void setFallbackLanguages(String[] stringArray) {
        this.fallbackLanguages = stringArray;
    }

    @Override
    public void setLscState(int n) {
        this.lscState = n;
    }

    @Override
    public void setSdsAvailable(boolean bl) {
        this.sdsAvailable = bl;
    }

    @Override
    public boolean isSdsAvailable() {
        return this.sdsAvailable;
    }

    @Override
    public void setEncodedVehicleType(String string) {
        if (System.getProperty("de.vw.mib.configuration.encodedVehicleType") == null) {
            this.encodedVehicleProject = string;
            this.encodedVehicleTypeForSkin0 = null;
            if (ServiceManager.logManager != null) {
                ServiceManager.logManager.addHeartbeatInformation("vehicle.id", this.getEncodedVehicleType());
            }
        }
    }

    @Override
    public void setMediaCountryCodeHmi(String string) {
        this.mediaCountryCodeHmi = string;
    }

    @Override
    public void setDynamicTmDebugProbesCfg(int n) {
        if (n != this.dynamicTmDebugProbesCfg) {
            this.dynamicTmDebugProbesCfg = n;
            this.notifyNvListener(0);
        }
    }

    @Override
    public void setDynamicTmTraceCfg(int[] nArray) {
        this.dynamicTmTraceCfg = (int[])nArray.clone();
    }

    @Override
    public void setSoftwareMuPartNumber(String string) {
        this.softwareMuPartNumber = string;
        if (ServiceManager.logManager != null) {
            ServiceManager.logManager.addHeartbeatInformation("software.mu.version", string);
        }
    }

    @Override
    public void setPartNumber(String string) {
        this.partNumber = string;
        if (ServiceManager.logManager != null) {
            ServiceManager.logManager.addHeartbeatInformation("part.number", string);
        }
    }

    @Override
    public void setDriverDistractionPreventionConfig(byte[] byArray) {
        if (byArray == null) {
            this.logger.warn(2, "ConfigurationManager.setDriverDistractionPreventionConfig - Illegal argument: null");
        } else {
            this.driverDistractionPreventionConfig = byArray;
        }
    }

    @Override
    public byte[] getDriverDistractionPreventionConfig() {
        return this.driverDistractionPreventionConfig;
    }

    @Override
    public boolean isStateGroupBlockable(int n) {
        int n2 = n % 8;
        int n3 = n / 8;
        if (n < 0 || n3 >= this.driverDistractionPreventionConfig.length) {
            return false;
        }
        return (this.driverDistractionPreventionConfig[n3] << n2 & 0x80) != 0;
    }

    @Override
    public void setCurrentAlphabetPath(String string) {
        this.alphabetPath = string;
    }

    @Override
    public void setCommonDataPath(String string) {
        this.commonDataPath = string;
    }

    @Override
    public void setCurrentFontPath(String string) {
        this.currentFontPath = string;
    }

    private File[] getAllSpeechFiles(String string, String string2) {
        ArrayList arrayList = new ArrayList();
        File file = new File(new StringBuffer().append(this.getSkinPath(this.getCurrentSkinId())).append(string2).toString());
        File[] fileArray = file.listFiles();
        if (fileArray != null) {
            for (int i2 = 0; i2 < fileArray.length; ++i2) {
                File file2 = fileArray[i2];
                if (!file2.getName().startsWith(string)) continue;
                arrayList.add(file2);
            }
        }
        return (File[])arrayList.toArray(new File[arrayList.size()]);
    }

    @Override
    public InputStream getSpeechPrompts(String string, int n, int n2) {
        String string2 = new StringBuffer().append(this.getSkinPath(n)).append("/Speech/svox_res/").append("frenzy.prompts_").append(string).append("_").append(n2).append(".ipm").toString();
        return new FileInputStream(string2);
    }

    @Override
    public File[] getAllSpeechPrompts() {
        return this.getAllSpeechFiles("frenzy.prompts_", "/Speech/svox_res/");
    }

    @Override
    public InputStream getSpeechCommands(String string, int n) {
        String string2 = new StringBuffer().append(this.getSkinPath(n)).append("/Speech/input/").append("frenzy.commands_").append(string).append(".srgs").toString();
        return new FileInputStream(string2);
    }

    @Override
    public File[] getAllSpeechCommands() {
        return this.getAllSpeechFiles("frenzy.commands_", "/Speech/input/");
    }

    @Override
    public InputStream getCurrentGrammarReferenceTable() {
        return new FileInputStream(this.getTheGrammarReferenceTable());
    }

    @Override
    public File getTheGrammarReferenceTable() {
        return new File(new StringBuffer().append(this.getSkinPath(this.getCurrentSkinId())).append("/Speech/input/").append("GrammarReferenceTable.xml").toString());
    }

    @Override
    public InputStream getTheGrammarReferenceTableDtd() {
        return new FileInputStream(this.getTheGrammarReferenceTableDtdFile());
    }

    @Override
    public File getTheGrammarReferenceTableDtdFile() {
        return new File(new StringBuffer().append(this.getSkinPath(this.getCurrentSkinId())).append("/Speech/input/").append("GrammarReferenceTable.dtd").toString());
    }

    @Override
    public InputStream getTheGrammarMetaTable() {
        return new FileInputStream(this.getTheGrammarMetaTableFile());
    }

    @Override
    public File getTheGrammarMetaTableFile() {
        return new File(new StringBuffer().append(this.getSkinPath(this.getCurrentSkinId())).append("/Speech/input/").append("SpeechGrammarMetaInfoTable.xml").toString());
    }

    @Override
    public String[] getSupportedVehicleTypes() {
        File file = new File(this.getCommonDataPath());
        ArrayList arrayList = new ArrayList();
        String[] stringArray = file.list();
        if (stringArray != null) {
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                String string = stringArray[i2];
                if (string.length() != 10) continue;
                arrayList.add(string);
            }
        }
        return (String[])arrayList.toArray(new String[arrayList.size()]);
    }

    @Override
    public void onNewLanguage(LanguageChanger languageChanger, int n, String string) {
        this.currentGuiLanguage = string;
        this.availableSkins4CurrentLanguage = null;
        this.notifyNvListener(2);
        if (ServiceManager.logManager != null) {
            ServiceManager.logManager.addHeartbeatInformation("current.gui.language", this.getCurrentGuiLanguage());
        }
        languageChanger.setChangeResult(n, true, string);
    }

    @Override
    public void onNewSkin(SkinChanger skinChanger, int n, int n2) {
        this.currentSkinId = n2;
        this.currentSkinProperties = null;
        if (ServiceManager.logManager != null) {
            ServiceManager.logManager.addHeartbeatInformation("skin.short.version", this.getSkinShortVersion());
        }
        skinChanger.setChangeResult(n, true, n2);
        this.notifyNvListener(3);
    }

    @Override
    public void onNewSkinmode(SkinmodeChanger skinmodeChanger, int n, int n2) {
        ServiceManager.eventDispatcher.invoke(new ConfigurationManagerImpl$1(this, n2));
        skinmodeChanger.setChangeResult(n, true, n2);
    }

    protected void executeOnNewSkinmode(int n) {
        this.currentSkinMode = n;
        this.notifyNvListener(1);
    }

    @Override
    public void releaseAslStartupData() {
    }

    @Override
    public void setEngineType(int n) {
        this.enginetype = n;
    }

    @Override
    public void setPrimaryFuelType(int n) {
        this.primaryFueltype = n;
    }

    @Override
    public void setSecondaryFuelType(int n) {
        this.secondaryFuelType = n;
    }

    @Override
    public int getEngineType() {
        return this.enginetype;
    }

    @Override
    public int getPrimaryFuelType() {
        return this.primaryFueltype;
    }

    @Override
    public int getSecondaryFuelType() {
        return this.secondaryFuelType;
    }

    @Override
    public void setDriverSide(int n) {
        if (n != 0 && n != 1 && n != 2) {
            this.logger.error(2, new StringBuffer().append("ConfigurationManager.setDriverSide - Illegal argument: ").append(n).toString());
            return;
        }
        this.driverSide = n;
    }

    @Override
    public int getDriverSide() {
        return this.driverSide;
    }

    @Override
    public String getSoftwareMuPartNumber() {
        return this.softwareMuPartNumber;
    }

    @Override
    public String getPartNumber() {
        return this.partNumber;
    }

    @Override
    public DynamicResourceDataDescription getVzaMappingDescription() {
        if (ServiceManager.dynamicResourceDataFactory == null) {
            return null;
        }
        if (this.vzaMappingDescription == null) {
            try {
                this.vzaMappingDescription = ServiceManager.dynamicResourceDataFactory.newDynamicResourceData(this.getCommonDataPath(), "vza");
            }
            catch (Exception exception) {
                this.logger.error(2, "Error loading dynamic resource data (vza)!", exception);
            }
        }
        return this.vzaMappingDescription;
    }

    @Override
    public DynamicResourceDataDescription getVzeMappingDescription() {
        if (ServiceManager.dynamicResourceDataFactory == null) {
            return null;
        }
        if (this.vzeMappingDescription == null) {
            try {
                this.vzeMappingDescription = ServiceManager.dynamicResourceDataFactory.newDynamicResourceData(this.getCommonDataPath(), "vze");
            }
            catch (Exception exception) {
                this.logger.error(2, "Error loading dynamic resource data (vze)!", exception);
            }
        }
        return this.vzeMappingDescription;
    }

    @Override
    public DynamicResourceDataDescription getCountryCodeMappingDescription() {
        if (ServiceManager.dynamicResourceDataFactory == null) {
            return null;
        }
        if (this.countryCodeMappingDescription == null) {
            try {
                this.countryCodeMappingDescription = ServiceManager.dynamicResourceDataFactory.newDynamicResourceData(this.getCommonDataPath(), "countrycode");
            }
            catch (Exception exception) {
                this.logger.error(2, "Error loading dynamic resource data (countrycode)!", exception);
            }
        }
        return this.countryCodeMappingDescription;
    }

    @Override
    public DynamicResourceDataDescription getVehicleWarningsMappingDescription() {
        if (ServiceManager.dynamicResourceDataFactory == null) {
            return null;
        }
        if (this.vehicleWarningsMappingDescription == null) {
            try {
                this.vehicleWarningsMappingDescription = ServiceManager.dynamicResourceDataFactory.newDynamicResourceData(this.getCommonDataPath(), "vehiclewarnings");
            }
            catch (Exception exception) {
                this.logger.error(2, "Error loading dynamic resource data (vehiclewarnings)!", exception);
            }
        }
        return this.vehicleWarningsMappingDescription;
    }

    @Override
    public DynamicResourceDataDescription getVehicleWarningsNarMappingDescription() {
        if (ServiceManager.dynamicResourceDataFactory == null) {
            return null;
        }
        if (this.vehicleWarningsNarMappingDescription == null) {
            try {
                this.vehicleWarningsNarMappingDescription = ServiceManager.dynamicResourceDataFactory.newDynamicResourceData(this.getCommonDataPath(), "vehiclewarningsnar");
            }
            catch (Exception exception) {
                this.logger.error(2, "Error loading dynamic resource data (vehiclewarningsnar)!", exception);
            }
        }
        return this.vehicleWarningsNarMappingDescription;
    }

    @Override
    public int[] getAllInstrumentClusterSizes() {
        return this.allInstrumentClusterSizes;
    }

    @Override
    public void setInstrumentClusterSize(int n) {
        if (n != 0 && n != 1) {
            throw new IllegalArgumentException();
        }
        if (n != this.currentInstrumentClusterSize) {
            this.currentInstrumentClusterSize = n;
            this.notifyNvListener(4);
        }
    }

    @Override
    public int getInstrumentClusterSize() {
        return this.currentInstrumentClusterSize;
    }

    @Override
    public String getInstrumentClusterSizeRepresentation(int n) {
        for (int i2 = 0; i2 < this.allInstrumentClusterSizes.length; ++i2) {
            if (this.allInstrumentClusterSizes[i2] != n) continue;
            return this.allInstrumentClusterSizeRepresentations[i2];
        }
        return null;
    }

    @Override
    public void setSpaceGestureAvailability(boolean bl) {
        if (bl != this.spaceGesturesAreAvailable) {
            this.spaceGesturesAreAvailable = bl;
            this.notifyNvListener(6);
        }
    }

    @Override
    public boolean isSpaceGestureAvailable() {
        return this.spaceGesturesAreAvailable;
    }

    @Override
    public void setOffClockLayout(int n) {
        if (n != this.offClockLayout) {
            this.offClockLayout = n;
            this.notifyNvListener(5);
        }
    }

    @Override
    public int getOffClockLayout() {
        return this.offClockLayout;
    }

    @Override
    public void setCurrentGuiLanguage(String string) {
    }

    @Override
    public void setCurrentSkinMode(int n) {
        this.currentSkinMode = n;
        this.notifyNvListener(1);
    }

    @Override
    public int getLayoutAndroidAutoCanvasDimensionHeight() {
        return Integer.valueOf(this.readFromInfoFile(this.getCurrentSkinId(), "Layout.AndroidAuto.Canvas_Dimension.height", "480"));
    }

    @Override
    public int getLayoutAndroidAutoCanvasDimensionWidth() {
        return Integer.valueOf(this.readFromInfoFile(this.getCurrentSkinId(), "Layout.AndroidAuto.Canvas_Dimension.width", "800"));
    }

    @Override
    public int getLayoutCarplayCanvasDimensionHeight() {
        return Integer.valueOf(this.readFromInfoFile(this.getCurrentSkinId(), "Layout.Carplay.Canvas_Dimension.height", "480"));
    }

    @Override
    public int getLayoutCarplayCanvasDimensionWidth() {
        return Integer.valueOf(this.readFromInfoFile(this.getCurrentSkinId(), "Layout.Carplay.Canvas_Dimension.width", "800"));
    }

    @Override
    public int getLayoutMirrorlinkCanvasDimensionHeight() {
        return Integer.valueOf(this.readFromInfoFile(this.getCurrentSkinId(), "Layout.Mirrorlink.Canvas_Dimension.height", "480"));
    }

    @Override
    public int getLayoutMirrorlinkCanvasDimensionWidth() {
        return Integer.valueOf(this.readFromInfoFile(this.getCurrentSkinId(), "Layout.Mirrorlink.Canvas_Dimension.width", "800"));
    }

    @Override
    public int getCarplayCanvasOffsetX() {
        return this.readInt("Layout.Carplay.Canvas.Offset.x", 0);
    }

    @Override
    public int getLayoutCarLifeCanvasDimensionHeight() {
        return this.readInt("Layout.CarLife.Canvas_Dimension.height", 480);
    }

    @Override
    public int getLayoutCarLifeCanvasDimensionWidth() {
        return this.readInt("Layout.CarLife.Canvas_Dimension.width", 800);
    }

    private int readInt(String string, int n) {
        int n2 = this.getCurrentSkinId();
        String string2 = Integer.toString(n);
        String string3 = this.readFromInfoFile(n2, string, string2);
        try {
            return Integer.parseInt(string3.trim());
        }
        catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException(new StringBuffer().append("The value for key='").append(string).append("' must be an >int< ! Got value='").append(string3).append("', skinId='").append(n2).append("'").toString());
        }
    }

    private String readFromInfoFile(int n, String string, String string2) {
        Properties properties;
        String string3 = new StringBuffer().append(this.getSkinPath(n)).append("/").append("info.txt").toString();
        if (n == this.currentSkinId) {
            if (this.currentSkinProperties == null) {
                this.currentSkinProperties = properties = this.propertiesReader.readProperties(string3);
            } else {
                properties = this.currentSkinProperties;
            }
        } else {
            properties = this.propertiesReader.readProperties(string3);
        }
        if (properties == null) {
            return string2;
        }
        return properties.getProperty(string, string2);
    }
}

