/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

public class CharismaListUpdateInfo {
    public int profileID;
    public int arrayContent;
    public int recordContent;
    public int startElement;
    public int numOfElements;

    public CharismaListUpdateInfo() {
        this.profileID = 0;
        this.arrayContent = 0;
        this.recordContent = 0;
        this.startElement = 0;
        this.numOfElements = 0;
    }

    public CharismaListUpdateInfo(int n, int n2, int n3, int n4, int n5) {
        this.profileID = n;
        this.arrayContent = n2;
        this.recordContent = n3;
        this.startElement = n4;
        this.numOfElements = n5;
    }

    public int getProfileID() {
        return this.profileID;
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

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("CharismaListUpdateInfo");
        stringBuffer.append('(');
        stringBuffer.append("profileID");
        stringBuffer.append('=');
        stringBuffer.append(this.profileID);
        stringBuffer.append(',');
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
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

