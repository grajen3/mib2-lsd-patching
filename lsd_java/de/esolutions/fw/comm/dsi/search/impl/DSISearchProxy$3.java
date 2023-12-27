/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.comm.dsi.search.impl.DSISearchProxy;
import de.esolutions.fw.comm.dsi.search.impl.SearchQuerySerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.search.SearchQuery;

class DSISearchProxy$3
implements ISerializable {
    private final /* synthetic */ SearchQuery val$query;
    private final /* synthetic */ DSISearchProxy this$0;

    DSISearchProxy$3(DSISearchProxy dSISearchProxy, SearchQuery searchQuery) {
        this.this$0 = dSISearchProxy;
        this.val$query = searchQuery;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        SearchQuerySerializer.putOptionalSearchQuery(iSerializer, this.val$query);
    }
}

