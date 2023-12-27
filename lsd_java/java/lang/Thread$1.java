/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

import com.ibm.oti.util.IdentityHashtable$Iterator;

class Thread$1
implements IdentityHashtable$Iterator {
    final /* synthetic */ Thread this$0;

    Thread$1(Thread thread) {
        this.this$0 = thread;
    }

    @Override
    public void iterate(Object object, Object object2) {
        if (object instanceof InheritableThreadLocal) {
            Thread.access$0(this.this$0).put(object, ((InheritableThreadLocal)object).childValue(object2));
        }
    }
}

