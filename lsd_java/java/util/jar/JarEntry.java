/*
 * Decompiled with CFR 0.152.
 */
package java.util.jar;

import java.security.cert.Certificate;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;

public class JarEntry
extends ZipEntry {
    private Attributes attributes;
    JarFile parentJar;
    Certificate[] certificates;

    public JarEntry(String string) {
        super(string);
    }

    public JarEntry(ZipEntry zipEntry) {
        super(zipEntry);
    }

    public Attributes getAttributes() {
        if (this.attributes != null || this.parentJar == null) {
            return this.attributes;
        }
        Manifest manifest = this.parentJar.getManifest();
        if (manifest == null) {
            return null;
        }
        this.attributes = manifest.getAttributes(this.getName());
        return this.attributes;
    }

    public Certificate[] getCertificates() {
        return this.certificates;
    }

    void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public JarEntry(JarEntry jarEntry) {
        super(jarEntry);
        this.parentJar = jarEntry.parentJar;
        this.attributes = jarEntry.attributes;
        this.certificates = jarEntry.certificates;
    }
}

