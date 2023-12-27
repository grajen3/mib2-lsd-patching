/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id.uuid.state;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.id.uuid.state.Node;
import org.apache.commons.id.uuid.state.ReadOnlyResourceStateImpl;
import org.apache.commons.id.uuid.state.State;
import org.apache.commons.id.uuid.state.StateHelper;

public class ReadWriteFileStateImpl
extends ReadOnlyResourceStateImpl
implements State {
    @Override
    public void store(Set set) {
        this.writeXML(this.genXML(set));
    }

    private String genXML(Set set) {
        Iterator iterator = set.iterator();
        StringBuffer stringBuffer = new StringBuffer(1024);
        stringBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n<!DOCTYPE uuidstate [\n   <!ELEMENT uuidstate (node*)>\n   <!ELEMENT node EMPTY>\n   <!ATTLIST node id ID #REQUIRED>\n   <!ATTLIST node clocksequence CDATA #IMPLIED>\n   <!ATTLIST node lasttimestamp CDATA #IMPLIED>\n]>\n<uuidstate synchInterval=\"");
        stringBuffer.append(this.getSynchInterval());
        stringBuffer.append("\">");
        while (iterator.hasNext()) {
            Node node = (Node)iterator.next();
            stringBuffer.append("\n\t<node id=\"");
            stringBuffer.append(StateHelper.encodeMACAddress(node.getNodeIdentifier()));
            stringBuffer.append("\" clocksequence=\"");
            stringBuffer.append(node.getClockSequence());
            stringBuffer.append("\" timestamp=\"");
            stringBuffer.append(node.getLastTimestamp());
            stringBuffer.append("\" />");
        }
        stringBuffer.append("\n</uuidstate>");
        return stringBuffer.toString();
    }

    private String genXML(Set set, long l) {
        Iterator iterator = set.iterator();
        StringBuffer stringBuffer = new StringBuffer(1024);
        stringBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n<!DOCTYPE uuidstate [\n   <!ELEMENT uuidstate (node*)>\n   <!ELEMENT node EMPTY>\n   <!ATTLIST node id ID #REQUIRED>\n   <!ATTLIST node clocksequence CDATA #IMPLIED>\n   <!ATTLIST node lasttimestamp CDATA #IMPLIED>\n]>\n<uuidstate synchInterval=\"");
        stringBuffer.append(this.getSynchInterval());
        stringBuffer.append("\">");
        while (iterator.hasNext()) {
            Node node = (Node)iterator.next();
            stringBuffer.append("\n\t<node id=\"");
            stringBuffer.append(StateHelper.encodeMACAddress(node.getNodeIdentifier()));
            stringBuffer.append("\" clocksequence=\"");
            stringBuffer.append(node.getClockSequence());
            stringBuffer.append("\" timestamp=\"");
            stringBuffer.append(l);
            stringBuffer.append("\" />");
        }
        stringBuffer.append("\n</uuidstate>");
        return stringBuffer.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void writeXML(String string) {
        File file;
        String string2 = System.getProperty("org.apache.commons.id.uuid.config.resource.filename");
        if (string2 == null) {
            return;
        }
        URL uRL = ClassLoader.getSystemResource(string2);
        if (uRL != null && (file = new File(uRL.getFile())) != null && file.canWrite()) {
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(file);
                fileWriter.write(string);
                fileWriter.close();
            }
            catch (IOException iOException) {
            }
            finally {
                try {
                    fileWriter.close();
                }
                catch (IOException iOException) {}
                fileWriter = null;
                file = null;
            }
        }
    }
}

