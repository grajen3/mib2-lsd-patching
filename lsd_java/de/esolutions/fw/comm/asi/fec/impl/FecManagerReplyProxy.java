/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.FecManagerReply;
import de.esolutions.fw.comm.asi.fec.SFecDetails;
import de.esolutions.fw.comm.asi.fec.SFecHistory;
import de.esolutions.fw.comm.asi.fec.SFecImportStatus;
import de.esolutions.fw.comm.asi.fec.impl.FecManagerReplyProxy$1;
import de.esolutions.fw.comm.asi.fec.impl.FecManagerReplyProxy$2;
import de.esolutions.fw.comm.asi.fec.impl.FecManagerReplyProxy$3;
import de.esolutions.fw.comm.asi.fec.impl.FecManagerReplyProxy$4;
import de.esolutions.fw.comm.asi.fec.impl.FecManagerReplyProxy$5;
import de.esolutions.fw.comm.asi.fec.impl.FecManagerReplyProxy$6;
import de.esolutions.fw.comm.asi.fec.impl.FecManagerReplyProxy$7;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class FecManagerReplyProxy
implements FecManagerReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.fec.FecManager");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public FecManagerReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("7b2f491d-eea1-4197-9124-469efe2453d2", -1, "8db34658-32cf-5a16-a3fd-9571af38a1d3", "asi.fec.FecManager");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void checkDataSignature(String string, boolean bl) {
        FecManagerReplyProxy$1 fecManagerReplyProxy$1 = new FecManagerReplyProxy$1(this, string, bl);
        this.proxy.remoteCallMethod((short)1, fecManagerReplyProxy$1);
    }

    @Override
    public void fecDetails(SFecDetails sFecDetails) {
        FecManagerReplyProxy$2 fecManagerReplyProxy$2 = new FecManagerReplyProxy$2(this, sFecDetails);
        this.proxy.remoteCallMethod((short)15, fecManagerReplyProxy$2);
    }

    @Override
    public void importFecs(int n, SFecImportStatus[] sFecImportStatusArray) {
        FecManagerReplyProxy$3 fecManagerReplyProxy$3 = new FecManagerReplyProxy$3(this, n, sFecImportStatusArray);
        this.proxy.remoteCallMethod((short)13, fecManagerReplyProxy$3);
    }

    @Override
    public void exportCCD(int n) {
        FecManagerReplyProxy$4 fecManagerReplyProxy$4 = new FecManagerReplyProxy$4(this, n);
        this.proxy.remoteCallMethod((short)6, fecManagerReplyProxy$4);
    }

    @Override
    public void getHistory(SFecHistory[] sFecHistoryArray) {
        FecManagerReplyProxy$5 fecManagerReplyProxy$5 = new FecManagerReplyProxy$5(this, sFecHistoryArray);
        this.proxy.remoteCallMethod((short)11, fecManagerReplyProxy$5);
    }

    @Override
    public void encryptFile(String string, int n) {
        FecManagerReplyProxy$6 fecManagerReplyProxy$6 = new FecManagerReplyProxy$6(this, string, n);
        this.proxy.remoteCallMethod((short)4, fecManagerReplyProxy$6);
    }

    @Override
    public void decryptFile(String string, int n) {
        FecManagerReplyProxy$7 fecManagerReplyProxy$7 = new FecManagerReplyProxy$7(this, string, n);
        this.proxy.remoteCallMethod((short)2, fecManagerReplyProxy$7);
    }
}

