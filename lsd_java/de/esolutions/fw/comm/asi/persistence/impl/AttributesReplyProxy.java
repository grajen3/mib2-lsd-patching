/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.persistence.impl;

import de.esolutions.fw.comm.asi.persistence.AttributesReply;
import de.esolutions.fw.comm.asi.persistence.impl.AttributesReplyProxy$1;
import de.esolutions.fw.comm.asi.persistence.impl.AttributesReplyProxy$2;
import de.esolutions.fw.comm.asi.persistence.impl.AttributesReplyProxy$3;
import de.esolutions.fw.comm.asi.persistence.impl.AttributesReplyProxy$4;
import de.esolutions.fw.comm.asi.persistence.impl.AttributesReplyProxy$5;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class AttributesReplyProxy
implements AttributesReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.persistence.Attributes");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public AttributesReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("f423654f-fed2-59d3-be18-59e9a9b2d05f", -1, "e5e426dc-4f2a-56e5-9b1b-8beaf406be7a", "asi.persistence.Attributes");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void unsubscribeResults(long[] lArray, long[] lArray2, int[] nArray) {
        AttributesReplyProxy$1 attributesReplyProxy$1 = new AttributesReplyProxy$1(this, lArray, lArray2, nArray);
        this.proxy.remoteCallMethod((short)10, attributesReplyProxy$1);
    }

    @Override
    public void stringValues(long[] lArray, long[] lArray2, String[] stringArray, int[] nArray) {
        AttributesReplyProxy$2 attributesReplyProxy$2 = new AttributesReplyProxy$2(this, lArray, lArray2, stringArray, nArray);
        this.proxy.remoteCallMethod((short)6, attributesReplyProxy$2);
    }

    @Override
    public void intValues(long[] lArray, long[] lArray2, int[] nArray, int[] nArray2) {
        AttributesReplyProxy$3 attributesReplyProxy$3 = new AttributesReplyProxy$3(this, lArray, lArray2, nArray, nArray2);
        this.proxy.remoteCallMethod((short)1, attributesReplyProxy$3);
    }

    @Override
    public void blobValues(long[] lArray, long[] lArray2, short[][] sArray, int[] nArray) {
        AttributesReplyProxy$4 attributesReplyProxy$4 = new AttributesReplyProxy$4(this, lArray, lArray2, sArray, nArray);
        this.proxy.remoteCallMethod((short)0, attributesReplyProxy$4);
    }

    @Override
    public void putResults(long[] lArray, long[] lArray2, int[] nArray) {
        AttributesReplyProxy$5 attributesReplyProxy$5 = new AttributesReplyProxy$5(this, lArray, lArray2, nArray);
        this.proxy.remoteCallMethod((short)4, attributesReplyProxy$5);
    }
}

