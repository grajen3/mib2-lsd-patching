/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class UGDOLearningData {
    public int aSGRequest;
    public int fSGResponse;
    public int codeSystem;
    public int button;

    public UGDOLearningData() {
        this.aSGRequest = 0;
        this.fSGResponse = 0;
        this.codeSystem = 0;
        this.button = 0;
    }

    public UGDOLearningData(int n, int n2, int n3, int n4) {
        this.aSGRequest = n;
        this.fSGResponse = n2;
        this.codeSystem = n3;
        this.button = n4;
    }

    public int getASGRequest() {
        return this.aSGRequest;
    }

    public int getFSGResponse() {
        return this.fSGResponse;
    }

    public int getCodeSystem() {
        return this.codeSystem;
    }

    public int getButton() {
        return this.button;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("UGDOLearningData");
        stringBuffer.append('(');
        stringBuffer.append("aSGRequest");
        stringBuffer.append('=');
        stringBuffer.append(this.aSGRequest);
        stringBuffer.append(',');
        stringBuffer.append("fSGResponse");
        stringBuffer.append('=');
        stringBuffer.append(this.fSGResponse);
        stringBuffer.append(',');
        stringBuffer.append("codeSystem");
        stringBuffer.append('=');
        stringBuffer.append(this.codeSystem);
        stringBuffer.append(',');
        stringBuffer.append("button");
        stringBuffer.append('=');
        stringBuffer.append(this.button);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

