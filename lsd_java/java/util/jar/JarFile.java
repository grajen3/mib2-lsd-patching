/*
 * Decompiled with CFR 0.152.
 */
package java.util.jar;

import java.io.File;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile$1$JarFileEnumerator;
import java.util.jar.JarFile$JarFileInputStream;
import java.util.jar.JarVerifier;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class JarFile
extends ZipFile {
    public static final String MANIFEST_NAME;
    static final String META_DIR;
    private Manifest manifest;
    private ZipEntry manifestEntry;
    JarVerifier verifier;

    public JarFile(File file) {
        this(file, true);
    }

    public JarFile(File file, boolean bl) {
        super(file);
        if (bl) {
            this.verifier = new JarVerifier(file.getPath());
        }
        this.readMetaEntries();
    }

    public JarFile(File file, boolean bl, int n) {
        super(file, n);
        if (bl) {
            this.verifier = new JarVerifier(file.getPath());
        }
        this.readMetaEntries();
    }

    public JarFile(String string) {
        this(string, true);
    }

    public JarFile(String string, boolean bl) {
        super(string);
        if (bl) {
            this.verifier = new JarVerifier(string);
        }
        this.readMetaEntries();
    }

    @Override
    public Enumeration entries() {
        return new JarFile$1$JarFileEnumerator(this, super.entries(), this);
    }

    public JarEntry getJarEntry(String string) {
        return (JarEntry)this.getEntry(string);
    }

    public Manifest getManifest() {
        if (this.manifest != null) {
            return this.manifest;
        }
        if (this.manifestEntry != null) {
            InputStream inputStream = super.getInputStream(this.manifestEntry);
            if (this.verifier != null) {
                byte[] byArray = new byte[inputStream.available()];
                inputStream.mark(byArray.length);
                inputStream.read(byArray, 0, byArray.length);
                inputStream.reset();
                this.verifier.addMetaEntry(this.manifestEntry.getName(), byArray);
            }
            try {
                this.manifest = new Manifest(inputStream, this.verifier != null);
            }
            finally {
                inputStream.close();
            }
            this.manifestEntry = null;
        }
        return this.manifest;
    }

    private void readMetaEntries() {
        ZipEntry[] zipEntryArray = this.getMetaEntriesImpl(null);
        int n = "META-INF/".length();
        boolean bl = false;
        if (zipEntryArray != null) {
            int n2 = 0;
            while (n2 < zipEntryArray.length) {
                ZipEntry zipEntry = zipEntryArray[n2];
                String string = zipEntry.getName();
                if (this.manifestEntry == null && this.manifest == null && string.regionMatches(true, n, "META-INF/MANIFEST.MF", n, "META-INF/MANIFEST.MF".length() - n)) {
                    this.manifestEntry = zipEntry;
                    if (this.verifier == null) {
                        break;
                    }
                } else if (this.verifier != null && string.length() > n && (string.regionMatches(true, string.length() - 3, ".SF", 0, 3) || string.regionMatches(true, string.length() - 4, ".DSA", 0, 4) || string.regionMatches(true, string.length() - 4, ".RSA", 0, 4))) {
                    bl = true;
                    InputStream inputStream = super.getInputStream(zipEntry);
                    byte[] byArray = new byte[inputStream.available()];
                    inputStream.read(byArray, 0, byArray.length);
                    inputStream.close();
                    this.verifier.addMetaEntry(string, byArray);
                }
                ++n2;
            }
        }
        if (!bl) {
            this.verifier = null;
        }
    }

    @Override
    public InputStream getInputStream(ZipEntry zipEntry) {
        InputStream inputStream;
        if (this.manifestEntry != null) {
            this.getManifest();
        }
        if (this.verifier != null) {
            this.verifier.setManifest(this.getManifest());
            if (this.verifier.readCertificates()) {
                this.verifier.removeMetaEntries();
                if (this.manifest != null) {
                    this.manifest.removeChunks();
                }
                if (!this.verifier.isSignedJar()) {
                    this.verifier = null;
                }
            }
        }
        if ((inputStream = super.getInputStream(zipEntry)) == null) {
            return null;
        }
        return new JarFile$JarFileInputStream(inputStream, zipEntry, zipEntry.getSize() >= 0L ? this.verifier : null);
    }

    @Override
    public ZipEntry getEntry(String string) {
        ZipEntry zipEntry = super.getEntry(string);
        if (zipEntry == null) {
            return zipEntry;
        }
        JarEntry jarEntry = new JarEntry(zipEntry);
        jarEntry.parentJar = this;
        if (this.verifier != null) {
            jarEntry.certificates = this.verifier.getCertificates(jarEntry.getName());
        }
        return jarEntry;
    }

    private native ZipEntry[] getMetaEntriesImpl(byte[] byArray) {
    }
}

