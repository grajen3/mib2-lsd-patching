/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.Certificate;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public abstract class JarURLConnection
extends URLConnection {
    protected URLConnection jarFileURLConnection;
    private String entryName;
    private URL fileURL;
    private String file;

    protected JarURLConnection(URL uRL) {
        super(uRL);
        this.file = uRL.getFile();
        int n = this.file.lastIndexOf("!/");
        if (n < 0) {
            throw new MalformedURLException();
        }
        if (this.file.length() == n + 2) {
            return;
        }
        this.entryName = this.file.substring(n + 2, this.file.length());
    }

    public Attributes getAttributes() {
        JarEntry jarEntry = this.getJarEntry();
        return jarEntry == null ? null : jarEntry.getAttributes();
    }

    public Certificate[] getCertificates() {
        JarEntry jarEntry = this.getJarEntry();
        if (jarEntry == null) {
            return null;
        }
        return jarEntry.getCertificates();
    }

    public String getEntryName() {
        return this.entryName;
    }

    public JarEntry getJarEntry() {
        if (!this.connected) {
            this.connect();
        }
        return this.getJarFile().getJarEntry(this.entryName);
    }

    public Manifest getManifest() {
        return this.getJarFile().getManifest();
    }

    public abstract JarFile getJarFile() {
    }

    public URL getJarFileURL() {
        if (this.fileURL != null) {
            return this.fileURL;
        }
        try {
            this.fileURL = new URL(this.url.getFile().substring(0, this.url.getFile().lastIndexOf("!/")));
            return this.fileURL;
        }
        catch (MalformedURLException malformedURLException) {
            return null;
        }
    }

    public Attributes getMainAttributes() {
        Manifest manifest = this.getJarFile().getManifest();
        return manifest == null ? null : manifest.getMainAttributes();
    }
}

