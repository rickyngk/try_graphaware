package com.graphaware.reco.integration;

import org.neo4j.graphdb.RelationshipType;

/**
 * Created by duynk on 12/27/15.
 */
public enum RelationShips implements RelationshipType {
    FRIEND_OF,
    LIVES_IN
};