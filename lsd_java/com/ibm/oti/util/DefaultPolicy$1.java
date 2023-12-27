/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

import com.ibm.oti.util.DefaultPolicy;
import java.security.CodeSource;
import java.security.PrivilegedAction;

final class DefaultPolicy$1
implements PrivilegedAction {
    final /* synthetic */ DefaultPolicy this$0;
    private final /* synthetic */ CodeSource val$cs;

    DefaultPolicy$1(DefaultPolicy defaultPolicy, CodeSource codeSource) {
        this.this$0 = defaultPolicy;
        this.val$cs = codeSource;
    }

    @Override
    public Object run() {
        return this.this$0.getPermissionsImpl(this.val$cs);
    }
}

