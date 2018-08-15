package com.nickperov.stud.java_samples.fork_join;

import java.util.ArrayList;
import java.util.List;

public class ValueSumCounter2 extends ValueSumCounter {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 5278250199687140013L;

	public ValueSumCounter2(Node node) {
    	super(node);
    }
    
    @Override
    protected Long compute() {
        long sum = node.getValue();
        List<Node> children = node.getChildren();
        if (children != null && children.size() > 0) {
        	  List<ValueSumCounter2> subTasks = new ArrayList<>(children.size());
        	  for(int i = 1; i < children.size(); i++) {
        		  ValueSumCounter2 task = new ValueSumCounter2(children.get(i));
                  task.fork(); // запустим асинхронно
                  subTasks.add(task);
        	  }
        	  for (ValueSumCounter task : subTasks)
        		  sum += task.join();
        	  return new ValueSumCounter2(children.get(0)).compute() + sum;
        } else {
        	return sum;
        }
    }
}