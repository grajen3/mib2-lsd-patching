/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.vm;

import com.ibm.oti.vm.AbstractClassLoader;
import java.security.PrivilegedAction;

final class AbstractClassLoader$3
implements PrivilegedAction {
    final /* synthetic */ AbstractClassLoader this$0;
    private final /* synthetic */ int val$cacheIndex;

    AbstractClassLoader$3(AbstractClassLoader abstractClassLoader, int n) {
        this.this$0 = abstractClassLoader;
        this.val$cacheIndex = n;
    }

    @Override
    public Object run() {
        this.this$0.fillCache(this.val$cacheIndex);
        return null;
    }
}

