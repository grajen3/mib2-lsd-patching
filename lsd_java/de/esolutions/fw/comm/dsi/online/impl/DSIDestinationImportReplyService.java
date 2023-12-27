/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.online.DSIDestinationImportReply;
import de.esolutions.fw.comm.dsi.online.impl.PortalADBEntrySerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.online.PortalADBEntry;

public class DSIDestinationImportReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.online.DSIDestinationImport");
    private static int dynamicHandle = 0;
    private DSIDestinationImportReply p_DSIDestinationImportReply;

    public DSIDestinationImportReplyService(DSIDestinationImportReply dSIDestinationImportReply) {
        super(new ServiceInstanceID("741c9acc-0404-5fb8-99c7-9cf87244aac9", DSIDestinationImportReplyService.nextDynamicHandle(), "4036fefc-0c4b-5c0e-afac-0d429dbc8f82", "dsi.online.DSIDestinationImport"));
        this.p_DSIDestinationImportReply = dSIDestinationImportReply;
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
                case 5: {
                    PortalADBEntry[] portalADBEntryArray = PortalADBEntrySerializer.getOptionalPortalADBEntryVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIDestinationImportReply.downloadAddressListResult(portalADBEntryArray, n, n2);
                    break;
                }
                case 11: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIDestinationImportReply.stopActionResult(n);
                    break;
                }
                case 14: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIDestinationImportReply.updateEntries(n, n3);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIDestinationImportReply.asyncException(n, string, n4);
                    break;
                }
                case 12: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIDestinationImportReply.yyIndication(string, string2);
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

