/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.mapregioninfo.impl;

import de.esolutions.fw.comm.asi.navigation.mapregioninfo.ComponentInfo;
import de.esolutions.fw.comm.asi.navigation.mapregioninfo.impl.ComponentInfoSerializer;
import de.esolutions.fw.comm.asi.navigation.mapregioninfo.impl.MapRegionInfoReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MapRegionInfoReplyProxy$3
implements ISerializable {
    private final /* synthetic */ int val$requestID;
    private final /* synthetic */ ComponentInfo[] val$componentInfo;
    private final /* synthetic */ int val$resultCode;
    private final /* synthetic */ MapRegionInfoReplyProxy this$0;

    MapRegionInfoReplyProxy$3(MapRegionInfoReplyProxy mapRegionInfoReplyProxy, int n, ComponentInfo[] componentInfoArray, int n2) {
        this.this$0 = mapRegionInfoReplyProxy;
        this.val$requestID = n;
        this.val$componentInfo = componentInfoArray;
        this.val$resultCode = n2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putUInt16(this.val$requestID);
        ComponentInfoSerializer.putOptionalComponentInfoVarArray(iSerializer, this.val$componentInfo);
        iSerializer.putEnum(this.val$resultCode);
    }
}

