/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.persistence.impl;

import de.esolutions.fw.comm.asi.persistence.impl.AttributesReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class AttributesReplyProxy$4
implements ISerializable {
    private final /* synthetic */ long[] val$namespaces;
    private final /* synthetic */ long[] val$keys;
    private final /* synthetic */ short[][] val$values;
    private final /* synthetic */ int[] val$status;
    private final /* synthetic */ AttributesReplyProxy this$0;

    AttributesReplyProxy$4(AttributesReplyProxy attributesReplyProxy, long[] lArray, long[] lArray2, short[][] sArray, int[] nArray) {
        this.this$0 = attributesReplyProxy;
        this.val$namespaces = lArray;
        this.val$keys = lArray2;
        this.val$values = sArray;
        this.val$status = nArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalUInt32VarArray(this.val$namespaces);
        iSerializer.putOptionalUInt32VarArray(this.val$keys);
        boolean bl = this.val$values != null;
        iSerializer.putBool(!bl);
        if (bl) {
            iSerializer.putUInt32(this.val$values.length);
            for (int i2 = 0; i2 < this.val$values.length; ++i2) {
                iSerializer.putOptionalUInt8VarArray(this.val$values[i2]);
            }
        }
        iSerializer.putOptionalEnumVarArray(this.val$status);
    }
}

