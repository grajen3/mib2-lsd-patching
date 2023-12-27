/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.impl;

import de.vw.mib.asl.clientapi.ASLClientAPIResponse;
import de.vw.mib.pool.PoorMansPool;

class ASLClientAPIBridge$RequestsBridgeBase$Invocation {
    private static int MAX_POOL_SIZE = 30;
    private static PoorMansPool POOL = new PoorMansPool("ASLClientAPIRequests.Invocation", MAX_POOL_SIZE);
    private static long nextCallId = 0L;
    private long callId;
    private ASLClientAPIResponse response;
    private int requestId;
    private Object[] arguments;
    private int ttl;
    private ASLClientAPIBridge$RequestsBridgeBase$Invocation next;

    private static synchronized long getNextCallId() {
        long l = nextCallId;
        long l2 = l;
        nextCallId = l + 1L;
    }

    private ASLClientAPIBridge$RequestsBridgeBase$Invocation() {
    }

    private static ASLClientAPIBridge$RequestsBridgeBase$Invocation borrow() {
        ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation = (ASLClientAPIBridge$RequestsBridgeBase$Invocation)POOL.borrow();
        if (null == aSLClientAPIBridge$RequestsBridgeBase$Invocation) {
            aSLClientAPIBridge$RequestsBridgeBase$Invocation = new ASLClientAPIBridge$RequestsBridgeBase$Invocation();
        }
        return aSLClientAPIBridge$RequestsBridgeBase$Invocation;
    }

    static ASLClientAPIBridge$RequestsBridgeBase$Invocation create(ASLClientAPIResponse aSLClientAPIResponse, int n, Object[] objectArray) {
        ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation = ASLClientAPIBridge$RequestsBridgeBase$Invocation.borrow();
        aSLClientAPIBridge$RequestsBridgeBase$Invocation.callId = ASLClientAPIBridge$RequestsBridgeBase$Invocation.getNextCallId();
        aSLClientAPIBridge$RequestsBridgeBase$Invocation.response = aSLClientAPIResponse;
        aSLClientAPIBridge$RequestsBridgeBase$Invocation.requestId = n;
        aSLClientAPIBridge$RequestsBridgeBase$Invocation.arguments = objectArray;
        aSLClientAPIBridge$RequestsBridgeBase$Invocation.ttl = 0;
        return aSLClientAPIBridge$RequestsBridgeBase$Invocation;
    }

    public long getCallId() {
        return this.callId;
    }

    public ASLClientAPIResponse getResponse() {
        return this.response;
    }

    public int getRequestId() {
        return this.requestId;
    }

    public Object[] getArguments() {
        return this.arguments;
    }

    boolean decreaseTTL(int n) {
        return 0 == this.ttl || 0 == (this.ttl = Math.max(0, this.ttl - n));
    }

    ASLClientAPIBridge$RequestsBridgeBase$Invocation getNext() {
        return this.next;
    }

    void setNext(ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation) {
        this.next = aSLClientAPIBridge$RequestsBridgeBase$Invocation;
    }

    void setTTL(int n) {
        this.ttl = n;
    }

    public void release() {
        this.response = null;
        this.requestId = 0;
        this.arguments = null;
        this.next = null;
        POOL.release(this);
    }
}

