/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.comm.dsi.search.impl.DSISearchDataProviderProxy;
import de.esolutions.fw.comm.dsi.search.impl.RawDataSetSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.search.RawDataSet;

class DSISearchDataProviderProxy$2
implements ISerializable {
    private final /* synthetic */ int val$source;
    private final /* synthetic */ RawDataSet[] val$dataSets;
    private final /* synthetic */ int val$totalCount;
    private final /* synthetic */ DSISearchDataProviderProxy this$0;

    DSISearchDataProviderProxy$2(DSISearchDataProviderProxy dSISearchDataProviderProxy, int n, RawDataSet[] rawDataSetArray, int n2) {
        this.this$0 = dSISearchDataProviderProxy;
        this.val$source = n;
        this.val$dataSets = rawDataSetArray;
        this.val$totalCount = n2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$source);
        RawDataSetSerializer.putOptionalRawDataSetVarArray(iSerializer, this.val$dataSets);
        iSerializer.putInt32(this.val$totalCount);
    }
}

