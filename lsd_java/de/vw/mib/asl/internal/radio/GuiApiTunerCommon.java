/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.manager.ManagerTarget;
import de.vw.mib.log4mib.Logger;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.global.ResourceLocator;

public final class GuiApiTunerCommon {
    private static Logger logger = ServiceManager.logger;

    private GuiApiTunerCommon() {
    }

    public static void setFmRadioTextLoadingState(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(3446, n);
    }

    public static void setDabRadioTextLoadingState(int n) {
        if (!RadioData.getDabDatabase().scanActive && !RadioData.getDabDatabase().searchingActive) {
            ServiceManager.aslPropertyManager.valueChangedInteger(3447, n);
        }
    }

    public static void setDabRadioTextLoadingStateToAvailable() {
        GuiApiTunerCommon.setDabRadioTextLoadingState(1);
    }

    public static void setDabRadioTextLoadingStateToLoading() {
        GuiApiTunerCommon.setDabRadioTextLoadingState(0);
    }

    public static void setDabRadioTextLoadingStateToNotAvailable() {
        GuiApiTunerCommon.setDabRadioTextLoadingState(2);
    }

    public static void updateFmRadioTextPlusActive(boolean bl) {
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_RADIOTEXT).append("updating RT+ active: ").append(bl).log();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(1443, bl);
    }

    public static void updateRadioManualMode(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1438, bl);
    }

    public static void updateCurrentBand(int n) {
        try {
            ServiceManager.aslPropertyManager.valueChangedInteger(1324, n);
            if (RadioCurrentWaveband.isAm() || RadioCurrentWaveband.isFm()) {
                AmFmFactory.getAslAmfmModelController().updateNewStationListIDAndPresetIndexForBAP(RadioUtil.computeUniqueID(RadioData.getAmfmDatabase().getCurrentStation()), -1);
            }
            if (logger.isTraceEnabled(128)) {
                logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("updating current band: ").append(n).log();
            }
            if (RadioCodingAdapter.isRadioTileFeatureActivated()) {
                RadioServiceManager.getServiceManager().getApiGuiRadioTiles().clearRadioText();
            }
        }
        catch (Exception exception) {
            logger.error(128, "Exception in updateCurrentBand() ", exception);
        }
    }

    public static void updateScanActive(boolean bl) {
        RadioServiceManager.getServiceManager().setScanIsActive(bl);
        ServiceManager.aslPropertyManager.valueChangedBoolean(1445, bl);
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("updating radio scan active: ").append(bl).log();
        }
    }

    public static void updateSeekActive(boolean bl) {
        RadioServiceManager.getServiceManager().setSeekIsActive(bl);
        ServiceManager.aslPropertyManager.valueChangedBoolean(1446, bl);
        if (logger.isTraceEnabled(128)) {
            logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM).append("updating radio seek active: ").append(bl).log();
        }
    }

    public static void updateTaRecordingActive(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1449, bl);
    }

    public static void updateScopeOfArrowKeys(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(1412, n);
    }

    public static void updateSelectedEpgStationImageURL(ResourceLocator resourceLocator) {
        ServiceManager.aslPropertyManager.valueChangedResourceLocator(1413, resourceLocator);
    }

    public static void updateTmElapsedTime(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(1417, n);
    }

    public static void updateTmPlayTime(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(1419, n);
    }

    public static void updateTmRemainingTime(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(1420, n);
    }

    public static void updateTpSelectedIndexOfMemoList(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(1421, n);
    }

    public static void updateTpOption(boolean bl) {
        if (null != ServiceManager.aslPropertyManager) {
            if (RadioCodingAdapter.isHongKongVariant()) {
                bl = false;
            }
            ServiceManager.aslPropertyManager.valueChangedBoolean(1422, bl);
        }
    }

    public static void updateTpState(int n) {
        if (logger.isTraceEnabled(8192)) {
            logger.trace(8192).append("updating TP flag: ").append(n);
        }
        if (RadioCodingAdapter.isHongKongVariant()) {
            n = 1;
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(1423, n);
    }

    public static void updateTransferredSongTags(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(1425, n);
    }

    public static void updateDabRadioTextPlusActive(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1436, bl);
    }

    public static void updateSetupPtyAnnouncement(boolean bl) {
        if (logger.isTraceEnabled(8192)) {
            ServiceManager.logger.trace(8192).append("<AnnouncementTop>setupPTYAnnouncement:").append(bl).log();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(1442, bl);
    }

    public static void updateBapReceptionList(Object[] objectArray) {
        if (ManagerTarget.isRadioActive) {
            int n = RadioCurrentWaveband.get();
            switch (n) {
                case 0: {
                    if (logger.isTraceEnabled(128)) {
                        ServiceManager.logger.trace(128).append("updating AM reception list to Bap").log();
                    }
                    ListManager.getGenericASLList(3900).updateList(objectArray);
                    break;
                }
                case 1: {
                    if (logger.isTraceEnabled(128)) {
                        ServiceManager.logger.trace(128).append("updating FM reception list tp Bap").log();
                    }
                    ListManager.getGenericASLList(1270).updateList(objectArray);
                    break;
                }
                case 3: {
                    if (logger.isTraceEnabled(128)) {
                        ServiceManager.logger.trace(128).append("updating SDARS reception list to Bap").log();
                    }
                    ListManager.getGenericASLList(3902).updateList(objectArray);
                    break;
                }
                case 2: {
                    if (logger.isTraceEnabled(128)) {
                        ServiceManager.logger.trace(128).append("updating DAB reception list to Bap").log();
                    }
                    ListManager.getGenericASLList(3901).updateList(objectArray);
                    break;
                }
            }
            ListManager.getGenericASLList(1270).updateList(objectArray);
        }
    }
}

