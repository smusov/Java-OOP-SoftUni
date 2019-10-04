package StackOfStrings;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push (String element){
        this.data.add(element);
    }
    public String pop (){
        if (!isEmpty()){
            return this.data.remove(this.data.size()-1);
        }
        return null;
    }
    public String peek (){
        if (!isEmpty()){
            return this.data.get(this.data.size()-1);
        }
        return null;
    }

    public boolean isEmpty(){
        return this.data.isEmpty();
    }

}
