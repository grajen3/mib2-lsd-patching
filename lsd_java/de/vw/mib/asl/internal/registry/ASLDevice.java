/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.registry;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.genericevents.ServiceRegister;

public interface ASLDevice {
    public static final int COMPLIANCE_LEVEL_1;
    public static final int COMPLIANCE_LEVEL_2;

    default public int getASLDeviceComplianceLevel() {
    }

    default public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
    }

    default public ASLList getASLList(int n) {
    }

    default public int[] getASLListColumns(int n) {
    }

    default public String getName() {
    }

    default public int getTargetId() {
    }

    default public void registerASLServices(ServiceRegister serviceRegister) {
    }

    default public void registerASLLists(ASLListRegistry aSLListRegistry) {
    }
}

