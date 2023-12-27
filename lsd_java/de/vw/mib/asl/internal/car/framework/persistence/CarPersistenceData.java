/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.framework.persistence;

import de.vw.mib.asl.framework.api.persistence.AbstractSharedPersistable;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.framework.persistence.RecuperationData;

public final class CarPersistenceData
extends AbstractSharedPersistable {
    private static final short VERSION_ONE;
    private static final short VERSION_TWO;
    private static final short[] SUPPORTED_VERSIONS;
    private static CarPersistenceData _persistenceService;
    private RecuperationData _recuperationData = new RecuperationData();

    private CarPersistenceData() {
        super(5021, 0);
    }

    public static CarPersistenceData getPersistenceService() {
        if (_persistenceService == null) {
            _persistenceService = new CarPersistenceData();
            ServiceManager.persistence.registerSharedPersistable(_persistenceService);
            ServiceManager.persistence.loadPersistable(_persistenceService.getNamespace(), _persistenceService.getKey(), _persistenceService);
        }
        return _persistenceService;
    }

    private RecuperationData getRecuperationData() {
        return this._recuperationData;
    }

    public int[] getRecuperationValues() {
        return this.getRecuperationData().getData();
    }

    public void addRecuperationValue(int n) {
        this.getRecuperationData().addValue(n);
        this.markDirty(true);
    }

    @Override
    public void fromStreamInternal(PersistenceInputStream persistenceInputStream, short s) {
        this.getRecuperationData().fromStream(persistenceInputStream);
    }

    @Override
    public void toStreamInternal(PersistenceOutputStream persistenceOutputStream) {
        this.getRecuperationData().toStream(persistenceOutputStream);
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

    @Override
    public void clear() {
        this.getRecuperationData().clear();
    }

    public void resetData() {
        this.getRecuperationData().clear();
        this.markDirty(true);
    }

    static {
        SUPPORTED_VERSIONS = new short[]{1, 2};
    }
}

