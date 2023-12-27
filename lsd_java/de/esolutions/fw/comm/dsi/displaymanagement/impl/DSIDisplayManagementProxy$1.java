/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.displaymanagement.impl;

import de.esolutions.fw.comm.dsi.displaymanagement.impl.DSIDisplayManagementProxy;
import de.esolutions.fw.comm.dsi.displaymanagement.impl.DisplayContextSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.displaymanagement.DisplayContext;

class DSIDisplayManagementProxy$1
implements ISerializable {
    private final /* synthetic */ DisplayContext[] val$contextList;
    private final /* synthetic */ DSIDisplayManagementProxy this$0;

    DSIDisplayManagementProxy$1(DSIDisplayManagementProxy dSIDisplayManagementProxy, DisplayContext[] displayContextArray) {
        this.this$0 = dSIDisplayManagementProxy;
        this.val$contextList = displayContextArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        DisplayContextSerializer.putOptionalDisplayContextVarArray(iSerializer, this.val$contextList);
    }
}

