/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class DoorLockingUserListUpdateInfo {
    public int arrayContent;
    public int recordContent;
    public int transactionID;
    public int startElement;
    public int numOfElements;
    public int asgID;

    public DoorLockingUserListUpdateInfo() {
        this.arrayContent = 0;
        this.recordContent = 0;
        this.transactionID = 0;
        this.startElement = 0;
        this.numOfElements = 0;
        this.asgID = 0;
    }

    public DoorLockingUserListUpdateInfo(int n, int n2, int n3, int n4, int n5, int n6) {
        this.arrayContent = n;
        this.recordContent = n2;
        this.transactionID = n3;
        this.startElement = n4;
        this.numOfElements = n5;
        this.asgID = n6;
    }

    public int getArrayContent() {
        return this.arrayContent;
    }

    public int getTransactionID() {
        return this.transactionID;
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

    public int getAsgID() {
        return this.asgID;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("DoorLockingUserListUpdateInfo");
        stringBuffer.append('(');
        stringBuffer.append("arrayContent");
        stringBuffer.append('=');
        stringBuffer.append(this.arrayContent);
        stringBuffer.append(',');
        stringBuffer.append("recordContent");
        stringBuffer.append('=');
        stringBuffer.append(this.recordContent);
        stringBuffer.append(',');
        stringBuffer.append("transactionID");
        stringBuffer.append('=');
        stringBuffer.append(this.transactionID);
        stringBuffer.append(',');
        stringBuffer.append("startElement");
        stringBuffer.append('=');
        stringBuffer.append(this.startElement);
        stringBuffer.append(',');
        stringBuffer.append("numOfElements");
        stringBuffer.append('=');
        stringBuffer.append(this.numOfElements);
        stringBuffer.append(',');
        stringBuffer.append("asgID");
        stringBuffer.append('=');
        stringBuffer.append(this.asgID);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

