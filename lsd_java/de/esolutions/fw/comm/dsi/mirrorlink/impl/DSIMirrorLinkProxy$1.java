/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.mirrorlink.impl;

import de.esolutions.fw.comm.dsi.mirrorlink.impl.ClientCapabilitiesSerializer;
import de.esolutions.fw.comm.dsi.mirrorlink.impl.DSIMirrorLinkProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.mirrorlink.ClientCapabilities;

class DSIMirrorLinkProxy$1
implements ISerializable {
    private final /* synthetic */ ClientCapabilities val$clientCapabilities;
    private final /* synthetic */ DSIMirrorLinkProxy this$0;

    DSIMirrorLinkProxy$1(DSIMirrorLinkProxy dSIMirrorLinkProxy, ClientCapabilities clientCapabilities) {
        this.this$0 = dSIMirrorLinkProxy;
        this.val$clientCapabilities = clientCapabilities;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ClientCapabilitiesSerializer.putOptionalClientCapabilities(iSerializer, this.val$clientCapabilities);
    }
}

