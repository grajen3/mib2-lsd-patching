/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl;

import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.ASIHMISyncCarSportChronoReply;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.ASIHMISyncCarSportChronoS;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCData;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCHeader;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.ASIHMISyncCarSportChronoReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.SCDataSerializer;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.SCHeaderSerializer;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncCarSportChronoService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.car.sportchrono.ASIHMISyncCarSportChrono");
    private ASIHMISyncCarSportChronoS p_ASIHMISyncCarSportChrono;

    public ASIHMISyncCarSportChronoService(int n, ASIHMISyncCarSportChronoS aSIHMISyncCarSportChronoS) {
        super(new ServiceInstanceID("f6e30936-2963-4f91-ac52-c32bdac06478", n, "206974b6-62b0-5276-9413-00d6e1532c16", "asi.hmisync.car.sportchrono.ASIHMISyncCarSportChrono"));
        this.p_ASIHMISyncCarSportChrono = aSIHMISyncCarSportChronoS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new ASIHMISyncCarSportChronoReplyProxy();
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
                    long l = iDeserializer.getInt64();
                    long l2 = iDeserializer.getInt64();
                    this.p_ASIHMISyncCarSportChrono.requestRecordData(l, l2, (ASIHMISyncCarSportChronoReplyProxy)iProxyFrontend);
                    break;
                }
                case 13: {
                    int n = iDeserializer.getInt32();
                    this.p_ASIHMISyncCarSportChrono.setRecord(n, (ASIHMISyncCarSportChronoReplyProxy)iProxyFrontend);
                    break;
                }
                case 5: {
                    int n = iDeserializer.getInt32();
                    this.p_ASIHMISyncCarSportChrono.requestTrackData(n, (ASIHMISyncCarSportChronoReplyProxy)iProxyFrontend);
                    break;
                }
                case 3: {
                    SCHeader sCHeader = SCHeaderSerializer.getOptionalSCHeader(iDeserializer);
                    String string = iDeserializer.getOptionalString();
                    this.p_ASIHMISyncCarSportChrono.initTrackTransfer(sCHeader, string, (ASIHMISyncCarSportChronoReplyProxy)iProxyFrontend);
                    break;
                }
                case 14: {
                    int n = iDeserializer.getInt32();
                    SCData[] sCDataArray = SCDataSerializer.getOptionalSCDataVarArray(iDeserializer);
                    int n2 = iDeserializer.getInt32();
                    this.p_ASIHMISyncCarSportChrono.setTrackData(n, sCDataArray, n2, (ASIHMISyncCarSportChronoReplyProxy)iProxyFrontend);
                    break;
                }
                case 31: {
                    int n = iDeserializer.getInt32();
                    this.p_ASIHMISyncCarSportChrono.setReferenceLap(n, (ASIHMISyncCarSportChronoReplyProxy)iProxyFrontend);
                    break;
                }
                case 26: {
                    int n = iDeserializer.getInt32();
                    this.p_ASIHMISyncCarSportChrono.requestReferenceLapData(n, (ASIHMISyncCarSportChronoReplyProxy)iProxyFrontend);
                    break;
                }
                case 30: {
                    int n = iDeserializer.getInt32();
                    short s2 = iDeserializer.getInt16();
                    this.p_ASIHMISyncCarSportChrono.saveReferenceLap(n, s2, (ASIHMISyncCarSportChronoReplyProxy)iProxyFrontend);
                    break;
                }
                case 10: {
                    this.p_ASIHMISyncCarSportChrono.setNotification((ASIHMISyncCarSportChronoReplyProxy)iProxyFrontend);
                    break;
                }
                case 12: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncCarSportChrono.setNotification(l, (ASIHMISyncCarSportChronoReply)((ASIHMISyncCarSportChronoReplyProxy)iProxyFrontend));
                    break;
                }
                case 11: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncCarSportChrono.setNotification(lArray, (ASIHMISyncCarSportChronoReply)((ASIHMISyncCarSportChronoReplyProxy)iProxyFrontend));
                    break;
                }
                case 0: {
                    this.p_ASIHMISyncCarSportChrono.clearNotification((ASIHMISyncCarSportChronoReplyProxy)iProxyFrontend);
                    break;
                }
                case 2: {
                    long l = iDeserializer.getUInt32();
                    this.p_ASIHMISyncCarSportChrono.clearNotification(l, (ASIHMISyncCarSportChronoReply)((ASIHMISyncCarSportChronoReplyProxy)iProxyFrontend));
                    break;
                }
                case 1: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_ASIHMISyncCarSportChrono.clearNotification(lArray, (ASIHMISyncCarSportChronoReply)((ASIHMISyncCarSportChronoReplyProxy)iProxyFrontend));
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

