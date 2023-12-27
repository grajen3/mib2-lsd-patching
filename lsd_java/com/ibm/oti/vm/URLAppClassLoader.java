/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.vm;

import com.ibm.oti.net.www.protocol.jxe.Handler;
import com.ibm.oti.vm.Jxe;
import com.ibm.oti.vm.JxeException;
import com.ibm.oti.vm.URLSystemClassLoader;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class URLAppClassLoader
extends URLSystemClassLoader {
    private static URL[] classPath = URLAppClassLoader.getClassPath();

    public URLAppClassLoader() {
        this((ClassLoader)null);
    }

    public URLAppClassLoader(ClassLoader classLoader) {
        super(classPath, classLoader);
    }

    URLAppClassLoader(URL[] uRLArray, ClassLoader classLoader) {
        super(uRLArray, classLoader);
    }

    private static URL[] getClassPath() {
        String string = System.getProperty("java.class.path", ".");
        int n = 0;
        int n2 = 0;
        int n3 = string.length();
        while (n < n3) {
            int n4 = string.indexOf(File.pathSeparatorChar, n);
            if (n4 == -1) {
                n4 = n3;
            }
            if (n4 - n > 0) {
                ++n2;
            }
            n = n4 + 1;
        }
        URL[] uRLArray = new URL[n2];
        n2 = 0;
        n = 0;
        while (n < n3) {
            int n5 = string.indexOf(File.pathSeparatorChar, n);
            if (n5 == -1) {
                n5 = n3;
            }
            if (n5 - n > 0) {
                String string2 = string.substring(n, n5);
                try {
                    Object object;
                    boolean bl = string2.startsWith("jxe=");
                    boolean bl2 = string2.startsWith("jxesl=");
                    if (string2.length() > 4 && (string2.substring(string2.length() - 4).equalsIgnoreCase(".jxe") || bl || bl2)) {
                        try {
                            object = null;
                            if (bl) {
                                try {
                                    object = Jxe.fromPointer(Long.parseLong(string2.substring(4), 16));
                                }
                                catch (NumberFormatException numberFormatException) {}
                            } else {
                                object = bl2 ? Jxe.fromSharedLibrary(string2.substring(6)) : Jxe.fromFile(new File(string2));
                            }
                            if (object != null) {
                                uRLArray[n2] = new URL("jxe", ((Jxe)object).getUuid(), -1, "/", new Handler((Jxe)object));
                                ++n2;
                                n = n5 + 1;
                                continue;
                            }
                        }
                        catch (JxeException jxeException) {
                        }
                        catch (UnsatisfiedLinkError unsatisfiedLinkError) {}
                    }
                    object = new File(string2);
                    string2 = ((File)object).getCanonicalPath();
                    if (File.separatorChar != '/') {
                        string2 = string2.replace(File.separatorChar, '/');
                    }
                    if (((File)object).isDirectory() && !string2.endsWith("/")) {
                        string2 = new StringBuffer(string2.length() + 1).append(string2).append('/').toString();
                    }
                    if (!string2.startsWith("/")) {
                        string2 = new StringBuffer(string2.length() + 1).append('/').append(string2).toString();
                    }
                    if (!string2.startsWith("//")) {
                        try {
                            uRLArray[n2++] = new URL("file", "", -1, string2, null);
                        }
                        catch (MalformedURLException malformedURLException) {}
                        n = n5 + 1;
                        continue;
                    }
                    string2 = new StringBuffer(string2.length() + 5).append("file:").append(string2).toString();
                    uRLArray[n2] = new URL(string2);
                    ++n2;
                }
                catch (IOException iOException) {}
            }
            n = n5 + 1;
        }
        if (n2 < uRLArray.length) {
            URL[] uRLArray2 = new URL[n2];
            System.arraycopy((Object)uRLArray, 0, (Object)uRLArray2, 0, n2);
            uRLArray = uRLArray2;
        }
        return uRLArray;
    }

    @Override
    boolean addExitPermission() {
        return true;
    }
}

