/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.main;

import de.vw.mib.asl.api.radio.ASLRadioAPI;
import de.vw.mib.asl.api.radio.ASLRadioFactory;
import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmScopeOfArrowKeys;
import de.vw.mib.asl.internal.radio.sdars.dsi.SatDsiApi;
import de.vw.mib.asl.internal.radio.sdars.filterlist.SatFilterListApi;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelListFromSouth;
import de.vw.mib.asl.internal.radio.sdars.helper.NotifiedChannels;
import de.vw.mib.asl.internal.radio.sdars.helper.SatConfig;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.main.AbstractMainState;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainStateTop$1;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainTarget;
import de.vw.mib.asl.internal.radio.tagging.TaggingApi;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import java.util.Iterator;
import org.dsi.ifc.sdars.StationInfo;
import org.dsi.ifc.sdars.TrafficWxEntry;

final class SatMainStateTop
extends AbstractMainState {
    private static final int RADIX;
    private static final int MAXDIGITS;
    private static final int INVALID;
    private final StringBuffer mChannelNumberEntered = new StringBuffer(6);
    private static final String CHARSET;
    private char[][] mNumbers;
    private boolean mUseChannelFilter = false;
    public static boolean triggeredFromTopState;
    private final AbstractFactoryResetParticipant siriusFactoryResetParticipant = new SatMainStateTop$1(this);

    SatMainStateTop(SatDb satDb, SatMainTarget satMainTarget, Hsm hsm, String string, HsmState hsmState) {
        super(satDb, satMainTarget, hsm, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        block1 : switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mPool.setString(39, this.getName());
                ServiceRegister serviceRegister = this.mTarget.getServiceRegister();
                int n = this.mTarget.getTargetId();
                serviceRegister.addObserver(352926976, n);
                if (serviceRegister.existService(-166341118)) {
                    serviceRegister.addObserver(-166341118, n);
                } else {
                    serviceRegister.addServiceMonitor(-166341118, 0, n);
                }
                serviceRegister.addObserver(-284950464, n);
                serviceRegister.addObserver(0x4B040040, n);
                serviceRegister.addObserver(0x4C040040, n);
                serviceRegister.addObserver(0x4E040040, n);
                serviceRegister.addObserver(0x4F040040, n);
                serviceRegister.addObserver(0x50040040, n);
                serviceRegister.addObserver(1359216704, n);
                serviceRegister.addObserver(1375993920, n);
                serviceRegister.addObserver(1392771136, n);
                serviceRegister.addObserver(-368443328, n);
                serviceRegister.addObserver(-385220544, n);
                serviceRegister.addObserver(1577320512, n);
                serviceRegister.addObserver(0x60040040, n);
                serviceRegister.addObserver(1661206592, n);
                serviceRegister.addObserver(1694761024, n);
                serviceRegister.addObserver(1828978752, n);
                serviceRegister.addObserver(1845755968, n);
                serviceRegister.addObserver(1862533184, n);
                serviceRegister.addObserver(0x70040040, n);
                serviceRegister.addObserver(1896087616, n);
                serviceRegister.addObserver(1912864832, n);
                serviceRegister.addObserver(1929642048, n);
                serviceRegister.addObserver(0x74040040, n);
                serviceRegister.addObserver(2063859776, n);
                serviceRegister.addObserver(2097414208, n);
                serviceRegister.addObserver(2114191424, n);
                serviceRegister.addObserver(-653721536, n);
                serviceRegister.addObserver(-636944320, n);
                serviceRegister.addObserver(1208549440, n);
                serviceRegister.addObserver(43983936, n);
                serviceRegister.addObserver(-536608704, n);
                serviceRegister.addObserver(-1459355584, n);
                serviceRegister.addObserver(-1023147968, n);
                serviceRegister.addObserver(-838598592, n);
                serviceRegister.addObserver(-922484672, n);
                serviceRegister.addObserver(-821821376, n);
                serviceRegister.addObserver(-805044160, n);
                serviceRegister.addObserver(-788266944, n);
                serviceRegister.addObserver(-704380864, n);
                serviceRegister.addObserver(-670826432, n);
                serviceRegister.addObserver(-654049216, n);
                serviceRegister.addObserver(-620494784, n);
                serviceRegister.addObserver(-1526464448, n);
                serviceRegister.addObserver(-402390976, n);
                serviceRegister.addObserver(161424448, n);
                serviceRegister.addObserver(-967043840, n);
                SatDsiApi satDsiApi = this.mDb.getDsiApi();
                String string = this.mTarget.getTaskId();
                GenericEvents genericEvents = this.mTarget.getMainObject();
                satDsiApi.start(genericEvents, ASLRadioTargetIds.ASL_SDARS_DSI_TARGET, string);
                satDsiApi.activate();
                EventGeneric eventGeneric2 = this.mDb.newEvent();
                eventGeneric2.setSenderTargetId(n);
                eventGeneric2.setReceiverTargetId(ASLRadioTargetIds.ASL_RADIO_MANAGER);
                eventGeneric2.setReceiverEventId(-1836646144);
                this.mTarget.send(eventGeneric2);
                SatFilterListApi satFilterListApi = this.mDb.getFilterListApi();
                this.mDb.getListApi().startModule();
                this.mDb.getPresetApi().startModule();
                satFilterListApi.startModule();
                this.mDb.getSeekApi().startModule();
                this.mDb.getPreviewHandler().start(satFilterListApi.getUserChannelFilter());
                this.mPool.setBoolean(177, Boolean.getBoolean("de.vw.mib.asl.internal.radio.sdars.debug"));
                this.mPool.setObject(62, this.mTarget);
                ASLRadioAPI aSLRadioAPI = ASLRadioFactory.getRadioApi();
                aSLRadioAPI.updateTravelLinkSubscriptions();
                FactoryResetService factoryResetService = ASLSystemFactory.getSystemApi().getFactoryResetService();
                factoryResetService.addParticipant(this.siriusFactoryResetParticipant, FactoryResetComponents.RADIO);
                break;
            }
            case 3: {
                this.mDb.getPersistable().setPersistenceWriteAccessBlocked(true);
                this.mDb.getPersistable().fromPersistence(true);
                this.mDb.getPersistable().setPersistenceWriteAccessBlocked(false);
                this.mPool.setInt(35, AmfmScopeOfArrowKeys.get());
                this.mTarget.transStateInactive();
                break;
            }
            case 4: {
                ServiceRegister serviceRegister = this.mTarget.getServiceRegister();
                int n = this.mTarget.getTargetId();
                this.mTarget.stopTimer(-1450835712);
                serviceRegister.removeObserver(352926976, n);
                serviceRegister.removeObserver(-284950464, n);
                serviceRegister.removeObserver(0x4B040040, n);
                serviceRegister.removeObserver(0x4C040040, n);
                serviceRegister.removeObserver(0x4E040040, n);
                serviceRegister.removeObserver(0x4F040040, n);
                serviceRegister.removeObserver(0x50040040, n);
                serviceRegister.removeObserver(1359216704, n);
                serviceRegister.removeObserver(1375993920, n);
                serviceRegister.removeObserver(1392771136, n);
                serviceRegister.removeObserver(-368443328, n);
                serviceRegister.removeObserver(-385220544, n);
                serviceRegister.removeObserver(1577320512, n);
                serviceRegister.removeObserver(0x60040040, n);
                serviceRegister.removeObserver(1661206592, n);
                serviceRegister.removeObserver(1694761024, n);
                serviceRegister.removeObserver(1828978752, n);
                serviceRegister.removeObserver(1845755968, n);
                serviceRegister.removeObserver(1862533184, n);
                serviceRegister.removeObserver(0x70040040, n);
                serviceRegister.removeObserver(1896087616, n);
                serviceRegister.removeObserver(1912864832, n);
                serviceRegister.removeObserver(1929642048, n);
                serviceRegister.removeObserver(0x74040040, n);
                serviceRegister.removeObserver(2063859776, n);
                serviceRegister.removeObserver(2097414208, n);
                serviceRegister.removeObserver(2114191424, n);
                serviceRegister.removeObserver(-653721536, n);
                serviceRegister.removeObserver(-636944320, n);
                serviceRegister.removeObserver(43983936, n);
                serviceRegister.removeObserver(1208549440, n);
                serviceRegister.removeObserver(-536608704, n);
                serviceRegister.removeObserver(-1459355584, n);
                serviceRegister.removeObserver(-1023147968, n);
                serviceRegister.removeObserver(-838598592, n);
                serviceRegister.removeObserver(-922484672, n);
                serviceRegister.removeObserver(-821821376, n);
                serviceRegister.removeObserver(-805044160, n);
                serviceRegister.removeObserver(-788266944, n);
                serviceRegister.removeObserver(-704380864, n);
                serviceRegister.removeObserver(-670826432, n);
                serviceRegister.removeObserver(-654049216, n);
                serviceRegister.removeObserver(-620494784, n);
                serviceRegister.removeObserver(-1526464448, n);
                serviceRegister.removeObserver(-402390976, n);
                SatDsiApi satDsiApi = this.mDb.getDsiApi();
                satDsiApi.deactivate();
                break;
            }
            case 0x4000044B: {
                int n;
                NotifiedChannels notifiedChannels;
                StationInfo stationInfo;
                int n2 = eventGeneric.getInt(0);
                if (n2 < 0 || (stationInfo = (notifiedChannels = (n = this.mPool.getInt(150)) == 0 ? new NotifiedChannels(this.mDb, true) : new NotifiedChannels(this.mDb, false)).getChannelByIndex(n2)) == null) break;
                this.getTuneHandler().tuneChannel(13, stationInfo, false);
                break;
            }
            case 0x4000044C: {
                StationInfo stationInfo;
                int n = (int)eventGeneric.getLong(0);
                if (n < 0 || (stationInfo = this.getChannels().getChannelBySID(n)) == null) break;
                if (stationInfo.subscription == 2) {
                    this.getTuneHandler().tuneChannel(19, stationInfo, false);
                    this.mDb.sendHmiEvent(215);
                    break;
                }
                this.mDb.sendHmiEvent(214);
                break;
            }
            case 100006: {
                this.getStatusHandler().notifyTimerNoSignalNoArtistArrived();
                break;
            }
            case 100023: {
                this.getStatusHandler().notifyTimerNoAudioArrived();
                break;
            }
            case 4000021: {
                int n = eventGeneric.getInt(0);
                if (n == 2) {
                    this.getAudioManager().setAudioAvailable(true);
                    break;
                }
                if (n == 0) {
                    this.getAudioManager().setAudioAvailable(false);
                    break;
                }
                if (n != 1) break;
                this.getAudioManager().setAudioAvailable(true);
                break;
            }
            case 1073742947: 
            case 1073742949: {
                LogMessage logMessage = this.getLogHandler().getLogMsg();
                if (logMessage == null) break;
                logMessage.append("Current SAT Main State = ").append(this.myHsm.getState().getName()).append(", BootString = ").append(this.mPool.getString(45)).log();
                break;
            }
            case 1073744345: {
                this.mPool.setBoolean(38, true);
                this.mTarget.addObserver(614285568);
                int n = this.mPool.getInt(172);
                if (this.mDb.isUnsubscribedPopupTriggered() || n != 0) break;
                this.mDb.getModelApi().sXMUnsubscriptionPopup(n);
                this.mDb.setUnsubscribedPopupTriggered(true);
                break;
            }
            case 1073744346: {
                this.mTarget.removeObserver(614285568);
                this.mPool.setBoolean(38, false);
                break;
            }
            case 47584758: {
                int n = eventGeneric.getInt(-149563902);
                this.mPool.setInt(183, n);
                break;
            }
            case 12: {
                int n = eventGeneric.getInt(0);
                if (n != -166341118) break;
                ServiceRegister serviceRegister = this.mTarget.getServiceRegister();
                int n3 = this.mTarget.getTargetId();
                serviceRegister.addObserver(-166341118, n3);
                serviceRegister.removeServiceMonitor(-166341118, 0, n3);
                break;
            }
            case 1073743049: {
                this.mPool.setChannel(22, null);
                int n = eventGeneric.getInt(0);
                this.mDb.getPool().setInt(35, n);
                break;
            }
            case 1076141826: {
                TrafficWxEntry[] trafficWxEntryArray = (TrafficWxEntry[])this.mPool.getObjectArray(105);
                if (null == trafficWxEntryArray || trafficWxEntryArray.length == 0) {
                    this.mPool.setBoolean(178, true);
                    break;
                }
                this.mPool.setBoolean(178, false);
                break;
            }
            case 100002: {
                triggeredFromTopState = true;
                this.mTarget.transActivate1();
                break;
            }
            case 100010: {
                triggeredFromTopState = true;
                SatDb.selectedStationStatus = eventGeneric.getInt(2);
                this.mTarget.transActivate2();
                break;
            }
            case 100011: {
                triggeredFromTopState = true;
                this.mTarget.transActivate3();
                break;
            }
            case 100009: {
                this.getModelApi().updateSpellerDataForEnteringChannelNumber(this.prepareDigitString(), this.mChannelNumberEntered.toString(), "", 0, this.mChannelNumberEntered.length(), 0, 0);
                break;
            }
            case 0x40000460: {
                int n = eventGeneric.getInt(0);
                LogMessage logMessage = this.getLogHandler().getLogMsg();
                if (logMessage == null) break;
                logMessage.append("Speller enters a ").append(n).log();
                break;
            }
            case 1073742958: {
                String string = this.mChannelNumberEntered.toString();
                if (string.length() <= 0) break;
                try {
                    int n = Integer.parseInt(string);
                    if (n > 999 || n < 0) {
                        this.showAdvisory("Illegal channel");
                        break;
                    }
                    switch (n) {
                        case 0: {
                            this.getTuneHandler().tuneChannel(13, SatConfig.ZERO_CHANNEL, false);
                            this.getLogHandler().simpleTrace("updateRadioManualMode called after tune Zero Channel");
                            GuiApiTunerCommon.updateRadioManualMode(false);
                            break block1;
                        }
                    }
                    StationInfo stationInfo = this.getChannels().getChannel(n);
                    if (stationInfo != null) {
                        this.mPool.addListener(21, this.mTarget.getTargetId(), -1333395200);
                        this.getTuneHandler().tuneChannel(13, stationInfo, false, this.mTarget.getTargetId(), 0);
                    } else {
                        this.showAdvisory("Invalid channel");
                    }
                    GuiApiTunerCommon.updateRadioManualMode(false);
                }
                catch (Exception exception) {}
                break;
            }
            case 1073742959: {
                this.mChannelNumberEntered.deleteCharAt(this.mChannelNumberEntered.length() - 1);
                this.getModelApi().updateSpellerDataForEnteringChannelNumber(this.prepareDigitString(), this.mChannelNumberEntered.toString(), "", 0, this.mChannelNumberEntered.length(), 0, 0);
                boolean bl = this.checkIfChannelExist();
                this.mPool.setBoolean(182, bl);
                break;
            }
            case 1073742961: {
                String string = eventGeneric.getString(0);
                this.mChannelNumberEntered.append(string);
                this.getModelApi().updateSpellerDataForEnteringChannelNumber(this.prepareDigitString(), this.mChannelNumberEntered.toString(), "", 0, this.mChannelNumberEntered.length(), 0, 0);
                boolean bl = this.checkIfChannelExist();
                this.mPool.setBoolean(182, bl);
                break;
            }
            case 1073742957: {
                this.getLogHandler().simpleTrace("updateRadioManualMode called from SatMainStateSpeller HSM_EXIT");
                GuiApiTunerCommon.updateRadioManualMode(false);
                this.mPool.setBoolean(29, false);
                this.mPool.removeListener(21, this.mTarget.getTargetId(), -1333395200);
                break;
            }
            case 0x40000470: {
                this.mPool.setString(39, this.getName());
                this.mPool.setBoolean(29, true);
                this.mPool.setBoolean(182, false);
                this.fill();
                this.mChannelNumberEntered.delete(0, this.mChannelNumberEntered.length());
                this.getModelApi().updateSpellerDataForEnteringChannelNumber(this.prepareDigitString(), this.mChannelNumberEntered.toString(), "", 0, this.mChannelNumberEntered.length(), 0, 0);
                break;
            }
            case 100016: {
                break;
            }
            default: {
                this.getLogHandler().printUnusedEvent(eventGeneric);
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void fill() {
        if (this.mUseChannelFilter) {
            ChannelListFromSouth channelListFromSouth = this.getChannels();
            int n = 0;
            Iterator iterator = channelListFromSouth.iterator();
            while (iterator.hasNext()) {
                StationInfo stationInfo = (StationInfo)iterator.next();
                if (stationInfo.subscription != 2) continue;
                ++n;
            }
            this.mNumbers = new char[n][4];
            int n2 = 0;
            iterator = channelListFromSouth.iterator();
            while (iterator.hasNext()) {
                StationInfo stationInfo = (StationInfo)iterator.next();
                if (stationInfo.subscription != 2) continue;
                String string = Integer.toString(stationInfo.stationNumber);
                for (int i2 = 0; i2 < 4; ++i2) {
                    this.mNumbers[n2][i2] = i2 < string.length() ? string.charAt(i2) : (char)2;
                }
                ++n2;
            }
        }
    }

    private String prepareDigitString() {
        int n;
        if (!this.mUseChannelFilter) {
            return "0123456789";
        }
        boolean[] blArray = new boolean[10];
        char[] cArray = this.mChannelNumberEntered.toString().toCharArray();
        int n2 = cArray.length;
        if (n2 >= 4) {
            return "";
        }
        for (int i2 = 0; i2 < this.mNumbers.length; ++i2) {
            int n3;
            n = 1;
            for (n3 = 0; n3 < n2; ++n3) {
                if (this.mNumbers[i2][n3] == cArray[n3]) continue;
                n = 0;
                break;
            }
            if (n == 0 || this.mNumbers[i2][n2] == '\u0002') continue;
            n3 = this.mNumbers[i2][n2] - 48;
            if (n3 < 0) {
                blArray[0] = true;
            }
            if (n3 >= 10) continue;
            blArray[n3] = true;
        }
        StringBuffer stringBuffer = new StringBuffer(10);
        for (n = 0; n < blArray.length; ++n) {
            if (!blArray[n]) continue;
            stringBuffer.append("0123456789".charAt(n));
        }
        String string = stringBuffer.toString();
        return string;
    }

    private void showAdvisory(String string) {
        this.getModelApi().updateSpellerDataForEnteringChannelNumber("", string, "", 0, 0, 0, 0);
        int n = this.mPool.getInt(60);
        this.mTarget.startTimer(-1450835712, (long)n, false);
        this.mChannelNumberEntered.setLength(0);
    }

    private boolean checkIfChannelExist() {
        String string = this.mChannelNumberEntered.toString();
        if (string.length() == 0) {
            return false;
        }
        int n = -1;
        try {
            n = Integer.parseInt(string);
        }
        catch (Exception exception) {
            return false;
        }
        if (n < 0 || n > 999) {
            return false;
        }
        if (n == 0) {
            return true;
        }
        StationInfo stationInfo = this.getChannels().getChannel(n);
        return null != stationInfo && null != this.mDb && null != this.mDb.getChannels() && stationInfo.getSubscription() == 2 && !this.mDb.getChannels().isInvalid(stationInfo.sID);
    }

    void resetSiriusToFactorySettings() {
        if (ServiceManager.logger.isTraceEnabled(512)) {
            ServiceManager.logger.trace(512).append("Factory Reset request from FW").log();
        }
        this.mDb.getFilterListApi().resetSettings();
        this.mDb.getPresetApi().resetSettings();
        this.mPool.setInt(150, 2);
        this.mDb.getSeekApi().deleteAllSeekEntries();
        this.mDb.getTrafficApi().resetTrafficAlertSettings();
        this.mDb.getPool().setBoolean(152, true);
        StationInfo stationInfo = this.mPool.getChannel(23);
        if (null != stationInfo && stationInfo.getStationNumber() != 1) {
            ServiceManager.logger.info(512).append("SatMainStateTop - resetSiriusToFactorySettings: Default channel is set ").log();
            this.mPool.setChannel(23, SatConfig.DEFAULT_CHANNEL);
            this.mPool.setChannel(15, SatConfig.DEFAULT_CHANNEL);
        }
        RadioServiceManager.getServiceManager().setSdarsDefaultOrLsmFreqYetTobeTuned(true);
        this.mTarget.resetSettings();
        this.mPool.incInt(68);
        this.mPool.setInt(151, 0);
        TaggingApi.resetInstance();
    }
}

