/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.pictureviewer;

import de.vw.mib.asl.framework.api.persistence.AbstractSharedPersistable;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.pictureviewer.PictureSourceInfo;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Loggable;

public final class PictureViewerSettings
extends AbstractSharedPersistable
implements Loggable {
    public static final int INVALID_PICTURE_INDEX;
    private int _zoomLevel = 0;
    private int _slideshowTimer = 0;
    private boolean _slideshowRepeatState = true;
    private PictureSourceInfo picture = PictureSourceInfo.NONE;
    private final String _classname = super.getClass().getName();
    private static final short VERSION;
    private static final short[] SUPPORTED_VERSIONS;

    public PictureViewerSettings() {
        super(5007, 0);
        this.clear();
    }

    void setZoomLevel(int n) {
        if (this._zoomLevel != n) {
            this._zoomLevel = n;
            this.markDirty(true);
        }
    }

    public int getZoomLevel() {
        return this._zoomLevel;
    }

    public boolean setSlideshowTimer(int n) {
        if (n != this._slideshowTimer) {
            this._slideshowTimer = n;
            this.markDirty(true);
            return true;
        }
        return false;
    }

    public int getSlideshowTimer() {
        return this._slideshowTimer;
    }

    public void toggleSlideshowRepeatState() {
        this._slideshowRepeatState = !this._slideshowRepeatState;
        this.markDirty(true);
    }

    public boolean getSlideshowRepeatState() {
        return this._slideshowRepeatState;
    }

    public int getHMISourceId() {
        return this.picture.getHMISourceId();
    }

    public String getUniqueMediaID() {
        return this.picture.getUniqueMediaID();
    }

    public String[] getPicturePath() {
        return this.picture.getPicturePath();
    }

    public int getPictureIndex() {
        return this.picture.getPictureIndex();
    }

    public void setPicture(PictureSourceInfo pictureSourceInfo) {
        this.picture = pictureSourceInfo;
        this.markDirty(true);
    }

    public PictureSourceInfo getPictureSourceInfo() {
        return this.picture;
    }

    @Override
    public void clear() {
        this._zoomLevel = 0;
        this._slideshowTimer = 0;
        this._slideshowRepeatState = true;
        this.picture = PictureSourceInfo.NONE;
    }

    void factoryReset() {
        this.clear();
        this.markDirty(true);
    }

    @Override
    public void fromStreamInternal(PersistenceInputStream persistenceInputStream, short s) {
        this._zoomLevel = persistenceInputStream.readInt();
        this._slideshowTimer = persistenceInputStream.readInt();
        this._slideshowRepeatState = persistenceInputStream.readBoolean();
        this.picture = new PictureSourceInfo(persistenceInputStream);
        if (ServiceManager.logger2.isTraceEnabled(128)) {
            ServiceManager.logger2.trace(128).append("PictureViewerSettings.fromStreamInternal(): ").append(this).log();
        }
    }

    @Override
    public void toStreamInternal(PersistenceOutputStream persistenceOutputStream) {
        persistenceOutputStream.writeInt(this._zoomLevel);
        persistenceOutputStream.writeInt(this._slideshowTimer);
        persistenceOutputStream.writeBoolean(this._slideshowRepeatState);
        this.picture.toStreamInternal(persistenceOutputStream);
        if (ServiceManager.logger2.isTraceEnabled(128)) {
            ServiceManager.logger2.trace(128).append("PictureViewerSettings.toStreamInternal()").append(this).log();
        }
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
        return 5;
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("PictureViewerSettings [_zoomLevel=").append(this._zoomLevel).append(", _slideshowTimer=").append(this._slideshowTimer).append(", _slideshowRepeatState=").append(this._slideshowRepeatState).append(", picture=").append(this.picture.toString());
    }

    static {
        SUPPORTED_VERSIONS = NO_SUPPORTED_VERSION;
    }
}

