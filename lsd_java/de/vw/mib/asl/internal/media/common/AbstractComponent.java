/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.common;

import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.media.common.AbstractComponent$1;
import de.vw.mib.asl.internal.media.common.MediaTimer;
import de.vw.mib.asl.internal.media.common.ResponseHandler;
import de.vw.mib.genericevents.GenericEvents;

public abstract class AbstractComponent
extends AbstractASLTarget {
    private ResponseHandler mResponseHandler = null;
    private int mResponseType = -1;
    private final MediaTimer mResponseTimer = new MediaTimer(new AbstractComponent$1(this), "responseTimeout");
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
        return this.registerForResponse(n, 0, responseHandler);
    }

    public boolean registerForResponse(int n, int n2, ResponseHandler responseHandler) {
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
            this.mResponseTimer.stop();
            if (n2 >= 0) {
                this.mResponseTimer.setTimeout(n2);
                this.mResponseTimer.start();
            }
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
            this.mResponseTimer.stop();
            responseHandler.handleResponse(bl ? 1 : 2, string);
        }
    }

    public boolean isRegisteredForResponse(int n) {
        return this.mResponseHandler != null && this.mResponseHandler.isValid() && this.mResponseType == n;
    }

    @Override
    public String toString() {
        return new StringBuffer().append(super.toString()).append(" ").append(super.getClass().getName()).toString();
    }

    static /* synthetic */ int access$000(AbstractComponent abstractComponent) {
        return abstractComponent.mResponseType;
    }
}

