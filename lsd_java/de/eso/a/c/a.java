/*
 * Decompiled with CFR 0.152.
 */
package de.eso.a.c;

import de.eso.a.c.b;
import java.io.File;
import java.io.InputStream;

public class a {
    private InputStream a;
    private File b;
    private b c;
    private boolean d = true;

    public a(File file, b b2) {
        this.b = file;
        this.c = b2;
        this.a = null;
    }

    public a(InputStream inputStream, b b2) {
        this.a = inputStream;
        this.b = null;
        this.c = b2;
    }

    public void a() {
        this.d = true;
        if (this.b != null) {
            this.a(this.b);
        } else {
            this.a(this.a);
        }
    }

    private void a(File file) {
        if (!this.d) {
            return;
        }
        if (file.isDirectory()) {
            File[] fileArray = file.listFiles();
            if (fileArray != null) {
                for (int i2 = 0; i2 < fileArray.length; ++i2) {
                    this.a(fileArray[i2]);
                }
            }
        } else if (this.c != null) {
            this.d = this.c.a(file);
        }
    }

    private void a(InputStream inputStream) {
        if (!this.d) {
            return;
        }
        if (inputStream != null && this.c != null) {
            this.d = this.c.a(inputStream);
        }
    }
}

