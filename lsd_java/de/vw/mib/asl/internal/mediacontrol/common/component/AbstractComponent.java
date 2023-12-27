/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.common.component;

import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.mediacontrol.common.component.ResponseHandler;
import de.vw.mib.genericevents.GenericEvents;

public abstract class AbstractComponent
extends AbstractASLTarget {
    private ResponseHandler mResponseHandler = null;
    private int mResponseType = -1;
    private static int mRequestId = 0;

    public abstract int getComponentId() {
    }

    public AbstractComponent(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    protected static int assignRequestId() {
        return mRequestId++;
    }

    public boolean registerForResponse(int n, ResponseHandler responseHandler) {
        if (this.mResponseHandler != null) {
            this.mResponseHandler.handleResponse(-1, new StringBuffer().append(this.mResponseHandler).append("(responseType: ").append(this.mResponseType).append(") aborted by new request from : ").append(responseHandler).append("(responseType: ").append(n).append(")").toString());
        }
        if (responseHandler != null) {
            if (n < 0) {
                this.error("MediaComponent ~ registerForResponse() failed: invalid responseType");
                return false;
            }
            this.mResponseHandler = responseHandler;
            this.mResponseType = n;
            return true;
        }
        this.mResponseHandler = null;
        this.mResponseType = -1;
        return true;
    }

    public void fireResponse(boolean bl) {
        this.fireResponse(bl, null);
    }

    public void fireResponse(boolean bl, int n) {
        this.fireResponse(bl, n, null);
    }

    public void fireResponse(boolean bl, String string) {
        this.fireResponse(bl, this.mResponseType, string);
    }

    protected void fireResponse(boolean bl, int n, String string) {
        if (this.isRegisteredForResponse(n)) {
            ResponseHandler responseHandler = this.mResponseHandler;
            this.mResponseHandler = null;
            this.mResponseType = -1;
            responseHandler.handleResponse(bl ? 1 : 2, string);
        }
    }

    public boolean isRegisteredForResponse(int n) {
        return this.mResponseHandler != null && !this.mResponseHandler.isTimedOut() && this.mResponseType == n;
    }

    @Override
    public String toString() {
        return new StringBuffer().append(super.toString()).append(" ").append(super.getClass().getName()).toString();
    }
}

