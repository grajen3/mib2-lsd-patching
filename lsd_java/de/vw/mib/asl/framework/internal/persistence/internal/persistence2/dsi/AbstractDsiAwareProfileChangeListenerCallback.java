/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi;

import de.vw.mib.asl.framework.api.persistence2.dsi.DsiAwareProfileChangeListenerCallback;
import de.vw.mib.log4mib.Logger;

public abstract class AbstractDsiAwareProfileChangeListenerCallback
implements DsiAwareProfileChangeListenerCallback {
    private static final String LOG_DELIM;
    private final Logger logger;
    private boolean executed;
    private final String callbackIdentifier;

    AbstractDsiAwareProfileChangeListenerCallback(Logger logger, String string) {
        this.logger = logger;
        this.callbackIdentifier = string;
    }

    @Override
    public final void notifyTaskDone(boolean bl) {
        if (this.executed) {
            this.logger.warn(32, new StringBuffer().append("[AbstractDsiAwareProfileChangeListenerCallback] Unexpected duplicate callback recieved: >").append(this.callbackIdentifier).append("<.").toString());
        } else {
            this.executed = true;
            if (this.logger.isTraceEnabled(32)) {
                this.logger.trace(32, new StringBuffer().append("[AbstractDsiAwareProfileChangeListenerCallback] ").append(this.callbackIdentifier).append(" finished with callback.").toString());
            }
            this.processCallbackTask(bl);
        }
    }

    protected abstract void processCallbackTask(boolean bl) {
    }
}

