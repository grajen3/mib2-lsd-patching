/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.global.sd.internal;

import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.asl.api.speechengine.features.GenericTargetFeature;
import de.vw.mib.asl.api.speechengine.features.complex.ComplexCommandFeature;
import de.vw.mib.asl.api.speechengine.features.complex.ComplexHelpPromptsFeature;
import de.vw.mib.asl.api.speechengine.features.complex.ComplexInitialPromptsFeature;
import de.vw.mib.asl.api.speechengine.features.complex.ComplexTeleprompterDataFeature;
import de.vw.mib.asl.api.speechengine.features.model.DynamicString;
import de.vw.mib.asl.api.speechengine.features.model.OrderedPrompts;
import de.vw.mib.asl.api.speechengine.features.model.Prompt;
import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.datapool.FormatterService;
import de.vw.mib.sdfeaturecollectionmanager.internal.AbstractSdFeatureCollectionHandler$SdCommandData;
import generated.de.vw.mib.global.datapool.SdFeatureCollectionHandlerBase;
import java.util.ArrayList;

public final class SpeechMediaSdfch
extends SdFeatureCollectionHandlerBase {
    private static int[] SSMDHMC_37_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{1};
    private static int[] SSMDHMC_37_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{1};
    private static int[] SSMDHMC_37_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_MEDIA_HELP_MODE = new int[]{0, 1};
    private static int[] SSMDHSC_3C_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{1};
    private static int[] SSMDHSC_3C_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{1};
    private static int[] SSMDHSC_3C_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_MEDIA_HELP_MODE = new int[]{0, 1};
    private static int[] SSMDMMC_55_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{1};
    private static int[] SSMDMMC_55_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{1};
    private static int[] SSMDMMC_55_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_MEDIA_HELP_MODE = new int[]{0, 1};
    private static int[] SSMDMPS_58_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0, 2};
    private static int[] SSMDMPS_58_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0, 2};
    private static int[] SSMDMPS_58_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{0, 2};
    private static int[] SSMDMPS_58_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{0, 2};
    private static int[] SSMDMPS_58_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_REQUEST_GET_MUSIC_USE_CASE = new int[]{0, 1, 2, 3};
    private static int[] SSMDMS_59_AFFECTED_FEATURES_FOR_CONDITION_8 = new int[]{1};
    private static int[] SSMDMS_59_AFFECTED_FEATURES_FOR_CONDITION_9 = new int[]{1};
    private static int[] SSMDMS_59_AFFECTED_FEATURES_FOR_CONDITION_10 = new int[]{1};
    private static int[] SSMDMS_59_AFFECTED_FEATURES_FOR_CONDITION_11 = new int[]{1};
    private static int[] SSMDMS_59_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_REQUEST_GET_MUSIC_USE_CASE = new int[]{8, 9, 10, 11};
    private static int[] SSMDMSL_5E_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSMDMSL_5E_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{0};
    private static int[] SSMDMSL_5E_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{0};
    private static int[] SSMDMSL_5E_AFFECTED_FEATURES_FOR_CONDITION_4 = new int[]{0};
    private static int[] SSMDMSL_5E_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_REQUEST_GET_MUSIC_USE_CASE = new int[]{1, 2, 3, 4};
    private static int[] SSMDSSL_6C_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSMDSSL_6C_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSMDSSL_6C_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{0};
    private static int[] SSMDSSL_6C_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{0};
    private static int[] SSMDSSL_6C_AFFECTED_FEATURES_FOR_CONDITION_4 = new int[]{0};
    private static int[] SSMDSSL_6C_AFFECTED_FEATURES_FOR_CONDITION_5 = new int[]{0};
    private static int[] SSMDSSL_6C_AFFECTED_FEATURES_FOR_CONDITION_6 = new int[]{0};
    private static int[] SSMDSSL_6C_AFFECTED_FEATURES_FOR_CONDITION_7 = new int[]{0};
    private static int[] SSMDSSL_6C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_AUX = new int[]{0};
    private static int[] SSMDSSL_6C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_BT = new int[]{1};
    private static int[] SSMDSSL_6C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_CD = new int[]{2};
    private static int[] SSMDSSL_6C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_DVD = new int[]{3};
    private static int[] SSMDSSL_6C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_JUKEBOX = new int[]{4};
    private static int[] SSMDSSL_6C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_SD = new int[]{5};
    private static int[] SSMDSSL_6C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_USB = new int[]{6};
    private static int[] SSMDSSL_6C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_WLAN = new int[]{7};
    private static int[] SSMDTS_71_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_REQUEST_GET_MUSIC_USE_CASE = new int[0];
    private static int[] SSMGGC_77_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSMGGC_77_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSMGGC_77_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{0};
    private static int[] SSMGGC_77_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{0};
    private static int[] SSMGGC_77_AFFECTED_FEATURES_FOR_CONDITION_4 = new int[]{0};
    private static int[] SSMGGC_77_AFFECTED_FEATURES_FOR_CONDITION_5 = new int[]{0};
    private static int[] SSMGGC_77_AFFECTED_FEATURES_FOR_CONDITION_6 = new int[]{0};
    private static int[] SSMGGC_77_AFFECTED_FEATURES_FOR_CONDITION_7 = new int[]{0};
    private static int[] SSMGGC_77_AFFECTED_FEATURES_FOR_CONDITION_8 = new int[]{0};
    private static int[] SSMGGC_77_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
    private static int[] SSMGGC_77_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
    private static int[] SSMGGC_77_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_AUX = new int[]{1};
    private static int[] SSMGGC_77_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_BT = new int[]{2};
    private static int[] SSMGGC_77_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_CD = new int[]{3};
    private static int[] SSMGGC_77_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_DVD = new int[]{4};
    private static int[] SSMGGC_77_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_JUKEBOX = new int[]{5};
    private static int[] SSMGGC_77_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_SD = new int[]{6};
    private static int[] SSMGGC_77_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_USB = new int[]{7};
    private static int[] SSMGGC_77_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_WLAN = new int[]{8};
    private static int[] SSMGHC_78_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSMGHC_78_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSMGHC_78_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{0};
    private static int[] SSMGHC_78_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{0};
    private static int[] SSMGHC_78_AFFECTED_FEATURES_FOR_CONDITION_4 = new int[]{0};
    private static int[] SSMGHC_78_AFFECTED_FEATURES_FOR_CONDITION_5 = new int[]{0};
    private static int[] SSMGHC_78_AFFECTED_FEATURES_FOR_CONDITION_6 = new int[]{0};
    private static int[] SSMGHC_78_AFFECTED_FEATURES_FOR_CONDITION_7 = new int[]{0};
    private static int[] SSMGHC_78_AFFECTED_FEATURES_FOR_CONDITION_8 = new int[]{0};
    private static int[] SSMGHC_78_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
    private static int[] SSMGHC_78_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
    private static int[] SSMGHC_78_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_AUX = new int[]{1};
    private static int[] SSMGHC_78_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_BT = new int[]{2};
    private static int[] SSMGHC_78_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_CD = new int[]{3};
    private static int[] SSMGHC_78_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_DVD = new int[]{4};
    private static int[] SSMGHC_78_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_JUKEBOX = new int[]{5};
    private static int[] SSMGHC_78_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_SD = new int[]{6};
    private static int[] SSMGHC_78_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_USB = new int[]{7};
    private static int[] SSMGHC_78_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_WLAN = new int[]{8};
    private static int[] SSMNDHMC_7A_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{1};
    private static int[] SSMNDHMC_7A_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{1};
    private static int[] SSMNDHMC_7A_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_MEDIA_HELP_MODE = new int[]{0, 1};
    private static int[] SSMNDHSC_7C_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{1};
    private static int[] SSMNDHSC_7C_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{1};
    private static int[] SSMNDHSC_7C_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_MEDIA_HELP_MODE = new int[]{0, 1};

    @Override
    public void init(int n, int n2) {
        this.sdFeatColId = n;
        this.speechClientId = n2;
        switch (n) {
            case 41: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 42: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 43: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 44: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 45: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 46: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 47: {
                this.conditions = new boolean[7];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 48: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 49: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 50: {
                this.featureData = new int[]{0, 0, 0};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 51: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{1521745920};
                this.featureData = new int[]{1, 3};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 52: {
                this.featureData = new int[]{0, 0, 0, 3};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 53: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 54: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 55: {
                this.featureData = new int[]{0, 0, 0};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 56: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{1521745920};
                this.featureData = new int[]{1, 3};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 57: {
                this.featureData = new int[]{1, 3};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 58: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 59: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 60: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 61: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 62: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 63: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 64: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 65: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 66: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 67: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 68: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 69: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 70: {
                this.conditions = new boolean[4];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 71: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 72: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 73: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 74: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 75: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 76: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 77: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 78: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 79: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 80: {
                this.featureData = new int[]{0, 0, 0};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 81: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{1521745920};
                this.featureData = new int[]{1, 3};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 82: {
                this.conditions = new boolean[4];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 83: {
                this.conditions = new boolean[4];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 84: {
                this.conditions = new boolean[4];
                this.dpProperties = new int[]{-1729298432};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(127, -1202048448, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(128, -1202048448, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(129, -1202048448, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(130, -1202048448, 3, false, false)};
                this.featureData = new int[]{1, 0, 1, 3};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 85: {
                this.conditions = new boolean[12];
                this.dpProperties = new int[]{-1729298432};
                this.featureData = new int[]{0, 1, 3};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 86: {
                this.conditions = new boolean[4];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 87: {
                this.conditions = new boolean[4];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 88: {
                this.conditions = new boolean[4];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 89: {
                this.conditions = new boolean[4];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 90: {
                this.conditions = new boolean[5];
                this.dpProperties = new int[]{-1729298432};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(100, -1453706688, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(101, -1436929472, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(102, -933612992, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(103, -1487261120, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(104, -1017499072, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(105, -1470483904, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(106, -1034276288, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(126, -1386597824, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(143, -1101385152, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(144, -1101385152, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(145, -1101385152, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(146, -1101385152, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 91: {
                this.conditions = new boolean[4];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 92: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 93: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 94: {
                this.featureData = new int[]{3};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 95: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 96: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 97: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 98: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 99: {
                this.conditions = new boolean[2];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 100: {
                this.featureData = new int[]{3};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 101: {
                this.featureData = new int[]{0, 0, 1, 3};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 102: {
                this.conditions = new boolean[14];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 103: {
                this.conditions = new boolean[14];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 104: {
                this.conditions = new boolean[9];
                this.dpProperties = new int[]{-1746665472, 1938358272, 1820917760, -203685888, -728432640, 0x3880000, 61997056, -306053120};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(100, -1453706688, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(101, -1436929472, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(103, -1487261120, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(105, -1470483904, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(132, -1336266176, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(133, -1319488960, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(134, -1302711744, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(135, -1285934528, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(136, -1269157312, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(137, -1386597824, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(138, -1252380096, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(139, -1235602880, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(140, -1218825664, 3, false, false)};
                this.featureData = new int[]{1, 0, 1};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 105: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 106: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 107: {
                this.conditions = new boolean[15];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 108: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 109: {
                this.dpProperties = new int[]{-1729298432};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(142, -1185271232, 3, false, false)};
                this.featureData = new int[]{1, 0, 1, 3};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 110: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 111: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 112: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 113: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 114: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 115: {
                this.conditions = new boolean[9];
                this.dpProperties = new int[]{10059, 0x7A00000, -1746665472, 1938358272, 1820917760, -203685888, -728432640, 0x3880000, 61997056, -306053120};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(93, -1587924416, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(107, -1604701632, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(108, -950390208, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(123, -1000721856, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(124, -983944640, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(125, -967167424, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(131, -1504038336, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(132, -1336266176, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(133, -1319488960, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(134, -1302711744, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(135, -1285934528, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(136, -1269157312, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(138, -1252380096, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(139, -1235602880, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(140, -1218825664, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(141, -1403375040, 1, false, false)};
                this.featureData = new int[]{1, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 116: {
                this.conditions = new boolean[9];
                this.dpProperties = new int[]{10059, 0x7A00000, -1746665472, 1938358272, 1820917760, -203685888, -728432640, 0x3880000, 61997056, -306053120};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(93, -1587924416, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(94, -1537592768, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(95, -1554369984, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(96, -1554369984, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(97, -1554369984, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(98, -1571147200, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(99, -1554369984, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(107, -1587924416, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(108, -1537592768, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(123, -1554369984, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(124, -1554369984, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(125, -1554369984, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(131, -1571147200, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(132, -1571147200, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(133, -1571147200, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(134, -1571147200, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(135, -1571147200, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(136, -1571147200, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(138, -1571147200, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(139, -1571147200, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(140, -1571147200, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(141, -1554369984, 2, false, false)};
                this.featureData = new int[]{1};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 117: {
                this.featureData = new int[]{0, 0, 0};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 118: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{1521745920};
                this.featureData = new int[]{1, 3};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 119: {
                this.featureData = new int[]{0, 0, 0};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 120: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{1521745920};
                this.featureData = new int[]{1, 3};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal sdFeatColId: ").append(this.sdFeatColId).toString());
            }
        }
    }

    @Override
    protected Feature createFeatureInstance(int n) {
        switch (this.sdFeatColId) {
            case 41: {
                return this.createFeatureInstance_SSMDA_2D(n);
            }
            case 42: {
                return this.createFeatureInstance_SSMDA_2E(n);
            }
            case 43: {
                return this.createFeatureInstance_SSMDA_2F(n);
            }
            case 44: {
                return this.createFeatureInstance_SSMDA_30(n);
            }
            case 45: {
                return this.createFeatureInstance_SSMDA_31(n);
            }
            case 46: {
                return this.createFeatureInstance_SSMDEF_32(n);
            }
            case 47: {
                return this.createFeatureInstance_SSMDENA_33(n);
            }
            case 48: {
                return this.createFeatureInstance_SSMDHMH_34(n);
            }
            case 49: {
                return this.createFeatureInstance_SSMDHMH_35(n);
            }
            case 50: {
                return this.createFeatureInstance_SSMDHM_36(n);
            }
            case 51: {
                return this.createFeatureInstance_SSMDHMC_37(n);
            }
            case 52: {
                return this.createFeatureInstance_SSMDHPS_38(n);
            }
            case 53: {
                return this.createFeatureInstance_SSMDHSH_39(n);
            }
            case 54: {
                return this.createFeatureInstance_SSMDHSH_3A(n);
            }
            case 55: {
                return this.createFeatureInstance_SSMDHS_3B(n);
            }
            case 56: {
                return this.createFeatureInstance_SSMDHSC_3C(n);
            }
            case 57: {
                return this.createFeatureInstance_SSMDI_3D(n);
            }
            case 58: {
                return this.createFeatureInstance_SSMDLFPE_3E(n);
            }
            case 59: {
                return this.createFeatureInstance_SSMDLFPE_3F(n);
            }
            case 60: {
                return this.createFeatureInstance_SSMDLFP_40(n);
            }
            case 61: {
                return this.createFeatureInstance_SSMDLFP_41(n);
            }
            case 62: {
                return this.createFeatureInstance_SSMDLGC_42(n);
            }
            case 63: {
                return this.createFeatureInstance_SSMDLGO_43(n);
            }
            case 64: {
                return this.createFeatureInstance_SSMDLLPE_44(n);
            }
            case 65: {
                return this.createFeatureInstance_SSMDLLPE_45(n);
            }
            case 66: {
                return this.createFeatureInstance_SSMDLLP_46(n);
            }
            case 67: {
                return this.createFeatureInstance_SSMDLLP_47(n);
            }
            case 68: {
                return this.createFeatureInstance_SSMDLNP_48(n);
            }
            case 69: {
                return this.createFeatureInstance_SSMDLNP_49(n);
            }
            case 70: {
                return this.createFeatureInstance_SSMDLN_4A(n);
            }
            case 71: {
                return this.createFeatureInstance_SSMDLOP_4B(n);
            }
            case 72: {
                return this.createFeatureInstance_SSMDLOP_4C(n);
            }
            case 73: {
                return this.createFeatureInstance_SSMDLPI_4D(n);
            }
            case 74: {
                return this.createFeatureInstance_SSMDLPI_4E(n);
            }
            case 75: {
                return this.createFeatureInstance_SSMDLPP_4F(n);
            }
            case 76: {
                return this.createFeatureInstance_SSMDLPP_50(n);
            }
            case 77: {
                return this.createFeatureInstance_SSMDLRIF_51(n);
            }
            case 78: {
                return this.createFeatureInstance_SSMDLRIF_52(n);
            }
            case 79: {
                return this.createFeatureInstance_SSMDMMH_53(n);
            }
            case 80: {
                return this.createFeatureInstance_SSMDMM_54(n);
            }
            case 81: {
                return this.createFeatureInstance_SSMDMMC_55(n);
            }
            case 82: {
                return this.createFeatureInstance_SSMDMPSM_56(n);
            }
            case 83: {
                return this.createFeatureInstance_SSMDMPSSA_57(n);
            }
            case 84: {
                return this.createFeatureInstance_SSMDMPS_58(n);
            }
            case 85: {
                return this.createFeatureInstance_SSMDMS_59(n);
            }
            case 86: {
                return this.createFeatureInstance_SSMDMSECP_5A(n);
            }
            case 87: {
                return this.createFeatureInstance_SSMDMSEDTL_5B(n);
            }
            case 88: {
                return this.createFeatureInstance_SSMDMSEGNA_5C(n);
            }
            case 89: {
                return this.createFeatureInstance_SSMDMSENDH_5D(n);
            }
            case 90: {
                return this.createFeatureInstance_SSMDMSL_5E(n);
            }
            case 91: {
                return this.createFeatureInstance_SSMDMSS_5F(n);
            }
            case 92: {
                return this.createFeatureInstance_SSMDMSS_60(n);
            }
            case 93: {
                return this.createFeatureInstance_SSMDMSS_61(n);
            }
            case 94: {
                return this.createFeatureInstance_SSMDNE_62(n);
            }
            case 95: {
                return this.createFeatureInstance_SSMDPSENS_63(n);
            }
            case 96: {
                return this.createFeatureInstance_SSMDPSERAM_64(n);
            }
            case 97: {
                return this.createFeatureInstance_SSMDPSES_65(n);
            }
            case 98: {
                return this.createFeatureInstance_SSMDPSS_66(n);
            }
            case 99: {
                return this.createFeatureInstance_SSMDPSS_67(n);
            }
            case 100: {
                return this.createFeatureInstance_SSMDPST_68(n);
            }
            case 101: {
                return this.createFeatureInstance_SSMDSS_69(n);
            }
            case 102: {
                return this.createFeatureInstance_SSMDSSA_6A(n);
            }
            case 103: {
                return this.createFeatureInstance_SSMDSSA_6B(n);
            }
            case 104: {
                return this.createFeatureInstance_SSMDSSL_6C(n);
            }
            case 105: {
                return this.createFeatureInstance_SSMDSSNM_6D(n);
            }
            case 106: {
                return this.createFeatureInstance_SSMDSSNA_6E(n);
            }
            case 107: {
                return this.createFeatureInstance_SSMDSSNA_6F(n);
            }
            case 108: {
                return this.createFeatureInstance_SSMDSSS_70(n);
            }
            case 109: {
                return this.createFeatureInstance_SSMDTS_71(n);
            }
            case 110: {
                return this.createFeatureInstance_SSMDTSM_72(n);
            }
            case 111: {
                return this.createFeatureInstance_SSMDTSNE_73(n);
            }
            case 112: {
                return this.createFeatureInstance_SSMDTSS_74(n);
            }
            case 113: {
                return this.createFeatureInstance_SSMDWS_75(n);
            }
            case 114: {
                return this.createFeatureInstance_SSMDWS_76(n);
            }
            case 115: {
                return this.createFeatureInstance_SSMGGC_77(n);
            }
            case 116: {
                return this.createFeatureInstance_SSMGHC_78(n);
            }
            case 117: {
                return this.createFeatureInstance_SSMNDHM_79(n);
            }
            case 118: {
                return this.createFeatureInstance_SSMNDHMC_7A(n);
            }
            case 119: {
                return this.createFeatureInstance_SSMNDHS_7B(n);
            }
            case 120: {
                return this.createFeatureInstance_SSMNDHSC_7C(n);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal sdFeatColId: ").append(this.sdFeatColId).toString());
    }

    private Feature createFeatureInstance_SSMDA_2D(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(202);
                genericTargetFeature.setBoolean(2010, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDA_2E(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(202);
                genericTargetFeature.setBoolean(2010, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDA_2F(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(202);
                genericTargetFeature.setBoolean(2010, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDA_30(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(202);
                genericTargetFeature.setBoolean(2010, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDA_31(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(202);
                genericTargetFeature.setBoolean(2010, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDEF_32(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(549));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, true);
                genericTargetFeature.setInt(3003, 0);
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDENA_33(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(619));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(620));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(621));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(622));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(623));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(624));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(625));
                }
                arrayList.add(SpeechMediaSdfch.createPrompt(550));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, true);
                genericTargetFeature.setInt(3003, 0);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDHMH_34(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(275221833));
                return genericTargetFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, true);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDHMH_35(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(275221833));
                return genericTargetFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, true);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDHM_36(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(552));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(258444617));
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, true);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDHMC_37(int n) {
        switch (n) {
            case 0: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{553}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 1: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[0] && object == null) {
                    object = this.getI18nString(5590);
                    bl = false;
                }
                if (this.conditions[1] && object == null) {
                    object = this.getI18nString(5587);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5604), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5595), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5596), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDHPS_38(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(551));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(291999049));
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
            case 3: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (object == null) {
                    object = this.getI18nString(5599);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDHSH_39(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(325553481));
                return genericTargetFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, true);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDHSH_3A(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(325553481));
                return genericTargetFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, true);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDHS_3B(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(554));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(308776265));
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, true);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDHSC_3C(int n) {
        switch (n) {
            case 0: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{555}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 1: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[0] && object == null) {
                    object = this.getI18nString(5605);
                    bl = false;
                }
                if (this.conditions[1] && object == null) {
                    object = this.getI18nString(5587);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(FormatterService.format(this.getI18nString(5601), this.getI18nStrings(300)[this.getLicValue(-1300155904, 0, 0, 0)]), true));
                ((ArrayList)object).add(this.createDynamicString(FormatterService.format(this.getI18nString(5588), this.getI18nStrings(300)[this.getLicValue(-1300155904, 0, 1, 0)]), true));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5603), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDI_3D(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(202);
                genericTargetFeature.setBoolean(2010, true);
                return genericTargetFeature;
            }
            case 1: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (object == null) {
                    object = this.getI18nString(5594);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 0);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDLFPE_3E(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(557));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDLFPE_3F(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(557));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDLFP_40(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(556));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDLFP_41(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(556));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDLGC_42(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(558));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDLGO_43(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(559));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDLLPE_44(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(561));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDLLPE_45(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(561));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDLLP_46(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(560));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDLLP_47(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(560));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDLNP_48(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(562));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDLNP_49(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(562));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDLN_4A(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(601));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(602));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(603));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(604));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDLOP_4B(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(563));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDLOP_4C(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(563));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDLPI_4D(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(564));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDLPI_4E(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(564));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDLPP_4F(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(565));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDLPP_50(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(565));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDLRIF_51(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(566));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDLRIF_52(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(566));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDMMH_53(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(359107913));
                return genericTargetFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, true);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDMM_54(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(570));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(342330697));
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDMMC_55(int n) {
        switch (n) {
            case 0: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{567}, 0));
                arrayList.add(this.createOrderedPrompts(new int[]{569}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 1: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[0] && object == null) {
                    object = this.getI18nString(5589);
                    bl = false;
                }
                if (this.conditions[1] && object == null) {
                    object = this.getI18nString(5587);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(FormatterService.format(this.getI18nString(5601), this.getI18nStrings(300)[this.getLicValue(-1300155904, 0, 0, 0)]), true));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5604), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5596), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 3);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDMPSM_56(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(578));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(571));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(572));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(573));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(375885129));
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDMPSSA_57(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(655));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(656));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(657));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(658));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(409439561));
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDMPS_58(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
            case 2: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{577}, 0));
                }
                if (this.conditions[1]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{574}, 0));
                }
                if (this.conditions[2]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{575}, 0));
                }
                if (this.conditions[3]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{576}, 0));
                }
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 3: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (object == null) {
                    object = this.getI18nStrings(299)[this.getInteger(-1729298432)];
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nStrings(296)[this.getInteger(-1729298432)], true));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nStrings(297)[this.getInteger(-1729298432)], true));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5586), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDMS_59(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[4]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(614));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(613));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(579));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(580));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(581));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(582));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(591));
                }
                if (this.conditions[7]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(592));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[8]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{600}, 0));
                }
                if (this.conditions[9]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{597}, 0));
                }
                if (this.conditions[10]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{598}, 0));
                }
                if (this.conditions[11]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{599}, 0));
                }
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 2: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (object == null) {
                    object = FormatterService.format(this.getI18nString(5591), this.getLicValue(-998166016, 9, 0, "Value name 0"));
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5608), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5593), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nStrings(298)[this.getInteger(-1729298432)], true));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5592), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5586), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5582), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDMSECP_5A(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(586));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(583));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(584));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(585));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, true);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDMSEDTL_5B(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(590));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(587));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(588));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(589));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, true);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDMSEGNA_5C(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(596));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(593));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(594));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(595));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, true);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDMSENDH_5D(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(608));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(605));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(606));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(607));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, true);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDMSL_5E(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, false);
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, this.conditions[0]);
                return genericTargetFeature;
            }
            case 3: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(307);
                genericTargetFeature.setBoolean(3050, true);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDMSS_5F(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(612));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(609));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(610));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(611));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDMSS_60(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, true);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDMSS_61(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, true);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDNE_62(int n) {
        switch (n) {
            case 0: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (object == null) {
                    object = this.getI18nString(5594);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDPSENS_63(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(642));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, true);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDPSERAM_64(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(643));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, true);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDPSES_65(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(645));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, true);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDPSS_66(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(644));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDPSS_67(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(640));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(641));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, true);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDPST_68(int n) {
        switch (n) {
            case 0: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (object == null) {
                    object = this.getI18nString(5594);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDSS_69(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(653));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(392662345));
                return genericTargetFeature;
            }
            case 2: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{654}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 3: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (object == null) {
                    object = this.getI18nString(5583);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(FormatterService.format(this.getI18nString(5606), this.getI18nStrings(300)[this.getLicValue(-1300155904, 0, 0, 0)]), true));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5584), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5586), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDSSA_6A(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(628));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(629));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(630));
                }
                if (this.conditions[7]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(631));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(632));
                }
                if (this.conditions[8]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(633));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(634));
                }
                if (this.conditions[9]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(635));
                }
                if (this.conditions[10]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(636));
                }
                if (this.conditions[11]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(637));
                }
                if (this.conditions[12]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(638));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(626));
                }
                if (this.conditions[13]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(627));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(639));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDSSA_6B(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(628));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(629));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(630));
                }
                if (this.conditions[7]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(631));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(632));
                }
                if (this.conditions[8]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(633));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(634));
                }
                if (this.conditions[9]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(635));
                }
                if (this.conditions[10]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(636));
                }
                if (this.conditions[11]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(637));
                }
                if (this.conditions[12]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(638));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(626));
                }
                if (this.conditions[13]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(627));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(639));
                }
                arrayList.add(SpeechMediaSdfch.createPrompt(646));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDSSL_6C(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, this.conditions[8]);
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(307);
                genericTargetFeature.setBoolean(3050, true);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDSSNM_6D(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(647));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, true);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDSSNA_6E(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(648));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, true);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDSSNA_6F(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[3]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(650));
                }
                if (this.conditions[14]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(651));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(652));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(628));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(629));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(630));
                }
                if (this.conditions[8]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(631));
                }
                if (this.conditions[7]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(632));
                }
                if (this.conditions[9]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(633));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(634));
                }
                if (this.conditions[10]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(635));
                }
                if (this.conditions[11]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(636));
                }
                if (this.conditions[12]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(637));
                }
                if (this.conditions[13]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(638));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechMediaSdfch.createPrompt(649));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, true);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDSSS_70(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, true);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDTS_71(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
            case 2: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{660}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 3: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (object == null) {
                    object = this.getI18nStrings(299)[this.getInteger(-1729298432)];
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nStrings(296)[this.getInteger(-1729298432)], true));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nStrings(297)[this.getInteger(-1729298432)], true));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5586), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDTSM_72(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(659));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(426216777));
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDTSNE_73(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(661));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDTSS_74(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(662));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDWS_75(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, this.conditions[0]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMDWS_76(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, this.conditions[0]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMGGC_77(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(201);
                genericTargetFeature.setEvent(2001, this.createEvent(677875017));
                genericTargetFeature.setEvent(2006, this.createEvent(442993993));
                genericTargetFeature.setEvent(2007, this.createEvent(459771209));
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMGHC_78(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMNDHM_79(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(616));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(258444617));
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, true);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMNDHMC_7A(int n) {
        switch (n) {
            case 0: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{616}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 1: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[0] && object == null) {
                    object = this.getI18nString(5610);
                    bl = false;
                }
                if (this.conditions[1] && object == null) {
                    object = this.getI18nString(5609);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5604), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5595), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5596), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMNDHS_7B(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechMediaSdfch.createPrompt(618));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(308776265));
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, true);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSMNDHSC_7C(int n) {
        switch (n) {
            case 0: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{618}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 1: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[0] && object == null) {
                    object = this.getI18nString(5611);
                    bl = false;
                }
                if (this.conditions[1] && object == null) {
                    object = this.getI18nString(5609);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(FormatterService.format(this.getI18nString(5601), this.getI18nStrings(300)[this.getLicValue(-1300155904, 0, 0, 0)]), true));
                ((ArrayList)object).add(this.createDynamicString(FormatterService.format(this.getI18nString(5588), this.getI18nStrings(300)[this.getLicValue(-1300155904, 0, 1, 0)]), true));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5603), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    @Override
    protected void collectAllUnconditionalCommands(ObjectArrayList objectArrayList) {
        switch (this.sdFeatColId) {
            case 90: {
                this.collectAllUnconditionalCommands_SSMDMSL_5E(objectArrayList);
                break;
            }
            case 104: {
                this.collectAllUnconditionalCommands_SSMDSSL_6C(objectArrayList);
                break;
            }
            case 109: {
                this.collectAllUnconditionalCommands_SSMDTS_71(objectArrayList);
                break;
            }
            case 115: {
                this.collectAllUnconditionalCommands_SSMGGC_77(objectArrayList);
                break;
            }
            case 116: {
                this.collectAllUnconditionalCommands_SSMGHC_78(objectArrayList);
                break;
            }
            default: {
                super.collectAllUnconditionalCommands(objectArrayList);
            }
        }
    }

    private void collectAllUnconditionalCommands_SSMDMSL_5E(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
        objectArrayList.add(this.createSingleCommand(4));
        objectArrayList.add(this.createSingleCommand(5));
        objectArrayList.add(this.createSingleCommand(6));
        objectArrayList.add(this.createSingleCommand(7));
    }

    private void collectAllUnconditionalCommands_SSMDSSL_6C(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
        objectArrayList.add(this.createSingleCommand(9));
    }

    private void collectAllUnconditionalCommands_SSMDTS_71(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
    }

    private void collectAllUnconditionalCommands_SSMGGC_77(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
    }

    private void collectAllUnconditionalCommands_SSMGHC_78(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(7));
        objectArrayList.add(this.createSingleCommand(8));
    }

    @Override
    protected boolean evaluateCondition(int n) {
        switch (this.sdFeatColId) {
            case 47: {
                return this.evaluateCondition_SSMDENA_33(n);
            }
            case 51: {
                return this.evaluateCondition_SSMDHMC_37(n);
            }
            case 56: {
                return this.evaluateCondition_SSMDHSC_3C(n);
            }
            case 70: {
                return this.evaluateCondition_SSMDLN_4A(n);
            }
            case 81: {
                return this.evaluateCondition_SSMDMMC_55(n);
            }
            case 82: {
                return this.evaluateCondition_SSMDMPSM_56(n);
            }
            case 83: {
                return this.evaluateCondition_SSMDMPSSA_57(n);
            }
            case 84: {
                return this.evaluateCondition_SSMDMPS_58(n);
            }
            case 85: {
                return this.evaluateCondition_SSMDMS_59(n);
            }
            case 86: {
                return this.evaluateCondition_SSMDMSECP_5A(n);
            }
            case 87: {
                return this.evaluateCondition_SSMDMSEDTL_5B(n);
            }
            case 88: {
                return this.evaluateCondition_SSMDMSEGNA_5C(n);
            }
            case 89: {
                return this.evaluateCondition_SSMDMSENDH_5D(n);
            }
            case 90: {
                return this.evaluateCondition_SSMDMSL_5E(n);
            }
            case 91: {
                return this.evaluateCondition_SSMDMSS_5F(n);
            }
            case 99: {
                return this.evaluateCondition_SSMDPSS_67(n);
            }
            case 102: {
                return this.evaluateCondition_SSMDSSA_6A(n);
            }
            case 103: {
                return this.evaluateCondition_SSMDSSA_6B(n);
            }
            case 104: {
                return this.evaluateCondition_SSMDSSL_6C(n);
            }
            case 107: {
                return this.evaluateCondition_SSMDSSNA_6F(n);
            }
            case 113: {
                return this.evaluateCondition_SSMDWS_75(n);
            }
            case 114: {
                return this.evaluateCondition_SSMDWS_76(n);
            }
            case 115: {
                return this.evaluateCondition_SSMGGC_77(n);
            }
            case 116: {
                return this.evaluateCondition_SSMGHC_78(n);
            }
            case 118: {
                return this.evaluateCondition_SSMNDHMC_7A(n);
            }
            case 120: {
                return this.evaluateCondition_SSMNDHSC_7C(n);
            }
        }
        return super.evaluateCondition(n);
    }

    private boolean evaluateCondition_SSMDENA_33(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(25305) == 3 || this.getInteger(25305) == 4;
            }
            case 1: {
                return this.getInteger(25305) == 1;
            }
            case 2: {
                return this.getInteger(25305) == 5;
            }
            case 3: {
                return this.getInteger(25305) == 6;
            }
            case 4: {
                return this.getInteger(25305) == 7;
            }
            case 5: {
                return this.getInteger(25305) == 8;
            }
            case 6: {
                return this.getInteger(25305) == 9;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSMDHMC_37(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(1521745920);
            }
            case 1: {
                return this.getBoolean(1521745920);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSMDHSC_3C(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(1521745920);
            }
            case 1: {
                return this.getBoolean(1521745920);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSMDLN_4A(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-1729298432) == 0;
            }
            case 1: {
                return this.getInteger(-1729298432) == 1;
            }
            case 2: {
                return this.getInteger(-1729298432) == 2;
            }
            case 3: {
                return this.getInteger(-1729298432) == 3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSMDMMC_55(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(1521745920);
            }
            case 1: {
                return this.getBoolean(1521745920);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSMDMPSM_56(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-1729298432) == 0;
            }
            case 1: {
                return this.getInteger(-1729298432) == 1;
            }
            case 2: {
                return this.getInteger(-1729298432) == 2;
            }
            case 3: {
                return this.getInteger(-1729298432) == 3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSMDMPSSA_57(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-1729298432) == 0;
            }
            case 1: {
                return this.getInteger(-1729298432) == 1;
            }
            case 2: {
                return this.getInteger(-1729298432) == 2;
            }
            case 3: {
                return this.getInteger(-1729298432) == 3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSMDMPS_58(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-1729298432) == 0;
            }
            case 1: {
                return this.getInteger(-1729298432) == 1;
            }
            case 2: {
                return this.getInteger(-1729298432) == 2;
            }
            case 3: {
                return this.getInteger(-1729298432) == 3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSMDMS_59(int n) {
        switch (n) {
            case 0: {
                return this.getLicValue(-998166016, 3, 0, 0) == 0 && this.getInteger(-1729298432) == 0;
            }
            case 1: {
                return this.getLicValue(-998166016, 3, 0, 0) == 0 && this.getInteger(-1729298432) == 1;
            }
            case 2: {
                return this.getLicValue(-998166016, 3, 0, 0) == 0 && this.getInteger(-1729298432) == 2;
            }
            case 3: {
                return this.getLicValue(-998166016, 3, 0, 0) == 0 && this.getInteger(-1729298432) == 3;
            }
            case 4: {
                return this.getLicValue(-998166016, 3, 0, 0) > 0 && this.getInteger(-1729298432) == 0;
            }
            case 5: {
                return this.getLicValue(-998166016, 3, 0, 0) > 0 && this.getInteger(-1729298432) == 1;
            }
            case 6: {
                return this.getLicValue(-998166016, 3, 0, 0) > 0 && this.getInteger(-1729298432) == 2;
            }
            case 7: {
                return this.getLicValue(-998166016, 3, 0, 0) > 0 && this.getInteger(-1729298432) == 3;
            }
            case 8: {
                return this.getInteger(-1729298432) == 0;
            }
            case 9: {
                return this.getInteger(-1729298432) == 1;
            }
            case 10: {
                return this.getInteger(-1729298432) == 2;
            }
            case 11: {
                return this.getInteger(-1729298432) == 3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSMDMSECP_5A(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-1729298432) == 0;
            }
            case 1: {
                return this.getInteger(-1729298432) == 1;
            }
            case 2: {
                return this.getInteger(-1729298432) == 2;
            }
            case 3: {
                return this.getInteger(-1729298432) == 3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSMDMSEDTL_5B(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-1729298432) == 0;
            }
            case 1: {
                return this.getInteger(-1729298432) == 1;
            }
            case 2: {
                return this.getInteger(-1729298432) == 2;
            }
            case 3: {
                return this.getInteger(-1729298432) == 3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSMDMSEGNA_5C(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-1729298432) == 0;
            }
            case 1: {
                return this.getInteger(-1729298432) == 1;
            }
            case 2: {
                return this.getInteger(-1729298432) == 2;
            }
            case 3: {
                return this.getInteger(-1729298432) == 3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSMDMSENDH_5D(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-1729298432) == 0;
            }
            case 1: {
                return this.getInteger(-1729298432) == 1;
            }
            case 2: {
                return this.getInteger(-1729298432) == 2;
            }
            case 3: {
                return this.getInteger(-1729298432) == 3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSMDMSL_5E(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(536739840);
            }
            case 1: {
                return this.getInteger(-1729298432) == 0;
            }
            case 2: {
                return this.getInteger(-1729298432) == 1;
            }
            case 3: {
                return this.getInteger(-1729298432) == 2;
            }
            case 4: {
                return this.getInteger(-1729298432) == 3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSMDMSS_5F(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-1729298432) == 0;
            }
            case 1: {
                return this.getInteger(-1729298432) == 1;
            }
            case 2: {
                return this.getInteger(-1729298432) == 2;
            }
            case 3: {
                return this.getInteger(-1729298432) == 3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSMDPSS_67(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-1054998272) == 0;
            }
            case 1: {
                return this.getInteger(-1054998272) > 0;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSMDSSA_6A(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-874905600) == 0;
            }
            case 1: {
                return this.getInteger(-874905600) == 1;
            }
            case 2: {
                return this.getInteger(-874905600) == 10;
            }
            case 3: {
                return this.getInteger(-874905600) == 11;
            }
            case 4: {
                return this.getInteger(-874905600) == 2;
            }
            case 5: {
                return this.getInteger(-874905600) == 20;
            }
            case 6: {
                return this.getInteger(-874905600) == 3;
            }
            case 7: {
                return this.getInteger(-874905600) == 30;
            }
            case 8: {
                return this.getInteger(-874905600) == 4;
            }
            case 9: {
                return this.getInteger(-874905600) == 5;
            }
            case 10: {
                return this.getInteger(-874905600) == 6;
            }
            case 11: {
                return this.getInteger(-874905600) == 7;
            }
            case 12: {
                return this.getInteger(-874905600) == 8;
            }
            case 13: {
                return this.getInteger(-874905600) == 9;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSMDSSA_6B(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-874905600) == 0;
            }
            case 1: {
                return this.getInteger(-874905600) == 1;
            }
            case 2: {
                return this.getInteger(-874905600) == 10;
            }
            case 3: {
                return this.getInteger(-874905600) == 11;
            }
            case 4: {
                return this.getInteger(-874905600) == 2;
            }
            case 5: {
                return this.getInteger(-874905600) == 20;
            }
            case 6: {
                return this.getInteger(-874905600) == 3;
            }
            case 7: {
                return this.getInteger(-874905600) == 30;
            }
            case 8: {
                return this.getInteger(-874905600) == 4;
            }
            case 9: {
                return this.getInteger(-874905600) == 5;
            }
            case 10: {
                return this.getInteger(-874905600) == 6;
            }
            case 11: {
                return this.getInteger(-874905600) == 7;
            }
            case 12: {
                return this.getInteger(-874905600) == 8;
            }
            case 13: {
                return this.getInteger(-874905600) == 9;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSMDSSL_6C(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(-1746665472);
            }
            case 1: {
                return this.getBoolean(1938358272);
            }
            case 2: {
                return this.getBoolean(1820917760);
            }
            case 3: {
                return this.getBoolean(-203685888);
            }
            case 4: {
                return this.getBoolean(-728432640);
            }
            case 5: {
                return this.getBoolean(0x3880000);
            }
            case 6: {
                return this.getBoolean(61997056);
            }
            case 7: {
                return this.getBoolean(-306053120);
            }
            case 8: {
                return this.getBoolean(536739840);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSMDSSNA_6F(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-874905600) != 10 && this.getInteger(-874905600) != 9 && this.getInteger(-874905600) != 11;
            }
            case 1: {
                return this.getInteger(-874905600) == 0;
            }
            case 2: {
                return this.getInteger(-874905600) == 1;
            }
            case 3: {
                return this.getInteger(-874905600) == 10;
            }
            case 4: {
                return this.getInteger(-874905600) == 11;
            }
            case 5: {
                return this.getInteger(-874905600) == 2;
            }
            case 6: {
                return this.getInteger(-874905600) == 20;
            }
            case 7: {
                return this.getInteger(-874905600) == 3;
            }
            case 8: {
                return this.getInteger(-874905600) == 30;
            }
            case 9: {
                return this.getInteger(-874905600) == 4;
            }
            case 10: {
                return this.getInteger(-874905600) == 5;
            }
            case 11: {
                return this.getInteger(-874905600) == 6;
            }
            case 12: {
                return this.getInteger(-874905600) == 7;
            }
            case 13: {
                return this.getInteger(-874905600) == 8;
            }
            case 14: {
                return this.getInteger(-874905600) == 9;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSMDWS_75(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(536739840);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSMDWS_76(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(536739840);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSMGGC_77(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 1: {
                return this.getBoolean(-1746665472) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 2: {
                return this.getBoolean(1938358272) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 3: {
                return this.getBoolean(1820917760) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 4: {
                return this.getBoolean(-203685888) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 5: {
                return this.getBoolean(-728432640) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 6: {
                return this.getBoolean(0x3880000) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 7: {
                return this.getBoolean(61997056) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 8: {
                return this.getBoolean(-306053120) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSMGHC_78(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 1: {
                return this.getBoolean(-1746665472) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 2: {
                return this.getBoolean(1938358272) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 3: {
                return this.getBoolean(1820917760) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 4: {
                return this.getBoolean(-203685888) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 5: {
                return this.getBoolean(-728432640) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 6: {
                return this.getBoolean(0x3880000) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 7: {
                return this.getBoolean(61997056) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 8: {
                return this.getBoolean(-306053120) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSMNDHMC_7A(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(1521745920);
            }
            case 1: {
                return this.getBoolean(1521745920);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSMNDHSC_7C(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(1521745920);
            }
            case 1: {
                return this.getBoolean(1521745920);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    @Override
    protected void collectAllCommandsGuardedByOneCondition(ObjectArrayList objectArrayList, int n) {
        switch (this.sdFeatColId) {
            case 47: {
                this.collectAllCommandsGuardedByOneCondition_SSMDENA_33(objectArrayList, n);
                break;
            }
            case 51: {
                this.collectAllCommandsGuardedByOneCondition_SSMDHMC_37(objectArrayList, n);
                break;
            }
            case 56: {
                this.collectAllCommandsGuardedByOneCondition_SSMDHSC_3C(objectArrayList, n);
                break;
            }
            case 70: {
                this.collectAllCommandsGuardedByOneCondition_SSMDLN_4A(objectArrayList, n);
                break;
            }
            case 81: {
                this.collectAllCommandsGuardedByOneCondition_SSMDMMC_55(objectArrayList, n);
                break;
            }
            case 82: {
                this.collectAllCommandsGuardedByOneCondition_SSMDMPSM_56(objectArrayList, n);
                break;
            }
            case 83: {
                this.collectAllCommandsGuardedByOneCondition_SSMDMPSSA_57(objectArrayList, n);
                break;
            }
            case 84: {
                this.collectAllCommandsGuardedByOneCondition_SSMDMPS_58(objectArrayList, n);
                break;
            }
            case 85: {
                this.collectAllCommandsGuardedByOneCondition_SSMDMS_59(objectArrayList, n);
                break;
            }
            case 86: {
                this.collectAllCommandsGuardedByOneCondition_SSMDMSECP_5A(objectArrayList, n);
                break;
            }
            case 87: {
                this.collectAllCommandsGuardedByOneCondition_SSMDMSEDTL_5B(objectArrayList, n);
                break;
            }
            case 88: {
                this.collectAllCommandsGuardedByOneCondition_SSMDMSEGNA_5C(objectArrayList, n);
                break;
            }
            case 89: {
                this.collectAllCommandsGuardedByOneCondition_SSMDMSENDH_5D(objectArrayList, n);
                break;
            }
            case 90: {
                this.collectAllCommandsGuardedByOneCondition_SSMDMSL_5E(objectArrayList, n);
                break;
            }
            case 91: {
                this.collectAllCommandsGuardedByOneCondition_SSMDMSS_5F(objectArrayList, n);
                break;
            }
            case 99: {
                this.collectAllCommandsGuardedByOneCondition_SSMDPSS_67(objectArrayList, n);
                break;
            }
            case 102: {
                this.collectAllCommandsGuardedByOneCondition_SSMDSSA_6A(objectArrayList, n);
                break;
            }
            case 103: {
                this.collectAllCommandsGuardedByOneCondition_SSMDSSA_6B(objectArrayList, n);
                break;
            }
            case 104: {
                this.collectAllCommandsGuardedByOneCondition_SSMDSSL_6C(objectArrayList, n);
                break;
            }
            case 107: {
                this.collectAllCommandsGuardedByOneCondition_SSMDSSNA_6F(objectArrayList, n);
                break;
            }
            case 113: {
                this.collectAllCommandsGuardedByOneCondition_SSMDWS_75(objectArrayList, n);
                break;
            }
            case 114: {
                this.collectAllCommandsGuardedByOneCondition_SSMDWS_76(objectArrayList, n);
                break;
            }
            case 115: {
                this.collectAllCommandsGuardedByOneCondition_SSMGGC_77(objectArrayList, n);
                break;
            }
            case 116: {
                this.collectAllCommandsGuardedByOneCondition_SSMGHC_78(objectArrayList, n);
                break;
            }
            case 118: {
                this.collectAllCommandsGuardedByOneCondition_SSMNDHMC_7A(objectArrayList, n);
                break;
            }
            case 120: {
                this.collectAllCommandsGuardedByOneCondition_SSMNDHSC_7C(objectArrayList, n);
                break;
            }
            default: {
                super.collectAllCommandsGuardedByOneCondition(objectArrayList, n);
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSMDENA_33(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            case 1: {
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                break;
            }
            case 5: {
                break;
            }
            case 6: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSMDHMC_37(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            case 1: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSMDHSC_3C(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            case 1: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSMDLN_4A(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            case 1: {
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSMDMMC_55(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            case 1: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSMDMPSM_56(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            case 1: {
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSMDMPSSA_57(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            case 1: {
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSMDMPS_58(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                objectArrayList.add(this.createSingleCommand(3));
                break;
            }
            case 1: {
                objectArrayList.add(this.createSingleCommand(0));
                break;
            }
            case 2: {
                objectArrayList.add(this.createSingleCommand(1));
                break;
            }
            case 3: {
                objectArrayList.add(this.createSingleCommand(2));
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSMDMS_59(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            case 1: {
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                break;
            }
            case 5: {
                break;
            }
            case 6: {
                break;
            }
            case 7: {
                break;
            }
            case 8: {
                break;
            }
            case 9: {
                break;
            }
            case 10: {
                break;
            }
            case 11: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSMDMSECP_5A(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            case 1: {
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSMDMSEDTL_5B(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            case 1: {
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSMDMSEGNA_5C(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            case 1: {
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSMDMSENDH_5D(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            case 1: {
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSMDMSL_5E(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            case 1: {
                objectArrayList.add(this.createSingleCommand(11));
                break;
            }
            case 2: {
                objectArrayList.add(this.createSingleCommand(8));
                break;
            }
            case 3: {
                objectArrayList.add(this.createSingleCommand(9));
                break;
            }
            case 4: {
                objectArrayList.add(this.createSingleCommand(10));
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSMDMSS_5F(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            case 1: {
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSMDPSS_67(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            case 1: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSMDSSA_6A(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            case 1: {
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                break;
            }
            case 5: {
                break;
            }
            case 6: {
                break;
            }
            case 7: {
                break;
            }
            case 8: {
                break;
            }
            case 9: {
                break;
            }
            case 10: {
                break;
            }
            case 11: {
                break;
            }
            case 12: {
                break;
            }
            case 13: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSMDSSA_6B(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            case 1: {
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                break;
            }
            case 5: {
                break;
            }
            case 6: {
                break;
            }
            case 7: {
                break;
            }
            case 8: {
                break;
            }
            case 9: {
                break;
            }
            case 10: {
                break;
            }
            case 11: {
                break;
            }
            case 12: {
                break;
            }
            case 13: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSMDSSL_6C(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                objectArrayList.add(this.createSingleCommand(4));
                break;
            }
            case 1: {
                objectArrayList.add(this.createSingleCommand(5));
                break;
            }
            case 2: {
                objectArrayList.add(this.createSingleCommand(6));
                break;
            }
            case 3: {
                objectArrayList.add(this.createSingleCommand(7));
                break;
            }
            case 4: {
                objectArrayList.add(this.createSingleCommand(8));
                break;
            }
            case 5: {
                objectArrayList.add(this.createSingleCommand(10));
                break;
            }
            case 6: {
                objectArrayList.add(this.createSingleCommand(11));
                break;
            }
            case 7: {
                objectArrayList.add(this.createSingleCommand(12));
                break;
            }
            case 8: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSMDSSNA_6F(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            case 1: {
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                break;
            }
            case 5: {
                break;
            }
            case 6: {
                break;
            }
            case 7: {
                break;
            }
            case 8: {
                break;
            }
            case 9: {
                break;
            }
            case 10: {
                break;
            }
            case 11: {
                break;
            }
            case 12: {
                break;
            }
            case 13: {
                break;
            }
            case 14: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSMDWS_75(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSMDWS_76(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSMGGC_77(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                objectArrayList.add(this.createSingleCommand(3));
                objectArrayList.add(this.createSingleCommand(4));
                objectArrayList.add(this.createSingleCommand(5));
                objectArrayList.add(this.createSingleCommand(6));
                objectArrayList.add(this.createSingleCommand(15));
                break;
            }
            case 1: {
                objectArrayList.add(this.createSingleCommand(7));
                break;
            }
            case 2: {
                objectArrayList.add(this.createSingleCommand(8));
                break;
            }
            case 3: {
                objectArrayList.add(this.createSingleCommand(9));
                break;
            }
            case 4: {
                objectArrayList.add(this.createSingleCommand(10));
                break;
            }
            case 5: {
                objectArrayList.add(this.createSingleCommand(11));
                break;
            }
            case 6: {
                objectArrayList.add(this.createSingleCommand(12));
                break;
            }
            case 7: {
                objectArrayList.add(this.createSingleCommand(13));
                break;
            }
            case 8: {
                objectArrayList.add(this.createSingleCommand(14));
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSMGHC_78(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                objectArrayList.add(this.createSingleCommand(2));
                objectArrayList.add(this.createSingleCommand(3));
                objectArrayList.add(this.createSingleCommand(4));
                objectArrayList.add(this.createSingleCommand(5));
                objectArrayList.add(this.createSingleCommand(6));
                objectArrayList.add(this.createSingleCommand(9));
                objectArrayList.add(this.createSingleCommand(10));
                objectArrayList.add(this.createSingleCommand(11));
                objectArrayList.add(this.createSingleCommand(12));
                objectArrayList.add(this.createSingleCommand(21));
                break;
            }
            case 1: {
                objectArrayList.add(this.createSingleCommand(13));
                break;
            }
            case 2: {
                objectArrayList.add(this.createSingleCommand(14));
                break;
            }
            case 3: {
                objectArrayList.add(this.createSingleCommand(15));
                break;
            }
            case 4: {
                objectArrayList.add(this.createSingleCommand(16));
                break;
            }
            case 5: {
                objectArrayList.add(this.createSingleCommand(17));
                break;
            }
            case 6: {
                objectArrayList.add(this.createSingleCommand(18));
                break;
            }
            case 7: {
                objectArrayList.add(this.createSingleCommand(19));
                break;
            }
            case 8: {
                objectArrayList.add(this.createSingleCommand(20));
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSMNDHMC_7A(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            case 1: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSMNDHSC_7C(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            case 1: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    @Override
    protected int[] getAffectedFeatures(int n) {
        switch (this.sdFeatColId) {
            case 47: {
                return this.getAffectedFeatures_SSMDENA_33(n);
            }
            case 51: {
                return this.getAffectedFeatures_SSMDHMC_37(n);
            }
            case 56: {
                return this.getAffectedFeatures_SSMDHSC_3C(n);
            }
            case 70: {
                return this.getAffectedFeatures_SSMDLN_4A(n);
            }
            case 81: {
                return this.getAffectedFeatures_SSMDMMC_55(n);
            }
            case 82: {
                return this.getAffectedFeatures_SSMDMPSM_56(n);
            }
            case 83: {
                return this.getAffectedFeatures_SSMDMPSSA_57(n);
            }
            case 84: {
                return this.getAffectedFeatures_SSMDMPS_58(n);
            }
            case 85: {
                return this.getAffectedFeatures_SSMDMS_59(n);
            }
            case 86: {
                return this.getAffectedFeatures_SSMDMSECP_5A(n);
            }
            case 87: {
                return this.getAffectedFeatures_SSMDMSEDTL_5B(n);
            }
            case 88: {
                return this.getAffectedFeatures_SSMDMSEGNA_5C(n);
            }
            case 89: {
                return this.getAffectedFeatures_SSMDMSENDH_5D(n);
            }
            case 90: {
                return this.getAffectedFeatures_SSMDMSL_5E(n);
            }
            case 91: {
                return this.getAffectedFeatures_SSMDMSS_5F(n);
            }
            case 99: {
                return this.getAffectedFeatures_SSMDPSS_67(n);
            }
            case 102: {
                return this.getAffectedFeatures_SSMDSSA_6A(n);
            }
            case 103: {
                return this.getAffectedFeatures_SSMDSSA_6B(n);
            }
            case 104: {
                return this.getAffectedFeatures_SSMDSSL_6C(n);
            }
            case 107: {
                return this.getAffectedFeatures_SSMDSSNA_6F(n);
            }
            case 113: {
                return this.getAffectedFeatures_SSMDWS_75(n);
            }
            case 114: {
                return this.getAffectedFeatures_SSMDWS_76(n);
            }
            case 115: {
                return this.getAffectedFeatures_SSMGGC_77(n);
            }
            case 116: {
                return this.getAffectedFeatures_SSMGHC_78(n);
            }
            case 118: {
                return this.getAffectedFeatures_SSMNDHMC_7A(n);
            }
            case 120: {
                return this.getAffectedFeatures_SSMNDHSC_7C(n);
            }
        }
        return super.getAffectedFeatures(n);
    }

    private int[] getAffectedFeatures_SSMDENA_33(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSMDHMC_37(int n) {
        switch (n) {
            case 0: {
                return SSMDHMC_37_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSMDHMC_37_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSMDHSC_3C(int n) {
        switch (n) {
            case 0: {
                return SSMDHSC_3C_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSMDHSC_3C_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSMDLN_4A(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSMDMMC_55(int n) {
        switch (n) {
            case 0: {
                return SSMDMMC_55_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSMDMMC_55_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSMDMPSM_56(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSMDMPSSA_57(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSMDMPS_58(int n) {
        switch (n) {
            case 0: {
                return SSMDMPS_58_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSMDMPS_58_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 2: {
                return SSMDMPS_58_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSMDMPS_58_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSMDMS_59(int n) {
        switch (n) {
            case 8: {
                return SSMDMS_59_AFFECTED_FEATURES_FOR_CONDITION_8;
            }
            case 9: {
                return SSMDMS_59_AFFECTED_FEATURES_FOR_CONDITION_9;
            }
            case 10: {
                return SSMDMS_59_AFFECTED_FEATURES_FOR_CONDITION_10;
            }
            case 11: {
                return SSMDMS_59_AFFECTED_FEATURES_FOR_CONDITION_11;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSMDMSECP_5A(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSMDMSEDTL_5B(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSMDMSEGNA_5C(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSMDMSENDH_5D(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSMDMSL_5E(int n) {
        switch (n) {
            case 1: {
                return SSMDMSL_5E_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 2: {
                return SSMDMSL_5E_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSMDMSL_5E_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
            case 4: {
                return SSMDMSL_5E_AFFECTED_FEATURES_FOR_CONDITION_4;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSMDMSS_5F(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSMDPSS_67(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSMDSSA_6A(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSMDSSA_6B(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSMDSSL_6C(int n) {
        switch (n) {
            case 0: {
                return SSMDSSL_6C_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSMDSSL_6C_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 2: {
                return SSMDSSL_6C_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSMDSSL_6C_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
            case 4: {
                return SSMDSSL_6C_AFFECTED_FEATURES_FOR_CONDITION_4;
            }
            case 5: {
                return SSMDSSL_6C_AFFECTED_FEATURES_FOR_CONDITION_5;
            }
            case 6: {
                return SSMDSSL_6C_AFFECTED_FEATURES_FOR_CONDITION_6;
            }
            case 7: {
                return SSMDSSL_6C_AFFECTED_FEATURES_FOR_CONDITION_7;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSMDSSNA_6F(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSMDWS_75(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSMDWS_76(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSMGGC_77(int n) {
        switch (n) {
            case 0: {
                return SSMGGC_77_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSMGGC_77_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 2: {
                return SSMGGC_77_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSMGGC_77_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
            case 4: {
                return SSMGGC_77_AFFECTED_FEATURES_FOR_CONDITION_4;
            }
            case 5: {
                return SSMGGC_77_AFFECTED_FEATURES_FOR_CONDITION_5;
            }
            case 6: {
                return SSMGGC_77_AFFECTED_FEATURES_FOR_CONDITION_6;
            }
            case 7: {
                return SSMGGC_77_AFFECTED_FEATURES_FOR_CONDITION_7;
            }
            case 8: {
                return SSMGGC_77_AFFECTED_FEATURES_FOR_CONDITION_8;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSMGHC_78(int n) {
        switch (n) {
            case 0: {
                return SSMGHC_78_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSMGHC_78_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 2: {
                return SSMGHC_78_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSMGHC_78_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
            case 4: {
                return SSMGHC_78_AFFECTED_FEATURES_FOR_CONDITION_4;
            }
            case 5: {
                return SSMGHC_78_AFFECTED_FEATURES_FOR_CONDITION_5;
            }
            case 6: {
                return SSMGHC_78_AFFECTED_FEATURES_FOR_CONDITION_6;
            }
            case 7: {
                return SSMGHC_78_AFFECTED_FEATURES_FOR_CONDITION_7;
            }
            case 8: {
                return SSMGHC_78_AFFECTED_FEATURES_FOR_CONDITION_8;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSMNDHMC_7A(int n) {
        switch (n) {
            case 0: {
                return SSMNDHMC_7A_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSMNDHMC_7A_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSMNDHSC_7C(int n) {
        switch (n) {
            case 0: {
                return SSMNDHSC_7C_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSMNDHSC_7C_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    @Override
    protected int[] getConditionsAffectedByProperty(int n) {
        switch (this.sdFeatColId) {
            case 51: {
                return this.getConditionsAffectedByProperty_SSMDHMC_37(n);
            }
            case 56: {
                return this.getConditionsAffectedByProperty_SSMDHSC_3C(n);
            }
            case 81: {
                return this.getConditionsAffectedByProperty_SSMDMMC_55(n);
            }
            case 84: {
                return this.getConditionsAffectedByProperty_SSMDMPS_58(n);
            }
            case 85: {
                return this.getConditionsAffectedByProperty_SSMDMS_59(n);
            }
            case 90: {
                return this.getConditionsAffectedByProperty_SSMDMSL_5E(n);
            }
            case 104: {
                return this.getConditionsAffectedByProperty_SSMDSSL_6C(n);
            }
            case 109: {
                return this.getConditionsAffectedByProperty_SSMDTS_71(n);
            }
            case 115: {
                return this.getConditionsAffectedByProperty_SSMGGC_77(n);
            }
            case 116: {
                return this.getConditionsAffectedByProperty_SSMGHC_78(n);
            }
            case 118: {
                return this.getConditionsAffectedByProperty_SSMNDHMC_7A(n);
            }
            case 120: {
                return this.getConditionsAffectedByProperty_SSMNDHSC_7C(n);
            }
        }
        return super.getConditionsAffectedByProperty(n);
    }

    private int[] getConditionsAffectedByProperty_SSMDHMC_37(int n) {
        switch (n) {
            case 46170: {
                return SSMDHMC_37_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_MEDIA_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSMDHSC_3C(int n) {
        switch (n) {
            case 46170: {
                return SSMDHSC_3C_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_MEDIA_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSMDMMC_55(int n) {
        switch (n) {
            case 46170: {
                return SSMDMMC_55_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_MEDIA_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSMDMPS_58(int n) {
        switch (n) {
            case 60824: {
                return SSMDMPS_58_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_REQUEST_GET_MUSIC_USE_CASE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSMDMS_59(int n) {
        switch (n) {
            case 60824: {
                return SSMDMS_59_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_REQUEST_GET_MUSIC_USE_CASE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSMDMSL_5E(int n) {
        switch (n) {
            case 60824: {
                return SSMDMSL_5E_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_REQUEST_GET_MUSIC_USE_CASE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSMDSSL_6C(int n) {
        switch (n) {
            case 58519: {
                return SSMDSSL_6C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_AUX;
            }
            case 35187: {
                return SSMDSSL_6C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_BT;
            }
            case 35180: {
                return SSMDSSL_6C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_CD;
            }
            case 56563: {
                return SSMDSSL_6C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_DVD;
            }
            case 38356: {
                return SSMDSSL_6C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_JUKEBOX;
            }
            case 34819: {
                return SSMDSSL_6C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_SD;
            }
            case 45571: {
                return SSMDSSL_6C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_USB;
            }
            case 49901: {
                return SSMDSSL_6C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_WLAN;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSMDTS_71(int n) {
        switch (n) {
            case 60824: {
                return SSMDTS_71_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_REQUEST_GET_MUSIC_USE_CASE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSMGGC_77(int n) {
        switch (n) {
            case 10059: {
                return SSMGGC_77_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSMGGC_77_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
            case 58519: {
                return SSMGGC_77_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_AUX;
            }
            case 35187: {
                return SSMGGC_77_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_BT;
            }
            case 35180: {
                return SSMGGC_77_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_CD;
            }
            case 56563: {
                return SSMGGC_77_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_DVD;
            }
            case 38356: {
                return SSMGGC_77_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_JUKEBOX;
            }
            case 34819: {
                return SSMGGC_77_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_SD;
            }
            case 45571: {
                return SSMGGC_77_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_USB;
            }
            case 49901: {
                return SSMGGC_77_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_WLAN;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSMGHC_78(int n) {
        switch (n) {
            case 10059: {
                return SSMGHC_78_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSMGHC_78_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
            case 58519: {
                return SSMGHC_78_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_AUX;
            }
            case 35187: {
                return SSMGHC_78_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_BT;
            }
            case 35180: {
                return SSMGHC_78_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_CD;
            }
            case 56563: {
                return SSMGHC_78_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_DVD;
            }
            case 38356: {
                return SSMGHC_78_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_JUKEBOX;
            }
            case 34819: {
                return SSMGHC_78_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_SD;
            }
            case 45571: {
                return SSMGHC_78_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_USB;
            }
            case 49901: {
                return SSMGHC_78_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_MEDIA_SOURCES_CODED_WLAN;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSMNDHMC_7A(int n) {
        switch (n) {
            case 46170: {
                return SSMNDHMC_7A_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_MEDIA_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSMNDHSC_7C(int n) {
        switch (n) {
            case 46170: {
                return SSMNDHSC_7C_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_MEDIA_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    @Override
    protected int[] getConditionsAffectedByList(int n) {
        switch (this.sdFeatColId) {
            default: 
        }
        return super.getConditionsAffectedByList(n);
    }

    @Override
    protected void updateAffectedFeature(int n) {
        switch (this.sdFeatColId) {
            case 84: {
                this.updateAffectedFeature_SSMDMPS_58(n);
                break;
            }
            case 85: {
                this.updateAffectedFeature_SSMDMS_59(n);
                break;
            }
            case 109: {
                this.updateAffectedFeature_SSMDTS_71(n);
                break;
            }
            default: {
                super.updateAffectedFeature(n);
            }
        }
    }

    private void updateAffectedFeature_SSMDMPS_58(int n) {
        switch (n) {
            case 60824: {
                this.updateFeature(0);
                this.updateFeature(2);
                this.updateFeature(3);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
            }
        }
    }

    private void updateAffectedFeature_SSMDMS_59(int n) {
        switch (n) {
            case 60824: {
                this.updateFeature(0);
                this.updateFeature(1);
                this.updateFeature(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
            }
        }
    }

    private void updateAffectedFeature_SSMDTS_71(int n) {
        switch (n) {
            case 60824: {
                this.updateFeature(3);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
            }
        }
    }
}

