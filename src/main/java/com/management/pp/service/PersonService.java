package com.management.pp.service;

import com.management.pp.graphdb.GraphOrientDB;
import com.management.pp.model.Person;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.T;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    GraphOrientDB db;

    public Vertex findByName(String name) {
        return db.getTraversal().V().has("name", name).next();
    }

    public void postPerson(){
        Graph graph = db.getGraph();
        final Vertex marko = graph.addVertex( T.label, "person", "name", "marko", "age", 29);
//        final Vertex vadas = graph.addVertex(T.id, 2, T.label, "person", "name", "vadas", "age", 27);
//        final Vertex lop = graph.addVertex(T.id, 3, T.label, "software", "name", "lop", "lang", "java");
//        final Vertex josh = graph.addVertex(T.id, 4, T.label, "person", "name", "josh", "age", 32);
//        final Vertex ripple = graph.addVertex(T.id, 5, T.label, "software", "name", "ripple", "lang", "java");
//        final Vertex peter = graph.addVertex(T.id, 6, T.label, "person", "name", "peter", "age", 35);
//
//        marko.addEdge("knows", josh, T.id, 8, "weight", 1.0d);
//        marko.addEdge("created", lop, T.id, 9, "weight", 0.4d);
//        josh.addEdge("created", ripple, T.id, 10, "weight", 1.0d);
//        josh.addEdge("created", lop, T.id, 11, "weight", 0.4d);
//        peter.addEdge("created", lop, T.id, 12, "weight", 0.2d);
    }

    public void addPerson(Person person){
        Graph graph = db.getGraph();
        graph.addVertex(T.label, "person",
                "name", person.getName(),
                "age", person.getAge());
    }

    public void addEdge(String userId1, String userId2){
        Graph graph = db.getGraph();
//        graph.traversal().getGraph();
//        marko.addEdge("knows", vadas, T.id, 7, "weight", 0.5d);
    }
}
