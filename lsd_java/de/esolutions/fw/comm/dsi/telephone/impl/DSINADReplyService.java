/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.telephone.DSINADReply;
import de.esolutions.fw.comm.dsi.telephone.impl.ActivationStateStructSerializer;
import de.esolutions.fw.comm.dsi.telephone.impl.LockStateStructSerializer;
import de.esolutions.fw.comm.dsi.telephone.impl.NADTemperatureStructSerializer;
import de.esolutions.fw.comm.dsi.telephone.impl.NetworkProviderNameSerializer;
import de.esolutions.fw.comm.dsi.telephone.impl.NetworkProviderSerializer;
import de.esolutions.fw.comm.dsi.telephone.impl.PhoneInformationSerializer;
import de.esolutions.fw.comm.dsi.telephone.impl.RegisterStateStructSerializer;
import de.esolutions.fw.comm.dsi.telephone.impl.ServiceProviderSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.telephone.ActivationStateStruct;
import org.dsi.ifc.telephone.LockStateStruct;
import org.dsi.ifc.telephone.NADTemperatureStruct;
import org.dsi.ifc.telephone.NetworkProvider;
import org.dsi.ifc.telephone.NetworkProviderName;
import org.dsi.ifc.telephone.PhoneInformation;
import org.dsi.ifc.telephone.RegisterStateStruct;
import org.dsi.ifc.telephone.ServiceProvider;

public class DSINADReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.telephone.DSINAD");
    private static int dynamicHandle = 0;
    private DSINADReply p_DSINADReply;

    public DSINADReplyService(DSINADReply dSINADReply) {
        super(new ServiceInstanceID("744f9c7a-3f01-5ae1-a600-1f677f1c9032", DSINADReplyService.nextDynamicHandle(), "a1072e44-3963-5f62-9f7a-427c15ebcd0f", "dsi.telephone.DSINAD"));
        this.p_DSINADReply = dSINADReply;
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
                case 14: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINADReply.responseAbortNetworkRegistration(n);
                    break;
                }
                case 15: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINADReply.responseAbortNetworkSearch(n);
                    break;
                }
                case 16: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSINADReply.responseChangeSIMCode(n, n2);
                    break;
                }
                case 21: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINADReply.responseSIMPINRequired(n);
                    break;
                }
                case 36: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSINADReply.updateSIMPINRequired(bl, n);
                    break;
                }
                case 18: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINADReply.responseNetworkRegistration(n);
                    break;
                }
                case 19: {
                    NetworkProvider[] networkProviderArray = NetworkProviderSerializer.getOptionalNetworkProviderVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINADReply.responseNetworkSearch(networkProviderArray, n);
                    break;
                }
                case 23: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINADReply.responseUnlockSIM(n);
                    break;
                }
                case 17: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINADReply.responseCheckSIMPINCode(n);
                    break;
                }
                case 20: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINADReply.responseRestoreFactorySettings(n);
                    break;
                }
                case 22: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINADReply.responseTelPower(n);
                    break;
                }
                case 43: {
                    int n = iDeserializer.getInt32();
                    this.p_DSINADReply.responseSetAutomaticPinEntryActive(n);
                    break;
                }
                case 28: {
                    ActivationStateStruct activationStateStruct = ActivationStateStructSerializer.getOptionalActivationStateStruct(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINADReply.updateActivationState(activationStateStruct, n);
                    break;
                }
                case 29: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSINADReply.updateAutomaticPinEntryActive(bl, n);
                    break;
                }
                case 30: {
                    LockStateStruct lockStateStruct = LockStateStructSerializer.getOptionalLockStateStruct(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINADReply.updateLockState(lockStateStruct, n);
                    break;
                }
                case 31: {
                    NADTemperatureStruct nADTemperatureStruct = NADTemperatureStructSerializer.getOptionalNADTemperatureStruct(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINADReply.updateNADTemperature(nADTemperatureStruct, n);
                    break;
                }
                case 42: {
                    PhoneInformation phoneInformation = PhoneInformationSerializer.getOptionalPhoneInformation(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINADReply.updatePhoneInformation(phoneInformation, n);
                    break;
                }
                case 32: {
                    NetworkProviderName networkProviderName = NetworkProviderNameSerializer.getOptionalNetworkProviderName(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINADReply.updateNetworkProvider(networkProviderName, n);
                    break;
                }
                case 33: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSINADReply.updateNetworkType(n, n3);
                    break;
                }
                case 35: {
                    RegisterStateStruct registerStateStruct = RegisterStateStructSerializer.getOptionalRegisterStateStruct(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINADReply.updateRegisterState(registerStateStruct, n);
                    break;
                }
                case 38: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSINADReply.updateSignalQuality(n, n4);
                    break;
                }
                case 37: {
                    ServiceProvider serviceProvider = ServiceProviderSerializer.getOptionalServiceProvider(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSINADReply.updateServiceProvider(serviceProvider, n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSINADReply.asyncException(n, string, n5);
                    break;
                }
                case 39: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSINADReply.yyIndication(string, string2);
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

