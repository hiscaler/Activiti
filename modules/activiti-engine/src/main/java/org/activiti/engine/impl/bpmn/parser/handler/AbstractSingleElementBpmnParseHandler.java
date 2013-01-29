/* Licensed under the Apache License, Version 2.0 (the "License");
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
package org.activiti.engine.impl.bpmn.parser.handler;

import java.util.HashSet;
import java.util.Set;

import org.activiti.bpmn.model.BaseElement;
import org.activiti.bpmn.model.SubProcess;
import org.activiti.engine.impl.bpmn.parser.BpmnParse;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.pvm.process.ScopeImpl;
import org.activiti.engine.parse.BpmnParseHandler;


/**
 * @author Joram Barrez
 */
public abstract class AbstractSingleElementBpmnParseHandler<T extends BaseElement> implements BpmnParseHandler {
  
  public Set<Class< ? extends BaseElement>> getHandledTypes() {
    Set<Class< ? extends BaseElement>> types = new HashSet<Class<? extends BaseElement>>();
    types.add(getHandledType());
    return types;
  }
  
  protected Class<? extends BaseElement> getHandledType() {
    // Subclasses should override
    return null;
  }
  
  @SuppressWarnings("unchecked")
  public void parse(BpmnParse bpmnParse, BaseElement element, ScopeImpl scope, ActivityImpl activity, SubProcess subProcess) {
    T baseElement = (T) element;
    executeParse(bpmnParse, baseElement, scope, activity, subProcess);
  }
  
  protected abstract void executeParse(BpmnParse bpmnParse, T element, ScopeImpl scope, ActivityImpl activity, SubProcess subProcess);

}