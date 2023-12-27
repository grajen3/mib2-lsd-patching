/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.persistence;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.tvtuner.persistence.TVTunerPersistable;
import de.vw.mib.asl.internal.tvtuner.persistence.TVTunerPresetsPersistable;

public class TVTunerDB {
    private TVTunerPresetsPersistable tvPresetPersistable = new TVTunerPresetsPersistable();
    private TVTunerPersistable tvPersistable = new TVTunerPersistable();

    public void initPresetsFromPersistence() {
        ServiceManager.persistence.registerSharedPersistable(this.tvPresetPersistable);
        ServiceManager.persistence.loadPersistable(5014, 0, this.tvPresetPersistable);
    }

    public void initSettingsPersistence() {
        ServiceManager.persistence.registerSharedPersistable(this.tvPersistable);
        ServiceManager.persistence.loadPersistable(5014, 0, this.tvPersistable);
    }

    public TVTunerPresetsPersistable getTvPresetPersistable() {
        return this.tvPresetPersistable;
    }

    public TVTunerPersistable getTvPersistable() {
        return this.tvPersistable;
    }
}

