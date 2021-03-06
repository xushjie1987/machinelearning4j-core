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
package org.machinelearning4j.core;


/**
 * Encapsulates the common components required in building of a TrainingSet.  To define a training set
 * before it can be populated, we must specify definitions for features of the
 * element we wish to analyze
 * 
 * @author Michael Lavelle
 */
public abstract class AbstractTrainingSetBuilder<T,S extends AbstractTrainingSetBuilder<T,S>> {

	protected NumericFeatureMapper<T> numericFeatureMapper;
	protected int size;
	protected FeatureScaler featureScaler;
	
	public AbstractTrainingSetBuilder(int size,boolean addInterceptFeature)
	{
		this.numericFeatureMapper = new NumericFeatureMapper<T>(addInterceptFeature);
		this.size = size;
	}
	
	/**
	 * 
	 * @param featureDefinition Defines a numeric feature of an element of this training set
	 * 
	 * @return the chained builder
	 */
	public S withFeatureDefinition(
			NumericFeatureDefinition<T> featureDefinition)
	{
		numericFeatureMapper.addFeatureDefinition(featureDefinition);
		return getChainedBuilder();
	}
	
	public S withFeatureScaling(FeatureScaler featureScaler)
	{
		this.featureScaler = featureScaler;
		return getChainedBuilder();
	}
	
	protected abstract S getChainedBuilder();



}
