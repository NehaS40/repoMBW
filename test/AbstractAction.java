/**
 * <p>Title: AbstractAction</p>
 * <p>Description: </p> 
 * Abstract Super Class of all actions called after a business rule 
 * has been processed. 2 main sub classes are ProcessApprovalAction & ProcessRejectionAction 
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: BCSG inc</p>
 * @author Timi Boboye
 * @version $Revision 0.1$
 */
package com.bcsg.api.businessrules.actions;

import com.bcsg.api.businessrules.engine.AbstractComponent;

public abstract class AbstractAction extends AbstractComponent {

	private AbstractComponent nextStep;

	@Override
	public void execute(Object arg) throws Exception {
	      this.doExecute(arg);
	      if(nextStep != null){
	         nextStep.execute(arg);
	      }
	}   
	   
	protected abstract void doExecute(Object arg) throws Exception;
	
	
	
	public void setNextStep(AbstractComponent nextStep) {
	      this.nextStep = nextStep;
	}
	   
	public AbstractComponent getNextStep() {
	      return nextStep;
	}
}

