/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.Utils;
import de.vw.mib.asl.internal.list.impl.AbstractASLList;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.sound.ASLSoundData;
import de.vw.mib.asl.internal.sound.HsmSoundDPHandling;
import de.vw.mib.asl.internal.sound.SoundUtil;
import de.vw.mib.asl.internal.sound.has.SoundHASUpdater;
import de.vw.mib.asl.internal.sound.transformer.SoundEqualizerBandCollector;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.reflection.RuntimeUtil;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundBalanceFaderCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundToneSettingsBalanceLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundToneSettingsBassLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundToneSettingsCantonSurroundLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundToneSettingsFaderLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundToneSettingsGALALimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundToneSettingsMiddleLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundToneSettingsSubwooferLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundToneSettingsTrebleLimitCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeEntertainmentLimitsCollector;
import generated.de.vw.mib.asl.internal.sound.transformer.SoundVolumeOnVolumeSetupiLimitCollector;
import org.dsi.ifc.audio.AmplifierCapabilities;
import org.dsi.ifc.base.DSIListener;

public class HsmSoundDPHandling$StateSoundDPHandlingHandling
extends AbstractHsmState {
    private HsmSoundDPHandling target;
    private int balanceFader_balanceValue;
    private int balanceFader_faderValue;
    private boolean soundSettingsTriggered;
    private boolean isAudioFeedbackActive;
    private final /* synthetic */ HsmSoundDPHandling this$0;

    public HsmSoundDPHandling$StateSoundDPHandlingHandling(HsmSoundDPHandling hsmSoundDPHandling, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = hsmSoundDPHandling;
        super(hsm, string, hsmState);
        this.target = this.this$0;
        this.balanceFader_balanceValue = 0;
        this.balanceFader_faderValue = 0;
        this.soundSettingsTriggered = false;
        this.isAudioFeedbackActive = false;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.dsiAudioManagement.setNotification(new int[]{2, 3}, (DSIListener)this.target.dsiAudioManagementListener);
                this.target.dsiSound.setNotification(new int[]{24, 2, 4, 9, 21, 3, 5, 10, 12, 13, 14, 17, 18, 48, 19, 20, 22, 34, 26, 31, 32, 33, 27, 28, 35, 45, 43, 44, 42, 49, 47, 38, 55}, (DSIListener)this.target.dsiSoundListener);
                this.target.dsiSound.setNotification(39, (DSIListener)this.target.dsiSoundListener);
                this.initFromPersistence();
                this.this$0.aslNavigationServices.isServiceAvailable();
                break;
            }
            case 1073743083: {
                int n = eventGeneric.getInt(0);
                this.isAudioFeedbackActive = n != 0;
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiAudioManagementUpdateActiveConnection(int n, int n2, int n3) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("[SoundDPHandling] recieved updateActiveConnection: ").append(n);
        }
        this.this$0.activeConnection = n;
        if (this.this$0.activeEntConnection != -1) {
            AbstractASLHsmTarget.writeBooleanToDatapool(4138, SoundUtil.isEntSource(n) || SoundUtil.isOtherSoundSetupAccessibleSource(n));
        }
        int n4 = 0;
        switch (n) {
            case 15: 
            case 31: 
            case 32: 
            case 33: 
            case 34: 
            case 35: 
            case 84: 
            case 85: {
                n4 = 3;
                break;
            }
            case 87: 
            case 95: 
            case 98: 
            case 99: 
            case 103: 
            case 104: 
            case 106: 
            case 151: 
            case 157: 
            case 165: 
            case 210: 
            case 212: 
            case 218: 
            case 225: 
            case 226: 
            case 227: 
            case 228: 
            case 241: 
            case 246: {
                n4 = 2;
                break;
            }
            case 83: 
            case 116: 
            case 117: 
            case 220: 
            case 221: 
            case 235: 
            case 242: {
                n4 = 1;
                break;
            }
            case 86: 
            case 112: 
            case 113: 
            case 114: 
            case 115: 
            case 118: 
            case 119: 
            case 126: 
            case 127: 
            case 152: 
            case 155: 
            case 158: 
            case 161: 
            case 168: 
            case 171: 
            case 219: 
            case 243: 
            case 244: {
                n4 = 4;
                break;
            }
            default: {
                n4 = 0;
            }
        }
        SoundHASUpdater.setVolumeContainerSource(n4);
        if (this.this$0.activeEntConnection == n || n == 8) {
            AbstractASLHsmTarget.writeIntegerToDatapool(1472, 0);
            AbstractASLHsmTarget.writeIntegerToDatapool(1468, 1);
            if (n == 8) {
                AbstractASLHsmTarget.writeIntegerToDatapool(1493, 0);
                SoundHASUpdater.setVolumeContainerVolume(1493, 0);
            }
            return;
        }
        AbstractASLHsmTarget.writeIntegerToDatapool(1472, n4);
        int n5 = SoundUtil.getActiveAudioComponent(n);
        AbstractASLHsmTarget.writeIntegerToDatapool(1468, n5);
    }

    public void dsiAudioManagementUpdateActiveEntertainmentConnection(int n, int n2, int n3) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("[SoundDPHandling] recieved updateActiveEntertainmentConnection: ").append(n).log();
        }
        int n4 = 0;
        switch (n) {
            case 12: 
            case 13: 
            case 26: 
            case 28: 
            case 43: {
                n4 = 1;
                ASLStartupv7rFactory.getStartupv7rApi().getPersistableEarlyData().setLastConnRadio(true);
                break;
            }
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 23: 
            case 24: 
            case 201: 
            case 215: 
            case 216: {
                n4 = 2;
                ASLStartupv7rFactory.getStartupv7rApi().getPersistableEarlyData().setLastConnRadio(false);
                break;
            }
            case 214: 
            case 217: {
                n4 = 4;
                ASLStartupv7rFactory.getStartupv7rApi().getPersistableEarlyData().setLastConnRadio(false);
                break;
            }
            case 27: {
                n4 = 5;
                ASLStartupv7rFactory.getStartupv7rApi().getPersistableEarlyData().setLastConnRadio(false);
                break;
            }
            case 156: 
            case 162: 
            case 167: 
            case 240: {
                n4 = 6;
                ASLStartupv7rFactory.getStartupv7rApi().getPersistableEarlyData().setLastConnRadio(false);
                break;
            }
        }
        if (n != this.this$0.activeEntConnection && n != 9 && n != 0) {
            AbstractASLHsmTarget.writeIntegerToDatapool(1470, n4);
        }
        if (this.this$0.activeEntConnection == -1) {
            AbstractASLHsmTarget.writeBooleanToDatapool(4138, SoundUtil.isEntSource(this.this$0.activeConnection) || SoundUtil.isOtherSoundSetupAccessibleSource(this.this$0.activeConnection));
        }
        this.this$0.activeEntConnection = n;
        if (!this.soundSettingsTriggered && this.this$0.activeConnection == 8 && this.this$0.activeEntConnection != 0) {
            this.this$0.trace("[SoundDPHandling] force update sound settings");
            this.soundSettingsTriggered = true;
            this.getSoundSettings();
        }
    }

    public void dsiSoundUpdateActiveAmplifierCapabilities(AmplifierCapabilities amplifierCapabilities, int n) {
        ASLSoundData.amplifierCapabilities = amplifierCapabilities;
        if (amplifierCapabilities != null) {
            AbstractASLHsmTarget.writeBooleanToDatapool(1504, amplifierCapabilities.isBalance());
            AbstractASLHsmTarget.writeBooleanToDatapool(1506, amplifierCapabilities.isFader());
            AbstractASLHsmTarget.writeBooleanToDatapool(1511, amplifierCapabilities.isSubwoofer());
            AbstractASLHsmTarget.writeBooleanToDatapool(1505, false);
            this.handleAmplifierType2(amplifierCapabilities.amplifier);
            this.this$0.checkIsBalanceFaderMainAvailable();
        }
    }

    private void handleAmplifierType2(int n) {
        AbstractASLHsmTarget.writeBooleanToDatapool(1507, SoundUtil.isAmpInternal(n));
        AbstractASLHsmTarget.writeBooleanToDatapool(1508, !SoundUtil.isAmpInternal(n));
        this.this$0.checkDynAudioFunctionsAvailable();
        this.this$0.checkAllBrandAndAmpDependingFunctions();
        boolean bl = n == 25;
        AbstractASLHsmTarget.writeBooleanToDatapool(1570642688, bl);
    }

    public void dsiSoundUpdateInputGainOffset(int n, int n2, short s, int n3) {
        short s2 = 0;
        switch (n) {
            case 21: 
            case 217: {
                s2 = (short)ASLSoundData.convertBTGainDSI2ASL(s);
                AbstractASLHsmTarget.writeIntegerToDatapool(1498, s2);
                AbstractASLHsmTarget.writeIntegerToDatapool(1486756608, s2);
                break;
            }
            case 16: 
            case 215: 
            case 216: {
                s2 = (short)ASLSoundData.convertAuxIpodAVGainDSI2ASL(s);
                AbstractASLHsmTarget.writeIntegerToDatapool(1471, s2);
                AbstractASLHsmTarget.writeIntegerToDatapool(1503533824, s2);
                break;
            }
        }
    }

    public void dsiSoundUpdatePresetPositionList(int n, int n2) {
        if (Util.isBitSet(1, n) && Util.isBitSet(2, n) && (ServiceManager.configManagerDiag.isFeatureFlagSet(353) || Util.isBitSet(4, n))) {
            AbstractASLHsmTarget.writeBooleanToDatapool(1512, true);
        } else {
            AbstractASLHsmTarget.writeBooleanToDatapool(1512, false);
        }
        ASLSoundData.presetPositionList = n;
        ASLSoundData.dynaudioPresetPositionAvailable = Util.isBitSet(1, n) && Util.isBitSet(2, n) && Util.isBitSet(4, n) && Util.isBitSet(8, n);
        this.this$0.checkDynAudioFunctionsAvailable();
        this.this$0.checkIsDynaudioFocusPresetAvailable();
        this.this$0.checkIsCantonSoundFocusAvailable();
        this.this$0.checkIsSurroundAvailable();
        this.this$0.checkIsSeatOrSkodaSoundFocusAvailable();
        this.this$0.checkIsBeatsFocusPresetAvailable();
        this.this$0.checkIsBalanceFaderMainAvailable();
    }

    public void dsiSoundUpdatePresetPosition(int n, int n2, int n3, int n4) {
        if (Util.isBitSet(1, n3)) {
            AbstractASLHsmTarget.writeIntegerToDatapool(1484, 0);
            AbstractASLHsmTarget.writeIntegerToDatapool(2789, 0);
            AbstractASLHsmTarget.writeIntegerToDatapool(3422, 2);
            ASLSoundData.arkamysDreiDSound = false;
            ASLSoundData.arkamysVirtualSubwoofer = false;
            AbstractASLHsmTarget.writeBooleanToDatapool(1469979392, ASLSoundData.arkamysDreiDSound);
            AbstractASLHsmTarget.writeBooleanToDatapool(1386093312, ASLSoundData.arkamysVirtualSubwoofer);
            AbstractASLHsmTarget.writeIntegerToDatapool(1436424960, 0);
        } else if (Util.isBitSet(2, n3)) {
            AbstractASLHsmTarget.writeIntegerToDatapool(1484, 1);
            AbstractASLHsmTarget.writeIntegerToDatapool(2789, 1);
            if (SoundUtil.isSkoda()) {
                AbstractASLHsmTarget.writeIntegerToDatapool(2789, 2);
            }
            AbstractASLHsmTarget.writeIntegerToDatapool(3422, 0);
            ASLSoundData.arkamysDreiDSound = false;
            ASLSoundData.arkamysVirtualSubwoofer = false;
            AbstractASLHsmTarget.writeBooleanToDatapool(1469979392, ASLSoundData.arkamysDreiDSound);
            AbstractASLHsmTarget.writeBooleanToDatapool(1386093312, ASLSoundData.arkamysVirtualSubwoofer);
            AbstractASLHsmTarget.writeIntegerToDatapool(1419647744, 2);
            AbstractASLHsmTarget.writeIntegerToDatapool(1436424960, 1);
        } else if (Util.isBitSet(4, n3)) {
            AbstractASLHsmTarget.writeIntegerToDatapool(1484, 2);
            AbstractASLHsmTarget.writeIntegerToDatapool(3422, 1);
            ASLSoundData.arkamysDreiDSound = true;
            ASLSoundData.arkamysVirtualSubwoofer = false;
            AbstractASLHsmTarget.writeBooleanToDatapool(1469979392, ASLSoundData.arkamysDreiDSound);
            AbstractASLHsmTarget.writeBooleanToDatapool(1386093312, ASLSoundData.arkamysVirtualSubwoofer);
            AbstractASLHsmTarget.writeIntegerToDatapool(1436424960, 2);
        } else if (Util.isBitSet(8, n3)) {
            AbstractASLHsmTarget.writeIntegerToDatapool(3422, 3);
            AbstractASLHsmTarget.writeIntegerToDatapool(2789, 1);
            ASLSoundData.arkamysDreiDSound = true;
            ASLSoundData.arkamysVirtualSubwoofer = true;
            AbstractASLHsmTarget.writeBooleanToDatapool(1469979392, ASLSoundData.arkamysDreiDSound);
            AbstractASLHsmTarget.writeBooleanToDatapool(1386093312, ASLSoundData.arkamysVirtualSubwoofer);
        } else if (Util.isBitSet(16, n3)) {
            AbstractASLHsmTarget.writeIntegerToDatapool(1419647744, 0);
        } else if (Util.isBitSet(32, n3)) {
            AbstractASLHsmTarget.writeIntegerToDatapool(1419647744, 1);
        }
    }

    public void dsiSoundUpdatePresetEQList(int n, int n2) {
        int n3 = 0;
        if (Util.isBitSet(1, n)) {
            ++n3;
        }
        if (Util.isBitSet(2, n)) {
            ++n3;
        }
        Object[] objectArray = new Integer[n3];
        if (n3 > 0) {
            int n4 = 0;
            if (Util.isBitSet(1, n)) {
                objectArray[n4++] = RuntimeUtil.valueOf(0);
            }
            if (Util.isBitSet(2, n)) {
                objectArray[n4++] = RuntimeUtil.valueOf(1);
            }
        }
        ListManager.getGenericASLList(1477).updateList(objectArray);
        ASLSoundData.presetEQList = n;
        ASLSoundData.dynaudioPresetEQAvailable = Util.isBitSet(1, n) && Util.isBitSet(2, n) && Util.isBitSet(4, n) && Util.isBitSet(8, n);
        this.this$0.checkDynAudioFunctionsAvailable();
        this.this$0.checkIsDynaudioCharacterPresetAvailable();
        this.this$0.checkIsCantonSoundPresetAvailable();
        this.this$0.checkIsSoundCharactersAvailable();
        this.this$0.checkIsTMBManEQMainAvailable();
    }

    public void dsiSoundUpdatePresetEQ(int n, int n2, int n3, int n4) {
        if (Util.isBitSet(1, n3)) {
            AbstractASLHsmTarget.writeIntegerToDatapool(3423, 0);
            AbstractASLHsmTarget.writeIntegerToDatapool(2672, 0);
            AbstractASLHsmTarget.writeIntegerToDatapool(1453202176, 0);
            AbstractASLHsmTarget.writeIntegerToDatapool(1553865472, 0);
        } else if (Util.isBitSet(2, n3)) {
            AbstractASLHsmTarget.writeIntegerToDatapool(2672, 1);
            AbstractASLHsmTarget.writeIntegerToDatapool(3423, 2);
            AbstractASLHsmTarget.writeIntegerToDatapool(1453202176, 2);
            AbstractASLHsmTarget.writeIntegerToDatapool(1553865472, 3);
        } else if (Util.isBitSet(4, n3)) {
            AbstractASLHsmTarget.writeIntegerToDatapool(3423, 1);
            AbstractASLHsmTarget.writeIntegerToDatapool(1453202176, 4);
            AbstractASLHsmTarget.writeIntegerToDatapool(1553865472, 1);
        } else if (Util.isBitSet(8, n3)) {
            AbstractASLHsmTarget.writeIntegerToDatapool(3423, 3);
            AbstractASLHsmTarget.writeIntegerToDatapool(1453202176, 1);
            AbstractASLHsmTarget.writeIntegerToDatapool(1553865472, 2);
        } else if (Util.isBitSet(128, n3)) {
            AbstractASLHsmTarget.writeIntegerToDatapool(1453202176, 3);
        }
        ASLSoundData.presetEQ = n3;
    }

    public void dsiSoundUpdateSurroundLevel(int n, int n2, short s, int n3) {
        ASLSoundData.dynAudSurrDSI_current = s;
        AbstractASLHsmTarget.writeIntegerToDatapool(1490, s);
        int n4 = ASLSoundData.convertDynAudSurrLev_DSI2ASL(s);
        AbstractASLHsmTarget.writeIntegerToDatapool(1369316096, n4);
        AbstractASLHsmTarget.writeBooleanToDatapool(2057181952, SoundUtil.isDynaudioPrologicActivated());
        this.checkDynAudProLogicIconVisibleState();
    }

    public void dsiSoundUpdateSurroundOnOff(int n, int n2, boolean bl, int n3) {
        ASLSoundData.surroundOnOff = bl;
        AbstractASLHsmTarget.writeBooleanToDatapool(1654528768, bl);
        AbstractASLHsmTarget.writeBooleanToDatapool(2929, bl);
        this.checkDynAudProLogicIconVisibleState();
    }

    public void dsiSoundUpdateSurrLevelRange(int n, int n2, int n3) {
        SoundToneSettingsCantonSurroundLimitCollector soundToneSettingsCantonSurroundLimitCollector = (SoundToneSettingsCantonSurroundLimitCollector)ListManager.getGenericASLList(1515).getRowItem(0);
        soundToneSettingsCantonSurroundLimitCollector.sound_tone_settings_canton_surround_min = n;
        soundToneSettingsCantonSurroundLimitCollector.sound_tone_settings_canton_surround_max = n2;
        ListManager.getGenericASLList(1515).updateList(ListManager.getGenericASLList(1515).getDSIObjects());
        ASLSoundData.setDynAudSurrLevDSI(n, n2);
        this.this$0.checkIsDynaudioSurroundLevelAvailable();
        this.this$0.checkIsCantonSurroundAvailable();
    }

    public void dsiSoundUpdateLoweringEntertainment(int n, int n2, int n3, short s, int n4) {
        if (n3 == 1) {
            AbstractASLHsmTarget.writeIntegerToDatapool(1494, s);
        }
        if (n3 == 0) {
            AbstractASLHsmTarget.writeIntegerToDatapool(1973295872, s);
        }
    }

    public void dsiSoundUpdateNoiseCompensation(int n, int n2, short s, int n3) {
        AbstractASLHsmTarget.writeIntegerToDatapool(1488, s);
    }

    public void dsiSoundUpdateEqualizer(int[] nArray, int[] nArray2, int n) {
        this.updateEqualizerBandsAndValues(nArray, nArray2, n);
    }

    public void dsiSoundUpdateEqualizerRange(int n, int n2, int[] nArray, int n3) {
        this.updateEqualizerBandsAndValues(nArray, null, n3);
        ASLSoundData.equalizerFrequencies = nArray;
        if (SoundUtil.isTMBAvailable(ASLSoundData.equalizerFrequencies)) {
            AbstractASLHsmTarget.writeFlagVectorToDatapool(1513, new boolean[]{true, false});
        } else {
            AbstractASLHsmTarget.writeFlagVectorToDatapool(1513, new boolean[]{false, true});
        }
        this.this$0.checkIsTMBManEQMainAvailable();
    }

    private void updateEqualizerBandsAndValues(int[] nArray, int[] nArray2, int n) {
        Object[] objectArray;
        Object object;
        if (this.target.isTraceEnabled()) {
            object = this.target.trace();
            object.append("[SoundDPHandling] received updateEqualizerBandsAndValues: frequencies:");
            Utils.appendArgs((LogMessage)object, new Object[]{nArray});
            object.append(", values: ");
            Utils.appendArgs((LogMessage)object, new Object[]{nArray2});
            object.append(", validFlag: ").append(n);
            object.log();
        }
        object = ListManager.getGenericASLList(1536);
        try {
            objectArray = ((GenericASLList)object).getDSIObjects();
        }
        catch (Exception exception) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("[SoundDPHandling] received updateEqualizerBandsAndValues: ASLList empty ").append(exception.getMessage()).log();
            }
            objectArray = new Object[]{};
        }
        if (Util.isNullOrEmpty(nArray)) {
            ((AbstractASLList)object).updateList(null);
        } else {
            if (null != nArray2) {
                ASLSoundData.equalizerValues = nArray2;
            }
            if (Util.isNullOrEmpty(objectArray) || objectArray.length != nArray.length || !(objectArray instanceof SoundEqualizerBandCollector[])) {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("Initial fill or recreate: EQUALIZER_BANDS, recreate=").append(objectArray.length != nArray.length);
                }
                Object[] objectArray2 = new SoundEqualizerBandCollector[nArray.length];
                for (int i2 = 0; i2 < nArray.length; ++i2) {
                    objectArray2[i2] = new SoundEqualizerBandCollector(nArray[i2], null == nArray2 ? 0 : nArray2[i2]);
                }
                ((AbstractASLList)object).updateList(objectArray2);
            } else {
                int n2;
                Object[] objectArray3 = (SoundEqualizerBandCollector[])objectArray;
                if (null != nArray2) {
                    if (this.target.isTraceEnabled()) {
                        this.target.trace("Update band values");
                    }
                    for (n2 = 0; n2 < objectArray3.length; ++n2) {
                        ((SoundEqualizerBandCollector)objectArray3[n2]).sound_equalizer_band_value = nArray2[n2];
                    }
                }
                if (nArray.length >= 5 && nArray[0] != 0 && nArray[2] != 0 && nArray[4] != 0) {
                    if (this.target.isTraceEnabled()) {
                        this.target.trace("Update band frequencies");
                    }
                    for (n2 = 0; n2 < objectArray3.length; ++n2) {
                        ((SoundEqualizerBandCollector)objectArray3[n2]).sound_equalizer_band_frequency = nArray[n2];
                    }
                }
                ((AbstractASLList)object).updateList(objectArray3);
            }
        }
    }

    public void dsiSoundUpdateVolumeRange(int n, int n2, int n3) {
        SoundVolumeEntertainmentLimitsCollector soundVolumeEntertainmentLimitsCollector = (SoundVolumeEntertainmentLimitsCollector)ListManager.getGenericASLList(1522).getRowItem(0);
        soundVolumeEntertainmentLimitsCollector.sound_volume_entertainment_max = n2;
        soundVolumeEntertainmentLimitsCollector.sound_volume_entertainment_min = n;
        ListManager.getGenericASLList(1522).updateList(ListManager.getGenericASLList(1522).getDSIObjects());
        ASLSoundData.volumeEntertainmentPopupMax = n2;
        ASLSoundData.volumeEntertainmentPopupMin = n;
        SoundHASUpdater.setVolumeRanges(1493, n, n2);
    }

    public void dsiSoundUpdateVolume(int n, int n2, short s, int n3) {
        if (n == this.this$0.activeEntConnection || n == 4) {
            AbstractASLHsmTarget.writeIntegerToDatapool(1493, s);
            SoundHASUpdater.setVolumeContainerVolume(1493, s);
        } else {
            switch (n) {
                case 99: 
                case 104: 
                case 151: 
                case 157: 
                case 210: 
                case 212: 
                case 218: 
                case 225: 
                case 226: 
                case 227: 
                case 228: 
                case 241: {
                    AbstractASLHsmTarget.writeIntegerToDatapool(1500, s);
                    SoundHASUpdater.setVolumeContainerVolume(1500, s);
                    break;
                }
                case 95: 
                case 98: 
                case 103: 
                case 165: {
                    AbstractASLHsmTarget.writeIntegerToDatapool(1500, s);
                    AbstractASLHsmTarget.writeIntegerToDatapool(1501, s);
                    SoundHASUpdater.setVolumeContainerVolume(1500, s);
                    break;
                }
                case 87: {
                    AbstractASLHsmTarget.writeIntegerToDatapool(1500, s);
                    AbstractASLHsmTarget.writeIntegerToDatapool(1501, s);
                    int n4 = ASLSoundData.phoneRangeContainer.getASLItemValue(s);
                    AbstractASLHsmTarget.writeIntegerToDatapool(1520311040, n4);
                    SoundHASUpdater.setVolumeContainerVolume(1500, s);
                    break;
                }
                case 124: {
                    AbstractASLHsmTarget.writeIntegerToDatapool(1495, s);
                    break;
                }
                case 83: 
                case 116: 
                case 117: 
                case 220: 
                case 221: 
                case 242: {
                    AbstractASLHsmTarget.writeIntegerToDatapool(1496, s);
                    SoundHASUpdater.setVolumeContainerVolume(1496, s);
                    break;
                }
                case 235: {
                    if (this.isAudioFeedbackActive) break;
                    AbstractASLHsmTarget.writeIntegerToDatapool(1496, s);
                    SoundHASUpdater.setVolumeContainerVolume(1496, s);
                    break;
                }
                case 86: 
                case 112: 
                case 114: 
                case 115: 
                case 118: 
                case 119: 
                case 126: 
                case 127: 
                case 152: 
                case 155: 
                case 158: 
                case 161: 
                case 168: 
                case 171: 
                case 219: 
                case 243: 
                case 244: {
                    AbstractASLHsmTarget.writeIntegerToDatapool(1502, s);
                    SoundHASUpdater.setVolumeContainerVolume(1502, s);
                    break;
                }
                case 15: 
                case 31: 
                case 32: 
                case 33: 
                case 34: 
                case 35: 
                case 84: 
                case 85: {
                    AbstractASLHsmTarget.writeIntegerToDatapool(1503, s);
                    SoundHASUpdater.setVolumeContainerVolume(1503, s);
                    break;
                }
                case 262: {
                    AbstractASLHsmTarget.writeIntegerToDatapool(1990073088, s - ASLSoundData.iccMin);
                    break;
                }
            }
        }
    }

    public void dsiSoundUpdateOnVolumeLimit(int n, int n2) {
        AbstractASLHsmTarget.writeIntegerToDatapool(1499, n);
    }

    public void dsiSoundUpdateSubwoofer(int n, int n2, short s, int n3) {
        AbstractASLHsmTarget.writeIntegerToDatapool(1491, s);
    }

    public void dsiSoundUpdateBalance(int n, int n2, short s, int n3) {
        AbstractASLHsmTarget.writeIntegerToDatapool(1485, s);
        this.checkInitialDynaudioFocusMode(n, s, ASLSoundData.entFader);
        this.balanceFader_balanceValue = s;
        this.handleUpdateBalanceFader();
    }

    public void dsiSoundUpdateFader(int n, int n2, short s, int n3) {
        AbstractASLHsmTarget.writeIntegerToDatapool(1487, s);
        this.checkInitialDynaudioFocusMode(n, ASLSoundData.entBalance, s);
        this.balanceFader_faderValue = s;
        this.handleUpdateBalanceFader();
    }

    public void dsiSoundUpdateBass(int n, int n2, short s, int n3) {
        AbstractASLHsmTarget.writeIntegerToDatapool(1486, s);
        this.checkInitialDynaudioCharacterMode(n, ASLSoundData.entTreble, ASLSoundData.entMiddle, s);
    }

    public void dsiSoundUpdateMiddle(int n, int n2, short s, int n3) {
        AbstractASLHsmTarget.writeIntegerToDatapool(1489, s);
        this.checkInitialDynaudioCharacterMode(n, ASLSoundData.entTreble, s, ASLSoundData.entBass);
    }

    public void dsiSoundUpdateTreble(int n, int n2, short s, int n3) {
        AbstractASLHsmTarget.writeIntegerToDatapool(1492, s);
        this.checkInitialDynaudioCharacterMode(n, s, ASLSoundData.entMiddle, ASLSoundData.entBass);
    }

    public void dsiSoundUpdateBalanceRange(int n, int n2, int n3) {
        SoundToneSettingsBalanceLimitCollector soundToneSettingsBalanceLimitCollector = (SoundToneSettingsBalanceLimitCollector)ListManager.getGenericASLList(1514).getRowItem(0);
        soundToneSettingsBalanceLimitCollector.sound_tone_settings_balance_min = n;
        soundToneSettingsBalanceLimitCollector.sound_tone_settings_balance_max = n2;
        ListManager.getGenericASLList(1514).updateList(ListManager.getGenericASLList(1514).getDSIObjects());
        SoundHASUpdater.setBalanceFaderRangesContainerBalance(n, n2);
    }

    public void dsiSoundUpdateBassRange(int n, int n2, int n3) {
        SoundToneSettingsBassLimitCollector soundToneSettingsBassLimitCollector = (SoundToneSettingsBassLimitCollector)ListManager.getGenericASLList(1516).getRowItem(0);
        soundToneSettingsBassLimitCollector.sound_tone_settings_bass_min = n;
        soundToneSettingsBassLimitCollector.sound_tone_settings_bass_max = n2;
        ListManager.getGenericASLList(1516).updateList(ListManager.getGenericASLList(1516).getDSIObjects());
    }

    public void dsiSoundUpdateMiddleRange(int n, int n2, int n3) {
        SoundToneSettingsMiddleLimitCollector soundToneSettingsMiddleLimitCollector = (SoundToneSettingsMiddleLimitCollector)ListManager.getGenericASLList(1519).getRowItem(0);
        soundToneSettingsMiddleLimitCollector.sound_tone_settings_middle_min = n;
        soundToneSettingsMiddleLimitCollector.sound_tone_settings_middle_max = n2;
        ListManager.getGenericASLList(1519).updateList(ListManager.getGenericASLList(1519).getDSIObjects());
    }

    public void dsiSoundUpdateFaderRange(int n, int n2, int n3) {
        SoundToneSettingsFaderLimitCollector soundToneSettingsFaderLimitCollector = (SoundToneSettingsFaderLimitCollector)ListManager.getGenericASLList(1517).getRowItem(0);
        soundToneSettingsFaderLimitCollector.sound_tone_settings_fader_min = n;
        soundToneSettingsFaderLimitCollector.sound_tone_settings_fader_max = n2;
        ListManager.getGenericASLList(1517).updateList(ListManager.getGenericASLList(1517).getDSIObjects());
        SoundHASUpdater.setBalanceFaderRangesContainerFader(n, n2);
    }

    public void dsiSoundUpdateTrebleRange(int n, int n2, int n3) {
        SoundToneSettingsTrebleLimitCollector soundToneSettingsTrebleLimitCollector = (SoundToneSettingsTrebleLimitCollector)ListManager.getGenericASLList(1521).getRowItem(0);
        soundToneSettingsTrebleLimitCollector.sound_tone_settings_treble_min = n;
        soundToneSettingsTrebleLimitCollector.sound_tone_settings_treble_max = n2;
        ListManager.getGenericASLList(1521).updateList(ListManager.getGenericASLList(1521).getDSIObjects());
    }

    public void dsiSoundUpdateSubwooferRange(int n, int n2, int n3) {
        SoundToneSettingsSubwooferLimitCollector soundToneSettingsSubwooferLimitCollector = (SoundToneSettingsSubwooferLimitCollector)ListManager.getGenericASLList(1520).getRowItem(0);
        soundToneSettingsSubwooferLimitCollector.sound_tone_settings_subwoofer_min = n;
        soundToneSettingsSubwooferLimitCollector.sound_tone_settings_subwoofer_max = n2;
        ListManager.getGenericASLList(1520).updateList(ListManager.getGenericASLList(1520).getDSIObjects());
    }

    public void dsiSoundUpdateNoiseCompensationRange(int n, int n2, int n3) {
        SoundToneSettingsGALALimitCollector soundToneSettingsGALALimitCollector = (SoundToneSettingsGALALimitCollector)ListManager.getGenericASLList(1518).getRowItem(0);
        soundToneSettingsGALALimitCollector.sound_tone_settings_gala_min = n;
        soundToneSettingsGALALimitCollector.sound_tone_settings_gala_max = n2;
        ListManager.getGenericASLList(1518).updateList(ListManager.getGenericASLList(1518).getDSIObjects());
    }

    public void dsiSoundUpdateOnVolumeLimitRange(int n, int n2, int n3) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("[SoundDPHandling] recieved updateOnVolumeLimitRange: minRange:").append(n).append(", maxRange: ").append(n2).log();
        }
        SoundVolumeOnVolumeSetupiLimitCollector soundVolumeOnVolumeSetupiLimitCollector = (SoundVolumeOnVolumeSetupiLimitCollector)ListManager.getGenericASLList(1526).getRowItem(0);
        soundVolumeOnVolumeSetupiLimitCollector.sound_volume_on_volume_setup_min = n;
        soundVolumeOnVolumeSetupiLimitCollector.sound_volume_on_volume_setup_max = n2;
        ListManager.getGenericASLList(1526).updateList(ListManager.getGenericASLList(1526).getDSIObjects());
    }

    public void dsiSoundUpdateVolumeFocus(int n, int n2, int n3) {
    }

    public void dsiSoundUpdateSubwooferActivity(int n, int n2, boolean bl, int n3) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("[SoundDPHandling] recieved updateSubwooferActivity: con:").append(n).append(", activity: ").append(bl).log();
        }
        AbstractASLHsmTarget.writeBooleanToDatapool(1587419904, bl);
        AbstractASLHsmTarget.writeBooleanToDatapool(1604197120, bl);
    }

    public void dsiSoundUpdateICCAvailable(boolean bl, int n, int n2) {
        this.this$0.info().append("Sound update ICC available: ").append(bl).log();
        AbstractASLHsmTarget.writeBooleanToDatapool(2023627520, bl);
        ASLSoundData.iCCAvailable = bl;
    }

    private void initFromPersistence() {
        this.this$0.info().append("Sound set EQ mode from persistence: ").append(ASLSoundData.persistence.getEqMode() == 0 ? "custom" : "preset").log();
        AbstractASLHsmTarget.writeIntegerToDatapool(3420, ASLSoundData.persistence.getEqMode());
    }

    private void handleUpdateBalanceFader() {
        SoundBalanceFaderCollector soundBalanceFaderCollector = (SoundBalanceFaderCollector)ListManager.getGenericASLList(3529).getRowItem(0);
        soundBalanceFaderCollector.sound_balance_fader__balance = this.balanceFader_balanceValue;
        soundBalanceFaderCollector.sound_balance_fader__fader = this.balanceFader_faderValue;
        ListManager.getGenericASLList(3529).updateList(ListManager.getGenericASLList(3529).getDSIObjects());
        SoundHASUpdater.setBalanceFaderContainer(this.balanceFader_balanceValue, this.balanceFader_faderValue);
    }

    private void checkInitialDynaudioCharacterMode(int n, short s, short s2, short s3) {
        if (SoundUtil.isEntSource(n)) {
            ASLSoundData.entTreble = s;
            ASLSoundData.entMiddle = s2;
            ASLSoundData.entBass = s3;
        }
    }

    private void checkInitialDynaudioFocusMode(int n, short s, short s2) {
        if (SoundUtil.isVW() && ASLSoundData.initialDynaudioFocusMode == -1 && SoundUtil.isEntSource(n)) {
            ASLSoundData.entBalance = s;
            ASLSoundData.entFader = s2;
            if (ASLSoundData.entBalance != -999 && ASLSoundData.entFader != -999) {
                if (ASLSoundData.entBalance == 0 && ASLSoundData.entFader == 0) {
                    ASLSoundData.initialDynaudioFocusMode = 1;
                    this.this$0.trace("[SoundDPHandling] set initialDynaudioFocusMode PRESET");
                } else {
                    ASLSoundData.initialDynaudioFocusMode = 0;
                    this.this$0.trace("[SoundDPHandling] set initialDynaudioFocusMode CUSTOM");
                }
                AbstractASLHsmTarget.writeIntegerToDatapool(3421, ASLSoundData.initialDynaudioFocusMode);
            }
        }
    }

    private void checkDynAudProLogicIconVisibleState() {
        if (ASLSoundData.dynAudProLogicIconVisible && (!SoundUtil.isDynaudioPrologicActivated() || !ASLSoundData.surroundOnOff) || !ASLSoundData.dynAudProLogicIconVisible && SoundUtil.isDynaudioPrologicActivated() && ASLSoundData.surroundOnOff) {
            ASLSoundData.dynAudProLogicIconVisible = !ASLSoundData.dynAudProLogicIconVisible;
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(805911808);
            eventGeneric.setBoolean(0, ASLSoundData.dynAudProLogicIconVisible);
            this.this$0.send(eventGeneric);
            if (this.this$0.isTraceEnabled()) {
                this.this$0.trace().append("[SoundDPHandling] Dynaudio ProLogic icon state changed. Is visible: ").append(ASLSoundData.dynAudProLogicIconVisible).log();
            }
        }
    }

    private void getSoundSettings() {
        this.target.dsiSound.getBalance(this.this$0.activeEntConnection, 1);
        this.target.dsiSound.getFader(this.this$0.activeEntConnection, 1);
        this.target.dsiSound.getTreble(this.this$0.activeEntConnection, 1);
        this.target.dsiSound.getMiddle(this.this$0.activeEntConnection, 1);
        this.target.dsiSound.getBass(this.this$0.activeEntConnection, 1);
        this.target.dsiSound.getEqualizer(this.this$0.activeEntConnection, 1);
        this.target.dsiSound.getPresetPosition(this.this$0.activeEntConnection, 1);
        this.target.dsiSound.getPresetEQ(this.this$0.activeEntConnection, 1);
        this.target.dsiSound.getSubwoofer(this.this$0.activeEntConnection, 1);
        this.target.dsiSound.getSurroundLevel(this.this$0.activeEntConnection, 1);
        this.target.dsiSound.getNoiseCompensation(this.this$0.activeEntConnection, 1);
    }
}

