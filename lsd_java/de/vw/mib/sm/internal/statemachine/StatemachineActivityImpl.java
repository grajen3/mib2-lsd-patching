/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.statemachine;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.modelapi.ModelApiDownEvent;
import de.vw.mib.modelapi.ui.ModelApiDownEventService;
import de.vw.mib.sm.AppHmiEnvironment;
import de.vw.mib.sm.internal.ServiceManagerStatemachine;
import de.vw.mib.sm.internal.statemachine.StatemachineActivity;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;

public class StatemachineActivityImpl
implements StatemachineActivity {
    protected final TopStatemachine topStatemachine;
    protected final int S_OFFSET;
    protected final int IT_OFFSET;
    protected final int TT_OFFSET;
    protected final int UT_OFFSET;

    protected StatemachineActivityImpl(TopStatemachine topStatemachine, int n, int n2, int n3, int n4) {
        this.topStatemachine = topStatemachine;
        this.S_OFFSET = n;
        this.IT_OFFSET = n2;
        this.TT_OFFSET = n3;
        this.UT_OFFSET = n4;
    }

    protected final AppHmiEnvironment getEnvironment() {
        return this.topStatemachine.getEnvironment();
    }

    protected final AppDefinition fromMe() {
        return this.topStatemachine.getEnvironment().getAppInstance();
    }

    protected final AppDefinition meSelf() {
        return this.topStatemachine.getEnvironment().getAppInstance();
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
    }

    @Override
    public void performStateExitAction(int n) {
    }

    @Override
    public void performStateFocusGainedAction(int n) {
    }

    @Override
    public void performStateFocusLostAction(int n) {
    }

    @Override
    public boolean evalInternalTransitionGuard(int n) {
        return true;
    }

    @Override
    public void performInternalTransitionAction(int n) {
    }

    @Override
    public boolean evalTriggeredTransitionGuard(int n) {
        return true;
    }

    @Override
    public void performTriggeredTransitionAction(int n) {
    }

    @Override
    public boolean evalUntriggeredTransitionGuard(int n) {
        return true;
    }

    @Override
    public void performUntriggeredTransitionAction(int n) {
    }

    protected void enterWaitaphoreForProperty(int n, int n2, int n3, int n4, int n5) {
        this.topStatemachine.enterWaitaphoreForProperty(n, n2, n3, n4, n5);
    }

    protected void enterWaitaphoreForAslList(int n, int n2, int n3, int n4, int n5) {
        this.topStatemachine.enterWaitaphoreForAslList(n, n2, n3, n4, n5);
    }

    protected void enterWaitaphoreForAppAdapterList(int n, int n2, int n3, int n4, int n5) {
        this.topStatemachine.enterWaitaphoreForAppAdapterList(n, n2, n3, n4, n5);
    }

    protected void enterWaitaphoreForNothing(int n) {
        this.topStatemachine.enterWaitaphoreForNothing(n);
    }

    protected final void leaveWaitaphore() {
        this.topStatemachine.leaveWaitaphore();
    }

    protected static void lockWaitaphore(int n, int n2) {
        ServiceManagerStatemachine.waitaphoreWatcher.lockWaitaphore(n, n2);
    }

    protected final void showView(String string, boolean bl, int n) {
        ServiceManagerStatemachine.statemachineManager.setActiveStatemachine(this.topStatemachine.getId());
        this.getEnvironment().showView(this.getLayerLabel(), string, bl, n);
    }

    protected final void hideView(String string) {
        this.getEnvironment().hideView(this.getLayerLabel(), string);
    }

    protected final void requestVisibility() {
        this.getEnvironment().requestVisibility(this.getLayerLabel());
    }

    protected ModelApiDownEvent createModelApiDownEvent(int n) {
        AppHmiEnvironment appHmiEnvironment = this.getEnvironment();
        ModelApiDownEventService modelApiDownEventService = appHmiEnvironment.getModelApiDownEventService();
        return modelApiDownEventService.createEvent(n);
    }

    protected void fireModelApiDownEvent(ModelApiDownEvent modelApiDownEvent) {
        AppHmiEnvironment appHmiEnvironment = this.getEnvironment();
        ModelApiDownEventService modelApiDownEventService = appHmiEnvironment.getModelApiDownEventService();
        modelApiDownEventService.sendEvent(modelApiDownEvent);
    }

    private String getLayerLabel() {
        return this.topStatemachine.getLayerLabel();
    }

    protected final void leaveIncludeDdpGroup() {
        this.topStatemachine.leaveIncludeDdpGroup();
    }

    protected final void enterIncludeDdpGroup(int n) {
        this.topStatemachine.enterIncludeDdpGroup(n);
    }

    protected final int getIncludeDdpGroupId() {
        return this.topStatemachine.getIncludeDdpGroupId();
    }
}

