/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

public class SuspensionControlOperationMessages {
    public int failureReason;
    public int selectionConfirmation;
    public int processFinished;
    public int regulation;

    public SuspensionControlOperationMessages() {
        this.failureReason = 0;
        this.selectionConfirmation = 0;
        this.processFinished = 0;
        this.regulation = 0;
    }

    public SuspensionControlOperationMessages(int n, int n2, int n3, int n4) {
        this.failureReason = n;
        this.selectionConfirmation = n2;
        this.processFinished = n3;
        this.regulation = n4;
    }

    public int getFailureReason() {
        return this.failureReason;
    }

    public int getSelectionConfirmation() {
        return this.selectionConfirmation;
    }

    public int getProcessFinished() {
        return this.processFinished;
    }

    public int getRegulation() {
        return this.regulation;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("SuspensionControlOperationMessages");
        stringBuffer.append('(');
        stringBuffer.append("failureReason");
        stringBuffer.append('=');
        stringBuffer.append(this.failureReason);
        stringBuffer.append(',');
        stringBuffer.append("selectionConfirmation");
        stringBuffer.append('=');
        stringBuffer.append(this.selectionConfirmation);
        stringBuffer.append(',');
        stringBuffer.append("processFinished");
        stringBuffer.append('=');
        stringBuffer.append(this.processFinished);
        stringBuffer.append(',');
        stringBuffer.append("regulation");
        stringBuffer.append('=');
        stringBuffer.append(this.regulation);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

