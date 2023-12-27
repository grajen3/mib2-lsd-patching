/*
 * Decompiled with CFR 0.152.
 */
package com.sun.gluegen.runtime;

public class CPU {
    private static boolean is32Bit;

    public static boolean is32Bit() {
        return is32Bit;
    }

    static {
        String string = System.getProperty("os.name").toLowerCase();
        String string2 = System.getProperty("os.arch").toLowerCase();
        if (string.startsWith("windows") && string2.equals("x86") || string.startsWith("linux") && string2.equals("i386") || string.startsWith("linux") && string2.equals("x86") || string.startsWith("mac os") && string2.equals("ppc") || string.startsWith("mac os") && string2.equals("i386") || string.startsWith("sunos") && string2.equals("sparc") || string.startsWith("sunos") && string2.equals("x86") || string.startsWith("freebsd") && string2.equals("i386") || string.startsWith("hp-ux") && string2.equals("pa_risc2.0") || string.startsWith("qnx") && string2.equals("arm") || string.startsWith("qnx") && string2.equals("x86")) {
            is32Bit = true;
        } else if (!(string.startsWith("windows") && string2.equals("amd64") || string.startsWith("linux") && string2.equals("amd64") || string.startsWith("linux") && string2.equals("x86_64") || string.startsWith("linux") && string2.equals("ia64") || string.startsWith("mac os") && string2.equals("x86_64") || string.startsWith("sunos") && string2.equals("sparcv9") || string.startsWith("sunos") && string2.equals("amd64"))) {
            throw new RuntimeException(new StringBuffer().append("Please port CPU detection (32/64 bit) to your platform (").append(string).append("/").append(string2).append(")").toString());
        }
    }
}

