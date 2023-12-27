/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.list;

import de.vw.mib.list.HMIListDataManipulator;

public interface HMIListDataTransaction
extends HMIListDataManipulator {
    default public void commit() {
    }

    default public void dismiss() {
    }
}

