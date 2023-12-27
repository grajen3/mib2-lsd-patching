/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import com.ibm.oti.util.PriviAction;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.security.AccessController;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.MapEntry;

public class Properties
extends Hashtable {
    private static final long serialVersionUID;
    protected Properties defaults;
    private static final int NONE;
    private static final int SLASH;
    private static final int UNICODE;
    private static final int CONTINUE;
    private static final int KEY_DONE;
    private static final int IGNORE;
    private static String lineSeparator;

    public Properties() {
    }

    public Properties(Properties properties) {
        this.defaults = properties;
    }

    private void dumpString(StringBuffer stringBuffer, String string, boolean bl) {
        int n = 0;
        if (!bl && n < string.length() && string.charAt(n) == ' ') {
            stringBuffer.append("\\ ");
            ++n;
        }
        while (n < string.length()) {
            char c2 = string.charAt(n);
            switch (c2) {
                case '\t': {
                    stringBuffer.append("\\t");
                    break;
                }
                case '\n': {
                    stringBuffer.append("\\n");
                    break;
                }
                case '\f': {
                    stringBuffer.append("\\f");
                    break;
                }
                case '\r': {
                    stringBuffer.append("\\r");
                    break;
                }
                default: {
                    if ("\\#!=:".indexOf(c2) >= 0 || bl && c2 == ' ') {
                        stringBuffer.append('\\');
                    }
                    if (c2 >= ' ' && c2 <= '~') {
                        stringBuffer.append(c2);
                        break;
                    }
                    String string2 = Integer.toHexString(c2);
                    stringBuffer.append("\\u");
                    int n2 = 0;
                    while (n2 < 4 - string2.length()) {
                        stringBuffer.append("0");
                        ++n2;
                    }
                    stringBuffer.append(string2);
                }
            }
            ++n;
        }
    }

    public String getProperty(String string) {
        String string2;
        Object object = this.get(string);
        String string3 = string2 = object instanceof String ? (String)object : null;
        if (string2 == null && this.defaults != null) {
            string2 = this.defaults.getProperty(string);
        }
        return string2;
    }

    public String getProperty(String string, String string2) {
        String string3;
        Object object = this.get(string);
        String string4 = string3 = object instanceof String ? (String)object : null;
        if (string3 == null && this.defaults != null) {
            string3 = this.defaults.getProperty(string);
        }
        if (string3 == null) {
            return string2;
        }
        return string3;
    }

    public void list(PrintStream printStream) {
        if (printStream == null) {
            throw new NullPointerException();
        }
        StringBuffer stringBuffer = new StringBuffer(80);
        Enumeration enumeration = this.propertyNames();
        while (enumeration.hasMoreElements()) {
            String string = (String)enumeration.nextElement();
            stringBuffer.append(string);
            stringBuffer.append('=');
            String string2 = (String)this.get(string);
            Properties properties = this.defaults;
            while (string2 == null) {
                string2 = (String)properties.get(string);
                properties = properties.defaults;
            }
            if (string2.length() > 40) {
                stringBuffer.append(string2.substring(0, 37));
                stringBuffer.append("...");
            } else {
                stringBuffer.append(string2);
            }
            printStream.println(stringBuffer.toString());
            stringBuffer.setLength(0);
        }
    }

    public void list(PrintWriter printWriter) {
        if (printWriter == null) {
            throw new NullPointerException();
        }
        StringBuffer stringBuffer = new StringBuffer(80);
        Enumeration enumeration = this.propertyNames();
        while (enumeration.hasMoreElements()) {
            String string = (String)enumeration.nextElement();
            stringBuffer.append(string);
            stringBuffer.append('=');
            String string2 = (String)this.get(string);
            Properties properties = this.defaults;
            while (string2 == null) {
                string2 = (String)properties.get(string);
                properties = properties.defaults;
            }
            if (string2.length() > 40) {
                stringBuffer.append(string2.substring(0, 37));
                stringBuffer.append("...");
            } else {
                stringBuffer.append(string2);
            }
            printWriter.println(stringBuffer.toString());
            stringBuffer.setLength(0);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public synchronized void load(InputStream inputStream) {
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        char[] cArray = new char[40];
        int n4 = 0;
        int n5 = -1;
        boolean bl = true;
        byte[] byArray = new byte[256];
        int n6 = 0;
        int n7 = 0;
        block17: while (true) {
            Object object;
            block34: {
                block36: {
                    block37: {
                        block35: {
                            if (n7 != n6) break block34;
                            n6 = inputStream.read(byArray);
                            if (n6 != -1) break block35;
                            if (n5 < 0) break block36;
                            break block37;
                        }
                        n7 = 0;
                        break block34;
                    }
                    String string = new String(cArray, 0, n4);
                    this.put(string.substring(0, n5), string.substring(n5));
                }
                return;
            }
            int n8 = byArray[n7++] & 0xFF;
            if (n4 == cArray.length) {
                object = new char[cArray.length * 2];
                System.arraycopy((Object)cArray, 0, object, 0, n4);
                cArray = object;
            }
            if (n == 2) {
                int n9 = Character.digit((char)n8, 16);
                if (n9 >= 0) {
                    n2 = (n2 << 4) + n9;
                    if (++n3 < 4) continue;
                }
                n = 0;
                cArray[n4++] = (char)n2;
                if (n8 != 10) continue;
            }
            if (n == 1) {
                n = 0;
                switch (n8) {
                    case 13: {
                        n = 3;
                        continue block17;
                    }
                    case 10: {
                        n = 5;
                        continue block17;
                    }
                    case 98: {
                        n8 = 8;
                        break;
                    }
                    case 102: {
                        n8 = 12;
                        break;
                    }
                    case 110: {
                        n8 = 10;
                        break;
                    }
                    case 114: {
                        n8 = 13;
                        break;
                    }
                    case 116: {
                        n8 = 9;
                        break;
                    }
                    case 117: {
                        n = 2;
                        n3 = 0;
                        n2 = 0;
                        continue block17;
                    }
                }
            } else {
                switch (n8) {
                    case 33: 
                    case 35: {
                        if (!bl) break;
                        do {
                            if (n7 != n6) continue;
                            n6 = inputStream.read(byArray);
                            if (n6 == -1) {
                                n7 = -1;
                                continue block17;
                            }
                            n7 = 0;
                        } while ((n8 = (int)((char)byArray[n7++])) != 13 && n8 != 10);
                        continue block17;
                    }
                    case 10: {
                        if (n == 3) {
                            n = 5;
                            continue block17;
                        }
                    }
                    case 13: {
                        n = 0;
                        bl = true;
                        if (n4 > 0) {
                            if (n5 == -1) {
                                n5 = n4;
                            }
                            object = new String(cArray, 0, n4);
                            this.put(((String)object).substring(0, n5), ((String)object).substring(n5));
                        }
                        n5 = -1;
                        n4 = 0;
                        continue block17;
                    }
                    case 92: {
                        if (n == 4) {
                            n5 = n4;
                        }
                        n = 1;
                        continue block17;
                    }
                    case 58: 
                    case 61: {
                        if (n5 != -1) break;
                        n = 0;
                        n5 = n4;
                        continue block17;
                    }
                }
                if (Character.isWhitespace((char)n8)) {
                    if (n == 3) {
                        n = 5;
                    }
                    if (n4 == 0 || n4 == n5 || n == 5) continue;
                    if (n5 == -1) {
                        n = 4;
                        continue;
                    }
                }
                if (n == 5 || n == 3) {
                    n = 0;
                }
            }
            bl = false;
            if (n == 4) {
                n5 = n4;
                n = 0;
            }
            cArray[n4++] = n8;
        }
    }

    public Enumeration propertyNames() {
        if (this.defaults == null) {
            return this.keys();
        }
        Hashtable hashtable = new Hashtable(this.defaults.size() + this.size());
        Enumeration enumeration = this.defaults.propertyNames();
        while (enumeration.hasMoreElements()) {
            hashtable.put(enumeration.nextElement(), hashtable);
        }
        enumeration = this.keys();
        while (enumeration.hasMoreElements()) {
            hashtable.put(enumeration.nextElement(), hashtable);
        }
        return hashtable.keys();
    }

    public void save(OutputStream outputStream, String string) {
        try {
            this.store(outputStream, string);
        }
        catch (IOException iOException) {}
    }

    public synchronized Object setProperty(String string, String string2) {
        return this.put(string, string2);
    }

    public synchronized void store(OutputStream outputStream, String string) {
        if (lineSeparator == null) {
            lineSeparator = (String)AccessController.doPrivileged(new PriviAction("line.separator"));
        }
        StringBuffer stringBuffer = new StringBuffer(200);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "ISO8859_1");
        if (string != null) {
            outputStreamWriter.write(new StringBuffer("#").append(string).append(lineSeparator).toString());
        }
        outputStreamWriter.write(new StringBuffer("#").append(new Date()).append(lineSeparator).toString());
        Iterator iterator = this.entrySet().iterator();
        while (iterator.hasNext()) {
            MapEntry mapEntry = (MapEntry)iterator.next();
            String string2 = (String)mapEntry.getKey();
            this.dumpString(stringBuffer, string2, true);
            stringBuffer.append('=');
            this.dumpString(stringBuffer, (String)mapEntry.getValue(), false);
            stringBuffer.append(lineSeparator);
            outputStreamWriter.write(stringBuffer.toString());
            stringBuffer.setLength(0);
        }
        outputStreamWriter.flush();
    }
}

