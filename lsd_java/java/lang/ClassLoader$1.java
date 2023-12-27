/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

import java.security.PrivilegedAction;
import java.security.ProtectionDomain;

final class ClassLoader$1
implements PrivilegedAction {
    final /* synthetic */ ClassLoader this$0;
    private final /* synthetic */ String val$className;
    private final /* synthetic */ byte[] val$classRep;
    private final /* synthetic */ int val$offset;
    private final /* synthetic */ int val$length;
    private final /* synthetic */ ProtectionDomain val$pd;

    ClassLoader$1(ClassLoader classLoader, String string, byte[] byArray, int n, int n2, ProtectionDomain protectionDomain) {
        this.this$0 = classLoader;
        this.val$className = string;
        this.val$classRep = byArray;
        this.val$offset = n;
        this.val$length = n2;
        this.val$pd = protectionDomain;
    }

    @Override
    public Object run() {
        return ClassLoader.access$0(this.this$0, this.val$className, this.val$classRep, this.val$offset, this.val$length, this.val$pd);
    }
}

