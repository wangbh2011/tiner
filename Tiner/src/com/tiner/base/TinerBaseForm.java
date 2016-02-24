package com.tiner.base;

import java.io.Serializable;

import org.springframework.webflow.engine.model.Model;

public class TinerBaseForm implements Serializable,Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5913931444970094985L;

	@Override
	public boolean isMergeableWith(Model model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void merge(Model model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Model createCopy() {
		// TODO Auto-generated method stub
		return null;
	}

}
