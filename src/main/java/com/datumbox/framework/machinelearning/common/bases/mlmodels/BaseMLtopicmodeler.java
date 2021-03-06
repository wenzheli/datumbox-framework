/**
 * Copyright (C) 2013-2015 Vasilis Vryniotis <bbriniotis@datumbox.com>
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
package com.datumbox.framework.machinelearning.common.bases.mlmodels;

import com.datumbox.common.persistentstorage.interfaces.DatabaseConfiguration;
import com.datumbox.common.persistentstorage.interfaces.DatabaseConnector;
import com.datumbox.framework.machinelearning.common.bases.validation.ModelValidation;

/**
 * Base Class for all the Topic Modeling algorithms.
 *
 * @author Vasilis Vryniotis <bbriniotis@datumbox.com>
 * @param <MP>
 * @param <TP>
 * @param <VM>
 */
public abstract class BaseMLtopicmodeler<MP extends BaseMLtopicmodeler.ModelParameters, TP extends BaseMLtopicmodeler.TrainingParameters, VM extends BaseMLtopicmodeler.ValidationMetrics> extends BaseMLmodel<MP, TP, VM> {
    
    /**
     * The ModelParameters class stores the coefficients that were learned during
     * the training of the algorithm.
     */
    public static abstract class ModelParameters extends BaseMLmodel.ModelParameters {

        /**
         * Protected constructor which accepts as argument the DatabaseConnector.
         * 
         * @param dbc 
         */
        protected ModelParameters(DatabaseConnector dbc) {
            super(dbc);
        }
        
    } 
    
    /**
     * The TrainingParameters class stores the parameters that can be changed
     * before training the algorithm.
     */
    public static abstract class TrainingParameters extends BaseMLmodel.TrainingParameters {    

    } 
    
    /**
     * The TrainingParameters class stores the parameters that can be changed
     * before training the algorithm.
     */
    public static abstract class ValidationMetrics extends BaseMLmodel.ValidationMetrics {
  
    }
    
    /**
     * Protected constructor of the regressor.
     * 
     * @param dbName
     * @param dbConf
     * @param mpClass
     * @param tpClass 
     * @param vmClass 
     * @param modelValidator 
     */
    protected BaseMLtopicmodeler(String dbName, DatabaseConfiguration dbConf, Class<MP> mpClass, Class<TP> tpClass, Class<VM> vmClass, ModelValidation<MP, TP, VM> modelValidator) {
        super(dbName, dbConf, mpClass, tpClass, vmClass, modelValidator);
    } 
    
}