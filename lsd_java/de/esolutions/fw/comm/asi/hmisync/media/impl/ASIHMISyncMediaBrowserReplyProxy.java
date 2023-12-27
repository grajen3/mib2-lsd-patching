/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaBrowserReply;
import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserReplyProxy$1;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserReplyProxy$10;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserReplyProxy$11;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserReplyProxy$12;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserReplyProxy$2;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserReplyProxy$3;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserReplyProxy$4;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserReplyProxy$5;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserReplyProxy$6;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserReplyProxy$7;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserReplyProxy$8;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserReplyProxy$9;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class ASIHMISyncMediaBrowserReplyProxy
implements ASIHMISyncMediaBrowserReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.media.ASIHMISyncMediaBrowser");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public ASIHMISyncMediaBrowserReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("d77696f4-48c5-4b8c-9855-fe17f312507c", -1, "45baad1f-9553-5ee9-b624-8c7cb4344305", "asi.hmisync.media.ASIHMISyncMediaBrowser");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void responseChangeFolder(boolean bl) {
        ASIHMISyncMediaBrowserReplyProxy$1 aSIHMISyncMediaBrowserReplyProxy$1 = new ASIHMISyncMediaBrowserReplyProxy$1(this, bl);
        this.proxy.remoteCallMethod((short)9, aSIHMISyncMediaBrowserReplyProxy$1);
    }

    @Override
    public void responseAddSelection(boolean bl) {
        ASIHMISyncMediaBrowserReplyProxy$2 aSIHMISyncMediaBrowserReplyProxy$2 = new ASIHMISyncMediaBrowserReplyProxy$2(this, bl);
        this.proxy.remoteCallMethod((short)8, aSIHMISyncMediaBrowserReplyProxy$2);
    }

    @Override
    public void responseList(boolean bl, int n, MediaEntry[] mediaEntryArray) {
        ASIHMISyncMediaBrowserReplyProxy$3 aSIHMISyncMediaBrowserReplyProxy$3 = new ASIHMISyncMediaBrowserReplyProxy$3(this, bl, n, mediaEntryArray);
        this.proxy.remoteCallMethod((short)10, aSIHMISyncMediaBrowserReplyProxy$3);
    }

    @Override
    public void updateASIVersion(String string, boolean bl) {
        ASIHMISyncMediaBrowserReplyProxy$4 aSIHMISyncMediaBrowserReplyProxy$4 = new ASIHMISyncMediaBrowserReplyProxy$4(this, string, bl);
        this.proxy.remoteCallMethod((short)15, aSIHMISyncMediaBrowserReplyProxy$4);
    }

    @Override
    public void updateRequestIDs(short[] sArray, boolean bl) {
        ASIHMISyncMediaBrowserReplyProxy$5 aSIHMISyncMediaBrowserReplyProxy$5 = new ASIHMISyncMediaBrowserReplyProxy$5(this, sArray, bl);
        this.proxy.remoteCallMethod((short)23, aSIHMISyncMediaBrowserReplyProxy$5);
    }

    @Override
    public void updateReplyIDs(short[] sArray, boolean bl) {
        ASIHMISyncMediaBrowserReplyProxy$6 aSIHMISyncMediaBrowserReplyProxy$6 = new ASIHMISyncMediaBrowserReplyProxy$6(this, sArray, bl);
        this.proxy.remoteCallMethod((short)22, aSIHMISyncMediaBrowserReplyProxy$6);
    }

    @Override
    public void updateActiveSlot(MediaSourceSlot mediaSourceSlot, boolean bl) {
        ASIHMISyncMediaBrowserReplyProxy$7 aSIHMISyncMediaBrowserReplyProxy$7 = new ASIHMISyncMediaBrowserReplyProxy$7(this, mediaSourceSlot, bl);
        this.proxy.remoteCallMethod((short)16, aSIHMISyncMediaBrowserReplyProxy$7);
    }

    @Override
    public void updateBrowseMode(int n, boolean bl) {
        ASIHMISyncMediaBrowserReplyProxy$8 aSIHMISyncMediaBrowserReplyProxy$8 = new ASIHMISyncMediaBrowserReplyProxy$8(this, n, bl);
        this.proxy.remoteCallMethod((short)18, aSIHMISyncMediaBrowserReplyProxy$8);
    }

    @Override
    public void updateDatabaseMode(boolean bl, boolean bl2) {
        ASIHMISyncMediaBrowserReplyProxy$9 aSIHMISyncMediaBrowserReplyProxy$9 = new ASIHMISyncMediaBrowserReplyProxy$9(this, bl, bl2);
        this.proxy.remoteCallMethod((short)19, aSIHMISyncMediaBrowserReplyProxy$9);
    }

    @Override
    public void updateRawMode(boolean bl, boolean bl2) {
        ASIHMISyncMediaBrowserReplyProxy$10 aSIHMISyncMediaBrowserReplyProxy$10 = new ASIHMISyncMediaBrowserReplyProxy$10(this, bl, bl2);
        this.proxy.remoteCallMethod((short)21, aSIHMISyncMediaBrowserReplyProxy$10);
    }

    @Override
    public void updateBrowseFolder(MediaEntry[] mediaEntryArray, boolean bl) {
        ASIHMISyncMediaBrowserReplyProxy$11 aSIHMISyncMediaBrowserReplyProxy$11 = new ASIHMISyncMediaBrowserReplyProxy$11(this, mediaEntryArray, bl);
        this.proxy.remoteCallMethod((short)17, aSIHMISyncMediaBrowserReplyProxy$11);
    }

    @Override
    public void updateListSize(int n, boolean bl) {
        ASIHMISyncMediaBrowserReplyProxy$12 aSIHMISyncMediaBrowserReplyProxy$12 = new ASIHMISyncMediaBrowserReplyProxy$12(this, n, bl);
        this.proxy.remoteCallMethod((short)20, aSIHMISyncMediaBrowserReplyProxy$12);
    }
}

