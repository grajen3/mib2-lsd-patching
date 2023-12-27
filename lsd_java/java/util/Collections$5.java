/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Collections$3;
import java.util.Collections$4;
import java.util.Map$Entry;

final class Collections$5
implements Map$Entry {
    final /* synthetic */ Collections$4 this$3;

    Collections$5(Collections$4 collections$4) {
        this.this$3 = collections$4;
    }

    @Override
    public boolean equals(Object object) {
        return Collections$4.access$0(this.this$3).contains(object);
    }

    @Override
    public Object getKey() {
        return Collections$3.access$0((Collections$3)Collections$4.access$0((Collections$4)this.this$3)).k;
    }

    @Override
    public Object getValue() {
        return Collections$3.access$0((Collections$3)Collections$4.access$0((Collections$4)this.this$3)).v;
    }

    @Override
    public int hashCode() {
        return (Collections$3.access$0((Collections$3)Collections$4.access$0((Collections$4)this.this$3)).k == null ? 0 : Collections$3.access$0((Collections$3)Collections$4.access$0((Collections$4)this.this$3)).k.hashCode()) ^ (Collections$3.access$0((Collections$3)Collections$4.access$0((Collections$4)this.this$3)).v == null ? 0 : Collections$3.access$0((Collections$3)Collections$4.access$0((Collections$4)this.this$3)).v.hashCode());
    }

    @Override
    public Object setValue(Object object) {
        throw new UnsupportedOperationException();
    }
}

