/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavSegmentIDSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavSegmentID;

class DSINavigationProxy$35
implements ISerializable {
    private final /* synthetic */ NavSegmentID[] val$traceIDs;
    private final /* synthetic */ String val$fileName;
    private final /* synthetic */ DSINavigationProxy this$0;

    DSINavigationProxy$35(DSINavigationProxy dSINavigationProxy, NavSegmentID[] navSegmentIDArray, String string) {
        this.this$0 = dSINavigationProxy;
        this.val$traceIDs = navSegmentIDArray;
        this.val$fileName = string;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavSegmentIDSerializer.putOptionalNavSegmentIDVarArray(iSerializer, this.val$traceIDs);
        iSerializer.putOptionalString(this.val$fileName);
    }
}

