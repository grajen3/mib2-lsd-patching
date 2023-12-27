/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.DCDisplayDependencySerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.DSICarKombiProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.DCDisplayDependency;

class DSICarKombiProxy$18
implements ISerializable {
    private final /* synthetic */ DCDisplayDependency val$setup;
    private final /* synthetic */ DSICarKombiProxy this$0;

    DSICarKombiProxy$18(DSICarKombiProxy dSICarKombiProxy, DCDisplayDependency dCDisplayDependency) {
        this.this$0 = dSICarKombiProxy;
        this.val$setup = dCDisplayDependency;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        DCDisplayDependencySerializer.putOptionalDCDisplayDependency(iSerializer, this.val$setup);
    }
}

