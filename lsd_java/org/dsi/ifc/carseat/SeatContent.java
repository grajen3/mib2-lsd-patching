/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carseat;

public class SeatContent {
    public int content1RL;
    public int memoryDetail1RL;
    public int content1RR;
    public int memoryDetail1RR;
    public int content2RL;
    public int memoryDetail2RL;
    public int content2RR;
    public int memoryDetail2RR;

    public SeatContent() {
        this.content1RL = 0;
        this.memoryDetail1RL = 0;
        this.content1RR = 0;
        this.memoryDetail1RR = 0;
        this.content2RL = 0;
        this.memoryDetail2RL = 0;
        this.content2RR = 0;
        this.memoryDetail2RR = 0;
    }

    public SeatContent(int n, int n2, int n3, int n4) {
        this.content1RL = n;
        this.memoryDetail1RL = n2;
        this.content1RR = n3;
        this.memoryDetail1RR = n4;
        this.content2RL = 0;
        this.memoryDetail2RL = 0;
        this.content2RR = 0;
        this.memoryDetail2RR = 0;
    }

    public SeatContent(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.content1RL = n;
        this.memoryDetail1RL = n2;
        this.content1RR = n3;
        this.memoryDetail1RR = n4;
        this.content2RL = n5;
        this.memoryDetail2RL = n6;
        this.content2RR = n7;
        this.memoryDetail2RR = n8;
    }

    public int getContent1RL() {
        return this.content1RL;
    }

    public int getMemoryDetail1RL() {
        return this.memoryDetail1RL;
    }

    public int getContent1RR() {
        return this.content1RR;
    }

    public int getMemoryDetail1RR() {
        return this.memoryDetail1RR;
    }

    public int getContent2RL() {
        return this.content2RL;
    }

    public int getMemoryDetail2RL() {
        return this.memoryDetail2RL;
    }

    public int getContent2RR() {
        return this.content2RR;
    }

    public int getMemoryDetail2RR() {
        return this.memoryDetail2RR;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(500);
        stringBuffer.append("SeatContent");
        stringBuffer.append('(');
        stringBuffer.append("content1RL");
        stringBuffer.append('=');
        stringBuffer.append(this.content1RL);
        stringBuffer.append(',');
        stringBuffer.append("memoryDetail1RL");
        stringBuffer.append('=');
        stringBuffer.append(this.memoryDetail1RL);
        stringBuffer.append(',');
        stringBuffer.append("content1RR");
        stringBuffer.append('=');
        stringBuffer.append(this.content1RR);
        stringBuffer.append(',');
        stringBuffer.append("memoryDetail1RR");
        stringBuffer.append('=');
        stringBuffer.append(this.memoryDetail1RR);
        stringBuffer.append(',');
        stringBuffer.append("content2RL");
        stringBuffer.append('=');
        stringBuffer.append(this.content2RL);
        stringBuffer.append(',');
        stringBuffer.append("memoryDetail2RL");
        stringBuffer.append('=');
        stringBuffer.append(this.memoryDetail2RL);
        stringBuffer.append(',');
        stringBuffer.append("content2RR");
        stringBuffer.append('=');
        stringBuffer.append(this.content2RR);
        stringBuffer.append(',');
        stringBuffer.append("memoryDetail2RR");
        stringBuffer.append('=');
        stringBuffer.append(this.memoryDetail2RR);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

