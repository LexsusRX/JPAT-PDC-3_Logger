import java.util.ArrayList;
import java.util.List;

public class Filter {
    String filterMessage;
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        int meaning = 0;
        String message;

        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        for (int i : source) {
            if (i < treshold) {
                message = String.format("Message %d not necessary", i);
                logger.log(message);
            } else {
                message = String.format("Message %d necessary", i);
                logger.log(message);
                result.add(i);
                meaning++;
            }
        }
        filterMessage = String.format("Filtered %d elements times of %d", meaning, source.size());
        logger.log(filterMessage);
        return result;
    }
}