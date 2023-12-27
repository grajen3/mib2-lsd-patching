/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.ASLNavigationServices;
import de.vw.mib.asl.api.navigation.ASLNavigationServicesListener;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.sound.ASLSoundData;
import de.vw.mib.asl.internal.sound.AbstractASLHsmSoundTarget;
import de.vw.mib.asl.internal.sound.HsmSoundDPHandling$1;
import de.vw.mib.asl.internal.sound.HsmSoundDPHandling$StateSoundDPHandlingHandling;
import de.vw.mib.asl.internal.sound.HsmSoundDPHandling$StateSoundDPHandlingInit;
import de.vw.mib.asl.internal.sound.SoundCapabilitiesUpdater;
import de.vw.mib.asl.internal.sound.SoundUtil;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.audio.DSIAudioManagement;
import org.dsi.ifc.audio.DSIAudioManagementListener;
import org.dsi.ifc.audio.DSISound;
import org.dsi.ifc.audio.DSISoundListener;

public class HsmSoundDPHandling
extends AbstractASLHsmSoundTarget {
    protected DSIAudioManagement dsiAudioManagement;
    protected DSISound dsiSound;
    protected DSIAudioManagementListener dsiAudioManagementListener;
    protected DSISoundListener dsiSoundListener;
    final HsmState stateInit;
    final HsmState stateHandling;
    protected ASLNavigationServicesListener aslNavigationServiceListener;
    protected ASLNavigationServices aslNavigationServices;
    SoundCapabilitiesUpdater soundCapabilities;
    protected final int EV_SOUND_ANSWER_DIAGNOSIS_DATA;
    boolean isInternalAmp;
    boolean isDynAudioAmp;
    protected final int CONNECTION_UNSET;
    int activeEntConnection;
    int activeConnection;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSIAudioManagement;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISound;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSIAudioManagementListener;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISoundListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$sound$capabilities$SoundCapabilitiesService;

    protected void initDSI() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiAudioManagement = (DSIAudioManagement)dSIProxy.getService(this, class$org$dsi$ifc$audio$DSIAudioManagement == null ? (class$org$dsi$ifc$audio$DSIAudioManagement = HsmSoundDPHandling.class$("org.dsi.ifc.audio.DSIAudioManagement")) : class$org$dsi$ifc$audio$DSIAudioManagement);
        this.dsiSound = (DSISound)dSIProxy.getService(this, class$org$dsi$ifc$audio$DSISound == null ? (class$org$dsi$ifc$audio$DSISound = HsmSoundDPHandling.class$("org.dsi.ifc.audio.DSISound")) : class$org$dsi$ifc$audio$DSISound);
        this.dsiAudioManagementListener = (DSIAudioManagementListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$audio$DSIAudioManagementListener == null ? (class$org$dsi$ifc$audio$DSIAudioManagementListener = HsmSoundDPHandling.class$("org.dsi.ifc.audio.DSIAudioManagementListener")) : class$org$dsi$ifc$audio$DSIAudioManagementListener);
        this.dsiSoundListener = (DSISoundListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$audio$DSISoundListener == null ? (class$org$dsi$ifc$audio$DSISoundListener = HsmSoundDPHandling.class$("org.dsi.ifc.audio.DSISoundListener")) : class$org$dsi$ifc$audio$DSISoundListener);
        this.soundCapabilities = new SoundCapabilitiesUpdater();
        ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().registerAPI(class$de$vw$mib$asl$api$sound$capabilities$SoundCapabilitiesService == null ? (class$de$vw$mib$asl$api$sound$capabilities$SoundCapabilitiesService = HsmSoundDPHandling.class$("de.vw.mib.asl.api.sound.capabilities.SoundCapabilitiesService")) : class$de$vw$mib$asl$api$sound$capabilities$SoundCapabilitiesService, this.soundCapabilities);
    }

    public HsmSoundDPHandling(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.stateInit = new HsmSoundDPHandling$StateSoundDPHandlingInit(this, this.hsm, "SoundDPHandlingInit", this.getWorkStateParent());
        this.stateHandling = new HsmSoundDPHandling$StateSoundDPHandlingHandling(this, this.hsm, "SoundDPHandlingHandling", this.stateInit);
        this.aslNavigationServiceListener = new HsmSoundDPHandling$1(this);
        this.aslNavigationServices = ASLNavigationFactory.getNavigationApi().getASLNavigationServices(this.aslNavigationServiceListener);
        this.EV_SOUND_ANSWER_DIAGNOSIS_DATA = -1585053440;
        this.isInternalAmp = true;
        this.isDynAudioAmp = false;
        this.CONNECTION_UNSET = -1;
        this.activeEntConnection = -1;
        this.activeConnection = -1;
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    @Override
    public int getDefaultTargetId() {
        return -1321921280;
    }

    boolean checkDynAudio() {
        return !this.isInternalAmp && ServiceManager.configManagerDiag.isFeatureFlagSet(432) && !ServiceManager.configManagerDiag.isFeatureFlagSet(105);
    }

    void checkDynAudioFunctionsAvailable() {
        int n = SoundUtil.getRequiredPresetEQForExtendedAudio();
        int n2 = SoundUtil.getRequiredPresetPositionsForExtendedAudio();
        boolean bl = SoundUtil.isExtendedAudioAvailable(ASLSoundData.amplifierCapabilities, ASLSoundData.presetPositionList, ASLSoundData.presetEQList);
        this.info().append("Sound check extended audio functions. isVW:").append(SoundUtil.isVW()).append(", isSkoda:").append(SoundUtil.isSkoda()).append(", isSeat:").append(SoundUtil.isSeat()).append(", requiredPresetPosition: 0x").append(Integer.toHexString(n2)).append(", availablePresetPositionList: 0x").append(Integer.toHexString(ASLSoundData.presetPositionList)).append(", requiredPresetEQ: 0x").append(Integer.toHexString(n)).append(", availablePresetEQ: 0x").append(Integer.toHexString(ASLSoundData.presetEQList)).append(". => extended audio available: ").append(bl).log();
        HsmSoundDPHandling.writeBooleanToDatapool(3629, bl);
    }

    void checkIsTMBManEQMainAvailable() {
        boolean bl = SoundUtil.isTMBMainAvailable(ASLSoundData.equalizerFrequencies);
        HsmSoundDPHandling.writeBooleanToDatapool(1855855360, bl);
        boolean bl2 = SoundUtil.isManEQMainAvailable();
        HsmSoundDPHandling.writeBooleanToDatapool(1872632576, bl2);
    }

    void checkIsBalanceFaderMainAvailable() {
        boolean bl = SoundUtil.isBalanceFaderMainAvailable();
        HsmSoundDPHandling.writeBooleanToDatapool(1889409792, bl);
        boolean bl2 = SoundUtil.isBalanceMainAvailable();
        HsmSoundDPHandling.writeBooleanToDatapool(1906187008, bl2);
    }

    void checkIsDynaudioCharacterPresetAvailable() {
        boolean bl = SoundUtil.isDynaudioCharacterPresetAvailable();
        HsmSoundDPHandling.writeBooleanToDatapool(1620974336, bl);
        this.soundCapabilities.onDynaudioCharacterPresetsAvailableChanged(bl);
    }

    void checkIsDynaudioFocusPresetAvailable() {
        boolean bl = SoundUtil.isDynaudioFocusPresetAvailable();
        HsmSoundDPHandling.writeBooleanToDatapool(1671305984, bl);
    }

    void checkIsDynaudioSurroundLevelAvailable() {
        boolean bl = false;
        bl = SoundUtil.isVW() && SoundUtil.isAmpDynaudio(ASLSoundData.amplifierCapabilities) && SoundUtil.hasValidSurroundRange();
        HsmSoundDPHandling.writeBooleanToDatapool(1637751552, bl);
    }

    void checkIsCantonSoundPresetAvailable() {
        boolean bl = SoundUtil.isCantonSoundPresetAvailable();
        HsmSoundDPHandling.writeBooleanToDatapool(1721637632, bl);
    }

    void checkIsCantonSoundFocusAvailable() {
        boolean bl = SoundUtil.isCantonSoundFocusAvailable();
        HsmSoundDPHandling.writeBooleanToDatapool(1688083200, bl);
    }

    void checkIsCantonSurroundAvailable() {
        boolean bl = SoundUtil.isCantonSurroundAvailable();
        HsmSoundDPHandling.writeBooleanToDatapool(1704860416, bl);
    }

    void checkIsSoundCharactersAvailable() {
        boolean bl = SoundUtil.isSoundCharactersAvailable();
        HsmSoundDPHandling.writeBooleanToDatapool(1788746496, bl);
    }

    void checkIsSurroundAvailable() {
        boolean bl = SoundUtil.isSurroundAvailable();
        HsmSoundDPHandling.writeBooleanToDatapool(1805523712, bl);
    }

    void checkIsSeatOrSkodaSoundFocusAvailable() {
        boolean bl = SoundUtil.isSkodaStandardSoundFocusDriverAvailable(ASLSoundData.presetPositionList);
        HsmSoundDPHandling.writeBooleanToDatapool(2124290816, bl || SoundUtil.isSeat());
        boolean bl2 = SoundUtil.isSkodaStandardSoundFocusFrontAvailable(ASLSoundData.presetPositionList);
        HsmSoundDPHandling.writeBooleanToDatapool(2141068032, bl2);
        boolean bl3 = SoundUtil.isSeatSoundFocusAvailable(ASLSoundData.amplifierCapabilities, ASLSoundData.presetPositionList) || SoundUtil.isSkodaStandardSoundFocusAvailable();
        HsmSoundDPHandling.writeBooleanToDatapool(2107513600, bl3);
    }

    void checkIsBeatsFocusPresetAvailable() {
        boolean bl = SoundUtil.isBeatsFocusPresetAvailable(ASLSoundData.amplifierCapabilities, ASLSoundData.presetPositionList);
        HsmSoundDPHandling.writeBooleanToDatapool(-2103567616, bl);
    }

    void checkAllBrandAndAmpDependingFunctions() {
        this.checkIsDynaudioCharacterPresetAvailable();
        this.checkIsDynaudioFocusPresetAvailable();
        this.checkIsDynaudioSurroundLevelAvailable();
        this.checkIsCantonSoundPresetAvailable();
        this.checkIsCantonSoundFocusAvailable();
        this.checkIsCantonSurroundAvailable();
        this.checkIsSoundCharactersAvailable();
        this.checkIsSurroundAvailable();
        this.checkIsSeatOrSkodaSoundFocusAvailable();
        this.checkIsBeatsFocusPresetAvailable();
        this.checkIsTMBManEQMainAvailable();
        this.checkIsBalanceFaderMainAvailable();
        ServiceManager.logger.info(16).append("Sound Info: ").append(ASLSoundData.getDescription2()).log();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

