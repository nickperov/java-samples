package com.nickperov.stud.java_samples.fork_join;

import java.util.concurrent.RecursiveTask;

public abstract class ValueSumCounter extends RecursiveTask<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2380233923567029946L;
	protected final Node node;
    
    public ValueSumCounter(Node node) {
        this.node = node;
    }

}
