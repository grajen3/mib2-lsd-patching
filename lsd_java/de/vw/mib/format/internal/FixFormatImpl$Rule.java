/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.format.internal;

import de.vw.mib.format.internal.FixFormatImpl;

class FixFormatImpl$Rule {
    String condition;
    String output;
    private final /* synthetic */ FixFormatImpl this$0;

    FixFormatImpl$Rule(FixFormatImpl fixFormatImpl) {
        this.this$0 = fixFormatImpl;
    }

    public void setCondition(String string) {
        this.condition = string;
    }

    public String getCondition() {
        return this.condition;
    }

    public void setOutput(String string) {
        this.output = string;
    }

    public String getOutput() {
        return this.output;
    }
}

