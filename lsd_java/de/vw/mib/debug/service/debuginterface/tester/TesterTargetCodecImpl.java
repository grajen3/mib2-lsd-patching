/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.debuginterface.tester;

import de.vw.mib.codec.ByteArrayReader;
import de.vw.mib.debug.service.debuginterface.tester.TesterTargetCodecListener;
import de.vw.mib.list.DynamicListDataDebug;
import de.vw.mib.log4mib.BinaryMessage;

public class TesterTargetCodecImpl {
    public static final byte GETWIDGETCOORDINATES;
    public static final byte GETWIDGETPROPERTY;
    public static final byte STARTTESTSTATEMENT;
    public static final byte STOPTESTSTATEMENT;
    public static final byte STARTTESTSUITE;
    public static final byte STOPTESTSUITE;
    private static final int GETSTATEMACHINESTATE;
    private static final int GETASLLISTVALUES;
    private static final int PRESS_SPELLER_BUTTON;
    private static final int FAILTESTSTATEMENT;
    public static final byte RESPONSE_WIDGETCOORINATES;
    public static final byte RESPONSE_ERROR_GETTING_WIDGETCOORINATES;
    public static final byte RESPONSE_WIDGETPROPERTY;
    public static final byte RESPONSE_ERROR_GETTING_WIDGETPROPERTY;
    public static final byte RESPONSE_STATEMACHINE_STATE;
    public static final byte RESPONSE_ASL_LIST_VALUES;
    public static final byte RESPONSE_ERROR_PRESS_SPELLER_BUTTON;
    public static final byte RESPONSE_PRESS_SPELLER_BUTTON;
    public static final byte RESPONSE_ERROR_GETTING_WIDGETCOORINATES_INVISIBLE;
    public static final byte RESPONSE_UNKNOWN_TYPE;
    static /* synthetic */ Class class$java$lang$Boolean;
    static /* synthetic */ Class class$java$lang$Byte;
    static /* synthetic */ Class class$java$lang$Short;
    static /* synthetic */ Class class$java$lang$Character;
    static /* synthetic */ Class class$java$lang$Integer;
    static /* synthetic */ Class class$java$lang$Double;
    static /* synthetic */ Class class$java$lang$Long;
    static /* synthetic */ Class class$java$lang$Float;
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$org$dsi$ifc$global$ResourceLocator;

    public BinaryMessage responseWidgetCoordinates(BinaryMessage binaryMessage, int n, int n2, int n3, int n4) {
        binaryMessage.append((byte)10);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.append(n3);
        binaryMessage.append(n4);
        return binaryMessage;
    }

    public BinaryMessage responseErrorGettinSpellerInformation(BinaryMessage binaryMessage, String string) {
        binaryMessage.append((byte)16);
        binaryMessage.append(string);
        return binaryMessage;
    }

    public BinaryMessage responsePressSpellerButton(BinaryMessage binaryMessage) {
        binaryMessage.append((byte)17);
        return binaryMessage;
    }

    public BinaryMessage responseWidgetCoordinatesNotVisible(BinaryMessage binaryMessage) {
        binaryMessage.append((byte)18);
        return binaryMessage;
    }

    public BinaryMessage responseErrorGettingWidgetcoorinates(BinaryMessage binaryMessage) {
        binaryMessage.append((byte)11);
        return binaryMessage;
    }

    public BinaryMessage responseWidgetproperty(BinaryMessage binaryMessage, Object object) {
        binaryMessage.append((byte)12);
        return this.appendProperty(object, binaryMessage);
    }

    public BinaryMessage responseErrorGettingWidgetproperty(BinaryMessage binaryMessage) {
        binaryMessage.append((byte)13);
        return binaryMessage;
    }

    public BinaryMessage responseStatemachineState(BinaryMessage binaryMessage, int n, int n2, int n3) {
        binaryMessage.append((byte)14);
        binaryMessage.append(n).append(n2).append(n3);
        return binaryMessage;
    }

    public BinaryMessage responseASLListValues(BinaryMessage binaryMessage, int n, DynamicListDataDebug dynamicListDataDebug) {
        binaryMessage.append((byte)15);
        binaryMessage.append(n);
        int n2 = dynamicListDataDebug.getSize();
        binaryMessage.append(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            String[] stringArray = dynamicListDataDebug.getRowValuesAsStrings(i2);
            if (stringArray == null) {
                binaryMessage.append(0);
                continue;
            }
            int n3 = stringArray.length;
            binaryMessage.append(n3);
            for (int i3 = 0; i3 < n3; ++i3) {
                binaryMessage.append(stringArray[i3]);
            }
        }
        return binaryMessage;
    }

    public BinaryMessage responseUnknownRequestType(BinaryMessage binaryMessage, byte by) {
        binaryMessage.append((byte)100);
        binaryMessage.append(by);
        return binaryMessage;
    }

    public void decode(byte[] byArray, TesterTargetCodecListener testerTargetCodecListener) {
        this.decode(new ByteArrayReader(byArray), testerTargetCodecListener);
    }

