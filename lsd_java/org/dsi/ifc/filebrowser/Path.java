/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.filebrowser;

public class Path {
    public String mountPoint;
    public String[] folderNames;

    public Path() {
        this.mountPoint = null;
        this.folderNames = null;
    }

    public Path(String string, String[] stringArray) {
        this.mountPoint = string;
        this.folderNames = stringArray;
    }

    public String getMountPoint() {
        return this.mountPoint;
    }

    public void setMountPoint(String string) {
        this.mountPoint = string;
    }

    public String[] getFolderNames() {
        return this.folderNames;
    }

    public void setFolderNames(String[] stringArray) {
        this.folderNames = stringArray;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("Path");
        stringBuffer.append('(');
        stringBuffer.append("mountPoint");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.mountPoint);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("folderNames");
        stringBuffer.append('[');
        if (this.folderNames != null) {
            stringBuffer.append(this.folderNames.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.folderNames != null) {
            int n = this.folderNames.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append('\"');
                stringBuffer.append(this.folderNames[i2]);
                stringBuffer.append('\"');
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.folderNames);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

