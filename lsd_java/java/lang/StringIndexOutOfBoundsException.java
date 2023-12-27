/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

import com.ibm.oti.util.Msg;

public class StringIndexOutOfBoundsException
extends IndexOutOfBoundsException {
    public StringIndexOutOfBoundsException() {
    }

    public StringIndexOutOfBoundsException(int n) {
        super(Msg.getString("K0055", n));
    }

    public StringIndexOutOfBoundsException(String string) {
        super(string);
    }
}

