/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.networking.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.networking.DSIDataConnectionReply;
import de.esolutions.fw.comm.dsi.networking.impl.ApplicationErrorStructSerializer;
import de.esolutions.fw.comm.dsi.networking.impl.ConnectionStateInformationStructSerializer;
import de.esolutions.fw.comm.dsi.networking.impl.DataConnectionStateStructSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.networking.ApplicationErrorStruct;
import org.dsi.ifc.networking.ConnectionStateInformationStruct;
import org.dsi.ifc.networking.DataConnectionStateStruct;

public class DSIDataConnectionReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.networking.DSIDataConnection");
    private static int dynamicHandle = 0;
    private DSIDataConnectionReply p_DSIDataConnectionReply;

    public DSIDataConnectionReplyService(DSIDataConnectionReply dSIDataConnectionReply) {
        super(new ServiceInstanceID("f6749804-3a69-5465-9822-1d5ccfd38720", DSIDataConnectionReplyService.nextDynamicHandle(), "ac66c0fa-deb7-50a6-834e-d94bf9a5b7ea", "dsi.networking.DSIDataConnection"));
        this.p_DSIDataConnectionReply = dSIDataConnectionReply;
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
                case 16: {
                    DataConnectionStateStruct dataConnectionStateStruct = DataConnectionStateStructSerializer.getOptionalDataConnectionStateStruct(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIDataConnectionReply.updateStateDataConnection(dataConnectionStateStruct, n);
                    break;
                }
                case 13: {
                    ConnectionStateInformationStruct connectionStateInformationStruct = ConnectionStateInformationStructSerializer.getOptionalConnectionStateInformationStruct(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIDataConnectionReply.updateConnectionStateInformation(connectionStateInformationStruct, n);
                    break;
                }
                case 15: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIDataConnectionReply.updateRoamingState(n, n2);
                    break;
                }
                case 14: {
                    ApplicationErrorStruct applicationErrorStruct = ApplicationErrorStructSerializer.getOptionalApplicationErrorStruct(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIDataConnectionReply.updateErrorState(applicationErrorStruct, n);
                    break;
                }
                case 9: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIDataConnectionReply.forceDisconnectResponse(n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIDataConnectionReply.asyncException(n, string, n3);
                    break;
                }
                case 17: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIDataConnectionReply.yyIndication(string, string2);
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

