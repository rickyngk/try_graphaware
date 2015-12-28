import com.graphaware.reco.generic.context.Context;
import com.graphaware.reco.generic.post.BasePostProcessor;
import com.graphaware.reco.generic.result.Recommendation;
import com.graphaware.reco.generic.result.Recommendations;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import static org.neo4j.helpers.collection.Iterables.toArray;

import java.util.Arrays;

/**
 * Created by duynk on 12/28/15.
 */
public class RewardSameLabels extends BasePostProcessor<Node, Node> {

    @Override
    protected String name() {
        return "sameGender";
    }

    @Override
    protected void doPostProcess(Recommendations<Node> recommendations, Node input, Context<Node, Node> context) {
        Label[] inputLabels = toArray(Label.class, input.getLabels());

        for (Recommendation<Node> recommendation : recommendations.get()) {
            if (Arrays.equals(inputLabels, toArray(Label.class, recommendation.getItem().getLabels()))) {
                recommendation.add(name(), 10);
            }
        }
    }
}