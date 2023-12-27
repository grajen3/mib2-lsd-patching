/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.statemachine;

import de.vw.mib.log4mib.Logger;
import de.vw.mib.sm.internal.statemachine.MainStatemachineOrder;
import java.util.Arrays;

public class MainStatemachineOrderUserDefinedBuilder {
    public static final String SYSTEM_PROPERTY;
    private static final char CATEGORY_DELIMITER;
    private static final char SUBPRIORITY_DELIMITER;
    private final Logger logger;
    private short[] priorityStatemachineIds;
    private short[] categoryById;
    private short[] subPriorityByIds;

    public MainStatemachineOrderUserDefinedBuilder(Logger logger) {
        this.logger = logger;
    }

    public MainStatemachineOrder build(String string, short[] sArray) {
        this.priorityStatemachineIds = sArray;
        this.debug("SM_SPLIT_INFO: Starting to categorize main statemachines (user-defined).");
        try {
            this.categoryById = new short[sArray.length];
            this.subPriorityByIds = new short[sArray.length];
            this.fillCategoryAndSubPriority(string);
            this.checkCompleteness();
            this.debug("SM_SPLIT_INFO: Categorization of main statemachines complete.");
            return new MainStatemachineOrder(this.categoryById, this.subPriorityByIds);
        }
        catch (RuntimeException runtimeException) {
            this.error(new StringBuffer().append("SM_SPLIT_ERROR: Exception during user-defined statemachine categorization: ").append(runtimeException.getMessage()).toString());
            return null;
        }
    }

    private void fillCategoryAndSubPriority(String string) {
        Arrays.fill(this.categoryById, (short)-1);
        String[] stringArray = MainStatemachineOrderUserDefinedBuilder.split(string, ';');
        for (short s = 0; s < stringArray.length; s = (short)(s + 1)) {
            this.fillCategoryAndSubPriority(s, stringArray[s]);
        }
    }

    private void fillCategoryAndSubPriority(short s, String string) {
        String[] stringArray = MainStatemachineOrderUserDefinedBuilder.split(string, ',');
        for (int n = 0; n < stringArray.length; n = (int)((short)(n + 1))) {
            int n2 = this.getId(stringArray[n]);
            this.categoryById[n2] = s;
            this.subPriorityByIds[n2] = n;
        }
    }

    private int getId(String string) {
        int n = Integer.parseInt(string);
        for (int i2 = 0; i2 < this.priorityStatemachineIds.length; ++i2) {
            if (this.priorityStatemachineIds[i2] != n) continue;
            return i2;
        }
        String string2 = new StringBuffer().append("Invalid startup order. Statemachine ID ").append(string).append(" does not exist on the target.").toString();
        throw new RuntimeException(string2);
    }

    private void checkCompleteness() {
        for (int i2 = 0; i2 < this.priorityStatemachineIds.length; ++i2) {
            short s = this.priorityStatemachineIds[i2];
            if (s == -1) continue;
            this.checkCategoryIsSet(i2);
        }
    }

    private void checkCategoryIsSet(int n) {
        if (this.categoryById[n] == -1) {
            String string = new StringBuffer().append("Invalid startup order. Statemachine ID ").append(this.priorityStatemachineIds[n]).append(" is not assigned to a category.").toString();
            throw new RuntimeException(string);
        }
    }

    private void debug(String string) {
        if (this.logger.isTraceEnabled(3)) {
            this.logger.trace(3, string);
        }
    }

    private void error(String string) {
        this.logger.error(1, string);
    }

    static String[] split(String string, char c2) {
        int n = 1;
        int n2 = string.indexOf(c2);
        while (n2 != -1) {
            ++n;
            n2 = string.indexOf(c2, n2 + 1);
        }
        String[] stringArray = new String[n];
        int n3 = 0;
        for (int i2 = 0; i2 < n - 1; ++i2) {
            int n4 = string.indexOf(c2, n3);
            stringArray[i2] = string.substring(n3, n4);
            n3 = n4 + 1;
        }
        stringArray[n - 1] = string.substring(n3);
        return stringArray;
    }
}

