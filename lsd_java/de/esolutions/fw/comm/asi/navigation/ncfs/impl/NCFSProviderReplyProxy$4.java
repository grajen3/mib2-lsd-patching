/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs.impl;

import de.esolutions.fw.comm.asi.navigation.ncfs.impl.NCFSProviderReplyProxy;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.sLGIEventSerializer;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.sTileInfoSerializer;
import de.esolutions.fw.comm.asi.navigation.ncfs.sLGIEvent;
import de.esolutions.fw.comm.asi.navigation.ncfs.sTileInfo;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class NCFSProviderReplyProxy$4
implements ISerializable {
    private final /* synthetic */ sTileInfo[] val$tiles;
    private final /* synthetic */ sLGIEvent[] val$events;
    private final /* synthetic */ int val$status;
    private final /* synthetic */ NCFSProviderReplyProxy this$0;

    NCFSProviderReplyProxy$4(NCFSProviderReplyProxy nCFSProviderReplyProxy, sTileInfo[] sTileInfoArray, sLGIEvent[] sLGIEventArray, int n) {
        this.this$0 = nCFSProviderReplyProxy;
        this.val$tiles = sTileInfoArray;
        this.val$events = sLGIEventArray;
        this.val$status = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sTileInfoSerializer.putOptionalsTileInfoVarArray(iSerializer, this.val$tiles);
        sLGIEventSerializer.putOptionalsLGIEventVarArray(iSerializer, this.val$events);
        iSerializer.putEnum(this.val$status);
    }
}

