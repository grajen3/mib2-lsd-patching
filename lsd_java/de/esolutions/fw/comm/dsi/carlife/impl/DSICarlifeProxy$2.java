/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlife.impl;

import de.esolutions.fw.comm.dsi.carlife.impl.DSICarlifeProxy;
import de.esolutions.fw.comm.dsi.carlife.impl.TouchEventSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carlife.TouchEvent;

class DSICarlifeProxy$2
implements ISerializable {
    private final /* synthetic */ int val$touchSource;
    private final /* synthetic */ TouchEvent[] val$pointers;
    private final /* synthetic */ int val$gesture;
    private final /* synthetic */ DSICarlifeProxy this$0;

    DSICarlifeProxy$2(DSICarlifeProxy dSICarlifeProxy, int n, TouchEvent[] touchEventArray, int n2) {
        this.this$0 = dSICarlifeProxy;
        this.val$touchSource = n;
        this.val$pointers = touchEventArray;
        this.val$gesture = n2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$touchSource);
        TouchEventSerializer.putOptionalTouchEventVarArray(iSerializer, this.val$pointers);
        iSerializer.putInt32(this.val$gesture);
    }
}

