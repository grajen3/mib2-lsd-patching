/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.registry.impl;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLDevice;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceRegistryImpl;

class ASLDeviceRegistryImpl$1
implements ASLListRegistry {
    private final /* synthetic */ ASLDeviceRegistryImpl this$0;

    ASLDeviceRegistryImpl$1(ASLDeviceRegistryImpl aSLDeviceRegistryImpl) {
        this.this$0 = aSLDeviceRegistryImpl;
    }

    @Override
    public ASLList getASLList(int n) {
        return this.this$0.getASLList(n);
    }

    @Override
    public ASLListFactory getASLListFactory() {
        return this.this$0.listFactory;
    }

    @Override
    public void registerASLDevice(int n, ASLDevice aSLDevice) {
        this.this$0.devicesByListId.put(n, aSLDevice);
    }

    @Override
    public void registerGrammar(int n, int n2, int n3, boolean bl) {
    }

    @Override
    public void registerGrammar(int n, int n2, int n3, boolean bl, int n4) {
    }
}

