/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util.personalization;

import de.vw.mib.asl.framework.api.persistence2.dsi.DsiAwareProfileChangeListener;
import de.vw.mib.asl.framework.api.persistence2.dsi.DsiAwareProfileChangeListenerCallback;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public abstract class AbstractDsiAwareProfileChangeHandler
implements DsiAwareProfileChangeListener {
    private DsiAwareProfileChangeListenerCallback callback;
    private String currentRunningCall = "";

    @Override
    public void prepareForProfileChange(DsiAwareProfileChangeListenerCallback dsiAwareProfileChangeListenerCallback) {
        this.callback = dsiAwareProfileChangeListenerCallback;
        this.currentRunningCall = "prepareForProfileChange";
        this.prepareForProfileChange();
    }

    @Override
    public void changeProfilePreDsi(DsiAwareProfileChangeListenerCallback dsiAwareProfileChangeListenerCallback) {
        this.callback = dsiAwareProfileChangeListenerCallback;
        this.currentRunningCall = "changeProfilePreDsi";
        this.changeProfilePreDsi();
    }

    @Override
    public void changeProfilePostDsi(DsiAwareProfileChangeListenerCallback dsiAwareProfileChangeListenerCallback) {
        this.callback = dsiAwareProfileChangeListenerCallback;
        this.currentRunningCall = "changeProfilePostDsi";
        this.changeProfilePostDsi();
    }

    public void notifyTaskDone(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            ServiceManager.logger.trace(16384, new StringBuffer().append("[AbstractDsiAwareProfileChangeHandler] notifyTaskDone for ").append(this.currentRunningCall).toString());
        }
        this.callback.notifyTaskDone(bl);
    }

    protected abstract void prepareForProfileChange() {
    }

    protected abstract void changeProfilePreDsi() {
    }

    protected abstract void changeProfilePostDsi() {
    }
}

