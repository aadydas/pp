package com.management.pp.graphdb;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Graph;

public interface GraphDatabaseInterface {

    public Graph getGraph();

    public void closeFactory();

    public GraphTraversalSource getTraversal();

    public Graph getGraph(boolean transactional);
}
