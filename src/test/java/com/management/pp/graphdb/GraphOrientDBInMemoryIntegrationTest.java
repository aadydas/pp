//package com.management.pp.graphdb;
//
//import org.apache.commons.lang.RandomStringUtils;
//import org.apache.tinkerpop.gremlin.orientdb.OrientGraphFactory;
//import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
//import org.apache.tinkerpop.gremlin.structure.Vertex;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Tag;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@SpringBootTest
//@ActiveProfiles("test-in-memory-orientdb")
//public class GraphOrientDBInMemoryIntegrationTest {
//
//    @Autowired
//    GraphOrientDB db;
//
//    @BeforeEach
//    private void deleteGraph(){
//        GraphTraversalSource g = db.getTraversal();
//        g.V().drop().iterate();
//    }
//
//    @AfterEach
//    private void deleteGraphAfterAll(){
//        GraphTraversalSource g = db.getTraversal();
//        g.V().drop().iterate();
//    }
//
//    @Test
//    @Tag("integration")
//    public void factoryShouldOpenAndCloseSuccessfullyForInMemoryDB() {
//        OrientGraphFactory graphFactory = new OrientGraphFactory("memory:orientdb-in-memory-test-db");
//        GraphOrientDB db = new GraphOrientDB();
//        db.setOrientGraphFactory(graphFactory);
//        db.setTransactional(true);
//        assertTrue(graphFactory.isOpen(), "Graph factory should be open");
//        GraphTraversalSource g = db.getTraversal();
//        g.addV("test").property("prop1", "value1").next();
//        g.tx().commit();
//        db.closeFactory();
//        assertTrue(!graphFactory.isOpen(), "Graph factory should be closed");
//    }
//
//    @Test
//    @Tag("integration")
//    public void shouldWriteAndReadSameRecord() {
//        db.setTransactional(true);
//        GraphOrientDB db = new GraphOrientDB();
//        String generatedString = RandomStringUtils.randomAlphabetic(10);
//        Vertex vWrite = g.addV("test").property("prop1", generatedString).next();
//        Object id = vWrite.id();
//        g.tx().commit();
//
//        g = graphDatabaseService.getTraversal();
//        Vertex vRead = g.V(id).next();
//        assertEquals(generatedString, vRead.property("prop1").value(), "the value of the node should match the written value");
//        vRead.remove();
//        g.tx().commit();
//    }
//
//
//
//}
