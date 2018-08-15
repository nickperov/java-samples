package com.nickperov.stud.java_samples.fork_join;

import java.util.ArrayList;
import java.util.List;

public class ValueSumCounter1 extends ValueSumCounter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2867888926578497135L;
	public ValueSumCounter1(Node node) {
		super(node);
	}

	@Override
    protected Long compute() {
        long sum = node.getValue();
        List<ValueSumCounter> subTasks = new ArrayList<>();
        
        for (Node child : node.getChildren()) {
            ValueSumCounter task = new ValueSumCounter1(child);
            task.fork(); // запустим асинхронно
            subTasks.add(task);
        }
        
        for (ValueSumCounter task : subTasks)
            sum += task.join(); // дождёмся выполнения задачи и прибавим результат
        
        return sum;
    }
}