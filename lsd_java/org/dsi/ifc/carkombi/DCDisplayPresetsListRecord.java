/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

import org.dsi.ifc.carkombi.DCDisplayPresetsListRecordDisplayData;

public class DCDisplayPresetsListRecord {
    public int pos;
    public int state;
    public int type;
    public int instance;
    public DCDisplayPresetsListRecordDisplayData display1;
    public DCDisplayPresetsListRecordDisplayData display2;
    public DCDisplayPresetsListRecordDisplayData display3;

    public DCDisplayPresetsListRecord() {
        this.pos = 0;
        this.state = 0;
        this.type = 0;
        this.instance = 0;
        this.display1 = null;
        this.display2 = null;
        this.display3 = null;
    }

    public DCDisplayPresetsListRecord(int n, int n2, int n3, int n4, DCDisplayPresetsListRecordDisplayData dCDisplayPresetsListRecordDisplayData, DCDisplayPresetsListRecordDisplayData dCDisplayPresetsListRecordDisplayData2, DCDisplayPresetsListRecordDisplayData dCDisplayPresetsListRecordDisplayData3) {
        this.pos = n;
        this.state = n2;
        this.type = n3;
        this.instance = n4;
        this.display1 = dCDisplayPresetsListRecordDisplayData;
        this.display2 = dCDisplayPresetsListRecordDisplayData2;
        this.display3 = dCDisplayPresetsListRecordDisplayData3;
    }

    public int getPos() {
        return this.pos;
    }

    public int getState() {
        return this.state;
    }

    public int getType() {
        return this.type;
    }

    public int getInstance() {
        return this.instance;
    }

    public DCDisplayPresetsListRecordDisplayData getDisplay1() {
        return this.display1;
    }

    public DCDisplayPresetsListRecordDisplayData getDisplay2() {
        return this.display2;
    }

    public DCDisplayPresetsListRecordDisplayData getDisplay3() {
        return this.display3;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(3250);
        stringBuffer.append("DCDisplayPresetsListRecord");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(',');
        stringBuffer.append("type");
        stringBuffer.append('=');
        stringBuffer.append(this.type);
        stringBuffer.append(',');
        stringBuffer.append("instance");
        stringBuffer.append('=');
        stringBuffer.append(this.instance);
        stringBuffer.append(',');
        stringBuffer.append("display1");
        stringBuffer.append('=');
        stringBuffer.append(this.display1);
        stringBuffer.append(',');
        stringBuffer.append("display2");
        stringBuffer.append('=');
        stringBuffer.append(this.display2);
        stringBuffer.append(',');
        stringBuffer.append("display3");
        stringBuffer.append('=');
        stringBuffer.append(this.display3);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

