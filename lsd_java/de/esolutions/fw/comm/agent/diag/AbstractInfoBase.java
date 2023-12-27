/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.diag;

import de.esolutions.fw.comm.agent.diag.AbstractInfoBase$1;
import de.esolutions.fw.comm.agent.diag.IInfoBase;
import de.esolutions.fw.comm.agent.diag.InfoEntry;
import de.esolutions.fw.comm.agent.diag.InfoStream;
import de.esolutions.fw.util.tracing.util.TraceTimeStamp;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class AbstractInfoBase
implements IInfoBase {
    private final int id;
    private final long timestamp;

    public AbstractInfoBase(int n) {
        this.id = n;
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public long getTimeStamp() {
        return this.timestamp;
    }

    public String getTimeStampString() {
        return new TraceTimeStamp(this.timestamp).toUTCTimeString(true);
    }

    protected String convertTimeStampField(Object object) {
        if (object instanceof Long) {
            long l = (Long)object;
            if (l == 0L) {
                return null;
            }
            TraceTimeStamp traceTimeStamp = new TraceTimeStamp(l);
            return traceTimeStamp.toUTCTimeString(true);
        }
        return null;
    }

    protected Object fieldValueToObject(Field field) {
        Class clazz = field.getType();
        String string = clazz.getName();
        if (clazz.isPrimitive()) {
            if ("short".equals(string)) {
                return new Short(field.getShort(this));
            }
            if ("int".equals(string)) {
                return new Integer(field.getInt(this));
            }
            if ("boolean".equals(string)) {
                return new Boolean(field.getBoolean(this));
            }
            if ("long".equals(string)) {
                return new Long(field.getLong(this));
            }
            return null;
        }
        return field.get(this);
    }

    @Override
    public InfoEntry[] getEntries() {
        try {
            Field[] fieldArray = super.getClass().getFields();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < fieldArray.length; ++i2) {
                Field field = fieldArray[i2];
                String string = field.getName();
                Object object = this.fieldValueToObject(field);
                InfoEntry infoEntry = new InfoEntry(string, object);
                arrayList.add(infoEntry);
            }
            Object[] objectArray = new InfoEntry[arrayList.size()];
            arrayList.toArray(objectArray);
            return objectArray;
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            noClassDefFoundError.printStackTrace();
            return null;
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
            return null;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            illegalArgumentException.printStackTrace();
            return null;
        }
    }

    @Override
    public InfoEntry[] getSortedEntries() {
        Object[] objectArray = this.getEntries();
        if (objectArray == null) {
            return null;
        }
        Arrays.sort(objectArray, new AbstractInfoBase$1(this));
        return objectArray;
    }

    @Override
    public String getSimpleClassName() {
        String string = super.getClass().getName();
        int n = string.lastIndexOf(46);
        if (n != -1) {
            string = string.substring(n + 1);
        }
        if (string.endsWith("Info")) {
            string = string.substring(0, string.length() - 4);
        }
        return string;
    }

    @Override
    public void write(InfoStream infoStream) {
        if (infoStream.isBrief()) {
            this.doBrief(infoStream);
        } else {
            this.doWrite(infoStream);
        }
    }

    private void doWrite(InfoStream infoStream) {
        InfoEntry[] infoEntryArray = this.getSortedEntries();
        infoStream.begin(new StringBuffer().append(this.getSimpleClassName()).append(": #").append(this.getID()).append("  @").append(this.getTimeStampString()).toString());
        for (int i2 = 0; i2 < infoEntryArray.length; ++i2) {
            InfoEntry infoEntry = infoEntryArray[i2];
            String string = infoEntry.getName();
            infoStream.print(string, infoEntry.getValueString());
        }
        infoStream.end();
    }

    private void doBrief(InfoStream infoStream) {
        String string = this.getSimpleClassName();
        if (string.length() > 4) {
            string = string.substring(0, 4);
        }
        infoStream.begin(new StringBuffer().append(string).append("#").append(this.getID()).toString());
        InfoEntry[] infoEntryArray = this.getEntries();
        for (int i2 = 0; i2 < infoEntryArray.length; ++i2) {
            InfoEntry infoEntry = infoEntryArray[i2];
            String string2 = new StringBuffer().append(i2).append("=").toString();
            Object object = infoEntry.getValue();
            if (object == null) continue;
            String string3 = this.strip(infoEntry.getValueString());
            infoStream.print(string2, string3);
        }
        infoStream.end();
    }

    private String strip(String string) {
        String[] stringArray = new String[]{"de.esolutions.fw.", "org.dsi.ifc."};
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            String string2;
            int n = string.indexOf(stringArray[i2]);
            if (n == -1) continue;
            string = string2 = new StringBuffer().append(string.substring(0, n)).append(string.substring(n + stringArray[i2].length(), string.length())).toString();
        }
        return string.trim();
    }
}

