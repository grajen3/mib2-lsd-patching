/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.DCMainItemsSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.DCMainItems;

class DSICarKombiProxy$9
implements ISerializable {
    private final /* synthetic */ DCMainItems val$MainSelection;
    private final /* synthetic */ DSICarKombiProxy this$0;

    DSICarKombiProxy$9(DSICarKombiProxy dSICarKombiProxy, DCMainItems dCMainItems) {
        this.this$0 = dSICarKombiProxy;
        this.val$MainSelection = dCMainItems;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        DCMainItemsSerializer.putOptionalDCMainItems(iSerializer, this.val$MainSelection);
    }
}

