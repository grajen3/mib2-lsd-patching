/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.bap;

import org.dsi.ifc.base.DSIListener;

public interface DSIBAPListener
extends DSIListener {
    default public void bapStateStatus(int n, int n2) {
    }

    default public void indication(int n, int n2, int n3, int n4, int n5) {
    }

    default public void indicationVoid(int n, int n2, int n3) {
    }

    default public void indicationByteSequence(int n, int n2, int n3, byte[] byArray) {
    }

    default public void indicationError(int n, int n2, int n3) {
    }

    default public void acknowledge(int n, int n2, int n3) {
    }
}

