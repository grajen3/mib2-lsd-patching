/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.comm.dsi.media.impl.CoverartInfoSerializer;
import de.esolutions.fw.comm.dsi.media.impl.DSIMetadataServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.media.CoverartInfo;

class DSIMetadataServiceProxy$1
implements ISerializable {
    private final /* synthetic */ int val$jobID;
    private final /* synthetic */ CoverartInfo val$coverartInfo;
    private final /* synthetic */ DSIMetadataServiceProxy this$0;

    DSIMetadataServiceProxy$1(DSIMetadataServiceProxy dSIMetadataServiceProxy, int n, CoverartInfo coverartInfo) {
        this.this$0 = dSIMetadataServiceProxy;
        this.val$jobID = n;
        this.val$coverartInfo = coverartInfo;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$jobID);
        CoverartInfoSerializer.putOptionalCoverartInfo(iSerializer, this.val$coverartInfo);
    }
}

