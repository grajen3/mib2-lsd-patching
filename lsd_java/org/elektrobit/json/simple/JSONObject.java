/*
 * Decompiled with CFR 0.152.
 */
package org.elektrobit.json.simple;

import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import org.elektrobit.json.simple.JSONAware;
import org.elektrobit.json.simple.JSONStreamAware;
import org.elektrobit.json.simple.JSONValue;

public class JSONObject
extends HashMap
implements Map,
JSONAware,
JSONStreamAware {
    private static final long serialVersionUID;

    public static void writeJSONString(Map map, Writer writer) {
        if (map == null) {
            writer.write("null");
            return;
        }
        boolean bl = true;
        Iterator iterator = map.entrySet().iterator();
        writer.write(123);
        while (iterator.hasNext()) {
            if (bl) {
                bl = false;
            } else {
                writer.write(44);
            }
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            writer.write(34);
            writer.write(JSONObject.escape(String.valueOf(map$Entry.getKey())));
            writer.write(34);
            writer.write(58);
            JSONValue.writeJSONString(map$Entry.getValue(), writer);
        }
        writer.write(125);
    }

    @Override
    public void writeJSONString(Writer writer) {
        JSONObject.writeJSONString(this, writer);
    }

    public static String toJSONString(Map map) {
        if (map == null) {
            return "null";
        }
        StringBuffer stringBuffer = new StringBuffer();
        boolean bl = true;
        Iterator iterator = map.entrySet().iterator();
        stringBuffer.append('{');
        while (iterator.hasNext()) {
            if (bl) {
                bl = false;
            } else {
                stringBuffer.append(',');
            }
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            JSONObject.toJSONString(String.valueOf(map$Entry.getKey()), map$Entry.getValue(), stringBuffer);
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    @Override
    public String toJSONString() {
        return JSONObject.toJSONString(this);
    }

    private static String toJSONString(String string, Object object, StringBuffer stringBuffer) {
        stringBuffer.append('\"');
        if (string == null) {
            stringBuffer.append("null");
        } else {
            JSONValue.escape(string, stringBuffer);
        }
        stringBuffer.append('\"').append(':');
        stringBuffer.append(JSONValue.toJSONString(object));
        return stringBuffer.toString();
    }

    @Override
    public String toString() {
        return this.toJSONString();
    }

    public static String toString(String string, Object object) {
        StringBuffer stringBuffer = new StringBuffer();
        JSONObject.toJSONString(string, object, stringBuffer);
        return stringBuffer.toString();
    }

    public static String escape(String string) {
        return JSONValue.escape(string);
    }
}

