package connection;

import sample.FXMLTransition;

public enum TransitionInstance {
    INSTANCE;

    private FXMLTransition instance;

    TransitionInstance(){
        instance = new FXMLTransition();
    }

    public FXMLTransition getInstance(){
        return instance;
    }
}
