/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.persistence.impl;

import de.esolutions.fw.comm.asi.persistence.AttributesS;
import de.esolutions.fw.comm.asi.persistence.impl.AttributesReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class AttributesService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.persistence.Attributes");
    private AttributesS p_Attributes;

    public AttributesService(int n, AttributesS attributesS) {
        super(new ServiceInstanceID("a58995e5-3a88-5f1a-9a3c-1786b9a38589", n, "8a7ea0fe-3e4b-5398-9204-ca052de05566", "asi.persistence.Attributes"));
        this.p_Attributes = attributesS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new AttributesReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 7: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    long[] lArray2 = iDeserializer.getOptionalUInt32VarArray();
                    this.p_Attributes.subscribe(lArray, lArray2, (AttributesReplyProxy)iProxyFrontend);
                    break;
                }
                case 8: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    long[] lArray3 = iDeserializer.getOptionalUInt32VarArray();
                    this.p_Attributes.unsubscribe(lArray, lArray3, (AttributesReplyProxy)iProxyFrontend);
                    break;
                }
                case 9: {
                    this.p_Attributes.unsubscribeAll((AttributesReplyProxy)iProxyFrontend);
                    break;
                }
                case 3: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    long[] lArray4 = iDeserializer.getOptionalUInt32VarArray();
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    this.p_Attributes.putInts(lArray, lArray4, nArray, (AttributesReplyProxy)iProxyFrontend);
                    break;
                }
                case 5: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    long[] lArray5 = iDeserializer.getOptionalUInt32VarArray();
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    this.p_Attributes.putStrings(lArray, lArray5, stringArray, (AttributesReplyProxy)iProxyFrontend);
                    break;
                }
                case 2: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    long[] lArray6 = iDeserializer.getOptionalUInt32VarArray();
                    boolean bl = !iDeserializer.getBool();
                    Object object = null;
                    if (bl) {
                        long l = iDeserializer.getUInt32();
                        object = new short[(int)l][];
                        int n = 0;
                        while ((long)n < l) {
                            object[n] = iDeserializer.getOptionalUInt8VarArray();
                            ++n;
                        }
                    }
                    this.p_Attributes.putBlobs(lArray, lArray6, (short[][])object, (AttributesReplyProxy)iProxyFrontend);
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

