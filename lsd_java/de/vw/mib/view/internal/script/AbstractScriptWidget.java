/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal.script;

import de.vw.mib.cio.framework.ScriptWidgetCioService;
import de.vw.mib.datapool.FormatterService;
import de.vw.mib.format.FixFormat;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.script.ScriptWidgetUtility;
import java.lang.reflect.Array;

public abstract class AbstractScriptWidget {
    protected static FixFormat fixFormat;
    protected static ScriptWidgetCioService cioUtil;
    protected static ScriptWidgetUtility scriptUtil;
    protected static Logger logger;

    protected AbstractScriptWidget() {
    }

    public static void setup(FixFormat fixFormat, ScriptWidgetCioService scriptWidgetCioService, LoggerFactory loggerFactory) {
        AbstractScriptWidget.fixFormat = fixFormat;
        cioUtil = scriptWidgetCioService;
        scriptUtil = new ScriptWidgetUtility();
        logger = loggerFactory.getLogger(1024);
    }

    public static Object resizeArray(Object object, int n) {
        int n2 = Array.getLength(object);
        if (n >= n2) {
            Class clazz = object.getClass().getComponentType();
            Object object2 = Array.newInstance(clazz, n + 1);
            System.arraycopy(object, 0, object2, 0, n2);
            return object2;
        }
        return object;
    }

    protected static boolean isScriptTraceEnabled() {
        return logger.isTraceEnabled(64);
    }

    protected static void scriptTrace(String string) {
        logger.trace(64, string);
    }

    public static CharSequence concatenateString(CharSequence charSequence, CharSequence charSequence2) {
        return FormatterService.format(charSequence, charSequence2);
    }

    public static CharSequence concatenateString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        return FormatterService.format(charSequence, charSequence2, charSequence3);
    }

    public static CharSequence concatenateString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) {
        return FormatterService.format(charSequence, charSequence2, charSequence3, charSequence4);
    }

    public static CharSequence concatenateString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5) {
        return FormatterService.format(charSequence, charSequence2, charSequence3, charSequence4, charSequence5);
    }

    public static CharSequence concatenateString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, CharSequence charSequence6) {
        return FormatterService.format(charSequence, charSequence2, charSequence3, charSequence4, charSequence5, charSequence6);
    }
}

