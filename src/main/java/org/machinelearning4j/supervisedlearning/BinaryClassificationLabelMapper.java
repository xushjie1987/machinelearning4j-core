/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.machinelearning4j.supervisedlearning;

import java.util.List;

/**
 * A NumericLabelMapper which converts labels of type C to 0 for the negative classification
 * and 1 for the positive classification
 * 
 * @author Michael Lavelle
 */
public abstract class BinaryClassificationLabelMapper<C> implements NumericLabelMapper<C> {

	
	@Override
	public double[] getLabelValues(List<C> labels) {
		double[] labelValues = new double[labels.size()];
		int labelValueIndex = 0;
		for (C label : labels)
		{
			labelValues[labelValueIndex++] = isPositiveClass(label) ? 1d : 0d;
		}
		return labelValues;
	}
	
	protected abstract boolean isPositiveClass(C label);

}
