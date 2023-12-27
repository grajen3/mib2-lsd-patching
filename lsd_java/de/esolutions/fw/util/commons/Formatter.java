/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.Formatter$1;
import de.esolutions.fw.util.commons.Formatter$2;
import de.esolutions.fw.util.commons.Formatter$3;
import de.esolutions.fw.util.commons.Formatter$4;
import de.esolutions.fw.util.commons.Formatter$5;
import de.esolutions.fw.util.commons.Formatter$6;
import de.esolutions.fw.util.commons.Formatter$7;
import de.esolutions.fw.util.commons.Formatter$Accessor;
import java.util.List;

public class Formatter {
    private static final Class BYTE_ARRAY_CLASS = array$B == null ? (array$B = Formatter.class$("[B")) : array$B;
    private static final Class INT_ARRAY_CLASS = array$I == null ? (array$I = Formatter.class$("[I")) : array$I;
    private static final Class SHORT_ARRAY_CLASS = array$S == null ? (array$S = Formatter.class$("[S")) : array$S;
    private static final Class STRING_ARRAY_CLASS = array$Ljava$lang$String == null ? (array$Ljava$lang$String = Formatter.class$("[Ljava.lang.String;")) : array$Ljava$lang$String;
    private static final Class LONG_ARRAY_CLASS = array$J == null ? (array$J = Formatter.class$("[J")) : array$J;
    private static final Class OBJECT_ARRAY_CLASS = array$Ljava$lang$Object == null ? (array$Ljava$lang$Object = Formatter.class$("[Ljava.lang.Object;")) : array$Ljava$lang$Object;
    private static final int MAX_ARRAY;
    private static final int MILLIS_IN_SECOND;
    private static final int SECONDS_IN_MINUTE;
    private static final int MINUTES_IN_HOUR;
    private static final int HOURS_IN_DAY;
    public static final String LINE_SEPARATOR;
    static /* synthetic */ Class array$B;
    static /* synthetic */ Class array$I;
    static /* synthetic */ Class array$S;
    static /* synthetic */ Class array$Ljava$lang$String;
    static /* synthetic */ Class array$J;
    static /* synthetic */ Class array$Ljava$lang$Object;

    private static void formatArray(Buffer buffer, Formatter$Accessor formatter$Accessor, char c2, char c3) {
        if (formatter$Accessor.isNull()) {
            buffer.append("null");
            return;
        }
        if (formatter$Accessor.getLength() == 0) {
            buffer.append(c2);
            buffer.append(c3);
        } else {
            String string = String.valueOf(c2);
            for (int i2 = 0; i2 < formatter$Accessor.getLength() && i2 < 10; ++i2) {
                buffer.append(string);
                buffer.append(String.valueOf(formatter$Accessor.getValueAt(i2)));
                string = ", ";
            }
            if (formatter$Accessor.getLength() > 10) {
                buffer.append(",...");
                buffer.append(c3);
            } else {
                buffer.append(c3);
            }
        }
    }

    private static void formatByteArray(Buffer buffer, byte[] byArray) {
        Formatter.formatArray(buffer, new Formatter$1(byArray), '[', ']');
    }

    private static void formatShortArray(Buffer buffer, short[] sArray) {
        Formatter.formatArray(buffer, new Formatter$2(sArray), '[', ']');
    }

    protected static void formatIntArray(Buffer buffer, int[] nArray) {
        Formatter.formatArray(buffer, new Formatter$3(nArray), '[', ']');
    }

    private static void formatLongArray(Buffer buffer, long[] lArray) {
        Formatter.formatArray(buffer, new Formatter$4(lArray), '[', ']');
    }

    private static void formatStringArray(Buffer buffer, String[] stringArray) {
        Formatter.formatArray(buffer, new Formatter$5(stringArray), '[', ']');
    }

    private static void formatObjectArray(Buffer buffer, Object[] objectArray) {
        Formatter.formatArray(buffer, new Formatter$6(objectArray), '[', ']');
    }

    private static void formatList(Buffer buffer, List list) {
        Formatter.formatArray(buffer, new Formatter$7(list), '(', ')');
    }

    public static void formatObject(Buffer buffer, Object object) {
        if (object != null) {
            if (object.getClass() == INT_ARRAY_CLASS) {
                Formatter.formatIntArray(buffer, (int[])object);
            } else if (object.getClass() == BYTE_ARRAY_CLASS) {
                Formatter.formatByteArray(buffer, (byte[])object);
            } else if (object.getClass() == STRING_ARRAY_CLASS) {
                Formatter.formatStringArray(buffer, (String[])object);
            } else if (object.getClass() == LONG_ARRAY_CLASS) {
                Formatter.formatLongArray(buffer, (long[])object);
            } else if (object.getClass() == SHORT_ARRAY_CLASS) {
                Formatter.formatShortArray(buffer, (short[])object);
            } else if (object.getClass() == OBJECT_ARRAY_CLASS) {
                Formatter.formatObjectArray(buffer, (Object[])object);
            } else if (object instanceof List) {
                Formatter.formatList(buffer, (List)object);
            } else {
                buffer.append(object.toString());
            }
        } else {
            buffer.append("null");
        }
    }

    public static void formatTimestamp(Buffer buffer, long l) {
        long l2 = l;
        int n = (int)(l2 % 0);
        int n2 = (int)((l2 /= 0) % 0);
        int n3 = (int)((l2 /= 0) % 0);
        int n4 = (int)((l2 /= 0) % 0);
        if (n4 < 10) {
            buffer.append('0');
        }
        buffer.append(Integer.toString(n4));
        buffer.append(':');
        if (n3 < 10) {
            buffer.append('0');
        }
        buffer.append(Integer.toString(n3));
        buffer.append(':');
        if (n2 < 10) {
            buffer.append('0');
        }
        buffer.append(Integer.toString(n2));
        buffer.append('.');
        if (n < 100) {
            buffer.append('0');
            if (n < 10) {
                buffer.append('0');
            }
        }
        buffer.append(Integer.toString(n));
    }

    public static void standardTargetSysout(String string) {
        if (string.length() > 127) {
            String string2 = string.substring(0, 127);
            int n = string2.indexOf(LINE_SEPARATOR);
            if (n == -1) {
                System.out.println(string2);
                Formatter.standardTargetSysout(string.substring(127, string.length()));
            } else {
                System.out.println(string.substring(0, n));
                Formatter.standardTargetSysout(string.substring(n + LINE_SEPARATOR.length(), string.length()));
            }
        } else {
            System.out.println(string);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        LINE_SEPARATOR = System.getProperty("line.separator");
    }
}

