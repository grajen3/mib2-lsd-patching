/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class NavDataBase {
    public long uid;
    public boolean currentlyInUse;
    public String name;
    public String language;
    public String path;

    public NavDataBase() {
        this.uid = 0L;
        this.currentlyInUse = false;
        this.name = null;
        this.language = null;
        this.path = null;
    }

    public NavDataBase(long l, boolean bl, String string, String string2, String string3) {
        this.uid = l;
        this.currentlyInUse = bl;
        this.name = string;
        this.language = string2;
        this.path = string3;
    }

    public long getUid() {
        return this.uid;
    }

    public boolean isCurrentlyInUse() {
        return this.currentlyInUse;
    }

    public String getName() {
        return this.name;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getPath() {
        return this.path;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("NavDataBase");
        stringBuffer.append('(');
        stringBuffer.append("uid");
        stringBuffer.append('=');
        stringBuffer.append(this.uid);
        stringBuffer.append(',');
        stringBuffer.append("currentlyInUse");
        stringBuffer.append('=');
        stringBuffer.append(this.currentlyInUse);
        stringBuffer.append(',');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("language");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.language);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("path");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.path);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

