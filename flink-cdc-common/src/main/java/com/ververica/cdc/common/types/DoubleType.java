/*
 * Copyright 2023 Ververica Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ververica.cdc.common.types;

import org.apache.flink.annotation.PublicEvolving;

import java.util.Collections;
import java.util.List;

/** Data type of an 8-byte double precision floating point number. */
@PublicEvolving
public final class DoubleType extends DataType {

    private static final long serialVersionUID = 1L;

    private static final String FORMAT = "DOUBLE";

    public DoubleType(boolean isNullable) {
        super(isNullable, DataTypeRoot.DOUBLE);
    }

    public DoubleType() {
        this(true);
    }

    @Override
    public DataType copy(boolean isNullable) {
        return new DoubleType(isNullable);
    }

    @Override
    public String asSerializableString() {
        return withNullability(FORMAT);
    }

    @Override
    public List<DataType> getChildren() {
        return Collections.emptyList();
    }

    @Override
    public <R> R accept(DataTypeVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
