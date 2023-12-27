/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext.memory;

import de.vw.mib.asl.api.navigation.memory.INavigationContactListElement;
import org.dsi.ifc.organizer.DataSet;

public class INavigationContactListElementImpl
implements INavigationContactListElement {
    public DataSet realDataSet;

    public String toString() {
        return this.realDataSet != null ? this.realDataSet.toString() : "null";
    }

    public INavigationContactListElementImpl(DataSet dataSet) {
        this.realDataSet = dataSet;
    }

    @Override
    public long getId() {
        return this.realDataSet != null ? this.realDataSet.entryId : 0L;
    }
}

