/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.diagnose;

import org.dsi.ifc.base.DSIListener;

public interface DSIDiagnoseSystemListener
extends DSIListener {
    default public void updateDiagnosticValueChanged(int n, long l, int n2) {
    }

    default public void requestRoutine(int n, int n2, int n3, int[] nArray) {
    }

    default public void requestActuatorTest(int n, int n2, int n3, int n4, int[] nArray) {
    }
}

