package de.kp.spark.intent.model
/* Copyright (c) 2014 Dr. Krusche & Partner PartG
 * 
 * This file is part of the Spark-Intent project
 * (https://github.com/skrusche63/spark-intent).
 * 
 * Spark-Intent is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * Spark-Intent is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with
 * Spark-Intent. 
 * 
 * If not, see <http://www.gnu.org/licenses/>.
 */

import de.kp.spark.core.model._

object PredictorFactory {

  def getPredictor(topic:String):IntentPredictor = {
         
    topic match {
      /*
       * The 'observation' topic supports requests to uncover a set
       * of (hidden) states from a certain observation. Note, that
       * this topic is restricted to Hidden Markov Models
       * 
       * The 'state' topic supports requests to determine a sequence
       * of most probable Markovian state, that follow a certain state.
       * 
       * Note, that this topic is not applicable to Hidden Markov models
       */
      case "observation" | "state" => new MarkovPredictor(topic)
      
      case _ => throw new Exception("Unknown topic.")
    
    }
    
  }  
  
}