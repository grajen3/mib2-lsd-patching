/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi;

import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;
import de.vw.mib.asl.framework.api.persistence2.dsi.DsiAwareProfileChangeListener;

public interface DsiAwareProfileChangeListenerFactory {
    default public ProfileChangeListener createProfileChangeListener(PersistenceModule persistenceModule, DsiAwareProfileChangeListener dsiAwareProfileChangeListener) {
    }
}

