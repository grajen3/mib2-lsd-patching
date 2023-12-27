/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.DCAdditionalInstrumentSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.DCAdditionalInstrument;

class DSICarKombiProxy$14
implements ISerializable {
    private final /* synthetic */ DCAdditionalInstrument val$setup;
    private final /* synthetic */ DSICarKombiProxy this$0;

    DSICarKombiProxy$14(DSICarKombiProxy dSICarKombiProxy, DCAdditionalInstrument dCAdditionalInstrument) {
        this.this$0 = dSICarKombiProxy;
        this.val$setup = dCAdditionalInstrument;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        DCAdditionalInstrumentSerializer.putOptionalDCAdditionalInstrument(iSerializer, this.val$setup);
    }
}

