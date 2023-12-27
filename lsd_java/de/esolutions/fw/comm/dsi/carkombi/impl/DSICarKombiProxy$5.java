/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.BCStatisticsResetSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCStatisticsReset;

class DSICarKombiProxy$5
implements ISerializable {
    private final /* synthetic */ BCStatisticsReset val$reset;
    private final /* synthetic */ DSICarKombiProxy this$0;

    DSICarKombiProxy$5(DSICarKombiProxy dSICarKombiProxy, BCStatisticsReset bCStatisticsReset) {
        this.this$0 = dSICarKombiProxy;
        this.val$reset = bCStatisticsReset;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        BCStatisticsResetSerializer.putOptionalBCStatisticsReset(iSerializer, this.val$reset);
    }
}

