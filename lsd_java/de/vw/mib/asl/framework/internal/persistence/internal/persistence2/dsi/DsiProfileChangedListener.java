/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi;

import de.vw.mib.asl.framework.api.persistence2.dsi.AbstractPersonalizedAppDsiAdapter;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistableService;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.DsiAwareProfileChangeListenerAdapter;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.PersonalizedAppAdapter;
import de.vw.mib.log4mib.Logger;

class DsiProfileChangedListener
extends PersonalizedAppAdapter {
    static final int UNKNOWN_PROFILE;
    private final DsiAwareProfileChangeListenerAdapter adapter;
    private final String dsiIdentifier;
    private final Logger logger;
    private final PersistableService persistableService;
    private final AbstractPersonalizedAppDsiAdapter dsiAdapter;

    DsiProfileChangedListener(DsiAwareProfileChangeListenerAdapter dsiAwareProfileChangeListenerAdapter, PersistableService persistableService, Logger logger, String string, AbstractPersonalizedAppDsiAdapter abstractPersonalizedAppDsiAdapter) {
        this.adapter = dsiAwareProfileChangeListenerAdapter;
        this.persistableService = persistableService;
        this.logger = logger;
        this.dsiIdentifier = string;
        this.dsiAdapter = abstractPersonalizedAppDsiAdapter;
    }

    @Override
    public void profileChanged(int n, int n2) {
        if (n2 != 0) {
            this.logger.warn(32, new StringBuffer().append("[DsiProfileChangedListener] DSI >").append(this.dsiIdentifier).append("< profile change for profile >").append(n).append("< returned unsuccessful with state: ").append(n2).toString());
        }
        this.adapter.notifyDsiAnswer(n, 1, this.dsiAdapter);
    }

    @Override
    public void profileReset(int n, int n2) {
        if (n2 != 0) {
            this.logger.warn(32, new StringBuffer().append("[DsiProfileChangedListener] DSI >").append(this.dsiIdentifier).append("< profile reset for profile >").append(n).append("< returned unsuccessful with state: ").append(n2).toString());
        }
        if (n == this.persistableService.getActiveProfile()) {
            this.adapter.notifyDsiAnswer(n, 2, this.dsiAdapter);
        }
    }

    @Override
    public void profileResetAll(int n) {
        if (n != 0) {
            this.logger.warn(32, new StringBuffer().append("[DsiProfileChangedListener] DSI >").append(this.dsiIdentifier).append("< profile reset all returned unsuccessful with state: ").append(n).toString());
        }
        this.adapter.notifyDsiAnswer(-1, 3, this.dsiAdapter);
    }
}

