/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephone;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.telephone.CallStackEntry;
import org.dsi.ifc.telephone.MissedCallIndicator;

public interface DSICallStacksListener
extends DSIListener {
    default public void updateIsReverted(boolean bl, int n) {
    }

    default public void updateLastAnsweredNumbers(CallStackEntry[] callStackEntryArray, int n) {
    }

    default public void updateLastDialedNumbers(CallStackEntry[] callStackEntryArray, int n) {
    }

    default public void updateMissedNumbers(CallStackEntry[] callStackEntryArray, int n) {
    }

    default public void updateMEDataValidity(int n, int n2) {
    }

    default public void updateMissedCallIndicator(MissedCallIndicator missedCallIndicator, int n) {
    }
}

