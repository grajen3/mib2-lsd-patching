/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.androidauto.impl;

import de.esolutions.fw.comm.dsi.androidauto.impl.DSIAndroidAutoProxy;
import de.esolutions.fw.comm.dsi.androidauto.impl.TouchEventSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.androidauto.TouchEvent;

class DSIAndroidAutoProxy$2
implements ISerializable {
    private final /* synthetic */ int val$touchSource;
    private final /* synthetic */ TouchEvent[] val$pointers;
    private final /* synthetic */ int val$action;
    private final /* synthetic */ int val$actionIndex;
    private final /* synthetic */ DSIAndroidAutoProxy this$0;

    DSIAndroidAutoProxy$2(DSIAndroidAutoProxy dSIAndroidAutoProxy, int n, TouchEvent[] touchEventArray, int n2, int n3) {
        this.this$0 = dSIAndroidAutoProxy;
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

