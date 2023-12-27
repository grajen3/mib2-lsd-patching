/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

import com.ibm.oti.vm.VM;
import java.io.File;
import java.util.Vector;

public class DeleteOnExit {
    private static Vector deleteList = new Vector();

    static {
        VM.deleteOnExit();
    }

    public static void addFile(String string) {
        deleteList.addElement(string);
    }

    public static void deleteOnExit() {
        int n = deleteList.size() - 1;
        while (n >= 0) {
            String string = (String)deleteList.elementAt(n);
            new File(string).delete();
            --n;
        }
    }
}

