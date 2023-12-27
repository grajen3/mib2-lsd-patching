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

public final class URLExtensionClassLoader
extends URLSystemClassLoader {
    private static final URL[] classPath = URLExtensionClassLoader.getClassPath();

    public URLExtensionClassLoader() {
        this((ClassLoader)null);
    }

    URLExtensionClassLoader(ClassLoader classLoader) {
        super(classPath, classLoader);
    }

    static URL[] getClassPath() {
        URL[] uRLArray;
        int n = 0;
        String string = System.getProperty("java.ext.dirs");
        if (string == null) {
            String string2 = System.getProperty("java.home", "");
            File file = new File(string2, "lib/ext");
            String string3 = System.getProperty("com.ibm.oti.configuration.dir");
            uRLArray = new File(string2, new StringBuffer("lib/").append(string3).append("/opt-ext").toString());
            string = new StringBuffer(String.valueOf(file.getPath())).append(File.pathSeparatorChar).append(uRLArray.getPath()).toString();
            System.setProperty("java.ext.dirs", string);
        }
        int n2 = 0;
        int n3 = 0;
        int n4 = string.length();
        while (n2 < n4) {
            int n5 = string.indexOf(File.pathSeparatorChar, n2);
            if (n5 == -1) {
                n5 = n4;
            }
            if (n5 - n2 > 0) {
                ++n3;
            }
            n2 = n5 + 1;
        }
        String[][] stringArray = new String[n3][];
        String[] stringArray2 = new String[n3];
        n3 = 0;
        n2 = 0;
        while (n2 < n4) {
            int n6 = string.indexOf(File.pathSeparatorChar, n2);
            if (n6 == -1) {
                n6 = n4;
            }
            if (n6 - n2 > 0) {
                String string4 = string.substring(n2, n6);
                File file = new File(string4);
                stringArray[n3] = file.list();
                if (stringArray[n3] != null) {
                    n += stringArray[n3].length;
                    stringArray2[n3++] = new StringBuffer(String.valueOf(file.getPath())).append(File.separatorChar).toString();
                }
            }
            n2 = n6 + 1;
        }
        uRLArray = new URL[n];
        if (stringArray != null) {
            int n7 = 0;
            int n8 = 0;
            while (n8 < stringArray.length) {
                if (stringArray[n8] != null) {
                    int n9 = 0;
                    while (n9 < stringArray[n8].length) {
                        block22: {
                            boolean bl;
                            String string5;
                            String string6;
                            block21: {
                                string6 = stringArray[n8][n9];
                                string5 = null;
                                bl = false;
                                if (string6.length() > 4 && string6.substring(string6.length() - 4).equalsIgnoreCase(".jxe")) {
                                    try {
                                        Jxe jxe = Jxe.fromFile(new File(new StringBuffer(String.valueOf(stringArray2[n8])).append(string6).toString()));
                                        if (jxe == null) break block21;
                                        uRLArray[n7] = new URL("jxe", jxe.getUuid(), -1, "/", new Handler(jxe));
                                        ++n7;
                                        break block22;
                                    }
                                    catch (IOException iOException) {
                                    }
                                    catch (JxeException jxeException) {
                                    }
                                    catch (UnsatisfiedLinkError unsatisfiedLinkError) {}
                                }
                            }
                            if (!bl) {
                                string5 = new StringBuffer("file:").append(stringArray2[n8]).append(string6).toString();
                            }
                            try {
                                uRLArray[n7] = new URL(string5);
                                ++n7;
                            }
                            catch (MalformedURLException malformedURLException) {}
                        }
                        ++n9;
                    }
                }
                ++n8;
            }
            if (n7 < uRLArray.length) {
                URL[] uRLArray2 = new URL[n7];
                System.arraycopy((Object)uRLArray, 0, (Object)uRLArray2, 0, n7);
                uRLArray = uRLArray2;
            }
        }
        return uRLArray;
    }

    @Override
    boolean addExitPermission() {
        return false;
    }
}

