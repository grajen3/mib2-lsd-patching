/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.impl;

import de.vw.mib.asl.clientapi.impl.ASLClientAPIBridge;
import de.vw.mib.asl.clientapi.impl.ASLClientAPIBridge$RequestsBridgeBase$Invocation;

class ASLClientAPIBridge$RequestsBridgeBase$Queue {
    private final int maxSize;
    private ASLClientAPIBridge$RequestsBridgeBase$Invocation head;
    private int size;
    static final /* synthetic */ boolean $assertionsDisabled;

    ASLClientAPIBridge$RequestsBridgeBase$Queue(int n) {
        this.maxSize = n;
    }

    void add(ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation) {
        ++this.size;
        ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation2 = this.head;
        if (null == aSLClientAPIBridge$RequestsBridgeBase$Invocation2) {
            this.head = aSLClientAPIBridge$RequestsBridgeBase$Invocation;
        } else {
            ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation3;
            while (null != (aSLClientAPIBridge$RequestsBridgeBase$Invocation3 = aSLClientAPIBridge$RequestsBridgeBase$Invocation2.getNext())) {
                aSLClientAPIBridge$RequestsBridgeBase$Invocation2 = aSLClientAPIBridge$RequestsBridgeBase$Invocation3;
            }
            aSLClientAPIBridge$RequestsBridgeBase$Invocation2.setNext(aSLClientAPIBridge$RequestsBridgeBase$Invocation);
        }
    }

    int countEntries(int n) {
        int n2 = 0;
        for (ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation = this.head; null != aSLClientAPIBridge$RequestsBridgeBase$Invocation; aSLClientAPIBridge$RequestsBridgeBase$Invocation = aSLClientAPIBridge$RequestsBridgeBase$Invocation.getNext()) {
            if (aSLClientAPIBridge$RequestsBridgeBase$Invocation.getRequestId() != n) continue;
            ++n2;
        }
        return n2;
    }

    ASLClientAPIBridge$RequestsBridgeBase$Invocation head() {
        return this.head;
    }

    boolean isFull() {
        return this.maxSize <= this.size;
    }

    void removeFirst(int n) {
        ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation;
        ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation2 = null;
        for (aSLClientAPIBridge$RequestsBridgeBase$Invocation = this.head; null != aSLClientAPIBridge$RequestsBridgeBase$Invocation && aSLClientAPIBridge$RequestsBridgeBase$Invocation.getRequestId() != n; aSLClientAPIBridge$RequestsBridgeBase$Invocation = aSLClientAPIBridge$RequestsBridgeBase$Invocation.getNext()) {
            aSLClientAPIBridge$RequestsBridgeBase$Invocation2 = aSLClientAPIBridge$RequestsBridgeBase$Invocation;
        }
        if (null != aSLClientAPIBridge$RequestsBridgeBase$Invocation) {
            this.unlink(aSLClientAPIBridge$RequestsBridgeBase$Invocation2, aSLClientAPIBridge$RequestsBridgeBase$Invocation);
            aSLClientAPIBridge$RequestsBridgeBase$Invocation.release();
        }
    }

    void removeLast(int n) {
        ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation = null;
        ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation2 = null;
        ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation3 = null;
        for (ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation4 = this.head; null != aSLClientAPIBridge$RequestsBridgeBase$Invocation4; aSLClientAPIBridge$RequestsBridgeBase$Invocation4 = aSLClientAPIBridge$RequestsBridgeBase$Invocation4.getNext()) {
            if (aSLClientAPIBridge$RequestsBridgeBase$Invocation4.getRequestId() == n) {
                aSLClientAPIBridge$RequestsBridgeBase$Invocation = aSLClientAPIBridge$RequestsBridgeBase$Invocation4;
                aSLClientAPIBridge$RequestsBridgeBase$Invocation2 = aSLClientAPIBridge$RequestsBridgeBase$Invocation3;
            }
            aSLClientAPIBridge$RequestsBridgeBase$Invocation3 = aSLClientAPIBridge$RequestsBridgeBase$Invocation4;
        }
        if (null != aSLClientAPIBridge$RequestsBridgeBase$Invocation) {
            this.unlink(aSLClientAPIBridge$RequestsBridgeBase$Invocation2, aSLClientAPIBridge$RequestsBridgeBase$Invocation);
            aSLClientAPIBridge$RequestsBridgeBase$Invocation.release();
        }
    }

    void unlink(ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation, ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation2) {
        if (!$assertionsDisabled && 0 >= this.size) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && null == aSLClientAPIBridge$RequestsBridgeBase$Invocation2) {
            throw new AssertionError();
        }
        ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation3 = aSLClientAPIBridge$RequestsBridgeBase$Invocation2.getNext();
        if (null != aSLClientAPIBridge$RequestsBridgeBase$Invocation) {
            aSLClientAPIBridge$RequestsBridgeBase$Invocation.setNext(aSLClientAPIBridge$RequestsBridgeBase$Invocation3);
        } else {
            this.head = aSLClientAPIBridge$RequestsBridgeBase$Invocation3;
        }
        aSLClientAPIBridge$RequestsBridgeBase$Invocation2.setNext(null);
        --this.size;
    }

    static {
        $assertionsDisabled = !(ASLClientAPIBridge.class$de$vw$mib$asl$clientapi$impl$ASLClientAPIBridge == null ? (ASLClientAPIBridge.class$de$vw$mib$asl$clientapi$impl$ASLClientAPIBridge = ASLClientAPIBridge.class$("de.vw.mib.asl.clientapi.impl.ASLClientAPIBridge")) : ASLClientAPIBridge.class$de$vw$mib$asl$clientapi$impl$ASLClientAPIBridge).desiredAssertionStatus();
    }
}

