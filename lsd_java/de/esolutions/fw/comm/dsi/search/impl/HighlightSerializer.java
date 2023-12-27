/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.search.Highlight;

public class HighlightSerializer {
    public static void putOptionalHighlight(ISerializer iSerializer, Highlight highlight) {
        boolean bl = highlight == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = highlight.getHighlightStart();
            iSerializer.putInt32(n);
            int n2 = highlight.getHighlightEnd();
            iSerializer.putInt32(n2);
            int n3 = highlight.getType();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalHighlightVarArray(ISerializer iSerializer, Highlight[] highlightArray) {
        boolean bl = highlightArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(highlightArray.length);
            for (int i2 = 0; i2 < highlightArray.length; ++i2) {
                HighlightSerializer.putOptionalHighlight(iSerializer, highlightArray[i2]);
            }
        }
    }

    public static Highlight getOptionalHighlight(IDeserializer iDeserializer) {
        Highlight highlight = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            highlight = new Highlight();
            highlight.highlightStart = n3 = iDeserializer.getInt32();
            highlight.highlightEnd = n2 = iDeserializer.getInt32();
            highlight.type = n = iDeserializer.getInt32();
        }
        return highlight;
    }

    public static Highlight[] getOptionalHighlightVarArray(IDeserializer iDeserializer) {
        Highlight[] highlightArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            highlightArray = new Highlight[n];
            for (int i2 = 0; i2 < n; ++i2) {
                highlightArray[i2] = HighlightSerializer.getOptionalHighlight(iDeserializer);
            }
        }
        return highlightArray;
    }
}

