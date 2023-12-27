/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi;

import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;
import de.vw.mib.asl.framework.api.persistence2.dsi.DsiAwareProfileChangeListener;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.DsiAwareProfileChangeListenerAdapter;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.DsiAwareProfileChangeListenerFactory;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServices;

public class DsiAwareProfileChangeListenerFactoryImpl
implements DsiAwareProfileChangeListenerFactory {
    private final PersistenceServices services;

    public DsiAwareProfileChangeListenerFactoryImpl(PersistenceServices persistenceServices) {
        this.services = persistenceServices;
    }

    @Override
    public ProfileChangeListener createProfileChangeListener(PersistenceModule persistenceModule, DsiAwareProfileChangeListener dsiAwareProfileChangeListener) {
        return new DsiAwareProfileChangeListenerAdapter(dsiAwareProfileChangeListener, persistenceModule, this.services);
    }
}

