/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons;

import de.esolutions.fw.util.commons.Formatter$Accessor;
import java.util.List;

final class Formatter$7
implements Formatter$Accessor {
    private final /* synthetic */ List val$listArg;

    Formatter$7(List list) {
        this.val$listArg = list;
    }

    @Override
    public boolean isNull() {
        return this.val$listArg == null;
    }

    @Override
    public int getLength() {
        return this.val$listArg.size();
    }

    @Override
    public String getValueAt(int n) {
        Object object = this.val$listArg.get(n);
        return object == null ? "null" : (object instanceof String ? new StringBuffer().append("\"").append(object).append("\"").toString() : object.toString());
    }
}

