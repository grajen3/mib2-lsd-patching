/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.traceme;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.StringUtils;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TraceMe {
    public static int TRACE = 0;
    public static int DEBUG = 1;
    public static int INFO = 2;
    public static int WARN = 3;
    public static int ERROR = 4;
    public static int FATAL = 5;
    public static int OFF = 6;
    public static String[] levelNames = new String[]{"trace", "debug", "info ", "Warn ", "Error", "FATAL", " OFF "};
    private static boolean enabled = false;
    private static Writer writer;
    private static int filterLevel;

    public static void init() {
        if (enabled) {
            return;
        }
        TraceMe.enable(System.getProperty("ipl.traceme"));
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static void enable(String string) {
        String string2;
        enabled = true;
        filterLevel = WARN;
        if (string != null) {
            string = string.toLowerCase();
            for (int i2 = 0; i2 < levelNames.length; ++i2) {
                if (levelNames[i2].toLowerCase().indexOf(string) == -1) continue;
                filterLevel = i2;
                break;
            }
        }
        if ((string2 = System.getProperty("ipl.traceme.file")) != null) {
            try {
                writer = new OutputStreamWriter(new FileOutputStream(string2, false), "UTF-8");
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
        TraceMe.msg(INFO, "traceMe enabled, filter level: %1", levelNames[filterLevel]);
    }

    public static void disable() {
        enabled = false;
        if (writer != null) {
            try {
                writer.close();
            }
            catch (IOException iOException) {
                // empty catch block
            }
            writer = null;
        }
    }

    private static void write(int n, String string, String string2, Object[] objectArray) {
        Buffer buffer = new Buffer(128);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
        buffer.append(simpleDateFormat.format(new Date(System.currentTimeMillis())));
        buffer.append(" TC ");
        buffer.append(levelNames[n]);
        buffer.append("  ");
        buffer.append(string);
        buffer.append("  ");
        if (objectArray != null) {
            StringUtils.expandArgStringToBuffer(string2, objectArray, buffer);
        } else {
            buffer.append(string2);
        }
        if (writer != null) {
            buffer.append("\n");
            try {
                writer.write(buffer.toString());
            }
            catch (IOException iOException) {
                writer = null;
                System.out.println(buffer.toString());
            }
        } else {
            System.out.println(buffer.toString());
        }
    }

    public static void msg(int n, String string, String string2) {
        if (n >= filterLevel) {
            TraceMe.write(n, string, string2, null);
        }
    }

    public static void msg(int n, String string, String string2, Object object) {
        if (n >= filterLevel) {
            TraceMe.write(n, string, string2, new Object[]{object});
        }
    }

    public static void msg(int n, String string, String string2, Object object, Object object2) {
        if (n >= filterLevel) {
            TraceMe.write(n, string, string2, new Object[]{object, object2});
        }
    }

    public static void msg(int n, String string, String string2, Object object, Object object2, Object object3) {
        if (n >= filterLevel) {
            TraceMe.write(n, string, string2, new Object[]{object, object2, object3});
        }
    }

    public static void msg(int n, String string, String string2, Object object, Object object2, Object object3, Object object4) {
        if (n >= filterLevel) {
            TraceMe.write(n, string, string2, new Object[]{object, object2, object3, object4});
        }
    }

    public static void msg(int n, String string, String string2, Object object, Object object2, Object object3, Object object4, Object object5) {
        if (n >= filterLevel) {
            TraceMe.write(n, string, string2, new Object[]{object, object2, object3, object4, object5});
        }
    }

    public static void msg(int n, String string, String string2, Object object, Object object2, Object object3, Object object4, Object object5, Object object6) {
        if (n >= filterLevel) {
            TraceMe.write(n, string, string2, new Object[]{object, object2, object3, object4, object5, object6});
        }
    }

    public static void msg(int n, String string, String string2, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7) {
        if (n >= filterLevel) {
            TraceMe.write(n, string, string2, new Object[]{object, object2, object3, object4, object5, object6, object7});
        }
    }

    static {
        filterLevel = OFF;
    }
}

