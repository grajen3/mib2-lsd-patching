/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

import com.ibm.oti.util.Msg;

public class ArrayIndexOutOfBoundsException
extends IndexOutOfBoundsException {
    public ArrayIndexOutOfBoundsException() {
    }

    public ArrayIndexOutOfBoundsException(int n) {
        super(Msg.getString("K0052", n));
    }

    public ArrayIndexOutOfBoundsException(String string) {
        super(string);
    }
}