    public void decode(ByteArrayReader byteArrayReader, TesterTargetCodecListener testerTargetCodecListener) {
        byte by = byteArrayReader.readByte();
        switch (by) {
            case 2: {
                testerTargetCodecListener.gotStartTestStatement(byteArrayReader.readString());
                break;
            }
            case 3: {
                testerTargetCodecListener.gotStopTestStatement(byteArrayReader.readString());
                break;
            }
            case 4: {
                testerTargetCodecListener.gotStartTestSuite(byteArrayReader.readString());
                break;
            }
            case 5: {
                testerTargetCodecListener.gotStopTestSuite(byteArrayReader.readString());
                break;
            }
            case 9: {
                testerTargetCodecListener.gotFailTestStatement(byteArrayReader.readString());
                break;
            }
            case 0: {
                testerTargetCodecListener.getWidgetCoordinates(byteArrayReader.readInt(), byteArrayReader.readInt());
                break;
            }
            case 1: {
                int n = byteArrayReader.readInt();
                int n2 = byteArrayReader.readInt();
                String string = byteArrayReader.readString();
                testerTargetCodecListener.getWidgetProperty(n, n2, string);
                break;
            }
            case 6: {
                int n = byteArrayReader.readInt();
                testerTargetCodecListener.getStatemachineState(n);
                break;
            }
            case 8: {
                int n = byteArrayReader.readInt();
                testerTargetCodecListener.pressSpellerButton(n);
                break;
            }
            case 7: {
                int n = byteArrayReader.readInt();
                testerTargetCodecListener.getASLListValues(n);
                break;
            }
        }
    }

    private BinaryMessage appendProperty(Object object, BinaryMessage binaryMessage) {
        if (object == null) {
            binaryMessage.append("WidgetNotFound");
            return binaryMessage;
        }
        if ((class$java$lang$Boolean == null ? (class$java$lang$Boolean = TesterTargetCodecImpl.class$("java.lang.Boolean")) : class$java$lang$Boolean).isAssignableFrom(object.getClass())) {
            binaryMessage.append("boolean");
            binaryMessage.append(object.toString());
        } else if ((class$java$lang$Byte == null ? (class$java$lang$Byte = TesterTargetCodecImpl.class$("java.lang.Byte")) : class$java$lang$Byte).isAssignableFrom(object.getClass())) {
            binaryMessage.append("byte");
            binaryMessage.append(object.toString());
        } else if ((class$java$lang$Short == null ? (class$java$lang$Short = TesterTargetCodecImpl.class$("java.lang.Short")) : class$java$lang$Short).isAssignableFrom(object.getClass())) {
            binaryMessage.append("short");
            binaryMessage.append(object.toString());
        } else if ((class$java$lang$Character == null ? (class$java$lang$Character = TesterTargetCodecImpl.class$("java.lang.Character")) : class$java$lang$Character).isAssignableFrom(object.getClass())) {
            binaryMessage.append("char");
            binaryMessage.append(object.toString());
        } else if ((class$java$lang$Integer == null ? (class$java$lang$Integer = TesterTargetCodecImpl.class$("java.lang.Integer")) : class$java$lang$Integer).isAssignableFrom(object.getClass())) {
            binaryMessage.append("int");
            binaryMessage.append(object.toString());
        } else if ((class$java$lang$Double == null ? (class$java$lang$Double = TesterTargetCodecImpl.class$("java.lang.Double")) : class$java$lang$Double).isAssignableFrom(object.getClass())) {
            binaryMessage.append("double");
            binaryMessage.append(object.toString());
        } else if ((class$java$lang$Long == null ? (class$java$lang$Long = TesterTargetCodecImpl.class$("java.lang.Long")) : class$java$lang$Long).isAssignableFrom(object.getClass())) {
            binaryMessage.append("long");
            binaryMessage.append(object.toString());
        } else if ((class$java$lang$Float == null ? (class$java$lang$Float = TesterTargetCodecImpl.class$("java.lang.Float")) : class$java$lang$Float).isAssignableFrom(object.getClass())) {
            binaryMessage.append("float");
            binaryMessage.append(object.toString());
        } else if ((class$java$lang$String == null ? (class$java$lang$String = TesterTargetCodecImpl.class$("java.lang.String")) : class$java$lang$String).isAssignableFrom(object.getClass())) {
            binaryMessage.append("String");
            binaryMessage.append(object.toString());
        } else if ((class$org$dsi$ifc$global$ResourceLocator == null ? (class$org$dsi$ifc$global$ResourceLocator = TesterTargetCodecImpl.class$("org.dsi.ifc.global.ResourceLocator")) : class$org$dsi$ifc$global$ResourceLocator).isAssignableFrom(object.getClass())) {
            binaryMessage.append("String");
            binaryMessage.append(object.toString());
        } else {
            binaryMessage.append("String");
            binaryMessage.append(new StringBuffer().append("TypeNotSupported(").append(object.getClass().getName()).append("): ").append(object.toString()).toString());
        }
        return binaryMessage;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

