/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.persistence.impl;

import de.esolutions.fw.comm.asi.persistence.impl.AttributesReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class AttributesReplyProxy$3
implements ISerializable {
    private final /* synthetic */ long[] val$namespaces;
    private final /* synthetic */ long[] val$keys;
    private final /* synthetic */ int[] val$values;
    private final /* synthetic */ int[] val$status;
    private final /* synthetic */ AttributesReplyProxy this$0;

    AttributesReplyProxy$3(AttributesReplyProxy attributesReplyProxy, long[] lArray, long[] lArray2, int[] nArray, int[] nArray2) {
        this.this$0 = attributesReplyProxy;
        this.val$namespaces = lArray;
        this.val$keys = lArray2;
        this.val$values = nArray;
        this.val$status = nArray2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalUInt32VarArray(this.val$namespaces);
        iSerializer.putOptionalUInt32VarArray(this.val$keys);
        iSerializer.putOptionalInt32VarArray(this.val$values);
        iSerializer.putOptionalEnumVarArray(this.val$status);
    }
}

