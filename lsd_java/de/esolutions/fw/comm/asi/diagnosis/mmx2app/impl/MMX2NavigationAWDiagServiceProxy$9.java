/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy;
import de.esolutions.fw.comm.asi.diagnosis.navigation.impl.sNavCorrectedDirectionSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCorrectedDirection;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationAWDiagServiceProxy$9
implements ISerializable {
    private final /* synthetic */ sNavCorrectedDirection val$correctedDirection;
    private final /* synthetic */ MMX2NavigationAWDiagServiceProxy this$0;

    MMX2NavigationAWDiagServiceProxy$9(MMX2NavigationAWDiagServiceProxy mMX2NavigationAWDiagServiceProxy, sNavCorrectedDirection sNavCorrectedDirection2) {
        this.this$0 = mMX2NavigationAWDiagServiceProxy;
        this.val$correctedDirection = sNavCorrectedDirection2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sNavCorrectedDirectionSerializer.putOptionalsNavCorrectedDirection(iSerializer, this.val$correctedDirection);
    }
}

