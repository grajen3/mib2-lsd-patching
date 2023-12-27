/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.headunit.impl;

import de.esolutions.fw.comm.asi.hmisync.headunit.CarConfiguration;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.CarConfigurationSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncHeadUnitReplyProxy$13
implements ISerializable {
    private final /* synthetic */ CarConfiguration val$CarConfiguration;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncHeadUnitReplyProxy this$0;

    ASIHMISyncHeadUnitReplyProxy$13(ASIHMISyncHeadUnitReplyProxy aSIHMISyncHeadUnitReplyProxy, CarConfiguration carConfiguration, boolean bl) {
        this.this$0 = aSIHMISyncHeadUnitReplyProxy;
        this.val$CarConfiguration = carConfiguration;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        CarConfigurationSerializer.putOptionalCarConfiguration(iSerializer, this.val$CarConfiguration);
        iSerializer.putBool(this.val$isValid);
    }
}

