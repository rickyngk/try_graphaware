package com.graphaware.reco.integration;

import com.graphaware.reco.generic.result.PartialScore;
import com.graphaware.reco.neo4j.post.RewardSomethingShared;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;

import java.util.Collections;

/**
 * Created by duynk on 12/27/15.
 */
public class RewardSameLocation extends RewardSomethingShared {

    @Override
    protected String name() {
        return "sameLocation";
    }

    @Override
    protected RelationshipType type() {
        return RelationShips.LIVES_IN;
    }

    @Override
    protected Direction direction() {
        return Direction.OUTGOING;
    }

    @Override
    protected PartialScore partialScore(Node rec, Node input, Node sharedThing) {
        return new PartialScore(10, Collections.singletonMap("location", sharedThing.getProperty("name")));
    }

}
