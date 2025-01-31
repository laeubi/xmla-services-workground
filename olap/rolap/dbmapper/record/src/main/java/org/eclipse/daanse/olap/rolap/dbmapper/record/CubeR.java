/*
 * Copyright (c) 2022 Contributors to the Eclipse Foundation.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   SmartCity Jena, Stefan Bischof - initial
 *   
 */
package org.eclipse.daanse.olap.rolap.dbmapper.record;

import java.util.List;

import org.eclipse.daanse.olap.rolap.dbmapper.api.Cube;

public record CubeR(String name,
                    String caption,
                    String description,
                    String defaultMeasure,
                    List<AnnotationR> annotations,
                    TableR table,
                    ViewR view,
                    List<Object> dimensionUsageOrDimension,
                    List<MeasureR> measure,
                    List<CalculatedMemberR> calculatedMember,
                    List<NamedSetR> namedSet,
                    List<DrillThroughActionR> drillThroughAction,
                    List<WritebackTableR> writebackTable,
                    boolean enabled,
                    boolean cache)
        implements Cube {

}
