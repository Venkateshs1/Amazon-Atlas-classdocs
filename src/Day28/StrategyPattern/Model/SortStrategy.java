package Day28.StrategyPattern.Model;
import Day28.StrategyPattern.Controller.SortingStrategy;

import java.util.*;

public class SortStrategy {
    private List<String> items;
    private SortingStrategy strategy;

    public SortStrategy(){
        this.items = new ArrayList<>();
    }

    public void setStrategy(SortingStrategy strategy){
        this.strategy = strategy;
    }

    public void addItem(String item){
        items.add(item);
    }

    public void removeItem(String item){
        items.remove(item);
    }

    public void performSort(){
        if(strategy==null){
            System.out.println("NO strategy found");
            return;
        }
        strategy.sort(items);
    }

    public List<String> getList(){
        return items;
    }
}
