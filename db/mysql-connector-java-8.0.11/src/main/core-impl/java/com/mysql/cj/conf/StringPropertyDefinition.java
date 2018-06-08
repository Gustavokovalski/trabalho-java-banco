/*
 * Copyright (c) 2015, 2018, Oracle and/or its affiliates. All rights reserved.
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License, version 2.0, as published by the
 * Free Software Foundation.
 *
 * This program is also distributed with certain software (including but not
 * limited to OpenSSL) that is licensed under separate terms, as designated in a
 * particular file or component or in included license documentation. The
 * authors of MySQL hereby grant you an additional permission to link the
 * program and your derivative works with the separately licensed software that
 * they have included with MySQL.
 *
 * Without limiting anything contained in the foregoing, this file, which is
 * part of MySQL Connector/J, is also subject to the Universal FOSS Exception,
 * version 1.0, a copy of which can be found at
 * http://oss.oracle.com/licenses/universal-foss-exception.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License, version 2.0,
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin St, Fifth Floor, Boston, MA 02110-1301  USA
 */

package com.mysql.cj.conf;

import com.mysql.cj.exceptions.ExceptionInterceptor;

public class StringPropertyDefinition extends AbstractPropertyDefinition<String> {

    private static final long serialVersionUID = 8228934389127796555L;

    public StringPropertyDefinition(String name, String alias, String defaultValue, boolean isRuntimeModifiable, String description, String sinceVersion,
            String category, int orderInCategory) {
        super(name, alias, defaultValue, isRuntimeModifiable, description, sinceVersion, category, orderInCategory);
    }

    @Override
    public String parseObject(String value, ExceptionInterceptor exceptionInterceptor) {
        return value;
    }

    /**
     * Creates instance of ReadableStringProperty or ModifiableStringProperty depending on isRuntimeModifiable() result.
     * 
     * @return
     */
    @Override
    public RuntimeProperty<String> createRuntimeProperty() {
        return isRuntimeModifiable() ? new ModifiableStringProperty(this) : new ReadableStringProperty(this);
    }
}
