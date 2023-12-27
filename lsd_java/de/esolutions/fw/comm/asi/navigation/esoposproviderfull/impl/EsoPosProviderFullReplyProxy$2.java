/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl;

import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl.EsoPosProviderFullReplyProxy;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl.sMapPositionSerializer;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl.sPositionSerializer;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.sMapPosition;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.sPosition;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class EsoPosProviderFullReplyProxy$2
implements ISerializable {
    private final /* synthetic */ String[] val$positionNmea;
    private final /* synthetic */ sMapPosition val$position;
    private final /* synthetic */ sPosition[] val$predictedPosition;
    private final /* synthetic */ EsoPosProviderFullReplyProxy this$0;

    EsoPosProviderFullReplyProxy$2(EsoPosProviderFullReplyProxy esoPosProviderFullReplyProxy, String[] stringArray, sMapPosition sMapPosition2, sPosition[] sPositionArray) {
        this.this$0 = esoPosProviderFullReplyProxy;
        this.val$positionNmea = stringArray;
        this.val$position = sMapPosition2;
        this.val$predictedPosition = sPositionArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalStringVarArray(this.val$positionNmea);
        sMapPositionSerializer.putOptionalsMapPosition(iSerializer, this.val$position);
        sPositionSerializer.putOptionalsPositionVarArray(iSerializer, this.val$predictedPosition);
    }
}

