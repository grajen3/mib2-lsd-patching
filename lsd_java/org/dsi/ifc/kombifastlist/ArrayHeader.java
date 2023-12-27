/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombifastlist;

public class ArrayHeader {
    public int mode;
    public int recordAddress;
    public long start;
    public int relativeJump;
    public int elements;
    public int absoluteListPos;
    public int jobModification;
    public int jobID;
    public int jobPriority;

    public ArrayHeader() {
        this.mode = 0;
        this.recordAddress = 0;
        this.start = 0L;
        this.relativeJump = 0;
        this.elements = 0;
        this.absoluteListPos = 0;
        this.jobModification = 0;
        this.jobID = 0;
        this.jobPriority = 0;
    }

    public ArrayHeader(int n, int n2, long l, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.mode = n;
        this.recordAddress = n2;
        this.start = l;
        this.relativeJump = n3;
        this.elements = n4;
        this.absoluteListPos = n5;
        this.jobModification = n6;
        this.jobID = n7;
        this.jobPriority = n8;
    }

    public int getMode() {
        return this.mode;
    }

    public int getRecordAddress() {
        return this.recordAddress;
    }

    public long getStart() {
        return this.start;
    }

    public int getRelativeJump() {
        return this.relativeJump;
    }

    public int getElements() {
        return this.elements;
    }

    public int getAbsoluteListPos() {
        return this.absoluteListPos;
    }

    public int getJobModification() {
        return this.jobModification;
    }

    public int getJobID() {
        return this.jobID;
    }

    public int getJobPriority() {
        return this.jobPriority;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(500);
        stringBuffer.append("ArrayHeader");
        stringBuffer.append('(');
        stringBuffer.append("mode");
        stringBuffer.append('=');
        stringBuffer.append(this.mode);
        stringBuffer.append(',');
        stringBuffer.append("recordAddress");
        stringBuffer.append('=');
        stringBuffer.append(this.recordAddress);
        stringBuffer.append(',');
        stringBuffer.append("start");
        stringBuffer.append('=');
        stringBuffer.append(this.start);
        stringBuffer.append(',');
        stringBuffer.append("relativeJump");
        stringBuffer.append('=');
        stringBuffer.append(this.relativeJump);
        stringBuffer.append(',');
        stringBuffer.append("elements");
        stringBuffer.append('=');
        stringBuffer.append(this.elements);
        stringBuffer.append(',');
        stringBuffer.append("absoluteListPos");
        stringBuffer.append('=');
        stringBuffer.append(this.absoluteListPos);
        stringBuffer.append(',');
        stringBuffer.append("jobModification");
        stringBuffer.append('=');
        stringBuffer.append(this.jobModification);
        stringBuffer.append(',');
        stringBuffer.append("jobID");
        stringBuffer.append('=');
        stringBuffer.append(this.jobID);
        stringBuffer.append(',');
        stringBuffer.append("jobPriority");
        stringBuffer.append('=');
        stringBuffer.append(this.jobPriority);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

