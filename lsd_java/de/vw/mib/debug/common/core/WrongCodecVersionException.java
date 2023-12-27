/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.common.core;

import java.io.IOException;

public class WrongCodecVersionException
extends IOException {
    private static final long serialVersionUID;
    private final byte codecVersion;
    private final byte encodedVersion;

    public WrongCodecVersionException(byte by, byte by2, Class clazz) {
        super(new StringBuffer().append("Wrong codec version, message couldn't be decoded by codec ").append(clazz == null ? "unknown" : clazz.getName()).append("! The message is encoded with version '").append(by).append("' but this codec supports version '").append(by2).append("'").toString());
        this.codecVersion = by2;
        this.encodedVersion = by;
    }

    public byte getCodecVersion() {
        return this.codecVersion;
    }

    public byte getEncodedVersion() {
        return this.encodedVersion;
    }
}

