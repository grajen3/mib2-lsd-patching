/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.esolutions.fw.util.config.writer;

import de.esolutions.fw.util.commons.StringUtils;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.model.ConfigArray;
import de.esolutions.fw.util.config.model.ConfigDictionary;
import de.esolutions.fw.util.config.writer.IConfigExporter;
import de.esolutions.fw.util.config.writer.IConfigWriter;
import de.esolutions.fw.util.config.writer.WriteConfigException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class JSONConfigWriter
implements IConfigWriter,
IConfigExporter {
    private PrintStream ps;
    private int indent;
    private boolean needNewLine;
    private boolean needIndent;

    @Override
    public void writeToOutputStream(OutputStream outputStream, ConfigValue configValue, ConfigDictionary configDictionary) {
        try {
            this.ps = new PrintStream(outputStream, true, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            WriteConfigException writeConfigException = new WriteConfigException(unsupportedEncodingException.getMessage());
            throw writeConfigException;
        }
        this.indent = 0;
        this.needIndent = true;
        this.needNewLine = false;
        configValue.export(this);
        this.flush();
    }

    private void writeToken(String string, boolean bl) {
        if (this.needNewLine) {
            this.ps.println("");
            this.needNewLine = false;
        }
        if (this.needIndent) {
            for (int i2 = 0; i2 < this.indent; ++i2) {
                this.ps.print(' ');
            }
            this.needIndent = false;
        }
        this.ps.print(string);
        if (bl) {
            this.needIndent = true;
            this.needNewLine = true;
        }
    }

    private void appendToken(String string) {
        this.ps.print(string);
        this.needIndent = true;
        this.needNewLine = true;
    }

    private void flush() {
        if (this.needNewLine) {
            this.ps.println();
        }
    }

    @Override
    public void beginDictionary(ConfigDictionary configDictionary, int n) {
        this.writeToken("{", true);
        ++this.indent;
    }

    @Override
    public void endDictionary() {
        --this.indent;
        this.writeToken("}", true);
    }

    @Override
    public void beginArray(ConfigArray configArray, int n) {
        this.writeToken("[", true);
        ++this.indent;
    }

    @Override
    public void endArray() {
        --this.indent;
        this.writeToken("]", true);
    }

    @Override
    public void beginDictEntry(int n, String string) {
        this.writeToken(new StringBuffer().append(StringUtils.quoteString(string)).append(" : ").toString(), false);
    }

    @Override
    public void endDictEntry(boolean bl) {
        if (!bl) {
            this.appendToken(",");
        }
    }

    @Override
    public void beginArrayEntry(int n) {
    }

    @Override
    public void endArrayEntry(boolean bl) {
        if (!bl) {
            this.appendToken(",");
        }
    }

    @Override
    public void writeString(String string) {
        this.writeToken(StringUtils.quoteString(string), false);
    }

    @Override
    public void writeInteger(int n) {
        this.writeToken(Integer.toString(n), false);
    }

    @Override
    public void writeDouble(double d2) {
        this.writeToken(Double.toString((double)d2), false);
    }

    @Override
    public void writeNull() {
        this.writeToken("null", false);
    }

    @Override
    public void writeBoolean(boolean bl) {
        this.writeToken(bl ? "true" : "false", false);
    }
}

