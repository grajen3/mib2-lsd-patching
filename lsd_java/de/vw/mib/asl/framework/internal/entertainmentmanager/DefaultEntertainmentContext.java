/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.entertainmentmanager;

import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentContext;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public class DefaultEntertainmentContext
implements EntertainmentContext {
    private final int contextId;
    private final int targetId;
    private final boolean deactivateOnSubcontextSwitch;
    private final int datapoolValue;
    private final int viewChangeEvent;

    public DefaultEntertainmentContext(int n, int n2, boolean bl, int n3, int n4) {
        this.contextId = n;
        this.targetId = n2;
        this.deactivateOnSubcontextSwitch = bl;
        this.datapoolValue = n3;
        this.viewChangeEvent = n4;
    }

    @Override
    public int contextId() {
        return this.contextId;
    }

    @Override
    public boolean preActivate(int n, boolean bl) {
        return true;
    }

    @Override
    public int answer(int n) {
        return n;
    }

    @Override
    public int skipSources(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int targetId() {
        return this.targetId;
    }

    @Override
    public boolean isDeactivateOnSubcontextSwitch() {
        return this.deactivateOnSubcontextSwitch;
    }

    @Override
    public void changeView() {
        if (this.viewChangeEvent != -1) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(this.viewChangeEvent);
        }
    }

    @Override
    public void setDatapoolValue(int n) {
        if (this.datapoolValue != -1) {
            try {
                ServiceManager.aslPropertyManager.valueChangedInteger(this.datapoolValue, n);
            }
            catch (Exception exception) {
                ServiceManager.logger2.error(16, "Unexpected Exception in valueChangedInteger", exception);
            }
        }
    }
}

