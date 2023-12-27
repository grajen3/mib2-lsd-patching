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
import de.vw.mib.sdfeaturecollectionmanager.internal.AbstractSdFeatureCollectionHandler$SdCommandData;
import generated.de.vw.mib.global.datapool.SdFeatureCollectionHandlerBase;
import java.util.ArrayList;

public final class SpeechGeneralSdfch
extends SdFeatureCollectionHandlerBase {
    private static int[] SSGDMM_11_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSGDMM_11_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSGDMM_11_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{0};
    private static int[] SSGDMM_11_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{0};
    private static int[] SSGDMM_11_AFFECTED_FEATURES_FOR_CONDITION_4 = new int[]{0};
    private static int[] SSGDMM_11_AFFECTED_FEATURES_FOR_CONDITION_5 = new int[]{1};
    private static int[] SSGDMM_11_AFFECTED_FEATURES_FOR_CONDITION_6 = new int[]{1};
    private static int[] SSGDMM_11_AFFECTED_FEATURES_FOR_CONDITION_7 = new int[]{0};
    private static int[] SSGDMM_11_AFFECTED_FEATURES_FOR_CONDITION_8 = new int[]{1};
    private static int[] SSGDMM_11_AFFECTED_FEATURES_FOR_CONDITION_9 = new int[]{1};
    private static int[] SSGDMM_11_AFFECTED_FEATURES_FOR_CONDITION_10 = new int[]{1};
    private static int[] SSGDMM_11_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
    private static int[] SSGDMM_11_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
    private static int[] SSGDMM_11_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_GENERAL_HELP_MODE = new int[]{9, 10};
    private static int[] SSGDTDC_24_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{4};
    private static int[] SSGDTDC_24_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{4};
    private static int[] SSGDTDC_24_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_GENERAL_HELP_MODE = new int[]{2, 3};
    private static int[] SSGDTHS_25_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{4};
    private static int[] SSGDTHS_25_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{4};
    private static int[] SSGDTHS_25_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_GENERAL_HELP_MODE = new int[]{2, 3};
    private static int[] SSGDTNDC_26_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{4};
    private static int[] SSGDTNDC_26_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{4};
    private static int[] SSGDTNDC_26_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_GENERAL_HELP_MODE = new int[]{2, 3};
    private static int[] SSGDTNHS_27_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{4};
    private static int[] SSGDTNHS_27_AFFECTED_FEATURES_FOR_CONDITION_3 = new int[]{4};
    private static int[] SSGDTNHS_27_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_GENERAL_HELP_MODE = new int[]{2, 3};
    private static int[] SSGGG_2A_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSGGG_2A_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSGGG_2A_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{0};
    private static int[] SSGGG_2A_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_EXT_PHONE_AVAILABLE = new int[]{0};
    private static int[] SSGGG_2A_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_INT_PHONE_AVAILABLE = new int[]{0};
    private static int[] SSGGG_2A_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_GENERAL_OUT_OF_DOMAIN_REQUEST_GET_CONCIERGE_CALL_STATE = new int[]{2};
    private static int[] SSGGG_2A_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SYSTEM_IS_NAVIGATION_CONTEXT_AVAILABLE_DIAG = new int[]{1};
    private static int[] SSGGH_2B_AFFECTED_FEATURES_FOR_CONDITION_0 = new int[]{0};
    private static int[] SSGGH_2B_AFFECTED_FEATURES_FOR_CONDITION_1 = new int[]{0};
    private static int[] SSGGH_2B_AFFECTED_FEATURES_FOR_CONDITION_2 = new int[]{0};
    private static int[] SSGGH_2B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_EXT_PHONE_AVAILABLE = new int[]{0};
    private static int[] SSGGH_2B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_INT_PHONE_AVAILABLE = new int[]{0};
    private static int[] SSGGH_2B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_GENERAL_OUT_OF_DOMAIN_REQUEST_GET_CONCIERGE_CALL_STATE = new int[]{2};
    private static int[] SSGGH_2B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SYSTEM_IS_NAVIGATION_CONTEXT_AVAILABLE_DIAG = new int[]{1};

    @Override
    public void init(int n, int n2) {
        this.sdFeatColId = n;
        this.speechClientId = n2;
        switch (n) {
            case 11: {
                this.featureData = new int[]{0};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 12: {
                this.featureData = new int[]{1, 3};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 13: {
                this.conditions = new boolean[11];
                this.dpProperties = new int[]{10059, 0x7A00000, 16664};
                this.featureData = new int[]{1, 3};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 14: {
                this.featureData = new int[]{3};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 15: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 16: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 17: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 18: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 19: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 20: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 21: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 22: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 23: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 24: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 25: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 26: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 27: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 28: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 29: {
                this.featureData = new int[]{0, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 30: {
                this.featureData = new int[]{1, 3};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 31: {
                this.featureData = new int[]{0, 0, 0};
                this.featuresToUpdate = new boolean[3];
                break;
            }
            case 32: {
                this.conditions = new boolean[4];
                this.dpProperties = new int[]{16664};
                this.featureData = new int[]{0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 33: {
                this.conditions = new boolean[4];
                this.dpProperties = new int[]{16664};
                this.featureData = new int[]{0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 34: {
                this.conditions = new boolean[4];
                this.dpProperties = new int[]{16664};
                this.featureData = new int[]{0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 35: {
                this.conditions = new boolean[4];
                this.dpProperties = new int[]{16664};
                this.featureData = new int[]{0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 36: {
                this.conditions = new boolean[2];
                this.featureData = new int[]{0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 37: {
                this.conditions = new boolean[2];
                this.featureData = new int[]{0, 0, 0, 1, 3};
                this.featuresToUpdate = new boolean[5];
                break;
            }
            case 38: {
                this.conditions = new boolean[3];
                this.dpProperties = new int[]{20317, 30686, 12221, 22877};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(58, 13905984, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(60, 164900928, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(62, 47460416, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(63, 433336384, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(64, 215232576, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(65, 81014848, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(66, 131346496, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(67, 181678144, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(68, 97792064, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(69, 282341440, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(77, 114569280, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(78, 232009792, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(79, 248787008, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(83, 265564224, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(84, 299118656, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(85, 64237632, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(86, 148123712, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(87, 198455360, 1, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(90, 30683200, 1, false, false)};
                this.featureData = new int[]{1, 0};
                this.featuresToUpdate = new boolean[2];
                break;
            }
            case 39: {
                this.conditions = new boolean[3];
                this.dpProperties = new int[]{20317, 30686, 12221, 22877};
                this.commandFeatureIndex = 0;
                this.sdCommandData = new AbstractSdFeatureCollectionHandler$SdCommandData[]{new AbstractSdFeatureCollectionHandler$SdCommandData(58, 13905984, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(60, 164900928, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(62, 47460416, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(63, 433336384, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(64, 215232576, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(65, 81014848, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(66, 131346496, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(67, 181678144, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(68, 97792064, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(69, 282341440, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(77, 114569280, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(78, 232009792, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(79, 248787008, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(83, 265564224, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(84, 299118656, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(85, 64237632, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(86, 148123712, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(87, 198455360, 2, false, false), new AbstractSdFeatureCollectionHandler$SdCommandData(90, 13905984, 2, false, false)};
                this.featureData = new int[]{1};
                this.featuresToUpdate = new boolean[1];
                break;
            }
            case 40: {
                this.featureData = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                this.featuresToUpdate = new boolean[12];
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
            case 11: {
                return this.createFeatureInstance_SSGDA_0F(n);
            }
            case 12: {
                return this.createFeatureInstance_SSGDI_10(n);
            }
            case 13: {
                return this.createFeatureInstance_SSGDMM_11(n);
            }
            case 14: {
                return this.createFeatureInstance_SSGDNVT_12(n);
            }
            case 15: {
                return this.createFeatureInstance_SSGDOC_13(n);
            }
            case 16: {
                return this.createFeatureInstance_SSGDOC_14(n);
            }
            case 17: {
                return this.createFeatureInstance_SSGDOCC_15(n);
            }
            case 18: {
                return this.createFeatureInstance_SSGDOE_16(n);
            }
            case 19: {
                return this.createFeatureInstance_SSGDOM_17(n);
            }
            case 20: {
                return this.createFeatureInstance_SSGDOM_18(n);
            }
            case 21: {
                return this.createFeatureInstance_SSGDOM_19(n);
            }
            case 22: {
                return this.createFeatureInstance_SSGDON_1A(n);
            }
            case 23: {
                return this.createFeatureInstance_SSGDOS_1B(n);
            }
            case 24: {
                return this.createFeatureInstance_SSGDOS_1C(n);
            }
            case 25: {
                return this.createFeatureInstance_SSGDOS_1D(n);
            }
            case 26: {
                return this.createFeatureInstance_SSGDOT_1E(n);
            }
            case 27: {
                return this.createFeatureInstance_SSGDOT_1F(n);
            }
            case 28: {
                return this.createFeatureInstance_SSGDOVG_20(n);
            }
            case 29: {
                return this.createFeatureInstance_SSGDSH_21(n);
            }
            case 30: {
                return this.createFeatureInstance_SSGDSM_22(n);
            }
            case 31: {
                return this.createFeatureInstance_SSGDS_23(n);
            }
            case 32: {
                return this.createFeatureInstance_SSGDTDC_24(n);
            }
            case 33: {
                return this.createFeatureInstance_SSGDTHS_25(n);
            }
            case 34: {
                return this.createFeatureInstance_SSGDTNDC_26(n);
            }
            case 35: {
                return this.createFeatureInstance_SSGDTNHS_27(n);
            }
            case 36: {
                return this.createFeatureInstance_SSGDTNVB_28(n);
            }
            case 37: {
                return this.createFeatureInstance_SSGDTVB_29(n);
            }
            case 38: {
                return this.createFeatureInstance_SSGGG_2A(n);
            }
            case 39: {
                return this.createFeatureInstance_SSGGH_2B(n);
            }
            case 40: {
                return this.createFeatureInstance_SSGGMF_2C(n);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal sdFeatColId: ").append(this.sdFeatColId).toString());
    }

    private Feature createFeatureInstance_SSGDA_0F(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(202);
                genericTargetFeature.setBoolean(2010, false);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSGDI_10(int n) {
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
                    object = this.getI18nString(5517);
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

    private Feature createFeatureInstance_SSGDMM_11(int n) {
        switch (n) {
            case 0: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[7]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{494}, 0));
                }
                if (this.conditions[1]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{495}, 0));
                }
                if (this.conditions[3]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{498}, 0));
                }
                if (this.conditions[4]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{496}, 0));
                }
                if (this.conditions[0]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{497}, 0));
                }
                if (this.conditions[2]) {
                    arrayList.add(this.createOrderedPrompts(new int[]{499}, 0));
                }
                arrayList.add(this.createOrderedPrompts(new int[]{493}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 1: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (this.conditions[10] && object == null) {
                    object = this.getI18nString(5516);
                    bl = false;
                }
                if (this.conditions[9] && object == null) {
                    object = this.getI18nString(5511);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                if (this.conditions[8]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5507), false));
                }
                if (this.conditions[8]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5504), false));
                }
                if (this.conditions[8]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5519), false));
                }
                if (this.conditions[6]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5521), false));
                }
                if (this.conditions[5]) {
                    ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5514), false));
                }
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 1);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSGDNVT_12(int n) {
        switch (n) {
            case 0: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (object == null) {
                    object = this.getI18nString(5517);
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

    private Feature createFeatureInstance_SSGDOC_13(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechGeneralSdfch.createPrompt(501));
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

    private Feature createFeatureInstance_SSGDOC_14(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechGeneralSdfch.createPrompt(502));
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

    private Feature createFeatureInstance_SSGDOCC_15(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechGeneralSdfch.createPrompt(503));
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

    private Feature createFeatureInstance_SSGDOE_16(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechGeneralSdfch.createPrompt(504));
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

    private Feature createFeatureInstance_SSGDOM_17(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechGeneralSdfch.createPrompt(505));
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

    private Feature createFeatureInstance_SSGDOM_18(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechGeneralSdfch.createPrompt(506));
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

    private Feature createFeatureInstance_SSGDOM_19(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechGeneralSdfch.createPrompt(507));
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

    private Feature createFeatureInstance_SSGDON_1A(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechGeneralSdfch.createPrompt(508));
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

    private Feature createFeatureInstance_SSGDOS_1B(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechGeneralSdfch.createPrompt(509));
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

    private Feature createFeatureInstance_SSGDOS_1C(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechGeneralSdfch.createPrompt(510));
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

    private Feature createFeatureInstance_SSGDOS_1D(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechGeneralSdfch.createPrompt(511));
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

    private Feature createFeatureInstance_SSGDOT_1E(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechGeneralSdfch.createPrompt(512));
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

    private Feature createFeatureInstance_SSGDOT_1F(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechGeneralSdfch.createPrompt(513));
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

    private Feature createFeatureInstance_SSGDOVG_20(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechGeneralSdfch.createPrompt(514));
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

    private Feature createFeatureInstance_SSGDSH_21(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(124226889));
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

    private Feature createFeatureInstance_SSGDSM_22(int n) {
        switch (n) {
            case 0: {
                ComplexHelpPromptsFeature complexHelpPromptsFeature = this.createHelpPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.createOrderedPrompts(new int[]{491}, 0));
                Object[] objectArray = new OrderedPrompts[arrayList.size()];
                arrayList.toArray(objectArray);
                complexHelpPromptsFeature.setHelpPrompts((OrderedPrompts[])objectArray);
                return complexHelpPromptsFeature;
            }
            case 1: {
                ComplexTeleprompterDataFeature complexTeleprompterDataFeature = this.createTeleprompterDataFeature();
                Object object = null;
                boolean bl = false;
                if (object == null) {
                    object = this.getI18nString(5522);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 3);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSGDS_23(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                arrayList.add(SpeechGeneralSdfch.createPrompt(527));
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(141004105));
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

    private Feature createFeatureInstance_SSGDTDC_24(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechGeneralSdfch.createPrompt(536));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(157781321));
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, this.conditions[0]);
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
                arrayList.add(this.createOrderedPrompts(new int[]{534}, 0));
                arrayList.add(this.createOrderedPrompts(new int[]{535}, 0));
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
                    object = this.getI18nString(5506);
                    bl = false;
                }
                if (this.conditions[2] && object == null) {
                    object = this.getI18nString(5511);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5508), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5520), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5518), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSGDTHS_25(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechGeneralSdfch.createPrompt(538));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(174558537));
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, this.conditions[0]);
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
                arrayList.add(this.createOrderedPrompts(new int[]{537}, 0));
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
                    object = this.getI18nString(5512);
                    bl = false;
                }
                if (this.conditions[2] && object == null) {
                    object = this.getI18nString(5511);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5509), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5525), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5510), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSGDTNDC_26(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechGeneralSdfch.createPrompt(539));
                }
                if (this.conditions[0]) {
                    arrayList.add(SpeechGeneralSdfch.createPrompt(540));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(157781321));
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, this.conditions[0]);
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
                arrayList.add(this.createOrderedPrompts(new int[]{539}, 0));
                arrayList.add(this.createOrderedPrompts(new int[]{540}, 0));
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
                    object = this.getI18nString(5527);
                    bl = false;
                }
                if (this.conditions[2] && object == null) {
                    object = this.getI18nString(5528);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5508), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5520), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5518), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSGDTNHS_27(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechGeneralSdfch.createPrompt(542));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(174558537));
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, this.conditions[0]);
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
                arrayList.add(this.createOrderedPrompts(new int[]{542}, 0));
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
                    object = this.getI18nString(5529);
                    bl = false;
                }
                if (this.conditions[2] && object == null) {
                    object = this.getI18nString(5528);
                    bl = false;
                }
                DynamicString dynamicString = this.createDynamicString((String)object, bl);
                complexTeleprompterDataFeature.setHeadline(dynamicString);
                object = new ArrayList();
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5509), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5525), false));
                ((ArrayList)object).add(this.createDynamicString(this.getI18nString(5510), false));
                Object[] objectArray = new DynamicString[((ArrayList)object).size()];
                ((ArrayList)object).toArray(objectArray);
                complexTeleprompterDataFeature.setCommandExamples((DynamicString[])objectArray);
                complexTeleprompterDataFeature.setInt(3081, 2);
                return complexTeleprompterDataFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSGDTNVB_28(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechGeneralSdfch.createPrompt(544));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(191335753));
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, this.conditions[0]);
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
                arrayList.add(this.createOrderedPrompts(new int[]{544}, 0));
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
                    object = this.getI18nString(5531);
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

    private Feature createFeatureInstance_SSGDTVB_29(int n) {
        switch (n) {
            case 0: {
                ComplexInitialPromptsFeature complexInitialPromptsFeature = this.createInitialPromptsFeature();
                ArrayList arrayList = new ArrayList();
                if (this.conditions[0]) {
                    arrayList.add(SpeechGeneralSdfch.createPrompt(547));
                }
                Object[] objectArray = new Prompt[arrayList.size()];
                arrayList.toArray(objectArray);
                complexInitialPromptsFeature.setInitialPrompts((Prompt[])objectArray);
                return complexInitialPromptsFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(301);
                genericTargetFeature.setBoolean(3011, true);
                genericTargetFeature.setEvent(3010, this.createEvent(191335753));
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(305);
                genericTargetFeature.setBoolean(3005, this.conditions[0]);
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
                arrayList.add(this.createOrderedPrompts(new int[]{546}, 0));
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
                    object = this.getI18nString(5524);
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

    private Feature createFeatureInstance_SSGGG_2A(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(201);
                genericTargetFeature.setEvent(2001, this.createEvent(828411209));
                genericTargetFeature.setEvent(2006, this.createEvent(208112969));
                genericTargetFeature.setEvent(2007, this.createEvent(224890185));
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSGGH_2B(int n) {
        switch (n) {
            case 0: {
                ComplexCommandFeature complexCommandFeature = this.createCommandFeatureAndFillItWithCommandsToLoad();
                return complexCommandFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    private Feature createFeatureInstance_SSGGMF_2C(int n) {
        switch (n) {
            case 0: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(103);
                genericTargetFeature.setOrderedPrompts(1020, this.createOrderedPrompts(new int[]{489}, 0));
                genericTargetFeature.setOrderedPrompts(1021, this.createOrderedPrompts(new int[]{548}, 0));
                genericTargetFeature.setOrderedPrompts(1022, this.createOrderedPrompts(new int[]{531}, 0));
                genericTargetFeature.setOrderedPrompts(1023, this.createOrderedPrompts(new int[]{533}, 0));
                genericTargetFeature.setOrderedPrompts(1024, this.createOrderedPrompts(new int[]{532}, 0));
                return genericTargetFeature;
            }
            case 1: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(104);
                genericTargetFeature.setInt(1030, 57);
                genericTargetFeature.setOrderedPrompts(1031, this.createOrderedPrompts(new int[]{490}, 0));
                return genericTargetFeature;
            }
            case 2: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(108);
                genericTargetFeature.setOrderedPrompts(1070, this.createOrderedPrompts(new int[]{521, 522, 523}, 0));
                return genericTargetFeature;
            }
            case 3: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(101);
                genericTargetFeature.setInt(1001, 55);
                genericTargetFeature.setOrderedPrompts(1002, this.createOrderedPrompts(new int[]{487}, 0));
                return genericTargetFeature;
            }
            case 4: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(102);
                genericTargetFeature.setInt(1010, 56);
                genericTargetFeature.setOrderedPrompts(1011, this.createOrderedPrompts(new int[]{488}, 0));
                return genericTargetFeature;
            }
            case 5: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(105);
                genericTargetFeature.setEvent(1041, this.createEvent(845188425));
                genericTargetFeature.setInt(1040, 59);
                genericTargetFeature.setOrderedPrompts(1042, this.createOrderedPrompts(new int[]{500}, 0));
                return genericTargetFeature;
            }
            case 6: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(106);
                genericTargetFeature.setOrderedPrompts(1050, this.createOrderedPrompts(new int[]{515, 516, 517}, 0));
                return genericTargetFeature;
            }
            case 7: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(107);
                genericTargetFeature.setOrderedPrompts(1062, this.createOrderedPrompts(new int[]{520}, 0));
                genericTargetFeature.setOrderedPrompts(1063, this.createOrderedPrompts(new int[]{519}, 0));
                genericTargetFeature.setInt(1060, 88);
                genericTargetFeature.setOrderedPrompts(1061, this.createOrderedPrompts(new int[]{518}, 0));
                return genericTargetFeature;
            }
            case 8: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(109);
                genericTargetFeature.setOrderedPrompts(1081, this.createOrderedPrompts(new int[]{524}, 0));
                genericTargetFeature.setInt(1080, 89);
                return genericTargetFeature;
            }
            case 9: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(110);
                genericTargetFeature.setOrderedPrompts(1090, this.createOrderedPrompts(new int[]{525, 526}, 0));
                return genericTargetFeature;
            }
            case 10: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(111);
                genericTargetFeature.setInt(1100, 492);
                return genericTargetFeature;
            }
            case 11: {
                GenericTargetFeature genericTargetFeature = this.createGenericFeature(112);
                genericTargetFeature.setOrderedPrompts(1113, this.createOrderedPrompts(new int[]{this.evalInt(12)}, 0));
                genericTargetFeature.setOrderedPrompts(1112, this.createOrderedPrompts(new int[]{this.evalInt(13)}, 0));
                genericTargetFeature.setInt(1111, 91);
                genericTargetFeature.setInt(1110, 92);
                return genericTargetFeature;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal feature index: ").append(n).toString());
    }

    @Override
    protected void collectAllUnconditionalCommands(ObjectArrayList objectArrayList) {
        switch (this.sdFeatColId) {
            case 38: {
                this.collectAllUnconditionalCommands_SSGGG_2A(objectArrayList);
                break;
            }
            case 39: {
                this.collectAllUnconditionalCommands_SSGGH_2B(objectArrayList);
                break;
            }
            default: {
                super.collectAllUnconditionalCommands(objectArrayList);
            }
        }
    }

    private void collectAllUnconditionalCommands_SSGGG_2A(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(4));
        objectArrayList.add(this.createSingleCommand(5));
        objectArrayList.add(this.createSingleCommand(6));
        objectArrayList.add(this.createSingleCommand(7));
        objectArrayList.add(this.createSingleCommand(8));
        objectArrayList.add(this.createSingleCommand(10));
        objectArrayList.add(this.createSingleCommand(11));
        objectArrayList.add(this.createSingleCommand(12));
        objectArrayList.add(this.createSingleCommand(13));
        objectArrayList.add(this.createSingleCommand(15));
        objectArrayList.add(this.createSingleCommand(16));
        objectArrayList.add(this.createSingleCommand(17));
        objectArrayList.add(this.createSingleCommand(18));
    }

    private void collectAllUnconditionalCommands_SSGGH_2B(ObjectArrayList objectArrayList) {
        objectArrayList.add(this.createSingleCommand(0));
        objectArrayList.add(this.createSingleCommand(1));
        objectArrayList.add(this.createSingleCommand(2));
        objectArrayList.add(this.createSingleCommand(4));
        objectArrayList.add(this.createSingleCommand(5));
        objectArrayList.add(this.createSingleCommand(6));
        objectArrayList.add(this.createSingleCommand(7));
        objectArrayList.add(this.createSingleCommand(8));
        objectArrayList.add(this.createSingleCommand(10));
        objectArrayList.add(this.createSingleCommand(11));
        objectArrayList.add(this.createSingleCommand(12));
        objectArrayList.add(this.createSingleCommand(13));
        objectArrayList.add(this.createSingleCommand(15));
        objectArrayList.add(this.createSingleCommand(16));
        objectArrayList.add(this.createSingleCommand(17));
        objectArrayList.add(this.createSingleCommand(18));
    }

    @Override
    protected boolean evaluateCondition(int n) {
        switch (this.sdFeatColId) {
            case 13: {
                return this.evaluateCondition_SSGDMM_11(n);
            }
            case 32: {
                return this.evaluateCondition_SSGDTDC_24(n);
            }
            case 33: {
                return this.evaluateCondition_SSGDTHS_25(n);
            }
            case 34: {
                return this.evaluateCondition_SSGDTNDC_26(n);
            }
            case 35: {
                return this.evaluateCondition_SSGDTNHS_27(n);
            }
            case 36: {
                return this.evaluateCondition_SSGDTNVB_28(n);
            }
            case 37: {
                return this.evaluateCondition_SSGDTVB_29(n);
            }
            case 38: {
                return this.evaluateCondition_SSGGG_2A(n);
            }
            case 39: {
                return this.evaluateCondition_SSGGH_2B(n);
            }
        }
        return super.evaluateCondition(n);
    }

    private boolean evaluateCondition_SSGDMM_11(int n) {
        switch (n) {
            case 0: {
                return !(this.getBoolean(0x7A00000) && this.getBoolean(10059)) && !(this.getBoolean(0x7A00000) && this.getBoolean(10059)) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 1: {
                return !(this.getBoolean(0x7A00000) && this.getBoolean(10059)) && this.getBoolean(0x7A00000) && this.getBoolean(10059) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 2: {
                return !(this.getBoolean(0x7A00000) && this.getBoolean(10059)) && !(this.getBoolean(0x7A00000) && this.getBoolean(10059));
            }
            case 3: {
                return !(this.getBoolean(0x7A00000) && this.getBoolean(10059)) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 4: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059) && !(this.getBoolean(0x7A00000) && this.getBoolean(10059)) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 5: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059) && !(this.getBoolean(0x7A00000) && this.getBoolean(10059)) && !(this.getBoolean(0x7A00000) && this.getBoolean(10059));
            }
            case 6: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059) && !(this.getBoolean(0x7A00000) && this.getBoolean(10059));
            }
            case 7: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059) && this.getBoolean(0x7A00000) && this.getBoolean(10059) && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 8: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 9: {
                return this.getInteger(16664) == 0;
            }
            case 10: {
                return this.getInteger(16664) == 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSGDTDC_24(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(30104) == 0;
            }
            case 1: {
                return this.getInteger(30104) == 1;
            }
            case 2: {
                return this.getInteger(16664) == 0;
            }
            case 3: {
                return this.getInteger(16664) == 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSGDTHS_25(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(30104) == 0;
            }
            case 1: {
                return this.getInteger(30104) == 1;
            }
            case 2: {
                return this.getInteger(16664) == 0;
            }
            case 3: {
                return this.getInteger(16664) == 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSGDTNDC_26(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(30104) == 0;
            }
            case 1: {
                return this.getInteger(30104) == 1;
            }
            case 2: {
                return this.getInteger(16664) == 0;
            }
            case 3: {
                return this.getInteger(16664) == 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSGDTNHS_27(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(30104) == 0;
            }
            case 1: {
                return this.getInteger(30104) == 1;
            }
            case 2: {
                return this.getInteger(16664) == 0;
            }
            case 3: {
                return this.getInteger(16664) == 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSGDTNVB_28(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(30104) == 0;
            }
            case 1: {
                return this.getInteger(30104) == 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSGDTVB_29(int n) {
        switch (n) {
            case 0: {
                return this.getInteger(30104) == 0;
            }
            case 1: {
                return this.getInteger(30104) == 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSGGG_2A(int n) {
        switch (n) {
            case 0: {
                return !(this.getBoolean(30686) || this.getBoolean(20317));
            }
            case 1: {
                return !this.getBoolean(22877);
            }
            case 2: {
                return this.getInteger(12221) == 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private boolean evaluateCondition_SSGGH_2B(int n) {
        switch (n) {
            case 0: {
                return !(this.getBoolean(30686) || this.getBoolean(20317));
            }
            case 1: {
                return !this.getBoolean(22877);
            }
            case 2: {
                return this.getInteger(12221) == 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    @Override
    protected void collectAllCommandsGuardedByOneCondition(ObjectArrayList objectArrayList, int n) {
        switch (this.sdFeatColId) {
            case 13: {
                this.collectAllCommandsGuardedByOneCondition_SSGDMM_11(objectArrayList, n);
                break;
            }
            case 32: {
                this.collectAllCommandsGuardedByOneCondition_SSGDTDC_24(objectArrayList, n);
                break;
            }
            case 33: {
                this.collectAllCommandsGuardedByOneCondition_SSGDTHS_25(objectArrayList, n);
                break;
            }
            case 34: {
                this.collectAllCommandsGuardedByOneCondition_SSGDTNDC_26(objectArrayList, n);
                break;
            }
            case 35: {
                this.collectAllCommandsGuardedByOneCondition_SSGDTNHS_27(objectArrayList, n);
                break;
            }
            case 36: {
                this.collectAllCommandsGuardedByOneCondition_SSGDTNVB_28(objectArrayList, n);
                break;
            }
            case 37: {
                this.collectAllCommandsGuardedByOneCondition_SSGDTVB_29(objectArrayList, n);
                break;
            }
            case 38: {
                this.collectAllCommandsGuardedByOneCondition_SSGGG_2A(objectArrayList, n);
                break;
            }
            case 39: {
                this.collectAllCommandsGuardedByOneCondition_SSGGH_2B(objectArrayList, n);
                break;
            }
            default: {
                super.collectAllCommandsGuardedByOneCondition(objectArrayList, n);
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSGDMM_11(ObjectArrayList objectArrayList, int n) {
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
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSGDTDC_24(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSGDTHS_25(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSGDTNDC_26(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSGDTNHS_27(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSGDTNVB_28(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSGDTVB_29(ObjectArrayList objectArrayList, int n) {
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

    private void collectAllCommandsGuardedByOneCondition_SSGGG_2A(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                objectArrayList.add(this.createSingleCommand(14));
                break;
            }
            case 1: {
                objectArrayList.add(this.createSingleCommand(9));
                break;
            }
            case 2: {
                objectArrayList.add(this.createSingleCommand(3));
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
            }
        }
    }

    private void collectAllCommandsGuardedByOneCondition_SSGGH_2B(ObjectArrayList objectArrayList, int n) {
        switch (n) {
            case 0: {
                objectArrayList.add(this.createSingleCommand(14));
                break;
            }
            case 1: {
                objectArrayList.add(this.createSingleCommand(9));
                break;
            }
            case 2: {
                objectArrayList.add(this.createSingleCommand(3));
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
            case 13: {
                return this.getAffectedFeatures_SSGDMM_11(n);
            }
            case 32: {
                return this.getAffectedFeatures_SSGDTDC_24(n);
            }
            case 33: {
                return this.getAffectedFeatures_SSGDTHS_25(n);
            }
            case 34: {
                return this.getAffectedFeatures_SSGDTNDC_26(n);
            }
            case 35: {
                return this.getAffectedFeatures_SSGDTNHS_27(n);
            }
            case 36: {
                return this.getAffectedFeatures_SSGDTNVB_28(n);
            }
            case 37: {
                return this.getAffectedFeatures_SSGDTVB_29(n);
            }
            case 38: {
                return this.getAffectedFeatures_SSGGG_2A(n);
            }
            case 39: {
                return this.getAffectedFeatures_SSGGH_2B(n);
            }
        }
        return super.getAffectedFeatures(n);
    }

    private int[] getAffectedFeatures_SSGDMM_11(int n) {
        switch (n) {
            case 0: {
                return SSGDMM_11_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSGDMM_11_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 2: {
                return SSGDMM_11_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSGDMM_11_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
            case 4: {
                return SSGDMM_11_AFFECTED_FEATURES_FOR_CONDITION_4;
            }
            case 5: {
                return SSGDMM_11_AFFECTED_FEATURES_FOR_CONDITION_5;
            }
            case 6: {
                return SSGDMM_11_AFFECTED_FEATURES_FOR_CONDITION_6;
            }
            case 7: {
                return SSGDMM_11_AFFECTED_FEATURES_FOR_CONDITION_7;
            }
            case 8: {
                return SSGDMM_11_AFFECTED_FEATURES_FOR_CONDITION_8;
            }
            case 9: {
                return SSGDMM_11_AFFECTED_FEATURES_FOR_CONDITION_9;
            }
            case 10: {
                return SSGDMM_11_AFFECTED_FEATURES_FOR_CONDITION_10;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSGDTDC_24(int n) {
        switch (n) {
            case 2: {
                return SSGDTDC_24_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSGDTDC_24_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSGDTHS_25(int n) {
        switch (n) {
            case 2: {
                return SSGDTHS_25_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSGDTHS_25_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSGDTNDC_26(int n) {
        switch (n) {
            case 2: {
                return SSGDTNDC_26_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSGDTNDC_26_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSGDTNHS_27(int n) {
        switch (n) {
            case 2: {
                return SSGDTNHS_27_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
            case 3: {
                return SSGDTNHS_27_AFFECTED_FEATURES_FOR_CONDITION_3;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSGDTNVB_28(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSGDTVB_29(int n) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSGGG_2A(int n) {
        switch (n) {
            case 0: {
                return SSGGG_2A_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSGGG_2A_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 2: {
                return SSGGG_2A_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    private int[] getAffectedFeatures_SSGGH_2B(int n) {
        switch (n) {
            case 0: {
                return SSGGH_2B_AFFECTED_FEATURES_FOR_CONDITION_0;
            }
            case 1: {
                return SSGGH_2B_AFFECTED_FEATURES_FOR_CONDITION_1;
            }
            case 2: {
                return SSGGH_2B_AFFECTED_FEATURES_FOR_CONDITION_2;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal condition index: ").append(n).toString());
    }

    @Override
    protected int[] getConditionsAffectedByProperty(int n) {
        switch (this.sdFeatColId) {
            case 13: {
                return this.getConditionsAffectedByProperty_SSGDMM_11(n);
            }
            case 32: {
                return this.getConditionsAffectedByProperty_SSGDTDC_24(n);
            }
            case 33: {
                return this.getConditionsAffectedByProperty_SSGDTHS_25(n);
            }
            case 34: {
                return this.getConditionsAffectedByProperty_SSGDTNDC_26(n);
            }
            case 35: {
                return this.getConditionsAffectedByProperty_SSGDTNHS_27(n);
            }
            case 38: {
                return this.getConditionsAffectedByProperty_SSGGG_2A(n);
            }
            case 39: {
                return this.getConditionsAffectedByProperty_SSGGH_2B(n);
            }
        }
        return super.getConditionsAffectedByProperty(n);
    }

    private int[] getConditionsAffectedByProperty_SSGDMM_11(int n) {
        switch (n) {
            case 10059: {
                return SSGDMM_11_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_CODING;
            }
            case 40967: {
                return SSGDMM_11_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_SDS_SW_AP;
            }
            case 16664: {
                return SSGDMM_11_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_GENERAL_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSGDTDC_24(int n) {
        switch (n) {
            case 16664: {
                return SSGDTDC_24_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_GENERAL_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSGDTHS_25(int n) {
        switch (n) {
            case 16664: {
                return SSGDTHS_25_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_GENERAL_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSGDTNDC_26(int n) {
        switch (n) {
            case 16664: {
                return SSGDTNDC_26_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_GENERAL_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSGDTNHS_27(int n) {
        switch (n) {
            case 16664: {
                return SSGDTNHS_27_AFFECTED_CONDITIONS_FOR_PROPERTY_STATE_SPEECH_GENERAL_HELP_MODE;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSGGG_2A(int n) {
        switch (n) {
            case 20317: {
                return SSGGG_2A_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_EXT_PHONE_AVAILABLE;
            }
            case 30686: {
                return SSGGG_2A_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_INT_PHONE_AVAILABLE;
            }
            case 12221: {
                return SSGGG_2A_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_GENERAL_OUT_OF_DOMAIN_REQUEST_GET_CONCIERGE_CALL_STATE;
            }
            case 22877: {
                return SSGGG_2A_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SYSTEM_IS_NAVIGATION_CONTEXT_AVAILABLE_DIAG;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Illegal DpProperty Id: ").append(n).toString());
    }

    private int[] getConditionsAffectedByProperty_SSGGH_2B(int n) {
        switch (n) {
            case 20317: {
                return SSGGH_2B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_EXT_PHONE_AVAILABLE;
            }
            case 30686: {
                return SSGGH_2B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_CONFIGURATION_IS_INT_PHONE_AVAILABLE;
            }
            case 12221: {
                return SSGGH_2B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SPEECH_GENERAL_OUT_OF_DOMAIN_REQUEST_GET_CONCIERGE_CALL_STATE;
            }
            case 22877: {
                return SSGGH_2B_AFFECTED_CONDITIONS_FOR_PROPERTY_ASL_SYSTEM_IS_NAVIGATION_CONTEXT_AVAILABLE_DIAG;
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

