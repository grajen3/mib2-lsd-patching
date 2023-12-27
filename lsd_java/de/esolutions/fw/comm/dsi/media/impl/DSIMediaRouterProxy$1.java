/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.comm.dsi.media.impl.AudioRouteSerializer;
import de.esolutions.fw.comm.dsi.media.impl.DSIMediaRouterProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.media.AudioRoute;

class DSIMediaRouterProxy$1
implements ISerializable {
    private final /* synthetic */ AudioRoute[] val$newRoutes;
    private final /* synthetic */ DSIMediaRouterProxy this$0;

    DSIMediaRouterProxy$1(DSIMediaRouterProxy dSIMediaRouterProxy, AudioRoute[] audioRouteArray) {
        this.this$0 = dSIMediaRouterProxy;
        this.val$newRoutes = audioRouteArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        AudioRouteSerializer.putOptionalAudioRouteVarArray(iSerializer, this.val$newRoutes);
    }
}

