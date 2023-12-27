/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.driving.impl;

import de.esolutions.fw.comm.asi.hmisync.car.driving.TADConfiguration;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.TADConfigurationSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarDrivingReplyProxy$5
implements ISerializable {
    private final /* synthetic */ TADConfiguration val$TADConfiguration;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarDrivingReplyProxy this$0;

    ASIHMISyncCarDrivingReplyProxy$5(ASIHMISyncCarDrivingReplyProxy aSIHMISyncCarDrivingReplyProxy, TADConfiguration tADConfiguration, boolean bl) {
        this.this$0 = aSIHMISyncCarDrivingReplyProxy;
        this.val$TADConfiguration = tADConfiguration;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        TADConfigurationSerializer.putOptionalTADConfiguration(iSerializer, this.val$TADConfiguration);
        iSerializer.putBool(this.val$isValid);
    }
}

