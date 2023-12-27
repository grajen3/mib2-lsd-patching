/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carstopwatch.impl;

import de.esolutions.fw.comm.dsi.carstopwatch.impl.DSICarStopWatchProxy;
import de.esolutions.fw.comm.dsi.carstopwatch.impl.StopWatchTimeSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carstopwatch.StopWatchTime;

class DSICarStopWatchProxy$1
implements ISerializable {
    private final /* synthetic */ StopWatchTime val$time;
    private final /* synthetic */ DSICarStopWatchProxy this$0;

    DSICarStopWatchProxy$1(DSICarStopWatchProxy dSICarStopWatchProxy, StopWatchTime stopWatchTime) {
        this.this$0 = dSICarStopWatchProxy;
        this.val$time = stopWatchTime;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        StopWatchTimeSerializer.putOptionalStopWatchTime(iSerializer, this.val$time);
    }
}

