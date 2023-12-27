/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package org.json.simple;

import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;
import org.json.simple.parser.JSONParser;

public class JSONValue {
    public static Object parse(Reader reader) {
        try {
            JSONParser jSONParser = new JSONParser();
            return jSONParser.parse(reader);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static Object parse(String string) {
        StringReader stringReader = new StringReader(string);
        return JSONValue.parse(stringReader);
    }

    public static Object parseWithException(Reader reader) {
        JSONParser jSONParser = new JSONParser();
        return jSONParser.parse(reader);
    }

    public static Object parseWithException(String string) {
        JSONParser jSONParser = new JSONParser();
        return jSONParser.parse(string);
    }

    public static void writeJSONString(Object object, Writer writer) {
        if (object == null) {
            writer.write("null");
            return;
        }
        if (object instanceof String) {
            writer.write(34);
            writer.write(JSONValue.escape((String)object));
            writer.write(34);
            return;
        }
        if (object instanceof Double) {
            if (((Double)object).isInfinite() || ((Double)object).isNaN()) {
                writer.write("null");
            } else {
                writer.write(object.toString());
            }
            return;
        }
        if (object instanceof Float) {
            if (((Float)object).isInfinite() || ((Float)object).isNaN()) {
                writer.write("null");
            } else {
                writer.write(object.toString());
            }
            return;
        }
        if (object instanceof Number) {
            writer.write(object.toString());
            return;
        }
        if (object instanceof Boolean) {
            writer.write(object.toString());
            return;
        }
        if (object instanceof JSONStreamAware) {
            ((JSONStreamAware)object).writeJSONString(writer);
            return;
        }
        if (object instanceof JSONAware) {
            writer.write(((JSONAware)object).toJSONString());
            return;
        }
        if (object instanceof Map) {
            JSONObject.writeJSONString((Map)object, writer);
            return;
        }
        if (object instanceof List) {
            JSONArray.writeJSONString((List)object, writer);
            return;
        }
        writer.write(object.toString());
    }

    public static String toJSONString(Object object) {
        if (object == null) {
            return "null";
        }
        if (object instanceof String) {
            return new StringBuffer().append("\"").append(JSONValue.escape((String)object)).append("\"").toString();
        }
        if (object instanceof Double) {
            if (((Double)object).isInfinite() || ((Double)object).isNaN()) {
                return "null";
            }
            return object.toString();
        }
        if (object instanceof Float) {
            if (((Float)object).isInfinite() || ((Float)object).isNaN()) {
                return "null";
            }
            return object.toString();
        }
        if (object instanceof Number) {
            return object.toString();
        }
        if (object instanceof Boolean) {
            return object.toString();
        }
        if (object instanceof JSONAware) {
            return ((JSONAware)object).toJSONString();
        }
        if (object instanceof Map) {
            return JSONObject.toJSONString((Map)object);
        }
        if (object instanceof List) {
            return JSONArray.toJSONString((List)object);
        }
        return object.toString();
    }

    public static String escape(String string) {
        if (string == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        JSONValue.escape(string, stringBuffer);
        return stringBuffer.toString();
    }

    static void escape(String string, StringBuffer stringBuffer) {
        block10: for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            switch (c2) {
                case '\"': {
                    stringBuffer.append("\\\"");
                    continue block10;
                }
                case '\\': {
                    stringBuffer.append("\\\\");
                    continue block10;
                }
                case '\b': {
                    stringBuffer.append("\\b");
                    continue block10;
                }
                case '\f': {
                    stringBuffer.append("\\f");
                    continue block10;
                }
                case '\n': {
                    stringBuffer.append("\\n");
                    continue block10;
                }
                case '\r': {
                    stringBuffer.append("\\r");
                    continue block10;
                }
                case '\t': {
                    stringBuffer.append("\\t");
                    continue block10;
                }
                case '/': {
                    stringBuffer.append("\\/");
                    continue block10;
                }
                default: {
                    if (c2 >= '\u0000' && c2 <= '\u001f' || c2 >= '\u007f' && c2 <= '\u009f' || c2 >= '\u2000' && c2 <= '\u20ff') {
                        String string2 = Integer.toHexString(c2);
                        stringBuffer.append("\\u");
                        for (int i3 = 0; i3 < 4 - string2.length(); ++i3) {
                            stringBuffer.append('0');
                        }
                        stringBuffer.append(string2.toUpperCase());
                        continue block10;
                    }
                    stringBuffer.append(c2);
                }
            }
        }
    }
}

