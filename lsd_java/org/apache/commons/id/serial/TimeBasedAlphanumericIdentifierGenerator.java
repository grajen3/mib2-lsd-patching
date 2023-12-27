/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id.serial;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.TimeZone;
import org.apache.commons.id.AbstractStringIdentifierGenerator;

public class TimeBasedAlphanumericIdentifierGenerator
extends AbstractStringIdentifierGenerator
implements Serializable {
    private static final long serialVersionUID;
    private static final char[] padding;
    private static final TimeZone UTC;
    private static long last;
    private static long counter;
    private final int postfixSize;
    private final long offset;

    public TimeBasedAlphanumericIdentifierGenerator(int n, long l) {
        if (n < 0 || n > MAX_LONG_ALPHANUMERIC_VALUE_LENGTH) {
            throw new IllegalArgumentException("Invalid size for postfix");
        }
        this.postfixSize = n;
        this.offset = l;
    }

    public TimeBasedAlphanumericIdentifierGenerator(int n) {
        this(n, 0L);
    }

    public TimeBasedAlphanumericIdentifierGenerator() {
        this(3);
    }

    @Override
    public long maxLength() {
        return MAX_LONG_ALPHANUMERIC_VALUE_LENGTH + this.postfixSize;
    }

    @Override
    public long minLength() {
        return this.maxLength();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public String nextStringIdentifier() {
        long l;
        long l2;
        Object object = this;
        synchronized (object) {
            l2 = Calendar.getInstance(UTC).getTime().getTime();
            l = l2 - last;
            if (l > 0L || l < -1000L) {
                last = l2;
                counter = 0L;
            } else {
                if (l != 0L) {
                    l2 = last;
                }
                ++counter;
            }
        }
        Object object2 = object = counter > 0L ? Long.toString(counter, 36) : "";
        if (((String)object).length() > this.postfixSize) {
            throw new IllegalStateException("The maximum number of identifiers in this millisecond has been reached");
        }
        l = l2 - this.offset;
        long l3 = l < 0L ? l + Long.MAX_VALUE + 1L : l;
        String string = Long.toString(l3, 36);
        char[] cArray = new char[MAX_LONG_ALPHANUMERIC_VALUE_LENGTH + this.postfixSize];
        int n = 0;
        int n2 = MAX_LONG_ALPHANUMERIC_VALUE_LENGTH - string.length();
        if (n2 > 0) {
            System.arraycopy((Object)padding, 0, (Object)cArray, 0, n2);
        }
        System.arraycopy((Object)string.toCharArray(), 0, (Object)cArray, n2, string.length());
        if (l < 0L) {
            cArray[0] = (char)(cArray[0] + 2);
        }
        n += string.length() + n2;
        if (this.postfixSize > 0) {
            n2 = this.postfixSize - ((String)object).length();
            if (n2 > 0) {
                System.arraycopy((Object)padding, 0, (Object)cArray, n, n2);
                n += n2;
            }
            System.arraycopy((Object)((String)object).toCharArray(), 0, (Object)cArray, n, ((String)object).length());
        }
        return new String(cArray);
    }

    public long getMillisecondsFromId(Object object, long l) {
        if (object instanceof String && object.toString().length() >= MAX_LONG_ALPHANUMERIC_VALUE_LENGTH) {
            boolean bl;
            char[] cArray = new char[MAX_LONG_ALPHANUMERIC_VALUE_LENGTH];
            System.arraycopy((Object)object.toString().toCharArray(), 0, (Object)cArray, 0, MAX_LONG_ALPHANUMERIC_VALUE_LENGTH);
            boolean bl2 = bl = cArray[0] > '1';
            if (bl) {
                cArray[0] = (char)(cArray[0] - 2);
            }
            long l2 = Long.parseLong(new String(cArray), 36);
            if (bl) {
                l2 -= Long.MIN_VALUE;
            }
            return l2 + l;
        }
        throw new IllegalArgumentException(new StringBuffer().append("'").append(object).append("' is not an id from this generator").toString());
    }

    static {
        padding = new char[MAX_LONG_ALPHANUMERIC_VALUE_LENGTH];
        Arrays.fill(padding, '0');
        UTC = TimeZone.getTimeZone("UTC");
        last = 0L;
        counter = 0L;
    }
}

