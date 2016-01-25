package com.r;

import com.graphaware.reco.generic.transform.ParetoScoreTransformer;
import com.graphaware.reco.generic.transform.ScoreTransformer;
import com.graphaware.reco.neo4j.engine.SomethingInCommon;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;

import java.util.Collections;
import java.util.Map;

/**
 * Created by duynk on 12/27/15.
 */
public class FriendsInCommon extends SomethingInCommon {
    private ScoreTransformer scoreTransformer = ParetoScoreTransformer.create(100, 10);

    public String name() {
        return "friendsInCommon";
    }

    @Override
    protected ScoreTransformer scoreTransformer() {
        return scoreTransformer;
    }

    @Override
    protected RelationshipType getType() {
        return RelationShips.FRIEND_OF;
    }

    @Override
    protected Direction getDirection() {
        return Direction.BOTH;
    }

    @Override
    protected Map<String, Object> details(Node thingInCommon, Relationship withInput, Relationship withOutput) {
        return Collections.singletonMap("name", thingInCommon.getProperty("name"));
    }
}

