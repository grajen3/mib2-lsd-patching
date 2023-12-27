/*
 * Decompiled with CFR 0.152.
 */
package java.nio;

public class InvalidDirectBufferException
extends RuntimeException {
    private static final long serialVersionUID;

    public InvalidDirectBufferException() {
        super("The Buffer is disposed");
    }
}

