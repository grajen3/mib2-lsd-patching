/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombipictureserver.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.kombipictureserver.impl.DSIKombiPictureServerProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;

class DSIKombiPictureServerProxy$5
implements ISerializable {
    private final /* synthetic */ int val$iconType;
    private final /* synthetic */ int val$sourceListReference;
    private final /* synthetic */ boolean val$validity;
    private final /* synthetic */ ResourceLocator val$resource;
    private final /* synthetic */ DSIKombiPictureServerProxy this$0;

    DSIKombiPictureServerProxy$5(DSIKombiPictureServerProxy dSIKombiPictureServerProxy, int n, int n2, boolean bl, ResourceLocator resourceLocator) {
        this.this$0 = dSIKombiPictureServerProxy;
        this.val$iconType = n;
        this.val$sourceListReference = n2;
        this.val$validity = bl;
        this.val$resource = resourceLocator;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$iconType);
        iSerializer.putInt32(this.val$sourceListReference);
        iSerializer.putBool(this.val$validity);
        ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, this.val$resource);
    }
}

