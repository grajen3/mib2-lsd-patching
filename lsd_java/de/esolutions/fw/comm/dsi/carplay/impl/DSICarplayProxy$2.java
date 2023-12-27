/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carplay.impl;

import de.esolutions.fw.comm.dsi.carplay.impl.DSICarplayProxy;
import de.esolutions.fw.comm.dsi.carplay.impl.TouchEventSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carplay.TouchEvent;

class DSICarplayProxy$2
implements ISerializable {
    private final /* synthetic */ int val$touchSource;
    private final /* synthetic */ int val$numberOfFingers;
    private final /* synthetic */ TouchEvent[] val$touchEvents;
    private final /* synthetic */ DSICarplayProxy this$0;

    DSICarplayProxy$2(DSICarplayProxy dSICarplayProxy, int n, int n2, TouchEvent[] touchEventArray) {
        this.this$0 = dSICarplayProxy;
        this.val$touchSource = n;
        this.val$numberOfFingers = n2;
        this.val$touchEvents = touchEventArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$touchSource);
        iSerializer.putInt32(this.val$numberOfFingers);
        TouchEventSerializer.putOptionalTouchEventVarArray(iSerializer, this.val$touchEvents);
    }
}

