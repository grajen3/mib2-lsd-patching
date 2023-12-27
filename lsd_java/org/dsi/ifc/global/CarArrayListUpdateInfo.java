/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.global;

public class CarArrayListUpdateInfo {
    public int asgID;
    public int transactionID;
    public int recordContent;
    public int arrayContent;
    public int startElement;
    public int numOfElements;

    public CarArrayListUpdateInfo() {
        this.asgID = 0;
        this.transactionID = 0;
        this.recordContent = 0;
        this.arrayContent = 0;
        this.startElement = 0;
        this.numOfElements = 0;
    }

    public CarArrayListUpdateInfo(int n, int n2, int n3, int n4, int n5, int n6) {
        this.asgID = n;
        this.transactionID = n2;
        this.recordContent = n3;
        this.arrayContent = n4;
        this.startElement = n5;
        this.numOfElements = n6;
    }

    public int getAsgID() {
        return this.asgID;
    }

    public int getTransactionID() {
        return this.transactionID;
    }

    public int getRecordContent() {
        return this.recordContent;
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

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CarArrayListUpdateInfo(");
        stringBuffer.append("asgID: ");
        stringBuffer.append(this.asgID);
        stringBuffer.append(",");
        stringBuffer.append("transactionID: ");
        stringBuffer.append(this.transactionID);
        stringBuffer.append(",");
        stringBuffer.append("recordContent: ");
        stringBuffer.append(this.recordContent);
        stringBuffer.append(",");
        stringBuffer.append("arrayContent: ");
        stringBuffer.append(this.arrayContent);
        stringBuffer.append(",");
        stringBuffer.append("startElement: ");
        stringBuffer.append(this.startElement);
        stringBuffer.append(",");
        stringBuffer.append("numOfElements: ");
        stringBuffer.append(this.numOfElements);
        stringBuffer.append(")");
        return stringBuffer.toString();
    }
}

