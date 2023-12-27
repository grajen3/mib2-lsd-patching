/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tpegservices;

import org.dsi.ifc.tpegservices.News;

public class NewsCategory {
    public int contentId;
    public int newsType;
    public News[] news;

    public NewsCategory() {
        this.contentId = 0;
        this.newsType = 0;
        this.news = null;
    }

    public NewsCategory(int n, int n2, News[] newsArray) {
        this.contentId = n;
        this.newsType = n2;
        this.news = newsArray;
    }

    public int getContentId() {
        return this.contentId;
    }

    public int getNewsType() {
        return this.newsType;
    }

    public News[] getNews() {
        return this.news;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("NewsCategory");
        stringBuffer.append('(');
        stringBuffer.append("contentId");
        stringBuffer.append('=');
        stringBuffer.append(this.contentId);
        stringBuffer.append(',');
        stringBuffer.append("newsType");
        stringBuffer.append('=');
        stringBuffer.append(this.newsType);
        stringBuffer.append(',');
        stringBuffer.append("news");
        stringBuffer.append('[');
        if (this.news != null) {
            stringBuffer.append(this.news.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.news != null) {
            int n = this.news.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.news[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.news);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

