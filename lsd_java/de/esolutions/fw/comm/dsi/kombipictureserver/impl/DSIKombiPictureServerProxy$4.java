/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombipictureserver.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.kombipictureserver.impl.DSIKombiPictureServerProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;

class DSIKombiPictureServerProxy$4
implements ISerializable {
    private final /* synthetic */ int val$phoneInstance;
    private final /* synthetic */ int val$callID;
    private final /* synthetic */ int val$activeCallPictureType;
    private final /* synthetic */ ResourceLocator val$resource;
    private final /* synthetic */ DSIKombiPictureServerProxy this$0;

    DSIKombiPictureServerProxy$4(DSIKombiPictureServerProxy dSIKombiPictureServerProxy, int n, int n2, int n3, ResourceLocator resourceLocator) {
        this.this$0 = dSIKombiPictureServerProxy;
        this.val$phoneInstance = n;
        this.val$callID = n2;
        this.val$activeCallPictureType = n3;
        this.val$resource = resourceLocator;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$phoneInstance);
        iSerializer.putInt32(this.val$callID);
        iSerializer.putInt32(this.val$activeCallPictureType);
        ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, this.val$resource);
    }
}

