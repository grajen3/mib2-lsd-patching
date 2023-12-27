/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.DCDisplayViewConfigurationSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.DCDisplayViewConfiguration;

class DSICarKombiProxy$19
implements ISerializable {
    private final /* synthetic */ DCDisplayViewConfiguration val$activeDisplayView;
    private final /* synthetic */ DSICarKombiProxy this$0;

    DSICarKombiProxy$19(DSICarKombiProxy dSICarKombiProxy, DCDisplayViewConfiguration dCDisplayViewConfiguration) {
        this.this$0 = dSICarKombiProxy;
        this.val$activeDisplayView = dCDisplayViewConfiguration;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        DCDisplayViewConfigurationSerializer.putOptionalDCDisplayViewConfiguration(iSerializer, this.val$activeDisplayView);
    }
}

