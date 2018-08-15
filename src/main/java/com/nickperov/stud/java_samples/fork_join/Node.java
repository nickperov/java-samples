package com.nickperov.stud.java_samples.fork_join;

import java.util.Collection;
import java.util.List;

public interface Node {
    List<Node> getChildren();
    void setChildren(List<Node> children);
    
    long getValue();
    void setValue(long value);
    void setLevel(long level);
    long getLevel();
}