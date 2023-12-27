/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.api.persistence2.dsi.AbstractPersonalizedAppDsiAdapter;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.DsiStateMachine;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServices;

class DsiReadyForProfileChangesObserver$StateMachineFactory {
    DsiReadyForProfileChangesObserver$StateMachineFactory() {
    }

    DsiStateMachine create(PersistenceServices persistenceServices, AbstractPersonalizedAppDsiAdapter abstractPersonalizedAppDsiAdapter) {
        return new DsiStateMachine(persistenceServices, abstractPersonalizedAppDsiAdapter);
    }
}

