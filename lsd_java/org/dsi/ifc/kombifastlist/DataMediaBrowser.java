/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombifastlist;

public class DataMediaBrowser {
    public long pos;
    public int fileType;
    public long fileState;
    public String fileName;

    public DataMediaBrowser() {
        this.pos = 0L;
        this.fileType = 0;
        this.fileState = 0L;
        this.fileName = "";
    }

    public DataMediaBrowser(long l, int n, long l2, String string) {
        this.pos = l;
        this.fileType = n;
        this.fileState = l2;
        this.fileName = string;
    }

    public long getPos() {
        return this.pos;
    }

    public int getFileType() {
        return this.fileType;
    }

    public long getFileState() {
        return this.fileState;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("DataMediaBrowser");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("fileType");
        stringBuffer.append('=');
        stringBuffer.append(this.fileType);
        stringBuffer.append(',');
        stringBuffer.append("fileState");
        stringBuffer.append('=');
        stringBuffer.append(this.fileState);
        stringBuffer.append(',');
        stringBuffer.append("fileName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.fileName);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

