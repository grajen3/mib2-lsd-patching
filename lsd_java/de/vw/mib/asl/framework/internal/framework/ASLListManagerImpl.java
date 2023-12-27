/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListManager;
import de.vw.mib.asl.internal.list.impl.DirectWindowList;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLDeviceRegistry;
import de.vw.mib.list.DynamicListData;
import de.vw.mib.list.DynamicListManager;

class ASLListManagerImpl
implements ASLListManager,
DynamicListManager {
    private final ASLDeviceRegistry registry;

    ASLListManagerImpl(ASLDeviceRegistry aSLDeviceRegistry) {
        this.registry = aSLDeviceRegistry;
    }

    @Override
    public DynamicListData getDynamicList(int n) {
        return this.getASLList(n);
    }

    @Override
    public GenericASLList getGenericASLList(int n) {
        return (GenericASLList)this.getASLList(n);
    }

    @Override
    public DirectWindowList getDirectWindowList(int n) {
        return (DirectWindowList)this.getASLList(n);
    }

    @Override
    public ASLList getASLList(int n) {
        return this.registry.getASLList(n);
    }
}

