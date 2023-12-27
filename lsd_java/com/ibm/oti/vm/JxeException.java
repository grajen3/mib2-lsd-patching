/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.vm;

import com.ibm.oti.vm.JxeUtil;

public class JxeException
extends Exception {
    public static JxeException jxeExceptionFromRelocationReturnCode(int n) {
        return new JxeException(JxeUtil.getRelocationMessage(n));
    }

    public JxeException() {
    }

    public JxeException(String string) {
        super(string);
    }
}

