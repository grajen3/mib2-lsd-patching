/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcalendar.d;

import de.eso.a.b.f;
import java.io.File;

public class a
implements f {
    @Override
    public void a(File file, int n) {
        System.out.println(new StringBuffer().append("Binary content in file: ").append(file).toString());
    }

    @Override
    public void a(byte[] byArray, int n) {
        System.out.println("Byte[] content");
    }

    @Override
    public void d() {
        System.out.println("END of ICalendar file");
    }

    @Override
    public void e() {
        System.out.println("---------------------------endline---------------------------");
    }

    @Override
    public void b(String string) {
        System.out.println(new StringBuffer().append("paramKey: ").append(string).toString());
    }

    @Override
    public void c(String string) {
        System.out.println(new StringBuffer().append("paramVal: ").append(string).toString());
    }

    @Override
    public void d(String string) {
        System.out.println(new StringBuffer().append("propertyGroup: ").append(string).toString());
    }

    @Override
    public void a(String string) {
        System.out.println(new StringBuffer().append("propertyName: ").append(string).toString());
    }

    @Override
    public void a(String string, int n) {
        System.out.println(new StringBuffer().append("value ").append(n).append(": ").append(string).toString());
    }

    @Override
    public boolean g() {
        return false;
    }
}

