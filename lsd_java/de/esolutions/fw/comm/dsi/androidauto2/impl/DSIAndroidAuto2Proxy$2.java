/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.androidauto2.impl;

import de.esolutions.fw.comm.dsi.androidauto2.impl.DSIAndroidAuto2Proxy;
import de.esolutions.fw.comm.dsi.androidauto2.impl.TouchEventSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.androidauto2.TouchEvent;

class DSIAndroidAuto2Proxy$2
implements ISerializable {
    private final /* synthetic */ int val$touchSource;
    private final /* synthetic */ TouchEvent[] val$pointers;
    private final /* synthetic */ int val$action;
    private final /* synthetic */ int val$actionIndex;
    private final /* synthetic */ DSIAndroidAuto2Proxy this$0;

    DSIAndroidAuto2Proxy$2(DSIAndroidAuto2Proxy dSIAndroidAuto2Proxy, int n, TouchEvent[] touchEventArray, int n2, int n3) {
        this.this$0 = dSIAndroidAuto2Proxy;
        this.val$touchSource = n;
        this.val$pointers = touchEventArray;
        this.val$action = n2;
        this.val$actionIndex = n3;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$touchSource);
        TouchEventSerializer.putOptionalTouchEventVarArray(iSerializer, this.val$pointers);
        iSerializer.putInt32(this.val$action);
        iSerializer.putInt32(this.val$actionIndex);
    }
}

