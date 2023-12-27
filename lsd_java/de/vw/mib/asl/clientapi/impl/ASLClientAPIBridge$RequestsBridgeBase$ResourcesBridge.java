/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.impl;

import de.vw.mib.asl.clientapi.ASLClientAPIResources;
import de.vw.mib.asl.clientapi.impl.ASLClientAPIBridge$RequestsBridgeBase;

class ASLClientAPIBridge$RequestsBridgeBase$ResourcesBridge
implements ASLClientAPIResources {
    private final /* synthetic */ ASLClientAPIBridge$RequestsBridgeBase this$0;

    ASLClientAPIBridge$RequestsBridgeBase$ResourcesBridge(ASLClientAPIBridge$RequestsBridgeBase aSLClientAPIBridge$RequestsBridgeBase) {
        this.this$0 = aSLClientAPIBridge$RequestsBridgeBase;
    }

    @Override
    public boolean isExplicitlyLocked(int n) {
        return this.this$0._isResourceExplicitlyLocked(n);
    }

    @Override
    public boolean isLocked(int n) {
        return this.this$0._isResourceLocked(n);
    }

    @Override
    public boolean setExplicitlLocked(int n, boolean bl) {
        return this.this$0._setResourceExplicitlyLocked(n, bl);
    }
}

