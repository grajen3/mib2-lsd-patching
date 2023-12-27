/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

import com.ibm.oti.util.Msg;

public class ClassCastException
extends RuntimeException {
    private static final long serialVersionUID;

    public ClassCastException() {
    }

    public ClassCastException(String string) {
        super(string);
    }

    ClassCastException(Class clazz, Class clazz2) {
        super(Msg.getString("K0340", clazz.getName(), clazz2.getName()));
    }
}

