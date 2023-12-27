/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice.impl;

import de.esolutions.fw.comm.asi.online.coreservice.License;
import de.esolutions.fw.comm.asi.online.coreservice.impl.ExtOnlineCoreServiceReplyProxy;
import de.esolutions.fw.comm.asi.online.coreservice.impl.LicenseSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ExtOnlineCoreServiceReplyProxy$9
implements ISerializable {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ License[] val$license;
    private final /* synthetic */ ExtOnlineCoreServiceReplyProxy this$0;

    ExtOnlineCoreServiceReplyProxy$9(ExtOnlineCoreServiceReplyProxy extOnlineCoreServiceReplyProxy, int n, License[] licenseArray) {
        this.this$0 = extOnlineCoreServiceReplyProxy;
        this.val$result = n;
        this.val$license = licenseArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putEnum(this.val$result);
        LicenseSerializer.putOptionalLicenseVarArray(iSerializer, this.val$license);
    }
}

