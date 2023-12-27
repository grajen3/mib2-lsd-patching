/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.registry.impl;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLDevice;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.genericevents.ServiceRegister;

public abstract class ASLDeviceAdapter
implements ASLDevice {
    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        return this.getASLList(n);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
    }
}

