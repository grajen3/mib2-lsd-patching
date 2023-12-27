/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.media.impl.sMediaTypeOpticalDriveSerializer;
import de.esolutions.fw.comm.asi.diagnosis.media.sMediaTypeOpticalDrive;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2MediaDiagServiceProxy$6
implements ISerializable {
    private final /* synthetic */ sMediaTypeOpticalDrive val$mediaType;
    private final /* synthetic */ MMX2MediaDiagServiceProxy this$0;

    MMX2MediaDiagServiceProxy$6(MMX2MediaDiagServiceProxy mMX2MediaDiagServiceProxy, sMediaTypeOpticalDrive sMediaTypeOpticalDrive2) {
        this.this$0 = mMX2MediaDiagServiceProxy;
        this.val$mediaType = sMediaTypeOpticalDrive2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sMediaTypeOpticalDriveSerializer.putOptionalsMediaTypeOpticalDrive(iSerializer, this.val$mediaType);
    }
}

