/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.mirrorlink.impl;

import de.esolutions.fw.comm.dsi.mirrorlink.impl.DSIMirrorLinkProxy;
import de.esolutions.fw.comm.dsi.mirrorlink.impl.EventSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.mirrorlink.Event;

class DSIMirrorLinkProxy$2
implements ISerializable {
    private final /* synthetic */ Event[] val$events;
    private final /* synthetic */ int val$deltaTime;
    private final /* synthetic */ DSIMirrorLinkProxy this$0;

    DSIMirrorLinkProxy$2(DSIMirrorLinkProxy dSIMirrorLinkProxy, Event[] eventArray, int n) {
        this.this$0 = dSIMirrorLinkProxy;
        this.val$events = eventArray;
        this.val$deltaTime = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        EventSerializer.putOptionalEventVarArray(iSerializer, this.val$events);
        iSerializer.putInt32(this.val$deltaTime);
    }
}

