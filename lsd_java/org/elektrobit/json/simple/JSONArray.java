/*
 * Decompiled with CFR 0.152.
 */
package org.elektrobit.json.simple;

import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.elektrobit.json.simple.JSONAware;
import org.elektrobit.json.simple.JSONStreamAware;
import org.elektrobit.json.simple.JSONValue;

public class JSONArray
extends ArrayList
implements List,
JSONAware,
JSONStreamAware {
    private static final long serialVersionUID;

    public static void writeJSONString(List list, Writer writer) {
        if (list == null) {
            writer.write("null");
            return;
        }
        boolean bl = true;
        Iterator iterator = list.iterator();
        writer.write(91);
        while (iterator.hasNext()) {
            if (bl) {
                bl = false;
            } else {
                writer.write(44);
            }
            Object object = iterator.next();
            if (object == null) {
                writer.write("null");
                continue;
            }
            JSONValue.writeJSONString(object, writer);
        }
        writer.write(93);
    }

    @Override
    public void writeJSONString(Writer writer) {
        JSONArray.writeJSONString(this, writer);
    }

    public static String toJSONString(List list) {
        if (list == null) {
            return "null";
        }
        boolean bl = true;
        StringBuffer stringBuffer = new StringBuffer();
        Iterator iterator = list.iterator();
        stringBuffer.append('[');
        while (iterator.hasNext()) {
            if (bl) {
                bl = false;
            } else {
                stringBuffer.append(',');
            }
            Object object = iterator.next();
            if (object == null) {
                stringBuffer.append("null");
                continue;
            }
            stringBuffer.append(JSONValue.toJSONString(object));
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    @Override
    public String toJSONString() {
        return JSONArray.toJSONString(this);
    }

    @Override
    public String toString() {
        return this.toJSONString();
    }
}

