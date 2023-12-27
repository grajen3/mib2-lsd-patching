/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.ObjectStreamException;

public class InvalidClassException
extends ObjectStreamException {
    private static final long serialVersionUID;
    public String classname;

    public InvalidClassException(String string) {
        super(string);
    }

    public InvalidClassException(String string, String string2) {
        super(string2);
        this.classname = string;
    }

    @Override
    public String getMessage() {
        String string = super.getMessage();
        if (this.classname != null) {
            string = new StringBuffer(String.valueOf(this.classname)).append(';').append(' ').append(string).toString();
        }
        return string;
    }
}

