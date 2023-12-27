/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.registry;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.registry.ASLDevice;
import de.vw.mib.asl.internal.registry.ASLDeviceAction;

public interface ASLDeviceRegistry {
    default public ASLDevice getASLDevice(int n) {
    }

    default public ASLList getASLList(int n) {
    }

    default public int[] getASLListColumns(int n) {
    }

    default public boolean isASLDeviceRegistered(int n) {
    }

    default public boolean isASLListRegistered(int n) {
    }

    default public void registerASLDevice(ASLDevice aSLDevice) {
    }

    default public void executeForEachASLDevice(ASLDeviceAction aSLDeviceAction) {
    }
}

