/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.buffer;

import de.esolutions.fw.util.transport.IReadable;
import de.esolutions.fw.util.transport.exception.TransportException;

public class ReadableDumper {
    public static void dump(IReadable iReadable, int n) {
        System.out.println(new StringBuffer().append("Buffer: size=").append(n).toString());
        try {
            byte[] byArray = iReadable.getData();
            int n2 = 0;
            while (n2 < n) {
                int n3 = n - n2;
                if (n3 > 16) {
                    n3 = 16;
                }
                String string = new StringBuffer().append("00000000").append(Integer.toHexString(n2)).toString();
                int n4 = string.length();
                string = new StringBuffer().append(string.substring(n4 - 8, n4)).append(": ").toString();
                StringBuffer stringBuffer = new StringBuffer(string);
                for (int i2 = 0; i2 < n3; ++i2) {
                    String string2 = new StringBuffer().append("00").append(Integer.toHexString(byArray[n2])).toString();
                    n4 = string2.length();
                    string2 = string2.substring(n4 - 2, n4);
                    stringBuffer.append(new StringBuffer().append(string2).append(" ").toString());
                    ++n2;
                }
                string = stringBuffer.toString();
                System.out.println(string);
            }
        }
        catch (TransportException transportException) {
            // empty catch block
        }
    }
}

