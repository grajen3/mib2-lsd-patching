/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.impl;

import de.vw.mib.asl.clientapi.ASLClientAPIResponse;
import de.vw.mib.asl.clientapi.impl.ASLClientAPIBridge$RequestsBridgeBase;

public class ASLClientAPIBridge$RequestsBridgeBase$ResponseProxyBase
implements ASLClientAPIResponse {
    private final long callId;
    private boolean valid = true;
    private final /* synthetic */ ASLClientAPIBridge$RequestsBridgeBase this$0;

    protected ASLClientAPIBridge$RequestsBridgeBase$ResponseProxyBase(ASLClientAPIBridge$RequestsBridgeBase aSLClientAPIBridge$RequestsBridgeBase, long l) {
        this.this$0 = aSLClientAPIBridge$RequestsBridgeBase;
        this.callId = l;
    }

    @Override
    public void _finished(int n) {
        if (this.valid) {
            this.valid = false;
            this.this$0._handleResponseFinished(this.callId, n);
        }
    }

    protected boolean _isValid() {
        return this.valid;
    }

    long _getCallId() {
        return this.callId;
    }

    void _invalidate() {
        this.valid = false;
    }
}

