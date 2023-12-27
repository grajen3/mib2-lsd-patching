/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mirrorlink.persistence;

import de.vw.mib.asl.framework.api.persistence.AbstractSharedPersistable;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import de.vw.mib.asl.internal.mirrorlink.target.MirrorLinkTarget;
import de.vw.mib.log4mib.LogMessage;

public class MirrorLinkPersistence
extends AbstractSharedPersistable {
    private final String classname;
    private final MirrorLinkTarget target;
    private boolean mirrorlinkActive = true;
    private int displayOrientation = 0;
    private boolean upsideDownActive = false;
    private int currentAudioSource = 1;
    private boolean developerMode = false;
    private boolean controlbarVisibilityMode = true;
    private boolean appPopupEnabled = true;
    private static final short VERSION;
    private static final short[] SUPPORTED_VERSIONS;

    public MirrorLinkPersistence(MirrorLinkTarget mirrorLinkTarget) {
        super(5018, 0);
        this.classname = "MirrorLinkPersistence";
        this.target = mirrorLinkTarget;
    }

    private MirrorLinkTarget getTarget() {
        return this.target;
    }

    @Override
    public void clear() {
        this.mirrorlinkActive = true;
        this.displayOrientation = 0;
        this.upsideDownActive = false;
        this.currentAudioSource = 1;
        this.developerMode = false;
        this.controlbarVisibilityMode = true;
        this.appPopupEnabled = true;
        this.markDirty(true);
    }

    @Override
    public void toStreamInternal(PersistenceOutputStream persistenceOutputStream) {
        persistenceOutputStream.writeBoolean(this.mirrorlinkActive);
        persistenceOutputStream.writeInt(this.displayOrientation);
        persistenceOutputStream.writeBoolean(this.upsideDownActive);
        persistenceOutputStream.writeInt(this.currentAudioSource);
        persistenceOutputStream.writeBoolean(this.developerMode);
        persistenceOutputStream.writeBoolean(this.appPopupEnabled);
    }

    @Override
    public void fromStreamInternal(PersistenceInputStream persistenceInputStream, short s) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append("MirrorLinkPersistence").append(".fromStreamInternal(version=").append(s).append(")").log();
        }
        this.mirrorlinkActive = persistenceInputStream.readBoolean();
        this.displayOrientation = persistenceInputStream.readInt();
        this.upsideDownActive = persistenceInputStream.readBoolean();
        this.currentAudioSource = persistenceInputStream.readInt();
        this.developerMode = persistenceInputStream.readBoolean();
        this.appPopupEnabled = persistenceInputStream.readBoolean();
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
        return 11;
    }

    public boolean isMirrorlinkActive() {
        return true;
    }

    public void toogleMirrorlinkActive() {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkPersistence").append(".toogleMirrorlinkActive()").log();
        }
        this.mirrorlinkActive = !this.mirrorlinkActive;
        this.markDirty(true);
    }

    public int getDisplayOrientation() {
        return this.displayOrientation;
    }

    public void setDisplayOrientation(int n) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkPersistence").append(new StringBuffer().append(".setDisplayOrientation(").append(n).append(")").toString()).log();
        }
        if (this.displayOrientation != n) {
            this.displayOrientation = n;
            this.markDirty(true);
        }
    }

    public boolean isUpsideDownActive() {
        return this.upsideDownActive;
    }

    public void toogleUpsideDownActive() {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkPersistence").append(".toogleUpsideDownActive()").log();
        }
        this.upsideDownActive = !this.upsideDownActive;
        this.markDirty(true);
    }

    public int getCurrentAudioSource() {
        return this.currentAudioSource;
    }

    public void setCurrentAudioSource(int n) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkPersistence").append(new StringBuffer().append(".setCurrentAudioSource(").append(n).append(")").toString()).log();
        }
        if (this.currentAudioSource != n) {
            this.currentAudioSource = n;
            this.markDirty(true);
        }
    }

    public void setDeveloperMode(boolean bl) {
        if (this.developerMode != bl) {
            this.developerMode = bl;
            this.markDirty(true);
        }
    }

    public boolean isDeveloperMode() {
        return this.developerMode;
    }

    public boolean getControlbarVisibilityMode() {
        return this.controlbarVisibilityMode;
    }

    public void toggleControlbarVisibilityMode() {
        this.controlbarVisibilityMode = !this.controlbarVisibilityMode;
    }

    public boolean getAppPopupEnabled() {
        return this.appPopupEnabled;
    }

    public void toogleAppPopupEnabled() {
        this.appPopupEnabled = !this.appPopupEnabled;
        this.markDirty(true);
    }

    static {
        SUPPORTED_VERSIONS = NO_SUPPORTED_VERSION;
    }
}

