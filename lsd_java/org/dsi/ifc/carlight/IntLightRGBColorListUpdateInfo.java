/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carlight;

public class IntLightRGBColorListUpdateInfo {
    public int arrayContent;
    public int recordContent;
    public int startElement;
    public int numOfElements;
    public int transactionID;

    public IntLightRGBColorListUpdateInfo() {
        this.arrayContent = 0;
        this.startElement = 0;
        this.numOfElements = 0;
        this.transactionID = 0;
        this.recordContent = 0;
    }

    public IntLightRGBColorListUpdateInfo(int n, int n2, int n3, int n4, int n5) {
        this.arrayContent = n;
        this.recordContent = n2;
        this.startElement = n3;
        this.numOfElements = n4;
        this.transactionID = n5;
    }

    public int getArrayContent() {
        return this.arrayContent;
    }

    public int getRecordContent() {
        return this.recordContent;
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
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("IntLightRGBColorListUpdateInfo");
        stringBuffer.append('(');
        stringBuffer.append("arrayContent");
        stringBuffer.append('=');
        stringBuffer.append(this.arrayContent);
        stringBuffer.append(',');
        stringBuffer.append("recordContent");
        stringBuffer.append('=');
        stringBuffer.append(this.recordContent);
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

