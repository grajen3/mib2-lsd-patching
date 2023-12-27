/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.careco;

public class StartStopListUpdateInfo {
    public int arrayContent;
    public int startElement;
    public int numOfElements;
    public int transactionID;

    public StartStopListUpdateInfo() {
        this.arrayContent = 0;
        this.startElement = 0;
        this.numOfElements = 0;
        this.transactionID = 0;
    }

    public StartStopListUpdateInfo(int n, int n2, int n3, int n4) {
        this.arrayContent = n;
        this.startElement = n2;
        this.numOfElements = n3;
        this.transactionID = n4;
    }

    public int getArrayContent() {
        return this.arrayContent;
    }

    public int getStartElement() {
        return this.startElement;
    }

    public int getNumOfElements() {
        return this.numOfElements;
    }

    public int getTransactionID() {
        return this.transactionID;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("StartStopListUpdateInfo");
        stringBuffer.append('(');
        stringBuffer.append("arrayContent");
        stringBuffer.append('=');
        stringBuffer.append(this.arrayContent);
        stringBuffer.append(',');
        stringBuffer.append("startElement");
        stringBuffer.append('=');
        stringBuffer.append(this.startElement);
        stringBuffer.append(',');
        stringBuffer.append("numOfElements");
        stringBuffer.append('=');
        stringBuffer.append(this.numOfElements);
        stringBuffer.append(',');
        stringBuffer.append("transactionID");
        stringBuffer.append('=');
        stringBuffer.append(this.transactionID);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

