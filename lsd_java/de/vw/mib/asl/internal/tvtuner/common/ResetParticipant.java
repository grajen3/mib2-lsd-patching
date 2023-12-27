/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.common;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetParticipant;
import de.vw.mib.asl.internal.tvtuner.accessor.TVTunerObjectAccessor;
import de.vw.mib.asl.internal.tvtuner.common.TVTunerHelper;

public class ResetParticipant
implements FactoryResetParticipant {
    private FactoryResetCallback callback = null;
    private int resetState = 0;
    private boolean notificationPending = false;

    public ResetParticipant() {
        if (ASLSystemFactory.getSystemApi().getFactoryResetService().getFactoryResetState() == 1) {
            ASLSystemFactory.getSystemApi().getFactoryResetService().addParticipant(this, FactoryResetComponents.TVTUNER);
        }
    }

    public void notifyResetParticipant() {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("ResetParticipant#notifyResetParticipant called");
        }
        if (this.isNotificationPending()) {
            this.setNotificationPending(false);
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace("ResetParticipant#notifyResetParticipant called - Callback will be notified");
            }
            this.getCallback().notifyResetDone();
        }
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("ResetParticipant#reset called");
        }
        this.setCallback(factoryResetCallback);
        this.setResetState(1);
        TVTunerObjectAccessor.getPresetListHandler().deleteAllPresets();
        TVTunerObjectAccessor.getTvTunerDB().getTvPersistable().clear();
        TVTunerObjectAccessor.getTvTunerDB().getTvPersistable().updateModelSettings();
        if (TVTunerObjectAccessor.getTargetTVTunerDSI().getTunerActiveState() == 1) {
            if (TVTunerObjectAccessor.getTargetTVTunerDSI().getTunerWaitState() == 1) {
                TVTunerObjectAccessor.getTvTunerDB().getTvPersistable().updateTunerSettings(true);
                this.setResetState(0);
                if (TVTunerHelper.isTraceEnabled()) {
                    TVTunerHelper.trace("ResetParticipant#reset called - ACTIVE and NOT_WAITING - reset done");
                }
            } else {
                TVTunerObjectAccessor.getTvAvSourceHandler().wakeUpTuner(true);
                if (TVTunerHelper.isTraceEnabled()) {
                    TVTunerHelper.trace("ResetParticipant#reset called - ACTIVE and WAITING - wake up");
                }
            }
        } else {
            this.setResetState(2);
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace("ResetParticipant#reset called - INACTIVE - reset pending");
            }
        }
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("ResetParticipant#reset called - markDirty");
        }
        TVTunerObjectAccessor.getTvTunerDB().getTvPersistable().markDirty(true);
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    public FactoryResetCallback getCallback() {
        return this.callback;
    }

    public void setCallback(FactoryResetCallback factoryResetCallback) {
        this.callback = factoryResetCallback;
    }

    private boolean isNotificationPending() {
        return this.notificationPending;
    }

    private void setNotificationPending(boolean bl) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("ResetParticipant#setNotificationPending called - notificationPending = ").append(bl).toString());
        }
        this.notificationPending = bl;
    }

    public int getResetState() {
        return this.resetState;
    }

    public void setResetState(int n) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("ResetParticipant#setResetState called - resetState = ").append(n).toString());
        }
        if (this.resetState == 1 && this.resetState != n) {
            this.setNotificationPending(true);
        }
        this.resetState = n;
    }
}

