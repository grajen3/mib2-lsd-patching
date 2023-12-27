/*
 * Decompiled with CFR 0.152.
 */
package de.eso.a.d;

import de.esolutions.fw.util.tracing.TraceChannel;
import de.esolutions.fw.util.tracing.TraceClient;

public class b {
    private static TraceChannel a;

    public static void a(String string) {
        if (a == null) {
            return;
        }
        try {
            a.log((short)3, string);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static void b(String string) {
        if (a == null) {
            return;
        }
        try {
            a.log((short)1, string);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static void c(String string) {
        if (a == null) {
            return;
        }
        try {
            a.log((short)2, string);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static void d(String string) {
        if (a == null) {
            return;
        }
        try {
            a.log((short)4, string);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static void a(short s) {
        if (a == null) {
            return;
        }
        a.setFilterLevel(s);
    }

    static {
        TraceClient.init("VCardParserService");
        a = TraceClient.createTraceChannel("organizer.VCardParser");
        if (a == null) {
            System.err.println("FATAL: TraceChannel for VCardParser could not be created!!!");
        }
    }
}

