/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

import com.ibm.oti.util.Msg;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

public final class StringBuffer
implements Serializable,
CharSequence {
    private static final long serialVersionUID;
    private static final int INITIAL_SIZE;
    private int count;
    private char[] value;
    private boolean shared;

    public StringBuffer() {
        this(16);
    }

    public StringBuffer(int n) {
        this.count = 0;
        this.value = new char[n];
    }

    public StringBuffer(String string) {
        this.count = string.length();
        this.value = new char[this.count + 16];
        string.getChars(0, this.count, this.value, 0);
    }

    public synchronized StringBuffer append(char[] cArray) {
        int n = this.count + cArray.length;
        if (n > this.value.length) {
            this.ensureCapacityImpl(n);
        }
        System.arraycopy((Object)cArray, 0, (Object)this.value, this.count, cArray.length);
        this.count = n;
        return this;
    }

    public synchronized StringBuffer append(char[] cArray, int n, int n2) {
        if (n >= 0 && n2 >= 0 && n2 <= cArray.length - n) {
            int n3 = this.count + n2;
            if (n3 > this.value.length) {
                this.ensureCapacityImpl(n3);
            }
            System.arraycopy((Object)cArray, n, (Object)this.value, this.count, n2);
            this.count = n3;
            return this;
        }
        throw new StringIndexOutOfBoundsException();
    }

    public synchronized StringBuffer append(char c2) {
        if (this.count >= this.value.length) {
            this.ensureCapacityImpl(this.count + 1);
        }
        this.value[this.count] = c2;
        ++this.count;
        return this;
    }

    public StringBuffer append(double d2) {
        return this.append(String.valueOf(d2));
    }

    public StringBuffer append(float f2) {
        return this.append(String.valueOf(f2));
    }

    public StringBuffer append(int n) {
        return this.append(Integer.toString(n));
    }

    public StringBuffer append(long l) {
        return this.append(Long.toString(l));
    }

    public StringBuffer append(Object object) {
        return this.append(String.valueOf(object));
    }

    public synchronized StringBuffer append(String string) {
        int n;
        int n2;
        if (string == null) {
            string = String.valueOf(string);
        }
        if ((n2 = this.count + (n = string.length())) > this.value.length) {
            this.ensureCapacityImpl(n2);
        }
        string.getChars(0, n, this.value, this.count);
        this.count = n2;
        return this;
    }

    public StringBuffer append(boolean bl) {
        return this.append(String.valueOf(bl));
    }

    public int capacity() {
        return this.value.length;
    }

    @Override
    public synchronized char charAt(int n) {
        try {
            if (n < this.count) {
                return this.value[n];
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {}
        throw new StringIndexOutOfBoundsException(n);
    }

    public synchronized StringBuffer delete(int n, int n2) {
        if (n >= 0) {
            if (n2 > this.count) {
                n2 = this.count;
            }
            if (n2 > n) {
                int n3 = this.count - n2;
                try {
                    if (!this.shared) {
                        if (n3 > 0) {
                            System.arraycopy((Object)this.value, n2, (Object)this.value, n, n3);
                        }
                    } else {
                        char[] cArray = new char[this.value.length];
                        if (n > 0) {
                            System.arraycopy((Object)this.value, 0, (Object)cArray, 0, n);
                        }
                        if (n3 > 0) {
                            System.arraycopy((Object)this.value, n2, (Object)cArray, n, n3);
                        }
                        this.value = cArray;
                        this.shared = false;
                    }
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    throw new StringIndexOutOfBoundsException();
                }
                this.count -= n2 - n;
                return this;
            }
            if (n == n2) {
                return this;
            }
        }
        throw new StringIndexOutOfBoundsException();
    }

    public synchronized StringBuffer deleteCharAt(int n) {
        if (n >= 0 && n < this.count) {
            int n2 = this.count - n - 1;
            try {
                if (!this.shared) {
                    if (n2 > 0) {
                        System.arraycopy((Object)this.value, n + 1, (Object)this.value, n, n2);
                    }
                } else {
                    char[] cArray = new char[this.value.length];
                    if (n > 0) {
                        System.arraycopy((Object)this.value, 0, (Object)cArray, 0, n);
                    }
                    if (n2 > 0) {
                        System.arraycopy((Object)this.value, n + 1, (Object)cArray, n, n2);
                    }
                    this.value = cArray;
                    this.shared = false;
                }
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new StringIndexOutOfBoundsException(n);
            }
            --this.count;
            return this;
        }
        throw new StringIndexOutOfBoundsException(n);
    }

    public synchronized void ensureCapacity(int n) {
        if (n > this.value.length) {
            this.ensureCapacityImpl(n);
        }
    }

    private void ensureCapacityImpl(int n) {
        int n2 = (this.value.length << 1) + 2;
        char[] cArray = new char[n > n2 ? n : n2];
        System.arraycopy((Object)this.value, 0, (Object)cArray, 0, this.count);
        this.value = cArray;
        this.shared = false;
    }

    public synchronized void getChars(int n, int n2, char[] cArray, int n3) {
        try {
            if (n <= this.count && n2 <= this.count) {
                System.arraycopy((Object)this.value, n, (Object)cArray, n3, n2 - n);
                return;
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {}
        throw new StringIndexOutOfBoundsException();
    }

    public synchronized StringBuffer insert(int n, char[] cArray) {
        if (n >= 0 && n <= this.count) {
            this.move(cArray.length, n);
            System.arraycopy((Object)cArray, 0, (Object)this.value, n, cArray.length);
            this.count += cArray.length;
            return this;
        }
        throw new StringIndexOutOfBoundsException(n);
    }

    public synchronized StringBuffer insert(int n, char[] cArray, int n2, int n3) {
        if (n >= 0 && n <= this.count) {
            if (n2 >= 0 && n3 >= 0 && n3 <= cArray.length - n2) {
                this.move(n3, n);
                System.arraycopy((Object)cArray, n2, (Object)this.value, n, n3);
                this.count += n3;
                return this;
            }
            throw new StringIndexOutOfBoundsException();
        }
        throw new StringIndexOutOfBoundsException(n);
    }

    public synchronized StringBuffer insert(int n, char c2) {
        if (n >= 0 && n <= this.count) {
            this.move(1, n);
            this.value[n] = c2;
            ++this.count;
            return this;
        }
        throw new StringIndexOutOfBoundsException(n);
    }

    public StringBuffer insert(int n, double d2) {
        return this.insert(n, String.valueOf(d2));
    }

    public StringBuffer insert(int n, float f2) {
        return this.insert(n, String.valueOf(f2));
    }

    public StringBuffer insert(int n, int n2) {
        return this.insert(n, Integer.toString(n2));
    }

    public StringBuffer insert(int n, long l) {
        return this.insert(n, Long.toString(l));
    }

    public StringBuffer insert(int n, Object object) {
        return this.insert(n, String.valueOf(object));
    }

    public synchronized StringBuffer insert(int n, String string) {
        if (n >= 0 && n <= this.count) {
            if (string == null) {
                string = String.valueOf(string);
            }
            int n2 = string.length();
            this.move(n2, n);
            string.getChars(0, n2, this.value, n);
            this.count += n2;
            return this;
        }
        throw new StringIndexOutOfBoundsException(n);
    }

    public StringBuffer insert(int n, boolean bl) {
        return this.insert(n, String.valueOf(bl));
    }

    @Override
    public int length() {
        return this.count;
    }

    private void move(int n, int n2) {
        int n3;
        if (this.value.length - this.count >= n) {
            if (!this.shared) {
                System.arraycopy((Object)this.value, n2, (Object)this.value, n2 + n, this.count - n2);
                return;
            }
            n3 = this.value.length;
        } else {
            int n4 = this.count + n;
            int n5 = (this.value.length << 1) + 2;
            n3 = n4 > n5 ? n4 : n5;
        }
        char[] cArray = new char[n3];
        System.arraycopy((Object)this.value, 0, (Object)cArray, 0, n2);
        System.arraycopy((Object)this.value, n2, (Object)cArray, n2 + n, this.count - n2);
        this.value = cArray;
        this.shared = false;
    }

    public synchronized StringBuffer replace(int n, int n2, String string) {
        if (n >= 0) {
            if (n2 > this.count) {
                n2 = this.count;
            }
            if (n2 > n) {
                int n3 = string.length();
                int n4 = n2 - n - n3;
                if (n4 > 0) {
                    if (!this.shared) {
                        System.arraycopy((Object)this.value, n2, (Object)this.value, n + n3, this.count - n2);
                    } else {
                        char[] cArray = new char[this.value.length];
                        System.arraycopy((Object)this.value, 0, (Object)cArray, 0, n);
                        System.arraycopy((Object)this.value, n2, (Object)cArray, n + n3, this.count - n2);
                        this.value = cArray;
                        this.shared = false;
                    }
                } else if (n4 < 0) {
                    this.move(-n4, n2);
                } else if (this.shared) {
                    this.value = (char[])this.value.clone();
                    this.shared = false;
                }
                string.getChars(0, n3, this.value, n);
                this.count -= n4;
                return this;
            }
            if (n == n2) {
                if (string == null) {
                    throw new NullPointerException();
                }
                return this.insert(n, string);
            }
        }
        throw new StringIndexOutOfBoundsException();
    }

    public synchronized StringBuffer reverse() {
        if (this.count < 2) {
            return this;
        }
        if (!this.shared) {
            int n = 0;
            int n2 = this.count;
            int n3 = this.count / 2;
            while (n < n3) {
                char c2 = this.value[--n2];
                this.value[n2] = this.value[n];
                this.value[n] = c2;
                ++n;
            }
        } else {
            char[] cArray = new char[this.value.length];
            int n = 0;
            int n4 = this.count;
            while (n < this.count) {
                cArray[--n4] = this.value[n];
                ++n;
            }
            this.value = cArray;
            this.shared = false;
        }
        return this;
    }

    public synchronized void setCharAt(int n, char c2) {
        if (this.shared) {
            this.value = (char[])this.value.clone();
            this.shared = false;
        }
        if (n < 0 || n >= this.count) {
            throw new StringIndexOutOfBoundsException(n);
        }
        this.value[n] = c2;
    }

    public synchronized void setLength(int n) {
        if (n > this.value.length) {
            this.ensureCapacityImpl(n);
        } else if (n > this.count) {
            Arrays.fill(this.value, this.count, n, '\u0000');
        } else if (this.shared) {
            if (n < 0) {
                throw new IndexOutOfBoundsException();
            }
            char[] cArray = new char[this.value.length];
            if (n > 0) {
                System.arraycopy((Object)this.value, 0, (Object)cArray, 0, n);
            }
            this.value = cArray;
            this.shared = false;
        } else if (n < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.count = n;
    }

    public synchronized String substring(int n) {
        if (n >= 0 && n <= this.count) {
            return new String(this.value, n, this.count - n);
        }
        throw new StringIndexOutOfBoundsException(n);
    }

    public synchronized String substring(int n, int n2) {
        if (n >= 0 && n <= n2 && n2 <= this.count) {
            return new String(this.value, n, n2 - n);
        }
        throw new StringIndexOutOfBoundsException();
    }

    @Override
    public synchronized String toString() {
        if (this.count >= 256 && this.count <= this.value.length >> 1) {
            return new String(this.value, 0, this.count);
        }
        this.shared = true;
        return new String(0, this.count, this.value);
    }

    char[] shareValue() {
        this.shared = true;
        return this.value;
    }

    private synchronized void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        if (this.count > this.value.length) {
            throw new InvalidObjectException(Msg.getString("K0199"));
        }
        this.shared = false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public synchronized StringBuffer append(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return this.append((String)null);
        }
        StringBuffer stringBuffer2 = stringBuffer;
        synchronized (stringBuffer2) {
            int n = stringBuffer.count;
            int n2 = this.count + n;
            if (n2 > this.value.length) {
                this.ensureCapacityImpl(n2);
            }
            System.arraycopy((Object)stringBuffer.value, 0, (Object)this.value, this.count, n);
            this.count = n2;
        }
        return this;
    }

    @Override
    public CharSequence subSequence(int n, int n2) {
        return this.substring(n, n2);
    }

    public int indexOf(String string) {
        return this.indexOf(string, 0);
    }

    public synchronized int indexOf(String string, int n) {
        int n2;
        if (n < 0) {
            n = 0;
        }
        if ((n2 = string.length()) > 0) {
            if (n2 + n > this.count) {
                return -1;
            }
            char c2 = string.charAt(0);
            while (true) {
                int n3 = n;
                boolean bl = false;
                while (n3 < this.count) {
                    if (this.value[n3] == c2) {
                        bl = true;
                        break;
                    }
                    ++n3;
                }
                if (!bl || n2 + n3 > this.count) {
                    return -1;
                }
                int n4 = n3;
                int n5 = 0;
                while (++n5 < n2 && this.value[++n4] == string.charAt(n5)) {
                }
                if (n5 == n2) {
                    return n3;
                }
                n = n3 + 1;
            }
        }
        return n < this.count || n == 0 ? n : this.count;
    }

    public synchronized int lastIndexOf(String string) {
        return this.lastIndexOf(string, this.count);
    }

    public synchronized int lastIndexOf(String string, int n) {
        int n2 = string.length();
        if (n2 <= this.count && n >= 0) {
            if (n2 > 0) {
                if (n > this.count - n2) {
                    n = this.count - n2;
                }
                char c2 = string.charAt(0);
                while (true) {
                    int n3 = n;
                    boolean bl = false;
                    while (n3 >= 0) {
                        if (this.value[n3] == c2) {
                            bl = true;
                            break;
                        }
                        --n3;
                    }
                    if (!bl) {
                        return -1;
                    }
                    int n4 = n3;
                    int n5 = 0;
                    while (++n5 < n2 && this.value[++n4] == string.charAt(n5)) {
                    }
                    if (n5 == n2) {
                        return n3;
                    }
                    n = n3 - 1;
                }
            }
            return n < this.count ? n : this.count;
        }
        return -1;
    }

    char[] getValue() {
        return this.value;
    }
}

