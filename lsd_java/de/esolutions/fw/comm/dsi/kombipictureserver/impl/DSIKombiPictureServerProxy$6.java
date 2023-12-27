/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombipictureserver.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.kombipictureserver.impl.DSIKombiPictureServerProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;

class DSIKombiPictureServerProxy$6
implements ISerializable {
    private final /* synthetic */ long val$address;
    private final /* synthetic */ int val$addressType;
    private final /* synthetic */ int val$adbContactPictureType;
    private final /* synthetic */ ResourceLocator val$resource;
    private final /* synthetic */ DSIKombiPictureServerProxy this$0;

    DSIKombiPictureServerProxy$6(DSIKombiPictureServerProxy dSIKombiPictureServerProxy, long l, int n, int n2, ResourceLocator resourceLocator) {
        this.this$0 = dSIKombiPictureServerProxy;
        this.val$address = l;
        this.val$addressType = n;
        this.val$adbContactPictureType = n2;
        this.val$resource = resourceLocator;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt64(this.val$address);
        iSerializer.putInt32(this.val$addressType);
        iSerializer.putInt32(this.val$adbContactPictureType);
        ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, this.val$resource);
    }
}

