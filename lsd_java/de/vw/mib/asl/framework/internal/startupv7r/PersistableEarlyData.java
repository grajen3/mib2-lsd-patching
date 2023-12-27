/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r;

import de.vw.mib.asl.framework.api.persistence.AbstractSharedPersistable;
import de.vw.mib.asl.framework.api.persistence.IPersistableEarlyData;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public class PersistableEarlyData
extends AbstractSharedPersistable
implements IPersistableEarlyData {
    private static final short VERSION;
    private static final short[] SUPPORTED_VERSIONS;
    int LAST_AUDIO_MODE_INVALID = -1;
    int LAST_AUDIO_MODE_RADIO = 0;
    int LAST_AUDIO_MODE_MEDIA = 1;
    int LAST_AUDIO_MODE_TVTUNER = 2;
    int LAST_AUDIO_MODE_MIRRORLINK = 3;
    private static PersistableEarlyData myInstance;
    private int displayBrightness;
    private boolean showClock;
    private int dayNightMode;
    private int lastContext;
    private boolean lastConnRadio;
    private int lastActiveSkin;
    private int lastActiveLanguagePrefetch;
    private short lastSouthSideUserContext;
    private short lastSouthSideAudioContext;
    private boolean acousticTouchscreenFeedback;
    private int userMuteStarted;
    private long lastClamp15OffTimestamp;
    private int languageWasUsedOnceBeforeBitfield;
    private int spellerLayout;
    private boolean proximityAnimationsActive;
    private int debugProbeConfiguration;
    private boolean autoDaylightSaving;
    private boolean sdsActive;
    private boolean testmodeAlternativeViewSetup1;
    private boolean testmodeAlternativeViewSetup2;
    private byte effectiveSkinMode;
    private byte lastPersistedCodedSkin;
    private boolean navOverwriteEnableOnlineFunctions;
    private boolean pqLscAutomaticModeActive;
    private boolean uotaCustomerSwdlIsRunning;
    private boolean hwrEnabled;
    private boolean sportHMIEnabled;
    private int lastActiveAudioContext;

    @Override
    public short[] getSupportedVersions() {
        return SUPPORTED_VERSIONS;
    }

    @Override
    public short getVersion() {
        return 19;
    }

    @Override
    public void fromStreamInternal(PersistenceInputStream persistenceInputStream, short s) {
        boolean bl = false;
        this.displayBrightness = persistenceInputStream.readByte();
        this.showClock = persistenceInputStream.readBoolean();
        this.dayNightMode = persistenceInputStream.readByte();
        this.lastContext = persistenceInputStream.readByte();
        this.lastConnRadio = persistenceInputStream.readBoolean();
        this.lastActiveSkin = persistenceInputStream.readByte();
        this.lastActiveLanguagePrefetch = persistenceInputStream.readByte();
        this.acousticTouchscreenFeedback = persistenceInputStream.readBoolean();
        this.userMuteStarted = persistenceInputStream.readInt();
        this.lastClamp15OffTimestamp = persistenceInputStream.readLong();
        this.languageWasUsedOnceBeforeBitfield = persistenceInputStream.readInt();
        this.spellerLayout = persistenceInputStream.readByte();
        this.proximityAnimationsActive = persistenceInputStream.readBoolean();
        this.debugProbeConfiguration = persistenceInputStream.readInt();
        this.autoDaylightSaving = persistenceInputStream.readBoolean();
        this.sdsActive = persistenceInputStream.readBoolean();
        this.testmodeAlternativeViewSetup1 = persistenceInputStream.readBoolean();
        this.testmodeAlternativeViewSetup2 = persistenceInputStream.readBoolean();
        if (s == SUPPORTED_VERSIONS[0]) {
            bl = true;
        } else {
            this.effectiveSkinMode = persistenceInputStream.readByte();
            this.lastPersistedCodedSkin = persistenceInputStream.readByte();
            if (s == SUPPORTED_VERSIONS[1]) {
                bl = true;
            } else {
                this.navOverwriteEnableOnlineFunctions = persistenceInputStream.readBoolean();
                if (s == SUPPORTED_VERSIONS[2]) {
                    bl = true;
                } else {
                    this.pqLscAutomaticModeActive = persistenceInputStream.readBoolean();
                    if (s == SUPPORTED_VERSIONS[3]) {
                        bl = true;
                    } else {
                        this.uotaCustomerSwdlIsRunning = persistenceInputStream.readBoolean();
                        if (s == SUPPORTED_VERSIONS[4]) {
                            bl = true;
                        } else {
                            this.hwrEnabled = persistenceInputStream.readBoolean();
                            this.sportHMIEnabled = persistenceInputStream.readBoolean();
                            if (s == SUPPORTED_VERSIONS[5]) {
                                bl = true;
                            } else {
                                this.lastActiveAudioContext = persistenceInputStream.readInt();
                            }
                        }
                    }
                }
            }
        }
        if (bl) {
            this.clearUnknownValues(s);
        }
    }

    @Override
    public void toStreamInternal(PersistenceOutputStream persistenceOutputStream) {
        persistenceOutputStream.writeByte(this.displayBrightness);
        persistenceOutputStream.writeBoolean(this.showClock);
        persistenceOutputStream.writeByte(this.dayNightMode);
        persistenceOutputStream.writeByte(this.lastContext);
        persistenceOutputStream.writeBoolean(this.lastConnRadio);
        persistenceOutputStream.writeByte(this.lastActiveSkin);
        persistenceOutputStream.writeByte(this.lastActiveLanguagePrefetch);
        persistenceOutputStream.writeBoolean(this.acousticTouchscreenFeedback);
        persistenceOutputStream.writeInt(this.userMuteStarted);
        persistenceOutputStream.writeLong(this.lastClamp15OffTimestamp);
        persistenceOutputStream.writeInt(this.languageWasUsedOnceBeforeBitfield);
        persistenceOutputStream.writeByte(this.spellerLayout);
        persistenceOutputStream.writeBoolean(this.proximityAnimationsActive);
        persistenceOutputStream.writeInt(this.debugProbeConfiguration);
        persistenceOutputStream.writeBoolean(this.autoDaylightSaving);
        persistenceOutputStream.writeBoolean(this.sdsActive);
        persistenceOutputStream.writeBoolean(this.testmodeAlternativeViewSetup1);
        persistenceOutputStream.writeBoolean(this.testmodeAlternativeViewSetup2);
        persistenceOutputStream.writeByte(this.effectiveSkinMode);
        persistenceOutputStream.writeByte(this.lastPersistedCodedSkin);
        persistenceOutputStream.writeBoolean(this.navOverwriteEnableOnlineFunctions);
        persistenceOutputStream.writeBoolean(this.pqLscAutomaticModeActive);
        persistenceOutputStream.writeBoolean(this.uotaCustomerSwdlIsRunning);
        persistenceOutputStream.writeBoolean(this.hwrEnabled);
        persistenceOutputStream.writeBoolean(this.sportHMIEnabled);
        persistenceOutputStream.writeInt(this.lastActiveAudioContext);
        this.writeLastModeToSouthSide(false);
    }

    private void writeLastModeToSouthSide(boolean bl) {
        boolean bl2 = false;
        short s = (short)(this.lastConnRadio ? this.LAST_AUDIO_MODE_RADIO : this.LAST_AUDIO_MODE_MEDIA);
        if (this.lastContext != this.lastSouthSideUserContext) {
            this.lastSouthSideUserContext = (short)this.lastContext;
            bl2 = true;
        }
        if (s != this.lastSouthSideAudioContext) {
            this.lastSouthSideAudioContext = s;
            bl2 = true;
        }
        if (bl2 || bl) {
            byte[] byArray = new byte[]{(byte)(this.lastSouthSideUserContext >> 8), (byte)this.lastSouthSideUserContext, (byte)(this.lastSouthSideAudioContext >> 8), (byte)this.lastSouthSideAudioContext};
            ServiceManager.persistence.writeByteArray(6000, 0, byArray);
        }
    }

    @Override
    public void clearUnknownValues(short s) {
        if (s == SUPPORTED_VERSIONS[5]) {
            this.lastActiveAudioContext = this.LAST_AUDIO_MODE_INVALID;
        } else if (s == SUPPORTED_VERSIONS[4]) {
            this.lastActiveAudioContext = this.LAST_AUDIO_MODE_INVALID;
            this.sportHMIEnabled = false;
            this.hwrEnabled = false;
        } else if (s == SUPPORTED_VERSIONS[3]) {
            this.lastActiveAudioContext = this.LAST_AUDIO_MODE_INVALID;
            this.sportHMIEnabled = false;
            this.hwrEnabled = false;
            this.uotaCustomerSwdlIsRunning = false;
        } else if (s == SUPPORTED_VERSIONS[2]) {
            this.lastActiveAudioContext = this.LAST_AUDIO_MODE_INVALID;
            this.sportHMIEnabled = false;
            this.hwrEnabled = false;
            this.uotaCustomerSwdlIsRunning = false;
            this.pqLscAutomaticModeActive = false;
        } else if (s == SUPPORTED_VERSIONS[1]) {
            this.lastActiveAudioContext = this.LAST_AUDIO_MODE_INVALID;
            this.sportHMIEnabled = false;
            this.hwrEnabled = false;
            this.uotaCustomerSwdlIsRunning = false;
            this.pqLscAutomaticModeActive = false;
            this.navOverwriteEnableOnlineFunctions = false;
        } else if (s == SUPPORTED_VERSIONS[0]) {
            this.lastActiveAudioContext = this.LAST_AUDIO_MODE_INVALID;
            this.sportHMIEnabled = false;
            this.hwrEnabled = false;
            this.uotaCustomerSwdlIsRunning = false;
            this.pqLscAutomaticModeActive = false;
            this.navOverwriteEnableOnlineFunctions = false;
            this.effectiveSkinMode = 0;
            this.lastPersistedCodedSkin = 0;
        }
    }

    PersistableEarlyData() {
        super(5000, 0);
        this.clear();
    }

    @Override
    public void clear() {
        this.displayBrightness = ServiceManager.configManagerDiag.getSystemDisplayBrightnessDefault();
        this.showClock = ServiceManager.configManagerDiag.getSystemShowOffClockActiveDefaultBoolean();
        this.dayNightMode = ServiceManager.configManagerDiag.getSystemDayNightModeDefault();
        this.lastContext = 6;
        this.lastConnRadio = true;
        this.lastActiveSkin = 1;
        this.lastActiveLanguagePrefetch = 0;
        this.acousticTouchscreenFeedback = false;
        this.userMuteStarted = 0;
        this.lastClamp15OffTimestamp = -1L;
        this.languageWasUsedOnceBeforeBitfield = 0;
        this.spellerLayout = ServiceManager.configManagerDiag.getSystemSpellerLayoutDefault();
        this.proximityAnimationsActive = ServiceManager.configManagerDiag.getSystemProximityOnDefaultBoolean();
        this.debugProbeConfiguration = Integer.getInteger("debugProbes.default", -2);
        this.autoDaylightSaving = false;
        this.sdsActive = true;
        this.testmodeAlternativeViewSetup1 = false;
        this.testmodeAlternativeViewSetup2 = false;
        this.clearUnknownValues(SUPPORTED_VERSIONS[0]);
        this.lastSouthSideUserContext = 0;
        this.lastSouthSideAudioContext = (short)this.LAST_AUDIO_MODE_INVALID;
    }

    public static PersistableEarlyData getInstance() {
        if (myInstance == null) {
            myInstance = new PersistableEarlyData();
        }
        return myInstance;
    }

    @Override
    public synchronized void setDisplayBrightness(int n) {
        this.displayBrightness = n;
        this.markDirty(true);
    }

    @Override
    public int getDisplayBrightness() {
        return this.displayBrightness;
    }

    @Override
    public synchronized void setShowClock(boolean bl) {
        this.showClock = bl;
        this.markDirty(true);
    }

    @Override
    public boolean isShowClock() {
        return this.showClock;
    }

    @Override
    public synchronized void setDayNightMode(int n) {
        this.dayNightMode = n;
        this.markDirty(true);
    }

    @Override
    public int getDayNightMode() {
        return this.dayNightMode;
    }

    @Override
    public boolean isLastConnRadio() {
        return this.lastConnRadio;
    }

    @Override
    public synchronized void setLastConnRadio(boolean bl) {
        this.lastConnRadio = bl;
        this.markDirty(true);
    }

    @Override
    public int getLastActiveSkin() {
        return this.lastActiveSkin;
    }

    private void setLastActiveSkin(int n) {
        this.lastActiveSkin = n;
    }

    @Override
    public int getLastActiveLanguagePrefetch() {
        return this.lastActiveLanguagePrefetch;
    }

    @Override
    public synchronized void setLastActiveLanguagePrefetch(int n) {
        this.lastActiveLanguagePrefetch = n;
        this.markDirty(true);
    }

    @Override
    public boolean isAcousticTouchscreenFeedback() {
        return this.acousticTouchscreenFeedback;
    }

    @Override
    public synchronized void setAcousticTouchscreenFeedback(boolean bl) {
        this.acousticTouchscreenFeedback = bl;
        this.markDirty(true);
    }

    @Override
    public int getUserMuteStarted() {
        return this.userMuteStarted;
    }

    @Override
    public synchronized void setUserMuteStarted(int n) {
        this.userMuteStarted = n;
        this.markDirty(true);
    }

    @Override
    public synchronized void setLastClamp15OffTimestamp(long l) {
        this.lastClamp15OffTimestamp = l;
        this.markDirty(true);
    }

    @Override
    public long getLastClamp15OffTimestamp() {
        return this.lastClamp15OffTimestamp;
    }

    @Override
    public synchronized void setLanguageWasUsedOnceBeforeBitfield(int n) {
        this.languageWasUsedOnceBeforeBitfield = n;
        this.markDirty(true);
    }

    @Override
    public int getLanguageWasUsedOnceBeforeBitfield() {
        return this.languageWasUsedOnceBeforeBitfield;
    }

    @Override
    public synchronized void setSpellerLayout(int n) {
        this.spellerLayout = n;
        this.markDirty(true);
    }

    @Override
    public int getSpellerLayout() {
        return this.spellerLayout;
    }

    @Override
    public synchronized void setProximityAnimationsActive(boolean bl) {
        this.proximityAnimationsActive = bl;
        this.markDirty(true);
    }

    @Override
    public boolean getProximityAnimationsActive() {
        return this.proximityAnimationsActive;
    }

    @Override
    public String getCurrentVersion() {
        return "";
    }

    @Override
    public synchronized void setDebugProbeConfiguration(int n) {
        if (this.debugProbeConfiguration != n) {
            this.debugProbeConfiguration = n;
            this.markDirty(true);
        }
    }

    @Override
    public int getDebugProbeConfiguration() {
        return this.debugProbeConfiguration;
    }

    @Override
    public boolean isAutoDaylightSaving() {
        return this.autoDaylightSaving;
    }

    @Override
    public synchronized void setAutoDaylightSaving(boolean bl) {
        this.autoDaylightSaving = bl;
        this.markDirty(true);
    }

    @Override
    public boolean isSDSActive() {
        return this.sdsActive;
    }

    @Override
    public synchronized void setSDSActive(boolean bl) {
        this.sdsActive = bl;
        this.markDirty(true);
    }

    @Override
    public boolean getTestmodeAlternativeViewSetup1() {
        return this.testmodeAlternativeViewSetup1;
    }

    @Override
    public synchronized void toggleTestmodeAlternativeViewSetup1() {
        this.testmodeAlternativeViewSetup1 = !this.testmodeAlternativeViewSetup1;
        this.markDirty(true);
    }

    @Override
    public boolean getTestmodeAlternativeViewSetup2() {
        return this.testmodeAlternativeViewSetup2;
    }

    @Override
    public synchronized void toggleTestmodeAlternativeViewSetup2() {
        this.testmodeAlternativeViewSetup2 = !this.testmodeAlternativeViewSetup2;
        this.markDirty(true);
    }

    @Override
    public byte getEffectiveSkinMode() {
        return this.effectiveSkinMode;
    }

    @Override
    public synchronized void setEffectiveSkinMode(int n) {
        if (this.effectiveSkinMode != (byte)n) {
            this.effectiveSkinMode = (byte)n;
            this.markDirty(true);
        }
    }

    @Override
    public byte getLastPersistedCodedSkin() {
        return this.lastPersistedCodedSkin;
    }

    private void setLastPersistedCodedSkin(int n) {
        this.lastPersistedCodedSkin = (byte)n;
    }

    @Override
    public synchronized void setNavOverwriteEnableOnlineFunctions(boolean bl) {
        if (this.navOverwriteEnableOnlineFunctions != bl) {
            this.navOverwriteEnableOnlineFunctions = bl;
            this.markDirty(true);
        }
    }

    @Override
    public boolean getNavOverwriteEnableOnlineFunctions() {
        return this.navOverwriteEnableOnlineFunctions;
    }

    @Override
    public void setPqLscAutomaticModeActive(boolean bl) {
        this.pqLscAutomaticModeActive = bl;
        this.markDirty(true);
    }

    @Override
    public boolean getPqLscAutomaticModeActive() {
        return this.pqLscAutomaticModeActive;
    }

    public boolean getUotaCustomerSwdlIsRunning() {
        return this.uotaCustomerSwdlIsRunning;
    }

    public void setUotaCustomerSwdlIsRunning(boolean bl) {
        this.uotaCustomerSwdlIsRunning = bl;
    }

    @Override
    public synchronized void setSkinValues(int n, int n2) {
        if (n != -2) {
            this.setLastActiveSkin(n);
        }
        if (n2 != -2) {
            this.setLastPersistedCodedSkin(n2);
        }
        this.markDirty(true);
    }

    @Override
    public void setHWREnabled(boolean bl) {
        this.hwrEnabled = bl;
        this.markDirty(true);
    }

    @Override
    public boolean getHWREnabled() {
        return this.hwrEnabled;
    }

    @Override
    public void setSportHMIEnabled(boolean bl) {
        this.sportHMIEnabled = bl;
        this.markDirty(true);
    }

    @Override
    public boolean getSportHMIEnabled() {
        return this.sportHMIEnabled;
    }

    public void setLastActiveAudioMode(int n) {
        this.lastActiveAudioContext = n;
    }

    public int getLastActiveAudioMode() {
        if (this.lastActiveAudioContext == this.LAST_AUDIO_MODE_INVALID) {
            return this.lastConnRadio ? this.LAST_AUDIO_MODE_RADIO : this.LAST_AUDIO_MODE_MEDIA;
        }
        return this.lastActiveAudioContext;
    }

    static {
        SUPPORTED_VERSIONS = new short[]{13, 14, 15, 16, 17, 18};
    }
}

