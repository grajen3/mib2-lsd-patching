/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcard.a;

import de.eso.a.d.b;
import de.eso.vcard.a.c;
import java.io.File;
import java.io.FilenameFilter;

class d
implements FilenameFilter {
    private int a;
    private boolean b;
    private final c c;

    d(c c2) {
        this.c = c2;
        this.a = 0;
        this.b = false;
    }

    @Override
    public boolean accept(File file, String string) {
        if (this.a >= 500) {
            if (!this.b) {
                de.eso.a.d.b.d(new StringBuffer().append("Too much vcardFiles in directory. Omitting the rest of ").append(de.eso.vcard.a.c.a(this.c)).toString());
            }
            this.b = true;
            return false;
        }
        if (string.toLowerCase().endsWith("vcf")) {
            ++this.a;
            return true;
        }
        return false;
    }
}

