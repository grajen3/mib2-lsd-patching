/*
 * Decompiled with CFR 0.152.
 */
package java.util.jar;

import com.ibm.oti.io.CharacterConverter;
import com.ibm.oti.util.Msg;
import com.ibm.oti.util.PriviAction;
import com.ibm.oti.util.Util;
import com.ibm.oti.vm.VM;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UTFDataFormatException;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.Attributes$Name;

class InitManifest {
    private static final boolean useNative = VM.useNatives();
    private byte[] inbuf = new byte[1024];
    private int inbufCount = 0;
    private int inbufPos = 0;
    private byte[] buffer = new byte[5];
    private char[] charbuf = new char[0];
    private ByteArrayOutputStream out = new ByteArrayOutputStream(256);
    private String encoding;
    private CharacterConverter converter;
    private Map attributeNames = new HashMap();

    InitManifest(InputStream inputStream, Attributes attributes, Map map, Map map2, String string) {
        this.encoding = (String)AccessController.doPrivileged(new PriviAction("manifest.read.encoding"));
        if ("".equals(this.encoding)) {
            this.encoding = null;
        }
        Attributes attributes2 = attributes;
        ArrayList arrayList = new ArrayList();
        this.readLines(inputStream, arrayList);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            this.addAttribute((String)iterator.next(), attributes2);
        }
        if (string != null && attributes.getValue(string) == null) {
            throw new IOException(Msg.getString("K0009", string));
        }
        arrayList.clear();
        byte[] byArray = null;
        while (!(map2 == null ? !this.readLines(inputStream, arrayList) : (byArray = this.nextChunk(inputStream, arrayList)) == null)) {
            iterator = arrayList.iterator();
            String string2 = (String)iterator.next();
            if (string2.length() < 7 || !string2.substring(0, 5).toLowerCase().equals("name:")) {
                throw new IOException(Msg.getString("K000a"));
            }
            String string3 = string2.substring(6, string2.length());
            attributes2 = new Attributes(12);
            if (map2 != null) {
                map2.put(string3, byArray);
            }
            map.put(string3, attributes2);
            while (iterator.hasNext()) {
                this.addAttribute((String)iterator.next(), attributes2);
            }
            arrayList.clear();
        }
    }

    private void addLine(int n, List list) {
        if (this.encoding != null) {
            list.add(new String(this.buffer, 0, n, this.encoding));
        } else {
            if (this.converter == null) {
                try {
                    if (useNative) {
                        list.add(Util.convertFromUTF8(this.buffer, 0, n));
                    } else {
                        if (this.charbuf.length < n) {
                            this.charbuf = new char[n];
                        }
                        list.add(Util.convertUTF8WithBuf(this.buffer, this.charbuf, 0, n));
                    }
                }
                catch (UTFDataFormatException uTFDataFormatException) {
                    this.converter = new CharacterConverter();
                }
            }
            if (this.converter != null) {
                if (this.charbuf.length < n) {
                    this.charbuf = new char[n];
                }
                this.converter.convert(this.buffer, 0, this.charbuf, 0, n);
                list.add(new String(this.charbuf, 0, n));
            }
        }
    }

    private byte[] nextChunk(InputStream inputStream, List list) {
        if (this.inbufCount == -1) {
            return null;
        }
        int n = 0;
        boolean bl = false;
        boolean bl2 = false;
        this.out.reset();
        while (true) {
            if (this.inbufPos == this.inbufCount) {
                this.inbufCount = inputStream.read(this.inbuf);
                if (this.inbufCount == -1) {
                    if (this.out.size() == 0) {
                        return null;
                    }
                    if (bl) {
                        this.addLine(n, list);
                    }
                    return this.out.toByteArray();
                }
                this.inbufPos = 0;
            }
            int n2 = this.inbuf[this.inbufPos++];
            if (bl2) {
                if (n2 != 10) {
                    --this.inbufPos;
                    n2 = 13;
                } else {
                    if (this.out.size() == 0) continue;
                    this.out.write(13);
                }
                bl2 = false;
            } else if (n2 == 13) {
                bl2 = true;
                continue;
            }
            if (bl) {
                if (n2 == 32) {
                    this.out.write(n2);
                    bl = false;
                    continue;
                }
                this.addLine(n, list);
                if (n2 == 10) {
                    this.out.write(n2);
                    return this.out.toByteArray();
                }
                n = 0;
            } else if (n2 == 10) {
                if (this.out.size() == 0) continue;
                this.out.write(n2);
                bl = true;
                continue;
            }
            bl = false;
            this.out.write(n2);
            if (n == this.buffer.length) {
                byte[] byArray = new byte[this.buffer.length * 2];
                System.arraycopy((Object)this.buffer, 0, (Object)byArray, 0, this.buffer.length);
                this.buffer = byArray;
            }
            this.buffer[n++] = n2;
        }
    }

    private boolean readLines(InputStream inputStream, List list) {
        if (this.inbufCount == -1) {
            return false;
        }
        int n = 0;
        boolean bl = false;
        boolean bl2 = false;
        while (true) {
            if (this.inbufPos == this.inbufCount) {
                this.inbufCount = inputStream.read(this.inbuf);
                if (this.inbufCount == -1) {
                    if (bl) {
                        this.addLine(n, list);
                    }
                    return list.size() != 0;
                }
                this.inbufPos = 0;
            }
            int n2 = this.inbuf[this.inbufPos++];
            if (bl2) {
                if (n2 != 10) {
                    --this.inbufPos;
                    n2 = 13;
                }
                bl2 = false;
            } else if (n2 == 13) {
                bl2 = true;
                continue;
            }
            if (bl) {
                if (n2 == 32) {
                    bl = false;
                    continue;
                }
                this.addLine(n, list);
                if (n2 == 10) {
                    return true;
                }
                n = 0;
            } else if (n2 == 10) {
                if (n == 0 && list.size() == 0) continue;
                bl = true;
                continue;
            }
            bl = false;
            if (n == this.buffer.length) {
                byte[] byArray = new byte[this.buffer.length * 2];
                System.arraycopy((Object)this.buffer, 0, (Object)byArray, 0, this.buffer.length);
                this.buffer = byArray;
            }
            this.buffer[n++] = n2;
        }
    }

    private void addAttribute(String string, Attributes attributes) {
        int n = string.indexOf(58);
        if (n < 1) {
            throw new IOException(Msg.getString("K000b", string));
        }
        String string2 = string.substring(0, n);
        Attributes$Name attributes$Name = (Attributes$Name)this.attributeNames.get(string2);
        if (attributes$Name == null) {
            try {
                attributes$Name = new Attributes$Name(string2);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                throw new IOException(illegalArgumentException.toString());
            }
            this.attributeNames.put(string2, attributes$Name);
        }
        if (n + 1 >= string.length() || string.charAt(n + 1) != ' ') {
            throw new IOException(Msg.getString("K000b", string));
        }
        attributes.put(attributes$Name, string.substring(n + 2, string.length()));
    }
}

