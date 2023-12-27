/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debugmanager.internal;

import de.vw.mib.codec.ByteArrayReader;
import de.vw.mib.debug.common.probes.configuration.DebugProbeConfiguration;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.log4mib.BinaryMessage;
import de.vw.mib.log4mib.InvocationContext;
import de.vw.mib.pool.PooledObject;
import java.lang.reflect.Array;

public abstract class AbstractProbeCodec
implements PooledObject {
    public static final byte PROBE_CONFIGURATION;
    public static final byte PROBE_DEACTIVATED;
    protected final ByteArrayReader defaultReader = new ByteArrayReader();
    private ProbeSystemServices probeSystemServices;

    public AbstractProbeCodec(ProbeSystemServices probeSystemServices) {
        this.probeSystemServices = probeSystemServices;
    }

    @Override
    public void backToPool() {
    }

    public void setProbeSystemServices(ProbeSystemServices probeSystemServices) {
        this.probeSystemServices = probeSystemServices;
    }

    public final void encodeProbeConfiguration(DebugProbeConfiguration debugProbeConfiguration) {
        BinaryMessage binaryMessage = this.probeSystemServices.createConfigurationMessage();
        binaryMessage.append(this.getCodecVersion());
        if (debugProbeConfiguration == null) {
            binaryMessage.append((byte)0);
        } else {
            binaryMessage.append((byte)1);
            binaryMessage.append(debugProbeConfiguration.storeToByteArray());
        }
        binaryMessage.send();
    }

    public final void encodeProbeDeactivation() {
        BinaryMessage binaryMessage = this.probeSystemServices.createConfigurationMessage();
        binaryMessage.append(this.getCodecVersion());
        binaryMessage.append((byte)0);
        binaryMessage.send();
    }

    private String getArrayTypeName(Object object) {
        Class clazz = object.getClass().getComponentType();
        if (clazz.isPrimitive()) {
            return clazz.getName();
        }
        String string = clazz.getName();
        return string.substring(string.lastIndexOf(".") + 1);
    }

    protected void appendCurrentInvocation(BinaryMessage binaryMessage) {
        this.appendInvocation(binaryMessage, InvocationContext.getCurrentInvocationContext(null));
    }

    protected void appendInvocation(BinaryMessage binaryMessage, InvocationContext invocationContext) {
        if (invocationContext == null) {
            binaryMessage.append(-1).append(-1).append(-1).append(-1);
            return;
        }
        binaryMessage.append(invocationContext.getForkBranchId());
        binaryMessage.append(Thread.currentThread().getName().hashCode());
        binaryMessage.append(invocationContext.getInvocationId());
        binaryMessage.append(invocationContext.getBranchId());
    }

    private void appendHeader(BinaryMessage binaryMessage, byte by) {
        binaryMessage.append(this.getCodecVersion());
        binaryMessage.append(by);
        binaryMessage.append(this.probeSystemServices.getTimestamp());
    }

    protected final BinaryMessage createMessage(byte by) {
        BinaryMessage binaryMessage = this.probeSystemServices.createMessage();
        this.appendHeader(binaryMessage, by);
        return binaryMessage;
    }

    protected final String arrayToString(Object object) {
        StringBuffer stringBuffer = new StringBuffer(64);
        int n = Array.getLength(object);
        stringBuffer.append(this.getArrayTypeName(object));
        if (n == 0) {
            stringBuffer.append("[]");
            return stringBuffer.toString();
        }
        stringBuffer.append("[");
        Object object2 = Array.get(object, 0);
        stringBuffer.append(object2 != null ? object2.toString() : "null");
        for (int i2 = 1; i2 < n; ++i2) {
            stringBuffer.append(", ");
            object2 = Array.get(object, i2);
            stringBuffer.append(object2 != null ? object2.toString() : "null");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    protected abstract short getConfigurationMessageType() {
    }

    protected abstract short getMessageType() {
    }

    protected abstract byte getCodecVersion() {
    }
}

