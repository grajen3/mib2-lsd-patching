/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carseat;

public class MassageProgs {
    public boolean program1Exist;
    public boolean program2Exist;
    public boolean program3Exist;
    public boolean program4Exist;
    public boolean program5Exist;
    public boolean program6Exist;
    public boolean program7Exist;
    public boolean program8Exist;

    public MassageProgs() {
        this.program1Exist = false;
        this.program2Exist = false;
        this.program3Exist = false;
        this.program4Exist = false;
        this.program5Exist = false;
        this.program6Exist = false;
        this.program7Exist = false;
        this.program8Exist = false;
    }

    public MassageProgs(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.program1Exist = bl;
        this.program2Exist = bl2;
        this.program3Exist = bl3;
        this.program4Exist = bl4;
        this.program5Exist = bl5;
        this.program6Exist = bl6;
        this.program7Exist = false;
        this.program8Exist = false;
    }

    public MassageProgs(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
        this.program1Exist = bl;
        this.program2Exist = bl2;
        this.program3Exist = bl3;
        this.program4Exist = bl4;
        this.program5Exist = bl5;
        this.program6Exist = bl6;
        this.program7Exist = bl7;
        this.program8Exist = bl8;
    }

    public boolean isProgram1Exist() {
        return this.program1Exist;
    }

    public boolean isProgram2Exist() {
        return this.program2Exist;
    }

    public boolean isProgram3Exist() {
        return this.program3Exist;
    }

    public boolean isProgram4Exist() {
        return this.program4Exist;
    }

    public boolean isProgram5Exist() {
        return this.program5Exist;
    }

    public boolean isProgram6Exist() {
        return this.program6Exist;
    }

    public boolean isProgram7Exist() {
        return this.program7Exist;
    }

    public boolean isProgram8Exist() {
        return this.program8Exist;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(400);
        stringBuffer.append("MassageProgs");
        stringBuffer.append('(');
        stringBuffer.append("program1Exist");
        stringBuffer.append('=');
        stringBuffer.append(this.program1Exist);
        stringBuffer.append(',');
        stringBuffer.append("program2Exist");
        stringBuffer.append('=');
        stringBuffer.append(this.program2Exist);
        stringBuffer.append(',');
        stringBuffer.append("program3Exist");
        stringBuffer.append('=');
        stringBuffer.append(this.program3Exist);
        stringBuffer.append(',');
        stringBuffer.append("program4Exist");
        stringBuffer.append('=');
        stringBuffer.append(this.program4Exist);
        stringBuffer.append(',');
        stringBuffer.append("program5Exist");
        stringBuffer.append('=');
        stringBuffer.append(this.program5Exist);
        stringBuffer.append(',');
        stringBuffer.append("program6Exist");
        stringBuffer.append('=');
        stringBuffer.append(this.program6Exist);
        stringBuffer.append(',');
        stringBuffer.append("program7Exist");
        stringBuffer.append('=');
        stringBuffer.append(this.program7Exist);
        stringBuffer.append(',');
        stringBuffer.append("program8Exist");
        stringBuffer.append('=');
        stringBuffer.append(this.program8Exist);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

