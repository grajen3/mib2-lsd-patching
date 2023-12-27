/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller;

import de.vw.mib.asl.internal.speechphone.communication.phone.PhoneHandler;
import de.vw.mib.asl.internal.speechphone.controller.AbstractCombinedAction;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;

public abstract class AbstractCheckedPhoneAction
extends AbstractCombinedAction {
    private final int usecaseId;
    protected final PhoneHandler phoneHandler;
    protected final ServiceFunctions serviceFunctions;

    public AbstractCheckedPhoneAction(ServiceFunctions serviceFunctions, int n, PhoneHandler phoneHandler) {
        this.serviceFunctions = serviceFunctions;
        this.usecaseId = n;
        this.phoneHandler = phoneHandler;
    }

    @Override
    protected void onAction(int n) {
        if (this.phoneHandler.isPhoneAvailable(this.usecaseId)) {
            this.reactOnRequest(n);
        }
    }

    protected abstract void reactOnRequest(int n) {
    }
}

