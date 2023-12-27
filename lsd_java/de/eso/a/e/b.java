/*
 * Decompiled with CFR 0.152.
 */
package de.eso.a.e;

import java.io.File;

public class b {
    private String a;

    public b(String string) {
        if (!string.startsWith(".")) {
            string = new StringBuffer().append(".").append(string).toString();
        }
        this.a = string;
    }

    public File a(File file, String string) {
        String string2 = this.a(string);
        int n = 2;
        File file2 = new File(file, new StringBuffer().append(string2).append(this.a).toString());
        while (file2.exists()) {
            if (n > 100) {
                de.eso.a.d.b.d(new StringBuffer().append("Tried to find a unique filename, but failed. Returning null instead. Filename was: ").append(string2).toString());
                return null;
            }
            String string3 = new StringBuffer().append(string2).append("-").append(n).append(this.a).toString();
            file2 = new File(file, string3);
            ++n;
        }
        return file2;
    }

    private String a(String string) {
        string = string.replace('/', '_');
        string = string.replace('\\', '_');
        string = string.replace(':', '_');
        string = string.replace('*', '_');
        string = string.replace('?', '_');
        string = string.replace('\"', '_');
        string = string.replace('<', '_');
        string = string.replace('>', '_');
        string = string.replace('|', '_');
        string = string.replace('\n', '_');
        string = string.replace('\r', '_');
        string = string.replace('\t', '_');
        return string;
    }
}

