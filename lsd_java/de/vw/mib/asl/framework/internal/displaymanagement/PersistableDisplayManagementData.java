/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.displaymanagement;

import de.vw.mib.asl.framework.api.persistence.AbstractVersionedPersistable;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import de.vw.mib.asl.framework.internal.displaymanagement.DisplayManagementPersistence;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public final class PersistableDisplayManagementData
extends AbstractVersionedPersistable
implements DisplayManagementPersistence {
    private static final short VERSION;
    private static final short[] SUPPORTED_VERSIONS;
    private boolean isDirty = false;
    private int displayableBrightnessForRVC;
    private int displayableContrastForRVC;
    private int displayableColorForRVC;
    private int displayableBrightnessForVideo_AMI;
    private int displayableContrastForVideo_AMI;
    private int displayableSaturationForVideo_AMI;
    private int displayableTintForVideo_AMI;
    private int displayableBrightnessForVideo_Digital_1;
    private int displayableContrastForVideo_Digital_1;
    private int displayableSaturationForVideo_Digital_1;
    private int displayableTintForVideo_Digital_1;
    private int displayableBrightnessForTV;
    private int displayableContrastForTV;
    private int displayableSaturationForTV;
    private int displayableTintForTV;
    private int displayableBrightnessForTV_AV;
    private int displayableContrastForTV_AV;
    private int displayableSaturationForTV_AV;
    private int displayableTintForTV_AV;
    private int screenshotCounter;

    @Override
    public short getVersion() {
        return 13;
    }

    @Override
    public short[] getSupportedVersions() {
        return SUPPORTED_VERSIONS;
    }

    PersistableDisplayManagementData() {
        this.clear();
    }

    void load() {
        ServiceManager.persistence.loadPersistable(5010, 0, this);
    }

    void store() {
        if (this.isDirty) {
            ServiceManager.persistence.storePersistable(5010, 0, this);
            this.isDirty = false;
        }
    }

    @Override
    public void clearUnknownValues(short s) {
        if (s == SUPPORTED_VERSIONS[0] && ServiceManager.configManagerDiag.isFeatureFlagSet(425)) {
            this.displayableBrightnessForTV = 0;
            this.displayableContrastForTV = 0;
            this.displayableSaturationForTV = 0;
            this.displayableTintForTV = 0;
            this.displayableBrightnessForTV_AV = 0;
            this.displayableContrastForTV_AV = 0;
            this.displayableSaturationForTV_AV = 0;
            this.displayableTintForTV_AV = 0;
        }
    }

    @Override
    public void clear() {
        this.displayableBrightnessForVideo_AMI = 0;
        this.displayableContrastForVideo_AMI = 0;
        this.displayableSaturationForVideo_AMI = 0;
        this.displayableTintForVideo_AMI = 0;
        this.displayableBrightnessForRVC = 50;
        this.displayableContrastForRVC = 50;
        this.displayableColorForRVC = 50;
        this.screenshotCounter = 1;
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(70)) {
            this.displayableBrightnessForVideo_Digital_1 = 0;
            this.displayableContrastForVideo_Digital_1 = 0;
            this.displayableSaturationForVideo_Digital_1 = 0;
            this.displayableTintForVideo_Digital_1 = 0;
        }
        this.clearUnknownValues(SUPPORTED_VERSIONS[0]);
    }

    @Override
    public void fromStreamInternal(PersistenceInputStream persistenceInputStream, short s) {
        this.displayableBrightnessForVideo_AMI = persistenceInputStream.readByte();
        this.displayableContrastForVideo_AMI = persistenceInputStream.readByte();
        this.displayableSaturationForVideo_AMI = persistenceInputStream.readByte();
        this.displayableTintForVideo_AMI = persistenceInputStream.readByte();
        this.displayableBrightnessForRVC = persistenceInputStream.readByte();
        this.displayableContrastForRVC = persistenceInputStream.readByte();
        this.displayableColorForRVC = persistenceInputStream.readByte();
        this.screenshotCounter = persistenceInputStream.readInt();
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(70)) {
            this.displayableBrightnessForVideo_Digital_1 = persistenceInputStream.readByte();
            this.displayableContrastForVideo_Digital_1 = persistenceInputStream.readByte();
            this.displayableSaturationForVideo_Digital_1 = persistenceInputStream.readByte();
            this.displayableTintForVideo_Digital_1 = persistenceInputStream.readByte();
        }
        if (s == SUPPORTED_VERSIONS[0]) {
            this.clearUnknownValues(s);
            return;
        }
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(425)) {
            this.displayableBrightnessForTV = persistenceInputStream.readByte();
            this.displayableContrastForTV = persistenceInputStream.readByte();
            this.displayableSaturationForTV = persistenceInputStream.readByte();
            this.displayableTintForTV = persistenceInputStream.readByte();
            this.displayableBrightnessForTV_AV = persistenceInputStream.readByte();
            this.displayableContrastForTV_AV = persistenceInputStream.readByte();
            this.displayableSaturationForTV_AV = persistenceInputStream.readByte();
            this.displayableTintForTV_AV = persistenceInputStream.readByte();
        }
    }

    @Override
    public void toStreamInternal(PersistenceOutputStream persistenceOutputStream) {
        persistenceOutputStream.writeByte(this.displayableBrightnessForVideo_AMI);
        persistenceOutputStream.writeByte(this.displayableContrastForVideo_AMI);
        persistenceOutputStream.writeByte(this.displayableSaturationForVideo_AMI);
        persistenceOutputStream.writeByte(this.displayableTintForVideo_AMI);
        persistenceOutputStream.writeByte(this.displayableBrightnessForRVC);
        persistenceOutputStream.writeByte(this.displayableContrastForRVC);
        persistenceOutputStream.writeByte(this.displayableColorForRVC);
        persistenceOutputStream.writeInt(this.screenshotCounter);
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(70)) {
            persistenceOutputStream.writeByte(this.displayableBrightnessForVideo_Digital_1);
            persistenceOutputStream.writeByte(this.displayableContrastForVideo_Digital_1);
            persistenceOutputStream.writeByte(this.displayableSaturationForVideo_Digital_1);
            persistenceOutputStream.writeByte(this.displayableTintForVideo_Digital_1);
        }
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(425)) {
            persistenceOutputStream.writeByte(this.displayableBrightnessForTV);
            persistenceOutputStream.writeByte(this.displayableContrastForTV);
            persistenceOutputStream.writeByte(this.displayableSaturationForTV);
            persistenceOutputStream.writeByte(this.displayableTintForTV);
            persistenceOutputStream.writeByte(this.displayableBrightnessForTV_AV);
            persistenceOutputStream.writeByte(this.displayableContrastForTV_AV);
            persistenceOutputStream.writeByte(this.displayableSaturationForTV_AV);
            persistenceOutputStream.writeByte(this.displayableTintForTV_AV);
        }
    }

    void setVideoDisplayableBrightness(int n, int n2) {
        switch (n) {
            case 27: {
                if (this.displayableBrightnessForVideo_AMI == n2) break;
                this.displayableBrightnessForVideo_AMI = n2;
                this.isDirty = true;
                break;
            }
            case 26: {
                if (this.displayableBrightnessForTV == n2) break;
                this.displayableBrightnessForTV = n2;
                this.isDirty = true;
                break;
            }
            case 29: {
                if (this.displayableBrightnessForTV_AV == n2) break;
                this.displayableBrightnessForTV_AV = n2;
                this.isDirty = true;
                break;
            }
            case 43: {
                if (this.displayableBrightnessForVideo_Digital_1 == n2) break;
                this.displayableBrightnessForVideo_Digital_1 = n2;
                this.isDirty = true;
                break;
            }
        }
    }

    int getVideoDisplayableBrightness(int n) {
        switch (n) {
            case 27: {
                return this.displayableBrightnessForVideo_AMI;
            }
            case 26: {
                return this.displayableBrightnessForTV;
            }
            case 29: {
                return this.displayableBrightnessForTV_AV;
            }
            case 43: {
                return this.displayableBrightnessForVideo_Digital_1;
            }
        }
        return -1;
    }

    void setVideoDisplayableContrast(int n, int n2) {
        switch (n) {
            case 27: {
                if (this.displayableContrastForVideo_AMI == n2) break;
                this.displayableContrastForVideo_AMI = n2;
                this.isDirty = true;
                break;
            }
            case 26: {
                if (this.displayableContrastForTV == n2) break;
                this.displayableContrastForTV = n2;
                this.isDirty = true;
                break;
            }
            case 29: {
                if (this.displayableContrastForTV_AV == n2) break;
                this.displayableContrastForTV_AV = n2;
                this.isDirty = true;
                break;
            }
            case 43: {
                if (this.displayableContrastForVideo_Digital_1 == n2) break;
                this.displayableContrastForVideo_Digital_1 = n2;
                this.isDirty = true;
                break;
            }
        }
    }

    int getVideoDisplayableContrast(int n) {
        switch (n) {
            case 27: {
                return this.displayableContrastForVideo_AMI;
            }
            case 26: {
                return this.displayableContrastForTV;
            }
            case 29: {
                return this.displayableContrastForTV_AV;
            }
            case 43: {
                return this.displayableContrastForVideo_Digital_1;
            }
        }
        return -1;
    }

    void setVideoDisplayableSaturation(int n, int n2) {
        switch (n) {
            case 27: {
                if (this.displayableSaturationForVideo_AMI == n2) break;
                this.displayableSaturationForVideo_AMI = n2;
                this.isDirty = true;
                break;
            }
            case 26: {
                if (this.displayableSaturationForTV == n2) break;
                this.displayableSaturationForTV = n2;
                this.isDirty = true;
                break;
            }
            case 29: {
                if (this.displayableSaturationForTV_AV == n2) break;
                this.displayableSaturationForTV_AV = n2;
                this.isDirty = true;
                break;
            }
            case 43: {
                if (this.displayableSaturationForVideo_Digital_1 == n2) break;
                this.displayableSaturationForVideo_Digital_1 = n2;
                this.isDirty = true;
                break;
            }
        }
    }

    int getVideoDisplayableSaturation(int n) {
        switch (n) {
            case 27: {
                return this.displayableSaturationForVideo_AMI;
            }
            case 26: {
                return this.displayableSaturationForTV;
            }
            case 29: {
                return this.displayableSaturationForTV_AV;
            }
            case 43: {
                return this.displayableSaturationForVideo_Digital_1;
            }
        }
        return -1;
    }

    void setVideoDisplayableTint(int n, int n2) {
        switch (n) {
            case 27: {
                if (this.displayableTintForVideo_AMI == n2) break;
                this.displayableTintForVideo_AMI = n2;
                this.isDirty = true;
                break;
            }
            case 26: {
                if (this.displayableTintForTV == n2) break;
                this.displayableTintForTV = n2;
                this.isDirty = true;
                break;
            }
            case 29: {
                if (this.displayableTintForTV_AV == n2) break;
                this.displayableTintForTV_AV = n2;
                this.isDirty = true;
                break;
            }
            case 43: {
                if (this.displayableTintForVideo_Digital_1 == n2) break;
                this.displayableTintForVideo_Digital_1 = n2;
                this.isDirty = true;
                break;
            }
        }
    }

    int getVideoDisplayableTint(int n) {
        switch (n) {
            case 27: {
                return this.displayableTintForVideo_AMI;
            }
            case 26: {
                return this.displayableTintForTV;
            }
            case 29: {
                return this.displayableTintForTV_AV;
            }
            case 43: {
                return this.displayableTintForVideo_Digital_1;
            }
        }
        return -1;
    }

    void setRVCDisplayableBrightness(int n) {
        if (this.displayableBrightnessForRVC != n) {
            this.displayableBrightnessForRVC = n;
            this.isDirty = true;
        }
    }

    int getRVCDisplayableBrightness() {
        return this.displayableBrightnessForRVC;
    }

    void setRVCDisplayableContrast(int n) {
        if (this.displayableContrastForRVC != n) {
            this.displayableContrastForRVC = n;
            this.isDirty = true;
        }
    }

    int getRVCDisplayableContrast() {
        return this.displayableContrastForRVC;
    }

    void setRVCDisplayableColor(int n) {
        if (this.displayableColorForRVC != n) {
            this.displayableColorForRVC = n;
            this.isDirty = true;
        }
    }

    int getRVCDisplayableColor() {
        return this.displayableColorForRVC;
    }

    @Override
    public void setScreenshotCounter(int n) {
        if (this.screenshotCounter != n) {
            this.screenshotCounter = n;
            this.isDirty = true;
            this.store();
        }
    }

    @Override
    public int getScreenshotCounter() {
        return this.screenshotCounter;
    }

    static {
        SUPPORTED_VERSIONS = new short[]{11};
    }
}

