/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence.AbstractSharedPersistable;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.sound.SoundPersistence$1;
import de.vw.mib.asl.internal.sound.SoundPersistence$2;
import de.vw.mib.asl.internal.sound.SoundPersistence$3;
import de.vw.mib.asl.sound.persistence.SoundPersistenceService;
import de.vw.mib.asl.sound.persistence.SoundPersistenceServiceImpl;
import de.vw.mib.asl.sound.persistence.SoundSettings;

public final class SoundPersistence
extends AbstractSharedPersistable {
    private static SoundPersistence instance;
    private static final short VERSION;
    private static final short[] SUPPORTED_VERSIONS;
    private static final int EQ_MODE_DEFAULT;
    private static final short EQ_USER_TREBLE_DEFAULT;
    private static final short EQ_USER_MIDDLE_DEFAULT;
    private static final short EQ_USER_BASS_DEFAULT;
    private static final int EQ_PRESET_CANTON_DEFAULT;
    private static final boolean USER_MUTE_ACTIVE_DEFAULT;
    private int eqMode = 1;
    private short eqUserTreble = 0;
    private short eqUserMiddle = 0;
    private short eqUserBass = 0;
    private int eqPresetCanton = 0;
    private boolean userMuteActive = false;
    public final SoundPersistenceService soundPersistenceService = SoundPersistenceServiceImpl.getInstance();
    private SoundSettings persistence;
    private boolean profileChangeOngoing = false;
    protected boolean mutepersonalizationTriggeredByMe = false;
    protected boolean profileChanceWithAudioMuteClampOngoing = false;

    public static int getEqModeDefault() {
        return 1;
    }

    public static int getEqPresetCantonDefault() {
        return 0;
    }

    public SoundPersistence() {
        super(5026, 0);
        this.clear();
        this.loadPersistence2_0();
    }

    void loadPersistence2_0() {
        this.persistence = this.soundPersistenceService.loadSoundSettings();
    }

    public static SoundPersistence getInstance() {
        if (instance == null) {
            instance = new SoundPersistence();
            ServiceManager.persistence.registerSharedPersistable(instance);
            ServiceManager.persistence.loadPersistable(instance.getNamespace(), instance.getKey(), instance);
            instance.registerProfileChangeHandler();
        }
        return instance;
    }

    public void registerProfileChangeHandler() {
        SoundPersistence$1 soundPersistence$1 = new SoundPersistence$1(this);
        this.soundPersistenceService.addProfileChangeListener(soundPersistence$1);
        ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi().addGlobalProfileChangeListener(new SoundPersistence$2(this), 0);
        ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi().addGlobalProfileChangeListener(new SoundPersistence$3(this), 10);
    }

    public void resetValues() {
        this.clear();
        this.markDirty(true);
    }

    public void resetToDefaults() {
        this.clear();
    }

    @Override
    public void clear() {
        if (ServiceManager.logger.isTraceEnabled(16)) {
            ServiceManager.logger.trace(16).append("SoundPersistence.clear()").log();
        }
        if (this.persistence != null) {
            this.persistence.resetToDefaults();
        } else {
            this.persistence = this.soundPersistenceService.createSoundSettings();
        }
        this.eqMode = 1;
        this.eqUserTreble = 0;
        this.eqUserMiddle = 0;
        this.eqUserBass = 0;
        this.eqPresetCanton = 0;
        this.userMuteActive = false;
    }

    @Override
    public void fromStreamInternal(PersistenceInputStream persistenceInputStream, short s) {
        if (ServiceManager.logger.isTraceEnabled(16)) {
            ServiceManager.logger.trace(16).append("SoundPersistence.fromStreamInternal()").log();
        }
        this.eqMode = persistenceInputStream.readInt();
        this.eqUserTreble = persistenceInputStream.readShort();
        this.eqUserMiddle = persistenceInputStream.readShort();
        this.eqUserBass = persistenceInputStream.readShort();
        this.eqPresetCanton = persistenceInputStream.readInt();
        this.userMuteActive = persistenceInputStream.readBoolean();
    }

    @Override
    public void toStreamInternal(PersistenceOutputStream persistenceOutputStream) {
        if (ServiceManager.logger.isTraceEnabled(16)) {
            ServiceManager.logger.trace(16).append("SoundPersistence.toStreamInternal()").log();
        }
        persistenceOutputStream.writeInt(this.eqMode);
        persistenceOutputStream.writeShort(this.eqUserTreble);
        persistenceOutputStream.writeShort(this.eqUserMiddle);
        persistenceOutputStream.writeShort(this.eqUserBass);
        persistenceOutputStream.writeInt(this.eqPresetCanton);
        persistenceOutputStream.writeBoolean(this.userMuteActive);
    }

    @Override
    public void clearUnknownValues(short s) {
    }

    @Override
    public short[] getSupportedVersions() {
        return SUPPORTED_VERSIONS;
    }

    @Override
    public short getVersion() {
        return 3;
    }

    public int getEqMode() {
        return this.persistence.getEqMode();
    }

    public void setEqMode(int n) {
        this.persistence.setEqMode(n);
    }

    public short getEqUserTreble() {
        return this.persistence.getEqUserTreble();
    }

    public void setEqUserTreble(short s) {
        this.persistence.setEqUserTreble(s);
    }

    public short getEqUserMiddle() {
        return this.persistence.getEqUserMiddle();
    }

    public void setEqUserMiddle(short s) {
        this.persistence.setEqUserMiddle(s);
    }

    public short getEqUserBass() {
        return this.persistence.getEqUserBass();
    }

    public void setEqUserBass(short s) {
        this.persistence.setEqUserBass(s);
    }

    public int getEqPresetCanton() {
        return this.persistence.getEqPresetCanton();
    }

    public void setEqPresetCanton(int n) {
        this.persistence.setEqPresetCanton(n);
    }

    public boolean getUserMuteActive() {
        return this.persistence.isUserMuteActive();
    }

    public void setUserMuteActive(boolean bl) {
        this.persistence.setUserMuteActive(bl);
    }

    public boolean isProfileChangeOngoing() {
        return this.profileChangeOngoing;
    }

    public void setProfileChangeOngoing(boolean bl) {
        this.profileChangeOngoing = bl;
    }

    static {
        SUPPORTED_VERSIONS = NO_SUPPORTED_VERSION;
    }
}

