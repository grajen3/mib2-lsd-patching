/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id.uuid.state;

import org.apache.commons.id.uuid.state.Node;
import org.apache.commons.id.uuid.state.ReadOnlyResourceStateImpl;
import org.apache.commons.id.uuid.state.StateHelper;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

class ReadOnlyResourceStateImpl$StateConfigHandler
extends DefaultHandler {
    static final short UUID_STATE_TAG;
    static final String UUID_STATE_TAG_STR;
    static final String SYNCH_INTERVAL_STR;
    static final short NODE_TAG;
    static final String NODE_TAG_STR;
    static final String ATTR_ID_STR;
    static final String ATTR_CLOCKSEQ_STR;
    static final String ATTR_LASTIMESTAMP_STR;
    private final /* synthetic */ ReadOnlyResourceStateImpl this$0;

    ReadOnlyResourceStateImpl$StateConfigHandler(ReadOnlyResourceStateImpl readOnlyResourceStateImpl) {
        this.this$0 = readOnlyResourceStateImpl;
    }

    @Override
    public void startElement(String string, String string2, String string3, Attributes attributes) {
        int n = 0;
        String string4 = string2;
        if ("".equals(string2)) {
            string4 = string3;
        }
        if (string4.equalsIgnoreCase("uuidstate")) {
            n = 1;
        } else if (string4.equalsIgnoreCase("node")) {
            n = 2;
        }
        if (attributes != null) {
            switch (n) {
                case 1: {
                    this.processBodyTag(attributes);
                    break;
                }
                case 2: {
                    this.processNodeTag(attributes);
                    break;
                }
            }
        }
    }

    private void processBodyTag(Attributes attributes) {
        for (int i2 = 0; i2 < attributes.getLength(); ++i2) {
            String string = attributes.getLocalName(i2);
            if ("".equals(string)) {
                string = attributes.getQName(i2);
            }
            String string2 = attributes.getValue(i2);
            if (!string.equalsIgnoreCase("synchinterval")) continue;
            try {
                ReadOnlyResourceStateImpl.synchronizeInterval = Long.parseLong(string2);
                continue;
            }
            catch (NumberFormatException numberFormatException) {
                ReadOnlyResourceStateImpl.synchronizeInterval = 0L;
            }
        }
    }

    private void processNodeTag(Attributes attributes) {
        byte[] byArray = null;
        long l = 0L;
        short s = 0;
        for (int i2 = 0; i2 < attributes.getLength(); ++i2) {
            String string = attributes.getLocalName(i2);
            if ("".equals(string)) {
                string = attributes.getQName(i2);
            }
            String string2 = attributes.getValue(i2);
            if (string.equalsIgnoreCase("id")) {
                byArray = StateHelper.decodeMACAddress(string2);
                continue;
            }
            if (string.equalsIgnoreCase("clocksequence")) {
                try {
                    s = Short.parseShort(string2);
                }
                catch (NumberFormatException numberFormatException) {
                    s = 0;
                }
                continue;
            }
            if (!string.equalsIgnoreCase("timestamp")) continue;
            try {
                l = Long.parseLong(string2);
                continue;
            }
            catch (NumberFormatException numberFormatException) {
                l = 0L;
            }
        }
        if (byArray != null) {
            if (s != 0) {
                ReadOnlyResourceStateImpl.nodes.add(new Node(byArray, l, s));
            } else {
                ReadOnlyResourceStateImpl.nodes.add(new Node(byArray));
            }
        }
    }
}

