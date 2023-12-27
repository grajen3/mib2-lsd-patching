/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio;

import de.vw.mib.asl.framework.api.persistence2.dsi.DsiAwareProfileChangeListener;
import de.vw.mib.asl.framework.api.persistence2.dsi.DsiAwareProfileChangeListenerCallback;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.AdapterAslPersistence;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.util.RadioSystemEventsUtil;

class AdapterAslPersistence$1
implements DsiAwareProfileChangeListener {
    private final /* synthetic */ AdapterAslPersistence this$0;

    AdapterAslPersistence$1(AdapterAslPersistence adapterAslPersistence) {
        this.this$0 = adapterAslPersistence;
    }

    @Override
    public void prepareForProfileChange(DsiAwareProfileChangeListenerCallback dsiAwareProfileChangeListenerCallback) {
        try {
            ServiceManager.logger.info(128).append("AdapterAslPersistence - prepareForProfileChange()").log();
            this.this$0.setDsiAwareProfileChangeListenerCallback(dsiAwareProfileChangeListenerCallback);
            this.this$0.setProfileChangeStarted(true);
            this.this$0.resetLoadedPersistenceAndAnswerCallBack();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public void changeProfilePreDsi(DsiAwareProfileChangeListenerCallback dsiAwareProfileChangeListenerCallback) {
        try {
            ServiceManager.logger.info(128).append("AdapterAslPersistence - changeProfilePreDsi()").log();
            if (null != dsiAwareProfileChangeListenerCallback) {
                dsiAwareProfileChangeListenerCallback.notifyTaskDone(true);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public void changeProfilePostDsi(DsiAwareProfileChangeListenerCallback dsiAwareProfileChangeListenerCallback) {
        try {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.info(128).append("AdapterAslPersistence - changeProfilePostDsi()").log();
            }
            if (null != RadioData.targetRadioData) {
                RadioData.targetRadioData.retriggerOrStartTimer(-1484324608, (long)0, false);
            }
            this.this$0.handleUserProfileChangedEvent();
            this.this$0.postActionAfterNewUser();
            this.this$0.setProfileChangeStarted(false);
            RadioSystemEventsUtil.sendReturnToMain();
            if (null != dsiAwareProfileChangeListenerCallback) {
                dsiAwareProfileChangeListenerCallback.notifyTaskDone(true);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}

