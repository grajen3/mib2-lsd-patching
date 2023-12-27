/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.organizer.DSIAdbInitReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIAdbInitReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.organizer.DSIAdbInit");
    private static int dynamicHandle = 0;
    private DSIAdbInitReply p_DSIAdbInitReply;

    public DSIAdbInitReplyService(DSIAdbInitReply dSIAdbInitReply) {
        super(new ServiceInstanceID("1269d6bb-274e-5f62-b76b-1600ed2924e4", DSIAdbInitReplyService.nextDynamicHandle(), "eb4873c9-aba1-5d89-b79b-04f665f38fb6", "dsi.organizer.DSIAdbInit"));
        this.p_DSIAdbInitReply = dSIAdbInitReply;
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
                case 27: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbInitReply.updateDefaultPublicProfileVisibility(bl, n);
                    break;
                }
                case 28: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIAdbInitReply.updateMaxLocalEntries(n, n2);
                    break;
                }
                case 29: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIAdbInitReply.updateMaxPhoneEntries(n, n3);
                    break;
                }
                case 31: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIAdbInitReply.updateMaxTopDestEntries(n, n4);
                    break;
                }
                case 30: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIAdbInitReply.updateMaxSpeedDialEntries(n, n5);
                    break;
                }
                case 26: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbInitReply.updateAutoProfileAllocation(bl, n);
                    break;
                }
                case 19: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbInitReply.setDefaultPublicProfileVisibilityResult(n);
                    break;
                }
                case 20: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbInitReply.setMaxLocalEntriesResult(n);
                    break;
                }
                case 21: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbInitReply.setMaxPhoneEntriesResult(n);
                    break;
                }
                case 23: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbInitReply.setMaxTopDestEntriesResult(n);
                    break;
                }
                case 22: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbInitReply.setMaxSpeedDialEntriesResult(n);
                    break;
                }
                case 24: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbInitReply.setNumericalSpellerEnabledResult(n);
                    break;
                }
                case 18: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbInitReply.setAutoProfileAllocationResult(n);
                    break;
                }
                case 25: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbInitReply.setSpeedDialTypeResult(n);
                    break;
                }
                case 16: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbInitReply.setProfileHandlingType(n);
                    break;
                }
                case 34: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbInitReply.setDefaultSortOrderResult(n);
                    break;
                }
                case 36: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbInitReply.setOnlineDestinationEnabledResult(n);
                    break;
                }
                case 38: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbInitReply.setDefaultSOSButtonResult(n);
                    break;
                }
                case 39: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbInitReply.updateDefaultSOSButton(bl, n);
                    break;
                }
                case 17: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIAdbInitReply.asyncException(n, string, n6);
                    break;
                }
                case 32: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIAdbInitReply.yyIndication(string, string2);
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

