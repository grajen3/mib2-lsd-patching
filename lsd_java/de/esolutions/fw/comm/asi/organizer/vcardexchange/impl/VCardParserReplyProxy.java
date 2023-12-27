/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.organizer.vcardexchange.impl;

import de.esolutions.fw.comm.asi.organizer.vcardexchange.VCardParserReply;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.impl.VCardParserReplyProxy$1;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.impl.VCardParserReplyProxy$2;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.impl.VCardParserReplyProxy$3;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.impl.VCardParserReplyProxy$4;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.impl.VCardParserReplyProxy$5;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.impl.VCardParserReplyProxy$6;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.impl.VCardParserReplyProxy$7;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.impl.VCardParserReplyProxy$8;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.impl.VCardParserReplyProxy$9;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import org.dsi.ifc.organizer.AdbEntry;

public class VCardParserReplyProxy
implements VCardParserReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.organizer.vcardexchange.VCardParser");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public VCardParserReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("c4084aff-df82-4408-b56c-2aef1da8ec7e", -1, "167912de-3ac1-5a6e-8756-89022777b8bc", "asi.organizer.vcardexchange.VCardParser");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void parseVCardResult(int n, AdbEntry adbEntry, int n2, int n3) {
        VCardParserReplyProxy$1 vCardParserReplyProxy$1 = new VCardParserReplyProxy$1(this, n, adbEntry, n2, n3);
        this.proxy.remoteCallMethod((short)27, vCardParserReplyProxy$1);
    }

    @Override
    public void parseVCardDirectoryResult(int n, AdbEntry[] adbEntryArray, int n2, int n3) {
        VCardParserReplyProxy$2 vCardParserReplyProxy$2 = new VCardParserReplyProxy$2(this, n, adbEntryArray, n2, n3);
        this.proxy.remoteCallMethod((short)26, vCardParserReplyProxy$2);
    }

    @Override
    public void exportVCardResult(int n, String string, int n2) {
        VCardParserReplyProxy$3 vCardParserReplyProxy$3 = new VCardParserReplyProxy$3(this, n, string, n2);
        this.proxy.remoteCallMethod((short)4, vCardParserReplyProxy$3);
    }

    @Override
    public void exportSmallVCardResult(int n, String string, int n2) {
        VCardParserReplyProxy$4 vCardParserReplyProxy$4 = new VCardParserReplyProxy$4(this, n, string, n2);
        this.proxy.remoteCallMethod((short)2, vCardParserReplyProxy$4);
    }

    @Override
    public void parsingFinished(int n) {
        VCardParserReplyProxy$5 vCardParserReplyProxy$5 = new VCardParserReplyProxy$5(this, n);
        this.proxy.remoteCallMethod((short)12, vCardParserReplyProxy$5);
    }

    @Override
    public void exportFinished(int n, int n2) {
        VCardParserReplyProxy$6 vCardParserReplyProxy$6 = new VCardParserReplyProxy$6(this, n, n2);
        this.proxy.remoteCallMethod((short)22, vCardParserReplyProxy$6);
    }

    @Override
    public void smallExportFinished(int n, long[] lArray, int n2, String string, int n3) {
        VCardParserReplyProxy$7 vCardParserReplyProxy$7 = new VCardParserReplyProxy$7(this, n, lArray, n2, string, n3);
        this.proxy.remoteCallMethod((short)17, vCardParserReplyProxy$7);
    }

    @Override
    public void setBinaryContentTempPathResult(int n, String string) {
        VCardParserReplyProxy$8 vCardParserReplyProxy$8 = new VCardParserReplyProxy$8(this, n, string);
        this.proxy.remoteCallMethod((short)16, vCardParserReplyProxy$8);
    }

    @Override
    public void setBinaryContentQuotaPerFileResult(int n, long l) {
        VCardParserReplyProxy$9 vCardParserReplyProxy$9 = new VCardParserReplyProxy$9(this, n, l);
        this.proxy.remoteCallMethod((short)14, vCardParserReplyProxy$9);
    }
}

