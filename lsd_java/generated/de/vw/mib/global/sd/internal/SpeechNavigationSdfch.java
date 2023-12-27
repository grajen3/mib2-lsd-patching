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

public final class SpeechNavigationSdfch
extends SdFeatureCollectionHandlerBase {
    private static int[] SSNCECNL_82_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{3};
    private static int[] SSNCECNL_82_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{3};
    private static int[] SSNCECNL_82_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_NAVIGATION_CONTROLLER_CONTACTS_GET_COMPILATION_RESULT = new int[]{0, 1};
    private static int[] SSNCEDDB_83_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{2};
    private static int[] SSNCEDDB_83_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{2};
    private static int[] SSNCEDDB_83_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_NAVIGATION_CONTROLLER_GENERIC_GET_SELECTED_LINE_TEXT = new int[0];
    private static int[] SSNCEDDB_83_AFFECTED_CONDITIONS_FOR_LIST_SPEECHNAVIGATION_CONTROLLER_CONTACTS_SELECTED_CONTACT = new int[]{0, 1};
    private static int[] SSNDGNLC_113_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSNDGNLC_113_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_DESTINATION_INPUT_NBEST_EM = new int[]{0};
    private static int[] SSNDGNLC_114_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSNDGNLC_114_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_DESTINATION_INPUT_NBEST_EM = new int[]{0};
    private static int[] SSNDGNLC_116_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSNDGNLC_116_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_DESTINATION_INPUT_NBEST_EM = new int[]{0};
    private static int[] SSNDGNLC_117_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSNDGNLC_117_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_DESTINATION_INPUT_NBEST_EM = new int[]{0};
    private static int[] SSNDGNLC_118_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSNDGNLC_118_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_DESTINATION_INPUT_NBEST_EM = new int[]{0};
    private static int[] SSNDGC_119_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSNDGC_119_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSNDGC_119_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{0};
    private static int[] SSNDGC_119_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{0};
    private static int[] SSNDGC_119_AFFECTED_FEATURES_FOR_CONDITION_4 = new int[]{0};
    private static int[] SSNDGC_119_AFFECTED_FEATURES_FOR_CONDITION_5 = new int[]{0};
    private static int[] SSNDGC_119_AFFECTED_FEATURES_FOR_CONDITION_6 = new int[]{0};
    private static int[] SSNDGC_119_AFFECTED_FEATURES_FOR_CONDITION_7 = new int[]{0};
    private static int[] SSNDGC_119_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_ONLINE_SERVICE = new int[]{6};
    private static int[] SSNDGC_119_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    private static int[] SSNDGC_119_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    private static int[] SSNDGC_119_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_NAVIGATION_CONTROLLER_CONTACTS_GET_COMPILATION_RESULT = new int[]{0, 1, 3};
    private static int[] SSNDGC_119_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_NAVIGATION_CONTROLLER_SINGLE_USER_INTERFACE_IS_SINGLE_USER_INTERFACE_SUPPORTED = new int[]{2, 3, 4, 5};
    private static int[] SSNDHC_11C_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSNDHC_11C_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSNDHC_11C_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{0};
    private static int[] SSNDHC_11C_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{0};
    private static int[] SSNDHC_11C_AFFECTED_FEATURES_FOR_CONDITION_4 = new int[]{0};
    private static int[] SSNDHC_11C_AFFECTED_FEATURES_FOR_CONDITION_5 = new int[]{0};
    private static int[] SSNDHC_11C_AFFECTED_FEATURES_FOR_CONDITION_6 = new int[]{0};
    private static int[] SSNDHC_11C_AFFECTED_FEATURES_FOR_CONDITION_7 = new int[]{0};
    private static int[] SSNDHC_11C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_ONLINE_SERVICE = new int[]{5};
    private static int[] SSNDHC_11C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    private static int[] SSNDHC_11C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    private static int[] SSNDHC_11C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_NAVIGATION_CONTROLLER_CONTACTS_GET_COMPILATION_RESULT = new int[]{0, 1, 2};
    private static int[] SSNDHC_11C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_NAVIGATION_CONTROLLER_SINGLE_USER_INTERFACE_IS_SINGLE_USER_INTERFACE_SUPPORTED = new int[]{2, 3, 4, 7};
    private static int[] SSNGM_131_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{3};
    private static int[] SSNGM_131_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{3};
    private static int[] SSNGM_131_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{3};
    private static int[] SSNGM_131_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{3, 4};
    private static int[] SSNGM_131_AFFECTED_FEATURES_FOR_CONDITION_4 = new int[]{3, 4};
    private static int[] SSNGM_131_AFFECTED_FEATURES_FOR_CONDITION_7 = new int[]{4};
    private static int[] SSNGM_131_AFFECTED_FEATURES_FOR_CONDITION_8 = new int[]{4};
    private static int[] SSNGM_131_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{0, 1, 2, 3, 4};
    private static int[] SSNGM_131_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{0, 1, 2, 3, 4};
    private static int[] SSNGM_131_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_HELPMODE_IS_ACTIVATED = new int[]{7, 8};
    private static int[] SSNGMA_132_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{4};
    private static int[] SSNGMA_132_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{4};
    private static int[] SSNGMA_132_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_HELPMODE_IS_ACTIVATED = new int[]{2, 3};
    private static int[] SSNGMH_135_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{4};
    private static int[] SSNGMH_135_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{4};
    private static int[] SSNGMH_135_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_HELPMODE_IS_ACTIVATED = new int[]{2, 3};
    private static int[] SSNGMLD_136_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{4};
    private static int[] SSNGMLD_136_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{4};
    private static int[] SSNGMLD_136_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_HELPMODE_IS_ACTIVATED = new int[]{2, 3};
    private static int[] SSNGMNC_137_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{4};
    private static int[] SSNGMNC_137_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{4};
    private static int[] SSNGMNC_137_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_HELPMODE_IS_ACTIVATED = new int[]{2, 3};
    private static int[] SSNGMOPS_139_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{4};
    private static int[] SSNGMOPS_139_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{4};
    private static int[] SSNGMOPS_139_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_HELPMODE_IS_ACTIVATED = new int[]{2, 3};
    private static int[] SSNGMPS_13A_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{4};
    private static int[] SSNGMPS_13A_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{4};
    private static int[] SSNGMPS_13A_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_HELPMODE_IS_ACTIVATED = new int[]{2, 3};
    private static int[] SSNGMR_13B_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{4};
    private static int[] SSNGMR_13B_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{4};
    private static int[] SSNGMR_13B_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_HELPMODE_IS_ACTIVATED = new int[]{2, 3};
    private static int[] SSNGNMA_13F_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{4};
    private static int[] SSNGNMA_13F_AFFECTED_FEATURES_FOR_CONDITION_4 = new int[]{4};
    private static int[] SSNGNMA_13F_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_HELPMODE_IS_ACTIVATED = new int[]{3, 4};
    private static int[] SSNGNMH_140_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{4};
    private static int[] SSNGNMH_140_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{4};
    private static int[] SSNGNMH_140_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_HELPMODE_IS_ACTIVATED = new int[]{2, 3};
    private static int[] SSNGNMLD_141_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{4};
    private static int[] SSNGNMLD_141_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{4};
    private static int[] SSNGNMLD_141_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_HELPMODE_IS_ACTIVATED = new int[]{2, 3};
    private static int[] SSNGNMNC_142_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{4};
    private static int[] SSNGNMNC_142_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{4};
    private static int[] SSNGNMNC_142_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_HELPMODE_IS_ACTIVATED = new int[]{2, 3};
    private static int[] SSNGNMOPS_143_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{4};
    private static int[] SSNGNMOPS_143_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{4};
    private static int[] SSNGNMOPS_143_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_HELPMODE_IS_ACTIVATED = new int[]{2, 3};
    private static int[] SSNGNMPS_144_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{4};
    private static int[] SSNGNMPS_144_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{4};
    private static int[] SSNGNMPS_144_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_HELPMODE_IS_ACTIVATED = new int[]{2, 3};
    private static int[] SSNGNMR_145_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{4};
    private static int[] SSNGNMR_145_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{4};
    private static int[] SSNGNMR_145_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_HELPMODE_IS_ACTIVATED = new int[]{2, 3};
    private static int[] SSNNDMCSN_164_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{3};
    private static int[] SSNNDMCSN_164_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{3};
    private static int[] SSNNDMCSN_164_AFFECTED_CONDITIONS_FOR_LIST_SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_COUNTRYSTATE_COUNTRY_STATE_RESULTS = new int[]{0, 1};
    private static int[] SSNNDMH_16D_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{4};
    private static int[] SSNNDMH_16D_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{4};
    private static int[] SSNNDMH_16D_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_NAVIGATION_CONTROLLER_DESTINATION_INPUT_CROSSING_IS_CROSSING_AVAILABLE = new int[]{1, 2};
    private static int[] SSNNDMHN_170_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{4};
    private static int[] SSNNDMHN_170_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{4};
    private static int[] SSNNDMHN_170_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{5};
    private static int[] SSNNDMHN_170_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{5};
    private static int[] SSNNDMHN_170_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_NAVIGATION_CONTROLLER_DESTINATION_INPUT_CROSSING_IS_CROSSING_AVAILABLE = new int[]{0, 1, 2, 3};
    private static int[] SSNNDMHPML_174_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{3};
    private static int[] SSNNDMHPML_174_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{3};
    private static int[] SSNNDMHPML_174_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{4};
    private static int[] SSNNDMHPML_174_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{4};
    private static int[] SSNNDMHPML_174_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_NAVIGATION_CONTROLLER_DESTINATION_INPUT_CROSSING_IS_CROSSING_AVAILABLE = new int[]{0, 1, 2, 3};
    private static int[] SSNNDMHPNLNCT_179_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{4};
    private static int[] SSNNDMHPNLNCT_179_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{4};
    private static int[] SSNNDMHPNLNCT_179_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{5};
    private static int[] SSNNDMHPNLNCT_179_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_NAVIGATION_CONTROLLER_DESTINATION_INPUT_CROSSING_IS_CROSSING_AVAILABLE = new int[]{0, 1, 3};
    private static int[] SSNNDMS_19A_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{4};
    private static int[] SSNNDMS_19A_AFFECTED_FEATURES_FOR_CONDITION_4 = new int[]{4};
    private static int[] SSNNDMS_19A_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_NEW_DEST_ENTRY_MODE = new int[]{1, 4};
    private static int[] SSNNDMS_19C_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{4};
    private static int[] SSNNDMS_19C_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{4};
    private static int[] SSNNDMS_19C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_NAVIGATION_CONTROLLER_DESTINATION_INPUT_GET_START_ENTRY_MODE = new int[]{1, 3};
    private static int[] SSNNDON_1B3_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_NAVIGATION_CONTROLLER_DESTINATION_INPUT_ONESHOT_GET_NBEST_HEADLINE_TEXT = new int[0];
    private static int[] SSNOPEDPLB_1BE_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0, 2, 3};
    private static int[] SSNOPEDPLB_1BE_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0, 2, 3};
    private static int[] SSNOPEDPLB_1BE_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_NAVIGATION_CONTROLLER_GUIDANCE_GET_GUIDANCE_STATUS = new int[]{0, 1};
    private static int[] SSNSUILNS_1F0_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSNSUILNS_1F0_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{0};
    private static int[] SSNSUILNS_1F0_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{0};
    private static int[] SSNSUIN_1F1_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{4};
    private static int[] SSNSUIN_1F1_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{4};
    private static int[] SSNSUIN_1F1_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{4};
    private static int[] SSNSUIN_1F1_AFFECTED_CONDITIONS_FOR_LIST_SPEECHNAVIGATION_CONTROLLER_SINGLEUSERINTERFACE_SUI_RESULT_LIST = new int[]{0, 1, 2};

    @Override
    public void init(int n, int n2) {
        this.sdFeatColId = n;
        this.speechClientId = n2;
        switch (n) {
            case 121: {
                this.conditions = new boolean[2];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 122: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 123: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 124: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(147, -1646185664, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(178, 1491153728, 3, false, false)};
                this.featureData = new int[]{1, 0, 1, 3};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 125: {
                this.featureData = new int[]{0, 0, 0};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 126: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{29133};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(149, -1629408448, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 127: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{28094};
                this.listItemControls = new ListItemControl[]{this.getListItemControl(1711813632, false)};
                this.listItemControlListeners = new AbstractSdFeatureCollectionHandler$SdFeatureCollectionListItemControlListener[]{new AbstractSdFeatureCollectionHandler$SdFeatureCollectionListItemControlListener(this, 1711813632)};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(147, -1646185664, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(171, 1340158784, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(172, 1356936000, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(173, 1323381568, 3, false, false)};
                this.featureData = new int[]{1, 0, 1, 3};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 128: {
                this.conditions = new boolean[2];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 129: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 130: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(148, -1662962880, 3, false, false)};
                this.featureData = new int[]{1, 0, 1, 3};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 131: {
                this.featureData = new int[]{0, 0, 0};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 132: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 133: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 134: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 135: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 136: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 137: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 138: {
                this.featureData = new int[]{3};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 139: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 140: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(186, 1306604352, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(189, 1289827136, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(191, 1256272704, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(193, 1273049920, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[6];
                break;
            }
            case 141: {
                this.conditions = new boolean[3];
                this.featureData = new int[]{0, 0, 0};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 142: {
                this.conditions = new boolean[3];
                this.featureData = new int[]{0, 0, 0};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 143: {
                this.commandFeatureIndex = 0;
                this.isInheritingCommands = false;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(187, 1373713216, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(188, 1340158784, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(190, 1356936000, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(192, 1323381568, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 144: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 145: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 146: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 147: {
                this.commandFeatureIndex = 0;
                this.isInheritingCommands = false;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(201, -2065616064, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(203, -2082393280, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(204, -2048838848, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(205, -2099170496, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[6];
                break;
            }
            case 148: {
                this.commandFeatureIndex = 0;
                this.isInheritingCommands = false;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(202, -2015284416, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(204, -2048838848, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(206, -2032061632, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 149: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 150: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 151: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 152: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 153: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(185, 1356936000, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(196, 1340158784, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(200, 1323381568, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 154: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(34, 2011247424, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(183, 2028024640, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(194, 1256272704, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(195, 2044801856, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(199, 2061579072, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 155: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 156: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(34, 2011247424, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(183, 2028024640, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(194, 1256272704, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(195, 2044801856, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(199, 2061579072, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 157: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 158: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 159: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 160: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 161: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 162: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 163: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 164: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 165: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 166: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 167: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 168: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 169: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 170: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 171: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 172: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 173: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 174: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 175: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 176: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 177: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 178: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 179: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 180: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 181: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 182: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 183: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 184: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 185: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 186: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 187: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 188: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 189: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 190: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 191: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 192: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 193: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 194: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 195: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 196: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 197: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 198: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 199: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 200: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 201: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 202: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 203: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 204: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 205: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 206: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 207: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 208: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 209: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 210: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 211: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 212: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 213: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 214: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 215: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 216: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 217: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 218: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 219: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 220: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 221: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 222: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 223: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 224: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 225: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 226: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 227: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 228: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 229: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 230: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 231: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 232: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 233: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 234: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 235: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 236: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 237: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 238: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 239: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 240: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 241: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 242: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 243: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 244: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 245: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 246: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 247: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 248: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 249: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 250: {
                this.conditions = new boolean[1];
                this.dpProperties = new int[]{-457834496};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(174, 1424044864, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(175, 1440822080, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(176, 1390490432, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(177, 1507930944, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(179, 1491153728, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(181, 1457599296, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(182, 1122054976, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(183, 1474376512, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 251: {
                this.conditions = new boolean[1];
                this.dpProperties = new int[]{-457834496};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(174, 1424044864, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(175, 1440822080, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(176, 1390490432, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(177, 1507930944, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(179, 1491153728, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(181, 1457599296, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(182, 1122054976, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(183, 1474376512, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 252: {
                this.conditions = new boolean[1];
                this.dpProperties = new int[]{-457834496};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(174, 1424044864, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(175, 1440822080, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(176, 1390490432, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(177, 1507930944, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(179, 1491153728, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(181, 1457599296, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(182, 1122054976, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(183, 1474376512, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 253: {
                this.conditions = new boolean[1];
                this.dpProperties = new int[]{-457834496};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(174, 1424044864, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(175, 1440822080, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(176, 1390490432, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(177, 1507930944, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(179, 1491153728, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(181, 1457599296, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(182, 1122054976, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(183, 1474376512, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 254: {
                this.conditions = new boolean[1];
                this.dpProperties = new int[]{-457834496};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(174, 1424044864, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(175, 1440822080, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(176, 1390490432, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(177, 1507930944, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(179, 1491153728, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(181, 1457599296, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(182, 1122054976, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(183, 1474376512, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 255: {
                this.conditions = new boolean[8];
                this.dpProperties = new int[]{19680, 10059, 0x7A00000, 29133, -626458624};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(13, -1981729984, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(37, -1176423616, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(39, -1142869184, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(40, -1109314752, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(54, -1159646400, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(150, -1679740096, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(151, -1662962880, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(152, -1662962880, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(153, -1428081856, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(154, 2095133504, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(158, 2078356288, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(161, -2132724928, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(163, -1428081856, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(164, 2145465152, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(167, 2128687936, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(169, 2111910720, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(185, 1239495488, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(194, 1994470208, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(210, 1893806912, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(219, 1222718272, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(223, 1138832192, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(268, -1595854016, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(269, -1562299584, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(272, -1327418560, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(273, -1293864128, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(280, 1927361344, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(281, 1960915776, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(282, 1944138560, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(283, 1977692992, 1, false, false)};
                this.featureData = new int[]{1, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 256: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 257: {
                this.conditions = new boolean[8];
                this.dpProperties = new int[]{19680, 10059, 0x7A00000, 29133, -626458624};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(13, 1793143616, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(37, 1877029696, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(39, 1809920832, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(40, 1809920832, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(54, 1826698048, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(150, 1809920832, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(151, 1809920832, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(152, 1809920832, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(153, 1877029696, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(154, 1877029696, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(158, 1877029696, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(161, 1877029696, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(163, 1877029696, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(164, 1877029696, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(167, 1877029696, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(169, 1877029696, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(185, 1860252480, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(194, 1860252480, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(207, 1776366400, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(208, 1793143616, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(209, 1809920832, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(210, 1893806912, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(211, 1843475264, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(212, 1826698048, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(213, 1860252480, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(214, 1860252480, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(215, 1877029696, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(219, 1776366400, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(223, 1893806912, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(268, 1826698048, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(269, 1826698048, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(272, 1843475264, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(273, 1843475264, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(280, 1860252480, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(281, 1860252480, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(282, 1860252480, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(283, 1860252480, 2, false, false)};
                this.featureData = new int[]{1};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 258: {
                this.featureData = new int[]{1, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 259: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(274, 1759589184, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(275, 1742811968, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 260: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 261: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 262: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(276, 1726034752, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(277, 1709257536, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 263: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 264: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 265: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(278, 1692480320, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(279, 1675703104, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 266: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 267: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 268: {
                this.featureData = new int[]{3};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 269: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 270: {
                this.featureData = new int[]{0, 0, 0};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 271: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 272: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 273: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 274: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 275: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 276: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 277: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 278: {
                this.conditions = new boolean[9];
                this.dpProperties = new int[]{10059, 0x7A00000, 67895552};
                this.featureData = new int[]{0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 279: {
                this.conditions = new boolean[4];
                this.dpProperties = new int[]{67895552};
                this.featureData = new int[]{0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 280: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 281: {
                this.conditions = new boolean[4];
                this.dpProperties = new int[]{67895552};
                this.featureData = new int[]{0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 282: {
                this.conditions = new boolean[4];
                this.dpProperties = new int[]{67895552};
                this.featureData = new int[]{0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 283: {
                this.conditions = new boolean[4];
                this.dpProperties = new int[]{67895552};
                this.featureData = new int[]{0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 284: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 285: {
                this.conditions = new boolean[4];
                this.dpProperties = new int[]{67895552};
                this.featureData = new int[]{0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 286: {
                this.conditions = new boolean[4];
                this.dpProperties = new int[]{67895552};
                this.featureData = new int[]{0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 287: {
                this.conditions = new boolean[4];
                this.dpProperties = new int[]{67895552};
                this.featureData = new int[]{0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 288: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 289: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 290: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 291: {
                this.conditions = new boolean[5];
                this.dpProperties = new int[]{67895552};
                this.featureData = new int[]{0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 292: {
                this.conditions = new boolean[4];
                this.dpProperties = new int[]{67895552};
                this.featureData = new int[]{0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 293: {
                this.conditions = new boolean[4];
                this.dpProperties = new int[]{67895552};
                this.featureData = new int[]{0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 294: {
                this.conditions = new boolean[4];
                this.dpProperties = new int[]{67895552};
                this.featureData = new int[]{0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 295: {
                this.conditions = new boolean[4];
                this.dpProperties = new int[]{67895552};
                this.featureData = new int[]{0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 296: {
                this.conditions = new boolean[4];
                this.dpProperties = new int[]{67895552};
                this.featureData = new int[]{0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 297: {
                this.conditions = new boolean[4];
                this.dpProperties = new int[]{67895552};
                this.featureData = new int[]{0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 298: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(171, 1340158784, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(172, 1356936000, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(173, 1323381568, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(221, 1205941056, 3, false, false)};
                this.featureData = new int[]{1, 0, 1, 3};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 299: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 300: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 301: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(220, 1189163840, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 0, 1};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 302: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(174, 1424044864, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(175, 1440822080, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(176, 1390490432, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(177, 1507930944, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(178, 1491153728, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(220, 1189163840, 3, false, false)};
                this.featureData = new int[]{1, 0, 3};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 303: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(220, 1189163840, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 0, 1};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 304: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(222, 1541485376, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 305: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 306: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 307: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 308: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 309: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 310: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 311: {
                this.featureData = new int[0];
                this.featuresToUpdate = new boolean[0];
                break;
            }
            case 312: {
                this.featureData = new int[0];
                this.featuresToUpdate = new boolean[0];
                break;
            }
            case 313: {
                this.featureData = new int[0];
                this.featuresToUpdate = new boolean[0];
                break;
            }
            case 314: {
                this.conditions = new boolean[8];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 315: {
                this.conditions = new boolean[10];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 316: {
                this.conditions = new boolean[4];
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(158, -924765376, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(227, -1897843904, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[6];
                break;
            }
            case 317: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(155, -1881066688, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 318: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 319: {
                this.conditions = new boolean[4];
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(228, -1931398336, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[6];
                break;
            }
            case 320: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 321: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(159, -1914621120, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 322: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 323: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 324: {
                this.conditions = new boolean[2];
                this.listItemControls = new ListItemControl[]{this.getListItemControl(-2012728320, false)};
                this.listItemControlListeners = new AbstractSdFeatureCollectionHandler$SdFeatureCollectionListItemControlListener[]{new AbstractSdFeatureCollectionHandler$SdFeatureCollectionListItemControlListener(this, -2012728320)};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(160, -1058983104, 3, false, false)};
                this.featureData = new int[]{1, 0, 1, 3};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 325: {
                this.conditions = new boolean[4];
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(230, -1780403392, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(248, -1696517312, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[6];
                break;
            }
            case 326: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 327: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(162, -1763626176, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 328: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 329: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 330: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(153, 2095133504, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(224, 861965641, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(225, 1356936000, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(226, 1323381568, 3, false, false)};
                this.featureData = new int[]{1, 0, 1};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 331: {
                this.conditions = new boolean[4];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 332: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 333: {
                this.conditions = new boolean[6];
                this.dpProperties = new int[]{-1096876032};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(161, -874433728, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(235, -1713294528, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(236, -1797180608, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(248, -1713294528, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[6];
                break;
            }
            case 334: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 335: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 336: {
                this.conditions = new boolean[5];
                this.dpProperties = new int[]{-1096876032};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(161, -874433728, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(164, -1478413504, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(231, -1495190720, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(232, -857656512, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(233, -1713294528, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(234, -1495190720, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(248, -1713294528, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[6];
                break;
            }
            case 337: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 338: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 339: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 340: {
                this.conditions = new boolean[4];
                this.dpProperties = new int[]{-1096876032};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(161, -874433728, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(164, -1478413504, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(235, -1713294528, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(248, -1713294528, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 341: {
                this.conditions = new boolean[4];
                this.dpProperties = new int[]{-1096876032};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(161, -874433728, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(164, -1478413504, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(224, -1478413504, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(226, -1713294528, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(235, -1713294528, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(248, -1713294528, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[6];
                break;
            }
            case 342: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(161, -2132724928, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(164, 2145465152, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(178, 1491153728, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(233, -1713294528, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(248, -1713294528, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 0, 0, 0};
                this.featuresToUpdate = new boolean[6];
                break;
            }
            case 343: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0, 0, 0, 3};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 344: {
                this.conditions = new boolean[5];
                this.dpProperties = new int[]{28043};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(158, 2078356288, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(249, -941542592, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[6];
                break;
            }
            case 345: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(166, -1025428672, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 346: {
                this.conditions = new boolean[6];
                this.dpProperties = new int[]{29633};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(153, -891210944, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(154, -907988160, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(248, -1730071744, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(250, -1730071744, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(251, -1830735040, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[6];
                break;
            }
            case 347: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 348: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(168, -1813957824, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 349: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 350: {
                this.conditions = new boolean[3];
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(158, -102681792, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(252, -1864289472, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[6];
                break;
            }
            case 351: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 352: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(170, -1847512256, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 353: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 354: {
                this.conditions = new boolean[6];
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(158, -69127360, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(169, -35572928, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(258, -1461636288, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[6];
                break;
            }
            case 355: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 356: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 357: {
                this.dpProperties = new int[]{-98238208};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(261, -1444859072, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 358: {
                this.conditions = new boolean[3];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 359: {
                this.conditions = new boolean[4];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 360: {
                this.conditions = new boolean[5];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 361: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(171, 1340158784, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(172, 1356936000, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(173, 1323381568, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(262, -1579076800, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(263, -1528745152, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(266, -1511967936, 3, false, false)};
                this.featureData = new int[]{1, 0, 1, 3};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 362: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 363: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0, 0, 0};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 364: {
                this.conditions = new boolean[2];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 365: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{13351};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(264, -1562299584, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(265, -1562299584, 3, false, false)};
                this.featureData = new int[]{1, 0, 1, 3};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 366: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0, 0, 0};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 367: {
                this.conditions = new boolean[2];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 368: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(267, -1545522368, 3, false, false)};
                this.featureData = new int[]{1, 0, 1, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 369: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 370: {
                this.featureData = new int[]{3};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 371: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(174, 1424044864, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(175, 1440822080, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(176, 1390490432, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(177, 1507930944, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(178, 1491153728, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(262, -1579076800, 3, false, false)};
                this.featureData = new int[]{1, 0, 1, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 372: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0, 0, 0};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 373: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 374: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 375: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(271, -1293864128, 3, false, false)};
                this.featureData = new int[]{1, 0, 1, 3};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 376: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 377: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 378: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 379: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 380: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 381: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 382: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 383: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 384: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 385: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 386: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 387: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 388: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 389: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(174, 1424044864, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(175, 1440822080, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(176, 1390490432, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(177, 1507930944, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(178, 1491153728, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(270, -1310641344, 3, false, false)};
                this.featureData = new int[]{1, 0, 1, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 390: {
                this.featureData = new int[]{0, 0, 0};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 391: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 392: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 393: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 394: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 395: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(171, 1340158784, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(172, 1356936000, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(173, 1323381568, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(263, -1260309696, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(266, -1277086912, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(270, -1310641344, 3, false, false)};
                this.featureData = new int[]{1, 0, 1, 3};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 396: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0, 0, 0};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 397: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 398: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 399: {
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(171, 1340158784, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(172, 1356936000, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(173, 1323381568, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(270, -1310641344, 3, false, false)};
                this.featureData = new int[]{1, 0, 1, 3};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 400: {
                this.featureData = new int[]{0, 0, 0};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 401: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 402: {
                this.conditions = new boolean[8];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 403: {
                this.conditions = new boolean[2];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 404: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 405: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 406: {
                this.conditions = new boolean[6];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 407: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 408: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 409: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 410: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 411: {
                this.conditions = new boolean[2];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 412: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 413: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 414: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 415: {
                this.conditions = new boolean[1];
                this.dpProperties = new int[]{10059, 0x7A00000};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(150, -1679740096, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(153, -1428081856, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(268, -1595854016, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 416: {
                this.conditions = new boolean[3];
                this.listItemControls = new ListItemControl[]{this.getListItemControl(-2146946048, false)};
                this.listItemControlListeners = new AbstractSdFeatureCollectionHandler$SdFeatureCollectionListItemControlListener[]{new AbstractSdFeatureCollectionHandler$SdFeatureCollectionListItemControlListener(this, -2146946048)};
                this.commandFeatureIndex = 0;
                this.featureData = new int[]{0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 417: {
                this.conditions = new boolean[6];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 418: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 419: {
                this.featureData = new int[]{0};
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
            case 121: {
                return this.createFeatureInstance_SSNCAI_7D(n);
            }
            case 122: {
                return this.createFeatureInstance_SSNCCS_7E(n);
            }
            case 123: {
                return this.createFeatureInstance_SSNCCNLSNI_7F(n);
            }
            case 124: {
                return this.createFeatureInstance_SSNCEALB_80(n);
            }
            case 125: {
                return this.createFeatureInstance_SSNCEAL_81(n);
            }
            case 126: {
                return this.createFeatureInstance_SSNCECNL_82(n);
            }
            case 127: {
                return this.createFeatureInstance_SSNCEDDB_83(n);
            }
            case 128: {
                return this.createFeatureInstance_SSNCEDDH_84(n);
            }
            case 129: {
                return this.createFeatureInstance_SSNCEDCLA_85(n);
            }
            case 130: {
                return this.createFeatureInstance_SSNCEDCLB_86(n);
            }
            case 131: {
                return this.createFeatureInstance_SSNCEDCL_87(n);
            }
            case 132: {
                return this.createFeatureInstance_SSNCFCF_88(n);
            }
            case 133: {
                return this.createFeatureInstance_SSNCFCIP_89(n);
            }
            case 134: {
                return this.createFeatureInstance_SSNCFIIP_8A(n);
            }
            case 135: {
                return this.createFeatureInstance_SSNCFNNA_8B(n);
            }
            case 136: {
                return this.createFeatureInstance_SSNCFNCA_8C(n);
            }
            case 137: {
                return this.createFeatureInstance_SSNCFNNCA_8D(n);
            }
            case 138: {
                return this.createFeatureInstance_SSNCNTF_8E(n);
            }
            case 139: {
                return this.createFeatureInstance_SSNDAS_8F(n);
            }
            case 140: {
                return this.createFeatureInstance_SSNDGCSGAA_90(n);
            }
            case 141: {
                return this.createFeatureInstance_SSNDGCSGSDD_91(n);
            }
            case 142: {
                return this.createFeatureInstance_SSNDGCSGSDD_92(n);
            }
            case 143: {
                return this.createFeatureInstance_SSNDGCSGSDM_93(n);
            }
            case 144: {
                return this.createFeatureInstance_SSNDGCSNDD_94(n);
            }
            case 145: {
                return this.createFeatureInstance_SSNDGCSRCA_95(n);
            }
            case 146: {
                return this.createFeatureInstance_SSNDGCSRCFNS_96(n);
            }
            case 147: {
                return this.createFeatureInstance_SSNDGCSCSA_97(n);
            }
            case 148: {
                return this.createFeatureInstance_SSNDGCSCSF_98(n);
            }
            case 149: {
                return this.createFeatureInstance_SSNDGCSCSFH_99(n);
            }
            case 150: {
                return this.createFeatureInstance_SSNDGCSCSFM_9A(n);
            }
            case 151: {
                return this.createFeatureInstance_SSNDGCSCSSAS_9B(n);
            }
            case 152: {
                return this.createFeatureInstance_SSNDGCSCSSD_9C(n);
            }
            case 153: {
                return this.createFeatureInstance_SSNDGCSGNA_9D(n);
            }
            case 154: {
                return this.createFeatureInstance_SSNDGCSGSA_9E(n);
            }
            case 155: {
                return this.createFeatureInstance_SSNDGCSGSAC_9F(n);
            }
            case 156: {
                return this.createFeatureInstance_SSNDGCSGSAH_A0(n);
            }
            case 157: {
                return this.createFeatureInstance_SSNDGCSGSANSR_A1(n);
            }
            case 158: {
                return this.createFeatureInstance_SSNDGLCGP_A2(n);
            }
            case 159: {
                return this.createFeatureInstance_SSNDGLCGP_A3(n);
            }
            case 160: {
                return this.createFeatureInstance_SSNDGLCGP_A4(n);
            }
            case 161: {
                return this.createFeatureInstance_SSNDGLCGP_A7(n);
            }
            case 162: {
                return this.createFeatureInstance_SSNDGLCGP_A8(n);
            }
            case 163: {
                return this.createFeatureInstance_SSNDGLOGP_A9(n);
            }
            case 164: {
                return this.createFeatureInstance_SSNDGLOGP_AA(n);
            }
            case 165: {
                return this.createFeatureInstance_SSNDGLOGP_AB(n);
            }
            case 166: {
                return this.createFeatureInstance_SSNDGLOGP_AE(n);
            }
            case 167: {
                return this.createFeatureInstance_SSNDGLOGP_AF(n);
            }
            case 168: {
                return this.createFeatureInstance_SSNDGLPNA_B0(n);
            }
            case 169: {
                return this.createFeatureInstance_SSNDGLPNA_B1(n);
            }
            case 170: {
                return this.createFeatureInstance_SSNDGLPNA_B2(n);
            }
            case 171: {
                return this.createFeatureInstance_SSNDGLPNA_B3(n);
            }
            case 172: {
                return this.createFeatureInstance_SSNDGLPNA_B4(n);
            }
            case 173: {
                return this.createFeatureInstance_SSNDGLPNA_B7(n);
            }
            case 174: {
                return this.createFeatureInstance_SSNDGLPNA_B8(n);
            }
            case 175: {
                return this.createFeatureInstance_SSNDGLPNA_B9(n);
            }
            case 176: {
                return this.createFeatureInstance_SSNDGLPNA_BA(n);
            }
            case 177: {
                return this.createFeatureInstance_SSNDGLPSLN_BB(n);
            }
            case 178: {
                return this.createFeatureInstance_SSNDGLPSLN_BC(n);
            }
            case 179: {
                return this.createFeatureInstance_SSNDGLPSLN_BD(n);
            }
            case 180: {
                return this.createFeatureInstance_SSNDGLPSLN_BF(n);
            }
            case 181: {
                return this.createFeatureInstance_SSNDGLPSLN_C0(n);
            }
            case 182: {
                return this.createFeatureInstance_SSNDGLPSLN_C1(n);
            }
            case 183: {
                return this.createFeatureInstance_SSNDGLSFP_C2(n);
            }
            case 184: {
                return this.createFeatureInstance_SSNDGLSFP_C3(n);
            }
            case 185: {
                return this.createFeatureInstance_SSNDGLSFP_C4(n);
            }
            case 186: {
                return this.createFeatureInstance_SSNDGLSFP_C5(n);
            }
            case 187: {
                return this.createFeatureInstance_SSNDGLSFP_C6(n);
            }
            case 188: {
                return this.createFeatureInstance_SSNDGLSFP_C9(n);
            }
            case 189: {
                return this.createFeatureInstance_SSNDGLSFP_CA(n);
            }
            case 190: {
                return this.createFeatureInstance_SSNDGLSFP_CB(n);
            }
            case 191: {
                return this.createFeatureInstance_SSNDGLSFP_CC(n);
            }
            case 192: {
                return this.createFeatureInstance_SSNDGLSLP_CD(n);
            }
            case 193: {
                return this.createFeatureInstance_SSNDGLSLP_CE(n);
            }
            case 194: {
                return this.createFeatureInstance_SSNDGLSLP_CF(n);
            }
            case 195: {
                return this.createFeatureInstance_SSNDGLSLP_D0(n);
            }
            case 196: {
                return this.createFeatureInstance_SSNDGLSLP_D1(n);
            }
            case 197: {
                return this.createFeatureInstance_SSNDGLSLP_D4(n);
            }
            case 198: {
                return this.createFeatureInstance_SSNDGLSLP_D5(n);
            }
            case 199: {
                return this.createFeatureInstance_SSNDGLSLP_D6(n);
            }
            case 200: {
                return this.createFeatureInstance_SSNDGLSLP_D7(n);
            }
            case 201: {
                return this.createFeatureInstance_SSNDGLSNE_D8(n);
            }
            case 202: {
                return this.createFeatureInstance_SSNDGLSNPF_D9(n);
            }
            case 203: {
                return this.createFeatureInstance_SSNDGLSNPF_DA(n);
            }
            case 204: {
                return this.createFeatureInstance_SSNDGLSNPF_DB(n);
            }
            case 205: {
                return this.createFeatureInstance_SSNDGLSNPF_DC(n);
            }
            case 206: {
                return this.createFeatureInstance_SSNDGLSNPF_DD(n);
            }
            case 207: {
                return this.createFeatureInstance_SSNDGLSNPF_E0(n);
            }
            case 208: {
                return this.createFeatureInstance_SSNDGLSNPF_E1(n);
            }
            case 209: {
                return this.createFeatureInstance_SSNDGLSNPF_E2(n);
            }
            case 210: {
                return this.createFeatureInstance_SSNDGLSNPF_E3(n);
            }
            case 211: {
                return this.createFeatureInstance_SSNDGLSNPF_E4(n);
            }
            case 212: {
                return this.createFeatureInstance_SSNDGLSNP_E5(n);
            }
            case 213: {
                return this.createFeatureInstance_SSNDGLSNP_E6(n);
            }
            case 214: {
                return this.createFeatureInstance_SSNDGLSNP_E7(n);
            }
            case 215: {
                return this.createFeatureInstance_SSNDGLSNP_E8(n);
            }
            case 216: {
                return this.createFeatureInstance_SSNDGLSNP_E9(n);
            }
            case 217: {
                return this.createFeatureInstance_SSNDGLSNP_EC(n);
            }
            case 218: {
                return this.createFeatureInstance_SSNDGLSNP_ED(n);
            }
            case 219: {
                return this.createFeatureInstance_SSNDGLSNP_EE(n);
            }
            case 220: {
                return this.createFeatureInstance_SSNDGLSNP_EF(n);
            }
            case 221: {
                return this.createFeatureInstance_SSNDGLSPE_F0(n);
            }
            case 222: {
                return this.createFeatureInstance_SSNDGLSPPF_F1(n);
            }
            case 223: {
                return this.createFeatureInstance_SSNDGLSPPF_F2(n);
            }
            case 224: {
                return this.createFeatureInstance_SSNDGLSPPF_F3(n);
            }
            case 225: {
                return this.createFeatureInstance_SSNDGLSPPF_F4(n);
            }
            case 226: {
                return this.createFeatureInstance_SSNDGLSPPF_F5(n);
            }
            case 227: {
                return this.createFeatureInstance_SSNDGLSPPF_F8(n);
            }
            case 228: {
                return this.createFeatureInstance_SSNDGLSPPF_F9(n);
            }
            case 229: {
                return this.createFeatureInstance_SSNDGLSPPF_FA(n);
            }
            case 230: {
                return this.createFeatureInstance_SSNDGLSPPF_FB(n);
            }
            case 231: {
                return this.createFeatureInstance_SSNDGLSPPF_FC(n);
            }
            case 232: {
                return this.createFeatureInstance_SSNDGLSPP_FD(n);
            }
            case 233: {
                return this.createFeatureInstance_SSNDGLSPP_FE(n);
            }
            case 234: {
                return this.createFeatureInstance_SSNDGLSPP_FF(n);
            }
            case 235: {
                return this.createFeatureInstance_SSNDGLSPP_100(n);
            }
            case 236: {
                return this.createFeatureInstance_SSNDGLSPP_101(n);
            }
            case 237: {
                return this.createFeatureInstance_SSNDGLSPP_104(n);
            }
            case 238: {
                return this.createFeatureInstance_SSNDGLSPP_105(n);
            }
            case 239: {
                return this.createFeatureInstance_SSNDGLSPP_106(n);
            }
            case 240: {
                return this.createFeatureInstance_SSNDGLSPP_107(n);
            }
            case 241: {
                return this.createFeatureInstance_SSNDGLSRNF_108(n);
            }
            case 242: {
                return this.createFeatureInstance_SSNDGLSRNF_109(n);
            }
            case 243: {
                return this.createFeatureInstance_SSNDGLSRNF_10A(n);
            }
            case 244: {
                return this.createFeatureInstance_SSNDGLSRNF_10B(n);
            }
            case 245: {
                return this.createFeatureInstance_SSNDGLSRNF_10C(n);
            }
            case 246: {
                return this.createFeatureInstance_SSNDGLSRNF_10F(n);
            }
            case 247: {
                return this.createFeatureInstance_SSNDGLSRNF_110(n);
            }
            case 248: {
                return this.createFeatureInstance_SSNDGLSRNF_111(n);
            }
            case 249: {
                return this.createFeatureInstance_SSNDGLSRNF_112(n);
            }
            case 250: {
                return this.createFeatureInstance_SSNDGNLC_113(n);
            }
            case 251: {
                return this.createFeatureInstance_SSNDGNLC_114(n);
            }
            case 252: {
                return this.createFeatureInstance_SSNDGNLC_116(n);
            }
            case 253: {
                return this.createFeatureInstance_SSNDGNLC_117(n);
            }
            case 254: {
                return this.createFeatureInstance_SSNDGNLC_118(n);
            }
            case 255: {
                return this.createFeatureInstance_SSNDGC_119(n);
            }
            case 256: {
                return this.createFeatureInstance_SSNDGFP_11B(n);
            }
            case 257: {
                return this.createFeatureInstance_SSNDHC_11C(n);
            }
            case 258: {
                return this.createFeatureInstance_SSNDIS_11D(n);
            }
            case 259: {
                return this.createFeatureInstance_SSNDMPRCA_11E(n);
            }
            case 260: {
                return this.createFeatureInstance_SSNDMPRCDN_11F(n);
            }
            case 261: {
                return this.createFeatureInstance_SSNDMPRCDY_120(n);
            }
            case 262: {
                return this.createFeatureInstance_SSNDMPSGA_121(n);
            }
            case 263: {
                return this.createFeatureInstance_SSNDMPSGDN_122(n);
            }
            case 264: {
                return this.createFeatureInstance_SSNDMPSGDY_123(n);
            }
            case 265: {
                return this.createFeatureInstance_SSNDMPWMA_124(n);
            }
            case 266: {
                return this.createFeatureInstance_SSNDMPWMDN_125(n);
            }
            case 267: {
                return this.createFeatureInstance_SSNDMPWMDY_126(n);
            }
            case 268: {
                return this.createFeatureInstance_SSNDNEV_127(n);
            }
            case 269: {
                return this.createFeatureInstance_SSNGGCSFNNA_128(n);
            }
            case 270: {
                return this.createFeatureInstance_SSNGGCSGSDDH_129(n);
            }
            case 271: {
                return this.createFeatureInstance_SSNGGCSSGCSG_12A(n);
            }
            case 272: {
                return this.createFeatureInstance_SSNGGCSFNNA_12B(n);
            }
            case 273: {
                return this.createFeatureInstance_SSNGGCSSGCSG_12C(n);
            }
            case 274: {
                return this.createFeatureInstance_SSNGGCSSGS_12D(n);
            }
            case 275: {
                return this.createFeatureInstance_SSNGGCSSGS_12E(n);
            }
            case 276: {
                return this.createFeatureInstance_SSNGGCSSGS_12F(n);
            }
            case 277: {
                return this.createFeatureInstance_SSNGGCSGS_130(n);
            }
            case 278: {
                return this.createFeatureInstance_SSNGM_131(n);
            }
            case 279: {
                return this.createFeatureInstance_SSNGMA_132(n);
            }
            case 280: {
                return this.createFeatureInstance_SSNGMHNA_134(n);
            }
            case 281: {
                return this.createFeatureInstance_SSNGMH_135(n);
            }
            case 282: {
                return this.createFeatureInstance_SSNGMLD_136(n);
            }
            case 283: {
                return this.createFeatureInstance_SSNGMNC_137(n);
            }
            case 284: {
                return this.createFeatureInstance_SSNGMNA_138(n);
            }
            case 285: {
                return this.createFeatureInstance_SSNGMOPS_139(n);
            }
            case 286: {
                return this.createFeatureInstance_SSNGMPS_13A(n);
            }
            case 287: {
                return this.createFeatureInstance_SSNGMR_13B(n);
            }
            case 288: {
                return this.createFeatureInstance_SSNGNHFNNA_13C(n);
            }
            case 289: {
                return this.createFeatureInstance_SSNGNHFND_13D(n);
            }
            case 290: {
                return this.createFeatureInstance_SSNGNHS_13E(n);
            }
            case 291: {
                return this.createFeatureInstance_SSNGNMA_13F(n);
            }
            case 292: {
                return this.createFeatureInstance_SSNGNMH_140(n);
            }
            case 293: {
                return this.createFeatureInstance_SSNGNMLD_141(n);
            }
            case 294: {
                return this.createFeatureInstance_SSNGNMNC_142(n);
            }
            case 295: {
                return this.createFeatureInstance_SSNGNMOPS_143(n);
            }
            case 296: {
                return this.createFeatureInstance_SSNGNMPS_144(n);
            }
            case 297: {
                return this.createFeatureInstance_SSNGNMR_145(n);
            }
            case 298: {
                return this.createFeatureInstance_SSNLDDDC_146(n);
            }
            case 299: {
                return this.createFeatureInstance_SSNLDEDH_147(n);
            }
            case 300: {
                return this.createFeatureInstance_SSNLDED_148(n);
            }
            case 301: {
                return this.createFeatureInstance_SSNLDELA_149(n);
            }
            case 302: {
                return this.createFeatureInstance_SSNLDELM_14A(n);
            }
            case 303: {
                return this.createFeatureInstance_SSNLDEL_14B(n);
            }
            case 304: {
                return this.createFeatureInstance_SSNLDENL_14C(n);
            }
            case 305: {
                return this.createFeatureInstance_SSNLDFLE_14D(n);
            }
            case 306: {
                return this.createFeatureInstance_SSNLDFNNA_14E(n);
            }
            case 307: {
                return this.createFeatureInstance_SSNLDSNIFNL_14F(n);
            }
            case 308: {
                return this.createFeatureInstance_SSNLDSL_150(n);
            }
            case 309: {
                return this.createFeatureInstance_SSNLDSL_151(n);
            }
            case 310: {
                return this.createFeatureInstance_SSNLDST_152(n);
            }
            case 311: {
                return this.createFeatureInstance_SSNNDLE_156(n);
            }
            case 312: {
                return this.createFeatureInstance_SSNNDLE_157(n);
            }
            case 313: {
                return this.createFeatureInstance_SSNNDLE_158(n);
            }
            case 314: {
                return this.createFeatureInstance_SSNNDLN_159(n);
            }
            case 315: {
                return this.createFeatureInstance_SSNNDLP_15A(n);
            }
            case 316: {
                return this.createFeatureInstance_SSNNDMC_15B(n);
            }
            case 317: {
                return this.createFeatureInstance_SSNNDMCN_15C(n);
            }
            case 318: {
                return this.createFeatureInstance_SSNNDMCPP_15D(n);
            }
            case 319: {
                return this.createFeatureInstance_SSNNDMC_15E(n);
            }
            case 320: {
                return this.createFeatureInstance_SSNNDMCNNA_15F(n);
            }
            case 321: {
                return this.createFeatureInstance_SSNNDMCN_161(n);
            }
            case 322: {
                return this.createFeatureInstance_SSNNDMCPP_162(n);
            }
            case 323: {
                return this.createFeatureInstance_SSNNDMCPP_163(n);
            }
            case 324: {
                return this.createFeatureInstance_SSNNDMCSN_164(n);
            }
            case 325: {
                return this.createFeatureInstance_SSNNDMC_165(n);
            }
            case 326: {
                return this.createFeatureInstance_SSNNDMCNNA_166(n);
            }
            case 327: {
                return this.createFeatureInstance_SSNNDMCN_167(n);
            }
            case 328: {
                return this.createFeatureInstance_SSNNDMCNC_168(n);
            }
            case 329: {
                return this.createFeatureInstance_SSNNDMCPP_169(n);
            }
            case 330: {
                return this.createFeatureInstance_SSNNDMDDV_16A(n);
            }
            case 331: {
                return this.createFeatureInstance_SSNNDMDDVE_16B(n);
            }
            case 332: {
                return this.createFeatureInstance_SSNNDMDDVPH_16C(n);
            }
            case 333: {
                return this.createFeatureInstance_SSNNDMH_16D(n);
            }
            case 334: {
                return this.createFeatureInstance_SSNNDMHACNA_16E(n);
            }
            case 335: {
                return this.createFeatureInstance_SSNNDMHNNA_16F(n);
            }
            case 336: {
                return this.createFeatureInstance_SSNNDMHN_170(n);
            }
            case 337: {
                return this.createFeatureInstance_SSNNDMHNE_171(n);
            }
            case 338: {
                return this.createFeatureInstance_SSNNDMHNPH_172(n);
            }
            case 339: {
                return this.createFeatureInstance_SSNNDMHNA_173(n);
            }
            case 340: {
                return this.createFeatureInstance_SSNNDMHPML_174(n);
            }
            case 341: {
                return this.createFeatureInstance_SSNNDMHPNLNCT_179(n);
            }
            case 342: {
                return this.createFeatureInstance_SSNNDMHPLM_17A(n);
            }
            case 343: {
                return this.createFeatureInstance_SSNNDMSNAFC_199(n);
            }
            case 344: {
                return this.createFeatureInstance_SSNNDMS_19A(n);
            }
            case 345: {
                return this.createFeatureInstance_SSNNDMSN_19B(n);
            }
            case 346: {
                return this.createFeatureInstance_SSNNDMS_19C(n);
            }
            case 347: {
                return this.createFeatureInstance_SSNNDMSNNA_19D(n);
            }
            case 348: {
                return this.createFeatureInstance_SSNNDMSN_19E(n);
            }
            case 349: {
                return this.createFeatureInstance_SSNNDMSPP_19F(n);
            }
            case 350: {
                return this.createFeatureInstance_SSNNDMZ_1A0(n);
            }
            case 351: {
                return this.createFeatureInstance_SSNNDMZNNA_1A1(n);
            }
            case 352: {
                return this.createFeatureInstance_SSNNDMZN_1A2(n);
            }
            case 353: {
                return this.createFeatureInstance_SSNNDMZPP_1A3(n);
            }
            case 354: {
                return this.createFeatureInstance_SSNNDO_1AA(n);
            }
            case 355: {
                return this.createFeatureInstance_SSNNDONNA_1B1(n);
            }
            case 356: {
                return this.createFeatureInstance_SSNNDONNA_1B2(n);
            }
            case 357: {
                return this.createFeatureInstance_SSNNDON_1B3(n);
            }
            case 358: {
                return this.createFeatureInstance_SSNNDOPP_1B6(n);
            }
            case 359: {
                return this.createFeatureInstance_SSNOPCSAR_1B8(n);
            }
            case 360: {
                return this.createFeatureInstance_SSNOPCS_1B9(n);
            }
            case 361: {
                return this.createFeatureInstance_SSNOPEDDB_1BA(n);
            }
            case 362: {
                return this.createFeatureInstance_SSNOPEDDH_1BB(n);
            }
            case 363: {
                return this.createFeatureInstance_SSNOPEDD_1BC(n);
            }
            case 364: {
                return this.createFeatureInstance_SSNOPEDPLA_1BD(n);
            }
            case 365: {
                return this.createFeatureInstance_SSNOPEDPLB_1BE(n);
            }
            case 366: {
                return this.createFeatureInstance_SSNOPEDPL_1BF(n);
            }
            case 367: {
                return this.createFeatureInstance_SSNOPEDPLSNR_1C0(n);
            }
            case 368: {
                return this.createFeatureInstance_SSNOPEPNL_1C1(n);
            }
            case 369: {
                return this.createFeatureInstance_SSNOPEPNLP_1C2(n);
            }
            case 370: {
                return this.createFeatureInstance_SSNOPEPNLTF_1C3(n);
            }
            case 371: {
                return this.createFeatureInstance_SSNOPEPLB_1C4(n);
            }
            case 372: {
                return this.createFeatureInstance_SSNOPEPL_1C5(n);
            }
            case 373: {
                return this.createFeatureInstance_SSNOPFNNA_1C6(n);
            }
            case 374: {
                return this.createFeatureInstance_SSNOPSNIPNL_1C7(n);
            }
            case 375: {
                return this.createFeatureInstance_SSNOPSD_1C8(n);
            }
            case 376: {
                return this.createFeatureInstance_SSNOPSDAN_1C9(n);
            }
            case 377: {
                return this.createFeatureInstance_SSNOPSDEA_1CA(n);
            }
            case 378: {
                return this.createFeatureInstance_SSNOPSDE_1CB(n);
            }
            case 379: {
                return this.createFeatureInstance_SSNOPSDNK_1CC(n);
            }
            case 380: {
                return this.createFeatureInstance_SSNOPSDNR_1CD(n);
            }
            case 381: {
                return this.createFeatureInstance_SSNOPSDSNEF_1CE(n);
            }
            case 382: {
                return this.createFeatureInstance_SSNOPSDSNE_1CF(n);
            }
            case 383: {
                return this.createFeatureInstance_SSNOPSDSPEF_1D0(n);
            }
            case 384: {
                return this.createFeatureInstance_SSNOPSDSPE_1D1(n);
            }
            case 385: {
                return this.createFeatureInstance_SSNOPSENLS_1D2(n);
            }
            case 386: {
                return this.createFeatureInstance_SSNOPSENR_1D3(n);
            }
            case 387: {
                return this.createFeatureInstance_SSNOPSEOF_1D4(n);
            }
            case 388: {
                return this.createFeatureInstance_SSNOPSESF_1D5(n);
            }
            case 389: {
                return this.createFeatureInstance_SSNOPSL_1D6(n);
            }
            case 390: {
                return this.createFeatureInstance_SSNOPSLE_1D7(n);
            }
            case 391: {
                return this.createFeatureInstance_SSNOPSLNKR_1D8(n);
            }
            case 392: {
                return this.createFeatureInstance_SSNOPSLNPF_1D9(n);
            }
            case 393: {
                return this.createFeatureInstance_SSNOPSLNFR_1DA(n);
            }
            case 394: {
                return this.createFeatureInstance_SSNOPSLRFR_1DB(n);
            }
            case 395: {
                return this.createFeatureInstance_SSNOPSMRD_1DC(n);
            }
            case 396: {
                return this.createFeatureInstance_SSNOPSMRDE_1DD(n);
            }
            case 397: {
                return this.createFeatureInstance_SSNOPSMRDN_1DE(n);
            }
            case 398: {
                return this.createFeatureInstance_SSNOPSS_1DF(n);
            }
            case 399: {
                return this.createFeatureInstance_SSNOPSSRD_1E0(n);
            }
            case 400: {
                return this.createFeatureInstance_SSNOPSSRDE_1E1(n);
            }
            case 401: {
                return this.createFeatureInstance_SSNOPSSRDN_1E2(n);
            }
            case 402: {
                return this.createFeatureInstance_SSNRI_1E3(n);
            }
            case 403: {
                return this.createFeatureInstance_SSNRID_1E4(n);
            }
            case 404: {
                return this.createFeatureInstance_SSNRIDI_1E5(n);
            }
            case 405: {
                return this.createFeatureInstance_SSNRIDNA_1E6(n);
            }
            case 406: {
                return this.createFeatureInstance_SSNRIE_1E7(n);
            }
            case 407: {
                return this.createFeatureInstance_SSNRIEI_1E8(n);
            }
            case 408: {
                return this.createFeatureInstance_SSNRIENA_1E9(n);
            }
            case 409: {
                return this.createFeatureInstance_SSNRII_1EA(n);
            }
            case 410: {
                return this.createFeatureInstance_SSNRINA_1EB(n);
            }
            case 411: {
                return this.createFeatureInstance_SSNRIR_1EC(n);
            }
            case 412: {
                return this.createFeatureInstance_SSNRIRI_1ED(n);
            }
            case 413: {
                return this.createFeatureInstance_SSNRIRNA_1EE(n);
            }
            case 414: {
                return this.createFeatureInstance_SSNSUIGNA_1EF(n);
            }
            case 415: {
                return this.createFeatureInstance_SSNSUILNS_1F0(n);
            }
            case 416: {
                return this.createFeatureInstance_SSNSUIN_1F1(n);
            }
            case 417: {
                return this.createFeatureInstance_SSNSUINIP_1F2(n);
            }
            case 418: {
                return this.createFeatureInstance_SSNSUINW_1F3(n);
            }
            case 419: {
                return this.createFeatureInstance_SSNSNLN_1F4(n);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal sdFeatColId: ").append(this.sdFeatColId).toString());
    }

    private Feature createFeatureInstance_SSNCAI_7D(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(674));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(677));
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
                genericTargetFeature.setInt(3003, 0);
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNCCS_7E(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(683));
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
                genericTargetFeature.setBoolean(3008, this.conditions[0]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNCCNLSNI_7F(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(664));
                if (this.conditions[0]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(667));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNCEALB_80(int n) {
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
                arrayList.add(this.createOrderedPrompts(new int[]{680}, 0));
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
                    object = this.getI18nString(5638);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5667), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5631), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5668), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNCEAL_81(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(668));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(694652233));
                return genericTargetFeature;
            }
            case 2: {
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

    private Feature createFeatureInstance_SSNCECNL_82(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(665));
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
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{678}, 0));
                }
                if (this.conditions[1]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{679}, 0));
                }
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNCEDDB_83(int n) {
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
                if (this.conditions[1]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{681}, 0));
                }
                if (this.conditions[0]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{682}, 0));
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
                    object = this.getString(28094);
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5680), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5644), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5631), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNCEDDH_84(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(681));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(682));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNCEDCLA_85(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(670));
                if (this.conditions[0]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(667));
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
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNCEDCLB_86(int n) {
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
                arrayList.add(this.createOrderedPrompts(new int[]{666}, 0));
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
                    object = this.getI18nString(5639);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5634), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5668), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5666), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNCEDCL_87(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(669));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(711429449));
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

    private Feature createFeatureInstance_SSNCFCF_88(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(671));
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

    private Feature createFeatureInstance_SSNCFCIP_89(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(672));
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

    private Feature createFeatureInstance_SSNCFIIP_8A(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(673));
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

    private Feature createFeatureInstance_SSNCFNNA_8B(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(663));
                arrayList.add(SpeechNavigationSdfch.createPrompt(685));
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

    private Feature createFeatureInstance_SSNCFNCA_8C(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(675));
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

    private Feature createFeatureInstance_SSNCFNNCA_8D(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(676));
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

    private Feature createFeatureInstance_SSNCNTF_8E(int n) {
        switch (n) {
            case 0: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (object == null) {
                    object = FormatterService.format(this.getI18nString(5632), this.getLicValue(1678259200, 2, 0, ""));
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5679), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5673), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5631), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDAS_8F(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(202);
                genericTargetFeature.setBoolean(2010, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGCSGAA_90(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(735));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, false);
                return genericTargetFeature;
            }
            case 3: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
            case 4: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{736}, 0));
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
                    object = this.getI18nString(5827);
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

    private Feature createFeatureInstance_SSNDGCSGSDD_91(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(740));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(741));
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
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, this.conditions[0]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGCSGSDD_92(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(740));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(741));
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
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, this.conditions[0]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGCSGSDM_93(int n) {
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
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{737}, 0));
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
                    object = this.getLicValue(1544041472, 12, 0, "");
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5680), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5644), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5642), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGCSNDD_94(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(746));
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

    private Feature createFeatureInstance_SSNDGCSRCA_95(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(747));
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

    private Feature createFeatureInstance_SSNDGCSRCFNS_96(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(748));
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

    private Feature createFeatureInstance_SSNDGCSCSA_97(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(762));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, false);
                return genericTargetFeature;
            }
            case 3: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
            case 4: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{758}, 0));
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
                    object = this.getI18nString(5824);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5680), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5643), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5640), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGCSCSF_98(int n) {
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
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{759}, 0));
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
                    object = this.getI18nString(5826);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5680), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5643), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5666), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGCSCSFH_99(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(759));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGCSCSFM_9A(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(763));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGCSCSSAS_9B(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(761));
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

    private Feature createFeatureInstance_SSNDGCSCSSD_9C(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(760));
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

    private Feature createFeatureInstance_SSNDGCSGNA_9D(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(752));
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
                genericTargetFeature.setInt(3003, 0);
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{753}, 0));
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
                    object = this.getI18nString(5645);
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

    private Feature createFeatureInstance_SSNDGCSGSA_9E(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(754));
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
                genericTargetFeature.setInt(3003, 0);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{756}, 0));
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
                    object = this.getI18nString(5641);
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

    private Feature createFeatureInstance_SSNDGCSGSAC_9F(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(755));
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

    private Feature createFeatureInstance_SSNDGCSGSAH_A0(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(756));
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
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{756}, 0));
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
                    object = this.getI18nString(5825);
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

    private Feature createFeatureInstance_SSNDGCSGSANSR_A1(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(757));
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

    private Feature createFeatureInstance_SSNDGLCGP_A2(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(698));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLCGP_A3(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(698));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLCGP_A4(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(698));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLCGP_A7(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(698));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLCGP_A8(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(698));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLOGP_A9(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(699));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLOGP_AA(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(699));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLOGP_AB(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(699));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLOGP_AE(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(699));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLOGP_AF(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(699));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLPNA_B0(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(697));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLPNA_B1(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(697));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLPNA_B2(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(697));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLPNA_B3(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(697));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLPNA_B4(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(697));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLPNA_B7(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(697));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLPNA_B8(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(697));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLPNA_B9(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(697));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLPNA_BA(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(697));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLPSLN_BB(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(686));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLPSLN_BC(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(686));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLPSLN_BD(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(686));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLPSLN_BF(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(686));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLPSLN_C0(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(686));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLPSLN_C1(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(686));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSFP_C2(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(687));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSFP_C3(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(687));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSFP_C4(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(687));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSFP_C5(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(687));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSFP_C6(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(687));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSFP_C9(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(687));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSFP_CA(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(687));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSFP_CB(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(687));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSFP_CC(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(687));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSLP_CD(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(688));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSLP_CE(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(688));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSLP_CF(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(688));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSLP_D0(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(688));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSLP_D1(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(688));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSLP_D4(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(688));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSLP_D5(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(688));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSLP_D6(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(688));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSLP_D7(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(688));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSNE_D8(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(689));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSNPF_D9(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(691));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSNPF_DA(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(691));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSNPF_DB(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(691));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSNPF_DC(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(691));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSNPF_DD(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(691));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSNPF_E0(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(691));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSNPF_E1(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(691));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSNPF_E2(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(691));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSNPF_E3(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(691));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSNPF_E4(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(691));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSNP_E5(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(690));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSNP_E6(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(690));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSNP_E7(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(690));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSNP_E8(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(690));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSNP_E9(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(690));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSNP_EC(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(690));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSNP_ED(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(690));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSNP_EE(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(690));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSNP_EF(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(690));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSPE_F0(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(692));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSPPF_F1(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(694));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSPPF_F2(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(694));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSPPF_F3(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(694));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSPPF_F4(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(694));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSPPF_F5(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(694));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSPPF_F8(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(694));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSPPF_F9(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(694));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSPPF_FA(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(694));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSPPF_FB(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(694));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSPPF_FC(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(694));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSPP_FD(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(693));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSPP_FE(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(693));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSPP_FF(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(693));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSPP_100(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(693));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSPP_101(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(693));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSPP_104(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(693));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSPP_105(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(693));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSPP_106(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(693));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSPP_107(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(693));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSRNF_108(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(696));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSRNF_109(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(696));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSRNF_10A(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(696));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSRNF_10B(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(696));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSRNF_10C(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(696));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSRNF_10F(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(696));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSRNF_110(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(696));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSRNF_111(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(696));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGLSRNF_112(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(696));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGNLC_113(int n) {
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
                genericTargetFeature.setBoolean(3008, false);
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

    private Feature createFeatureInstance_SSNDGNLC_114(int n) {
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
                genericTargetFeature.setBoolean(3008, false);
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

    private Feature createFeatureInstance_SSNDGNLC_116(int n) {
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
                genericTargetFeature.setBoolean(3008, false);
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

    private Feature createFeatureInstance_SSNDGNLC_117(int n) {
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
                genericTargetFeature.setBoolean(3008, false);
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

    private Feature createFeatureInstance_SSNDGNLC_118(int n) {
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
                genericTargetFeature.setBoolean(3008, false);
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

    private Feature createFeatureInstance_SSNDGC_119(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(201);
                genericTargetFeature.setEvent(2002, this.createEvent(1416072521));
                genericTargetFeature.setEvent(2003, this.createEvent(1399295305));
                genericTargetFeature.setEvent(2001, this.createEvent(1432849737));
                genericTargetFeature.setEvent(2006, this.createEvent(1114082633));
                genericTargetFeature.setEvent(2007, this.createEvent(1130859849));
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDGFP_11B(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(684));
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

    private Feature createFeatureInstance_SSNDHC_11C(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNDIS_11D(int n) {
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

    private Feature createFeatureInstance_SSNDMPRCA_11E(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1085));
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
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1086}, 0));
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
                    object = this.getI18nString(5828);
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

    private Feature createFeatureInstance_SSNDMPRCDN_11F(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1083));
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

    private Feature createFeatureInstance_SSNDMPRCDY_120(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1084));
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

    private Feature createFeatureInstance_SSNDMPSGA_121(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1089));
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
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1090}, 0));
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
                    object = this.getI18nString(5829);
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

    private Feature createFeatureInstance_SSNDMPSGDN_122(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1087));
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

    private Feature createFeatureInstance_SSNDMPSGDY_123(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1088));
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

    private Feature createFeatureInstance_SSNDMPWMA_124(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1093));
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
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1094}, 0));
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
                    object = this.getI18nString(5830);
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

    private Feature createFeatureInstance_SSNDMPWMDN_125(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1091));
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

    private Feature createFeatureInstance_SSNDMPWMDY_126(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1092));
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

    private Feature createFeatureInstance_SSNDNEV_127(int n) {
        switch (n) {
            case 0: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (object == null) {
                    object = this.getI18nString(5832);
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

    private Feature createFeatureInstance_SSNGGCSFNNA_128(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(734));
                arrayList.add(SpeechNavigationSdfch.createPrompt(685));
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

    private Feature createFeatureInstance_SSNGGCSGSDDH_129(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(737));
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

    private Feature createFeatureInstance_SSNGGCSSGCSG_12A(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(733));
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

    private Feature createFeatureInstance_SSNGGCSFNNA_12B(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(750));
                arrayList.add(SpeechNavigationSdfch.createPrompt(685));
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

    private Feature createFeatureInstance_SSNGGCSSGCSG_12C(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(749));
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

    private Feature createFeatureInstance_SSNGGCSSGS_12D(int n) {
        switch (n) {
            case 0: {
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

    private Feature createFeatureInstance_SSNGGCSSGS_12E(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(751));
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

    private Feature createFeatureInstance_SSNGGCSSGS_12F(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(751));
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

    private Feature createFeatureInstance_SSNGGCSGS_130(int n) {
        switch (n) {
            case 0: {
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

    private Feature createFeatureInstance_SSNGM_131(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[5]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(780));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(728206665));
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, this.conditions[6]);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{720}, 0));
                }
                if (this.conditions[2]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{721}, 0));
                }
                if (this.conditions[1]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{719}, 0));
                }
                if (this.conditions[1]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{722}, 0));
                }
                arrayList.add(this.createOrderedPrompts(new int[]{716}, 0));
                if (this.conditions[3]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{717}, 0));
                }
                if (this.conditions[4]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{718}, 0));
                }
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 4: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[7] && object == null) {
                    object = this.getI18nString(5793);
                    bl = false;
                }
                if (this.conditions[8] && object == null) {
                    object = this.getI18nString(5836);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5762), false));
                if (this.conditions[4]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5788), false));
                }
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5777), false));
                if (this.conditions[3]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5771), false));
                }
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 3);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNGMA_132(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(700));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(744983881));
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, this.conditions[1]);
                genericTargetFeature.setBoolean(3007, this.conditions[0]);
                genericTargetFeature.setBoolean(3001, this.conditions[0]);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{703}, 0));
                arrayList.add(this.createOrderedPrompts(new int[]{704}, 0));
                arrayList.add(this.createOrderedPrompts(new int[]{705}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 4: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[2] && object == null) {
                    object = this.getI18nString(5681);
                    bl = false;
                }
                if (this.conditions[3] && object == null) {
                    object = this.getI18nString(5836);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5762), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5502), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5766), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNGMHNA_134(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1078));
                arrayList.add(SpeechNavigationSdfch.createPrompt(685));
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

    private Feature createFeatureInstance_SSNGMH_135(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(713));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(761761097));
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, this.conditions[1]);
                genericTargetFeature.setBoolean(3007, this.conditions[0]);
                genericTargetFeature.setBoolean(3001, this.conditions[0]);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{712}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 4: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[2] && object == null) {
                    object = this.getI18nString(5750);
                    bl = false;
                }
                if (this.conditions[3] && object == null) {
                    object = this.getI18nString(5836);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5777), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNGMLD_136(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(715));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(778538313));
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, this.conditions[1]);
                genericTargetFeature.setBoolean(3007, this.conditions[0]);
                genericTargetFeature.setBoolean(3001, this.conditions[0]);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{714}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 4: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[2] && object == null) {
                    object = this.getI18nString(5752);
                    bl = false;
                }
                if (this.conditions[3] && object == null) {
                    object = this.getI18nString(5836);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5769), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNGMNC_137(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(724));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(795315529));
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, this.conditions[1]);
                genericTargetFeature.setBoolean(3007, this.conditions[0]);
                genericTargetFeature.setBoolean(3001, this.conditions[0]);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{723}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 4: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[2] && object == null) {
                    object = this.getI18nString(5794);
                    bl = false;
                }
                if (this.conditions[3] && object == null) {
                    object = this.getI18nString(5836);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5796), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNGMNA_138(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1077));
                arrayList.add(SpeechNavigationSdfch.createPrompt(685));
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

    private Feature createFeatureInstance_SSNGMOPS_139(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(726));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(812092745));
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, this.conditions[1]);
                genericTargetFeature.setBoolean(3007, this.conditions[0]);
                genericTargetFeature.setBoolean(3001, this.conditions[0]);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{725}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 4: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[2] && object == null) {
                    object = this.getI18nString(5812);
                    bl = false;
                }
                if (this.conditions[3] && object == null) {
                    object = this.getI18nString(5836);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5814), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5815), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5816), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNGMPS_13A(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(729));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(828869961));
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, this.conditions[1]);
                genericTargetFeature.setBoolean(3007, this.conditions[0]);
                genericTargetFeature.setBoolean(3001, this.conditions[0]);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{727}, 0));
                arrayList.add(this.createOrderedPrompts(new int[]{728}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 4: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[2] && object == null) {
                    object = this.getI18nString(5801);
                    bl = false;
                }
                if (this.conditions[3] && object == null) {
                    object = this.getI18nString(5836);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5788), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5809), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5810), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNGMR_13B(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(732));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(845647177));
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, this.conditions[1]);
                genericTargetFeature.setBoolean(3007, this.conditions[0]);
                genericTargetFeature.setBoolean(3001, this.conditions[0]);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{730}, 0));
                arrayList.add(this.createOrderedPrompts(new int[]{731}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 4: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[2] && object == null) {
                    object = this.getI18nString(5817);
                    bl = false;
                }
                if (this.conditions[3] && object == null) {
                    object = this.getI18nString(5836);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5644), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5503), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5820), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNGNHFNNA_13C(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(764));
                arrayList.add(SpeechNavigationSdfch.createPrompt(685));
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

    private Feature createFeatureInstance_SSNGNHFND_13D(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(765));
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
                genericTargetFeature.setBoolean(3008, this.conditions[0]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNGNHS_13E(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(768));
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
                genericTargetFeature.setBoolean(3008, this.conditions[0]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNGNMA_13F(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(997));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(998));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(999));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(744983881));
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, this.conditions[2]);
                genericTargetFeature.setBoolean(3007, this.conditions[1]);
                genericTargetFeature.setBoolean(3001, this.conditions[1]);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{997}, 0));
                arrayList.add(this.createOrderedPrompts(new int[]{998}, 0));
                arrayList.add(this.createOrderedPrompts(new int[]{999}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 4: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[3] && object == null) {
                    object = this.getI18nString(5893);
                    bl = false;
                }
                if (this.conditions[4] && object == null) {
                    object = this.getI18nString(5835);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5762), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5502), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5766), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNGNMH_140(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(1006));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(761761097));
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, this.conditions[1]);
                genericTargetFeature.setBoolean(3007, this.conditions[0]);
                genericTargetFeature.setBoolean(3001, this.conditions[0]);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1006}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 4: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[2] && object == null) {
                    object = this.getI18nString(5894);
                    bl = false;
                }
                if (this.conditions[3] && object == null) {
                    object = this.getI18nString(5835);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5777), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNGNMLD_141(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(1008));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(778538313));
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, this.conditions[1]);
                genericTargetFeature.setBoolean(3007, this.conditions[0]);
                genericTargetFeature.setBoolean(3001, this.conditions[0]);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1008}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 4: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[2] && object == null) {
                    object = this.getI18nString(5895);
                    bl = false;
                }
                if (this.conditions[3] && object == null) {
                    object = this.getI18nString(5835);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5769), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNGNMNC_142(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(1010));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(795315529));
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, this.conditions[1]);
                genericTargetFeature.setBoolean(3007, this.conditions[0]);
                genericTargetFeature.setBoolean(3001, this.conditions[0]);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1010}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 4: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[2] && object == null) {
                    object = this.getI18nString(5896);
                    bl = false;
                }
                if (this.conditions[3] && object == null) {
                    object = this.getI18nString(5835);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5796), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNGNMOPS_143(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(1012));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(812092745));
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, this.conditions[1]);
                genericTargetFeature.setBoolean(3007, this.conditions[0]);
                genericTargetFeature.setBoolean(3001, this.conditions[0]);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1012}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 4: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[2] && object == null) {
                    object = this.getI18nString(5898);
                    bl = false;
                }
                if (this.conditions[3] && object == null) {
                    object = this.getI18nString(5835);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5814), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5815), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5816), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNGNMPS_144(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(1014));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(1015));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(828869961));
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, this.conditions[1]);
                genericTargetFeature.setBoolean(3007, this.conditions[0]);
                genericTargetFeature.setBoolean(3001, this.conditions[0]);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1014}, 0));
                arrayList.add(this.createOrderedPrompts(new int[]{1015}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 4: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[2] && object == null) {
                    object = this.getI18nString(5897);
                    bl = false;
                }
                if (this.conditions[3] && object == null) {
                    object = this.getI18nString(5835);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5788), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5809), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5810), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNGNMR_145(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(1017));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(1018));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(845647177));
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, this.conditions[1]);
                genericTargetFeature.setBoolean(3007, this.conditions[0]);
                genericTargetFeature.setBoolean(3001, this.conditions[0]);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{1017}, 0));
                arrayList.add(this.createOrderedPrompts(new int[]{1018}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 4: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[2] && object == null) {
                    object = this.getI18nString(5899);
                    bl = false;
                }
                if (this.conditions[3] && object == null) {
                    object = this.getI18nString(5835);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5644), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5503), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5820), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNLDDDC_146(int n) {
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
                arrayList.add(this.createOrderedPrompts(new int[]{770}, 0));
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
                    object = this.getLicValue(1544041472, 12, 0, "");
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5680), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5644), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5652), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNLDEDH_147(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(770));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNLDED_148(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(771));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNLDELA_149(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(774));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(862424393));
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
                arrayList.add(this.createOrderedPrompts(new int[]{773}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNLDELM_14A(int n) {
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
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (object == null) {
                    object = this.getI18nString(5651);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5667), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5672), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5668), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNLDEL_14B(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(772));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(862424393));
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
                arrayList.add(this.createOrderedPrompts(new int[]{773}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNLDENL_14C(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(775));
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
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{776}, 0));
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
                    object = FormatterService.format(this.getI18nString(5650), this.getLicValue(1393046528, 2, 0, ""));
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5679), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5673), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5649), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNLDFLE_14D(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(777));
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

    private Feature createFeatureInstance_SSNLDFNNA_14E(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(769));
                arrayList.add(SpeechNavigationSdfch.createPrompt(685));
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

    private Feature createFeatureInstance_SSNLDSNIFNL_14F(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(779));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNLDSL_150(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(686));
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
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNLDSL_151(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(686));
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
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNLDST_152(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(778));
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

    private Feature createFeatureInstance_SSNNDLE_156(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDLE_157(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDLE_158(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDLN_159(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[4]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(801));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(808));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(814));
                }
                if (this.conditions[7]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(822));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(880));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(889));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(899));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(974));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDLP_15A(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(809));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(815));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(881));
                }
                if (this.conditions[7]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(898));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(890));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(802));
                }
                if (this.conditions[8]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(788));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(972));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(973));
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
                genericTargetFeature.setBoolean(3008, this.conditions[9]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDMC_15B(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(797));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(799));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(800));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(879201609));
                return genericTargetFeature;
            }
            case 3: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, this.conditions[1]);
                return genericTargetFeature;
            }
            case 4: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{795}, 0));
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
                    object = this.getI18nString(5837);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5853), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5854), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5668), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDMCN_15C(int n) {
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
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{801}, 0));
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
                    object = FormatterService.format(this.getI18nString(5877), this.getLicValue(1627927552, 1, 0, ""));
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5876), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5673), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5869), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDMCPP_15D(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(798));
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
                genericTargetFeature.setBoolean(3008, this.conditions[0]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDMC_15E(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[3]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(804));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(806));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(807));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(895978825));
                return genericTargetFeature;
            }
            case 3: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, this.conditions[2]);
                return genericTargetFeature;
            }
            case 4: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{803}, 0));
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
                    object = this.getI18nString(5838);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5855), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5668), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5666), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDMCNNA_15F(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1072));
                arrayList.add(SpeechNavigationSdfch.createPrompt(685));
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

    private Feature createFeatureInstance_SSNNDMCN_161(int n) {
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
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{808}, 0));
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
                    object = FormatterService.format(this.getI18nString(5877), this.getLicValue(1627927552, 1, 0, ""));
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5876), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5673), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5870), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDMCPP_162(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(805));
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
                genericTargetFeature.setBoolean(3008, this.conditions[0]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDMCPP_163(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(805));
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
                genericTargetFeature.setBoolean(3008, this.conditions[0]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDMCSN_164(int n) {
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
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
            case 2: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{814}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 3: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[0] && object == null) {
                    object = FormatterService.format((CharSequence)this.getI18nString(5879), this.getLicValue(-2012728320, 2, 0, ""), this.getLicValue(-2012728320, 4, 0, ""));
                    bl = true;
                }
                if (this.conditions[1] && object == null) {
                    object = FormatterService.format(this.getI18nString(5878), this.getLicValue(-2012728320, 2, 0, ""));
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5876), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5673), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5870), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDMC_165(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[3]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(817));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(819));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(821));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(912756041));
                return genericTargetFeature;
            }
            case 3: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, this.conditions[1]);
                return genericTargetFeature;
            }
            case 4: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{816}, 0));
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
                    object = this.getI18nString(5839);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5856), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5857), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5668), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDMCNNA_166(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1073));
                arrayList.add(SpeechNavigationSdfch.createPrompt(685));
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

    private Feature createFeatureInstance_SSNNDMCN_167(int n) {
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
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{822}, 0));
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
                    object = FormatterService.format(this.getI18nString(5877), this.getLicValue(1627927552, 1, 0, ""));
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5876), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5673), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5871), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDMCNC_168(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(818));
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
                genericTargetFeature.setBoolean(3008, this.conditions[0]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDMCPP_169(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(886));
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
                genericTargetFeature.setBoolean(3008, this.conditions[0]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDMDDV_16A(int n) {
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
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
            case 2: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{787}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDMDDVE_16B(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[3]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(783));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(784));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(785));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(786));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDMDDVPH_16C(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, true);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDMH_16D(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[5]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(831));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(833));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(839));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(929533257));
                return genericTargetFeature;
            }
            case 3: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, this.conditions[3]);
                return genericTargetFeature;
            }
            case 4: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[2]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{823}, 0));
                }
                if (this.conditions[1]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{824}, 0));
                }
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
                    object = this.getI18nString(5843);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5860), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5862), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5858), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDMHACNA_16E(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(840));
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
                genericTargetFeature.setBoolean(3008, this.conditions[0]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDMHNNA_16F(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1074));
                arrayList.add(SpeechNavigationSdfch.createPrompt(685));
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

    private Feature createFeatureInstance_SSNNDMHN_170(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                return genericTargetFeature;
            }
            case 3: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, this.conditions[4]);
                return genericTargetFeature;
            }
            case 4: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{828}, 0));
                }
                if (this.conditions[0]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{829}, 0));
                }
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
                    object = FormatterService.format(this.getI18nString(5841), this.getLicValue(2013803520, 2, 0, ""));
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5861), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5862), false));
                if (this.conditions[3]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5858), false));
                }
                if (this.conditions[2]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5668), false));
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

    private Feature createFeatureInstance_SSNNDMHNE_171(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(830));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDMHNPH_172(int n) {
        switch (n) {
            case 0: {
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

    private Feature createFeatureInstance_SSNNDMHNA_173(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(832));
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
                genericTargetFeature.setBoolean(3008, this.conditions[0]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDMHPML_174(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{836}, 0));
                }
                if (this.conditions[0]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{837}, 0));
                }
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
                    object = this.getI18nString(5840);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5667), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5859), false));
                if (this.conditions[3]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5858), false));
                }
                if (this.conditions[2]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5668), false));
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

    private Feature createFeatureInstance_SSNNDMHPNLNCT_179(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(793));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                return genericTargetFeature;
            }
            case 3: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, this.conditions[2]);
                return genericTargetFeature;
            }
            case 4: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{791}, 0));
                }
                if (this.conditions[0]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{792}, 0));
                }
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
                    object = this.getI18nString(5842);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5862), false));
                if (this.conditions[3]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5858), false));
                }
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5859), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDMHPLM_17A(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(788));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, false);
                return genericTargetFeature;
            }
            case 3: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
            case 4: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 5: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                ArrayList arrayList = null;
                boolean bl = false;
                DynamicString dynamicString = this.createDynamicString((String)((Object)arrayList), bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                arrayList = new ArrayList();
                Object[] objectArray = new DynamicString[arrayList.size()];
                arrayList.toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDMSNAFC_199(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(874));
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
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, false);
                genericTargetFeature.setBoolean(3002, true);
                genericTargetFeature.setInt(3003, 0);
                genericTargetFeature.setBoolean(3008, this.conditions[0]);
                return genericTargetFeature;
            }
            case 3: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (object == null) {
                    object = this.getI18nString(5832);
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

    private Feature createFeatureInstance_SSNNDMS_19A(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(876));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(877));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(879));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(946310473));
                return genericTargetFeature;
            }
            case 3: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, this.conditions[2]);
                return genericTargetFeature;
            }
            case 4: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{875}, 0));
                }
                if (this.conditions[4]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{878}, 0));
                }
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
                    object = this.getI18nString(5845);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5867), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5868), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5668), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDMSN_19B(int n) {
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
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{880}, 0));
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
                    object = FormatterService.format(this.getI18nString(5877), this.getLicValue(1627927552, 1, 0, ""));
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5876), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5673), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5873), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDMS_19C(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(885));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(887));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(888));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(963087689));
                return genericTargetFeature;
            }
            case 3: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, this.conditions[2]);
                return genericTargetFeature;
            }
            case 4: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{883}, 0));
                }
                if (this.conditions[3]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{882}, 0));
                }
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
                    object = this.getI18nString(5846);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5864), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5865), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5866), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDMSNNA_19D(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1075));
                arrayList.add(SpeechNavigationSdfch.createPrompt(685));
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

    private Feature createFeatureInstance_SSNNDMSN_19E(int n) {
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
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{889}, 0));
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
                    object = FormatterService.format(this.getI18nString(5877), this.getLicValue(1627927552, 1, 0, ""));
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5876), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5673), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5874), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDMSPP_19F(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(886));
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
                genericTargetFeature.setBoolean(3008, this.conditions[0]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDMZ_1A0(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(894));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(897));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(979864905));
                return genericTargetFeature;
            }
            case 3: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, this.conditions[1]);
                return genericTargetFeature;
            }
            case 4: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{891}, 0));
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
                    object = this.getI18nString(5847);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5863), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5854), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5668), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDMZNNA_1A1(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1076));
                arrayList.add(SpeechNavigationSdfch.createPrompt(685));
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

    private Feature createFeatureInstance_SSNNDMZN_1A2(int n) {
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
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{899}, 0));
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
                    object = FormatterService.format(this.getI18nString(5877), this.getLicValue(1627927552, 1, 0, ""));
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5876), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5673), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5872), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDMZPP_1A3(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(895));
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
                genericTargetFeature.setBoolean(3008, this.conditions[0]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDO_1AA(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[2]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(919));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(981));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(947));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(948));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(949));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(996642121));
                return genericTargetFeature;
            }
            case 3: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, this.conditions[5]);
                return genericTargetFeature;
            }
            case 4: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{950}, 0));
                arrayList.add(this.createOrderedPrompts(new int[]{951}, 0));
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
                    object = this.getI18nString(5883);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5881), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5880), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5668), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDONNA_1B1(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1070));
                arrayList.add(SpeechNavigationSdfch.createPrompt(685));
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

    private Feature createFeatureInstance_SSNNDONNA_1B2(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1070));
                arrayList.add(SpeechNavigationSdfch.createPrompt(685));
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

    private Feature createFeatureInstance_SSNNDON_1B3(int n) {
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
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{974}, 0));
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
                    object = FormatterService.format(this.getI18nString(5892), this.getString(-98238208));
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5876), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5673), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5891), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNNDOPP_1B6(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[2]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(982));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(983));
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
                genericTargetFeature.setBoolean(3008, this.conditions[0]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNOPCSAR_1B8(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[2]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(1043));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(1046));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(1045));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(1040));
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
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNOPCS_1B9(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(1041));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(1042));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(1044));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(1039));
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
                genericTargetFeature.setBoolean(3008, this.conditions[0]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNOPEDDB_1BA(int n) {
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
                arrayList.add(this.createOrderedPrompts(new int[]{1034}, 0));
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
                    object = this.getLicValue(1997026304, 2, 0, "");
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5644), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5654), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5671), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNOPEDDH_1BB(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1034));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNOPEDD_1BC(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(1026));
                }
                arrayList.add(SpeechNavigationSdfch.createPrompt(1023));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1030196553));
                return genericTargetFeature;
            }
            case 2: {
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

    private Feature createFeatureInstance_SSNOPEDPLA_1BD(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(1029));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(1030));
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
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNOPEDPLB_1BE(int n) {
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
                if (this.conditions[1]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1035}, 0));
                }
                if (this.conditions[0]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1036}, 0));
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
                    object = this.getI18nString(5665);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                if (this.conditions[0]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5658), false));
                }
                if (this.conditions[0]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5659), false));
                }
                if (this.conditions[0]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5660), false));
                }
                if (this.conditions[1]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5655), false));
                }
                if (this.conditions[1]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5656), false));
                }
                if (this.conditions[1]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5657), false));
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

    private Feature createFeatureInstance_SSNOPEDPL_1BF(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1028));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1013419337));
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
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNOPEDPLSNR_1C0(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1031));
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(1032));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(1033));
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
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNOPEPNL_1C1(int n) {
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
                arrayList.add(this.createOrderedPrompts(new int[]{1037}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNOPEPNLP_1C2(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1047));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNOPEPNLTF_1C3(int n) {
        switch (n) {
            case 0: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (object == null) {
                    object = FormatterService.format(this.getI18nString(5653), this.getLicValue(1829254144, 5, 0, ""));
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5679), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5673), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5654), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNOPEPLB_1C4(int n) {
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
                arrayList.add(this.createOrderedPrompts(new int[]{1038}, 0));
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
                    object = FormatterService.format(this.getI18nString(5664), Integer.toString(this.getListItemControl(1879585792, true).getItemCount()));
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5667), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5654), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5670), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5668), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNOPEPL_1C5(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(1048));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, this.conditions[0]);
                genericTargetFeature.setEvent(3010, this.createEvent(1046973769));
                return genericTargetFeature;
            }
            case 2: {
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

    private Feature createFeatureInstance_SSNOPFNNA_1C6(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1020));
                arrayList.add(SpeechNavigationSdfch.createPrompt(685));
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

    private Feature createFeatureInstance_SSNOPSNIPNL_1C7(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1021));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNOPSD_1C8(int n) {
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
                arrayList.add(this.createOrderedPrompts(new int[]{1056}, 0));
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
                    object = this.getI18nString(5904);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5900), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5902), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5903), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5668), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5666), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5678), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNOPSDAN_1C9(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1053));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1063750985));
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNOPSDEA_1CA(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1054));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNOPSDE_1CB(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1055));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1063750985));
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNOPSDNK_1CC(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1065));
                arrayList.add(SpeechNavigationSdfch.createPrompt(1057));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNOPSDNR_1CD(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1068));
                arrayList.add(SpeechNavigationSdfch.createPrompt(1058));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNOPSDSNEF_1CE(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(691));
                arrayList.add(SpeechNavigationSdfch.createPrompt(1049));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNOPSDSNE_1CF(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(689));
                arrayList.add(SpeechNavigationSdfch.createPrompt(1049));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNOPSDSPEF_1D0(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(694));
                arrayList.add(SpeechNavigationSdfch.createPrompt(1049));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNOPSDSPE_1D1(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(692));
                arrayList.add(SpeechNavigationSdfch.createPrompt(1049));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNOPSENLS_1D2(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1066));
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
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNOPSENR_1D3(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1067));
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
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNOPSEOF_1D4(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1059));
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

    private Feature createFeatureInstance_SSNOPSESF_1D5(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1060));
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

    private Feature createFeatureInstance_SSNOPSL_1D6(int n) {
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
                arrayList.add(this.createOrderedPrompts(new int[]{1063}, 0));
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
                    object = this.getI18nString(5907);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5667), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5674), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5670), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5677), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5668), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5666), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNOPSLE_1D7(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1061));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1080528201));
                return genericTargetFeature;
            }
            case 2: {
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

    private Feature createFeatureInstance_SSNOPSLNKR_1D8(int n) {
        switch (n) {
            case 0: {
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

    private Feature createFeatureInstance_SSNOPSLNPF_1D9(int n) {
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

    private Feature createFeatureInstance_SSNOPSLNFR_1DA(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1064));
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

    private Feature createFeatureInstance_SSNOPSLRFR_1DB(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1062));
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

    private Feature createFeatureInstance_SSNOPSMRD_1DC(int n) {
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
                arrayList.add(this.createOrderedPrompts(new int[]{1050}, 0));
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
                    object = FormatterService.format(this.getI18nString(5675), this.getLicValue(2131244032, 2, 0, ""));
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5680), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5676), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5662), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5663), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5668), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5666), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNOPSMRDE_1DD(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(686));
                }
                arrayList.add(SpeechNavigationSdfch.createPrompt(1049));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, false);
                genericTargetFeature.setEvent(3010, this.createEvent(1097305417));
                return genericTargetFeature;
            }
            case 2: {
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

    private Feature createFeatureInstance_SSNOPSMRDN_1DE(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1050));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNOPSS_1DF(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1069));
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

    private Feature createFeatureInstance_SSNOPSSRD_1E0(int n) {
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
                arrayList.add(this.createOrderedPrompts(new int[]{1052}, 0));
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
                    object = FormatterService.format(this.getI18nString(5675), this.getLicValue(2131244032, 2, 0, ""));
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5680), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5676), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5674), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5668), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5666), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5678), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNOPSSRDE_1E1(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1051));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(1097305417));
                return genericTargetFeature;
            }
            case 2: {
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

    private Feature createFeatureInstance_SSNOPSSRDN_1E2(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1052));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNRI_1E3(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(435));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(436));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(437));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(438));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(440));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(441));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(444));
                }
                if (this.conditions[7]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(445));
                }
                if (this.conditions[6]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(432));
                }
                if (this.conditions[7]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(433));
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
                genericTargetFeature.setInt(3003, 0);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNRID_1E4(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(432));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(433));
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
                genericTargetFeature.setInt(3003, 0);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNRIDI_1E5(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(434));
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

    private Feature createFeatureInstance_SSNRIDNA_1E6(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1080));
                arrayList.add(SpeechNavigationSdfch.createPrompt(685));
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

    private Feature createFeatureInstance_SSNRIE_1E7(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(435));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(436));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(437));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(438));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(440));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(441));
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
                genericTargetFeature.setInt(3003, 0);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNRIEI_1E8(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(442));
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

    private Feature createFeatureInstance_SSNRIENA_1E9(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1081));
                arrayList.add(SpeechNavigationSdfch.createPrompt(685));
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

    private Feature createFeatureInstance_SSNRII_1EA(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(443));
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

    private Feature createFeatureInstance_SSNRINA_1EB(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1079));
                arrayList.add(SpeechNavigationSdfch.createPrompt(685));
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

    private Feature createFeatureInstance_SSNRIR_1EC(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(444));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(445));
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
                genericTargetFeature.setInt(3003, 0);
                genericTargetFeature.setBoolean(3008, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNRIRI_1ED(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(446));
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

    private Feature createFeatureInstance_SSNRIRNA_1EE(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(1082));
                arrayList.add(SpeechNavigationSdfch.createPrompt(685));
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

    private Feature createFeatureInstance_SSNSUIGNA_1EF(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(474));
                arrayList.add(SpeechNavigationSdfch.createPrompt(685));
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

    private Feature createFeatureInstance_SSNSUILNS_1F0(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(473));
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
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{472}, 0));
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
                    object = this.getI18nString(5908);
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

    private Feature createFeatureInstance_SSNSUIN_1F1(int n) {
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
                genericTargetFeature.setBoolean(3008, true);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{479}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 4: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[0] && object == null) {
                    object = FormatterService.format(this.getI18nString(5910), this.getLicValue(-2146946048, 3, 0, ""));
                    bl = true;
                }
                if (this.conditions[1] && object == null) {
                    object = FormatterService.format(this.getI18nString(5911), this.getLicValue(-2146946048, 15, 0, ""));
                    bl = true;
                }
                if (this.conditions[2] && object == null) {
                    object = FormatterService.format(this.getI18nString(5909), this.getLicValue(-2146946048, 9, 0, ""));
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5876), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5673), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5668), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNSUINIP_1F2(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[5]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(477));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(478));
                }
                if (this.conditions[3]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(480));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(483));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(484));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechNavigationSdfch.createPrompt(485));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSNSUINW_1F3(int n) {
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

    private Feature createFeatureInstance_SSNSNLN_1F4(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechNavigationSdfch.createPrompt(479));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    @Override
    protected void collectAllUnconditionalCommands(ObjectArrayList objectArrayList) {
        switch (this.sdFeatColId) {
            case 124: {
                this.collectAllUnconditionalCommands_SSNCEALB_80(objectArrayList);
                break;
            }
            case 126: {
                this.collectAllUnconditionalCommands_SSNCECNL_82(objectArrayList);
                break;
            }
            case 127: {
                this.collectAllUnconditionalCommands_SSNCEDDB_83(objectArrayList);
                break;
            }
            case 130: {
                this.collectAllUnconditionalCommands_SSNCEDCLB_86(objectArrayList);
                break;
            }
            case 140: {
                this.collectAllUnconditionalCommands_SSNDGCSGAA_90(objectArrayList);
                break;
            }
            case 143: {
                this.collectAllUnconditionalCommands_SSNDGCSGSDM_93(objectArrayList);
                break;
            }
            case 147: {
                this.collectAllUnconditionalCommands_SSNDGCSCSA_97(objectArrayList);
                break;
            }
            case 148: {
                this.collectAllUnconditionalCommands_SSNDGCSCSF_98(objectArrayList);
                break;
            }
            case 153: {
                this.collectAllUnconditionalCommands_SSNDGCSGNA_9D(objectArrayList);
                break;
            }
            case 154: {
                this.collectAllUnconditionalCommands_SSNDGCSGSA_9E(objectArrayList);
                break;
            }
            case 156: {
                this.collectAllUnconditionalCommands_SSNDGCSGSAH_A0(objectArrayList);
                break;
            }
            case 250: {
                this.collectAllUnconditionalCommands_SSNDGNLC_113(objectArrayList);
                break;
            }
            case 251: {
                this.collectAllUnconditionalCommands_SSNDGNLC_114(objectArrayList);
                break;
            }
            case 252: {
                this.collectAllUnconditionalCommands_SSNDGNLC_116(objectArrayList);
                break;
            }
            case 253: {
                this.collectAllUnconditionalCommands_SSNDGNLC_117(objectArrayList);
                break;
            }
            case 254: {
                this.collectAllUnconditionalCommands_SSNDGNLC_118(objectArrayList);
                break;
            }
            case 255: {
                this.collectAllUnconditionalCommands_SSNDGC_119(objectArrayList);
                break;
            }
            case 257: {
                this.collectAllUnconditionalCommands_SSNDHC_11C(objectArrayList);
                break;
            }
            case 259: {
                this.collectAllUnconditionalCommands_SSNDMPRCA_11E(objectArrayList);
                break;
            }
            case 262: {
                this.collectAllUnconditionalCommands_SSNDMPSGA_121(objectArrayList);
                break;
            }
            case 265: {
                this.collectAllUnconditionalCommands_SSNDMPWMA_124(objectArrayList);
                break;
            }
            case 298: {
                this.collectAllUnconditionalCommands_SSNLDDDC_146(objectArrayList);
                break;
            }
            case 301: {
                this.collectAllUnconditionalCommands_SSNLDELA_149(objectArrayList);
                break;
            }
            case 302: {
                this.collectAllUnconditionalCommands_SSNLDELM_14A(objectArrayList);
                break;
            }
            case 303: {
                this.collectAllUnconditionalCommands_SSNLDEL_14B(objectArrayList);
                break;
            }
            case 304: {
                this.collectAllUnconditionalCommands_SSNLDENL_14C(objectArrayList);
                break;
            }
            case 316: {
                this.collectAllUnconditionalCommands_SSNNDMC_15B(objectArrayList);
                break;
            }
            case 317: {
                this.collectAllUnconditionalCommands_SSNNDMCN_15C(objectArrayList);
                break;
            }
            case 319: {
                this.collectAllUnconditionalCommands_SSNNDMC_15E(objectArrayList);
                break;
            }
            case 321: {
                this.collectAllUnconditionalCommands_SSNNDMCN_161(objectArrayList);
                break;
            }
            case 324: {
                this.collectAllUnconditionalCommands_SSNNDMCSN_164(objectArrayList);
                break;
            }
            case 325: {
                this.collectAllUnconditionalCommands_SSNNDMC_165(objectArrayList);
                break;
            }
            case 327: {
                this.collectAllUnconditionalCommands_SSNNDMCN_167(objectArrayList);
                break;
            }
            case 330: {
                this.collectAllUnconditionalCommands_SSNNDMDDV_16A(objectArrayList);
                break;
            }
            case 333: {
                this.collectAllUnconditionalCommands_SSNNDMH_16D(objectArrayList);
                break;
            }
            case 336: {
                this.collectAllUnconditionalCommands_SSNNDMHN_170(objectArrayList);
                break;
            }
            case 340: {
                this.collectAllUnconditionalCommands_SSNNDMHPML_174(objectArrayList);
                break;
            }
            case 341: {
                this.collectAllUnconditionalCommands_SSNNDMHPNLNCT_179(objectArrayList);
                break;
            }
            case 342: {
                this.collectAllUnconditionalCommands_SSNNDMHPLM_17A(objectArrayList);
                break;
            }
            case 344: {
                this.collectAllUnconditionalCommands_SSNNDMS_19A(objectArrayList);
                break;
            }
            case 345: {
                this.collectAllUnconditionalCommands_SSNNDMSN_19B(objectArrayList);
                break;
            }
            case 346: {
                this.collectAllUnconditionalCommands_SSNNDMS_19C(objectArrayList);
                break;
            }
            case 348: {
                this.collectAllUnconditionalCommands_SSNNDMSN_19E(objectArrayList);
                break;
            }
            case 350: {
                this.collectAllUnconditionalCommands_SSNNDMZ_1A0(objectArrayList);
                break;
            }
            case 352: {
                this.collectAllUnconditionalCommands_SSNNDMZN_1A2(objectArrayList);
                break;
            }
            case 354: {
                this.collectAllUnconditionalCommands_SSNNDO_1AA(objectArrayList);
                break;
            }
            case 357: {
                this.collectAllUnconditionalCommands_SSNNDON_1B3(objectArrayList);
                break;
            }
            case 361: {
                this.collectAllUnconditionalCommands_SSNOPEDDB_1BA(objectArrayList);
                break;
            }
            case 368: {
                this.collectAllUnconditionalCommands_SSNOPEPNL_1C1(objectArrayList);
                break;
            }
            case 371: {
                this.collectAllUnconditionalCommands_SSNOPEPLB_1C4(objectArrayList);
                break;
            }
            case 375: {
                this.collectAllUnconditionalCommands_SSNOPSD_1C8(objectArrayList);
                break;
            }
            case 389: {
                this.collectAllUnconditionalCommands_SSNOPSL_1D6(objectArrayList);
                break;
            }
            case 395: {
                this.collectAllUnconditionalCommands_SSNOPSMRD_1DC(objectArrayList);
                break;
            }
            case 399: {
                this.collectAllUnconditionalCommands_SSNOPSSRD_1E0(objectArrayList);
                break;
            }
            case 415: {
                this.collectAllUnconditionalCommands_SSNSUILNS_1F0(objectArrayList);
                break;
            }
            default: {
                super.collectAllUnconditionalCommands(objectArrayList);
            }
        }
    }

    private void collectAllUnconditionalCommands_SSNCEALB_80(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
    }

    private void collectAllUnconditionalCommands_SSNCECNL_82(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
    }

    private void collectAllUnconditionalCommands_SSNCEDDB_83(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
    }

    private void collectAllUnconditionalCommands_SSNCEDCLB_86(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
    }

    private void collectAllUnconditionalCommands_SSNDGCSGAA_90(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
    }

    private void collectAllUnconditionalCommands_SSNDGCSGSDM_93(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
    }

    private void collectAllUnconditionalCommands_SSNDGCSCSA_97(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
    }

    private void collectAllUnconditionalCommands_SSNDGCSCSF_98(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
    }

    private void collectAllUnconditionalCommands_SSNDGCSGNA_9D(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
    }

    private void collectAllUnconditionalCommands_SSNDGCSGSA_9E(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
        objectArrayList.add(this.createSingleCommand(4));
    }

    private void collectAllUnconditionalCommands_SSNDGCSGSAH_A0(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
        objectArrayList.add(this.createSingleCommand(4));
    }

    private void collectAllUnconditionalCommands_SSNDGNLC_113(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
        objectArrayList.add(this.createSingleCommand(4));
    }

    private void collectAllUnconditionalCommands_SSNDGNLC_114(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
        objectArrayList.add(this.createSingleCommand(4));
    }

    private void collectAllUnconditionalCommands_SSNDGNLC_116(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
        objectArrayList.add(this.createSingleCommand(4));
    }

    private void collectAllUnconditionalCommands_SSNDGNLC_117(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
        objectArrayList.add(this.createSingleCommand(4));
    }

    private void collectAllUnconditionalCommands_SSNDGNLC_118(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
        objectArrayList.add(this.createSingleCommand(4));
    }

    private void collectAllUnconditionalCommands_SSNDGC_119(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(5));
        objectArrayList.add(this.createSingleCommand(8));
        objectArrayList.add(this.createSingleCommand(9));
        objectArrayList.add(this.createSingleCommand(10));
        objectArrayList.add(this.createSingleCommand(11));
        objectArrayList.add(this.createSingleCommand(12));
        objectArrayList.add(this.createSingleCommand(13));
        objectArrayList.add(this.createSingleCommand(14));
        objectArrayList.add(this.createSingleCommand(15));
        objectArrayList.add(this.createSingleCommand(16));
        objectArrayList.add(this.createSingleCommand(17));
        objectArrayList.add(this.createSingleCommand(18));
        objectArrayList.add(this.createSingleCommand(19));
        objectArrayList.add(this.createSingleCommand(20));
        objectArrayList.add(this.createSingleCommand(21));
        objectArrayList.add(this.createSingleCommand(25));
        objectArrayList.add(this.createSingleCommand(26));
        objectArrayList.add(this.createSingleCommand(27));
        objectArrayList.add(this.createSingleCommand(28));
    }

    private void collectAllUnconditionalCommands_SSNDHC_11C(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(5));
        objectArrayList.add(this.createSingleCommand(8));
        objectArrayList.add(this.createSingleCommand(9));
        objectArrayList.add(this.createSingleCommand(10));
        objectArrayList.add(this.createSingleCommand(11));
        objectArrayList.add(this.createSingleCommand(12));
        objectArrayList.add(this.createSingleCommand(13));
        objectArrayList.add(this.createSingleCommand(14));
        objectArrayList.add(this.createSingleCommand(15));
        objectArrayList.add(this.createSingleCommand(16));
        objectArrayList.add(this.createSingleCommand(17));
        objectArrayList.add(this.createSingleCommand(18));
        objectArrayList.add(this.createSingleCommand(19));
        objectArrayList.add(this.createSingleCommand(20));
        objectArrayList.add(this.createSingleCommand(21));
        objectArrayList.add(this.createSingleCommand(24));
        objectArrayList.add(this.createSingleCommand(25));
        objectArrayList.add(this.createSingleCommand(26));
        objectArrayList.add(this.createSingleCommand(27));
        objectArrayList.add(this.createSingleCommand(28));
        objectArrayList.add(this.createSingleCommand(29));
        objectArrayList.add(this.createSingleCommand(30));
        objectArrayList.add(this.createSingleCommand(33));
        objectArrayList.add(this.createSingleCommand(34));
        objectArrayList.add(this.createSingleCommand(35));
        objectArrayList.add(this.createSingleCommand(36));
    }

    private void collectAllUnconditionalCommands_SSNDMPRCA_11E(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
    }

    private void collectAllUnconditionalCommands_SSNDMPSGA_121(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
    }

    private void collectAllUnconditionalCommands_SSNDMPWMA_124(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
    }

    private void collectAllUnconditionalCommands_SSNLDDDC_146(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
    }

    private void collectAllUnconditionalCommands_SSNLDELA_149(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
    }

    private void collectAllUnconditionalCommands_SSNLDELM_14A(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
        objectArrayList.add(this.createSingleCommand(4));
        objectArrayList.add(this.createSingleCommand(5));
    }

    private void collectAllUnconditionalCommands_SSNLDEL_14B(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
    }

    private void collectAllUnconditionalCommands_SSNLDENL_14C(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
    }

    private void collectAllUnconditionalCommands_SSNNDMC_15B(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
    }

    private void collectAllUnconditionalCommands_SSNNDMCN_15C(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
    }

    private void collectAllUnconditionalCommands_SSNNDMC_15E(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
    }

    private void collectAllUnconditionalCommands_SSNNDMCN_161(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
    }

    private void collectAllUnconditionalCommands_SSNNDMCSN_164(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
    }

    private void collectAllUnconditionalCommands_SSNNDMC_165(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
    }

    private void collectAllUnconditionalCommands_SSNNDMCN_167(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
    }

    private void collectAllUnconditionalCommands_SSNNDMDDV_16A(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
    }

    private void collectAllUnconditionalCommands_SSNNDMH_16D(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
    }

    private void collectAllUnconditionalCommands_SSNNDMHN_170(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
        objectArrayList.add(this.createSingleCommand(4));
        objectArrayList.add(this.createSingleCommand(5));
        objectArrayList.add(this.createSingleCommand(6));
    }

    private void collectAllUnconditionalCommands_SSNNDMHPML_174(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
    }

    private void collectAllUnconditionalCommands_SSNNDMHPNLNCT_179(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
        objectArrayList.add(this.createSingleCommand(4));
        objectArrayList.add(this.createSingleCommand(5));
    }

    private void collectAllUnconditionalCommands_SSNNDMHPLM_17A(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
        objectArrayList.add(this.createSingleCommand(4));
    }

    private void collectAllUnconditionalCommands_SSNNDMS_19A(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
    }

    private void collectAllUnconditionalCommands_SSNNDMSN_19B(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
    }

    private void collectAllUnconditionalCommands_SSNNDMS_19C(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
        objectArrayList.add(this.createSingleCommand(4));
    }

    private void collectAllUnconditionalCommands_SSNNDMSN_19E(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
    }

    private void collectAllUnconditionalCommands_SSNNDMZ_1A0(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
    }

    private void collectAllUnconditionalCommands_SSNNDMZN_1A2(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
    }

    private void collectAllUnconditionalCommands_SSNNDO_1AA(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
    }

    private void collectAllUnconditionalCommands_SSNNDON_1B3(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
    }

    private void collectAllUnconditionalCommands_SSNOPEDDB_1BA(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
        objectArrayList.add(this.createSingleCommand(4));
        objectArrayList.add(this.createSingleCommand(5));
    }

    private void collectAllUnconditionalCommands_SSNOPEPNL_1C1(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
    }

    private void collectAllUnconditionalCommands_SSNOPEPLB_1C4(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
        objectArrayList.add(this.createSingleCommand(4));
        objectArrayList.add(this.createSingleCommand(5));
    }

    private void collectAllUnconditionalCommands_SSNOPSD_1C8(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
    }

    private void collectAllUnconditionalCommands_SSNOPSL_1D6(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
        objectArrayList.add(this.createSingleCommand(4));
        objectArrayList.add(this.createSingleCommand(5));
    }

    private void collectAllUnconditionalCommands_SSNOPSMRD_1DC(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
        objectArrayList.add(this.createSingleCommand(4));
        objectArrayList.add(this.createSingleCommand(5));
    }

    private void collectAllUnconditionalCommands_SSNOPSSRD_1E0(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(3));
    }

    private void collectAllUnconditionalCommands_SSNSUILNS_1F0(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
    }

    @Override
    protected boolean evaluateCondition(int n) {
        switch (this.sdFeatColId) {
            case 121: {
                return this.evaluateCondition_SSNCAI_7D(n);
            }
            case 122: {
                return this.evaluateCondition_SSNCCS_7E(n);
            }
            case 123: {
                return this.evaluateCondition_SSNCCNLSNI_7F(n);
            }
            case 126: {
                return this.evaluateCondition_SSNCECNL_82(n);
            }
            case 127: {
                return this.evaluateCondition_SSNCEDDB_83(n);
            }
            case 128: {
                return this.evaluateCondition_SSNCEDDH_84(n);
            }
            case 129: {
                return this.evaluateCondition_SSNCEDCLA_85(n);
            }
            case 141: {
                return this.evaluateCondition_SSNDGCSGSDD_91(n);
            }
            case 142: {
                return this.evaluateCondition_SSNDGCSGSDD_92(n);
            }
            case 250: {
                return this.evaluateCondition_SSNDGNLC_113(n);
            }
            case 251: {
                return this.evaluateCondition_SSNDGNLC_114(n);
            }
            case 252: {
                return this.evaluateCondition_SSNDGNLC_116(n);
            }
            case 253: {
                return this.evaluateCondition_SSNDGNLC_117(n);
            }
            case 254: {
                return this.evaluateCondition_SSNDGNLC_118(n);
            }
            case 255: {
                return this.evaluateCondition_SSNDGC_119(n);
            }
            case 257: {
                return this.evaluateCondition_SSNDHC_11C(n);
            }
            case 278: {
                return this.evaluateCondition_SSNGM_131(n);
            }
            case 279: {
                return this.evaluateCondition_SSNGMA_132(n);
            }
            case 281: {
                return this.evaluateCondition_SSNGMH_135(n);
            }
            case 282: {
                return this.evaluateCondition_SSNGMLD_136(n);
            }
            case 283: {
                return this.evaluateCondition_SSNGMNC_137(n);
            }
            case 285: {
                return this.evaluateCondition_SSNGMOPS_139(n);
            }
            case 286: {
                return this.evaluateCondition_SSNGMPS_13A(n);
            }
            case 287: {
                return this.evaluateCondition_SSNGMR_13B(n);
            }
            case 289: {
                return this.evaluateCondition_SSNGNHFND_13D(n);
            }
            case 290: {
                return this.evaluateCondition_SSNGNHS_13E(n);
            }
            case 291: {
                return this.evaluateCondition_SSNGNMA_13F(n);
            }
            case 292: {
                return this.evaluateCondition_SSNGNMH_140(n);
            }
            case 293: {
                return this.evaluateCondition_SSNGNMLD_141(n);
            }
            case 294: {
                return this.evaluateCondition_SSNGNMNC_142(n);
            }
            case 295: {
                return this.evaluateCondition_SSNGNMOPS_143(n);
            }
            case 296: {
                return this.evaluateCondition_SSNGNMPS_144(n);
            }
            case 297: {
                return this.evaluateCondition_SSNGNMR_145(n);
            }
            case 314: {
                return this.evaluateCondition_SSNNDLN_159(n);
            }
            case 315: {
                return this.evaluateCondition_SSNNDLP_15A(n);
            }
            case 316: {
                return this.evaluateCondition_SSNNDMC_15B(n);
            }
            case 318: {
                return this.evaluateCondition_SSNNDMCPP_15D(n);
            }
            case 319: {
                return this.evaluateCondition_SSNNDMC_15E(n);
            }
            case 322: {
                return this.evaluateCondition_SSNNDMCPP_162(n);
            }
            case 323: {
                return this.evaluateCondition_SSNNDMCPP_163(n);
            }
            case 324: {
                return this.evaluateCondition_SSNNDMCSN_164(n);
            }
            case 325: {
                return this.evaluateCondition_SSNNDMC_165(n);
            }
            case 328: {
                return this.evaluateCondition_SSNNDMCNC_168(n);
            }
            case 329: {
                return this.evaluateCondition_SSNNDMCPP_169(n);
            }
            case 331: {
                return this.evaluateCondition_SSNNDMDDVE_16B(n);
            }
            case 333: {
                return this.evaluateCondition_SSNNDMH_16D(n);
            }
            case 334: {
                return this.evaluateCondition_SSNNDMHACNA_16E(n);
            }
            case 336: {
                return this.evaluateCondition_SSNNDMHN_170(n);
            }
            case 339: {
                return this.evaluateCondition_SSNNDMHNA_173(n);
            }
            case 340: {
                return this.evaluateCondition_SSNNDMHPML_174(n);
            }
            case 341: {
                return this.evaluateCondition_SSNNDMHPNLNCT_179(n);
            }
            case 343: {
                return this.evaluateCondition_SSNNDMSNAFC_199(n);
            }
            case 344: {
                return this.evaluateCondition_SSNNDMS_19A(n);
            }
            case 346: {
                return this.evaluateCondition_SSNNDMS_19C(n);
            }
            case 349: {
                return this.evaluateCondition_SSNNDMSPP_19F(n);
            }
            case 350: {
                return this.evaluateCondition_SSNNDMZ_1A0(n);
            }
            case 353: {
                return this.evaluateCondition_SSNNDMZPP_1A3(n);
            }
            case 354: {
                return this.evaluateCondition_SSNNDO_1AA(n);
            }
            case 358: {
                return this.evaluateCondition_SSNNDOPP_1B6(n);
            }
            case 359: {
                return this.evaluateCondition_SSNOPCSAR_1B8(n);
            }
            case 360: {
                return this.evaluateCondition_SSNOPCS_1B9(n);
            }
            case 363: {
                return this.evaluateCondition_SSNOPEDD_1BC(n);
            }
            case 364: {
                return this.evaluateCondition_SSNOPEDPLA_1BD(n);
            }
            case 365: {
                return this.evaluateCondition_SSNOPEDPLB_1BE(n);
            }
            case 366: {
                return this.evaluateCondition_SSNOPEDPL_1BF(n);
            }
            case 367: {
                return this.evaluateCondition_SSNOPEDPLSNR_1C0(n);
            }
            case 372: {
                return this.evaluateCondition_SSNOPEPL_1C5(n);
            }
            case 396: {
                return this.evaluateCondition_SSNOPSMRDE_1DD(n);
            }
            case 402: {
                return this.evaluateCondition_SSNRI_1E3(n);
            }
            case 403: {
                return this.evaluateCondition_SSNRID_1E4(n);
            }
            case 406: {
                return this.evaluateCondition_SSNRIE_1E7(n);
            }
            case 411: {
                return this.evaluateCondition_SSNRIR_1EC(n);
            }
            case 415: {
                return this.evaluateCondition_SSNSUILNS_1F0(n);
            }
            case 416: {
                return this.evaluateCondition_SSNSUIN_1F1(n);
            }
            case 417: {
                return this.evaluateCondition_SSNSUINIP_1F2(n);
            }
            case 418: {
                return this.evaluateCondition_SSNSUINW_1F3(n);
            }
        }
        return super.evaluateCondition(n);
    }

    private boolean evaluateCondition_SSNCAI_7D(int n) {
        switch (n) {
            case 0: {
                return this.getLicValue(1711813632, 3, 0, 0) == 1 || this.getLicValue(1711813632, 3, 0, 0) == 0;
            }
            case 1: {
                return this.getLicValue(1711813632, 3, 0, 0) == 2;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNCCS_7E(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(881983488);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNCCNLSNI_7F(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(29133) == 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNCECNL_82(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(29133) != 1;
            }
            case 1: {
                return this.getInteger(29133) == 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNCEDDB_83(int n) {
        switch (n) {
            case 0: {
                return this.getLicValue(1711813632, 3, 0, 0) == 1;
            }
            case 1: {
                return this.getLicValue(1711813632, 3, 0, 0) == 2;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNCEDDH_84(int n) {
        switch (n) {
            case 0: {
                return this.getLicValue(1711813632, 3, 0, 0) == 1;
            }
            case 1: {
                return this.getLicValue(1711813632, 3, 0, 0) == 2;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNCEDCLA_85(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(29133) == 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNDGCSGSDD_91(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(881983488);
            }
            case 1: {
                return !this.getLicValue(1544041472, 2, 0, "").equals("");
            }
            case 2: {
                return this.getLicValue(1544041472, 2, 0, "").equals("");
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNDGCSGSDD_92(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(881983488);
            }
            case 1: {
                return !this.getLicValue(1544041472, 2, 0, "").equals("");
            }
            case 2: {
                return this.getLicValue(1544041472, 2, 0, "").equals("");
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNDGNLC_113(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-457834496) != 7;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNDGNLC_114(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-457834496) != 7;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNDGNLC_116(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-457834496) != 7;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNDGNLC_117(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-457834496) != 7;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNDGNLC_118(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-457834496) != 7;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNDGC_119(int n) {
        switch (n) {
            case 0: {
                return !(this.getBoolean(0x7A00000) && this.getBoolean(10059)) && this.getInteger(29133) != 0;
            }
            case 1: {
                return !(this.getBoolean(0x7A00000) && this.getBoolean(10059)) && this.getInteger(29133) == 0;
            }
            case 2: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059) && !this.getBoolean(-626458624);
            }
            case 3: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059) && this.getBoolean(-626458624) && this.getInteger(29133) != 0;
            }
            case 4: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059) && this.getBoolean(-626458624) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 5: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059) && this.getBoolean(-626458624) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 6: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059) && this.getBoolean(19680);
            }
            case 7: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNDHC_11C(int n) {
        switch (n) {
            case 0: {
                return !(this.getBoolean(0x7A00000) && this.getBoolean(10059)) && this.getInteger(29133) != 0;
            }
            case 1: {
                return !(this.getBoolean(0x7A00000) && this.getBoolean(10059)) && this.getInteger(29133) == 0;
            }
            case 2: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059) && this.getBoolean(-626458624) && this.getInteger(29133) != 0;
            }
            case 3: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059) && this.getBoolean(-626458624) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 4: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059) && this.getBoolean(-626458624) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 5: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059) && this.getBoolean(19680);
            }
            case 6: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 7: {
                return !this.getBoolean(-626458624) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNGM_131(int n) {
        switch (n) {
            case 0: {
                return !(this.getBoolean(0x7A00000) && this.getBoolean(10059)) && !(this.getBoolean(0x7A00000) && this.getBoolean(10059));
            }
            case 1: {
                return !(this.getBoolean(0x7A00000) && this.getBoolean(10059)) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 2: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 3: {
                return !(this.getBoolean(0x7A00000) && this.getBoolean(10059));
            }
            case 4: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 5: {
                return !this.getBoolean(922091520);
            }
            case 6: {
                return this.getBoolean(922091520);
            }
            case 7: {
                return !this.getBoolean(67895552);
            }
            case 8: {
                return this.getBoolean(67895552);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNGMA_132(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(13543);
            }
            case 1: {
                return this.getBoolean(13543);
            }
            case 2: {
                return !this.getBoolean(67895552);
            }
            case 3: {
                return this.getBoolean(67895552);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNGMH_135(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(13543);
            }
            case 1: {
                return this.getBoolean(13543);
            }
            case 2: {
                return !this.getBoolean(67895552);
            }
            case 3: {
                return this.getBoolean(67895552);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNGMLD_136(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(13543);
            }
            case 1: {
                return this.getBoolean(13543);
            }
            case 2: {
                return !this.getBoolean(67895552);
            }
            case 3: {
                return this.getBoolean(67895552);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNGMNC_137(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(13543);
            }
            case 1: {
                return this.getBoolean(13543);
            }
            case 2: {
                return !this.getBoolean(67895552);
            }
            case 3: {
                return this.getBoolean(67895552);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNGMOPS_139(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(13543);
            }
            case 1: {
                return this.getBoolean(13543);
            }
            case 2: {
                return !this.getBoolean(67895552);
            }
            case 3: {
                return this.getBoolean(67895552);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNGMPS_13A(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(13543);
            }
            case 1: {
                return this.getBoolean(13543);
            }
            case 2: {
                return !this.getBoolean(67895552);
            }
            case 3: {
                return this.getBoolean(67895552);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNGMR_13B(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(13543);
            }
            case 1: {
                return this.getBoolean(13543);
            }
            case 2: {
                return !this.getBoolean(67895552);
            }
            case 3: {
                return this.getBoolean(67895552);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNGNHFND_13D(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(881983488);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNGNHS_13E(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(881983488);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNGNMA_13F(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(13543);
            }
            case 1: {
                return !this.getBoolean(13543);
            }
            case 2: {
                return this.getBoolean(13543);
            }
            case 3: {
                return !this.getBoolean(67895552);
            }
            case 4: {
                return this.getBoolean(67895552);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNGNMH_140(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(13543);
            }
            case 1: {
                return this.getBoolean(13543);
            }
            case 2: {
                return !this.getBoolean(67895552);
            }
            case 3: {
                return this.getBoolean(67895552);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNGNMLD_141(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(13543);
            }
            case 1: {
                return this.getBoolean(13543);
            }
            case 2: {
                return !this.getBoolean(67895552);
            }
            case 3: {
                return this.getBoolean(67895552);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNGNMNC_142(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(13543);
            }
            case 1: {
                return this.getBoolean(13543);
            }
            case 2: {
                return !this.getBoolean(67895552);
            }
            case 3: {
                return this.getBoolean(67895552);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNGNMOPS_143(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(13543);
            }
            case 1: {
                return this.getBoolean(13543);
            }
            case 2: {
                return !this.getBoolean(67895552);
            }
            case 3: {
                return this.getBoolean(67895552);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNGNMPS_144(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(13543);
            }
            case 1: {
                return this.getBoolean(13543);
            }
            case 2: {
                return !this.getBoolean(67895552);
            }
            case 3: {
                return this.getBoolean(67895552);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNGNMR_145(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(13543);
            }
            case 1: {
                return this.getBoolean(13543);
            }
            case 2: {
                return !this.getBoolean(67895552);
            }
            case 3: {
                return this.getBoolean(67895552);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNNDLN_159(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-457834496) != 4 && this.getInteger(-457834496) != 1 && this.getInteger(-457834496) != 2 && this.getInteger(-457834496) != 8 && this.getInteger(-457834496) != 3 && this.getInteger(-457834496) != 6 && this.getInteger(-457834496) != 5 || this.getInteger(-457834496) == 10;
            }
            case 1: {
                return this.getInteger(-457834496) == 1;
            }
            case 2: {
                return this.getInteger(-457834496) == 2;
            }
            case 3: {
                return this.getInteger(-457834496) == 3;
            }
            case 4: {
                return this.getInteger(-457834496) == 4;
            }
            case 5: {
                return this.getInteger(-457834496) == 5;
            }
            case 6: {
                return this.getInteger(-457834496) == 6;
            }
            case 7: {
                return this.getInteger(-457834496) == 8;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNNDLP_15A(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(-70909952) && (this.getInteger(-457834496) == 6 || this.getInteger(-457834496) == 8);
            }
            case 1: {
                return this.getInteger(-457834496) == 1 && this.getBoolean(-70909952);
            }
            case 2: {
                return this.getInteger(-457834496) == 10 && this.getLicValue(2064135168, 0, 0, 0) < 1 && this.getBoolean(-70909952);
            }
            case 3: {
                return this.getInteger(-457834496) == 10 && this.getLicValue(2064135168, 0, 0, 0) > 0 && this.getBoolean(-70909952);
            }
            case 4: {
                return this.getInteger(-457834496) == 2 && this.getBoolean(-70909952);
            }
            case 5: {
                return this.getInteger(-457834496) == 3 && this.getBoolean(-70909952);
            }
            case 6: {
                return this.getInteger(-457834496) == 4 && this.getBoolean(-70909952);
            }
            case 7: {
                return this.getInteger(-457834496) == 5 && this.getBoolean(-70909952);
            }
            case 8: {
                return this.getInteger(-457834496) == 7 && this.getBoolean(-70909952);
            }
            case 9: {
                return this.getBoolean(881983488);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNNDMC_15B(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(28043) != 1 && this.getInteger(28043) != 2;
            }
            case 1: {
                return this.getBoolean(881983488);
            }
            case 2: {
                return this.getInteger(28043) == 1;
            }
            case 3: {
                return this.getInteger(28043) == 2;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNNDMCPP_15D(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(881983488);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNNDMC_15E(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(28043) == 1;
            }
            case 1: {
                return this.getInteger(28043) == 2;
            }
            case 2: {
                return this.getBoolean(881983488);
            }
            case 3: {
                return this.getInteger(28043) != 1 && this.getInteger(28043) != 2;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNNDMCPP_162(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(881983488);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNNDMCPP_163(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(881983488);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNNDMCSN_164(int n) {
        switch (n) {
            case 0: {
                return !this.getLicValue(-2012728320, 4, 0, "").equals("");
            }
            case 1: {
                return this.getLicValue(-2012728320, 4, 0, "").equals("");
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNNDMC_165(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(28043) != 1 && this.getInteger(28043) != 2;
            }
            case 1: {
                return this.getBoolean(881983488);
            }
            case 2: {
                return this.getInteger(28043) == 1;
            }
            case 3: {
                return this.getInteger(28043) == 2;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNNDMCNC_168(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(881983488);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNNDMCPP_169(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(881983488);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNNDMDDVE_16B(int n) {
        switch (n) {
            case 0: {
                return !this.getLicValue(1560818688, 6, 0, "").equals("") && !this.getLicValue(1560818688, 6, 0, "").equals("") && !this.getLicValue(1560818688, 7, 0, "").equals("") && this.getLicValue(1560818688, 8, 0, "").equals("");
            }
            case 1: {
                return !this.getLicValue(1560818688, 6, 0, "").equals("") && !this.getLicValue(1560818688, 6, 0, "").equals("") && !this.getLicValue(1560818688, 8, 0, "").equals("") && this.getLicValue(1560818688, 7, 0, "").equals("");
            }
            case 2: {
                return !this.getLicValue(1560818688, 6, 0, "").equals("") && !this.getLicValue(1560818688, 6, 0, "").equals("") && this.getLicValue(1560818688, 8, 0, "").equals("") && this.getLicValue(1560818688, 7, 0, "").equals("");
            }
            case 3: {
                return this.getLicValue(1560818688, 6, 0, "").equals("") && !this.getLicValue(1560818688, 6, 0, "").equals("");
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNNDMH_16D(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(28043) != 1 && this.getInteger(28043) != 2;
            }
            case 1: {
                return !this.getBoolean(-1096876032);
            }
            case 2: {
                return this.getBoolean(-1096876032);
            }
            case 3: {
                return this.getBoolean(881983488);
            }
            case 4: {
                return this.getInteger(28043) == 1;
            }
            case 5: {
                return this.getInteger(28043) == 2;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNNDMHACNA_16E(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(881983488);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNNDMHN_170(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(-1096876032);
            }
            case 1: {
                return this.getBoolean(-1096876032);
            }
            case 2: {
                return !this.getBoolean(-1096876032);
            }
            case 3: {
                return this.getBoolean(-1096876032);
            }
            case 4: {
                return this.getBoolean(881983488);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNNDMHNA_173(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(881983488);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNNDMHPML_174(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(-1096876032);
            }
            case 1: {
                return this.getBoolean(-1096876032);
            }
            case 2: {
                return !this.getBoolean(-1096876032);
            }
            case 3: {
                return this.getBoolean(-1096876032);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNNDMHPNLNCT_179(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(-1096876032);
            }
            case 1: {
                return this.getBoolean(-1096876032);
            }
            case 2: {
                return this.getBoolean(881983488);
            }
            case 3: {
                return this.getBoolean(-1096876032);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNNDMSNAFC_199(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(881983488);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNNDMS_19A(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(28043) != 1 && this.getInteger(28043) != 2;
            }
            case 1: {
                return this.getInteger(28043) != 2;
            }
            case 2: {
                return this.getBoolean(881983488);
            }
            case 3: {
                return this.getInteger(28043) == 1;
            }
            case 4: {
                return this.getInteger(28043) == 2;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNNDMS_19C(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(28043) != 1 && this.getInteger(28043) != 2;
            }
            case 1: {
                return this.getInteger(29633) != 8;
            }
            case 2: {
                return this.getBoolean(881983488);
            }
            case 3: {
                return this.getInteger(29633) == 8;
            }
            case 4: {
                return this.getInteger(28043) == 1;
            }
            case 5: {
                return this.getInteger(28043) == 2;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNNDMSPP_19F(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(881983488);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNNDMZ_1A0(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(28043) != 1 && this.getInteger(28043) != 2;
            }
            case 1: {
                return this.getBoolean(881983488);
            }
            case 2: {
                return this.getInteger(28043) == 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNNDMZPP_1A3(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(881983488);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNNDO_1AA(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(28043) != 1 && this.getInteger(28043) != 2 && this.getBoolean(-525795328);
            }
            case 1: {
                return this.getInteger(28043) != 1 && !this.getBoolean(-525795328);
            }
            case 2: {
                return this.getInteger(28043) == 1 && !this.getBoolean(-525795328);
            }
            case 3: {
                return this.getInteger(28043) == 1 && this.getBoolean(-525795328);
            }
            case 4: {
                return this.getInteger(28043) == 2 && this.getBoolean(-525795328);
            }
            case 5: {
                return this.getBoolean(881983488);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNNDOPP_1B6(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(881983488);
            }
            case 1: {
                return !this.getLicValue(2097689600, 3, 0, "").equals("");
            }
            case 2: {
                return this.getLicValue(2097689600, 3, 0, "").equals("");
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNOPCSAR_1B8(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-1076166656) == 2 && !this.getBoolean(13351);
            }
            case 1: {
                return this.getInteger(-1076166656) == 2 && this.getBoolean(13351);
            }
            case 2: {
                return this.getInteger(-1076166656) == 1;
            }
            case 3: {
                return this.getInteger(-1076166656) == 3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNOPCS_1B9(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-1076166656) != this.getInteger(187105536);
            }
            case 1: {
                return this.getInteger(187105536) == 0 || this.getInteger(187105536) == 4;
            }
            case 2: {
                return this.getInteger(187105536) == 1;
            }
            case 3: {
                return this.getInteger(187105536) == 2;
            }
            case 4: {
                return this.getInteger(187105536) == 3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNOPEDD_1BC(int n) {
        switch (n) {
            case 0: {
                return this.getListItemControl(1879585792, true).getItemCount() == 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNOPEDPLA_1BD(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(13351);
            }
            case 1: {
                return this.getBoolean(13351);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNOPEDPLB_1BE(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(13351);
            }
            case 1: {
                return this.getBoolean(13351);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNOPEDPL_1BF(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(881983488);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNOPEDPLSNR_1C0(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(13351);
            }
            case 1: {
                return this.getBoolean(13351);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNOPEPL_1C5(int n) {
        switch (n) {
            case 0: {
                return this.getListItemControl(1879585792, true).getItemCount() > 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNOPSMRDE_1DD(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(1577124096);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNRI_1E3(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(-1123352320) && this.getInteger(435814400) == 0 && this.getLicValue(1527264256, 6, 0, 0) < 6039045;
            }
            case 1: {
                return !this.getBoolean(-1123352320) && this.getInteger(435814400) == 1 && this.getLicValue(1527264256, 6, 0, 0) < 6039045;
            }
            case 2: {
                return this.getBoolean(-1123352320) && this.getInteger(435814400) == 0 && this.getLicValue(1527264256, 6, 0, 0) < 6039045;
            }
            case 3: {
                return this.getBoolean(-1123352320) && this.getInteger(435814400) == 1 && this.getLicValue(1527264256, 6, 0, 0) < 6039045;
            }
            case 4: {
                return this.getLicValue(1527264256, 6, 0, 0) > -10803707 && !this.getBoolean(-1123352320);
            }
            case 5: {
                return this.getLicValue(1527264256, 6, 0, 0) > -10803707 && this.getBoolean(-1123352320);
            }
            case 6: {
                return !this.getBoolean(-1123352320);
            }
            case 7: {
                return this.getBoolean(-1123352320);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNRID_1E4(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(-1123352320);
            }
            case 1: {
                return this.getBoolean(-1123352320);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNRIE_1E7(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(-1123352320) && this.getInteger(435814400) == 0 && this.getLicValue(1527264256, 6, 0, 0) < 6039045;
            }
            case 1: {
                return !this.getBoolean(-1123352320) && this.getInteger(435814400) == 1 && this.getLicValue(1527264256, 6, 0, 0) < 6039045;
            }
            case 2: {
                return this.getBoolean(-1123352320) && this.getInteger(435814400) == 0 && this.getLicValue(1527264256, 6, 0, 0) < 6039045;
            }
            case 3: {
                return this.getBoolean(-1123352320) && this.getInteger(435814400) == 1 && this.getLicValue(1527264256, 6, 0, 0) < 6039045;
            }
            case 4: {
                return this.getLicValue(1527264256, 6, 0, 0) > -10803707 && !this.getBoolean(-1123352320);
            }
            case 5: {
                return this.getLicValue(1527264256, 6, 0, 0) > -10803707 && this.getBoolean(-1123352320);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNRIR_1EC(int n) {
        switch (n) {
            case 0: {
                return !this.getBoolean(-1123352320);
            }
            case 1: {
                return this.getBoolean(-1123352320);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNSUILNS_1F0(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNSUIN_1F1(int n) {
        switch (n) {
            case 0: {
                return this.getLicValue(-2146946048, 1, 0, 0) == 0;
            }
            case 1: {
                return this.getLicValue(-2146946048, 1, 0, 0) == 1;
            }
            case 2: {
                return this.getLicValue(-2146946048, 1, 0, 0) == 2;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNSUINIP_1F2(int n) {
        switch (n) {
            case 0: {
                return this.getLicValue(-2146946048, 0, 0, 0) < 1 && this.getLicValue(-2146946048, 1, 0, 0) == 0 && this.getBoolean(-70909952);
            }
            case 1: {
                return this.getLicValue(-2146946048, 0, 0, 0) < 1 && this.getLicValue(-2146946048, 1, 0, 0) == 1 && this.getBoolean(-70909952);
            }
            case 2: {
                return this.getLicValue(-2146946048, 0, 0, 0) < 1 && this.getLicValue(-2146946048, 1, 0, 0) == 2 && this.getBoolean(-70909952);
            }
            case 3: {
                return this.getLicValue(-2146946048, 0, 0, 0) > 0 && this.getLicValue(-2146946048, 1, 0, 0) == 0 && this.getBoolean(-70909952);
            }
            case 4: {
                return this.getLicValue(-2146946048, 0, 0, 0) > 0 && this.getLicValue(-2146946048, 1, 0, 0) == 1 && this.getBoolean(-70909952);
            }
            case 5: {
                return this.getLicValue(-2146946048, 0, 0, 0) > 0 && this.getLicValue(-2146946048, 1, 0, 0) == 2 && this.getBoolean(-70909952);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSNSUINW_1F3(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(881983488);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    @Override
    protected void collectAllCommandsGuardedByOneCondition(ObjectArrayList objectArrayList, int n) {
        switch (this.sdFeatColId) {
            case 121: {
                this.collectAllCommandsGuardedByOneCondition_SSNCAI_7D(objectArrayList, n);
                break;
            }
            case 122: {
                this.collectAllCommandsGuardedByOneCondition_SSNCCS_7E(objectArrayList, n);
                break;
            }
            case 123: {
                this.collectAllCommandsGuardedByOneCondition_SSNCCNLSNI_7F(objectArrayList, n);
                break;
            }
            case 126: {
                this.collectAllCommandsGuardedByOneCondition_SSNCECNL_82(objectArrayList, n);
                break;
            }
            case 127: {
                this.collectAllCommandsGuardedByOneCondition_SSNCEDDB_83(objectArrayList, n);
                break;
            }
            case 128: {
                this.collectAllCommandsGuardedByOneCondition_SSNCEDDH_84(objectArrayList, n);
                break;
            }
            case 129: {
                this.collectAllCommandsGuardedByOneCondition_SSNCEDCLA_85(objectArrayList, n);
                break;
            }
            case 141: {
                this.collectAllCommandsGuardedByOneCondition_SSNDGCSGSDD_91(objectArrayList, n);
                break;
            }
            case 142: {
                this.collectAllCommandsGuardedByOneCondition_SSNDGCSGSDD_92(objectArrayList, n);
                break;
            }
            case 250: {
                this.collectAllCommandsGuardedByOneCondition_SSNDGNLC_113(objectArrayList, n);
                break;
            }
            case 251: {
                this.collectAllCommandsGuardedByOneCondition_SSNDGNLC_114(objectArrayList, n);
                break;
            }
            case 252: {
                this.collectAllCommandsGuardedByOneCondition_SSNDGNLC_116(objectArrayList, n);
                break;
            }
            case 253: {
                this.collectAllCommandsGuardedByOneCondition_SSNDGNLC_117(objectArrayList, n);
                break;
            }
            case 254: {
                this.collectAllCommandsGuardedByOneCondition_SSNDGNLC_118(objectArrayList, n);
                break;
            }
            case 255: {
                this.collectAllCommandsGuardedByOneCondition_SSNDGC_119(objectArrayList, n);
                break;
            }
            case 257: {
                this.collectAllCommandsGuardedByOneCondition_SSNDHC_11C(objectArrayList, n);
                break;
            }
            case 278: {
                this.collectAllCommandsGuardedByOneCondition_SSNGM_131(objectArrayList, n);
                break;
            }
            case 279: {
                this.collectAllCommandsGuardedByOneCondition_SSNGMA_132(objectArrayList, n);
                break;
            }
            case 281: {
                this.collectAllCommandsGuardedByOneCondition_SSNGMH_135(objectArrayList, n);
                break;
            }
            case 282: {
                this.collectAllCommandsGuardedByOneCondition_SSNGMLD_136(objectArrayList, n);
                break;
            }
            case 283: {
                this.collectAllCommandsGuardedByOneCondition_SSNGMNC_137(objectArrayList, n);
                break;
            }
            case 285: {
                this.collectAllCommandsGuardedByOneCondition_SSNGMOPS_139(objectArrayList, n);
                break;
            }
            case 286: {
                this.collectAllCommandsGuardedByOneCondition_SSNGMPS_13A(objectArrayList, n);
                break;
            }
            case 287: {
                this.collectAllCommandsGuardedByOneCondition_SSNGMR_13B(objectArrayList, n);
                break;
            }
            case 289: {
                this.collectAllCommandsGuardedByOneCondition_SSNGNHFND_13D(objectArrayList, n);
                break;
            }
            case 290: {
                this.collectAllCommandsGuardedByOneCondition_SSNGNHS_13E(objectArrayList, n);
                break;
            }
            case 291: {
                this.collectAllCommandsGuardedByOneCondition_SSNGNMA_13F(objectArrayList, n);
                break;
            }
            case 292: {
                this.collectAllCommandsGuardedByOneCondition_SSNGNMH_140(objectArrayList, n);
                break;
            }
            case 293: {
                this.collectAllCommandsGuardedByOneCondition_SSNGNMLD_141(objectArrayList, n);
                break;
            }
            case 294: {
                this.collectAllCommandsGuardedByOneCondition_SSNGNMNC_142(objectArrayList, n);
                break;
            }
            case 295: {
                this.collectAllCommandsGuardedByOneCondition_SSNGNMOPS_143(objectArrayList, n);
                break;
            }
            case 296: {
                this.collectAllCommandsGuardedByOneCondition_SSNGNMPS_144(objectArrayList, n);
                break;
            }
            case 297: {
                this.collectAllCommandsGuardedByOneCondition_SSNGNMR_145(objectArrayList, n);
                break;
            }
            case 314: {
                this.collectAllCommandsGuardedByOneCondition_SSNNDLN_159(objectArrayList, n);
                break;
            }
            case 315: {
                this.collectAllCommandsGuardedByOneCondition_SSNNDLP_15A(objectArrayList, n);
                break;
            }
            case 316: {
                this.collectAllCommandsGuardedByOneCondition_SSNNDMC_15B(objectArrayList, n);
                break;
            }
            case 318: {
                this.collectAllCommandsGuardedByOneCondition_SSNNDMCPP_15D(objectArrayList, n);
                break;
            }
            case 319: {
                this.collectAllCommandsGuardedByOneCondition_SSNNDMC_15E(objectArrayList, n);
                break;
            }
            case 322: {
                this.collectAllCommandsGuardedByOneCondition_SSNNDMCPP_162(objectArrayList, n);
                break;
            }
            case 323: {
                this.collectAllCommandsGuardedByOneCondition_SSNNDMCPP_163(objectArrayList, n);
                break;
            }
            case 324: {
                this.collectAllCommandsGuardedByOneCondition_SSNNDMCSN_164(objectArrayList, n);
                break;
            }
            case 325: {
                this.collectAllCommandsGuardedByOneCondition_SSNNDMC_165(objectArrayList, n);
                break;
            }
            case 328: {
                this.collectAllCommandsGuardedByOneCondition_SSNNDMCNC_168(objectArrayList, n);
                break;
            }
            case 329: {
                this.collectAllCommandsGuardedByOneCondition_SSNNDMCPP_169(objectArrayList, n);
                break;
            }
            case 331: {
                this.collectAllCommandsGuardedByOneCondition_SSNNDMDDVE_16B(objectArrayList, n);
                break;
            }
            case 333: {
                this.collectAllCommandsGuardedByOneCondition_SSNNDMH_16D(objectArrayList, n);
                break;
            }
            case 334: {
                this.collectAllCommandsGuardedByOneCondition_SSNNDMHACNA_16E(objectArrayList, n);
                break;
            }
            case 336: {
                this.collectAllCommandsGuardedByOneCondition_SSNNDMHN_170(objectArrayList, n);
                break;
            }
            case 339: {
                this.collectAllCommandsGuardedByOneCondition_SSNNDMHNA_173(objectArrayList, n);
                break;
            }
            case 340: {
                this.collectAllCommandsGuardedByOneCondition_SSNNDMHPML_174(objectArrayList, n);
                break;
            }
            case 341: {
                this.collectAllCommandsGuardedByOneCondition_SSNNDMHPNLNCT_179(objectArrayList, n);
                break;
            }
            case 343: {
                this.collectAllCommandsGuardedByOneCondition_SSNNDMSNAFC_199(objectArrayList, n);
                break;
            }
            case 344: {
                this.collectAllCommandsGuardedByOneCondition_SSNNDMS_19A(objectArrayList, n);
                break;
            }
            case 346: {
                this.collectAllCommandsGuardedByOneCondition_SSNNDMS_19C(objectArrayList, n);
                break;
            }
            case 349: {
                this.collectAllCommandsGuardedByOneCondition_SSNNDMSPP_19F(objectArrayList, n);
                break;
            }
            case 350: {
                this.collectAllCommandsGuardedByOneCondition_SSNNDMZ_1A0(objectArrayList, n);
                break;
            }
            case 353: {
                this.collectAllCommandsGuardedByOneCondition_SSNNDMZPP_1A3(objectArrayList, n);
                break;
            }
            case 354: {
                this.collectAllCommandsGuardedByOneCondition_SSNNDO_1AA(objectArrayList, n);
                break;
            }
            case 358: {
                this.collectAllCommandsGuardedByOneCondition_SSNNDOPP_1B6(objectArrayList, n);
                break;
            }
            case 359: {
                this.collectAllCommandsGuardedByOneCondition_SSNOPCSAR_1B8(objectArrayList, n);
                break;
            }
            case 360: {
                this.collectAllCommandsGuardedByOneCondition_SSNOPCS_1B9(objectArrayList, n);
                break;
            }
            case 363: {
                this.collectAllCommandsGuardedByOneCondition_SSNOPEDD_1BC(objectArrayList, n);
                break;
            }
            case 364: {
                this.collectAllCommandsGuardedByOneCondition_SSNOPEDPLA_1BD(objectArrayList, n);
                break;
            }
            case 365: {
                this.collectAllCommandsGuardedByOneCondition_SSNOPEDPLB_1BE(objectArrayList, n);
                break;
            }
            case 366: {
                this.collectAllCommandsGuardedByOneCondition_SSNOPEDPL_1BF(objectArrayList, n);
                break;
            }
            case 367: {
                this.collectAllCommandsGuardedByOneCondition_SSNOPEDPLSNR_1C0(objectArrayList, n);
                break;
            }
            case 372: {
                this.collectAllCommandsGuardedByOneCondition_SSNOPEPL_1C5(objectArrayList, n);
                break;
            }
            case 396: {
                this.collectAllCommandsGuardedByOneCondition_SSNOPSMRDE_1DD(objectArrayList, n);
                break;
            }
            case 402: {
                this.collectAllCommandsGuardedByOneCondition_SSNRI_1E3(objectArrayList, n);
                break;
            }
            case 403: {
                this.collectAllCommandsGuardedByOneCondition_SSNRID_1E4(objectArrayList, n);
                break;
            }
            case 406: {
                this.collectAllCommandsGuardedByOneCondition_SSNRIE_1E7(objectArrayList, n);
                break;
            }
            case 411: {
                this.collectAllCommandsGuardedByOneCondition_SSNRIR_1EC(objectArrayList, n);
                break;
            }
            case 415: {
                this.collectAllCommandsGuardedByOneCondition_SSNSUILNS_1F0(objectArrayList, n);
                break;
            }
            case 416: {
                this.collectAllCommandsGuardedByOneCondition_SSNSUIN_1F1(objectArrayList, n);
                break;
            }
            case 417: {
                this.collectAllCommandsGuardedByOneCondition_SSNSUINIP_1F2(objectArrayList, n);
                break;
            }
            case 418: {
                this.collectAllCommandsGuardedByOneCondition_SSNSUINW_1F3(objectArrayList, n);
                break;
            }
            default: {
                super.collectAllCommandsGuardedByOneCondition(objectArrayList, n);
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSNCAI_7D(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNCCS_7E(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSNCCNLSNI_7F(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSNCECNL_82(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNCEDDB_83(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNCEDDH_84(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNCEDCLA_85(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSNDGCSGSDD_91(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNDGCSGSDD_92(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNDGNLC_113(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                objectArrayList.add(this.createSingleCommand(5));
                objectArrayList.add(this.createSingleCommand(6));
                objectArrayList.add(this.createSingleCommand(7));
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSNDGNLC_114(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                objectArrayList.add(this.createSingleCommand(5));
                objectArrayList.add(this.createSingleCommand(6));
                objectArrayList.add(this.createSingleCommand(7));
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSNDGNLC_116(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                objectArrayList.add(this.createSingleCommand(5));
                objectArrayList.add(this.createSingleCommand(6));
                objectArrayList.add(this.createSingleCommand(7));
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSNDGNLC_117(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                objectArrayList.add(this.createSingleCommand(5));
                objectArrayList.add(this.createSingleCommand(6));
                objectArrayList.add(this.createSingleCommand(7));
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSNDGNLC_118(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                objectArrayList.add(this.createSingleCommand(5));
                objectArrayList.add(this.createSingleCommand(6));
                objectArrayList.add(this.createSingleCommand(7));
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSNDGC_119(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                objectArrayList.add(this.createSingleCommand(6));
                break;
            }
            case 1: {
                objectArrayList.add(this.createSingleCommand(7));
                break;
            }
            case 2: {
                objectArrayList.add(this.createSingleCommand(3));
                break;
            }
            case 3: {
                objectArrayList.add(this.createSingleCommand(2));
                break;
            }
            case 4: {
                objectArrayList.add(this.createSingleCommand(1));
                break;
            }
            case 5: {
                objectArrayList.add(this.createSingleCommand(4));
                break;
            }
            case 6: {
                objectArrayList.add(this.createSingleCommand(23));
                objectArrayList.add(this.createSingleCommand(24));
                break;
            }
            case 7: {
                objectArrayList.add(this.createSingleCommand(22));
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSNDHC_11C(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                objectArrayList.add(this.createSingleCommand(6));
                break;
            }
            case 1: {
                objectArrayList.add(this.createSingleCommand(7));
                break;
            }
            case 2: {
                objectArrayList.add(this.createSingleCommand(2));
                break;
            }
            case 3: {
                objectArrayList.add(this.createSingleCommand(1));
                break;
            }
            case 4: {
                objectArrayList.add(this.createSingleCommand(4));
                break;
            }
            case 5: {
                objectArrayList.add(this.createSingleCommand(22));
                objectArrayList.add(this.createSingleCommand(31));
                objectArrayList.add(this.createSingleCommand(32));
                break;
            }
            case 6: {
                objectArrayList.add(this.createSingleCommand(23));
                break;
            }
            case 7: {
                objectArrayList.add(this.createSingleCommand(3));
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSNGM_131(ObjectArrayList objectArrayList, int n) {
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
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSNGMA_132(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNGMH_135(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNGMLD_136(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNGMNC_137(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNGMOPS_139(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNGMPS_13A(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNGMR_13B(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNGNHFND_13D(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSNGNHS_13E(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSNGNMA_13F(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNGNMH_140(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNGNMLD_141(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNGNMNC_142(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNGNMOPS_143(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNGNMPS_144(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNGNMR_145(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNNDLN_159(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNNDLP_15A(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNNDMC_15B(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNNDMCPP_15D(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSNNDMC_15E(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNNDMCPP_162(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSNNDMCPP_163(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSNNDMCSN_164(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNNDMC_165(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNNDMCNC_168(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSNNDMCPP_169(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSNNDMDDVE_16B(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNNDMH_16D(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNNDMHACNA_16E(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSNNDMHN_170(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNNDMHNA_173(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSNNDMHPML_174(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNNDMHPNLNCT_179(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNNDMSNAFC_199(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSNNDMS_19A(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNNDMS_19C(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNNDMSPP_19F(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSNNDMZ_1A0(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNNDMZPP_1A3(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSNNDO_1AA(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNNDOPP_1B6(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNOPCSAR_1B8(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNOPCS_1B9(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNOPEDD_1BC(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSNOPEDPLA_1BD(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNOPEDPLB_1BE(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                objectArrayList.add(this.createSingleCommand(1));
                break;
            }
            case 1: {
                objectArrayList.add(this.createSingleCommand(0));
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSNOPEDPL_1BF(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSNOPEDPLSNR_1C0(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNOPEPL_1C5(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSNOPSMRDE_1DD(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSNRI_1E3(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNRID_1E4(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNRIE_1E7(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNRIR_1EC(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNSUILNS_1F0(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                objectArrayList.add(this.createSingleCommand(2));
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSNSUIN_1F1(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNSUINIP_1F2(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSNSUINW_1F3(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
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
            case 121: {
                return this.getAffectedFeatures_SSNCAI_7D(n);
            }
            case 122: {
                return this.getAffectedFeatures_SSNCCS_7E(n);
            }
            case 123: {
                return this.getAffectedFeatures_SSNCCNLSNI_7F(n);
            }
            case 126: {
                return this.getAffectedFeatures_SSNCECNL_82(n);
            }
            case 127: {
                return this.getAffectedFeatures_SSNCEDDB_83(n);
            }
            case 128: {
                return this.getAffectedFeatures_SSNCEDDH_84(n);
            }
            case 129: {
                return this.getAffectedFeatures_SSNCEDCLA_85(n);
            }
            case 141: {
                return this.getAffectedFeatures_SSNDGCSGSDD_91(n);
            }
            case 142: {
                return this.getAffectedFeatures_SSNDGCSGSDD_92(n);
            }
            case 250: {
                return this.getAffectedFeatures_SSNDGNLC_113(n);
            }
            case 251: {
                return this.getAffectedFeatures_SSNDGNLC_114(n);
            }
            case 252: {
                return this.getAffectedFeatures_SSNDGNLC_116(n);
            }
            case 253: {
                return this.getAffectedFeatures_SSNDGNLC_117(n);
            }
            case 254: {
                return this.getAffectedFeatures_SSNDGNLC_118(n);
            }
            case 255: {
                return this.getAffectedFeatures_SSNDGC_119(n);
            }
            case 257: {
                return this.getAffectedFeatures_SSNDHC_11C(n);
            }
            case 278: {
                return this.getAffectedFeatures_SSNGM_131(n);
            }
            case 279: {
                return this.getAffectedFeatures_SSNGMA_132(n);
            }
            case 281: {
                return this.getAffectedFeatures_SSNGMH_135(n);
            }
            case 282: {
                return this.getAffectedFeatures_SSNGMLD_136(n);
            }
            case 283: {
                return this.getAffectedFeatures_SSNGMNC_137(n);
            }
            case 285: {
                return this.getAffectedFeatures_SSNGMOPS_139(n);
            }
            case 286: {
                return this.getAffectedFeatures_SSNGMPS_13A(n);
            }
            case 287: {
                return this.getAffectedFeatures_SSNGMR_13B(n);
            }
            case 289: {
                return this.getAffectedFeatures_SSNGNHFND_13D(n);
            }
            case 290: {
                return this.getAffectedFeatures_SSNGNHS_13E(n);
            }
            case 291: {
                return this.getAffectedFeatures_SSNGNMA_13F(n);
            }
            case 292: {
                return this.getAffectedFeatures_SSNGNMH_140(n);
            }
            case 293: {
                return this.getAffectedFeatures_SSNGNMLD_141(n);
            }
            case 294: {
                return this.getAffectedFeatures_SSNGNMNC_142(n);
            }
            case 295: {
                return this.getAffectedFeatures_SSNGNMOPS_143(n);
            }
            case 296: {
                return this.getAffectedFeatures_SSNGNMPS_144(n);
            }
            case 297: {
                return this.getAffectedFeatures_SSNGNMR_145(n);
            }
            case 314: {
                return this.getAffectedFeatures_SSNNDLN_159(n);
            }
            case 315: {
                return this.getAffectedFeatures_SSNNDLP_15A(n);
            }
            case 316: {
                return this.getAffectedFeatures_SSNNDMC_15B(n);
            }
            case 318: {
                return this.getAffectedFeatures_SSNNDMCPP_15D(n);
            }
            case 319: {
                return this.getAffectedFeatures_SSNNDMC_15E(n);
            }
            case 322: {
                return this.getAffectedFeatures_SSNNDMCPP_162(n);
            }
            case 323: {
                return this.getAffectedFeatures_SSNNDMCPP_163(n);
            }
            case 324: {
                return this.getAffectedFeatures_SSNNDMCSN_164(n);
            }
            case 325: {
                return this.getAffectedFeatures_SSNNDMC_165(n);
            }
            case 328: {
                return this.getAffectedFeatures_SSNNDMCNC_168(n);
            }
            case 329: {
                return this.getAffectedFeatures_SSNNDMCPP_169(n);
            }
            case 331: {
                return this.getAffectedFeatures_SSNNDMDDVE_16B(n);
            }
            case 333: {
                return this.getAffectedFeatures_SSNNDMH_16D(n);
            }
            case 334: {
                return this.getAffectedFeatures_SSNNDMHACNA_16E(n);
            }
            case 336: {
                return this.getAffectedFeatures_SSNNDMHN_170(n);
            }
            case 339: {
                return this.getAffectedFeatures_SSNNDMHNA_173(n);
            }
            case 340: {
                return this.getAffectedFeatures_SSNNDMHPML_174(n);
            }
            case 341: {
                return this.getAffectedFeatures_SSNNDMHPNLNCT_179(n);
            }
            case 343: {
                return this.getAffectedFeatures_SSNNDMSNAFC_199(n);
            }
            case 344: {
                return this.getAffectedFeatures_SSNNDMS_19A(n);
            }
            case 346: {
                return this.getAffectedFeatures_SSNNDMS_19C(n);
            }
            case 349: {
                return this.getAffectedFeatures_SSNNDMSPP_19F(n);
            }
            case 350: {
                return this.getAffectedFeatures_SSNNDMZ_1A0(n);
            }
            case 353: {
                return this.getAffectedFeatures_SSNNDMZPP_1A3(n);
            }
            case 354: {
                return this.getAffectedFeatures_SSNNDO_1AA(n);
            }
            case 358: {
                return this.getAffectedFeatures_SSNNDOPP_1B6(n);
            }
            case 359: {
                return this.getAffectedFeatures_SSNOPCSAR_1B8(n);
            }
            case 360: {
                return this.getAffectedFeatures_SSNOPCS_1B9(n);
            }
            case 363: {
                return this.getAffectedFeatures_SSNOPEDD_1BC(n);
            }
            case 364: {
                return this.getAffectedFeatures_SSNOPEDPLA_1BD(n);
            }
            case 365: {
                return this.getAffectedFeatures_SSNOPEDPLB_1BE(n);
            }
            case 366: {
                return this.getAffectedFeatures_SSNOPEDPL_1BF(n);
            }
            case 367: {
                return this.getAffectedFeatures_SSNOPEDPLSNR_1C0(n);
            }
            case 372: {
                return this.getAffectedFeatures_SSNOPEPL_1C5(n);
            }
            case 396: {
                return this.getAffectedFeatures_SSNOPSMRDE_1DD(n);
            }
            case 402: {
                return this.getAffectedFeatures_SSNRI_1E3(n);
            }
            case 403: {
                return this.getAffectedFeatures_SSNRID_1E4(n);
            }
            case 406: {
                return this.getAffectedFeatures_SSNRIE_1E7(n);
            }
            case 411: {
                return this.getAffectedFeatures_SSNRIR_1EC(n);
            }
            case 415: {
                return this.getAffectedFeatures_SSNSUILNS_1F0(n);
            }
            case 416: {
                return this.getAffectedFeatures_SSNSUIN_1F1(n);
            }
            case 417: {
                return this.getAffectedFeatures_SSNSUINIP_1F2(n);
            }
            case 418: {
                return this.getAffectedFeatures_SSNSUINW_1F3(n);
            }
        }
        return super.getAffectedFeatures(n);
    }

    private int[] getAffectedFeatures_SSNCAI_7D(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNCCS_7E(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNCCNLSNI_7F(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNCECNL_82(int n) {
        switch (n) {
            case 0: {
                return SSNCECNL_82_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSNCECNL_82_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNCEDDB_83(int n) {
        switch (n) {
            case 0: {
                return SSNCEDDB_83_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSNCEDDB_83_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNCEDDH_84(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNCEDCLA_85(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNDGCSGSDD_91(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNDGCSGSDD_92(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNDGNLC_113(int n) {
        switch (n) {
            case 0: {
                return SSNDGNLC_113_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNDGNLC_114(int n) {
        switch (n) {
            case 0: {
                return SSNDGNLC_114_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNDGNLC_116(int n) {
        switch (n) {
            case 0: {
                return SSNDGNLC_116_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNDGNLC_117(int n) {
        switch (n) {
            case 0: {
                return SSNDGNLC_117_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNDGNLC_118(int n) {
        switch (n) {
            case 0: {
                return SSNDGNLC_118_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNDGC_119(int n) {
        switch (n) {
            case 0: {
                return SSNDGC_119_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSNDGC_119_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 2: {
                return SSNDGC_119_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSNDGC_119_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
            case 4: {
                return SSNDGC_119_AFFECTED_FEATURES_FOR_CONDITION_4;
            }
            case 5: {
                return SSNDGC_119_AFFECTED_FEATURES_FOR_CONDITION_5;
            }
            case 6: {
                return SSNDGC_119_AFFECTED_FEATURES_FOR_CONDITION_6;
            }
            case 7: {
                return SSNDGC_119_AFFECTED_FEATURES_FOR_CONDITION_7;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNDHC_11C(int n) {
        switch (n) {
            case 0: {
                return SSNDHC_11C_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSNDHC_11C_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 2: {
                return SSNDHC_11C_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSNDHC_11C_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
            case 4: {
                return SSNDHC_11C_AFFECTED_FEATURES_FOR_CONDITION_4;
            }
            case 5: {
                return SSNDHC_11C_AFFECTED_FEATURES_FOR_CONDITION_5;
            }
            case 6: {
                return SSNDHC_11C_AFFECTED_FEATURES_FOR_CONDITION_6;
            }
            case 7: {
                return SSNDHC_11C_AFFECTED_FEATURES_FOR_CONDITION_7;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNGM_131(int n) {
        switch (n) {
            case 0: {
                return SSNGM_131_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSNGM_131_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 2: {
                return SSNGM_131_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSNGM_131_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
            case 4: {
                return SSNGM_131_AFFECTED_FEATURES_FOR_CONDITION_4;
            }
            case 7: {
                return SSNGM_131_AFFECTED_FEATURES_FOR_CONDITION_7;
            }
            case 8: {
                return SSNGM_131_AFFECTED_FEATURES_FOR_CONDITION_8;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNGMA_132(int n) {
        switch (n) {
            case 2: {
                return SSNGMA_132_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSNGMA_132_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNGMH_135(int n) {
        switch (n) {
            case 2: {
                return SSNGMH_135_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSNGMH_135_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNGMLD_136(int n) {
        switch (n) {
            case 2: {
                return SSNGMLD_136_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSNGMLD_136_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNGMNC_137(int n) {
        switch (n) {
            case 2: {
                return SSNGMNC_137_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSNGMNC_137_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNGMOPS_139(int n) {
        switch (n) {
            case 2: {
                return SSNGMOPS_139_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSNGMOPS_139_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNGMPS_13A(int n) {
        switch (n) {
            case 2: {
                return SSNGMPS_13A_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSNGMPS_13A_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNGMR_13B(int n) {
        switch (n) {
            case 2: {
                return SSNGMR_13B_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSNGMR_13B_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNGNHFND_13D(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNGNHS_13E(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNGNMA_13F(int n) {
        switch (n) {
            case 3: {
                return SSNGNMA_13F_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
            case 4: {
                return SSNGNMA_13F_AFFECTED_FEATURES_FOR_CONDITION_4;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNGNMH_140(int n) {
        switch (n) {
            case 2: {
                return SSNGNMH_140_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSNGNMH_140_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNGNMLD_141(int n) {
        switch (n) {
            case 2: {
                return SSNGNMLD_141_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSNGNMLD_141_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNGNMNC_142(int n) {
        switch (n) {
            case 2: {
                return SSNGNMNC_142_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSNGNMNC_142_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNGNMOPS_143(int n) {
        switch (n) {
            case 2: {
                return SSNGNMOPS_143_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSNGNMOPS_143_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNGNMPS_144(int n) {
        switch (n) {
            case 2: {
                return SSNGNMPS_144_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSNGNMPS_144_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNGNMR_145(int n) {
        switch (n) {
            case 2: {
                return SSNGNMR_145_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSNGNMR_145_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNNDLN_159(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNNDLP_15A(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNNDMC_15B(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNNDMCPP_15D(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNNDMC_15E(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNNDMCPP_162(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNNDMCPP_163(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNNDMCSN_164(int n) {
        switch (n) {
            case 0: {
                return SSNNDMCSN_164_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSNNDMCSN_164_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNNDMC_165(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNNDMCNC_168(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNNDMCPP_169(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNNDMDDVE_16B(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNNDMH_16D(int n) {
        switch (n) {
            case 1: {
                return SSNNDMH_16D_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 2: {
                return SSNNDMH_16D_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNNDMHACNA_16E(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNNDMHN_170(int n) {
        switch (n) {
            case 0: {
                return SSNNDMHN_170_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSNNDMHN_170_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 2: {
                return SSNNDMHN_170_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSNNDMHN_170_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNNDMHNA_173(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNNDMHPML_174(int n) {
        switch (n) {
            case 0: {
                return SSNNDMHPML_174_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSNNDMHPML_174_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 2: {
                return SSNNDMHPML_174_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSNNDMHPML_174_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNNDMHPNLNCT_179(int n) {
        switch (n) {
            case 0: {
                return SSNNDMHPNLNCT_179_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSNNDMHPNLNCT_179_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 3: {
                return SSNNDMHPNLNCT_179_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNNDMSNAFC_199(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNNDMS_19A(int n) {
        switch (n) {
            case 1: {
                return SSNNDMS_19A_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 4: {
                return SSNNDMS_19A_AFFECTED_FEATURES_FOR_CONDITION_4;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNNDMS_19C(int n) {
        switch (n) {
            case 1: {
                return SSNNDMS_19C_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 3: {
                return SSNNDMS_19C_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNNDMSPP_19F(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNNDMZ_1A0(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNNDMZPP_1A3(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNNDO_1AA(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNNDOPP_1B6(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNOPCSAR_1B8(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNOPCS_1B9(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNOPEDD_1BC(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNOPEDPLA_1BD(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNOPEDPLB_1BE(int n) {
        switch (n) {
            case 0: {
                return SSNOPEDPLB_1BE_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSNOPEDPLB_1BE_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNOPEDPL_1BF(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNOPEDPLSNR_1C0(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNOPEPL_1C5(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNOPSMRDE_1DD(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNRI_1E3(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNRID_1E4(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNRIE_1E7(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNRIR_1EC(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNSUILNS_1F0(int n) {
        switch (n) {
            case 0: {
                return SSNSUILNS_1F0_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNSUIN_1F1(int n) {
        switch (n) {
            case 0: {
                return SSNSUIN_1F1_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSNSUIN_1F1_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 2: {
                return SSNSUIN_1F1_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNSUINIP_1F2(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSNSUINW_1F3(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    @Override
    protected int[] getConditionsAffectedByProperty(int n) {
        switch (this.sdFeatColId) {
            case 126: {
                return this.getConditionsAffectedByProperty_SSNCECNL_82(n);
            }
            case 127: {
                return this.getConditionsAffectedByProperty_SSNCEDDB_83(n);
            }
            case 250: {
                return this.getConditionsAffectedByProperty_SSNDGNLC_113(n);
            }
            case 251: {
                return this.getConditionsAffectedByProperty_SSNDGNLC_114(n);
            }
            case 252: {
                return this.getConditionsAffectedByProperty_SSNDGNLC_116(n);
            }
            case 253: {
                return this.getConditionsAffectedByProperty_SSNDGNLC_117(n);
            }
            case 254: {
                return this.getConditionsAffectedByProperty_SSNDGNLC_118(n);
            }
            case 255: {
                return this.getConditionsAffectedByProperty_SSNDGC_119(n);
            }
            case 257: {
                return this.getConditionsAffectedByProperty_SSNDHC_11C(n);
            }
            case 278: {
                return this.getConditionsAffectedByProperty_SSNGM_131(n);
            }
            case 279: {
                return this.getConditionsAffectedByProperty_SSNGMA_132(n);
            }
            case 281: {
                return this.getConditionsAffectedByProperty_SSNGMH_135(n);
            }
            case 282: {
                return this.getConditionsAffectedByProperty_SSNGMLD_136(n);
            }
            case 283: {
                return this.getConditionsAffectedByProperty_SSNGMNC_137(n);
            }
            case 285: {
                return this.getConditionsAffectedByProperty_SSNGMOPS_139(n);
            }
            case 286: {
                return this.getConditionsAffectedByProperty_SSNGMPS_13A(n);
            }
            case 287: {
                return this.getConditionsAffectedByProperty_SSNGMR_13B(n);
            }
            case 291: {
                return this.getConditionsAffectedByProperty_SSNGNMA_13F(n);
            }
            case 292: {
                return this.getConditionsAffectedByProperty_SSNGNMH_140(n);
            }
            case 293: {
                return this.getConditionsAffectedByProperty_SSNGNMLD_141(n);
            }
            case 294: {
                return this.getConditionsAffectedByProperty_SSNGNMNC_142(n);
            }
            case 295: {
                return this.getConditionsAffectedByProperty_SSNGNMOPS_143(n);
            }
            case 296: {
                return this.getConditionsAffectedByProperty_SSNGNMPS_144(n);
            }
            case 297: {
                return this.getConditionsAffectedByProperty_SSNGNMR_145(n);
            }
            case 333: {
                return this.getConditionsAffectedByProperty_SSNNDMH_16D(n);
            }
            case 336: {
                return this.getConditionsAffectedByProperty_SSNNDMHN_170(n);
            }
            case 340: {
                return this.getConditionsAffectedByProperty_SSNNDMHPML_174(n);
            }
            case 341: {
                return this.getConditionsAffectedByProperty_SSNNDMHPNLNCT_179(n);
            }
            case 344: {
                return this.getConditionsAffectedByProperty_SSNNDMS_19A(n);
            }
            case 346: {
                return this.getConditionsAffectedByProperty_SSNNDMS_19C(n);
            }
            case 357: {
                return this.getConditionsAffectedByProperty_SSNNDON_1B3(n);
            }
            case 365: {
                return this.getConditionsAffectedByProperty_SSNOPEDPLB_1BE(n);
            }
            case 415: {
                return this.getConditionsAffectedByProperty_SSNSUILNS_1F0(n);
            }
        }
        return super.getConditionsAffectedByProperty(n);
    }

    private int[] getConditionsAffectedByProperty_SSNCECNL_82(int n) {
        switch (n) {
            case 29133: {
                return SSNCECNL_82_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_NAVIGATION_CONTROLLER_CONTACTS_GET_COMPILATION_RESULT;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNCEDDB_83(int n) {
        switch (n) {
            case 28094: {
                return SSNCEDDB_83_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_NAVIGATION_CONTROLLER_GENERIC_GET_SELECTED_LINE_TEXT;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNDGNLC_113(int n) {
        switch (n) {
            case 46820: {
                return SSNDGNLC_113_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_DESTINATION_INPUT_NBEST_EM;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNDGNLC_114(int n) {
        switch (n) {
            case 46820: {
                return SSNDGNLC_114_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_DESTINATION_INPUT_NBEST_EM;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNDGNLC_116(int n) {
        switch (n) {
            case 46820: {
                return SSNDGNLC_116_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_DESTINATION_INPUT_NBEST_EM;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNDGNLC_117(int n) {
        switch (n) {
            case 46820: {
                return SSNDGNLC_117_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_DESTINATION_INPUT_NBEST_EM;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNDGNLC_118(int n) {
        switch (n) {
            case 46820: {
                return SSNDGNLC_118_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_DESTINATION_INPUT_NBEST_EM;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNDGC_119(int n) {
        switch (n) {
            case 19680: {
                return SSNDGC_119_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_ONLINE_SERVICE;
            }
            case 10059: {
                return SSNDGC_119_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSNDGC_119_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
            case 29133: {
                return SSNDGC_119_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_NAVIGATION_CONTROLLER_CONTACTS_GET_COMPILATION_RESULT;
            }
            case 43482: {
                return SSNDGC_119_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_NAVIGATION_CONTROLLER_SINGLE_USER_INTERFACE_IS_SINGLE_USER_INTERFACE_SUPPORTED;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNDHC_11C(int n) {
        switch (n) {
            case 19680: {
                return SSNDHC_11C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_ONLINE_SERVICE;
            }
            case 10059: {
                return SSNDHC_11C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSNDHC_11C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
            case 29133: {
                return SSNDHC_11C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_NAVIGATION_CONTROLLER_CONTACTS_GET_COMPILATION_RESULT;
            }
            case 43482: {
                return SSNDHC_11C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_NAVIGATION_CONTROLLER_SINGLE_USER_INTERFACE_IS_SINGLE_USER_INTERFACE_SUPPORTED;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNGM_131(int n) {
        switch (n) {
            case 10059: {
                return SSNGM_131_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSNGM_131_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
            case 68612: {
                return SSNGM_131_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_HELPMODE_IS_ACTIVATED;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNGMA_132(int n) {
        switch (n) {
            case 68612: {
                return SSNGMA_132_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_HELPMODE_IS_ACTIVATED;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNGMH_135(int n) {
        switch (n) {
            case 68612: {
                return SSNGMH_135_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_HELPMODE_IS_ACTIVATED;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNGMLD_136(int n) {
        switch (n) {
            case 68612: {
                return SSNGMLD_136_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_HELPMODE_IS_ACTIVATED;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNGMNC_137(int n) {
        switch (n) {
            case 68612: {
                return SSNGMNC_137_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_HELPMODE_IS_ACTIVATED;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNGMOPS_139(int n) {
        switch (n) {
            case 68612: {
                return SSNGMOPS_139_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_HELPMODE_IS_ACTIVATED;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNGMPS_13A(int n) {
        switch (n) {
            case 68612: {
                return SSNGMPS_13A_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_HELPMODE_IS_ACTIVATED;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNGMR_13B(int n) {
        switch (n) {
            case 68612: {
                return SSNGMR_13B_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_HELPMODE_IS_ACTIVATED;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNGNMA_13F(int n) {
        switch (n) {
            case 68612: {
                return SSNGNMA_13F_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_HELPMODE_IS_ACTIVATED;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNGNMH_140(int n) {
        switch (n) {
            case 68612: {
                return SSNGNMH_140_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_HELPMODE_IS_ACTIVATED;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNGNMLD_141(int n) {
        switch (n) {
            case 68612: {
                return SSNGNMLD_141_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_HELPMODE_IS_ACTIVATED;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNGNMNC_142(int n) {
        switch (n) {
            case 68612: {
                return SSNGNMNC_142_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_HELPMODE_IS_ACTIVATED;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNGNMOPS_143(int n) {
        switch (n) {
            case 68612: {
                return SSNGNMOPS_143_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_HELPMODE_IS_ACTIVATED;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNGNMPS_144(int n) {
        switch (n) {
            case 68612: {
                return SSNGNMPS_144_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_HELPMODE_IS_ACTIVATED;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNGNMR_145(int n) {
        switch (n) {
            case 68612: {
                return SSNGNMR_145_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_HELPMODE_IS_ACTIVATED;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNNDMH_16D(int n) {
        switch (n) {
            case 40894: {
                return SSNNDMH_16D_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_NAVIGATION_CONTROLLER_DESTINATION_INPUT_CROSSING_IS_CROSSING_AVAILABLE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNNDMHN_170(int n) {
        switch (n) {
            case 40894: {
                return SSNNDMHN_170_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_NAVIGATION_CONTROLLER_DESTINATION_INPUT_CROSSING_IS_CROSSING_AVAILABLE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNNDMHPML_174(int n) {
        switch (n) {
            case 40894: {
                return SSNNDMHPML_174_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_NAVIGATION_CONTROLLER_DESTINATION_INPUT_CROSSING_IS_CROSSING_AVAILABLE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNNDMHPNLNCT_179(int n) {
        switch (n) {
            case 40894: {
                return SSNNDMHPNLNCT_179_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_NAVIGATION_CONTROLLER_DESTINATION_INPUT_CROSSING_IS_CROSSING_AVAILABLE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNNDMS_19A(int n) {
        switch (n) {
            case 28043: {
                return SSNNDMS_19A_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_NAVIGATION_NEW_DEST_ENTRY_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNNDMS_19C(int n) {
        switch (n) {
            case 29633: {
                return SSNNDMS_19C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_NAVIGATION_CONTROLLER_DESTINATION_INPUT_GET_START_ENTRY_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNNDON_1B3(int n) {
        switch (n) {
            case 75258: {
                return SSNNDON_1B3_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_NAVIGATION_CONTROLLER_DESTINATION_INPUT_ONESHOT_GET_NBEST_HEADLINE_TEXT;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNOPEDPLB_1BE(int n) {
        switch (n) {
            case 13351: {
                return SSNOPEDPLB_1BE_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_NAVIGATION_CONTROLLER_GUIDANCE_GET_GUIDANCE_STATUS;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSNSUILNS_1F0(int n) {
        switch (n) {
            case 10059: {
                return SSNSUILNS_1F0_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSNSUILNS_1F0_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    @Override
    protected int[] getConditionsAffectedByList(int n) {
        switch (this.sdFeatColId) {
            case 127: {
                return this.getConditionsAffectedByList_SSNCEDDB_83(n);
            }
            case 324: {
                return this.getConditionsAffectedByList_SSNNDMCSN_164(n);
            }
            case 416: {
                return this.getConditionsAffectedByList_SSNSUIN_1F1(n);
            }
        }
        return super.getConditionsAffectedByList(n);
    }

    private int[] getConditionsAffectedByList_SSNCEDDB_83(int n) {
        switch (n) {
            case 3410022: {
                return SSNCEDDB_83_AFFECTED_CONDITIONS_FOR_LIST_SPEECHNAVIGATION_CONTROLLER_CONTACTS_SELECTED_CONTACT;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal list Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByList_SSNNDMCSN_164(int n) {
        switch (n) {
            case 3410056: {
                return SSNNDMCSN_164_AFFECTED_CONDITIONS_FOR_LIST_SPEECHNAVIGATION_CONTROLLER_DESTINATIONINPUT_COUNTRYSTATE_COUNTRY_STATE_RESULTS;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal list Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByList_SSNSUIN_1F1(int n) {
        switch (n) {
            case 3410048: {
                return SSNSUIN_1F1_AFFECTED_CONDITIONS_FOR_LIST_SPEECHNAVIGATION_CONTROLLER_SINGLEUSERINTERFACE_SUI_RESULT_LIST;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal list Id: ").append(n).toString());
    }

    @Override
    protected void updateAffectedFeature(int n) {
        switch (this.sdFeatColId) {
            case 127: {
                this.updateAffectedFeature_SSNCEDDB_83(n);
                break;
            }
            case 357: {
                this.updateAffectedFeature_SSNNDON_1B3(n);
                break;
            }
            default: {
                super.updateAffectedFeature(n);
            }
        }
    }

    private void updateAffectedFeature_SSNCEDDB_83(int n) {
        switch (n) {
            case 28094: {
                this.updateFeature(3);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
            }
        }
    }

    private void updateAffectedFeature_SSNNDON_1B3(int n) {
        switch (n) {
            case 75258: {
                this.updateFeature(4);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
            }
        }
    }
}

