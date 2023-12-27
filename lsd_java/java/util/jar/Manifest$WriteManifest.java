/*
 * Decompiled with CFR 0.152.
 */
package java.util.jar;

import com.ibm.oti.io.CharacterConverter;
import com.ibm.oti.util.PriviAction;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.AccessController;
import java.util.Iterator;
import java.util.jar.Attributes;
import java.util.jar.Attributes$Name;
import java.util.jar.Manifest;

class Manifest$WriteManifest {
    private static final int LIMIT;
    private static byte[] sepBuf;
    private static Attributes$Name nameAttribute;
    byte[] oneByte = new byte[1];
    char[] oneChar = new char[1];
    private CharacterConverter converter;
    private byte[] outBuf = new byte[70];
    OutputStream os;

    static {
        sepBuf = new byte[]{13, 10};
        nameAttribute = new Attributes$Name("Name", false);
    }

    Manifest$WriteManifest() {
    }

    private void writeEntry(Attributes$Name attributes$Name, String string) {
        int n;
        int n2 = 0;
        int n3 = 70;
        byte[] byArray = new StringBuffer(String.valueOf(attributes$Name.toString())).append(": ").toString().getBytes("ISO8859_1");
        if (byArray.length > n3) {
            while (byArray.length - n2 >= n3) {
                n = byArray.length - n2;
                if (n > n3) {
                    n = n3;
                }
                if (n2 > 0) {
                    this.os.write(32);
                }
                this.os.write(byArray, n2, n);
                this.os.write(sepBuf);
                n2 += n;
                n3 = 69;
            }
        }
        n = byArray.length - n2;
        System.arraycopy((Object)byArray, n2, (Object)this.outBuf, 0, n);
        int n4 = 0;
        while (n4 < string.length()) {
            byte[] byArray2;
            this.oneChar[0] = string.charAt(n4);
            if (this.oneChar[0] < '\u0080' || this.converter == null) {
                this.oneByte[0] = (byte)this.oneChar[0];
                byArray2 = this.oneByte;
            } else {
                byArray2 = this.converter.convert(this.oneChar, 0, 1);
            }
            if (n + byArray2.length > n3) {
                if (n3 != 70) {
                    this.os.write(32);
                }
                this.os.write(this.outBuf, 0, n);
                this.os.write(sepBuf);
                n3 = 69;
                n = 0;
            }
            if (byArray2.length == 1) {
                this.outBuf[n] = byArray2[0];
            } else {
                System.arraycopy((Object)byArray2, 0, (Object)this.outBuf, n, byArray2.length);
            }
            n += byArray2.length;
            ++n4;
        }
        if (n > 0) {
            if (n3 != 70) {
                this.os.write(32);
            }
            this.os.write(this.outBuf, 0, n);
            this.os.write(sepBuf);
        }
    }

    void write(Manifest manifest, OutputStream outputStream) {
        Object object;
        Iterator iterator;
        String string;
        this.os = outputStream;
        String string2 = (String)AccessController.doPrivileged(new PriviAction("manifest.write.encoding"));
        if (string2 != null) {
            if ("".equals(string2)) {
                string2 = "UTF8";
            }
            this.converter = CharacterConverter.getConverter(string2);
            if (this.converter == null) {
                throw new UnsupportedEncodingException(string2);
            }
        }
        if ((string = Manifest.access$0(manifest).getValue(Attributes$Name.MANIFEST_VERSION)) != null) {
            this.writeEntry(Attributes$Name.MANIFEST_VERSION, string);
            iterator = Manifest.access$0(manifest).keySet().iterator();
            while (iterator.hasNext()) {
                object = (Attributes$Name)iterator.next();
                if (((Attributes$Name)object).equals(Attributes$Name.MANIFEST_VERSION)) continue;
                this.writeEntry((Attributes$Name)object, Manifest.access$0(manifest).getValue((Attributes$Name)object));
            }
        }
        this.os.write(sepBuf);
        iterator = Manifest.access$1(manifest).keySet().iterator();
        while (iterator.hasNext()) {
            object = (String)iterator.next();
            this.writeEntry(nameAttribute, (String)object);
            Attributes attributes = (Attributes)Manifest.access$1(manifest).get(object);
            Iterator iterator2 = attributes.keySet().iterator();
            while (iterator2.hasNext()) {
                Attributes$Name attributes$Name = (Attributes$Name)iterator2.next();
                this.writeEntry(attributes$Name, attributes.getValue(attributes$Name));
            }
            this.os.write(sepBuf);
        }
    }
}

