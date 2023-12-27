/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.uota;

public class PackageInfo {
    public String symbolicName;
    public String category;
    public String version;
    public String[] hierarchyInfo;
    public int priority;
    public String label;
    public long size;
    public int type;
    public String[] extras;

    public PackageInfo() {
        this.symbolicName = null;
        this.category = null;
        this.version = null;
        this.hierarchyInfo = null;
        this.priority = 0;
        this.label = null;
        this.size = 0L;
        this.type = -1;
        this.extras = null;
    }

    public PackageInfo(String string, String string2, String string3, String[] stringArray, int n, String string4, long l, int n2, String[] stringArray2) {
        this.symbolicName = string;
        this.category = string2;
        this.version = string3;
        this.hierarchyInfo = stringArray;
        this.priority = n;
        this.label = string4;
        this.size = l;
        this.type = n2;
        this.extras = stringArray2;
    }

    public String getSymbolicName() {
        return this.symbolicName;
    }

    public String getCategory() {
        return this.category;
    }

    public String getVersion() {
        return this.version;
    }

    public int getType() {
        return this.type;
    }

    public String[] getHierarchyInfo() {
        return this.hierarchyInfo;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getLabel() {
        return this.label;
    }

    public long getSize() {
        return this.size;
    }

    public String[] getExtras() {
        return this.extras;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(550);
        stringBuffer.append("PackageInfo");
        stringBuffer.append('(');
        stringBuffer.append("symbolicName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.symbolicName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("category");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.category);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("version");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.version);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("hierarchyInfo");
        stringBuffer.append('[');
        if (this.hierarchyInfo != null) {
            stringBuffer.append(this.hierarchyInfo.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.hierarchyInfo != null) {
            n3 = this.hierarchyInfo.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.hierarchyInfo[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.hierarchyInfo);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("priority");
        stringBuffer.append('=');
        stringBuffer.append(this.priority);
        stringBuffer.append(',');
        stringBuffer.append("label");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.label);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("size");
        stringBuffer.append('=');
        stringBuffer.append(this.size);
        stringBuffer.append(',');
        stringBuffer.append("type");
        stringBuffer.append('=');
        stringBuffer.append(this.type);
        stringBuffer.append(',');
        stringBuffer.append("extras");
        stringBuffer.append('[');
        if (this.extras != null) {
            stringBuffer.append(this.extras.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.extras != null) {
            n3 = this.extras.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.extras[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.extras);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

