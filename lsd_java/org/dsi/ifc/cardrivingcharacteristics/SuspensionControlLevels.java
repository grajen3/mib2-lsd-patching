/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

public class SuspensionControlLevels {
    public boolean level1;
    public boolean level2;
    public boolean level3;
    public boolean level4;
    public boolean level5;
    public boolean level6;
    public boolean level7;

    public SuspensionControlLevels() {
        this.level1 = false;
        this.level2 = false;
        this.level3 = false;
        this.level4 = false;
        this.level5 = false;
        this.level6 = false;
        this.level7 = false;
    }

    public SuspensionControlLevels(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7) {
        this.level1 = bl;
        this.level2 = bl2;
        this.level3 = bl3;
        this.level4 = bl4;
        this.level5 = bl5;
        this.level6 = bl6;
        this.level7 = bl7;
    }

    public boolean isLevel1() {
        return this.level1;
    }

    public boolean isLevel2() {
        return this.level2;
    }

    public boolean isLevel3() {
        return this.level3;
    }

    public boolean isLevel4() {
        return this.level4;
    }

    public boolean isLevel5() {
        return this.level5;
    }

    public boolean isLevel6() {
        return this.level6;
    }

    public boolean isLevel7() {
        return this.level7;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("SuspensionControlLevels");
        stringBuffer.append('(');
        stringBuffer.append("level1");
        stringBuffer.append('=');
        stringBuffer.append(this.level1);
        stringBuffer.append(',');
        stringBuffer.append("level2");
        stringBuffer.append('=');
        stringBuffer.append(this.level2);
        stringBuffer.append(',');
        stringBuffer.append("level3");
        stringBuffer.append('=');
        stringBuffer.append(this.level3);
        stringBuffer.append(',');
        stringBuffer.append("level4");
        stringBuffer.append('=');
        stringBuffer.append(this.level4);
        stringBuffer.append(',');
        stringBuffer.append("level5");
        stringBuffer.append('=');
        stringBuffer.append(this.level5);
        stringBuffer.append(',');
        stringBuffer.append("level6");
        stringBuffer.append('=');
        stringBuffer.append(this.level6);
        stringBuffer.append(',');
        stringBuffer.append("level7");
        stringBuffer.append('=');
        stringBuffer.append(this.level7);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

