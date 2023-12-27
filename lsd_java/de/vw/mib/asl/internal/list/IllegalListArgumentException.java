/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list;

import de.vw.mib.asl.internal.list.IllegalListAccessException;

public class IllegalListArgumentException
extends IllegalListAccessException {
    private static final long serialVersionUID;

    public IllegalListArgumentException(String string) {
        super(string);
    }

    public static IllegalListArgumentException invalidListId(String string, int n) {
        return new IllegalListArgumentException(new StringBuffer().append("Invalid list id for device ").append(string).append(": ").append(n).toString());
    }

    public static IllegalListArgumentException invalidListTypeAndId(String string, String string2, int n) {
        return new IllegalListArgumentException(new StringBuffer().append("Invalid list id for type ").append(string2).append(" and device ").append(string).append(": ").append(n).toString());
    }

    public static IllegalListArgumentException invalidDeprecatedListId(String string, int n) {
        return new IllegalListArgumentException(new StringBuffer().append("Invalid deprecated list id for device ").append(string).append(": ").append(n).toString());
    }
}

