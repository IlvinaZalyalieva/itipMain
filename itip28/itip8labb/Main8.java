import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
public class Main8 {
    public static void main(String[] args)
    {
        DataManager dataManager = new DataManager();

        dataManager.registerDataProcessor(new DataFilter());
        dataManager.registerDataProcessor(new DataTransformer());
        dataManager.registerDataProcessor(new DataAggregator());

        List<String> input = dataManager.loadData("/Users/ilvina/IdeaProjects/untitled/src/input.txt");
        List<String> pr = dataManager.processData(input);
        dataManager.saveData(pr, "/Users/ilvina/IdeaProjects/untitled/src/data.txt");
    }
}

@interface DataProcessor {}

@DataProcessor
class DataFilter
{ public List<String> filterData(List<String> data)
    {return data.stream().filter(i -> i.length() > 4).collect(Collectors.toList());}
}
@DataProcessor
class DataTransformer {
    public String transformData(List<String> data) {
        StringBuilder result = new StringBuilder();
        for (String str : data) {
            result.append(str.toUpperCase()).append('\n');
        }
        return result.toString();
    }}

@DataProcessor
class DataAggregator
{
    public String aggregateData(List<String> data) {
        StringBuilder result = new StringBuilder();
        for (String str : data) {
            result.append(str + "№");
        }
        return result.toString();
    }}

class DataManager
{
    private final List<Object> dataProcessors = List.of(new DataFilter(), new DataTransformer(), new DataAggregator());

    public void registerDataProcessor(Object processor)
    {
        if (processor.getClass().isAnnotationPresent(DataProcessor.class))
        {dataProcessors.add(processor);}
    }

    public List<String> loadData(String input)
    {
        Path read = Path.of(input);
        try
        {
            return Files.readAllLines(read);
        }
        catch (Exception e)
        {
            throw new RuntimeException("error", e);
        }
    }

    // многопоточность
    public List<String> processData(List<String> data)
    {
        ExecutorService poolFlow = Executors.newFixedThreadPool(dataProcessors.size());
        try
        {
            return dataProcessors.parallelStream().map(processor -> poolFlow.submit(() -> processWithAnnotation(processor, data))).map(future -> {
                        try
                        {
                            return future.get();
                        }
                        catch (Exception e)
                        {
                            throw new RuntimeException(e);
                        }
                    }).flatMap(List::stream).collect(Collectors.toList());
        }
        finally
        {
            poolFlow.shutdown();
        }
    }

    private List<String> processWithAnnotation(Object processor, List<String> data)
    {
        if (processor instanceof DataFilter) return ((DataFilter) processor).filterData(data);
        else if (processor instanceof DataTransformer) return List.of(((DataTransformer) processor).transformData(data));
        else if (processor instanceof DataAggregator) return List.of(((DataAggregator) processor).aggregateData(data));
        return data;
    }

    public void saveData(List<String> processedData, String destination)
    {
        Path write = Path.of(destination);
        try
        {
            Files.write(write, processedData, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
            System.out.println("kaif");
        } catch (Exception e) {
            throw new RuntimeException("not save", e);
        }
    }
}
