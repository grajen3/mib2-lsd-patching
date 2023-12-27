/*
 * Decompiled with CFR 0.152.
 */
package java.util.jar;

import java.io.OutputStream;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class JarOutputStream
extends ZipOutputStream {
    private Manifest manifest;

    public JarOutputStream(OutputStream outputStream, Manifest manifest) {
        super(outputStream);
        if (manifest == null) {
            throw new NullPointerException();
        }
        this.manifest = manifest;
        ZipEntry zipEntry = new ZipEntry("META-INF/MANIFEST.MF");
        this.putNextEntry(zipEntry);
        this.manifest.write(this);
        this.closeEntry();
    }

    public JarOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override
    public void putNextEntry(ZipEntry zipEntry) {
        super.putNextEntry(zipEntry);
    }
}

