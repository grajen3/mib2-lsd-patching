/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.sdis.version.impl;

import de.esolutions.fw.comm.asi.sdis.version.SDISVersionReply;
import de.esolutions.fw.comm.asi.sdis.version.impl.SDISVersionReplyProxy$1;
import de.esolutions.fw.comm.asi.sdis.version.impl.SDISVersionReplyProxy$2;
import de.esolutions.fw.comm.asi.sdis.version.impl.SDISVersionReplyProxy$3;
import de.esolutions.fw.comm.asi.sdis.version.impl.SDISVersionReplyProxy$4;
import de.esolutions.fw.comm.asi.sdis.version.impl.SDISVersionReplyProxy$5;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class SDISVersionReplyProxy
implements SDISVersionReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.sdis.version.SDISVersion");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public SDISVersionReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("af682e42-9d3b-11e3-8d05-425861b86ab6", -1, "d416a5aa-8b20-525c-a84a-e810898c7325", "asi.sdis.version.SDISVersion");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void updateASIVersion(String string, boolean bl) {
        SDISVersionReplyProxy$1 sDISVersionReplyProxy$1 = new SDISVersionReplyProxy$1(this, string, bl);
        this.proxy.remoteCallMethod((short)6, sDISVersionReplyProxy$1);
    }

    @Override
    public void updateSDISInterfaceVersion(String string, boolean bl) {
        SDISVersionReplyProxy$2 sDISVersionReplyProxy$2 = new SDISVersionReplyProxy$2(this, string, bl);
        this.proxy.remoteCallMethod((short)10, sDISVersionReplyProxy$2);
    }

    @Override
    public void updateMMXSWVersion(String string, boolean bl) {
        SDISVersionReplyProxy$3 sDISVersionReplyProxy$3 = new SDISVersionReplyProxy$3(this, string, bl);
        this.proxy.remoteCallMethod((short)8, sDISVersionReplyProxy$3);
    }

    @Override
    public void updateMMXSKUVersion(String string, boolean bl) {
        SDISVersionReplyProxy$4 sDISVersionReplyProxy$4 = new SDISVersionReplyProxy$4(this, string, bl);
        this.proxy.remoteCallMethod((short)7, sDISVersionReplyProxy$4);
    }

    @Override
    public void updateMUDetailedVersion(String string, boolean bl) {
        SDISVersionReplyProxy$5 sDISVersionReplyProxy$5 = new SDISVersionReplyProxy$5(this, string, bl);
        this.proxy.remoteCallMethod((short)9, sDISVersionReplyProxy$5);
    }
}

