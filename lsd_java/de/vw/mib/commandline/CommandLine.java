/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.commandline;

public interface CommandLine {
    public static final int SLOT_WITH_SENDER_NAME;
    public static final int MAX_COMMANDS;
    public static final int NO_INT;
    public static final byte DEFAULT;
    public static final byte RED;
    public static final byte GREEN;
    public static final byte YELLOW;
    public static final byte BLUE;
    public static final byte MAGENTA;
    public static final byte CYAN;

    default public void addCommand(int n, String string) {
    }

    default public void color(byte by) {
    }

    default public void append(String string, byte by) {
    }

    default public void append(String string) {
    }

    default public void appendln(String string, byte by) {
    }

    default public void appendln(String string) {
    }

    default public void flush() {
    }

    default public void headline(String string) {
    }

    default public boolean isOff(String string) {
    }

    default public boolean isOn(String string) {
    }

    default public int parseInt(String string) {
    }
}

