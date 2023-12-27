/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcard.c;

import de.eso.a.b.f;
import java.io.File;

public class a
implements f {
    @Override
    public void a(String string) {
        System.out.println(new StringBuffer().append("propertyName: ").append(string).toString());
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
    public void a(String string, int n) {
        System.out.println(new StringBuffer().append("value ").append(n).append(": ").append(string).toString());
    }

    @Override
    public void d() {
        System.out.println("END of VCARD file");
    }

    public void b(byte[] byArray, int n) {
        int n2 = 0;
        if (byArray != null) {
            n2 = byArray.length;
        }
        System.out.println(new StringBuffer().append("binary value ").append(n).append(": ").append(n2).append(" bytes.").toString());
    }

    @Override
    public void e() {
        System.out.println("---------------------------endline---------------------------");
    }

    @Override
    public void a(File file, int n) {
        System.out.println(new StringBuffer().append("Binary content in file: ").append(file).toString());
    }

    @Override
    public void a(byte[] byArray, int n) {
        System.out.println("Byte[] content");
    }

    @Override
    public void d(String string) {
        System.out.println(new StringBuffer().append("propertyGroup: ").append(string).toString());
    }

    @Override
    public boolean g() {
        return false;
    }
}

