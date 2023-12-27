/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.filebrowser;

import org.dsi.ifc.filebrowser.BrowsedFile;
import org.dsi.ifc.filebrowser.Path;

public class BrowsedFileSet {
    public Path path;
    public BrowsedFile[] files;

    public BrowsedFileSet() {
        this.path = null;
        this.files = null;
    }

    public BrowsedFileSet(Path path, BrowsedFile[] browsedFileArray) {
        this.path = path;
        this.files = browsedFileArray;
    }

    public Path getPath() {
        return this.path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public BrowsedFile[] getFiles() {
        return this.files;
    }

    public void setFiles(BrowsedFile[] browsedFileArray) {
        this.files = browsedFileArray;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1100);
        stringBuffer.append("BrowsedFileSet");
        stringBuffer.append('(');
        stringBuffer.append("path");
        stringBuffer.append('=');
        stringBuffer.append(this.path);
        stringBuffer.append(',');
        stringBuffer.append("files");
        stringBuffer.append('[');
        if (this.files != null) {
            stringBuffer.append(this.files.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.files != null) {
            int n = this.files.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.files[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.files);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

