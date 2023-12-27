/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.waitaphore;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.hmi.internal.ServiceManagerCommon;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.sm.internal.ServiceManagerStatemachine;
import de.vw.mib.sm.internal.waitaphore.WaitaphoreObserver;

public class Waitaphore
implements WaitaphoreObserver {
    private static final int NOT_ID;
    private final AppDefinition appInstance;
    private int waitPropertyId = -1;
    private int waitAslListId = -1;
    private int waitAppAdapterListId = -1;
    private int waitPopupId = -1;
    private int waitPopupInfoId = -1;
    private int waitSucceededEventId = -1;
    private int waitFailedEventId = -1;
    private int openPopupId = -1;
    private int openPopupInfoId = -1;

    public Waitaphore(AppDefinition appDefinition) {
        this.appInstance = appDefinition;
    }

    public void enterForProperty(int n, int n2, int n3, int n4, int n5) {
        this.waitPropertyId = n;
        this.waitAslListId = -1;
        this.waitAppAdapterListId = -1;
        this.waitPopupId = n2;
        this.waitPopupInfoId = n3;
        this.waitSucceededEventId = n4;
        this.waitFailedEventId = n5;
        ServiceManagerStatemachine.waitaphoreWatcher.enterPropertyWaitaphore(n, this);
    }

    public void enterForAslList(int n, int n2, int n3, int n4, int n5) {
        this.waitPropertyId = -1;
        this.waitAslListId = n;
        this.waitAppAdapterListId = -1;
        this.waitPopupId = n2;
        this.waitPopupInfoId = n3;
        this.waitSucceededEventId = n4;
        this.waitFailedEventId = n5;
        Logger logger = ServiceManagerCommon.loggerFactory.getLogger(0x800000);
        logger.error(1, "Waiting for ASL list not supported yet. Please ask Framework for implementing wait for ASL list.");
        this.errorTimeout();
    }

    public void enterForAppAdapterList(int n, int n2, int n3, int n4, int n5) {
        this.waitPropertyId = -1;
        this.waitAslListId = -1;
        this.waitAppAdapterListId = n;
        this.waitPopupId = n2;
        this.waitPopupInfoId = n3;
        this.waitSucceededEventId = n4;
        this.waitFailedEventId = n5;
        Logger logger = ServiceManagerCommon.loggerFactory.getLogger(0x800000);
        logger.error(1, "Waiting for AppAdapter list not supported yet. Please ask Framework for implementing wait for AppAdapter list.");
        this.errorTimeout();
    }

    public void enterForNothing(int n) {
        this.waitPropertyId = -1;
        this.waitAslListId = -1;
        this.waitAppAdapterListId = -1;
        this.waitPopupId = -1;
        this.waitPopupInfoId = -1;
        this.waitSucceededEventId = n;
        this.waitFailedEventId = -1;
        Logger logger = ServiceManagerCommon.loggerFactory.getLogger(0x800000);
        logger.error(1, "Waiting for Nothing could be a problem.");
        this.response();
    }

    public void leave() {
        if (this.waitPropertyId != -1) {
            ServiceManagerStatemachine.waitaphoreWatcher.leavePropertyWaitaphore(this.waitPropertyId, this);
            this.waitPropertyId = -1;
        }
        if (this.waitAslListId != -1) {
            this.waitAslListId = -1;
        }
        if (this.waitAppAdapterListId != -1) {
            this.waitAppAdapterListId = -1;
        }
    }

    @Override
    public void waitTimeout() {
        if (this.openPopupId != this.waitPopupId) {
            this.closeWaitPopup();
            this.openPopupId = this.waitPopupId;
            this.openPopupInfoId = this.waitPopupInfoId;
            ServiceManagerCommon.statemachineEventDispatcher.createAndSubmitDynamicStateEvent(this.openPopupId, 0, this.openPopupInfoId);
        }
    }

    @Override
    public void errorTimeout() {
        ServiceManagerCommon.statemachineEventDispatcher.createAndSubmitHMIEvent(this.appInstance, this.appInstance, this.waitFailedEventId);
    }

    @Override
    public void response() {
        ServiceManagerCommon.statemachineEventDispatcher.createAndSubmitHMIEvent(this.appInstance, this.appInstance, this.waitSucceededEventId);
    }

    public void closeWaitPopup() {
        if (this.openPopupId != -1) {
            ServiceManagerCommon.statemachineEventDispatcher.createAndSubmitDynamicStateEvent(this.openPopupId, 1, this.openPopupInfoId);
            this.openPopupId = -1;
            this.openPopupInfoId = -1;
        }
    }
}

