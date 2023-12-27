/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.configuration.internal.generated;

import de.vw.mib.configuration.internal.ConfigurationManagerBase;
import de.vw.mib.configuration.internal.generated.ConfigurationManagerGenerated;
import de.vw.mib.configuration.internal.generated.FeatureFlags;

public class ConfigurationManagerImplGenerated
extends ConfigurationManagerBase
implements ConfigurationManagerGenerated {
    private static final int OBJSWAP_WORKUNITNAMES_INDEX;
    private static final int OBJSWAP_SERVICENAMES_INDEX;
    private static final int OBJSWAP_ASLTARGETQUALIFIEDNAMES_INDEX;
    private static final int OBJSWAP_WORKUNITDATA_INDEX;
    private static final int OBJSWAP_LUMMAPPINGS_INDEX;
    private static final int OBJSWAP_LAMMAPPINGS_INDEX;
    private static final int OBJSWAP_FEATUREFLAGS_INDEX;
    private static final int OBJSWAP_BOOLEANCONSTANTS_INDEX;
    private static final int OBJSWAP_INTCONSTANTS_INDEX;
    private static final int OBJSWAP_STRINGCONSTANTS_INDEX;
    private static final int OBJSWAP_DISPLAYMANAGEMENTDATA_INDEX;
    private static final int OBJSWAP_DISPLAYMANAGEMENTINTS_INDEX;
    private static final int OBJSWAP_DISPLAYMANAGEMENTSTRINGS_INDEX;
    private static final int OBJSWAP_VERSIONS_INDEX;
    private static final int OBJSWAP_LSC_DEPENDENCIES_INDEX;
    private static final int OBJSWAP_LSC_ISOMAPPINGS_INDEX;
    private static final int OBJSWAP_LSC_HAPTICLANGUAGES_INDEX;
    private static final int OBJSWAP_LSC_SPEECHLANGUAGES_INDEX;
    private static final int OBJSWAP_LSC_SPELLERLANGUAGES_INDEX;
    private static final int OBJSWAP_LSC_USEDLSCLISTENERTYPES_INDEX;
    private static final int OBJSWAP_ASLEXCLUDETARGETS;
    private static final int OBJSWAP_FEATUREFLAGRTMETHODNAMES_INDEX;
    private static final int OBJSWAP_FEATUREFLAGRTMETHOD2FLAGINDEX_INDEX;
    private static final int OBJSWAP_KEYTIMESANDMAPPING_INDEX;
    private static final int OBJSWAP_PARTICLEANIMATIONMAP_INDEX;
    private static final int OBJSWAP_ASLSTARTUPSTRINGS_INDEX;
    private static final int DEFAULTDISPLAYCONTEXTID_INDEX;
    private static final int DEFAULTRVCDISPLAYCONTEXTID_INDEX;
    private static final int NUMBERODFDISPLAYCONTEXTS_INDEX;
    protected int[][] aft2lfts = new int[][]{{398, 644}, {70, 459, 460, 460, 461, 461, 462, 462, 463, 469, 476, 478, 505, 521, 522}, {309, 537, 584, 585, 586, 587, 588, 589, 590, 591, 592, 593, 594, 595, 596, 597, 598, 599, 600, 601, 602}, {313, 587}, {334, 607}, {51, 506}, {173, 484, 486, 498, 499, 510, 652}, {307, 533, 536, 537, 538, 539, 540, 541, 542, 543, 544, 545, 546, 547, 548, 549, 550, 551, 552, 553, 554, 555, 556, 557, 558, 559, 560, 561, 562, 563, 564, 565, 566, 567, 568, 569, 570, 571, 572, 573, 574, 575, 576, 577, 578, 582, 584, 585, 586, 587, 588, 589, 590, 591, 592, 593, 594, 595, 596, 597, 598, 599, 600, 601, 602, 621, 622, 623, 624, 625, 626, 627, 628, 629, 630, 631, 632, 633, 634, 635, 636, 637, 638, 640}, {323, 597}, {316, 590}, {392, 474, 649, 650, 651}, {255, 549}, {263, 637}, {350, 640}, {241, 533, 535, 536, 537, 538, 539, 540, 541, 542, 543, 544, 545, 546, 547, 548, 549, 550, 551, 552, 553, 554, 555, 556, 557, 558, 559, 560, 561, 562, 563, 564, 565, 566, 567, 568, 569, 570, 571, 572, 573, 574, 575, 576, 577, 578, 584, 585, 586, 587, 588, 589, 590, 591, 592, 593, 594, 595, 596, 597, 598, 599, 600, 601, 602, 621, 622, 623, 624, 625, 626, 627, 628, 629, 630, 631, 632, 633, 634, 635, 636, 637, 638, 640}, {66, 447, 448, 449}, {286, 564}, {262, 636}, {304, 639}, {296, 580}, {261, 629}, {162, 485, 529}, {192, 475, 508}, {0, 502}, {264, 630}, {320, 594}, {432, 464, 465}, {4, 451}, {354, 457}, {108, 467}, {424, 572, 575, 577}, {249, 623}, {187, 450, 458}, {329, 603, 604, 605, 606, 607, 608, 609, 610, 611, 612, 613, 614, 615, 616, 617, 618, 619, 620}, {104, 469}, {273, 552, 553, 554, 555, 556, 557, 558, 559, 560, 635}, {288, 566}, {437, 461, 462, 479}, {48, 517}, {85, 460, 461, 462}, {327, 601}, {363, 658, 659}, {294, 579}, {310, 584}, {445, 656}, {89, 530}, {322, 596}, {443, 654}, {427, 526}, {26, 459, 509, 525, 526, 621, 660}, {275, 554}, {303, 495}, {370, 489}, {434, 480}, {58, 459}, {125, 484, 486, 498, 499, 510, 528}, {25, 451}, {326, 600}, {315, 589}, {57, 521, 523, 528}, {71, 519}, {186, 475}, {355, 643, 644}, {161, 485, 529}, {184, 474}, {345, 617}, {138, 484, 486, 498, 499, 510}, {435, 461, 462, 479}, {278, 559}, {330, 603}, {436, 461, 462, 479}, {353, 460, 460, 461, 461, 462, 462, 464, 488, 489, 490, 491, 492, 493, 494, 496, 497, 512, 516, 657}, {106, 648}, {181, 452}, {168, 484, 486, 498, 499, 510}, {280, 560}, {232, 470}, {198, 473}, {281, 557}, {236, 461, 532}, {27, 650}, {289, 567}, {111, 484, 486, 498, 499, 510}, {151, 471}, {332, 605}, {276, 555}, {399, 647}, {183, 452}, {318, 592}, {340, 612}, {1, 487, 501, 503, 570, 571}, {242, 536, 538, 539, 540, 541, 542, 543, 544, 545, 546, 547, 548, 549, 550, 551, 552, 553, 554, 555, 556, 557, 558, 559, 560, 561, 562, 563, 564, 565, 566, 567, 568, 569, 570, 571, 572, 573, 574, 575, 576, 577, 578, 621, 622, 623, 624, 625, 626, 627, 628, 629, 630, 631, 632, 633, 634, 635, 636, 637, 638, 640}, {385, 450}, {328, 602}, {2, 570, 571, 573, 574, 575}, {336, 609}, {259, 627}, {321, 595}, {245, 542}, {87, 581}, {308, 583}, {65, 447, 448}, {258, 626}, {358, 643, 645}, {319, 593}, {253, 625}, {23, 451}, {324, 598}, {277, 558}, {342, 614}, {311, 585}, {191, 473}, {63, 481, 482, 483, 486}, {302, 495}, {53, 518, 519}, {314, 588}, {270, 539}, {290, 568, 569, 570, 571, 572, 573, 574, 575, 576, 577}, {335, 608}, {352, 642}, {285, 563}, {271, 634}, {267, 633}, {295, 580}, {55, 521, 522, 524, 525, 526, 527}, {397, 643, 643, 645, 646}, {73, 481, 482, 483, 486}, {59, 621, 651}, {266, 632}, {325, 599}, {107, 466}, {444, 655}, {282, 635}, {356, 643, 646}, {112, 468}, {351, 641}, {269, 538}, {247, 544}, {393, 650, 651}, {291, 577}, {60, 483}, {56, 523, 528}, {284, 562}, {341, 613}, {260, 628}, {274, 553}, {312, 586}, {343, 615}, {248, 545, 546, 547, 623, 624, 625}, {239, 495, 533, 534, 536, 537, 538, 539, 540, 541, 542, 543, 544, 545, 546, 547, 548, 549, 550, 551, 552, 553, 554, 555, 556, 557, 558, 559, 560, 561, 562, 563, 564, 565, 566, 567, 568, 569, 570, 571, 572, 573, 574, 575, 576, 577, 578, 579, 580, 583, 584, 585, 586, 587, 588, 589, 590, 591, 592, 593, 594, 595, 596, 597, 598, 599, 600, 601, 602, 621, 622, 623, 624, 625, 626, 627, 628, 629, 630, 631, 632, 633, 634, 635, 636, 637, 638, 640}, {279, 556}, {41, 457}, {369, 498, 499, 514, 660}, {193, 475, 630}, {442, 653}, {256, 538, 539, 550, 621, 622, 626, 627, 628, 629, 630, 631, 632, 633, 634, 636, 637, 638}, {268, 638}, {344, 616}, {360, 454, 455, 456, 464, 465, 513, 516, 660}, {283, 561}, {238, 487, 493, 494, 500, 501, 511, 515, 576}, {244, 541}, {77, 477}, {94, 520}, {69, 460, 461, 462, 465, 480, 650, 651}, {347, 619}, {408, 652}, {254, 548}, {68, 460, 461, 462, 465, 480}, {272, 551}, {49, 487, 488, 490, 491, 492, 496, 497, 500, 501, 504, 515, 572}, {339, 611}, {246, 543}, {252, 547}, {99, 451}, {265, 631}, {317, 591}, {337, 610}, {251, 546}, {349, 620}, {346, 618}, {97, 520}, {250, 624}, {297, 581}, {292, 578}, {190, 650, 651}, {20, 456}, {123, 484, 486, 498, 499, 510}, {84, 531}, {174, 657}, {287, 565}, {75, 472, 526, 622}, {331, 604}, {24, 451}, {105, 453, 476, 478, 491, 497, 507, 621}, {185, 649}, {243, 540}, {333, 606}};
    protected int[] onlineServiceFeatureFlags = new int[]{183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200};
    private int[] packedFeatureFlagValues;
    protected String[][] allConstantNames = new String[][]{{"BAPFsgFcVersion"}, {"AdaptationMetaDataPath"}, {"AM_SSEonMMX"}, {"BAPTUNERDABDoubleTuner"}, {"BAPTunerEnablePresetListInIC"}, {"CarSportBoolean"}, {"CodingMetaDataPath"}, {"CommonSkinId"}, {"CopyrightFilePath"}, {"CopyrightIndexFilePath"}, {"DefaultSkinMode"}, {"DiagClassName"}, {"EventQueueSize"}, {"FwDefaultVisiblePoiCategories"}, {"GpsAvailable"}, {"GraphicsFontCacheSizeMiB"}, {"GraphicsImageCacheSizeMiB"}, {"GraphicsVideoRAMSizeMiB"}, {"MediaImportNumberOfAvailableSources"}, {"MediaImportPositionCDDVD"}, {"MediaImportPositionSDCard1"}, {"MediaImportPositionSDCard2"}, {"MediaImportPositionUSB"}, {"MediaVideoNumberOfAvailableSources"}, {"MediaVideoPositionCDDVD"}, {"MediaVideoPositionCDDVDChanger"}, {"NaviInfotileDefaultContentGuidance"}, {"NaviInfotileDefaultContentNoGuidance"}, {"NumberOfSDSlots"}, {"OffClockMapType"}, {"PhoneMaxPhoneNumberCharacters"}, {"PhoneMaxPhoneNumberCharactersSds"}, {"PhoneNumberOfAddressbookEntries"}, {"PhoneDefaultContactNameRepresentation"}, {"RelativeAlphabetPath"}, {"RelativeOpsPath"}, {"ScreenshotDirectories"}, {"SDSNavTTSAvailable"}, {"SDSisUpdateGrammarStateSupported"}, {"SDSMediaCountLimitedGlobally"}, {"SDSMediaMaxItems"}, {"SystemDayNightModeDefault"}, {"SystemDefaultDateFormat"}, {"SystemDisplayBrightnessDefault"}, {"SystemKeyPanelInstance"}, {"SystemPersonalisationProfilesCount"}, {"SystemProximityOnDefaultBoolean"}, {"SystemShowOffClockActiveDefaultBoolean"}, {"SystemSpecialHandlingPowerstateOFFDuringSWDL"}, {"SystemSpellerLayoutDefault"}, {"SystemSummertimeOnDefaultBoolean"}, {"SystemTimeMasterDefault"}, {"SystemTranslationHash"}, {"TimerReadoutListTimeoutPromptFinished"}, {"TimerReadoutListTimeoutPromptStarted"}, {"TimerReadoutListUserInteraction"}, {"TUNERDABsupportsJumpLmBoolean"}, {"TUNERDABsupportsScanBoolean"}, {"TunerDabUserPresetLogoHeight"}, {"TunerDabUserPresetLogoWidth"}, {"TUNERFirstItemPresetBank2"}, {"TUNERFirstItemPresetBank3"}, {"TUNERNumberOfPresets"}, {"VehicleProductId"}, {"ViewHandlerCacheSize"}, {"ClusterInstrumentType.MLB511", "ClusterInstrumentType.Top", "ClusterInstrumentType.MQB"}, {"DisplayDefault.ResolutionWidth", "DisplayDefault.ResolutionHeight"}, {"EventPoolSize.PropertyUpdate", "EventPoolSize.SystemEvent", "EventPoolSize.ListItem", "EventPoolSize.ViewChange", "EventPoolSize.Touch", "EventPoolSize.Invocation", "EventPoolSize.SdFeatureCollection", "EventPoolSize.ListReadout", "EventPoolSize.BooleanValue", "EventPoolSize.ReadoutListSelection", "EventPoolSize.SpeechCommand", "EventPoolSize.Startup", "EventPoolSize.PopupView", "EventPoolSize.Point", "EventPoolSize.IntegerValue", "EventPoolSize.LsChange", "EventPoolSize.PopupStackChange", "EventPoolSize.HMI", "EventPoolSize.ContextChange", "EventPoolSize.PowerState", "EventPoolSize.Repaint", "EventPoolSize.State", "EventPoolSize.DynamicState", "EventPoolSize.SpellerValue", "EventPoolSize.Rotation", "EventPoolSize.Speech"}, {"NaviCommonOptionDefault.SwitchToResultListThreshold", "NaviCommonOptionDefault.FormattingRuleOffset", "NaviCommonOptionDefault.TimeDisplayFormat", "NaviCommonOptionDefault.MaxNumberOfTourDestinations"}, {"NaviCommonOptionDefaultBoolean.TouchApproachInMapFeatureAvailable", "NaviCommonOptionDefaultBoolean.ThreePlusOneBoxFeatureAvailable", "NaviCommonOptionDefaultBoolean.CrosshairModeFeatureAvailable", "NaviCommonOptionDefaultBoolean.ShowEnhancedCityModelAllViewtypes", "NaviCommonOptionDefaultBoolean.GoogleEarthCalculateZoomIndexOfZoomLevel", "NaviCommonOptionDefaultBoolean.Landmarks3DAlwaysVisible", "NaviCommonOptionDefaultBoolean.CountryOverviewAvailable", "NaviCommonOptionDefaultBoolean.GoogleStreetViewAvailable", "NaviCommonOptionDefaultBoolean.SecondDsiMapViewerControlInstanceAvailable", "NaviCommonOptionDefaultBoolean.AllowDisplayGeoCoordinates", "NaviCommonOptionDefaultBoolean.GoogleEarthAvailable", "NaviCommonOptionDefaultBoolean.DieselFuelWarningAvailable"}, {"NaviCountryOverviewLocationOptionDefault.LongitudeDeciSeconds", "NaviCountryOverviewLocationOptionDefault.LongitudeMinutes", "NaviCountryOverviewLocationOptionDefault.LongitudeDegrees", "NaviCountryOverviewLocationOptionDefault.LatitudeDegrees", "NaviCountryOverviewLocationOptionDefault.LatitudeMinutes", "NaviCountryOverviewLocationOptionDefault.LatitudeDeciSeconds"}, {"NaviDestInputDefault.ListWindowSize", "NaviDestInputDefault.ListAutoSize"}, {"NaviDualScreenOptionDefault.MapVisibility"}, {"NaviLocationOptionDefault.LongitudeMinutes", "NaviLocationOptionDefault.LongitudeDegrees", "NaviLocationOptionDefault.LatitudeDegrees", "NaviLocationOptionDefault.LatitudeMinutes", "NaviLocationOptionDefault.LongitudeSeconds", "NaviLocationOptionDefault.LatitudeSeconds"}, {"NaviLocationOptionDefaultBoolean.LatitudeSign", "NaviLocationOptionDefaultBoolean.LocationInputChinaFeaturesEnabled", "NaviLocationOptionDefaultBoolean.LocationInputEnabled", "NaviLocationOptionDefaultBoolean.LocationInputNarFeaturesEnabled", "NaviLocationOptionDefaultBoolean.LongitudeSign"}, {"NaviPoiSortOrderBoolean.CategoryClassesNatural", "NaviPoiSortOrderBoolean.TopCategoriesNatural", "NaviPoiSortOrderBoolean.PreferredBrandsNatural", "NaviPoiSortOrderBoolean.CategoryGroupsNatural"}, {"NaviRMLOptionBoolean.ExtendedItems"}, {"NaviRouteOptionDefault.RouteProfile", "NaviRouteOptionDefault.Weighting", "NaviRouteOptionDefault.CityMaut", "NaviRouteOptionDefault.HovCarPoolsLane", "NaviRouteOptionDefault.HybridMode", "NaviRouteOptionDefault.RouteType", "NaviRouteOptionDefault.Unpaved", "NaviRouteOptionDefault.DynamicTrafficPatternRecorded", "NaviRouteOptionDefault.SlopesMaxFactor", "NaviRouteOptionDefault.TimeDomain", "NaviRouteOptionDefault.ResidentialAreaHandling", "NaviRouteOptionDefault.Slopes", "NaviRouteOptionDefault.LeftRightTurn", "NaviRouteOptionDefault.DynamicTrafficPattern", "NaviRouteOptionDefault.Vignette", "NaviRouteOptionDefault.Border", "NaviRouteOptionDefault.Ferries", "NaviRouteOptionDefault.Trailer", "NaviRouteOptionDefault.EconomicTurns", "NaviRouteOptionDefault.Tollroads", "NaviRouteOptionDefault.Tunnels", "NaviRouteOptionDefault.Trail", "NaviRouteOptionDefault.Motorways", "NaviRouteOptionDefault.DynamicSpeedFlow", "NaviRouteOptionDefault.InProgressData", "NaviRouteOptionDefault.TollroadsCostPenalty", "NaviRouteOptionDefault.DynamicTrafficPatternOnline", "NaviRouteOptionDefault.Dynamic", "NaviRouteOptionDefault.Cartrain", "NaviRouteOptionDefault.NumberOfAlternativeRoutes", "NaviRouteOptionDefault.WaypointMode", "NaviRouteOptionDefault.SeasonalTimeDomain"}, {"NaviRouteOptionDefaultBoolean.AlternativeRouteCalculation"}, {"NaviSplitScreenOptionDefaultBoolean.SplitScreenNoGuidanceEnabled", "NaviSplitScreenOptionDefaultBoolean.SplitScreenGuidanceEnabled"}, {"NaviSplitScreenOptionDefaultInteger.SplitScreenNoGuidanceContent", "NaviSplitScreenOptionDefaultInteger.SplitScreenGuidanceContent", "NaviSplitScreenOptionDefaultInteger.SplitScreenSecondDisplayablePositionY", "NaviSplitScreenOptionDefaultInteger.SplitScreenSecondDisplayablePositionX", "NaviSplitScreenOptionDefaultInteger.SplitScreenEvPositionY", "NaviSplitScreenOptionDefaultInteger.SplitScreenEvPositionX", "NaviSplitScreenOptionDefaultInteger.SplitScreenKdkPositionY", "NaviSplitScreenOptionDefaultInteger.SplitScreenKdkPositionX"}, {"WidgetPoolSize.Default", "WidgetPoolSize.ControllerDefault"}};
    protected String[][] allConstValueTypesAsString = new String[][]{{"int"}, {"String"}, {"boolean"}, {"boolean"}, {"boolean"}, {"boolean"}, {"String"}, {"int"}, {"String"}, {"String"}, {"int"}, {"String"}, {"int"}, {"String"}, {"boolean"}, {"int"}, {"int"}, {"int"}, {"int"}, {"int"}, {"int"}, {"int"}, {"int"}, {"int"}, {"int"}, {"int"}, {"int"}, {"int"}, {"int"}, {"int"}, {"int"}, {"int"}, {"int"}, {"int"}, {"String"}, {"String"}, {"String"}, {"boolean"}, {"boolean"}, {"boolean"}, {"int"}, {"int"}, {"int"}, {"int"}, {"int"}, {"int"}, {"boolean"}, {"boolean"}, {"boolean"}, {"int"}, {"boolean"}, {"int"}, {"int"}, {"int"}, {"int"}, {"int"}, {"boolean"}, {"boolean"}, {"int"}, {"int"}, {"int"}, {"int"}, {"int"}, {"String"}, {"int"}, {"boolean", "boolean", "boolean"}, {"int", "int"}, {"int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int"}, {"int", "int", "int", "int"}, {"boolean", "boolean", "boolean", "boolean", "boolean", "boolean", "boolean", "boolean", "boolean", "boolean", "boolean", "boolean"}, {"int", "int", "int", "int", "int", "int"}, {"int", "int"}, {"int"}, {"int", "int", "int", "int", "int", "int"}, {"boolean", "boolean", "boolean", "boolean", "boolean"}, {"boolean", "boolean", "boolean", "boolean"}, {"boolean"}, {"int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int", "int"}, {"boolean"}, {"boolean", "boolean"}, {"int", "int", "int", "int", "int", "int", "int", "int"}, {"int", "int"}};
    protected byte[][] allConstValueTypes = new byte[][]{{1}, {2}, {0}, {0}, {0}, {0}, {2}, {1}, {2}, {2}, {1}, {2}, {1}, {2}, {0}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}, {2}, {2}, {2}, {0}, {0}, {0}, {1}, {1}, {1}, {1}, {1}, {1}, {0}, {0}, {0}, {1}, {0}, {1}, {1}, {1}, {1}, {1}, {0}, {0}, {1}, {1}, {1}, {1}, {1}, {2}, {1}, {0, 0, 0}, {1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}, {1, 1}, {1}, {1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0}, {0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {0}, {0, 0}, {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1}};
    private int[] packedBooleanValues;
    private int[] intValues;
    private String[] stringValues;

    @Override
    public long getExcludedAslTargets() {
        if (this.isObjectSwapperDataAvailable(21)) {
            return ((long[])this.objectSwapperData[21])[0];
        }
        return 0;
    }

    public ConfigurationManagerImplGenerated() {
        if (this.isObjectSwapperDataAvailable(8) && this.isObjectSwapperDataAvailable(9) && this.isObjectSwapperDataAvailable(10)) {
            this.setConstantValues((int[])this.objectSwapperData[8], (int[])this.objectSwapperData[9], (String[])this.objectSwapperData[10]);
        }
        if (this.isObjectSwapperDataAvailable(7)) {
            this.setFeatureFlagValues((int[])this.objectSwapperData[7]);
        }
    }

    protected void setFeatureFlagValues(int[] nArray) {
        this.packedFeatureFlagValues = nArray;
    }

    @Override
    public String[] getAllFeatureFlagNames() {
        return FeatureFlags.getAllFeatureFlagNames();
    }

    @Override
    public String[] getAllFeatureFlagValuesAsString() {
        String[] stringArray = new String[FeatureFlags.getAllFeatureFlagNames().length];
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            stringArray[i2] = String.valueOf(this.isFeatureFlagSet(i2));
        }
        return stringArray;
    }

    @Override
    public String[] getAllFeatureFlagTypesAsString() {
        String[] stringArray = new String[FeatureFlags.getAllFeatureFlagNames().length];
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            stringArray[i2] = this.isRuntimeFlag(i2) ? "rt" : "ct";
        }
        return stringArray;
    }

    @Override
    public byte[] getAllFeatureFlagTypes() {
        byte[] byArray = new byte[FeatureFlags.getAllFeatureFlagNames().length];
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            byArray[i2] = this.isRuntimeFlag(i2) ? (byte)1 : 0;
        }
        return byArray;
    }

    private boolean isRuntimeFlag(int n) {
        this.checkArrayIndex(n, FeatureFlags.getAllFeatureFlagNames().length - 1);
        if (n < 447) {
            return (this.packedFeatureFlagValues[this.packedFeatureFlagValues.length / 2 + (n >> 5)] & 1 << (n & 0x1F)) != 0;
        }
        int[] nArray = null;
        for (int i2 = 0; i2 < this.aft2lfts.length; ++i2) {
            nArray = this.aft2lfts[i2];
            for (int i3 = 1; i3 < nArray.length; ++i3) {
                if (i3 != n || !this.isRuntimeFlag(i2)) continue;
                return true;
            }
        }
        return false;
    }

    public void setFeatureFlagValue(int n, boolean bl) {
        this.checkArrayIndex(n, 446);
        if (this.isRuntimeFlag(n)) {
            int n2;
            int n3 = -1;
            boolean[] blArray = null;
            int[] nArray = null;
            for (n2 = 0; n2 < this.aft2lfts.length; ++n2) {
                if (this.aft2lfts[n2][0] != n) continue;
                n3 = n2;
            }
            if (n3 >= 0) {
                nArray = this.aft2lfts[n3];
                blArray = new boolean[nArray.length];
                for (n2 = 1; n2 < nArray.length; ++n2) {
                    blArray[n2] = this.isFeatureFlagSet(nArray[n2]);
                }
            }
            if (bl) {
                int n4 = n >> 5;
                this.packedFeatureFlagValues[n4] = this.packedFeatureFlagValues[n4] | 1 << (n & 0x1F);
            } else {
                int n5 = n >> 5;
                this.packedFeatureFlagValues[n5] = this.packedFeatureFlagValues[n5] & ~(1 << (n & 0x1F));
            }
            this.sendFeatureFlagUpdate(n, bl);
            this.notifyFeatureFlagValueChangeReceivers(n, bl);
            if (this.logger.isTraceEnabled(8)) {
                this.logger.trace(8).append("Feature flag '").append(this.getAllFeatureFlagNames()[n]).append("' => ").append(bl).log();
            }
            if (blArray != null && nArray != null) {
                for (n2 = 1; n2 < nArray.length; ++n2) {
                    boolean bl2 = this.isFeatureFlagSet(nArray[n2]);
                    if (bl2 == blArray[n2]) continue;
                    this.sendFeatureFlagUpdate(nArray[n2], bl2);
                    this.notifyFeatureFlagValueChangeReceivers(nArray[n2], bl2);
                    if (!this.logger.isTraceEnabled(8)) continue;
                    this.logger.trace(8).append("Feature flag '").append(this.getAllFeatureFlagNames()[nArray[n2]]).append("' => ").append(bl2).log();
                }
            }
        }
    }

    @Override
    public boolean isFeatureFlagSet(int n) {
        this.checkArrayIndex(n, FeatureFlags.getAllFeatureFlagNames().length - 1);
        if (n < 447) {
            return (this.packedFeatureFlagValues[n >> 5] & 1 << (n & 0x1F)) != 0;
        }
        switch (n) {
            case 447: {
                return this.isFeatureFlagSet(66) || this.isFeatureFlagSet(65);
            }
            case 448: {
                return !this.isFeatureFlagSet(447);
            }
            case 449: {
                return !this.isFeatureFlagSet(66);
            }
            case 450: {
                return this.isFeatureFlagSet(385) || this.isFeatureFlagSet(458);
            }
            case 451: {
                return this.isFeatureFlagSet(25) || this.isFeatureFlagSet(4) || this.isFeatureFlagSet(99) || this.isFeatureFlagSet(23) || this.isFeatureFlagSet(24);
            }
            case 452: {
                return this.isFeatureFlagSet(183) || this.isFeatureFlagSet(181);
            }
            case 453: {
                return this.isFeatureFlagSet(105);
            }
            case 454: {
                return this.isFeatureFlagSet(360);
            }
            case 455: {
                return this.isFeatureFlagSet(360);
            }
            case 456: {
                return this.isFeatureFlagSet(20) && !this.isFeatureFlagSet(360);
            }
            case 457: {
                return this.isFeatureFlagSet(41) || this.isFeatureFlagSet(354);
            }
            case 458: {
                return this.isFeatureFlagSet(187);
            }
            case 459: {
                return this.isFeatureFlagSet(58) && (!this.isFeatureFlagSet(70) || !this.isFeatureFlagSet(26));
            }
            case 460: {
                return this.isFeatureFlagSet(85) && (!this.isFeatureFlagSet(70) && !this.isFeatureFlagSet(353) || this.isFeatureFlagSet(70) && this.isFeatureFlagSet(353) || this.isFeatureFlagSet(68) || this.isFeatureFlagSet(69));
            }
            case 461: {
                return this.isFeatureFlagSet(236) && this.isFeatureFlagSet(479) && this.isFeatureFlagSet(460);
            }
            case 462: {
                return this.isFeatureFlagSet(460) && this.isFeatureFlagSet(479);
            }
            case 463: {
                return this.isFeatureFlagSet(70);
            }
            case 464: {
                return this.isFeatureFlagSet(432) || this.isFeatureFlagSet(353) || this.isFeatureFlagSet(360);
            }
            case 465: {
                return !(!this.isFeatureFlagSet(68) && !this.isFeatureFlagSet(69) || !this.isFeatureFlagSet(432) && !this.isFeatureFlagSet(360));
            }
            case 466: {
                return !this.isFeatureFlagSet(107);
            }
            case 467: {
                return !this.isFeatureFlagSet(108);
            }
            case 468: {
                return !this.isFeatureFlagSet(112);
            }
            case 469: {
                return this.isFeatureFlagSet(70) && this.isFeatureFlagSet(104);
            }
            case 470: {
                return !this.isFeatureFlagSet(232);
            }
            case 471: {
                return !this.isFeatureFlagSet(151);
            }
            case 472: {
                return this.isFeatureFlagSet(75);
            }
            case 473: {
                return this.isFeatureFlagSet(198) || this.isFeatureFlagSet(191);
            }
            case 474: {
                return this.isFeatureFlagSet(184) || this.isFeatureFlagSet(392);
            }
            case 475: {
                return this.isFeatureFlagSet(192) || this.isFeatureFlagSet(186) || this.isFeatureFlagSet(193);
            }
            case 476: {
                return !this.isFeatureFlagSet(70) || !this.isFeatureFlagSet(105);
            }
            case 477: {
                return !this.isFeatureFlagSet(77);
            }
            case 478: {
                return !this.isFeatureFlagSet(70) || !this.isFeatureFlagSet(105);
            }
            case 479: {
                return this.isFeatureFlagSet(435) && (this.isFeatureFlagSet(436) || this.isFeatureFlagSet(437));
            }
            case 480: {
                return this.isFeatureFlagSet(434) && (this.isFeatureFlagSet(68) || this.isFeatureFlagSet(69));
            }
            case 481: {
                return this.isFeatureFlagSet(73) && this.isFeatureFlagSet(63);
            }
            case 482: {
                return this.isFeatureFlagSet(73) || this.isFeatureFlagSet(63);
            }
            case 483: {
                return this.isFeatureFlagSet(482) || this.isFeatureFlagSet(60);
            }
            case 484: {
                return this.isFeatureFlagSet(173) && (this.isFeatureFlagSet(123) || this.isFeatureFlagSet(125) || this.isFeatureFlagSet(111) || this.isFeatureFlagSet(138) || this.isFeatureFlagSet(168));
            }
            case 485: {
                return this.isFeatureFlagSet(161) || this.isFeatureFlagSet(162);
            }
            case 486: {
                return this.isFeatureFlagSet(484) || this.isFeatureFlagSet(73) || this.isFeatureFlagSet(63);
            }
            case 487: {
                return this.isFeatureFlagSet(238) || this.isFeatureFlagSet(49) || this.isFeatureFlagSet(1);
            }
            case 488: {
                return this.isFeatureFlagSet(353) || this.isFeatureFlagSet(49);
            }
            case 489: {
                return this.isFeatureFlagSet(353) && this.isFeatureFlagSet(370);
            }
            case 490: {
                return this.isFeatureFlagSet(512) || this.isFeatureFlagSet(49);
            }
            case 491: {
                return this.isFeatureFlagSet(490) && this.isFeatureFlagSet(507);
            }
            case 492: {
                return !this.isFeatureFlagSet(353) && !this.isFeatureFlagSet(49);
            }
            case 493: {
                return !this.isFeatureFlagSet(353) && !this.isFeatureFlagSet(238);
            }
            case 494: {
                return this.isFeatureFlagSet(353) || this.isFeatureFlagSet(238);
            }
            case 495: {
                return this.isFeatureFlagSet(239) && this.isFeatureFlagSet(302) && this.isFeatureFlagSet(303);
            }
            case 496: {
                return this.isFeatureFlagSet(353) && this.isFeatureFlagSet(504);
            }
            case 497: {
                return this.isFeatureFlagSet(496) && this.isFeatureFlagSet(507);
            }
            case 498: {
                return this.isFeatureFlagSet(369) && this.isFeatureFlagSet(484);
            }
            case 499: {
                return this.isFeatureFlagSet(369) && this.isFeatureFlagSet(510);
            }
            case 500: {
                return !this.isFeatureFlagSet(238) && !this.isFeatureFlagSet(49);
            }
            case 501: {
                return !this.isFeatureFlagSet(238) && !this.isFeatureFlagSet(49) && !this.isFeatureFlagSet(1);
            }
            case 502: {
                return !this.isFeatureFlagSet(0);
            }
            case 503: {
                return !this.isFeatureFlagSet(1);
            }
            case 504: {
                return !this.isFeatureFlagSet(49);
            }
            case 505: {
                return !this.isFeatureFlagSet(70);
            }
            case 506: {
                return !this.isFeatureFlagSet(51);
            }
            case 507: {
                return !this.isFeatureFlagSet(105);
            }
            case 508: {
                return !this.isFeatureFlagSet(192);
            }
            case 509: {
                return !this.isFeatureFlagSet(26);
            }
            case 510: {
                return !this.isFeatureFlagSet(484);
            }
            case 511: {
                return !this.isFeatureFlagSet(238);
            }
            case 512: {
                return !this.isFeatureFlagSet(353);
            }
            case 513: {
                return !this.isFeatureFlagSet(360);
            }
            case 514: {
                return !this.isFeatureFlagSet(369);
            }
            case 515: {
                return (this.isFeatureFlagSet(238) ? 1 : 0) + (this.isFeatureFlagSet(49) ? 1 : 0) == 1;
            }
            case 516: {
                return (this.isFeatureFlagSet(360) ? 1 : 0) + (this.isFeatureFlagSet(353) ? 1 : 0) == 1;
            }
            case 517: {
                return !this.isFeatureFlagSet(48);
            }
            case 518: {
                return !this.isFeatureFlagSet(53);
            }
            case 519: {
                return this.isFeatureFlagSet(53) || this.isFeatureFlagSet(71);
            }
            case 520: {
                return this.isFeatureFlagSet(94) || this.isFeatureFlagSet(97);
            }
            case 521: {
                return this.isFeatureFlagSet(70) && (this.isFeatureFlagSet(55) || this.isFeatureFlagSet(57));
            }
            case 522: {
                return this.isFeatureFlagSet(70) && this.isFeatureFlagSet(55);
            }
            case 523: {
                return this.isFeatureFlagSet(56) || this.isFeatureFlagSet(57);
            }
            case 524: {
                return this.isFeatureFlagSet(55);
            }
            case 525: {
                return this.isFeatureFlagSet(55) && !this.isFeatureFlagSet(26);
            }
            case 526: {
                return this.isFeatureFlagSet(55) && !this.isFeatureFlagSet(26) && !this.isFeatureFlagSet(75) && !this.isFeatureFlagSet(427);
            }
            case 527: {
                return this.isFeatureFlagSet(55);
            }
            case 528: {
                return (this.isFeatureFlagSet(56) || this.isFeatureFlagSet(57)) && !this.isFeatureFlagSet(125);
            }
            case 529: {
                return !this.isFeatureFlagSet(161) && !this.isFeatureFlagSet(162);
            }
            case 530: {
                return !this.isFeatureFlagSet(89);
            }
            case 531: {
                return !this.isFeatureFlagSet(84);
            }
            case 532: {
                return this.isFeatureFlagSet(236);
            }
            case 533: {
                return this.isFeatureFlagSet(307) && this.isFeatureFlagSet(241) && this.isFeatureFlagSet(534);
            }
            case 534: {
                return this.isFeatureFlagSet(239);
            }
            case 535: {
                return this.isFeatureFlagSet(241);
            }
            case 536: {
                return this.isFeatureFlagSet(533) && this.isFeatureFlagSet(242);
            }
            case 537: {
                return this.isFeatureFlagSet(533) && this.isFeatureFlagSet(309);
            }
            case 538: {
                return this.isFeatureFlagSet(550) && this.isFeatureFlagSet(269);
            }
            case 539: {
                return this.isFeatureFlagSet(550) && this.isFeatureFlagSet(270);
            }
            case 540: {
                return this.isFeatureFlagSet(536) && this.isFeatureFlagSet(243);
            }
            case 541: {
                return this.isFeatureFlagSet(536) && this.isFeatureFlagSet(244);
            }
            case 542: {
                return this.isFeatureFlagSet(536) && this.isFeatureFlagSet(245);
            }
            case 543: {
                return this.isFeatureFlagSet(536) && this.isFeatureFlagSet(246);
            }
            case 544: {
                return this.isFeatureFlagSet(536) && this.isFeatureFlagSet(247);
            }
            case 545: {
                return this.isFeatureFlagSet(536) && this.isFeatureFlagSet(248);
            }
            case 546: {
                return this.isFeatureFlagSet(545) && this.isFeatureFlagSet(251);
            }
            case 547: {
                return this.isFeatureFlagSet(545) && this.isFeatureFlagSet(252);
            }
            case 548: {
                return this.isFeatureFlagSet(536) && this.isFeatureFlagSet(254);
            }
            case 549: {
                return this.isFeatureFlagSet(536) && this.isFeatureFlagSet(255);
            }
            case 550: {
                return this.isFeatureFlagSet(536) && this.isFeatureFlagSet(256);
            }
            case 551: {
                return this.isFeatureFlagSet(536) && this.isFeatureFlagSet(272);
            }
            case 552: {
                return this.isFeatureFlagSet(536) && this.isFeatureFlagSet(273);
            }
            case 553: {
                return this.isFeatureFlagSet(552) && this.isFeatureFlagSet(274);
            }
            case 554: {
                return this.isFeatureFlagSet(552) && this.isFeatureFlagSet(275);
            }
            case 555: {
                return this.isFeatureFlagSet(552) && this.isFeatureFlagSet(276);
            }
            case 556: {
                return this.isFeatureFlagSet(552) && this.isFeatureFlagSet(279);
            }
            case 557: {
                return this.isFeatureFlagSet(552) && this.isFeatureFlagSet(281);
            }
            case 558: {
                return this.isFeatureFlagSet(552) && this.isFeatureFlagSet(277);
            }
            case 559: {
                return this.isFeatureFlagSet(552) && this.isFeatureFlagSet(278);
            }
            case 560: {
                return this.isFeatureFlagSet(552) && this.isFeatureFlagSet(280);
            }
            case 561: {
                return this.isFeatureFlagSet(536) && this.isFeatureFlagSet(283);
            }
            case 562: {
                return this.isFeatureFlagSet(536) && this.isFeatureFlagSet(284);
            }
            case 563: {
                return this.isFeatureFlagSet(536) && this.isFeatureFlagSet(285);
            }
            case 564: {
                return this.isFeatureFlagSet(536) && this.isFeatureFlagSet(286);
            }
            case 565: {
                return this.isFeatureFlagSet(536) && this.isFeatureFlagSet(287);
            }
            case 566: {
                return this.isFeatureFlagSet(536) && this.isFeatureFlagSet(288);
            }
            case 567: {
                return this.isFeatureFlagSet(536) && this.isFeatureFlagSet(289);
            }
            case 568: {
                return this.isFeatureFlagSet(536) && this.isFeatureFlagSet(290);
            }
            case 569: {
                return this.isFeatureFlagSet(568);
            }
            case 570: {
                return this.isFeatureFlagSet(568) && this.isFeatureFlagSet(1) && !this.isFeatureFlagSet(2);
            }
            case 571: {
                return this.isFeatureFlagSet(568) && this.isFeatureFlagSet(1) && this.isFeatureFlagSet(2);
            }
            case 572: {
                return this.isFeatureFlagSet(568) && this.isFeatureFlagSet(49) && !this.isFeatureFlagSet(424);
            }
            case 573: {
                return this.isFeatureFlagSet(568) && !this.isFeatureFlagSet(2);
            }
            case 574: {
                return this.isFeatureFlagSet(568) && this.isFeatureFlagSet(2);
            }
            case 575: {
                return this.isFeatureFlagSet(568) && !this.isFeatureFlagSet(2) && !this.isFeatureFlagSet(424);
            }
            case 576: {
                return this.isFeatureFlagSet(568) && this.isFeatureFlagSet(238);
            }
            case 577: {
                return this.isFeatureFlagSet(568) && this.isFeatureFlagSet(291) && this.isFeatureFlagSet(424);
            }
            case 578: {
                return this.isFeatureFlagSet(536) && this.isFeatureFlagSet(292);
            }
            case 579: {
                return this.isFeatureFlagSet(239) && this.isFeatureFlagSet(294);
            }
            case 580: {
                return this.isFeatureFlagSet(239) && this.isFeatureFlagSet(295) && this.isFeatureFlagSet(296);
            }
            case 581: {
                return this.isFeatureFlagSet(87) && this.isFeatureFlagSet(297);
            }
            case 582: {
                return this.isFeatureFlagSet(307);
            }
            case 583: {
                return this.isFeatureFlagSet(239) && this.isFeatureFlagSet(308);
            }
            case 584: {
                return this.isFeatureFlagSet(537) && this.isFeatureFlagSet(310);
            }
            case 585: {
                return this.isFeatureFlagSet(537) && this.isFeatureFlagSet(311);
            }
            case 586: {
                return this.isFeatureFlagSet(537) && this.isFeatureFlagSet(312);
            }
            case 587: {
                return this.isFeatureFlagSet(537) && this.isFeatureFlagSet(313);
            }
            case 588: {
                return this.isFeatureFlagSet(537) && this.isFeatureFlagSet(314);
            }
            case 589: {
                return this.isFeatureFlagSet(537) && this.isFeatureFlagSet(315);
            }
            case 590: {
                return this.isFeatureFlagSet(537) && this.isFeatureFlagSet(316);
            }
            case 591: {
                return this.isFeatureFlagSet(537) && this.isFeatureFlagSet(317);
            }
            case 592: {
                return this.isFeatureFlagSet(537) && this.isFeatureFlagSet(318);
            }
            case 593: {
                return this.isFeatureFlagSet(537) && this.isFeatureFlagSet(319);
            }
            case 594: {
                return this.isFeatureFlagSet(537) && this.isFeatureFlagSet(320);
            }
            case 595: {
                return this.isFeatureFlagSet(537) && this.isFeatureFlagSet(321);
            }
            case 596: {
                return this.isFeatureFlagSet(537) && this.isFeatureFlagSet(322);
            }
            case 597: {
                return this.isFeatureFlagSet(537) && this.isFeatureFlagSet(323);
            }
            case 598: {
                return this.isFeatureFlagSet(537) && this.isFeatureFlagSet(324);
            }
            case 599: {
                return this.isFeatureFlagSet(537) && this.isFeatureFlagSet(325);
            }
            case 600: {
                return this.isFeatureFlagSet(537) && this.isFeatureFlagSet(326);
            }
            case 601: {
                return this.isFeatureFlagSet(537) && this.isFeatureFlagSet(327);
            }
            case 602: {
                return this.isFeatureFlagSet(537) && this.isFeatureFlagSet(328);
            }
            case 603: {
                return this.isFeatureFlagSet(329) && this.isFeatureFlagSet(330);
            }
            case 604: {
                return this.isFeatureFlagSet(329) && this.isFeatureFlagSet(331);
            }
            case 605: {
                return this.isFeatureFlagSet(329) && this.isFeatureFlagSet(332);
            }
            case 606: {
                return this.isFeatureFlagSet(329) && this.isFeatureFlagSet(333);
            }
            case 607: {
                return this.isFeatureFlagSet(329) && this.isFeatureFlagSet(334);
            }
            case 608: {
                return this.isFeatureFlagSet(329) && this.isFeatureFlagSet(335);
            }
            case 609: {
                return this.isFeatureFlagSet(329) && this.isFeatureFlagSet(336);
            }
            case 610: {
                return this.isFeatureFlagSet(329) && this.isFeatureFlagSet(337);
            }
            case 611: {
                return this.isFeatureFlagSet(329) && this.isFeatureFlagSet(339);
            }
            case 612: {
                return this.isFeatureFlagSet(329) && this.isFeatureFlagSet(340);
            }
            case 613: {
                return this.isFeatureFlagSet(329) && this.isFeatureFlagSet(341);
            }
            case 614: {
                return this.isFeatureFlagSet(329) && this.isFeatureFlagSet(342);
            }
            case 615: {
                return this.isFeatureFlagSet(329) && this.isFeatureFlagSet(343);
            }
            case 616: {
                return this.isFeatureFlagSet(329) && this.isFeatureFlagSet(344);
            }
            case 617: {
                return this.isFeatureFlagSet(329) && this.isFeatureFlagSet(345);
            }
            case 618: {
                return this.isFeatureFlagSet(329) && this.isFeatureFlagSet(346);
            }
            case 619: {
                return this.isFeatureFlagSet(329) && this.isFeatureFlagSet(347);
            }
            case 620: {
                return this.isFeatureFlagSet(329) && this.isFeatureFlagSet(349);
            }
            case 621: {
                return this.isFeatureFlagSet(536) && this.isFeatureFlagSet(256) && (this.isFeatureFlagSet(59) || this.isFeatureFlagSet(105) || this.isFeatureFlagSet(26));
            }
            case 622: {
                return this.isFeatureFlagSet(536) && this.isFeatureFlagSet(256) && this.isFeatureFlagSet(75);
            }
            case 623: {
                return this.isFeatureFlagSet(545) && this.isFeatureFlagSet(249);
            }
            case 624: {
                return this.isFeatureFlagSet(545) && this.isFeatureFlagSet(250);
            }
            case 625: {
                return this.isFeatureFlagSet(545) && this.isFeatureFlagSet(253);
            }
            case 626: {
                return this.isFeatureFlagSet(550) && this.isFeatureFlagSet(258);
            }
            case 627: {
                return this.isFeatureFlagSet(550) && this.isFeatureFlagSet(259);
            }
            case 628: {
                return this.isFeatureFlagSet(550) && this.isFeatureFlagSet(260);
            }
            case 629: {
                return this.isFeatureFlagSet(550) && this.isFeatureFlagSet(261);
            }
            case 630: {
                return this.isFeatureFlagSet(550) && this.isFeatureFlagSet(264) && this.isFeatureFlagSet(193);
            }
            case 631: {
                return this.isFeatureFlagSet(550) && this.isFeatureFlagSet(265);
            }
            case 632: {
                return this.isFeatureFlagSet(550) && this.isFeatureFlagSet(266);
            }
            case 633: {
                return this.isFeatureFlagSet(550) && this.isFeatureFlagSet(267);
            }
            case 634: {
                return this.isFeatureFlagSet(550) && this.isFeatureFlagSet(271);
            }
            case 635: {
                return this.isFeatureFlagSet(552) && this.isFeatureFlagSet(282);
            }
            case 636: {
                return this.isFeatureFlagSet(550) && this.isFeatureFlagSet(262);
            }
            case 637: {
                return this.isFeatureFlagSet(550) && this.isFeatureFlagSet(263);
            }
            case 638: {
                return this.isFeatureFlagSet(550) && this.isFeatureFlagSet(268);
            }
            case 639: {
                return this.isFeatureFlagSet(304);
            }
            case 640: {
                return this.isFeatureFlagSet(536) && this.isFeatureFlagSet(350);
            }
            case 641: {
                return this.isFeatureFlagSet(351);
            }
            case 642: {
                return this.isFeatureFlagSet(352);
            }
            case 643: {
                return this.isFeatureFlagSet(397) && !this.isFeatureFlagSet(355) && !this.isFeatureFlagSet(356) && !this.isFeatureFlagSet(645);
            }
            case 644: {
                return this.isFeatureFlagSet(398) && this.isFeatureFlagSet(355);
            }
            case 645: {
                return this.isFeatureFlagSet(397) && this.isFeatureFlagSet(358);
            }
            case 646: {
                return this.isFeatureFlagSet(397) && this.isFeatureFlagSet(356);
            }
            case 647: {
                return this.isFeatureFlagSet(399);
            }
            case 648: {
                return this.isFeatureFlagSet(106);
            }
            case 649: {
                return this.isFeatureFlagSet(185) || this.isFeatureFlagSet(392);
            }
            case 650: {
                return this.isFeatureFlagSet(190) && !this.isFeatureFlagSet(392) && !this.isFeatureFlagSet(393) && this.isFeatureFlagSet(27) && this.isFeatureFlagSet(69);
            }
            case 651: {
                return this.isFeatureFlagSet(190) && !this.isFeatureFlagSet(392) && !this.isFeatureFlagSet(393) && this.isFeatureFlagSet(59) && this.isFeatureFlagSet(69);
            }
            case 652: {
                return this.isFeatureFlagSet(173) && this.isFeatureFlagSet(408);
            }
            case 653: {
                return !this.isFeatureFlagSet(442);
            }
            case 654: {
                return !this.isFeatureFlagSet(443);
            }
            case 655: {
                return !this.isFeatureFlagSet(444);
            }
            case 656: {
                return !this.isFeatureFlagSet(445);
            }
            case 657: {
                return this.isFeatureFlagSet(174) && this.isFeatureFlagSet(512);
            }
            case 658: {
                return this.isFeatureFlagSet(363);
            }
            case 659: {
                return !this.isFeatureFlagSet(658);
            }
            case 660: {
                return this.isFeatureFlagSet(360) && this.isFeatureFlagSet(26) && this.isFeatureFlagSet(369);
            }
        }
        this.logger.error(2).append(new Exception(new StringBuffer().append("isFeatureFlagSet(").append(n).append("): Something went very very wrong!!!").toString())).log();
        return false;
    }

    public void setOnlineService(boolean bl) {
        for (int i2 = 0; i2 < this.onlineServiceFeatureFlags.length; ++i2) {
            this.setFeatureFlagValue(this.onlineServiceFeatureFlags[i2], bl);
        }
    }

    public void setFeatureFlagValue(String string, boolean bl) {
        if (this.isObjectSwapperDataAvailable(22) && this.isObjectSwapperDataAvailable(23)) {
            int n;
            String[] stringArray = (String[])this.objectSwapperData[22];
            int[] nArray = (int[])this.objectSwapperData[23];
            int n2 = -1;
            for (n = 0; n < stringArray.length; ++n) {
                if (!string.equals(stringArray[n])) continue;
                n2 = n;
                break;
            }
            if (n2 >= 0) {
                n = 0;
                while (n2-- > 0) {
                    n += 1 + nArray[n];
                }
                int n3 = nArray[n++];
                for (int i2 = 0; i2 < n3; ++i2) {
                    this.setFeatureFlagValue(nArray[n++], bl);
                }
                this.notifyRtMethodListeners(string);
            }
        }
    }

    protected void sendFeatureFlagUpdate(int n, boolean bl) {
        this.observer.receiveFeatureFlagUpdate(n, bl ? "true" : "false");
    }

    @Override
    public int getBAPFsgFcVersion() {
        return this.intValues == null ? 3041 : this.intValues[0];
    }

    @Override
    public String getAdaptationMetaDataPath() {
        return this.stringValues == null ? "\\MMC\\HMI\\config\\adaptation.swap" : this.stringValues[0];
    }

    @Override
    public boolean getAM_SSEonMMX() {
        return this.packedBooleanValues == null ? false : (this.packedBooleanValues[0] & 1) != 0;
    }

    @Override
    public boolean getBAPTUNERDABDoubleTuner() {
        return this.packedBooleanValues == null ? false : (this.packedBooleanValues[0] & 2) != 0;
    }

    @Override
    public boolean getBAPTunerEnablePresetListInIC() {
        return this.packedBooleanValues == null ? false : (this.packedBooleanValues[0] & 4) != 0;
    }

    @Override
    public boolean getCarSportBoolean() {
        return this.packedBooleanValues == null ? false : (this.packedBooleanValues[0] & 8) != 0;
    }

    @Override
    public String getCodingMetaDataPath() {
        return this.stringValues == null ? "\\MMC\\HMI\\config\\coding.swap" : this.stringValues[1];
    }

    @Override
    public int getCommonSkinId() {
        return this.intValues == null ? 0 : this.intValues[1];
    }

    @Override
    public String getCopyrightFilePath() {
        return this.stringValues == null ? "\\MMC\\HMI\\config\\copyright.txt" : this.stringValues[2];
    }

    @Override
    public String getCopyrightIndexFilePath() {
        return this.stringValues == null ? "\\MMC\\HMI\\config\\copyright.index" : this.stringValues[3];
    }

    @Override
    public int getDefaultSkinMode() {
        return this.intValues == null ? 0 : this.intValues[2];
    }

    @Override
    public String getDiagClassName() {
        return this.stringValues == null ? "de.vw.mib.asl.framework.internal.diagnosis.variant.std2.ClassWarehouseImpl" : this.stringValues[4];
    }

    @Override
    public int getEventQueueSize() {
        return this.intValues == null ? 5000 : this.intValues[3];
    }

    @Override
    public String getFwDefaultVisiblePoiCategories() {
        return this.stringValues == null ? "1025;2053;101;2000" : this.stringValues[5];
    }

    @Override
    public boolean getGpsAvailable() {
        return this.packedBooleanValues == null ? true : (this.packedBooleanValues[0] & 0x10) != 0;
    }

    @Override
    public int getGraphicsFontCacheSizeMiB() {
        return this.intValues == null ? 1 : this.intValues[4];
    }

    @Override
    public int getGraphicsImageCacheSizeMiB() {
        return this.intValues == null ? 80 : this.intValues[5];
    }

    @Override
    public int getGraphicsVideoRAMSizeMiB() {
        return this.intValues == null ? 64 : this.intValues[6];
    }

    @Override
    public int getMediaImportNumberOfAvailableSources() {
        return this.intValues == null ? 4 : this.intValues[7];
    }

    @Override
    public int getMediaImportPositionCDDVD() {
        return this.intValues == null ? 0 : this.intValues[8];
    }

    @Override
    public int getMediaImportPositionSDCard1() {
        return this.intValues == null ? 1 : this.intValues[9];
    }

    @Override
    public int getMediaImportPositionSDCard2() {
        return this.intValues == null ? 2 : this.intValues[10];
    }

    @Override
    public int getMediaImportPositionUSB() {
        return this.intValues == null ? 3 : this.intValues[11];
    }

    @Override
    public int getMediaVideoNumberOfAvailableSources() {
        return this.intValues == null ? 1 : this.intValues[12];
    }

    @Override
    public int getMediaVideoPositionCDDVD() {
        return this.intValues == null ? 0 : this.intValues[13];
    }

    @Override
    public int getMediaVideoPositionCDDVDChanger() {
        return this.intValues == null ? -1 : this.intValues[14];
    }

    @Override
    public int getNaviInfotileDefaultContentGuidance() {
        return this.intValues == null ? 3 : this.intValues[15];
    }

    @Override
    public int getNaviInfotileDefaultContentNoGuidance() {
        return this.intValues == null ? 3 : this.intValues[16];
    }

    @Override
    public int getNumberOfSDSlots() {
        return this.intValues == null ? 2 : this.intValues[17];
    }

    @Override
    public int getOffClockMapType() {
        return this.intValues == null ? 0 : this.intValues[18];
    }

    @Override
    public int getPhoneMaxPhoneNumberCharacters() {
        return this.intValues == null ? 40 : this.intValues[19];
    }

    @Override
    public int getPhoneMaxPhoneNumberCharactersSds() {
        return this.intValues == null ? 24 : this.intValues[20];
    }

    @Override
    public int getPhoneNumberOfAddressbookEntries() {
        return this.intValues == null ? 2000 : this.intValues[21];
    }

    @Override
    public int getPhoneDefaultContactNameRepresentation() {
        return this.intValues == null ? 1 : this.intValues[22];
    }

    @Override
    public String getRelativeAlphabetPath() {
        return this.stringValues == null ? "Alphabets" : this.stringValues[6];
    }

    @Override
    public String getRelativeOpsPath() {
        return this.stringValues == null ? "OPS" : this.stringValues[7];
    }

    @Override
    public String getScreenshotDirectories() {
        return this.stringValues == null ? "{sd0};{sd1}" : this.stringValues[8];
    }

    @Override
    public boolean getSDSNavTTSAvailable() {
        return this.packedBooleanValues == null ? false : (this.packedBooleanValues[0] & 0x20) != 0;
    }

    @Override
    public boolean getSDSisUpdateGrammarStateSupported() {
        return this.packedBooleanValues == null ? true : (this.packedBooleanValues[0] & 0x40) != 0;
    }

    @Override
    public boolean getSDSMediaCountLimitedGlobally() {
        return this.packedBooleanValues == null ? false : (this.packedBooleanValues[0] & 0x80) != 0;
    }

    @Override
    public int getSDSMediaMaxItems() {
        return this.intValues == null ? 10000 : this.intValues[23];
    }

    @Override
    public int getSystemDayNightModeDefault() {
        return this.intValues == null ? 2 : this.intValues[24];
    }

    @Override
    public int getSystemDefaultDateFormat() {
        return this.intValues == null ? 0 : this.intValues[25];
    }

    @Override
    public int getSystemDisplayBrightnessDefault() {
        return this.intValues == null ? 2 : this.intValues[26];
    }

    @Override
    public int getSystemKeyPanelInstance() {
        return this.intValues == null ? 0 : this.intValues[27];
    }

    @Override
    public int getSystemPersonalisationProfilesCount() {
        return this.intValues == null ? 7 : this.intValues[28];
    }

    @Override
    public boolean getSystemProximityOnDefaultBoolean() {
        return this.packedBooleanValues == null ? true : (this.packedBooleanValues[0] & 0x100) != 0;
    }

    @Override
    public boolean getSystemShowOffClockActiveDefaultBoolean() {
        return this.packedBooleanValues == null ? false : (this.packedBooleanValues[0] & 0x200) != 0;
    }

    @Override
    public boolean getSystemSpecialHandlingPowerstateOFFDuringSWDL() {
        return this.packedBooleanValues == null ? false : (this.packedBooleanValues[0] & 0x400) != 0;
    }

    @Override
    public int getSystemSpellerLayoutDefault() {
        return this.intValues == null ? 1 : this.intValues[29];
    }

    @Override
    public boolean getSystemSummertimeOnDefaultBoolean() {
        return this.packedBooleanValues == null ? false : (this.packedBooleanValues[0] & 0x800) != 0;
    }

    @Override
    public int getSystemTimeMasterDefault() {
        return this.intValues == null ? 0 : this.intValues[30];
    }

    @Override
    public int getSystemTranslationHash() {
        return this.intValues == null ? 1606053156 : this.intValues[31];
    }

    @Override
    public int getTimerReadoutListTimeoutPromptFinished() {
        return this.intValues == null ? 5000 : this.intValues[32];
    }

    @Override
    public int getTimerReadoutListTimeoutPromptStarted() {
        return this.intValues == null ? 2000 : this.intValues[33];
    }

    @Override
    public int getTimerReadoutListUserInteraction() {
        return this.intValues == null ? 500 : this.intValues[34];
    }

    @Override
    public boolean getTUNERDABsupportsJumpLmBoolean() {
        return this.packedBooleanValues == null ? true : (this.packedBooleanValues[0] & 0x1000) != 0;
    }

    @Override
    public boolean getTUNERDABsupportsScanBoolean() {
        return this.packedBooleanValues == null ? true : (this.packedBooleanValues[0] & 0x2000) != 0;
    }

    @Override
    public int getTunerDabUserPresetLogoHeight() {
        return this.intValues == null ? 120 : this.intValues[35];
    }

    @Override
    public int getTunerDabUserPresetLogoWidth() {
        return this.intValues == null ? 160 : this.intValues[36];
    }

    @Override
    public int getTUNERFirstItemPresetBank2() {
        return this.intValues == null ? 5 : this.intValues[37];
    }

    @Override
    public int getTUNERFirstItemPresetBank3() {
        return this.intValues == null ? 10 : this.intValues[38];
    }

    @Override
    public int getTUNERNumberOfPresets() {
        return this.intValues == null ? 15 : this.intValues[39];
    }

    @Override
    public String getVehicleProductId() {
        return this.stringValues == null ? "5K0" : this.stringValues[9];
    }

    @Override
    public int getViewHandlerCacheSize() {
        return this.intValues == null ? 8 : this.intValues[40];
    }

    protected void setConstantValues(int[] nArray, int[] nArray2, String[] stringArray) {
        this.packedBooleanValues = nArray;
        this.intValues = nArray2;
        this.stringValues = stringArray;
    }

    @Override
    public boolean getClusterInstrumentType(int n) {
        int[] nArray = new int[]{15, 16, 14};
        boolean[] blArray = new boolean[]{false, false, true};
        this.checkArrayIndex(n, 2);
        if (this.packedBooleanValues == null) {
            return blArray[n];
        }
        int n2 = nArray[n];
        return (this.packedBooleanValues[n2 >> 5] & 1 << (n2 & 0x1F)) != 0;
    }

    @Override
    public int getDisplayDefault(int n) {
        int[] nArray = new int[]{42, 41};
        int[] nArray2 = new int[]{800, 480};
        this.checkArrayIndex(n, 1);
        if (this.intValues == null) {
            return nArray2[n];
        }
        return this.intValues[nArray[n]];
    }

    @Override
    public int getEventPoolSize(int n) {
        int[] nArray = new int[]{56, 66, 49, 68, 67, 48, 60, 50, 43, 57, 62, 64, 54, 52, 47, 51, 53, 46, 44, 55, 58, 65, 45, 63, 59, 61};
        int[] nArray2 = new int[]{20, 100, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20};
        this.checkArrayIndex(n, 25);
        if (this.intValues == null) {
            return nArray2[n];
        }
        return this.intValues[nArray[n]];
    }

    @Override
    public int getNaviCommonOptionDefault(int n) {
        int[] nArray = new int[]{72, 70, 69, 71};
        int[] nArray2 = new int[]{6, 0, 0, 20};
        this.checkArrayIndex(n, 3);
        if (this.intValues == null) {
            return nArray2[n];
        }
        return this.intValues[nArray[n]];
    }

    @Override
    public boolean getNaviCommonOptionDefaultBoolean(int n) {
        int[] nArray = new int[]{28, 27, 19, 26, 22, 24, 18, 23, 25, 17, 21, 20};
        boolean[] blArray = new boolean[]{true, false, false, false, false, false, false, false, false, true, false, false};
        this.checkArrayIndex(n, 11);
        if (this.packedBooleanValues == null) {
            return blArray[n];
        }
        int n2 = nArray[n];
        return (this.packedBooleanValues[n2 >> 5] & 1 << (n2 & 0x1F)) != 0;
    }

    @Override
    public int getNaviCountryOverviewLocationOptionDefault(int n) {
        int[] nArray = new int[]{78, 77, 76, 73, 74, 75};
        int[] nArray2 = new int[]{0, 0, 0, 0, 0, 0};
        this.checkArrayIndex(n, 5);
        if (this.intValues == null) {
            return nArray2[n];
        }
        return this.intValues[nArray[n]];
    }

    @Override
    public int getNaviDestInputDefault(int n) {
        int[] nArray = new int[]{80, 79};
        int[] nArray2 = new int[]{25, 5};
        this.checkArrayIndex(n, 1);
        if (this.intValues == null) {
            return nArray2[n];
        }
        return this.intValues[nArray[n]];
    }

    @Override
    public int getNaviDualScreenOptionDefault(int n) {
        int[] nArray = new int[]{81};
        int[] nArray2 = new int[]{0};
        this.checkArrayIndex(n, 0);
        if (this.intValues == null) {
            return nArray2[n];
        }
        return this.intValues[nArray[n]];
    }

    @Override
    public int getNaviLocationOptionDefault(int n) {
        int[] nArray = new int[]{86, 85, 82, 83, 87, 84};
        int[] nArray2 = new int[]{47, 10, 52, 26, 50, 0};
        this.checkArrayIndex(n, 5);
        if (this.intValues == null) {
            return nArray2[n];
        }
        return this.intValues[nArray[n]];
    }

    @Override
    public boolean getNaviLocationOptionDefaultBoolean(int n) {
        int[] nArray = new int[]{29, 30, 31, 32, 33};
        boolean[] blArray = new boolean[]{false, false, true, false, false};
        this.checkArrayIndex(n, 4);
        if (this.packedBooleanValues == null) {
            return blArray[n];
        }
        int n2 = nArray[n];
        return (this.packedBooleanValues[n2 >> 5] & 1 << (n2 & 0x1F)) != 0;
    }

    @Override
    public boolean getNaviPoiSortOrderBoolean(int n) {
        int[] nArray = new int[]{34, 37, 36, 35};
        boolean[] blArray = new boolean[]{true, false, false, false};
        this.checkArrayIndex(n, 3);
        if (this.packedBooleanValues == null) {
            return blArray[n];
        }
        int n2 = nArray[n];
        return (this.packedBooleanValues[n2 >> 5] & 1 << (n2 & 0x1F)) != 0;
    }

    @Override
    public boolean getNaviRMLOptionBoolean(int n) {
        int[] nArray = new int[]{38};
        boolean[] blArray = new boolean[]{false};
        this.checkArrayIndex(n, 0);
        if (this.packedBooleanValues == null) {
            return blArray[n];
        }
        int n2 = nArray[n];
        return (this.packedBooleanValues[n2 >> 5] & 1 << (n2 & 0x1F)) != 0;
    }

    @Override
    public int getNaviRouteOptionDefault(int n) {
        int[] nArray = new int[]{105, 119, 90, 98, 99, 106, 116, 95, 109, 110, 104, 108, 101, 93, 117, 88, 97, 114, 96, 111, 115, 113, 102, 92, 100, 112, 94, 91, 89, 103, 118, 107};
        int[] nArray2 = new int[]{0, 50, 1, 0, 7, 0, 1, 7, 0, 5, 1, 1, 7, 1, 1, 1, 1, 1, 7, 1, 1, 0, 1, 7, 1, 0, 7, 6, 1, 3, 2, 5};
        this.checkArrayIndex(n, 31);
        if (this.intValues == null) {
            return nArray2[n];
        }
        return this.intValues[nArray[n]];
    }

    @Override
    public boolean getNaviRouteOptionDefaultBoolean(int n) {
        int[] nArray = new int[]{39};
        boolean[] blArray = new boolean[]{false};
        this.checkArrayIndex(n, 0);
        if (this.packedBooleanValues == null) {
            return blArray[n];
        }
        int n2 = nArray[n];
        return (this.packedBooleanValues[n2 >> 5] & 1 << (n2 & 0x1F)) != 0;
    }

    @Override
    public boolean getNaviSplitScreenOptionDefaultBoolean(int n) {
        int[] nArray = new int[]{41, 40};
        boolean[] blArray = new boolean[]{true, true};
        this.checkArrayIndex(n, 1);
        if (this.packedBooleanValues == null) {
            return blArray[n];
        }
        int n2 = nArray[n];
        return (this.packedBooleanValues[n2 >> 5] & 1 << (n2 & 0x1F)) != 0;
    }

    @Override
    public int getNaviSplitScreenOptionDefaultInteger(int n) {
        int[] nArray = new int[]{125, 122, 127, 126, 121, 120, 124, 123};
        int[] nArray2 = new int[]{1, 5, 65, 24, 71, 30, 71, 30};
        this.checkArrayIndex(n, 7);
        if (this.intValues == null) {
            return nArray2[n];
        }
        return this.intValues[nArray[n]];
    }

    @Override
    public int getWidgetPoolSize(int n) {
        int[] nArray = new int[]{129, 128};
        int[] nArray2 = new int[]{10, 10};
        this.checkArrayIndex(n, 1);
        if (this.intValues == null) {
            return nArray2[n];
        }
        return this.intValues[nArray[n]];
    }

    @Override
    public String[][] getAllConstNames() {
        return this.allConstantNames;
    }

    @Override
    public String[][] getAllConstValuesAsStrings() {
        int n;
        String[][] stringArray = new String[82][];
        stringArray[0] = new String[]{String.valueOf(this.getBAPFsgFcVersion())};
        stringArray[1] = new String[]{String.valueOf(this.getAdaptationMetaDataPath())};
        stringArray[2] = new String[]{String.valueOf(this.getAM_SSEonMMX())};
        stringArray[3] = new String[]{String.valueOf(this.getBAPTUNERDABDoubleTuner())};
        stringArray[4] = new String[]{String.valueOf(this.getBAPTunerEnablePresetListInIC())};
        stringArray[5] = new String[]{String.valueOf(this.getCarSportBoolean())};
        stringArray[6] = new String[]{String.valueOf(this.getCodingMetaDataPath())};
        stringArray[7] = new String[]{String.valueOf(this.getCommonSkinId())};
        stringArray[8] = new String[]{String.valueOf(this.getCopyrightFilePath())};
        stringArray[9] = new String[]{String.valueOf(this.getCopyrightIndexFilePath())};
        stringArray[10] = new String[]{String.valueOf(this.getDefaultSkinMode())};
        stringArray[11] = new String[]{String.valueOf(this.getDiagClassName())};
        stringArray[12] = new String[]{String.valueOf(this.getEventQueueSize())};
        stringArray[13] = new String[]{String.valueOf(this.getFwDefaultVisiblePoiCategories())};
        stringArray[14] = new String[]{String.valueOf(this.getGpsAvailable())};
        stringArray[15] = new String[]{String.valueOf(this.getGraphicsFontCacheSizeMiB())};
        stringArray[16] = new String[]{String.valueOf(this.getGraphicsImageCacheSizeMiB())};
        stringArray[17] = new String[]{String.valueOf(this.getGraphicsVideoRAMSizeMiB())};
        stringArray[18] = new String[]{String.valueOf(this.getMediaImportNumberOfAvailableSources())};
        stringArray[19] = new String[]{String.valueOf(this.getMediaImportPositionCDDVD())};
        stringArray[20] = new String[]{String.valueOf(this.getMediaImportPositionSDCard1())};
        stringArray[21] = new String[]{String.valueOf(this.getMediaImportPositionSDCard2())};
        stringArray[22] = new String[]{String.valueOf(this.getMediaImportPositionUSB())};
        stringArray[23] = new String[]{String.valueOf(this.getMediaVideoNumberOfAvailableSources())};
        stringArray[24] = new String[]{String.valueOf(this.getMediaVideoPositionCDDVD())};
        stringArray[25] = new String[]{String.valueOf(this.getMediaVideoPositionCDDVDChanger())};
        stringArray[26] = new String[]{String.valueOf(this.getNaviInfotileDefaultContentGuidance())};
        stringArray[27] = new String[]{String.valueOf(this.getNaviInfotileDefaultContentNoGuidance())};
        stringArray[28] = new String[]{String.valueOf(this.getNumberOfSDSlots())};
        stringArray[29] = new String[]{String.valueOf(this.getOffClockMapType())};
        stringArray[30] = new String[]{String.valueOf(this.getPhoneMaxPhoneNumberCharacters())};
        stringArray[31] = new String[]{String.valueOf(this.getPhoneMaxPhoneNumberCharactersSds())};
        stringArray[32] = new String[]{String.valueOf(this.getPhoneNumberOfAddressbookEntries())};
        stringArray[33] = new String[]{String.valueOf(this.getPhoneDefaultContactNameRepresentation())};
        stringArray[34] = new String[]{String.valueOf(this.getRelativeAlphabetPath())};
        stringArray[35] = new String[]{String.valueOf(this.getRelativeOpsPath())};
        stringArray[36] = new String[]{String.valueOf(this.getScreenshotDirectories())};
        stringArray[37] = new String[]{String.valueOf(this.getSDSNavTTSAvailable())};
        stringArray[38] = new String[]{String.valueOf(this.getSDSisUpdateGrammarStateSupported())};
        stringArray[39] = new String[]{String.valueOf(this.getSDSMediaCountLimitedGlobally())};
        stringArray[40] = new String[]{String.valueOf(this.getSDSMediaMaxItems())};
        stringArray[41] = new String[]{String.valueOf(this.getSystemDayNightModeDefault())};
        stringArray[42] = new String[]{String.valueOf(this.getSystemDefaultDateFormat())};
        stringArray[43] = new String[]{String.valueOf(this.getSystemDisplayBrightnessDefault())};
        stringArray[44] = new String[]{String.valueOf(this.getSystemKeyPanelInstance())};
        stringArray[45] = new String[]{String.valueOf(this.getSystemPersonalisationProfilesCount())};
        stringArray[46] = new String[]{String.valueOf(this.getSystemProximityOnDefaultBoolean())};
        stringArray[47] = new String[]{String.valueOf(this.getSystemShowOffClockActiveDefaultBoolean())};
        stringArray[48] = new String[]{String.valueOf(this.getSystemSpecialHandlingPowerstateOFFDuringSWDL())};
        stringArray[49] = new String[]{String.valueOf(this.getSystemSpellerLayoutDefault())};
        stringArray[50] = new String[]{String.valueOf(this.getSystemSummertimeOnDefaultBoolean())};
        stringArray[51] = new String[]{String.valueOf(this.getSystemTimeMasterDefault())};
        stringArray[52] = new String[]{String.valueOf(this.getSystemTranslationHash())};
        stringArray[53] = new String[]{String.valueOf(this.getTimerReadoutListTimeoutPromptFinished())};
        stringArray[54] = new String[]{String.valueOf(this.getTimerReadoutListTimeoutPromptStarted())};
        stringArray[55] = new String[]{String.valueOf(this.getTimerReadoutListUserInteraction())};
        stringArray[56] = new String[]{String.valueOf(this.getTUNERDABsupportsJumpLmBoolean())};
        stringArray[57] = new String[]{String.valueOf(this.getTUNERDABsupportsScanBoolean())};
        stringArray[58] = new String[]{String.valueOf(this.getTunerDabUserPresetLogoHeight())};
        stringArray[59] = new String[]{String.valueOf(this.getTunerDabUserPresetLogoWidth())};
        stringArray[60] = new String[]{String.valueOf(this.getTUNERFirstItemPresetBank2())};
        stringArray[61] = new String[]{String.valueOf(this.getTUNERFirstItemPresetBank3())};
        stringArray[62] = new String[]{String.valueOf(this.getTUNERNumberOfPresets())};
        stringArray[63] = new String[]{String.valueOf(this.getVehicleProductId())};
        stringArray[64] = new String[]{String.valueOf(this.getViewHandlerCacheSize())};
        String[] stringArray2 = new String[3];
        for (n = 0; n < stringArray2.length; ++n) {
            stringArray2[n] = String.valueOf(this.getClusterInstrumentType(n));
        }
        stringArray[65] = stringArray2;
        stringArray2 = new String[2];
        for (n = 0; n < stringArray2.length; ++n) {
            stringArray2[n] = String.valueOf(this.getDisplayDefault(n));
        }
        stringArray[66] = stringArray2;
        stringArray2 = new String[26];
        for (n = 0; n < stringArray2.length; ++n) {
            stringArray2[n] = String.valueOf(this.getEventPoolSize(n));
        }
        stringArray[67] = stringArray2;
        stringArray2 = new String[4];
        for (n = 0; n < stringArray2.length; ++n) {
            stringArray2[n] = String.valueOf(this.getNaviCommonOptionDefault(n));
        }
        stringArray[68] = stringArray2;
        stringArray2 = new String[12];
        for (n = 0; n < stringArray2.length; ++n) {
            stringArray2[n] = String.valueOf(this.getNaviCommonOptionDefaultBoolean(n));
        }
        stringArray[69] = stringArray2;
        stringArray2 = new String[6];
        for (n = 0; n < stringArray2.length; ++n) {
            stringArray2[n] = String.valueOf(this.getNaviCountryOverviewLocationOptionDefault(n));
        }
        stringArray[70] = stringArray2;
        stringArray2 = new String[2];
        for (n = 0; n < stringArray2.length; ++n) {
            stringArray2[n] = String.valueOf(this.getNaviDestInputDefault(n));
        }
        stringArray[71] = stringArray2;
        stringArray2 = new String[1];
        for (n = 0; n < stringArray2.length; ++n) {
            stringArray2[n] = String.valueOf(this.getNaviDualScreenOptionDefault(n));
        }
        stringArray[72] = stringArray2;
        stringArray2 = new String[6];
        for (n = 0; n < stringArray2.length; ++n) {
            stringArray2[n] = String.valueOf(this.getNaviLocationOptionDefault(n));
        }
        stringArray[73] = stringArray2;
        stringArray2 = new String[5];
        for (n = 0; n < stringArray2.length; ++n) {
            stringArray2[n] = String.valueOf(this.getNaviLocationOptionDefaultBoolean(n));
        }
        stringArray[74] = stringArray2;
        stringArray2 = new String[4];
        for (n = 0; n < stringArray2.length; ++n) {
            stringArray2[n] = String.valueOf(this.getNaviPoiSortOrderBoolean(n));
        }
        stringArray[75] = stringArray2;
        stringArray2 = new String[1];
        for (n = 0; n < stringArray2.length; ++n) {
            stringArray2[n] = String.valueOf(this.getNaviRMLOptionBoolean(n));
        }
        stringArray[76] = stringArray2;
        stringArray2 = new String[32];
        for (n = 0; n < stringArray2.length; ++n) {
            stringArray2[n] = String.valueOf(this.getNaviRouteOptionDefault(n));
        }
        stringArray[77] = stringArray2;
        stringArray2 = new String[1];
        for (n = 0; n < stringArray2.length; ++n) {
            stringArray2[n] = String.valueOf(this.getNaviRouteOptionDefaultBoolean(n));
        }
        stringArray[78] = stringArray2;
        stringArray2 = new String[2];
        for (n = 0; n < stringArray2.length; ++n) {
            stringArray2[n] = String.valueOf(this.getNaviSplitScreenOptionDefaultBoolean(n));
        }
        stringArray[79] = stringArray2;
        stringArray2 = new String[8];
        for (n = 0; n < stringArray2.length; ++n) {
            stringArray2[n] = String.valueOf(this.getNaviSplitScreenOptionDefaultInteger(n));
        }
        stringArray[80] = stringArray2;
        stringArray2 = new String[2];
        for (n = 0; n < stringArray2.length; ++n) {
            stringArray2[n] = String.valueOf(this.getWidgetPoolSize(n));
        }
        stringArray[81] = stringArray2;
        return stringArray;
    }

    @Override
    public byte[][] getAllConstValueTypes() {
        return this.allConstValueTypes;
    }

    @Override
    public String[][] getAllConstValueTypesAsString() {
        return this.allConstValueTypesAsString;
    }

    @Override
    public int[] getStartupWorkUnitData() {
        if (this.isObjectSwapperDataAvailable(4)) {
            return (int[])this.objectSwapperData[4];
        }
        return null;
    }

    @Override
    public String getWorkUnitName(int n) {
        if (this.isObjectSwapperDataAvailable(1)) {
            return ((String[])this.objectSwapperData[1])[n - 1];
        }
        return null;
    }

    @Override
    public String getServiceName(int n) {
        if (this.isObjectSwapperDataAvailable(2)) {
            return ((String[])this.objectSwapperData[2])[n];
        }
        return null;
    }

    @Override
    public String getAslTargetQualifiedName(int n) {
        if (this.isObjectSwapperDataAvailable(3)) {
            return ((String[])this.objectSwapperData[3])[n];
        }
        return null;
    }

    @Override
    public int[] getLumMappings() {
        if (this.isObjectSwapperDataAvailable(5)) {
            return (int[])this.objectSwapperData[5];
        }
        return null;
    }

    @Override
    public int[] getLamMappings() {
        if (this.isObjectSwapperDataAvailable(6)) {
            return (int[])this.objectSwapperData[6];
        }
        return null;
    }

    @Override
    public String getAslStartupString(int n) {
        if (this.isObjectSwapperDataAvailable(28)) {
            return ((String[])this.objectSwapperData[28])[n];
        }
        return null;
    }

    @Override
    public void releaseAslStartupData() {
    }

    @Override
    public boolean shouldHaveSameLanguage(int n, int n2) {
        return this.getLscDependencyType(n, n2) == 2;
    }

    @Override
    public boolean mustHaveSameLanguage(int n, int n2) {
        return this.getLscDependencyType(n, n2) == 1;
    }

    @Override
    public int getLscDependencyType(int n, int n2) {
        int n3 = n & 0xFF;
        int n4 = n2 & 0xFF;
        if (n3 < 0 || n3 > 11 || n4 < 0 || n4 > 11) {
            this.logger.error(2).append(new Exception(new StringBuffer().append("Invalid LscListenerTypeID (shouldHaveSameLanguage(").append(n3).append(", ").append(n4).append(").").toString())).log();
        }
        if (this.isObjectSwapperDataAvailable(15)) {
            int[] nArray = (int[])this.objectSwapperData[15];
            for (int i2 = 0; i2 < nArray.length; i2 += 3) {
                if (nArray[i2] != n4 || nArray[i2 + 1] != n3) continue;
                return nArray[i2 + 2];
            }
        }
        return 0;
    }

    @Override
    public int[] getUsedLscListenerTypes() {
        if (this.isObjectSwapperDataAvailable(20)) {
            return (int[])this.objectSwapperData[20];
        }
        return new int[0];
    }

    @Override
    public String getLscListenerTypeName(int n) {
        String[] stringArray = new String[]{"Generic", "GUI", "ConfigManager", "Widgets", "SpeechTTS", "SpeechSDS", "NavGUI", "NavTTS", "Phone", "Addressbook", "Instrumentcluster", "Media"};
        if (n >= 0 && n < 12) {
            return stringArray[n];
        }
        return "{invalid LSC listener type}";
    }

    @Override
    public String[] getVariantDefinedLanguages() {
        return this.getHapticLanguages();
    }

    @Override
    public String[] getHapticLanguages() {
        if (this.isObjectSwapperDataAvailable(17)) {
            return (String[])this.objectSwapperData[17];
        }
        return null;
    }

    @Override
    public String[] getSpeechLanguages() {
        if (this.isObjectSwapperDataAvailable(18)) {
            return (String[])this.objectSwapperData[18];
        }
        return null;
    }

    @Override
    public String[] getSpellerLanguages() {
        if (this.isObjectSwapperDataAvailable(19)) {
            return (String[])this.objectSwapperData[19];
        }
        return null;
    }

    @Override
    public String getLanguageReplacement(String string) {
        if (this.isObjectSwapperDataAvailable(16)) {
            String[] stringArray = (String[])this.objectSwapperData[16];
            for (int i2 = 0; i2 < stringArray.length; i2 += 3) {
                if (!stringArray[i2].equals(string) || !stringArray[i2 + 1].equals(this.mediaCountryCodeHmi)) continue;
                return stringArray[i2 + 2];
            }
        }
        return string;
    }

    @Override
    public int[] getUsedDisplayContextData() {
        if (this.isObjectSwapperDataAvailable(11)) {
            return (int[])this.objectSwapperData[11];
        }
        return null;
    }

    public int getContextGroupForContext(int n) {
        if (this.isObjectSwapperDataAvailable(12)) {
            int[] nArray = (int[])this.objectSwapperData[12];
            int n2 = nArray[2];
            int n3 = 3;
            while (n2-- > 0) {
                if (nArray[n3] == n) {
                    return nArray[n3 + 2];
                }
                n3 += 3;
            }
        }
        return -1;
    }

    @Override
    public String getDisplayContextName(int n) {
        if (this.isObjectSwapperDataAvailable(12)) {
            int[] nArray = (int[])this.objectSwapperData[12];
            int n2 = nArray[2];
            int n3 = 3;
            while (n2-- > 0) {
                if (nArray[n3] == n) {
                    int n4 = nArray[n3 + 1];
                    return ((String[])this.objectSwapperData[13])[n4];
                }
                n3 += 3;
            }
        }
        return null;
    }

    @Override
    public String getDisplayableName(int n) {
        if (this.isObjectSwapperDataAvailable(12)) {
            int[] nArray = (int[])this.objectSwapperData[12];
            int n2 = nArray[2];
            int n3 = 2 + n2 * 3 + 1;
            int n4 = nArray[n3++];
            while (n4-- > 0) {
                if (nArray[n3] == n) {
                    int n5 = nArray[n3 + 1];
                    return ((String[])this.objectSwapperData[13])[n5];
                }
                n3 += 2;
            }
        }
        return null;
    }

    @Override
    public int getDefaultDisplayContextId() {
        if (this.isObjectSwapperDataAvailable(12)) {
            return ((int[])this.objectSwapperData[12])[0];
        }
        return -1;
    }

    @Override
    public int getDefaultRvcDisplayContextId() {
        if (this.isObjectSwapperDataAvailable(12)) {
            return ((int[])this.objectSwapperData[12])[1];
        }
        return -1;
    }

    @Override
    public int[] getKeyTimesAndMappingsData() {
        if (this.isObjectSwapperDataAvailable(24)) {
            return (int[])this.objectSwapperData[24];
        }
        return null;
    }

    @Override
    public String getParticleParameterSetName(String string, int n) {
        if (this.isObjectSwapperDataAvailable(27)) {
            String[] stringArray = (String[])this.objectSwapperData[27];
            String string2 = new StringBuffer().append(string).append(';').append(String.valueOf(n)).toString();
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                if (!stringArray[i2++].equals(string2)) continue;
                return stringArray[i2];
            }
        }
        return null;
    }

    @Override
    public String getPureHmiBaseVersion() {
        String string = this.getHmiSoftwareBaseVersion();
        String string2 = "missing";
        int n = string.indexOf(45);
        if (n > 0) {
            string2 = string.substring(0, n);
        }
        return string2;
    }

    @Override
    public String getPureVariant() {
        int n;
        String string = this.getHmiSoftwareCgRunVersion();
        String string2 = "missing";
        int n2 = string.lastIndexOf(95);
        if (n2 > 0 && (n = string.indexOf(95)) < n2 - 1) {
            string2 = string.substring(n + 1, n2);
        }
        return string2;
    }

    @Override
    public String getHmiSoftwareVersion() {
        return new StringBuffer().append(this.getPureHmiBaseVersion()).append("_").append(this.getPureVariant()).toString();
    }

    @Override
    public String getHmiSoftwareBaseVersion() {
        return "H29.319.29-201707121419";
    }

    @Override
    public String getHmiSoftwareCgRunVersion() {
        return ((String[])this.objectSwapperData[14])[0];
    }
}

