/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.powermanagement.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.powermanagement.DSIPowerManagementReply;
import de.esolutions.fw.comm.dsi.powermanagement.impl.ClampSignalSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.powermanagement.ClampSignal;

public class DSIPowerManagementReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.powermanagement.DSIPowerManagement");
    private static int dynamicHandle = 0;
    private DSIPowerManagementReply p_DSIPowerManagementReply;

    public DSIPowerManagementReplyService(DSIPowerManagementReply dSIPowerManagementReply) {
        super(new ServiceInstanceID("6f03b6fa-61a3-550e-b68d-542d13666d43", DSIPowerManagementReplyService.nextDynamicHandle(), "8fff252e-ea27-52bc-8f1f-2bc868ac2c70", "dsi.powermanagement.DSIPowerManagement"));
        this.p_DSIPowerManagementReply = dSIPowerManagementReply;
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
                case 18: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIPowerManagementReply.updatePowerManagementState(n, n2, n3);
                    break;
                }
                case 19: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIPowerManagementReply.updatePowerManagementStateRight(n, n4, n5);
                    break;
                }
                case 14: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIPowerManagementReply.updateBEMState(n, n6);
                    break;
                }
                case 22: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIPowerManagementReply.updateTelMaxPopup(bl, n);
                    break;
                }
                case 25: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIPowerManagementReply.updateTStandbyPopup(bl, n);
                    break;
                }
                case 16: {
                    ClampSignal clampSignal = ClampSignalSerializer.getOptionalClampSignal(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIPowerManagementReply.updateClampSignal(clampSignal, n);
                    break;
                }
                case 20: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIPowerManagementReply.updateRVCActive(bl, n);
                    break;
                }
                case 15: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIPowerManagementReply.updateChildLockState(n, n7);
                    break;
                }
                case 17: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSIPowerManagementReply.updateLastOn(n, n8);
                    break;
                }
                case 21: {
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSIPowerManagementReply.updateSplashScreenAnimation(n, n9);
                    break;
                }
                case 13: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSIPowerManagementReply.asyncException(n, string, n10);
                    break;
                }
                case 23: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIPowerManagementReply.yyIndication(string, string2);
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

