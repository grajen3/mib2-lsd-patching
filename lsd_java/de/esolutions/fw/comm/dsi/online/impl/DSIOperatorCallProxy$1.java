/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.dsi.online.impl.DSIOperatorCallProxy;
import de.esolutions.fw.comm.dsi.online.impl.OperatorCallDataSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.OperatorCallData;

class DSIOperatorCallProxy$1
implements ISerializable {
    private final /* synthetic */ int val$serviceType;
    private final /* synthetic */ OperatorCallData val$container;
    private final /* synthetic */ boolean val$ignoreOldSession;
    private final /* synthetic */ DSIOperatorCallProxy this$0;

    DSIOperatorCallProxy$1(DSIOperatorCallProxy dSIOperatorCallProxy, int n, OperatorCallData operatorCallData, boolean bl) {
        this.this$0 = dSIOperatorCallProxy;
        this.val$serviceType = n;
        this.val$container = operatorCallData;
        this.val$ignoreOldSession = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$serviceType);
        OperatorCallDataSerializer.putOptionalOperatorCallData(iSerializer, this.val$container);
        iSerializer.putBool(this.val$ignoreOldSession);
    }
}

