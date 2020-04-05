package com.management.pp.graphdb;

import com.management.pp.conf.OrientDBConfig;
import org.apache.tinkerpop.gremlin.orientdb.OrientGraphFactory;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class GraphOrientDB implements GraphDatabaseInterface {

    @Autowired
    private OrientGraphFactory graphFactory;

    @Autowired
    private OrientDBConfig orientDBConfig;
    private boolean transactional = false;

    @PostConstruct
    public void init() {
        switch(orientDBConfig.getUrl().substring(0, 7)){
            case "memory:":
                this.graphFactory = new OrientGraphFactory(orientDBConfig.getUrl());
                break;
            default:
                this.graphFactory = new OrientGraphFactory(orientDBConfig.getUrl(), orientDBConfig.getUsername(),
                        orientDBConfig.getPassword());
        }
        this.transactional = orientDBConfig.isTransactional();
    }

    @Override
    public Graph getGraph(boolean transactional) {
        return transactional ? graphFactory.getTx() : graphFactory.getNoTx();
    }

    @Override
    public void closeFactory() {
        graphFactory.close();
    }

    @Override
    public Graph getGraph() {
        return getGraph(transactional);
    }

    @Override
    public GraphTraversalSource getTraversal() {
        return getGraph().traversal();
    }

    public void setOrientGraphFactory(OrientGraphFactory factory) {
        this.graphFactory = factory;
    }

    public void setTransactional(boolean transactional) {
        this.transactional = transactional;
    }
}
