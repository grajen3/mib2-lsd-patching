/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

import com.ibm.oti.util.ExtendedResourceBundle;
import java.util.Enumeration;

final class ExtendedResourceBundle$1
implements Enumeration {
    Enumeration local;
    Enumeration pEnum;
    Object nextElement;
    final /* synthetic */ ExtendedResourceBundle this$0;

    ExtendedResourceBundle$1(ExtendedResourceBundle extendedResourceBundle) {
        this.this$0 = extendedResourceBundle;
        this.local = ExtendedResourceBundle.access$0(extendedResourceBundle).keys();
        this.pEnum = ExtendedResourceBundle.access$1(extendedResourceBundle).getKeys();
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
            if (ExtendedResourceBundle.access$0(this.this$0).containsKey(var1_1)) continue;
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

