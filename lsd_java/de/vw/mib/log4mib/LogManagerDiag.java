/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib;

import de.vw.mib.log4mib.LogManager;
import de.vw.mib.log4mib.LogManagerDiagListener;

public interface LogManagerDiag
extends LogManager {
    default public int[] getClassifierIds() {
    }

    default public String[] getClassifierNames() {
    }

    default public String[] getSubClassifierNames(int n) {
    }

    default public void registerLogManagerDiagListener(LogManagerDiagListener logManagerDiagListener) {
    }

    default public void unregisterLogManagerDiagListener(LogManagerDiagListener logManagerDiagListener) {
    }
}

