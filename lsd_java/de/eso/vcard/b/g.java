/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcard.b;

import de.eso.a.b.a;
import de.eso.a.b.e;
import de.eso.a.b.f;
import de.eso.a.d.b;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class g
extends a {
    private BufferedOutputStream C = null;
    private File D = null;
    private static File E = new File("/organizerdisk/vcard");
    private static boolean F = false;

    public g(File file, f f2) {
        this.o = file;
        this.p = new FileInputStream(this.o);
        this.r = new e(f2);
    }

    public g(InputStream inputStream, f f2) {
        this.o = null;
        this.p = inputStream;
        this.r = new e(f2);
    }

    public static void a(File file) {
        E = file;
    }

    public static void a(boolean bl) {
        F = bl;
    }

    public static boolean e() {
        return F;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final void a(int n) {
        if (this.C != null) {
            try {
                this.C.flush();
                this.C.close();
                if (this.w) {
                    de.eso.a.d.b.c(new StringBuffer().append("Deleting binary file ").append(this.D).toString());
                    if (!this.D.delete()) {
                        de.eso.a.d.b.d(new StringBuffer().append("Error deleting the binary file ").append(this.D).toString());
                    }
                    this.D = null;
                } else if (this.D != null) {
                    de.eso.a.d.b.c(new StringBuffer().append("Closed file ").append(this.D).toString());
                    this.r.a(this.D, n);
                } else {
                    de.eso.a.d.b.d("Binary file was null!");
                }
            }
            catch (IOException iOException) {
                de.eso.a.d.b.d(new StringBuffer().append("Error reading binary file ").append(this.D).toString());
            }
            finally {
                this.C = null;
                this.D = null;
            }
        }
    }

    private void b(byte by) {
        if (this.C == null && !this.w) {
            try {
                boolean bl;
                if (!E.exists() && !(bl = E.mkdirs())) {
                    de.eso.a.d.b.d(new StringBuffer().append("Could not access binary temp dir ").append(E.getAbsolutePath()).toString());
                    this.w = true;
                    return;
                }
                String string = ".bin";
                if ("PHOTO".equalsIgnoreCase(this.x)) {
                    string = ".jpg";
                }
                this.w = false;
                this.v = 0L;
                String string2 = this.o == null ? "rfc_file" : this.o.getName();
                this.D = File.createTempFile(new StringBuffer().append("vcard_").append(string2).append("_").append(this.x).toString(), string, E);
                this.C = new BufferedOutputStream(new FileOutputStream(this.D));
                de.eso.a.d.b.c(new StringBuffer().append("Writing binary content to :").append(this.D.getAbsolutePath()).toString());
            }
            catch (Exception exception) {
                de.eso.a.d.b.d(new StringBuffer().append("Error opening temp file for binary rfc content: ").append(exception.getMessage()).toString());
                this.w = true;
            }
        }
        if (this.C != null) {
            if (this.w) {
                return;
            }
            if (this.v > de.eso.a.b.a.d()) {
                de.eso.a.d.b.d(new StringBuffer().append("Writing to binary file exceeded quota of ").append(de.eso.a.b.a.d()).append(" bytes. Deleting partly written file.").toString());
                this.w = true;
            }
            try {
                this.C.write(by);
                ++this.v;
            }
            catch (IOException iOException) {
                de.eso.a.d.b.d("Error writing binary content to temp file");
            }
        }
    }

    @Override
    public final void a(byte by) {
        this.z = true;
        if ("PHOTO".equalsIgnoreCase(this.x)) {
            this.b(by);
        } else {
            this.q.a(by);
        }
    }

    @Override
    public void b(String string) {
        this.B = this.r.g();
        if (this.B) {
            return;
        }
        if ("BEGIN".equalsIgnoreCase(string)) {
            this.A = true;
            ++this.y;
        } else if ("END".equalsIgnoreCase(string)) {
            if (this.y == 0) {
                this.c();
                this.B = this.r.g();
                if (this.B) {
                    return;
                }
            }
            --this.y;
        }
    }
}

