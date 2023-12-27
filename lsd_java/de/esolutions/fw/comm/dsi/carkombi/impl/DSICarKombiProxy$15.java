/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.DCAdditionalInstrument2Serializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.DCAdditionalInstrument2;

class DSICarKombiProxy$15
implements ISerializable {
    private final /* synthetic */ DCAdditionalInstrument2 val$setup;
    private final /* synthetic */ DSICarKombiProxy this$0;

    DSICarKombiProxy$15(DSICarKombiProxy dSICarKombiProxy, DCAdditionalInstrument2 dCAdditionalInstrument2) {
        this.this$0 = dSICarKombiProxy;
        this.val$setup = dCAdditionalInstrument2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        DCAdditionalInstrument2Serializer.putOptionalDCAdditionalInstrument2(iSerializer, this.val$setup);
    }
}

