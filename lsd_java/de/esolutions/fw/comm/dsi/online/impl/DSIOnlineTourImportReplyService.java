/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.online.DSIOnlineTourImportReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIOnlineTourImportReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.online.DSIOnlineTourImport");
    private static int dynamicHandle = 0;
    private DSIOnlineTourImportReply p_DSIOnlineTourImportReply;

    public DSIOnlineTourImportReplyService(DSIOnlineTourImportReply dSIOnlineTourImportReply) {
        super(new ServiceInstanceID("426b4e5c-52db-5f92-b26c-ea476cf9735e", DSIOnlineTourImportReplyService.nextDynamicHandle(), "490703e9-9991-5248-b8c4-930a7edcd612", "dsi.online.DSIOnlineTourImport"));
        this.p_DSIOnlineTourImportReply = dSIOnlineTourImportReply;
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
                case 7: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineTourImportReply.indicateToursAvailable(n);
                    break;
                }
                case 8: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineTourImportReply.responseTourDownload(n);
                    break;
                }
                case 6: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIOnlineTourImportReply.indicateTourDownloadFinished(n, string, string2, n2);
                    break;
                }
                case 1: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIOnlineTourImportReply.asyncException(n, string, n3);
                    break;
                }
                case 13: {
                    String string = iDeserializer.getOptionalString();
                    String string3 = iDeserializer.getOptionalString();
                    this.p_DSIOnlineTourImportReply.yyIndication(string, string3);
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

