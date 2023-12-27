/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.BCMenueConfigurationSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCMenueConfiguration;

class DSICarKombiProxy$2
implements ISerializable {
    private final /* synthetic */ BCMenueConfiguration val$config;
    private final /* synthetic */ int val$menu;
    private final /* synthetic */ DSICarKombiProxy this$0;

    DSICarKombiProxy$2(DSICarKombiProxy dSICarKombiProxy, BCMenueConfiguration bCMenueConfiguration, int n) {
        this.this$0 = dSICarKombiProxy;
        this.val$config = bCMenueConfiguration;
        this.val$menu = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        BCMenueConfigurationSerializer.putOptionalBCMenueConfiguration(iSerializer, this.val$config);
        iSerializer.putInt32(this.val$menu);
    }
}

