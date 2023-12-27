/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller.contact;

import de.vw.mib.asl.api.speechengine.result.handling.ResultItemHandler;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneLogger2;

public class LocTypeIndexHandler {
    private final SpeechPhoneLogger2 logger;
    private int loctype;
    private int index;
    private final ResultItemHandler resultItemHandler;
    public static final String[] LOCTYPESTRING = new String[]{"other", "mobile", "business", "private", "fax business", "fax private", "fax"};
    public static final int LOCTYPE_NOT_SET;
    public static final int INDEX_NOT_SET;
    public static final int INDEX_NOT_MATCH;
    public static final int INDEX_MATCH;

    public LocTypeIndexHandler(ServiceFunctions serviceFunctions, ResultItemHandler resultItemHandler) {
        this.resultItemHandler = resultItemHandler;
        this.logger = serviceFunctions.createLogger("LocTypeIndexHandler");
        this.reset();
    }

    public void fetchLocType() {
        block6: {
            try {
                int n = Integer.parseInt(this.resultItemHandler.getResultItem().getTag());
                if (n > 0) {
                    this.loctype = n;
                    this.index = -1;
                    if (this.logger.isTraceEnabled()) {
                        this.logger.trace(new StringBuffer().append("fetched loctype ").append(LOCTYPESTRING[this.loctype]).append(", index was not set").toString());
                    }
                } else if (this.logger.isTraceEnabled()) {
                    this.logger.trace("no loctype was spoken, keeping old values");
                }
            }
            catch (Exception exception) {
                this.loctype = -1;
                this.index = -1;
                if (!this.logger.isTraceEnabled()) break block6;
                this.logger.trace("error at loctype recognition, loctype reset");
            }
        }
    }

    public void fetchLocTypeIndex() {
        block9: {
            try {
                int n = Integer.parseInt(this.resultItemHandler.getResultItem().getTag());
                if (n > 0) {
                    this.loctype = n / 10;
                    this.index = n - this.loctype * 10;
                    if (this.index < 1) {
                        this.index = -1;
                        if (this.logger.isTraceEnabled()) {
                            this.logger.trace(new StringBuffer().append("fetched loctype ").append(LOCTYPESTRING[this.loctype]).append(", index was not set").toString());
                        }
                    } else if (this.logger.isTraceEnabled()) {
                        this.logger.trace(new StringBuffer().append("fetched loctype ").append(LOCTYPESTRING[this.loctype]).append(", index is ").append(this.index).toString());
                    }
                } else if (this.logger.isTraceEnabled()) {
                    this.logger.trace("no loctype or index was spoken, keeping old values");
                }
            }
            catch (Exception exception) {
                if (!this.logger.isTraceEnabled()) break block9;
                this.logger.trace("error at loctype recognition, keeping old values");
            }
        }
    }

    public void reset() {
        this.loctype = -1;
        this.index = -1;
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("resetting loctype and index");
        }
    }

    public int getLoctype() {
        return this.loctype;
    }

    public int getIndex() {
        return this.index;
    }
}

