/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.comm.dsi.search.impl.DSISearchProxy;
import de.esolutions.fw.comm.dsi.search.impl.EnvironmentSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.search.Environment;

class DSISearchProxy$9
implements ISerializable {
    private final /* synthetic */ Environment val$environment;
    private final /* synthetic */ DSISearchProxy this$0;

    DSISearchProxy$9(DSISearchProxy dSISearchProxy, Environment environment) {
        this.this$0 = dSISearchProxy;
        this.val$environment = environment;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        EnvironmentSerializer.putOptionalEnvironment(iSerializer, this.val$environment);
    }
}

