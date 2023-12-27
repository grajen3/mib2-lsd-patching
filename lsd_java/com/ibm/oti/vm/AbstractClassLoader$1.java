/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.vm;

import com.ibm.oti.vm.AbstractClassLoader;
import java.net.URL;
import java.security.PrivilegedAction;

final class AbstractClassLoader$1
implements PrivilegedAction {
    final /* synthetic */ AbstractClassLoader this$0;
    private final /* synthetic */ String val$res;

    AbstractClassLoader$1(AbstractClassLoader abstractClassLoader, String string) {
        this.this$0 = abstractClassLoader;
        this.val$res = string;
    }

    @Override
    public Object run() {
        int n = 0;
        while (n < this.this$0.cache.length) {
            URL uRL = AbstractClassLoader.access$0(this.this$0, n, this.val$res);
            if (uRL != null) {
                return uRL;
            }
            ++n;
        }
        return null;
    }
}

