/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.persistence.impl;

import de.esolutions.fw.comm.asi.persistence.impl.AttributesReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class AttributesReplyProxy$5
implements ISerializable {
    private final /* synthetic */ long[] val$namespaces;
    private final /* synthetic */ long[] val$keys;
    private final /* synthetic */ int[] val$status;
    private final /* synthetic */ AttributesReplyProxy this$0;

    AttributesReplyProxy$5(AttributesReplyProxy attributesReplyProxy, long[] lArray, long[] lArray2, int[] nArray) {
        this.this$0 = attributesReplyProxy;
        this.val$namespaces = lArray;
        this.val$keys = lArray2;
        this.val$status = nArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalUInt32VarArray(this.val$namespaces);
        iSerializer.putOptionalUInt32VarArray(this.val$keys);
        iSerializer.putOptionalEnumVarArray(this.val$status);
    }
}

