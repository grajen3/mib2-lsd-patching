/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package java.lang;

import com.ibm.oti.io.CharacterConverter;
import com.ibm.oti.util.PriviAction;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.AccessController;
import java.util.Comparator;
import java.util.Locale;

public final class String
implements Serializable,
Comparable,
CharSequence {
    private static final long serialVersionUID;
    public static final Comparator CASE_INSENSITIVE_ORDER;
    private static final char[] ascii;
    private final char[] value;
    private final int offset;
    private final int count;
    private int hashCode;
    private static CharacterConverter DefaultConverter;
    private static CharacterConverter lastConverter;
    private static final char[] upperValues;

    static {
        CASE_INSENSITIVE_ORDER = new String$CaseInsensitiveComparator();
        ascii = new char[128];
        int n = 0;
        while (n < ascii.length) {
            String.ascii[n] = (char)n;
            ++n;
        }
        upperValues = "SS\u0000\u02bcN\u0000J\u030c\u0000\u0399\u0308\u0301\u03a5\u0308\u0301\u0535\u0552\u0000H\u0331\u0000T\u0308\u0000W\u030a\u0000Y\u030a\u0000A\u02be\u0000\u03a5\u0313\u0000\u03a5\u0313\u0300\u03a5\u0313\u0301\u03a5\u0313\u0342\u1f08\u0399\u0000\u1f09\u0399\u0000\u1f0a\u0399\u0000\u1f0b\u0399\u0000\u1f0c\u0399\u0000\u1f0d\u0399\u0000\u1f0e\u0399\u0000\u1f0f\u0399\u0000\u1f08\u0399\u0000\u1f09\u0399\u0000\u1f0a\u0399\u0000\u1f0b\u0399\u0000\u1f0c\u0399\u0000\u1f0d\u0399\u0000\u1f0e\u0399\u0000\u1f0f\u0399\u0000\u1f28\u0399\u0000\u1f29\u0399\u0000\u1f2a\u0399\u0000\u1f2b\u0399\u0000\u1f2c\u0399\u0000\u1f2d\u0399\u0000\u1f2e\u0399\u0000\u1f2f\u0399\u0000\u1f28\u0399\u0000\u1f29\u0399\u0000\u1f2a\u0399\u0000\u1f2b\u0399\u0000\u1f2c\u0399\u0000\u1f2d\u0399\u0000\u1f2e\u0399\u0000\u1f2f\u0399\u0000\u1f68\u0399\u0000\u1f69\u0399\u0000\u1f6a\u0399\u0000\u1f6b\u0399\u0000\u1f6c\u0399\u0000\u1f6d\u0399\u0000\u1f6e\u0399\u0000\u1f6f\u0399\u0000\u1f68\u0399\u0000\u1f69\u0399\u0000\u1f6a\u0399\u0000\u1f6b\u0399\u0000\u1f6c\u0399\u0000\u1f6d\u0399\u0000\u1f6e\u0399\u0000\u1f6f\u0399\u0000\u1fba\u0399\u0000\u0391\u0399\u0000\u0386\u0399\u0000\u0391\u0342\u0000\u0391\u0342\u0399\u0391\u0399\u0000\u1fca\u0399\u0000\u0397\u0399\u0000\u0389\u0399\u0000\u0397\u0342\u0000\u0397\u0342\u0399\u0397\u0399\u0000\u0399\u0308\u0300\u0399\u0308\u0301\u0399\u0342\u0000\u0399\u0308\u0342\u03a5\u0308\u0300\u03a5\u0308\u0301\u03a1\u0313\u0000\u03a5\u0342\u0000\u03a5\u0308\u0342\u1ffa\u0399\u0000\u03a9\u0399\u0000\u038f\u0399\u0000\u03a9\u0342\u0000\u03a9\u0342\u0399\u03a9\u0399\u0000FF\u0000FI\u0000FL\u0000FFIFFLST\u0000ST\u0000\u0544\u0546\u0000\u0544\u0535\u0000\u0544\u053b\u0000\u054e\u0546\u0000\u0544\u053d\u0000".value;
    }

    public String() {
        this.value = new char[0];
        this.offset = 0;
        this.count = 0;
    }

    private String(String string, char c2) {
        this.offset = 0;
        this.value = new char[string.count + 1];
        this.count = string.count + 1;
        System.arraycopy((Object)string.value, string.offset, (Object)this.value, 0, string.count);
        this.value[string.count] = c2;
    }

    public String(byte[] byArray) {
        this(byArray, 0, byArray.length);
    }

    public String(byte[] byArray, int n, int n2) {
        if (n < 0 || n2 < 0 || n2 > byArray.length - n) {
            throw new StringIndexOutOfBoundsException();
        }
        this.offset = 0;
        CharacterConverter characterConverter = String.defaultConverter();
        this.value = characterConverter.convert(byArray, n, n2);
        this.count = this.value.length;
    }

    public String(byte[] byArray, int n, int n2, String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        if (n < 0 || n2 < 0 || n2 > byArray.length - n) {
            throw new StringIndexOutOfBoundsException();
        }
        this.offset = 0;
        CharacterConverter characterConverter = this.getConverter(string);
        this.value = characterConverter.convert(byArray, n, n2);
        this.count = this.value.length;
    }

    public String(byte[] byArray, String string) {
        this(byArray, 0, byArray.length, string);
    }

    public String(char[] cArray) {
        this(cArray, 0, cArray.length);
    }

    public String(char[] cArray, int n, int n2) {
        if (n >= 0 && n2 >= 0 && n2 <= cArray.length - n) {
            this.offset = 0;
            this.value = new char[n2];
            this.count = n2;
            try {
                System.arraycopy((Object)cArray, n, (Object)this.value, 0, this.count);
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new StringIndexOutOfBoundsException();
            }
        } else {
            throw new StringIndexOutOfBoundsException();
        }
    }

    String(int n, int n2, char[] cArray) {
        this.value = cArray;
        this.offset = n;
        this.count = n2;
    }

    public String(String string) {
        this.value = string.value;
        this.offset = string.offset;
        this.count = string.count;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String(StringBuffer stringBuffer) {
        this.offset = 0;
        StringBuffer stringBuffer2 = stringBuffer;
        synchronized (stringBuffer2) {
            this.value = stringBuffer.shareValue();
            this.count = stringBuffer.length();
        }
    }

    private String(String string, String string2) {
        if (string == null) {
            string = "null";
        }
        if (string2 == null) {
            string2 = "null";
        }
        int n = string.count + string2.count;
        this.value = new char[n];
        this.offset = 0;
        System.arraycopy((Object)string.value, string.offset, (Object)this.value, 0, string.count);
        System.arraycopy((Object)string2.value, string2.offset, (Object)this.value, string.count, string2.count);
        this.count = n;
    }

    private String(String string, String string2, String string3) {
        if (string == null) {
            string = "null";
        }
        if (string2 == null) {
            string2 = "null";
        }
        if (string3 == null) {
            string3 = "null";
        }
        int n = string.count + string2.count + string3.count;
        this.value = new char[n];
        this.offset = 0;
        System.arraycopy((Object)string.value, string.offset, (Object)this.value, 0, string.count);
        System.arraycopy((Object)string2.value, string2.offset, (Object)this.value, string.count, string2.count);
        System.arraycopy((Object)string3.value, string3.offset, (Object)this.value, string.count + string2.count, string3.count);
        this.count = n;
    }

    private String(String string, int n) {
        int n2;
        int n3;
        if (string == null) {
            string = "null";
        }
        int n4 = 1;
        int n5 = n;
        while ((n5 /= 10) != 0) {
            ++n4;
        }
        if (n >= 0) {
            n3 = -n;
        } else {
            ++n4;
            n3 = n;
        }
        int n6 = string.count + n4;
        this.value = new char[n6];
        int n7 = n6 - 1;
        do {
            n2 = n3 / 10;
            int n8 = n3 - n2 * 10;
            this.value[n7] = (char)(48 - n8);
            --n7;
        } while ((n3 = n2) != 0);
        if (n < 0) {
            this.value[n7] = 45;
        }
        this.offset = 0;
        System.arraycopy((Object)string.value, string.offset, (Object)this.value, 0, string.count);
        this.count = n6;
    }

    @Override
    public char charAt(int n) {
        if (n >= 0 && n < this.count) {
            return this.value[this.offset + n];
        }
        throw new StringIndexOutOfBoundsException();
    }

    @Override
    public int compareTo(Object object) {
        return this.compareTo((String)object);
    }

    public int compareTo(String string) {
        int n = this.offset;
        int n2 = string.offset;
        int n3 = this.offset + (this.count < string.count ? this.count : string.count);
        char[] cArray = string.value;
        while (n < n3) {
            int n4;
            if ((n4 = this.value[n++] - cArray[n2++]) == 0) continue;
            return n4;
        }
        return this.count - string.count;
    }

    private char compareValue(char c2) {
        if (c2 < '\u0080' && 'A' <= c2 && c2 <= 'Z') {
            return (char)(c2 + 32);
        }
        return Character.toLowerCase(Character.toUpperCase(c2));
    }

    public int compareToIgnoreCase(String string) {
        int n = this.offset;
        int n2 = string.offset;
        int n3 = this.offset + (this.count < string.count ? this.count : string.count);
        char[] cArray = string.value;
        while (n < n3) {
            int n4;
            char c2;
            char c3;
            if ((c3 = this.value[n++]) == (c2 = cArray[n2++]) || (n4 = (c3 = this.compareValue(c3)) - (c2 = this.compareValue(c2))) == 0) continue;
            return n4;
        }
        return this.count - string.count;
    }

    public String concat(String string) {
        if (string.count > 0) {
            char[] cArray = new char[this.count + string.count];
            if (this.count > 0) {
                System.arraycopy((Object)this.value, this.offset, (Object)cArray, 0, this.count);
            }
            System.arraycopy((Object)string.value, string.offset, (Object)cArray, this.count, string.count);
            return new String(0, cArray.length, cArray);
        }
        return this;
    }

    public static String copyValueOf(char[] cArray) {
        return new String(cArray, 0, cArray.length);
    }

    public static String copyValueOf(char[] cArray, int n, int n2) {
        return new String(cArray, n, n2);
    }

    private static CharacterConverter defaultConverter() {
        if (DefaultConverter == null) {
            String string = (String)AccessController.doPrivileged(new PriviAction("file.encoding", "ISO8859_1"));
            if (DefaultConverter == null) {
                DefaultConverter = CharacterConverter.getDefaultConverter(string).getModeless();
            }
        }
        return DefaultConverter;
    }

    public boolean endsWith(String string) {
        return this.regionMatches(this.count - string.count, string, 0, string.count);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof String) {
            String string = (String)object;
            if (this.count != string.count || this.hashCode != string.hashCode && this.hashCode != 0 && string.hashCode != 0) {
                return false;
            }
            return this.regionMatches(0, string, 0, this.count);
        }
        return false;
    }

    public boolean equalsIgnoreCase(String string) {
        if (string == this) {
            return true;
        }
        if (string == null || this.count != string.count) {
            return false;
        }
        int n = this.offset;
        int n2 = string.offset;
        int n3 = this.offset + this.count;
        char[] cArray = string.value;
        while (n < n3) {
            char c2;
            char c3;
            if ((c3 = this.value[n++]) == (c2 = cArray[n2++]) || this.toUpperCase(c3) == this.toUpperCase(c2) || this.toLowerCase(c3) == this.toLowerCase(c2)) continue;
            return false;
        }
        return true;
    }

    public byte[] getBytes() {
        return String.defaultConverter().convert(this.value, this.offset, this.count);
    }

    public byte[] getBytes(String string) {
        return this.getConverter(string).convert(this.value, this.offset, this.count);
    }

    private CharacterConverter getConverter(String string) {
        CharacterConverter characterConverter = lastConverter;
        if (characterConverter == null || !characterConverter.isCalled(string)) {
            characterConverter = CharacterConverter.getConverter(string);
            if (characterConverter != null) {
                lastConverter = characterConverter = characterConverter.getModeless();
            } else {
                throw new UnsupportedEncodingException(string);
            }
        }
        return characterConverter;
    }

    public void getChars(int n, int n2, char[] cArray, int n3) {
        if (n < 0 || n > n2 || n2 > this.count) {
            throw new StringIndexOutOfBoundsException();
        }
        System.arraycopy((Object)this.value, n + this.offset, (Object)cArray, n3, n2 - n);
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = this.hashCodeImpl();
        }
        return this.hashCode;
    }

    private native int hashCodeImpl() {
    }

    public int indexOf(int n) {
        return this.indexOf(n, 0);
    }

    public native int indexOf(int n, int n2) {
    }

    public int indexOf(String string) {
        return this.indexOf(string, 0);
    }

    public int indexOf(String string, int n) {
        int n2;
        if (n < 0) {
            n = 0;
        }
        if ((n2 = string.count) > 0) {
            if (n2 + n > this.count) {
                return -1;
            }
            char[] cArray = string.value;
            int n3 = string.offset;
            char c2 = cArray[n3];
            int n4 = n3 + n2;
            while (true) {
                int n5;
                if ((n5 = this.indexOf(c2, n)) == -1 || n2 + n5 > this.count) {
                    return -1;
                }
                int n6 = this.offset + n5;
                int n7 = n3;
                while (++n7 < n4 && this.value[++n6] == cArray[n7]) {
                }
                if (n7 == n4) {
                    return n5;
                }
                n = n5 + 1;
            }
        }
        return n < this.count ? n : this.count;
    }

    public native String intern() {
    }

    public int lastIndexOf(int n) {
        return this.lastIndexOf(n, this.count - 1);
    }

    public native int lastIndexOf(int n, int n2) {
    }

    public int lastIndexOf(String string) {
        return this.lastIndexOf(string, this.count);
    }

    public int lastIndexOf(String string, int n) {
        int n2 = string.count;
        if (n2 <= this.count && n >= 0) {
            if (n2 > 0) {
                if (n > this.count - n2) {
                    n = this.count - n2;
                }
                char[] cArray = string.value;
                int n3 = string.offset;
                char c2 = cArray[n3];
                int n4 = n3 + n2;
                while (true) {
                    int n5;
                    if ((n5 = this.lastIndexOf(c2, n)) == -1) {
                        return -1;
                    }
                    int n6 = this.offset + n5;
                    int n7 = n3;
                    while (++n7 < n4 && this.value[++n6] == cArray[n7]) {
                    }
                    if (n7 == n4) {
                        return n5;
                    }
                    n = n5 - 1;
                }
            }
            return n < this.count ? n : this.count;
        }
        return -1;
    }

    @Override
    public int length() {
        return this.count;
    }

    public native boolean regionMatches(int n, String string, int n2, int n3) {
    }

    public boolean regionMatches(boolean bl, int n, String string, int n2, int n3) {
        if (!bl) {
            return this.regionMatches(n, string, n2, n3);
        }
        if (string != null) {
            if (n < 0 || n3 > this.count - n) {
                return false;
            }
            if (n2 < 0 || n3 > string.count - n2) {
                return false;
            }
            n2 += string.offset;
            int n4 = (n += this.offset) + n3;
            char[] cArray = string.value;
            while (n < n4) {
                char c2;
                char c3;
                if ((c3 = this.value[n++]) == (c2 = cArray[n2++]) || this.toUpperCase(c3) == this.toUpperCase(c2) || this.toLowerCase(c3) == this.toLowerCase(c2)) continue;
                return false;
            }
            return true;
        }
        throw new NullPointerException();
    }

    public String replace(char c2, char c3) {
        int n = this.indexOf(c2, 0);
        if (n == -1) {
            return this;
        }
        char[] cArray = new char[this.count];
        System.arraycopy((Object)this.value, this.offset, (Object)cArray, 0, this.count);
        do {
            cArray[n++] = c3;
        } while ((n = this.indexOf(c2, n)) != -1);
        return new String(0, this.count, cArray);
    }

    public boolean startsWith(String string) {
        return this.startsWith(string, 0);
    }

    public boolean startsWith(String string, int n) {
        return this.regionMatches(n, string, 0, string.count);
    }

    public String substring(int n) {
        if (n == 0) {
            return this;
        }
        if (n >= 0 && n <= this.count) {
            return new String(this.offset + n, this.count - n, this.value);
        }
        throw new StringIndexOutOfBoundsException(n);
    }

    public String substring(int n, int n2) {
        if (n == 0 && n2 == this.count) {
            return this;
        }
        if (n >= 0 && n <= n2 && n2 <= this.count) {
            return new String(this.offset + n, n2 - n, this.value);
        }
        throw new StringIndexOutOfBoundsException();
    }

    public char[] toCharArray() {
        char[] cArray = new char[this.count];
        System.arraycopy((Object)this.value, this.offset, (Object)cArray, 0, this.count);
        return cArray;
    }

    public String toLowerCase() {
        return this.toLowerCase(Locale.getDefault());
    }

    private char toLowerCase(char c2) {
        if (c2 < '\u0080') {
            if ('A' <= c2 && c2 <= 'Z') {
                return (char)(c2 + 32);
            }
            return c2;
        }
        return Character.toLowerCase(c2);
    }

    private char toUpperCase(char c2) {
        if (c2 < '\u0080') {
            if ('a' <= c2 && c2 <= 'z') {
                return (char)(c2 - 32);
            }
            return c2;
        }
        return Character.toUpperCase(c2);
    }

    /*
     * Unable to fully structure code
     */
    public String toLowerCase(Locale var1_1) {
        var2_2 = this.offset;
        var3_3 = this.offset + this.count;
        while (var2_2 < var3_3) {
            block3: {
                block4: {
                    var4_4 = this.value[var2_2];
                    if (var4_4 == this.toLowerCase(var4_4)) break block3;
                    var5_5 = new char[this.count];
                    var6_6 = var2_2 - this.offset;
                    System.arraycopy((Object)this.value, this.offset, (Object)var5_5, 0, var6_6);
                    if ("tr".equals(var1_1.getLanguage())) ** GOTO lbl15
                    while (var6_6 < this.count) {
                        var5_5[var6_6++] = this.toLowerCase(this.value[var2_2++]);
                    }
                    break block4;
lbl-1000:
                    // 1 sources

                    {
                        v0 = var5_5[var6_6++] = (var4_4 = this.value[var2_2++]) != 'I' ? (int)this.toLowerCase(var4_4) : 305;
lbl15:
                        // 2 sources

                        ** while (var6_6 < this.count)
                    }
                }
                return new String(0, this.count, var5_5);
            }
            ++var2_2;
        }
        return this;
    }

    @Override
    public String toString() {
        return this;
    }

    public String toUpperCase() {
        return this.toUpperCase(Locale.getDefault());
    }

    private int upperIndex(int n) {
        int n2 = -1;
        if (n <= 1415) {
            if (n == 223) {
                n2 = 0;
            } else if (n <= 329) {
                if (n == 329) {
                    n2 = 1;
                }
            } else if (n <= 496) {
                if (n == 496) {
                    n2 = 2;
                }
            } else if (n <= 912) {
                if (n == 912) {
                    n2 = 3;
                }
            } else if (n <= 944) {
                if (n == 944) {
                    n2 = 4;
                }
            } else if (n <= 1415 && n == 1415) {
                n2 = 5;
            }
        } else if (n >= 7830) {
            if (n <= 7834) {
                n2 = 6 + n - 7830;
            } else if (n >= 8016 && n <= 8188) {
                n2 = "\u000b\u0000\f\u0000\r\u0000\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>\u0000\u0000?@A\u0000BC\u0000\u0000\u0000\u0000D\u0000\u0000\u0000\u0000\u0000EFG\u0000HI\u0000\u0000\u0000\u0000J\u0000\u0000\u0000\u0000\u0000KL\u0000\u0000MN\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000OPQ\u0000RS\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000TUV\u0000WX\u0000\u0000\u0000\u0000Y".value[n - 8016];
                if (n2 == 0) {
                    n2 = -1;
                }
            } else if (n >= 0xFB0000) {
                if (n <= 117112832) {
                    n2 = 90 + n - 0xFB0000;
                } else if (n >= 335216640 && n <= 402325504) {
                    n2 = 97 + n - 335216640;
                }
            }
        }
        return n2;
    }

    public String toUpperCase(Locale locale) {
        boolean bl = "tr".equals(locale.getLanguage());
        char[] cArray = null;
        int n = 0;
        int n2 = this.offset;
        int n3 = this.offset + this.count;
        while (n2 < n3) {
            int n4;
            char c2 = this.value[n2];
            int n5 = -1;
            if (c2 >= '\u00df' && c2 <= '\u17fb0000') {
                n5 = this.upperIndex(c2);
            }
            if (n5 == -1) {
                if (cArray != null && n >= cArray.length) {
                    char[] cArray2 = new char[cArray.length + this.count / 6 + 2];
                    System.arraycopy((Object)cArray, 0, (Object)cArray2, 0, cArray.length);
                    cArray = cArray2;
                }
                int n6 = n4 = !bl || c2 != 'i' ? this.toUpperCase(c2) : 304;
                if (c2 != n4) {
                    if (cArray == null) {
                        cArray = new char[this.count];
                        n = n2 - this.offset;
                        System.arraycopy((Object)this.value, this.offset, (Object)cArray, 0, n);
                    }
                    cArray[n++] = n4;
                } else if (cArray != null) {
                    cArray[n++] = c2;
                }
            } else {
                n4 = n5 * 3;
                char c3 = upperValues[n4 + 2];
                if (cArray == null) {
                    cArray = new char[this.count + this.count / 6 + 2];
                    n = n2 - this.offset;
                    System.arraycopy((Object)this.value, this.offset, (Object)cArray, 0, n);
                } else if (n + (c3 == '\u0000' ? 1 : 2) >= cArray.length) {
                    char[] cArray3 = new char[cArray.length + this.count / 6 + 3];
                    System.arraycopy((Object)cArray, 0, (Object)cArray3, 0, cArray.length);
                    cArray = cArray3;
                }
                char c4 = upperValues[n4];
                cArray[n++] = c4;
                c4 = upperValues[n4 + 1];
                cArray[n++] = c4;
                if (c3 != '\u0000') {
                    cArray[n++] = c3;
                }
            }
            ++n2;
        }
        if (cArray == null) {
            return this;
        }
        return cArray.length == n || cArray.length - n < 8 ? new String(0, n, cArray) : new String(cArray, 0, n);
    }

    public String trim() {
        int n;
        int n2 = this.offset;
        int n3 = n = this.offset + this.count - 1;
        while (n2 <= n3 && this.value[n2] <= ' ') {
            ++n2;
        }
        while (n3 >= n2 && this.value[n3] <= ' ') {
            --n3;
        }
        if (n2 == this.offset && n3 == n) {
            return this;
        }
        return new String(n2, n3 - n2 + 1, this.value);
    }

    public static String valueOf(char[] cArray) {
        return new String(cArray, 0, cArray.length);
    }

    public static String valueOf(char[] cArray, int n, int n2) {
        return new String(cArray, n, n2);
    }

    public static String valueOf(char c2) {
        String string = c2 < '\u0080' ? new String(c2, 1, ascii) : new String(0, 1, new char[]{c2});
        string.hashCode = c2;
        return string;
    }

    public static String valueOf(double d2) {
        return Double.toString((double)d2);
    }

    public static String valueOf(float f2) {
        return Float.toString(f2);
    }

    public static String valueOf(int n) {
        return Integer.toString(n);
    }

    public static String valueOf(long l) {
        return Long.toString(l);
    }

    public static String valueOf(Object object) {
        return object != null ? object.toString() : "null";
    }

    public static String valueOf(boolean bl) {
        return bl ? "true" : "false";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean contentEquals(StringBuffer stringBuffer) {
        StringBuffer stringBuffer2 = stringBuffer;
        synchronized (stringBuffer2) {
            int n;
            block4: {
                n = stringBuffer.length();
                if (this.count == n) break block4;
                return false;
            }
            return this.regionMatches(0, new String(0, n, stringBuffer.getValue()), 0, n);
        }
    }

    @Override
    public CharSequence subSequence(int n, int n2) {
        return this.substring(n, n2);
    }

    private static int indexOf(String string, String string2, int n, int n2, char c2) {
        char[] cArray = string.value;
        int n3 = string.offset;
        int n4 = string.count;
        char[] cArray2 = string2.value;
        int n5 = string2.offset;
        int n6 = string2.count;
        int n7 = n6 - 1;
        int n8 = n3 + n4;
        int n9 = n3 + n7;
        block0: while (n9 < n8) {
            int n10;
            if (c2 == cArray[n9]) {
                n10 = 0;
                while (n10 < n7) {
                    if (cArray2[n10 + n5] != cArray[n9 + n10 - n7]) {
                        int n11 = 1;
                        int n12 = 0;
                        n12 = (n & '\u0001' << cArray[n9]) == 0 ? 0 : 1;
                        n9 += Math.max(n2, n11 += --n12 & n10);
                        continue block0;
                    }
                    ++n10;
                }
                return n9 - n7 - n3;
            }
            n10 = 0;
            n10 = (n & '\u0001' << cArray[n9]) == 0 ? 0 : 1;
            n9 += --n10 & n7;
            ++n9;
        }
        return -1;
    }

    char[] getValue() {
        return this.value;
    }

    static /* synthetic */ char[] access$0(String string) {
        return string.value;
    }

    static /* synthetic */ int access$1(String string) {
        return string.offset;
    }

    static /* synthetic */ int access$2(String string) {
        return string.count;
    }
}

