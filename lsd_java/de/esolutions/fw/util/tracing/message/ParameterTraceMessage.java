/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.message;

import de.esolutions.fw.util.commons.StringUtils;
import de.esolutions.fw.util.tracing.message.TraceMessage;

public class ParameterTraceMessage
extends TraceMessage {
    private String message;
    private Object[] args;

    public ParameterTraceMessage(long l, int n, int n2, short s, short s2, String string, Object[] objectArray) {
        super(l, n, n2, s, s2, (short)1);
        this.message = string;
        this.args = objectArray;
    }

    @Override
    public void expandNow() {
        if (this.args != null) {
            this.setMessageString(StringUtils.expandArgString(this.message, this.args));
            this.args = null;
        } else {
            this.setMessageString(this.message);
        }
        this.message = null;
    }
}

