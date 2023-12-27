/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.displaymanagement.impl;

import de.esolutions.fw.comm.dsi.displaymanagement.impl.DSIDisplayManagementProxy;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;

class DSIDisplayManagementProxy$2
implements ISerializable {
    private final /* synthetic */ ResourceLocator val$resourceLocator;
    private final /* synthetic */ int val$cid;
    private final /* synthetic */ DSIDisplayManagementProxy this$0;

    DSIDisplayManagementProxy$2(DSIDisplayManagementProxy dSIDisplayManagementProxy, ResourceLocator resourceLocator, int n) {
        this.this$0 = dSIDisplayManagementProxy;
        this.val$resourceLocator = resourceLocator;
        this.val$cid = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, this.val$resourceLocator);
        iSerializer.putInt32(this.val$cid);
    }
}

