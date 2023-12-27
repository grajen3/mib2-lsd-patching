/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Enumeration;
import java.util.ListResourceBundle;

final class ListResourceBundle$1
implements Enumeration {
    Enumeration local;
    Enumeration pEnum;
    Object nextElement;
    final /* synthetic */ ListResourceBundle this$0;

    ListResourceBundle$1(ListResourceBundle listResourceBundle) {
        this.this$0 = listResourceBundle;
        this.local = listResourceBundle.table.keys();
        this.pEnum = listResourceBundle.parent.getKeys();
        this.nextElement = null;
    }

    /*
     * Unable to fully structure code
     */
    private boolean findNext() {
        if (this.nextElement == null) ** GOTO lbl7
        return true;
lbl-1000:
        // 1 sources

        {
            var1_1 = (String)this.pEnum.nextElement();
            if (this.this$0.table.containsKey(var1_1)) continue;
            this.nextElement = var1_1;
            return true;
lbl7:
            // 2 sources

            ** while (this.pEnum.hasMoreElements())
        }
lbl8:
        // 1 sources

        return false;
    }

    @Override
    public boolean hasMoreElements() {
        if (this.local.hasMoreElements()) {
            return true;
        }
        return this.findNext();
    }

    @Override
    public Object nextElement() {
        if (this.local.hasMoreElements()) {
            return this.local.nextElement();
        }
        if (this.findNext()) {
            Object object = this.nextElement;
            this.nextElement = null;
            return object;
        }
        return this.pEnum.nextElement();
    }
}

