/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal.viewhandler;

import de.vw.mib.desktop.internal.viewhandler.SmartViewHandler;

class SmartViewHandler$SmartViewHandlerIsInABadStateException
extends RuntimeException {
    private final /* synthetic */ SmartViewHandler this$0;

    SmartViewHandler$SmartViewHandlerIsInABadStateException(SmartViewHandler smartViewHandler, String string, int n) {
        this.this$0 = smartViewHandler;
        super(new StringBuffer().append("The view handler '").append(string).append("' is in a bad state (").append(n).append(")!").toString());
    }
}

