/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.uotanaviservice.impl;

import de.esolutions.fw.comm.asi.navigation.mapregioninfo.ComponentInfo;
import de.esolutions.fw.comm.asi.navigation.mapregioninfo.impl.ComponentInfoSerializer;
import de.esolutions.fw.comm.asi.navigation.uotanaviservice.impl.UOTANaviServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class UOTANaviServiceProxy$1
implements ISerializable {
    private final /* synthetic */ short val$uniqueId;
    private final /* synthetic */ ComponentInfo[] val$versionInfo;
    private final /* synthetic */ int val$resultCode;
    private final /* synthetic */ UOTANaviServiceProxy this$0;

    UOTANaviServiceProxy$1(UOTANaviServiceProxy uOTANaviServiceProxy, short s, ComponentInfo[] componentInfoArray, int n) {
        this.this$0 = uOTANaviServiceProxy;
        this.val$uniqueId = s;
        this.val$versionInfo = componentInfoArray;
        this.val$resultCode = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt16(this.val$uniqueId);
        ComponentInfoSerializer.putOptionalComponentInfoVarArray(iSerializer, this.val$versionInfo);
        iSerializer.putEnum(this.val$resultCode);
    }
}

