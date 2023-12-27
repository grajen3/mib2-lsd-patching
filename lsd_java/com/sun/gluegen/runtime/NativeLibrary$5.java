/*
 * Decompiled with CFR 0.152.
 */
package com.sun.gluegen.runtime;

import com.sun.gluegen.runtime.NativeLibrary;
import java.security.PrivilegedAction;

final class NativeLibrary$5
implements PrivilegedAction {
    private final /* synthetic */ ClassLoader val$loader;
    private final /* synthetic */ String val$libName;

    NativeLibrary$5(ClassLoader classLoader, String string) {
        this.val$loader = classLoader;
        this.val$libName = string;
    }

    @Override
    public Object run() {
        try {
            return NativeLibrary.access$200().invoke(this.val$loader, new Object[]{this.val$libName});
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}

