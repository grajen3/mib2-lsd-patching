/*
 * Decompiled with CFR 0.152.
 */
package java.util.jar;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarVerifier;
import java.util.jar.JarVerifier$VerifierEntry;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class JarInputStream
extends ZipInputStream {
    private Manifest manifest;
    private boolean eos = false;
    private JarEntry mEntry;
    private JarEntry jarEntry;
    private boolean isMeta;
    private JarVerifier verifier;
    private OutputStream verStream;

    public JarInputStream(InputStream inputStream, boolean bl) {
        super(inputStream);
        if (bl) {
            this.verifier = new JarVerifier("JarInputStream");
        }
        if ((this.mEntry = this.getNextJarEntry()) == null) {
            return;
        }
        String string = this.mEntry.getName().toUpperCase();
        if (string.equals("META-INF/")) {
            this.mEntry = null;
            this.closeEntry();
            this.mEntry = this.getNextJarEntry();
            string = this.mEntry.getName().toUpperCase();
        }
        if (string.equals("META-INF/MANIFEST.MF")) {
            this.mEntry = null;
            this.manifest = new Manifest(this, bl);
            this.closeEntry();
            if (bl) {
                this.verifier.setManifest(this.manifest);
            }
        } else {
            Attributes attributes = new Attributes(3);
            attributes.map.put("hidden", null);
            this.mEntry.setAttributes(attributes);
        }
    }

    public JarInputStream(InputStream inputStream) {
        this(inputStream, true);
    }

    public Manifest getManifest() {
        return this.manifest;
    }

    public JarEntry getNextJarEntry() {
        return (JarEntry)this.getNextEntry();
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        if (this.mEntry != null) {
            return -1;
        }
        int n3 = super.read(byArray, n, n2);
        if (this.verStream != null && !this.eos) {
            if (n3 == -1) {
                this.eos = true;
                if (this.isMeta) {
                    this.verifier.addMetaEntry(this.jarEntry.getName(), ((ByteArrayOutputStream)this.verStream).toByteArray());
                    this.verifier.readCertificates();
                } else {
                    this.verifier.verifySignatures((JarVerifier$VerifierEntry)this.verStream, this.jarEntry);
                }
            } else {
                this.verStream.write(byArray, n, n3);
            }
        }
        return n3;
    }

    @Override
    public ZipEntry getNextEntry() {
        this.eos = false;
        if (this.mEntry != null) {
            this.jarEntry = this.mEntry;
            this.mEntry = null;
            this.jarEntry.setAttributes(null);
            return this.jarEntry;
        }
        this.jarEntry = (JarEntry)super.getNextEntry();
        if (this.jarEntry == null) {
            return null;
        }
        if (this.verifier != null) {
            this.isMeta = this.jarEntry.getName().toUpperCase().startsWith("META-INF/");
            this.verStream = this.isMeta ? new ByteArrayOutputStream() : this.verifier.initEntry(this.jarEntry.getName());
        }
        return this.jarEntry;
    }

    @Override
    protected ZipEntry createZipEntry(String string) {
        JarEntry jarEntry = new JarEntry(string);
        if (this.manifest != null) {
            jarEntry.setAttributes(this.manifest.getAttributes(string));
        }
        return jarEntry;
    }
}

