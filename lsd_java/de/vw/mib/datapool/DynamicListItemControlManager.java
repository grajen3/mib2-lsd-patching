/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool;

import de.vw.mib.app.appadapter.CellValue;
import de.vw.mib.datapool.ExtendedListItemControl;

public interface DynamicListItemControlManager {
    default public CellValue getCellValue(CellValue cellValue, int n, int n2, int n3) {
    }

    default public ExtendedListItemControl getListItemControl(int n) {
    }
}

