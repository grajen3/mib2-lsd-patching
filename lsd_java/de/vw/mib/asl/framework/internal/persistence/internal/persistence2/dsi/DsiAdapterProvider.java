/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi;

import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.api.persistence2.dsi.AbstractPersonalizedAppDsiAdapter;
import de.vw.mib.asl.framework.api.persistence2.dsi.PersonalizedAppListener;
import java.util.List;

public interface DsiAdapterProvider {
    default public void addDsiListener(AbstractPersonalizedAppDsiAdapter abstractPersonalizedAppDsiAdapter, PersonalizedAppListener personalizedAppListener) {
    }

    default public List getAllDsiAdapters() {
    }

    default public List getDsiAdapters(PersistenceModule persistenceModule) {
    }

    default public boolean hasRegisteredDsiAdapters(PersistenceModule persistenceModule) {
    }

    default public void registerDsiAdapter(PersistenceModule persistenceModule, AbstractPersonalizedAppDsiAdapter abstractPersonalizedAppDsiAdapter) {
    }

    default public void removeDsiListener(AbstractPersonalizedAppDsiAdapter abstractPersonalizedAppDsiAdapter, PersonalizedAppListener personalizedAppListener) {
    }

    default public List filterUnregisteredDsis(List list) {
    }
}

