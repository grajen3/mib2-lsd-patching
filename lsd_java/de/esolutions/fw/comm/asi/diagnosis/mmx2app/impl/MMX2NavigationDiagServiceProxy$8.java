/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy;
import de.esolutions.fw.comm.asi.diagnosis.navigation.impl.sNavCorrectedPositionSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCorrectedPosition;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationDiagServiceProxy$8
implements ISerializable {
    private final /* synthetic */ sNavCorrectedPosition val$correctedPosition;
    private final /* synthetic */ MMX2NavigationDiagServiceProxy this$0;

    MMX2NavigationDiagServiceProxy$8(MMX2NavigationDiagServiceProxy mMX2NavigationDiagServiceProxy, sNavCorrectedPosition sNavCorrectedPosition2) {
        this.this$0 = mMX2NavigationDiagServiceProxy;
        this.val$correctedPosition = sNavCorrectedPosition2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sNavCorrectedPositionSerializer.putOptionalsNavCorrectedPosition(iSerializer, this.val$correctedPosition);
    }
}

