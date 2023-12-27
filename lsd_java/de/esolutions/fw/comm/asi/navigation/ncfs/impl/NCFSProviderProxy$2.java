/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs.impl;

import de.esolutions.fw.comm.asi.navigation.ncfs.impl.NCFSProviderProxy;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.sBoundingBoxSerializer;
import de.esolutions.fw.comm.asi.navigation.ncfs.sBoundingBox;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class NCFSProviderProxy$2
implements ISerializable {
    private final /* synthetic */ sBoundingBox val$boundingBox;
    private final /* synthetic */ NCFSProviderProxy this$0;

    NCFSProviderProxy$2(NCFSProviderProxy nCFSProviderProxy, sBoundingBox sBoundingBox2) {
        this.this$0 = nCFSProviderProxy;
        this.val$boundingBox = sBoundingBox2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sBoundingBoxSerializer.putOptionalsBoundingBox(iSerializer, this.val$boundingBox);
    }
}

