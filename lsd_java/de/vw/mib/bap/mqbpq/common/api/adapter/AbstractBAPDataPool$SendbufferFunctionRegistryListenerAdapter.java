/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.api.adapter;

import de.vw.mib.asl.api.bap.dispatcher.BAPDispatcher;
import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.mqbpq.common.api.adapter.AbstractBAPDataPool;
import de.vw.mib.bap.mqbpq.common.api.adapter.BAPDataPoolValueAdapter;
import de.vw.mib.bap.mqbpq.common.marshalling.FunctionRegistryListenerAdapter;

class AbstractBAPDataPool$SendbufferFunctionRegistryListenerAdapter
extends FunctionRegistryListenerAdapter {
    private final boolean isCached;
    private final /* synthetic */ AbstractBAPDataPool this$0;

    public AbstractBAPDataPool$SendbufferFunctionRegistryListenerAdapter(AbstractBAPDataPool abstractBAPDataPool, int n, BAPDispatcher bAPDispatcher, boolean bl) {
        this.this$0 = abstractBAPDataPool;
        super(n, bAPDispatcher);
        this.isCached = bl;
    }

    @Override
    public boolean statusProperty(BAPEntity bAPEntity, Property property) {
        BAPDataPoolValueAdapter bAPDataPoolValueAdapter = this.this$0.get(this.getFctID());
        boolean bl = AbstractBAPDataPool.updateValueAdapterWithNewValue(bAPDataPoolValueAdapter, bAPEntity, !this.isCached);
        if (bl) {
            super.statusProperty(bAPEntity, property);
        }
        return bl;
    }

    @Override
    public void result(BAPEntity bAPEntity, Method method) {
        BAPDataPoolValueAdapter bAPDataPoolValueAdapter = this.this$0.get(this.getFctID());
        boolean bl = AbstractBAPDataPool.updateValueAdapterWithNewValue(bAPDataPoolValueAdapter, bAPEntity, !this.isCached);
        if (bl) {
            super.result(bAPEntity, method);
        }
    }

    @Override
    public void changedArray(BAPChangedArray bAPChangedArray, Array array) {
        BAPDataPoolValueAdapter bAPDataPoolValueAdapter = this.this$0.get(this.getFctID());
        boolean bl = AbstractBAPDataPool.updateValueAdapterWithNewValue(bAPDataPoolValueAdapter, bAPChangedArray, !this.isCached);
        if (bl) {
            super.changedArray(bAPChangedArray, array);
        }
    }
}

