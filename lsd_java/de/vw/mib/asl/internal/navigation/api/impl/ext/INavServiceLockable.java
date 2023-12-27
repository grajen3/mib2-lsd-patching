/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext;

public interface INavServiceLockable {
    default public void lock() {
    }

    default public void weakLock() {
    }

    default public void unlock() {
    }

    default public void updateLock(boolean bl) {
    }
}

