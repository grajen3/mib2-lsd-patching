/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.OperatorCallResult;

public interface DSIOperatorCallListener
extends DSIListener {
    default public void responseOperatorCallResult(int n, OperatorCallResult[] operatorCallResultArray) {
    }

    default public void responseOperatorPhoneNumber(int n, String string, String[] stringArray, int n2) {
    }
}

