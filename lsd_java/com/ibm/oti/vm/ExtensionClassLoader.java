/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.vm;

import com.ibm.oti.util.Msg;
import com.ibm.oti.vm.AppClassLoader;
import com.ibm.oti.vm.VM;
import java.io.File;
import java.util.Hashtable;

public final class ExtensionClassLoader
extends AppClassLoader {
    private static ExtensionClassLoader singleton;
    private static Hashtable protectionDomainCache;

    static {
        protectionDomainCache = new Hashtable(10);
    }

    private ExtensionClassLoader() {
        super(false);
        int n;
        CharSequence charSequence;
        String[] stringArray;
        String[][] stringArray2;
        int n2 = 0;
        String string = System.getProperty("java.ext.dirs");
        if (string == null) {
            stringArray2 = new String[1][];
            stringArray = new String[1];
            charSequence = System.getProperty("java.home", "");
            File file = new File((String)charSequence, "lib/ext");
            stringArray2[0] = file.list();
            if (stringArray2[0] != null) {
                n2 = stringArray2[0].length;
                stringArray[0] = new StringBuffer(String.valueOf(file.getPath())).append(File.separatorChar).toString();
            }
        } else {
            int n3;
            int n4 = 0;
            int n5 = 0;
            n = string.length();
            while (n4 < n) {
                n3 = string.indexOf(File.pathSeparatorChar, n4);
                if (n3 == -1) {
                    n3 = n;
                }
                if (n3 - n4 > 0) {
                    ++n5;
                }
                n4 = n3 + 1;
            }
            stringArray2 = new String[n5][];
            stringArray = new String[n5];
            n5 = 0;
            n4 = 0;
            while (n4 < n) {
                n3 = string.indexOf(File.pathSeparatorChar, n4);
                if (n3 == -1) {
                    n3 = n;
                }
                if (n3 - n4 > 0) {
                    String string2 = string.substring(n4, n3);
                    File file = new File(string2);
                    stringArray2[n5] = file.list();
                    if (stringArray2[n5] != null) {
                        n2 += stringArray2[n5].length;
                        stringArray[n5++] = new StringBuffer(String.valueOf(file.getPath())).append(File.separatorChar).toString();
                    }
                }
                n4 = n3 + 1;
            }
        }
        if (stringArray2 != null) {
            this.types = new int[n2];
            this.parsedPath = new String[n2];
            this.cache = this.parsedPath;
            charSequence = new StringBuffer();
            int n6 = 0;
            while (n6 < stringArray2.length) {
                if (stringArray2[n6] != null) {
                    n = 0;
                    while (n < stringArray2[n6].length) {
                        ((StringBuffer)charSequence).append(stringArray[n6]);
                        ((StringBuffer)charSequence).append(stringArray2[n6][n]);
                        this.parsedPath[n] = new StringBuffer(String.valueOf(stringArray[n6])).append(stringArray2[n6][n]).toString();
                        if (n != stringArray2.length - 1) {
                            ((StringBuffer)charSequence).append(';');
                        }
                        ++n;
                    }
                }
                ++n6;
            }
            VM.setClassPathImpl((ClassLoader)this, ((StringBuffer)charSequence).toString());
        }
    }

    public static synchronized ClassLoader singleton() {
        if (singleton != null) {
            throw new InstantiationError(Msg.getString("K0085"));
        }
        singleton = new ExtensionClassLoader();
        return singleton;
    }

    @Override
    Hashtable getProtectionDomainCache() {
        return protectionDomainCache;
    }

    @Override
    boolean addExitPermission() {
        return false;
    }
}

