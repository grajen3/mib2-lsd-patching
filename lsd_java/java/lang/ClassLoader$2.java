/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

import java.net.URL;
import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.util.Vector;

final class ClassLoader$2
implements Enumeration {
    int index;
    final /* synthetic */ ClassLoader this$0;
    private final /* synthetic */ Vector val$resources;

    ClassLoader$2(ClassLoader classLoader, Vector vector) {
        this.this$0 = classLoader;
        this.val$resources = vector;
        this.index = vector.size() - 1;
    }

    @Override
    public boolean hasMoreElements() {
        while (this.index >= 0) {
            if (((Enumeration)this.val$resources.elementAt(this.index)).hasMoreElements()) {
                return true;
            }
            --this.index;
        }
        return false;
    }

    @Override
    public Object nextElement() {
        while (this.index >= 0) {
            Enumeration enumeration = (Enumeration)this.val$resources.elementAt(this.index);
            if (enumeration.hasMoreElements()) {
                return (URL)enumeration.nextElement();
            }
            --this.index;
        }
        throw new NoSuchElementException();
    }
}

