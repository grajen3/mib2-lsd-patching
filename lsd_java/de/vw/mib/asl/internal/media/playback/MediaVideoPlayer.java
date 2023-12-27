/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.playback;

import de.vw.mib.asl.framework.api.diagnosis.config.RegionCode;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.speller.ASLAPISpellerBinding;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.avdc.video.dvd.transformer.DVDAudioChannelCollector;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.media.accessor.MediaObjectAccessor;
import de.vw.mib.asl.internal.media.browser.MediaBrowserHelper;
import de.vw.mib.asl.internal.media.common.ResponseHandler;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdExecuteDvdMenu;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.media.AudioStream;
import org.dsi.ifc.media.ListEntry;

public class MediaVideoPlayer
extends MediaPlayer {
    private static final int RT_MENU_CMD = MediaVideoPlayer.assignRequestId();
    private static final GenericASLList DVD_SUBTITLE_LIST = ListManager.getGenericASLList(115);
    private static final GenericASLList DVD_AUDIO_CHANNEL_LIST = ListManager.getGenericASLList(153);
    private boolean mVideoDisclaimerShown = false;
    private ASLAPISpellerBinding mSpellerHsmPMLPIN;
    private String mTemporaryPIN;
    private int mSpellerFunction = -1;
    private int mPlayViewSize = 0;
    private ListEntry[] mPlayviewEntries = null;
    private int mTempPML = -1;
    private int mLastIndicatedDvdEvent = -1;
    private static final long VIEWANGLE_TIMEOUT;
    private static final int[] OBSERVER;

    public MediaVideoPlayer(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 330240768;
    }

    @Override
    protected void reset() {
        this.valueChangedBoolean(138, false);
        this.valueChangedBoolean(3353, true);
        this.valueChangedInteger(113, 0);
        this.valueChangedInteger(129, 0);
        this.valueChangedInteger(131, 0);
        this.valueChangedBoolean(2865, true);
        this.valueChangedInteger(144, 0);
        this.valueChangedInteger(145, 0);
        DVD_SUBTITLE_LIST.updateList(null);
        this.valueChangedInteger(111, 0);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        super.gotEvent(eventGeneric);
        block0 : switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.addObservers(OBSERVER);
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(51)) {
                    ServiceManager.adaptionApi.requestConfigManagerPersRegionCode(this.getTargetId(), -1551499008);
                }
                this.mSpellerHsmPMLPIN = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLAPISpellerFactory().createSimpleCursor(375131136, 154471488, 120917056, 171248704);
                if (Util.isNullOrEmpty(this.persistence.getParentalManagementPin())) {
                    MediaVideoPlayer.writeIntegerToDatapool(358353920, 0);
                } else {
                    MediaVideoPlayer.writeIntegerToDatapool(358353920, 1);
                }
                MediaVideoPlayer.writeIntegerToDatapool(291245056, this.persistence.getParentalManagementLevel());
                if (!ServiceManager.configManagerDiag.isFeatureFlagSet(51) && !ServiceManager.configManagerDiag.isFeatureFlagSet(52)) break;
                this.getDsiMediaBase().setParentalML(this.persistence.getParentalManagementLevel());
                break;
            }
            case 107: {
                this.removeObservers(OBSERVER);
                break;
            }
            case 1200004: {
                if (!ServiceManager.configManagerDiag.isFeatureFlagSet(51)) break;
                ServiceManager.adaptionApi.requestConfigManagerPersRegionCode(this.getTargetId(), -1551499008);
                break;
            }
            case 100003: {
                if (this.isTraceEnabled()) {
                    this.trace("Received region code data!");
                }
                if (eventGeneric.getResult() != 0 || eventGeneric.getInt(2) != 0 || eventGeneric.getLong(3) != 0) break;
                this.handleRegionCodeValues((RegionCode)eventGeneric.getObject(1));
                break;
            }
            case 4300050: {
                this.setDisclaimerShown(eventGeneric.getBoolean(0));
                break;
            }
            case 0x40000060: {
                if (Util.isBitSet(2048, this.getPlayerState().getCmdBlockingMask())) {
                    this.sendHMIEvent(430);
                    this.valueChangedBoolean(138, false);
                    return;
                }
                if (this.mLastIndicatedDvdEvent != 1) {
                    this.enqueueMenuCmd(1);
                    break;
                }
                this.valueChangedBoolean(138, true);
                break;
            }
            case 1073741938: {
                this.valueChangedBoolean(138, false);
                break;
            }
            case 1073741933: {
                if (Util.isBitSet(2048, this.getPlayerState().getCmdBlockingMask())) {
                    this.sendHMIEvent(430);
                    this.valueChangedBoolean(138, false);
                    return;
                }
                this.enqueueMenuCmd(1);
                break;
            }
            case 1073741927: {
                this.enqueueMenuCmd(2);
                break;
            }
            case 1073741944: {
                this.enqueueMenuCmd(6);
                break;
            }
            case 1073741942: {
                this.enqueueMenuCmd(5);
                break;
            }
            case 1073741945: {
                this.enqueueMenuCmd(3);
                break;
            }
            case 0x40000077: {
                this.enqueueMenuCmd(4);
                break;
            }
            case 1073741923: {
                this.enqueueMenuCmd(8);
                break;
            }
            case 1073741925: {
                this.enqueueMenuCmd(9);
                break;
            }
            case 1074541824: {
                this.getDSI().requestTouchEvent(0, eventGeneric.getInt(0), eventGeneric.getInt(1));
                break;
            }
            case 1074541825: {
                this.getDSI().requestTouchEvent(1, eventGeneric.getInt(0), eventGeneric.getInt(1));
                break;
            }
            case 1073741921: {
                this.mLanguageSettings.setPreferredLanguage(eventGeneric.getString(0), -1);
                break;
            }
            case 0x40000088: {
                this.setAudioStream(eventGeneric.getInt(0));
                break;
            }
            case 1073741922: {
                this.setSubtitleLanguage(eventGeneric.getInt(0));
                break;
            }
            case 1073741961: {
                this.setViewAngle(eventGeneric.getInt(0));
                break;
            }
            case 100002: {
                this.expiredViewAngleTimer();
                break;
            }
            case 1074541826: {
                break;
            }
            case 1074541827: {
                if (this.mTempPML == -1) {
                    this.mTempPML = 0;
                }
                this.getDsiMediaBase().setParentalML(this.mTempPML);
                break;
            }
            case 1074541828: {
                int n = eventGeneric.getInt(0);
                this.getDsiMediaBase().setParentalML(n);
                this.persistence.setParentalManagementLevel(n);
                MediaVideoPlayer.writeIntegerToDatapool(291245056, n);
                break;
            }
            case 1074541843: {
                this.getDSI().denyTempPMLRequest();
                break;
            }
            case 1074541829: {
                switch (this.mSpellerFunction) {
                    case 0: {
                        if (this.mSpellerHsmPMLPIN.getSpellerData().getEnteredText().equals(this.persistence.getParentalManagementPin())) {
                            MediaVideoPlayer.writeIntegerToDatapool(341576704, 2);
                            break block0;
                        }
                        MediaVideoPlayer.writeIntegerToDatapool(341576704, 1);
                        break block0;
                    }
                }
                this.warn("SPELLER_CHECK_PIN_AGAINST_SYSTEM and spellerFunction is not SPELLER_SET_FUNCTION__TYPE__C0_ACTUAL_PIN_INPUT");
                break;
            }
            case 1074541830: {
                this.mSpellerHsmPMLPIN.resetSpellerData();
                break;
            }
            case 1074541832: {
                this.mSpellerHsmPMLPIN.resetSpellerData();
                break;
            }
            case 1074541835: {
                this.mSpellerFunction = eventGeneric.getInt(0);
                MediaVideoPlayer.writeIntegerToDatapool(391908352, this.mSpellerFunction);
                if (this.mSpellerFunction == 0) {
                    MediaVideoPlayer.writeBooleanToDatapool(408685568, true);
                }
                this.mSpellerHsmPMLPIN.resetSpellerData();
                break;
            }
            case 1074541836: {
                switch (this.mSpellerFunction) {
                    case 2: {
                        this.persistence.setParentalManagementPin(this.mSpellerHsmPMLPIN.getSpellerData().getEnteredText());
                        MediaVideoPlayer.writeIntegerToDatapool(358353920, 1);
                        MediaVideoPlayer.writeIntegerToDatapool(341576704, 5);
                        break block0;
                    }
                }
                this.warn("SPELLER_SET_NEW_PIN and spellerFunction is not SPELLER_SET_FUNCTION__TYPE__C2_SECOND_NEW_PIN_INPUT");
                break;
            }
            case 1074541837: {
                this.mTemporaryPIN = this.mSpellerHsmPMLPIN.getSpellerData().getEnteredText();
                MediaVideoPlayer.writeIntegerToDatapool(341576704, 3);
                break;
            }
            default: {
                if (this.mSpellerHsmPMLPIN != null && this.mSpellerHsmPMLPIN.handleEvent(eventGeneric)) {
                    switch (this.mSpellerFunction) {
                        case 0: {
                            MediaVideoPlayer.writeBooleanToDatapool(408685568, true);
                            break block0;
                        }
                        case 1: {
                            MediaVideoPlayer.writeBooleanToDatapool(408685568, this.mSpellerHsmPMLPIN.getSpellerData().getEnteredText().length() == 4);
                            break block0;
                        }
                        case 2: {
                            MediaVideoPlayer.writeBooleanToDatapool(408685568, this.mSpellerHsmPMLPIN.getSpellerData().getEnteredText().equals(this.mTemporaryPIN));
                            break block0;
                        }
                    }
                    break;
                }
                this.handleEvent(eventGeneric);
            }
        }
    }

    public void setDisclaimerShown(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("MediaPlaybackVideo.setDisclaimerShown(").append(bl).append(")").log();
        }
        this.mVideoDisclaimerShown = bl;
    }

    public void dsiMediaPlayerIndicationDvdEvent(int n) {
        if (this.mLastIndicatedDvdEvent != n) {
            this.mLastIndicatedDvdEvent = n;
            if (n == 1) {
                this.valueChangedBoolean(138, true);
                if (this.mVideoDisclaimerShown) {
                    this.enqueueMenuCmd(2);
                }
            } else {
                this.valueChangedBoolean(138, false);
            }
        }
        if (this.isRegisteredForResponse(RT_MENU_CMD) && n == 1) {
            this.fireResponse(true);
        }
    }

    public void enqueueMenuCmd(int n) {
        MediaObjectAccessor.mMediaController.addCommand(new CmdExecuteDvdMenu(this, MediaObjectAccessor.getAudioManager(), n));
    }

    public void rqExecuteMenuCmd(int n, boolean bl, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_MENU_CMD, responseHandler)) {
            this.getDSI().executeMenuCmd(n);
            if (!bl) {
                this.getDSI().pause();
            }
            if (n != 1 || this.mLastIndicatedDvdEvent == 1) {
                this.fireResponse(true, "fire and forget");
            }
        }
    }

    public void dsiMediaPlayerUpdateCmdBlockingMask(int n, int n2) {
        if (n2 != 1) {
            this.getPlayerState().updateCmdBlockingMask(0);
            return;
        }
        this.getPlayerState().updateCmdBlockingMask(n);
        if (this.isTraceEnabled()) {
            this.trace().append("MediaPlaybackVideo.updateCmdBlockingMask(").append(MediaBrowserHelper.getCmdBlockingStr(n)).append(")").log();
        }
    }

    public void dsiMediaPlayerResponseCmdBlocked(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("MediaPlaybackVideo.updateResponseCmdBlocked(").append(Integer.toHexString(n)).append(")").log();
        }
        this.sendHMIEvent(430);
        if (Util.isBitSet(2048, n)) {
            this.setPlaying(true);
        }
        if (this.isRegisteredForResponse(RT_MENU_CMD) && Util.isBitSet(2048, n)) {
            this.fireResponse(true, "command Clocked");
        }
    }

    public void dsiMediaPlayerUpdateAudioStreamList(AudioStream[] audioStreamArray, int n) {
        if (n != 1) {
            return;
        }
        Object[] objectArray = null;
        if (Util.isNullOrEmpty(audioStreamArray)) {
            objectArray = new DVDAudioChannelCollector[]{new DVDAudioChannelCollector()};
        } else {
            objectArray = new DVDAudioChannelCollector[audioStreamArray.length];
            for (int i2 = 0; i2 < audioStreamArray.length; ++i2) {
                DVDAudioChannelCollector dVDAudioChannelCollector = new DVDAudioChannelCollector();
                dVDAudioChannelCollector.languageCode = audioStreamArray[i2].getLanguageCode();
                dVDAudioChannelCollector.audioLanguageExtension = audioStreamArray[i2].getAudioLanguageExtension();
                dVDAudioChannelCollector.numChannels = audioStreamArray[i2].getNumChannels();
                dVDAudioChannelCollector.audioCoding = audioStreamArray[i2].audioCoding;
                dVDAudioChannelCollector.samplingRate = audioStreamArray[i2].samplingRate;
                objectArray[i2] = dVDAudioChannelCollector;
            }
        }
        if (!Util.isNullOrEmpty(objectArray)) {
            DVD_AUDIO_CHANNEL_LIST.updateList(objectArray);
            this.valueChangedInteger(143, 0);
        }
    }

    public void dsiMediaPlayerUpdateActiveAudioStream(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        int n3 = 0;
        if (n >= 0 && DVD_AUDIO_CHANNEL_LIST.getSize() > n) {
            n3 = n;
        }
        DVD_AUDIO_CHANNEL_LIST.setActiveIndex(n3);
        this.valueChangedInteger(143, n3);
    }

    public void setAudioStream(int n) {
        if (DVD_AUDIO_CHANNEL_LIST.getSize() >= n) {
            DVD_AUDIO_CHANNEL_LIST.setActiveIndex(n);
            this.getDSI().setAudioStream(n);
        }
    }

    public void dsiMediaPlayerUpdateSubtitleList(int[] nArray, int n) {
        Object[] objectArray = null;
        if (Util.isNullOrEmpty(nArray)) {
            objectArray = new Object[]{new Integer(1)};
        } else {
            objectArray = new Object[nArray.length];
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                objectArray[i2] = new Integer(nArray[i2]);
            }
        }
        if (!Util.isNullOrEmpty(objectArray)) {
            DVD_SUBTITLE_LIST.updateList(objectArray);
            this.valueChangedInteger(111, 0);
        }
    }

    public void setSubtitleLanguage(int n) {
        this.getDSI().setSubtitleLanguage(n);
    }

    public void dsiMediaPlayerUpdateActiveSubtitle(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        int n3 = 0;
        if (n >= 0 && DVD_SUBTITLE_LIST.getSize() > n) {
            n3 = n;
        }
        DVD_SUBTITLE_LIST.setActiveIndex(n3);
        this.valueChangedInteger(111, n3);
    }

    public void dsiMediaPlayerUpdateNumVideoAngles(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        this.valueChangedInteger(145, n);
    }

    public void setViewAngle(int n) {
        if (!this.isTimerActive(-1568276224)) {
            int n2 = n + 1;
            this.getDSI().setVideoAngle(n2);
            this.startTimer(-1568276224, (long)0, false);
            this.valueChangedBoolean(2865, false);
        }
    }

    public void dsiMediaPlayerUpdateActiveVideoAngle(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        this.valueChangedInteger(144, n - 1);
        if (n2 == 1) {
            this.resetViewAngleTimer();
        }
    }

    public void expiredViewAngleTimer() {
        if (this.isTraceEnabled()) {
            this.trace().append("MediaSettings.expiredViewAngleTimer()").log();
        }
        this.valueChangedBoolean(2865, true);
    }

    public void resetViewAngleTimer() {
        if (this.isTraceEnabled()) {
            this.trace().append("MediaSettings.resetViewAngleTimer()").log();
        }
        if (this.isTimerActive(-1568276224)) {
            this.stopTimer(-1568276224);
        }
        this.valueChangedBoolean(2865, true);
    }

    public boolean isPlayviewEntry(long l) {
        if (Util.isNullOrEmpty(this.mPlayviewEntries)) {
            this.error().append("MediaPlayback.isPlayviewEntry(").append(l).append("): Invalid playback view entries").log();
        } else {
            for (int i2 = 0; i2 < this.mPlayviewEntries.length; ++i2) {
                if (this.mPlayviewEntries[i2] == null || this.mPlayviewEntries[i2].getEntryID() != l) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public void dsiMediaPlayerUpdatePlayViewSize(int n, int n2, int n3) {
        if (this.getActiveOrRequestedMedia().isDVDVideoAudio()) {
            if (n3 != 1) {
                return;
            }
            this.getDSI().requestPlayView(0L, 0, n, 0);
            if (this.mPlayViewSize != n) {
                this.mPlayViewSize = n;
            }
        } else {
            super.dsiMediaPlayerUpdatePlayViewSize(n, n2, n3);
        }
    }

    public void dsiMediaPlayerResponsePlayView(ListEntry[] listEntryArray, int n, int n2, int n3) {
        if (this.getActiveMedia().isDVDVideoAudio()) {
            if (this.isTraceEnabled()) {
                this.trace().append("MediaPlaybackVideo.responsePlayView(").append(!Util.isNullOrEmpty(listEntryArray) ? listEntryArray.length : 0).append(", ").append(n).append(", ").append(n2).append(")").log();
            }
            this.mPlayviewEntries = listEntryArray;
        }
    }

    public void dsiMediaBaseUpdateCustomerUpdate(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        this.valueChangedBoolean(3682, n == 2);
    }

    public void dsiMediaBaseUpdateParentalML(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        if (n == this.mTempPML) {
            this.mTempPML = -1;
        } else {
            this.persistence.setParentalManagementLevel(n);
            this.valueChangedInteger(291245056, n);
        }
    }

    public void dsiMediaPlayerTempPMLRequest(int n) {
        if (n > 0) {
            this.mTempPML = n;
            ServiceManager.aslPropertyManager.valueChangedInteger(308022272, 1);
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(308022272, 0);
        }
    }

    private void handleRegionCodeValues(RegionCode regionCode) {
        if (regionCode != null) {
            int n = regionCode.getValue(845);
            if (this.isTraceEnabled()) {
                this.trace().append("TargetMediaDSI.handleRegionCodeValues() getPossiChangForRegioCodeDvdMedia=").append(n).log();
            }
            ServiceManager.aslPropertyManager.valueChangedInteger(147, 5);
            ServiceManager.aslPropertyManager.valueChangedInteger(146, n);
        }
    }

    static {
        OBSERVER = new int[]{0x60000040, 1912602688, 1828716608, 1728053312, 2013265984, 1979711552, 2030043200, 0x77000040, 3476544, 20253760, 1660944448, 1694498880, 1627390016, -2013265856, 1644167232, -1996488640, 312295680, 37030976, 53808192, 70585408, 322243648, 87362624, 104139840, 154471488, 120917056, 137694272, 171248704, 188025920, 204803136, 221580352, -2075192832};
    }
}

