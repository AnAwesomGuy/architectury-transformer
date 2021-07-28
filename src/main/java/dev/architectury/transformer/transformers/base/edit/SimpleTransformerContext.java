/*
 * This file is licensed under the MIT License, part of architectury-transformer.
 * Copyright (c) 2020, 2021 architectury
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package dev.architectury.transformer.transformers.base.edit;

import java.util.function.Consumer;

public final class SimpleTransformerContext implements TransformerContext {
    private final Consumer<String[]> appendArgument;
    private final boolean canModifyAssets;
    private final boolean canAppendArgument;
    private final boolean canAddClasses;
    
    public SimpleTransformerContext(Consumer<String[]> appendArgument, boolean canModifyAssets, boolean canAppendArgument, boolean canAddClasses) {
        this.appendArgument = appendArgument;
        this.canModifyAssets = canModifyAssets;
        this.canAppendArgument = canAppendArgument;
        this.canAddClasses = canAddClasses;
    }
    
    @Override
    public void appendArgument(String... args) {
        appendArgument.accept(args);
    }
    
    @Override
    public boolean canModifyAssets() {
        return canModifyAssets;
    }
    
    @Override
    public boolean canAppendArgument() {
        return canAppendArgument;
    }
    
    @Override
    public boolean canAddClasses() {
        return canAddClasses;
    }
}
