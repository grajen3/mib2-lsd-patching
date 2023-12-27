/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.appadapter.modelapi.list;

import de.vw.mib.app.appadapter.modelapi.list.AdditionalColumn;
import de.vw.mib.app.appadapter.modelapi.list.Formatter;
import de.vw.mib.app.appadapter.modelapi.list.Mapper;
import de.vw.mib.app.appadapter.modelapi.list.Sorter;

public interface ListControl {
    default public void addColumn(int n, AdditionalColumn additionalColumn) {
    }

    default public void bind(Object object) {
    }

    default public void setFormatter(Formatter formatter) {
    }

    default public void setMapper(Mapper mapper) {
    }

    default public void setSorter(Sorter sorter) {
    }
}

