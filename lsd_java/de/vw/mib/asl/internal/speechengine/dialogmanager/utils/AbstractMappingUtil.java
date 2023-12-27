/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.utils;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import java.lang.reflect.Field;

public class AbstractMappingUtil {
    private IntObjectMap states;
    private Class claz;
    private String clazName;

    public AbstractMappingUtil(Class clazz) {
        this.claz = clazz;
    }

    private void initMapping() {
        this.states = new IntObjectOptHashMap();
        this.clazName = this.claz.getName().substring(this.claz.getName().lastIndexOf(".") + 1);
        Field[] fieldArray = this.claz.getFields();
        for (int i2 = 0; i2 < fieldArray.length; ++i2) {
            try {
                int n = fieldArray[i2].getInt(this.claz);
                String string = fieldArray[i2].getName();
                this.states.put(n, this.toReadable(this.clazName, string, n));
                continue;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                continue;
            }
            catch (IllegalAccessException illegalAccessException) {
                // empty catch block
            }
        }
    }

    private String toReadable(String string, String string2, int n) {
        StringBuffer stringBuffer = new StringBuffer(string);
        stringBuffer.append(".");
        stringBuffer.append(string2);
        stringBuffer.append("[");
        stringBuffer.append(n);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public String toString(int n) {
        if (this.states == null) {
            if (this.claz == null) {
                return "INVALID_MAPPING_INITIALIZATION";
            }
            this.initMapping();
        }
        if (this.states.containsKey(n)) {
            return (String)this.states.get(n);
        }
        return this.toReadable(this.clazName, "UNKNOWN", n);
    }
}

