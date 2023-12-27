/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.exlap;

public class Service {
    public int id;
    public int status;

    public Service() {
        this.id = -1;
        this.status = -1;
    }

    public Service(int n, int n2) {
        this.id = n;
        this.status = n2;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int n) {
        this.id = n;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int n) {
        this.status = n;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("Service");
        stringBuffer.append('(');
        stringBuffer.append("id");
        stringBuffer.append('=');
        stringBuffer.append(this.id);
        stringBuffer.append(',');
        stringBuffer.append("status");
        stringBuffer.append('=');
        stringBuffer.append(this.status);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

