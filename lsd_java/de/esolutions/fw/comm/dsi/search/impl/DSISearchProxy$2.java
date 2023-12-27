/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.comm.dsi.search.impl.DSISearchProxy;
import de.esolutions.fw.comm.dsi.search.impl.SearchResultSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.search.SearchResult;

class DSISearchProxy$2
implements ISerializable {
    private final /* synthetic */ SearchResult val$entry;
    private final /* synthetic */ DSISearchProxy this$0;

    DSISearchProxy$2(DSISearchProxy dSISearchProxy, SearchResult searchResult) {
        this.this$0 = dSISearchProxy;
        this.val$entry = searchResult;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        SearchResultSerializer.putOptionalSearchResult(iSerializer, this.val$entry);
    }
}

