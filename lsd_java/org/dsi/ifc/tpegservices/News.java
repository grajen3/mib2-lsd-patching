/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tpegservices;

import org.dsi.ifc.global.DateTime;

public class News {
    public String newsHeadliner;
    public DateTime timestamp;
    public int contentId;
    public String newsHeadline;
    public String newsText;

    public News() {
    }

    public News(String string, DateTime dateTime, int n, String string2, String string3) {
        this.newsHeadliner = string;
        this.timestamp = dateTime;
        this.contentId = n;
        this.newsHeadline = string2;
        this.newsText = string3;
    }

    public String getNewsHeadliner() {
        return this.newsHeadliner;
    }

    public DateTime getTimestamp() {
        return this.timestamp;
    }

    public int getContentId() {
        return this.contentId;
    }

    public String getNewsHeadline() {
        return this.newsHeadline;
    }

    public String getNewsText() {
        return this.newsText;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1350);
        stringBuffer.append("News");
        stringBuffer.append('(');
        stringBuffer.append("newsHeadliner");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.newsHeadliner);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("timestamp");
        stringBuffer.append('=');
        stringBuffer.append(this.timestamp);
        stringBuffer.append(',');
        stringBuffer.append("contentId");
        stringBuffer.append('=');
        stringBuffer.append(this.contentId);
        stringBuffer.append(',');
        stringBuffer.append("newsHeadline");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.newsHeadline);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("newsText");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.newsText);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

