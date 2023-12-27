/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.vm;

import com.ibm.oti.util.Msg;

public class ReflectObjectInvalidException
extends RuntimeException {
    public ReflectObjectInvalidException() {
        super(Msg.getString("K0086"));
    }

    public ReflectObjectInvalidException(String string) {
        super(Msg.getString("K0087", string));
    }
}

