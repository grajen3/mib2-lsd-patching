/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.adapterMOD.control;

public final class CoreServiceMODUtils {
    public static int getAdapterStateWithServiceState(int n) {
        int n2 = 0;
        switch (n) {
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 0;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
        }
        return n2;
    }
}

