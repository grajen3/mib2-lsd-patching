/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.common.probes.configuration;

import de.vw.mib.debug.common.core.ByteArrayReader;
import de.vw.mib.debug.common.core.ByteArrayWriter;
import de.vw.mib.debug.common.probes.configuration.DebugProbeConfiguration;

public abstract class AbstractDebugProbeConfiguration
extends ByteArrayWriter
implements DebugProbeConfiguration {
    public static final int TYPE_BINARY;
    public static final int TYPE_PROPERTIES;
    private ByteArrayReader defaultReader;

    public abstract byte getCodecVersion() {
    }

    @Override
    public void load(byte[] byArray) {
        if (this.defaultReader == null) {
            this.defaultReader = new ByteArrayReader(byArray);
        } else {
            this.defaultReader.reset(byArray);
        }
        this.readBinaryConfiguration(this.defaultReader);
    }

    @Override
    public byte[] storeToByteArray() {
        this.reset();
        this.writeBinaryConfiguration();
        return this.toByteArray();
    }

    protected abstract void readBinaryConfiguration(ByteArrayReader byteArrayReader) {
    }

    protected abstract void writeBinaryConfiguration() {
    }

    protected boolean readBoolean(String string) {
        if (string == null) {
            return false;
        }
        return Boolean.valueOf(string);
    }

    protected int readInt(String string) {
        if (string == null) {
            return 0;
        }
        if (string.startsWith("0x")) {
            return (int)Long.parseLong(string.substring(2), 16);
        }
        return Integer.parseInt(string);
    }
}

