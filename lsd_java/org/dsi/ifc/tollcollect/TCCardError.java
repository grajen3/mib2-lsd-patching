/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tollcollect;

public class TCCardError {
    public int cardError;
    public String errorCode;

    public TCCardError() {
        this.cardError = 0;
        this.errorCode = null;
    }

    public TCCardError(int n, String string) {
        this.cardError = n;
        this.errorCode = string;
    }

    public int getCardError() {
        return this.cardError;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("TCCardError");
        stringBuffer.append('(');
        stringBuffer.append("cardError");
        stringBuffer.append('=');
        stringBuffer.append(this.cardError);
        stringBuffer.append(',');
        stringBuffer.append("errorCode");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.errorCode);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

