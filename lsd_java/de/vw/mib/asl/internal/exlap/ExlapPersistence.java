/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exlap;

import de.vw.mib.asl.framework.api.persistence.AbstractSharedPersistable;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public class ExlapPersistence
extends AbstractSharedPersistable {
    private static final short VERSION;
    private static final short[] SUPPORTED_VERSIONS;
    private boolean externalAppsUserSettingEnabled = true;
    private int rseUserSetting = ServiceManager.configManagerDiag.isFeatureFlagSet(353) ? 2 : 1;

    public ExlapPersistence() {
        super(5025, 0);
    }

    @Override
    public void fromStreamInternal(PersistenceInputStream persistenceInputStream, short s) {
        this.setExternalAppsUserSettingEnabled(persistenceInputStream.readBoolean());
        this.setRseUserSetting(persistenceInputStream.readInt());
    }

    @Override
    public void toStreamInternal(PersistenceOutputStream persistenceOutputStream) {
        persistenceOutputStream.writeBoolean(this.isExternalAppsUserSettingEnabled());
        persistenceOutputStream.writeInt(this.getRseUserSetting());
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
        return 1;
    }

    @Override
    public void clear() {
        this.setExternalAppsUserSettingEnabled(true);
        this.setRseUserSetting(ServiceManager.configManagerDiag.isFeatureFlagSet(353) ? 2 : 1);
    }

    public int getRseUserSetting() {
        return this.rseUserSetting;
    }

    public void setRseUserSetting(int n) {
        this.rseUserSetting = n;
        this.markDirty(true);
    }

    public boolean isExternalAppsUserSettingEnabled() {
        return this.externalAppsUserSettingEnabled;
    }

    public void setExternalAppsUserSettingEnabled(boolean bl) {
        this.externalAppsUserSettingEnabled = bl;
        this.markDirty(true);
    }

    static {
        SUPPORTED_VERSIONS = new short[]{1};
    }
}

