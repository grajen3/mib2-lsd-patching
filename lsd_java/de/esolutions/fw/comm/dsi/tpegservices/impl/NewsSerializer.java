/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tpegservices.impl;

import de.esolutions.fw.comm.dsi.global.impl.DateTimeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.tpegservices.News;

public class NewsSerializer {
    public static void putOptionalNews(ISerializer iSerializer, News news) {
        boolean bl = news == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = news.getNewsHeadliner();
            iSerializer.putOptionalString(string);
            DateTime dateTime = news.getTimestamp();
            DateTimeSerializer.putOptionalDateTime(iSerializer, dateTime);
            int n = news.getContentId();
            iSerializer.putInt32(n);
            String string2 = news.getNewsHeadline();
            iSerializer.putOptionalString(string2);
            String string3 = news.getNewsText();
            iSerializer.putOptionalString(string3);
        }
    }

    public static void putOptionalNewsVarArray(ISerializer iSerializer, News[] newsArray) {
        boolean bl = newsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(newsArray.length);
            for (int i2 = 0; i2 < newsArray.length; ++i2) {
                NewsSerializer.putOptionalNews(iSerializer, newsArray[i2]);
            }
        }
    }

    public static News getOptionalNews(IDeserializer iDeserializer) {
        News news = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            int n;
            DateTime dateTime;
            String string3;
            news = new News();
            news.newsHeadliner = string3 = iDeserializer.getOptionalString();
            news.timestamp = dateTime = DateTimeSerializer.getOptionalDateTime(iDeserializer);
            news.contentId = n = iDeserializer.getInt32();
            news.newsHeadline = string2 = iDeserializer.getOptionalString();
            news.newsText = string = iDeserializer.getOptionalString();
        }
        return news;
    }

    public static News[] getOptionalNewsVarArray(IDeserializer iDeserializer) {
        News[] newsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            newsArray = new News[n];
            for (int i2 = 0; i2 < n; ++i2) {
                newsArray[i2] = NewsSerializer.getOptionalNews(iDeserializer);
            }
        }
        return newsArray;
    }
}

