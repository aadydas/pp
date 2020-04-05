//package com.management.pp.graphdb;
//
//import org.apache.tinkerpop.gremlin.orientdb.OrientGraph;
//import org.apache.tinkerpop.gremlin.orientdb.OrientGraphFactory;
//import org.apache.tinkerpop.gremlin.orientdb.OrientTransaction;
//import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class GraphOrientDBTest {
//
//    @Test
//    public void factoryShouldOpenAndCloseSuccessfully() {
//        GraphOrientDB db = new GraphOrientDB();
//        OrientGraphFactory graphFactory = new OrientGraphFactory();
//        db.setOrientGraphFactory(graphFactory);
//        db.setTransactional(false);
//        assertTrue(graphFactory.isOpen(), "Graph factory should be open");
//        db.closeFactory();
//        assertTrue(graphFactory.isOpen(), "Graph factory should be closed");
//    }
//
//    @Test
//    public void getTxGraphShouldReturnTxGraph() {
//        GraphOrientDB db = new GraphOrientDB();
//        db.setOrientGraphFactory(new OrientGraphFactory());
//        db.setTransactional(false);
//        OrientGraph graph = (OrientGraph) db.getGraph(true);
//        OrientTransaction tx = graph.tx();
//        assertEquals("org.apache.tinkerpop.gremlin.orientdb.OrientTransaction", tx.getClass().getName(),
//                "tx class should be 'org.apache.tinkerpop.gremlin.orientdb.OrientTransaction'");
//        graph.close();
//        db.closeFactory();
//    }
//
//    @Test
//    public void getNoTxGraphShouldReturnNoTxGraph() {
//        GraphOrientDB db = new GraphOrientDB();
//        db.setOrientGraphFactory(new OrientGraphFactory());
//        db.setTransactional(false);
//        OrientGraph graph = (OrientGraph) db.getGraph(false);
//        OrientTransaction tx = graph.tx();
//        assertEquals("org.apache.tinkerpop.gremlin.orientdb.OrientNoTransaction", tx.getClass().getName(),
//                "tx class should be 'org.apache.tinkerpop.gremlin.orientdb.OrientNoTransaction'");
//        graph.close();
//        db.closeFactory();
//    }
//
//    @Test
//    public void getGraphShouldReturnTxGraph() {
//        GraphOrientDB db = new GraphOrientDB();
//        db.setOrientGraphFactory(new OrientGraphFactory());
//        db.setTransactional(true);
//        OrientGraph graph = (OrientGraph) db.getGraph();
//        OrientTransaction tx = graph.tx();
//        assertEquals("org.apache.tinkerpop.gremlin.orientdb.OrientTransaction", tx.getClass().getName(),
//                "tx class should be 'org.apache.tinkerpop.gremlin.orientdb.OrientTransaction'");
//        graph.close();
//        db.closeFactory();
//    }
//
//    @Test
//    public void getTraversalShouldReturnTraversal() throws Exception {
//        GraphOrientDB db = new GraphOrientDB();
//        db.setOrientGraphFactory(new OrientGraphFactory());
//        db.setTransactional(false);
//        GraphTraversalSource g = db.getTraversal();
//        assertNotNull(g, "g GraphTraversalSource should not be null");
//        db.closeFactory();
//    }
//}
