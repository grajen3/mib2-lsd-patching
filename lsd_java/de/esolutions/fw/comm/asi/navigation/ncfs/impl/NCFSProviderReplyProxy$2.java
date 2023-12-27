/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs.impl;

import de.esolutions.fw.comm.asi.navigation.ncfs.impl.NCFSProviderReplyProxy;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.sEdgeSerializer;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.sRestrictionSerializer;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.sTileInfoSerializer;
import de.esolutions.fw.comm.asi.navigation.ncfs.sEdge;
import de.esolutions.fw.comm.asi.navigation.ncfs.sRestriction;
import de.esolutions.fw.comm.asi.navigation.ncfs.sTileInfo;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class NCFSProviderReplyProxy$2
implements ISerializable {
    private final /* synthetic */ sTileInfo[] val$tiles;
    private final /* synthetic */ sEdge[] val$edges;
    private final /* synthetic */ sRestriction[] val$restrictions;
    private final /* synthetic */ int val$status;
    private final /* synthetic */ NCFSProviderReplyProxy this$0;

    NCFSProviderReplyProxy$2(NCFSProviderReplyProxy nCFSProviderReplyProxy, sTileInfo[] sTileInfoArray, sEdge[] sEdgeArray, sRestriction[] sRestrictionArray, int n) {
        this.this$0 = nCFSProviderReplyProxy;
        this.val$tiles = sTileInfoArray;
        this.val$edges = sEdgeArray;
        this.val$restrictions = sRestrictionArray;
        this.val$status = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sTileInfoSerializer.putOptionalsTileInfoVarArray(iSerializer, this.val$tiles);
        sEdgeSerializer.putOptionalsEdgeVarArray(iSerializer, this.val$edges);
        sRestrictionSerializer.putOptionalsRestrictionVarArray(iSerializer, this.val$restrictions);
        iSerializer.putEnum(this.val$status);
    }
}

