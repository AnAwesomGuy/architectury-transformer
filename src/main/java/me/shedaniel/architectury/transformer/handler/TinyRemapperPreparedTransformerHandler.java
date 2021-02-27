/*
 * This file is licensed under the MIT License, part of architectury-transformer.
 * Copyright (c) 2020, 2021 shedaniel
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

package me.shedaniel.architectury.transformer.handler;

import me.shedaniel.architectury.transformer.transformers.ClasspathProvider;
import me.shedaniel.architectury.transformer.transformers.base.edit.TransformerContext;
import me.shedaniel.architectury.transformer.util.Logger;
import net.fabricmc.tinyremapper.IMappingProvider;
import net.fabricmc.tinyremapper.TinyRemapper;

import java.io.IOException;
import java.util.Set;

public class TinyRemapperPreparedTransformerHandler extends SimpleTransformerHandler {
    private TinyRemapper remapper;
    
    public TinyRemapperPreparedTransformerHandler(ClasspathProvider classpath, TransformerContext context) throws Exception {
        super(classpath, context);
        prepare();
    }
    
    private void prepare() throws Exception {
        Logger.debug("Preparing tiny remapper prepared transformer: " + getClass().getName());
        remapper = TinyRemapper.newRemapper().skipConflictsChecking(true).cacheMappings(true).build();
        
        remapper.readClassPath(classpath.provide());
        remapper.prepareClasses();
    }
    
    @Override
    public TinyRemapper getRemapper(Set<IMappingProvider> providers) throws Exception {
        remapper.replaceMappings(providers);
        if (remapper.isMappingsDirty()) {
            Logger.debug("Remapping with Dirty Mappings...");
        }
        return remapper;
    }
    
    @Override
    protected void closeRemapper(TinyRemapper remapper) throws Exception {
        remapper.removeInput();
    }
    
    @Override
    public void close() throws IOException {
        super.close();
        if (this.remapper != null) {
            this.remapper.finish();
        }
        this.remapper = null;
    }
}
