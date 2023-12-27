/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket;

import de.esolutions.fw.util.commons.Buffer;

public class MultiFileNamer {
    private final String baseName;
    private final String suffix;
    private final int numDigits;
    private int index;

    public MultiFileNamer(String string, String string2, int n, int n2) {
        this.baseName = string;
        this.suffix = string2;
        this.numDigits = n;
        this.index = n2;
    }

    public MultiFileNamer(String string, String string2) {
        this(string, string2, 4, 0);
    }

    public String nextFileName() {
        Buffer buffer = new Buffer();
        buffer.append(this.baseName);
        buffer.append('_');
        String string = new StringBuffer().append("0000000000").append(Integer.toString(this.index)).toString();
        int n = string.length() - this.numDigits;
        buffer.append(string.substring(n));
        buffer.append('.');
        buffer.append(this.suffix);
        ++this.index;
        return buffer.toString();
    }
}

