/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

public class Error
extends Throwable {
    private static final long serialVersionUID;

    public Error() {
    }

    public Error(String string) {
        super(string);
    }

    public Error(String string, Throwable throwable) {
        super(string, throwable);
    }

    public Error(Throwable throwable) {
        super(throwable);
    }
}

