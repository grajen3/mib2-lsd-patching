/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.RadioDabTraceUtil;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.dab.DabTunerState;
import de.vw.mib.asl.internal.radio.dab.presets.DabPreset;
import de.vw.mib.asl.internal.radio.dab.presets.SelectedStationHighlighting;
import de.vw.mib.asl.internal.radio.dab.stationList.HmiDabListView;
import de.vw.mib.asl.internal.radio.has.RadioHASUpdater;
import de.vw.mib.asl.internal.radio.transformer.DabPresetListInfoCollector;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.longs.LongObjectOptHashMap;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.radio.transformer.RadioCurrentStationInfoDABCollector;
import java.util.TreeSet;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;

public final class GuiApiDab {
    static int currentEnsembleState = 0;
    private static boolean isUpdateStaInfoBlocked = false;

    private GuiApiDab() {
    }

    public static void updateRadioText(String string) {
        ServiceManager.aslPropertyManager.valueChangedString(1343, string.trim());
        if (RadioUtil.isDabTraceEnabled()) {
            RadioDabTraceUtil.DataPoolTraceDab("RADIO_DAB_RADIO_TEXT_STRING", string.trim());
        }
    }

    public static void updateRadioTextPlus(IntObjectOptHashMap intObjectOptHashMap) {
        String string = (String)intObjectOptHashMap.get(1);
        if (string == null) {
            string = "";
        }
        ServiceManager.aslPropertyManager.valueChangedString(1354, string.trim());
        if (RadioUtil.isDabTraceEnabled()) {
            RadioDabTraceUtil.DataPoolTraceDab("RADIO_DAB_RADIO_TEXT_PLUS__TITLE_NAME", string.trim());
        }
        if ((string = (String)intObjectOptHashMap.get(4)) == null) {
            string = "";
        }
        ServiceManager.aslPropertyManager.valueChangedString(1352, string.trim());
        if (RadioUtil.isDabTraceEnabled()) {
            RadioDabTraceUtil.DataPoolTraceDab("RADIO_DAB_RADIO_TEXT_PLUS__ARTIST_NAME", string.trim());
        }
    }

    public static void updateRadioTextPlus(String string, String string2, String string3, String string4) {
        ServiceManager.aslPropertyManager.valueChangedString(1346, string);
        ServiceManager.aslPropertyManager.valueChangedString(1352, string2);
        ServiceManager.aslPropertyManager.valueChangedString(1353, string3);
        ServiceManager.aslPropertyManager.valueChangedString(1354, string4);
    }

    public static void resetRadioTextPlus() {
        GuiApiDab.updateRadioTextPlus("", "", "", "");
        if (RadioUtil.isDabTraceEnabled()) {
            RadioDabTraceUtil.DataPoolTraceDab("radiotext plus resetted");
        }
    }

    public static void updateViewMode(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(1349, n);
        if (RadioUtil.isDabTraceEnabled()) {
            String string;
            switch (n) {
                case 0: {
                    string = "DABVIEWMODE_C0_PRESET";
                    break;
                }
                case 1: {
                    string = "DABVIEWMODE_C1_STATION";
                    break;
                }
                case 2: {
                    string = "DABVIEWMODE_C2_TEXT";
                    break;
                }
                case 3: {
                    string = "DABVIEWMODE_C3_SLIDE_SHOW";
                    break;
                }
                default: {
                    string = "unknown";
                }
            }
            RadioDabTraceUtil.DataPoolTraceDab("RADIO_DAB_VIEW_MODE", string);
        }
    }

    public static void updateEnsembleStateToAvailableAndNotMuted() {
        GuiApiDab.updateEnsembleState(0);
    }

    public static void updateEnsembleStateToNotAvailable() {
        GuiApiDab.updateEnsembleState(1);
    }

    public static void updateEnsembleStateToNoAudio() {
        RadioDabTraceUtil.DataPoolTraceDab("--- Ensemble, but no audio");
        GuiApiDab.updateEnsembleState(2);
    }

    public static void updateEnsembleState(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(1339, n);
        if (RadioUtil.isDabTraceEnabled()) {
            String string;
            switch (n) {
                case 0: {
                    string = "DABENSEMBLESTATE_C0_DAB_ENSEMBLE_AVAILABLE_AND_NOT_MUTED";
                    break;
                }
                case 1: {
                    string = "DABENSEMBLESTATE_C1_DAB_ENSEMBLE_NOT_AVAILABLE";
                    break;
                }
                case 2: {
                    string = "DABENSEMBLESTATE_C2_DAB_ENSEMBLE_NO_AUDIO";
                    break;
                }
                default: {
                    string = "Unknown";
                }
            }
            RadioDabTraceUtil.DataPoolTraceDab("RADIO_DAB_ENSEMBLE_STATE_INTEGER", string);
        }
    }

