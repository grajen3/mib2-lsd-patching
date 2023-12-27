/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.sound.ASLSoundData;
import de.vw.mib.asl.internal.sound.HsmSoundSetterHandling;
import de.vw.mib.asl.internal.sound.SoundUtil;
import de.vw.mib.asl.internal.sound.has.SoundHASUpdater;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.TimerServer;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeAuxLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeBluetoothLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeEntertainmentLoweringLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeICCLimitsCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeNavEntLowLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeNaviLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeNaviLimitPopupCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumePhoneLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumePhoneLimitPopupCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeRingtoneLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeSDSLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeSDSLimitPopupCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeTALimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeTALimitPopupCollector;
import org.dsi.ifc.base.DSIListener;

public class HsmSoundSetterHandling$StateSoundSetterHandlingMain
extends AbstractHsmState {
    private HsmSoundSetterHandling target;
    private int lastMenuSource;
    private int activeConnection;
    private int activeEntConnection;
    private int soundSettingConnection;
    private int aMAvailableState;
    private boolean recallSoundSettingsPending;
    private boolean sliderOpen;
    private int NAV_VOL_MIN_RANGE_UNDEFINED;
    private boolean NAV_VOL_MIN_REREQUESTED;
    private int navMenuVolumeMinRange;
    private static final int NAV_ANN_INVALID;
    private static final int NAV_ANN_OFF;
    private static final int NAV_ANN_ON;
    private int navAnnStatus;
    private boolean isICCActive;
    private boolean menuVolumesInitialized;
    private short lastSetBalanceValue;
    private short lastSetFaderValue;
    private short lastUpdatedBalanceValue;
    private short lastUpdatedFaderValue;
    private boolean forceBalFadSync;
    private boolean ringtoneWaveplayerTriggeredByMe;
    private int lastRadioSelectstationTrigger;
    private final /* synthetic */ HsmSoundSetterHandling this$0;

    public HsmSoundSetterHandling$StateSoundSetterHandlingMain(HsmSoundSetterHandling hsmSoundSetterHandling, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = hsmSoundSetterHandling;
        super(hsm, string, hsmState);
        this.target = this.this$0;
        this.soundSettingConnection = 2;
        this.aMAvailableState = 3;
        this.recallSoundSettingsPending = false;
        this.sliderOpen = false;
        this.NAV_VOL_MIN_RANGE_UNDEFINED = -1;
        this.NAV_VOL_MIN_REREQUESTED = false;
        this.navMenuVolumeMinRange = this.NAV_VOL_MIN_RANGE_UNDEFINED;
        this.navAnnStatus = -1;
        this.isICCActive = false;
        this.menuVolumesInitialized = false;
        this.lastSetBalanceValue = (short)-100;
        this.lastSetFaderValue = (short)-100;
        this.lastUpdatedBalanceValue = 0;
        this.lastUpdatedFaderValue = 0;
        this.forceBalFadSync = false;
        this.ringtoneWaveplayerTriggeredByMe = false;
        this.lastRadioSelectstationTrigger = 0;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        block0 : switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.dsiAudioManagement.setNotification(new int[]{3, 2}, (DSIListener)this.target.dsiAudioManagementListener);
                this.target.dsiSound.setNotification(new int[]{24, 2, 9}, (DSIListener)this.target.dsiSoundListener);
                break;
            }
            case 4300013: {
                ASLSoundData.initSoundSettings();
                this.target.dsiSound.revertToFactorySettings(1, 1);
                this.getVolumeSettingVolumes();
                ASLSoundData.persistence.resetToDefaults();
                AbstractASLHsmTarget.writeIntegerToDatapool(3420, ASLSoundData.persistence.getEqMode());
                ServiceManager.logger.info(16).append("Sound Info: ").append(ASLSoundData.getDescription2()).log();
                break;
            }
            case 100004: {
                this.this$0.trace("[SoundSetterHandling] received profile change");
                this.recallSoundSettingsPending = true;
                this.recallSoundSettings();
                break;
            }
            case 100005: {
                this.this$0.trace("[SoundSetterHandling] received global profile change completed");
                this.sendCurrentNavAnnouncementStatus();
                break;
            }
            case 1073743105: {
                int n = eventGeneric.getInt(0);
                this.setPresetPositionMIB2(n);
                break;
            }
            case 1073743958: {
                int n = eventGeneric.getInt(0);
                this.setSoundFocusMIB2(n);
                break;
            }
            case 4300067: {
                int n = eventGeneric.getInt(0);
                this.changeVolume(n);
                break;
            }
            case 0x40000504: {
                int n = eventGeneric.getInt(0);
                int n2 = eventGeneric.getInt(1);
                this.setVolume(n, n2);
                break;
            }
            case 1073743091: {
                int n = eventGeneric.getInt(0);
                this.decreaseVolume(n);
                break;
            }
            case 1073743097: {
                int n = eventGeneric.getInt(0);
                this.increaseVolume(n);
                break;
            }
            case 1073743846: {
                int n = eventGeneric.getInt(0);
                this.setPresetEQ2MIB2(n);
                break;
            }
            case 0x400004F4: {
                this.this$0.warn("[SoundSetterHandling] ASL_SOUND_EQ_ROOM_SETTINGS is not handled!");
                break;
            }
            case 1073743107: {
                int n = eventGeneric.getInt(0);
                short s = (short)eventGeneric.getInt(1);
                this.setTone(n, s);
                break;
            }
            case 1073743090: {
                int n = eventGeneric.getInt(0);
                this.decreaseTone(n);
                break;
            }
            case 1073743096: {
                int n = eventGeneric.getInt(0);
                this.increaseTone(n);
                break;
            }
            case 1073743083: {
                int n = eventGeneric.getInt(0);
                this.activateAudioFeedback(n);
                break;
            }
            case 1073743094: {
                int n = eventGeneric.getInt(0);
                int n3 = eventGeneric.getInt(1);
                this.target.dsiSound.setEqualizer(this.soundSettingConnection, 1, ASLSoundData.equalizerFrequencies[n], n3);
                break;
            }
            case 1073743089: {
                int n = eventGeneric.getInt(0);
                short s = 1;
                this.target.dsiSound.decreaseEqualizer(this.soundSettingConnection, 1, ASLSoundData.equalizerFrequencies[n], s);
                break;
            }
            case 1073743095: {
                int n = eventGeneric.getInt(0);
                short s = 1;
                this.target.dsiSound.increaseEqualizer(this.soundSettingConnection, 1, ASLSoundData.equalizerFrequencies[n], s);
                break;
            }
            case 1073743085: {
                int n = eventGeneric.getInt(0);
                int n4 = eventGeneric.getInt(1);
                int n5 = ASLSoundData.convertAuxIpodAVGainASL2DSI(n4);
                switch (n) {
                    case 0: 
                    case 1: 
                    case 2: {
                        if (ServiceManager.configManagerDiag.getPureVariant().equals("HIGH_KOR")) {
                            this.target.dsiSound.setInputGainOffset(215, 1, (short)n5);
                            this.target.dsiSound.setInputGainOffset(216, 1, (short)n5);
                            break block0;
                        }
                        this.target.dsiSound.setInputGainOffset(16, 1, (short)n5);
                        break block0;
                    }
                }
                break;
            }
            case 1073743100: {
                int n = eventGeneric.getInt(0);
                short s = (short)ASLSoundData.convertAuxIpodAVGainASL2DSI(n);
                this.setAuxGain(s);
                break;
            }
            case 1073744223: {
                int n = eventGeneric.getInt(0);
                this.setDynaudioFocusPresetMIB2(n);
                break;
            }
            case 1073744225: {
                break;
            }
            case 1073744486: {
                int n = eventGeneric.getInt(0);
                if (n == 0) {
                    this.setDynaudioFocusPresetMIB2(2);
                    this.setBalanceFader((short)0, (short)0);
                    this.forceBalFadSync = true;
                } else if (n == 1) {
                    this.setBalanceFader((short)0, (short)0);
                    this.forceBalFadSync = true;
                }
                AbstractASLHsmTarget.writeIntegerToDatapool(3421, n);
                break;
            }
            case 1073744222: {
                int n = eventGeneric.getInt(0);
                this.setDynaudioCharacterPresetMIB2(n);
                break;
            }
            case 1073744224: {
                break;
            }
            case 1073744459: {
                int n = eventGeneric.getInt(0);
                if (n == ASLSoundData.persistence.getEqMode()) break;
                this.setDynaudioCharacterMode(n);
                break;
            }
            case 1075541824: {
                int n = eventGeneric.getInt(0);
                short s = ASLSoundData.convertDynAudSurrLev_ASL2DSI(n);
                this.target.dsiSound.setSurroundLevel(this.soundSettingConnection, 1, s);
                break;
            }
            case 1075541837: {
                short s = SoundUtil.getToggledDynAudSurrLev();
                this.target.dsiSound.setSurroundLevel(this.soundSettingConnection, 1, s);
                break;
            }
            case 1075541838: {
                int n = eventGeneric.getInt(0);
                int n6 = SoundUtil.getAuro3dDSI(n);
                this.target.dsiSound.set3DMode(this.soundSettingConnection, 1, n6);
                break;
            }
            case 1073744349: {
                short s = (short)eventGeneric.getInt(0);
                short s2 = (short)eventGeneric.getInt(1);
                this.setBalanceFader(s, s2);
                break;
            }
            case 1075541835: {
                int n = eventGeneric.getInt(0);
                this.setSkodaArkamysPreset(n == 0, ASLSoundData.arkamysVirtualSubwoofer);
                break;
            }
            case 1075541825: {
                int n = eventGeneric.getInt(0);
                this.setSkodaArkamysPreset(ASLSoundData.arkamysDreiDSound, n == 0);
                break;
            }
            case 1075541827: {
                int n = eventGeneric.getInt(0);
                this.setSkodaPQSurroundPresetPosition(n);
                break;
            }
            case 1075541829: {
                int n = eventGeneric.getInt(0);
                this.setSkodaPQSoundCharactersPresetEQ(n);
                break;
            }
            case 1075541828: {
                int n = eventGeneric.getInt(0);
                this.setSkodaCantonSoundFocus(n);
                break;
            }
            case 1075541834: {
                int n = eventGeneric.getInt(0);
                this.setSkodaCantonCharacterPresetMIB2(n);
                break;
            }
            case 1075541831: {
                int n = eventGeneric.getInt(0);
                short s = (short)ASLSoundData.convertBTGainASL2DSI(n);
                this.setBTGain(s);
                break;
            }
            case 1075541832: {
                int n = eventGeneric.getInt(0);
                short s = (short)ASLSoundData.convertAuxIpodAVGainASL2DSI(n);
                this.setAuxGain(s);
                break;
            }
            case 1075541833: {
                int n = eventGeneric.getInt(0);
                short s = (short)ASLSoundData.convertAuxIpodAVGainASL2DSI(n);
                this.setAuxGain(s);
                break;
            }
            case 1075541836: {
                short s = (short)eventGeneric.getInt(0);
                this.target.dsiSound.setLoweringEntertainment(this.soundSettingConnection, 1, 0, s);
                break;
            }
            case 100003: {
                super.getClass();
                int n = eventGeneric.getInt(0);
                super.getClass();
                int n7 = eventGeneric.getInt(1);
                if (n != this.lastUpdatedBalanceValue || n7 != this.lastUpdatedFaderValue || this.forceBalFadSync) {
                    if (this.this$0.isTraceEnabled()) {
                        this.this$0.trace().append("[SoundSetterHandling] BalanceFader sync error. Send sync request. Bal/Fad set: ").append(n).append("/").append(n7).append(", last updated Bal/Fad: ").append(this.lastUpdatedBalanceValue).append("/").append(this.lastUpdatedFaderValue).log();
                    }
                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(507);
                    this.forceBalFadSync = false;
                    break;
                }
                if (!this.this$0.isTraceEnabled()) break;
                this.this$0.trace().append("[SoundSetterHandling] BalanceFader sync timer expired ok, Bal/Fad in sync: ").append(n).append("/").append(n7).log();
                break;
            }
            case 100001: {
                this.target.triggerObserver(369704192, null);
                this.ringtoneWaveplayerTriggeredByMe = true;
                break;
            }
            case 100002: {
                if (eventGeneric.getResult() == 0) {
                    if (this.lastRadioSelectstationTrigger != 420035840) {
                        this.this$0.trace("[SoundSetterHandling] received EV_RESPONSE_MENU_TA_CONNECTION_SET");
                        this.target.triggerObserver(420035840, null);
                        this.lastRadioSelectstationTrigger = 420035840;
                        break;
                    }
                    this.this$0.trace("[SoundSetterHandling] received EV_RESPONSE_MENU_TA_CONNECTION_SET, but radio just triggered to select FMTA. Not triggering again. Just fading.");
                    this.triggerFadeToMenuTA();
                    break;
                }
                this.this$0.trace("[SoundSetterHandling] received EV_RESPONSE_MENU_TA_CONNECTION_SET failed! Not triggering radio to selectStation.");
                break;
            }
            case 4000026: {
                this.this$0.trace("[SoundSetterHandling] received ASL_SOUND_RADIO_SELECTSTATION_FMTA_RESPONSE");
                this.triggerFadeToMenuTA();
                break;
            }
            case 4000015: {
                int n = eventGeneric.getInt(0);
                this.abortLastFeedbackDevice(n);
                break;
            }
            case 4000033: {
                this.changeVolume(-1);
                break;
            }
            case 4000032: {
                this.changeVolume(1);
                break;
            }
            case 4000036: {
                short s = (short)eventGeneric.getInt(1);
                short s3 = (short)eventGeneric.getInt(2);
                this.setBalanceFader(s, s3);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiAudioManagementUpdateAMAvailable(int n, int n2, int n3) {
        this.aMAvailableState = n;
        this.recallSoundSettings();
    }

    public void dsiAudioManagementUpdateActiveConnection(int n, int n2, int n3) {
        this.activeConnection = n;
    }

    public void dsiAudioManagementUpdateActiveEntertainmentConnection(int n, int n2, int n3) {
        this.soundSettingConnection = this.activeEntConnection = n;
        this.this$0.onVolumeConnection = this.activeEntConnection;
        if (!this.menuVolumesInitialized && this.activeEntConnection != 0) {
            this.menuVolumesInitialized = true;
            this.getVolumeSettingVolumes();
        }
    }

    public void dsiSoundUpdateVolume(int n, int n2, short s, int n3) {
        if (n == 83) {
            this.handleNavVolume(s);
        }
        if (n == 262) {
            this.handleICCVolume(s);
        }
    }

    public void dsiSoundUpdateBalance(int n, int n2, short s, int n3) {
        this.lastUpdatedBalanceValue = s;
        ServiceManager.eventMain.getTimerServer().restartTimedEvent(this.target.getTargetId(), -1551499008);
    }

    public void dsiSoundUpdateFader(int n, int n2, short s, int n3) {
        this.lastUpdatedFaderValue = s;
        ServiceManager.eventMain.getTimerServer().restartTimedEvent(this.target.getTargetId(), -1551499008);
    }

    public void dsiSoundInputGainOffsetRange(int n, int n2, int n3, int n4) {
        switch (n) {
            case 16: 
            case 215: 
            case 216: {
                SoundVolumeAuxLimitCollector soundVolumeAuxLimitCollector = (SoundVolumeAuxLimitCollector)ListManager.getGenericASLList(1534).getRowItem(0);
                soundVolumeAuxLimitCollector.sound_volume_aux_min = n3;
                soundVolumeAuxLimitCollector.sound_volume_aux_max = n4;
                ListManager.getGenericASLList(1534).updateList(ListManager.getGenericASLList(1534).getDSIObjects());
                ASLSoundData.setAuxIpodAVGainDSI(n3, n4);
                this.target.dsiSound.getInputGainOffset(n, 1);
                break;
            }
            case 21: {
                SoundVolumeBluetoothLimitCollector soundVolumeBluetoothLimitCollector = (SoundVolumeBluetoothLimitCollector)ListManager.getGenericASLList(1535).getRowItem(0);
                soundVolumeBluetoothLimitCollector.sound_volume_bluetooth_min = n3;
                soundVolumeBluetoothLimitCollector.sound_volume_bluetooth_max = n4;
                ListManager.getGenericASLList(1535).updateList(ListManager.getGenericASLList(1535).getDSIObjects());
                ASLSoundData.setBTGainDSI(n3, n4);
                this.target.dsiSound.getInputGainOffset(n, 1);
                break;
            }
        }
    }

    public void dsiSoundMenuVolEntRange(int n, int n2, int n3) {
        Object object;
        if (n == 1) {
            object = (SoundVolumeEntertainmentLoweringLimitCollector)ListManager.getGenericASLList(1523).getRowItem(0);
            ((SoundVolumeEntertainmentLoweringLimitCollector)object).sound_volume_entertainment_lowering_min = n2;
            ((SoundVolumeEntertainmentLoweringLimitCollector)object).sound_volume_entertainment_lowering_max = n3;
            ListManager.getGenericASLList(1523).updateList(ListManager.getGenericASLList(1523).getDSIObjects());
        }
        if (n == 0) {
            object = (SoundVolumeNavEntLowLimitCollector)ListManager.getGenericASLList(1939741440).getRowItem(0);
            ((SoundVolumeNavEntLowLimitCollector)object).sound_volume_nav_ent_low_min = n2;
            ((SoundVolumeNavEntLowLimitCollector)object).sound_volume_nav_ent_low_max = n3;
            ListManager.getGenericASLList(1939741440).updateList(ListManager.getGenericASLList(1939741440).getDSIObjects());
        }
    }

    public void dsiSoundMenuVolumeRange(int n, int n2, int n3, int n4) {
        switch (n) {
            case 83: {
                this.navMenuVolumeMinRange = n3;
                SoundVolumeNaviLimitCollector soundVolumeNaviLimitCollector = (SoundVolumeNaviLimitCollector)ListManager.getGenericASLList(1524).getRowItem(0);
                soundVolumeNaviLimitCollector.sound_volume_navi_max = n4;
                soundVolumeNaviLimitCollector.sound_volume_navi_min = n3;
                ListManager.getGenericASLList(1524).updateList(ListManager.getGenericASLList(1524).getDSIObjects());
                SoundVolumeNaviLimitPopupCollector soundVolumeNaviLimitPopupCollector = (SoundVolumeNaviLimitPopupCollector)ListManager.getGenericASLList(1525).getRowItem(0);
                soundVolumeNaviLimitPopupCollector.sound_volume_navi_max_popup = 30;
                soundVolumeNaviLimitPopupCollector.sound_volume_navi_min_popup = 0;
                ListManager.getGenericASLList(1525).updateList(ListManager.getGenericASLList(1525).getDSIObjects());
                SoundHASUpdater.setVolumeRanges(1496, n3, n4);
                break;
            }
            case 84: {
                SoundVolumeTALimitCollector soundVolumeTALimitCollector = (SoundVolumeTALimitCollector)ListManager.getGenericASLList(1532).getRowItem(0);
                soundVolumeTALimitCollector.sound_volume_ta_max = n4;
                soundVolumeTALimitCollector.sound_volume_ta_min = n3;
                ListManager.getGenericASLList(1532).updateList(ListManager.getGenericASLList(1532).getDSIObjects());
                SoundVolumeTALimitPopupCollector soundVolumeTALimitPopupCollector = (SoundVolumeTALimitPopupCollector)ListManager.getGenericASLList(1533).getRowItem(0);
                soundVolumeTALimitPopupCollector.sound_volume_ta_max_popup = ASLSoundData.volumeEntertainmentPopupMax;
                soundVolumeTALimitPopupCollector.sound_volume_ta_min_popup = 0;
                ListManager.getGenericASLList(1533).updateList(ListManager.getGenericASLList(1533).getDSIObjects());
                SoundHASUpdater.setVolumeRanges(1503, n3, n4);
                break;
            }
            case 86: {
                SoundVolumeSDSLimitCollector soundVolumeSDSLimitCollector = (SoundVolumeSDSLimitCollector)ListManager.getGenericASLList(1530).getRowItem(0);
                soundVolumeSDSLimitCollector.sound_volume_sds_max = n4;
                soundVolumeSDSLimitCollector.sound_volume_sds_min = n3;
                ListManager.getGenericASLList(1530).updateList(ListManager.getGenericASLList(1530).getDSIObjects());
                SoundVolumeSDSLimitPopupCollector soundVolumeSDSLimitPopupCollector = (SoundVolumeSDSLimitPopupCollector)ListManager.getGenericASLList(1531).getRowItem(0);
                soundVolumeSDSLimitPopupCollector.sound_volume_sds_max_popup = 30;
                soundVolumeSDSLimitPopupCollector.sound_volume_sds_min_popup = 0;
                ListManager.getGenericASLList(1531).updateList(ListManager.getGenericASLList(1531).getDSIObjects());
                SoundHASUpdater.setVolumeRanges(1502, n3, n4);
                break;
            }
            case 87: {
                SoundVolumePhoneLimitCollector soundVolumePhoneLimitCollector = (SoundVolumePhoneLimitCollector)ListManager.getGenericASLList(1527).getRowItem(0);
                soundVolumePhoneLimitCollector.sound_volume_phone_max = n4;
                soundVolumePhoneLimitCollector.sound_volume_phone_min = n3;
                ListManager.getGenericASLList(1527).updateList(ListManager.getGenericASLList(1527).getDSIObjects());
                SoundVolumePhoneLimitPopupCollector soundVolumePhoneLimitPopupCollector = (SoundVolumePhoneLimitPopupCollector)ListManager.getGenericASLList(1528).getRowItem(0);
                soundVolumePhoneLimitPopupCollector.sound_volume_phone_max_popup = 30;
                soundVolumePhoneLimitPopupCollector.sound_volume_phone_min_popup = 0;
                ListManager.getGenericASLList(1528).updateList(ListManager.getGenericASLList(1528).getDSIObjects());
                SoundVolumeRingtoneLimitCollector soundVolumeRingtoneLimitCollector = (SoundVolumeRingtoneLimitCollector)ListManager.getGenericASLList(1529).getRowItem(0);
                soundVolumeRingtoneLimitCollector.sound_volume_ringtone_max = n4;
                soundVolumeRingtoneLimitCollector.sound_volume_ringtone_min = n3;
                ListManager.getGenericASLList(1529).updateList(ListManager.getGenericASLList(1529).getDSIObjects());
                SoundHASUpdater.setVolumeRanges(1500, n3, n4);
                break;
            }
            case 262: {
                SoundVolumeICCLimitsCollector soundVolumeICCLimitsCollector = (SoundVolumeICCLimitsCollector)ListManager.getGenericASLList(2006850304).getRowItem(0);
                soundVolumeICCLimitsCollector.sound_volume_icc_max = n4 - n3;
                soundVolumeICCLimitsCollector.sound_volume_icc_min = n3 - n3;
                ListManager.getGenericASLList(2006850304).updateList(ListManager.getGenericASLList(2006850304).getDSIObjects());
                ASLSoundData.iccMin = n3;
                this.target.dsiSound.getVolume(262, 1);
                break;
            }
        }
    }

    private void setBalanceFader(short s, short s2) {
        if (ServiceManager.eventMain.getTimerServer().isTimerActive(this.target.getTargetId(), -1551499008)) {
            ServiceManager.eventMain.getTimerServer().stopTimedEvent(this.target.getTargetId(), -1551499008);
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.target.getTargetId(), this.target.getTargetId(), -1551499008);
        super.getClass();
        eventGeneric.setInt(0, s);
        super.getClass();
        eventGeneric.setInt(1, s2);
        TimerServer timerServer = ServiceManager.eventMain.getTimerServer();
        super.getClass();
        timerServer.sendTimedEvent(eventGeneric, (long)0, false, false);
        this.target.dsiSound.setBalance(this.soundSettingConnection, 1, s);
        this.target.dsiSound.setFader(this.soundSettingConnection, 1, s2);
    }

    private void decreaseTone(int n) {
        short s = 1;
        switch (n) {
            case 1: {
                this.target.dsiSound.decreaseTreble(this.soundSettingConnection, 1, s);
                break;
            }
            case 2: {
                this.target.dsiSound.decreaseMiddle(this.soundSettingConnection, 1, s);
                break;
            }
            case 3: {
                this.target.dsiSound.decreaseBass(this.soundSettingConnection, 1, s);
                break;
            }
            case 4: {
                this.target.dsiSound.decreaseBalance(this.soundSettingConnection, 1, s);
                break;
            }
            case 5: {
                this.target.dsiSound.decreaseFader(this.soundSettingConnection, 1, s);
                break;
            }
            case 6: {
                this.target.dsiSound.decreaseNoiseCompensation(this.soundSettingConnection, 1, s);
                break;
            }
            case 7: {
                this.target.dsiSound.decreaseSubwoofer(this.soundSettingConnection, 1, s);
                break;
            }
        }
    }

    private void increaseTone(int n) {
        short s = 1;
        switch (n) {
            case 1: {
                this.target.dsiSound.increaseTreble(this.soundSettingConnection, 1, s);
                break;
            }
            case 2: {
                this.target.dsiSound.increaseMiddle(this.soundSettingConnection, 1, s);
                break;
            }
            case 3: {
                this.target.dsiSound.increaseBass(this.soundSettingConnection, 1, s);
                break;
            }
            case 4: {
                this.target.dsiSound.increaseBalance(this.soundSettingConnection, 1, s);
                break;
            }
            case 5: {
                this.target.dsiSound.increaseFader(this.soundSettingConnection, 1, s);
                break;
            }
            case 6: {
                this.target.dsiSound.increaseNoiseCompensation(this.soundSettingConnection, 1, s);
                break;
            }
            case 7: {
                this.target.dsiSound.increaseSubwoofer(this.soundSettingConnection, 1, s);
                break;
            }
        }
    }

    private void activateAudioFeedback(int n) {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("[SoundSetterHandling] recieved activateAudioFeedback for source ").append(n).log();
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(34159872);
        if (n != 0) {
            this.sliderOpen = true;
        }
        switch (n) {
            case 0: {
                if (!this.sliderOpen) break;
                this.sliderOpen = false;
                this.releaseLastMenuSource();
                break;
            }
            case 1: {
                this.target.dsiSound.getVolume(83, 1);
                this.target.dsiSound.getMenuVolumeRange(83, 1);
                eventGeneric.setInt(0, 83);
                this.lastMenuSource = 83;
                this.this$0.send(eventGeneric);
                this.lockConnection(83, true);
                this.lockConnection(8, true);
                break;
            }
            case 2: {
                this.target.dsiSound.getMenuVolumeRange(87, 1);
                eventGeneric.setInt(0, 87);
                this.lastMenuSource = 87;
                this.this$0.send(eventGeneric);
                this.lockConnection(8, true);
                break;
            }
            case 3: {
                this.target.dsiSound.getMenuVolumeRange(84, 1);
                eventGeneric.setInt(0, 84);
                eventGeneric.setBoolean(1, true);
                eventGeneric.setSenderEventId(-1568276224);
                this.lastMenuSource = 84;
                this.this$0.send(eventGeneric);
                this.lockConnection(8, true);
                break;
            }
            case 4: {
                eventGeneric.setInt(0, 80);
                this.lastMenuSource = 80;
                this.this$0.send(eventGeneric);
                this.lockConnection(8, true);
                break;
            }
            case 5: {
                this.target.dsiSound.getMenuVolumeRange(86, 1);
                eventGeneric.setInt(0, 86);
                this.lastMenuSource = 86;
                this.this$0.send(eventGeneric);
                this.lockConnection(86, true);
                this.lockConnection(8, true);
                break;
            }
            case 6: {
                this.target.dsiSound.getMenuVolumeRange(87, 1);
                eventGeneric.setInt(0, 87);
                eventGeneric.setBoolean(1, true);
                eventGeneric.setSenderEventId(-1585053440);
                this.lastMenuSource = 87;
                this.this$0.send(eventGeneric);
                this.lockConnection(8, true);
                break;
            }
            case 7: {
                break;
            }
            case 8: {
                eventGeneric.setInt(0, 94);
                this.lastMenuSource = 94;
                this.this$0.send(eventGeneric);
                this.lockConnection(8, true);
                break;
            }
            case 9: {
                if (ServiceManager.configManagerDiag.getPureVariant().equals("HIGH_KOR")) {
                    this.target.dsiSound.getInputGainOffsetRange(216, 1);
                    this.target.dsiSound.getInputGainOffsetRange(215, 1);
                } else {
                    this.target.dsiSound.getInputGainOffsetRange(16, 1);
                }
                this.releaseLastMenuSource();
                break;
            }
            case 10: {
                this.target.dsiSound.getInputGainOffsetRange(21, 1);
                this.releaseLastMenuSource();
                break;
            }
            case 11: {
                this.target.dsiSound.getMenuVolEntRange(0);
                this.target.dsiSound.getLoweringEntertainment(this.soundSettingConnection, 1, 0);
                eventGeneric.setInt(0, 83);
                this.lastMenuSource = 83;
                this.this$0.send(eventGeneric);
                this.lockConnection(83, true);
                this.lockConnection(8, true);
                break;
            }
            case 12: {
                this.target.dsiSound.getMenuVolumeRange(262, 1);
                eventGeneric.setInt(0, 262);
                this.lastMenuSource = 262;
                this.this$0.send(eventGeneric);
                this.lockConnection(8, true);
                break;
            }
        }
    }

    private void releaseLastMenuSource() {
        if (this.lastMenuSource != 0) {
            this.releaseConnection(this.lastMenuSource);
            this.lastMenuSource = 0;
        }
        this.lockConnection(8, false);
    }

    private void abortLastFeedbackDevice(int n) {
        if (n == 87 && this.ringtoneWaveplayerTriggeredByMe) {
            this.ringtoneWaveplayerTriggeredByMe = false;
            this.target.triggerObserver(386481408, null);
        } else if (n == 84) {
            this.target.triggerObserver(453590272, null);
            this.lastRadioSelectstationTrigger = 453590272;
        }
    }

    private void releaseConnection(int n) {
        this.lockConnection(n, false);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(67714304);
        eventGeneric.setInt(0, n);
        this.this$0.send(eventGeneric);
    }

    private void lockConnection(int n, boolean bl) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.this$0.getTargetId(), -1338698496, 218709248);
        eventGeneric.setInt(0, n);
        eventGeneric.setBoolean(1, bl);
        this.this$0.send(eventGeneric);
    }

    private void setTone(int n, short s) {
        switch (n) {
            case 1: {
                this.target.dsiSound.setTreble(this.soundSettingConnection, 1, s);
                break;
            }
            case 2: {
                this.target.dsiSound.setMiddle(this.soundSettingConnection, 1, s);
                break;
            }
            case 3: {
                this.target.dsiSound.setBass(this.soundSettingConnection, 1, s);
                break;
            }
            case 4: {
                if (this.lastSetBalanceValue == s) break;
                this.target.dsiSound.setBalance(this.soundSettingConnection, 1, s);
                this.lastSetBalanceValue = s;
                break;
            }
            case 5: {
                if (this.lastSetFaderValue == s) break;
                this.target.dsiSound.setFader(this.soundSettingConnection, 1, s);
                this.lastSetFaderValue = s;
                break;
            }
            case 6: {
                this.target.dsiSound.setNoiseCompensation(this.soundSettingConnection, 1, s);
                break;
            }
            case 7: {
                this.target.dsiSound.setSubwoofer(this.soundSettingConnection, 1, s);
                break;
            }
            case 8: {
                this.target.dsiSound.setSurroundLevel(this.soundSettingConnection, 1, s);
                break;
            }
        }
    }

    private void increaseVolume(int n) {
        this.changeVolume(1);
    }

    private void decreaseVolume(int n) {
        this.changeVolume(-1);
    }

    private void setVolume(int n, int n2) {
        int n3 = this.convertVolumeConnectASL2DSI(n);
        int n4 = this.convertVolumeVolumeASL2DSI(n, n2);
        if (n3 != -1) {
            this.target.dsiSound.setVolume(n3, 1, (short)n4);
        }
        if (n3 == 83 && n3 != this.activeConnection) {
            this.target.dsiSound.getVolume(n3, 1);
        }
    }

    void changeVolume(int n) {
        short s = (short)n;
        if (n == 0) {
            return;
        }
        if (n < 0) {
            s = (short)(n * -1);
            this.target.dsiSound.decreaseVolume(2, 1, s);
        } else {
            this.target.dsiSound.increaseVolume(2, 1, s);
        }
    }

    private void handleNavVolume(int n) {
        if (this.navMenuVolumeMinRange == this.NAV_VOL_MIN_RANGE_UNDEFINED && !this.NAV_VOL_MIN_REREQUESTED) {
            this.this$0.trace("[SoundSetterHandling] re-request range and volume for MenuTTSNav");
            this.target.dsiSound.getMenuVolumeRange(83, 1);
            this.target.dsiSound.getVolume(83, 1);
            this.NAV_VOL_MIN_REREQUESTED = true;
        } else {
            if (this.navMenuVolumeMinRange == this.NAV_VOL_MIN_RANGE_UNDEFINED) {
                this.this$0.warn("[SoundSetterHandling] MenuTTSNavMinVol still unknown, set to default: 4!");
                this.navMenuVolumeMinRange = 4;
            }
            if (n <= this.navMenuVolumeMinRange && this.navAnnStatus != 0) {
                this.this$0.info().append("[SoundSetterHandling] new ASL_SOUND_NAV_ANNOUNCEMENT_STATUS false").log();
                this.navAnnStatus = 0;
                this.sendCurrentNavAnnouncementStatus();
            }
            if (n > this.navMenuVolumeMinRange && this.navAnnStatus != 1) {
                this.this$0.info().append("[SoundSetterHandling] new ASL_SOUND_NAV_ANNOUNCEMENT_STATUS true").log();
                this.navAnnStatus = 1;
                this.sendCurrentNavAnnouncementStatus();
            }
        }
    }

    private void sendCurrentNavAnnouncementStatus() {
        if (ASLSoundData.persistence.isProfileChangeOngoing()) {
            this.this$0.info().append("[SoundSetterHandling] profile change ongoing, do not yet send Navi new ASL_SOUND_NAV_ANNOUNCEMENT_STATUS").log();
        } else {
            this.this$0.info().append("[SoundSetterHandling] send Navi new ASL_SOUND_NAV_ANNOUNCEMENT_STATUS ").append(this.navAnnStatus == 1).log();
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(319372544);
            eventGeneric.setBoolean(0, this.navAnnStatus == 1);
            this.this$0.sendSafe(eventGeneric);
        }
    }

    private void handleICCVolume(int n) {
        EventGeneric eventGeneric;
        EventGeneric eventGeneric2;
        if (!this.isICCActive && n > ASLSoundData.iccMin) {
            this.this$0.info().append("[SoundSetterHandling] set ICC active. Value:").append(n).append(", Min: ").append(ASLSoundData.iccMin).log();
            eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(34159872);
            eventGeneric2.setInt(0, 261);
            this.this$0.sendSafe(eventGeneric2);
            eventGeneric = ServiceManager.mGenericEventFactory.newEvent(34159872);
            eventGeneric.setInt(0, 260);
            this.this$0.sendSafe(eventGeneric);
            this.isICCActive = true;
        }
        if (this.isICCActive && n <= ASLSoundData.iccMin) {
            this.this$0.info("[SoundSetterHandling] set ICC not active");
            eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(67714304);
            eventGeneric2.setInt(0, 261);
            this.this$0.sendSafe(eventGeneric2);
            eventGeneric = ServiceManager.mGenericEventFactory.newEvent(67714304);
            eventGeneric.setInt(0, 260);
            this.this$0.sendSafe(eventGeneric);
            this.isICCActive = false;
        }
    }

    private void setDynaudioCharacterMode(int n) {
        ASLSoundData.persistence.setEqMode(n);
        if (SoundUtil.isSkoda()) {
            if (n == 1) {
                if (this.this$0.isTraceEnabled()) {
                    this.this$0.trace().append("[SoundSetterHandling] set Skoda EQ preset: set TMB to 0, persist current T/M/B: ").append(ASLSoundData.entTreble).append("/").append(ASLSoundData.entMiddle).append("/").append(ASLSoundData.entBass).append(", set stored PresetEQ: ").append(Integer.toHexString(ASLSoundData.persistence.getEqPresetCanton())).log();
                }
                ASLSoundData.persistence.setEqUserTreble(ASLSoundData.entTreble);
                ASLSoundData.persistence.setEqUserMiddle(ASLSoundData.entMiddle);
                ASLSoundData.persistence.setEqUserBass(ASLSoundData.entBass);
                this.target.dsiSound.setTreble(this.soundSettingConnection, 1, (short)0);
                this.target.dsiSound.setMiddle(this.soundSettingConnection, 1, (short)0);
                this.target.dsiSound.setBass(this.soundSettingConnection, 1, (short)0);
                this.target.dsiSound.setPresetEQ(this.soundSettingConnection, 1, ASLSoundData.persistence.getEqPresetCanton());
            } else if (n == 0) {
                if (this.this$0.isTraceEnabled()) {
                    this.this$0.trace().append("[SoundSetterHandling] set Skoda EQ custom: restore from persistence T/M/B: ").append(ASLSoundData.persistence.getEqUserTreble()).append("/").append(ASLSoundData.persistence.getEqUserMiddle()).append("/").append(ASLSoundData.persistence.getEqUserBass()).append(", persist current PresetEQ: ").append(Integer.toHexString(ASLSoundData.presetEQ)).log();
                }
                this.target.dsiSound.setTreble(this.soundSettingConnection, 1, ASLSoundData.persistence.getEqUserTreble());
                this.target.dsiSound.setMiddle(this.soundSettingConnection, 1, ASLSoundData.persistence.getEqUserMiddle());
                this.target.dsiSound.setBass(this.soundSettingConnection, 1, ASLSoundData.persistence.getEqUserBass());
                ASLSoundData.persistence.setEqPresetCanton(ASLSoundData.presetEQ);
                this.setSkodaCantonCharacterPresetMIB2(0);
            }
        }
        AbstractASLHsmTarget.writeIntegerToDatapool(3420, n);
    }

    private void setPresetEQ2MIB2(int n) {
        switch (n) {
            case 0: {
                this.target.dsiSound.setPresetEQ(this.soundSettingConnection, 1, 1);
                break;
            }
            case 1: {
                this.target.dsiSound.setPresetEQ(this.soundSettingConnection, 1, 2);
                break;
            }
            default: {
                this.this$0.warn().append("[HsmSoundSetter] EQSettings2->PresetEQ: Unknown value: ").append(n).log();
            }
        }
    }

    private void setPresetPositionMIB2(int n) {
        switch (n) {
            case 0: {
                this.target.dsiSound.setPresetPosition(this.soundSettingConnection, 1, 1);
                break;
            }
            case 1: {
                this.target.dsiSound.setPresetPosition(this.soundSettingConnection, 1, 2);
                break;
            }
            case 2: {
                this.target.dsiSound.setPresetPosition(this.soundSettingConnection, 1, 4);
                break;
            }
            default: {
                this.this$0.warn().append("[HsmSoundSetter] Surround->PresetPosition, Unknown value: ").append(n).log();
            }
        }
    }

    private void setSoundFocusMIB2(int n) {
        switch (n) {
            case 0: {
                this.target.dsiSound.setPresetPosition(this.soundSettingConnection, 1, 1);
                break;
            }
            case 1: {
                if (SoundUtil.isSkoda()) {
                    this.target.dsiSound.setPresetPosition(this.soundSettingConnection, 1, 8);
                    break;
                }
                this.target.dsiSound.setPresetPosition(this.soundSettingConnection, 1, 2);
                break;
            }
            case 2: {
                this.target.dsiSound.setPresetPosition(this.soundSettingConnection, 1, 2);
                break;
            }
            default: {
                this.this$0.warn().append("[HsmSoundSetter] SoundFocus->PresetPosition, Unknown value: ").append(n).log();
            }
        }
    }

    private void setDynaudioFocusPresetMIB2(int n) {
        switch (n) {
            case 0: {
                this.target.dsiSound.setPresetPosition(this.soundSettingConnection, 1, 2);
                break;
            }
            case 1: {
                this.target.dsiSound.setPresetPosition(this.soundSettingConnection, 1, 4);
                break;
            }
            case 2: {
                this.target.dsiSound.setPresetPosition(this.soundSettingConnection, 1, 1);
                break;
            }
            case 3: {
                this.target.dsiSound.setPresetPosition(this.soundSettingConnection, 1, 8);
                break;
            }
            default: {
                this.this$0.warn().append("[HsmSoundSetter] DynaudioSoundFocusPreset->PresetPosition, Unknown value: ").append(n).log();
            }
        }
    }

    private void setDynaudioCharacterPresetMIB2(int n) {
        switch (n) {
            case 0: {
                this.target.dsiSound.setPresetEQ(this.soundSettingConnection, 1, 1);
                break;
            }
            case 1: {
                this.target.dsiSound.setPresetEQ(this.soundSettingConnection, 1, 4);
                break;
            }
            case 2: {
                this.target.dsiSound.setPresetEQ(this.soundSettingConnection, 1, 2);
                break;
            }
            case 3: {
                this.target.dsiSound.setPresetEQ(this.soundSettingConnection, 1, 8);
                break;
            }
            default: {
                this.this$0.warn().append("[HsmSoundSetter] Dynaudio SoundCharacterPreset->PresetEQ, Unknown value: ").append(n).log();
            }
        }
    }

    private void setSkodaCantonCharacterPresetMIB2(int n) {
        switch (n) {
            case 0: {
                this.target.dsiSound.setPresetEQ(this.soundSettingConnection, 1, 1);
                break;
            }
            case 1: {
                this.target.dsiSound.setPresetEQ(this.soundSettingConnection, 1, 4);
                break;
            }
            case 2: {
                this.target.dsiSound.setPresetEQ(this.soundSettingConnection, 1, 8);
                break;
            }
            case 3: {
                this.target.dsiSound.setPresetEQ(this.soundSettingConnection, 1, 2);
                break;
            }
            default: {
                this.this$0.warn().append("[HsmSoundSetter] Canton SoundCharacterPreset->PresetEQ, Unknown value: ").append(n).log();
            }
        }
    }

    private void setSkodaArkamysPreset(boolean bl, boolean bl2) {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("[SoundSetterHandling] set Arkamys function, 3DSound: ").append(bl).append(", VirtualSubwoofer: ").append(bl2).log();
        }
        if (bl) {
            if (bl2) {
                this.target.dsiSound.setPresetPosition(this.soundSettingConnection, 1, 8);
            } else {
                this.target.dsiSound.setPresetPosition(this.soundSettingConnection, 1, 4);
            }
        } else {
            this.target.dsiSound.setPresetPosition(this.soundSettingConnection, 1, 1);
        }
    }

    private void setSkodaPQSurroundPresetPosition(int n) {
        switch (n) {
            case 0: {
                this.target.dsiSound.setPresetPosition(this.soundSettingConnection, 1, 16);
                break;
            }
            case 1: {
                this.target.dsiSound.setPresetPosition(this.soundSettingConnection, 1, 32);
                break;
            }
            case 2: {
                this.target.dsiSound.setPresetPosition(this.soundSettingConnection, 1, 2);
                break;
            }
        }
    }

    private void setSkodaPQSoundCharactersPresetEQ(int n) {
        switch (n) {
            case 0: {
                this.target.dsiSound.setPresetEQ(this.soundSettingConnection, 1, 1);
                break;
            }
            case 1: {
                this.target.dsiSound.setPresetEQ(this.soundSettingConnection, 1, 8);
                break;
            }
            case 2: {
                this.target.dsiSound.setPresetEQ(this.soundSettingConnection, 1, 2);
                break;
            }
            case 3: {
                this.target.dsiSound.setPresetEQ(this.soundSettingConnection, 1, 128);
                break;
            }
            case 4: {
                this.target.dsiSound.setPresetEQ(this.soundSettingConnection, 1, 4);
                break;
            }
        }
    }

    private void setSkodaCantonSoundFocus(int n) {
        switch (n) {
            case 0: {
                this.target.dsiSound.setPresetPosition(this.soundSettingConnection, 1, 1);
                break;
            }
            case 1: {
                this.target.dsiSound.setPresetPosition(this.soundSettingConnection, 1, 2);
                break;
            }
            case 2: {
                this.target.dsiSound.setPresetPosition(this.soundSettingConnection, 1, 4);
                break;
            }
        }
    }

    private void setAuxGain(short s) {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(60)) {
            this.target.dsiSound.setInputGainOffset(215, 1, s);
            this.target.dsiSound.setInputGainOffset(216, 1, s);
        } else {
            this.target.dsiSound.setInputGainOffset(16, 1, s);
        }
    }

    private void setBTGain(short s) {
        this.target.dsiSound.setInputGainOffset(21, 1, s);
    }

    private int convertVolumeConnectASL2DSI(int n) {
        switch (n) {
            case 1: {
                return 83;
            }
            case 2: {
                return 87;
            }
            case 3: {
                return 84;
            }
            case 4: {
                return 80;
            }
            case 5: {
                return 86;
            }
            case 6: {
                return 87;
            }
            case 7: {
                break;
            }
            case 9: {
                return 262;
            }
        }
        return -1;
    }

    private int convertVolumeVolumeASL2DSI(int n, int n2) {
        if (n == 9) {
            return n2 + ASLSoundData.iccMin;
        }
        return n2;
    }

    private void getVolumeSettingVolumes() {
        ServiceManager.dsiServiceLocator.setUnexpectedResponsePassing(HsmSoundSetterHandling.class$org$dsi$ifc$audio$DSISound == null ? (HsmSoundSetterHandling.class$org$dsi$ifc$audio$DSISound = HsmSoundSetterHandling.class$("org.dsi.ifc.audio.DSISound")) : HsmSoundSetterHandling.class$org$dsi$ifc$audio$DSISound, "getMenuVolumeRange", true);
        ServiceManager.dsiServiceLocator.setUnexpectedResponsePassing(HsmSoundSetterHandling.class$org$dsi$ifc$audio$DSISound == null ? (HsmSoundSetterHandling.class$org$dsi$ifc$audio$DSISound = HsmSoundSetterHandling.class$("org.dsi.ifc.audio.DSISound")) : HsmSoundSetterHandling.class$org$dsi$ifc$audio$DSISound, "getMenuVolEntRange", true);
        ServiceManager.dsiServiceLocator.setUnexpectedResponsePassing(HsmSoundSetterHandling.class$org$dsi$ifc$audio$DSISound == null ? (HsmSoundSetterHandling.class$org$dsi$ifc$audio$DSISound = HsmSoundSetterHandling.class$("org.dsi.ifc.audio.DSISound")) : HsmSoundSetterHandling.class$org$dsi$ifc$audio$DSISound, "getInputGainOffsetRange", true);
        this.target.dsiSound.getMenuVolumeRange(83, 1);
        this.target.dsiSound.getVolume(83, 1);
        this.target.dsiSound.getVolume(84, 1);
        this.target.dsiSound.getMenuVolumeRange(84, 1);
        this.target.dsiSound.getVolume(80, 1);
        this.target.dsiSound.getMenuVolumeRange(80, 1);
        this.target.dsiSound.getVolume(86, 1);
        this.target.dsiSound.getMenuVolumeRange(86, 1);
        this.target.dsiSound.getInputGainOffsetRange(16, 1);
        this.target.dsiSound.getInputGainOffsetRange(21, 1);
        this.target.dsiSound.getVolume(87, 1);
        this.target.dsiSound.getMenuVolumeRange(87, 1);
        this.target.dsiSound.getLoweringEntertainment(this.soundSettingConnection, 1, 0);
        this.target.dsiSound.getMenuVolEntRange(0);
        this.target.dsiSound.getMenuVolEntRange(1);
        if (SoundUtil.isICCAvailable()) {
            this.target.dsiSound.getMenuVolumeRange(262, 1);
        }
    }

    private void recallSoundSettings() {
        if (this.recallSoundSettingsPending && this.aMAvailableState == 3) {
            this.getVolumeSettingVolumes();
            AbstractASLHsmTarget.writeIntegerToDatapool(3420, ASLSoundData.persistence.getEqMode());
            boolean bl = ASLSoundData.persistence.getUserMuteActive();
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(bl ? 772357376 : 789134592);
            this.this$0.sendSafe(eventGeneric);
            ServiceManager.logger.info(16).append("Sound Info: ").append(ASLSoundData.getDescription2()).log();
            this.recallSoundSettingsPending = false;
        }
    }

    private void triggerFadeToMenuTA() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.this$0.getTargetId(), -1338698496, 50937088);
        eventGeneric.setInt(0, 84);
        this.target.triggerObserver(50937088, eventGeneric);
    }
}

