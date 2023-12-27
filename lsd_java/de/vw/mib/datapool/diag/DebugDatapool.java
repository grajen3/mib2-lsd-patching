/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool.diag;

import de.vw.mib.collections.ints.IntBooleanMap;
import de.vw.mib.collections.ints.IntFloatMap;
import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntLongMap;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.datapool.diag.DebugDatapoolObserver;

public interface DebugDatapool {
    default public IntBooleanMap getBooleanValues() {
    }

    default public IntFloatMap getFloatValues() {
    }

    default public IntIntMap getIntegerValues() {
    }

    default public IntLongMap getLongValues() {
    }

    default public IntObjectMap getObjectValues() {
    }

    default public String getValueAsString(int n) {
    }

    default public String getValueAsString(int n, int n2) {
    }

    default public void setValueFromString(int n, int n2, String string) {
    }

    default public void registerObserver(DebugDatapoolObserver debugDatapoolObserver) {
    }

    default public void unregisterObserver(DebugDatapoolObserver debugDatapoolObserver) {
    }
}