    public static void updateListStateToUpdating() {
        ServiceManager.aslPropertyManager.valueChangedInteger(1341, 1);
        RadioData.getDabDatabase().dabPresetList.setCurrentVisibleIndex(-1, true);
        GuiApiDab.updateBapCurrentStationIndices(-1, 0L);
        if (RadioUtil.isDabTraceEnabled()) {
            RadioDabTraceUtil.DataPoolTraceDab("RADIO_DAB_LIST_STATE_INTEGER", "DABLISTSTATE_C1_SERVICE_STATE_STATION_LIST_UPDATING");
        }
    }

    public static void updateListStateToCancelling() {
        ServiceManager.aslPropertyManager.valueChangedInteger(1341, 2);
        if (RadioUtil.isDabTraceEnabled()) {
            RadioDabTraceUtil.DataPoolTraceDab("RADIO_DAB_LIST_STATE_INTEGER", "DABLISTSTATE_C0_SERVICE_STATE_AVAILABLE");
        }
    }

    public static void updateListStateToAvailable() {
        ServiceManager.aslPropertyManager.valueChangedInteger(1341, 0);
        if (RadioUtil.isDabTraceEnabled()) {
            RadioDabTraceUtil.DataPoolTraceDab("RADIO_DAB_LIST_STATE_INTEGER", "DABLISTSTATE_C0_SERVICE_STATE_AVAILABLE");
        }
    }

    public static void updateAdditionalServiceState(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(1357, n);
        if (RadioUtil.isDabTraceEnabled()) {
            String string;
            switch (n) {
                case 0: {
                    string = "DABADDITIONALSERVICESTATE_C0_NOT_AVAILABLE";
                    break;
                }
                case 1: {
                    string = "DABADDITIONALSERVICESTATE_C1_AVAILABLE";
                    break;
                }
                case 2: {
                    string = "DABADDITIONALSERVICESTATE_C2_PLAYING";
                    break;
                }
                default: {
                    string = "Unknown";
                }
            }
            RadioDabTraceUtil.DataPoolTraceDab("RADIO_DAB_ADDITIONAL_SERVICE_STATE_INTEGER", string);
        }
    }

    public static void updateAdditionalServiceStateToAdditionalServiceActive() {
        GuiApiDab.updateAdditionalServiceState(2);
    }

    public static void updateServiceState(int n) {
        if (SelectedStationHighlighting.getSelectedStationHighlightingIsActive()) {
            if (RadioUtil.isDabTraceEnabled()) {
                RadioDabTraceUtil.DataPoolTraceDab(new StringBuffer().append("DAB Preset Highlighting is active, so not updating the service state value: ").append(n).toString());
            }
            return;
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(1356, n);
        if (RadioUtil.isDabTraceEnabled()) {
            String string = "";
            switch (n) {
                case 3: {
                    string = "DABSERVICESTATE_C3_LINKING_TO_FM";
                    break;
                }
                case 1: {
                    string = "DABSERVICESTATE_C1_NOT_AVAILABLE";
                    break;
                }
                case 2: {
                    string = "DABSERVICESTATE_C2_MAY_NOT_AVAILABLE";
                    break;
                }
                case 4: {
                    string = "DABSERVICESTATE_C4_LINKING_TO_DAB";
                    break;
                }
                case 0: {
                    string = "DABSERVICESTATE_C0_DEFAULT";
                    break;
                }
            }
            RadioDabTraceUtil.DataPoolTraceDab("RADIO_DAB_SERVICE_STATE_INTEGER", string);
        }
    }

    public static void updateActiveEnsembleIndex(int n) {
        RadioDabTraceUtil.DataPoolTraceDab("RADIO_DAB_ACTIVE_ENSEMBLE_INDEX_INTEGER", String.valueOf(n));
        ServiceManager.aslPropertyManager.valueChangedInteger(1332, n);
    }

    public static void updateOpenedEnsembleIndex(int n) {
        if (ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.trace(256).append("ensemble Closed : ").append(HmiDabListView.ensembleClosed).log();
        }
        if (HmiDabListView.ensembleClosed) {
            RadioDabTraceUtil.DataPoolTraceDab("RADIO_DAB_OPENED_ENSEMBLE_INDEX_INTEGER", String.valueOf(-1));
            ServiceManager.aslPropertyManager.valueChangedInteger(2351, -1);
        } else {
            RadioDabTraceUtil.DataPoolTraceDab("RADIO_DAB_OPENED_ENSEMBLE_INDEX_INTEGER", String.valueOf(n));
            ServiceManager.aslPropertyManager.valueChangedInteger(2351, n);
        }
    }

    public static void setOtherAnnouncementsActivated(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1431, bl);
        RadioDabTraceUtil.DataPoolTraceDab("RADIO_DAB_OTHER_ANNOUNCEMENTS_ACTIVATED_BOOLEAN", String.valueOf(bl));
    }

