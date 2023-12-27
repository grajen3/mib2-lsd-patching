/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.registry;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLDevice;

public interface ASLListRegistry {
    default public ASLList getASLList(int n) {
    }

    default public ASLListFactory getASLListFactory() {
    }

    default public void registerASLDevice(int n, ASLDevice aSLDevice) {
    }

    default public void registerGrammar(int n, int n2, int n3, boolean bl) {
    }

    default public void registerGrammar(int n, int n2, int n3, boolean bl, int n4) {
    }
}

