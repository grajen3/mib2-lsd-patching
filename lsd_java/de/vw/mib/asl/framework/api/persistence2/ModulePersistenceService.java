/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence2;

import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;
import de.vw.mib.asl.framework.api.persistence2.dsi.DsiAwareProfileChangeListener;

public interface ModulePersistenceService {
    default public void addProfileChangeListener(ProfileChangeListener profileChangeListener) {
    }

    default public void removeProfileChangeListener(ProfileChangeListener profileChangeListener) {
    }

    default public void addProfileChangeListener(DsiAwareProfileChangeListener dsiAwareProfileChangeListener) {
    }

    default public void removeProfileChangeListener(DsiAwareProfileChangeListener dsiAwareProfileChangeListener) {
    }
}

