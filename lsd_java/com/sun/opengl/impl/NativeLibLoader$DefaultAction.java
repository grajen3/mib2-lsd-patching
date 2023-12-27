/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl;

import com.sun.opengl.impl.NativeLibLoader;
import com.sun.opengl.impl.NativeLibLoader$1;
import com.sun.opengl.impl.NativeLibLoader$LoaderAction;

class NativeLibLoader$DefaultAction
implements NativeLibLoader$LoaderAction {
    private NativeLibLoader$DefaultAction() {
    }

    @Override
    public void loadLibrary(String string, String[] stringArray, boolean bl, boolean bl2) {
        if (bl) {
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                try {
                    NativeLibLoader.access$000(stringArray[i2]);
                    continue;
                }
                catch (UnsatisfiedLinkError unsatisfiedLinkError) {
                    if (bl2 || unsatisfiedLinkError.getMessage().indexOf("already loaded") >= 0) continue;
                    throw unsatisfiedLinkError;
                }
            }
        }
        NativeLibLoader.access$000(string);
    }

    /* synthetic */ NativeLibLoader$DefaultAction(NativeLibLoader$1 nativeLibLoader$1) {
        this();
    }
}

