/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.comm.dsi.search.impl.DSISearchDataProviderProxy;
import de.esolutions.fw.comm.dsi.search.impl.DataSetSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.search.DataSet;

class DSISearchDataProviderProxy$1
implements ISerializable {
    private final /* synthetic */ int val$source;
    private final /* synthetic */ DataSet[] val$dataSets;
    private final /* synthetic */ int val$totalCount;
    private final /* synthetic */ DSISearchDataProviderProxy this$0;

    DSISearchDataProviderProxy$1(DSISearchDataProviderProxy dSISearchDataProviderProxy, int n, DataSet[] dataSetArray, int n2) {
        this.this$0 = dSISearchDataProviderProxy;
        this.val$source = n;
        this.val$dataSets = dataSetArray;
        this.val$totalCount = n2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$source);
        DataSetSerializer.putOptionalDataSetVarArray(iSerializer, this.val$dataSets);
        iSerializer.putInt32(this.val$totalCount);
    }
}

