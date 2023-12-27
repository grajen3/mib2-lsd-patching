/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardriverassistance;

public class TSDSignInfo {
    public boolean roadWorkSign;
    public boolean sourceIsCamera;
    public boolean signWarning;
    public boolean mph;
    public boolean sourceIsDatabase;
    public boolean sourceIsFusion;
    public boolean startUrbanArea;
    public boolean endUrbanArea;
    public boolean startTrafficCalmedArea;
    public boolean endTrafficCalmedArea;
    public boolean signEffective;
    public boolean acousticWarning;

    public TSDSignInfo() {
        this.roadWorkSign = false;
        this.sourceIsCamera = false;
        this.signWarning = false;
        this.mph = false;
        this.sourceIsDatabase = false;
        this.sourceIsFusion = false;
        this.startUrbanArea = false;
        this.endUrbanArea = false;
        this.startTrafficCalmedArea = false;
        this.endTrafficCalmedArea = false;
        this.signEffective = false;
        this.acousticWarning = false;
    }

    public TSDSignInfo(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.roadWorkSign = bl;
        this.sourceIsCamera = bl2;
        this.signWarning = bl3;
        this.mph = bl4;
        this.sourceIsDatabase = bl5;
        this.sourceIsFusion = bl6;
        this.startUrbanArea = false;
        this.endUrbanArea = false;
        this.startTrafficCalmedArea = false;
        this.endTrafficCalmedArea = false;
        this.signEffective = false;
        this.acousticWarning = false;
    }

    public TSDSignInfo(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12) {
        this.roadWorkSign = bl;
        this.sourceIsCamera = bl2;
        this.signWarning = bl3;
        this.mph = bl4;
        this.sourceIsDatabase = bl5;
        this.sourceIsFusion = bl6;
        this.startUrbanArea = bl7;
        this.endUrbanArea = bl8;
        this.startTrafficCalmedArea = bl9;
        this.endTrafficCalmedArea = bl10;
        this.signEffective = bl11;
        this.acousticWarning = bl12;
    }

    public boolean isRoadWorkSign() {
        return this.roadWorkSign;
    }

    public boolean isSourceIsCamera() {
        return this.sourceIsCamera;
    }

    public boolean isSignWarning() {
        return this.signWarning;
    }

    public boolean isMph() {
        return this.mph;
    }

    public boolean isSourceIsDatabase() {
        return this.sourceIsDatabase;
    }

    public boolean isSourceIsFusion() {
        return this.sourceIsFusion;
    }

    public boolean isStartUrbanArea() {
        return this.startUrbanArea;
    }

    public boolean isEndUrbanArea() {
        return this.endUrbanArea;
    }

    public boolean isStartTrafficCalmedArea() {
        return this.startTrafficCalmedArea;
    }

    public boolean isEndTrafficCalmedArea() {
        return this.endTrafficCalmedArea;
    }

    public boolean isSignEffective() {
        return this.signEffective;
    }

    public boolean isAcousticWarning() {
        return this.acousticWarning;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(600);
        stringBuffer.append("TSDSignInfo");
        stringBuffer.append('(');
        stringBuffer.append("roadWorkSign");
        stringBuffer.append('=');
        stringBuffer.append(this.roadWorkSign);
        stringBuffer.append(',');
        stringBuffer.append("sourceIsCamera");
        stringBuffer.append('=');
        stringBuffer.append(this.sourceIsCamera);
        stringBuffer.append(',');
        stringBuffer.append("signWarning");
        stringBuffer.append('=');
        stringBuffer.append(this.signWarning);
        stringBuffer.append(',');
        stringBuffer.append("mph");
        stringBuffer.append('=');
        stringBuffer.append(this.mph);
        stringBuffer.append(',');
        stringBuffer.append("sourceIsDatabase");
        stringBuffer.append('=');
        stringBuffer.append(this.sourceIsDatabase);
        stringBuffer.append(',');
        stringBuffer.append("sourceIsFusion");
        stringBuffer.append('=');
        stringBuffer.append(this.sourceIsFusion);
        stringBuffer.append(',');
        stringBuffer.append("startUrbanArea");
        stringBuffer.append('=');
        stringBuffer.append(this.startUrbanArea);
        stringBuffer.append(',');
        stringBuffer.append("endUrbanArea");
        stringBuffer.append('=');
        stringBuffer.append(this.endUrbanArea);
        stringBuffer.append(',');
        stringBuffer.append("startTrafficCalmedArea");
        stringBuffer.append('=');
        stringBuffer.append(this.startTrafficCalmedArea);
        stringBuffer.append(',');
        stringBuffer.append("endTrafficCalmedArea");
        stringBuffer.append('=');
        stringBuffer.append(this.endTrafficCalmedArea);
        stringBuffer.append(',');
        stringBuffer.append("signEffective");
        stringBuffer.append('=');
        stringBuffer.append(this.signEffective);
        stringBuffer.append(',');
        stringBuffer.append("acousticWarning");
        stringBuffer.append('=');
        stringBuffer.append(this.acousticWarning);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

