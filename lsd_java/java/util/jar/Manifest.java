/*
 * Decompiled with CFR 0.152.
 */
package java.util.jar;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.InitManifest;
import java.util.jar.Manifest$WriteManifest;

public class Manifest
implements Cloneable {
    private Attributes mainAttributes = new Attributes();
    private HashMap entryAttributes = new HashMap();
    private HashMap chunks;

    public Manifest() {
    }

    public Manifest(InputStream inputStream) {
        this.read(inputStream);
    }

    Manifest(InputStream inputStream, boolean bl) {
        if (bl) {
            this.chunks = new HashMap();
        }
        this.read(inputStream);
    }

    public void clear() {
        this.entryAttributes.clear();
        this.mainAttributes.clear();
    }

    public Attributes getAttributes(String string) {
        return (Attributes)this.getEntries().get(string);
    }

    public Map getEntries() {
        return this.entryAttributes;
    }

    public Attributes getMainAttributes() {
        return this.mainAttributes;
    }

    public Manifest(Manifest manifest) {
        this.mainAttributes = (Attributes)manifest.mainAttributes.clone();
        this.entryAttributes = (HashMap)manifest.entryAttributes.clone();
    }

    public Object clone() {
        return new Manifest(this);
    }

    public void write(OutputStream outputStream) {
        new Manifest$WriteManifest().write(this, outputStream);
    }

    public void read(InputStream inputStream) {
        new InitManifest(inputStream, this.mainAttributes, this.entryAttributes, this.chunks, null);
    }

    public int hashCode() {
        return this.mainAttributes.hashCode() ^ this.entryAttributes.hashCode();
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object.getClass() != super.getClass()) {
            return false;
        }
        if (!this.mainAttributes.equals(((Manifest)object).mainAttributes)) {
            return false;
        }
        return this.entryAttributes.equals(((Manifest)object).entryAttributes);
    }

    byte[] getChunk(String string) {
        return (byte[])this.chunks.get(string);
    }

    void removeChunks() {
        this.chunks = null;
    }

    static /* synthetic */ Attributes access$0(Manifest manifest) {
        return manifest.mainAttributes;
    }

    static /* synthetic */ HashMap access$1(Manifest manifest) {
        return manifest.entryAttributes;
    }
}

