package com.graphaware.reco.integration;

import com.graphaware.reco.generic.transform.ParetoScoreTransformer;
import com.graphaware.reco.generic.transform.ScoreTransformer;
import com.graphaware.reco.neo4j.engine.SomethingInCommon;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.RelationshipType;

/**
 * Created by duynk on 12/27/15.
 */
public class FriendsInCommon extends SomethingInCommon {

    public String name() {
        return "friendsInCommon";
    }

    @Override
    protected Direction getDirection() {
        return Direction.BOTH;
    }

    @Override
    protected RelationshipType getType() {
        return RelationShips.FRIEND_OF;
    }

    @Override
    protected ScoreTransformer scoreTransformer() {
        return new ParetoScoreTransformer(100, 10);
    }
}

