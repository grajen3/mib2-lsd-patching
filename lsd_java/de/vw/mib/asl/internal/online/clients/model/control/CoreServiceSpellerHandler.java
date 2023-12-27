/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.clients.model.control;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.properties.values.SpellerData;

public final class CoreServiceSpellerHandler {
    private final String _classname = super.getClass().getName();
    private SpellerData _spellerData = new SpellerData();
    private String _spellerInitialText = "";

    public void spellerDeleteChar() {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".spellerDeleteChar()").log();
        }
        this.deleteChar();
        this.setSpellerData(this._spellerData);
    }

    public String spellerOK() {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(".spellerOK()").log();
        }
        object = null;
        if (this._spellerData.getEnteredText() != null) {
            object = this._spellerData.getEnteredText();
        }
        this.setSpellerOk(false);
        return object;
    }

    public void spellerAddChar(String string) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".spellerAddChar(").append(string != null ? string : "NULL").append(")").toString()).log();
        }
        this.addChar(string);
        this.setSpellerData(this._spellerData);
    }

    public void spellerSetCursorPosition(int n) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".spellerSetCursorPosition(").append(n).append(")").toString()).log();
        }
        this.deselectAll();
        this._spellerData.setCursorPosition(n);
        this.setSpellerData(this._spellerData);
    }

    public void spellerCancel() {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".spellerCancel()").log();
        }
        this.resetSpeller();
    }

    public void spellerEntered() {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".spellerEntered()").log();
        }
        this.resetSpeller();
        this.addChar(this._spellerInitialText);
        this.setSpellerData(this._spellerData);
        this.setSpellerOk(true);
    }

    public void resetSpeller() {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".resetSpeller()").log();
        }
        this._spellerData = new SpellerData();
        this.setSpellerData(this._spellerData);
        this.setSpellerOk(true);
    }

    private void deleteChar() {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(".deleteChar()").log();
        }
        object = this._spellerData.getEnteredText();
        int n = this._spellerData.getCursorPosition();
        if (this._spellerData.getSelectionStart() != this._spellerData.getSelectionEnd()) {
            this._spellerData.setEnteredText("");
            this.deselectAll();
            this._spellerData.setCursorPosition(0);
            return;
        }
        if (((String)object).length() > 0 && n > 0 && n <= ((String)object).length() + 1) {
            if (n == 1) {
                this._spellerData.setEnteredText(((String)object).substring(1));
            } else if (n == ((String)object).length()) {
                this._spellerData.setEnteredText(((String)object).substring(0, ((String)object).length() - 1));
            } else {
                this._spellerData.setEnteredText(new StringBuffer().append(((String)object).substring(0, n - 1)).append(((String)object).substring(n)).toString());
            }
            this._spellerData.setCursorPosition(n - 1);
        }
    }

    private void addChar(String string) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".addChar(").append(string).append(")").toString()).log();
        }
        object = this._spellerData.getEnteredText();
        int n = this._spellerData.getCursorPosition();
        if (this._spellerData.getSelectionStart() != this._spellerData.getSelectionEnd()) {
            this._spellerData.setEnteredText(string);
            this.deselectAll();
            this._spellerData.setCursorPosition(this._spellerData.getEnteredText().length());
            return;
        }
        if (n <= ((String)object).length() + 1) {
            if (((String)object).length() == 0) {
                this._spellerData.setEnteredText(string);
            } else if (n == 0) {
                this._spellerData.setEnteredText(new StringBuffer().append(string).append((String)object).toString());
            } else if (n == ((String)object).length()) {
                this._spellerData.setEnteredText(new StringBuffer().append((String)object).append(string).toString());
            } else {
                this._spellerData.setEnteredText(new StringBuffer(((String)object).substring(0, n)).append(string).append(((String)object).substring(n)).toString());
            }
            this._spellerData.setCursorPosition(n + string.length());
        }
    }

    void deselectAll() {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".deselectAll()").log();
        }
        this._spellerData.setSelectionStart(0);
        this._spellerData.setSelectionEnd(0);
    }

    void setSpellerData(SpellerData spellerData) {
        ServiceManager.aslPropertyManager.valueChangedSpellerData(4069, spellerData);
    }

    void setSpellerActive(boolean bl) {
    }

    void setSpellerAvailable(boolean bl) {
    }

    void setSpellerOk(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1039995648, bl);
    }

    void setSpellerInitialText(String string) {
    }
}

