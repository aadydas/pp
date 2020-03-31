package com.management.pp.orm;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TinkerPopProvider {

    private GraphTraversalSource g;

    @Autowired
    public TinkerPopProvider(GraphTraversalSource g) {
        this.g = g;
    }

    public GraphTraversalSource getG() {
        return g;
    }
}
