/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.tracing;

import de.esolutions.fw.comm.core.IStub;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.tracing.SubBuffer;
import de.esolutions.fw.util.serializer.IStreamSerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import de.esolutions.fw.util.tracing.TraceChannel;
import de.esolutions.fw.util.transport.buffer.TransportBuffer;

public class CommMessageTracing {
    public static final short UNDEFINED_AGENT_ID;
    public static final short UNDEFINED_ENTITY_ID;
    public static final int TRUNCATED_PAYLOAD_SIZE;
    public static final byte COMM_TRACING_PROTOCOL_V0;
    public static final byte COMM_TRACING_PROTOCOL_V1;
    public static final byte COMM_TRACING_PROTOCOL_V2;
    public static final byte FLAG_REPLY;
    public static final byte FLAG_RELATED;
    public static final byte FLAG_UUID;
    public static final byte FLAG_IKEY;
    private byte version = 1;
    private byte flagMask = 0;
    private int truncatedPayloadSize = 1024;
    private short myAgentID;

    public void setMyAgentID(short s) {
        this.myAgentID = s;
    }

    public void setVersion(byte by) {
        this.version = by;
    }

    public byte getVersion() {
        return this.version;
    }

    public void setFlagMask(byte by) {
        this.flagMask = by;
    }

    public byte getFlagMask() {
        return this.flagMask;
    }

    public void setTruncatedPayloadSize(int n) {
        this.truncatedPayloadSize = n;
    }

    public int getTruncatedPayloadSize() {
        return this.truncatedPayloadSize;
    }

    public void logStub(TraceChannel traceChannel, IStreamSerializer iStreamSerializer, IStub iStub, short s, SubBuffer subBuffer, int n) {
        byte by = 0;
        ServiceInstanceID serviceInstanceID = iStub.getService().getInstanceID();
        ServiceInstanceID serviceInstanceID2 = null;
        Proxy proxy = iStub.getRequestProxy();
        if (proxy != null) {
            by = (byte)(by | 1);
            serviceInstanceID2 = proxy.getInstanceID();
        } else {
            proxy = iStub.getReplyProxy();
            if (proxy != null) {
                serviceInstanceID2 = proxy.getInstanceID();
            }
        }
        this.log(traceChannel, iStreamSerializer, iStub.getRemoteAgentID(), iStub.getStubID(), s, subBuffer, by, serviceInstanceID, serviceInstanceID2, n);
    }

    public void logProxy(TraceChannel traceChannel, IStreamSerializer iStreamSerializer, Proxy proxy, short s, short s2, SubBuffer subBuffer, int n) {
        byte by = 0;
        ServiceInstanceID serviceInstanceID = proxy.getInstanceID();
        ServiceInstanceID serviceInstanceID2 = null;
        IStub iStub = proxy.getRequestStub();
        if (iStub != null) {
            by = (byte)(by | 1);
            serviceInstanceID2 = iStub.getService().getInstanceID();
        } else {
            iStub = proxy.getReplyStub();
            if (iStub != null) {
                serviceInstanceID2 = iStub.getService().getInstanceID();
            }
        }
        this.log(traceChannel, iStreamSerializer, s, proxy.getProxyID(), s2, subBuffer, by, serviceInstanceID, serviceInstanceID2, n);
    }

    private SubBuffer createHeader(IStreamSerializer iStreamSerializer, short s, short s2, short s3, byte by, ServiceInstanceID serviceInstanceID, ServiceInstanceID serviceInstanceID2, int n) {
        int n2;
        TransportBuffer transportBuffer = new TransportBuffer(128);
        iStreamSerializer.attachBuffer(transportBuffer);
        by = (byte)(by | this.flagMask);
        boolean bl = false;
        if ((by & 2) == 2) {
            if (serviceInstanceID2 == null) {
                by = (byte)(by & 0xFFFFFFFD);
            } else {
                bl = true;
            }
        }
        byte by2 = (byte)(5 | this.version << 4);
        iStreamSerializer.putInt8(by2);
        iStreamSerializer.putInt8(iStreamSerializer.getId());
        if (this.version >= 2) {
            iStreamSerializer.putInt8(by);
            iStreamSerializer.putInt16(this.myAgentID);
        }
        if (this.version >= 1) {
            iStreamSerializer.putInt16(s);
            iStreamSerializer.putInt16(s2);
        }
        iStreamSerializer.putInt16(s3);
        iStreamSerializer.putInt32(serviceInstanceID.getHandle());
        if (this.version >= 2) {
            boolean bl2;
            n2 = (by & 4) == 4 ? 1 : 0;
            boolean bl3 = bl2 = (by & 8) == 8;
            if (n2 != 0) {
                iStreamSerializer.putRawBytes(serviceInstanceID.getServiceUUID().getUUID().getRawBytes());
            }
            if (bl2) {
                iStreamSerializer.putRawBytes(serviceInstanceID.getInterfaceKey().getUUID().getRawBytes());
            }
            if (bl) {
                iStreamSerializer.putInt32(serviceInstanceID2.getHandle());
                if (n2 != 0) {
                    iStreamSerializer.putRawBytes(serviceInstanceID2.getServiceUUID().getUUID().getRawBytes());
                }
                if (bl2) {
                    iStreamSerializer.putRawBytes(serviceInstanceID2.getInterfaceKey().getUUID().getRawBytes());
                }
            }
            iStreamSerializer.putInt32(n);
        }
        n2 = iStreamSerializer.getDirectPos();
        iStreamSerializer.detachBuffer();
        byte[] byArray = transportBuffer.getDirectData();
        return new SubBuffer(byArray, n2, 0);
    }

    private void log(TraceChannel traceChannel, IStreamSerializer iStreamSerializer, short s, short s2, short s3, SubBuffer subBuffer, byte by, ServiceInstanceID serviceInstanceID, ServiceInstanceID serviceInstanceID2, int n) {
        short s4 = traceChannel.getFilterLevel();
        int n2 = subBuffer.size;
        if (s4 == 2) {
            n2 = 0;
        } else if (s4 == 1 && n2 > this.truncatedPayloadSize) {
            n2 = this.truncatedPayloadSize;
        }
        try {
            SubBuffer subBuffer2 = this.createHeader(iStreamSerializer, s, s2, s3, by, serviceInstanceID, serviceInstanceID2, n);
            byte[] byArray = SubBuffer.concat(subBuffer2, subBuffer);
            traceChannel.log(traceChannel.getFilterLevel(), (short)0, (short)3, byArray);
        }
        catch (SerializerException serializerException) {
            serializerException.printStackTrace();
        }
    }
}

