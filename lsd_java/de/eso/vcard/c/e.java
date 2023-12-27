/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcard.c;

import de.eso.a.c.b;
import java.io.File;
import java.io.InputStream;

class e
implements b {
    e() {
    }

    @Override
    public boolean a(File file) {
        de.eso.a.d.b.c(file.getAbsolutePath());
        return true;
    }

    @Override
    public boolean a(InputStream inputStream) {
        return false;
    }
}

