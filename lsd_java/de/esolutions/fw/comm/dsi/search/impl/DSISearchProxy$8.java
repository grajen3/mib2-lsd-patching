/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.comm.dsi.search.impl.DSISearchProxy;
import de.esolutions.fw.comm.dsi.search.impl.SearchFilterSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.search.SearchFilter;

class DSISearchProxy$8
implements ISerializable {
    private final /* synthetic */ int val$source;
    private final /* synthetic */ SearchFilter val$searchFilter;
    private final /* synthetic */ DSISearchProxy this$0;

    DSISearchProxy$8(DSISearchProxy dSISearchProxy, int n, SearchFilter searchFilter) {
        this.this$0 = dSISearchProxy;
        this.val$source = n;
        this.val$searchFilter = searchFilter;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$source);
        SearchFilterSerializer.putOptionalSearchFilter(iSerializer, this.val$searchFilter);
    }
}

