/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.persistence;

import de.vw.mib.asl.framework.api.persistence.AbstractSharedPersistable;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.services.CoreServiceImageInfo;
import de.vw.mib.log4mib.LogMessage;
import java.util.ArrayList;

public class CoreServicePersistence
extends AbstractSharedPersistable {
    private static final short VERSION;
    private final String _classname = super.getClass().getName();
    private ArrayList _imageList;
    private boolean _carNetPinActivated;
    private boolean _downloadIndicationStatus;
    private boolean _downloadDestinationIndicationStatus;
    private boolean _downloadLaterStatus;
    private boolean _downloadDestinationLaterStatus;

    public CoreServicePersistence() {
        super(5022, 0);
    }

    private ArrayList getImageList() {
        if (this._imageList == null) {
            this._imageList = new ArrayList();
        }
        return this._imageList;
    }

    public ArrayList getImageInfoList() {
        return this.getImageList();
    }

    public boolean addImageInfo(CoreServiceImageInfo coreServiceImageInfo) {
        boolean bl = false;
        if (coreServiceImageInfo != null) {
            if (ServiceManager.logger2.isTraceEnabled(16384)) {
                LogMessage logMessage = ServiceManager.logger2.trace(16384);
                logMessage.append(this._classname).append(new StringBuffer().append(".addImageInfo(").append(coreServiceImageInfo.toString()).append(")").toString()).log();
            }
            this.getImageList().add(coreServiceImageInfo);
            bl = true;
            this.markDirty(bl);
        }
        return bl;
    }

    public void removeImageInfo(CoreServiceImageInfo coreServiceImageInfo) {
    }

    public void setCarNetPinActivation(boolean bl) {
        this._carNetPinActivated = bl;
        this.markDirty(true);
    }

    public boolean isCarNetPinActivated() {
        return this._carNetPinActivated;
    }

    public boolean isDownloadIndicationStatus() {
        return this._downloadIndicationStatus;
    }

    public void setDownloadIndicationStatus(boolean bl) {
        this._downloadIndicationStatus = bl;
        this.markDirty(true);
    }

    public boolean isDownloadDestinationIndicationStatus() {
        return this._downloadDestinationIndicationStatus;
    }

    public void setDownloadDestinationIndicationStatus(boolean bl) {
        this._downloadDestinationIndicationStatus = bl;
        this.markDirty(true);
    }

    public boolean isDownloadLaterStatus() {
        return this._downloadLaterStatus;
    }

    public void setDownloadLaterStatus(boolean bl) {
        this._downloadLaterStatus = bl;
    }

    public boolean isDownloadDestinationLaterStatus() {
        return this._downloadDestinationLaterStatus;
    }

    public void setDownloadDestinationLaterStatus(boolean bl) {
        this._downloadDestinationLaterStatus = bl;
    }

    @Override
    public void clearUnknownValues(short s) {
    }

    @Override
    public void fromStreamInternal(PersistenceInputStream persistenceInputStream, short s) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".fromStreamInternal()").log();
        }
        this.getImageList().clear();
        int n = persistenceInputStream.readInt();
        for (int i2 = 0; i2 < n; ++i2) {
            CoreServiceImageInfo coreServiceImageInfo = new CoreServiceImageInfo(persistenceInputStream);
            this.getImageList().add(coreServiceImageInfo);
        }
        this._carNetPinActivated = persistenceInputStream.readBoolean();
        this._downloadIndicationStatus = persistenceInputStream.readBoolean();
        this._downloadDestinationIndicationStatus = persistenceInputStream.readBoolean();
    }

    @Override
    public void toStreamInternal(PersistenceOutputStream persistenceOutputStream) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(".toStreamInternal()").log();
        }
        persistenceOutputStream.writeInt(this.getImageList().size());
        object = this.getImageList().iterator();
        while (object.hasNext()) {
            CoreServiceImageInfo coreServiceImageInfo = (CoreServiceImageInfo)object.next();
            coreServiceImageInfo.toStream(persistenceOutputStream);
        }
        persistenceOutputStream.writeBoolean(this._carNetPinActivated);
        persistenceOutputStream.writeBoolean(this._downloadIndicationStatus);
        persistenceOutputStream.writeBoolean(this._downloadDestinationIndicationStatus);
    }

    @Override
    public short[] getSupportedVersions() {
        return NO_SUPPORTED_VERSION;
    }

    @Override
    public short getVersion() {
        return 15;
    }

    @Override
    public void clear() {
        this.getImageList().clear();
        this._carNetPinActivated = false;
        this._downloadIndicationStatus = false;
        this._downloadDestinationIndicationStatus = false;
        this._downloadLaterStatus = false;
        this._downloadDestinationLaterStatus = false;
        this.markDirty(true);
    }
}

