/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

import com.ibm.oti.vm.VM;
import java.io.ByteArrayInputStream;

public class AccessibleByteArrayInputStream
extends ByteArrayInputStream {
    public AccessibleByteArrayInputStream(byte[] byArray) {
        super(byArray);
    }

    public byte[] getByteArray() {
        if (VM.callerClassLoader() != null) {
            throw new SecurityException();
        }
        return this.buf;
    }
}

