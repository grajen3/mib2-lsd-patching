/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.organizer.DSIAdbSetupReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIAdbSetupReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.organizer.DSIAdbSetup");
    private static int dynamicHandle = 0;
    private DSIAdbSetupReply p_DSIAdbSetupReply;

    public DSIAdbSetupReplyService(DSIAdbSetupReply dSIAdbSetupReply) {
        super(new ServiceInstanceID("cc1266c2-e252-54fa-8a38-76eb4551247b", DSIAdbSetupReplyService.nextDynamicHandle(), "3eae9550-165e-55c9-b8bf-5515a3b98ee4", "dsi.organizer.DSIAdbSetup"));
        this.p_DSIAdbSetupReply = dSIAdbSetupReply;
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
                case 22: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIAdbSetupReply.updateAdbState(n, n2);
                    break;
                }
                case 23: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIAdbSetupReply.updateSortOrder(n, n3);
                    break;
                }
                case 30: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbSetupReply.updatePictureVisibility(bl, n);
                    break;
                }
                case 19: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbSetupReply.setLanguageResult(n);
                    break;
                }
                case 21: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbSetupReply.setSortOrderResult(n);
                    break;
                }
                case 20: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbSetupReply.setPublicProfileVisibilityResult(n);
                    break;
                }
                case 17: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbSetupReply.resetToFactorySettingsResult(n);
                    break;
                }
                case 18: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbSetupReply.resetTopDestinationResult(n);
                    break;
                }
                case 15: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    this.p_DSIAdbSetupReply.createBackupFileResult(n, string);
                    break;
                }
                case 16: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    this.p_DSIAdbSetupReply.importBackupFileResult(n, string);
                    break;
                }
                case 28: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbSetupReply.setPictureVisibilityResult(n);
                    break;
                }
                case 26: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbSetupReply.setContextSpecificVisibilityResult(n);
                    break;
                }
                case 29: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbSetupReply.updateContextSpecificVisibility(bl, n);
                    break;
                }
                case 14: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIAdbSetupReply.asyncException(n, string, n4);
                    break;
                }
                case 24: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIAdbSetupReply.yyIndication(string, string2);
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

