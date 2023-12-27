/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mirrorlink.model.list;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.log4mib.LogMessage;
import generated.de.vw.mib.asl.internal.ListManager;

public abstract class AbstractListHandler {
    private int listID = 0;
    private static final Object[] EMPTY_ARRAY = new Object[0];
    public static final int INVALID_LIST_INDEX;
    public static final int PENDING_LIST_INDEX;
    private final String classname;

    public AbstractListHandler(int n) {
        this.classname = "AbstractListHandler";
        this.listID = n;
    }

    public GenericASLList getList() {
        return ListManager.getGenericASLList(this.listID);
    }

    public boolean isValidIndex(int n) {
        return n > -1 && n < this.getList().getSize();
    }

    public abstract void reset() {
    }

    public void clear() {
        this.setActiveElement(-1);
        GenericASLList genericASLList = this.getList();
        if (genericASLList.isWindowingEnabled()) {
            genericASLList.setSize(0);
        } else {
            genericASLList.updateList(EMPTY_ARRAY);
        }
        this.reset();
    }

    public void setActiveElement(int n) {
        if (ServiceManager.logger2.isTraceEnabled(4)) {
            LogMessage logMessage = ServiceManager.logger2.trace(4);
            logMessage.append("AbstractListHandler").append(new StringBuffer().append(".setActiveElement(").append(n).append(")").toString()).log();
        }
        if (this.isValidIndex(n)) {
            this.getList().setActiveIndex(n);
        } else {
            this.getList().setActiveIndex(-1);
        }
    }
}

