/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.careco;

public class BCmEListUpdateInfo {
    public int arrayContent;
    public int startElement;
    public int numOfElements;
    public int transactionID;
    public int recordContent;
    public int asgID;

    public BCmEListUpdateInfo() {
        this.arrayContent = 0;
        this.startElement = 0;
        this.numOfElements = 0;
        this.transactionID = 0;
        this.recordContent = 0;
        this.asgID = 0;
    }

    public BCmEListUpdateInfo(int n, int n2, int n3, int n4, int n5, int n6) {
        this.arrayContent = n;
        this.startElement = n2;
        this.numOfElements = n3;
        this.transactionID = n4;
        this.recordContent = n5;
        this.asgID = n6;
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

    public int getRecordContent() {
        return this.recordContent;
    }

    public int getAsgID() {
        return this.asgID;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("BCmEListUpdateInfo");
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
        stringBuffer.append(',');
        stringBuffer.append("recordContent");
        stringBuffer.append('=');
        stringBuffer.append(this.recordContent);
        stringBuffer.append(',');
        stringBuffer.append("asgID");
        stringBuffer.append('=');
        stringBuffer.append(this.asgID);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

