package noize.dev.spring_core_guide.practice.scope;

public class PrototypeCounterBean implements CounterBean{
    private int count = 0;

    public PrototypeCounterBean() {
        this.count = 0;
    }

    @Override
    public void increment(){
        count++;
    }

    @Override
    public int value() {
        return count;
    }
}
