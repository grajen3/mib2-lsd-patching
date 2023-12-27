/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.calendar;

import org.dsi.ifc.base.DSIListener;

public interface DSICalendarExchangeListener
extends DSIListener {
    default public void parseICalResult(int n) {
    }

    default public void parseICalDirectoryResult(int[] nArray) {
    }

    default public void exportICalResult(int n, String string) {
    }

    default public void finishExportResult(int n, long[] lArray, int n2, String string) {
    }
}

