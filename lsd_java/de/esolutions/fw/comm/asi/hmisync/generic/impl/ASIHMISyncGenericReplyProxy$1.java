/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.generic.impl;

import de.esolutions.fw.comm.asi.hmisync.generic.GenericPacket;
import de.esolutions.fw.comm.asi.hmisync.generic.impl.ASIHMISyncGenericReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.generic.impl.GenericPacketSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncGenericReplyProxy$1
implements ISerializable {
    private final /* synthetic */ GenericPacket val$packet;
    private final /* synthetic */ ASIHMISyncGenericReplyProxy this$0;

    ASIHMISyncGenericReplyProxy$1(ASIHMISyncGenericReplyProxy aSIHMISyncGenericReplyProxy, GenericPacket genericPacket) {
        this.this$0 = aSIHMISyncGenericReplyProxy;
        this.val$packet = genericPacket;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        GenericPacketSerializer.putOptionalGenericPacket(iSerializer, this.val$packet);
    }
}

