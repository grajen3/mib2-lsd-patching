/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.mastercontrol.impl;

import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.mastercontrol.ASIMasterControlListener;
import de.vw.mib.asi.mastercontrol.impl.ASIMasterControlBaseServiceImpl;

class ASIMasterControlBaseServiceImpl$ListenerProxy
implements ASIMasterControlListener {
    private final /* synthetic */ ASIMasterControlBaseServiceImpl this$0;

    ASIMasterControlBaseServiceImpl$ListenerProxy(ASIMasterControlBaseServiceImpl aSIMasterControlBaseServiceImpl) {
        this.this$0 = aSIMasterControlBaseServiceImpl;
    }

    @Override
    public void updateBlockState(int n, boolean bl) {
        try {
            this.this$0.updateBlockState(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateHUVersion(String string, boolean bl) {
        try {
            this.this$0.updateHUVersion(string, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateLockState(int n, boolean bl) {
        try {
            this.this$0.updateLockState(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateVIN(String string, boolean bl) {
        try {
            this.this$0.updateVIN(string, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }
}

