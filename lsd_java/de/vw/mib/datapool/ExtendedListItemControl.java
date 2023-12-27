/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool;

import de.vw.mib.app.appadapter.CellValue;
import de.vw.mib.list.DynamicListData;
import de.vw.mib.list.DynamicListDataRowItemTransformer;
import de.vw.mib.list.ListItemControl;

public interface ExtendedListItemControl
extends ListItemControl {
    @Override
    default public DynamicListData getASLList() {
    }

    @Override
    default public boolean isDynamic() {
    }

    @Override
    default public DynamicListDataRowItemTransformer getListTransformer() {
    }

    default public CellValue getCellValue(CellValue cellValue, Object object, int n, int n2) {
    }
}

