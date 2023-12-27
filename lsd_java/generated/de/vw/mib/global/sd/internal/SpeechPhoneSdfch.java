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
import de.vw.mib.list.ListItemControl;
import de.vw.mib.sdfeaturecollectionmanager.internal.AbstractSdFeatureCollectionHandler$SdCommandData;
import de.vw.mib.sdfeaturecollectionmanager.internal.AbstractSdFeatureCollectionHandler$SdFeatureCollectionListItemControlListener;
import generated.de.vw.mib.global.datapool.SdFeatureCollectionHandlerBase;
import java.util.ArrayList;

public final class SpeechPhoneSdfch
extends SdFeatureCollectionHandlerBase {
    private static int[] SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{4};
    private static int[] SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{4};
    private static int[] SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{4};
    private static int[] SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{3};
    private static int[] SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_4 = new int[]{3};
    private static int[] SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_5 = new int[]{3};
    private static int[] SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_6 = new int[]{3};
    private static int[] SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_7 = new int[]{3};
    private static int[] SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_8 = new int[]{3};
    private static int[] SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_9 = new int[]{3};
    private static int[] SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_10 = new int[]{3};
    private static int[] SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_11 = new int[]{4};
    private static int[] SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_12 = new int[]{0};
    private static int[] SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_13 = new int[]{0};
    private static int[] SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_14 = new int[]{0};
    private static int[] SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_15 = new int[]{0};
    private static int[] SSPDCL_1FC_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_DATA_CALLSTACK_LIST_GET_CALLSTACK_TYPE = new int[]{3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15};
    private static int[] SSPDCL_1FC_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_DATA_CALLSTACK_LIST_GET_CALLSTACK_VIEW_TYPE = new int[]{0, 1, 2};
    private static int[] SSPDCL_1FC_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_DATA_CONTACT_CALLSTACK_LIST_GET_FIRST_FOUND_CONTACT_NAME_OR_NUMBER = new int[0];
    private static int[] SSPDCL_1FC_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_DATA_CONTACT_CALLSTACK_LIST_IS_CALLSTACK_LIST_CONTAINING_KNOWN_NUMBERS = new int[]{0, 1, 11};
    private static int[] SSPDCL_1FC_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_STATUS_GET_CONTACT_SPEAKABILITY = new int[]{3, 4, 5, 6, 7, 8, 9, 10};
    private static int[] SSPDCL_1FC_AFFECTED_CONDITIONS_FOR_LIST_SPEECHPHONE_DATA_CONTACT_ACCEPTED_CALLS_LIST = new int[]{0, 1, 2};
    private static int[] SSPDCL_1FC_AFFECTED_CONDITIONS_FOR_LIST_SPEECHPHONE_DATA_CONTACT_CALLSTACK_DETAIL_LIST = new int[]{0, 1, 2};
    private static int[] SSPDCL_1FC_AFFECTED_CONDITIONS_FOR_LIST_SPEECHPHONE_DATA_CONTACT_DIALED_NUMBERS_LIST = new int[]{0, 1, 2};
    private static int[] SSPDCL_1FC_AFFECTED_CONDITIONS_FOR_LIST_SPEECHPHONE_DATA_CONTACT_MISSED_CALLS_LIST = new int[]{0, 1, 2};
    private static int[] SSPDDCA_206_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{3};
    private static int[] SSPDDCA_206_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{3};
    private static int[] SSPDDCA_206_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_DATA_CONTACT_NUMBER_LIST_IS_CONTACT_SELECTED_ITEM_NOT_ONLY_OTHER = new int[]{0, 1};
    private static int[] SSPDDCD_20D_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{3};
    private static int[] SSPDDCD_20D_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{3};
    private static int[] SSPDDCD_20D_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_DATA_CONTACT_NUMBER_LIST_IS_CONTACT_SELECTED_ITEM_NOT_ONLY_OTHER = new int[]{0, 1};
    private static int[] SSPDDCN_21C_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{3};
    private static int[] SSPDDCN_21C_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{3};
    private static int[] SSPDDCN_21C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_STATUS_GET_CONTACT_SPEAKABILITY = new int[]{0, 1};
    private static int[] SSPDDN_22B_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSPDDN_22B_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSPDDN_22B_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{0};
    private static int[] SSPDDN_22B_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{0};
    private static int[] SSPDDN_22B_AFFECTED_FEATURES_FOR_CONDITION_4 = new int[]{3};
    private static int[] SSPDDN_22B_AFFECTED_FEATURES_FOR_CONDITION_5 = new int[]{0, 3};
    private static int[] SSPDDN_22B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{0, 1, 2, 3};
    private static int[] SSPDDN_22B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{0, 1, 2, 3};
    private static int[] SSPDDN_22B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_DIAL_NUMBER_GET_LAST_NUMBER_BLOCK = new int[0];
    private static int[] SSPDDN_22B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_DIAL_NUMBER_IS_NUMBER_NOT_EMPTY = new int[]{4, 5};
    private static int[] SSPDDN_22B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_STATUS_IS_EMERGENCY_NUMBER_CODED = new int[]{0};
    private static int[] SSPDDN_22B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_STATUS_IS_INFORMATION_NUMBER_CODED = new int[]{1};
    private static int[] SSPDDN_22B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_STATUS_IS_SERVICE_NUMBER_CODED = new int[]{2};
    private static int[] SSPDDNNNE_231_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_DIAL_NUMBER_GET_LAST_NUMBER_BLOCK = new int[0];
    private static int[] SSPDHCS_23F_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSPDHCS_23F_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSPDHCS_23F_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_PHONE_HELP_MODE = new int[]{0, 1};
    private static int[] SSPDHCS_243_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSPDHCS_243_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSPDHCS_243_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_PHONE_HELP_MODE = new int[]{0, 1};
    private static int[] SSPDHMS_247_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSPDHMS_247_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSPDHMS_247_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_PHONE_HELP_MODE = new int[]{0, 1};
    private static int[] SSPDHNS_24B_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSPDHNS_24B_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSPDHNS_24B_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_PHONE_HELP_MODE = new int[]{0, 1};
    private static int[] SSPDHRSS_24F_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSPDHRSS_24F_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSPDHRSS_24F_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_PHONE_HELP_MODE = new int[]{0, 1};
    private static int[] SSPDMS_25C_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSPDMS_25C_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSPDMS_25C_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_PHONE_HELP_MODE = new int[]{0, 1};
    private static int[] SSPDMM_260_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_MESSAGES_GET_INDEX_OF_MESSAGE = new int[0];
    private static int[] SSPGGC_270_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSPGGC_270_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSPGGC_270_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{0};
    private static int[] SSPGGC_270_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{0};
    private static int[] SSPGGC_270_AFFECTED_FEATURES_FOR_CONDITION_4 = new int[]{0};
    private static int[] SSPGGC_270_AFFECTED_FEATURES_FOR_CONDITION_5 = new int[]{0};
    private static int[] SSPGGC_270_AFFECTED_FEATURES_FOR_CONDITION_6 = new int[]{0};
    private static int[] SSPGGC_270_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{0, 1, 2, 3, 4, 5, 6};
    private static int[] SSPGGC_270_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{0, 1, 2, 3, 4, 5, 6};
    private static int[] SSPGGC_270_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_STATUS_GET_USE_CONTACT_GARBAGE_COMMAND = new int[]{4, 5};
    private static int[] SSPGGC_270_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_STATUS_IS_EMERGENCY_NUMBER_CODED = new int[]{0};
    private static int[] SSPGGC_270_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_STATUS_IS_INFORMATION_NUMBER_CODED = new int[]{1};
    private static int[] SSPGGC_270_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_STATUS_IS_SERVICE_NUMBER_CODED = new int[]{6};
    private static int[] SSPGHC_271_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSPGHC_271_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSPGHC_271_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{0};
    private static int[] SSPGHC_271_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{0};
    private static int[] SSPGHC_271_AFFECTED_FEATURES_FOR_CONDITION_4 = new int[]{0};
    private static int[] SSPGHC_271_AFFECTED_FEATURES_FOR_CONDITION_5 = new int[]{0};
    private static int[] SSPGHC_271_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{0, 1, 2, 3, 4, 5};
    private static int[] SSPGHC_271_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{0, 1, 2, 3, 4, 5};
    private static int[] SSPGHC_271_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_STATUS_GET_USE_CONTACT_GARBAGE_COMMAND = new int[]{1, 2};
    private static int[] SSPGHC_271_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_STATUS_IS_EMERGENCY_NUMBER_CODED = new int[]{3};
    private static int[] SSPGHC_271_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_STATUS_IS_INFORMATION_NUMBER_CODED = new int[]{4};
    private static int[] SSPGHC_271_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_STATUS_IS_SERVICE_NUMBER_CODED = new int[]{5};
    private static int[] SSPNDHCS_273_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSPNDHCS_273_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSPNDHCS_273_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_PHONE_HELP_MODE = new int[]{0, 1};
    private static int[] SSPNDHCS_275_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSPNDHCS_275_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSPNDHCS_275_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_PHONE_HELP_MODE = new int[]{0, 1};
    private static int[] SSPNDHMS_277_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSPNDHMS_277_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSPNDHMS_277_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_PHONE_HELP_MODE = new int[]{0, 1};
    private static int[] SSPNDHNS_279_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSPNDHNS_279_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSPNDHNS_279_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_PHONE_HELP_MODE = new int[]{0, 1};
    private static int[] SSPNDHRSS_27B_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSPNDHRSS_27B_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSPNDHRSS_27B_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_PHONE_HELP_MODE = new int[]{0, 1};

    @Override
    public void init(int n, int n2) {
        this.sdFeatColId = n;
        this.speechClientId = n2;
        switch (n) {
            case 420: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 421: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 422: {
                this.conditions = new boolean[8];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 423: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 424: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 425: {
                this.conditions = new boolean[4];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 426: {
                this.conditions = new boolean[4];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 427: {
                this.conditions = new boolean[16];
                this.dpProperties = new int[]{-813105152, 621150464, -1297809408, 27410, 1307115520};
                this.listItemControls = new ListItemControl[]{this.getListItemControl(-1716962560, false), this.getListItemControl(-1951843584, false), this.getListItemControl(-1733739776, false), this.getListItemControl(-1750516992, false)};
                this.listItemControlListeners = new AbstractSdFeatureCollectionHandler$SdFeatureCollectionListItemControlListener[]{new AbstractSdFeatureCollectionHandler$SdFeatureCollectionListItemControlListener(this, -1716962560), new AbstractSdFeatureCollectionHandler$SdFeatureCollectionListItemControlListener(this, -1951843584), new AbstractSdFeatureCollectionHandler$SdFeatureCollectionListItemControlListener(this, -1733739776), new AbstractSdFeatureCollectionHandler$SdFeatureCollectionListItemControlListener(this, -1750516992)};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(284, -1685963968, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(285, -1685963968, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(286, -1685963968, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(287, -1685963968, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(310, 2055355200, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(311, 2038577984, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(312, 2021800768, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(313, 1870805824, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(331, -1971176640, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(332, -1954399424, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(335, 2088909632, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(336, -2004731072, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(338, -1987953856, 3, false, false)};
                this.featureData = new int[]{1, 0, 1, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 428: {
                this.conditions = new boolean[5];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 429: {
                this.conditions = new boolean[5];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 430: {
                this.conditions = new boolean[5];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 431: {
                this.conditions = new boolean[5];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 432: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 433: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(288, -1887290560, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(289, -1937622208, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(296, -1618855104, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(331, -1971176640, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(332, -1954399424, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(335, 2088909632, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(336, -2004731072, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(337, -1920844992, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(338, -1987953856, 3, false, false)};
                this.featureData = new int[]{1, 0, 1, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 434: {
                this.conditions = new boolean[8];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 435: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 436: {
                this.conditions = new boolean[3];
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(298, 1988246336, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[6];
                break;
            }
            case 437: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{-654901248};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(299, -1786627264, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(302, -1786627264, 3, false, false)};
                this.featureData = new int[]{1, 1, 1, 3};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 438: {
                this.conditions = new boolean[7];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 439: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(296, -1753072832, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(303, -1803404480, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(331, -1971176640, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(332, -1954399424, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(333, 2088909632, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(336, -2004731072, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(338, -1987953856, 3, false, false)};
                this.featureData = new int[]{1, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 440: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(295, -1920844992, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(297, -1937622208, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(299, -1786627264, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(302, -1786627264, 3, false, false)};
                this.featureData = new int[]{1, 1, 1, 3};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 441: {
                this.conditions = new boolean[7];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 442: {
                this.conditions = new boolean[7];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 443: {
                this.conditions = new boolean[7];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 444: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{-654901248};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(299, -1786627264, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(302, -1786627264, 3, false, false)};
                this.featureData = new int[]{1, 1, 1, 3};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 445: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 446: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 447: {
                this.conditions = new boolean[7];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 448: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 449: {
                this.conditions = new boolean[8];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 450: {
                this.conditions = new boolean[7];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 451: {
                this.conditions = new boolean[8];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 452: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 453: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 454: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 455: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 456: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 457: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 458: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 459: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{1307115520};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(296, -1753072832, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(300, -1836958912, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(301, -1820181696, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(331, -1971176640, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(332, -1954399424, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(335, 2088909632, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(336, -2004731072, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(337, -1920844992, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(338, -1987953856, 3, false, false)};
                this.featureData = new int[]{1, 0, 1, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 460: {
                this.conditions = new boolean[8];
                this.featureData = new int[]{0, 0, 3};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 461: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 462: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 463: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 464: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 465: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 466: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(295, -1920844992, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(297, -1937622208, 3, false, false)};
                this.featureData = new int[]{1, 1, 1, 3};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 467: {
                this.conditions = new boolean[8];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 468: {
                this.conditions = new boolean[8];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 469: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0, 0, 3};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 470: {
                this.conditions = new boolean[6];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 471: {
                this.conditions = new boolean[6];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 472: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 473: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 474: {
                this.conditions = new boolean[6];
                this.dpProperties = new int[]{10059, 0x7A00000, 16367, -457965568, 20065, -754450176, 2063859968};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(290, 1921137472, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(291, 1954691904, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(293, 1937914688, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(294, 1887583040, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(304, -2138948800, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(305, -2122171584, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(306, -2088617152, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(307, 2122464064, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(308, 2139241280, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(309, -2105394368, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(334, -2071839936, 3, false, false)};
                this.featureData = new int[]{1, 0, 1, 3};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 475: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 476: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 477: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 478: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 479: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(295, -2138948800, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(297, -2088617152, 3, false, false)};
                this.featureData = new int[]{1, 0, 1};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 480: {
                this.dpProperties = new int[]{16367};
                this.featureData = new int[]{0, 1, 3};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 481: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 482: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 483: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 484: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 485: {
                this.featureData = new int[]{0, 1};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 486: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 487: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 488: {
                this.featureData = new int[]{0, 0, 0, 3};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 489: {
                this.featureData = new int[]{0, 0, 0, 3};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 490: {
                this.featureData = new int[]{0, 0, 0, 3};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 491: {
                this.featureData = new int[]{0, 0, 1};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 492: {
                this.featureData = new int[]{0, 0, 1};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 493: {
                this.featureData = new int[]{0, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 494: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{13507};
                this.featureData = new int[]{3};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 495: {
                this.featureData = new int[]{0, 0, 1};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 496: {
                this.featureData = new int[]{0, 0, 1};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 497: {
                this.featureData = new int[]{0, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 498: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{13507};
                this.featureData = new int[]{3};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 499: {
                this.featureData = new int[]{0, 0, 1};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 500: {
                this.featureData = new int[]{0, 0, 1};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 501: {
                this.featureData = new int[]{0, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 502: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{13507};
                this.featureData = new int[]{3};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 503: {
                this.featureData = new int[]{0, 0, 1};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 504: {
                this.featureData = new int[]{0, 0, 1};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 505: {
                this.featureData = new int[]{0, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 506: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{13507};
                this.featureData = new int[]{3};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 507: {
                this.featureData = new int[]{0, 0, 1};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 508: {
                this.featureData = new int[]{0, 0, 1};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 509: {
                this.featureData = new int[]{0, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 510: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{13507};
                this.featureData = new int[]{3};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 511: {
                this.featureData = new int[]{0, 0, 0, 3};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 512: {
                this.featureData = new int[]{1, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 513: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 514: {
                this.conditions = new boolean[10];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 515: {
                this.conditions = new boolean[10];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 516: {
                this.conditions = new boolean[10];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 517: {
                this.conditions = new boolean[10];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 518: {
                this.conditions = new boolean[10];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 519: {
                this.conditions = new boolean[10];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 520: {
                this.conditions = new boolean[10];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 521: {
                this.featureData = new int[]{0, 0, 1};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 522: {
                this.featureData = new int[]{0, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 523: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{13507};
                this.featureData = new int[]{3};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 524: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 525: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 526: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 527: {
                this.conditions = new boolean[16];
                this.dpProperties = new int[]{1729495296};
                this.featureData = new int[]{0, 3};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 528: {
                this.conditions = new boolean[1];
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(339, -1652409536, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(340, -1635632320, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 0, 1};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 529: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 530: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 531: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 532: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 533: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 534: {
                this.featureData = new int[]{3};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 535: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 536: {
                this.conditions = new boolean[14];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 537: {
                this.conditions = new boolean[7];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 538: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 539: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 540: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 541: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 542: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 543: {
                this.conditions = new boolean[7];
                this.dpProperties = new int[]{10059, 0x7A00000, 17635, 20065, -754450176, 2063859968};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(290, 1921137472, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(291, 1954691904, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(292, 1971469120, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(293, 1937914688, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(294, 1887583040, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(310, 2055355200, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(311, 2038577984, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(312, 2021800768, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(313, 1870805824, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(314, 1837251392, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(315, 1988246336, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(316, 1854028608, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(317, 1803696960, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(318, 1635924800, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(319, 1619147584, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(320, -2038285504, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(321, 1820474176, 1, false, false)};
                this.featureData = new int[]{1, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 544: {
                this.conditions = new boolean[6];
                this.dpProperties = new int[]{10059, 0x7A00000, 17635, 20065, -754450176, 2063859968};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(290, 1753365312, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(291, 1786919744, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(293, 1770142528, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(294, 1703033664, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(310, 1686256448, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(311, 1686256448, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(312, 1686256448, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(313, 1686256448, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(314, 1652702016, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(315, 1652702016, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(316, 1652702016, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(317, 1669479232, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(318, 1635924800, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(319, 1635924800, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(320, 1719810880, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(321, 1736588096, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(322, 1686256448, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(323, 1652702016, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(324, 1753365312, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(325, 1786919744, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(326, 1669479232, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(327, 1770142528, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(328, 1703033664, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(329, 1719810880, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(330, 1736588096, 2, false, false)};
                this.featureData = new int[]{1};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 545: {
                this.featureData = new int[]{0, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 546: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{13507};
                this.featureData = new int[]{3};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 547: {
                this.featureData = new int[]{0, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 548: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{13507};
                this.featureData = new int[]{3};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 549: {
                this.featureData = new int[]{0, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 550: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{13507};
                this.featureData = new int[]{3};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 551: {
                this.featureData = new int[]{0, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 552: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{13507};
                this.featureData = new int[]{3};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 553: {
                this.featureData = new int[]{0, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 554: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{13507};
                this.featureData = new int[]{3};
                this.featuresToUpdate = new boolean[1];
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
            case 420: {
                return this.createFeatureInstance_SSPDA_1F5(n);
            }
            case 421: {
                return this.createFeatureInstance_SSPDCD_1F6(n);
            }
            case 422: {
                return this.createFeatureInstance_SSPDCDC_1F7(n);
            }
            case 423: {
                return this.createFeatureInstance_SSPDCDN_1F8(n);
            }
            case 424: {
                return this.createFeatureInstance_SSPDCE_1F9(n);
            }
            case 425: {
                return this.createFeatureInstance_SSPDCEC_1FA(n);
            }
            case 426: {
                return this.createFeatureInstance_SSPDCEE_1FB(n);
            }
            case 427: {
                return this.createFeatureInstance_SSPDCL_1FC(n);
            }
            case 428: {
                return this.createFeatureInstance_SSPDCLEA_1FD(n);
            }
            case 429: {
                return this.createFeatureInstance_SSPDCLED_1FE(n);
            }
            case 430: {
                return this.createFeatureInstance_SSPDCLEM_1FF(n);
            }
            case 431: {
                return this.createFeatureInstance_SSPDCLEM_200(n);
            }
            case 432: {
                return this.createFeatureInstance_SSPDCLUN_201(n);
            }
            case 433: {
                return this.createFeatureInstance_SSPDCN_202(n);
            }
            case 434: {
                return this.createFeatureInstance_SSPDCNE_203(n);
            }
            case 435: {
                return this.createFeatureInstance_SSPDCNGO_204(n);
            }
            case 436: {
                return this.createFeatureInstance_SSPDDC_205(n);
            }
            case 437: {
                return this.createFeatureInstance_SSPDDCA_206(n);
            }
            case 438: {
                return this.createFeatureInstance_SSPDDCALTNM_207(n);
            }
            case 439: {
                return this.createFeatureInstance_SSPDDCC_208(n);
            }
            case 440: {
                return this.createFeatureInstance_SSPDDCC_209(n);
            }
            case 441: {
                return this.createFeatureInstance_SSPDDCCIM_20A(n);
            }
            case 442: {
                return this.createFeatureInstance_SSPDDCCINM_20B(n);
            }
            case 443: {
                return this.createFeatureInstance_SSPDDCCINS_20C(n);
            }
            case 444: {
                return this.createFeatureInstance_SSPDDCD_20D(n);
            }
            case 445: {
                return this.createFeatureInstance_SSPDDCDB_20E(n);
            }
            case 446: {
                return this.createFeatureInstance_SSPDDCDLTNS_20F(n);
            }
            case 447: {
                return this.createFeatureInstance_SSPDDCDLTS_210(n);
            }
            case 448: {
                return this.createFeatureInstance_SSPDDCD_211(n);
            }
            case 449: {
                return this.createFeatureInstance_SSPDDCDC_212(n);
            }
            case 450: {
                return this.createFeatureInstance_SSPDDCDLTI_213(n);
            }
            case 451: {
                return this.createFeatureInstance_SSPDDCDLT_214(n);
            }
            case 452: {
                return this.createFeatureInstance_SSPDDCDN_215(n);
            }
            case 453: {
                return this.createFeatureInstance_SSPDDCE_216(n);
            }
            case 454: {
                return this.createFeatureInstance_SSPDDCECC_217(n);
            }
            case 455: {
                return this.createFeatureInstance_SSPDDCED_218(n);
            }
            case 456: {
                return this.createFeatureInstance_SSPDDCEEC_219(n);
            }
            case 457: {
                return this.createFeatureInstance_SSPDDCENC_21A(n);
            }
            case 458: {
                return this.createFeatureInstance_SSPDDCENSC_21B(n);
            }
            case 459: {
                return this.createFeatureInstance_SSPDDCN_21C(n);
            }
            case 460: {
                return this.createFeatureInstance_SSPDDCNE_21D(n);
            }
            case 461: {
                return this.createFeatureInstance_SSPDDCNGO_21E(n);
            }
            case 462: {
                return this.createFeatureInstance_SSPDDCND_21F(n);
            }
            case 463: {
                return this.createFeatureInstance_SSPDDCND_220(n);
            }
            case 464: {
                return this.createFeatureInstance_SSPDDCNPNC_221(n);
            }
            case 465: {
                return this.createFeatureInstance_SSPDDCNPN_222(n);
            }
            case 466: {
                return this.createFeatureInstance_SSPDDCS_223(n);
            }
            case 467: {
                return this.createFeatureInstance_SSPDDCSLTM_224(n);
            }
            case 468: {
                return this.createFeatureInstance_SSPDDCSLTNM_225(n);
            }
            case 469: {
                return this.createFeatureInstance_SSPDDCSLTNS_226(n);
            }
            case 470: {
                return this.createFeatureInstance_SSPDDCWBDLTI_227(n);
            }
            case 471: {
                return this.createFeatureInstance_SSPDDCWBDLT_228(n);
            }
            case 472: {
                return this.createFeatureInstance_SSPDDI_229(n);
            }
            case 473: {
                return this.createFeatureInstance_SSPDDM_22A(n);
            }
            case 474: {
                return this.createFeatureInstance_SSPDDN_22B(n);
            }
            case 475: {
                return this.createFeatureInstance_SSPDDNCD_22C(n);
            }
            case 476: {
                return this.createFeatureInstance_SSPDDNC_22D(n);
            }
            case 477: {
                return this.createFeatureInstance_SSPDDND_22E(n);
            }
            case 478: {
                return this.createFeatureInstance_SSPDDNDN_22F(n);
            }
            case 479: {
                return this.createFeatureInstance_SSPDDNMNL_230(n);
            }
            case 480: {
                return this.createFeatureInstance_SSPDDNNNE_231(n);
            }
            case 481: {
                return this.createFeatureInstance_SSPDDNNTL_232(n);
            }
            case 482: {
                return this.createFeatureInstance_SSPDDNNTL_233(n);
            }
            case 483: {
                return this.createFeatureInstance_SSPDDNR_234(n);
            }
            case 484: {
                return this.createFeatureInstance_SSPDDNS_235(n);
            }
            case 485: {
                return this.createFeatureInstance_SSPDDNSX_236(n);
            }
            case 486: {
                return this.createFeatureInstance_SSPDDS_237(n);
            }
            case 487: {
                return this.createFeatureInstance_SSPDEC_238(n);
            }
            case 488: {
                return this.createFeatureInstance_SSPDHCE_239(n);
            }
            case 489: {
                return this.createFeatureInstance_SSPDHCI_23A(n);
            }
            case 490: {
                return this.createFeatureInstance_SSPDHCS_23B(n);
            }
            case 491: {
                return this.createFeatureInstance_SSPDHCH_23C(n);
            }
            case 492: {
                return this.createFeatureInstance_SSPDHCH_23D(n);
            }
            case 493: {
                return this.createFeatureInstance_SSPDHC_23E(n);
            }
            case 494: {
                return this.createFeatureInstance_SSPDHCS_23F(n);
            }
            case 495: {
                return this.createFeatureInstance_SSPDHCH_240(n);
            }
            case 496: {
                return this.createFeatureInstance_SSPDHCH_241(n);
            }
            case 497: {
                return this.createFeatureInstance_SSPDHC_242(n);
            }
            case 498: {
                return this.createFeatureInstance_SSPDHCS_243(n);
            }
            case 499: {
                return this.createFeatureInstance_SSPDHMH_244(n);
            }
            case 500: {
                return this.createFeatureInstance_SSPDHMH_245(n);
            }
            case 501: {
                return this.createFeatureInstance_SSPDHM_246(n);
            }
            case 502: {
                return this.createFeatureInstance_SSPDHMS_247(n);
            }
            case 503: {
                return this.createFeatureInstance_SSPDHNH_248(n);
            }
            case 504: {
                return this.createFeatureInstance_SSPDHNH_249(n);
            }
            case 505: {
                return this.createFeatureInstance_SSPDHN_24A(n);
            }
            case 506: {
                return this.createFeatureInstance_SSPDHNS_24B(n);
            }
            case 507: {
                return this.createFeatureInstance_SSPDHRS_24C(n);
            }
            case 508: {
                return this.createFeatureInstance_SSPDHRS_24D(n);
            }
            case 509: {
                return this.createFeatureInstance_SSPDHRS_24E(n);
            }
            case 510: {
                return this.createFeatureInstance_SSPDHRSS_24F(n);
            }
            case 511: {
                return this.createFeatureInstance_SSPDHR_250(n);
            }
            case 512: {
                return this.createFeatureInstance_SSPDI_251(n);
            }
            case 513: {
                return this.createFeatureInstance_SSPDLIF_252(n);
            }
            case 514: {
                return this.createFeatureInstance_SSPDLLP_253(n);
            }
            case 515: {
                return this.createFeatureInstance_SSPDLLP_254(n);
            }
            case 516: {
                return this.createFeatureInstance_SSPDLLP_255(n);
            }
            case 517: {
                return this.createFeatureInstance_SSPDLLP_256(n);
            }
            case 518: {
                return this.createFeatureInstance_SSPDLLP_257(n);
            }
            case 519: {
                return this.createFeatureInstance_SSPDLLP_258(n);
            }
            case 520: {
                return this.createFeatureInstance_SSPDLLP_259(n);
            }
            case 521: {
                return this.createFeatureInstance_SSPDMH_25A(n);
            }
            case 522: {
                return this.createFeatureInstance_SSPDM_25B(n);
            }
            case 523: {
                return this.createFeatureInstance_SSPDMS_25C(n);
            }
            case 524: {
                return this.createFeatureInstance_SSPDM_25D(n);
            }
            case 525: {
                return this.createFeatureInstance_SSPDME_25E(n);
            }
            case 526: {
                return this.createFeatureInstance_SSPDME_25F(n);
            }
            case 527: {
                return this.createFeatureInstance_SSPDMM_260(n);
            }
            case 528: {
                return this.createFeatureInstance_SSPDMN_261(n);
            }
            case 529: {
                return this.createFeatureInstance_SSPDMNM_262(n);
            }
            case 530: {
                return this.createFeatureInstance_SSPDMNS_263(n);
            }
            case 531: {
                return this.createFeatureInstance_SSPDNN_264(n);
            }
            case 532: {
                return this.createFeatureInstance_SSPDNN_265(n);
            }
            case 533: {
                return this.createFeatureInstance_SSPDNSM_266(n);
            }
            case 534: {
                return this.createFeatureInstance_SSPDNEV_267(n);
            }
            case 535: {
                return this.createFeatureInstance_SSPDPI_268(n);
            }
            case 536: {
                return this.createFeatureInstance_SSPDPNR_269(n);
            }
            case 537: {
                return this.createFeatureInstance_SSPDRC_26A(n);
            }
            case 538: {
                return this.createFeatureInstance_SSPDRE_26B(n);
            }
            case 539: {
                return this.createFeatureInstance_SSPDRN_26C(n);
            }
            case 540: {
                return this.createFeatureInstance_SSPDRS_26D(n);
            }
            case 541: {
                return this.createFeatureInstance_SSPDSM_26E(n);
            }
            case 542: {
                return this.createFeatureInstance_SSPDSND_26F(n);
            }
            case 543: {
                return this.createFeatureInstance_SSPGGC_270(n);
            }
            case 544: {
                return this.createFeatureInstance_SSPGHC_271(n);
            }
            case 545: {
                return this.createFeatureInstance_SSPNDHC_272(n);
            }
            case 546: {
                return this.createFeatureInstance_SSPNDHCS_273(n);
            }
            case 547: {
                return this.createFeatureInstance_SSPNDHC_274(n);
            }
            case 548: {
                return this.createFeatureInstance_SSPNDHCS_275(n);
            }
            case 549: {
                return this.createFeatureInstance_SSPNDHM_276(n);
            }
            case 550: {
                return this.createFeatureInstance_SSPNDHMS_277(n);
            }
            case 551: {
                return this.createFeatureInstance_SSPNDHN_278(n);
            }
            case 552: {
                return this.createFeatureInstance_SSPNDHNS_279(n);
            }
            case 553: {
                return this.createFeatureInstance_SSPNDHRS_27A(n);
            }
            case 554: {
                return this.createFeatureInstance_SSPNDHRSS_27B(n);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal sdFeatColId: ").append(this.sdFeatColId).toString());
    }

    private Feature createFeatureInstance_SSPDA_1F5(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(202);
                genericTargetFeature.setBoolean(2010, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDCD_1F6(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, true);
                genericTargetFeature.setInt(3003, 1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDCDC_1F7(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1336));
                }
                if (this.conditions[7]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1337));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1338));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1339));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1340));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1341));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1342));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDCDN_1F8(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                arrayList.add(SpeechPhoneSdfch.createPrompt(1101));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDCE_1F9(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, true);
                genericTargetFeature.setInt(3003, 2);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDCEC_1FA(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1097));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1098));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1099));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1100));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDCEE_1FB(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1102));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1103));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1104));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1105));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDCL_1FC(int n) {
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
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(307);
                genericTargetFeature.setBoolean(3050, true);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[6]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1107}, 0));
                }
                if (this.conditions[5]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1108}, 0));
                }
                if (this.conditions[4]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1109}, 0));
                }
                if (this.conditions[3]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1110}, 0));
                }
                if (this.conditions[10]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1111}, 0));
                }
                if (this.conditions[9]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1112}, 0));
                }
                if (this.conditions[8]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1113}, 0));
                }
                if (this.conditions[7]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1114}, 0));
                }
                arrayList.add(this.createOrderedPrompts(new int[]{1106}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 4: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (object == null) {
                    object = this.getI18nStrings(303)[this.getInteger(621150464)];
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                if (this.conditions[11]) {
                    ((ArrayList)object).add(this.createDynamicString(FormatterService.format(this.getI18nString(5932), this.getString(-1297809408)), true));
                }
                if (this.conditions[2]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5928), false));
                }
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5933), false));
                if (this.conditions[1]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5921), false));
                }
                if (this.conditions[0]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5923), false));
                }
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDCLEA_1FD(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1095));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1096));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1125));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1129));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1130));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, this.conditions[4]);
                genericTargetFeature.setEvent(3010, this.createEvent(1466404169));
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDCLED_1FE(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1095));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1096));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1126));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1129));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1130));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, this.conditions[4]);
                genericTargetFeature.setEvent(3010, this.createEvent(1483181385));
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDCLEM_1FF(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1095));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1096));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1127));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1129));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1130));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, this.conditions[4]);
                genericTargetFeature.setEvent(3010, this.createEvent(1499958601));
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDCLEM_200(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1095));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1096));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1128));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1129));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1130));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, this.conditions[4]);
                genericTargetFeature.setEvent(3010, this.createEvent(1516735817));
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDCLUN_201(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                arrayList.add(SpeechPhoneSdfch.createPrompt(1131));
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

    private Feature createFeatureInstance_SSPDCN_202(int n) {
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
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(307);
                genericTargetFeature.setBoolean(3050, true);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1124}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 4: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (object == null) {
                    object = FormatterService.format(this.getI18nString(5961), this.getLicValue(-1968620800, 2, 0, ""));
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5924), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5959), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5920), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDCNE_203(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[7]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1115));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1116));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1117));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1118));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1119));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1120));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1121));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1122));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDCNGO_204(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                arrayList.add(SpeechPhoneSdfch.createPrompt(1123));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDC_205(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1231));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1208));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1133));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1533513033));
                return genericTargetFeature;
            }
            case 3: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
            case 4: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1192}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 5: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (object == null) {
                    object = this.getI18nString(5965);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5938), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5935), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5937), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCA_206(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(307);
                genericTargetFeature.setBoolean(3050, true);
                return genericTargetFeature;
            }
            case 2: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1140}, 0));
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
                    object = FormatterService.format(this.getI18nString(5941), this.getLicValue(-1985398016, 2, 0, ""));
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                if (this.conditions[1]) {
                    ((ArrayList)object).add(this.createDynamicString(FormatterService.format(this.getI18nString(5940), this.getI18nStrings(302)[this.getLicValue(-1918289152, 1, 0, 0)]), true));
                }
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5928), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5920), false));
                if (this.conditions[0]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5921), false));
                }
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCALTNM_207(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1134));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1135));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1136));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1137));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1138));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1139));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCC_208(int n) {
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
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCC_209(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(307);
                genericTargetFeature.setBoolean(3050, true);
                return genericTargetFeature;
            }
            case 2: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1165}, 0));
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
                    object = FormatterService.format(this.getI18nString(5942), this.getLicValue(-1985398016, 2, 0, ""));
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5924), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5928), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5920), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCCIM_20A(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1159));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1160));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1161));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1162));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1163));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1164));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCCINM_20B(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1141));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1142));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1143));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1144));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1145));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1146));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCCINS_20C(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1224));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1225));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1226));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1227));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1228));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1229));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCD_20D(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(307);
                genericTargetFeature.setBoolean(3050, true);
                return genericTargetFeature;
            }
            case 2: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1185}, 0));
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
                    object = FormatterService.format(this.getI18nString(5941), this.getLicValue(-1985398016, 2, 0, ""));
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                if (this.conditions[1]) {
                    ((ArrayList)object).add(this.createDynamicString(FormatterService.format(this.getI18nString(5940), this.getI18nStrings(302)[this.getLicValue(-1918289152, 1, 0, 0)]), true));
                }
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5928), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5920), false));
                if (this.conditions[0]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5921), false));
                }
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCDB_20E(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1178));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCDLTNS_20F(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                arrayList.add(SpeechPhoneSdfch.createPrompt(1178));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCDLTS_210(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1179));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1180));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1181));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1182));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1183));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1184));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCD_211(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, this.conditions[0]);
                genericTargetFeature.setInt(3003, 1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCDC_212(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1216));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1217));
                }
                if (this.conditions[7]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1218));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1219));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1220));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1221));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1222));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCDLTI_213(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1148));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1150));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1152));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1154));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1156));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1158));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCDLT_214(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1147));
                }
                if (this.conditions[7]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1149));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1151));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1153));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1155));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1157));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1186));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCDN_215(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                arrayList.add(SpeechPhoneSdfch.createPrompt(1186));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCE_216(int n) {
        switch (n) {
            case 0: {
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

    private Feature createFeatureInstance_SSPDDCECC_217(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1187));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCED_218(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1188));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCEEC_219(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1189));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCENC_21A(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1190));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCENSC_21B(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1191));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCN_21C(int n) {
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
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(307);
                genericTargetFeature.setBoolean(3050, true);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1202}, 0));
                if (this.conditions[1]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1203}, 0));
                }
                if (this.conditions[0]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1204}, 0));
                }
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCNE_21D(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[7]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1193));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1194));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1195));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1196));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1197));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1198));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1199));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1200));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, false);
                return genericTargetFeature;
            }
            case 2: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (object == null) {
                    object = this.getLicValue(-2018952448, 2, 0, "");
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5924), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5959), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5920), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCNGO_21E(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                arrayList.add(SpeechPhoneSdfch.createPrompt(1201));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCND_21F(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1207));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCND_220(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1207));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCNPNC_221(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1206));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCNPN_222(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                arrayList.add(SpeechPhoneSdfch.createPrompt(1205));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCS_223(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(307);
                genericTargetFeature.setBoolean(3050, true);
                return genericTargetFeature;
            }
            case 2: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1230}, 0));
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
                    object = FormatterService.format((CharSequence)this.getI18nString(5946), this.getLicValue(-1985398016, 2, 0, ""), this.getI18nStrings(301)[this.getLicValue(-1985398016, 6, 0, 0)]);
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5924), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5922), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5920), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5926), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCSLTM_224(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1223));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1224));
                }
                if (this.conditions[7]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1225));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1226));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1227));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1228));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1229));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCSLTNM_225(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1209));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1210));
                }
                if (this.conditions[7]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1211));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1212));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1213));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1214));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1215));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCSLTNS_226(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                arrayList.add(SpeechPhoneSdfch.createPrompt(1223));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, false);
                return genericTargetFeature;
            }
            case 2: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (object == null) {
                    object = FormatterService.format(this.getI18nString(5942), this.getLicValue(-1985398016, 2, 0, ""));
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5924), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5922), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5920), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5926), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCWBDLTI_227(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1167));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1169));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1171));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1173));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1175));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1177));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDCWBDLT_228(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1166));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1168));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1170));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1172));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1174));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1176));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDI_229(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                arrayList.add(SpeechPhoneSdfch.createPrompt(1232));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDM_22A(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                arrayList.add(SpeechPhoneSdfch.createPrompt(1233));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDN_22B(int n) {
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
                arrayList.add(this.createOrderedPrompts(new int[]{1249}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 3: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[4] && object == null) {
                    object = this.getI18nString(5958);
                    bl = false;
                }
                if (this.conditions[5] && object == null) {
                    object = this.getString(16367);
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5947), false));
                if (this.conditions[4]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5957), false));
                }
                if (this.conditions[5]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5950), false));
                }
                if (this.conditions[5]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5949), false));
                }
                if (this.conditions[4]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5926), false));
                }
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDNCD_22C(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1245));
                }
                arrayList.add(SpeechPhoneSdfch.createPrompt(1238));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDNC_22D(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1242));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDND_22E(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1243));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDNDN_22F(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1244));
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
                genericTargetFeature.setInt(3003, 1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDNMNL_230(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1235));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 2: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1236}, 0));
                arrayList.add(this.createOrderedPrompts(new int[]{1237}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDNNNE_231(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(308);
                genericTargetFeature.setEvent(3064, this.createEvent(2103938377));
                genericTargetFeature.setEvent(3062, this.createEvent(1449626953));
                return genericTargetFeature;
            }
            case 1: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1239}, 0));
                arrayList.add(this.createOrderedPrompts(new int[]{1240}, 0));
                arrayList.add(this.createOrderedPrompts(new int[]{1241}, 0));
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
                    object = this.getString(16367);
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5947), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5950), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5949), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDNNTL_232(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1246));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDNNTL_233(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1246));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDNR_234(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1247));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDNS_235(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1248));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDNSX_236(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1238));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1239}, 0));
                arrayList.add(this.createOrderedPrompts(new int[]{1240}, 0));
                arrayList.add(this.createOrderedPrompts(new int[]{1241}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDDS_237(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                arrayList.add(SpeechPhoneSdfch.createPrompt(1250));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDEC_238(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                arrayList.add(SpeechPhoneSdfch.createPrompt(1251));
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

    private Feature createFeatureInstance_SSPDHCE_239(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1273));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1617399113));
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
                    object = this.getI18nString(5990);
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

    private Feature createFeatureInstance_SSPDHCI_23A(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1274));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1634176329));
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
                    object = this.getI18nString(5992);
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

    private Feature createFeatureInstance_SSPDHCS_23B(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1280));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1768394057));
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
                    object = this.getI18nString(6029);
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

    private Feature createFeatureInstance_SSPDHCH_23C(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1567067465));
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
            case 2: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1269}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDHCH_23D(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1567067465));
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
            case 2: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1269}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDHC_23E(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1268));
                arrayList.add(SpeechPhoneSdfch.createPrompt(1270));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1550290249));
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
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1269}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDHCS_23F(int n) {
        switch (n) {
            case 0: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[0] && object == null) {
                    object = this.getI18nString(5968);
                    bl = false;
                }
                if (this.conditions[1] && object == null) {
                    object = this.getI18nString(5915);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5974), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5971), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5973), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDHCH_240(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1600621897));
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
            case 2: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1272}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDHCH_241(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1600621897));
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
            case 2: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1272}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDHC_242(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1271));
                arrayList.add(SpeechPhoneSdfch.createPrompt(1270));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1583844681));
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
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1272}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDHCS_243(int n) {
        switch (n) {
            case 0: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[0] && object == null) {
                    object = this.getI18nString(5987);
                    bl = false;
                }
                if (this.conditions[1] && object == null) {
                    object = this.getI18nString(5915);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5977), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5979), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5983), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDHMH_244(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1667730761));
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
            case 2: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1276}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDHMH_245(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1667730761));
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
            case 2: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1276}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDHM_246(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1275));
                arrayList.add(SpeechPhoneSdfch.createPrompt(1270));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1650953545));
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
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1276}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDHMS_247(int n) {
        switch (n) {
            case 0: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[0] && object == null) {
                    object = this.getI18nString(5994);
                    bl = false;
                }
                if (this.conditions[1] && object == null) {
                    object = this.getI18nString(5915);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5998), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5926), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5927), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDHNH_248(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1701285193));
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
            case 2: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1278}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDHNH_249(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1701285193));
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
            case 2: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1278}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDHN_24A(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1277));
                arrayList.add(SpeechPhoneSdfch.createPrompt(1270));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1684507977));
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
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1278}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDHNS_24B(int n) {
        switch (n) {
            case 0: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[0] && object == null) {
                    object = this.getI18nString(6024);
                    bl = false;
                }
                if (this.conditions[1] && object == null) {
                    object = this.getI18nString(5915);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6021), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6023), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6005), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDHRS_24C(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1734839625));
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
            case 2: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1282}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDHRS_24D(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1734839625));
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
            case 2: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1282}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDHRS_24E(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1281));
                arrayList.add(SpeechPhoneSdfch.createPrompt(1270));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1718062409));
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
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1282}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDHRSS_24F(int n) {
        switch (n) {
            case 0: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[0] && object == null) {
                    object = this.getI18nString(6030);
                    bl = false;
                }
                if (this.conditions[1] && object == null) {
                    object = this.getI18nString(5915);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6010), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5926), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5927), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDHR_250(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1279));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1751616841));
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
                    object = this.getI18nString(6027);
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

    private Feature createFeatureInstance_SSPDI_251(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(202);
                genericTargetFeature.setBoolean(2010, true);
                return genericTargetFeature;
            }
            case 1: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                ArrayList arrayList = null;
                boolean bl = false;
                DynamicString dynamicString = this.createDynamicString((String)((Object)arrayList), bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                arrayList = new ArrayList();
                Object[] objectArray = new DynamicString[arrayList.size()];
                arrayList.toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 0);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDLIF_252(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1287));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDLLP_253(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1284));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1286));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1292));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1283));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1289));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1291));
                }
                if (this.conditions[7]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1290));
                }
                if (this.conditions[8]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1285));
                }
                if (this.conditions[9]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1287));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDLLP_254(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1284));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1286));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1292));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1283));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1289));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1291));
                }
                if (this.conditions[7]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1290));
                }
                if (this.conditions[8]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1285));
                }
                if (this.conditions[9]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1287));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDLLP_255(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1284));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1286));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1292));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1283));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1289));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1291));
                }
                if (this.conditions[7]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1290));
                }
                if (this.conditions[8]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1285));
                }
                if (this.conditions[9]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1287));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDLLP_256(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1284));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1286));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1292));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1283));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1289));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1291));
                }
                if (this.conditions[7]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1290));
                }
                if (this.conditions[8]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1285));
                }
                if (this.conditions[9]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1287));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDLLP_257(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1284));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1286));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1292));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1283));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1289));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1291));
                }
                if (this.conditions[7]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1290));
                }
                if (this.conditions[8]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1285));
                }
                if (this.conditions[9]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1287));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDLLP_258(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1284));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1286));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1292));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1283));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1289));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1291));
                }
                if (this.conditions[7]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1290));
                }
                if (this.conditions[8]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1285));
                }
                if (this.conditions[9]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1287));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDLLP_259(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1284));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1286));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1292));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1283));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1289));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1291));
                }
                if (this.conditions[7]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1290));
                }
                if (this.conditions[8]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1285));
                }
                if (this.conditions[9]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1287));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDMH_25A(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1801948489));
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
            case 2: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1295}, 0));
                arrayList.add(this.createOrderedPrompts(new int[]{1296}, 0));
                arrayList.add(this.createOrderedPrompts(new int[]{1294}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDM_25B(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1293));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1785171273));
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
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1295}, 0));
                arrayList.add(this.createOrderedPrompts(new int[]{1296}, 0));
                arrayList.add(this.createOrderedPrompts(new int[]{1294}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDMS_25C(int n) {
        switch (n) {
            case 0: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[0] && object == null) {
                    object = this.getI18nString(6018);
                    bl = false;
                }
                if (this.conditions[1] && object == null) {
                    object = this.getI18nString(5915);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6000), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6004), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6017), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 3);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDM_25D(int n) {
        switch (n) {
            case 0: {
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

    private Feature createFeatureInstance_SSPDME_25E(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1313));
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

    private Feature createFeatureInstance_SSPDME_25F(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, true);
                genericTargetFeature.setInt(3003, 2);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDMM_260(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[10]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1315));
                }
                if (this.conditions[11]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1316));
                }
                arrayList.add(SpeechPhoneSdfch.createPrompt(1310));
                if (this.conditions[7]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1298));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1303));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1301));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1302));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1306));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1307));
                }
                if (this.conditions[9]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1299));
                }
                if (this.conditions[8]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1300));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1304));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1305));
                }
                if (this.conditions[13]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1317));
                }
                if (this.conditions[14]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1318));
                }
                if (this.conditions[12]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1309));
                }
                if (this.conditions[15]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1319));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (object == null) {
                    object = FormatterService.format(this.getI18nString(6038), Integer.toString(this.getInteger(1729495296)));
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6035), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6037), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6034), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDMN_261(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1297));
                }
                arrayList.add(SpeechPhoneSdfch.createPrompt(1320));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
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
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(308);
                genericTargetFeature.setEvent(3064, this.createEvent(2103938377));
                return genericTargetFeature;
            }
            case 4: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1308}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDMNM_262(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1312));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDMNS_263(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1314));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDNN_264(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1132));
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1133));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDNN_265(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1132));
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1133));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDNSM_266(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1321));
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

    private Feature createFeatureInstance_SSPDNEV_267(int n) {
        switch (n) {
            case 0: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (object == null) {
                    object = this.getI18nString(5930);
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

    private Feature createFeatureInstance_SSPDPI_268(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1252));
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

    private Feature createFeatureInstance_SSPDPNR_269(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1253));
                }
                if (this.conditions[13]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1254));
                }
                if (this.conditions[12]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1255));
                }
                if (this.conditions[11]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1256));
                }
                if (this.conditions[9]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1258));
                }
                if (this.conditions[7]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1259));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1260));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1261));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1262));
                }
                if (this.conditions[10]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1263));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1264));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1265));
                }
                if (this.conditions[8]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1266));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1267));
                }
                arrayList.add(SpeechPhoneSdfch.createPrompt(1257));
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

    private Feature createFeatureInstance_SSPDRC_26A(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[2]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1336));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1337));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1338));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1339));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1340));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1341));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1342));
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
                genericTargetFeature.setInt(3003, 1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDRE_26B(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1334));
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
                genericTargetFeature.setInt(3003, 2);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDRN_26C(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1333));
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
                genericTargetFeature.setInt(3003, 1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPDRS_26D(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1335));
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

    private Feature createFeatureInstance_SSPDSM_26E(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechPhoneSdfch.createPrompt(1288));
                }
                arrayList.add(SpeechPhoneSdfch.createPrompt(1234));
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

    private Feature createFeatureInstance_SSPDSND_26F(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, true);
                genericTargetFeature.setInt(3003, 1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPGGC_270(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(201);
                genericTargetFeature.setEvent(2002, this.createEvent(2087161161));
                genericTargetFeature.setEvent(2003, this.createEvent(2070383945));
                genericTargetFeature.setEvent(2001, this.createEvent(2120715593));
                genericTargetFeature.setEvent(2006, this.createEvent(1818725705));
                genericTargetFeature.setEvent(2007, this.createEvent(1835502921));
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPGHC_271(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPNDHC_272(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1323));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1550290249));
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
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1323}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPNDHCS_273(int n) {
        switch (n) {
            case 0: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[0] && object == null) {
                    object = this.getI18nString(5972);
                    bl = false;
                }
                if (this.conditions[1] && object == null) {
                    object = this.getI18nString(5913);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5974), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5971), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5973), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPNDHC_274(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1326));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1583844681));
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
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1326}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPNDHCS_275(int n) {
        switch (n) {
            case 0: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[0] && object == null) {
                    object = this.getI18nString(5988);
                    bl = false;
                }
                if (this.conditions[1] && object == null) {
                    object = this.getI18nString(5913);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5977), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5979), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5983), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPNDHM_276(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1328));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1650953545));
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
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1328}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPNDHMS_277(int n) {
        switch (n) {
            case 0: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[0] && object == null) {
                    object = this.getI18nString(5996);
                    bl = false;
                }
                if (this.conditions[1] && object == null) {
                    object = this.getI18nString(5913);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5998), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5926), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5927), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPNDHN_278(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1330));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1684507977));
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
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1330}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPNDHNS_279(int n) {
        switch (n) {
            case 0: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[0] && object == null) {
                    object = this.getI18nString(6025);
                    bl = false;
                }
                if (this.conditions[1] && object == null) {
                    object = this.getI18nString(5913);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6021), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6023), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6005), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPNDHRS_27A(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechPhoneSdfch.createPrompt(1332));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1718062409));
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
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1332}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSPNDHRSS_27B(int n) {
        switch (n) {
            case 0: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[0] && object == null) {
                    object = this.getI18nString(6031);
                    bl = false;
                }
                if (this.conditions[1] && object == null) {
                    object = this.getI18nString(5913);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6010), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5926), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5927), false));
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
            case 427: {
                this.collectAllUnconditionalCommands_SSPDCL_1FC(objectArrayList);
                break;
            }
            case 433: {
                this.collectAllUnconditionalCommands_SSPDCN_202(objectArrayList);
                break;
            }
            case 436: {
                this.collectAllUnconditionalCommands_SSPDDC_205(objectArrayList);
                break;
            }
            case 437: {
                this.collectAllUnconditionalCommands_SSPDDCA_206(objectArrayList);
                break;
            }
            case 439: {
                this.collectAllUnconditionalCommands_SSPDDCC_208(objectArrayList);
                break;
            }
            case 440: {
                this.collectAllUnconditionalCommands_SSPDDCC_209(objectArrayList);
                break;
            }
            case 444: {
                this.collectAllUnconditionalCommands_SSPDDCD_20D(objectArrayList);
                break;
            }
            case 459: {
                this.collectAllUnconditionalCommands_SSPDDCN_21C(objectArrayList);
                break;
            }
            case 466: {
                this.collectAllUnconditionalCommands_SSPDDCS_223(objectArrayList);
                break;
            }
            case 474: {
                this.collectAllUnconditionalCommands_SSPDDN_22B(objectArrayList);
                break;
            }
            case 479: {
                this.collectAllUnconditionalCommands_SSPDDNMNL_230(objectArrayList);
                break;
            }
            case 528: {
                this.collectAllUnconditionalCommands_SSPDMN_261(objectArrayList);
                break;
            }
            case 543: {
                this.collectAllUnconditionalCommands_SSPGGC_270(objectArrayList);
                break;
            }
            case 544: {
                this.collectAllUnconditionalCommands_SSPGHC_271(objectArrayList);
                break;
            }
            default: {
                super.collectAllUnconditionalCommands(objectArrayList);
            }
        }
    }

    private void collectAllUnconditionalCommands_SSPDCL_1FC(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(4));
        objectArrayList.add(this.createSingleCommand(5));
        objectArrayList.add(this.createSingleCommand(6));
        objectArrayList.add(this.createSingleCommand(7));
        objectArrayList.add(this.createSingleCommand(8));
        objectArrayList.add(this.createSingleCommand(9));
        objectArrayList.add(this.createSingleCommand(10));
        objectArrayList.add(this.createSingleCommand(11));
        objectArrayList.add(this.createSingleCommand(12));
    }

    private void collectAllUnconditionalCommands_SSPDCN_202(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
        objectArrayList.add(this.createSingleCommand(4));
        objectArrayList.add(this.createSingleCommand(5));
        objectArrayList.add(this.createSingleCommand(6));
        objectArrayList.add(this.createSingleCommand(7));
        objectArrayList.add(this.createSingleCommand(8));
    }

    private void collectAllUnconditionalCommands_SSPDDC_205(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
    }

    private void collectAllUnconditionalCommands_SSPDDCA_206(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
    }

    private void collectAllUnconditionalCommands_SSPDDCC_208(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
        objectArrayList.add(this.createSingleCommand(4));
        objectArrayList.add(this.createSingleCommand(5));
        objectArrayList.add(this.createSingleCommand(6));
    }

    private void collectAllUnconditionalCommands_SSPDDCC_209(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
    }

    private void collectAllUnconditionalCommands_SSPDDCD_20D(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
    }

    private void collectAllUnconditionalCommands_SSPDDCN_21C(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
        objectArrayList.add(this.createSingleCommand(4));
        objectArrayList.add(this.createSingleCommand(5));
        objectArrayList.add(this.createSingleCommand(6));
        objectArrayList.add(this.createSingleCommand(7));
        objectArrayList.add(this.createSingleCommand(8));
    }

    private void collectAllUnconditionalCommands_SSPDDCS_223(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
    }

    private void collectAllUnconditionalCommands_SSPDDN_22B(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(7));
        objectArrayList.add(this.createSingleCommand(10));
    }

    private void collectAllUnconditionalCommands_SSPDDNMNL_230(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
    }

    private void collectAllUnconditionalCommands_SSPDMN_261(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
    }

    private void collectAllUnconditionalCommands_SSPGGC_270(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(13));
        objectArrayList.add(this.createSingleCommand(14));
    }

    private void collectAllUnconditionalCommands_SSPGHC_271(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(12));
        objectArrayList.add(this.createSingleCommand(13));
        objectArrayList.add(this.createSingleCommand(14));
        objectArrayList.add(this.createSingleCommand(23));
    }

    @Override
    protected boolean evaluateCondition(int n) {
        switch (this.sdFeatColId) {
            case 422: {
                return this.evaluateCondition_SSPDCDC_1F7(n);
            }
            case 423: {
                return this.evaluateCondition_SSPDCDN_1F8(n);
            }
            case 425: {
                return this.evaluateCondition_SSPDCEC_1FA(n);
            }
            case 426: {
                return this.evaluateCondition_SSPDCEE_1FB(n);
            }
            case 427: {
                return this.evaluateCondition_SSPDCL_1FC(n);
            }
            case 428: {
                return this.evaluateCondition_SSPDCLEA_1FD(n);
            }
            case 429: {
                return this.evaluateCondition_SSPDCLED_1FE(n);
            }
            case 430: {
                return this.evaluateCondition_SSPDCLEM_1FF(n);
            }
            case 431: {
                return this.evaluateCondition_SSPDCLEM_200(n);
            }
            case 432: {
                return this.evaluateCondition_SSPDCLUN_201(n);
            }
            case 434: {
                return this.evaluateCondition_SSPDCNE_203(n);
            }
            case 435: {
                return this.evaluateCondition_SSPDCNGO_204(n);
            }
            case 436: {
                return this.evaluateCondition_SSPDDC_205(n);
            }
            case 437: {
                return this.evaluateCondition_SSPDDCA_206(n);
            }
            case 438: {
                return this.evaluateCondition_SSPDDCALTNM_207(n);
            }
            case 441: {
                return this.evaluateCondition_SSPDDCCIM_20A(n);
            }
            case 442: {
                return this.evaluateCondition_SSPDDCCINM_20B(n);
            }
            case 443: {
                return this.evaluateCondition_SSPDDCCINS_20C(n);
            }
            case 444: {
                return this.evaluateCondition_SSPDDCD_20D(n);
            }
            case 446: {
                return this.evaluateCondition_SSPDDCDLTNS_20F(n);
            }
            case 447: {
                return this.evaluateCondition_SSPDDCDLTS_210(n);
            }
            case 448: {
                return this.evaluateCondition_SSPDDCD_211(n);
            }
            case 449: {
                return this.evaluateCondition_SSPDDCDC_212(n);
            }
            case 450: {
                return this.evaluateCondition_SSPDDCDLTI_213(n);
            }
            case 451: {
                return this.evaluateCondition_SSPDDCDLT_214(n);
            }
            case 452: {
                return this.evaluateCondition_SSPDDCDN_215(n);
            }
            case 459: {
                return this.evaluateCondition_SSPDDCN_21C(n);
            }
            case 460: {
                return this.evaluateCondition_SSPDDCNE_21D(n);
            }
            case 461: {
                return this.evaluateCondition_SSPDDCNGO_21E(n);
            }
            case 465: {
                return this.evaluateCondition_SSPDDCNPN_222(n);
            }
            case 467: {
                return this.evaluateCondition_SSPDDCSLTM_224(n);
            }
            case 468: {
                return this.evaluateCondition_SSPDDCSLTNM_225(n);
            }
            case 469: {
                return this.evaluateCondition_SSPDDCSLTNS_226(n);
            }
            case 470: {
                return this.evaluateCondition_SSPDDCWBDLTI_227(n);
            }
            case 471: {
                return this.evaluateCondition_SSPDDCWBDLT_228(n);
            }
            case 472: {
                return this.evaluateCondition_SSPDDI_229(n);
            }
            case 473: {
                return this.evaluateCondition_SSPDDM_22A(n);
            }
            case 474: {
                return this.evaluateCondition_SSPDDN_22B(n);
            }
            case 475: {
                return this.evaluateCondition_SSPDDNCD_22C(n);
            }
            case 486: {
                return this.evaluateCondition_SSPDDS_237(n);
            }
            case 487: {
                return this.evaluateCondition_SSPDEC_238(n);
            }
            case 494: {
                return this.evaluateCondition_SSPDHCS_23F(n);
            }
            case 498: {
                return this.evaluateCondition_SSPDHCS_243(n);
            }
            case 502: {
                return this.evaluateCondition_SSPDHMS_247(n);
            }
            case 506: {
                return this.evaluateCondition_SSPDHNS_24B(n);
            }
            case 510: {
                return this.evaluateCondition_SSPDHRSS_24F(n);
            }
            case 514: {
                return this.evaluateCondition_SSPDLLP_253(n);
            }
            case 515: {
                return this.evaluateCondition_SSPDLLP_254(n);
            }
            case 516: {
                return this.evaluateCondition_SSPDLLP_255(n);
            }
            case 517: {
                return this.evaluateCondition_SSPDLLP_256(n);
            }
            case 518: {
                return this.evaluateCondition_SSPDLLP_257(n);
            }
            case 519: {
                return this.evaluateCondition_SSPDLLP_258(n);
            }
            case 520: {
                return this.evaluateCondition_SSPDLLP_259(n);
            }
            case 523: {
                return this.evaluateCondition_SSPDMS_25C(n);
            }
            case 527: {
                return this.evaluateCondition_SSPDMM_260(n);
            }
            case 528: {
                return this.evaluateCondition_SSPDMN_261(n);
            }
            case 531: {
                return this.evaluateCondition_SSPDNN_264(n);
            }
            case 532: {
                return this.evaluateCondition_SSPDNN_265(n);
            }
            case 536: {
                return this.evaluateCondition_SSPDPNR_269(n);
            }
            case 537: {
                return this.evaluateCondition_SSPDRC_26A(n);
            }
            case 541: {
                return this.evaluateCondition_SSPDSM_26E(n);
            }
            case 543: {
                return this.evaluateCondition_SSPGGC_270(n);
            }
            case 544: {
                return this.evaluateCondition_SSPGHC_271(n);
            }
            case 546: {
                return this.evaluateCondition_SSPNDHCS_273(n);
            }
            case 548: {
                return this.evaluateCondition_SSPNDHCS_275(n);
            }
            case 550: {
                return this.evaluateCondition_SSPNDHMS_277(n);
            }
            case 552: {
                return this.evaluateCondition_SSPNDHNS_279(n);
            }
            case 554: {
                return this.evaluateCondition_SSPNDHRSS_27B(n);
            }
        }
        return super.evaluateCondition(n);
    }

    private boolean evaluateCondition_SSPDCDC_1F7(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880);
            }
            case 1: {
                return this.getLicValue(-1935066368, 14, 0, 0) == 0;
            }
            case 2: {
                return this.getLicValue(-1935066368, 14, 0, 0) == 1;
            }
            case 3: {
                return this.getLicValue(-1935066368, 14, 0, 0) == 2;
            }
            case 4: {
                return this.getLicValue(-1935066368, 14, 0, 0) == 3;
            }
            case 5: {
                return this.getLicValue(-1935066368, 14, 0, 0) == 4;
            }
            case 6: {
                return this.getLicValue(-1935066368, 14, 0, 0) == 5;
            }
            case 7: {
                return this.getLicValue(-1935066368, 14, 0, 0) == 6;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDCDN_1F8(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDCEC_1FA(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-813105152) == 0;
            }
            case 1: {
                return this.getInteger(-813105152) == 1;
            }
            case 2: {
                return this.getInteger(-813105152) == 2;
            }
            case 3: {
                return this.getInteger(-813105152) == 3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDCEE_1FB(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-813105152) == 0;
            }
            case 1: {
                return this.getInteger(-813105152) == 1;
            }
            case 2: {
                return this.getInteger(-813105152) == 2;
            }
            case 3: {
                return this.getInteger(-813105152) == 3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDCL_1FC(int n) {
        switch (n) {
            case 0: {
                return !(this.getBoolean(27410) || this.getInteger(621150464) == 1 && this.getListItemControl(-1750516992, true).getItemCount() > 1 || this.getInteger(621150464) == 2 && this.getListItemControl(-1733739776, true).getItemCount() > 1 || this.getInteger(621150464) == 3 && this.getListItemControl(-1716962560, true).getItemCount() > 1 || this.getInteger(621150464) == 0 && this.getListItemControl(-1951843584, true).getItemCount() > 1);
            }
            case 1: {
                return !(this.getBoolean(27410) && (this.getInteger(621150464) == 1 && this.getListItemControl(-1750516992, true).getItemCount() > 1 || this.getInteger(621150464) == 2 && this.getListItemControl(-1733739776, true).getItemCount() > 1 || this.getInteger(621150464) == 3 && this.getListItemControl(-1716962560, true).getItemCount() > 1 || this.getInteger(621150464) == 0 && this.getListItemControl(-1951843584, true).getItemCount() > 1));
            }
            case 2: {
                return this.getInteger(621150464) == 1 && this.getListItemControl(-1750516992, true).getItemCount() > 1 || this.getInteger(621150464) == 2 && this.getListItemControl(-1733739776, true).getItemCount() > 1 || this.getInteger(621150464) == 3 && this.getListItemControl(-1716962560, true).getItemCount() > 1 || this.getInteger(621150464) == 0 && this.getListItemControl(-1951843584, true).getItemCount() > 1;
            }
            case 3: {
                return (this.getInteger(1307115520) == 0 || this.getInteger(1307115520) == 1) && this.getInteger(-813105152) == 0;
            }
            case 4: {
                return (this.getInteger(1307115520) == 0 || this.getInteger(1307115520) == 1) && this.getInteger(-813105152) == 1;
            }
            case 5: {
                return (this.getInteger(1307115520) == 0 || this.getInteger(1307115520) == 1) && this.getInteger(-813105152) == 2;
            }
            case 6: {
                return (this.getInteger(1307115520) == 0 || this.getInteger(1307115520) == 1) && this.getInteger(-813105152) == 3;
            }
            case 7: {
                return this.getInteger(1307115520) == 2 && this.getInteger(-813105152) == 0;
            }
            case 8: {
                return this.getInteger(1307115520) == 2 && this.getInteger(-813105152) == 1;
            }
            case 9: {
                return this.getInteger(1307115520) == 2 && this.getInteger(-813105152) == 2;
            }
            case 10: {
                return this.getInteger(1307115520) == 2 && this.getInteger(-813105152) == 3;
            }
            case 11: {
                return this.getBoolean(27410);
            }
            case 12: {
                return this.getInteger(-813105152) == 0;
            }
            case 13: {
                return this.getInteger(-813105152) == 1;
            }
            case 14: {
                return this.getInteger(-813105152) == 2;
            }
            case 15: {
                return this.getInteger(-813105152) == 3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDCLEA_1FD(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(21570) && (this.getInteger(1307115520) == 0 || this.getInteger(1307115520) == 1) && this.getBoolean(1075904768);
            }
            case 1: {
                return !this.getBoolean(21570) && (this.getInteger(1307115520) == 2 || !this.getBoolean(1075904768));
            }
            case 2: {
                return this.getBoolean(21570) && (this.getInteger(1307115520) == 0 || this.getInteger(1307115520) == 1);
            }
            case 3: {
                return this.getBoolean(21570) && this.getInteger(1307115520) == 2;
            }
            case 4: {
                return !this.getBoolean(21570);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDCLED_1FE(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(21570) && (this.getInteger(1307115520) == 0 || this.getInteger(1307115520) == 1) && this.getBoolean(1075904768);
            }
            case 1: {
                return !this.getBoolean(21570) && (this.getInteger(1307115520) == 2 || !this.getBoolean(1075904768));
            }
            case 2: {
                return this.getBoolean(21570) && (this.getInteger(1307115520) == 0 || this.getInteger(1307115520) == 1);
            }
            case 3: {
                return this.getBoolean(21570) && this.getInteger(1307115520) == 2;
            }
            case 4: {
                return !this.getBoolean(21570);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDCLEM_1FF(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(21570) && (this.getInteger(1307115520) == 0 || this.getInteger(1307115520) == 1) && this.getBoolean(1075904768);
            }
            case 1: {
                return !this.getBoolean(21570) && (this.getInteger(1307115520) == 2 || !this.getBoolean(1075904768));
            }
            case 2: {
                return this.getBoolean(21570) && (this.getInteger(1307115520) == 0 || this.getInteger(1307115520) == 1);
            }
            case 3: {
                return this.getBoolean(21570) && this.getInteger(1307115520) == 2;
            }
            case 4: {
                return !this.getBoolean(21570);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDCLEM_200(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(21570) && (this.getInteger(1307115520) == 0 || this.getInteger(1307115520) == 1) && this.getBoolean(1075904768);
            }
            case 1: {
                return !this.getBoolean(21570) && (this.getInteger(1307115520) == 2 || !this.getBoolean(1075904768));
            }
            case 2: {
                return this.getBoolean(21570) && (this.getInteger(1307115520) == 0 || this.getInteger(1307115520) == 1);
            }
            case 3: {
                return this.getBoolean(21570) && this.getInteger(1307115520) == 2;
            }
            case 4: {
                return !this.getBoolean(21570);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDCLUN_201(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDCNE_203(int n) {
        switch (n) {
            case 0: {
                return this.getLicValue(-1968620800, 1, 0, 0) == 0 && (this.getLicValue(-1968620800, 14, 0, 0) == 0 && this.getLicValue(-1968620800, 17, 0, 0) == 1 || this.getLicValue(-1968620800, 17, 0, 0) != 1);
            }
            case 1: {
                return this.getLicValue(-1968620800, 1, 0, 0) == 0 && this.getLicValue(-1968620800, 14, 0, 0) == 1 && this.getLicValue(-1968620800, 17, 0, 0) == 1;
            }
            case 2: {
                return this.getLicValue(-1968620800, 1, 0, 0) == 0 && this.getLicValue(-1968620800, 14, 0, 0) == 2 && this.getLicValue(-1968620800, 17, 0, 0) == 1;
            }
            case 3: {
                return this.getLicValue(-1968620800, 1, 0, 0) == 0 && this.getLicValue(-1968620800, 14, 0, 0) == 3 && this.getLicValue(-1968620800, 17, 0, 0) == 1;
            }
            case 4: {
                return this.getLicValue(-1968620800, 1, 0, 0) == 0 && this.getLicValue(-1968620800, 14, 0, 0) == 4 && this.getLicValue(-1968620800, 17, 0, 0) == 1;
            }
            case 5: {
                return this.getLicValue(-1968620800, 1, 0, 0) == 0 && this.getLicValue(-1968620800, 14, 0, 0) == 5 && this.getLicValue(-1968620800, 17, 0, 0) == 1;
            }
            case 6: {
                return this.getLicValue(-1968620800, 1, 0, 0) == 0 && this.getLicValue(-1968620800, 14, 0, 0) == 6 && this.getLicValue(-1968620800, 17, 0, 0) == 1;
            }
            case 7: {
                return this.getLicValue(-1968620800, 1, 0, 0) > 0;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDCNGO_204(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDDC_205(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(27957) && this.getInteger(1307115520) != 0;
            }
            case 1: {
                return !this.getBoolean(27957);
            }
            case 2: {
                return this.getBoolean(27957);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDDCA_206(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(-654901248);
            }
            case 1: {
                return this.getBoolean(-654901248);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDDCALTNM_207(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880);
            }
            case 1: {
                return this.getInteger(2147090432) == 1;
            }
            case 2: {
                return this.getInteger(2147090432) == 2;
            }
            case 3: {
                return this.getInteger(2147090432) == 3;
            }
            case 4: {
                return this.getInteger(2147090432) == 4;
            }
            case 5: {
                return this.getInteger(2147090432) == 5;
            }
            case 6: {
                return this.getInteger(2147090432) == 6;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDDCCIM_20A(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880);
            }
            case 1: {
                return this.getInteger(2147090432) == 1;
            }
            case 2: {
                return this.getInteger(2147090432) == 2;
            }
            case 3: {
                return this.getInteger(2147090432) == 3;
            }
            case 4: {
                return this.getInteger(2147090432) == 4;
            }
            case 5: {
                return this.getInteger(2147090432) == 5;
            }
            case 6: {
                return this.getInteger(2147090432) == 6;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDDCCINM_20B(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880);
            }
            case 1: {
                return this.getInteger(2147090432) == 1;
            }
            case 2: {
                return this.getInteger(2147090432) == 2;
            }
            case 3: {
                return this.getInteger(2147090432) == 3;
            }
            case 4: {
                return this.getInteger(2147090432) == 4;
            }
            case 5: {
                return this.getInteger(2147090432) == 5;
            }
            case 6: {
                return this.getInteger(2147090432) == 6;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDDCCINS_20C(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880);
            }
            case 1: {
                return this.getInteger(2147090432) == 1;
            }
            case 2: {
                return this.getInteger(2147090432) == 2;
            }
            case 3: {
                return this.getInteger(2147090432) == 3;
            }
            case 4: {
                return this.getInteger(2147090432) == 4;
            }
            case 5: {
                return this.getInteger(2147090432) == 5;
            }
            case 6: {
                return this.getInteger(2147090432) == 6;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDDCD_20D(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(-654901248);
            }
            case 1: {
                return this.getBoolean(-654901248);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDDCDLTNS_20F(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDDCDLTS_210(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880);
            }
            case 1: {
                return this.getInteger(2147090432) == 1;
            }
            case 2: {
                return this.getInteger(2147090432) == 2;
            }
            case 3: {
                return this.getInteger(2147090432) == 3;
            }
            case 4: {
                return this.getInteger(2147090432) == 4;
            }
            case 5: {
                return this.getInteger(2147090432) == 5;
            }
            case 6: {
                return this.getInteger(2147090432) == 6;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDDCD_211(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(-302907392);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDDCDC_212(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880);
            }
            case 1: {
                return this.getLicValue(-1985398016, 6, 0, 0) == 0;
            }
            case 2: {
                return this.getLicValue(-1985398016, 6, 0, 0) == 1;
            }
            case 3: {
                return this.getLicValue(-1985398016, 6, 0, 0) == 2;
            }
            case 4: {
                return this.getLicValue(-1985398016, 6, 0, 0) == 3;
            }
            case 5: {
                return this.getLicValue(-1985398016, 6, 0, 0) == 4;
            }
            case 6: {
                return this.getLicValue(-1985398016, 6, 0, 0) == 5;
            }
            case 7: {
                return this.getLicValue(-1985398016, 6, 0, 0) == 6;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDDCDLTI_213(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880);
            }
            case 1: {
                return this.getInteger(2147090432) == 1;
            }
            case 2: {
                return this.getInteger(2147090432) == 2;
            }
            case 3: {
                return this.getInteger(2147090432) == 3;
            }
            case 4: {
                return this.getInteger(2147090432) == 4;
            }
            case 5: {
                return this.getInteger(2147090432) == 5;
            }
            case 6: {
                return this.getInteger(2147090432) == 6;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDDCDLT_214(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880);
            }
            case 1: {
                return this.getInteger(2147090432) == 0;
            }
            case 2: {
                return this.getInteger(2147090432) == 1;
            }
            case 3: {
                return this.getInteger(2147090432) == 2;
            }
            case 4: {
                return this.getInteger(2147090432) == 3;
            }
            case 5: {
                return this.getInteger(2147090432) == 4;
            }
            case 6: {
                return this.getInteger(2147090432) == 5;
            }
            case 7: {
                return this.getInteger(2147090432) == 6;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDDCDN_215(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDDCN_21C(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(1307115520) != 0;
            }
            case 1: {
                return this.getInteger(1307115520) == 0;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDDCNE_21D(int n) {
        switch (n) {
            case 0: {
                return this.getLicValue(-2018952448, 1, 0, 0) == 0 && (this.getLicValue(-2018952448, 6, 0, 0) == 0 && this.getLicValue(-2018952448, 4, 0, 0) == 1 || this.getLicValue(-2018952448, 4, 0, 0) != 1);
            }
            case 1: {
                return this.getLicValue(-2018952448, 1, 0, 0) == 0 && this.getLicValue(-2018952448, 6, 0, 0) == 1 && this.getLicValue(-2018952448, 4, 0, 0) == 1;
            }
            case 2: {
                return this.getLicValue(-2018952448, 1, 0, 0) == 0 && this.getLicValue(-2018952448, 6, 0, 0) == 2 && this.getLicValue(-2018952448, 4, 0, 0) == 1;
            }
            case 3: {
                return this.getLicValue(-2018952448, 1, 0, 0) == 0 && this.getLicValue(-2018952448, 6, 0, 0) == 3 && this.getLicValue(-2018952448, 4, 0, 0) == 1;
            }
            case 4: {
                return this.getLicValue(-2018952448, 1, 0, 0) == 0 && this.getLicValue(-2018952448, 6, 0, 0) == 4 && this.getLicValue(-2018952448, 4, 0, 0) == 1;
            }
            case 5: {
                return this.getLicValue(-2018952448, 1, 0, 0) == 0 && this.getLicValue(-2018952448, 6, 0, 0) == 5 && this.getLicValue(-2018952448, 4, 0, 0) == 1;
            }
            case 6: {
                return this.getLicValue(-2018952448, 1, 0, 0) == 0 && this.getLicValue(-2018952448, 6, 0, 0) == 6 && this.getLicValue(-2018952448, 4, 0, 0) == 1;
            }
            case 7: {
                return this.getLicValue(-2018952448, 1, 0, 0) > 0;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDDCNGO_21E(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDDCNPN_222(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDDCSLTM_224(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880);
            }
            case 1: {
                return this.getLicValue(-1985398016, 6, 0, 0) == 0;
            }
            case 2: {
                return this.getLicValue(-1985398016, 6, 0, 0) == 1;
            }
            case 3: {
                return this.getLicValue(-1985398016, 6, 0, 0) == 2;
            }
            case 4: {
                return this.getLicValue(-1985398016, 6, 0, 0) == 3;
            }
            case 5: {
                return this.getLicValue(-1985398016, 6, 0, 0) == 4;
            }
            case 6: {
                return this.getLicValue(-1985398016, 6, 0, 0) == 5;
            }
            case 7: {
                return this.getLicValue(-1985398016, 6, 0, 0) == 6;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDDCSLTNM_225(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880);
            }
            case 1: {
                return this.getLicValue(-1985398016, 6, 0, 0) == 0;
            }
            case 2: {
                return this.getLicValue(-1985398016, 6, 0, 0) == 1;
            }
            case 3: {
                return this.getLicValue(-1985398016, 6, 0, 0) == 2;
            }
            case 4: {
                return this.getLicValue(-1985398016, 6, 0, 0) == 3;
            }
            case 5: {
                return this.getLicValue(-1985398016, 6, 0, 0) == 4;
            }
            case 6: {
                return this.getLicValue(-1985398016, 6, 0, 0) == 5;
            }
            case 7: {
                return this.getLicValue(-1985398016, 6, 0, 0) == 6;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDDCSLTNS_226(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDDCWBDLTI_227(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(2147090432) == 1;
            }
            case 1: {
                return this.getInteger(2147090432) == 2;
            }
            case 2: {
                return this.getInteger(2147090432) == 3;
            }
            case 3: {
                return this.getInteger(2147090432) == 4;
            }
            case 4: {
                return this.getInteger(2147090432) == 5;
            }
            case 5: {
                return this.getInteger(2147090432) == 6;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDDCWBDLT_228(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(2147090432) == 1;
            }
            case 1: {
                return this.getInteger(2147090432) == 2;
            }
            case 2: {
                return this.getInteger(2147090432) == 3;
            }
            case 3: {
                return this.getInteger(2147090432) == 4;
            }
            case 4: {
                return this.getInteger(2147090432) == 5;
            }
            case 5: {
                return this.getInteger(2147090432) == 6;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDDI_229(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDDM_22A(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDDN_22B(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059) && this.getBoolean(20065);
            }
            case 1: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059) && this.getBoolean(-754450176);
            }
            case 2: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059) && this.getBoolean(2063859968);
            }
            case 3: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 4: {
                return !this.getBoolean(-457965568);
            }
            case 5: {
                return this.getBoolean(-457965568);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDDNCD_22C(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(-107544576);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDDS_237(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDEC_238(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDHCS_23F(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(13507);
            }
            case 1: {
                return this.getBoolean(13507);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDHCS_243(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(13507);
            }
            case 1: {
                return this.getBoolean(13507);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDHMS_247(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(13507);
            }
            case 1: {
                return this.getBoolean(13507);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDHNS_24B(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(13507);
            }
            case 1: {
                return this.getBoolean(13507);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDHRSS_24F(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(13507);
            }
            case 1: {
                return this.getBoolean(13507);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDLLP_253(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880) && this.getInteger(17659) != 8;
            }
            case 1: {
                return this.getInteger(17659) == 0;
            }
            case 2: {
                return this.getInteger(17659) == 1;
            }
            case 3: {
                return this.getInteger(17659) == 2;
            }
            case 4: {
                return this.getInteger(17659) == 3;
            }
            case 5: {
                return this.getInteger(17659) == 4;
            }
            case 6: {
                return this.getInteger(17659) == 5;
            }
            case 7: {
                return this.getInteger(17659) == 6;
            }
            case 8: {
                return this.getInteger(17659) == 7;
            }
            case 9: {
                return this.getInteger(17659) == 8;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDLLP_254(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880) && this.getInteger(17659) != 8;
            }
            case 1: {
                return this.getInteger(17659) == 0;
            }
            case 2: {
                return this.getInteger(17659) == 1;
            }
            case 3: {
                return this.getInteger(17659) == 2;
            }
            case 4: {
                return this.getInteger(17659) == 3;
            }
            case 5: {
                return this.getInteger(17659) == 4;
            }
            case 6: {
                return this.getInteger(17659) == 5;
            }
            case 7: {
                return this.getInteger(17659) == 6;
            }
            case 8: {
                return this.getInteger(17659) == 7;
            }
            case 9: {
                return this.getInteger(17659) == 8;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDLLP_255(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880) && this.getInteger(17659) != 8;
            }
            case 1: {
                return this.getInteger(17659) == 0;
            }
            case 2: {
                return this.getInteger(17659) == 1;
            }
            case 3: {
                return this.getInteger(17659) == 2;
            }
            case 4: {
                return this.getInteger(17659) == 3;
            }
            case 5: {
                return this.getInteger(17659) == 4;
            }
            case 6: {
                return this.getInteger(17659) == 5;
            }
            case 7: {
                return this.getInteger(17659) == 6;
            }
            case 8: {
                return this.getInteger(17659) == 7;
            }
            case 9: {
                return this.getInteger(17659) == 8;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDLLP_256(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880) && this.getInteger(17659) != 8;
            }
            case 1: {
                return this.getInteger(17659) == 0;
            }
            case 2: {
                return this.getInteger(17659) == 1;
            }
            case 3: {
                return this.getInteger(17659) == 2;
            }
            case 4: {
                return this.getInteger(17659) == 3;
            }
            case 5: {
                return this.getInteger(17659) == 4;
            }
            case 6: {
                return this.getInteger(17659) == 5;
            }
            case 7: {
                return this.getInteger(17659) == 6;
            }
            case 8: {
                return this.getInteger(17659) == 7;
            }
            case 9: {
                return this.getInteger(17659) == 8;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDLLP_257(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880) && this.getInteger(17659) != 8;
            }
            case 1: {
                return this.getInteger(17659) == 0;
            }
            case 2: {
                return this.getInteger(17659) == 1;
            }
            case 3: {
                return this.getInteger(17659) == 2;
            }
            case 4: {
                return this.getInteger(17659) == 3;
            }
            case 5: {
                return this.getInteger(17659) == 4;
            }
            case 6: {
                return this.getInteger(17659) == 5;
            }
            case 7: {
                return this.getInteger(17659) == 6;
            }
            case 8: {
                return this.getInteger(17659) == 7;
            }
            case 9: {
                return this.getInteger(17659) == 8;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDLLP_258(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880) && this.getInteger(17659) != 8;
            }
            case 1: {
                return this.getInteger(17659) == 0;
            }
            case 2: {
                return this.getInteger(17659) == 1;
            }
            case 3: {
                return this.getInteger(17659) == 2;
            }
            case 4: {
                return this.getInteger(17659) == 3;
            }
            case 5: {
                return this.getInteger(17659) == 4;
            }
            case 6: {
                return this.getInteger(17659) == 5;
            }
            case 7: {
                return this.getInteger(17659) == 6;
            }
            case 8: {
                return this.getInteger(17659) == 7;
            }
            case 9: {
                return this.getInteger(17659) == 8;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDLLP_259(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880) && this.getInteger(17659) != 8;
            }
            case 1: {
                return this.getInteger(17659) == 0;
            }
            case 2: {
                return this.getInteger(17659) == 1;
            }
            case 3: {
                return this.getInteger(17659) == 2;
            }
            case 4: {
                return this.getInteger(17659) == 3;
            }
            case 5: {
                return this.getInteger(17659) == 4;
            }
            case 6: {
                return this.getInteger(17659) == 5;
            }
            case 7: {
                return this.getInteger(17659) == 6;
            }
            case 8: {
                return this.getInteger(17659) == 7;
            }
            case 9: {
                return this.getInteger(17659) == 8;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDMS_25C(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(13507);
            }
            case 1: {
                return this.getBoolean(13507);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDMM_260(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(-1810693888) && (this.getInteger(24018) == 1 || this.getInteger(24018) == 2) && this.getInteger(435814400) == 0;
            }
            case 1: {
                return !this.getBoolean(-1810693888) && (this.getInteger(24018) == 1 || this.getInteger(24018) == 2) && this.getInteger(435814400) == 1;
            }
            case 2: {
                return !this.getBoolean(-1810693888) && this.getInteger(24018) == 0;
            }
            case 3: {
                return !this.getBoolean(-1810693888) && this.getInteger(24018) == 3 && this.getInteger(-1886781440) != 0;
            }
            case 4: {
                return !this.getBoolean(-1810693888) && this.getInteger(24018) == 3 && this.getInteger(-1886781440) == 0;
            }
            case 5: {
                return this.getBoolean(-1810693888) && (this.getInteger(24018) == 1 || this.getInteger(24018) == 2) && this.getInteger(435814400) == 0;
            }
            case 6: {
                return this.getBoolean(-1810693888) && (this.getInteger(24018) == 1 || this.getInteger(24018) == 2) && this.getInteger(435814400) == 1;
            }
            case 7: {
                return this.getBoolean(-1810693888) && this.getInteger(24018) == 0;
            }
            case 8: {
                return this.getBoolean(-1810693888) && this.getInteger(24018) == 3 && this.getInteger(-1886781440) != 0;
            }
            case 9: {
                return this.getBoolean(-1810693888) && this.getInteger(24018) == 3 && this.getInteger(-1886781440) == 0;
            }
            case 10: {
                return this.getBoolean(102170880) && this.getInteger(-323878912) == 1;
            }
            case 11: {
                return this.getBoolean(102170880) && this.getInteger(-323878912) > 1;
            }
            case 12: {
                return this.getInteger(2116288768) == 2 || this.getInteger(2116288768) == 4;
            }
            case 13: {
                return this.getInteger(2116288768) == 0;
            }
            case 14: {
                return this.getInteger(2116288768) == 1;
            }
            case 15: {
                return this.getInteger(2116288768) == 3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDMN_261(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(2116288768) == 2 || this.getInteger(2116288768) == 4;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDNN_264(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(1307115520) != 0;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDNN_265(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(1307115520) != 0;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDPNR_269(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(10260) == 1;
            }
            case 1: {
                return this.getInteger(10260) == 10;
            }
            case 2: {
                return this.getInteger(10260) == 11;
            }
            case 3: {
                return this.getInteger(10260) == 12;
            }
            case 4: {
                return this.getInteger(10260) == 13;
            }
            case 5: {
                return this.getInteger(10260) == 14;
            }
            case 6: {
                return this.getInteger(10260) == 2;
            }
            case 7: {
                return this.getInteger(10260) == 3;
            }
            case 8: {
                return this.getInteger(10260) == 4;
            }
            case 9: {
                return this.getInteger(10260) == 5;
            }
            case 10: {
                return this.getInteger(10260) == 6;
            }
            case 11: {
                return this.getInteger(10260) == 7;
            }
            case 12: {
                return this.getInteger(10260) == 8;
            }
            case 13: {
                return this.getInteger(10260) == 9;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDRC_26A(int n) {
        switch (n) {
            case 0: {
                return this.getLicValue(-1935066368, 14, 0, 0) == 0;
            }
            case 1: {
                return this.getLicValue(-1935066368, 14, 0, 0) == 1;
            }
            case 2: {
                return this.getLicValue(-1935066368, 14, 0, 0) == 2;
            }
            case 3: {
                return this.getLicValue(-1935066368, 14, 0, 0) == 3;
            }
            case 4: {
                return this.getLicValue(-1935066368, 14, 0, 0) == 4;
            }
            case 5: {
                return this.getLicValue(-1935066368, 14, 0, 0) == 5;
            }
            case 6: {
                return this.getLicValue(-1935066368, 14, 0, 0) == 6;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPDSM_26E(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(102170880);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPGGC_270(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059) && this.getBoolean(20065);
            }
            case 1: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059) && this.getBoolean(-754450176);
            }
            case 2: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 3: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 4: {
                return !this.getBoolean(17635) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 5: {
                return this.getBoolean(17635) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 6: {
                return this.getBoolean(2063859968) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPGHC_271(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 1: {
                return !this.getBoolean(17635) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 2: {
                return this.getBoolean(17635) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 3: {
                return this.getBoolean(20065) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 4: {
                return this.getBoolean(-754450176) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 5: {
                return this.getBoolean(2063859968) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPNDHCS_273(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(13507);
            }
            case 1: {
                return this.getBoolean(13507);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPNDHCS_275(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(13507);
            }
            case 1: {
                return this.getBoolean(13507);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPNDHMS_277(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(13507);
            }
            case 1: {
                return this.getBoolean(13507);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPNDHNS_279(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(13507);
            }
            case 1: {
                return this.getBoolean(13507);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSPNDHRSS_27B(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(13507);
            }
            case 1: {
                return this.getBoolean(13507);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    @Override
    protected void collectAllCommandsGuardedByOneCondition(ObjectArrayList objectArrayList, int n) {
        switch (this.sdFeatColId) {
            case 422: {
                this.collectAllCommandsGuardedByOneCondition_SSPDCDC_1F7(objectArrayList, n);
                break;
            }
            case 423: {
                this.collectAllCommandsGuardedByOneCondition_SSPDCDN_1F8(objectArrayList, n);
                break;
            }
            case 425: {
                this.collectAllCommandsGuardedByOneCondition_SSPDCEC_1FA(objectArrayList, n);
                break;
            }
            case 426: {
                this.collectAllCommandsGuardedByOneCondition_SSPDCEE_1FB(objectArrayList, n);
                break;
            }
            case 427: {
                this.collectAllCommandsGuardedByOneCondition_SSPDCL_1FC(objectArrayList, n);
                break;
            }
            case 428: {
                this.collectAllCommandsGuardedByOneCondition_SSPDCLEA_1FD(objectArrayList, n);
                break;
            }
            case 429: {
                this.collectAllCommandsGuardedByOneCondition_SSPDCLED_1FE(objectArrayList, n);
                break;
            }
            case 430: {
                this.collectAllCommandsGuardedByOneCondition_SSPDCLEM_1FF(objectArrayList, n);
                break;
            }
            case 431: {
                this.collectAllCommandsGuardedByOneCondition_SSPDCLEM_200(objectArrayList, n);
                break;
            }
            case 432: {
                this.collectAllCommandsGuardedByOneCondition_SSPDCLUN_201(objectArrayList, n);
                break;
            }
            case 434: {
                this.collectAllCommandsGuardedByOneCondition_SSPDCNE_203(objectArrayList, n);
                break;
            }
            case 435: {
                this.collectAllCommandsGuardedByOneCondition_SSPDCNGO_204(objectArrayList, n);
                break;
            }
            case 436: {
                this.collectAllCommandsGuardedByOneCondition_SSPDDC_205(objectArrayList, n);
                break;
            }
            case 437: {
                this.collectAllCommandsGuardedByOneCondition_SSPDDCA_206(objectArrayList, n);
                break;
            }
            case 438: {
                this.collectAllCommandsGuardedByOneCondition_SSPDDCALTNM_207(objectArrayList, n);
                break;
            }
            case 441: {
                this.collectAllCommandsGuardedByOneCondition_SSPDDCCIM_20A(objectArrayList, n);
                break;
            }
            case 442: {
                this.collectAllCommandsGuardedByOneCondition_SSPDDCCINM_20B(objectArrayList, n);
                break;
            }
            case 443: {
                this.collectAllCommandsGuardedByOneCondition_SSPDDCCINS_20C(objectArrayList, n);
                break;
            }
            case 444: {
                this.collectAllCommandsGuardedByOneCondition_SSPDDCD_20D(objectArrayList, n);
                break;
            }
            case 446: {
                this.collectAllCommandsGuardedByOneCondition_SSPDDCDLTNS_20F(objectArrayList, n);
                break;
            }
            case 447: {
                this.collectAllCommandsGuardedByOneCondition_SSPDDCDLTS_210(objectArrayList, n);
                break;
            }
            case 448: {
                this.collectAllCommandsGuardedByOneCondition_SSPDDCD_211(objectArrayList, n);
                break;
            }
            case 449: {
                this.collectAllCommandsGuardedByOneCondition_SSPDDCDC_212(objectArrayList, n);
                break;
            }
            case 450: {
                this.collectAllCommandsGuardedByOneCondition_SSPDDCDLTI_213(objectArrayList, n);
                break;
            }
            case 451: {
                this.collectAllCommandsGuardedByOneCondition_SSPDDCDLT_214(objectArrayList, n);
                break;
            }
            case 452: {
                this.collectAllCommandsGuardedByOneCondition_SSPDDCDN_215(objectArrayList, n);
                break;
            }
            case 459: {
                this.collectAllCommandsGuardedByOneCondition_SSPDDCN_21C(objectArrayList, n);
                break;
            }
            case 460: {
                this.collectAllCommandsGuardedByOneCondition_SSPDDCNE_21D(objectArrayList, n);
                break;
            }
            case 461: {
                this.collectAllCommandsGuardedByOneCondition_SSPDDCNGO_21E(objectArrayList, n);
                break;
            }
            case 465: {
                this.collectAllCommandsGuardedByOneCondition_SSPDDCNPN_222(objectArrayList, n);
                break;
            }
            case 467: {
                this.collectAllCommandsGuardedByOneCondition_SSPDDCSLTM_224(objectArrayList, n);
                break;
            }
            case 468: {
                this.collectAllCommandsGuardedByOneCondition_SSPDDCSLTNM_225(objectArrayList, n);
                break;
            }
            case 469: {
                this.collectAllCommandsGuardedByOneCondition_SSPDDCSLTNS_226(objectArrayList, n);
                break;
            }
            case 470: {
                this.collectAllCommandsGuardedByOneCondition_SSPDDCWBDLTI_227(objectArrayList, n);
                break;
            }
            case 471: {
                this.collectAllCommandsGuardedByOneCondition_SSPDDCWBDLT_228(objectArrayList, n);
                break;
            }
            case 472: {
                this.collectAllCommandsGuardedByOneCondition_SSPDDI_229(objectArrayList, n);
                break;
            }
            case 473: {
                this.collectAllCommandsGuardedByOneCondition_SSPDDM_22A(objectArrayList, n);
                break;
            }
            case 474: {
                this.collectAllCommandsGuardedByOneCondition_SSPDDN_22B(objectArrayList, n);
                break;
            }
            case 475: {
                this.collectAllCommandsGuardedByOneCondition_SSPDDNCD_22C(objectArrayList, n);
                break;
            }
            case 486: {
                this.collectAllCommandsGuardedByOneCondition_SSPDDS_237(objectArrayList, n);
                break;
            }
            case 487: {
                this.collectAllCommandsGuardedByOneCondition_SSPDEC_238(objectArrayList, n);
                break;
            }
            case 494: {
                this.collectAllCommandsGuardedByOneCondition_SSPDHCS_23F(objectArrayList, n);
                break;
            }
            case 498: {
                this.collectAllCommandsGuardedByOneCondition_SSPDHCS_243(objectArrayList, n);
                break;
            }
            case 502: {
                this.collectAllCommandsGuardedByOneCondition_SSPDHMS_247(objectArrayList, n);
                break;
            }
            case 506: {
                this.collectAllCommandsGuardedByOneCondition_SSPDHNS_24B(objectArrayList, n);
                break;
            }
            case 510: {
                this.collectAllCommandsGuardedByOneCondition_SSPDHRSS_24F(objectArrayList, n);
                break;
            }
            case 514: {
                this.collectAllCommandsGuardedByOneCondition_SSPDLLP_253(objectArrayList, n);
                break;
            }
            case 515: {
                this.collectAllCommandsGuardedByOneCondition_SSPDLLP_254(objectArrayList, n);
                break;
            }
            case 516: {
                this.collectAllCommandsGuardedByOneCondition_SSPDLLP_255(objectArrayList, n);
                break;
            }
            case 517: {
                this.collectAllCommandsGuardedByOneCondition_SSPDLLP_256(objectArrayList, n);
                break;
            }
            case 518: {
                this.collectAllCommandsGuardedByOneCondition_SSPDLLP_257(objectArrayList, n);
                break;
            }
            case 519: {
                this.collectAllCommandsGuardedByOneCondition_SSPDLLP_258(objectArrayList, n);
                break;
            }
            case 520: {
                this.collectAllCommandsGuardedByOneCondition_SSPDLLP_259(objectArrayList, n);
                break;
            }
            case 523: {
                this.collectAllCommandsGuardedByOneCondition_SSPDMS_25C(objectArrayList, n);
                break;
            }
            case 527: {
                this.collectAllCommandsGuardedByOneCondition_SSPDMM_260(objectArrayList, n);
                break;
            }
            case 528: {
                this.collectAllCommandsGuardedByOneCondition_SSPDMN_261(objectArrayList, n);
                break;
            }
            case 531: {
                this.collectAllCommandsGuardedByOneCondition_SSPDNN_264(objectArrayList, n);
                break;
            }
            case 532: {
                this.collectAllCommandsGuardedByOneCondition_SSPDNN_265(objectArrayList, n);
                break;
            }
            case 536: {
                this.collectAllCommandsGuardedByOneCondition_SSPDPNR_269(objectArrayList, n);
                break;
            }
            case 537: {
                this.collectAllCommandsGuardedByOneCondition_SSPDRC_26A(objectArrayList, n);
                break;
            }
            case 541: {
                this.collectAllCommandsGuardedByOneCondition_SSPDSM_26E(objectArrayList, n);
                break;
            }
            case 543: {
                this.collectAllCommandsGuardedByOneCondition_SSPGGC_270(objectArrayList, n);
                break;
            }
            case 544: {
                this.collectAllCommandsGuardedByOneCondition_SSPGHC_271(objectArrayList, n);
                break;
            }
            case 546: {
                this.collectAllCommandsGuardedByOneCondition_SSPNDHCS_273(objectArrayList, n);
                break;
            }
            case 548: {
                this.collectAllCommandsGuardedByOneCondition_SSPNDHCS_275(objectArrayList, n);
                break;
            }
            case 550: {
                this.collectAllCommandsGuardedByOneCondition_SSPNDHMS_277(objectArrayList, n);
                break;
            }
            case 552: {
                this.collectAllCommandsGuardedByOneCondition_SSPNDHNS_279(objectArrayList, n);
                break;
            }
            case 554: {
                this.collectAllCommandsGuardedByOneCondition_SSPNDHRSS_27B(objectArrayList, n);
                break;
            }
            default: {
                super.collectAllCommandsGuardedByOneCondition(objectArrayList, n);
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDCDC_1F7(ObjectArrayList objectArrayList, int n) {
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
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDCDN_1F8(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDCEC_1FA(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSPDCEE_1FB(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSPDCL_1FC(ObjectArrayList objectArrayList, int n) {
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
                objectArrayList.add(this.createSingleCommand(3));
                break;
            }
            case 13: {
                objectArrayList.add(this.createSingleCommand(2));
                break;
            }
            case 14: {
                objectArrayList.add(this.createSingleCommand(1));
                break;
            }
            case 15: {
                objectArrayList.add(this.createSingleCommand(0));
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDCLEA_1FD(ObjectArrayList objectArrayList, int n) {
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
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDCLED_1FE(ObjectArrayList objectArrayList, int n) {
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
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDCLEM_1FF(ObjectArrayList objectArrayList, int n) {
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
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDCLEM_200(ObjectArrayList objectArrayList, int n) {
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
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDCLUN_201(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDCNE_203(ObjectArrayList objectArrayList, int n) {
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
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDCNGO_204(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDDC_205(ObjectArrayList objectArrayList, int n) {
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
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDDCA_206(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSPDDCALTNM_207(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSPDDCCIM_20A(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSPDDCCINM_20B(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSPDDCCINS_20C(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSPDDCD_20D(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSPDDCDLTNS_20F(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDDCDLTS_210(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSPDDCD_211(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDDCDC_212(ObjectArrayList objectArrayList, int n) {
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
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDDCDLTI_213(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSPDDCDLT_214(ObjectArrayList objectArrayList, int n) {
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
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDDCDN_215(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDDCN_21C(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSPDDCNE_21D(ObjectArrayList objectArrayList, int n) {
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
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDDCNGO_21E(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDDCNPN_222(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDDCSLTM_224(ObjectArrayList objectArrayList, int n) {
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
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDDCSLTNM_225(ObjectArrayList objectArrayList, int n) {
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
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDDCSLTNS_226(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDDCWBDLTI_227(ObjectArrayList objectArrayList, int n) {
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
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDDCWBDLT_228(ObjectArrayList objectArrayList, int n) {
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
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDDI_229(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDDM_22A(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDDN_22B(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                objectArrayList.add(this.createSingleCommand(0));
                break;
            }
            case 1: {
                objectArrayList.add(this.createSingleCommand(1));
                break;
            }
            case 2: {
                objectArrayList.add(this.createSingleCommand(2));
                break;
            }
            case 3: {
                objectArrayList.add(this.createSingleCommand(3));
                break;
            }
            case 4: {
                break;
            }
            case 5: {
                objectArrayList.add(this.createSingleCommand(4));
                objectArrayList.add(this.createSingleCommand(5));
                objectArrayList.add(this.createSingleCommand(6));
                objectArrayList.add(this.createSingleCommand(8));
                objectArrayList.add(this.createSingleCommand(9));
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDDNCD_22C(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDDS_237(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDEC_238(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDHCS_23F(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSPDHCS_243(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSPDHMS_247(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSPDHNS_24B(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSPDHRSS_24F(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSPDLLP_253(ObjectArrayList objectArrayList, int n) {
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
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDLLP_254(ObjectArrayList objectArrayList, int n) {
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
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDLLP_255(ObjectArrayList objectArrayList, int n) {
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
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDLLP_256(ObjectArrayList objectArrayList, int n) {
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
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDLLP_257(ObjectArrayList objectArrayList, int n) {
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
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDLLP_258(ObjectArrayList objectArrayList, int n) {
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
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDLLP_259(ObjectArrayList objectArrayList, int n) {
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
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDMS_25C(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSPDMM_260(ObjectArrayList objectArrayList, int n) {
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
            case 15: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDMN_261(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDNN_264(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDNN_265(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPDPNR_269(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSPDRC_26A(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSPDSM_26E(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPGGC_270(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                objectArrayList.add(this.createSingleCommand(0));
                break;
            }
            case 1: {
                objectArrayList.add(this.createSingleCommand(1));
                break;
            }
            case 2: {
                objectArrayList.add(this.createSingleCommand(2));
                objectArrayList.add(this.createSingleCommand(4));
                objectArrayList.add(this.createSingleCommand(5));
                objectArrayList.add(this.createSingleCommand(6));
                objectArrayList.add(this.createSingleCommand(7));
                objectArrayList.add(this.createSingleCommand(8));
                objectArrayList.add(this.createSingleCommand(12));
                objectArrayList.add(this.createSingleCommand(16));
                break;
            }
            case 3: {
                objectArrayList.add(this.createSingleCommand(15));
                break;
            }
            case 4: {
                objectArrayList.add(this.createSingleCommand(9));
                objectArrayList.add(this.createSingleCommand(10));
                break;
            }
            case 5: {
                objectArrayList.add(this.createSingleCommand(11));
                break;
            }
            case 6: {
                objectArrayList.add(this.createSingleCommand(3));
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPGHC_271(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                objectArrayList.add(this.createSingleCommand(3));
                objectArrayList.add(this.createSingleCommand(4));
                objectArrayList.add(this.createSingleCommand(5));
                objectArrayList.add(this.createSingleCommand(6));
                objectArrayList.add(this.createSingleCommand(7));
                objectArrayList.add(this.createSingleCommand(11));
                objectArrayList.add(this.createSingleCommand(15));
                objectArrayList.add(this.createSingleCommand(16));
                objectArrayList.add(this.createSingleCommand(17));
                objectArrayList.add(this.createSingleCommand(20));
                objectArrayList.add(this.createSingleCommand(22));
                objectArrayList.add(this.createSingleCommand(24));
                break;
            }
            case 1: {
                objectArrayList.add(this.createSingleCommand(8));
                objectArrayList.add(this.createSingleCommand(9));
                break;
            }
            case 2: {
                objectArrayList.add(this.createSingleCommand(10));
                break;
            }
            case 3: {
                objectArrayList.add(this.createSingleCommand(0));
                objectArrayList.add(this.createSingleCommand(18));
                break;
            }
            case 4: {
                objectArrayList.add(this.createSingleCommand(1));
                objectArrayList.add(this.createSingleCommand(19));
                break;
            }
            case 5: {
                objectArrayList.add(this.createSingleCommand(2));
                objectArrayList.add(this.createSingleCommand(21));
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSPNDHCS_273(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSPNDHCS_275(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSPNDHMS_277(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSPNDHNS_279(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSPNDHRSS_27B(ObjectArrayList objectArrayList, int n) {
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
            case 422: {
                return this.getAffectedFeatures_SSPDCDC_1F7(n);
            }
            case 423: {
                return this.getAffectedFeatures_SSPDCDN_1F8(n);
            }
            case 425: {
                return this.getAffectedFeatures_SSPDCEC_1FA(n);
            }
            case 426: {
                return this.getAffectedFeatures_SSPDCEE_1FB(n);
            }
            case 427: {
                return this.getAffectedFeatures_SSPDCL_1FC(n);
            }
            case 428: {
                return this.getAffectedFeatures_SSPDCLEA_1FD(n);
            }
            case 429: {
                return this.getAffectedFeatures_SSPDCLED_1FE(n);
            }
            case 430: {
                return this.getAffectedFeatures_SSPDCLEM_1FF(n);
            }
            case 431: {
                return this.getAffectedFeatures_SSPDCLEM_200(n);
            }
            case 432: {
                return this.getAffectedFeatures_SSPDCLUN_201(n);
            }
            case 434: {
                return this.getAffectedFeatures_SSPDCNE_203(n);
            }
            case 435: {
                return this.getAffectedFeatures_SSPDCNGO_204(n);
            }
            case 436: {
                return this.getAffectedFeatures_SSPDDC_205(n);
            }
            case 437: {
                return this.getAffectedFeatures_SSPDDCA_206(n);
            }
            case 438: {
                return this.getAffectedFeatures_SSPDDCALTNM_207(n);
            }
            case 441: {
                return this.getAffectedFeatures_SSPDDCCIM_20A(n);
            }
            case 442: {
                return this.getAffectedFeatures_SSPDDCCINM_20B(n);
            }
            case 443: {
                return this.getAffectedFeatures_SSPDDCCINS_20C(n);
            }
            case 444: {
                return this.getAffectedFeatures_SSPDDCD_20D(n);
            }
            case 446: {
                return this.getAffectedFeatures_SSPDDCDLTNS_20F(n);
            }
            case 447: {
                return this.getAffectedFeatures_SSPDDCDLTS_210(n);
            }
            case 448: {
                return this.getAffectedFeatures_SSPDDCD_211(n);
            }
            case 449: {
                return this.getAffectedFeatures_SSPDDCDC_212(n);
            }
            case 450: {
                return this.getAffectedFeatures_SSPDDCDLTI_213(n);
            }
            case 451: {
                return this.getAffectedFeatures_SSPDDCDLT_214(n);
            }
            case 452: {
                return this.getAffectedFeatures_SSPDDCDN_215(n);
            }
            case 459: {
                return this.getAffectedFeatures_SSPDDCN_21C(n);
            }
            case 460: {
                return this.getAffectedFeatures_SSPDDCNE_21D(n);
            }
            case 461: {
                return this.getAffectedFeatures_SSPDDCNGO_21E(n);
            }
            case 465: {
                return this.getAffectedFeatures_SSPDDCNPN_222(n);
            }
            case 467: {
                return this.getAffectedFeatures_SSPDDCSLTM_224(n);
            }
            case 468: {
                return this.getAffectedFeatures_SSPDDCSLTNM_225(n);
            }
            case 469: {
                return this.getAffectedFeatures_SSPDDCSLTNS_226(n);
            }
            case 470: {
                return this.getAffectedFeatures_SSPDDCWBDLTI_227(n);
            }
            case 471: {
                return this.getAffectedFeatures_SSPDDCWBDLT_228(n);
            }
            case 472: {
                return this.getAffectedFeatures_SSPDDI_229(n);
            }
            case 473: {
                return this.getAffectedFeatures_SSPDDM_22A(n);
            }
            case 474: {
                return this.getAffectedFeatures_SSPDDN_22B(n);
            }
            case 475: {
                return this.getAffectedFeatures_SSPDDNCD_22C(n);
            }
            case 486: {
                return this.getAffectedFeatures_SSPDDS_237(n);
            }
            case 487: {
                return this.getAffectedFeatures_SSPDEC_238(n);
            }
            case 494: {
                return this.getAffectedFeatures_SSPDHCS_23F(n);
            }
            case 498: {
                return this.getAffectedFeatures_SSPDHCS_243(n);
            }
            case 502: {
                return this.getAffectedFeatures_SSPDHMS_247(n);
            }
            case 506: {
                return this.getAffectedFeatures_SSPDHNS_24B(n);
            }
            case 510: {
                return this.getAffectedFeatures_SSPDHRSS_24F(n);
            }
            case 514: {
                return this.getAffectedFeatures_SSPDLLP_253(n);
            }
            case 515: {
                return this.getAffectedFeatures_SSPDLLP_254(n);
            }
            case 516: {
                return this.getAffectedFeatures_SSPDLLP_255(n);
            }
            case 517: {
                return this.getAffectedFeatures_SSPDLLP_256(n);
            }
            case 518: {
                return this.getAffectedFeatures_SSPDLLP_257(n);
            }
            case 519: {
                return this.getAffectedFeatures_SSPDLLP_258(n);
            }
            case 520: {
                return this.getAffectedFeatures_SSPDLLP_259(n);
            }
            case 523: {
                return this.getAffectedFeatures_SSPDMS_25C(n);
            }
            case 527: {
                return this.getAffectedFeatures_SSPDMM_260(n);
            }
            case 528: {
                return this.getAffectedFeatures_SSPDMN_261(n);
            }
            case 531: {
                return this.getAffectedFeatures_SSPDNN_264(n);
            }
            case 532: {
                return this.getAffectedFeatures_SSPDNN_265(n);
            }
            case 536: {
                return this.getAffectedFeatures_SSPDPNR_269(n);
            }
            case 537: {
                return this.getAffectedFeatures_SSPDRC_26A(n);
            }
            case 541: {
                return this.getAffectedFeatures_SSPDSM_26E(n);
            }
            case 543: {
                return this.getAffectedFeatures_SSPGGC_270(n);
            }
            case 544: {
                return this.getAffectedFeatures_SSPGHC_271(n);
            }
            case 546: {
                return this.getAffectedFeatures_SSPNDHCS_273(n);
            }
            case 548: {
                return this.getAffectedFeatures_SSPNDHCS_275(n);
            }
            case 550: {
                return this.getAffectedFeatures_SSPNDHMS_277(n);
            }
            case 552: {
                return this.getAffectedFeatures_SSPNDHNS_279(n);
            }
            case 554: {
                return this.getAffectedFeatures_SSPNDHRSS_27B(n);
            }
        }
        return super.getAffectedFeatures(n);
    }

    private int[] getAffectedFeatures_SSPDCDC_1F7(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDCDN_1F8(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDCEC_1FA(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDCEE_1FB(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDCL_1FC(int n) {
        switch (n) {
            case 0: {
                return SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 2: {
                return SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
            case 4: {
                return SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_4;
            }
            case 5: {
                return SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_5;
            }
            case 6: {
                return SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_6;
            }
            case 7: {
                return SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_7;
            }
            case 8: {
                return SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_8;
            }
            case 9: {
                return SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_9;
            }
            case 10: {
                return SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_10;
            }
            case 11: {
                return SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_11;
            }
            case 12: {
                return SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_12;
            }
            case 13: {
                return SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_13;
            }
            case 14: {
                return SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_14;
            }
            case 15: {
                return SSPDCL_1FC_AFFECTED_FEATURES_FOR_CONDITION_15;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDCLEA_1FD(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDCLED_1FE(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDCLEM_1FF(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDCLEM_200(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDCLUN_201(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDCNE_203(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDCNGO_204(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDDC_205(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDDCA_206(int n) {
        switch (n) {
            case 0: {
                return SSPDDCA_206_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSPDDCA_206_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDDCALTNM_207(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDDCCIM_20A(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDDCCINM_20B(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDDCCINS_20C(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDDCD_20D(int n) {
        switch (n) {
            case 0: {
                return SSPDDCD_20D_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSPDDCD_20D_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDDCDLTNS_20F(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDDCDLTS_210(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDDCD_211(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDDCDC_212(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDDCDLTI_213(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDDCDLT_214(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDDCDN_215(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDDCN_21C(int n) {
        switch (n) {
            case 0: {
                return SSPDDCN_21C_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSPDDCN_21C_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDDCNE_21D(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDDCNGO_21E(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDDCNPN_222(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDDCSLTM_224(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDDCSLTNM_225(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDDCSLTNS_226(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDDCWBDLTI_227(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDDCWBDLT_228(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDDI_229(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDDM_22A(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDDN_22B(int n) {
        switch (n) {
            case 0: {
                return SSPDDN_22B_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSPDDN_22B_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 2: {
                return SSPDDN_22B_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSPDDN_22B_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
            case 4: {
                return SSPDDN_22B_AFFECTED_FEATURES_FOR_CONDITION_4;
            }
            case 5: {
                return SSPDDN_22B_AFFECTED_FEATURES_FOR_CONDITION_5;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDDNCD_22C(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDDS_237(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDEC_238(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDHCS_23F(int n) {
        switch (n) {
            case 0: {
                return SSPDHCS_23F_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSPDHCS_23F_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDHCS_243(int n) {
        switch (n) {
            case 0: {
                return SSPDHCS_243_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSPDHCS_243_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDHMS_247(int n) {
        switch (n) {
            case 0: {
                return SSPDHMS_247_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSPDHMS_247_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDHNS_24B(int n) {
        switch (n) {
            case 0: {
                return SSPDHNS_24B_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSPDHNS_24B_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDHRSS_24F(int n) {
        switch (n) {
            case 0: {
                return SSPDHRSS_24F_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSPDHRSS_24F_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDLLP_253(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDLLP_254(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDLLP_255(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDLLP_256(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDLLP_257(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDLLP_258(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDLLP_259(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDMS_25C(int n) {
        switch (n) {
            case 0: {
                return SSPDMS_25C_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSPDMS_25C_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDMM_260(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDMN_261(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDNN_264(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDNN_265(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDPNR_269(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDRC_26A(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPDSM_26E(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPGGC_270(int n) {
        switch (n) {
            case 0: {
                return SSPGGC_270_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSPGGC_270_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 2: {
                return SSPGGC_270_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSPGGC_270_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
            case 4: {
                return SSPGGC_270_AFFECTED_FEATURES_FOR_CONDITION_4;
            }
            case 5: {
                return SSPGGC_270_AFFECTED_FEATURES_FOR_CONDITION_5;
            }
            case 6: {
                return SSPGGC_270_AFFECTED_FEATURES_FOR_CONDITION_6;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPGHC_271(int n) {
        switch (n) {
            case 0: {
                return SSPGHC_271_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSPGHC_271_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 2: {
                return SSPGHC_271_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSPGHC_271_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
            case 4: {
                return SSPGHC_271_AFFECTED_FEATURES_FOR_CONDITION_4;
            }
            case 5: {
                return SSPGHC_271_AFFECTED_FEATURES_FOR_CONDITION_5;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPNDHCS_273(int n) {
        switch (n) {
            case 0: {
                return SSPNDHCS_273_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSPNDHCS_273_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPNDHCS_275(int n) {
        switch (n) {
            case 0: {
                return SSPNDHCS_275_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSPNDHCS_275_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPNDHMS_277(int n) {
        switch (n) {
            case 0: {
                return SSPNDHMS_277_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSPNDHMS_277_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPNDHNS_279(int n) {
        switch (n) {
            case 0: {
                return SSPNDHNS_279_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSPNDHNS_279_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSPNDHRSS_27B(int n) {
        switch (n) {
            case 0: {
                return SSPNDHRSS_27B_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSPNDHRSS_27B_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    @Override
    protected int[] getConditionsAffectedByProperty(int n) {
        switch (this.sdFeatColId) {
            case 427: {
                return this.getConditionsAffectedByProperty_SSPDCL_1FC(n);
            }
            case 437: {
                return this.getConditionsAffectedByProperty_SSPDDCA_206(n);
            }
            case 444: {
                return this.getConditionsAffectedByProperty_SSPDDCD_20D(n);
            }
            case 459: {
                return this.getConditionsAffectedByProperty_SSPDDCN_21C(n);
            }
            case 474: {
                return this.getConditionsAffectedByProperty_SSPDDN_22B(n);
            }
            case 480: {
                return this.getConditionsAffectedByProperty_SSPDDNNNE_231(n);
            }
            case 494: {
                return this.getConditionsAffectedByProperty_SSPDHCS_23F(n);
            }
            case 498: {
                return this.getConditionsAffectedByProperty_SSPDHCS_243(n);
            }
            case 502: {
                return this.getConditionsAffectedByProperty_SSPDHMS_247(n);
            }
            case 506: {
                return this.getConditionsAffectedByProperty_SSPDHNS_24B(n);
            }
            case 510: {
                return this.getConditionsAffectedByProperty_SSPDHRSS_24F(n);
            }
            case 523: {
                return this.getConditionsAffectedByProperty_SSPDMS_25C(n);
            }
            case 527: {
                return this.getConditionsAffectedByProperty_SSPDMM_260(n);
            }
            case 543: {
                return this.getConditionsAffectedByProperty_SSPGGC_270(n);
            }
            case 544: {
                return this.getConditionsAffectedByProperty_SSPGHC_271(n);
            }
            case 546: {
                return this.getConditionsAffectedByProperty_SSPNDHCS_273(n);
            }
            case 548: {
                return this.getConditionsAffectedByProperty_SSPNDHCS_275(n);
            }
            case 550: {
                return this.getConditionsAffectedByProperty_SSPNDHMS_277(n);
            }
            case 552: {
                return this.getConditionsAffectedByProperty_SSPNDHNS_279(n);
            }
            case 554: {
                return this.getConditionsAffectedByProperty_SSPNDHRSS_27B(n);
            }
        }
        return super.getConditionsAffectedByProperty(n);
    }

    private int[] getConditionsAffectedByProperty_SSPDCL_1FC(int n) {
        switch (n) {
            case 35279: {
                return SSPDCL_1FC_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_DATA_CALLSTACK_LIST_GET_CALLSTACK_TYPE;
            }
            case 67109: {
                return SSPDCL_1FC_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_DATA_CALLSTACK_LIST_GET_CALLSTACK_VIEW_TYPE;
            }
            case 42418: {
                return SSPDCL_1FC_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_DATA_CONTACT_CALLSTACK_LIST_GET_FIRST_FOUND_CONTACT_NAME_OR_NUMBER;
            }
            case 27410: {
                return SSPDCL_1FC_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_DATA_CONTACT_CALLSTACK_LIST_IS_CALLSTACK_LIST_CONTAINING_KNOWN_NUMBERS;
            }
            case 59725: {
                return SSPDCL_1FC_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_STATUS_GET_CONTACT_SPEAKABILITY;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSPDDCA_206(int n) {
        switch (n) {
            case 63448: {
                return SSPDDCA_206_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_DATA_CONTACT_NUMBER_LIST_IS_CONTACT_SELECTED_ITEM_NOT_ONLY_OTHER;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSPDDCD_20D(int n) {
        switch (n) {
            case 63448: {
                return SSPDDCD_20D_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_DATA_CONTACT_NUMBER_LIST_IS_CONTACT_SELECTED_ITEM_NOT_ONLY_OTHER;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSPDDCN_21C(int n) {
        switch (n) {
            case 59725: {
                return SSPDDCN_21C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_STATUS_GET_CONTACT_SPEAKABILITY;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSPDDN_22B(int n) {
        switch (n) {
            case 10059: {
                return SSPDDN_22B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSPDDN_22B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
            case 16367: {
                return SSPDDN_22B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_DIAL_NUMBER_GET_LAST_NUMBER_BLOCK;
            }
            case 46308: {
                return SSPDDN_22B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_DIAL_NUMBER_IS_NUMBER_NOT_EMPTY;
            }
            case 20065: {
                return SSPDDN_22B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_STATUS_IS_EMERGENCY_NUMBER_CODED;
            }
            case 67795: {
                return SSPDDN_22B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_STATUS_IS_INFORMATION_NUMBER_CODED;
            }
            case 66683: {
                return SSPDDN_22B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_STATUS_IS_SERVICE_NUMBER_CODED;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSPDDNNNE_231(int n) {
        switch (n) {
            case 16367: {
                return SSPDDNNNE_231_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_DIAL_NUMBER_GET_LAST_NUMBER_BLOCK;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSPDHCS_23F(int n) {
        switch (n) {
            case 13507: {
                return SSPDHCS_23F_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_PHONE_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSPDHCS_243(int n) {
        switch (n) {
            case 13507: {
                return SSPDHCS_243_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_PHONE_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSPDHMS_247(int n) {
        switch (n) {
            case 13507: {
                return SSPDHMS_247_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_PHONE_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSPDHNS_24B(int n) {
        switch (n) {
            case 13507: {
                return SSPDHNS_24B_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_PHONE_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSPDHRSS_24F(int n) {
        switch (n) {
            case 13507: {
                return SSPDHRSS_24F_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_PHONE_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSPDMS_25C(int n) {
        switch (n) {
            case 13507: {
                return SSPDMS_25C_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_PHONE_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSPDMM_260(int n) {
        switch (n) {
            case 71271: {
                return SSPDMM_260_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_MESSAGES_GET_INDEX_OF_MESSAGE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSPGGC_270(int n) {
        switch (n) {
            case 10059: {
                return SSPGGC_270_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSPGGC_270_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
            case 17635: {
                return SSPGGC_270_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_STATUS_GET_USE_CONTACT_GARBAGE_COMMAND;
            }
            case 20065: {
                return SSPGGC_270_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_STATUS_IS_EMERGENCY_NUMBER_CODED;
            }
            case 67795: {
                return SSPGGC_270_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_STATUS_IS_INFORMATION_NUMBER_CODED;
            }
            case 66683: {
                return SSPGGC_270_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_STATUS_IS_SERVICE_NUMBER_CODED;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSPGHC_271(int n) {
        switch (n) {
            case 10059: {
                return SSPGHC_271_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSPGHC_271_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
            case 17635: {
                return SSPGHC_271_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_STATUS_GET_USE_CONTACT_GARBAGE_COMMAND;
            }
            case 20065: {
                return SSPGHC_271_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_STATUS_IS_EMERGENCY_NUMBER_CODED;
            }
            case 67795: {
                return SSPGHC_271_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_STATUS_IS_INFORMATION_NUMBER_CODED;
            }
            case 66683: {
                return SSPGHC_271_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_PHONE_STATUS_IS_SERVICE_NUMBER_CODED;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSPNDHCS_273(int n) {
        switch (n) {
            case 13507: {
                return SSPNDHCS_273_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_PHONE_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSPNDHCS_275(int n) {
        switch (n) {
            case 13507: {
                return SSPNDHCS_275_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_PHONE_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSPNDHMS_277(int n) {
        switch (n) {
            case 13507: {
                return SSPNDHMS_277_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_PHONE_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSPNDHNS_279(int n) {
        switch (n) {
            case 13507: {
                return SSPNDHNS_279_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_PHONE_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSPNDHRSS_27B(int n) {
        switch (n) {
            case 13507: {
                return SSPNDHRSS_27B_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_PHONE_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    @Override
    protected int[] getConditionsAffectedByList(int n) {
        switch (this.sdFeatColId) {
            case 427: {
                return this.getConditionsAffectedByList_SSPDCL_1FC(n);
            }
        }
        return super.getConditionsAffectedByList(n);
    }

    private int[] getConditionsAffectedByList_SSPDCL_1FC(int n) {
        switch (n) {
            case 3910041: {
                return SSPDCL_1FC_AFFECTED_CONDITIONS_FOR_LIST_SPEECHPHONE_DATA_CONTACT_ACCEPTED_CALLS_LIST;
            }
            case 3910027: {
                return SSPDCL_1FC_AFFECTED_CONDITIONS_FOR_LIST_SPEECHPHONE_DATA_CONTACT_CALLSTACK_DETAIL_LIST;
            }
            case 3910040: {
                return SSPDCL_1FC_AFFECTED_CONDITIONS_FOR_LIST_SPEECHPHONE_DATA_CONTACT_DIALED_NUMBERS_LIST;
            }
            case 3910039: {
                return SSPDCL_1FC_AFFECTED_CONDITIONS_FOR_LIST_SPEECHPHONE_DATA_CONTACT_MISSED_CALLS_LIST;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal list Id: ").append(n).toString());
    }

    @Override
    protected void updateAffectedFeature(int n) {
        switch (this.sdFeatColId) {
            case 427: {
                this.updateAffectedFeature_SSPDCL_1FC(n);
                break;
            }
            case 474: {
                this.updateAffectedFeature_SSPDDN_22B(n);
                break;
            }
            case 480: {
                this.updateAffectedFeature_SSPDDNNNE_231(n);
                break;
            }
            case 527: {
                this.updateAffectedFeature_SSPDMM_260(n);
                break;
            }
            default: {
                super.updateAffectedFeature(n);
            }
        }
    }

    private void updateAffectedFeature_SSPDCL_1FC(int n) {
        switch (n) {
            case 35279: {
                break;
            }
            case 67109: {
                this.updateFeature(4);
                break;
            }
            case 42418: {
                this.updateFeature(4);
                break;
            }
            case 27410: {
                break;
            }
            case 59725: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
            }
        }
    }

    private void updateAffectedFeature_SSPDDN_22B(int n) {
        switch (n) {
            case 10059: {
                break;
            }
            case 40967: {
                break;
            }
            case 16367: {
                this.updateFeature(3);
                break;
            }
            case 46308: {
                break;
            }
            case 20065: {
                break;
            }
            case 67795: {
                break;
            }
            case 66683: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
            }
        }
    }

    private void updateAffectedFeature_SSPDDNNNE_231(int n) {
        switch (n) {
            case 16367: {
                this.updateFeature(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
            }
        }
    }

    private void updateAffectedFeature_SSPDMM_260(int n) {
        switch (n) {
            case 71271: {
                this.updateFeature(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
            }
        }
    }
}

