/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.common;

import de.vw.mib.asl.internal.media.common.AbstractComponent;
import de.vw.mib.asl.internal.media.common.ResponseHandler;

public abstract class AbstractComponentRequest {
    private final AbstractComponent mComponent;
    private final int mRequestId;

    public AbstractComponentRequest(AbstractComponent abstractComponent) {
        this.mComponent = abstractComponent;
        this.mRequestId = AbstractComponent.assignRequestId();
    }

    public AbstractComponent getComponent() {
        return this.mComponent;
    }

    public boolean registerForResponse(ResponseHandler responseHandler) {
        return this.mComponent.registerForResponse(this.mRequestId, responseHandler);
    }

    public void fireResponse(boolean bl) {
        this.mComponent.fireResponse(bl);
    }

    public void fireResponse(boolean bl, int n) {
        this.mComponent.fireResponse(bl, n);
    }

    public void fireResponse(boolean bl, String string) {
        this.mComponent.fireResponse(bl, string);
    }

    protected void fireResponse(boolean bl, int n, String string) {
        this.mComponent.fireResponse(bl, n, string);
    }

    public boolean isRegisteredForResponse() {
        return this.mComponent.isRegisteredForResponse(this.mRequestId);
    }

    public String toString() {
        return new StringBuffer().append(this.mComponent.toString()).append(" ").append(super.getClass().getName()).toString();
    }
}

