/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tpegservices.impl;

import de.esolutions.fw.comm.dsi.tpegservices.impl.NewsSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.tpegservices.News;
import org.dsi.ifc.tpegservices.NewsCategory;

public class NewsCategorySerializer {
    public static void putOptionalNewsCategory(ISerializer iSerializer, NewsCategory newsCategory) {
        boolean bl = newsCategory == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = newsCategory.getContentId();
            iSerializer.putInt32(n);
            int n2 = newsCategory.getNewsType();
            iSerializer.putInt32(n2);
            News[] newsArray = newsCategory.getNews();
            NewsSerializer.putOptionalNewsVarArray(iSerializer, newsArray);
        }
    }

    public static void putOptionalNewsCategoryVarArray(ISerializer iSerializer, NewsCategory[] newsCategoryArray) {
        boolean bl = newsCategoryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(newsCategoryArray.length);
            for (int i2 = 0; i2 < newsCategoryArray.length; ++i2) {
                NewsCategorySerializer.putOptionalNewsCategory(iSerializer, newsCategoryArray[i2]);
            }
        }
    }

    public static NewsCategory getOptionalNewsCategory(IDeserializer iDeserializer) {
        NewsCategory newsCategory = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            newsCategory = new NewsCategory();
            newsCategory.contentId = n2 = iDeserializer.getInt32();
            newsCategory.newsType = n = iDeserializer.getInt32();
            News[] newsArray = NewsSerializer.getOptionalNewsVarArray(iDeserializer);
            newsCategory.news = newsArray;
        }
        return newsCategory;
    }

    public static NewsCategory[] getOptionalNewsCategoryVarArray(IDeserializer iDeserializer) {
        NewsCategory[] newsCategoryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            newsCategoryArray = new NewsCategory[n];
            for (int i2 = 0; i2 < n; ++i2) {
                newsCategoryArray[i2] = NewsCategorySerializer.getOptionalNewsCategory(iDeserializer);
            }
        }
        return newsCategoryArray;
    }
}

