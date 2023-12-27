/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.bc.impl;

import de.esolutions.fw.comm.asi.hmisync.car.bc.ASIHMISyncCarBordComputerReply;
import de.esolutions.fw.comm.asi.hmisync.car.bc.ASIHMISyncCarBordComputerS;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.ASIHMISyncCarBordComputerReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncCarBordComputerService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.car.bc.ASIHMISyncCarBordComputer");
    private ASIHMISyncCarBordComputerS p_ASIHMISyncCarBordComputer;

    public ASIHMISyncCarBordComputerService(int n, ASIHMISyncCarBordComputerS aSIHMISyncCarBordComputerS) {
        super(new ServiceInstanceID("7bf67018-bebb-46f4-bf0f-0d5345fcf213", n, "2a6a543b-0fe6-5170-9fb4-6c05144dfe9c", "asi.hmisync.car.bc.ASIHMISyncCarBordComputer"));
        this.p_ASIHMISyncCarBordComputer = aSIHMISyncCarBordComputerS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new ASIHMISyncCarBordComputerReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 3: {
                    this.p_ASIHMISyncCarBordComputer.setNotification((ASIHMISyncCarBordComputerReplyProxy)iProxyFrontend);
                    break;
                }
                case 5: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncCarBordComputer.setNotification(l, (ASIHMISyncCarBordComputerReply)((ASIHMISyncCarBordComputerReplyProxy)iProxyFrontend));
                    break;
                }
                case 4: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncCarBordComputer.setNotification(lArray, (ASIHMISyncCarBordComputerReply)((ASIHMISyncCarBordComputerReplyProxy)iProxyFrontend));
                    break;
                }
                case 0: {
                    this.p_ASIHMISyncCarBordComputer.clearNotification((ASIHMISyncCarBordComputerReplyProxy)iProxyFrontend);
                    break;
                }
                case 2: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncCarBordComputer.clearNotification(l, (ASIHMISyncCarBordComputerReply)((ASIHMISyncCarBordComputerReplyProxy)iProxyFrontend));
                    break;
                }
                case 1: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncCarBordComputer.clearNotification(lArray, (ASIHMISyncCarBordComputerReply)((ASIHMISyncCarBordComputerReplyProxy)iProxyFrontend));
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

