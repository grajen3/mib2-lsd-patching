/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id.uuid.state;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.apache.commons.id.uuid.state.ReadOnlyResourceStateImpl$StateConfigHandler;
import org.apache.commons.id.uuid.state.State;
import org.xml.sax.helpers.DefaultHandler;

public class ReadOnlyResourceStateImpl
implements State {
    static long synchronizeInterval = Long.MAX_VALUE;
    static HashSet nodes = new HashSet();
    public static final String CONFIG_FILENAME_KEY;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void load() {
        String string = System.getProperty("org.apache.commons.id.uuid.config.resource.filename");
        if (string == null) {
            throw new IllegalStateException("No value set for system property: org.apache.commons.id.uuid.config.resource.filename");
        }
        InputStream inputStream = null;
        try {
            inputStream = ClassLoader.getSystemResourceAsStream(string);
            if (inputStream == null) {
                throw new IllegalStateException(new StringBuffer().append(string).append(" loaded as system resource is null").toString());
            }
            this.parse(inputStream);
        }
        finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                }
                catch (IOException iOException) {}
            }
        }
    }

    @Override
    public long getSynchInterval() {
        return Long.MAX_VALUE;
    }

    @Override
    public Set getNodes() {
        return nodes;
    }

    @Override
    public void store(Set set) {
    }

    @Override
    public void store(Set set, long l) {
    }

    protected void parse(InputStream inputStream) {
        ReadOnlyResourceStateImpl$StateConfigHandler readOnlyResourceStateImpl$StateConfigHandler = new ReadOnlyResourceStateImpl$StateConfigHandler(this);
        SAXParserFactory sAXParserFactory = SAXParserFactory.newInstance();
        sAXParserFactory.setValidating(true);
        SAXParser sAXParser = sAXParserFactory.newSAXParser();
        sAXParser.parse(inputStream, (DefaultHandler)readOnlyResourceStateImpl$StateConfigHandler);
    }
}

