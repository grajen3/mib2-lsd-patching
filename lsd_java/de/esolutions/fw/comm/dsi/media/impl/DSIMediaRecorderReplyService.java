/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.media.DSIMediaRecorderReply;
import de.esolutions.fw.comm.dsi.media.impl.DatabaseSpaceSerializer;
import de.esolutions.fw.comm.dsi.media.impl.ListEntrySerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.media.DatabaseSpace;
import org.dsi.ifc.media.ListEntry;

public class DSIMediaRecorderReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.media.DSIMediaRecorder");
    private static int dynamicHandle = 0;
    private DSIMediaRecorderReply p_DSIMediaRecorderReply;

    public DSIMediaRecorderReplyService(DSIMediaRecorderReply dSIMediaRecorderReply) {
        super(new ServiceInstanceID("53731708-ed5a-5568-9cc2-de4fb8d324ab", DSIMediaRecorderReplyService.nextDynamicHandle(), "c64e24f0-2106-5742-87b0-661dfecd5ce0", "dsi.media.DSIMediaRecorder"));
        this.p_DSIMediaRecorderReply = dSIMediaRecorderReply;
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
                case 17: {
                    long l = iDeserializer.getInt64();
                    long l2 = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMediaRecorderReply.updateActiveMedia(l, l2, n);
                    break;
                }
                case 7: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_DSIMediaRecorderReply.responseSetSelection(n, bl);
                    break;
                }
                case 23: {
                    long l = iDeserializer.getInt64();
                    long l3 = iDeserializer.getInt64();
                    long l4 = iDeserializer.getInt64();
                    long l5 = iDeserializer.getInt64();
                    long l6 = iDeserializer.getInt64();
                    long l7 = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMediaRecorderReply.updateImportSummary(l, l3, l4, l5, l6, l7, n);
                    break;
                }
                case 28: {
                    long l = iDeserializer.getInt64();
                    ListEntry listEntry = ListEntrySerializer.getOptionalListEntry(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMediaRecorderReply.updateImportProgress(l, listEntry, n);
                    break;
                }
                case 22: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIMediaRecorderReply.updateImportStatus(n, n2);
                    break;
                }
                case 19: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMediaRecorderReply.updateDeletionProgress(l, n);
                    break;
                }
                case 20: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIMediaRecorderReply.updateDeletionStatus(n, n3);
                    break;
                }
                case 18: {
                    DatabaseSpace databaseSpace = DatabaseSpaceSerializer.getOptionalDatabaseSpace(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMediaRecorderReply.updateDatabaseSpace(databaseSpace, n);
                    break;
                }
                case 24: {
                    long l = iDeserializer.getInt64();
                    long l8 = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMediaRecorderReply.updateTargetMedia(l, l8, n);
                    break;
                }
                case 6: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMediaRecorderReply.responseSetEncodingQuality(n);
                    break;
                }
                case 2: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIMediaRecorderReply.asyncException(n, string, n4);
                    break;
                }
                case 25: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIMediaRecorderReply.yyIndication(string, string2);
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

