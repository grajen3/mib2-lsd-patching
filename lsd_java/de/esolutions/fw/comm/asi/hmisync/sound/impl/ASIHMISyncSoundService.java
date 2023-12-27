/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.sound.impl;

import de.esolutions.fw.comm.asi.hmisync.sound.ASIHMISyncSoundReply;
import de.esolutions.fw.comm.asi.hmisync.sound.ASIHMISyncSoundS;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncSoundService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.sound.ASIHMISyncSound");
    private ASIHMISyncSoundS p_ASIHMISyncSound;

    public ASIHMISyncSoundService(int n, ASIHMISyncSoundS aSIHMISyncSoundS) {
        super(new ServiceInstanceID("77c20339-10b3-4457-b2a9-6deff271cdc2", n, "cc691fbd-3a67-5f0a-ad62-7022a03a7536", "asi.hmisync.sound.ASIHMISyncSound"));
        this.p_ASIHMISyncSound = aSIHMISyncSoundS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new ASIHMISyncSoundReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 4: {
                    int n = iDeserializer.getInt32();
                    this.p_ASIHMISyncSound.setBassValue(n, (ASIHMISyncSoundReplyProxy)iProxyFrontend);
                    break;
                }
                case 13: {
                    int n = iDeserializer.getInt32();
                    this.p_ASIHMISyncSound.setTrebleValue(n, (ASIHMISyncSoundReplyProxy)iProxyFrontend);
                    break;
                }
                case 3: {
                    int n = iDeserializer.getInt32();
                    this.p_ASIHMISyncSound.setBalanceValue(n, (ASIHMISyncSoundReplyProxy)iProxyFrontend);
                    break;
                }
                case 5: {
                    int n = iDeserializer.getInt32();
                    this.p_ASIHMISyncSound.setFaderValue(n, (ASIHMISyncSoundReplyProxy)iProxyFrontend);
                    break;
                }
                case 11: {
                    int n = iDeserializer.getInt32();
                    this.p_ASIHMISyncSound.setSubwooferValue(n, (ASIHMISyncSoundReplyProxy)iProxyFrontend);
                    break;
                }
                case 12: {
                    int n = iDeserializer.getInt32();
                    this.p_ASIHMISyncSound.setSurroundValue(n, (ASIHMISyncSoundReplyProxy)iProxyFrontend);
                    break;
                }
                case 6: {
                    int n = iDeserializer.getInt32();
                    this.p_ASIHMISyncSound.setNoiseCompensationValue(n, (ASIHMISyncSoundReplyProxy)iProxyFrontend);
                    break;
                }
                case 36: {
                    int n = iDeserializer.getInt32();
                    this.p_ASIHMISyncSound.setThreeDModeValue(n, (ASIHMISyncSoundReplyProxy)iProxyFrontend);
                    break;
                }
                case 10: {
                    int n = iDeserializer.getInt32();
                    this.p_ASIHMISyncSound.setPresetPosition(n, (ASIHMISyncSoundReplyProxy)iProxyFrontend);
                    break;
                }
                case 35: {
                    int n = iDeserializer.getInt32();
                    this.p_ASIHMISyncSound.setPresetEQ(n, (ASIHMISyncSoundReplyProxy)iProxyFrontend);
                    break;
                }
                case 7: {
                    this.p_ASIHMISyncSound.setNotification((ASIHMISyncSoundReplyProxy)iProxyFrontend);
                    break;
                }
                case 9: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncSound.setNotification(l, (ASIHMISyncSoundReply)((ASIHMISyncSoundReplyProxy)iProxyFrontend));
                    break;
                }
                case 8: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncSound.setNotification(lArray, (ASIHMISyncSoundReply)((ASIHMISyncSoundReplyProxy)iProxyFrontend));
                    break;
                }
                case 0: {
                    this.p_ASIHMISyncSound.clearNotification((ASIHMISyncSoundReplyProxy)iProxyFrontend);
                    break;
                }
                case 2: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncSound.clearNotification(l, (ASIHMISyncSoundReply)((ASIHMISyncSoundReplyProxy)iProxyFrontend));
                    break;
                }
                case 1: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncSound.clearNotification(lArray, (ASIHMISyncSoundReply)((ASIHMISyncSoundReplyProxy)iProxyFrontend));
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

