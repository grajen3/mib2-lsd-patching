/*
 * Decompiled with CFR 0.152.
 */
package java.util.jar;

import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

class JarFile$1$JarFileEnumerator
implements Enumeration {
    Enumeration ze;
    JarFile jf;
    final /* synthetic */ JarFile this$0;

    JarFile$1$JarFileEnumerator(JarFile jarFile, Enumeration enumeration, JarFile jarFile2) {
        this.this$0 = jarFile;
        this.ze = enumeration;
        this.jf = jarFile2;
    }

    @Override
    public boolean hasMoreElements() {
        return this.ze.hasMoreElements();
    }

    @Override
    public Object nextElement() {
        JarEntry jarEntry = new JarEntry((ZipEntry)this.ze.nextElement());
        jarEntry.parentJar = this.jf;
        if (this.this$0.verifier != null) {
            jarEntry.certificates = this.this$0.verifier.getCertificates(jarEntry.getName());
        }
        return jarEntry;
    }
}

