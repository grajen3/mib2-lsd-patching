/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.impl;

import de.vw.mib.asl.clientapi.impl.ASLClientAPIBridge$RequestsBridgeBase;
import de.vw.mib.asl.clientapi.impl.ASLClientAPIBridge$RequestsBridgeBase$Invocation;
import de.vw.mib.pool.PoorMansPool;

class ASLClientAPIBridge$RequestsBridgeBase$ASLSwitch
implements Runnable {
    private static final int MAX_POOL_SIZE;
    private static final PoorMansPool POOL;
    private static final int TYPE_INVOCATION;
    private static final int TYPE_INVOKE_NEXT;
    private ASLClientAPIBridge$RequestsBridgeBase bridge;
    private int type;
    private ASLClientAPIBridge$RequestsBridgeBase$Invocation invocation;

    private ASLClientAPIBridge$RequestsBridgeBase$ASLSwitch() {
    }

    static ASLClientAPIBridge$RequestsBridgeBase$ASLSwitch createInvocation(ASLClientAPIBridge$RequestsBridgeBase aSLClientAPIBridge$RequestsBridgeBase, ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation) {
        return ASLClientAPIBridge$RequestsBridgeBase$ASLSwitch.create(aSLClientAPIBridge$RequestsBridgeBase, 0, aSLClientAPIBridge$RequestsBridgeBase$Invocation);
    }

    static ASLClientAPIBridge$RequestsBridgeBase$ASLSwitch createInvokeNext(ASLClientAPIBridge$RequestsBridgeBase aSLClientAPIBridge$RequestsBridgeBase) {
        return ASLClientAPIBridge$RequestsBridgeBase$ASLSwitch.create(aSLClientAPIBridge$RequestsBridgeBase, 1, null);
    }

    private static ASLClientAPIBridge$RequestsBridgeBase$ASLSwitch create(ASLClientAPIBridge$RequestsBridgeBase aSLClientAPIBridge$RequestsBridgeBase, int n, ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation) {
        ASLClientAPIBridge$RequestsBridgeBase$ASLSwitch aSLClientAPIBridge$RequestsBridgeBase$ASLSwitch = (ASLClientAPIBridge$RequestsBridgeBase$ASLSwitch)POOL.borrow();
        if (null == aSLClientAPIBridge$RequestsBridgeBase$ASLSwitch) {
            aSLClientAPIBridge$RequestsBridgeBase$ASLSwitch = new ASLClientAPIBridge$RequestsBridgeBase$ASLSwitch();
        }
        aSLClientAPIBridge$RequestsBridgeBase$ASLSwitch.bridge = aSLClientAPIBridge$RequestsBridgeBase;
        aSLClientAPIBridge$RequestsBridgeBase$ASLSwitch.invocation = aSLClientAPIBridge$RequestsBridgeBase$Invocation;
        aSLClientAPIBridge$RequestsBridgeBase$ASLSwitch.type = n;
        return aSLClientAPIBridge$RequestsBridgeBase$ASLSwitch;
    }

    @Override
    public void run() {
        ASLClientAPIBridge$RequestsBridgeBase aSLClientAPIBridge$RequestsBridgeBase = this.bridge;
        ASLClientAPIBridge$RequestsBridgeBase$Invocation aSLClientAPIBridge$RequestsBridgeBase$Invocation = this.invocation;
        int n = this.type;
        this.bridge = null;
        this.invocation = null;
        POOL.release(this);
        switch (n) {
            case 0: {
                aSLClientAPIBridge$RequestsBridgeBase._handleInvocation(aSLClientAPIBridge$RequestsBridgeBase$Invocation);
                break;
            }
            case 1: {
                aSLClientAPIBridge$RequestsBridgeBase._invokeNext();
                break;
            }
        }
    }

    static {
        POOL = new PoorMansPool("ASLClientAPI.ASLSwitch", 10);
    }
}

