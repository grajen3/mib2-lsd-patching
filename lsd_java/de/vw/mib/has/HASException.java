/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has;

public class HASException
extends Exception {
    private static final long serialVersionUID;
    private final int resultCode;

    protected HASException(int n, String string) {
        super(string);
        this.resultCode = n;
    }

    public final int getDSIResultCode() {
        return 16;
    }

    public final int getResultCode() {
        return this.resultCode;
    }

    public static HASException noChildrenAllowed(int n) {
        return new HASException(-8, new StringBuffer().append("cannot add children to containerId=").append(n).toString());
    }

    public static HASException wrongContainerId(int n, int n2) {
        return new HASException(-8, new StringBuffer().append("wrong container, expected containerId=").append(n).append(" but got containerId=").append(n2).toString());
    }

    public static HASException invalidDataElement(int n, int n2, int n3) {
        return new HASException(-8, new StringBuffer().append("invalid data elementId=").append(n2).append(" of type=").append(HASException.elementTypeToString(n3)).append(" for containerId=").append(n).toString());
    }

    public static HASException invalidChild(int n, int n2) {
        return new HASException(-8, new StringBuffer().append("invalid child containerId=").append(n2).append(" for containerId=").append(n).toString());
    }

    public static HASException invalidMultipleChildren(int n, int n2) {
        return new HASException(-8, new StringBuffer().append("invalid multiple children containerId=").append(n2).append(" for containerId=").append(n).toString());
    }

    public static HASException illegalElementType(int n, int n2, int n3) {
        return new HASException(-8, new StringBuffer().append("illegal element type=").append(HASException.elementTypeToString(n3)).append(" detected in elementId=").append(n2).append(" of containerId=").append(n).toString());
    }

    public static HASException oneElementExpected(int n) {
        return new HASException(-8, new StringBuffer().append("exactly one element was expected for containerId=").append(n).toString());
    }

    public static HASException ambiguousHierarchyId(int n) {
        return new HASException(-8, new StringBuffer().append("ambiguous hierarchyId=").append(n).toString());
    }

    public static HASException incompleteContainerTree(int n) {
        return new HASException(-8, new StringBuffer().append("incomplete container data tree, missing referenced hierarchyId=").append(n).toString());
    }

    public static HASException ambiguousRootContainer() {
        return new HASException(-8, "ambiguous root in container data tree");
    }

    public static HASException missingRootContainer() {
        return new HASException(-8, "missing root in container data tree");
    }

    public static HASException invalidActionRequest(int n) {
        return new HASException(-5, new StringBuffer().append("invalid actionId=").append(n).toString());
    }

    public static HASException invalidPropertyRequest(int n) {
        return new HASException(-4, new StringBuffer().append("invalid propertyId=").append(n).toString());
    }

    public static HASException contextNotReady(String string) {
        return new HASException(-1, new StringBuffer().append("context not ready, context=").append(string).toString());
    }

    public static HASException invocationNotAllowed(int n) {
        return new HASException(2, new StringBuffer().append("invocation of action not allowed, actionId=").append(n).toString());
    }

    private static String elementTypeToString(int n) {
        switch (n) {
            case 5: {
                return "binary";
            }
            case 4: {
                return "boolean";
            }
            case 3: {
                return "double";
            }
            case 0: {
                return "int";
            }
            case 1: {
                return "long";
            }
            case 6: {
                return "resourceLocator";
            }
            case 2: {
                return "string";
            }
            case -1: {
                return "undefined";
            }
        }
        return String.valueOf(n);
    }
}

