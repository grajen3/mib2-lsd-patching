/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.speechrec;

public class GrammarInfo {
    public int id;
    public int commandHieratchy;

    public GrammarInfo() {
        this.id = 0;
        this.commandHieratchy = 0;
    }

    public GrammarInfo(int n, int n2) {
        this.id = n;
        this.commandHieratchy = n2;
    }

    public int getId() {
        return this.id;
    }

    public int getCommandHieratchy() {
        return this.commandHieratchy;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("GrammarInfo");
        stringBuffer.append('(');
        stringBuffer.append("id");
        stringBuffer.append('=');
        stringBuffer.append(this.id);
        stringBuffer.append(',');
        stringBuffer.append("commandHieratchy");
        stringBuffer.append('=');
        stringBuffer.append(this.commandHieratchy);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

