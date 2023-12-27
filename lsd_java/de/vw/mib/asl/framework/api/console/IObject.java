/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.console;

import java.math.BigInteger;

public interface IObject {
    default public IObject i_repr() {
    }

    default public IObject i_str() {
    }

    default public String i_stringValue() {
    }

    default public boolean isNumber() {
    }

    default public boolean isInt() {
    }

    default public boolean isLong() {
    }

    default public boolean isDouble() {
    }

    default public boolean isComplex() {
    }

    default public boolean isString() {
    }

    default public boolean isDict() {
    }

    default public boolean isList() {
    }

    default public boolean isInstance() {
    }

    default public boolean isClass() {
    }

    default public boolean isType() {
    }

    default public boolean i_hasAttr(String string) {
    }

    default public IObject i_getAttr(String string) {
    }

    default public void i_setAttr(String string, IObject iObject) {
    }

    default public void i_delAttr(String string) {
    }

    default public boolean i_hasItem(String string) {
    }

    default public boolean i_hasItem(int n) {
    }

    default public boolean i_hasItem(IObject iObject) {
    }

    default public IObject i_getItem(String string) {
    }

    default public IObject i_getItem(int n) {
    }

    default public IObject i_getItem(IObject iObject) {
    }

    default public void i_delItem(String string) {
    }

    default public void i_delItem(int n) {
    }

    default public void i_delItem(IObject iObject) {
    }

    default public void i_setItem(String string, IObject iObject) {
    }

    default public void i_setItem(int n, IObject iObject) {
    }

    default public void i_setItem(IObject iObject, IObject iObject2) {
    }

    default public int i_len() {
    }

    default public int as_int() {
    }

    default public BigInteger as_bigint() {
    }

    default public double as_double() {
    }

    default public long as_long() {
    }
}

