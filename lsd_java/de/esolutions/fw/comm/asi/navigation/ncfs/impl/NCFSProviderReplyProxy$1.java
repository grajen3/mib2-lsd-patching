/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs.impl;

import de.esolutions.fw.comm.asi.navigation.ncfs.impl.NCFSProviderReplyProxy;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.sBoundingBoxSerializer;
import de.esolutions.fw.comm.asi.navigation.ncfs.sBoundingBox;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class NCFSProviderReplyProxy$1
implements ISerializable {
    private final /* synthetic */ int[] val$tileIndexes;
    private final /* synthetic */ sBoundingBox val$boundingBox;
    private final /* synthetic */ int val$status;
    private final /* synthetic */ NCFSProviderReplyProxy this$0;

    NCFSProviderReplyProxy$1(NCFSProviderReplyProxy nCFSProviderReplyProxy, int[] nArray, sBoundingBox sBoundingBox2, int n) {
        this.this$0 = nCFSProviderReplyProxy;
        this.val$tileIndexes = nArray;
        this.val$boundingBox = sBoundingBox2;
        this.val$status = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalInt32VarArray(this.val$tileIndexes);
        sBoundingBoxSerializer.putOptionalsBoundingBox(iSerializer, this.val$boundingBox);
        iSerializer.putEnum(this.val$status);
    }
}

