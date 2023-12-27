/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.filebrowser;

public class BrowsedFile {
    public long id;
    public boolean selected;
    public String filename;
    public int fileType;
    public long fileSize;

    public BrowsedFile() {
    }

    public BrowsedFile(long l, boolean bl, String string, int n, long l2) {
        this.id = l;
        this.selected = bl;
        this.filename = string;
        this.fileType = n;
        this.fileSize = l2;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long l) {
        this.id = l;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean bl) {
        this.selected = bl;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String string) {
        this.filename = string;
    }

    public int getFileType() {
        return this.fileType;
    }

    public void setFileType(int n) {
        this.fileType = n;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(long l) {
        this.fileSize = l;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("BrowsedFile");
        stringBuffer.append('(');
        stringBuffer.append("id");
        stringBuffer.append('=');
        stringBuffer.append(this.id);
        stringBuffer.append(',');
        stringBuffer.append("selected");
        stringBuffer.append('=');
        stringBuffer.append(this.selected);
        stringBuffer.append(',');
        stringBuffer.append("filename");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.filename);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("fileType");
        stringBuffer.append('=');
        stringBuffer.append(this.fileType);
        stringBuffer.append(',');
        stringBuffer.append("fileSize");
        stringBuffer.append('=');
        stringBuffer.append(this.fileSize);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

