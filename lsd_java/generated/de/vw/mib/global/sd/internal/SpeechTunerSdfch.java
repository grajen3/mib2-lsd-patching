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

public final class SpeechTunerSdfch
extends SdFeatureCollectionHandlerBase {
    private static int[] SSTCBCD_27E_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{5};
    private static int[] SSTCBCD_27E_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSTCBCD_27E_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{0};
    private static int[] SSTCBCD_27E_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{0};
    private static int[] SSTCBCD_27E_AFFECTED_FEATURES_FOR_CONDITION_5 = new int[]{4};
    private static int[] SSTCBCD_27E_AFFECTED_FEATURES_FOR_CONDITION_6 = new int[]{4};
    private static int[] SSTCBCD_27E_AFFECTED_FEATURES_FOR_CONDITION_7 = new int[]{4};
    private static int[] SSTCBCD_27E_AFFECTED_FEATURES_FOR_CONDITION_8 = new int[]{5};
    private static int[] SSTCBCD_27E_AFFECTED_FEATURES_FOR_CONDITION_9 = new int[]{5};
    private static int[] SSTCBCD_27E_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_AMAVAILABLE = new int[]{0, 1, 5, 6, 7, 8};
    private static int[] SSTCBCD_27E_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_DABAVAILABLE = new int[]{0, 2, 5, 6, 7, 9};
    private static int[] SSTCBCD_27E_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{0, 1, 2, 3, 5, 6, 7, 8, 9};
    private static int[] SSTCBCD_27E_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{0, 1, 2, 3, 5, 6, 7, 8, 9};
    private static int[] SSTCSFDA_287_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSTCSFDA_287_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSTCSFDA_287_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{0};
    private static int[] SSTCSFDA_287_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{0};
    private static int[] SSTCSFDA_287_AFFECTED_FEATURES_FOR_CONDITION_5 = new int[]{4};
    private static int[] SSTCSFDA_287_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_AMAVAILABLE = new int[]{0, 1, 2, 3, 5};
    private static int[] SSTCSFDA_287_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{0, 1, 2, 3, 5};
    private static int[] SSTCSFDA_287_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{0, 1, 2, 3, 5};
    private static int[] SSTCSFDA_287_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_TUNER_GET_CURRENT_AMFREQUENCY_SCALE = new int[]{0, 1, 2, 3};
    private static int[] SSTCSFDF_289_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSTCSFDF_289_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSTCSFDF_289_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{0};
    private static int[] SSTCSFDF_289_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{0};
    private static int[] SSTCSFDF_289_AFFECTED_FEATURES_FOR_CONDITION_4 = new int[]{0};
    private static int[] SSTCSFDF_289_AFFECTED_FEATURES_FOR_CONDITION_7 = new int[]{4};
    private static int[] SSTCSFDF_289_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{0, 1, 2, 3, 4, 7};
    private static int[] SSTCSFDF_289_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{0, 1, 2, 3, 4, 7};
    private static int[] SSTCSFDF_289_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_TUNER_GET_CURRENT_FMFREQUENCY_SCALE = new int[]{0, 1, 2, 3, 4};
    private static int[] SSTCSSDD_28D_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{0, 4};
    private static int[] SSTCSSDD_28D_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_DABAVAILABLE = new int[]{3};
    private static int[] SSTCSSDD_28D_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{3};
    private static int[] SSTCSSDD_28D_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{3};
    private static int[] SSTCSSDF_28E_AFFECTED_FEATURES_FOR_CONDITION_4 = new int[]{0, 4};
    private static int[] SSTCSSDF_28E_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{4};
    private static int[] SSTCSSDF_28E_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{4};
    private static int[] SSTCSR_292_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{3};
    private static int[] SSTCSR_292_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{3};
    private static int[] SSTCSR_292_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{3};
    private static int[] SSTCSR_292_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_DABAVAILABLE = new int[]{0, 1, 2};
    private static int[] SSTCSR_292_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{0, 1, 2};
    private static int[] SSTCSR_292_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{0, 1, 2};
    private static int[] SSTDR_296_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSTDR_296_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSTDR_296_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{0};
    private static int[] SSTDR_296_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{0};
    private static int[] SSTDR_296_AFFECTED_FEATURES_FOR_CONDITION_4 = new int[]{0};
    private static int[] SSTDR_296_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_AMAVAILABLE = new int[]{0, 1};
    private static int[] SSTDR_296_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_DABAVAILABLE = new int[]{0, 1, 2};
    private static int[] SSTDR_296_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{0, 1, 2};
    private static int[] SSTDR_296_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{0, 1, 2};
    private static int[] SSTDR_296_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_TUNER_HELP_MODE = new int[]{3, 4};
    private static int[] SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{0};
    private static int[] SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{0};
    private static int[] SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_4 = new int[]{0};
    private static int[] SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_5 = new int[]{0};
    private static int[] SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_6 = new int[]{0};
    private static int[] SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_7 = new int[]{0};
    private static int[] SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_8 = new int[]{0};
    private static int[] SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_9 = new int[]{0};
    private static int[] SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_10 = new int[]{0};
    private static int[] SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_11 = new int[]{0};
    private static int[] SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_12 = new int[]{0};
    private static int[] SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_13 = new int[]{0};
    private static int[] SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_14 = new int[]{0};
    private static int[] SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_15 = new int[]{0};
    private static int[] SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_16 = new int[]{0};
    private static int[] SSTGGC_29B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_AMAVAILABLE = new int[]{0, 1, 2, 3, 11, 14};
    private static int[] SSTGGC_29B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_DABAVAILABLE = new int[]{10, 12};
    private static int[] SSTGGC_29B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    private static int[] SSTGGC_29B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    private static int[] SSTGGC_29B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_TUNER_GET_CURRENT_AMFREQUENCY_SCALE = new int[]{0, 1, 2, 3};
    private static int[] SSTGGC_29B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_TUNER_GET_CURRENT_BAND = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static int[] SSTGGC_29B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_TUNER_GET_CURRENT_FMFREQUENCY_SCALE = new int[]{4, 5, 6, 7, 8};
    private static int[] SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{0};
    private static int[] SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{0};
    private static int[] SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_4 = new int[]{0};
    private static int[] SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_5 = new int[]{0};
    private static int[] SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_6 = new int[]{0};
    private static int[] SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_7 = new int[]{0};
    private static int[] SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_8 = new int[]{0};
    private static int[] SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_9 = new int[]{0};
    private static int[] SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_10 = new int[]{0};
    private static int[] SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_11 = new int[]{0};
    private static int[] SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_12 = new int[]{0};
    private static int[] SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_13 = new int[]{0};
    private static int[] SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_14 = new int[]{0};
    private static int[] SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_15 = new int[]{0};
    private static int[] SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_16 = new int[]{0};
    private static int[] SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_17 = new int[]{0};
    private static int[] SSTGHMC_29C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_AMAVAILABLE = new int[]{0, 1, 2, 3, 11, 12, 13, 14, 17};
    private static int[] SSTGHMC_29C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_DABAVAILABLE = new int[]{5, 12};
    private static int[] SSTGHMC_29C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
    private static int[] SSTGHMC_29C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
    private static int[] SSTGHMC_29C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_TUNER_GET_CURRENT_AMFREQUENCY_SCALE = new int[]{0, 1, 2, 3};
    private static int[] SSTGHMC_29C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_TUNER_GET_CURRENT_BAND = new int[]{4, 5};
    private static int[] SSTGHMC_29C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_TUNER_GET_CURRENT_FMFREQUENCY_SCALE = new int[]{6, 7, 8, 9, 10};
    private static int[] SSTHBCOOB_29D_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{3};
    private static int[] SSTHBCOOB_29D_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{3};
    private static int[] SSTHBCOOB_29D_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_TUNER_HELP_MODE = new int[]{0, 1};
    private static int[] SSTHBCSB_29E_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSTHBCSB_29E_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSTHBCSB_29E_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_TUNER_HELP_MODE = new int[]{0, 1};
    private static int[] SSTHBCTO_29F_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{3};
    private static int[] SSTHBCTO_29F_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{0};
    private static int[] SSTHBCTO_29F_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{0};
    private static int[] SSTHBCTO_2A0_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{3};
    private static int[] SSTHBCTO_2A0_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{0};
    private static int[] SSTHBCTO_2A0_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{0};
    private static int[] SSTHCS_2A3_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSTHCS_2A3_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSTHCS_2A3_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_TUNER_HELP_MODE = new int[]{0, 1};
    private static int[] SSTHFSTO_2A4_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{3};
    private static int[] SSTHFSTO_2A4_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_AMAVAILABLE = new int[]{0};
    private static int[] SSTHFSTO_2A4_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{0};
    private static int[] SSTHFSTO_2A4_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{0};
    private static int[] SSTHFSTO_2A5_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{3};
    private static int[] SSTHFSTO_2A5_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_AMAVAILABLE = new int[]{0};
    private static int[] SSTHFSTO_2A5_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{0};
    private static int[] SSTHFSTO_2A5_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{0};
    private static int[] SSTHFS_2A6_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSTHFS_2A6_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSTHFS_2A6_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_TUNER_HELP_MODE = new int[]{0, 1};
    private static int[] SSTHNBCOOB_2A7_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{3};
    private static int[] SSTHNBCOOB_2A7_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{3};
    private static int[] SSTHNBCOOB_2A7_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_TUNER_HELP_MODE = new int[]{0, 1};
    private static int[] SSTHNBCSB_2A8_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSTHNBCSB_2A8_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSTHNBCSB_2A8_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_TUNER_HELP_MODE = new int[]{0, 1};
    private static int[] SSTHNBCTO_2A9_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{3};
    private static int[] SSTHNBCTO_2A9_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{0};
    private static int[] SSTHNBCTO_2A9_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{0};
    private static int[] SSTHNBCTO_2AA_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{3};
    private static int[] SSTHNBCTO_2AA_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{1};
    private static int[] SSTHNBCTO_2AA_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{1};
    private static int[] SSTHNCS_2AD_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSTHNCS_2AD_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSTHNCS_2AD_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_TUNER_HELP_MODE = new int[]{0, 1};
    private static int[] SSTHNFSTO_2AE_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{3};
    private static int[] SSTHNFSTO_2AE_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_AMAVAILABLE = new int[]{1};
    private static int[] SSTHNFSTO_2AE_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{1};
    private static int[] SSTHNFSTO_2AE_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{1};
    private static int[] SSTHNFSTO_2AF_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{3};
    private static int[] SSTHNFSTO_2AF_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_AMAVAILABLE = new int[]{1};
    private static int[] SSTHNFSTO_2AF_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{1};
    private static int[] SSTHNFSTO_2AF_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{1};
    private static int[] SSTHNFS_2B0_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSTHNFS_2B0_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSTHNFS_2B0_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_TUNER_HELP_MODE = new int[]{0, 1};
    private static int[] SSTHNSSTO_2B1_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{3};
    private static int[] SSTHNSSTO_2B1_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_DABAVAILABLE = new int[]{1};
    private static int[] SSTHNSSTO_2B1_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{1};
    private static int[] SSTHNSSTO_2B1_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{1};
    private static int[] SSTHNSSTO_2B2_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{3};
    private static int[] SSTHNSSTO_2B2_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_DABAVAILABLE = new int[]{1};
    private static int[] SSTHNSSTO_2B2_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{1};
    private static int[] SSTHNSSTO_2B2_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{1};
    private static int[] SSTHNSS_2B3_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSTHNSS_2B3_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSTHNSS_2B3_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_TUNER_HELP_MODE = new int[]{0, 1};
    private static int[] SSTHR_2B4_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{2};
    private static int[] SSTHR_2B4_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{2};
    private static int[] SSTHR_2B4_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{2};
    private static int[] SSTHR_2B4_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_DABAVAILABLE = new int[]{0, 1, 2};
    private static int[] SSTHR_2B4_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{0, 1, 2};
    private static int[] SSTHR_2B4_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{0, 1, 2};
    private static int[] SSTHSSTO_2B5_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{3};
    private static int[] SSTHSSTO_2B5_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_DABAVAILABLE = new int[]{0};
    private static int[] SSTHSSTO_2B5_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{0};
    private static int[] SSTHSSTO_2B5_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{0};
    private static int[] SSTHSSTO_2B6_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{3};
    private static int[] SSTHSSTO_2B6_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_DABAVAILABLE = new int[]{0};
    private static int[] SSTHSSTO_2B6_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{0};
    private static int[] SSTHSSTO_2B6_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{0};
    private static int[] SSTHSS_2B7_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSTHSS_2B7_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSTHSS_2B7_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_TUNER_HELP_MODE = new int[]{0, 1};
    private static int[] SSTNL_2BD_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{3, 4};
    private static int[] SSTNL_2BD_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{0};
    private static int[] SSTNL_2BD_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_DABAVAILABLE = new int[]{1, 2};
    private static int[] SSTNL_2BD_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{1, 2};
    private static int[] SSTNL_2BD_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{1, 2};
    private static int[] SSTNL_2BD_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_TUNER_NBEST_ENTRY_MODE = new int[]{1};

    @Override
    public void init(int n, int n2) {
        this.sdFeatColId = n;
        this.speechClientId = n2;
        switch (n) {
            case 555: {
                this.conditions = new boolean[2];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 556: {
                this.conditions = new boolean[4];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 557: {
                this.conditions = new boolean[11];
                this.dpProperties = new int[]{-1358495488, 12357, 10059, 0x7A00000};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(351, -604292800, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(352, -570738368, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(353, -587515584, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[6];
                break;
            }
            case 558: {
                this.conditions = new boolean[2];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 559: {
                this.conditions = new boolean[2];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 560: {
                this.conditions = new boolean[2];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 561: {
                this.conditions = new boolean[2];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 562: {
                this.conditions = new boolean[6];
                this.dpProperties = new int[]{-1358495488, 10059, 0x7A00000, 68878592};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(383, -654624448, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(384, -654624448, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(389, -654624448, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(390, -654624448, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[6];
                break;
            }
            case 563: {
                this.conditions = new boolean[8];
                this.dpProperties = new int[]{10059, 0x7A00000, -1276313600};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(391, -637847232, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(392, -637847232, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(398, -637847232, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(399, -637847232, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(400, -637847232, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[6];
                break;
            }
            case 564: {
                this.conditions = new boolean[2];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 565: {
                this.conditions = new boolean[2];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 566: {
                this.conditions = new boolean[4];
                this.dpProperties = new int[]{12357, 10059, 0x7A00000};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(413, -688178880, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[6];
                break;
            }
            case 567: {
                this.conditions = new boolean[5];
                this.dpProperties = new int[]{10059, 0x7A00000};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(414, -906282688, 3, false, false)};
                this.featureData = new int[]{1, 0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[6];
                break;
            }
            case 568: {
                this.conditions = new boolean[2];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 569: {
                this.conditions = new boolean[5];
                this.dpProperties = new int[]{12357, 10059, 0x7A00000};
                this.featureData = new int[]{0, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 570: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 571: {
                this.featureData = new int[]{1, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 572: {
                this.featureData = new int[]{3};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 573: {
                this.conditions = new boolean[5];
                this.dpProperties = new int[]{-1358495488, 12357, 10059, 0x7A00000, -41091072};
                this.featureData = new int[]{3};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 574: {
                this.conditions = new boolean[7];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 575: {
                this.conditions = new boolean[2];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 576: {
                this.conditions = new boolean[2];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 577: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 578: {
                this.conditions = new boolean[17];
                this.dpProperties = new int[]{-1358495488, 12357, 10059, 0x7A00000, 68878592, 109248512, -1276313600};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(348, -621070016, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(349, -604292800, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(350, -570738368, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(355, -587515584, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(361, -1023723200, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(364, -1040500416, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(374, -671401664, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(375, -654624448, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(376, -654624448, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(381, -654624448, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(382, -654624448, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(401, -637847232, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(402, -637847232, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(408, -637847232, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(409, -637847232, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(410, -637847232, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(411, -738510528, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(412, -688178880, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(416, -906282688, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(419, -1057277632, 1, false, false)};
                this.featureData = new int[]{1};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 579: {
                this.conditions = new boolean[18];
                this.dpProperties = new int[]{-1358495488, 12357, 10059, 0x7A00000, 68878592, 109248512, -1276313600};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(348, -1006945984, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(349, -1006945984, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(350, -1006945984, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(355, -1006945984, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(356, -1006945984, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(357, -1006945984, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(359, -990168768, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(361, -1023723200, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(362, -973391552, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(364, -1023723200, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(374, -990168768, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(375, -990168768, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(376, -990168768, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(381, -990168768, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(382, -990168768, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(401, -990168768, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(402, -990168768, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(408, -990168768, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(409, -990168768, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(410, -990168768, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(411, -973391552, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(412, -973391552, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(416, -973391552, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(419, -1023723200, 2, false, false)};
                this.featureData = new int[]{1};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 580: {
                this.conditions = new boolean[3];
                this.dpProperties = new int[]{-41091072};
                this.featureData = new int[]{0, 0, 0, 3};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 581: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{-41091072};
                this.featureData = new int[]{3};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 582: {
                this.conditions = new boolean[1];
                this.dpProperties = new int[]{10059, 0x7A00000};
                this.featureData = new int[]{0, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 583: {
                this.conditions = new boolean[1];
                this.dpProperties = new int[]{10059, 0x7A00000};
                this.featureData = new int[]{0, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 584: {
                this.featureData = new int[]{0, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 585: {
                this.featureData = new int[]{0, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 586: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{-41091072};
                this.featureData = new int[]{3};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 587: {
                this.conditions = new boolean[1];
                this.dpProperties = new int[]{-1358495488, 10059, 0x7A00000};
                this.featureData = new int[]{0, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 588: {
                this.conditions = new boolean[1];
                this.dpProperties = new int[]{-1358495488, 10059, 0x7A00000};
                this.featureData = new int[]{0, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 589: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{-41091072};
                this.featureData = new int[]{3};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 590: {
                this.conditions = new boolean[3];
                this.dpProperties = new int[]{-41091072};
                this.featureData = new int[]{0, 0, 0, 3};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 591: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{-41091072};
                this.featureData = new int[]{3};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 592: {
                this.conditions = new boolean[1];
                this.dpProperties = new int[]{10059, 0x7A00000};
                this.featureData = new int[]{0, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 593: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{10059, 0x7A00000};
                this.featureData = new int[]{0, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 594: {
                this.featureData = new int[]{0, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 595: {
                this.featureData = new int[]{0, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 596: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{-41091072};
                this.featureData = new int[]{3};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 597: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{-1358495488, 10059, 0x7A00000};
                this.featureData = new int[]{0, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 598: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{-1358495488, 10059, 0x7A00000};
                this.featureData = new int[]{0, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 599: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{-41091072};
                this.featureData = new int[]{3};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 600: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{12357, 10059, 0x7A00000};
                this.featureData = new int[]{0, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 601: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{12357, 10059, 0x7A00000};
                this.featureData = new int[]{0, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 602: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{-41091072};
                this.featureData = new int[]{3};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 603: {
                this.conditions = new boolean[3];
                this.dpProperties = new int[]{12357, 10059, 0x7A00000};
                this.featureData = new int[]{0, 0, 1};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 604: {
                this.conditions = new boolean[1];
                this.dpProperties = new int[]{12357, 10059, 0x7A00000};
                this.featureData = new int[]{0, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 605: {
                this.conditions = new boolean[1];
                this.dpProperties = new int[]{12357, 10059, 0x7A00000};
                this.featureData = new int[]{0, 0, 0, 1};
                this.featuresToUpdate = new boolean[4];
                break;
            }
            case 606: {
                this.conditions = new boolean[2];
                this.dpProperties = new int[]{-41091072};
                this.featureData = new int[]{3};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 607: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 608: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 609: {
                this.conditions = new boolean[2];
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 610: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 611: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 612: {
                this.conditions = new boolean[3];
                this.dpProperties = new int[]{12357, 10059, 0x7A00000, 0xA50000};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(365, -704956096, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(366, -855951040, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(367, -839173824, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(368, -889505472, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(369, -721733312, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(370, -872728256, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(371, -788842176, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(372, -805619392, 3, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(373, -822396608, 3, false, false)};
                this.featureData = new int[]{1, 0, 1, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 613: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 614: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 615: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 616: {
                this.conditions = new boolean[2];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 617: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 618: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 619: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 620: {
                this.conditions = new boolean[1];
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 621: {
                this.conditions = new boolean[1];
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
            case 555: {
                return this.createFeatureInstance_SSTCBA_27C(n);
            }
            case 556: {
                return this.createFeatureInstance_SSTCBAA_27D(n);
            }
            case 557: {
                return this.createFeatureInstance_SSTCBCD_27E(n);
            }
            case 558: {
                return this.createFeatureInstance_SSTCBD_27F(n);
            }
            case 559: {
                return this.createFeatureInstance_SSTCBF_280(n);
            }
            case 560: {
                return this.createFeatureInstance_SSTCLTR_282(n);
            }
            case 561: {
                return this.createFeatureInstance_SSTCSFA_285(n);
            }
            case 562: {
                return this.createFeatureInstance_SSTCSFDA_287(n);
            }
            case 563: {
                return this.createFeatureInstance_SSTCSFDF_289(n);
            }
            case 564: {
                return this.createFeatureInstance_SSTCSFF_28B(n);
            }
            case 565: {
                return this.createFeatureInstance_SSTCSSD_28C(n);
            }
            case 566: {
                return this.createFeatureInstance_SSTCSSDD_28D(n);
            }
            case 567: {
                return this.createFeatureInstance_SSTCSSDF_28E(n);
            }
            case 568: {
                return this.createFeatureInstance_SSTCSSF_290(n);
            }
            case 569: {
                return this.createFeatureInstance_SSTCSR_292(n);
            }
            case 570: {
                return this.createFeatureInstance_SSTDA_293(n);
            }
            case 571: {
                return this.createFeatureInstance_SSTDI_294(n);
            }
            case 572: {
                return this.createFeatureInstance_SSTDNEV_295(n);
            }
            case 573: {
                return this.createFeatureInstance_SSTDR_296(n);
            }
            case 574: {
                return this.createFeatureInstance_SSTEE_297(n);
            }
            case 575: {
                return this.createFeatureInstance_SSTESF_298(n);
            }
            case 576: {
                return this.createFeatureInstance_SSTESS_299(n);
            }
            case 577: {
                return this.createFeatureInstance_SSTGCE_29A(n);
            }
            case 578: {
                return this.createFeatureInstance_SSTGGC_29B(n);
            }
            case 579: {
                return this.createFeatureInstance_SSTGHMC_29C(n);
            }
            case 580: {
                return this.createFeatureInstance_SSTHBCOOB_29D(n);
            }
            case 581: {
                return this.createFeatureInstance_SSTHBCSB_29E(n);
            }
            case 582: {
                return this.createFeatureInstance_SSTHBCTO_29F(n);
            }
            case 583: {
                return this.createFeatureInstance_SSTHBCTO_2A0(n);
            }
            case 584: {
                return this.createFeatureInstance_SSTHCSTO_2A1(n);
            }
            case 585: {
                return this.createFeatureInstance_SSTHCSTO_2A2(n);
            }
            case 586: {
                return this.createFeatureInstance_SSTHCS_2A3(n);
            }
            case 587: {
                return this.createFeatureInstance_SSTHFSTO_2A4(n);
            }
            case 588: {
                return this.createFeatureInstance_SSTHFSTO_2A5(n);
            }
            case 589: {
                return this.createFeatureInstance_SSTHFS_2A6(n);
            }
            case 590: {
                return this.createFeatureInstance_SSTHNBCOOB_2A7(n);
            }
            case 591: {
                return this.createFeatureInstance_SSTHNBCSB_2A8(n);
            }
            case 592: {
                return this.createFeatureInstance_SSTHNBCTO_2A9(n);
            }
            case 593: {
                return this.createFeatureInstance_SSTHNBCTO_2AA(n);
            }
            case 594: {
                return this.createFeatureInstance_SSTHNCSTO_2AB(n);
            }
            case 595: {
                return this.createFeatureInstance_SSTHNCSTO_2AC(n);
            }
            case 596: {
                return this.createFeatureInstance_SSTHNCS_2AD(n);
            }
            case 597: {
                return this.createFeatureInstance_SSTHNFSTO_2AE(n);
            }
            case 598: {
                return this.createFeatureInstance_SSTHNFSTO_2AF(n);
            }
            case 599: {
                return this.createFeatureInstance_SSTHNFS_2B0(n);
            }
            case 600: {
                return this.createFeatureInstance_SSTHNSSTO_2B1(n);
            }
            case 601: {
                return this.createFeatureInstance_SSTHNSSTO_2B2(n);
            }
            case 602: {
                return this.createFeatureInstance_SSTHNSS_2B3(n);
            }
            case 603: {
                return this.createFeatureInstance_SSTHR_2B4(n);
            }
            case 604: {
                return this.createFeatureInstance_SSTHSSTO_2B5(n);
            }
            case 605: {
                return this.createFeatureInstance_SSTHSSTO_2B6(n);
            }
            case 606: {
                return this.createFeatureInstance_SSTHSS_2B7(n);
            }
            case 607: {
                return this.createFeatureInstance_SSTNCG_2B8(n);
            }
            case 608: {
                return this.createFeatureInstance_SSTNEOL_2B9(n);
            }
            case 609: {
                return this.createFeatureInstance_SSTNE_2BA(n);
            }
            case 610: {
                return this.createFeatureInstance_SSTNFP_2BB(n);
            }
            case 611: {
                return this.createFeatureInstance_SSTNLP_2BC(n);
            }
            case 612: {
                return this.createFeatureInstance_SSTNL_2BD(n);
            }
            case 613: {
                return this.createFeatureInstance_SSTNNP_2BE(n);
            }
            case 614: {
                return this.createFeatureInstance_SSTNN_2BF(n);
            }
            case 615: {
                return this.createFeatureInstance_SSTNOOP_2C0(n);
            }
            case 616: {
                return this.createFeatureInstance_SSTNOG_2C1(n);
            }
            case 617: {
                return this.createFeatureInstance_SSTNPP_2C2(n);
            }
            case 618: {
                return this.createFeatureInstance_SSTNRNSF_2C3(n);
            }
            case 619: {
                return this.createFeatureInstance_SSTNSBRN_2C4(n);
            }
            case 620: {
                return this.createFeatureInstance_SSTNTOL_2C5(n);
            }
            case 621: {
                return this.createFeatureInstance_SSTNWS_2C6(n);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal sdFeatColId: ").append(this.sdFeatColId).toString());
    }

    private Feature createFeatureInstance_SSTCBA_27C(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1344));
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
                genericTargetFeature.setBoolean(3008, this.conditions[1]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTCBAA_27D(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1345));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1352));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1350));
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
                genericTargetFeature.setBoolean(3008, this.conditions[3]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTCBCD_27E(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[10]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1343));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(2137492809));
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
                if (this.conditions[5]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1346}, 0));
                }
                if (this.conditions[6]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1347}, 0));
                }
                if (this.conditions[7]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1353}, 0));
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
                    object = this.getI18nString(6058);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                if (this.conditions[8]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6054), false));
                }
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6056), false));
                if (this.conditions[9]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6055), false));
                }
                if (this.conditions[0]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6039), false));
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

    private Feature createFeatureInstance_SSTCBD_27F(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1349));
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
                genericTargetFeature.setBoolean(3008, this.conditions[1]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTCBF_280(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1351));
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
                genericTargetFeature.setBoolean(3008, this.conditions[1]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTCLTR_282(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1398));
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
                genericTargetFeature.setBoolean(3008, this.conditions[0]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTCSFA_285(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1409));
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
                genericTargetFeature.setBoolean(3008, this.conditions[1]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTCSFDA_287(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[5]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1406));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(-1956147895));
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
                if (this.conditions[5]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1408}, 0));
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
                    object = this.getI18nString(6063);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6059), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6039), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6040), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTCSFDF_289(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[5]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1361));
                }
                if (this.conditions[7]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1411));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(-1956147895));
                return genericTargetFeature;
            }
            case 3: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, this.conditions[6]);
                return genericTargetFeature;
            }
            case 4: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[7]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1414}, 0));
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
                    object = this.getI18nString(6064);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6060), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6039), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6040), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTCSFF_28B(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1415));
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
                genericTargetFeature.setBoolean(3008, this.conditions[1]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTCSSD_28C(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1418));
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
                genericTargetFeature.setBoolean(3008, this.conditions[0]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTCSSDD_28D(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1416));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1363));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(-1939370679));
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
                if (this.conditions[3]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1417}, 0));
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
                    object = this.getI18nString(6068);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(FormatterService.format(this.getI18nString(6066), this.getLicValue(-601736704, 2, 0, "")), true));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6039), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6040), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTCSSDF_28E(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[2]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1361));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1419));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1368));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(-1939370679));
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
                if (this.conditions[4]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1420}, 0));
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
                    object = this.getI18nString(6069);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(FormatterService.format(this.getI18nString(6067), this.getLicValue(-719177216, 7, 0, "")), true));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6039), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6040), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 4);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTCSSF_290(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1421));
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
                genericTargetFeature.setBoolean(3008, this.conditions[0]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTCSR_292(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[4]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1400));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(-1972925111));
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, false);
                genericTargetFeature.setBoolean(3007, false);
                genericTargetFeature.setBoolean(3001, true);
                genericTargetFeature.setBoolean(3002, false);
                genericTargetFeature.setInt(3003, -1);
                genericTargetFeature.setBoolean(3008, this.conditions[3]);
                return genericTargetFeature;
            }
            case 3: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[2]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1405}, 0));
                }
                if (this.conditions[1]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1403}, 0));
                }
                if (this.conditions[0]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1404}, 0));
                }
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTDA_293(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(202);
                genericTargetFeature.setBoolean(2010, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTDI_294(int n) {
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

    private Feature createFeatureInstance_SSTDNEV_295(int n) {
        switch (n) {
            case 0: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (object == null) {
                    object = this.getI18nString(6047);
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

    private Feature createFeatureInstance_SSTDR_296(int n) {
        switch (n) {
            case 0: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[3] && object == null) {
                    object = this.getI18nString(6099);
                    bl = false;
                }
                if (this.conditions[4] && object == null) {
                    object = this.getI18nString(6048);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6097), false));
                if (this.conditions[2]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6102), false));
                }
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6101), false));
                if (this.conditions[0]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6092), false));
                }
                if (this.conditions[1]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6039), false));
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

    private Feature createFeatureInstance_SSTEE_297(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[3]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1395));
                }
                if (this.conditions[1]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1397));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1398));
                }
                if (this.conditions[2]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1399));
                }
                if (this.conditions[5]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1359));
                }
                if (this.conditions[4]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1360));
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
                genericTargetFeature.setInt(3003, 2);
                genericTargetFeature.setBoolean(3008, this.conditions[6]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTESF_298(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1410));
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
                genericTargetFeature.setInt(3003, 2);
                genericTargetFeature.setBoolean(3008, this.conditions[0]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTESS_299(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1422));
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
                genericTargetFeature.setInt(3003, 2);
                genericTargetFeature.setBoolean(3008, this.conditions[1]);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTGCE_29A(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(201);
                genericTargetFeature.setEvent(2001, this.createEvent(-1922593463));
                genericTargetFeature.setEvent(2006, this.createEvent(-1905816247));
                genericTargetFeature.setEvent(2007, this.createEvent(-1889039031));
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTGGC_29B(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTGHMC_29C(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTHBCOOB_29D(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[2]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1433));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(-2140697271));
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
                if (this.conditions[0] && object == null) {
                    object = this.getI18nString(6078);
                    bl = false;
                }
                if (this.conditions[1] && object == null) {
                    object = this.getI18nString(6048);
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

    private Feature createFeatureInstance_SSTHBCSB_29E(int n) {
        switch (n) {
            case 0: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[0] && object == null) {
                    object = this.getI18nString(6071);
                    bl = false;
                }
                if (this.conditions[1] && object == null) {
                    object = this.getI18nString(6048);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6070), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6073), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6039), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTHBCTO_29F(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1428));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(-2123920055));
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
                if (this.conditions[0]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1428}, 0));
                }
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTHBCTO_2A0(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1427));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1358));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(-2107142839));
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
                if (this.conditions[0]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1428}, 0));
                }
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTHCSTO_2A1(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(-2090365623));
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
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTHCSTO_2A2(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(-2073588407));
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
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTHCS_2A3(int n) {
        switch (n) {
            case 0: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[0] && object == null) {
                    object = this.getI18nString(6106);
                    bl = false;
                }
                if (this.conditions[1] && object == null) {
                    object = this.getI18nString(6048);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6105), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6110), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6039), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTHFSTO_2A4(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1432));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(-2056811191));
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
                if (this.conditions[0]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1432}, 0));
                }
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTHFSTO_2A5(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1431));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1358));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(-2040033975));
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
                if (this.conditions[0]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1432}, 0));
                }
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTHFS_2A6(int n) {
        switch (n) {
            case 0: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[0] && object == null) {
                    object = this.getI18nString(6081);
                    bl = false;
                }
                if (this.conditions[1] && object == null) {
                    object = this.getI18nString(6048);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6079), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6083), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6039), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTHNBCOOB_2A7(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[2]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1392));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(-2140697271));
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
                if (this.conditions[0] && object == null) {
                    object = this.getI18nString(6077);
                    bl = false;
                }
                if (this.conditions[1] && object == null) {
                    object = this.getI18nString(6045);
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

    private Feature createFeatureInstance_SSTHNBCSB_2A8(int n) {
        switch (n) {
            case 0: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[0] && object == null) {
                    object = this.getI18nString(6072);
                    bl = false;
                }
                if (this.conditions[1] && object == null) {
                    object = this.getI18nString(6045);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6070), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6073), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6039), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTHNBCTO_2A9(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechTunerSdfch.createPrompt(1387));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(-2123920055));
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
                if (this.conditions[0]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1387}, 0));
                }
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTHNBCTO_2AA(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1387));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(-2107142839));
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
                if (this.conditions[1]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1387}, 0));
                }
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTHNCSTO_2AB(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(-2090365623));
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
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTHNCSTO_2AC(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(-2073588407));
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
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTHNCS_2AD(int n) {
        switch (n) {
            case 0: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[0] && object == null) {
                    object = this.getI18nString(6108);
                    bl = false;
                }
                if (this.conditions[1] && object == null) {
                    object = this.getI18nString(6045);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6105), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6110), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6039), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTHNFSTO_2AE(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1391));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(-2056811191));
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
                if (this.conditions[1]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1391}, 0));
                }
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTHNFSTO_2AF(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1391));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(-2040033975));
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
                if (this.conditions[1]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1391}, 0));
                }
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTHNFS_2B0(int n) {
        switch (n) {
            case 0: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[0] && object == null) {
                    object = this.getI18nString(6082);
                    bl = false;
                }
                if (this.conditions[1] && object == null) {
                    object = this.getI18nString(6045);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6079), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6083), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6039), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTHNSSTO_2B1(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1394));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(-2006479543));
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
                if (this.conditions[1]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1394}, 0));
                }
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTHNSSTO_2B2(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1394));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(-1989702327));
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
                if (this.conditions[1]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1394}, 0));
                }
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTHNSS_2B3(int n) {
        switch (n) {
            case 0: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[0] && object == null) {
                    object = this.getI18nString(6109);
                    bl = false;
                }
                if (this.conditions[1] && object == null) {
                    object = this.getI18nString(6045);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6113), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6111), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6039), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTHR_2B4(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(-2023256759));
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
                if (this.conditions[2]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1405}, 0));
                }
                if (this.conditions[1]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1403}, 0));
                }
                if (this.conditions[0]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1404}, 0));
                }
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTHSSTO_2B5(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1435));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(-2006479543));
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
                if (this.conditions[0]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1435}, 0));
                }
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTHSSTO_2B6(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1434));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1358));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(-1989702327));
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
                if (this.conditions[0]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1435}, 0));
                }
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTHSS_2B7(int n) {
        switch (n) {
            case 0: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[0] && object == null) {
                    object = this.getI18nString(6107);
                    bl = false;
                }
                if (this.conditions[1] && object == null) {
                    object = this.getI18nString(6048);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6113), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6111), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6039), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTNCG_2B8(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1372));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTNEOL_2B9(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1365));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTNE_2BA(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1367));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1362));
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

    private Feature createFeatureInstance_SSTNFP_2BB(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1366));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTNLP_2BC(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1373));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTNL_2BD(int n) {
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
                genericTargetFeature.setBoolean(3008, this.conditions[0]);
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
                if (this.conditions[1]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{1370}, 0));
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
                    object = FormatterService.format(this.getI18nString(6051), this.getLicValue(-467518976, 0, 0, ""));
                    bl = true;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6049), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6046), false));
                if (this.conditions[1]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(6052), false));
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

    private Feature createFeatureInstance_SSTNNP_2BE(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1374));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTNN_2BF(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1371));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTNOOP_2C0(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1375));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTNOG_2C1(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[1]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1369));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1364));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTNPP_2C2(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1376));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTNRNSF_2C3(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1377));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTNSBRN_2C4(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1378));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTNTOL_2C5(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechTunerSdfch.createPrompt(1384));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSTNWS_2C6(int n) {
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

    @Override
    protected void collectAllUnconditionalCommands(ObjectArrayList objectArrayList) {
        switch (this.sdFeatColId) {
            default: 
        }
        super.collectAllUnconditionalCommands(objectArrayList);
    }

    @Override
    protected boolean evaluateCondition(int n) {
        switch (this.sdFeatColId) {
            case 555: {
                return this.evaluateCondition_SSTCBA_27C(n);
            }
            case 556: {
                return this.evaluateCondition_SSTCBAA_27D(n);
            }
            case 557: {
                return this.evaluateCondition_SSTCBCD_27E(n);
            }
            case 558: {
                return this.evaluateCondition_SSTCBD_27F(n);
            }
            case 559: {
                return this.evaluateCondition_SSTCBF_280(n);
            }
            case 560: {
                return this.evaluateCondition_SSTCLTR_282(n);
            }
            case 561: {
                return this.evaluateCondition_SSTCSFA_285(n);
            }
            case 562: {
                return this.evaluateCondition_SSTCSFDA_287(n);
            }
            case 563: {
                return this.evaluateCondition_SSTCSFDF_289(n);
            }
            case 564: {
                return this.evaluateCondition_SSTCSFF_28B(n);
            }
            case 565: {
                return this.evaluateCondition_SSTCSSD_28C(n);
            }
            case 566: {
                return this.evaluateCondition_SSTCSSDD_28D(n);
            }
            case 567: {
                return this.evaluateCondition_SSTCSSDF_28E(n);
            }
            case 568: {
                return this.evaluateCondition_SSTCSSF_290(n);
            }
            case 569: {
                return this.evaluateCondition_SSTCSR_292(n);
            }
            case 573: {
                return this.evaluateCondition_SSTDR_296(n);
            }
            case 574: {
                return this.evaluateCondition_SSTEE_297(n);
            }
            case 575: {
                return this.evaluateCondition_SSTESF_298(n);
            }
            case 576: {
                return this.evaluateCondition_SSTESS_299(n);
            }
            case 578: {
                return this.evaluateCondition_SSTGGC_29B(n);
            }
            case 579: {
                return this.evaluateCondition_SSTGHMC_29C(n);
            }
            case 580: {
                return this.evaluateCondition_SSTHBCOOB_29D(n);
            }
            case 581: {
                return this.evaluateCondition_SSTHBCSB_29E(n);
            }
            case 582: {
                return this.evaluateCondition_SSTHBCTO_29F(n);
            }
            case 583: {
                return this.evaluateCondition_SSTHBCTO_2A0(n);
            }
            case 586: {
                return this.evaluateCondition_SSTHCS_2A3(n);
            }
            case 587: {
                return this.evaluateCondition_SSTHFSTO_2A4(n);
            }
            case 588: {
                return this.evaluateCondition_SSTHFSTO_2A5(n);
            }
            case 589: {
                return this.evaluateCondition_SSTHFS_2A6(n);
            }
            case 590: {
                return this.evaluateCondition_SSTHNBCOOB_2A7(n);
            }
            case 591: {
                return this.evaluateCondition_SSTHNBCSB_2A8(n);
            }
            case 592: {
                return this.evaluateCondition_SSTHNBCTO_2A9(n);
            }
            case 593: {
                return this.evaluateCondition_SSTHNBCTO_2AA(n);
            }
            case 596: {
                return this.evaluateCondition_SSTHNCS_2AD(n);
            }
            case 597: {
                return this.evaluateCondition_SSTHNFSTO_2AE(n);
            }
            case 598: {
                return this.evaluateCondition_SSTHNFSTO_2AF(n);
            }
            case 599: {
                return this.evaluateCondition_SSTHNFS_2B0(n);
            }
            case 600: {
                return this.evaluateCondition_SSTHNSSTO_2B1(n);
            }
            case 601: {
                return this.evaluateCondition_SSTHNSSTO_2B2(n);
            }
            case 602: {
                return this.evaluateCondition_SSTHNSS_2B3(n);
            }
            case 603: {
                return this.evaluateCondition_SSTHR_2B4(n);
            }
            case 604: {
                return this.evaluateCondition_SSTHSSTO_2B5(n);
            }
            case 605: {
                return this.evaluateCondition_SSTHSSTO_2B6(n);
            }
            case 606: {
                return this.evaluateCondition_SSTHSS_2B7(n);
            }
            case 607: {
                return this.evaluateCondition_SSTNCG_2B8(n);
            }
            case 608: {
                return this.evaluateCondition_SSTNEOL_2B9(n);
            }
            case 609: {
                return this.evaluateCondition_SSTNE_2BA(n);
            }
            case 610: {
                return this.evaluateCondition_SSTNFP_2BB(n);
            }
            case 611: {
                return this.evaluateCondition_SSTNLP_2BC(n);
            }
            case 612: {
                return this.evaluateCondition_SSTNL_2BD(n);
            }
            case 613: {
                return this.evaluateCondition_SSTNNP_2BE(n);
            }
            case 614: {
                return this.evaluateCondition_SSTNN_2BF(n);
            }
            case 615: {
                return this.evaluateCondition_SSTNOOP_2C0(n);
            }
            case 616: {
                return this.evaluateCondition_SSTNOG_2C1(n);
            }
            case 617: {
                return this.evaluateCondition_SSTNPP_2C2(n);
            }
            case 618: {
                return this.evaluateCondition_SSTNRNSF_2C3(n);
            }
            case 619: {
                return this.evaluateCondition_SSTNSBRN_2C4(n);
            }
            case 620: {
                return this.evaluateCondition_SSTNTOL_2C5(n);
            }
            case 621: {
                return this.evaluateCondition_SSTNWS_2C6(n);
            }
        }
        return super.evaluateCondition(n);
    }

    private boolean evaluateCondition_SSTCBA_27C(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(31) && this.evalBoolean(37);
            }
            case 1: {
                return this.getBoolean(19244);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTCBAA_27D(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(31) && this.evalBoolean(37) && this.getInteger(109248512) == 0;
            }
            case 1: {
                return this.evalBoolean(32) && this.evalBoolean(37) && this.getInteger(109248512) == 2;
            }
            case 2: {
                return this.evalBoolean(33) && this.evalBoolean(37) && this.getInteger(109248512) == 1;
            }
            case 3: {
                return this.getBoolean(19244);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTCBCD_27E(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(26) || this.evalBoolean(29);
            }
            case 1: {
                return this.evalBoolean(31) && this.evalBoolean(37);
            }
            case 2: {
                return this.evalBoolean(32) && this.evalBoolean(37);
            }
            case 3: {
                return this.evalBoolean(33) && this.evalBoolean(37);
            }
            case 4: {
                return this.getBoolean(19244);
            }
            case 5: {
                return this.evalBoolean(26);
            }
            case 6: {
                return this.evalBoolean(27);
            }
            case 7: {
                return this.evalBoolean(29);
            }
            case 8: {
                return this.evalBoolean(31);
            }
            case 9: {
                return this.evalBoolean(32);
            }
            case 10: {
                return this.evalBoolean(37);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTCBD_27F(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(32) && this.evalBoolean(37);
            }
            case 1: {
                return this.getBoolean(19244);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTCBF_280(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(33) && this.evalBoolean(37);
            }
            case 1: {
                return this.getBoolean(19244);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTCLTR_282(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(19244);
            }
            case 1: {
                return this.evalBoolean(42);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTCSFA_285(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(35);
            }
            case 1: {
                return this.getBoolean(19244);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTCSFDA_287(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(68878592) == 0 && this.evalBoolean(35);
            }
            case 1: {
                return this.getInteger(68878592) == 1 && this.evalBoolean(35);
            }
            case 2: {
                return this.getInteger(68878592) == 2 && this.evalBoolean(35);
            }
            case 3: {
                return this.getInteger(68878592) == 3 && this.evalBoolean(35);
            }
            case 4: {
                return this.getBoolean(19244);
            }
            case 5: {
                return this.evalBoolean(35);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTCSFDF_289(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-1276313600) == 0 && this.evalBoolean(39);
            }
            case 1: {
                return this.getInteger(-1276313600) == 1 && this.evalBoolean(39);
            }
            case 2: {
                return this.getInteger(-1276313600) == 2 && this.evalBoolean(39);
            }
            case 3: {
                return this.getInteger(-1276313600) == 3 && this.evalBoolean(39);
            }
            case 4: {
                return this.getInteger(-1276313600) == 4 && this.evalBoolean(39);
            }
            case 5: {
                return this.getInteger(-1751908352) == 2 && this.evalBoolean(39);
            }
            case 6: {
                return this.getBoolean(19244);
            }
            case 7: {
                return this.evalBoolean(39);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTCSFF_28B(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(39);
            }
            case 1: {
                return this.getBoolean(19244);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTCSSD_28C(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(19244);
            }
            case 1: {
                return this.evalBoolean(38);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTCSSDD_28D(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-1751908352) == 0 && this.evalBoolean(38);
            }
            case 1: {
                return this.getInteger(-1751908352) == 1 && this.evalBoolean(38);
            }
            case 2: {
                return this.getBoolean(19244);
            }
            case 3: {
                return this.evalBoolean(38);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTCSSDF_28E(int n) {
        switch (n) {
            case 0: {
                return (this.getInteger(-1751908352) == 1 || this.getInteger(-1751908352) == 2) && this.evalBoolean(41);
            }
            case 1: {
                return this.getInteger(-1751908352) == 0 && this.evalBoolean(41);
            }
            case 2: {
                return this.getInteger(-1751908352) == 2 && this.evalBoolean(41);
            }
            case 3: {
                return this.getBoolean(19244);
            }
            case 4: {
                return this.evalBoolean(41);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTCSSF_290(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(19244);
            }
            case 1: {
                return this.evalBoolean(41);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTCSR_292(int n) {
        switch (n) {
            case 0: {
                return !this.evalBoolean(53);
            }
            case 1: {
                return (this.evalBoolean(41) || this.evalBoolean(38)) && this.evalBoolean(39);
            }
            case 2: {
                return this.evalBoolean(41) || this.evalBoolean(38);
            }
            case 3: {
                return this.getBoolean(19244);
            }
            case 4: {
                return this.evalBoolean(42);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTDR_296(int n) {
        switch (n) {
            case 0: {
                return !this.evalBoolean(53) && this.evalBoolean(44);
            }
            case 1: {
                return !this.evalBoolean(53) && this.evalBoolean(50);
            }
            case 2: {
                return this.evalBoolean(41) || this.evalBoolean(38);
            }
            case 3: {
                return this.getInteger(-41091072) == 0;
            }
            case 4: {
                return this.getInteger(-41091072) == 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTEE_297(int n) {
        switch (n) {
            case 0: {
                return (this.getInteger(1192034560) == 1 || this.getInteger(1192034560) == 5) && this.evalBoolean(42);
            }
            case 1: {
                return this.getInteger(1192034560) == 2 && this.evalBoolean(52);
            }
            case 2: {
                return this.getInteger(1192034560) == 3 && this.evalBoolean(53);
            }
            case 3: {
                return this.getInteger(1192034560) == 4 && this.evalBoolean(37);
            }
            case 4: {
                return this.getInteger(-1381957632) == 0 && this.evalBoolean(42);
            }
            case 5: {
                return this.getInteger(-1381957632) == 2 && this.evalBoolean(42);
            }
            case 6: {
                return this.getBoolean(19244);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTESF_298(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(19244);
            }
            case 1: {
                return this.evalBoolean(52);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTESS_299(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(38) || this.evalBoolean(41);
            }
            case 1: {
                return this.getBoolean(19244);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTGGC_29B(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(109248512) == 0 && this.getInteger(68878592) == 0 && this.evalBoolean(35);
            }
            case 1: {
                return this.getInteger(109248512) == 0 && this.getInteger(68878592) == 1 && this.evalBoolean(35);
            }
            case 2: {
                return this.getInteger(109248512) == 0 && this.getInteger(68878592) == 2 && this.evalBoolean(35);
            }
            case 3: {
                return this.getInteger(109248512) == 0 && this.getInteger(68878592) == 3 && this.evalBoolean(35);
            }
            case 4: {
                return this.getInteger(109248512) == 1 && this.getInteger(-1276313600) == 0 && this.evalBoolean(39);
            }
            case 5: {
                return this.getInteger(109248512) == 1 && this.getInteger(-1276313600) == 1 && this.evalBoolean(39);
            }
            case 6: {
                return this.getInteger(109248512) == 1 && this.getInteger(-1276313600) == 2 && this.evalBoolean(39);
            }
            case 7: {
                return this.getInteger(109248512) == 1 && this.getInteger(-1276313600) == 3 && this.evalBoolean(39);
            }
            case 8: {
                return this.getInteger(109248512) == 1 && this.getInteger(-1276313600) == 4 && this.evalBoolean(39);
            }
            case 9: {
                return this.getInteger(109248512) == 1 && this.evalBoolean(41);
            }
            case 10: {
                return this.getInteger(109248512) == 2 && this.evalBoolean(38);
            }
            case 11: {
                return this.evalBoolean(31) && this.evalBoolean(37);
            }
            case 12: {
                return this.evalBoolean(32) && this.evalBoolean(37);
            }
            case 13: {
                return this.evalBoolean(33) && this.evalBoolean(37);
            }
            case 14: {
                return this.evalBoolean(42);
            }
            case 15: {
                return this.evalBoolean(37);
            }
            case 16: {
                return this.evalBoolean(42);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTGHMC_29C(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(68878592) == 0 && this.evalBoolean(35);
            }
            case 1: {
                return this.getInteger(68878592) == 1 && this.evalBoolean(35);
            }
            case 2: {
                return this.getInteger(68878592) == 2 && this.evalBoolean(35);
            }
            case 3: {
                return this.getInteger(68878592) == 3 && this.evalBoolean(35);
            }
            case 4: {
                return this.getInteger(109248512) == 1 && this.evalBoolean(41);
            }
            case 5: {
                return this.getInteger(109248512) == 2 && this.evalBoolean(38);
            }
            case 6: {
                return this.getInteger(-1276313600) == 0 && this.evalBoolean(39);
            }
            case 7: {
                return this.getInteger(-1276313600) == 1 && this.evalBoolean(39);
            }
            case 8: {
                return this.getInteger(-1276313600) == 2 && this.evalBoolean(39);
            }
            case 9: {
                return this.getInteger(-1276313600) == 3 && this.evalBoolean(39);
            }
            case 10: {
                return this.getInteger(-1276313600) == 4 && this.evalBoolean(39);
            }
            case 11: {
                return this.evalBoolean(42);
            }
            case 12: {
                return this.evalBoolean(53) || this.evalBoolean(52);
            }
            case 13: {
                return this.evalBoolean(37);
            }
            case 14: {
                return this.evalBoolean(52);
            }
            case 15: {
                return this.evalBoolean(37);
            }
            case 16: {
                return this.evalBoolean(42);
            }
            case 17: {
                return this.evalBoolean(52);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTHBCOOB_29D(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-41091072) == 0;
            }
            case 1: {
                return this.getInteger(-41091072) == 1;
            }
            case 2: {
                return this.evalBoolean(37);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTHBCSB_29E(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-41091072) == 0;
            }
            case 1: {
                return this.getInteger(-41091072) == 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTHBCTO_29F(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(37);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTHBCTO_2A0(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(37);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTHCS_2A3(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-41091072) == 0;
            }
            case 1: {
                return this.getInteger(-41091072) == 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTHFSTO_2A4(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(52);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTHFSTO_2A5(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(52);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTHFS_2A6(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-41091072) == 0;
            }
            case 1: {
                return this.getInteger(-41091072) == 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTHNBCOOB_2A7(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-41091072) == 0;
            }
            case 1: {
                return this.getInteger(-41091072) == 1;
            }
            case 2: {
                return this.evalBoolean(37);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTHNBCSB_2A8(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-41091072) == 0;
            }
            case 1: {
                return this.getInteger(-41091072) == 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTHNBCTO_2A9(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(37);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTHNBCTO_2AA(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 1: {
                return this.evalBoolean(37);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTHNCS_2AD(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-41091072) == 0;
            }
            case 1: {
                return this.getInteger(-41091072) == 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTHNFSTO_2AE(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(35) || this.evalBoolean(39);
            }
            case 1: {
                return this.evalBoolean(52);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTHNFSTO_2AF(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(35) || this.evalBoolean(39);
            }
            case 1: {
                return this.evalBoolean(52);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTHNFS_2B0(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-41091072) == 0;
            }
            case 1: {
                return this.getInteger(-41091072) == 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTHNSSTO_2B1(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(38) || this.evalBoolean(41);
            }
            case 1: {
                return this.evalBoolean(53);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTHNSSTO_2B2(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(38) || this.evalBoolean(41);
            }
            case 1: {
                return this.evalBoolean(53);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTHNSS_2B3(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-41091072) == 0;
            }
            case 1: {
                return this.getInteger(-41091072) == 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTHR_2B4(int n) {
        switch (n) {
            case 0: {
                return !this.evalBoolean(53);
            }
            case 1: {
                return (this.evalBoolean(38) || this.evalBoolean(41)) && this.evalBoolean(39);
            }
            case 2: {
                return this.evalBoolean(41) || this.evalBoolean(38);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTHSSTO_2B5(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(53);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTHSSTO_2B6(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(53);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTHSS_2B7(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(-41091072) == 0;
            }
            case 1: {
                return this.getInteger(-41091072) == 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTNCG_2B8(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(53);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTNEOL_2B9(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(53);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTNE_2BA(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(46);
            }
            case 1: {
                return this.evalBoolean(47);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTNFP_2BB(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(53);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTNLP_2BC(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(53);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTNL_2BD(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(19244);
            }
            case 1: {
                return this.evalBoolean(48);
            }
            case 2: {
                return this.evalBoolean(53);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTNNP_2BE(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(53);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTNN_2BF(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(48);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTNOOP_2C0(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(53);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTNOG_2C1(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(46);
            }
            case 1: {
                return this.evalBoolean(47);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTNPP_2C2(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(53);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTNRNSF_2C3(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(53);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTNSBRN_2C4(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(53);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTNTOL_2C5(int n) {
        switch (n) {
            case 0: {
                return this.evalBoolean(53);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSTNWS_2C6(int n) {
        switch (n) {
            case 0: {
                return this.getBoolean(19244);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    @Override
    protected void collectAllCommandsGuardedByOneCondition(ObjectArrayList objectArrayList, int n) {
        switch (this.sdFeatColId) {
            case 555: {
                this.collectAllCommandsGuardedByOneCondition_SSTCBA_27C(objectArrayList, n);
                break;
            }
            case 556: {
                this.collectAllCommandsGuardedByOneCondition_SSTCBAA_27D(objectArrayList, n);
                break;
            }
            case 557: {
                this.collectAllCommandsGuardedByOneCondition_SSTCBCD_27E(objectArrayList, n);
                break;
            }
            case 558: {
                this.collectAllCommandsGuardedByOneCondition_SSTCBD_27F(objectArrayList, n);
                break;
            }
            case 559: {
                this.collectAllCommandsGuardedByOneCondition_SSTCBF_280(objectArrayList, n);
                break;
            }
            case 560: {
                this.collectAllCommandsGuardedByOneCondition_SSTCLTR_282(objectArrayList, n);
                break;
            }
            case 561: {
                this.collectAllCommandsGuardedByOneCondition_SSTCSFA_285(objectArrayList, n);
                break;
            }
            case 562: {
                this.collectAllCommandsGuardedByOneCondition_SSTCSFDA_287(objectArrayList, n);
                break;
            }
            case 563: {
                this.collectAllCommandsGuardedByOneCondition_SSTCSFDF_289(objectArrayList, n);
                break;
            }
            case 564: {
                this.collectAllCommandsGuardedByOneCondition_SSTCSFF_28B(objectArrayList, n);
                break;
            }
            case 565: {
                this.collectAllCommandsGuardedByOneCondition_SSTCSSD_28C(objectArrayList, n);
                break;
            }
            case 566: {
                this.collectAllCommandsGuardedByOneCondition_SSTCSSDD_28D(objectArrayList, n);
                break;
            }
            case 567: {
                this.collectAllCommandsGuardedByOneCondition_SSTCSSDF_28E(objectArrayList, n);
                break;
            }
            case 568: {
                this.collectAllCommandsGuardedByOneCondition_SSTCSSF_290(objectArrayList, n);
                break;
            }
            case 569: {
                this.collectAllCommandsGuardedByOneCondition_SSTCSR_292(objectArrayList, n);
                break;
            }
            case 573: {
                this.collectAllCommandsGuardedByOneCondition_SSTDR_296(objectArrayList, n);
                break;
            }
            case 574: {
                this.collectAllCommandsGuardedByOneCondition_SSTEE_297(objectArrayList, n);
                break;
            }
            case 575: {
                this.collectAllCommandsGuardedByOneCondition_SSTESF_298(objectArrayList, n);
                break;
            }
            case 576: {
                this.collectAllCommandsGuardedByOneCondition_SSTESS_299(objectArrayList, n);
                break;
            }
            case 578: {
                this.collectAllCommandsGuardedByOneCondition_SSTGGC_29B(objectArrayList, n);
                break;
            }
            case 579: {
                this.collectAllCommandsGuardedByOneCondition_SSTGHMC_29C(objectArrayList, n);
                break;
            }
            case 580: {
                this.collectAllCommandsGuardedByOneCondition_SSTHBCOOB_29D(objectArrayList, n);
                break;
            }
            case 581: {
                this.collectAllCommandsGuardedByOneCondition_SSTHBCSB_29E(objectArrayList, n);
                break;
            }
            case 582: {
                this.collectAllCommandsGuardedByOneCondition_SSTHBCTO_29F(objectArrayList, n);
                break;
            }
            case 583: {
                this.collectAllCommandsGuardedByOneCondition_SSTHBCTO_2A0(objectArrayList, n);
                break;
            }
            case 586: {
                this.collectAllCommandsGuardedByOneCondition_SSTHCS_2A3(objectArrayList, n);
                break;
            }
            case 587: {
                this.collectAllCommandsGuardedByOneCondition_SSTHFSTO_2A4(objectArrayList, n);
                break;
            }
            case 588: {
                this.collectAllCommandsGuardedByOneCondition_SSTHFSTO_2A5(objectArrayList, n);
                break;
            }
            case 589: {
                this.collectAllCommandsGuardedByOneCondition_SSTHFS_2A6(objectArrayList, n);
                break;
            }
            case 590: {
                this.collectAllCommandsGuardedByOneCondition_SSTHNBCOOB_2A7(objectArrayList, n);
                break;
            }
            case 591: {
                this.collectAllCommandsGuardedByOneCondition_SSTHNBCSB_2A8(objectArrayList, n);
                break;
            }
            case 592: {
                this.collectAllCommandsGuardedByOneCondition_SSTHNBCTO_2A9(objectArrayList, n);
                break;
            }
            case 593: {
                this.collectAllCommandsGuardedByOneCondition_SSTHNBCTO_2AA(objectArrayList, n);
                break;
            }
            case 596: {
                this.collectAllCommandsGuardedByOneCondition_SSTHNCS_2AD(objectArrayList, n);
                break;
            }
            case 597: {
                this.collectAllCommandsGuardedByOneCondition_SSTHNFSTO_2AE(objectArrayList, n);
                break;
            }
            case 598: {
                this.collectAllCommandsGuardedByOneCondition_SSTHNFSTO_2AF(objectArrayList, n);
                break;
            }
            case 599: {
                this.collectAllCommandsGuardedByOneCondition_SSTHNFS_2B0(objectArrayList, n);
                break;
            }
            case 600: {
                this.collectAllCommandsGuardedByOneCondition_SSTHNSSTO_2B1(objectArrayList, n);
                break;
            }
            case 601: {
                this.collectAllCommandsGuardedByOneCondition_SSTHNSSTO_2B2(objectArrayList, n);
                break;
            }
            case 602: {
                this.collectAllCommandsGuardedByOneCondition_SSTHNSS_2B3(objectArrayList, n);
                break;
            }
            case 603: {
                this.collectAllCommandsGuardedByOneCondition_SSTHR_2B4(objectArrayList, n);
                break;
            }
            case 604: {
                this.collectAllCommandsGuardedByOneCondition_SSTHSSTO_2B5(objectArrayList, n);
                break;
            }
            case 605: {
                this.collectAllCommandsGuardedByOneCondition_SSTHSSTO_2B6(objectArrayList, n);
                break;
            }
            case 606: {
                this.collectAllCommandsGuardedByOneCondition_SSTHSS_2B7(objectArrayList, n);
                break;
            }
            case 607: {
                this.collectAllCommandsGuardedByOneCondition_SSTNCG_2B8(objectArrayList, n);
                break;
            }
            case 608: {
                this.collectAllCommandsGuardedByOneCondition_SSTNEOL_2B9(objectArrayList, n);
                break;
            }
            case 609: {
                this.collectAllCommandsGuardedByOneCondition_SSTNE_2BA(objectArrayList, n);
                break;
            }
            case 610: {
                this.collectAllCommandsGuardedByOneCondition_SSTNFP_2BB(objectArrayList, n);
                break;
            }
            case 611: {
                this.collectAllCommandsGuardedByOneCondition_SSTNLP_2BC(objectArrayList, n);
                break;
            }
            case 612: {
                this.collectAllCommandsGuardedByOneCondition_SSTNL_2BD(objectArrayList, n);
                break;
            }
            case 613: {
                this.collectAllCommandsGuardedByOneCondition_SSTNNP_2BE(objectArrayList, n);
                break;
            }
            case 614: {
                this.collectAllCommandsGuardedByOneCondition_SSTNN_2BF(objectArrayList, n);
                break;
            }
            case 615: {
                this.collectAllCommandsGuardedByOneCondition_SSTNOOP_2C0(objectArrayList, n);
                break;
            }
            case 616: {
                this.collectAllCommandsGuardedByOneCondition_SSTNOG_2C1(objectArrayList, n);
                break;
            }
            case 617: {
                this.collectAllCommandsGuardedByOneCondition_SSTNPP_2C2(objectArrayList, n);
                break;
            }
            case 618: {
                this.collectAllCommandsGuardedByOneCondition_SSTNRNSF_2C3(objectArrayList, n);
                break;
            }
            case 619: {
                this.collectAllCommandsGuardedByOneCondition_SSTNSBRN_2C4(objectArrayList, n);
                break;
            }
            case 620: {
                this.collectAllCommandsGuardedByOneCondition_SSTNTOL_2C5(objectArrayList, n);
                break;
            }
            case 621: {
                this.collectAllCommandsGuardedByOneCondition_SSTNWS_2C6(objectArrayList, n);
                break;
            }
            default: {
                super.collectAllCommandsGuardedByOneCondition(objectArrayList, n);
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSTCBA_27C(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTCBAA_27D(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTCBCD_27E(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
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
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSTCBD_27F(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTCBF_280(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTCLTR_282(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTCSFA_285(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTCSFDA_287(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                objectArrayList.add(this.createSingleCommand(1));
                break;
            }
            case 1: {
                objectArrayList.add(this.createSingleCommand(0));
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
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSTCSFDF_289(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                objectArrayList.add(this.createSingleCommand(1));
                break;
            }
            case 1: {
                objectArrayList.add(this.createSingleCommand(0));
                break;
            }
            case 2: {
                objectArrayList.add(this.createSingleCommand(2));
                break;
            }
            case 3: {
                objectArrayList.add(this.createSingleCommand(4));
                break;
            }
            case 4: {
                objectArrayList.add(this.createSingleCommand(3));
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

    private void collectAllCommandsGuardedByOneCondition_SSTCSFF_28B(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTCSSD_28C(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTCSSDD_28D(ObjectArrayList objectArrayList, int n) {
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
                objectArrayList.add(this.createSingleCommand(0));
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSTCSSDF_28E(ObjectArrayList objectArrayList, int n) {
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
                objectArrayList.add(this.createSingleCommand(0));
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSTCSSF_290(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTCSR_292(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTDR_296(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTEE_297(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTESF_298(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTESS_299(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTGGC_29B(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                objectArrayList.add(this.createSingleCommand(8));
                break;
            }
            case 1: {
                objectArrayList.add(this.createSingleCommand(7));
                break;
            }
            case 2: {
                objectArrayList.add(this.createSingleCommand(9));
                break;
            }
            case 3: {
                objectArrayList.add(this.createSingleCommand(10));
                break;
            }
            case 4: {
                objectArrayList.add(this.createSingleCommand(12));
                break;
            }
            case 5: {
                objectArrayList.add(this.createSingleCommand(11));
                break;
            }
            case 6: {
                objectArrayList.add(this.createSingleCommand(13));
                break;
            }
            case 7: {
                objectArrayList.add(this.createSingleCommand(15));
                break;
            }
            case 8: {
                objectArrayList.add(this.createSingleCommand(14));
                break;
            }
            case 9: {
                objectArrayList.add(this.createSingleCommand(18));
                break;
            }
            case 10: {
                objectArrayList.add(this.createSingleCommand(17));
                break;
            }
            case 11: {
                objectArrayList.add(this.createSingleCommand(1));
                break;
            }
            case 12: {
                objectArrayList.add(this.createSingleCommand(2));
                break;
            }
            case 13: {
                objectArrayList.add(this.createSingleCommand(3));
                break;
            }
            case 14: {
                objectArrayList.add(this.createSingleCommand(16));
                break;
            }
            case 15: {
                objectArrayList.add(this.createSingleCommand(0));
                break;
            }
            case 16: {
                objectArrayList.add(this.createSingleCommand(4));
                objectArrayList.add(this.createSingleCommand(5));
                objectArrayList.add(this.createSingleCommand(6));
                objectArrayList.add(this.createSingleCommand(19));
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSTGHMC_29C(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                objectArrayList.add(this.createSingleCommand(12));
                break;
            }
            case 1: {
                objectArrayList.add(this.createSingleCommand(11));
                break;
            }
            case 2: {
                objectArrayList.add(this.createSingleCommand(13));
                break;
            }
            case 3: {
                objectArrayList.add(this.createSingleCommand(14));
                break;
            }
            case 4: {
                objectArrayList.add(this.createSingleCommand(22));
                break;
            }
            case 5: {
                objectArrayList.add(this.createSingleCommand(21));
                break;
            }
            case 6: {
                objectArrayList.add(this.createSingleCommand(16));
                break;
            }
            case 7: {
                objectArrayList.add(this.createSingleCommand(15));
                break;
            }
            case 8: {
                objectArrayList.add(this.createSingleCommand(17));
                break;
            }
            case 9: {
                objectArrayList.add(this.createSingleCommand(19));
                break;
            }
            case 10: {
                objectArrayList.add(this.createSingleCommand(18));
                break;
            }
            case 11: {
                objectArrayList.add(this.createSingleCommand(20));
                break;
            }
            case 12: {
                objectArrayList.add(this.createSingleCommand(8));
                break;
            }
            case 13: {
                objectArrayList.add(this.createSingleCommand(5));
                break;
            }
            case 14: {
                objectArrayList.add(this.createSingleCommand(6));
                break;
            }
            case 15: {
                objectArrayList.add(this.createSingleCommand(0));
                objectArrayList.add(this.createSingleCommand(1));
                objectArrayList.add(this.createSingleCommand(2));
                objectArrayList.add(this.createSingleCommand(3));
                objectArrayList.add(this.createSingleCommand(4));
                break;
            }
            case 16: {
                objectArrayList.add(this.createSingleCommand(7));
                objectArrayList.add(this.createSingleCommand(9));
                objectArrayList.add(this.createSingleCommand(23));
                break;
            }
            case 17: {
                objectArrayList.add(this.createSingleCommand(10));
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSTHBCOOB_29D(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTHBCSB_29E(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTHBCTO_29F(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSTHBCTO_2A0(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSTHCS_2A3(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTHFSTO_2A4(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSTHFSTO_2A5(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSTHFS_2A6(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTHNBCOOB_2A7(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTHNBCSB_2A8(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTHNBCTO_2A9(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSTHNBCTO_2AA(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTHNCS_2AD(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTHNFSTO_2AE(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTHNFSTO_2AF(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTHNFS_2B0(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTHNSSTO_2B1(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTHNSSTO_2B2(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTHNSS_2B3(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTHR_2B4(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTHSSTO_2B5(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSTHSSTO_2B6(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSTHSS_2B7(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTNCG_2B8(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSTNEOL_2B9(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSTNE_2BA(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTNFP_2BB(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSTNLP_2BC(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSTNL_2BD(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            case 1: {
                break;
            }
            case 2: {
                objectArrayList.add(this.createSingleCommand(0));
                objectArrayList.add(this.createSingleCommand(1));
                objectArrayList.add(this.createSingleCommand(2));
                objectArrayList.add(this.createSingleCommand(3));
                objectArrayList.add(this.createSingleCommand(4));
                objectArrayList.add(this.createSingleCommand(5));
                objectArrayList.add(this.createSingleCommand(6));
                objectArrayList.add(this.createSingleCommand(7));
                objectArrayList.add(this.createSingleCommand(8));
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSTNNP_2BE(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSTNN_2BF(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSTNOOP_2C0(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSTNOG_2C1(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSTNPP_2C2(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSTNRNSF_2C3(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSTNSBRN_2C4(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSTNTOL_2C5(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSTNWS_2C6(ObjectArrayList objectArrayList, int n) {
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
            case 555: {
                return this.getAffectedFeatures_SSTCBA_27C(n);
            }
            case 556: {
                return this.getAffectedFeatures_SSTCBAA_27D(n);
            }
            case 557: {
                return this.getAffectedFeatures_SSTCBCD_27E(n);
            }
            case 558: {
                return this.getAffectedFeatures_SSTCBD_27F(n);
            }
            case 559: {
                return this.getAffectedFeatures_SSTCBF_280(n);
            }
            case 560: {
                return this.getAffectedFeatures_SSTCLTR_282(n);
            }
            case 561: {
                return this.getAffectedFeatures_SSTCSFA_285(n);
            }
            case 562: {
                return this.getAffectedFeatures_SSTCSFDA_287(n);
            }
            case 563: {
                return this.getAffectedFeatures_SSTCSFDF_289(n);
            }
            case 564: {
                return this.getAffectedFeatures_SSTCSFF_28B(n);
            }
            case 565: {
                return this.getAffectedFeatures_SSTCSSD_28C(n);
            }
            case 566: {
                return this.getAffectedFeatures_SSTCSSDD_28D(n);
            }
            case 567: {
                return this.getAffectedFeatures_SSTCSSDF_28E(n);
            }
            case 568: {
                return this.getAffectedFeatures_SSTCSSF_290(n);
            }
            case 569: {
                return this.getAffectedFeatures_SSTCSR_292(n);
            }
            case 573: {
                return this.getAffectedFeatures_SSTDR_296(n);
            }
            case 574: {
                return this.getAffectedFeatures_SSTEE_297(n);
            }
            case 575: {
                return this.getAffectedFeatures_SSTESF_298(n);
            }
            case 576: {
                return this.getAffectedFeatures_SSTESS_299(n);
            }
            case 578: {
                return this.getAffectedFeatures_SSTGGC_29B(n);
            }
            case 579: {
                return this.getAffectedFeatures_SSTGHMC_29C(n);
            }
            case 580: {
                return this.getAffectedFeatures_SSTHBCOOB_29D(n);
            }
            case 581: {
                return this.getAffectedFeatures_SSTHBCSB_29E(n);
            }
            case 582: {
                return this.getAffectedFeatures_SSTHBCTO_29F(n);
            }
            case 583: {
                return this.getAffectedFeatures_SSTHBCTO_2A0(n);
            }
            case 586: {
                return this.getAffectedFeatures_SSTHCS_2A3(n);
            }
            case 587: {
                return this.getAffectedFeatures_SSTHFSTO_2A4(n);
            }
            case 588: {
                return this.getAffectedFeatures_SSTHFSTO_2A5(n);
            }
            case 589: {
                return this.getAffectedFeatures_SSTHFS_2A6(n);
            }
            case 590: {
                return this.getAffectedFeatures_SSTHNBCOOB_2A7(n);
            }
            case 591: {
                return this.getAffectedFeatures_SSTHNBCSB_2A8(n);
            }
            case 592: {
                return this.getAffectedFeatures_SSTHNBCTO_2A9(n);
            }
            case 593: {
                return this.getAffectedFeatures_SSTHNBCTO_2AA(n);
            }
            case 596: {
                return this.getAffectedFeatures_SSTHNCS_2AD(n);
            }
            case 597: {
                return this.getAffectedFeatures_SSTHNFSTO_2AE(n);
            }
            case 598: {
                return this.getAffectedFeatures_SSTHNFSTO_2AF(n);
            }
            case 599: {
                return this.getAffectedFeatures_SSTHNFS_2B0(n);
            }
            case 600: {
                return this.getAffectedFeatures_SSTHNSSTO_2B1(n);
            }
            case 601: {
                return this.getAffectedFeatures_SSTHNSSTO_2B2(n);
            }
            case 602: {
                return this.getAffectedFeatures_SSTHNSS_2B3(n);
            }
            case 603: {
                return this.getAffectedFeatures_SSTHR_2B4(n);
            }
            case 604: {
                return this.getAffectedFeatures_SSTHSSTO_2B5(n);
            }
            case 605: {
                return this.getAffectedFeatures_SSTHSSTO_2B6(n);
            }
            case 606: {
                return this.getAffectedFeatures_SSTHSS_2B7(n);
            }
            case 607: {
                return this.getAffectedFeatures_SSTNCG_2B8(n);
            }
            case 608: {
                return this.getAffectedFeatures_SSTNEOL_2B9(n);
            }
            case 609: {
                return this.getAffectedFeatures_SSTNE_2BA(n);
            }
            case 610: {
                return this.getAffectedFeatures_SSTNFP_2BB(n);
            }
            case 611: {
                return this.getAffectedFeatures_SSTNLP_2BC(n);
            }
            case 612: {
                return this.getAffectedFeatures_SSTNL_2BD(n);
            }
            case 613: {
                return this.getAffectedFeatures_SSTNNP_2BE(n);
            }
            case 614: {
                return this.getAffectedFeatures_SSTNN_2BF(n);
            }
            case 615: {
                return this.getAffectedFeatures_SSTNOOP_2C0(n);
            }
            case 616: {
                return this.getAffectedFeatures_SSTNOG_2C1(n);
            }
            case 617: {
                return this.getAffectedFeatures_SSTNPP_2C2(n);
            }
            case 618: {
                return this.getAffectedFeatures_SSTNRNSF_2C3(n);
            }
            case 619: {
                return this.getAffectedFeatures_SSTNSBRN_2C4(n);
            }
            case 620: {
                return this.getAffectedFeatures_SSTNTOL_2C5(n);
            }
            case 621: {
                return this.getAffectedFeatures_SSTNWS_2C6(n);
            }
        }
        return super.getAffectedFeatures(n);
    }

    private int[] getAffectedFeatures_SSTCBA_27C(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTCBAA_27D(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTCBCD_27E(int n) {
        switch (n) {
            case 0: {
                return SSTCBCD_27E_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSTCBCD_27E_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 2: {
                return SSTCBCD_27E_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSTCBCD_27E_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
            case 5: {
                return SSTCBCD_27E_AFFECTED_FEATURES_FOR_CONDITION_5;
            }
            case 6: {
                return SSTCBCD_27E_AFFECTED_FEATURES_FOR_CONDITION_6;
            }
            case 7: {
                return SSTCBCD_27E_AFFECTED_FEATURES_FOR_CONDITION_7;
            }
            case 8: {
                return SSTCBCD_27E_AFFECTED_FEATURES_FOR_CONDITION_8;
            }
            case 9: {
                return SSTCBCD_27E_AFFECTED_FEATURES_FOR_CONDITION_9;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTCBD_27F(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTCBF_280(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTCLTR_282(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTCSFA_285(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTCSFDA_287(int n) {
        switch (n) {
            case 0: {
                return SSTCSFDA_287_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSTCSFDA_287_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 2: {
                return SSTCSFDA_287_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSTCSFDA_287_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
            case 5: {
                return SSTCSFDA_287_AFFECTED_FEATURES_FOR_CONDITION_5;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTCSFDF_289(int n) {
        switch (n) {
            case 0: {
                return SSTCSFDF_289_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSTCSFDF_289_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 2: {
                return SSTCSFDF_289_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSTCSFDF_289_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
            case 4: {
                return SSTCSFDF_289_AFFECTED_FEATURES_FOR_CONDITION_4;
            }
            case 7: {
                return SSTCSFDF_289_AFFECTED_FEATURES_FOR_CONDITION_7;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTCSFF_28B(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTCSSD_28C(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTCSSDD_28D(int n) {
        switch (n) {
            case 3: {
                return SSTCSSDD_28D_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTCSSDF_28E(int n) {
        switch (n) {
            case 4: {
                return SSTCSSDF_28E_AFFECTED_FEATURES_FOR_CONDITION_4;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTCSSF_290(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTCSR_292(int n) {
        switch (n) {
            case 0: {
                return SSTCSR_292_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSTCSR_292_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 2: {
                return SSTCSR_292_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTDR_296(int n) {
        switch (n) {
            case 0: {
                return SSTDR_296_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSTDR_296_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 2: {
                return SSTDR_296_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSTDR_296_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
            case 4: {
                return SSTDR_296_AFFECTED_FEATURES_FOR_CONDITION_4;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTEE_297(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTESF_298(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTESS_299(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTGGC_29B(int n) {
        switch (n) {
            case 0: {
                return SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 2: {
                return SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
            case 4: {
                return SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_4;
            }
            case 5: {
                return SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_5;
            }
            case 6: {
                return SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_6;
            }
            case 7: {
                return SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_7;
            }
            case 8: {
                return SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_8;
            }
            case 9: {
                return SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_9;
            }
            case 10: {
                return SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_10;
            }
            case 11: {
                return SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_11;
            }
            case 12: {
                return SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_12;
            }
            case 13: {
                return SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_13;
            }
            case 14: {
                return SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_14;
            }
            case 15: {
                return SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_15;
            }
            case 16: {
                return SSTGGC_29B_AFFECTED_FEATURES_FOR_CONDITION_16;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTGHMC_29C(int n) {
        switch (n) {
            case 0: {
                return SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 2: {
                return SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
            case 4: {
                return SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_4;
            }
            case 5: {
                return SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_5;
            }
            case 6: {
                return SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_6;
            }
            case 7: {
                return SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_7;
            }
            case 8: {
                return SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_8;
            }
            case 9: {
                return SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_9;
            }
            case 10: {
                return SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_10;
            }
            case 11: {
                return SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_11;
            }
            case 12: {
                return SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_12;
            }
            case 13: {
                return SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_13;
            }
            case 14: {
                return SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_14;
            }
            case 15: {
                return SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_15;
            }
            case 16: {
                return SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_16;
            }
            case 17: {
                return SSTGHMC_29C_AFFECTED_FEATURES_FOR_CONDITION_17;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTHBCOOB_29D(int n) {
        switch (n) {
            case 0: {
                return SSTHBCOOB_29D_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSTHBCOOB_29D_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTHBCSB_29E(int n) {
        switch (n) {
            case 0: {
                return SSTHBCSB_29E_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSTHBCSB_29E_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTHBCTO_29F(int n) {
        switch (n) {
            case 0: {
                return SSTHBCTO_29F_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTHBCTO_2A0(int n) {
        switch (n) {
            case 0: {
                return SSTHBCTO_2A0_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTHCS_2A3(int n) {
        switch (n) {
            case 0: {
                return SSTHCS_2A3_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSTHCS_2A3_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTHFSTO_2A4(int n) {
        switch (n) {
            case 0: {
                return SSTHFSTO_2A4_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTHFSTO_2A5(int n) {
        switch (n) {
            case 0: {
                return SSTHFSTO_2A5_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTHFS_2A6(int n) {
        switch (n) {
            case 0: {
                return SSTHFS_2A6_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSTHFS_2A6_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTHNBCOOB_2A7(int n) {
        switch (n) {
            case 0: {
                return SSTHNBCOOB_2A7_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSTHNBCOOB_2A7_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTHNBCSB_2A8(int n) {
        switch (n) {
            case 0: {
                return SSTHNBCSB_2A8_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSTHNBCSB_2A8_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTHNBCTO_2A9(int n) {
        switch (n) {
            case 0: {
                return SSTHNBCTO_2A9_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTHNBCTO_2AA(int n) {
        switch (n) {
            case 1: {
                return SSTHNBCTO_2AA_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTHNCS_2AD(int n) {
        switch (n) {
            case 0: {
                return SSTHNCS_2AD_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSTHNCS_2AD_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTHNFSTO_2AE(int n) {
        switch (n) {
            case 1: {
                return SSTHNFSTO_2AE_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTHNFSTO_2AF(int n) {
        switch (n) {
            case 1: {
                return SSTHNFSTO_2AF_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTHNFS_2B0(int n) {
        switch (n) {
            case 0: {
                return SSTHNFS_2B0_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSTHNFS_2B0_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTHNSSTO_2B1(int n) {
        switch (n) {
            case 1: {
                return SSTHNSSTO_2B1_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTHNSSTO_2B2(int n) {
        switch (n) {
            case 1: {
                return SSTHNSSTO_2B2_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTHNSS_2B3(int n) {
        switch (n) {
            case 0: {
                return SSTHNSS_2B3_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSTHNSS_2B3_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTHR_2B4(int n) {
        switch (n) {
            case 0: {
                return SSTHR_2B4_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSTHR_2B4_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 2: {
                return SSTHR_2B4_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTHSSTO_2B5(int n) {
        switch (n) {
            case 0: {
                return SSTHSSTO_2B5_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTHSSTO_2B6(int n) {
        switch (n) {
            case 0: {
                return SSTHSSTO_2B6_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTHSS_2B7(int n) {
        switch (n) {
            case 0: {
                return SSTHSS_2B7_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSTHSS_2B7_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTNCG_2B8(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTNEOL_2B9(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTNE_2BA(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTNFP_2BB(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTNLP_2BC(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTNL_2BD(int n) {
        switch (n) {
            case 1: {
                return SSTNL_2BD_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 2: {
                return SSTNL_2BD_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTNNP_2BE(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTNN_2BF(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTNOOP_2C0(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTNOG_2C1(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTNPP_2C2(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTNRNSF_2C3(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTNSBRN_2C4(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTNTOL_2C5(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSTNWS_2C6(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    @Override
    protected int[] getConditionsAffectedByProperty(int n) {
        switch (this.sdFeatColId) {
            case 557: {
                return this.getConditionsAffectedByProperty_SSTCBCD_27E(n);
            }
            case 562: {
                return this.getConditionsAffectedByProperty_SSTCSFDA_287(n);
            }
            case 563: {
                return this.getConditionsAffectedByProperty_SSTCSFDF_289(n);
            }
            case 566: {
                return this.getConditionsAffectedByProperty_SSTCSSDD_28D(n);
            }
            case 567: {
                return this.getConditionsAffectedByProperty_SSTCSSDF_28E(n);
            }
            case 569: {
                return this.getConditionsAffectedByProperty_SSTCSR_292(n);
            }
            case 573: {
                return this.getConditionsAffectedByProperty_SSTDR_296(n);
            }
            case 578: {
                return this.getConditionsAffectedByProperty_SSTGGC_29B(n);
            }
            case 579: {
                return this.getConditionsAffectedByProperty_SSTGHMC_29C(n);
            }
            case 580: {
                return this.getConditionsAffectedByProperty_SSTHBCOOB_29D(n);
            }
            case 581: {
                return this.getConditionsAffectedByProperty_SSTHBCSB_29E(n);
            }
            case 582: {
                return this.getConditionsAffectedByProperty_SSTHBCTO_29F(n);
            }
            case 583: {
                return this.getConditionsAffectedByProperty_SSTHBCTO_2A0(n);
            }
            case 586: {
                return this.getConditionsAffectedByProperty_SSTHCS_2A3(n);
            }
            case 587: {
                return this.getConditionsAffectedByProperty_SSTHFSTO_2A4(n);
            }
            case 588: {
                return this.getConditionsAffectedByProperty_SSTHFSTO_2A5(n);
            }
            case 589: {
                return this.getConditionsAffectedByProperty_SSTHFS_2A6(n);
            }
            case 590: {
                return this.getConditionsAffectedByProperty_SSTHNBCOOB_2A7(n);
            }
            case 591: {
                return this.getConditionsAffectedByProperty_SSTHNBCSB_2A8(n);
            }
            case 592: {
                return this.getConditionsAffectedByProperty_SSTHNBCTO_2A9(n);
            }
            case 593: {
                return this.getConditionsAffectedByProperty_SSTHNBCTO_2AA(n);
            }
            case 596: {
                return this.getConditionsAffectedByProperty_SSTHNCS_2AD(n);
            }
            case 597: {
                return this.getConditionsAffectedByProperty_SSTHNFSTO_2AE(n);
            }
            case 598: {
                return this.getConditionsAffectedByProperty_SSTHNFSTO_2AF(n);
            }
            case 599: {
                return this.getConditionsAffectedByProperty_SSTHNFS_2B0(n);
            }
            case 600: {
                return this.getConditionsAffectedByProperty_SSTHNSSTO_2B1(n);
            }
            case 601: {
                return this.getConditionsAffectedByProperty_SSTHNSSTO_2B2(n);
            }
            case 602: {
                return this.getConditionsAffectedByProperty_SSTHNSS_2B3(n);
            }
            case 603: {
                return this.getConditionsAffectedByProperty_SSTHR_2B4(n);
            }
            case 604: {
                return this.getConditionsAffectedByProperty_SSTHSSTO_2B5(n);
            }
            case 605: {
                return this.getConditionsAffectedByProperty_SSTHSSTO_2B6(n);
            }
            case 606: {
                return this.getConditionsAffectedByProperty_SSTHSS_2B7(n);
            }
            case 612: {
                return this.getConditionsAffectedByProperty_SSTNL_2BD(n);
            }
        }
        return super.getConditionsAffectedByProperty(n);
    }

    private int[] getConditionsAffectedByProperty_SSTCBCD_27E(int n) {
        switch (n) {
            case 67503: {
                return SSTCBCD_27E_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_AMAVAILABLE;
            }
            case 12357: {
                return SSTCBCD_27E_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_DABAVAILABLE;
            }
            case 10059: {
                return SSTCBCD_27E_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSTCBCD_27E_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTCSFDA_287(int n) {
        switch (n) {
            case 67503: {
                return SSTCSFDA_287_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_AMAVAILABLE;
            }
            case 10059: {
                return SSTCSFDA_287_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSTCSFDA_287_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
            case 72452: {
                return SSTCSFDA_287_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_TUNER_GET_CURRENT_AMFREQUENCY_SCALE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTCSFDF_289(int n) {
        switch (n) {
            case 10059: {
                return SSTCSFDF_289_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSTCSFDF_289_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
            case 60851: {
                return SSTCSFDF_289_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_TUNER_GET_CURRENT_FMFREQUENCY_SCALE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTCSSDD_28D(int n) {
        switch (n) {
            case 12357: {
                return SSTCSSDD_28D_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_DABAVAILABLE;
            }
            case 10059: {
                return SSTCSSDD_28D_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSTCSSDD_28D_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTCSSDF_28E(int n) {
        switch (n) {
            case 10059: {
                return SSTCSSDF_28E_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSTCSSDF_28E_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTCSR_292(int n) {
        switch (n) {
            case 12357: {
                return SSTCSR_292_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_DABAVAILABLE;
            }
            case 10059: {
                return SSTCSR_292_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSTCSR_292_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTDR_296(int n) {
        switch (n) {
            case 67503: {
                return SSTDR_296_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_AMAVAILABLE;
            }
            case 12357: {
                return SSTDR_296_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_DABAVAILABLE;
            }
            case 10059: {
                return SSTDR_296_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSTDR_296_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
            case 36349: {
                return SSTDR_296_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_TUNER_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTGGC_29B(int n) {
        switch (n) {
            case 67503: {
                return SSTGGC_29B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_AMAVAILABLE;
            }
            case 12357: {
                return SSTGGC_29B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_DABAVAILABLE;
            }
            case 10059: {
                return SSTGGC_29B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSTGGC_29B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
            case 72452: {
                return SSTGGC_29B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_TUNER_GET_CURRENT_AMFREQUENCY_SCALE;
            }
            case 33542: {
                return SSTGGC_29B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_TUNER_GET_CURRENT_BAND;
            }
            case 60851: {
                return SSTGGC_29B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_TUNER_GET_CURRENT_FMFREQUENCY_SCALE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTGHMC_29C(int n) {
        switch (n) {
            case 67503: {
                return SSTGHMC_29C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_AMAVAILABLE;
            }
            case 12357: {
                return SSTGHMC_29C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_DABAVAILABLE;
            }
            case 10059: {
                return SSTGHMC_29C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSTGHMC_29C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
            case 72452: {
                return SSTGHMC_29C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_TUNER_GET_CURRENT_AMFREQUENCY_SCALE;
            }
            case 33542: {
                return SSTGHMC_29C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_TUNER_GET_CURRENT_BAND;
            }
            case 60851: {
                return SSTGHMC_29C_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_TUNER_GET_CURRENT_FMFREQUENCY_SCALE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTHBCOOB_29D(int n) {
        switch (n) {
            case 36349: {
                return SSTHBCOOB_29D_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_TUNER_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTHBCSB_29E(int n) {
        switch (n) {
            case 36349: {
                return SSTHBCSB_29E_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_TUNER_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTHBCTO_29F(int n) {
        switch (n) {
            case 10059: {
                return SSTHBCTO_29F_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSTHBCTO_29F_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTHBCTO_2A0(int n) {
        switch (n) {
            case 10059: {
                return SSTHBCTO_2A0_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSTHBCTO_2A0_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTHCS_2A3(int n) {
        switch (n) {
            case 36349: {
                return SSTHCS_2A3_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_TUNER_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTHFSTO_2A4(int n) {
        switch (n) {
            case 67503: {
                return SSTHFSTO_2A4_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_AMAVAILABLE;
            }
            case 10059: {
                return SSTHFSTO_2A4_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSTHFSTO_2A4_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTHFSTO_2A5(int n) {
        switch (n) {
            case 67503: {
                return SSTHFSTO_2A5_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_AMAVAILABLE;
            }
            case 10059: {
                return SSTHFSTO_2A5_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSTHFSTO_2A5_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTHFS_2A6(int n) {
        switch (n) {
            case 36349: {
                return SSTHFS_2A6_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_TUNER_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTHNBCOOB_2A7(int n) {
        switch (n) {
            case 36349: {
                return SSTHNBCOOB_2A7_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_TUNER_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTHNBCSB_2A8(int n) {
        switch (n) {
            case 36349: {
                return SSTHNBCSB_2A8_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_TUNER_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTHNBCTO_2A9(int n) {
        switch (n) {
            case 10059: {
                return SSTHNBCTO_2A9_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSTHNBCTO_2A9_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTHNBCTO_2AA(int n) {
        switch (n) {
            case 10059: {
                return SSTHNBCTO_2AA_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSTHNBCTO_2AA_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTHNCS_2AD(int n) {
        switch (n) {
            case 36349: {
                return SSTHNCS_2AD_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_TUNER_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTHNFSTO_2AE(int n) {
        switch (n) {
            case 67503: {
                return SSTHNFSTO_2AE_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_AMAVAILABLE;
            }
            case 10059: {
                return SSTHNFSTO_2AE_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSTHNFSTO_2AE_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTHNFSTO_2AF(int n) {
        switch (n) {
            case 67503: {
                return SSTHNFSTO_2AF_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_AMAVAILABLE;
            }
            case 10059: {
                return SSTHNFSTO_2AF_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSTHNFSTO_2AF_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTHNFS_2B0(int n) {
        switch (n) {
            case 36349: {
                return SSTHNFS_2B0_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_TUNER_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTHNSSTO_2B1(int n) {
        switch (n) {
            case 12357: {
                return SSTHNSSTO_2B1_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_DABAVAILABLE;
            }
            case 10059: {
                return SSTHNSSTO_2B1_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSTHNSSTO_2B1_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTHNSSTO_2B2(int n) {
        switch (n) {
            case 12357: {
                return SSTHNSSTO_2B2_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_DABAVAILABLE;
            }
            case 10059: {
                return SSTHNSSTO_2B2_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSTHNSSTO_2B2_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTHNSS_2B3(int n) {
        switch (n) {
            case 36349: {
                return SSTHNSS_2B3_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_TUNER_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTHR_2B4(int n) {
        switch (n) {
            case 12357: {
                return SSTHR_2B4_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_DABAVAILABLE;
            }
            case 10059: {
                return SSTHR_2B4_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSTHR_2B4_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTHSSTO_2B5(int n) {
        switch (n) {
            case 12357: {
                return SSTHSSTO_2B5_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_DABAVAILABLE;
            }
            case 10059: {
                return SSTHSSTO_2B5_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSTHSSTO_2B5_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTHSSTO_2B6(int n) {
        switch (n) {
            case 12357: {
                return SSTHSSTO_2B6_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_DABAVAILABLE;
            }
            case 10059: {
                return SSTHSSTO_2B6_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSTHSSTO_2B6_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTHSS_2B7(int n) {
        switch (n) {
            case 36349: {
                return SSTHSS_2B7_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_TUNER_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSTNL_2BD(int n) {
        switch (n) {
            case 12357: {
                return SSTNL_2BD_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_DABAVAILABLE;
            }
            case 10059: {
                return SSTNL_2BD_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSTNL_2BD_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
            case 42240: {
                return SSTNL_2BD_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_TUNER_NBEST_ENTRY_MODE;
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
            default: 
        }
        super.updateAffectedFeature(n);
    }
}

