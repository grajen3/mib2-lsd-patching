/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.upnp.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.upnp.DSIUPNPBrowserReply;
import de.esolutions.fw.comm.dsi.upnp.impl.ListEntrySerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.upnp.ListEntry;

public class DSIUPNPBrowserReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.upnp.DSIUPNPBrowser");
    private static int dynamicHandle = 0;
    private DSIUPNPBrowserReply p_DSIUPNPBrowserReply;

    public DSIUPNPBrowserReplyService(DSIUPNPBrowserReply dSIUPNPBrowserReply) {
        super(new ServiceInstanceID("c595044a-be53-5cb5-a0bd-56eecee8fe4e", DSIUPNPBrowserReplyService.nextDynamicHandle(), "ed7163ca-c11b-587a-8ec4-a26a9780ba19", "dsi.upnp.DSIUPNPBrowser"));
        this.p_DSIUPNPBrowserReply = dSIUPNPBrowserReply;
    }

    private static synchronized int nextDynamicHandle() {
        int n = ++dynamicHandle;
        return n;
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 11: {
                    ListEntry[] listEntryArray = ListEntrySerializer.getOptionalListEntryVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIUPNPBrowserReply.updateBrowseFolder(listEntryArray, n);
                    break;
                }
                case 12: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIUPNPBrowserReply.updateListSize(n, n2, n3);
                    break;
                }
                case 7: {
                    ListEntry[] listEntryArray = ListEntrySerializer.getOptionalListEntryVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIUPNPBrowserReply.responseList(listEntryArray, n);
                    break;
                }
                case 5: {
                    this.p_DSIUPNPBrowserReply.invalidBrowsePath();
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIUPNPBrowserReply.asyncException(n, string, n4);
                    break;
                }
                case 13: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIUPNPBrowserReply.yyIndication(string, string2);
                    break;
                }
                default: {
                    throw new MethodException(new StringBuffer().append("Invalid Method Id ").append(s).toString());
                }
            }
        }
        catch (SerializerException serializerException) {
            throw new MethodException(new StringBuffer().append("Deserialization failed: method=").append(s).append(", error=").append(serializerException.getMessage()).toString());
        }
    }
}

