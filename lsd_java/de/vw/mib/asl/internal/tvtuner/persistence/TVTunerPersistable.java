/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.persistence;

import de.vw.mib.asl.framework.api.persistence.AbstractSharedPersistable;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import de.vw.mib.asl.internal.tvtuner.accessor.TVTunerObjectAccessor;
import de.vw.mib.asl.internal.tvtuner.common.TVTunerHelper;

public final class TVTunerPersistable
extends AbstractSharedPersistable {
    private static final short VERSION;
    private static final short[] SUPPORTED_VERSIONS;
    private boolean isServiceLinkingActive;
    private boolean isSubtitleActive;
    private int aspectRatio;
    private int buttonMode;
    private int activeSource;
    private int avAspectRatio;
    private int avNorm;
    private int normArea;
    private long lastStationNamePID;
    private int lastStationServicePID;
    private int lastStationSType;
    private int lastAudioChannelID;
    private boolean visualAudioShowPictures;
    private boolean showEWSMessages;

    public TVTunerPersistable() {
        super(5014, 0);
        this.clear();
    }

    @Override
    public void clear() {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("TVTunerPersistable#clear()");
        }
        this.isServiceLinkingActive = true;
        this.isSubtitleActive = false;
        this.aspectRatio = 0;
        this.buttonMode = 1;
        this.activeSource = 0;
        this.avAspectRatio = 1;
        this.avNorm = 0;
        this.normArea = 0;
        this.lastStationNamePID = -1L;
        this.lastStationServicePID = -1;
        this.lastStationSType = -1;
        this.lastAudioChannelID = -1;
        this.visualAudioShowPictures = false;
        this.showEWSMessages = true;
    }

    @Override
    public void toStreamInternal(PersistenceOutputStream persistenceOutputStream) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("TVTunerPersistable#toStreamInternal()");
        }
        persistenceOutputStream.writeBoolean(this.isServiceLinkingActive);
        persistenceOutputStream.writeBoolean(this.isSubtitleActive);
        persistenceOutputStream.writeInt(this.aspectRatio);
        persistenceOutputStream.writeInt(this.buttonMode);
        persistenceOutputStream.writeInt(this.activeSource);
        persistenceOutputStream.writeInt(this.avAspectRatio);
        persistenceOutputStream.writeInt(this.avNorm);
        persistenceOutputStream.writeInt(this.normArea);
        persistenceOutputStream.writeLong(this.lastStationNamePID);
        persistenceOutputStream.writeInt(this.lastStationServicePID);
        persistenceOutputStream.writeInt(this.lastStationSType);
        persistenceOutputStream.writeInt(this.lastAudioChannelID);
        persistenceOutputStream.writeBoolean(this.visualAudioShowPictures);
        persistenceOutputStream.writeBoolean(this.showEWSMessages);
        TVTunerObjectAccessor.getResetParticipant().notifyResetParticipant();
    }

    public void persistButtonMode(int n) {
        if (this.buttonMode != n) {
            this.buttonMode = n;
            this.tryMarkDirty(true);
        }
    }

    public void persistActiveSource(int n) {
        if (this.activeSource != n) {
            this.activeSource = n;
            this.tryMarkDirty(true);
        }
    }

    public void persistAspectRatio(int n) {
        if (this.aspectRatio != n) {
            this.aspectRatio = n;
            this.tryMarkDirty(true);
        }
    }

    public void persistSubtitleActive(boolean bl) {
        if (this.isSubtitleActive != bl) {
            this.isSubtitleActive = bl;
            this.tryMarkDirty(true);
        }
    }

    public void persistServiceLinkingActive(boolean bl) {
        if (this.isServiceLinkingActive != bl) {
            this.isServiceLinkingActive = bl;
            this.tryMarkDirty(true);
        }
    }

    public void persistAVAspectRatio(int n) {
        if (this.avAspectRatio != n) {
            this.avAspectRatio = n;
            this.tryMarkDirty(true);
        }
    }

    public void persistAVNorm(int n) {
        if (this.avNorm != n) {
            this.avNorm = n;
            this.tryMarkDirty(true);
        }
    }

    public void persistNormArea(int n) {
        if (this.normArea != n) {
            this.normArea = n;
            this.tryMarkDirty(true);
        }
    }

    public void persistLastStation(long l, int n, int n2) {
        if (l != this.lastStationNamePID) {
            this.lastStationNamePID = l;
            this.lastStationServicePID = n;
            this.lastStationSType = n2;
            this.tryMarkDirty(true);
        }
    }

    public void persistLastAudioChannel(int n) {
        if (n != this.lastAudioChannelID) {
            this.lastAudioChannelID = n;
            this.tryMarkDirty(true);
        }
    }

    public void persistVisualAudioShowPictures(boolean bl) {
        if (bl != this.visualAudioShowPictures) {
            this.visualAudioShowPictures = bl;
            this.tryMarkDirty(true);
        }
    }

    public void persistShowEWSMessageOption(boolean bl) {
        if (bl != this.showEWSMessages) {
            this.showEWSMessages = bl;
            this.tryMarkDirty(true);
        }
    }

    public void updateTunerSettings(boolean bl) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerPersistable#updateTunerSettings( forceReset = ").append(bl).append(" )").toString());
        }
        TVTunerObjectAccessor.getTvTunerSettings().setServiceLinking(this.isServiceLinkingActive);
        TVTunerObjectAccessor.getTvTunerSettings().setSubtitleState(this.isSubtitleActive);
        TVTunerObjectAccessor.getTvAvSourceHandler().setSource(this.activeSource);
        TVTunerObjectAccessor.getTvTunerAVSettings().setAVNorm(this.avNorm);
        if (bl) {
            TVTunerObjectAccessor.getTvTunerSettings().setSelectedTVNorm(0);
        } else if (this.normArea != 0) {
            TVTunerObjectAccessor.getTvTunerSettings().setSelectedTVNorm(this.normArea);
        } else if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("TVTunerPersistable#updateTunerSettings() - normArea == 0 -> ignore");
        }
    }

    public void updateModelSettings() {
        TVTunerObjectAccessor.getTvTunerSettings().setAspectRatioMode(this.aspectRatio, true);
        TVTunerObjectAccessor.getTuningHandler().setArrowButtonMode(this.buttonMode, true);
        TVTunerObjectAccessor.getTvTunerAVSettings().setAspectRatioMode(this.avAspectRatio, true);
        TVTunerObjectAccessor.getTvTunerSettings().setVisualAudioShowPictures(this.visualAudioShowPictures, true);
        TVTunerObjectAccessor.getTvTunerSettings().setShowEWSMessages(this.showEWSMessages, true);
    }

    private void setLastStation() {
        TVTunerObjectAccessor.getTargetTVTunerDSI().getDSITVTuner().selectService(this.lastStationNamePID, this.lastStationServicePID, this.lastStationSType);
        TVTunerObjectAccessor.getTargetTVTunerDSI().getDSITVTuner().setAudioChannel(this.lastAudioChannelID);
    }

    @Override
    public void fromStreamInternal(PersistenceInputStream persistenceInputStream, short s) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerPersistable#fromStreamInternal( version == ").append(s).append(" )").toString());
        }
        this.isServiceLinkingActive = persistenceInputStream.readBoolean();
        this.isSubtitleActive = persistenceInputStream.readBoolean();
        this.aspectRatio = persistenceInputStream.readInt();
        this.buttonMode = persistenceInputStream.readInt();
        this.activeSource = persistenceInputStream.readInt();
        this.avAspectRatio = persistenceInputStream.readInt();
        this.avNorm = persistenceInputStream.readInt();
        this.normArea = persistenceInputStream.readInt();
        this.lastStationNamePID = persistenceInputStream.readLong();
        this.lastStationServicePID = persistenceInputStream.readInt();
        this.lastStationSType = persistenceInputStream.readInt();
        this.lastAudioChannelID = persistenceInputStream.readInt();
        this.visualAudioShowPictures = persistenceInputStream.readBoolean();
        this.showEWSMessages = persistenceInputStream.readBoolean();
        this.updateModelSettings();
        this.updateTunerSettings(false);
        this.setLastStation();
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
        return 2;
    }

    public void tryMarkDirty(boolean bl) {
        if (TVTunerObjectAccessor.getResetParticipant().getResetState() != 1) {
            this.markDirty(bl);
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace(new StringBuffer().append("TVTunerPersistable#tryMarkDirty called - dirty was set to: ").append(bl).toString());
            }
        } else if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerPersistable#tryMarkDirty called - dirty was NOT set to: ").append(bl).toString());
        }
    }

    static {
        SUPPORTED_VERSIONS = new short[0];
    }
}