    public static void setTrafficAnnouncementsActivated(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1430, bl);
        RadioDabTraceUtil.DataPoolTraceDab("RADIO_DAB_TRAFFIC_ANNOUNCEMENTS_ACTIVATED_BOOLEAN", String.valueOf(bl));
    }

    public static void updateOptionServiceLinking(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1435, bl);
        RadioDabTraceUtil.DataPoolTraceDab("RADIO_DAB_SERVICE_LINKING_ACTIVATED_BOOLEAN", String.valueOf(bl));
    }

    public static void updateOptionServiceFollowing(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1434, bl);
        RadioDabTraceUtil.DataPoolTraceDab("RADIO_DAB_SERVICE_FOLLOWING_ACTIVATED_BOOLEAN", String.valueOf(bl));
    }

    public static void makeSoftLinkingButtonVisible() {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(416)) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(700851200, true);
            RadioDabTraceUtil.DataPoolTraceDab("makeSoftLinkingButtonVisible : ", String.valueOf(true));
        } else {
            ServiceManager.aslPropertyManager.valueChangedBoolean(700851200, false);
            RadioDabTraceUtil.DataPoolTraceDab("makeSoftLinkingButtonVisible : ", String.valueOf(false));
        }
    }

    public static void enableSoftLinkingButton(boolean bl) {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(416)) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(767960064, bl);
            RadioDabTraceUtil.DataPoolTraceDab("enableSoftLinkingButton : ", String.valueOf(bl));
        }
    }

    public static void updateOptionSoftLinking(boolean bl) {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(416)) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(717628416, bl);
            RadioDabTraceUtil.DataPoolTraceDab("updateOptionSoftLinking : ", String.valueOf(bl));
        }
    }

    public static void setFirstPresetBankWithEmptyElement(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(1364, n);
        RadioDabTraceUtil.DataPoolTraceDab("RADIO_FIRST_DAB_PRESET_BANK_WITH_EMPTY_ELEMENT_INTEGER", String.valueOf(n));
    }

    public static void setActivePresetBank(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(1403, n);
        RadioDabTraceUtil.DataPoolTraceDab("RADIO_INDEX_OF_PRESET_BANK_DAB_INTEGER", String.valueOf(n));
    }

    public static void setActivePreset(int n) {
        if (-1 == n) {
            n = 255;
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(1397, n);
        RadioDabTraceUtil.DataPoolTraceDab("RADIO_INDEX_OF_ACTIVATED_DAB_PRESET_INTEGER", String.valueOf(n));
    }

    public static void updateServiceIndex(int n) {
        RadioDabTraceUtil.DataPoolTraceDab("RADIO_DAB_ACTIVE_SERVICE_INDEX_INTEGER", String.valueOf(n));
        ServiceManager.aslPropertyManager.valueChangedInteger(1335, n);
    }

    public static void updateCurrentStationInfo() {
        FrequencyInfo frequencyInfo;
        if (GuiApiDab.isUpdateStationInfoBlocked() || RadioData.listStoreViewEntered) {
            return;
        }
        RadioDabTraceUtil.DataPoolTraceDab("hmiapidab: update by main hsm ");
        ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
        ComponentInfo componentInfo = RadioData.getDabDatabase().mTunerState.getCurrentComponent();
        Object[] objectArray = (RadioCurrentStationInfoDABCollector[])ListManager.getGenericASLList(1455).getDSIObjects();
        if (objectArray == null) {
            objectArray = new RadioCurrentStationInfoDABCollector[]{new RadioCurrentStationInfoDABCollector()};
        }
        if ((frequencyInfo = RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo()) != null) {
            objectArray[0].radio_current_station_info_dab__frequency_label = frequencyInfo.label;
            objectArray[0].radio_current_station_info_dab__frequency = RadioData.getDabDatabase().mTunerState.getFrequencyIndex();
        } else {
            objectArray[0].radio_current_station_info_dab__frequency_label = "";
            objectArray[0].radio_current_station_info_dab__frequency = 0;
            objectArray[0].radio_current_station_info_dab__tp_available = false;
        }
        EnsembleInfo ensembleInfo = null;
        if (componentInfo != null) {
            if (serviceInfo != null) {
                objectArray[0].radio_current_station_info_dab__service_ps = serviceInfo.fullName;
                ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__service_short_name = serviceInfo.shortName;
                ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__tp_available = serviceInfo.tp;
            } else {
                objectArray[0].radio_current_station_info_dab__service_ps = "";
                ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__service_short_name = "";
                ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__tp_available = false;
            }
            ensembleInfo = RadioData.getDabDatabase().mTunerState.getCurrentEnsemble();
            ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__ensemble_name = ensembleInfo == null || null == ensembleInfo.fullName ? "" : ensembleInfo.fullName;
            if (componentInfo.sCIDI > 0 && componentInfo.sID > 0L && componentInfo.ensID > 0) {
                GuiApiDab.updateAdditionalServiceStateToAdditionalServiceActive();
                ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__secondary_service_short_name = componentInfo.shortName;
                ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__secondary_service_name = componentInfo.fullName;
            }
            currentEnsembleState = 0;
        } else if (serviceInfo != null) {
            objectArray[0].radio_current_station_info_dab__service_ps = serviceInfo.fullName;
            ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__service_short_name = serviceInfo.shortName;
            ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__tp_available = serviceInfo.tp;
            ensembleInfo = RadioData.getDabDatabase().mTunerState.getCurrentEnsemble();
            ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__ensemble_name = ensembleInfo == null || null == ensembleInfo.fullName ? "" : ensembleInfo.fullName;
            ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__secondary_service_name = "";
            currentEnsembleState = 0;
        } else if (frequencyInfo != null) {
            objectArray[0].radio_current_station_info_dab__service_ps = "";
            ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__service_short_name = "";
            ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__secondary_service_name = "";
            ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__ensemble_name = "";
            ensembleInfo = RadioData.getDabDatabase().mTunerState.getCurrentEnsemble();
            if (ensembleInfo != null) {
                if ((long)ensembleInfo.frequencyValue == frequencyInfo.frequency) {
                    ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__ensemble_name = null == ensembleInfo.fullName ? "" : ensembleInfo.fullName;
                    if (!RadioData.getDabDatabase().mTunerState.hasAudioServices(ensembleInfo)) {
                        currentEnsembleState = 2;
                    }
                } else {
                    currentEnsembleState = 1;
                }
            } else {
                currentEnsembleState = 1;
            }
            ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__auto_assigned_logo = "";
            ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__stored_logo_state = 0;
        }
        ListManager.getGenericASLList(1455).updateList(objectArray);
        GuiApiDab.updateEnsembleState(currentEnsembleState);
        GuiApiDab.updateServiceState(RadioData.getDabDatabase().mTunerState.getCurrentServiceState());
        GuiApiDab.updateAdditionalServiceState(RadioData.getDabDatabase().mTunerState.getAdditionalServiceState());
        GuiApiDab.traceCurrentStationInfoToString((RadioCurrentStationInfoDABCollector)objectArray[0]);
        RadioHASUpdater.updateCurrentDABStation((RadioCurrentStationInfoDABCollector)objectArray[0], ensembleInfo, serviceInfo, componentInfo);
    }

    public static boolean isUpdateStationInfoBlocked() {
        return isUpdateStaInfoBlocked;
    }

    public static void setUpdateStationInfoBlocked(boolean bl) {
        isUpdateStaInfoBlocked = bl;
    }

    public static void updateCurrentStationInfo(FrequencyInfo frequencyInfo, EnsembleInfo ensembleInfo, ServiceInfo serviceInfo, ComponentInfo componentInfo) {
        RadioDabTraceUtil.DataPoolTraceDab("hmiapidab: update by dsi hsm");
        Object[] objectArray = new RadioCurrentStationInfoDABCollector[]{new RadioCurrentStationInfoDABCollector()};
        if (frequencyInfo != null) {
            objectArray[0].radio_current_station_info_dab__frequency_label = frequencyInfo.label;
            objectArray[0].radio_current_station_info_dab__frequency = RadioData.getDabDatabase().mTunerState.findFrequencyIndex(frequencyInfo);
        } else {
            objectArray[0].radio_current_station_info_dab__frequency_label = "";
            objectArray[0].radio_current_station_info_dab__frequency = 0;
            objectArray[0].radio_current_station_info_dab__tp_available = false;
        }
        if (componentInfo != null) {
            if (serviceInfo != null) {
                objectArray[0].radio_current_station_info_dab__service_ps = serviceInfo.fullName;
                ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__service_short_name = serviceInfo.shortName;
                ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__tp_available = serviceInfo.tp;
            } else {
                objectArray[0].radio_current_station_info_dab__service_ps = "";
                ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__service_short_name = "";
                ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__tp_available = false;
            }
            ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__ensemble_name = ensembleInfo == null ? "" : ensembleInfo.fullName;
            if (componentInfo.sCIDI > 0 && componentInfo.sID > 0L && componentInfo.ensID > 0) {
                GuiApiDab.updateAdditionalServiceStateToAdditionalServiceActive();
                ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__secondary_service_short_name = componentInfo.shortName;
                ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__secondary_service_name = componentInfo.fullName;
            }
            currentEnsembleState = 0;
        } else if (serviceInfo != null) {
            objectArray[0].radio_current_station_info_dab__service_ps = serviceInfo.fullName;
            ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__service_short_name = serviceInfo.shortName;
            ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__tp_available = serviceInfo.tp;
            ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__ensemble_name = ensembleInfo == null ? "" : ensembleInfo.fullName;
            ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__secondary_service_name = "";
            currentEnsembleState = 0;
        } else if (frequencyInfo != null) {
            objectArray[0].radio_current_station_info_dab__service_ps = "";
            ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__service_short_name = "";
            ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__secondary_service_name = "";
            ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__ensemble_name = "";
            ensembleInfo = RadioData.getDabDatabase().mTunerState.getCurrentEnsemble();
            if (ensembleInfo != null) {
                if ((long)ensembleInfo.frequencyValue == frequencyInfo.frequency) {
                    ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__ensemble_name = ensembleInfo.fullName;
                    if (!RadioData.getDabDatabase().mTunerState.hasAudioServices(ensembleInfo)) {
                        currentEnsembleState = 2;
                    }
                } else {
                    currentEnsembleState = 1;
                }
            } else {
                currentEnsembleState = 1;
            }
            ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__auto_assigned_logo = "";
            ((RadioCurrentStationInfoDABCollector)objectArray[0]).radio_current_station_info_dab__stored_logo_state = 0;
        }
        ListManager.getGenericASLList(1455).updateList(objectArray);
        GuiApiDab.updateEnsembleState(currentEnsembleState);
        GuiApiDab.updateServiceState(RadioData.getDabDatabase().mTunerState.getCurrentServiceState());
        GuiApiDab.updateAdditionalServiceState(RadioData.getDabDatabase().mTunerState.getAdditionalServiceState());
        GuiApiDab.traceCurrentStationInfoToString((RadioCurrentStationInfoDABCollector)objectArray[0]);
    }

    private static void traceCurrentStationInfoToString(RadioCurrentStationInfoDABCollector radioCurrentStationInfoDABCollector) {
        if (RadioUtil.isDabTraceEnabled()) {
            RadioDabTraceUtil.DataPoolTraceDab("RadioCurrentStationInfoDab.radio_current_station_info_dab__frequency", Integer.toString(radioCurrentStationInfoDABCollector.radio_current_station_info_dab__frequency));
            RadioDabTraceUtil.DataPoolTraceDab("RadioCurrentStationInfoDab.radio_current_station_info_dab__frequency_label", radioCurrentStationInfoDABCollector.radio_current_station_info_dab__frequency_label);
            RadioDabTraceUtil.DataPoolTraceDab("RadioCurrentStationInfoDab.radio_current_station_info_dab__ensemble_name", radioCurrentStationInfoDABCollector.radio_current_station_info_dab__ensemble_name);
            RadioDabTraceUtil.DataPoolTraceDab("RadioCurrentStationInfoDab.radio_current_station_info_dab__service_ps", radioCurrentStationInfoDABCollector.radio_current_station_info_dab__service_ps);
            RadioDabTraceUtil.DataPoolTraceDab("RadioCurrentStationInfoDab.radio_current_station_info_dab__service_short_name", radioCurrentStationInfoDABCollector.radio_current_station_info_dab__service_short_name);
            RadioDabTraceUtil.DataPoolTraceDab("RadioCurrentStationInfoDab.radio_current_station_info_dab__secondary_service_name", radioCurrentStationInfoDABCollector.radio_current_station_info_dab__secondary_service_name);
            RadioDabTraceUtil.DataPoolTraceDab("RadioCurrentStationInfoDab.radio_current_station_info_dab__secondary_service_short_name", radioCurrentStationInfoDABCollector.radio_current_station_info_dab__secondary_service_short_name);
        }
    }

    public static void updateBapCurrentStationIndices(int n, long l) {
        RadioServiceManager.getServiceManager().getGuiBapApi().updateBapCurrentStationIndices(n, l);
        if (RadioUtil.isDabTraceEnabled()) {
            RadioDabTraceUtil.DataPoolTraceDab("RADIO_BAP_CURRENT_STATION_INDICES.radio_bap_current_station_indices__active_preset_bank_index", String.valueOf(n));
            RadioDabTraceUtil.DataPoolTraceDab("RADIO_BAP_CURRENT_STATION_INDICES.radio_bap_current_station_indices__active_station_id", String.valueOf(l));
        }
    }

    public static void UpdateDefaultStation() {
        Object[] objectArray = (RadioCurrentStationInfoDABCollector[])ListManager.getGenericASLList(1455).getDSIObjects();
        objectArray[0].radio_current_station_info_dab__frequency_label = RadioData.getDabDatabase().mTunerState.getNearest((int)0).label;
        objectArray[0].radio_current_station_info_dab__frequency = 0;
        objectArray[0].radio_current_station_info_dab__service_ps = "";
        objectArray[0].radio_current_station_info_dab__service_short_name = "";
        objectArray[0].radio_current_station_info_dab__secondary_service_name = "";
        objectArray[0].radio_current_station_info_dab__ensemble_name = "";
        ListManager.getGenericASLList(1455).updateList(objectArray);
        GuiApiDab.traceCurrentStationInfoToString((RadioCurrentStationInfoDABCollector)objectArray[0]);
    }

    public static void updateAnnouncementStationName(String string) {
        ServiceManager.aslPropertyManager.valueChangedString(1325, string);
        RadioDabTraceUtil.DataPoolTraceDab("RADIO_CURRENT_DAB_ANNOUNCEMENT_STATION_NAME_STRING", string);
    }

    public static void updatePresetList() {
        try {
            DabPreset[] dabPresetArray = RadioData.getDabDatabase().dabPresetList.getPresets();
            if (null == dabPresetArray) {
                return;
            }
            Object[] objectArray = new DabPresetListInfoCollector[dabPresetArray.length];
            int n = -1;
            int n2 = -1;
            boolean bl = false;
            for (int i2 = 0; i2 < dabPresetArray.length; ++i2) {
                DabPresetListInfoCollector dabPresetListInfoCollector = new DabPresetListInfoCollector();
                DabPreset dabPreset = dabPresetArray[i2];
                if (dabPreset != null && dabPreset.getService() != null) {
                    ResourceLocator resourceLocator;
                    ServiceInfo serviceInfo;
                    if (n == -1) {
                        n = i2;
                    }
                    dabPresetListInfoCollector.mIsServiceStored = true;
                    dabPresetListInfoCollector.mPresetName = dabPreset.getService().shortName;
                    dabPresetListInfoCollector.mPresetId = "";
                    if (RadioData.getDabDatabase().mTunerState.hasComponents(dabPreset.getService())) {
                        dabPresetListInfoCollector.mAttributes = 4;
                    }
                    if ((serviceInfo = RadioData.getDabDatabase().mTunerState.getServiceById(dabPreset.getService().ensID, dabPreset.getService().ensECC, dabPreset.getService().sID)) != null && serviceInfo.tp) {
                        dabPresetListInfoCollector.mAttributes |= 0x20;
                    }
                    if ((resourceLocator = dabPreset.getImage()) != null) {
                        bl = true;
                        dabPresetListInfoCollector.mAutoStoreState = 2;
                        dabPresetListInfoCollector.mResource = resourceLocator;
                        if (RadioUtil.isDabTraceEnabled()) {
                            RadioDabTraceUtil.DataPoolTraceDab(new StringBuffer().append("Preset[").append(i2).append("].hasImage").toString(), "true");
                            RadioDabTraceUtil.DataPoolTraceDab(new StringBuffer().append("Preset[").append(i2).append("].Resource").toString(), resourceLocator.toString());
                        }
                    } else {
                        dabPresetListInfoCollector.mAutoStoreState = 0;
                    }
                    if (RadioUtil.isDabTraceEnabled()) {
                        RadioDabTraceUtil.DataPoolTraceDab(new StringBuffer().append("Preset[").append(i2).append("].frequency").toString(), dabPreset.mFrequency.label);
                    }
                } else {
                    dabPresetListInfoCollector.mIsServiceStored = false;
                    dabPresetListInfoCollector.mAutoStoreState = 0;
                    if (n2 == -1) {
                        n2 = i2;
                    }
                }
                objectArray[i2] = dabPresetListInfoCollector;
            }
            GuiApiDab.updateIndexOfFirstOccupiedPreset(n);
            GuiApiDab.updatePresetBankWithEmptyElement(n2);
            GuiApiDab.updateImageOnPresetStored(bl);
            ListManager.getGenericASLList(1458).updateList(objectArray);
            GuiApiDab.tracePresetList((DabPresetListInfoCollector[])objectArray);
            RadioHASUpdater.updateDABPresetList((DabPresetListInfoCollector[])objectArray, dabPresetArray);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private static void tracePresetList(DabPresetListInfoCollector[] dabPresetListInfoCollectorArray) {
        if (RadioUtil.isDabTraceEnabled()) {
            for (int i2 = 0; i2 < dabPresetListInfoCollectorArray.length; ++i2) {
                RadioDabTraceUtil.DataPoolTraceDab(new StringBuffer().append("RADIO_DAB_PRESET_LIST_INFO[").append(i2).append("]").toString(), dabPresetListInfoCollectorArray[i2].toString());
            }
        }
    }

    public static void updateLBandOptionState(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1340, bl);
        RadioDabTraceUtil.DataPoolTraceDab("RADIO_DABL_BAND_OPTION_STATE_BOOLEAN", String.valueOf(bl));
    }

    public static void updateLBandOptionAvailable(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1432, bl);
        RadioDabTraceUtil.DataPoolTraceDab("RADIO_DABL_BAND_SETUP_OPTION_AVAILABLE_BOOLEAN", String.valueOf(bl));
    }

    public static void updatePresetBankWithEmptyElement(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(1364, n);
        RadioDabTraceUtil.DataPoolTraceDab("RADIO_FIRST_DAB_PRESET_BANK_WITH_EMPTY_ELEMENT_INTEGER", String.valueOf(n));
    }

    public static void updateIndexOfFirstOccupiedPreset(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(1400, n);
        RadioDabTraceUtil.DataPoolTraceDab("RADIO_INDEX_OF_FIRST_OCCUPIED_DAB_PRESET_INTEGER", String.valueOf(n));
    }

    public static void updateIndexOfPresetBank(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(1403, n);
        RadioDabTraceUtil.DataPoolTraceDab("RADIO_INDEX_OF_PRESET_BANK_DAB_INTEGER", String.valueOf(n));
    }

    public static void updateDabSearching(boolean bl) {
        RadioData.getDabDatabase().searchingActive = bl;
        ServiceManager.aslPropertyManager.valueChangedBoolean(1433, bl);
        RadioDabTraceUtil.DataPoolTraceDab("RADIO_DAB_SEARCHING_BOOLEAN", String.valueOf(bl));
        GuiApiTunerCommon.updateSeekActive(bl);
    }

    public static void updateEpgStationAvailability(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1437, bl);
        RadioDabTraceUtil.DataPoolTraceDab("RADIO_EPG_STATION_AVAILABLE_BOOLEAN", String.valueOf(bl));
    }

    public static void updateSpeechAndBapReceptionList() {
        Object object;
        long l;
        Object object2;
        int n;
        EnsembleInfo[] ensembleInfoArray = RadioData.getDabDatabase().mTunerState.getEnsembleList();
        ServiceInfo[] serviceInfoArray = RadioData.getDabDatabase().mTunerState.getServiceList();
        ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
        FrequencyInfo frequencyInfo = RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo();
        EnsembleInfo ensembleInfo = RadioData.getDabDatabase().mTunerState.getCurrentEnsemble();
        TreeSet treeSet = new TreeSet(RadioData.getDabDatabase().mTunerState.getEnsembleNameComparator());
        TreeSet treeSet2 = new TreeSet(RadioData.getDabDatabase().mTunerState.getServiceComparator());
        boolean bl = serviceInfo != null && RadioData.getDabDatabase().mTunerState.getEnsembleById(serviceInfo.ensID, serviceInfo.ensECC) != null;
        boolean bl2 = serviceInfo != null && RadioData.getDabDatabase().mTunerState.getServiceById(serviceInfo.ensID, serviceInfo.ensECC, serviceInfo.sID) != null;
        LongObjectOptHashMap longObjectOptHashMap = new LongObjectOptHashMap();
        if (frequencyInfo != null && ensembleInfo == null) {
            treeSet.add(frequencyInfo);
            longObjectOptHashMap.put(0L, frequencyInfo);
        }
        for (n = 0; n < ensembleInfoArray.length; ++n) {
            object2 = ensembleInfoArray[n];
            treeSet.add(object2);
            l = DabTunerState.calcEnsembleId(((EnsembleInfo)object2).ensID, ((EnsembleInfo)object2).ensECC);
            longObjectOptHashMap.put(l, object2);
        }
        if (!bl && ensembleInfo != null) {
            treeSet.add(ensembleInfo);
            long l2 = DabTunerState.calcEnsembleId(ensembleInfo.ensID, ensembleInfo.ensECC);
            longObjectOptHashMap.put(l2, ensembleInfo);
        }
        for (n = 0; n < serviceInfoArray.length; ++n) {
            object2 = serviceInfoArray[n];
            treeSet2.add(object2);
            l = DabTunerState.calcServiceId(((ServiceInfo)object2).ensID, ((ServiceInfo)object2).ensECC, ((ServiceInfo)object2).sID);
            longObjectOptHashMap.put(l, object2);
            object = RadioData.getDabDatabase().mTunerState.getComponentsByService(serviceInfoArray[n]);
            for (int i2 = 0; i2 < ((ComponentInfo[])object).length; ++i2) {
                Object object3 = object[i2];
                l = DabTunerState.calcComponentId(((ComponentInfo)object3).sCIDI, ((ComponentInfo)object3).sID, ((ComponentInfo)object3).ensECC, ((ComponentInfo)object3).ensID);
                longObjectOptHashMap.put(l, object3);
                treeSet2.add(object3);
            }
        }
        if (!bl2 && serviceInfo != null) {
            long l3 = DabTunerState.calcServiceId(serviceInfo.ensID, serviceInfo.ensECC, serviceInfo.sID);
            longObjectOptHashMap.put(l3, serviceInfo);
            treeSet2.add(serviceInfo);
        }
        RadioData.getDabDatabase().mTunerState.mBapHmiList = longObjectOptHashMap;
        Object[] objectArray = new Object[treeSet.size() + treeSet2.size()];
        treeSet.toArray(objectArray);
        int n2 = treeSet2.size();
        int n3 = treeSet.size();
        object = treeSet2.iterator();
        for (int i3 = 0; i3 < n2; ++i3) {
            objectArray[n3++] = object.next();
        }
        GuiApiTunerCommon.updateBapReceptionList(objectArray);
    }

    public static void updateFrequencyMaxValue(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(1331, n);
        RadioDabTraceUtil.DataPoolTraceDab("RADIO_DAB__MAX_FREQUENCY_VALUE_INTEGER", String.valueOf(n));
        ServiceManager.logger.info(256, new StringBuffer().append("Freq Max Value : ").append(n).toString());
    }

    public static void updateDabScale(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(1329, n);
        RadioDabTraceUtil.DataPoolTraceDab("RADIO_DAB__MAX_FREQUENCY_VALUE_INTEGER", String.valueOf(n));
        ServiceManager.logger.info(256, new StringBuffer().append("DAB Scale Value : ").append(n).toString());
    }

    public static void updateSlideShowAvailable(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(1359, n);
        if (RadioUtil.isDabTraceEnabled()) {
            String string = "";
            switch (n) {
                case 0: {
                    string = "DABSLIDESHOWSERVICESTATE_C0_SERVICE_DOES_NOT_SUPPORT_SLIDESHOW";
                    break;
                }
                case 1: {
                    string = "DABSLIDESHOWSERVICESTATE_C1_SERVICE_SUPPORTS_SLIDESHOW";
                    break;
                }
                case 2: {
                    string = "DABSLIDESHOWSERVICESTATE_C2_SERVICE_SUPPORTS_SLIDESHOW_WAITING";
                    break;
                }
                case 3: {
                    string = "DABSLIDESHOWSERVICESTATE_C3_SLIDESHOW_DEACTIVATED";
                    break;
                }
            }
            RadioDabTraceUtil.DataPoolTraceDab("RADIO_DAB_SLIDE_SHOW_SERVICE_STATE_INTEGER", string);
        }
        RadioHASUpdater.updateSlideShowImageAvailable(n == 1 || n == 2);
    }

    public static void updateSlideShowImage(ResourceLocator resourceLocator) {
        String string = resourceLocator != null ? resourceLocator.toString() : null;
        RadioDabTraceUtil.DataPoolTraceDab("RADIO_DAB_SLIDE_SHOW_IMAGE_RESOURCE_LOCATOR", string);
        ServiceManager.aslPropertyManager.valueChangedResourceLocator(1358, resourceLocator);
        RadioHASUpdater.updateSlideShowImage(resourceLocator);
    }

    public static void updateSlideShowOrLogoVisibility(int n) {
        RadioDabTraceUtil.DataPoolTraceDab("RADIO_DAB_SLIDE_SHOW_IMAGE OR LOGO VISIBILITY", String.valueOf(n));
        ServiceManager.aslPropertyManager.valueChangedInteger(449192960, n);
    }

    public static void updateImageOnPresetStored(boolean bl) {
        RadioDabTraceUtil.DataPoolTraceDab("AT_LEAST_ON_DAB_PRESET_LOGO_AVAILABLE", String.valueOf(bl));
        ServiceManager.aslPropertyManager.valueChangedBoolean(3896, bl);
    }
}

