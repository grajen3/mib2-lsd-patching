/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.ooc.app.impl;

import de.esolutions.fw.comm.asi.ooc.app.IOocApplicationS;
import de.esolutions.fw.comm.asi.ooc.app.impl.IOocApplicationReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class IOocApplicationService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.ooc.app.IOocApplication");
    private IOocApplicationS p_IOocApplication;

    public IOocApplicationService(int n, IOocApplicationS iOocApplicationS) {
        super(new ServiceInstanceID("17b8d9e8-c125-4a29-9049-8e3cb4bfef59", n, "d9d2930f-88a6-55d1-912f-75f103b57a0c", "asi.ooc.app.IOocApplication"));
        this.p_IOocApplication = iOocApplicationS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new IOocApplicationReplyProxy();
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
                    boolean bl = iDeserializer.getBool();
                    this.p_IOocApplication.setCarWakeup(bl, (IOocApplicationReplyProxy)iProxyFrontend);
                    break;
                }
                case 1: {
                    boolean bl = iDeserializer.getBool();
                    this.p_IOocApplication.setCallActive(bl, (IOocApplicationReplyProxy)iProxyFrontend);
                    break;
                }
                case 3: {
                    boolean bl = iDeserializer.getBool();
                    this.p_IOocApplication.setPhonePowerDelay(bl, (IOocApplicationReplyProxy)iProxyFrontend);
                    break;
                }
                case 2: {
                    boolean bl = iDeserializer.getBool();
                    this.p_IOocApplication.setNavigationPowerDelay(bl, (IOocApplicationReplyProxy)iProxyFrontend);
                    break;
                }
                case 16: {
                    int n = iDeserializer.getEnum();
                    int n2 = iDeserializer.getEnum();
                    this.p_IOocApplication.setApplicationState(n, n2, (IOocApplicationReplyProxy)iProxyFrontend);
                    break;
                }
                case 9: {
                    boolean bl = iDeserializer.getBool();
                    this.p_IOocApplication.setZrActive(bl, (IOocApplicationReplyProxy)iProxyFrontend);
                    break;
                }
                case 0: {
                    this.p_IOocApplication.registerPowerEventListener((IOocApplicationReplyProxy)iProxyFrontend);
                    break;
                }
                case 17: {
                    int n = iDeserializer.getEnum();
                    this.p_IOocApplication.shutdownResponseFinal(n, (IOocApplicationReplyProxy)iProxyFrontend);
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

