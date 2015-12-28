import com.graphaware.reco.generic.context.Context;
import com.graphaware.reco.generic.engine.RecommendationEngine;
import com.graphaware.reco.generic.filter.BlacklistBuilder;
import com.graphaware.reco.generic.filter.Filter;
import com.graphaware.reco.generic.policy.ParticipationPolicy;
import com.graphaware.reco.generic.post.PostProcessor;
import com.graphaware.reco.neo4j.engine.Neo4jTopLevelDelegatingRecommendationEngine;
import com.graphaware.reco.neo4j.filter.ExcludeSelf;
import com.graphaware.reco.neo4j.filter.ExistingRelationshipBlacklistBuilder;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;

import java.util.Arrays;
import java.util.List;

/**
 * Created by duynk on 12/28/15.
 */
public class FriendsComputingEngine extends Neo4jTopLevelDelegatingRecommendationEngine {

    @Override
    protected List<RecommendationEngine<Node, Node>> engines() {
        return Arrays.<RecommendationEngine<Node, Node>>asList(
                new FriendsInCommon(),
                new RandomPeople()
        );
    }

    @Override
    protected List<PostProcessor<Node, Node>> postProcessors() {
        return Arrays.<PostProcessor<Node, Node>>asList(
                new RewardSameLabels(),
                new RewardSameLocation(),
                new PenalizeAgeDifference()
        );
    }

    @Override
    protected List<BlacklistBuilder<Node, Node>> blacklistBuilders() {
        return Arrays.<BlacklistBuilder<Node, Node>>asList(
                new ExistingRelationshipBlacklistBuilder(RelationShips.FRIENDS_OF, Direction.BOTH)
        );
    }

    @Override
    protected List<Filter<Node, Node>> filters() {
        return Arrays.<Filter<Node, Node>>asList(
                new ExcludeSelf()
        );
    }

    @Override
    public ParticipationPolicy<Node, Node> participationPolicy(Context<Node, Node> context) {
        return ParticipationPolicy.IF_MORE_RESULTS_NEEDED;
    }
}